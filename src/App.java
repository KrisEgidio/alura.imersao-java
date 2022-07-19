import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String body = getBodyRequest("https://api.mocki.io/v2/549a5d8b"); // utilizando endereço alternativo

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> movies = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String, String> movie : movies) {
            showMovie(movie);
        }

    }

    private static void showMovie(Map<String, String> movie) {
        System.out.print("\u001b[34m" + "[Filme] \u001b[m");
        System.out.println(movie.get("title"));
        System.out.print("\u001b[32m" + "[Imagem] \u001b[m");
        System.out.println(movie.get("image"));
        System.out.print("\u001b[35m" + "[Pontuação] "+ "\u001b[m");
        showStars(Double.parseDouble(movie.get("imDbRating")));
        System.out.println("\n");
    }

    private static String getBodyRequest(String endpoint) throws Exception {
        URI url = URI.create(endpoint);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(url).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        return body;
    }

    private static void showStars(Double points){
        var number = Math.floor(points);
        for(int i = 0; i < number; i++){
            System.out.print("⭐");
        }
    }

}
