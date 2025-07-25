# React with SpringBoot

- This section is all about getting to know about ReactJS, and its fundamental concepts alongside Springboot in backend.
- We would create a Fullstack application (or add react in our Todo Application we made earlier), and REST-API
- 
    
    ![image.png](React%20with%20SpringBoot/image.png)
    

- npm
    
    ![image.png](React%20with%20SpringBoot/image%201.png)
    

# What is React?

- 
    
    ![image.png](React%20with%20SpringBoot/image%202.png)
    

- A SPA or Single Page Application, is that when we update something on a webpage instead of refreshing the entire page react only refreshes the part of the page which is updated.

# Creating React App with Create React App

- 
    
    ![Screenshot 2025-07-22 185718.png](React%20with%20SpringBoot/Screenshot_2025-07-22_185718.png)
    

- The structure of the command is
    
    ```xml
    npx create-react-app <name of the react app you want to create>
    ```
    
- After creating a React-app we can change our directory to the folder with the name of our react app, and type
    
    ```xml
    npm start
    ```
    
    To start our application
    
    ![image.png](React%20with%20SpringBoot/image%203.png)
    

# Some Important npm commands

- 
    
    ![image.png](React%20with%20SpringBoot/image%204.png)
    

# React Folder Structure

- 
    
    ![image.png](React%20with%20SpringBoot/image%205.png)
    

# React Components

- 
    
    ![image.png](React%20with%20SpringBoot/image%206.png)
    

- 
    
    ![image.png](React%20with%20SpringBoot/image%207.png)
    

# Creating Your First React Component

- To create a component in a react application, you would have to create a function in App.js and then include that function inside the App() function.
    
    ![image.png](React%20with%20SpringBoot/image%208.png)
    
    ![image.png](React%20with%20SpringBoot/image%209.png)
    

- Here we are making use of function to create components, and hence these are called Function Components. React also provides Class Components, which uses class to create a component.
- In a class component, we have to use render() function to write what we want to display in our application. And the class extends Component, which we would have to import using the statement
    
    ```jsx
    import {Component} from 'react'
    ```
    
    ![image.png](React%20with%20SpringBoot/image%2010.png)
    
    ![image.png](React%20with%20SpringBoot/image%2011.png)
    

# Understanding State in React

- Since, we have 2 types of components: Function and Class. It is pretty easy to get confused which component to use when.
- 
    
    ![image.png](React%20with%20SpringBoot/image%2012.png)
    
- In earlier version of React, state could only be used in Class components, and not in Function components.
- But now, since Hooks allows the function component to use state as well we would mostly use Function Component to build our application.

# Exploring JSX - React Views

- JSX stands for Java Scripts XML. It is used to write HTML for our React application, but is different than HTML in some areas.
- 
    
    ![image.png](React%20with%20SpringBoot/image%2013.png)
    

- We use () to make returning the complex JSX values easier. If you don’t want to use the parenthesis, then you must have the first element of the returning element in the same line as that of return.
    
    ![image.png](React%20with%20SpringBoot/image%2014.png)
    
    ![image.png](React%20with%20SpringBoot/image%2015.png)
    
    The second component is not visible, as we didn’t used () neither we made the first element in the same line as that of ‘return’ statement 
    
- One thing is that the component name should have the first character as upper-case, and the for HTML you must use lower case. This helps in differentiating HTML and components.
- 
    
    ![image.png](React%20with%20SpringBoot/image%2016.png)
    

- The class is HTML is defined using className is JSX

# Implementing JS Best Practices

- One of the best JS practice is to create component in different files, or modules in js.
- 
    
    ![image.png](React%20with%20SpringBoot/image%2017.png)
    
    ![image.png](React%20with%20SpringBoot/image%2018.png)
    
    ![image.png](React%20with%20SpringBoot/image%2019.png)
    
    ![image.png](React%20with%20SpringBoot/image%2020.png)
    
    ![image.png](React%20with%20SpringBoot/image%2021.png)
    

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
    
    ![image.png](React%20with%20SpringBoot/image%2022.png)
    
    ![image.png](React%20with%20SpringBoot/image%2023.png)
    
    ![image.png](React%20with%20SpringBoot/image%2024.png)
    
