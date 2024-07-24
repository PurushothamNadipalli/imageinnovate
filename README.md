
GET : HealthCheck:
curl --location 'http://localhost:8080/v1/healthcheck'

POST :  Add Employee
curl --location 'localhost:8080/v1/api/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName" : "raju",
    "lastName" : "S",
    "email" : "srikanth@gamil.com",
    "phoneNumber" : ["9876543210"],
    "doj" : "2023-03-21",
    "salary" : 250000
}'

GET: getEmployee by ID
curl --location 'localhost:8080/v1/api/employee/1'

GET : caluculate Tax
curl --location 'http://localhost:8080/v1/api/employeeTDS/1' 
