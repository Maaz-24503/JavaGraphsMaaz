# Group 3 Project
## Object-Oriented Programming Project

### Group Members
Muhammad Bilal 24443  
Maaz Karim 24503  

### Changes from the UML  
##### Bar.java  
We change the type of value from integer to a double. So that it also works with real values. The setter and getters have been changed to accommodate this.

##### Graph.java
We hava a function isVertical, to check whether the graph is vertical or horizontal, when the change button is pressed.

#### JavaGraphs.java
We added a JButton to be displayed on the screen. We added two more functions,ifButtonPressed() and resetScreen(), so that the code looks more clean. A boolean type called isPressed was also added to check whether the button is pressed.


### How the code works
Data is taken from the data.txt file in main and then stored in a 2d array. From there the data is converted and stored in form of a list of bars. A graph Area is set and the default setting for is HorizontalBar graph. After a certain time delay, the actionPerformed() function is called. The function increases the height(or width) by a small amount everytime the function is called.This works as an animation.
Eventually the width(or height) reaches it maximum value that is calculated and then the animation stops.
When the button is pressed, a boolean value is set as true and then the function runs in the actionPerformed. The function first checks
whether it is horizontal or vertical and then changed the graph accordingly.
