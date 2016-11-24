package lv.ss.demo.model;

/**
 * Created by ikorol on 23.11.2016.
 */
public enum Category {
    ELECTRONICS("electronics");
    private String href;
    Category(String categoryHref){
        href = categoryHref;
    }
    public String getCategoryHref(){
        return href;
    }
}
