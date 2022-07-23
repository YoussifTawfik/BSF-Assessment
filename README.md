# BSF-Assessment

The Main purpose of BSF assessment is to expose two APIs:
1- Transfer Money from an account to another one.
2- get account details by account code.

Layers Architecture: 
REST Controller ----> Adapter ----> Service ----> Repository

Entities:
Account ----> (Id, Code, Balance, Creation date).


For more details about the APIs request and response, you can check the below link to access Swagger (The API documentation).
Swagger URL: 
http://localhost:8080/swagger-ui/#/account-controller

also you can test the APIs using postman through the below link:
Postman Collection:
https://drive.google.com/file/d/1E1bVqTQ8dO5JGGgiAgpmmUqgKvJqi8Iz/view?usp=sharing

