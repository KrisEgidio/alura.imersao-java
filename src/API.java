public enum API {
    
    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope", "NASA"), 
    IMDB("https://api.mocki.io/v2/549a5d8b", "IMDB");

    private String url;
    private String name;

    API(String url, String name){
        this.url = url;
        this.name = name;
    }

    public String getUrl(){
        return this.url;
    }

    public ContentExtractor getContentExtractor(){
        if(this.name == "NASA"){
            var extractor = new NasaContentExtractor();
            return extractor;
        } else{
            var extractor = new ImdbContentExtractor();
            return extractor;
        }
    }

}
