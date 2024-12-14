package helpers;

import static io.restassured.RestAssured.given;

public class BrowserstackVideoHelper {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_nSLF3V", "PPXoqnxzaV3z94pLSc6C")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
