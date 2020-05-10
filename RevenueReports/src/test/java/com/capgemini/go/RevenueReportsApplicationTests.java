package com.capgemini.go;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.go.entity.RevenueReport;

@SpringBootTest

public class RevenueReportsApplicationTests {

	@Test
	public void contextLoads() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 4545 + "/Reports/RevenueReport/2018-01-01/2021-01-01/mountaineering";
		URI uri = new URI(baseUrl);

		ResponseEntity<RevenueReport[]> datalist = restTemplate.getForEntity(uri, RevenueReport[].class);
		RevenueReport[] data = datalist.getBody();
		assertNotEquals(2, data.length);

	}

	@Test
	public void revenueData() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 4545 + "/Reports/RevenueReport/2019-06-01/2020-01-01/mountaineering";
		URI uri = new URI(baseUrl);

		ResponseEntity<RevenueReport[]> datalist = restTemplate.getForEntity(uri, RevenueReport[].class);
		RevenueReport[] data = datalist.getBody();
		assertEquals(4, data.length);

	}
}