- Now we have just added some basic CSS, to make our webpage look good
    
    ![image.png](React%20with%20SpringBoot/image%2025.png)
    
    ![image.png](React%20with%20SpringBoot/image%2026.png)
    
    ![image.png](React%20with%20SpringBoot/image%2027.png)
    

## Exploring React State with useState hook

- Now, lets add some functionality in our application.
- We want the counter to be incremented by 1 when we click the button ‘+1’. For that we need to store the state of our component, and for that we can use useState() in function component
- useState returns 2 things:
    - Current state
    - A function to update state
- useState returns an array in which the 0th index is the state of the component, and the 1st index is the function which would be used to update the state. So we can store the values inside an array as well
    
    ![image.png](React%20with%20SpringBoot/image%2028.png)
    

### How is Updating State updates the View?

- As we saw, that now we have the functionality to increase the counter. But we have only written the logic which updates the state of our component. Then how is our view updated?
- Initially we have to write the code to update DOM as well, which would then update the view. But React uses Virtual-DOM.
- Reacts create a virtual-dom, then when the state is changed it creates a new version of the virtual-dom v2, then compare both the versions and makes the changes accordingly.
- The process where React compares both the versions of virtual-dom is called “Diffing”

## Exploring React Props

- Props, short for Properties, are the data which are to be passed to the components. Think of them as the arguments you pass to a function.

### Traditional Approach on How to use Props

- The traditional way is when we are calling the components in the App.js we pass the property:value with them and then inside the component we can use make use of them as it would return an object.
    
    ![image.png](React%20with%20SpringBoot/image%2029.png)
    

### Modern JS Approach to use Props

- The modern way to pass props is to use curly braces, {}, in our components.
    
    ![image.png](React%20with%20SpringBoot/image%2030.png)
    
- Similarly we can also change our components to this
    
    ![image.png](React%20with%20SpringBoot/image%2031.png)
    

- We can also set the type of props our component can accept using PropTypes, also the default value can be set
    
    ![image.png](React%20with%20SpringBoot/image%2032.png)
    

## Creating a single count for multiple counterbuttons

- Up until now, we have multiple count values and for each count value we have a separate increment button, and decrement button.
- Now, we want that all of these buttons changes the value of a single count.
- To do that we have to move our state up.
- We would create a new component in our Counter.jsx named Counter, and rename the already existing Counter() function to CounterButton. Now instead of returning the CounterButtons from App.js we would return them from Counter
    
    ![image.png](React%20with%20SpringBoot/image%2033.png)
    
    ![image.png](React%20with%20SpringBoot/image%2034.png)
    
- Now we want a single count value, so we would remove the useState() function from CounterButton, also remove the <span> which returns the count and use them in our Counter
- Now, we would have to create functions for incrementing and decrementing the values in Counter() component. And when we are returning the <CounterButton /> we would have to specify them as props
    
    ![image.png](React%20with%20SpringBoot/image%2035.png)
    
- Now we have a counter application, with single count and multiple buttons
    
    ![image.png](React%20with%20SpringBoot/image%2036.png)
    
- But as we saw earlier, every component must be in separate module. So we would create a new module for our CounterButton component
    
    ![image.png](React%20with%20SpringBoot/image%2037.png)
    
    ![image.png](React%20with%20SpringBoot/image%2038.png)
    

## Adding a Reset Button

- Adding a reset button should be easy, as we just need to return an additional button from the Counter component. Also we would need to create a function which would be called when the button is clicked, and it would set our count to 0
    
    ![image.png](React%20with%20SpringBoot/image%2039.png)
    

## Calling Parent Component Functions Directly to our Child Component

- Right now, when we want to call incrementMethod() or decrementMethod() in our CounterButton component, we are making new functions, and calling them in those new functions.
- But we can use arrow functions to call our parent component functions directly in our child component.
- 
    
    ![image.png](React%20with%20SpringBoot/image%2040.png)
    

# Building Java Todo Full Stack Application With Springboot and React

- 
    
    ![image.png](React%20with%20SpringBoot/image%2041.png)
    

