import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //utilizando enum para pegar as informações da api selecionada
        //System.out.println("\u001b[32m" + "[Qual tipo de figurinha?] \u001b[m");
        //System.out.println("\u001b[35m" + "[Digite 1 para NASA ou 2 para IMDB] \u001b[m");
        
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String input = reader.readLine().toUpperCase();
        API api = API.valueOf("LANGUAGE");
        String url = api.getUrl();
        ContentExtractor contentExtractor = api.getContentExtractor();
        
        //obtendo o body do json da api
        var http = new HttpClientApi();
        String json = http.fetchData(url);
        
        //criando a lista de conteúdo
        List<Content> contents = contentExtractor.contentExtract(json);

        //exibe a lista de conteúdo
        contentExtractor.showContent(json);

        // gera as figurinhas
        var generator = new StickerGenerator();

        for(int i = 0; i < contents.size(); i++){
            Content content = contents.get(i);
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = content.getTitle() + ".png";
            generator.create(inputStream, fileName, content.getTitle());
        }
    }

}
