Todo Management Project:

This Todo Management project is a full-stack application designed to manage projects and their associated tasks (or todos). It includes the following core features:

1. Project Creation: Users can create projects with titles and view a list of all existing projects.
2. Todo Management: Within each project, users can:
 * Add, edit todos.
 * Mark todos as complete or pending.
3. Gist Export: Users can export a project summary as a GitHub gist in markdown format, which lists completed and pending todos.

The backend is built with Spring Boot and includes:
 * A REST API with endpoints for projects and todos.
 * Basic authentication for API security.
 * Database persistence using JPA and MySQL.

The frontend uses React and provides a user interface to manage projects and todos, with Axios used for API requests. Additionally, CORS is configured for secure communication between the frontend and backend during development.


Project Setup Guide
This guide provides instructions on how to set up and run the backend and frontend of this project separately.


Prerequisites
* Java 17+
* Node.js (LTS version)
* MySQL Server
* IntelliJ IDEA (or any preferred IDE for Java)
* VS Code (or any preferred IDE for JavaScript/React)


Backend Setup (Spring Boot + MySQL)

1. Clone the Repository
https://github.com/suraj768689/Project-todos-backend.git
cd your-repository-folder

2. Configure MySQL Database
* Open MySQL and create a database for the application.
* Update application.properties in src/main/resources with your MySQL credentials and database name.

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run the Backend
Open the backend folder in IntelliJ IDEA.
Navigate to the main application class (e.g., TodoManagerApplication.java) and run it.
The backend server will start on http://localhost:8090.


Frontend Setup (React)

1. Clone the Repository
 https://github.com/suraj768689/Projects-todos-frontend.git
 cd your-repository-folder

2. Install Dependencies
npm install

3. Configure API Base URL
* Open src/service/apiService.js and ensure the API_URL matches your backend URL:
 const API_URL = 'http://localhost:8090/api';

4. Run the Frontend
npm start

Access the frontend at http://localhost:3000.


PROJECT OUTPUT:

1. Project list page with list of project name and add new project button.
   https://drive.google.com/file/d/1dPeQ5KO7FDQH2izrDQXLkq4mcvmkQ9ca/view?usp=drive_link

2. Project Form to add new poroject.
   https://drive.google.com/file/d/1cjXnC_67-Dv6Nr2yVkAyntNHLqaGsCP1/view?usp=drive_link

3. Todos of a particular project(project details page) with summary, pendind and completed task.
   https://drive.google.com/file/d/1qMFkLRbM8zeiSwLxIw3TEz5VdwIqkRcw/view?usp=drive_link

4. Todo form to add new todo of a particular project through project id.
   https://drive.google.com/file/d/1XdbzjYWE7-RTcWGzEiLKAsT9AEoQIZ0M/view?usp=drive_link

5. Edit form of a todo of a project through todo id.
   https://drive.google.com/file/d/1NZiaHOTmYyZYxw2Vf9XppNb-53pFxj6s/view?usp=drive_link
