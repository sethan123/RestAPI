import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class Practise1_using_javanetpackage {
        public static void main(String[] args) {
            String apiUrl = "https://reqres.in/api/users?page=2";

            try {
                // Send GET request
                String response = sendGetRequest(apiUrl);
                System.out.println("GET Response:\n" + response);

                // Send POST request
                String postData = "{\"key\": \"value\"}";
                response = sendPostRequest(apiUrl, postData);
                System.out.println("POST Response:\n" + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String sendGetRequest(String apiUrl) throws IOException {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                return "GET request failed with response code: " + responseCode;
            }
        }

        private static String sendPostRequest(String apiUrl, String postData) throws IOException {
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            System.out.println("post method started");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            String jsonBody= "{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"leader\"\n" +
                    "}";

          byte[] inputjson= jsonBody.getBytes();

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonBody.getBytes());
            System.out.println("Responce code "+ connection.getResponseCode());
            System.out.println("Request Message" +connection.getResponseMessage());


            outputStream.flush();
            outputStream.close();



            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                return response.toString();
            } else {
                return "POST request failed with response code: " + responseCode;
            }
        }
    }






