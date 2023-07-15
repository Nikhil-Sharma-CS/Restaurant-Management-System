
# Restaurant-Management-System 

This is the code for Restaurant-Management-System, this contains various types of mappings as **One to One**, **Many to One**, **Many to Many**.

This also uses **Relational Data** and **JPA** for data source

This Project also uses **Sign-In**, **Sign-Up**, **Sign-Out** functionalities.



## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer trainee at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot.


# Data Flow

## Controller
-   *This section contains 4 classes which uses APIs as mentioned below* :

* ### AdminController Class

    * @PostMapping("adminSignUp")
    * @PostMapping("adminSignIn")
    * @DeleteMapping("adminSignOut")

* ### UserController Class

    * @PostMapping("userSignUp")
    * @PostMapping("userSignIn")
    * @DeleteMapping("userSignOut")

* ### OrderController Class

    * @PostMapping("addOrder")
    * @DeleteMapping("deleteOrder/{Id}")
    * @GetMapping("seeOrders/{id}")
    * @PutMapping("editOrderStatus/{orderId}")

* ### FoodController Class

    * @GetMapping("foodItem")
    * @PostMapping("addFoodItem")

## Services
-  *This section contains 5 classs with functions that helps API to perform their specific tasks* : 

* ### AdminService Class

    * checkValid(String email) 
    * SignUpOutput signUpAdmin(Admin admin)
    * adminSignIn(SignInInput signInInput)
    * adminSignOut(String email)

* ### FoodItemService Class

    * List<FoodItem> foodItems()
    * addFoodItem(List<FoodItem> foodItems)

* ### OrdersService Class

    * addOrders(Orders orders)
    * deleteOrder(Integer Id)
    * seeOrder(Integer id, String email)
    * editOrderStatus(Integer id, Status status)

* ### UserService Class
    
    * signUpUser(User user)
    * userSignIn(SignInInput signInInput)
    * userSignOut(String email)

* ### AuthenticationService Class
    
    * authenticate(String email, String authTokenValue)
    * boolean authenticateAdmin(String email, String token)

## Model
- *This section contains 5 models as required by project named **Admin**, **FoodItem**, **Orders**, **Status**, **User**, **AuthenticationToken**. Each have their relative datamembers in them which will be used as columns to store their respective data*.

- *This also contains a DTO with 2 classes **SignInInput** and **SignUpOutput**. They help in accomplishing sign-in, sign-out sign-up functionalities.*

##  Repository
- *This section contains 5 **Interfaces** named IAdminRepo, IFoodItemRepo, IAuthTokenRepo, IOrdersRepo, IUserRepo*

- *All of these extends JpaRepository Interface*.


## Database Design
- *In this section we used the models as mentioned in Model section, which are used as a table to store data*.
- *It also uses **Relational Database** and **JPA** to create datastructure*.
- *We use **MYSQL** which is a management system for relational data*

## Data Structure Used

- *We used **Relational database** along with **JPA** as the data source in this project*.

- *Relational Data is stored in form of tables which further can be connected via various types of mappings/relations, such as One to One, One to Many, etc*.

- *This kind of data persists forever and we use **SQL** to manipulate this data via MYSQL.*

- *Here we also used the concept of **Mapping** which uses **Foreign Keys** to define relation between 2 tables.*
## Summary

*This project performs the task of managing Orders with various types of API's like **Get, Post, Put, Delete***.

*This project is also connected to a relational data which is the data source of this project.*

*We used **MVC Architecture** to create this project. 
And this is created in **SpringBoot** using **Maven** and **Java**.*

*Here a user can singup and login using **email** and **password**, and they can also place orders via credentials.*


## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)


