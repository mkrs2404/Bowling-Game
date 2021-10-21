## Assumptions
 - Input to be provided through a file "input.txt" in src/main/resources
 - The input provided should be of the form [10,0] for the frame in case a strike was made.
 - The inputs should be "," (comma) separated.

 ## Design
 
 - Each throw is recorded into an arraylist to process further.
 - In the case of strikes, redundant inputs (zero) are provided which are taken care by the transformInput() method.
 - score and throwsList are members of the BowlingGame class.

 ## How to run
 - It is a Spring Boot maven based app.
 - It requires Java 11 and maven installed in your system.
 - Go to the directory Bowling-Game\bowling and execute `mvn spring-boot:run`
 - You can also run it through an IDE. The entry point for this Spring Boot app is BowlingApplication class
 - You'll get the outputs as per the input in input.txt file
 - To run the tests, execute `mvn test` in the same directory.
