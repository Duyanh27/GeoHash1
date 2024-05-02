package model.map;

import model.Place;
import model.util.HashMap;
import model.util.ArrayList;

public class Map2D {
    private HashMap<String, ArrayList<Place>> places;

    public Map2D() {
        places = new HashMap<>();
    }

    public void addPlace(Place place) {
        // Assuming a typical precision value here, e.g., 7
        String hash = GeoHash.encode((double) place.getX(), (double) place.getY(), 7);
        ArrayList<Place> hashedPlaces = places.get(hash);
        if (hashedPlaces == null) {
            hashedPlaces = new ArrayList<>();
            places.put(hash, hashedPlaces);
        }
        hashedPlaces.add(place);
    }

    public ArrayList<Place> searchNearby(int x1, int y1, int x2, int y2, String service) {
        ArrayList<Place> result = new ArrayList<>();
        // Using a precision value consistent with addPlace
        for (int x = x1; x <= x2; x += 1000) {
            for (int y = y1; y <= y2; y += 1000) {
                String hash = GeoHash.encode((double) x, (double) y, 7);
                ArrayList<Place> bucket = places.get(hash);
                if (bucket != null) {
                    for (Place place : bucket) {
                        if (place.getServices().contains(service)) {
                            result.add(place);
                        }
                    }
                }
            }
        }
        return result;
    }
}
