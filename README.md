# Project Title: MagiWorld

MagiWorld is a French game with 3 characters: Warrior (Guerrier), Thief (Rôdeur), and Magician (Mage). 
We run the game by choosing 2 players in the beginning. Each player has a role of one of the characters above.

Each character has specific capacities defined by a combination of 5 features:
* Life = Level * 5
* Level = Strength + Agility + Intelligence
* Strength 
* Agility
* Intelligence
 
Each character owns 2 kinds of attacks: 

* Warrior: 
    - While he launches a basic attack (Sword Strike):  His enemy will get damage equal to his strength. 
    - While he launches a special attack (Anger Strike): His enemy will get damage equal to twice of his strength. 
                                                       			The player will, as for him, lose vitality equal to half of his strength.
* Thief: 
    - While he launches a basic attack (Archery):  His enemy will get damage equal to his agility. 
    - While he launches a special attack (Concentration):  The player will gain ability equal to twice of his level.

* Magician: 
    - While he launches a basic attack (Fireball):  His enemy will get damage equal to his intelligence. 
    - While he launches a special attack (Care):  The player will gain vitality equal to twice of his intelligence. The new vitality should not be greater than the old one. 

## Getting Started

You can run the game in an IDE of Java such as IntelliJ and Eclipse. 


### Prerequisites

To run a Java program in your Command Prompt, first, you need to have JDK (Java Development Toolkit) installed. You can download the last version on the website of Oracle: https://www.oracle.com/technetwork/java/javase/downloads/index.html. 

Secondly, you need to configure your environment variable so that Command Prompt can find where JDK has been installed. You can refer to this web page for the configuration: https://javatutorial.net/set-java-home-windows-10 

Thirdly, please install an IDE such as IntelliJ and Eclipse.

Finally, for the quality of the game, we strongly recommend that you run the game with Windows 8 or 10. 

### Installing

Download the game from Github: https://github.com/jwglimois/MagiWorld

Once entering to this web page, you click on "clone". You can save it to your repository.

## Running the tests

The unit tests have been created all the classes. Check the repository where you can find the test files: https://github.com/jwglimois/MagiWorld/tree/master/src/test/java/MagiWorld


## Deployment

To deploy this game on a live system, make sure to have JDK installed and environment variable configured for Java programs.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit5](https://junit.org/junit5/) - Used to generate unit tests
* [JavaDoc](https://docs.oracle.com/javase/7/docs/api/) - Documentation generator to describe each class


## Versioning

Version 1.0 21/10/2019, in Paris
We use [Git](https://git-scm.com/) for versioning. For the version available, see our last project on: https://github.com/jwglimois/EscapeGame.

## Author

* **Jia-Wen GLIMOIS** 

## License

This game is an open source project without license.
