# Memory Game

A Java-based memory matching game that uses Single Linked List data structure. Players match animals from two different lists while competing for high scores.

## 🎮 Game Features

- Dynamic animal pairs matching
- Score tracking system
- High score table
- Colorful console interface
- File-based persistence

## 🛠 Technical Implementation

### Data Structures
- Single Linked List (SLL) implementation
- Custom Node class
- Dynamic memory management

### Core Components
1. **SingleLinkedList Class**
   - UnsortedAdd
   - SortedAdd
   - Delete
   - Search
   - Display operations

2. **Node Class**
   - Data storage
   - Link management
   - Getter/Setter methods

3. **Main Game Logic**
   - Random animal selection
   - Score calculation
   - High score management

## 🎯 How to Play

1. Start the game
2. Enter a number (n) for the size of animal pairs to match
3. The game will create two lists (SLL1 and SLL2) with n matching animals
4. In each turn:
   - Two random positions are selected
   - If animals match:
     - Score increases by 20 points
     - Matched pairs are removed
   - If animals don't match:
     - Score decreases by 1 point
5. Game continues until all pairs are matched
6. Enter your name for the high score table

## 📊 Scoring System

- Successful match: +20 points
- Failed match: -1 point
- High scores are stored and displayed at the end

## 🎨 Console Display

The game uses ANSI colors for better visualization:
- 🔴 Red: Game borders
- 🟢 Green: SLL1 display
- 🔵 Blue: Game over message
- 🟡 Yellow: Random numbers and current player score
- 🟣 Purple: Animal SLL display
- 🔅 Cyan: Welcome message

## 📁 File Requirements

The game requires two text files:
1. `animals.txt`: Contains the list of animals
2. `highscoretable.txt`: Stores the high scores

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- Text editor or IDE (Eclipse, IntelliJ IDEA, etc.)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/barissolcay/Memory-Game.git
