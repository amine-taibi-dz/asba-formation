package de.dplatz.app;

import static org.junit.Assert.assertThat;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

/**
 * HelloIT
 */
public class HealthCheckST {

    WebTarget tut;

    @Before
    public void init() {
        String httpPort = System.getenv("APPSVR_HTTP_PORT") != null ? System.getenv("APPSVR_HTTP_PORT") : "80";
        tut = ClientBuilder.newClient().target("http://localhost:" + httpPort + "/jee-00");
    }

    @Test
    public void should_be_healthy() {
        Response response = tut.path("resources/health").request().get();

        assertThat(response.getStatus(), CoreMatchers.is(200));
        assertThat(response.readEntity(String.class), CoreMatchers.startsWith("UP"));
    }
}