# React with SpringBoot

- This section is all about getting to know about ReactJS, and its fundamental concepts alongside Springboot in backend.
- We would create a Fullstack application (or add react in our Todo Application we made earlier), and REST-API
- 
    
    ![image.png](/images/React%20with%20SpringBoot/image.png)
    

- npm
    
    ![image.png](/images/React%20with%20SpringBoot/image%201.png)
    

# What is React?

- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%202.png)
    

- A SPA or Single Page Application, is that when we update something on a webpage instead of refreshing the entire page react only refreshes the part of the page which is updated.

# Creating React App with Create React App

- 
    
    ![Screenshot 2025-07-22 185718.png](/images/React%20with%20SpringBoot/Screenshot_2025-07-22_185718.png)
    

- The structure of the command is
    
    ```xml
    npx create-react-app <name of the react app you want to create>
    ```
    
- After creating a React-app we can change our directory to the folder with the name of our react app, and type
    
    ```xml
    npm start
    ```
    
    To start our application
    
    ![image.png](/images/React%20with%20SpringBoot/image%203.png)
    

# Some Important npm commands

- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%204.png)
    

# React Folder Structure

- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%205.png)
    

# React Components

- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%206.png)
    

- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%207.png)
    

# Creating Your First React Component

- To create a component in a react application, you would have to create a function in App.js and then include that function inside the App() function.
    
    ![image.png](/images/React%20with%20SpringBoot/image%208.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%209.png)
    

- Here we are making use of function to create components, and hence these are called Function Components. React also provides Class Components, which uses class to create a component.
- In a class component, we have to use render() function to write what we want to display in our application. And the class extends Component, which we would have to import using the statement
    
    ```jsx
    import {Component} from 'react'
    ```
    
    ![image.png](/images/React%20with%20SpringBoot/image%2010.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2011.png)
    

# Understanding State in React

- Since, we have 2 types of components: Function and Class. It is pretty easy to get confused which component to use when.
- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%2012.png)
    
- In earlier version of React, state could only be used in Class components, and not in Function components.
- But now, since Hooks allows the function component to use state as well we would mostly use Function Component to build our application.

# Exploring JSX - React Views

- JSX stands for Java Scripts XML. It is used to write HTML for our React application, but is different than HTML in some areas.
- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%2013.png)
    

- We use () to make returning the complex JSX values easier. If you don’t want to use the parenthesis, then you must have the first element of the returning element in the same line as that of return.
    
    ![image.png](/images/React%20with%20SpringBoot/image%2014.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2015.png)
    
    The second component is not visible, as we didn’t used () neither we made the first element in the same line as that of ‘return’ statement 
    
- One thing is that the component name should have the first character as upper-case, and the for HTML you must use lower case. This helps in differentiating HTML and components.
- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%2016.png)
    

- The class is HTML is defined using className is JSX

# Implementing JS Best Practices

- One of the best JS practice is to create component in different files, or modules in js.
- 
    
    ![image.png](/images/React%20with%20SpringBoot/image%2017.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2018.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2019.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2020.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2021.png)
    

- While importing something into your project, if you use don’t use curly braces, {}, then the default function would be imported. And if we use {}, and pass the name of the function/component inside the braces then the component with the name passed inside would be imported. Here we made all of our components default for their specific module, and hence we didn’t require to use the curly braces. But while importing Component from react in our Class Components we were using curly braces, as Component is not the default export of react. This is called Named import.

# Exploring React Components - Counter Example

- The basic parts of a component in React are:
    - View (JSX)
    - JS Logic
    - Styling (CSS)
    - State (Internal Data Store)
    - Props (Passed Data): They are also called properties, they can be said are the arguments passed to the function which is a component.
- In this step, we would create a simple counter application which would help us to get to know about React Components, in a better and deeper way.
- First let us create a CounterComponent, and create function inside the component which when a button is clicked prints something on the console.log
    
    ![image.png](/images/React%20with%20SpringBoot/image%2022.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2023.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2024.png)
    
- Now we have just added some basic CSS, to make our webpage look good
    
    ![image.png](/images/React%20with%20SpringBoot/image%2025.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2026.png)
    
    ![image.png](/images/React%20with%20SpringBoot/image%2027.png)
    

## Exploring React State with useState hook

- Now, lets add some functionality in our application.
- We want the counter to be incremented by 1 when we click the button ‘+1’. For that we need to store the state of our component, and for that we can use useState() in function component
- useState returns 2 things:
    - Current state
    - A function to update state
- useState returns an array in which the 0th index is the state of the component, and the 1st index is the function which would be used to update the state. So we can store the values inside an array as well
    
    ![image.png](/images/React%20with%20SpringBoot/image%2028.png)
    

### How is Updating State updates the View?

- As we saw, that now we have the functionality to increase the counter. But we have only written the logic which updates the state of our component. Then how is our view updated?
- Initially we have to write the code to update DOM as well, which would then update the view. But React uses Virtual-DOM.
- Reacts create a virtual-dom, then when the state is changed it creates a new version of the virtual-dom v2, then compare both the versions and makes the changes accordingly.
- The process where React compares both the versions of virtual-dom is called “Diffing”

## Exploring React Props

- Props, short for Properties, are the data which are to be passed to the components. Think of them as the arguments you pass to a function.

### Traditional Approach on How to use Props

- The traditional way is when we are calling the components in the App.js we pass the property:value with them and then inside the component we can use make use of them as it would return an object.
    
    ![image.png](/images/React%20with%20SpringBoot/image%2029.png)
    

### Modern JS Approach to use Props

- The modern way to pass props is to use curly braces, {}, in our components.
    
    ![image.png](/images/React%20with%20SpringBoot/image%2030.png)
    
- Similarly we can also change our components to this
    
    ![image.png](/images/React%20with%20SpringBoot/image%2031.png)
    

- We can also set the type of props our component can accept using PropTypes