package com.hcld2.jwtdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JwtdemoApplicationTests {

	@Autowired
	private Environment environment;

	@Test
	void contextLoads() {
	}

	@Test
	void swaggerUiAndOpenApiDocsArePublic() throws Exception {
		int port = environment.getProperty("local.server.port", Integer.class);
		HttpClient client = HttpClient.newHttpClient();

		for (String path : new String[]{"/swagger-ui/index.html", "/v3/api-docs"}) {
			HttpRequest request = HttpRequest.newBuilder(
					URI.create("http://localhost:" + port + path)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			assertEquals(200, response.statusCode(), path);
		}
	}
}
