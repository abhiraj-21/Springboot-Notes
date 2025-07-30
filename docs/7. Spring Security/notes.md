# Spring Security

# Authorization vs Authentication

- 
    
    ![image.png](/images/Spring%20Security/image.png)
    
    Identities are the users or admin who would access your application/resource
    

# Important Security Principles

- 
    
    ![image.png](/images/Spring%20Security/image%201.png)
    
    ![image.png](/images/Spring%20Security/image%202.png)
    

# How Does Spring Security Works?

- 
    
    ![image.png](/images/Spring%20Security/image%203.png)
    

- Basic Spring Security Configuration:
    
    ![image.png](/images/Spring%20Security/image%204.png)
    

# Form Based Authentication

- 
    
    ![image.png](/images/Spring%20Security/image%205.png)
    

# Basic Authentication

- 
    
    ![image.png](/images/Spring%20Security/image%206.png)
    

# CSRF

- CSRF: Cross-Site Request Forgery
- Spring Security allows the GetMapping to different sites, but the PostMapping or the update request is blocked by Spring Security. All the put or post request would require a CSRF token to complete their tasks.
    
    ![image.png](/images/Spring%20Security/image%207.png)
    
- To get the csrf token we can make a GET request method over a url like /csrf-token  which would give us an attribute back with the name “_csrf”
    
    ![image.png](/images/Spring%20Security/image%208.png)
    
    ![image.png](/images/Spring%20Security/image%209.png)
    
- If you have a stateless rest api, then you would have to disable csrf
- Similar to Synchronizer token pattern, we have SameSite cookie as well which would help us protect from CSRF. In it we basically set Set-Cookie to strict so that, the cookie is not shared to anyother website than the one it was created in.
- To set the cookie to strict, we have to add this in our [application.properties](http://application.properties)
    
    ```xml
    server.servlet.session.cookie.same-site=strict
    ```
    

## How to Disable CSRF

- If we go to eclipse and press ctrl+shift+t and type SBW, then we would go to SpringBootWebSecurityConfiguration class, and inside it is a method SecurityFilterChainConfiguration. This method is responsible for the basic spring security configuration, and hence we need to change it since it enables csrf.
    
    ![image.png](/images/Spring%20Security/image%2010.png)
    
    ```java
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	http.httpBasic(withDefaults());
    	return http.build();
    }
    ```
    
- To change the default configuration we would first need to create a Configuration class using @Configuration
    
    ![image.png](/images/Spring%20Security/image%2011.png)
    

- Now, we want to disable session, and it can be done like this
    
    ![image.png](/images/Spring%20Security/image%2012.png)
    
    ```java
    http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    ```
    

- Now, we can easily disable csrf like this
    
    ![image.png](/images/Spring%20Security/image%2013.png)
    
    ```java
    http.csrf().disable();
    ```
    

- Now we can perform POST Requests even if we don’t add the csrf token
    
    ![image.png](/images/Spring%20Security/image%2014.png)
    

# CORS

- CORS: Cross-Origin Request Sharing
    
    ![image.png](/images/Spring%20Security/image%2015.png)
    
- If we want to enable the Global CORS, then we can add the above mentioned code in any configuration class.

# Storing User Credentials

- When we want to make the username and password to access the webapp static we add them in application.properties. But it does not allow us to share it with anyother component or module. This is called In-Memory, it is okay to use them in development but not in production.
- The other way is to store credentials using a Database
- Another way is LDAP: Lightweight Directory Access Protocol

## Storing Multiple User Credentials InMemory

- 
    
    ![image.png](/images/Spring%20Security/image%2016.png)
    
- The {noop} is used to tell that the password passed is not encrypted and should be used as it is.
- It is a good practice to make an Enum of all the roles you need in your application, and then use them to assign the roles.

## Storing User Credentials Using Database/JDBC

- We would be using JDBC alongside H2 which is an in-memory database. But it can be replaced with MySQL very easily.
- 
    
    ![image.png](/images/Spring%20Security/image%2017.png)
    

- Here we have created a method dataSource, which is used to execute the script Default_User_Schema_DDL_Location just as when the h2 is executed. By default JDBC gives us 2 tables, 1. Users and 2. Authorities. Initially they both are empty.
- To populate the 2 default tables we have made another method userDetailsService and this time we have passed an object of DataSource as parameter. Now we would create a JdbcUserDetailsManager, and create the 2 users and they would be used to populate the tables.
    
    ![image.png](/images/Spring%20Security/image%2018.png)
    
- One thing to notice here is that the passwords are stored in un-encrypted way.

## Encoding vs Hashing vs Encryption

- 
    
    ![image.png](/images/Spring%20Security/image%2019.png)
    

- Hashing is used for storing passwords.

## Storing Bcrypt Encoded Passwords

- We can just create a method which returns an object of BCryptPasswordEncoder, and the encode it using the method passwordEncoder() when we create the use like this
    
    ![image.png](/images/Spring%20Security/image%2020.png)
    
- And now if we check our database then the passwords are in the encoded form
    
    ![image.png](/images/Spring%20Security/image%2021.png)
    
- 
    
    ![image.png](/images/Spring%20Security/image%2022.png)