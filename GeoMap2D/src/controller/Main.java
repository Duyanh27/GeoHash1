//package controller;
//
//import model.Place;
//import model.map.Map2D;
//import model.services.Service;
//import view.MapView;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        Map2D map = new Map2D();  // Initialize your map data structure
//        MapView view = new MapView();  // Initialize the GUI
//
//        // Adding places with different services at specified locations
//        addPlaceWithService(map, 1000000, 2000000, Service.COFFEE_SHOP);
//        addPlaceWithService(map, 4000000, 3000000, Service.RESTAURANT);
//        addPlaceWithService(map, 3000000, 7000000, Service.GAS_STATION);
//        addPlaceWithService(map, 6000000, 5000000, Service.HOSPITAL);
//        addPlaceWithService(map, 7000000, 8000000, Service.ATM);
//
//        // Define the bounding rectangle to search for Coffee Shops
//        int centerX = 3000000;  // Example center X
//        int centerY = 5000000;  // Example center Y
//        int halfWidth = 1500000;  // Search area width/2
//        int halfHeight = 1500000; // Search area height/2
//
//        // Execute the search
//        List<Place> results = map.search(centerX - halfWidth, centerY - halfHeight, halfWidth * 2, halfHeight * 2, Service.COFFEE_SHOP);
//
//        // Display results on the GUI
//        javax.swing.SwingUtilities.invokeLater(() -> {
//            view.setVisible(true);
//            view.displayResults(results);
//        });
//    }
//
//    // Helper method to add places with specific services to the map
//    private static void addPlaceWithService(Map2D map, int x, int y, Service service) {
//        Set<Service> services = new HashSet<>();
//        services.add(service);
//        Place place = new Place(x, y, services);
//        map.addPlace(place);
//    }
//}
