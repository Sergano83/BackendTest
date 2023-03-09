package Lesson3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    @BeforeAll
    static void setUp() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    static Properties prop = new Properties();
        private static String apiKey;
        private static String baseUrl;
        private static String profileUrl;

        @BeforeAll
        static void initTest() throws IOException {
            InputStream configFile = new FileInputStream("src/main/resources/test.properties");
            prop.load(configFile);

            apiKey =  prop.getProperty("apiKey");
            baseUrl = prop.getProperty("base_url");
            profileUrl = prop.getProperty("profile_Url");
        }

        public static String getApiKey() {
            return apiKey;
        }

        public static String getBaseUrl() {
            return baseUrl;
        }
        public static String getProfileUrl() {
        return profileUrl;
    }


}
