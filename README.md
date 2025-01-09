# Forum API
A Spring-based REST API designed to manage and store forum data such as topics, answers, users, courses, and profiles in a PostgreSQL database. The project follows industry-standard practices for efficient and secure data handling while leveraging Spring Boot for seamless development.

---

## Features
- **User Management**: Create and manage user accounts with profiles.
- **Forum Topics**: Create, retrieve, and manage topics within the forum.
- **Answers**: Add and retrieve answers for topics, including marking solutions.
- **Course Integration**: Associate topics with specific courses for better categorization.
- **Role-Based Access Control**: Manage user roles through profiles.

---

## Technologies
- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL
- **ORM**: Hibernate (JPA)
- **Validation**: Jakarta Validation
- **Security**: Spring Security
- **Documentation**: Swagger
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **API Testing**: Postman
- **Version Control**: Git

---

## Setup

### Prerequisites
Ensure you have the following installed:
- Java 17 or higher
- Maven
- PostgreSQL

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/SebasDosman/forum_hub_project.git
   cd forum_hub_project
   ```
2. Configure the database:
   - Update application.properties with your PostgreSQL credentials.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database  
   spring.datasource.username=your_username  
   spring.datasource.password=your_password  
   spring.jpa.hibernate.ddl-auto=update
   ```  
3. Build the project:
   ```bash
   mvn clean install
    ```
4. Run the application:
   ```bash
   mvn spring-boot:run
    ```

---

## Endpoints

### User Endpoints
- GET `/users`: List all users
- GET `/users/{id}`: Retrieve user by ID
- PUT `/users`: Update a user
- DELETE `/users/{id}`: Delete a user
### Topic Endpoints
- GET `/topics`: List all topics
- GET `/topics/status`: List all topics by status active 
- GET `/topics/{id}`: Retrieve topic by ID
- POST `/topics`: Create a new topic
- PUT `/topics`: Update a topic
- PUT `/topics/status/{id}`: Update a topic status
- DELETE `/topics/{id}`: Delete a topic
### Answer Endpoints
- GET `/answers`: List all answers
- GET `/answers/{id}`: Retrieve answer by ID
- POST `/answers`: Add an answer to a topic
- PUT `/answers`: Update an answer
- DELETE `/answers/{id}`: Delete an answer
### Course Endpoints
- GET `/courses`: List all courses
- GET `/courses/{id}`: Retrieve course by ID
- POST `/courses`: Create a new course
- PUT `/courses`: Update a course
- DELETE `/courses/{id}`: Delete a course
### Profile Endpoints
- GET `/profiles`: List all profiles
- GET `/profiles/{id}`: Retrieve profile by ID
- POST `/profiles`: Create a new profile
- PUT `/profiles`: Update a profile
- DELETE `/profiles/{id}`: Delete a profile
### Authentication Endpoints
- POST `/auth/register`: Register a new user
- POST `/auth/login`: Authenticate a user

---

## Future Improvements
- Add authentication and authorization using JWT.
- Implement pagination for list endpoints.
- Enhance error handling and validation responses.

---

## License
This project is licensed under the MIT License.

---

## Contributions
Contributions are welcome! Feel free to submit a pull request or open an issue to discuss improvements.

---

## Contact
For any questions or feedback, reach out at:
- **Email**: jsdosman0@gmail.com
- **GitHub**: SebasDosman