# Elasticsearch-with-Grails

A demo project in order to impart knowledge to the students on how to use Java API for Elasticsearch in grails project.
The project is basically an API that can respond to JSON requests and return JSON response.

For demonstration: Example request=>

POST Request URI: http://localhost:8080/request, where request is the name of our controller and 8080 is the port in which our project is running.
Request Body: {"service":"accounts","task":"getAccountSummary"}

# Prerequisites
1. JDK (at least JDK 8)
2. Elasticsearch (Refer Setting Up Guide.docx available in the repository)
3. Bulk index accounts.json file to your Elasticsearch using curl.

# Grails Version Used: 
3.3.9

# JAVA API for Elasticsearch: 
Via Maven Repo-> "org.elasticsearch:elasticsearch:6.7.1"
