# -Bluebik-_Global_Assignment


The Transaction microservice is responsible for handling credit and debit operations on user accounts in the Bank App.

API Endpoints
Credit API
Endpoint: /api/credit

Description: Credits a specified amount to the account balance for a given user.

      *  Request: 

POST /api/credit
Content-Type: application/json

{
  "user_id": "123456",
  "amount": 1000
}



     *    Response:

HTTP/1.1 200 OK
Content-Type: application/json

{
  "message": "Credit successful",
  "new_balance": 5000
}


 *     Debit API
Endpoint: /api/debit

Description: Debits a specified amount from the account balance for a given user.

*    Request:

POST /api/debit
Content-Type: application/json

{
  "user_id": "123456",
  "amount": 500
}

*      Response:

HTTP/1.1 200 OK
Content-Type: application/json

{
  "message": "Debit successful",
  "new_balance": 4500
}

# Constraints
Credit operation: The account balance cannot exceed 10 million.
Debit operation: The account balance cannot go below 0.

# Notes
Multiple users can perform credit and debit operations on a single account simultaneously.
The microservice ensures that the account balance remains within the specified constraints.
Proper error handling is implemented to handle scenarios such as insufficient balance or invalid user ID.
