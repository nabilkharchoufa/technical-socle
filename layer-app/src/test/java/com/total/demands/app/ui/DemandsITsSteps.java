package com.total.demands.app.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ITConfiguration.class)
@TestPropertySource(
        locations = "classpath:application-IT.properties")
public class DemandsITsSteps {

    private TestRestTemplate restTemplate;

    private DemandsWorld resourceRequestWorld;

    public DemandsITsSteps(TestRestTemplate restTemplate, DemandsWorld resourceRequestWorld) {
        this.restTemplate = restTemplate;
        this.resourceRequestWorld = resourceRequestWorld;
    }

    @Given("^a DemandsDomain with title \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void aDemandsWithTitleAndDescription(String title, String description) throws JSONException {

        JSONObject request = new JSONObject();
        request.put("title", title);
        request.put("description", description);
        request.put("dueDate", 12334);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("/resources-requests", HttpMethod.POST, entity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONObject object = new JSONObject(responseEntity.getBody());
        Long id = object.getLong("id");

        assertThat(id).isNotNull();
        resourceRequestWorld.resourceRequestId = id;
    }

    @When("^User read previously created DemandsDomain$")
    public void readPreviouslyCreatedDemands() throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("/resourceRequests/" + resourceRequestWorld.resourceRequestId, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        JSONObject object = new JSONObject(responseEntity.getBody());
        resourceRequestWorld.readTitle = object.getString("title");
        resourceRequestWorld.readDescription = object.getString("description");
    }

    @Then("^title is \"([^\"]*)\" and description is \"([^\"]*)\"$")
    public void titleIsAndDescriptionIs(String title, String description) {
        assertThat(resourceRequestWorld.readTitle).isEqualTo(title);
        assertThat(resourceRequestWorld.readDescription).isEqualTo(description);

    }

    @When("^User Change description of previously created DemandsDomain with Title \"([^\"]*)\" and description to \"([^\"]*)\"$")
    public void userChangeDescriptionOfPreviouslyCreatedDemandsWithTitleAndDescriptionTo(String title, String description) throws Throwable {

        JSONObject request = new JSONObject();
        request.put("title", title);
        request.put("description", description);
        request.put("dueDate", 12334);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("/resourceRequests/" + resourceRequestWorld.resourceRequestId, HttpMethod.PUT, entity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT
        );
    }
}
