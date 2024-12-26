package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    // Метод для запису об'єкта університету в файл JSON
    public static void writeToJsonFile(String filePath, University university) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(university, writer);  // Перетворює об'єкт у формат JSON і записує в файл
        }
    }

    // Метод для зчитування об'єкта університету з JSON-файлу
    public static University readFromJsonFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, University.class);  // Відновлює об'єкт із JSON
        }
    }
}
