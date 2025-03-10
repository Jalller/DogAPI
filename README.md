# DogAPI

Rest API intro	Exercises	Dog dictionary API
Meditative dog

The Dog dictionary API exercise
Exercise with javalin and CRUD
In this exercise we want to create a small API for a dog dictionary. 
The API should be able to handle CRUD operations for dogs. 
Just to get our feet wet with REST APIs and Javalin.

Setup project with javalin
Create a new javalin server running on port 7007 that can handle the following routes representing a dog ressource:

Method	Endpoint	Comment
GET	/dog	Returns all dogs from an in-memory collection of dogs (You decide the data structure)
GET	/dog/{id}	Returns a specific dog based on the id
POST	/dog	Creates a new dog
PUT	/dog/{id}	Updates an existing dog
DELETE	/dog/{id}	Deletes an existing dog
This table organizes the endpoints neatly, making it easy to read and understand each method’s purpose.

1: Setup the server so that all dog endpoints are under the path /api/dog

2:Let the dogs live in a map in memory with the id as key and the dog as value.

3: Create a new class called DogDTO.java in a src/main/java/dtos folder with fields: id, name, breed, gender, age.

4: Create a new class called DogController.java in a src/main/java/controllers folder with the following methods:
getAllDogs()
getDogById()
createDog()
updateDog()
deleteDog()

1: Make sure that the server returns json for all endpoints.
2: Make sure to return 404 when a dog is not found.