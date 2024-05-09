# Java's version

|Version|Provider|Where to find|
|:-:|:-:|:-:|
|17|Amazon Corretto|https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc|

# How to dowload and run

## With git

1. Open the CMD 
2. Type `git clone https://github.com/LazaroDamasceno/Medical-Appointments-Management-API.git; cd Medical-Appointments-Management-API; cd v1; ./mvnw clean spring-boot:run`
3. Open a web browser
4. Search on the search bar `localhost:8080/swagger-ui/index.html`

## Without git

1. Press on `Code`
2. Press in `Download zip`
3. Select a directory to save the zipped file.
4. Unzip it.
5. Get the path of file.
6. Open the CMD 
7. Copy the path on CMD.
8. Type `cd v1; ./mvnw clean spring-boot:run`
9. Open a web browser
10. Search on the search bar `localhost:8080/swagger-ui/index.html`

# Warnings

## 1st warning

For POST, GET, PUT and PATCH methods, the date time format must be `yyyy-MM-ddTHH:mm:ss`.

yyyy = year<br>
MM = month<br>
dd = day<br>
HH = hour (24 format)<br>
*hh = hour (12 format)<br>
mm = minute<br>
ss = second<br>

For the methods `registerPatientController` and `registerPhysicianController`, the date time format must be `yyyy-MM-dd`. 

The database used is H2. H2 is an in-memory database. In other words, every time it's initialized, it cleans its memory.

## 2nd  warning

To access the H2 database, type on the browser `localhost:8080/h2-console`. When the H2's console is open, type the following:
1. In `JDBC URL`: `jdbc:h2:mem:testdb`
2. In `User Name`: `sa`

## 3td  warning

SSN has 9 digits.

Phyisician license number has 7 digits.

# API running

[https://youtu.be/RdtXYxab4q8](https://youtu.be/RdtXYxab4q8)