- These are the steps involved in building the entire todo app
    
    ![image.png](React%20with%20SpringBoot/image%2042.png)
    

- Lets start by creating a login and welcome components.
- A simple login component can be created using this (Here we have not yet made a new module for Login Component but we will make one later)
    
    ![image.png](React%20with%20SpringBoot/image%2043.png)
    
    ![image.png](React%20with%20SpringBoot/image%2044.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
                <Login /> 
            </div>
        )
    }
    
    function Login(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()              
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        return(
            <div className="Login">
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                         <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login">Submit</button>
                    </div>
                </div>
            </div>
        )
    }
    ```
    

## Adding Hardcoded Authentication for Login

- First, let us hardcode our authenticated credentials, and if the credentials are right we must print success or failure in console.
    
    ![image.png](React%20with%20SpringBoot/image%2045.png)
    

- Now, if we want to print some message on our view then we have to make use of the && operation. For eg: We want to display “Authentication Successful” when the authentication is success, and “Authentication Failed” when it fails.
    - For that we would need to create 2 more state:
        1. showSuccessMessage, setShowSuccessMessage: initally false
        2. showErrorMessage, setShowErrorMessage: initally false
    - Then we will check about the authentication in our handleSubmit button, and accordingly update the value of these 2 states.
    - At last, in our login component, we can use the && to let the authentication decide if it shows any message or not.
        
        ![image.png](React%20with%20SpringBoot/image%2046.png)
        
        ![image.png](React%20with%20SpringBoot/image%2047.png)
        
        ![image.png](React%20with%20SpringBoot/image%2048.png)
        
        ![image.png](React%20with%20SpringBoot/image%2049.png)
        
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
                <Login /> 
            </div>
        )
    }
    
    function Login(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)      
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    ```
    

## Redirecting to Welcome Component

- Now, the only functionality which is not yet in our Login component is that when the authentication is successful we should be redirected or routed to Welcome component.
- We want LoginComponent to route to WelcomeComponent, and the component that would allow us to do routing is called React Router DOM
- To install React Router DOM we would have to use this command in our cmd
    
    ```xml
    npm install react-router-dom
    ```
    
- Now we need to import BrowserRouter, Routes, Route, and useNavigate() from react-router-dom
    
    ```jsx
    import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
    
    ```
    
- Now we can specify the url at which our components would be present like this:
    
    ![image.png](React%20with%20SpringBoot/image%2050.png)
    
- Also, we want that if the credentials are correct we are redirected to the welcome component, which is now present at ‘/welcome’ so we can use another hook useNavigate which would return a function in which when we pass an url it redirects us to that url
    
    ![image.png](React%20with%20SpringBoot/image%2051.png)
    
- 
    
    ```
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />}></Route>
                        <Route path='/login' element={<LoginComponent />}></Route>
                        <Route path='/welcome' element={<WelcomeComponent />}></Route>
                    </Routes>
                </BrowserRouter>
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate('/welcome')
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
        return(
            <div className='Welcome'>
                Welcome Component
            </div>
        )
    }
    ```
    

## Adding Error Components

- Right now when we try to access a url which is not yet routed to any component our application shows a blank page with an error in the console
    
    ![image.png](React%20with%20SpringBoot/image%2052.png)
    
