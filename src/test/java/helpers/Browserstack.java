package helpers;

import config.ProjectConfig;
import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static URL browserstackUrl() {
        try {
            return new URL(String.format(ProjectConfig.get.hubUrl(),
                    ProjectConfig.get.user(), ProjectConfig.get.key()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(ProjectConfig.get.user(), ProjectConfig.get.key())
                .when()
                .get(ProjectConfig.get.sessionUrl() + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}