# Tic-Tac-Toe (Java, OOP)

A console-based Tic-Tac-Toe game built to demonstrate clean object-oriented design.
Play against a friend or against a computer opponent.

## Features
- Player vs Player and Player vs Computer modes
- Computer AI: wins when it can, blocks your win, takes the centre, otherwise random
- Input validation (out-of-range, occupied cells, non-numeric input)
- JUnit 5 unit tests

## OOP Concepts Used
| Concept | Where |
|---|---|
| **Encapsulation** | `Board` hides the grid and exposes only safe methods |
| **Abstraction** | `Player` defines *what* a player does (`chooseMove`), not *how* |
| **Inheritance** | `HumanPlayer` and `ComputerPlayer` extend `Player` |
| **Polymorphism** | `Game` calls `chooseMove()` without knowing the player type |
| **Single Responsibility** | `Board` = rules/state, `Game` = flow, `Player` = decisions |
| **Enums** | `Symbol`, `GameStatus` |

## Class Diagram
```
            +-----------+
            |  Player   |  (abstract)
            +-----------+
            | name      |
            | symbol    |
            +-----------+
            | chooseMove(Board)
            +-----^-----+
         extends  |  extends
        +---------+----------+
+---------------+     +----------------+
| HumanPlayer   |     | ComputerPlayer |
+---------------+     +----------------+

Game --has--> Board, Player x2, GameStatus
Board --uses--> Symbol
```

## Project Structure
```
TicTacToe/
├── src/com/tictactoe/
│   ├── Main.java
│   ├── Game.java
│   ├── Board.java
│   ├── Player.java
│   ├── HumanPlayer.java
│   ├── ComputerPlayer.java
│   ├── Symbol.java
│   └── GameStatus.java
└── test/com/tictactoe/
    ├── BoardTest.java
    └── ComputerPlayerTest.java
```

## Import into Eclipse
1. Clone the repo: `git clone <your-repo-url>`
2. In Eclipse: **File → Import → General → Existing Projects into Workspace**
3. Select the cloned folder → **Finish**
4. Right-click `Main.java` → **Run As → Java Application**
5. To run tests: right-click the project → **Run As → JUnit Test**

Requires JDK 11 or higher.

## Future Improvements
- Swing/JavaFX GUI
- Minimax (unbeatable) AI
- Score tracking across rounds
- Configurable board size
