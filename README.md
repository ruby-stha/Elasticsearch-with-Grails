# Elasticsearch-with-Grails

A demo framework created in order to impart knowledge to the students on how to use Java API for Elasticsearch in grails project, which is basically an API that can respond to JSON requests and return JSON response.

For demonstration: Example request=>

POST Request URI: http://localhost:8080/request, where request is the name of our controller and 8080 is the port in which our project is running.

Sample Request Body:

```json
{
  "service": "accounts",
  "task": "getAccountById",
  "accountId": "25"
}
```

Sample JSON Response for the Request Above

```json
{
    "accountInfo": {
        "account_number": 25,
        "firstname": "Virginia",
        "address": "171 Putnam Avenue",
        "balance": 40540,
        "gender": "F",
        "city": "Nicholson",
        "employer": "Filodyne",
        "state": "PA",
        "age": 39,
        "email": "virginiaayala@filodyne.com",
        "lastname": "Ayala"
    }
}
```

# Prerequisites
1. JDK (at least JDK 8)
2. Elasticsearch (Refer Setting Up Guide.docx available in the repository)
3. Bulk index accounts.json file to your Elasticsearch using curl.

# Grails Version Used: 
3.3.9

# JAVA API for Elasticsearch: 
Via Maven Repo-> "org.elasticsearch:elasticsearch:6.7.1"
