Feature: Test Map all endpoints

  Background: 
    * configure base uri

  Scenario: create new map using post request
    Given get the request specification object
    And attach request payload to http request
    When select http post request
    Then capture id from response payload
    And validate status code 201
    And validate status line "Created"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate json schema
    And generate logs

  Scenario: retrieve map using post request
    Given get the request specification object
    And add path parameter
    When select http get request
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate json schema
    And generate logs

  Scenario: update map using put request
    Given get the request specification object
    And attach request payload to http put request
    And add path parameter
    When select http put request
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate json schema
    And generate logs
    
    
    
  Scenario: retrieve map using get request
    Given get the request specification object
    And add path parameter
    When select http get request
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And validate json schema
    And generate logs
    
     Scenario: delete map using delete request
    Given get the request specification object
    And add path parameter
    When select http delete request
    And validate status code 200
    And validate status line "OK"
    And validate response time below 5000 ms
    And validate "Content-Type" and "application/json" response header
    And validate "Date" and current month and year response header
    And generate logs

    
    
    Scenario: retrieve map using get request
    Given get the request specification object
    And add path parameter
    When select http get request
    And validate status code 404
    And validate status line "Not Found"
    And validate response time below 5000 ms
    And generate logs