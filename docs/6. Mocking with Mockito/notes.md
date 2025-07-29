# Mocking with Mockito

# Why Mockito??

- 
    
    ![image.png](/images/Mocking%20with%20Mockito/image.png)
    

- We do not want to add any additional dependency to add Mockito in our project. When we create the project using spring initializer it automatically adds springboot-starter-test dependency which have the mockito dependency in it.
- What we would do is that we would create a business class which would talk to Data interface and then mock or stub the data layer so that we understand what is actually going on
    
    ![image.png](/images/Mocking%20with%20Mockito/image%201.png)
    

# Understanding Stub

- We would create a unit test for our SomeBusinessImpl class in the same package
- We want to test if the SomeBusinessImpl class is working as expected without passing any actual data (dependency) to it. Since our SomeBusinessImpl needs the DataService and we don’t want to pass any data, we would create a stub of DataService in our unit test.
    
    ![image.png](/images/Mocking%20with%20Mockito/image%202.png)
    
    ![image.png](/images/Mocking%20with%20Mockito/image%203.png)
    

## Problems with Stub

- The most common problem with stubs are that whenever a new method is made in the DataService interface we would have to change or update its stub everytime. Even if we are not using the new method we still have to implement them according to Java Interface rules.
- Another problem, and the most important one, is that when we want to test multiple scenarios, which means testing multiple inputs, we would have to create multiple stub classes for the same interface.
- This makes the maintenance of our Unit Test very hard, and hence is not recommended now.

# Understanding Mocks

- Instead of making a new class then making it implement our interface. We can directly use mock() to mock our interface (even a class).
- Then we want, when a specific method of that interface is called it returns a value. We can do that using when().thenReturn()
    
    ![image.png](/images/Mocking%20with%20Mockito/image%204.png)
    

- Now, if we want to check for multiple scenarios mocking has made it easy as we just need to define a new test method for that and just change the return value in the thenReturn() method.
    
    ![image.png](/images/Mocking%20with%20Mockito/image%205.png)
    

- Mocks are easier to write and to maintain.

## Using @Mock @InjectMocks and MockExtension to make Unit Testing much Easier

- 
    
    ![image.png](/images/Mocking%20with%20Mockito/image%206.png)
    

![image.png](/images/Mocking%20with%20Mockito/image%207.png)