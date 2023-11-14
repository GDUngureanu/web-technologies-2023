# Web Technologies - Laboratory 06 - Exercise 01

## Exercise

### 1. Starting from a business idea - breakdown the requirements

#### Possible business ideas:

- Event Planner

- Marketplace

- Designer Platform

- Food Truck Locator

- Other.

### 2. Take the requirements for a MVP (minimal viable product) and transform them to REST API endpoints

---

### Example for a Fitness Class Booking System

#### 1. Register User (Student/Instructor)

**Endpoint:** `/api/users/register`

- **Type:** POST
- **Request Body:** User registration details with a role.
  ```json
  {
      "username": "user123",
      "email": "user123@example.com",
      "password": "securepassword123",
      "role": "Instructor" // or "Student"
  }
  ```
- **Response Body:** User profile information.
- **Example Response:**
  ```json
  {
      "userId": "12345",
      "username": "user123",
      "email": "user123@example.com",
      "role": "Instructor"
  }
  ```

#### 2. Create a Class

**Endpoint:** `/api/classes`

- **Type:** POST
- **Request Body:** Class details including the user ID of the instructor.
  ```json
  {
      "type": "Yoga",
      "time": "2021-07-21T07:00:00",
      "instructorId": "12345",
      "capacity": 10
  }
  ```
- **Response Body:** Confirmation with class details.
- **Example Response:**
  ```json
  {
      "classId": 1,
      "type": "Yoga",
      "time": "2021-07-21T07:00:00",
      "instructorId": "12345",
      "spotsAvailable": 10
  }
  ```

#### 3. List All Classes

**Endpoint:** `/api/classes`

- **Type:** GET
- **Query Params:**
    - `type` (optional): Filter by class type.
    - `date` (optional): Filter by class date.
- **Request Body:** None
- **Response Body:** List of classes.
- **Example Response:**
  ```json
  [
      {
          "classId": 1,
          "type": "Yoga",
          "time": "2021-07-21T07:00:00",
          "instructorId": "12345",
          "spotsAvailable": 8
      }
      // More classes
  ]
  ```

#### 4. List All Users

**Endpoint:** `/api/users`

- **Type:** GET
- **Query Params:**
    - `role` (optional): Filter by user role ('Instructor' or 'Student').
- **Request Body:** None
- **Response Body:** List of users.
- **Example Response:**
  ```json
  [
      {
          "userId": "12345",
          "username": "instructor1",
          "email": "instructor1@example.com",
          "role": "instructor"
      },
      {
          "userId": "12346",
          "username": "student1",
          "email": "student1@example.com",
          "role": "student"
      }
      // More users
  ]
  ```

#### 5. Update Class

**Endpoint:** `/api/classes/{classId}`

- **Type:** PUT
- **Path Variables:**
    - `classId`: ID of the class to be updated.
- **Request Body:** Updated class details.
  ```json
  {
      "type": "Pilates",
      "time": "2021-07-22T08:00:00",
      "capacity": 15
  }
  ```
- **Response Body:** Confirmation with updated class details.
- **Example Response:**
  ```json
  {
      "classId": 1,
      "type": "Pilates",
      "time": "2021-07-22T08:00:00",
      "instructorId": "12345",
      "spotsAvailable": 15
  }
  ```
- **Security:** Only instructors should be allowed to update class details. Implement authentication and role-based authorization checks.

#### 6. Book a Class

**Endpoint:** `/api/classes/{classId}/book`

- **Type:** POST
- **Path Variables:**
    - `classId`: ID of the class to book.
- **Request Body:** User ID of the student booking the class.
  ```json
  {
      "userId": "12346"
  }
  ```
- **Response Body:** Confirmation of booking.
- **Example Response:**
  ```json
  {
      "message": "Class booked successfully.",
      "classId": 1,
      "userId": "12346"
  }
  ```

#### 7. Cancel a Booking

**Endpoint:** `/api/classes/{classId}/cancel`

- **Type:** POST
- **Path Variables:**
    - `classId`: ID of the class for which the booking is to be canceled.
- **Request Body:** User ID of the student canceling the booking.
  ```json
  {
      "userId": "12346"
  }
  ```
- **Response Body:** Confirmation of cancellation.
- **Example Response:**
  ```json
  {
      "message": "Booking cancelled successfully.",
      "classId": 1,
      "userId": "12346"
  }
  ```

#### 8. Update Personal User Profile

**Endpoint:** `/api/users/{userId}/profile`

- **Type:** PUT
- **Path Variables:**
    - `userId`: ID of the user whose profile is to be updated.
- **Request Body:** Updated profile details.
  ```json
  {
      "email": "newemail@example.com",
      "fitnessGoals": "Increase flexibility",
      "preferredClassTypes": ["Pilates", "Yoga"]
  }
  ```
- **Response Body:** Updated user profile information.
- **Example Response:**
  ```json
  {
      "userId": "12346",
      "username": "student1",
      "email": "newemail@example.com",
      "role": "student",
      "fitnessGoals": "Increase flexibility",
      "preferredClassTypes": ["Pilates", "Yoga"]
  }
  ```

#### 9. Delete a Class

**Endpoint:** `/api/classes/{classId}`

- **Type:** DELETE
- **Path Variables:**
    - `classId`: The ID of the class to be deleted.
- **Request Body:** None
- **Response Body:** Confirmation message.
- **Example Response:**
  ```json
  {
      "message": "Class successfully deleted.",
      "classId": 1
  }
  ```
- **Details:** This functionality allows an instructor to remove a class from the schedule. It's a key feature, especially if a class is no longer
  going to be offered.
- **Security:** Only instructors (or admins) should be able to delete classes. Implement appropriate role-based access control.

#### 10. Remove a User from the System

**Endpoint:** `/api/users/{userId}`

- **Type:** DELETE
- **Path Variables:**
    - `userId`: The ID of the user to be removed.
- **Request Body:** None
- **Response Body:** Confirmation message.
- **Example Response:**
  ```json
  {
      "message": "User profile successfully deleted.",
      "userId": "12345"
  }
  ```
- **Details:** This could be used in scenarios where a user decides to leave the platform and wants their profile and associated data removed.
- **Security:** Users should only be able to delete their own profiles unless an admin role is involved.

### Additional Enhancements and Endpoints

#### Notification System

Implement a notification system to alert users (especially students) when classes are updated or canceled. This could involve an additional endpoint
for managing user notifications or preferences.

#### User Authentication and Authorization

Consider adding endpoints for user authentication (login) and authorization, especially to distinguish between instructor-led operations (like
creating or updating classes) and student operations (like booking classes).

#### Feedback or Rating System

Introduce endpoints for students to rate classes or provide feedback, which could help improve the quality of classes and instructor performance.
 