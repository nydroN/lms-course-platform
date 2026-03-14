# 🎓 LMS Course Platform

A full-stack Learning Management System (LMS) built with **Spring Boot** and **Vanilla JavaScript**. This project demonstrates a robust, production-ready architecture featuring secure JWT authentication, role-based access control (RBAC), and seamless REST API integration.

## 🚀 Features

- **Secure Authentication:** JWT-based user login and registration flows.
- **Role-Based Access Control (RBAC):** Differentiated authorities for `ADMIN` and `USER` roles.
- **Course Management:** Admins can dynamically add, view, and delete courses.
- **Single Page Application (SPA) Feel:** Real-time DOM updates using Vanilla JS without page reloads.
- **CORS Configured:** Secure and fully configured cross-origin resource sharing between the backend and frontend.
- **Responsive Design:** Clean and modern UI powered by Bootstrap 5.

## 🛠️ Tech Stack

### Backend
- **Java & Spring Boot:** Core backend framework.
- **Spring Security & JWT:** For stateless, secure API endpoints.
- **Spring Data JPA & Hibernate:** ORM for database interactions.
- **MySQL:** Relational database management.

### Frontend
- **HTML5 & CSS3:** Page structure and styling.
- **Vanilla JavaScript:** API requests (Fetch API), token management, and DOM manipulation.
- **Bootstrap 5:** Modals, grid system, and responsive UI components.

## ⚙️ How It Works

1. **Authentication:** Users register and log in to receive a securely signed JSON Web Token (JWT).
2. **Token Storage:** The JWT is stored in the browser's `localStorage` and automatically attached as a `Bearer` token to the headers of subsequent API requests via a custom interceptor function.
3. **Authorization:** The frontend decodes the JWT payload to conditionally render UI elements (e.g., hiding the "Add Course" and "Delete" buttons for non-admins). The backend independently verifies the token signature and role before executing sensitive operations.


---
*Developed with clean code principles and secure architecture in mind.*
