package de.dplatz.app.business.health.boundary;

import javax.ejb.Stateless;

@Stateless
public class HealthService {

    public boolean isHealthy() {
        return true;
    }
}