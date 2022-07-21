import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class NasaContentExtractor implements ContentExtractor{
    
    public List<Content> contentExtract(String json){
        
        var parser = new JsonParser();
        List<Map<String, String>> list = parser.parse(json);
        List<Content> contents = new ArrayList<>();

        //popular lista
        for(Map<String, String> attribute : list){
            String title = attribute.get("title");
            String urlImage = attribute.get("url");
            var content = new Content(title, urlImage);
            contents.add(content);
        }

        return contents;
    }

    public void showContent(String json){
        var parser = new JsonParser();
        List<Map<String, String>> list = parser.parse(json);

        for(Map<String, String> attribute : list){
            String title = attribute.get("title");
            String urlImage = attribute.get("url");

            System.out.print("\u001b[32m" + "[Título] \u001b[m");
            System.out.println(title);
            System.out.print("\u001b[35m" + "[Imagem] \u001b[m");
            System.out.println(urlImage);
            System.out.println("\n");
        }
        
    }

}
