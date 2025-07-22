# JUnit

- 
    
    ![image.png](/images/JUnit/image.png)
    

- Mockito is used for Mocking

# Creating a Simple JUnit test

- We have created a method which takes an integer array as input and returns the sum of its elements.
    
    ![image.png](/images/JUnit/image%201.png)
    
- Now, we have to check if this method works correct or not. For this, we have to write a unit test.
- All the test are to be written in a new source folder named test.
- In this test source folder, we can create a JUnit Test Case file which would contain our test logic
    
    ![image.png](/images/JUnit/image%202.png)
    
- 
    
    ![image.png](/images/JUnit/image%203.png)
    
    The name of the Test case should be the name of the class followed by “Test”. Also, the test should be placed in the same package of the class for which it is being written.
    

- Here we have written a simple JUnit test to check if the output of our calculateSum() method is the same as the expected result.
    
    ![image.png](/images/JUnit/image%204.png)
    
    Since it is the same here, we have received a green bar, which indicates test success. Now, if we change our expectedResult to something else, then it would give us red bar, which indicates test failure.
    
    ![image.png](/images/JUnit/image%205.png)
    
    We can also notice that under Failure Trace, we have received some information about why the current test has been failed.
    

- This is the better way to write the tests. Proper name is very important while writing test cases.
    
    ![image.png](/images/JUnit/image%206.png)
    

- You can pass some error message using the assertEquals() method as well. The assertEquals() method accepts a last argument as string, and it is use as the error message.
- There is also, assertTrue(), assertFalse(), and assertArrayEquals() which checks if the boolean value is true, false, or if the 2 arrays passed as argument are equal respectively.

# Some More Annotations

- If we want some functionality to be executed before every test is executed then we can use @BeforeEach over that function.
- If we want some functionality to be executed after every test is executed then we can use @AfterEach over that function.
- 
    
    ![image.png](/images/JUnit/image%207.png)
    
- There is also @BeforeAll and @AfterAll, which as the name would be executed once before any test case executes, or after all the test cases are executed. The @BeforeAll and @AfterAll methods should be static
    
    ![image.png](/images/JUnit/image%208.png)