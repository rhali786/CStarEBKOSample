Welcome to the AWS CodeStar sample web service
============================================== 

This sample code helps get you started with a simple Express web service
deployed by AWS Elastic Beanstalk.

What's Here
-----------

This sample includes:

* README.md - this file
* .ebextensions/ - this directory contains the configuration files that
  AWS Elastic Beanstalk will deploy your Express service
* package.json - this file contains various metadata relevant to your Node.js
  application such as dependencies
* server.js - this file contains the code for your service


Getting Started
---------------

These directions assume you want to develop on your local computer, and not
from the Amazon EC2 instance itself. If you're on the Amazon EC2 instance, the
virtual environment is already set up for you, and you can start working on the
code.

To work on the sample code, you'll need to clone your project's repository to your
local computer. If you haven't, do that first. You can find instructions in the
AWS CodeStar user guide.

1. Install Node.js on your computer.  For details on available installers visit
   https://nodejs.org/en/download/.

2. Install NPM dependencies:

        $ npm install

3. Start the development server:

        $ node server.js

4. Open http://127.0.0.1:3000/ in a web browser to view your service.

What Do I Do Next?
------------------

Once you have a virtual environment running, you can start making changes to
the sample Express web service. We suggest making a small change to
server.js first, so you can see how changes pushed to your project's repository
are automatically picked up and deployed to the Amazon EC2 instance by AWS Elastic
Beanstalk. (You can watch the progress on your project dashboard.) Once you've seen
how that works, start developing your own code, and have fun!

Learn more about AWS CodeStar by reading the user guide.  Ask questions or make
suggestions on our forum.

User Guide: http://docs.aws.amazon.com/codestar/latest/userguide/welcome.html

Forum: https://forums.aws.amazon.com/forum.jspa?forumID=248


URL: http://cstarebkosampleapp.fe8mvqdfgp.us-east-2.elasticbeanstalk.com/
