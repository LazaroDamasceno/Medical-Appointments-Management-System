# Java's version

|Version|Provider|Where to find|
|:-:|:-:|:-:|
|17|Amazon Corretto|https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc|

# How to dowload (using git) and run

1. Open the CMD 
2. Type `git clone https://github.com/LazaroDamasceno/Medical-Appointments-Management-API.git; cd Medical-Appointments-Management-API; cd v1; ./mvnw clean spring-boot:run`
3. Open a web browser
4. Search on the search bar `localhost:8080/swagger-ui/index.html`

# Warnings

For GET methods, the date time format must be `dd-MM-yyyy HH:mm:ss`. 

For POST, PUT and PATCH methods, the date time format must be `dd/MM/yyyy HH:mm:ss`. 

For the methods `registerPatientController` and `registerPhysicianController`, the date time format must be `dd/MM/yyyy`.

# API running
  