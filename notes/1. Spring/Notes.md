# Spring

# Spring Initializer

- This is the website of Spring Initializer: [https://start.spring.io/](https://start.spring.io/)
- 
    
    ![image.png](/images/Spring/image.png)
    

# Coupling

- 
    
    ![image.png](/images/Spring/image%201.png)
    

- Here, the GameRunner class is tightly coupled to the MarioGame class, since it uses an object of MarioGame as parameter in its constructor. So, if we want to use an object of a different class in its constructor then we have to perform a lot of work.
    
    ![image.png](/images/Spring/image%202.png)
    
    ![image.png](/images/Spring/image%203.png)
    
    ![image.png](/images/Spring/image%204.png)
    

- Here, now we have made an interface GamingConsole, and all the games are now implementing this interface and in the GameRunner constructor we have used the GamingConsole as the parameter. Hence, now GameRunner class is loosely bounded.
    
    ![image.png](/images/Spring/image%205.png)
    
    ![image.png](/images/Spring/image%206.png)
    
    ![image.png](/images/Spring/image%207.png)
    
    ![image.png](/images/Spring/image%208.png)
    
    ![image.png](/images/Spring/image%209.png)
    
    ![image.png](/images/Spring/image%2010.png)
    
    ![Screenshot 2024-12-25 104723.png](/images/Spring/Screenshot_2024-12-25_104723.png)
    

# Loose Coupling Using Spring

- When we used Interfaces for loose coupling, we had to write the code for object creation and wiring dependencies with some objects. When we use spring framework for loose coupling, spring itself is responsible for wiring dependencies.
    
    ![image.png](/images/Spring/image%2011.png)
    

## Configuration Class

![image.png](/images/Spring/image%2012.png)

- Here, we first need to make a Spring Context (The Green Part), and then we need to make a Spring Bean, (name).
- Spring Bean: Anything, variable, which is managed by Spring Framework.
- To configure the spring beans, we can use a Configuration class. This configuration class will configure all the spring beans and will launch the spring context as well.
- 
    
    ![image.png](/images/Spring/image%2013.png)
    
- 
    
    ![image.png](/images/Spring/image%2014.png)
    
- 
    
    ```java
    package com.learnSpring.learnSpringFramework;
    
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    
    import com.learnSpring.learnSpringFramework.game.GameRunner;
    import com.learnSpring.learnSpringFramework.game.MarioGame;
    import com.learnSpring.learnSpringFramework.game.SuperContraGame;
    import com.learnSpring.learnSpringFramework.game.pacManGame;
    
    public class App02HelloWorldSpring {
    
    	public static void main(String[] args) {
    		//1: Launch Spring Context
    		
    		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    																//Here the AnnotationConfigApplicationContext() is used to launch a Spring Context with the beans present in HelloWorldConfiguration class
    		
    		//2: Configure spring beans 
    		//HelloWorldConfiguration - @Configuration
    		//name - @Bean
    		
    		//3: Retrieving Beans Managed by Spring 
    		System.out.println(context.getBean("name"));
    		System.out.println(context.getBean("age"));
    		System.out.println(context.getBean("Person1"));
    		System.out.println(context.getBean("Person2"));
    		System.out.println(context.getBean("Person3"));
    		System.out.println(context.getBean(Address.class));
    	}
    
    }
    
    ```
    
- 
    
    ```java
    package com.learnSpring.learnSpringFramework;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Primary;
    
    record Person(String name, int age) {}
    record Address(String firstLine, String city) {}
    @Configuration
    public class HelloWorldConfiguration {
    
    	//This is the proper way to define a spring bean 
    	@Bean
    	public String name() {
    		return "Abhiraj";
    	}
    	
    	@Bean
    	public int age() {
    		return 20;
    	}
    	
    	@Bean
    	public Person Person1() {
    		return new Person("Aayushi",22);
    	}
    	
    	@Bean
    	public Person Person2() {				//Creating a new Bean using the existing Beans as Method call
    		return new Person(name(),age());
    	}
    	
    	@Bean
    	public Person Person3(String name, int age) {		//Creating a new Bean with existing Beans as Method Parameter
    		return new Person(name,age);
    	}
    	
    	@Bean(name="address1")
    	public Address address() {
    		return new Address("Katariya colony","Jaipur");
    	}
    	
    	@Bean
    	@Primary	//This makes this address as the primary whenever address is called without specifying the name of the bean
    	public Address add() {
    		return new Address("Baker Street","London");
    	}
    	
    }
    
    ```
    

## POJO vs Java Beans vs Spring Beans

![image.png](/images/Spring/image%2015.png)

## What is Spring Container/ Spring Context/ IOC Container

![image.png](/images/Spring/image%2016.png)

- IOC: Inversion Of Control

## Game Loose Coupling using Spring

- 
    
    ![image.png](/images/Spring/image%2017.png)
    
- 
    
    ![image.png](/images/Spring/image%2018.png)
    

Here we are using 2 classes as we did in the helloworld program, where name, age, person were present. Instead we can make the configuration and launcher class same, which would be the App03GamingSpringBeans.

- Here the launcher and configuration are both done inside the same class, which makes the code easy. The class App03GamingSpringBeans has @Configuration present above it, and before the main method the beans are defined.
    
    ![image.png](/images/Spring/image%2019.png)
    

But here we ourselves are making the objects, beans, and spring has the ability to make and manage the objects on its own.

- 
    
    ![image.png](/images/Spring/image%2020.png)
    
    ![image.png](/images/Spring/image%2021.png)
    
    Here the pacManGame class has been declared as a bean using @Component, and since it is present in a different package than the App03GamingSpringBean, which is the configuration and launcher, so we have used @ComponentScan() to search for the components in the package where pacManGame class is present. This allows the spring framework to create an object on its own whenever it is required, in the example the object was required in the gameRunner bean as the parameter.
    

Here, we are manually creating the gameRunner bean, but since we are calling it in the main method using context.getBean(GameRunner.class), therefore we can make the GameRunner class also as a component and remove the code where we manually make the spring bean.

- 
    
    ![image.png](/images/Spring/image%2022.png)
    
    ![image.png](/images/Spring/image%2023.png)
    
    The important thing to note here is that the GameRunner class is present in the same package as that of pacManGame class and hence we did not change the @ComponentScan() location.
    

Now, we gave the @Component to pacManGame class only, but we have 2 more game classes, i.e. MarioGame and SuperContraGame. But if we gave the @Component directly to them then when spring would be required to make a component or a bean of any of the three game it would get an error, since there would be 3 beans (since in GameRunner constructor we have GamingConsole object and all 3 game classes implements it). So to tackle this problem we have 2 ways, one is to give @Primary to any of the 3 game classes, other is to give @Qualifier to all the 3 classes.

- @Primary: Here we have given MarioGame the @Primary and hence when the GameRunner bean is called in the main method it creates an object of MarioGame class.
    
    ![image.png](/images/Spring/image%2024.png)
    
    ![image.png](/images/Spring/image%2025.png)
    
    ![image.png](/images/Spring/image%2026.png)
    

- @Qualifier(): Here we have used the @Qualifier in the SuperContraGame class, and also we have used the same @Qualifier(””) in the constructor of GameRunner to create an object of the Qualifier with the same name, i.e. SuperContraGame class.
    
    ![image.png](/images/Spring/image%2027.png)
    
    ![image.png](/images/Spring/image%2028.png)
    
    ![image.png](/images/Spring/image%2029.png)
    
    ![image.png](/images/Spring/image%2030.png)
    
    ![image.png](/images/Spring/image%2031.png)
    
    We can also use the @Qualifier in the GameRunner class only without declaring the SuperContraGame class as the @Qualifier. We just need to use the @Qualifier(”superContraGame”) in the GameRunnerClass, which is the name of the class just the first alphabet is in small letters.
    
    ![image.png](/images/Spring/image%2032.png)
    
    ![image.png](/images/Spring/image%2033.png)
    

- **`@Primary`** is used for setting a default when multiple beans of the same type are available.
- **`@Qualifier`** is used to explicitly define which bean to inject when there are multiple candidates, overriding `@Primary` if present.
- **`@Qualifier`** takes higher priority than `@Primary` in case both annotations are involved.

### Different Types Of Dependencies

- 
    
    ![image.png](/images/Spring/image%2034.png)
    
- Field Injection: For field injection we use @Autowired above the declaration of dependancies. Here, we have made 3 classes namely YourBusinessClass, Dependency1, and Dependency2. The Dependency1 and Dependency2 would be used to check whether they are wired into the YourBusinessClass.
    
    ![image.png](/images/Spring/image%2035.png)
    
    Here, we can see that the dep1 and dep2 are not Autowired since when we use the getBean() for the YourBusinessClass the output is Using null and null. To wire dep1 and dep2 to YourBusinessClass we use @Autowired. 
    
    ![image.png](/images/Spring/image%2036.png)
    
- Setter-based Injection: Here @Autowired is used just above the setter of the dependencies.
    
    ![image.png](/images/Spring/image%2037.png)
    
- Constructor-based Injection: Here @Autowired is not required.
    
    ![image.png](/images/Spring/image%2038.png)
    

### Spring Framework Terminologies

- 
    
    ![image.png](/images/Spring/image%2039.png)
    

### @Component vs @Bean

- 
    
    ![image.png](/images/Spring/image%2040.png)
    

# Lazy Initialization

- As we know, when we use Constructor Based Dependency Injection the autowiring and intialization of all spring beans is done at the time of spring context creation. So to avoid this, and let the bean only be initialized when the corresponding class is being called by the getBean() method, we use @Lazy for the class. The default initialization of Spring Beans is called Eager Initialization, and the other way is called Lazy Initialization where we use @Lazy and the spring bean is initialized only when the getBean() is called.
- Here for example. ClassB uses Constructor based DI where it injects ClassA as the dependency. In the main method, after we have intialized the spring context the ClassA object is created even when we havent called the getBean() method for the ClassB.
    
    ![image.png](/images/Spring/image%2041.png)
    
    Now we have used @Lazy just above the ClassB to make it use the Lazy Initialization, due to which the object of ClassA will only be initialized when the method getBean() is called for the ClassB.class.
    
    ![image.png](/images/Spring/image%2042.png)
    
    ![image.png](/images/Spring/image%2043.png)
    
- 
    
    ![image.png](/images/Spring/image%2044.png)
    
- 
    
    ![image.png](/images/Spring/image%2045.png)
    

# Spring Bean Scopes

- 
    
    ![image.png](/images/Spring/image%2046.png)
    

- When we create a spring bean it is singleton by default. But to make a spring Prototype we use @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE***).***  We can also use @Scope(value=”prototype”)
- Here in this example, the NormalClass is the default Spring Bean, i.e. Singleton sprin bean, and only one instance of the class is present in the entire Spring Context. Since we are printing the address 3 times for NormalClass and everytime the address is same. But the PrototypeClass has @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) which makes it a Prototype and whenever it is called a new instance of the ProtoypeClass is created. We can see that when we printed the address 3 times every time the address was different.
    
    ![image.png](/images/Spring/image%2047.png)
    
