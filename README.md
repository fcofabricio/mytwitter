MyTwitter Project
=================

[Rails tutorial](http://www.railstutorial.org/book) sample app developed using java technologies (spring, jpa, etc.)

Prerequisites
-------------

[Git](http://git-scm.com/), [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (I'm planning to change to openjdk early), [Maven](http://maven.apache.org/) and [PhantomJS](http://phantomjs.org/).

Maven
------------------

To create Eclipse WTP project, run:

`mvn eclipse:eclipse`

To run the application on jetty, run:

`mvn jetty:run-war`

To test execution, run:

`mvn verify`
