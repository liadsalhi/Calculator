# Calculator

A simple calculator app for Android, built with **Kotlin** and **Jetpack Compose**.
The project follows the **MVVM** pattern and is split into clear layers, so each part is easy to understand, test and change.

## Features

- Basic math: `+`, `-`, `*`, `/`
- Order of operations and parentheses (for example, `2+3*4` = `14`)
- Delete the last character or clear everything
- Clean results: `5` instead of `5.0`
- Invalid input shows `Syntax ERROR` instead of crashing
- The expression is kept when the screen rotates

## Tech Stack

| Tool | Used for |
| --- | --- |
| Kotlin | Programming language |
| Jetpack Compose | User interface |
| ViewModel + StateFlow | Holding the screen state |
| [exp4j](https://github.com/fasseg/exp4j) | Calculating the math expression |

## Architecture

The code is split into three layers:

```
com.example.calculator
├── domain
│   └── Calc.kt                  // interface: "something that can solve an expression"
├── data
│   └── Exp4jCalc.kt             // implementation of Calc using the exp4j library
└── presentation
    ├── CalculatorState.kt       // what the screen shows
    ├── CalculatorAction.kt      // what the user can do
    ├── CalculatorViewModel.kt   // handles actions and updates the state
    └── CalculatorScreen.kt      // the Compose UI
```

## Coming Next

- **Scientific calculator:** turn the phone sideways to open a scientific calculator. It adds more buttons, like `sin`, `cos`, `log`, `√` and `π`, next to the regular buttons.
- **Solve from a photo:** open the phone camera, take a picture of a math exercise, and the app reads it as text and puts it into the calculator.