- 
    
    ![image.png](/images/Spring/image%2048.png)
    

# PostConstruct & PreDestroy

- Here,we are explicitly calling the functions initialize() and cleanup().
    
    ![image.png](/images/Spring/image%2049.png)
    
- But if we want the functions to automatically be invoked with a certain condition, like initialize() should be invoked just after the constructor is completed, and the cleanup() should be invoked just before the spring bean gets destroyed, we use @PostConstruct and @PreDestroy respectively.
    
    ![image.png](/images/Spring/image%2050.png)
    

# Jakarta Context & Dependency Injection (CDI)

- 
    
    ![image.png](/images/Spring/image%2051.png)
    
    Therefore, we can use @Named, @Inject in place of @Component and @Autowired. To use Jakarta in our program we have to add a dependency in out pom.xml.
    
    ```java
    <dependency>
    			<groupId>jakarta.inject</groupId>
    			<artifactId>jakarta.inject-api</artifactId>
    </dependency>
    ```
    

- 
    
    ![image.png](/images/Spring/image%2052.png)
    
    ```java
    package com.learnSpring.learnSpringFramework.example.g1;
    
    import java.util.Arrays;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.stereotype.Component;
    
    import jakarta.inject.Inject;
    import jakarta.inject.Named;
    
    //@Component
    @Named	//Using @Named instead of @Component
    class BusinessService{
    	private DataService dataService;
    
    	public DataService getDataService() {
    		return dataService;
    	}
    	//@Autowired
    	@Inject	//Using @Inject in place of @Autowired in setter-based injection
    	public void setDataService(DataService dataService) {
    		System.out.println("Setter Injection");
    		this.dataService = dataService;
    	}
    }
    @Component
    class DataService{
    	
    }
    
    @Configuration
    @ComponentScan		
    public class CdiContextLauncherApplication {
    	
    	public static void main(String[] args) {
    		
    		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
    			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    			System.out.println(context.getBean(BusinessService.class).getDataService());
    		}
    
    	}
    
    }
    
    ```
    

# Spring Stereotype Annotations

- 
    
    ![image.png](/images/Spring/image%2053.png)
    

# XML Configuration

- Till now what we have studied is called the Java Configuration of spring. But before the Java configuration was introduced, the Xml Configuration were used to make spring application.
- To use XML configuration, make a new file contextConfiguration.xml in the resources folder. Then paste this in there:  (You can find this here)

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"> <!-- bean definitions here -->
	
 	
</beans>
```

- This is how a bean is made in XML configuration:
    
    ![Screenshot 2025-05-19 151819.png](/images/Spring/Screenshot_2025-05-19_151819.png)
    
    ![Screenshot 2025-05-19 151845.png](/images/Spring/Screenshot_2025-05-19_151845.png)
    

## Java Configuration vs XML Configuration

- 
    
    ![image.png](/images/Spring/image%2054.png)
    

# Important Spring Framework Annotations

- 
    
    ![image.png](/images/Spring/image%2055.png)
    
    ![image.png](/images/Spring/image%2056.png)
    
    ![image.png](/images/Spring/image%2057.png)
    

# Important Spring Framework Concepts

- 
    
    ![image.png](/images/Spring/image%2058.png)