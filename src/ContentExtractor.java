import java.util.List;

public interface ContentExtractor {
    
    public List<Content> contentExtract(String json);
    
    public void showContent(String json);

}
