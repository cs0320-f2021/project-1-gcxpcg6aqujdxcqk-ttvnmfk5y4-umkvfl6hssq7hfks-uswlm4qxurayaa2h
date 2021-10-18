PROJECT: Project 1 Sprint

DESCRIPTION: API and KD-Tree

TEAM MEMBERS: Kat, Ben, Sheridan, Livia

Clothing, Review, and Users classes are the java objects in which the Json file is stored. 
They all implement the JSONObject interface so that Java registers that they are of the same type

Received some help from Helen Huang -- helped update JsonHandler.
JsonHandler class reads the json files and convert them into the specific java object (so the rental clothing json file will be stored as a Clothing[] object, etc.)

REPL COMMANDS:
add <number> <number>: adds two numbers together
subtract <number> <number>: substracts one number from the other
stars <file>: FILL IN
naive_neighbors <int> <x> <y> <z>: FILL IN
naive_neighbors <int> <name>: FILL IN
dataGet <users, reviews, rent>: FILL IN
openJson <file> <users, reviews, clothing>: FILL IN


**From this angle, how might your matchmaker’s results end up treating
 minorities differently than their more privileged counterparts? What larger-reaching
 impacts might this have (e.g. are biases reiterated? Do members of minority
 groups receive as well-suited matches as their peers might? etc.).**

As the study mentioned, marginalized communities are less likely to
advocate for themselves or accurately realize/determine their own skill level.
Therefore, biases that assume these communities are underperformers or less
talented relative to their non-marginalized peers could very easily be reinforced
by marginalized students' underestimating their own abilities. I'm not entirely
sure how people's rating of themselves is going to be factored into creating groups.
However, if a student of a marginalized community who has rated their abilities
a low value gets paired with a non-marginalized student who rated their abilities
with a high value, the non-marginalized student might already have assumptions
that they are the "better" coder and that the other student is "less than." This
type of relationship will then automatically reinforce the marginalized student's
perception or fear that they aren't as good at coding as their counterpart.



**What did we not implement?**

For the sprint portion, we did not implement the command `classify`. However, we have some comments indicating that this would simply be a matter of running `similar` and then
using a HashMap to determine astrological data for each User in the `similar` output. Then, it would be a matter of looping through and tallying up counts of
each astrological sign (likely in a hasmap mapping astrological signs to counts) in order to print the desired result.

We decided to prioritize our functionality and ultimately ended up not implementing 
user stories 3 and 4. In the comments of our StudentRecommender class, we have an outline
for the recommender methods that would be used in user stories 3 and 4. 

**Here is the outline for how we would have approached user story 3 (also see the comments for StudentRecommender.recommendId()):**
1. First, filter by students' meeting preferences (in person or online) and whether their meeting times match. We do this by loading the data into a bloom filter and generating recommendations based purely on these categorial meeting availability metrics.
2. From these bloom filter recommendations, build a new kdtree using those students' skills fields. 
3. To generate a list of recommended students for this student, generated the inverse/flipped versions of each of this student's scores by subtracting this student's scores from 10 and then running the kdtree algorithm using these values. This ensures that we find the students closest to the opposite of this student's skillset.

*This approach assumes that skills scores are out of 10 as per the google form specifications, but we actually do not have a method to enforce this invariant.*

The reason that we decided not to use the tables with interests as well as positive and negative traits was because we found these traits either irrelevant or difficult to apply. We assumed that student's shared interests were not a significant enough signal in terms of
being able to determime whether they would be able to work well together, as from our own personal experiences, just because two people share similar interests does not necessarily make them compatible as academic partners. In terms of students' positive and negative traits, we 
also thought this was too difficult to define concretely. If a student is a procrastinator, does it necessarily make more sense to put them with somebody who finishes things early? Possibly not, because that would put undue stress on the early starter. But on the other hand,
putting two procrastinators together could very easily cause problems in terms of nobody starting work on the project until the last minute.




**Here is the outline for how we would have approached user story 4 (also see the comments for StudentRecommender.recommendTeams()):**

num_gropus = (total number of people)/ (group size)
the remainder (extra people) = total people mod group size (between 1 and 1-n)
1. randomly pick 1 person to be the group started and generate their nearest neighbors using recommendId() 
2. randomly choose x from center's nn and remove x from global list (if neighbors list empty, select from all people instead)
3. add x to this group and generate its nn
4. Repeat steps 2-3 until the size of this group == inputted group size
5. Repeat steps 1-4 for all of the num_groups
6. Then, account for leftover people using the following algorithm:
```
   (if num_people > 0){
    for each extra-person {
      randomly choose a group
      make sure that group size is equal to inputted group size (if not repick)
      add extra person to this group, so that there is one extra person
     }
    }
  ```