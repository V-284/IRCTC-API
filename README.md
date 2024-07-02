Run Project as Desired.

This is Spring Boot based (IRCTC like) Reservation RESTful APIS.

Requirements :- Postman, IntelliJ, MySQL Workbench

1)Install IntelliJ Editor,
2)Download Zip Folder
3)Open pom.xml File From IntelliJ
4)Let it download Dependencies automatically.
5)Download and Configure MySQL Workbench
6)Create scheme name irctc in MySQL
7)Install Postman
8)Start Tomcat Server From IntelliJ
9)run localhost:8080
10)Enjoy

1) To register user
hit url localhost:8080/register with POST Action
Body raw(JSON)

{
"username": "<anyname>",
"passwrod":"<anypassword",
}
click on Send

2) To login
hit url localhost:8080/login

{
"username" :"<>",
"password" :"<>",
}

you will get Authorization Code here which you need to add in Bearer Token to access any api without authentication

3)
To access admin apis, visit application.properties and fetch myapi-key and myapi-secret and add it to header 

4) to add trains add in given format JSON in Postman while hitting localhost:8080/addtrain 

{ "name": "shivganga",
"trainnumber": 12560,
"source": "varanasi",
"destination":"newdelhi",
"midstation":["prayagraj","kanpur"]
}



NOTE :- All APIs are working 100%
if you need any help, 
reach 1vishnuverma1@gmail.com

