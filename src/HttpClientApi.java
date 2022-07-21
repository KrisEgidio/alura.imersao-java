import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientApi {
    
    public String fetchData(String endpoint){
        
        try {
            
            URI url = URI.create(endpoint);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(url).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    
    }

}
