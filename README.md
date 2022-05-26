### Team Members
- Drake Menard    :: Team Lead
- Aarion Ojeda    :: Backend
- Quentin Hewitt  :: Backend
- Kristen Wilson  :: Frontend
### List of Microservices Identified 
- ProductService      :: Drake
- CartService         :: Aarion
- TransactionService  :: Drake 
- userAccountService  :: Quentin
- RegistrationService :: 
- GatewayService      :: Kristen
********************************* 
### Microservice - Product
#### Models 
- Model - Product
    - Attribute - 1: int (Primary key) id
    - Attribute - 2: String name
    - Attribute - 3: double price 
    - Attribute - 4: String description (Nullable)

#### Endpoints 
- /api/v1/products - GET --this will display all current Products in the db that are for sale
- /api/v1/list_for_sale - POST -- this will add the Product to the db containing items for sale 
- /api/v1/list_for_sale - PUT –- this will update a given Product that is already for sale
- /api/v1/products/{prodID} - DELETE –-this will remove an item from the for sale database  

#### Models 
- Model - Transaction
    - Attribute - 1: int (Primary key) orderNumber
    - Attribute - 2: String accountInfo
    - Attribute - 3: double price 

#### Endpoints 
- /api/v1/products/{prodID} - GET --this will display all current Product that the buyer is interested in
- /api/v1/products/{prodID} - POST –-this will add the item to the cart to be purchased
- /api/v1/products/{prodID} - PUT –-this will update the for-sale registry
- /api/v1/checkout/ - DELETE –-this will delete the items from the cart AND the db when transaction is successful

#### Models
- Model - User Profile (Account)

- user_id int (auto-generated) Primary Key
- username String (text, VARCHAR_200, required)
- password String (text, VARCHAR_200, required)
- firstName String (text, VARCHAR_200, required)
- lastName String (text, VARCHAR_200, required)

### Endpoints
- /api/v1/users/new - POST - Create a user
- /api/v1/users/{userID} - GET - Get the user with the given userID
- /api/v1/users - GET - Get all the users
- /api/v1/users/{userID} - PUT - Update the userID's profile info with the provided JSON
- /api/v1/users/{userID} - DELETE - Delete userID's profile 

#### Models
- Model - Cart ::incorporate the cart service with the transaction service::
    - List<Product products> - list of current products in our cart  ::Do we need? Try to factor out since stored in db::
    - doube price of items together
    - String payment information
    - User userId (Primary Key) user that cart belongs to
    - int order/transaction/receipt number 
    
#### Endpoints

- /api/v1/checkout/ - DELETE –-this will delete the items from the cart AND the db when transaction is successful
- /api/v1/checkout/ - PUT –-this will update the items from the cart
    
    
********************************** 



