package de.dplatz.app.business.health.boundary;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class HealthServiceTest {

    @Test
    public void should_be_healthy() {
        HealthService cut = new HealthService();
        assertThat(cut.isHealthy(), CoreMatchers.is(true));
    }
}