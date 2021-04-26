# ClickBus - Backend Developer Challenge

This is a simple challenge to test my skills on building APIs. Its functionalities are basiclly create and edit places, as well as get a specific one and list them by name.

## Technologies

- Java 11;
- Spring Boot;
- JPA;
- MySQL.

## Endpoints

### Create a new place

In order to create a new place, you only need to inform its name, city and state by making a post request with the url bellow:

- /api/place/

{
    "name":"Wendy's",
    "city":"Chicago",
    "state":"IL"
}

### Get all places

- /api/place/

### Get a specific place by slug

- /api/place/{place-slug}

### Get places by name

- /api/place/name/{place-name}

### Edit a place

You can optionally update these three attributes by adding the place id next to the url and passing the values you'd like to modify.

- /api/place/{place-id}

{
    "name":"Starbucks Manhattan",
    "city":"New York City",
    "state":"NY"
}

## How to Run

I've provided a test enviroment on Heroko where you can interact with the API by following the endpoint instructions above.
Acesses link: https://quero-ser-clickbus-backend.herokuapp.com/api/place
