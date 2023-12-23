package com.itis.javafxaplicattion;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherWindowController {

    @FXML
    private TextField textField;

    @FXML
    public void onCitySubmit(ActionEvent event) {
        String enteredCity = textField.getText();

        try {
            JsonNode weatherData = getCityWeather(enteredCity);
            if (weatherData != null) {
                Stage newStage = new Stage();
                VBox vbox = new VBox();
                Scene scene = new Scene(vbox, 400, 300);
                ImageView weatherIcon = new ImageView();
                System.out.println(weatherData.get("weather").get(0).get("icon").asText());
                String iconUrl = "http://openweathermap.org/img/wn/" + weatherData.get("weather").get(0).get("icon").asText() + "@2x.png";
                Image icon = new Image(iconUrl);
                weatherIcon.setImage(icon);

                System.out.println(weatherData);
                Label cityLabel = new Label("City: " + weatherData.get("name").asText());
                Label temperatureLabel = new Label("Temperature: " + Math.round(weatherData.get("main").get("temp").asDouble() - 273) + "°C");
                Label feelsLikeLabel = new Label("Feels Like: " + Math.round(weatherData.get("main").get("feels_like").asDouble() - 273) + "°C");
                Label minTempLabel = new Label("Min Temperature: " + Math.round(weatherData.get("main").get("temp_min").asDouble() - 273) + "°C");
                Label maxTempLabel = new Label("Max Temperature: " + Math.round(weatherData.get("main").get("temp_max").asDouble() - 273)+ "°C");
                Label pressureLabel = new Label("Pressure: " + weatherData.get("main").get("pressure").asDouble() + " hPa");
                Label descriptionLabel = new Label("Description: " + weatherData.get("weather").get(0).get("description").asText());
                Label humidityLabel = new Label("Humidity: " + weatherData.get("main").get("humidity").asInt() + "%");
                Label windSpeedLabel = new Label("Wind Speed: " + weatherData.get("wind").get("speed").asDouble() + " m/s");

                vbox.getChildren().addAll(weatherIcon, cityLabel,
                        temperatureLabel, feelsLikeLabel, minTempLabel, maxTempLabel, pressureLabel,
                        descriptionLabel, humidityLabel, windSpeedLabel
                );

                newStage.setScene(scene);
                newStage.setTitle("Weather Information");
                newStage.show();
            } else {
                System.out.println("Error: Unable to retrieve weather data.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonNode getCityWeather(String city) throws IOException {
        String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=5f5a9a788cc70316af3c41981ba2f54e";
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(responseStream);
        } else {
            System.out.println("Error: HTTP response code " + responseCode);
            return null;
        }
    }
}
