# AA Game

A JavaFX-based 2D game built with Maven.

## Description

AA Game is a ball-based game with multiple levels, user profiles, and a scoring system. Players control a big ball to catch or avoid smaller balls across different game levels, with Persian-themed effects.

## Features

- **Multiple game levels** with increasing difficulty
- **User profiles** — register, log in, and customize your avatar
- **Scoreboard** — track high scores across players
- **Settings menu** — adjust game settings
- **Persian-style visual effects**
- **Background music and sound effects**

## Tech Stack

- **Language:** Java 13+
- **Framework:** JavaFX 19
- **Build tool:** Maven
- **JSON:** Gson
- **Media:** JavaFX Media

## Project Structure

```
AA_Game/
├── AA/                          # Main Maven module
│   ├── pom.xml                  # Maven configuration
│   └── src/main/java/
│       ├── module-info.java     # Java module descriptor
│       ├── controller/          # Menu and game controllers
│       ├── model/               # Game logic (BigBall, LittleBall, User, etc.)
│       ├── view/                # UI and game views
│       └── enums/               # Game enums (levels, images)
└── data.json                    # Game data
```

## Getting Started

### Prerequisites

- JDK 13 or later
- Maven 3.6+
- JavaFX 19 SDK

### Build & Run

```bash
cd AA
mvn clean compile
mvn javafx:run
```

Alternatively, open the project in IntelliJ IDEA and run the main class directly.
