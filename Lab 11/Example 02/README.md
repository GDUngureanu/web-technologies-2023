# Web Technologies - Laboratory 11 - Exercise 02

## Online Event Booking System

### Objective: Develop the back-end for an online event booking application. The system should expose REST endpoints for managing event bookings and use an SQL database for data storage.

### Key Features and Constraints:

1. **Add an Event Endpoint**:
    - **Request Fields**: `eventId`, `eventName`, `eventType`, `eventDate`, `venue`, `maxCapacity`, `price`.
    - **Constraints**:
        - `eventId`: Unique, non-nullable.
        - `eventName`: Non-nullable, maximum 150 characters.
        - `eventType`: Non-nullable, must be one of predefined types (e.g., CONCERT, WORKSHOP, SEMINAR).
        - `eventDate`: Non-nullable, must be a future date.
        - `venue`: Non-nullable, maximum 100 characters.
        - `maxCapacity`: Non-negative integer.
        - `price`: Non-negative decimal.
    - **Business Logic**: Reject addition if an event with the same `eventName`, `eventDate`, and `venue` already exists.

2. **Book Event Endpoint**:
    - **Request Fields**: `bookingId`, `eventId`, `customerName`, `numberOfTickets`.
    - **Constraints**:
        - `bookingId`: Unique, non-nullable.
        - `eventId`: Must exist in the events table.
        - `customerName`: Non-nullable, maximum 100 characters.
        - `numberOfTickets`: Non-negative integer, must not exceed the remaining capacity for the event.
    - **Business Logic**: Update the remaining capacity of the event after each successful booking.

3. **Cancel Booking Endpoint**:
    - **Request Fields**: `bookingId`.
    - **Constraints**:
        - Validate that `bookingId` exists.
    - **Business Logic**: Update the remaining capacity of the event after cancellation.

4. **Unit Tests**: Implement unit tests for all service methods with a target of at least 75% code coverage.

5. **Database Choice**: You are free to choose the type of SQL database.

### Step by Step:

- [ ] Create a maven project with Spring Web dependencies:
    - [ ] Add Spring Web Dependency: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    - [ ] (Optional) Add Lombok Dependency: https://mvnrepository.com/artifact/org.projectlombok/lombok
    - [ ] Add Spring Plugin: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-maven-plugin
    - [ ] (Optional) Add Lombok to annotationProcessorPaths: https://ioflood.com/blog/lombok-maven/

- [ ] Create simple models for the given requirements

- [ ] Create controllers for the given functionality
    - Before proceeding to next step
        - [ ] Test the API with dummy data.
        - [ ] Create unit tests for the controllers.
            - [ ] Add JUnit for simple tests: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

- [ ] Implement service layer
    - [ ] Create services for the given requirements
    - [ ] Link services to the controllers and update existing tests
        - [ ] Add Mockito for mocking test dependencies: https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
    - Before proceeding to next step
        - [ ] Test the API with dummy data.
        - [ ] Create unit tests for the services.

- [ ] Configure Database
    - H2
        - [ ] Add H2 DB Dependency: https://mvnrepository.com/artifact/com.h2database/h2
        - [ ] Add H2 DB Properties in application.yml (example in Lab 7)
    - PostgreSQL
        - [ ] Add PostgreSQL DB Dependency: https://mvnrepository.com/artifact/org.postgresql/postgresql
        - [ ] Add PostgreSQL DB Properties in application.yml (example in Lab 8 & 9)
        - [ ] (Optional) Create SQL script for creating tables. (example in Lab 8)

- [ ] Implement persistence layer
    - [ ] Spring Data JPA Dependency: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    - [ ] Transform modals to entities (ensure that the columns ar properly annotated if you are not using SQL scripts)
    - [ ] Create repositories for the given entities
    - [ ] Link repositories to the services and update existing tests
        - [ ] Test the API with the DB.

- [ ] (Optional) Create Integration Tests (example in Lab 10):
    - [ ] Add Spring Boot Starter Test for Web tests: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
