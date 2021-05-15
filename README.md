## IMC Java home assignment

---

###Problem
Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display
a symbol:

• Fist equals rock

• Open hand equals paper

• Showing the index and middle finger equals scissors.

**The winner is determined by the following schema:**

• Paper beats (wraps) rock

• Rock beats (blunts) scissors

• Scissors beats (cuts) paper.

---

### Built with
* Java 11
* Junit5

---

### Overall architecture
`PaperRockScissors` is the main class of the application. Basically it creates an instance of `GamePlayService` which executes the game.

In the `GamePlayService` construction `Player` instances are creating by Enum Factory Methods via `PlayerFactory` class.
There are 2 different player types and for more flexiblity it creates via factory creation methods which allows to make it either `ComputerPlayer` or `HumanPlayer`

`GameResultService` has the responsibility to make a decision who won the game and also it handles the `GameScore` till ending the game.

### Build & Run

Shell script file provided to build & run.

**For Windows**
```
$ cd $PROJECT_FOLDER
$ start.bat
```

**For Linux / Mac**
```
$ cd $PROJECT_FOLDER
$ ./start.sh
```
