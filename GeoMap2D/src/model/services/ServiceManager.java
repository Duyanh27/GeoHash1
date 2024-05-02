package model.services;

import java.util.EnumSet;

public class ServiceManager {
    private EnumSet<Service> availableServices;

    public ServiceManager() {
        availableServices = EnumSet.allOf(Service.class);
    }

    public EnumSet<Service> getAvailableServices() {
        return availableServices;
    }
}
