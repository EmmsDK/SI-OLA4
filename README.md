### README.md for OLA4

#### Project Overview
The MyTrailer application is designed to manage trailer rentals. It allows users to book, return, and manage trailers and rentals. The application initially built as a monolith, demonstrates the use of Spring Boot and Spring Cloud for building scalable enterprise applications.

#### Domain-Driven Design (DDD) Approach

##### Entities
Entities in the MyTrailer application are objects that have a distinct identity that runs through the system and persists over time.
- **Trailer**: Represents a trailer available for rent. Each trailer has a unique identifier, a location, and availability status.
- **Customer**: Represents a customer who can rent trailers. Each customer has a unique identifier, name, and email.
- **Rental**: Represents a rental agreement between a customer and a trailer. It includes details like rental periods and associated customer and trailer.

##### Value Objects
Currently, the application does not explicitly define value objects. However, implementing value objects for things like `Email`, `LocationId`, and `RentalPeriod` could enhance the model by encapsulating validations and behaviors related to these aspects.

##### Aggregates
The `Rental` aggregate includes the `Rental`, `Customer`, and `Trailer` entities. This aggregate ensures that all operations on a rental are consistent and maintain the integrity of the business rules.
- **RentalService**: Acts as an aggregate root for rentals, managing the lifecycle of each rental and enforcing business rules.

##### Repositories
While not explicitly defined in the provided code, our plan was that the repositories would be responsible for retrieving and storing persistent objects like `Trailer`, `Customer`, and `Rental`.
- **TrailerRepository**: Manages persistence operations for trailers.
- **CustomerRepository**: Manages persistence operations for customers.
- **RentalRepository**: Manages persistence operations for rentals.

#### Architecture

##### Monolithic Architecture
The application is structured as a monolith with a single deployable unit managed by Spring Boot, making it easier to develop, test, and deploy initially.

##### Refactoring to Microservices
To refactor the application into microservices, each bounded context (e.g., Trailers, Customers, Rentals) would be separated into its own microservice. This separation allows for independent scaling, development, and deployment of each microservice.
- **Trailer Service**: Manages all operations related to trailers.
- **Customer Service**: Manages all operations related to customers.
- **Rental Service**: Manages all operations related to rentals.
