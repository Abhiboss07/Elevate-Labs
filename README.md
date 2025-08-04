# Simple Calculator

A basic command-line calculator implemented in Java that performs arithmetic operations on two numbers.

## Features

- **Basic Arithmetic Operations**: Addition (+), Subtraction (-), Multiplication (*), Division (/), and Modulo (%)
- **Interactive Interface**: User-friendly command-line interface with prompts
- **Input Validation**: Handles invalid operators and division by zero
- **Continuous Operation**: Runs continuously until user chooses to exit
- **Exit Functionality**: Type 'x' or 'X' to exit the program

## How to Use

1. **Compile the Program**:
   ```bash
   javac Task1.java
   ```

2. **Run the Program**:
   ```bash
   java Task1
   ```

3. **Follow the Prompts**:
   - Enter an operator (+, -, *, /, %)
   - Enter two numbers when prompted
   - View the result
   - Continue with more calculations or type 'x' to exit

## Example Usage

```
Enter the operator: +
Enter two numbers: 5 3
8

Enter the operator: *
Enter two numbers: 4 6
24

Enter the operator: /
Enter two numbers: 10 2
5

Enter the operator: x
```

## Supported Operations

| Operator | Description | Example |
|----------|-------------|---------|
| `+` | Addition | 5 + 3 = 8 |
| `-` | Subtraction | 10 - 4 = 6 |
| `*` | Multiplication | 6 * 7 = 42 |
| `/` | Division | 15 / 3 = 5 |
| `%` | Modulo (remainder) | 17 % 5 = 2 |
| `x` or `X` | Exit program | - |

## Error Handling

- **Invalid Operator**: Displays "Invalid operation!!" for unsupported operators
- **Division by Zero**: Handles division by zero gracefully
- **Input Validation**: Validates operator input before proceeding

## Requirements

- Java Development Kit (JDK) 8 or higher
- Command line terminal

## File Structure

```
Elevate Lab/
├── Task1.java    # Main calculator program
└── README.md     # This documentation file
```

## Development

This project was created as part of the Elevate Lab internship program. The calculator demonstrates basic Java programming concepts including:

- User input handling with `Scanner`
- Control flow with `if-else` statements
- Loop structures with `while` loops
- Basic arithmetic operations
- Input validation and error handling

## Contributing

Feel free to enhance this calculator by adding more features such as:
- Support for decimal numbers
- Additional mathematical operations (power, square root, etc.)
- History of calculations
- Better error messages
- GUI interface

## License

This project is part of the Elevate Lab internship program. 