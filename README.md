# cmsc389T-fall21
​​# Project 2: PacMan
Group Members: Mark Mudimba, Chris Park, Kashif Peshimam, Vibhor Goel


*Insert image here*

To run the pacman program, go to the terminal or command line and type in: 
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

Mark Mudimba:  
- Map move():
- Code: The method takes a name, location, and type and puts the object specified by the name at the location. If the function is able to successfully move the object it returns true, otherwise it returns false.
- Test: This test creates a ghost and Pacman that are next to each other. Then the method move() is called on Pacman to move it to the location where the ghost is. This should return false. Then the move() method is called on Pacman and it is moved to a different location. This should return true since this is a valid location. 
- Ghost is_pacman_in_range()
- Code: This method checks its surroundings to see if Pacman is in attack range. If there are ghosts within one move step then the method returns true, else it will return false. 
- Test: This test creates a ghost and Pacman that are next to each other. When the is_pacman_in_range() method is run, it should return true. Then Pacman moves one coordinate away. The method is run again and it should return false this time since Pacman is not within one move. 

- Pacman is_ghost__in_range()
- Code: This method checks its surroundings to see if any Ghosts are in attack range. If there are ghosts within one move step then the method returns true, else it will return false. 
- Test: This test creates a ghost and Pacman that are next to each other. When the is_ghost_in_range() method is run, it should return true. Then Pacman moves one coordinate away. The method is run again and it should return false this time since Pacman is not within one move. 


Chris Park:
-Ghost move():
-Code: The method calls on get_valid_moves() and if an array of valid moves is returned, will pick the first move as the desired move and will return true. If no moves are given, it will return false.
-Test: The only scenario in which the method will return false is if it were to be fully surrounded by walls. This test places a ghost in a place with only one way out and blocks that way out with a wall before asserting false.
-Map getLoc()
-Code: The method will check if the location is within the wall set or empty set. If not it will pull the loc variable.
-Test: The test creates a ghost, pacman, and wall and makes sure that each asserts the correct type.
-Map attack()
-Code: The method checks to see if the ghost name is in the list of components. If it is, it will run the ghost’s attack method and will return the corresponding boolean value.
-Test: The test creates a ghost and pacman, one unit away from each other and expects an assertion value of true.

Kashif Peshimam:
-Pacman move():
-Code: The function uses get_valid_moves() to get an array of the valid moves. Then it simply takes the first option in the array list and moves in that direction and returns true. If the list is empty meaning there is no valid move, false is returned.
-Test: This test places pacman at location (1,1), then calls move(). Based on the view of the map text file, there is a space to move. So after the move I test that the location is not (1,1).
-Pacman consume():
-Code: This function checks if there is a Cookie at the current location of “this” pacman object, and if so it returns the eatCookie function using “pacman” as the name. The result of this eatCookie function when it works should be a JComponent of the cookie. If there is no cookie at pacman’s current location, null is returned.
-Test: This test places pacman at location (1,1) and then calls consume. Then the test checks if null is not returned, because according to the Map text file there should be a cookie there.
-Map eatCookie():
-Code: This function gets the current location of the string passed in, which would be “pacman”. Then it would check if a cookie and pacman are at the specified location. Then it removes the cookie using cookieID from locations, field, and components. Then it returns the component. If pacman and the cookie are not at the same location, then null is returned.
-Test: This test creates pacman at location (1,1), and uses the frame’s map to call the eatCookie() function. There should be a cookie at pacman’s current location, so the test asserts that null should not be returned. 

Vibhor Goel:
-Pacman getValidMove():
-Code: This function returns the arraylist with all the possible moves of the pacman. It returns true only if all the location tuples are added in the Arraylist.
-Test: The test function adds an invalid location to the result array list and checks if the function returns false as a result.
-Ghost getValidMove():
-Code: This function returns the arraylist with all the possible moves of the Ghost. While the ghost can travel via pacman and other ghosts, it can’t move through walls. It returns true only if all the location tuples are added in the Arraylist.
-Test: The test function adds an invalid location to the result array list and checks if the function returns false as a result
-Ghost attack():
-Code: This function returns a boolean after the ghost is able to attack the pacman. It returns true if it does attack, false otherwise.
-Test: Pacman is located at an invalid location. The function returns false since the pacman is out of range of pacman, and cannot attack.
