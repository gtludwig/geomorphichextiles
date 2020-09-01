# Geomorphichextiles

## Context
During the 2020 pandemic, most social gatherings were subject to social distancing rules.

The same set of rules apply for hobbies, in particular those that normally take place around a desk with a small group of people.

To address the social distancing barrier, many of these enthusiasts started using virtual table-top (VTT) systems where a grid is place on top of a map. This map is either imported to VTT platform or drawn into it.   

The initial goal of this project is to implement a set of rules for hexagonal geomorphic tiles. In order to define what tiles can be placed adjacent to one another in any of the six faces, both tiles need to have matching contact faces in those directions. This is achieved by a feature called face signature - only when two signatures match, the tiles can be placed next to each other.

A hexagonal tile has six sides, faces A to F, like so:

Face | Position
---- | --------
A | top
B | top right
C | bottom right
D | bottom
E | bottom left
F | top left

After selecting the first tile (FT), all tiles with any face that matches one of the six will be loaded into a set.

Once the second tile, adjacent to the first, is selected, the other sets are updated to match the two face signatures already defined.

All the remaining sets will be updated according to two, three, four, five or six face signatures, depending on the position of the tile and its neighbours.

As an example, the tile with identity "xpto" has the following face signatures [a, b, c, d, e, f]. The set of allowed tiles that can match face A contains all tiles that have a face signature of [a], in any face. The tiles can be rotated 0, 60, 120, 180, 240 or 300 degrees.

A tile with identity "yyz" that matches the signature was selected. The set of tiles that can be selected for positions next to faces B and F of tile "xpto" are the ones that have a face signature of [b] **AND** match the signature matches the face of "yyz" at face C.  

This process is repeated for all the tiles of the map.

Once the grid is validated, an image of each tile is rendered onto the map, and an image can be exported. 

## Running the project
This is a maven project built with Spring Boot. Once cloned, the project can be started with

`$ mvn clean install`

`$ mvn spring-boot:run`

Once up, a very simple web interface can be accessed at: http://localhost:8080

For the documentation of the API Swagger can be accessed at: http://localhost:8080/swagger-ui.html 

 Finally, some test data can be created by hitting the endpoints:
 
 1. GET http://localhost:8080/api/faces/createOneRandomFace
 2. GET http://localhost:8080/api/faces/createRandomFaces/{numberOfFaces}
 3. GET http://localhost:8080/api/tiles/createOneRandomTile
 4. GET http://localhost:8080/api/tiles/createRandomTiles/{numberOfTiles}
 
 ## Disclaimer
 This project is under heavy development and all features are subject to change.