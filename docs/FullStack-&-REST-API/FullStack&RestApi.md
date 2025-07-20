# Spring Boot Full Stack Tutorial

## Table of Contents
1. [Maven](#maven)
2. [Pom.xml](#pomxml)
3. [JPA and Hibernate](#jpa-and-hibernate)
4. [H2 Database](#h2-database)
5. [Building First Web Application](#building-first-web-application)
    - [JSP](#jsp)
    - [@RequestParam & ModelMap](#requestparam--modelmap)
    - [Dispatcher Servlet](#dispatcher-servlet)
6. [Building a Todo Webapp](#building-a-todo-webapp)
    - [@SessionAttribute](#sessionattribute)
    - [JSTL](#jstl)
    - [Validation](#validation)
    - [JSP Fragments](#jsp-fragments)
    - [Spring Security Basics](#spring-security-basics)
7. [REST API](#rest-api)
    - [Response Status](#response-status)
    - [Custom Error Structures](#custom-error-structures)
    - [Validation in REST API](#validation-in-rest-api)
    - [REST API Documentation](#rest-api-documentation)
    - [REST API Content Negotiation](#rest-api-content-negotiation)
    - [REST API Internationalization (i18n)](#rest-api-internationalization-i18n)
    - [REST API Versioning](#rest-api-versioning)
    - [HATEOAS for REST API](#hateoas-for-rest-api)
    - [Filtering in REST API](#filtering-in-rest-api)
    - [HAL Explorer](#hal-explorer)
    - [Spring Security Basics for REST API](#spring-security-basics-for-rest-api)

---

## Maven
Apache Maven is a build automation tool used primarily for Java projects. It helps in managing dependencies, builds, and project structure.

## Pom.xml
The `pom.xml` file is the heart of any Maven project. It contains project configuration, dependencies, plugins, and build settings.

## JPA and Hibernate
JPA (Java Persistence API) is a specification for accessing, persisting, and managing data. Hibernate is the most popular implementation of JPA.

## H2 Database
H2 is an in-memory relational database. It is often used for development and testing due to its lightweight and fast performance.

---

## Building First Web Application

### JSP
JavaServer Pages (JSP) allows the creation of dynamically generated web pages based on HTML, XML, or other document types.

### @RequestParam & ModelMap
- `@RequestParam` binds HTTP request parameters to method parameters.
- `ModelMap` is used to pass attributes from the controller to the view.

### Dispatcher Servlet
The DispatcherServlet is the front controller in Spring MVC. It routes requests to appropriate handlers, view resolvers, etc.

---

## Building a Todo Webapp

### @SessionAttribute
Used to store model attributes in the session between requests.

### JSTL
JavaServer Pages Standard Tag Library (JSTL) provides tags for common tasks such as iteration and conditionals in JSP.

### Validation
Spring provides powerful validation mechanisms using `@Valid`, `BindingResult`, and custom validators.

### JSP Fragments
JSP fragments allow reuse of common layouts and components using JSP includes or tag files.

### Spring Security Basics
Basic authentication, authorization, and configuration for securing a web application.

---

## REST API

### Response Status
Control HTTP response status using `@ResponseStatus` or `ResponseEntity`.

### Custom Error Structures
Design consistent and informative error responses using `@ControllerAdvice`.

### Validation in REST API
Use Bean Validation (`@Valid`) and `MethodArgumentNotValidException` to enforce request validation.

### REST API Documentation
Document your API using tools like **SpringDoc** or **Swagger/OpenAPI**.

### REST API Content Negotiation
Support multiple data formats (JSON, XML, etc.) using Spring’s content negotiation strategies.

### REST API Internationalization (i18n)
Provide localized error messages and responses based on user’s locale.

### REST API Versioning
Use techniques like URI versioning, request parameter, or header-based versioning to support multiple API versions.

### HATEOAS for REST API
Hypermedia as the Engine of Application State (HATEOAS) adds navigational links to your REST responses.

### Filtering in REST API
Implement field-level filtering to control the data returned to clients.

### HAL Explorer
HAL Explorer is a browser-based tool for navigating HAL-based REST APIs.

### Spring Security Basics for REST API
Secure REST endpoints using stateless authentication (e.g., JWT, Basic Auth) with Spring Security.

