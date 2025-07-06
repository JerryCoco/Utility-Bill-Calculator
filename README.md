# Utility Bill Calculator

## Overview
A Java Swing application that calculates water and electricity bills based on usage, with tiered pricing rates. The application provides a simple GUI for inputting consumption values and displays calculated bills.

## Features
- **Water Bill Calculation**:
  - First 500 gallons free
  - Additional gallons charged at $1.05 per gallon
- **Electricity Bill Calculation**:
  - First 50 kWh free
  - Next 100 kWh charged at $0.50 per kWh
  - Additional kWh charged at $1.20 per kWh
- **GUI Interface**:
  - Input fields for water (gallons) and electricity (kWh) usage
  - Displays calculated water bill, electricity bill, and total amount
  - Action buttons (Calculate, New, Exit)

## Requirements
- Java 23 or later
- MySQL Connector/J 8.3.0 (for database functionality - currently simulated)

## Installation
1. Clone or download the project
2. Ensure MySQL Connector/J is in your classpath (included in project properties)
3. Compile and run the `UtilityBillCalculator` class

## Usage
1. Enter water usage in gallons
2. Enter electricity usage in kilowatt-hours (kWh)
3. Click "Calculate" to see bill breakdown
4. Use "New" to save results (currently shows simulated save dialog)
5. "Exit" closes the application

## Database Integration (Future Enhancement)
The current version simulates database saving. To implement actual database functionality:
1. Uncomment database-related code
2. Configure your MySQL connection in the `saveToDatabase()` method
3. Create appropriate database tables

## License
This project is currently unlicensed. 

## Known Issues
- No input validation beyond number format checking
- Database functionality is simulated
- No unit tests currently implemented

## Future Improvements
- Proper database persistence
- Implement input validation
- Add printing functionality
- Support for multiple rate structures
- User authentication system

## Author
[Jeremiah Abban]
