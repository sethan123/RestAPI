import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GetExample {
    public static void main(String[] args) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.example.com/resource")
                    .header("Accept", "application/json")
                    .asString();
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
