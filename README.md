# CAPSTONE Project
This is the official Capstone project for group 22 - Applications Development Practice.
Our application is a Restaurant Management system, that allows employees and administrators to view and edit,
Student Accounts, Meals, Orders and Restaurant information (if needed).

Thank you for viewing this web application 🙂

# How to run 
To install, simply unpack the zip file and locate the `RestaurantManagementApp.java` file under `src` directory:
```
+---src
|   +---main
|   |   +---java
|   |   |   \---za
|   |   |       \---ac
|   |   |           \---cput
|   |   |               |   RestaurantManagementApp.java
```

# How to find files
Our project uses convention based folder names and structures:

```
|   pom.xml
|   README.md
|           
+---src
|   +---main
|   |   +---java
|   |   |   \---za
|   |   |       \---ac
|   |   |           \---cput
|   |   |               |   Main.java
|   |   |               |   
|   |   |               +---Controller
|   |   |               |       AdminController.java
|   |   |               |       EmployeeController.java
|   |   |               |       IndexController.java
|   |   |               |       LoginController.java
|   |   |               |       MainController.java
|   |   |               |       MealController.java
|   |   |               |       OrderController.java
|   |   |               |       PaymentController.java
|   |   |               |       RestaurantController.java
|   |   |               |       StudentAccountController.java
|   |   |               |       StudentController.java
|   |   |               |       
|   |   |               +---Domain
|   |   |               |   \---Entity
|   |   |               |       |   Admin.java
|   |   |               |       |   Employee.java
|   |   |               |       |   Meal.java
|   |   |               |       |   Order.java
|   |   |               |       |   Payment.java
|   |   |               |       |   Restaurant.java
|   |   |               |       |   Student.java
|   |   |               |       |   StudentAccount.java
|   |   |               |       |   
|   |   |               |       \---Util
|   |   |               |               Validation.java
|   |   |               |               
|   |   |               +---Factory
|   |   |               |       AdminFactory.java
|   |   |               |       EmployeeFactory.java
|   |   |               |       MealFactory.java
|   |   |               |       OrderFactory.java
|   |   |               |       PaymentFactory.java
|   |   |               |       RestaurantFactory.java
|   |   |               |       StudentAccountFactory.java
|   |   |               |       StudentFactory.java
|   |   |               |       
|   |   |               +---Repository
|   |   |               |       AdminRepository.java
|   |   |               |       EmployeeRepository.java
|   |   |               |       MealRepository.java
|   |   |               |       OrderRepository.java
|   |   |               |       PaymentRepository.java
|   |   |               |       RestaurantRepository.java
|   |   |               |       StudentAccountRepository.java
|   |   |               |       StudentRepository.java
|   |   |               |       
|   |   |               +---Security
|   |   |               |       AuthEntryPoint.java
|   |   |               |       ResponseFilter.java
|   |   |               |       WebSecurityConfig.java
|   |   |               |       
|   |   |               \---Service
|   |   |                   |   IService.java
|   |   |                   |   
|   |   |                   \---Impl
|   |   |                           AdminService.java
|   |   |                           AdminServiceImpl.java
|   |   |                           EmployeeService.java
|   |   |                           EmployeeServiceImpl.java
|   |   |                           MealService.java
|   |   |                           MealServiceImpl.java
|   |   |                           OrderService.java
|   |   |                           OrderServiceImpl.java
|   |   |                           PaymentService.java
|   |   |                           PaymentServiceImpl.java
|   |   |                           RestaurantService.java
|   |   |                           RestaurantServiceImpl.java
|   |   |                           StudentAccountService.java
|   |   |                           StudentAccountServiceImpl.java
|   |   |                           StudentService.java
|   |   |                           StudentServiceImpl.java
|   |   |                           
|   |   \---resources
|   |       |   application.properties
|   |       |   
|   |       +---static
|   |       |   \---css
|   |       |           index-not-logged-in.css
|   |       |           login.css
|   |       |           navbar.css
|   |       |           
|   |       \---templates
|   |           |   Error.html
|   |           |   index.html
|   |           |   Login.html
|   |           |   Main.html
|   |           |   
|   |           \---fragments
|   |                   navbar.html
|   |                   
|   \---test
|       \---java
|           \---za
|               \---ac
|                   \---cput
|                       |   MainTest.java
|                       |   
|                       +---Controller
|                       |       AdminControllerTest.java
|                       |       IndexContollerTest.java
|                       |       PaymentControllerTest.java
|                       |       StudentAccountControllerTest.java
|                       |       StudentControllerTest.java
|                       |       
|                       +---Domain
|                       |   \---Entity
|                       |           AdminTest.java
|                       |           MealTest.java
|                       |           OrderTest.java
|                       |           PaymentTest.java
|                       |           StudentAccountTest.java
|                       |           StudentTest.java
|                       |           
|                       +---Factory
|                       |       AdminFactoryTest.java
|                       |       MealFactoryTest.java
|                       |       OrderFactoryTest.java
|                       |       PaymentFactoryTest.java
|                       |       RestaurantFactoryTest.java
|                       |       StudentAccountFactoryTest.java
|                       |       StudentFactoryTest.java
|                       |       
|                       \---Service
|                           \---Impl
|                                   AdminServiceImplTest.java
|                                   EmployeeServiceImplTest.java
|                                   PaymentServiceImplTest.java
|                                   StudentAccountServiceImplTest.java
|                                   StudentServiceImplTest.java
|                                   
```



Our UML entities are:
---------------------
![UML team entities](https://user-images.githubusercontent.com/80794017/161523048-b0dee54c-eb4b-455d-9dcf-01e041601a2a.PNG)
---------------------
