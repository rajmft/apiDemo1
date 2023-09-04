package com.csc340f23.apidemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
		boredApi();
		// System.exit(0);
	}

	public static void boredApi() {
		try {
			String url = "https://www.boredapi.com/api/activity";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			String jSonPrice = restTemplate.getForObject(url, String.class);
			JsonNode root = mapper.readTree(jSonPrice);

			//gets activity name
			String activity = root.findValue("activity").asText();

			//gets type of activity
			String activityType = root.findValue("type").asText();

			//gets number of participants
			String numberOfPeople = root.findValue("participants").asText();

			//print vals
			System.out.println("\nActivity: " + activity);
			System.out.println("Type: " + activityType);
			System.out.println("Participants: " + numberOfPeople);

		} catch (JsonProcessingException ex) {
			System.out.println("error in boredapi");
		}
	}


}
