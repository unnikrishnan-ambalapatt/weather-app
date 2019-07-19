# weather-app
 Simple Spring Boot app that fetches weather information from openweathermap.org

Instructions to run locally

Option 1: Run from IDE: Import the code as Maven project in an IDE and run the following class as Java application: com.weather.weatherapp.WeatherAppApplication.

Option 2: Run as jar: Run the following jar file using java command: target/weather-app-0.0.1-SNAPSHOT.jar.
Command to use: java -jar weather-app-0.0.1-SNAPSHOT.jar

Although against best practices, the jar was committed to enable easy running of the app.

URL to access locally: http://localhost:8090

Future enhancement

The sample cities and their city ids are hard coded in client code. This could be moved to a database and fetched at run time to populate the list of cities in the UI.
