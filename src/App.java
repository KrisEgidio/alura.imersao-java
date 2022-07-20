import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

        // gera as figurinhas
        var generator = new StickerGenerator();
        int i = 0;

        for (Map<String, String> movie : movies) {
            String title = movie.get("title");
            String urlImage = movie.get("image");
            Double rating = Double.parseDouble(movie.get("imDbRating"));

            if (i <= 2) {
                InputStream inputStream = new URL(urlImage).openStream();
                String fileName = title + ".png";
                generator.create(inputStream, fileName, rating);
            }
            
            showMovie(title, urlImage, rating);
            i++;
        }

    }

    private static void showMovie(String title, String urlImage, Double rating) {
        System.out.print("\u001b[32m" + "[Filme] \u001b[m");
        System.out.println(title);
        System.out.print("\u001b[35m" + "[Imagem] \u001b[m");
        System.out.println(urlImage);
        System.out.print("\u001b[33m" + "[Pontuação] " + "\u001b[m");
        System.out.println(rating);
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

}