- Instead of this we want to show a proper error component.
- This is pretty simple, we just need to make an error component and then route it to every url using * and place it as the last route in <Routes>
    
    ![image.png](React%20with%20SpringBoot/image%2053.png)
    
    ![image.png](React%20with%20SpringBoot/image%2054.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />}></Route>
                        <Route path='/login' element={<LoginComponent />}></Route>
                        <Route path='/welcome' element={<WelcomeComponent />}></Route>
                        <Route path='*' element={<ErrorComponent />}></Route>
                    </Routes>
                </BrowserRouter>
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate('/welcome')
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                <h1>Time To LockIn!!</h1>
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
        return(
            <div className='Welcome'>
                <h1>Welcome Abhiraj</h1>
                <div>
                    Welcome Component
                </div>
            </div>
        )
    }
    
    function ErrorComponent(){
        return(
            <div className='Error'>
                <h1>We are working really hard!</h1>
                <div>
                    Please stay in your limits. 
                </div>
            </div>
        )
    }
    ```
    

## Removing Hardcoded Data from Welcome Component

- Right now, we have hardcoded the name ‘Abhiraj’ in our welcome component
    
    ![image.png](React%20with%20SpringBoot/image%2055.png)
    
- What we want is that the username which was specified at the time of login to be used.
- For that we have to use another hook useParams() which would return a key:value pair where value would be the thing we want to capture.
    
    ![image.png](React%20with%20SpringBoot/image%2056.png)
    
    ![image.png](React%20with%20SpringBoot/image%2057.png)
    
    ![image.png](React%20with%20SpringBoot/image%2058.png)
    
- Even here, we have somehow hardcode the name ‘abhiraj’ and not using it from the login form. To use it from the login, we can pass the variable (state) username in the navigate() function. And to pass a variable alongside a string in JavaScript we use ` ` instead of ' '
    
    ![image.png](React%20with%20SpringBoot/image%2059.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Route, Routes, useNavigate, useParams } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />}></Route>
                        <Route path='/login' element={<LoginComponent />}></Route>
                        <Route path='/welcome/:username' element={<WelcomeComponent />}></Route>        {/* the keyword we specify here becomes the key of useParams() */}
                        <Route path='*' element={<ErrorComponent />}></Route>
                    </Routes>
                </BrowserRouter>
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate(`/welcome/${username}`)        //what we pass in here becomes the value of the useParams()
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                <h1>Time To LockIn!!</h1>
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
    
        const {username} = useParams()  //Here we have deconstruted our object so that whatever value was present in 'username' key would be stored here
    
        return(
            <div className='Welcome'>
                <h1>Welcome {username}</h1>
                <div>
                    Welcome Component
                </div>
            </div>
        )
    }
    
    function ErrorComponent(){
        return(
            <div className='Error'>
                <h1>We are working really hard!</h1>
                <div>
                    Please stay in your limits. 
                </div>
            </div>
        )
    }
    ```
    

## Creating ListTodosComponent

