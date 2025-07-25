# Springboot

# Maven

- 
    
    ![image.png](/images/Springboot/image.png)
    

## pom.xml

- 
    
    ![image.png](/images/Springboot/image%201.png)
    

- Under dependencyManagement we only specify the version of dependency we are using in our project. The dependencies which would be downloaded are present in dependencies.

## Maven Build Life Cycle

- 
    
    ![image.png](/images/Springboot/image%202.png)
    

- Validate: Is the java code correct?
- Compile: Compile the java code
- Test: Perform the unit test
- Package: Create a jar file
- Integration Test: Perform the integration test
- Verify
- Install: Installed the jar file on our target folder
- Deploy

## How Maven Works

- 
    
    ![image.png](/images/Springboot/image%203.png)
    
- When we add a dependency in our pom.xml, then the dependency is downloaded from the Maven Central Repository (to our local repository). If we are using some dependency which is not yet released but is RC1 (Release Candidate), then we have to specify another repository using <repositor></repository> in our pom.xml
- 
    
    ![image.png](/images/Springboot/image%204.png)
    

## Important Maven Commands

- 
    
    ![image.png](/images/Springboot/image%205.png)
    

## How spring projects are versioned

- 
    
    ![image.png](/images/Springboot/image%206.png)
    

# Building a Simple Rest API in Springboot

- 
    
    ![image.png](/images/Springboot/image%207.png)
    
- 
    
    ![image.png](/images/Springboot/image%208.png)
    
- 
    
    ![image.png](/images/Springboot/image%209.png)
    

