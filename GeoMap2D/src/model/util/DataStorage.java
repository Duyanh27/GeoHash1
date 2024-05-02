package model.util;

import model.Place;
import java.io.*;
import model.util.ArrayList;

public class DataStorage {

    public static void savePlaces(ArrayList<Place> places, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Place place : places) {
                writer.write(placeToJson(place) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String placeToJson(Place place) {
        return String.format("{\"x\":%d,\"y\":%d,\"id\":\"%s\",\"services\":%s}",
                place.getX(), place.getY(), place.getId(), servicesToJson(place.getServices()));
    }

    private static String servicesToJson(ArrayList<String> services) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < services.size(); i++) {
            sb.append("\"").append(services.get(i)).append("\"");
            if (i < services.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static ArrayList<Place> loadPlaces(String filename) {
        ArrayList<Place> places = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                places.add(parseJsonToPlace(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return places;
    }

    private static Place parseJsonToPlace(String json) {
        // This needs to be implemented to accurately parse the JSON.
        return new Place(0, 0, "id", new ArrayList<>());  // Simplified
    }
}