- Let us first create an array of Todos for simplicity.
- The map() function in JavaScript creates a separate array for the same fields of a given array. For eg: If we have an array arr with every element having 2 fields. Then map() would create 2 new arrays for each field values for all elements of the array
- 
    
    ![image.png](React%20with%20SpringBoot/image%2060.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Route, Routes, useNavigate, useParams } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/welcome/:username' element={<WelcomeComponent />} />  
                        <Route path='/todos' element={<ListTodosComponent />} />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                </BrowserRouter>
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate(`/welcome/${username}`)        //what we pass in here becomes the value of the useParams()
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                <h1>Time To LockIn!!</h1>
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
    
        const {username} = useParams()  //Here we have deconstruted our object so that whatever value was present in 'username' key would be stored here
    
        return(
            <div className='Welcome'>
                <h1>Welcome {username}</h1>
                <div>
                    Welcome Component
                </div>
            </div>
        )
    }
    
    function ErrorComponent(){
        return(
            <div className='Error'>
                <h1>We are working really hard!</h1>
                <div>
                    Please stay in your limits. 
                </div>
            </div>
        )
    }
    
    function ListTodosComponent(){
    
        const todos = [ {id:1, description: 'Learn AWS'},
                        {id:2, description: 'Learn React'},
                        {id:3, description: 'Learn Docker'},
                        {id:4, description: 'Learn MySQL'},
                        {id:5, description: 'Learn ThymeLeaf'},
                        ]
    
        return(
            <div className='ListTodosComponent'>
                <h1>Things You Need To Do!!</h1>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Description</td>
                            </tr>
                        </thead>
                        <tbody>
                            
                            {   
                                todos.map(                      //The todos.map() function in JavaScript creates a separate array for the elements of todos 
                                    todo => (
                                        <tr key={todo.id}>          
                                            <td>{todo.id}</td>
                                            <td>{todo.description}</td>
                                        </tr>
                                    )
                                )
                            }
    
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
    ```
    

- Now let us add a Done and Target Date fields as well.
    
    ![image.png](React%20with%20SpringBoot/image%2061.png)
    

- Now we want to add a link to our welcome component which would redirect us to our todos component. We can easily do that using the <a> tag in html. But if we use <a> tag then the entire page is refreshed when we get redirected. And it is not a good practice since, we are using React and if our entire webpage is being refreshed then we are not making full use of React.
- Instead of <a href=””> we can use <Link to=””> which is provided to us by react-router-dom
    
    ![image.png](React%20with%20SpringBoot/image%2062.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/welcome/:username' element={<WelcomeComponent />} />  
                        <Route path='/todos' element={<ListTodosComponent />} />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                </BrowserRouter>
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate(`/welcome/${username}`)        //what we pass in here becomes the value of the useParams()
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                <h1>Time To LockIn!!</h1>
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
    
        const {username} = useParams()  
    
        return(
            <div className='Welcome'>
                <h1>Welcome {username}</h1>
                <div>
                    <Link to='/todos'> Manage </Link>Your Todos!
                </div>
            </div>
        )
    }
    
    function ErrorComponent(){
        return(
            <div className='Error'>
                <h1>We are working really hard!</h1>
                <div>
                    Please stay in your limits. 
                </div>
            </div>
        )
    }
    
    function ListTodosComponent(){
    
        const today = new Date()
        const targetDate = new Date(today.getFullYear()+1, today.getMonth(), today.getDay())
    
        const todos = [ {id:1, description: 'Learn AWS', done: false, targetDate: targetDate},
                        {id:2, description: 'Learn React', done: false, targetDate: targetDate},
                        {id:3, description: 'Learn Docker', done: false, targetDate: targetDate}
                        ]
    
        return(
            <div className='ListTodosComponent'>
                <h1>Things You Need To Do!!</h1>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Description</td>
                                <td>Is Done?</td>
                                <td>Target Date</td>
                            </tr>
                        </thead>
                        <tbody>
                            
                            {   
                                todos.map(                     
                                    todo => (
                                        <tr key={todo.id}>          
                                            <td>{todo.id}</td>
                                            <td>{todo.description}</td>
                                            <td>{todo.done.toString()}</td>
                                            <td>{todo.targetDate.toDateString()}</td>
                                        </tr>
                                    )
                                )
                            }
    
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
    ```
    

## Creating Header, Footer, adn Logout Components

- Here we are just adding few simple header, footer, and logout components.
- The header and footer component would be placed above and below the BrowserRouter in the default export component, so that they are visible over every other component which is present within the BrowserRouter. And the logout component is routed to the url ‘/logout’
    
    ![image.png](React%20with%20SpringBoot/image%2063.png)
    
    ![image.png](React%20with%20SpringBoot/image%2064.png)
    
    ```jsx
    import { useState } from 'react'
    import './TodoApp.css'
    import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from 'react-router-dom'
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
    
                <HeaderComponent />
    
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/welcome/:username' element={<WelcomeComponent />} />  
                        <Route path='/todos' element={<ListTodosComponent />} />
                        <Route path='/logout' element={<LogoutComponent />} />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                </BrowserRouter>
    
                <FooterComponent />
    
            </div>
        )
    }
    
    function LoginComponent(){
    
        const [username, setUsername] = useState('abhiraj')     
        const [password, setPassword] = useState()        
        const [showSuccessMessage, setShowSuccessMessage] = useState(false)      
        const [showErrorMessage, setShowErrorMessage] = useState(false)   
        
        const navigate = useNavigate()
    
        function handleUsernameChange(event){
            setUsername(event.target.value)                     
        }
    
        function handlePasswordChange(event){
            setPassword(event.target.value)
        }
    
        function handleSubmit(){
            if(username === 'abhiraj' && password === 'Abhiraj@07'){
                console.log('correct')
                setShowSuccessMessage(true)
                setShowErrorMessage(false)
                navigate(`/welcome/${username}`)        //what we pass in here becomes the value of the useParams()
            }else{
                console.log('failed')
                setShowSuccessMessage(false)
                setShowErrorMessage(true)
            }
        }
    
        return(
            <div className="Login">
                <h1>Time To LockIn!!</h1>
                {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}  
                <div className="LoginForm">
                    <div>
                        <label>Username: </label>
                        <input type="text" name="username" value={username} onChange={handleUsernameChange} />  
                    </div>
                    <div>
                        <label>Password: </label>
                        <input type="password" name="password" onChange={handlePasswordChange}/>
                    </div>
                    <div>
                        <button type="button" name="login" onClick={handleSubmit}>Login</button>
                    </div>
                </div>
            </div>
        )
    }
    
    function WelcomeComponent(){
    
        const {username} = useParams()  
    
        return(
            <div className='Welcome'>
                <h1>Welcome {username}</h1>
                <div>
                    <Link to='/todos'> Manage </Link>Your Todos!
                </div>
            </div>
        )
    }
    
    function ErrorComponent(){
        return(
            <div className='Error'>
                <h1>We are working really hard!</h1>
                <div>
                    Please stay in your limits. 
                </div>
            </div>
        )
    }
    
    function ListTodosComponent(){
    
        const today = new Date()
        const targetDate = new Date(today.getFullYear()+1, today.getMonth(), today.getDay())
    
        const todos = [ {id:1, description: 'Learn AWS', done: false, targetDate: targetDate},
                        {id:2, description: 'Learn React', done: false, targetDate: targetDate},
                        {id:3, description: 'Learn Docker', done: false, targetDate: targetDate}
                        ]
    
        return(
            <div className='ListTodosComponent'>
                <h1>Things You Need To Do!!</h1>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Description</td>
                                <td>Is Done?</td>
                                <td>Target Date</td>
                            </tr>
                        </thead>
                        <tbody>
                            
                            {   
                                todos.map(                     
                                    todo => (
                                        <tr key={todo.id}>          
                                            <td>{todo.id}</td>
                                            <td>{todo.description}</td>
                                            <td>{todo.done.toString()}</td>
                                            <td>{todo.targetDate.toDateString()}</td>
                                        </tr>
                                    )
                                )
                            }
    
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
    
    function HeaderComponent(){
        return(
            <div className='header'>
                Header <hr/>
            </div>
        )
    }
    
    function FooterComponent(){
        return(
            <div className='footer'>
                <hr/> Footer
            </div>
        )
    }
    
    function LogoutComponent(){
        return(
            <div className='logoutComponent'>
                <h1>You are logged out!</h1>
                <div>Thank you for your visit.</div>
            </div>
        )
    }
    ```
    

## Adding Bootstrap to our Application

- You can use the command for installing bootstrap
    
    ```xml
    npm install bootstrap
    ```
    
- After installing bootstrap, we would have to copy its path from node_modules, and import it in our index.js so that we can use bootstrap over our complete application.
    
    ![image.png](React%20with%20SpringBoot/image%2065.png)
    
    ```xml
    import 'bootstrap/dist/css/bootstrap.min.css';
    ```
    
- Basic HeaderComponent return
    
    ```xml
    <header className="border-bottom border-light border-5 mb-5 p-2">
                <div className="container">
                    <div className="row">
                        <nav className="navbar navbar-expand-lg">
                            <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://www.linkedin.com/in/abhiraj07/">Abhiraj</a>
                            <div className="collapse navbar-collapse">
                                <ul className="navbar-nav">
                                    <li className="nav-item fs-5"><Link className="nav-link" to="/welcome/Abhiraj">Home</Link></li>
                                    <li className="nav-item fs-5"><Link className="nav-link" to="/todos">Todos</Link></li>
                                </ul>
                            </div>
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5"><Link className="nav-link" to="/login">Login</Link></li>
                                <li className="nav-item fs-5"><Link className="nav-link" to="/logout">Logout</Link></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
    ```
    
- For now we have removed Footer from our application so that we dont have to deal with it much.
- Now, our TodoApp component is becoming too big so we would create separate modules for every component
    
    ![image.png](React%20with%20SpringBoot/image%2066.png)
    

## Auth Context

- Right now, we can access all of our component even if we haven’t logged in using the correct credentials. This means that as soon as we go away from the login component the state of that component disappears, and is not available to use further.
- But we want to use the state of our LoginComponent in our other components as well, this means we have to make a common state for all the components.
- We can create a Context, and share this context with multiple components.
- Right now, we are having our authentication logic in our LoginComponent. What we would do is, we would create a new folder named Security, and inside that we would create another component named “AuthContext.js” in which we would create our context, and apply the authentication logic. Then we would put some state in the context, and share the context with other components.
- To create a context we use a function createContext()
- To share our context with other components we would have to create a function named AuthProvider() and return a JSX tage <AuthContext.Provider>. The AuthContext Component would be the parent of all the components present in the <BrowserRouter>, and hence we would have to pass a {children} in this AuthProvider() function
- To put state in our context we can directly use the useState() hook.
    
    ![image.png](React%20with%20SpringBoot/image%2067.png)
    
    ![image.png](React%20with%20SpringBoot/image%2068.png)
    
    Here we can see that the AuthContext is the parent of all the other contexts, as it wraps around the BrowserRouter
    
- To use AuthContext or AuthProvider in other components we can use a hook useContext()
    
    ![image.png](React%20with%20SpringBoot/image%2069.png)
    
- Here we can see that if we have to use our AuthContext we have to import it from its directory, and also import useContext() hook. Instead what we generally do is we create a hook useAuth() in our AuthContext component which calls useContext() for AuthContext. And when we need to use our AuthContext in other components we directly import our made hook useAuth()
    
    ![image.png](React%20with%20SpringBoot/image%2070.png)
    
    ![image.png](React%20with%20SpringBoot/image%2071.png)
    

### Adding AuthContext in our Application

- We want that the links/buttons on our header are only visible when the login is authenticated. And if the authentication is not yet completed only the login button is visible. Also, when we click the logout button on our header the authentication is again reset.
- For this we would have to create a new state [isAuthenticated, setAuthenticated] in our AuthContext, and then we would use the same logic we applied in displaying the error message in login component to change the visibility of our buttons on header.
- Also we want that whenever the authentication is correct the isAuthenticated is set to true, so we would have to use AuthContext in LoginComponent as well
    
    ![image.png](React%20with%20SpringBoot/image%2072.png)
    
    ![image.png](React%20with%20SpringBoot/image%2073.png)
    
    ![image.png](React%20with%20SpringBoot/image%2074.png)
    

- Now we don’t see the home, todos, or logout button when we are not authenticated
    
    ![image.png](React%20with%20SpringBoot/image%2075.png)
    
- But if we directly go to the url without authentication our todos are still visible
    
    ![image.png](React%20with%20SpringBoot/image%2076.png)
    

- Before adding the authentication functionality, we must bring the login and logout logic into the AuthContext as well.
    
    ![image.png](React%20with%20SpringBoot/image%2077.png)
    
    ![image.png](React%20with%20SpringBoot/image%2078.png)
    
    ![image.png](React%20with%20SpringBoot/image%2079.png)
    
    This allows us to not send the setAuthenticated() outside our AuthContext, and would make our application a little more robust.
    
- Now lets make our urls authenticated. The simplest way of doing that is to create a function named AuthenticatedRoute in TodoApp component which would have an object of children. And return these children only when the authentication is successful (means we would have to import AuthContext in TodoApp as well).
- To add AuthenticatedRoute to our URLs we can use this new component AuthenticatedRoute inside the element attribute of the route of our desired component
    
    ![image.png](React%20with%20SpringBoot/image%2080.png)
    
    ```jsx
    import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
    import LogoutComponent from './LogoutComponent'
    import HeaderComponent from './HeaderComponent'
    import ErrorComponent from './ErrorComponent'
    import WelcomeComponent from './WelcomeComponent'
    import LoginComponent from './LoginComponent'
    import ListTodosComponent from './ListTodosComponent'
    import AuthProvider, { useAuth } from './security/AuthContext'
    
    import './TodoApp.css'
    
    function AuthenticatedRoute({children}){
        const authContext = useAuth()
        const isAuthenticated = authContext.isAuthenticated
        if(isAuthenticated){
            return children
        }else{
            return <Navigate to='/' />
        }
    }
    
    export default function TodoApp(){
        return(
            <div className="TodoApp">
                <AuthProvider>
                    <BrowserRouter>
                        <HeaderComponent />
                        <Routes>
                            <Route path='/' element={<LoginComponent />} />
                            <Route path='/login' element={<LoginComponent />} />
                
                            <Route path='/welcome/:username' element={
                                <AuthenticatedRoute>
                                    <WelcomeComponent />
                                </AuthenticatedRoute>
                                } />  
                            
                            <Route path='/todos' element={
                                <AuthenticatedRoute>
                                    <ListTodosComponent />
                                </AuthenticatedRoute>
                                } />
    
                            <Route path='/logout' element={
                                <AuthenticatedRoute>
                                    <LogoutComponent />
                                </AuthenticatedRoute>
                                } />
                            
                            <Route path='*' element={<ErrorComponent />} />
                        </Routes>
                    </BrowserRouter>
                </AuthProvider>
            </div>
        )
    }
    ```
    
- Now the only thing which is left for this application is performing the basic CRUD operations on Todo list. That can be done using REST-API which we would build using Springboot. Hence now, we would learn how to connect a react application to Springboot or REST-API

# Connecting Springboot REST-API with React Frontend

- First we would learn how to connect our a react front end to a REST-API using a simple Hello World REST-API. And then we would connect our Todo Frontend to a complete Todo REST-API to make it a fullstack application.
- The Hello World REST-API which we would be using here is the same we made while we were learning to make REST-API using Springboot.

## Connecting Spring Boot Hello World REST-API from React Hello World Component

- What we would do is that we would add a button on our WelcomeComponent, which when clicked would invoke the HelloWorld REST-API
- One of the most famous framework which is used to call a REST-API from react is Axios. To install axios in your project you have to use this command
    
    ```jsx
    npm install axios
    ```
    
- 
    
    ![image.png](React%20with%20SpringBoot/image%2081.png)
    
- Now if we click the button which is used to call the REST-API, we would see an error
    
    ![image.png](React%20with%20SpringBoot/image%2082.png)
    
    This error says that the REST-API url has been block by CORS policy. Simply stating that, a website (api) is being called by another website (welcome component) which is not generally allowed
    

### CORS Policy

- To over-write the CORS policy, we would need to make a spring bean of WebMvcConfigurer  (You can use the command ctrl+shift+T and search for it) in  our Springboot application. It would be a function which would return WebMvcConfigurer, and since it is an interface we would have to override a method.
- The method we would be overriding is addCorsMappings(), and we would have to write this code to allow [localhost:3000](http://localhost:3000) (react application) to call everything from [localhost:8080](http://localhost:8080) (springboot application)
    
    ![image.png](React%20with%20SpringBoot/image%2083.png)
    
    ```java
    @Bean
    	public WebMvcConfigurer corsConfigurer() {
    		return new WebMvcConfigurer() {
    			@Override
    			public void addCorsMappings(CorsRegistry registry) {
    				registry.addMapping("/**")
    						.allowedMethods("*")
    						.allowedOrigins("http://localhost:3000/");
    			}
    		};
    ```
    
- Now, if we go to our welcome component, and click the button which calls the REST-API we would be able to do so
    
    ![image.png](React%20with%20SpringBoot/image%2084.png)
    
- It is generally preferred that the calling of REST-API happens in a separate component. Here, the welcome component is the one responsible for calling the REST-API, and it is also responsible for the next steps like if it fails then what, if it passes then what. These whats are okay to be considered in our components, but not the calling.
- Hence we would make a separate file just for the calling of REST-APIs. We would make a new folder inside our todo named api, and create a new file named HelloWorldApiService.js
    
    ![image.png](React%20with%20SpringBoot/image%2085.png)
    
    ![image.png](React%20with%20SpringBoot/image%2086.png)
    

- These are some of the best practices while using axios
    
    ![image.png](React%20with%20SpringBoot/image%2087.png)
    
    ![image.png](React%20with%20SpringBoot/image%2088.png)