- When we run the LearnSpringbootApplication as Java application, and go to [localhost:8080/courses](http://localhost:8080/courses) we would see this
    
    ![image.png](/images/Springboot/image%2010.png)
    

## Springboot Starter Projects

- 
    
    ![image.png](/images/Springboot/image%2011.png)
    

## Springboot - AutoConfiguration

- 
    
    ![image.png](/images/Springboot/image%2012.png)
    

## Springboot Devtools

- If we don’t use Devtools, then whenever we make a change in our code we would have to close or stop the already running server (or else there would be an error stating the current host is already in use), and then again run the code as java application.
- But if we use Devtools, then whenever we make some changes and save the code, after refreshing the webpage the changes would be visible.
- To use Devtools we have to add a dependency:
    
    ```java
    <dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-devtools</artifactId>
    		</dependency>
    ```
    
- 
    
    ![image.png](/images/Springboot/image%2013.png)
    

## Production Ready Applications with Springboot

- Spring boot provides various features by which the application gets production ready.

### 1. Managing Application Configuration Using Profiles

- Every application has multiple configurations (development, test, production), every configuration needs a different environment (dev environment, test environment, production environment).
    
    ```xml
    This is a fundamental truth in software development. 
    An application needs different settings when it's being developed locally, 
    when it's being tested, and when it's live for users. 
    For instance, a development environment might connect to a local, in-memory database, 
    while production connects to a robust, highly available cloud database.
    ```
    
- Springboot helps in managing all these configuration, and their environment. It could be possible that Dev environment is talking to DatabaseA, while Test Environment is talking to DatabaseB.
    
    ```xml
    This is precisely what Spring Boot excels at with its configuration management features. 
    It allows developers to define different property values (like database connection details, 
    API keys, server ports) based on the active environment. The example of 
    "DatabaseA" vs. "DatabaseB" clearly illustrates this need.
    ```
    
- Springboot uses Profiles to manage the different environments present in the application.
    
    ```xml
    This is the core mechanism in Spring Boot for achieving environment-specific configuration. 
    A "profile" is a named logical group of bean definitions and configuration properties that 
    can be activated at runtime. Common profile names include dev, test, prod, qa, etc.
    ```
    
- The specific profile is set as active in the [application.properties](http://application.properties) in the resource package.
    
    ```xml
    This is one of the primary ways to activate a profile in Spring Boot. 
    You can specify spring.profiles.active=dev (or test, prod, etc.) in your application.properties 
    (or application.yml) file. Other ways to activate profiles include:
    Command-line arguments (--spring.profiles.active=dev)
    Environment variables (SPRING_PROFILES_ACTIVE=dev)
    Web deployment descriptor (web.xml) for WAR files.
    ```
    
- The dev profile would be named: [application-dev.properties](http://application-dev.properties), the prod profile would be named:             application-prod.properties
- When we want to set a profile active, then in the [application.properties](http://application.properties) we write:                 spring.profiles.active=<profileName>
- For eg: We want to make 2 profiles, for Dev and Prod. And we want to set the logging level for dev as trace, and for prod as info. Then we want to set the dev profile as active.
    
    ![image.png](/images/Springboot/image%2014.png)
    
    ![image.png](/images/Springboot/image%2015.png)
    
    ![image.png](/images/Springboot/image%2016.png)
    
- There are multiple logging levels present:
1. trace: 
    
    ```xml
    Extremely fine-grained informational events that are most useful for debugging an application. 
    This is typically for developers during active debugging sessions and can generate a 
    massive amount of output.
    ```
    
2. debug: 
    
    ```xml
    Fine-grained informational events that are most useful to debug an application. 
    Similar to TRACE but usually a bit less granular, providing information useful for 
    understanding the flow and state of the application.
    ```
    
3. info: 
    
    ```xml
    Informational messages that highlight the progress of the application at a coarse-grained level. 
    This is often the default level for production environments, showing significant events or milestones.
    ```
    
4. warning: 
    
    ```xml
    Potentially harmful situations. These indicate that something unexpected or undesirable happened, 
    but the application can continue to function. It might be a sign of a potential problem in the future.
    ```
    
5. error: 
    
    ```xml
    Error events that might still allow the application to continue running. These indicate that a 
    specific operation failed, but the overall application might still be functional.
    ```
    
6. off: 
    
    ```xml
    This level is used to turn off logging completely. No messages will be logged when this level is 
    active.
    ```
    
- If we want to use multiple complex application configuration, then it is recommended to use @ConfigurationProperties()
- We make a class, and if the name of the class and the name of the configuration is not same we use prefix=<name of configuration> inside @ConfigurationProperties()
- For eg: We want to make an application configuration named: currency-service. we would create a class CurrencyServiceConfiguration, add the attributes required in the class. Give @ConfigurationProperties(prefix=”currency-service”) and @Component to the class. Create a controller for the class, and launch the springboot application.
    
    ![image.png](/images/Springboot/image%2017.png)
    
    ![image.png](/images/Springboot/image%2018.png)
    
    ![image.png](/images/Springboot/image%2019.png)
    
    ![image.png](/images/Springboot/image%2020.png)
    
    ![image.png](/images/Springboot/image%2021.png)
    

### Simplify Deployment using Spring Boot Embedded Servers

- We want our deployment process to be very easy, as any application has multiple environment and deploying each environment could be a little hard. And if we are following an Agile approach, we would be performing multiple deployment per day.
- Old Approach of Deployment (WAR):
    1. Install Java 
    2. Install Web/Application Server (Tomcat/Websphere/Weblogic etc)
    3. Deploy the Web Archive (WAR)
    
    ```xml
    This is a correct depiction of the traditional Java EE deployment model. 
    You'd typically build a WAR file (Web Application Archive) containing your application's code 
    and resources. This WAR then needed to be deployed onto a separately installed and configured 
    web server (like Tomcat or Jetty) or a full-fledged application server (like WebSphere or 
    WebLogic). This approach involves managing two separate components: the application server 
    and the application itself.
    ```
    
- Embedded Server: The JAR already contains a web application like Tomcat:
    1. Install Java
    2. Run JAR
    
    ```xml
    This is the core benefit of Spring Boot's embedded server strategy. When you package a 
    Spring Boot application as an executable JAR, it includes a lightweight, embedded web server 
    (most commonly Tomcat by default, but also Jetty or Undertow can be used).
    
    The implication: You no longer need to separately install a web server. 
    You just need Java installed on the target machine, and then you can directly run the JAR file. 
    The web server starts up within your application process.
    ```
    
- The spring-boot-starter-web brings tomcat with it, and this is one of the reason why we have to use         spring-boot-starter-web dependency when we are building a web application using springboot in pom.xml
- The spring-boot-starter-web brings spring-boot-starter-tomcat, but we can also include                             spring-boot-starter-jetty or spring-boot-starter-undertow
- 
    
    ![image.png](/images/Springboot/image%2022.png)
    

### Monitor Application using Spring Boot Actuator

- Monitoring your application means the ability to look what is happening in the backend of our application. The springboot feature which enables you to monitor your application is: Actuator.
    
    ```xml
    Actuator provides production-ready features to monitor and manage your application when it's 
    running.
    ```
    
- Actuator helps in monitoring and managing your application.
    
    ```xml
    Beyond just monitoring, Actuator also provides endpoints for management tasks like 
    shutting down the application, refreshing configuration, viewing environment properties, etc. 
    (though some of these require explicit enabling for security reasons).
    ```
    
- There are number of endpoints Actuator provides:
    1. beans: all the beans your application has
        
        ```xml
         shows a comprehensive list of all Spring beans configured in your application, 
         their scope, type, and dependencies.
        ```
        
    2. health: the health of your application (is your application on and running)
        
        ```xml
         provides basic application health information, indicating if it's "UP" or "DOWN", 
         often including details about database connectivity, disk space, etc.
        ```
        
    3. metrics: application metrics
        
        ```xml
        provides a list of available metrics, and you can drill down into specific metrics 
        (e.g., /actuator/metrics/jvm.memory.used) to get detailed performance data 
        (like JVM memory usage, CPU usage, HTTP request counts, etc.). This is often integrated 
        with tools like Prometheus and Grafana.
        ```
        
    4. mappings: details around request mapping (mapping of a component to an url) 
        
        ```xml
        shows a comprehensive list of all @RequestMapping annotations in your controllers, 
        indicating which URLs map to which controller methods.
        ```
        
- We had to include the spring-boot-starter-actuator dependency in the pom.xml file.
    
    ![image.png](/images/Springboot/image%2023.png)
    
- After launching the application, we go to [http://localhost:8080/actuator](http://localhost:8080/actuator) for the Actuator, and it gives this as the default output:
    
    ![image.png](/images/Springboot/image%2024.png)
    
- By default, whenever you launch Actuator, it will only show health endpoint. If we want to enable more endpoints, we need to enable them in [application.properties](http://application.properties)
    
    ![image.png](/images/Springboot/image%2025.png)
    
    Now when we launch the /actuator we will see all the endpoints provided by actuator for our application
    
    ![image.png](/images/Springboot/image%2026.png)
    
- But it is recommended to specify the endpoints we want to see in the actuator. If we print all the endpoints, then our application becomes less secure and the cpu gets a lot of toll. So it is preferred to specify the endpoints like: `management.endpoints.web.exposure.include=health,metrics`

## Spring Boot vs Spring vs Spring MVC

- 
    
    ![image.png](/images/Springboot/image%2027.png)
    

# JPA and Hibernate

- These are the dependencies which you would need to use jdbc, jpa, and H2 database:
    
    ![image.png](/images/Springboot/image%2028.png)
    
- Dependency to install JPA in your application
    
    ```xml
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-data-jpa</artifactId>
    		</dependency>
    
    ```
    

## H2 Database

- If you forgot to add dependency while creating the project use this
    
    ```xml
    		<dependency>
    			<groupId>com.h2database</groupId>
    			<artifactId>h2</artifactId>
    			<scope>runtime</scope>
    		</dependency>
    
    ```
    
- To enable the H2 console, or to access the database we would have to type this in application.properties:
    
    ```xml
    spring.h2.console.enabled=true
    ```
    
    ![image.png](/images/Springboot/image%2029.png)
    
- After you have enabled the console in application.properties, run the application and go to                      localhost/h2-console
    
    ![image.png](/images/Springboot/image%2030.png)
    
- The JDBC URL is always incorrect, so we should check the url everytime we go to our database. Since we haven’t mapped a specific url to jdbc right now, so our application generates a random url for it:
    
    ![image.png](/images/Springboot/image%2031.png)
    
- After changing the url, and pressing connect we would be able to access our database:
    
    ![image.png](/images/Springboot/image%2032.png)
    
- To give a specific static url to our jdbc, we have to write this is application.properties:
    
    ```xml
    spring.datasource.url=jdbc:h2:mem:<name>
    ```
    
    ![image.png](/images/Springboot/image%2033.png)
    
- To use JDBC, JPA with H2 we need to make some tables in the database. To make a table, we need to create a file schema.sql in the main/resource folder.

## Spring JDBC

- Spring JDBC is used to manage databases in our applications.
- It uses SQL queries for the management and manipulation of data.
- In JDBC, we have to write a lot of SQL queries and a lot of JAVA code. But in Spring JDBC, the amount of JAVA code becomes less.
    
    ```xml
    Plain JDBC often involves a lot of boilerplate code for opening connections, preparing 
    statements, handling result sets, and closing resources. Spring JDBC significantly reduces this 
    boilerplate through its JdbcTemplate and other helper classes, leading to more concise and 
    readable Java code.
    ```
    

### Inserting Hardcoded Data using Spring JDBC

- To use Spring JDBC to manage our data, we use the JdbcTemplate
- @Repository is the annotation used to define a class which talks to database.
- 
    
    ![image.png](/images/Springboot/image%2034.png)
    
- Now, to if we want that whenever our application starts, this sql query is executed. Then we have to use Command Line Runner. It is a spring interface which runs the statement as soon as the application starts.
    
    ![image.png](/images/Springboot/image%2035.png)
    

### Inserting Softcoded Data using Spring JDBC

- 
    
    ![image.png](/images/Springboot/image%2036.png)
    
    ![image.png](/images/Springboot/image%2037.png)
    

### Querying Data using Spring JDBC (Select Statement)

- We cannot use the update() method since it was only used when we want to insert, update or delete some fields in the table.
- For querying the data we use the query() method which returns a list of data.
- If we want to retrieve only a single data/row, then we use the queryForObject() method.
- When we use query(), or queryForObject() then the return value is in the table format, but it is not supported by Java.
    
    ```xml
    When you execute a SQL SELECT query, the database returns a ResultSet (which conceptually is 
    like a table). While Java's java.sql.ResultSet can directly represent this tabular format, 
    it's a low-level API. The point being made is that you typically don't want to work 
    directly with a ResultSet in your application logic. Instead, you want to convert the data 
    from the ResultSet into Java objects (e.g., POJOs - Plain Old Java Objects) that are easier 
    to work with in your application. So, it's not that "table format is not supported by Java," 
    but rather that ResultSet is a raw format that needs to be mapped to more convenient Java types.
    ```
    
- So we have to map this ResultSet to our class Bean so that it is supported by Java.
- When the class attributes are of the same name as the table fields, we can use the  BeanPropertyRowMapper<>(ClassName.class)
- Example of using query()
    
    ![image.png](/images/Springboot/image%2038.png)
    
    ![image.png](/images/Springboot/image%2039.png)
    
    ![image.png](/images/Springboot/image%2040.png)
    
- Example of using queryForObject()
    
    ![image.png](/images/Springboot/image%2041.png)
    
    ![image.png](/images/Springboot/image%2042.png)
    

## Spring JPA

- In Spring JDBC, the queries starts to be a problem when we have multiple tables in our applications.
- Spring JPA directly maps the class (of which we are making the table) to the table which is present in our database.
    
    ```xml
    This is the fundamental idea behind Object-Relational Mapping (ORM). JPA allows you to define 
    your data model using plain Java classes (entities), and it handles the mapping of these 
    classes to database tables.
    ```
    
- We use @Entity to map the java bean (class) to the table. And this entity would be used to perform the Retrieve, insert, update, delete values from the table.
    
    ```xml
    The @Entity annotation (from jakarta.persistence or javax.persistence) marks a POJO as an 
    entity, meaning it's a JPA-managed object that corresponds to a table in the database. 
    Once a class is an entity, JPA can perform CRUD (Create, Retrieve, Update, Delete) 
    operations on instances of that entity.
    ```
    
- If the bean name is different than the table name then we use @Entity(name=<table name>)
- To make an attribute as the primary key we use @Id above its definition
- To mark an attribute as the column we use @Column(name=<column Name>), only if the name of the column is different than the name of the attribute
    
    ```xml
    By default, JPA maps entity attributes to columns with the same name. If your Java attribute 
    name (e.g., firstName) is different from the database column name (e.g., first_name), you 
    use @Column(name = "first_name") to explicitly map it.
    ```
    
- To use JPA, we have to make an object of EntityManager in our Repository class.
- We use @PersistenceContext while making the object of EntityManager, it works the same as @Autowired but is more specific for the EntityManager class.
- Whenever we want to execute queries using JPA, we have to enable transactions, and to do that we use @Transactional with the repository class. In short repository have 2 annotation, @Repository and @Transactional
- 
    
    ![image.png](/images/Springboot/image%2043.png)
    
    ![image.png](/images/Springboot/image%2044.png)
    

### Inserting A Row using Spring JPA

- Unlike JDBC, when we want to insert a row using JPA we do not have to write the sql query by ourselves, it is done by JPA.
- We create an insert() method with the object of the class mapped to the table as parameter, and call a function merge() with the entityManager object.
- Since the mapping is already done directly in the class, we do not need to specify any column in the insert() or merge() methods.

### Finding A Row using Spring JPA

- In JPA, finding a row and returning it is the select statement.
- We use the find() method, which takes 2 arguments. First being the class which is mapped to the table, and second being the primary key which would be used to find the row in our database/table.
    
    ```xml
    The EntityManager in JPA provides a find() method for this exact purpose. Its signature is 
    typically EntityManager.find(Class<T> entityClass, Object primaryKey).
    
    entityClass: This is the Class object of your entity (e.g., User.class, Product.class), 
    						 which tells JPA which table to query.
    primaryKey: This is the value of the primary key of the row you want to retrieve.
    ```
    

### Deleting a Row using Spring JPA

- In JPA, if we want to delete a row first we have to find it in the table and then we have to delete it.
- We use the find() method to find the table, and instead of returning it we store it in a variable. And then we use the remove() method and pass the row we found using the find() method.

- If we want to see the sql queries generated by JPA, then we have to add this in the [application.properties](http://application.properties)

```xml
spring.jpa.show-sql=true
```

![image.png](image/image%2045.png)

![image.png](image/image%2046.png)

## Spring Data JPA

- Spring Data JPA makes the management and manipulation of data in tables even more easy.
- Here we just need to create an interface repository and extend the JpaRepository<Entity,PrimaryKeyType>
- We don’t even have to create any other method for insert, delete, or select.
- In spring data JPA insert is performed by save(), delete is performed by many methods such as deleteById(), find is performed by many options such as findById().
- After we have created the interface for the repository, then we just need to go to our command line runner class, and instantiate the interface. Now generally, Java does not allow to instantiate an interface but here spring allows this.
    
    ```xml
    Spring creates a concrete implementation class for your repository interface at runtime and 
    manages it as a Spring Bean.
    ```
    
- 
    
    ![image.png](/images/Springboot/image%2047.png)
    
    ![image.png](/images/Springboot/image%2048.png)
    

- We can also create custom methods to perform more CRUD operations. For example if we have a field with the name author, and an attribute author in our entity. Then we can execute the SQL query: select * from Course where author=’Aayushi’ using Spring Data JPA as
    
    ```java
    List<Course> findByAuthor(String author);
    ```
    
    in our interface.
    
    ![image.png](/images/Springboot/image%2049.png)
    

# Building first WebApplication with Spring Boot

- By default the tomcat is loaded on port 8080, but if we want to change that we have to write this in our application.propperties
    
    ```xml
    server.port=<new port ex 8081>
    ```
    

## HTML in Web App with Springboot

- If we want to use HTML in our web application then we can either hard-code it like this
    
    ![image.png](/images/Springboot/image%2050.png)
    
- But hardcoding HTML like this using StringBuilder, or StringBuffer is very hard, and could get complex since we would have to write a lot of things in our app.
- To make HTML simple in our web app with Spring boot we use Views.

### JSP: Java Server Pages

- JSP is one of the most popular view we use to create a html page for our web application
    
    ```xml
    While JSP was one of the most popular view technologies for Java web applications, its 
    popularity has significantly declined in favor of templating engines like Thymeleaf, 
    Freemarker, and Mustache, especially with Spring Boot. JSPs have some drawbacks 
    (e.g., compile-time errors only at runtime, harder to test, often require WAR deployment). 
    However, it's still possible to use them.
    ```
    
- We create a .jsp file (eg: sayHello.jsp), and then a method in the controller class redirects us to the jsp file when we go to its mapped method. This method returns a String of the name of the jsp file
    
    ```xml
    This describes the basic flow. A Spring @Controller method handles a request, performs some 
    logic, and then typically returns a String representing the view name (e.g., "sayHello"). 
    Spring's view resolver then resolves this view name to the actual JSP file.
    
    ```
    
- All the jsp files go into this specific folder:
    
    ```xml
    	/src/main/resources/META-INF/resources/WEB-INF/jsp/<name of your jsp file>.jsp
    ```
    
- Now if we have 1, or 10 jsp files in our web app, only the name of the jsp would differ and nothing else. So we store the constant part of the jsp file address in our application.properties. The spring MVC, already knows about /sec/resources/META-INF/resources, so we only need to specify /WEB-INF/jsp/<name of your jsp file>
- We do not use @ResponseBody with the method which returns a String of the name of our JSP file
- We use Spring MVC’s prefix and suffix for this:
    
    ```xml
    spring.mvc.view.prefix=/WEB-INF/jsp/
    spring.mvc.view.suffix=.jsp
    ```
    
- We also have to use this dependency in our pom.xml to use JSP in our WebApp:
    
    ```xml
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
    ```
    
- 
    
    ![image.png](/images/Springboot/image%2051.png)
    
    ![image.png](/images/Springboot/image%2052.png)
    
    ![image.png](/images/Springboot/image%2053.png)
    
    ![image.png](/images/Springboot/image%2054.png)
    

## @RequestParam & ModelMap

- Before understanding RequestParam, we have to understand Query Parameters.
- Most of the urls have a section which starts from ?, the text after this ? is called Query Parameter.
- This Query Parameter is nothing but the same webpage is loaded with a slight change in the url.
    
    ```xml
    Query parameters are used to pass dynamic data to a server, which can then alter the content 
    or behavior of the page being served without necessarily changing the base URL path.
    ```
    
- Now, if we want to make use of Query Parameter in our web app, we use @RequestParam in our method present in the controller.
- For eg: If we have a login page, and we have to display “Welcome to our website <name>!”, the constant url for the login page would be “localhost:8080/login” but the name has to be placed in the query parameter as
    
    ```xml
    localhost:8080/login?name=<name>
    ```
    
- We would have to use @RequestParam like tihs for the example
    
    ![image.png](/images/Springboot/image%2055.png)
    
    The name of the query parameter (here name) should be the same as the @RequestParam Parameter
    
- But our login.jsp, does not know about this parameter yet. And whenever we want to pass any value from our controller to our jsp file we make use of ModelMap.
- In this example the ModelMap would be used like this:
    
    ![image.png](/images/Springboot/image%2056.png)
    
    ![image.png](/images/Springboot/image%2057.png)
    
    ```xml
    This shows how to access the data stored in the ModelMap within a JSP using Expression Language 
    (EL) syntax ${key}. The JSP correctly retrieves the value associated with the key "name" from 
    the model
    ```
    
    ![image.png](/images/Springboot/image%2058.png)
    
- The ModelMap is somewhat similar to HashMap. Since we need to use the value present in controller in our jsp file, we use the method put(). The put() method takes two argument: 1. Key: generally string, it refers to the name of the key we would be using in our jsp file as well. 2. Object: it refers to the Request Parameter.
- In our jsp file, when we want to make use of anything coming from the controller we type
    
    ```xml
    ${<key>}
    ```
    

## Logger and LoggerFactory

- When you are developing a product it is not recommended to use print statements like System.out.println() to log information.
    
    ```xml
    This is a fundamental principle of professional software development. System.out.println() has 
    several drawbacks for logging in production applications:
    1. No control over log levels (e.g., INFO, DEBUG, ERROR).
    2. No configuration for output destinations (console, file, network, etc.).
    3. No formatting options (timestamps, thread info, class name).
    4. Performance overhead (especially for frequent calls).
    5. Cannot be easily turned off or configured in production.
    ```
    
- Hence we use Logger in our applications.
- We create an object of Logger, and initialise it with LoggerFactory.getLogger(getClass()).
- Here we are using SLF4j for the Logger Class
    
    ![image.png](/images/Springboot/image%2059.png)
    
    ![image.png](/images/Springboot/image%2060.png)
    
    ![image.png](/images/Springboot/image%2061.png)
    

## Dispatcher Servlet

- 
    
    ![image.png](/images/Springboot/image%2062.png)
    

- The Front Controller receives a http request from the browser.
    
    ```xml
    The Dispatcher Servlet acts as the single entry point for all incoming web requests that it is 
    configured to handle.
    ```
    
- It then processes the request. To process the request it uses the Spring MVC (Model View Controller).
- The first thing it identifies is, what is the url. Eg: /login for the login page
    
    ```xml
    It uses URL mapping (e.g., via @RequestMapping annotations) to determine which controller and 
    method should handle the request.
    ```
    
- So the first thing it identifies is the correct controller method for that url or request.
- Once identified, it then executes the controller method. Which returns the Model and View name.
- Now for the returned view name, the dispatcher servlet now searches for the correct view.
- To make sure that the correct view is searched, we specify the prefix and suffix for the view in our application.properties
- Logic: Prefix + View Name + Suffix. This logic is done in View Resolver
- Hence, Dispatcher Servlet uses View Resolver to search for the correct view
- It then executes the view, and returns http Response

## Creating a Login Form

- This is the general structure of an HTML form. But the issue with this is that it uses the GET method, which as we can see in the output, when we try to login our name and password is clearly visible as the Query Parameter.
    
    ![image.png](/images/Springboot/image%2063.png)
    
    ![image.png](/images/Springboot/image%2064.png)
    
- To check which request method is being used, we can always go to inspect and select docs from there:
    
    ![image.png](/images/Springboot/image%2065.png)
    
- To avoid our password to be visible we have to change the method from GET (default) to POST for the forms, like this:
    
    ![image.png](/images/Springboot/image%2066.png)
    
- Right now, when we enter our details, the same login webpage is again loaded. What we want is to check if the credentials are correct and if they are redirect or load the welcome page.
- First we would have to build a welcome view (jsp).
- The login page is being loaded when the method is both GET and POST. But, the request method is changed to post after we have submitted our credentials. So we want that when the request method is POST, we get redirected to welcome.jsp, and if the request method is GET we are on the login.jsp
- To achieve this, we specify the method in our RequestMapping to RequestMethod.GET for login method in our controller.
- Similarly, when we create a controller method for welcome, (we are going to use the same loginController but a different method) we would specify the method as RequestMethod=POST. The value (url) would be same, just the returned view name and the request method  would be different.
    
    ![image.png](/images/Springboot/image%2067.png)
    
    ![image.png](/images/Springboot/image%2068.png)
    
    ![image.png](/images/Springboot/image%2069.png)
    
- If we see in our inspect → network → docs → payload we can see the username, and password as the form details. We can use these data to authenticate that if the credentials are correct or not.
    
    ![image.png](/images/Springboot/image%2070.png)
    
- As we saw earlier, we can use @RequestParam to check for the Query Parameters. The @RequestParam is also useful to check the form data as well.
- We use @RequestParam to capture the form data like this:
    
    ![image.png](/images/Springboot/image%2071.png)
    
    ![image.png](/images/Springboot/image%2072.png)
    
    ![image.png](/images/Springboot/image%2073.png)
    

### Authentication in our Login Form

- Till now we have seen how to capture the data from the form, but we haven’t checked if the credentials are correct or not.
- For the authentication of the login form we have to store the signed up data, and hence we have to use a database in here.
- We want that if the name, and password in the form data is correct (or present in our database) then only we redirect to the welcome page
- For now, we would only create a single correct credentials where name-Abhiraj password-dummy (so for now we wont be creating a database)
- For the authentication we would have to create a new class named AuthenticationService (in the same package that of our login controller or else we would have to import it)
- 
    
    ![image.png](/images/Springboot/image%2074.png)
    
    ![image.png](/images/Springboot/image%2075.png)
    
    ![image.png](/images/Springboot/image%2076.png)
    
    The model.put(”errorMessage”,”Invalid Credentials”) is used so that when incorrect credentials are used and we are redirected to the login page the user can see why the welcome page was not visible
    

# Building a ToDo Webapp using SpringBoot

- This is the glimpse of the webapp we are going to make

![image.png](image/image%2077.png)

- We want to manage the description, the deadline, to check if its done or not. We also want to be able to update them, or delete them.
- First we want to create a class ToDo which would store the basic details about every task. This class would contain: ID - the id of the todo, username - who does this todo (task) belong to, description - the actual task information, targetDate - the deadline of the task, and done - to check whether the task is completed or not
    
    ![image.png](/images/Springboot/image%2078.png)
    
- Now we want to store our ToDos in a database (eg: H2, MySQL), but for now we would store them in a static List and then use database. To manage this list of todos we would create another class called TodoService
    
    ![image.png](/images/Springboot/image%2079.png)
    
- Now to view this in your browser you would need to create a controller and a view:
    
    ![image.png](/images/Springboot/image%2080.png)
    
    ![image.png](/images/Springboot/image%2081.png)
    
    ![image.png](/images/Springboot/image%2082.png)
    

## @SessionAttributes

- When we use ModelMap on an attribute in our webapp, then as soon as we move to a different view the value of attributes are removed.
- For eg, in our loginController we use ModelMap to put the value of name in our welcome view, if we add a link to our welcome view which directs us to the list-todos. Then the value of the name attribute would be lost as soon as we move from welcome view to list-todos view.
- To not let this happen, and retain the value of the attribute we use @SessionAttributes() on the controller class. And we specify the name of the attribute inside the parenthesis. We have to use @SessionAttributes over every controller in which we want the attribute to retain its value.
- 
    
    ![image.png](/images/Springboot/image%2083.png)
    
    ![image.png](/images/Springboot/image%2084.png)
    
    ![image.png](/images/Springboot/image%2085.png)
    
    ![image.png](/images/Springboot/image%2086.png)
    
    ![image.png](/images/Springboot/image%2087.png)
    
    ![image.png](/images/Springboot/image%2088.png)
    
- 
    
    ![image.png](/images/Springboot/image%2089.png)
    

## JSTL

- The expression language which we have been using in our view for displaying the dynamic data (eg: name, todos) are only used for simple datas.
- But we have to display some complex data in our application most of the times, and for that we have to use JSTL: JavaServer Pages Standard Tag Library
- If we want to use JSTL in our application, then we have to use these 2 dependencies:
    
    ```xml
    <dependency>
    			<groupId>jakarta.servlet.jsp.jstl</groupId>
    			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    </dependency>
    ```
    
    ```xml
    <dependency>
    			<groupId>org.glassfish.web</groupId>
    			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
    </dependency>
    ```
    
- We also need to import the JSTL in the view in which we would be making use of it. To import the JSTL in our view, we have to write this at the top of our view:
    
    ```xml
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    ```
    
- We have to specify the prefix as ‘c’ to use the JSTL tags in our view. [Here](https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html) are some of the examples of our JSTL tags
    
    ![image.png](/images/Springboot/image%2090.png)
    
- So if we want to use the forEach tag, we have to write
    
    ```xml
    <c:forEach></c:forEach>
    ```
    
- Here we have created a table for our todos list:
    
    ![image.png](/images/Springboot/image%2091.png)
    
    ![image.png](/images/Springboot/image%2092.png)
    

## Adding Bootstrap using WebJars

- Earlier we had to manually install the bootstrap in the static folder of our resources. But now it is handled by webjars.
- We have to make use of 2 dependencies: 1 for bootstrap, and 1 for jquery
    
    ```xml
    <dependency>
    	<groupId>org.webjars</groupId>
    	<artifactId>bootstrap</artifactId>
    	<version>5.1.3</version>
    </dependency>
     
    <dependency>
    	<groupId>org.webjars</groupId>
    	<artifactId>jquery</artifactId>
    	<version>3.6.0</version>
    </dependency>
    ```
    
- Then we have to copy and store the qualified name of: bootstrap-min.css, bootstrap-min.js, and jquery-min.js
    
    ![image.png](/images/Springboot/image%2093.png)
    
    ```xml
    /META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css
    /META-INF/resources/webjars/bootstrap/5.1.3/js/bootstrap.min.js
    /META-INF/resources/webjars/jquery/3.6.0/jquery.min.js
    ```
    
- Since we are making use of Webjars, we do not need to specify /META-INF/resources/
    
    ```xml
    webjars/bootstrap/5.1.3/css/bootstrap.min.css
    webjars/bootstrap/5.1.3/js/bootstrap.min.js
    webjars/jquery/3.6.0/jquery.min.js
    ```
    
- Now, we have to add the bootstrap in our views.
    1. Adding bootstrap-min.css : We add the css file just inside the head 
        
        ```xml
        webjars/bootstrap/5.1.3/css/bootstrap.min.css
        ```
        
        ![image.png](/images/Springboot
/image%2094.png)
        
    2. Adding bootstrap-min.js & jquery.js : We add the js file just before closing our body tag 
        
        ```xml
        	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        ```
        
        ![image.png](/images/Springboot
/image%2095.png)
        

### Formatting JSP with Bootstrap

- It is recommended that we put all of the content of the body inside a div with class container
    
    ![image.png](/images/Springboot/image%2096.png)
    
- Bootstrap provides a class for tables called “table”
    
    ![image.png](/images/Springboot/image%2097.png)
    
    ![image.png](/images/Springboot/image%2098.png)
    

## Adding a functionality of Adding a new Todo

- What we want is to add a button in our list-todos page, which if clicked we would be redirected to another view which would ask us about the information of this new todo
    
    ![image.png](/images/Springboot/image%2099.png)
    
    ![image.png](/images/Springboot/image%20100.png)
    
- Now we would have to create a new method which would redirect us to this todo.jsp view when we click the button, in our todoController
    
    ![image.png](/images/Springboot/image%20101.png)
    
- Now when we click the submit button, it would give us an error as we haven’t handled the view for the page with POST method. For this we want to be redirected to our list-todos page back, and we can do that by creating a method with the return value as “redirect:list-todos” (list-todos is the url here and not the name of the view)
    
    ![image.png](/images/Springboot/image%20102.png)
    
- But even now, the new todo we add isn’t visible in our table, and to do that we would have to make a new method in our TodoService
    
    ![image.png](/images/Springboot/image%20103.png)
    
    ![image.png](/images/Springboot/image%20104.png)
    
- Here even if we try to add a todo without any description (blank character) it would be added in our table. So we need to validate that the description coming is correct or not.
- One of the method is to use the front-end validation. In this case we can use required attribute in our form, like this
    
    ![image.png](/images/Springboot/image%20105.png)
    
    ![image.png](/images/Springboot/image%20106.png)
    
- But these front end validations can easily be overcome or broken by hackers. Hence it is recommended to use the server side validations

## Validations in Spring Boot

- Spring boot makes it very easy to add validation in our application.
- There are 4 steps involved:
    1. Adding Spring Boot Starter Validation in our pom.xml
    2. Using the concept of Command Bean (or Form Backing Object). Implementing 2-way binding between todo.jsp & TodoController.java
    3. Adding Validation to our bean (Todo.java)
    4. Display Validation Errors in the view
    
    ![image.png](/images/Springboot/image%20107.png)
    
- Adding Spring boot starter Validation: We would have to add this dependency
    
    ```xml
    	<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-validation</artifactId>
    	</dependency>
    	
    ```
    
- Currently we are binding the description value which would be typed in the todo view to the addNewTodo() method using @RequestParam. What we are going to do is that we would bind the value of description directly to the bean or the [Todo.java](http://Todo.java) class.
We do this because, if we have 10 fields in our form then we would have to use 10 @RequestParam in our method, which would make the code much more complex. This is the concept of the Command Bean or Form Backing Bean
- Now the very first step would be to remove the @RequestParam from our addNewTodo() method, and make the ModelMap as the first parameter.
    
    ![image.png](/images/Springboot/image%20108.png)
    
- Now, pass the bean as parameter (object of Todo class)
    
    ![image.png](/images/Springboot/image%20109.png)
    
- Now we want to use this todo bean in our todo.jsp as well. To configure a form backing object in jsp we have to make use of Spring Form Tag Libraries. [Here](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/view.html) We would have to add this in our jsp file:
    
    ```xml
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    ```
    
- After importing the spring form library we can make use of tags using form as prefix. 
Firstly we would have to change the <form> tag to <form:form> in our jsp
    
    ![image.png](/images/Springboot/image%20110.png)
    
    Now, we want to bind this form to our todo bean (the parameter in the addNewTodo()). To do that we can use modelAttribute(”<name of the bean>”) attribute in the form:form tag 
    
    ![image.png](/images/Springboot/image%20111.png)
    
    Now, we also need to bind the description from the bean, and the form together. To that we could make use of <form:input> tag where we would change the name attribute with path 
    
    ![image.png](/images/Springboot/image%20112.png)
    
    Now, even if we have use the todo bean in our addNewTodo() method, the showNewTodoPage() is actuallly being loaded whenever we want to add a new todo. So we would have to create an instance of Todo in that method, and hardcode some attributes. These attributes would be now used as default attributes value for our bean  
    
    ![image.png](/images/Springboot/image%20113.png)
    
    Now, even if the view of adding new todo is loaded. When we try to add a new todo with description we find some errors. Here it says, that the value of Id, and done was null
    
    ![image.png](/images/Springboot/image%20114.png)
    
    ![image.png](/images/Springboot/image%20115.png)
    
    For now, we would create a hidden variable in our form for id, and done. And now we are able to add our todos 
    
    ![image.png](/images/Springboot/image%20116.png)
    
    ![image.png](/images/Springboot/image%20117.png)
    

### Adding Validations (Step-3 & 4)

- After we have implemented 2-way binding using command beans, we have multiple annotations which we can use in our bean (Todo.java) to add validations.
- For eg: if we want to set a minimum length for our description field then we can use @Size(min=<integer value>) above the declaration of the description field in our [Todo.java](http://Todo.java) class
    
    ![image.png](/images/Springboot/image%20118.png)
    
    If we also use message=<String value>, then if the characters are less than 10 then the message would be displayed.
    
- If we expand the Maven Dependencies directory, and look inside jakarata.validation-api-3.0.2.jar, then you can find multiple other validation annotations.

![image.png](image/image%20119.png)

- We also need to use the annotation @Valid in the controller method where we are binding the field (description for now) to our bean (which is required to check the validation). Here the addNewTodo() method is the one.
    
    ![image.png](/images/Springboot/image%20120.png)
    
    Now if we try to add anything in the description field which is less than 10 characters, then we would see an error page. And there would be the error message which we specified in the @Size(message=<>) field
    
    ![image.png](/images/Springboot/image%20121.png)
    
- But we do not want that whenever the validation is incorrect the user is redirected to an error page. We want that the error message we have specified is displayed beside the element. To implement this we would need an object of the class BindingResult in our post method or the method which is binding our bean to the view (addNewTodo).
    
    ![image.png](/images/Springboot/image%20122.png)
    
- But it would still not show the error message. For the error message to be visible when the validation is not correct, we would need to use <form:errors path=”<path of the element>”> in our view like this
    
    ![image.png](/images/Springboot/image%20123.png)
    
- Now if we try to add anything in our table with description of less than 10 characters
    
    ![image.png](/images/Springboot/image%20124.png)
    
- Since now we are making use of spring forms instead of html forms (since we used command beans for 2-way binding) if we want to use any class in our forms we need to use cssClass and not just class
    
    ![image.png](/images/Springboot/image%20125.png)
    
    ![image.png](/images/Springboot/image%20126.png)
    

## Implementing Deleting Todo

- Right now we do not have any button to delete or update todos in our list-todos page
    
    ![image.png](/images/Springboot/image%20127.png)
    
    So we would start by adding a button for deleting a todo.
    
    ![image.png](/images/Springboot/image%20128.png)
    
    ![image.png](/images/Springboot/image%20129.png)
    
- Now to use the id to delete the todo, we could use Query Parameters like this
    
    ![image.png](/images/Springboot/image%20130.png)
    
- Now we can just create a method in our controller class which would redirect us back to the list-todos page but after the todo is deleted. To apply the delete logic, we would need to create a method in our service class where the list of our todos is created, and delete the todo with the specific id.
    
    ![image.png](/images/Springboot/image%20131.png)
    
    ![image.png](/images/Springboot/image%20132.png)
    
    Now, when we click the delete button infront of any todo, it gets deleted
    
    ![image.png](/images/Springboot/image%20133.png)
    

## Implementing Update Todo

- We again want to add a new button for updating a todo.
- After creating the update button, we would need 2 more things.
    1. Redirecting to the update-todo page. We did not add a new view while implementing delete feature because we did not required anything from the user. But, in update feature just like add todo, we need to take inputs from user and hence we would need a separate view for it.
    2. Adding the functionality to update the todo. Just like in add todo we made a new method in our service class, we would need to do the same here. 

 

- Instead of creating a new Update Page, we can use the todo.jsp we used in add implementation. Because it is a generic view which can be used for multiple things. So, we need to create a method in our controller which would be mapped to “update-todo” link, and would redirect us to todo.jsp Here we also need to create a method called findById() in our service class which would help us to initialise the todo bean in our controller class for the 2-way binding
    
    ![image.png](/images/Springboot/image%20134.png)
    
    ![image.png](/images/Springboot/image%20135.png)
    

- Now, we can add the implementation logic behind the update todo. We would need to create another method in our service class which would be used to change or update the values in the existing todo.
    
    ![image.png](/images/Springboot/image%20136.png)
    
- We would also need a method in our controller class which would be handling the POST method, and would redirect us to list-todos with the updated values. At all times we have to remember that we have already did the 2-way binding of our controller and the bean.
    
    ![Screenshot 2025-07-16 121948.png](/images/Springboot/Screenshot_2025-07-16_121948.png)
    
- Now when we click our update button, we would be redirected to the todo.jsp
    
    ![image.png](/images/Springboot/image%20137.png)
    
    ![image.png](/images/Springboot/image%20138.png)
    
    And, when we change the description and press submit, we would be redirected to the list-todos page with the updated values
    
    ![image.png](/images/Springboot/image%20139.png)
    
    ![image.png](/images/Springboot/image%20140.png)
    

## Adding Target Date Field to Todo Page

- We would have to create a date field in the todo.jsp just as we did for the description
    
    ![image.png](/images/Springboot/image%20141.png)
    
- Also since we were hardcoding the default value in our add implementation, we would have to change it as well
    
    ![image.png](/images/Springboot/image%20142.png)
    
- If we want to change the format of date in our application, then we would have to write this in our [application.properties](http://application.properties)
    
    ```xml
    spring.mvc.format.date= yyyy-MM-dd
    ```
    
    ![image.png](/images/Springboot/image%20143.png)
    
- Till now, we were using the type=”date” offered by html forms to specify the date datatype in our views. But it is better to make use of Bootstrap datepicker in our applications.
- To add Bootstrap datepicker in our application we would need to include this dependency
    
    ```xml
    		<dependency>
    			<groupId>org.webjars</groupId>
    			<artifactId>bootstrap-datepicker</artifactId>
    			<version>1.10.0</version>
    		</dependency>
    ```
    
- After downloading this dependency, as we did for bootstrap, we would have to copy their qualified names for css and js, and include them in our views in which we want to use them.
    
    ![image.png](/images/Springboot/image%20144.png)
    
    ![image.png](/images/Springboot/image%20145.png)
    
- There are multiple ways in which you can use bootstrap datepicker, and to check for all the ways you can visit [here](https://bootstrap-datepicker.readthedocs.io/en/latest/). For now we would be using this:
    
    ![image.png](/images/Springboot/image%20146.png)
    
    But we have to keep in mind that ‘.datepicker’ is not the class of our date field. The id of our date field is targetDate, so we would have to change it, and add it in our view like this 
    
    ![Screenshot 2025-07-16 154134.png](/images/Springboot/Screenshot_2025-07-16_154134.png)
    
    Notice that we have also change the type of our <form:input> tag to text so that the bootstrap styling can be applied. 
    
    ![image.png](/images/Springboot/image%20147.png)
    

## Adding Navigation bar and Implementing JSP Fragments

### Adding Navigation Bar

- (Writing everything about Navigation bar here would be waste as we have already covered it in HTML notes, so here is the exact code we would be using in this application)
    
    ```html
    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
    	<a class="navbar-brand m-1" href="https://www.linkedin.com/in/abhiraj07/">Todo List Application</a>
    	<div class="collapse navbar-collapse">
    		<ul class="navbar-nav">
    			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
    			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
    		</ul>
    	</div>
    	<ul class="navbar-nav">
    		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    	</ul>	
    </nav>
    ```
    
    ![image.png](/images/Springboot/image%20148.png)
    
    For now the home, and logout button would endup in an error page as we haven’t assigned or specified the functions or views for them.
    
- We would have to copy this navigation bar code snippet in every view if we want to have it there. This makes our code very repetitive and hard to manage. To avoid this JSP Fragments are used.

### JSP Fragments

- JSP Fragments are very useful as it helps in code reusability, and makes it easy to maintain.
- In our listTodos.jsp and todo.jsp we would want to reduce the code duplication and hence we would create a new folder inside jsp named common. Inside this common folder we would create 3 files header.jspf footer.jspf and navigation.jspf
    
    ![image.png](/images/Springboot/image%20149.png)
    
- Now we can save the duplicated code in header, footer, and navigation in header.jspf, footer.jspf and navigation.jspf respectively and can then include them in our view.
- For eg: We can just write the navigation bar code snippet in navigation.jspf and then include the jspf in our listTodos.jsp and todo.jsp like this
    
    ```html
    <%@ include file="common/navigation.jspf"%>
    ```
    
    ![image.png](/images/Springboot/image%20150.png)
    
    ![image.png](/images/Springboot/image%20151.png)
    
    ![image.png](/images/Springboot/image%20152.png)
    
- Similarly we can add the duplicate code from header and footer in their respective jspf files
    
    ![image.png](/images/Springboot/image%20153.png)
    
    ![image.png](/images/Springboot/image%20154.png)
    
    ![image.png](/images/Springboot/image%20155.png)
    
    ![image.png](/images/Springboot/image%20156.png)
    

## Spring Security

- Spring Security is a very useful framework which makes it very easy to add Authentication in our application.
- When we use Spring Security in our application we do not need to worry about Login and its logic as it is handled by Spring Security.
- In our application, we have wrote a lot of login logic and now we would have to change it
    
    ![image.png](/images/Springboot/image%20157.png)
    
    This is all we need in our root url when we use Spring Security (For now we have hardcoded the name but it would be resolved when we would start using Spring Security). And now even the Home button on our navigation bar would work, because we have specified the url for “/” 
    
    ![image.png](/images/Springboot/image%20158.png)
    
    We don’t need login.jsp and [AuthenticationService.java](http://AuthenticationService.java) now, and now the name of the method should be gotoWelcomePage(), and the controller should be named WelcomeController
    
- To add Spring Security in your project you need to add this dependency in your pom.xml
    
    ```xml
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-security</artifactId>
    		</dependency>
    
    ```
    
- After adding Spring Security, when you would start or run your application you would see some changes in your console
    
    ![image.png](/images/Springboot/image%20159.png)
    
- And now when you would reload your webpage it would directly go to login
    
    ![image.png](/images/Springboot/image%20160.png)
    
    Even if you try to go to any other url like “add-todo” “list-todo” it wouldn’t allow you to before you login. 
    
    The username is user, and password is what was generated in the console.
    
- To make the password static we can either create a custom User and password, or we can write this in our [application.properties](http://application.properties)
    
    ```xml
    spring.security.user.name=username
    spring.security.user.password=password
    ```
    

### Adding Custom Users and Passwords

- Right now, whenever we restart the application the password is changed. We want to create custom users and passwords for our applications.
- Firstly we would create a class SpringSecurityConfiguration and use @Configuration over it, as we would be configuring spring beans directly into it, and then returning them.
    
    ![image.png](/images/Springboot/image%20161.png)
    
- Generally, we use LDAP or atleast a Database to configure the userIds. But for the simplicity we would be using InMemoryUserDetailsManager (or simply InMemory Configuration for now)
- The InMemoryUserDetailsManager uses an interface UserDetails to store and manage the details of a user. Since it is an interface, we cannot directly instantiate it in our application and would have to use a builder. User is a builder class which is used for this exact same thing.
    
    ![image.png](/images/Springboot/image%20162.png)
    
    Here, we have created a custom user with the userName “Abhiraj” and password “Abhiraj@07”, and also specified their roles. 
    
- Instead of using withDefaultPasswordEncoder() which is not suggested, we would now create our own custom passwordEncoder bean.
    
    ![image.png](/images/Springboot/image%20163.png)
    
    Here, we are making use of BCryptPasswordEncoder() which is an implementation of PasswordEncoder, and uses strong hashing functions to protect our passwords. 
    

- 
    
    ![image.png](/images/Springboot/image%20164.png)
    
    1. Line-19: This is a lambda function which takes String as input and gives String as output, and the name of the lambda function is passwordEncoder. It takes “input” as input, and returns it after encoding using our passwordEncoder() function.
    2. Line 21-29: This is the same previous bean we were using. The changes are that instead of using withDefaultPasswordEncoder() we are now using builder() to encode our passwordEncoder(). The passwordEncoder passed as an argument in line-22 is the lambda function created at line-19.
    
      
    

### Removing Hardcode and Refactoring

- Right now, we can see that our welcomeController has the name “Abhiraj” hardcoded into it. But what we need is to use the name which was used while logging in
    
    ![image.png](/images/Springboot/image%20165.png)
    
- For this we can create a new method in the controller, and use SecurityContextHolder()
    
    ![image.png](/images/Springboot/image%20166.png)
    
    We can do the same in our TodoController, or anyother class which has hardcoded data.
    

### Adding a new User

- We configure all of our user in our SpringSecurityConfiguration class. Here we have refracted the code so it is easy to create a new user
    
    ![image.png](/images/Springboot/image%20167.png)
    

## Adding JPA and H2 in our application

- Until now we have been using a static list to store all of our todos. But in real world applications, we have to use a database like MySQL, or H2, or any other. Here we would shift our application from static list to H2 database.
- But just adding H2 and JPA dependencies won’t be enough to access the database. The spring security needs to be configured for it.

### Configuring Spring Security for H2 Database

- Right now the spring security is configuring 2 things:
    - All the URLs are protected. This means that whenever we go to any url we are redirected directly to the login form.
    - A login form is shown for unauthorized requests.
- What we want to do is disable CSRF **Cross-Site Request Forgery**
- H2 database also uses something called frames, but Spring Security by default do not allow frames in them.
- We are configuring the security so we would be using the SpringSecurityConfiguration class. And the thing we are configuring here is called SecurityFilterChain
- We should know that, whenever we are redefining the SecurityFilterChain we always have to consider the above 2 listed configurations again. And after that we can change whatever we want.
    
    ![image.png](/images/Springboot/image%20168.png)
    
    ```java
    	@Bean
    	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    		http.authorizeHttpRequests(
    				auth -> auth.anyRequest().authenticated()				//This re-configures the first configuration that all the urls are protected
    				);
    		
    		http.formLogin(withDefaults());		//This makes the login form visible
    		
    		return http.build();	
    	}
    
    ```
    
    ```java
    //You Also need to static import the withDefaults() method using this
    
    import static org.springframework.security.config.Customizer.withDefaults;
    
    ```
    
- Now, we need to disable csrf, and x-forms
    
    ![image.png](/images/Springboot/image%20169.png)
    
- And now, when we go to localhot:8080/h2-console we can connect to our database

### Connecting our Application to H2 using JPA

- Now, we can use @Entity to connect our Todo bean to a table named Todo in our database.
- One of the main advantage of using Spring JPA is, that if we use @Entity over a bean (Todo class here) then a table would automatically be created in our database for that entity.
    
    ![image.png](/images/Springboot/image%20170.png)
    
    ![image.png](/images/Springboot/image%20171.png)
    

- Now we can create a file named data.sql in the main/resource folder to populate some data. The queries present in this sql file will be executed everytime the application starts.
- Generally, the sql queries are executed before the entities are created. This could lead to error since we could have been writing an insert query but there won’t be any table. To change this we have to write this in our [application.properties](http://application.properties)
    
    ```xml
    spring.jpa.defer-datasource-initialization=true
    ```
    
    ![image.png](/images/Springboot/image%20172.png)
    
    ![image.png](/images/Springboot/image%20173.png)
    

- One thing you have to remember is H2 is an in-memory database, and everytime you restart the application the data is lost.

### Connecting List-todos page with JPA and H2

- Now we just need to make a repository interface named TodoRepository, which extends JpaRepository. And for now we  would create a copy of the TodoController, and name it TodoControllerJpa so that we can go back to the controller which works with Lists. In the TodoControllerJpa we would create an instance of TodoRepository, autowire it using constructor injection. Then we would create a method findByUsername() in repository so that we can use it to display all the Todos which are present in the database regarding the username.
    
    ![image.png](/images/Springboot/image%20174.png)
    
    ![image.png](/images/Springboot/image%20175.png)
    
    We would also need to create a default constructor for our Todo bean, so that H2 can use it without any errors.
    
    ![image.png](/images/Springboot/image%20176.png)
    

### Connecting All Todo App Features to H2 Database

- In addTodo we just need to populate the todo bean (which we created during 2-way binding), and use the save() method provided by Spring Data JPA
    
    ![image.png](/images/Springboot/image%20177.png)
    
- In the deleteTodo we just need to change the method being called from todoService to todoRepository as Spring Data JPA provides a method called deleteById() (which is primary key in this entity)
    
    ![image.png](/images/Springboot/image%20178.png)
    
- In the updateTodo we need to change 2 methods. First would be the showUpdateTodoPage() which redirects us to todo.jsp view, in which we have set the default values (the pre-entered values). We can use the findById() method provided by Spring Data JPA
    
    ![image.png](/images/Springboot/image%20179.png)
    
    After this, we also need to make changes in the updateTodoById() method, where we just need to populate the todo bean and use the save() method again 
    
    ![image.png](/images/Springboot/image%20180.png)
    

## Connecting Our Application to MySQL Database

- H2 database is an in-memory database, which means that everytime you restart the application the data you saved in the previous iteration is deleted. Hence, it is good for learning but not good for production.
- Right now we would be using MySQL in Docker. To launch MySQL from docker we need to run this command in cmd
    
    ```xml
    docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
    ```
    
    ![image.png](/images/Springboot/image%20181.png)
    
- Now, since we are using H2 right now, we would have to delete its dependencies from pom.xml
- Then we would need to download the MySQL dependencies using these dependencies
    
    ```xml
    		<dependency>
    			<groupId>com.mysql</groupId>
    			<artifactId>mysql-connector-j</artifactId>
    		</dependency>
    
    ```
    
- We also need to specify the url for mysql in [application.properties](http://application.properties)
    
    ```xml
    spring.datasource.url=jdbc:mysql://localhost:<port-where-mysql-is-running>/<name-of-database>
    spring.datasource.username=<username>
    spring.datasource.password=<user-password>
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    
    spring.jpa.hibernate.ddl-auto=update 
    
    ```
    
    The port, name of the database, username, and userpassword are specified in the docker command which was used to run MySQL
    
    ![Screenshot 2025-07-18 122308.png](/images/Springboot/Screenshot_2025-07-18_122308.png)
    
- You don’t need to change any other java code, as we were using Spring Data JPA while writing java code which was connected to H2 database. We have now connected to MySQL using Spring Data JPA as well.
    
    ```xml
    JPA provides an abstraction layer over the underlying database. As long as you configure the 
    correct data source (URL, username, password, and dialect) in application.properties and have 
    the appropriate JDBC driver (MySQL Connector/J in this case), your JPA entities and 
    Spring Data JPA repositories can seamlessly switch between different relational databases 
    (H2, MySQL, PostgreSQL, etc.) without requiring changes to the core Java code for data access.
    ```
    

# Building a Simple Rest-API with SpringBoot

- Whenever we talk about Rest-APIs we are mostly talking about json response and json requests.
- Instead of using @RequestMapping() we can also use @GetMapping() for the functions which are mapped to the url whose method is GET. Similar to this, we have @PostMapping() and other method mapping as well. This makes the code more readable
    
    ![image.png](/images/Springboot/image%20182.png)
    
- @PathVariable is used to add Path Parameter in your SpringBoot Application. Like when we want to capture the query parameters from the URL we make use of @RequestParam, here when we want to capture the dynamic parameters from the URI (also called Path Parameters) we make use of @PathVariable
    
    ![image.png](/images/Springboot/image%20183.png)
    
    ![image.png](/images/Springboot/image%20184.png)
    

# Building A Social Media Application REST API

- We would be creating 2 REST APIs: Users and Posts. Both of them would have the basic CRUD operations.
    
    ![image.png](/images/Springboot/image%20185.png)
    
- To let our REST API perform some functions, like create or update or anything else, we use Request Methods
    
    ![image.png](/images/Springboot/image%20186.png)
    
- We would first create a Users REST API, and then we would create the Post REST API since every post would be done by a user so the post rest api should be connected to user rest api
    
    ![image.png](/images/Springboot/image%20187.png)
    

## User REST API

- For every user we want to store id, name, and birthdate.
- So we would create a user bean (class).
    
    ![image.png](/images/Springboot/image%20188.png)
    
- Now we want to perform a lot of operation by this user bean, like saving it, updating it, deleting it, etc. in a database. And to perform all these operation with something which is present in a database we would create a DAO Object (Data Access Object)
- We would create a new class UserDaoService. And we would define the functions which would display all the users, save a user, and find a specific user. Now as we mentioned, DAO is used to perform operations over data present in database. But for now, for simplicity, we would create a static list and perform all the operations over it. Then later we would change it to work with a database.
- We would also create a UserResource class, which would be the @RestController for the User bean.
- This is how we would implement the findAll() method which would be used to display or retrieve all the users
    
    ![image.png](/images/Springboot/image%20189.png)
    
    ![image.png](/images/Springboot/image%20190.png)
    
- This is how we would implement the findOne() method which would be used to display or retrieve the users by id
    
    ![Screenshot 2025-07-18 165340.png](/images/Springboot/Screenshot_2025-07-18_165340.png)
    
    ![image.png](/images/Springboot/image%20191.png)
    
- This is how you could implement the save() method, which is the method to add a new user in your REST API
    
    ![image.png](/images/Springboot/image%20192.png)
    
    ![image.png](/images/Springboot/image%20193.png)
    
    Since we are updating our List, we have to use the POST method here. But we cannot directly execute POST request from the browser. To execute a POST request, you have to use something called REST-API Client to make the POST request.
    
    One of the simplest Rest Api clients is [Talend Api Tester](https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=en), so we would have to download it and use it to test our POST requests. 
    
    ![image.png](/images/Springboot/image%20194.png)
    

Now if we want to check if our POST method is working, we need to go to the specified URL, and pass some Body (since we are adding a user here so a User details would be passed in the json format in the body)

![image.png](image/image%20195.png)

And now, when we go back to [localhost:8080/users](http://localhost:8080/users) the xyz user would be visible 

![image.png](image/image%20196.png)

### Response Status for REST API

- 
    
    ![image.png](/images/Springboot/image%20197.png)
    
- The correct Response Status when an object is created is 201, but when we are adding a user using our POST method, the response status which is being returned is 200. And it is very important to always return a correct Response status, as it helps in management and debuggin of code.
- To change the Response Status, we would have to use ResponseEntity class, and since we are creating a user here so we should use the create() builder, and since we want to return a ResponseEntity<Object> we have to use build() to build the object. Like this
    
    ![image.png](/images/Springboot/image%20198.png)
    
    And now, when we create a user we would get 201 as response status 
    
    ![image.png](/images/Springboot/image%20199.png)
    
- It is also possible to return the URI of the user we have just created, as we are using null in the create() builder. The create() builder accepts a URI location as input. The URI for the new user would be “/user/{id}”. We can pick “/user” from the url, append “/{id}” to it. And then change {id} with user.getId().
    - We can pick the url using the ServletUriComponentsBuilder class, and fromCurrentRequest() method
    - Now, we want to add a path /{id} to it, and it can be done using the path() method
    - And at last we want to replace the /{id}, with getId() method. For this we have to store the service.save() in a local variable, and then pass it in the buildAndExpand() method like save.getId()
    - And just use the toUri() method to convert it to uri.
    
    ![image.png](/images/Springboot/image%20200.png)
    
    And now, when we post something the location would be the URI of the new user just created 
    
    ![image.png](/images/Springboot/image%20201.png)
    

### Implementing Exceptional Handling - 404 Resource not found

- Right now, when we want to find a specific user which does not exists, we get a blank screen in return. And if we check in exception we would see that the response status it is returning is 200 and not 404.
    
    ![image.png](/images/Springboot/image%20202.png)
    
- To change this, we should create a class named UserNotFoundException, which extends RuntimeException. And add a condition in our retrieveUser() method that if we get null then throw UserNotFoundException.
    - Also, this still wouldn’t return 404 status, and would return 500. To make it return 404, you have to use @ResponseStatus(code=HttpStatus.NOT_FOUND)
    
    ![image.png](/images/Springboot/image%20203.png)
    

![image.png](image/image%20204.png)

![image.png](image/image%20205.png)

### Creating custom error structure

- When we changed the response status to 404, we saw that in the body section there was a proper structure which was followed to provide information about the error. But sometimes we do have a different structure which we have to follow, so we have to change the structure of the error.
- For eg: we would want a structure which has timestamp, message, and details. So we would create a new bean ErrorDetails (class)
    
    ![image.png](/images/Springboot/image%20206.png)
    
- Now, we want to use this format whenever we get an error. For that we would have to create another bean CustomizedResponseEntityExceptionHandler which extends ResponseEntityExceptionHandler, and override the method handleAllExceptions()
    
    ![image.png](/images/Springboot/image%20207.png)
    
    You can get the function signature by visiting the ResponseEntityExceptionHandler and searching for handleAllExceptions. Also we have to use @ExceptionHandler() here and since we are making the current structure as the structure for all types of exceptions we have passed the entire Exception class in the annotation 
    
    ![image.png](/images/Springboot/image%20208.png)
    
    ![image.png](/images/Springboot/image%20209.png)
    
    Now we would have to change the fact that when the user is not found we are giving off response status 500 instead of 404. So we can make use of our custom class UserNotFoundException for this 
    
    ![image.png](/images/Springboot/image%20210.png)
    
    ![image.png](/images/Springboot/image%20211.png)
    

### Implementing Delete User

- 
    
    ![image.png](/images/Springboot/image%20212.png)
    
    ![image.png](/images/Springboot/image%20213.png)
    

### Implementing Validation for REST API

- Right now, even if we create a user, using our post method, with a blank username and a future birthdate it would accept the user. To change this we have to add Validation in our REST API
- (I have by mistake used @FutureOrPresent instead of @Past for birthdate change it)
    
    ![image.png](/images/Springboot/image%20214.png)
    
    ![image.png](/images/Springboot/image%20215.png)
    
    ![image.png](/images/Springboot/image%20216.png)
    
- But here, the consumer cannot see what the error is. To change this we have to override handleMethodArgumentNotValid() method in CustomizedResponseEntityExceptionHandler, with our structure and define some message value in our validation in the User bean
    
    ![image.png](/images/Springboot/image%20217.png)
    
    ![image.png](/images/Springboot/image%20218.png)
    
    ![image.png](/images/Springboot/image%20219.png)
    

### REST API Documentation

- 
    
    ![image.png](/images/Springboot/image%20220.png)
    
- Swagger and Open API are used to generate documentation from code
    
    ![image.png](/images/Springboot/image%20221.png)
    
- The library which is used to automate the generation of our api documentation is called Springdoc-openapi
- Currently the Springdoc-openapi v2 is the one which works with Springboot v3 so we are going to add this dependency in our pom.xml
    
    ```xml
       <dependency>
          <groupId>org.springdoc</groupId>
          <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
          <version>2.8.9</version>
       </dependency>
    
    ```
    
    You can visit [here](https://springdoc.org/), to check if the springdoc-openapi version is available to work with your springboot version 
    
- Now when we go to [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) we can see that the documentation is ready for our api
    
    ![image.png](/images/Springboot/image%20222.png)
    
    And if we click [/v3/api-docs](http://localhost:8080/v3/api-docs) then it would take us to the Openapi specification for our rest api 
    
    ![image.png](/images/Springboot/image%20223.png)
    

### Content Negotiation

- 
    
    ![image.png](/images/Springboot/image%20224.png)
    
- To add Accept Header in our REST API, we would need to add this dependency
    
    ```xml
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
        </dependency>
    ```
    
- After adding the accept header, if we go to our API tester, and add a header accept with the name application/xml then we would get an xml output
    
    ![image.png](/images/Springboot/image%20225.png)
    

### Internationalization - i18n

- 
    
    ![image.png](/images/Springboot/image%20226.png)
    
- To check for the language we only need to look at the accept-language header, and then our content should be in that language.
- The first step is to define the language and their codes (en, fr, nl needs to be defined)
- The second step is to write the code to pick those value up
- We would have to create a file named “messages.properties” in the src/main/resources folder. The name of the file should be the same, and the location should be where [application.properties](http://application.properties) is present for the default language (generally English). And messages_fr.properties for French and similarly for other languages.
- After creating the [messages.properties](http://messages.properties) files we would have to create an object (bean) of MessageSource interface, as it would help us to pick the correct properties file for the language by checking the accept-language header.
    
    ![image.png](/images/Springboot/image%20227.png)
    
    ![image.png](/images/Springboot/image%20228.png)
    
    ![image.png](/images/Springboot/image%20229.png)
    
    ![image.png](/images/Springboot/image%20230.png)
    
    ![image.png](/images/Springboot/image%20231.png)
    
    The getMessage() method requires 4 parameters, first is the code for which we have to look for, second is use to pass some variables if there are any in our message, third is the default message, and the last is the locale which is used to get the header and check for the language or [messages.properties](http://messages.properties) file
    

### Versioning REST API

- 
    
    ![image.png](/images/Springboot/image%20232.png)
    
- URL Versioning: Twitter
    
    ![image.png](/images/Springboot/image%20233.png)
    
    ![image.png](/images/Springboot/image%20234.png)
    
    ![image.png](/images/Springboot/image%20235.png)
    
    ![image.png](/images/Springboot/image%20236.png)
    
    ![image.png](/images/Springboot/image%20237.png)
    
    ![image.png](/images/Springboot/image%20238.png)
    

- Request Param Versioning: Amazon
    
    ![image.png](/images/Springboot/image%20239.png)
    
    ![image.png](/images/Springboot/image%20240.png)
    
    ![image.png](/images/Springboot/image%20241.png)
    

- Custom Headers Versioning: Microsoft
    
    ![image.png](/images/Springboot/image%20242.png)
    
    ![image.png](/images/Springboot/image%20243.png)
    
    ![image.png](/images/Springboot/image%20244.png)
    
    We can use anything in the headers = <> attribute, but we would have to pass the same value in the address as well while executing our api
    

- Media type versioning: Github (aka “content negotiation” or “accept header”)
    
    ![image.png](/images/Springboot/image%20245.png)
    
    ![image.png](/images/Springboot/image%20246.png)
    
    ![image.png](/images/Springboot/image%20247.png)
    

- 
    
    ![image.png](/images/Springboot/image%20248.png)
    

### HATEOAS for REST API

- HATEOAS is the basically enhancing your REST API that whenever some data is returned some suggested subsequent actions are recommended with the data.
    
    ```xml
    enhancing your REST API so that whenever some data is returned, some suggested subsequent 
    actions (in the form of links) are recommended with the data.
    ```
    
- 
    
    ![image.png](/images/Springboot/image%20249.png)
    
- To use HATEOAS we need to use this dependency
    
    ```xml
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-hateoas</artifactId>
    		</dependency>
    
    ```
    
- For eg: We have to add a link that redirects us to the list of all the users when we go to a link to get the data of a single user. (When we go to /users/1 then it has an attribute which links directly to /users) So we would need to change the retrieveUser() method in the UserResource.
    1. We would first need to create an object of EntityModel, which is used to add links in our REST APIs. 
        
        ![image.png](/images/Springboot
/image%20250.png)
        
    2. Then we would use WebMvcLinkBuilder, which would be used to specify the method and link to which we want to redirect. Since here we want to redirect to link which retrievesAllUser() 
        
        ![image.png](/images/Springboot
/image%20251.png)
        
        The important thing to note here is that, you would have to static import the linkTo() and methodOn() methods using their qualified name which is present in the declaration of WebMvcLinkBuilder. 
        
    3. Now, when we go to the url which retrieves a single user it would have an attribute which would contain a link to the list of all-users 
        
        ![image.png](/images/Springboot
/image%20252.png)
        

### Implementing Static Filtering for REST API

- 
    
    ![image.png](/images/Springboot/image%20253.png)
    
- Suppose you have 3 fields, and multiple REST APIs. You want that in all the REST API the field1 is not visible, then it is called static filtering. But you want that field2 should be visible in some REST APIs and not in others, then it is called dynamic filtering.
- Implementing a Static filtering is very easy, you just need to use @JsonIgnore over the field which you want to hide.
    
    ![image.png](/images/Springboot/image%20254.png)
    
    ![image.png](/images/Springboot/image%20255.png)
    
    ![image.png](/images/Springboot/image%20256.png)
    
    This even works when we are returning a list 
    
    ![image.png](/images/Springboot/image%20257.png)
    
    ![image.png](/images/Springboot/image%20258.png)
    
- Another way of performing the same task is, instead of using @JsonIgnore over the field we can use @JsonIgnoreProperties(<name of the property>)
    
    ![image.png](/images/Springboot/image%20259.png)
    
    ![image.png](/images/Springboot/image%20260.png)
    

### Dynamic Filtering

- Sometimes we want to display different attributes of a same bean in different REST APIs (some attributes in one REST API and some in other), in these cases we have to use Dynamic Filtering.
- What we want is that field2 and field3 to be visible in the /filtering-list url, and field1 and field3 to be visible in /filtering
- Since, we need 2 different filters in 2 different urls, we cannot apply the filtering logic in the bean. Hence we would apply the logic directly into the methods which are mapped to the url.
- For the /filtering url:
    1. To use the filters we need to create an object of MappingJacksonValue and pass our bean as parameter. 
        
        ![image.png](/images/Springboot
/image%20261.png)
        
    2. Then to specify the filter we would use the method setFilters(), and pass filters as parameter and create a local variable filters of the type FilterProvider. 
        
        ![image.png](/images/Springboot
/image%20262.png)
        
    3. Now at last, we have to pass the value we have added in the first parameter of addFilter() method (Here “SomeBeanFilter”) to our class which defines the structure of our bean inside the annotation @JsonFilter(value=<>)
        
        ![image.png](/images/Springboot
/image%20263.png)
        
    4. Now when we go to localhost:8080/filtering, only field1, and field3 would be visible 
        
        ![image.png](/images/Springboot
/image%20264.png)
        

- We can perform the filtering over /filtering-list url in a similar way. We have to make sure we pass the same String value of the name of the filter in both of our addFilter() method
    
    ![image.png](/images/Springboot/image%20265.png)
    

### Exploring REST API using HAL Explorer

- 
    
    ![image.png](/images/Springboot/image%20266.png)
    
- To us HAL Explorer in our REST API we have to add this dependency:
    
    ```xml
    		<dependency>
    		    <groupId>org.springframework.data</groupId>
    		    <artifactId>spring-data-rest-hal-explorer</artifactId>
    		</dependency>
    
    ```
    
- Now, if we go to our root link that is [localhost:8080](http://localhost:8080) then we would see our HAL Explorer
    
    ![image.png](/images/Springboot/image%20267.png)
    
    And now if we change our header (here we would change it to /users/1 because we added a link using HAL in HATEOAS) then we would see all the link we have added using HAL 
    
    ![image.png](/images/Springboot/image%20268.png)
    

## Connecting our REST API to H2 Database

- Till now we have been using a static list to store the data about our REST APIs, but in real life applications we have to store data in a database. Also, H2 is a good database to learn things and not to use in real life application as it is also an in-memory database which means that everytime the server restarts the data which was modified is deleted.
- These are all the changes we made
    
    ![image.png](/images/Springboot/image%20269.png)
    
    ![image.png](/images/Springboot/image%20270.png)
    
    ![image.png](/images/Springboot/image%20271.png)
    
    ![image.png](/images/Springboot/image%20272.png)
    
    ![image.png](/images/Springboot/image%20273.png)
    

## Posts REST API

- Now we want to create a Posts REST API, which would store the data about all the posts a particular user has made. It would be a Many to One relationship because a single user can have multiple posts.
- We want the Posts REST API to:
    1. Retrieve all posts for a User: GET /users/{id}/posts
    2. Create a post for a User: POST /users/{id}/posts
- First, we would create a new bean (class) named Post, and make it an entity. We want an id, and description as parameters
    
    ![image.png](/images/Springboot/image%20274.png)
    
- Now, since every post would be associated with a User, we would need to make an object of User in Post bean. Also, every User could have multiple posts so we would create a List of Post in the User bean
    
    ![image.png](/images/Springboot/image%20275.png)
    
    ![image.png](/images/Springboot/image%20276.png)
    
- Since a user can have multiple posts the relationship of User to Post would be One-to-Many, hence we would use @OneToMany over the list of posts, and in the parameter we would have to pass the name of the attribute which would be used to map the User bean to Post (here user)
    
    ![image.png](/images/Springboot/image%20277.png)
    
- Since many posts would be mapped to one User, so the relationship from Post to User is Many-to-One, hence we would use @ManyToOne annotation over the instance of User (Again by Mistake I have use @ManyToAny change it)
    
    ![image.png](/images/Springboot/image%20278.png)
    
- Also, we want that the Post bean is only instantiated when a user posts something hence we would have to change its fetch attribute to LAZY instead of EAGER which is default for @ManyToOne
    
    ![image.png](/images/Springboot/image%20279.png)
    
- Now, we do not want Post to be visible in /users and User to be visible when we are accessing Post bean. So we would include @JsonIgnore to both attributes
    
    ![image.png](/images/Springboot/image%20280.png)
    
    ![image.png](/images/Springboot/image%20281.png)
    

- Now, we can add details about our posts in the h2 database
    
    ![image.png](/images/Springboot/image%20282.png)
    
    ![image.png](/images/Springboot/image%20283.png)
    

### Implementing GET API for Post

- 
    
    ![image.png](/images/Springboot/image%20284.png)
    
- 
    
    ![image.png](/images/Springboot/image%20285.png)
    

### Implementing a POST API to create a post for a user

- We created a class PostRepository as well. All the explanation is same as previous time when we were creating a new user
    
    ![image.png](/images/Springboot/image%20286.png)
    

## Spring Security in REST-API

- One thing to note while using Spring Security is, that a login form webpage is good when creating a website but not in a REST-API. A REST-API is better suited with a pop up.
- Also, csrf have to be disabled here as well so that we can use the PUT, POST, PATCH method to work
    
    ![image.png](/images/Springboot/image%20287.png)