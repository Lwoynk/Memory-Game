# Memory Game

This project implements a simple memory game in Java. Players try to match pairs of animals from two linked lists. The game keeps track of player scores and maintains a high score table.

## Project Overview

The project consists of several Java classes:
- `Main.java`: The main class that runs the game.
- `Node.java`: A class that represents a node in a singly linked list.
- `SingleLinkedList.java`: A class that implements a singly linked list.

### Features

The game includes:
1. Loading animal names from a file into a singly linked list.
2. Creating two linked lists of random animal names.
3. Matching pairs of animals from the two linked lists.
4. Keeping track of player scores.
5. Maintaining a high score table.

## Requirements

The project requires Java Development Kit (JDK) to compile and run the Java files.

## Usage

1. Clone the repository:

    ```bash
    git clone https://github.com/barissolcay/Memory-Game.git
    cd Memory-Game
    ```

2. Ensure you have a file named `animals.txt` in your root directory with the animal names.

3. Compile the Java files:

    ```bash
    javac src/*.java
    ```

4. Run the game:

    ```bash
    java src/Main
    ```

## Game Flow

1. The player is prompted to enter a number `n` between 1 and the size of the list.
2. Two linked lists (`SLL1` and `SLL2`) of random animal names are created.
3. The player attempts to match pairs of animals from `SLL1` and `SLL2`.
4. The game displays the current scores, steps, and the state of the lists after each move.
5. The game ends when all pairs are matched.
6. The player's score is added to the high score table if it is high enough.
7. The player is asked to enter their name for the high score table.

## High Scores

The game maintains a high score table in a text file. The table is sorted in descending order of scores, and the top scores are displayed.

## Contributing

Feel free to open issues or submit pull requests if you have suggestions for improvements or find any bugs.

## License

MIT License

```markdown
MIT License

Copyright (c) 2025 Baris Solcay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
