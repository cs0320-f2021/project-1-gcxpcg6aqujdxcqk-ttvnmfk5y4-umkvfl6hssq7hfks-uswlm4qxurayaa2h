package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import edu.brown.cs.student.main.api.ApiHandler;
import edu.brown.cs.student.main.kdtree.ClassifyHandler;
import edu.brown.cs.student.main.kdtree.KdTree;
import edu.brown.cs.student.main.kdtree.SimilarHandler;
import edu.brown.cs.student.main.onboarding.AddHandler;
import edu.brown.cs.student.main.onboarding.NaiveNeighborsHandler;
import edu.brown.cs.student.main.onboarding.StarsHandler;
import edu.brown.cs.student.main.onboarding.SubtractHandler;
import freemarker.template.Configuration;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import spark.ExceptionHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * The Main class of our project. This is where execution begins.
 */
public final class Main {

  // use port 4567 by default when running server
  private static final int DEFAULT_PORT = 4567;

  /**
   * The initial method called when execution begins.
   *
   * @param args An array of command line arguments
   */
  public static void main(String[] args) {
    new Main(args).run();
  }

  private String[] args;

  private Main(String[] args) {
    this.args = args;
  }

  private void run() {
    // set up parsing of command line flags
    OptionParser parser = new OptionParser();

    // "./run --gui" will start a web server
    parser.accepts("gui");

    // use "--port <n>" to specify what port on which the server runs
    parser.accepts("port").withRequiredArg().ofType(Integer.class)
        .defaultsTo(DEFAULT_PORT);

    OptionSet options = parser.parse(args);
    if (options.has("gui")) {
      runSparkServer((int) options.valueOf("port"));
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String input;

      HashMap<String, ArgumentHandler> argHashMap = new HashMap<>();
      argHashMap.put("add", new AddHandler());
      argHashMap.put("subtract", new SubtractHandler());
      argHashMap.put("stars", new StarsHandler());
      argHashMap.put("naive_neighbors", new NaiveNeighborsHandler());

      argHashMap.put("users", new UsersHandler());
      argHashMap.put("similar", new SimilarHandler());
      argHashMap.put("classify", new ClassifyHandler());
      argHashMap.put("dataGet", new ApiHandler()); //added repl commands for api
      argHashMap.put("openJson", new ApiHandler()); //added repl commands for json reader
      argHashMap.put("recsys_load", new RecsysLoadHandler()); //added repl commands for json reader

      ProjectDataContainer.setDataStructure(new KdTree(3));

      while ((input = br.readLine()) != null) {
        input = input.trim();
        String[] arguments = input.split(" ");

        ArgumentHandler handler = argHashMap.get(arguments[0]);

        //TODO before, Ben's code checked: `if the reader hasn't already been created and the command isn't stars, throw an error`
        if (handler == null) {
          ProjectErrorHandler.wrongArgError();
          continue;
        }

        // Ask the handler whether there's the right no of arguments
        if (!handler.checkNumArgs(arguments)) {
          ProjectErrorHandler.invalidInputError(handler.getUsageString());
        } else {
          try {
            handler.handleArg(arguments);
          } catch (Exception e) {
            continue;
          }

        }

      }
    } catch (Exception e) {
      e.printStackTrace();
      ProjectErrorHandler.brokenReplError(); //e.printStackTrace();
    }
  }

  private static FreeMarkerEngine createEngine() {
    Configuration config = new Configuration(Configuration.VERSION_2_3_0);

    // this is the directory where FreeMarker templates are placed
    File templates = new File("src/main/resources/spark/template/freemarker");
    try {
      config.setDirectoryForTemplateLoading(templates);
    } catch (IOException ioe) {
      System.out.printf("ERROR: Unable use %s for template loading.%n",
          templates);
      System.exit(1);
    }
    return new FreeMarkerEngine(config);
  }

  private void runSparkServer(int port) {
    // set port to run the server on
    Spark.port(port);

    // specify location of static resources (HTML, CSS, JS, images, etc.)
    Spark.externalStaticFileLocation("src/main/resources/static");

    // when there's a server error, use ExceptionPrinter to display error on GUI
    Spark.exception(Exception.class, new ExceptionPrinter());

    // initialize FreeMarker template engine (converts .ftl templates to HTML)
    FreeMarkerEngine freeMarker = createEngine();

    // setup Spark Routes
    Spark.get("/", new MainHandler(), freeMarker);
  }

  /**
   * Display an error page when an exception occurs in the server.
   */
  private static class ExceptionPrinter implements ExceptionHandler<Exception> {
    @Override
    public void handle(Exception e, Request req, Response res) {
      // status 500 generally means there was an internal server error
      res.status(500);

      // write stack trace to GUI
      StringWriter stacktrace = new StringWriter();
      try (PrintWriter pw = new PrintWriter(stacktrace)) {
        pw.println("<pre>");
        e.printStackTrace(pw);
        pw.println("</pre>");
      }
      res.body(stacktrace.toString());
    }
  }

  /**
   * A handler to serve the site's main page.
   *
   * @return ModelAndView to render.
   * (main.ftl).
   */
  private static class MainHandler implements TemplateViewRoute {
    @Override
    public ModelAndView handle(Request req, Response res) {
      // this is a map of variables that are used in the FreeMarker template
      Map<String, Object> variables = ImmutableMap.of("title",
          "Go go GUI");

      return new ModelAndView(variables, "main.ftl");
    }
  }
}
