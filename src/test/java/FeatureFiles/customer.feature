@customerApi
Feature: Test customer all endpoints

  Background: 
    * configure base uri

  Scenario: create new customer using post request
    Given get the request specification object
    And attach customer request payload to http request
    When select http post request to create customer
    Then capture id from response payload
    And validate status code 201
    And validate status line "Created"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate customer json schema
    And generate logs

  Scenario: update customer using put request
    Given get the request specification object
    And attach updated customer request payload to http request
    And add path parameter
    When select http put request to update customer
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate customer json schema
    And generate logs

  Scenario: retrieve customer using get request
    Given get the request specification object
    And add path parameter
    When select http get request to get customer
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate customer json schema
    And generate logs
    
     Scenario: delete customer using get request
    Given get the request specification object
    And add path parameter
    When select http delete request to delete customer
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And generate logs
