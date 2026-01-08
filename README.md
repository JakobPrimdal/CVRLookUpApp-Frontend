CVR Lookup Application
* A JavaFX desktop application for looking up publicly available information about Danish companies using their CVR number.

Features
* Search for Danish companies by CVR number
* Display company information, including name, address, industry, and registration details
* Clean and intuitive user interface
* Real-time data from the official Danish CVR registry

Prerequisites

Java 11 or higher
JavaFX SDK
Maven (for dependency management)
API key for CVR data access

Set up your API key
* Create an "API.key" file in the project config directory - next to the example file
* Note: Never commit this file to version control. It's already included in .gitignore.

Get an API key
* To obtain your own API key, visit Virk.dk and register for API access.

Usage

* Launch the application
* Enter a valid Danish CVR number in the search field
* Click "Search" or press Enter
* View the company information displayed

Example CVR Numbers
For testing purposes, you can use these real Danish companies:

10150817 - Erhvervsstyrelsen
36213728 - Ørsted A/S
54562519 - LEGO A/S

Project Structure
* The project utilizes a three-layered architecture, allowing it to keep a high level of adaptability for potential future features and improvements.

All dependencies are managed through Maven and specified in pom.xml.

Support
If you encounter any issues or have questions:
* Open an issue on GitHub
* Check existing issues for solutions
* Review the API documentation
