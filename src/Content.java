public class Content {
    
    private final String title;
    private final String urlImage;
    private final int ranking;
    
    
    public Content(String title, String urlImage, int ranking) {
        this.title = title;
        this.urlImage = urlImage;
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }
    
    public String getUrlImage() {
        return urlImage;
    }

    public int getRanking(){
        return ranking;
    }
    
}
