# Springboot - SpringAOP

# Spring AOP

## What is AOP?

- AOP : Aspect Oriented Programming
- 
    
    ![image.png](/images/Spring%20AOP/image.png)
    
    ![image.png](/images/Spring%20AOP/image%201.png)
    
- We have to write the code for the cross cutting concerns first and the we must define point cuts to indicate where the aspect (a specific cross-cutting concern) should be applied.
- You won’t find the dependency for AOP in the spring initializer so you would have to manually add it in your application using the dependency (for gradle)
    
    ```xml
    implementation 'org.springframework.boot:spring-boot-starter-aop'
    ```
    

We would be using gradle for this project. All the dependencies in gradle is downloaded in build.gradle 

![image.png](/images/Spring%20AOP/image%202.png)

## Setting up Components for Spring AOP

- We would create a DataService1 and BusinessService1 class (Spring beans) for this
    
    ![image.png](/images/Spring%20AOP/image%203.png)
    
    ![image.png](/images/Spring%20AOP/image%204.png)
    
    ![image.png](/images/Spring%20AOP/image%205.png)
    

## Creating a Logging Aspect

- Now, since we have our data logic, and business logic, we want to create an aspect. Aspect is the logic or the piece of code which would be common in both of the DataService and BusincessService class.
- For now, let us create a Logging Aspect, which would log all the method which are being executed.
- For this we would need to create a different class LoggingAspect, and we would need to do 2 things:
    - Specify that this is a configuration class which configures AOP
    - Create a method which logs the method being executed in DataService or BusinessService class
    - We would also need to define the pointcuts
    
    ![image.png](/images/Spring%20AOP/image%206.png)
    
- To define that this class is used for AOP, we could use @Aspect over the class, just below @Configuration
- To define a methods Pointcut we can use @Pointcut(”<>”) above the method. We have to be very careful while passing the parameter, as the interception would depend on it.
    - If we want that the method intercepts all the calls in a class in a specific package then we have to use this
        
        ```xml
        execution(* <package>.*.*(..))
        ```
        
        So if we want to intercept all the calls present within the BusinessService1 class, we have to write *@Pointcut*("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*. *(..))") We can get the <package> value by copying the qualified name of the package in which we want to intercept every calls of all the classes
        
    
    ![image.png](/images/Spring%20AOP/image%207.png)
    
- Now, we want that which ever method is being called is logged, and to get the details about a specific method we use JoinPoint class. JoinPoints is used not just to get the name but to get almost all details about the method using the inbuilt method present with it
    
    ![image.png](/images/Spring%20AOP/image%208.png)
    
- Here we want that the name of the method is logged before it perform its function, hence we would need to use @Before instead of @PointCut
    
    ![image.png](/images/Spring%20AOP/image%209.png)
    

## Terminologies Related to AOP

- 
    
    ![image.png](/images/Spring%20AOP/image%2010.png)
    
- If the pointcuts at 1000 points, the advice would be executed 1000 times.

## Exploring @After

- 
    
    ![image.png](/images/Spring%20AOP/image%2011.png)
    
- 
    
    ![image.png](/images/Spring%20AOP/image%2012.png)
    
- The @After executes the advice even if the method throws an exception. If we want something to log only if the method executes successfully then we can use @AfterReturning, or if we want to log something only if an error is thrown then we can use @AfterThrowing
    - For eg: Here we have changed the method present in BusinessService1 class that it would throw an exception
        
        ![image.png](/images/Spring%20AOP/image%2013.png)
        
    - Now if we want to log something we can use @AfterThrowing. We can also pass the exception using the throwing parameter
        
        ![image.png](/images/Spring%20AOP/image%2014.png)
        
    - Similar to throwing in @AfterException we have returning in @AfterReturning
        
        ![image.png](/images/Spring%20AOP/image%2015.png)
        

## @Around

- Let us suppose we have to find out the performance of a method, then we cannot only rely on @Before or @After. We want some logic or advice to be executed once before the method starts executing and once after it has completed execution.
    
    ```xml
    @Around doesn't execute "twice" as two separate instances of advice, nor "continuously." 
    Instead, it's a single block of code that wraps the method execution, allowing you to place 
    logic at points that occur logically before and after the wrapped method's execution via the
    proceed() call.
    ```
    
- @Around is used when we have to execute some advice at both before and after of a method execution.
- 
    
    ![image.png](/images/Spring%20AOP/image%2016.png)
    
- When we are making use of @Around we cannot use JoinPoint, because it does not allow the method (Pointcut method) to execute. This means that the @Around would wrap around the method but won’t allow it to execute, it basically converts it to @Before
- To let the method execute we would use ProceedingJoinPoint instead of JoinPoint, which is a subclass of JoinPoints
- The ProceedingJoinPoint enables us to use the method proceed(), which invokes the pointcut method and the control is shifted to that method. After that method’s execution is completed the control is sent back to @Around advice, and the rest of the advice is executed.
- The proceed() method returns the return value of the method it is being currently executing
    
    ![image.png](/images/Spring%20AOP/image%2017.png)
    

## Creating a CommonPointcutConfig

- Until now, everytime we have been declaring an advice we were using @Before, @After, @Around and specifying the package in every annotation individually. But this is hard to maintain, as if the package of any of our class or bean changes we would have to make changes on mulitple places.
- Instead what we can do is, we can create a CommonPointcutConfig class in which we would define the package name using @Pointcut over a method, and then passing that methods qualified name as the pointcut parameter in the @Before, @After, or @Around
    
    ![image.png](/images/Spring%20AOP/image%2018.png)
    
    ![image.png](/images/Spring%20AOP/image%2019.png)
    

- We could also use bean instead of execution inside @Pointcut
    
    ![image.png](/images/Spring%20AOP/image%2020.png)
    
    ![image.png](/images/Spring%20AOP/image%2021.png)
    

## Creating an Annotation @TrackTime

- In @Around advice where we are tracking time of all the methods present. Suppose we want only some specific methods of which we want to track time of. So then we would have to create an annotation of our own, and then use it over the method which we want to track time of and at last pass its qualified name as the pointcut parameter in the @Around config
    
    ![Screenshot 2025-07-21 195806.png](/images/Spring%20AOP/Screenshot_2025-07-21_195806.png)
    
    ![Screenshot 2025-07-21 195815.png](/images/Spring%20AOP/Screenshot_2025-07-21_195815.png)
    
    ![image.png](/images/Spring%20AOP/image%2022.png)
    
    ![Screenshot 2025-07-21 200052.png](/images/Spring%20AOP/Screenshot_2025-07-21_200052.png)