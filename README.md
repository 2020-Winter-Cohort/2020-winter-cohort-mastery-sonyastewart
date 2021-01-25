# SurvivingCodingBootcamp.com - A Blog

Welcome to the staff of SurvivingCodingBootcamp, a blog for former students to write about how they survived their 
coding bootcamp experience.  We have a simple blog started already, but we brought you on to make some changes.

We need you to help us add some new features and functionality to this website.

## The Required Tasks:
1. Add a hashtag system to our posts.  The hashtag should be connected to the posts in a way that a post can have 
different hashtags and a hashtag can be associated with different posts.
  - Create a `Hashtag` POJO and provide the correct JPA entity mapping for it and the `POSTS`
  - Create a `single-hashtag-template.html` file that matches the uses the same style.css file as the other templates 
    and has a similar style to the other pages.  This page should display the posts associated with it's specfic hashtag
    and provide links to those posts.
  - Create a `all-hashtags-template.html` file that that matches the uses the same style.css file as the other templates 
    and has a similar style to the other pages.  This page should display all hashtags in the application and provide 
    links to those individual hashtags.
  - Add an HTML form to the `single-post-template.html` that allows you to add a hashtag to the post you are viewing.
  - Create a `HashtagStorage` service class to interact with your JPA repository for hashtags.  It should be able to 
    retrieve a hashtag by the value of its id field and by the value of its name/title field, retrieve all hashtags, and
    save new and existing hashtags.  
  - Create a `HashTagController` to provide three path mappings, one for individual hashtags, one for all hashtags, and 
 one for adding a hashtag to the system. 
  - Add a link to the all hashtags endpoint to the header's nav list on all pages.
2. Add a field to the `Post` POJO for the post's author.  This can be a `String`.  Then change the `single-post-template` 
and the `Post` constructor to add an author name.  Go to the populator and add an author name to the posts.
3. Add a form to the `single-category-template` to create a new post for that category.  You should include inputs for
passing information to the controller about each of the fields you need to fill the `Post` POJO's constructor 
parameters. You will also need to add a method to the `PostController` to allow for the creation of new posts.

## Deadline and Grading Criteria
The deadline for this project is Monday, October 26th, at 9:30am.
If the project is not complete or not pushed up to GitHub at that time it will be evaluated as an _Incomplete_ project.

This is a Pass/Fail assignment, the assignment will be considered passing if it meets the following criteria:
- Uses Git and GitHub to push complete assignment to GitHub before due date.
- The code compiles.  (No red squiggly underlines!)
- The provided integration tests still pass.
- All existing request endpoints are still reachable through the browser.
- All three of the required tasks are complete.

If your project doesn't meet these criteria at the deadline, it will be marked as _Needs Improvement_.

If your project is evaluated as _Incomplete_ or _Needs Improvement_ we will let you know and give you feed back on what 
needs to change to help move it to a passing project.
You will receive a new deadline of Friday, October 30th, at 9:30 to re-submit your project by pushing changes to GitHub.  
We will evaluate your project with the same criteria as the first submission and this evaluation will be the final grade
for this assessment.

## Optional Tasks:
Try these only when the above are finished and only commit them to the repo if they work and don't break the 
application.  All of the above grading criteria still need to be met while you add these _**OPTIONAL**_ features. 
1.  Create a new form for new topics on the home page.
2.  Play with the CSS layout.  
3.  Add a form to the `single-post-template` that allows you to add comments to a post.  
4.  Add a date/time field to the `Post` POJO and post template so that you can see when a post is created.

