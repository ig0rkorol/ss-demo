package lv.ss.demo.model;

/**
 * Created by ikorol on 22.11.2016.
 */
public enum Languages {
    RUSSIAN("ru"),
    LATVIAN("lv");
    private String code;
    Languages(String value){
        code = value;
    }
    public String getCode(){
        return code;
    }
}
