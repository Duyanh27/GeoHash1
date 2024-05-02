package model;

import model.util.Point;
import model.util.ArrayList;

public class Place extends Point {
    private String id;
    private ArrayList<String> services;

    public Place(int x, int y, String id, ArrayList<String> services) {
        super(x, y);
        this.id = id;
        this.services = services;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getServices() {
        return services;
    }
}