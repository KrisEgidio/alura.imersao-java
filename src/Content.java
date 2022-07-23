public class Content {
    
    private final String title;
    private final String urlImage;
    private final String ranking;
    
    
    public Content(String title, String urlImage, String ranking) {
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

    public String getRanking(){
        return ranking;
    }
    
}
