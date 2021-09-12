
MVC Spring boot project that makes use of PostgreSQL as remote database.
The purpose of this project is to fully understand the process of making and consuming web services, with Kotlin Android as a front-end (this app will appear here soon).

<h3>Project structure</h3>        
main <br>
└── rabbitbank <br>
    ├── config --> For Swagger <br>
    ├── converters --> Entities<->dtos <br>
    ├── dto --> part of the view to communicate with the mobile app <br>
    ├── exceptions <br>
    ├── model <br>
    ├── repository <br>
    ├── resource <br>
    ├── service <br>
    └── utils <br>
└── resources <br>
    └── application.yml <br>
    
<h3>To run the project: </h3> 
run -> mvn spring-boot:run
User: user <br>
Password: scroll up your cmd and copy the key after "Using generated security password: "

<h3>Docs: </h3> 

![](https://user-images.githubusercontent.com/58961790/133006685-e38fb649-5377-47ac-ad6a-c76c0d0ec32b.png)

<h3>Authentication: </h3> 
JWT pattern to authenticate users.

<h3>To be done: </h3> 
Unit tests.
