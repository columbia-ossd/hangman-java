# Hangman Java Game

A command-line Hangman game written in Java.

The game randomly selects a city in Washington State, and the player guesses one letter at a time.

## Requirements

- Java 17 or later

Check your Java version:

```bash
java --version
```

---

## Running the Game

### 1. Clone the repository

```bash
git clone <repository-url>
cd hangman-java
```

### 2. Compile the source files

```bash
javac src/*.java
```

This will generate `.class` files in the `src` directory.

### 3. Run the game

```bash
java -cp src Main
```

### Example

```bash
javac src/*.java
java -cp src Main
```

---

## Project Structure

```text
hangman-java/
├── src/
│   ├── Main.java
│   ├── Game.java
│   ├── Drawing.java
│   └── Dictionary.java
└── README.md
```

--- 

# Notes
Please do not commit .class files to the repo! You should only commit .java files.

# Communication
The Slack channel for this project is _#hangman-java-1_

Please use that channel for communicating with other contributors.

