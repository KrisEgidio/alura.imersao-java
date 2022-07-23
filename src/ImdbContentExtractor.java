import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ImdbContentExtractor implements ContentExtractor{
    
    public List<Content> contentExtract(String json){
        
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> list = parser.parse(json);
        List<Content> contents = new ArrayList<>();

        //popular lista
        for(Map<String, String> attribute : list){
            String title = attribute.get("title");
            String urlImage = attribute.get("image");
            int rating = Integer.parseInt(attribute.get("imDbRating"));
            var content = new Content(title, urlImage, rating);
            contents.add(content);
        }

        return contents;

    }

    public void showContent(String json){
        var parser = new JsonParser();
        List<Map<String, String>> list = parser.parse(json);

        for(Map<String, String> attribute : list){
            String title = attribute.get("title");
            String urlImage = attribute.get("image");
            String rating = attribute.get("rating");
            //Double rating = Double.parseDouble(attribute.get("imDbRating"));

            System.out.print("\u001b[32m" + "[Filme] \u001b[m");
            System.out.println(title);
            System.out.print("\u001b[35m" + "[Imagem] \u001b[m");
            System.out.println(urlImage);
            System.out.print("\u001b[33m" + "[Pontuação] " + "\u001b[m");
            System.out.println(rating);
            System.out.println("\n");
        }
        
    }

}
