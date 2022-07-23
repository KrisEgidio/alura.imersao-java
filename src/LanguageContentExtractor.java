import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LanguageContentExtractor implements ContentExtractor{

    public List<Content> contentExtract(String json){

        var parser = new JsonParser();
        List<Map<String, String>> list = parser.parse(json);
        List<Content> contents = new ArrayList<>();

        //popular lista
        for(Map<String, String> attribute : list){
            String title = attribute.get("title");
            String urlImage = attribute.get("image");
            String ranking = attribute.get("ranking");
            var content = new Content(title, urlImage, ranking);
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
            String ranking = attribute.get("ranking");

            System.out.print("\u001b[32m" + "[Linguagem] \u001b[m");
            System.out.println(title);
            System.out.print("\u001b[35m" + "[Imagem] \u001b[m");
            System.out.println(urlImage);
            System.out.print("\u001b[33m" + "[Pontuação] " + "\u001b[m");
            System.out.println(ranking);
            System.out.println("\n");
        }
        
    }


}
