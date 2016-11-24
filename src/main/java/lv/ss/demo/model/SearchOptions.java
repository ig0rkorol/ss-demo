package lv.ss.demo.model;

/**
 * Created by ikorol on 24.11.2016.
 */

public class SearchOptions {
    private final String word;
    private final String priceMin;
    private final String priceMax;

    public static class Builder {
        private String word;
        private String priceMin;
        private String priceMax;

        public Builder word(String value) {
            word = value;
            return this;
        }
        public Builder priceMin(String value) {
            priceMin = value;
            return this;
        }
        public Builder priceMax(String value) {
            priceMax = value;
            return this;
        }
        public SearchOptions build() {
            return new SearchOptions(this);
        }
    }

    private SearchOptions(Builder builder){
        this.word = builder.word;
        this.priceMin = builder.priceMin;
        this.priceMax = builder.priceMax;
    }
    public String getWord(){
        return word;
    }
    public String getMinPrice(){
        return priceMin;
    }
    public String getMaxPrice() {
        return priceMax;
    }
}
