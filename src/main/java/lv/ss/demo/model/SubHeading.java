package lv.ss.demo.model;

/**
 * Created by ikorol on 23.11.2016.
 */
public enum SubHeading {
    CELL("Продают"),
    BUY("Покупают"),
    TO_RENT("Сдают"),
    RENT("Снимут"),
    CHANGE("Меняют"),
    OTHER("Разное");

    private String russian;
    private String latvian;

    SubHeading(String valueRu){
        russian = valueRu;
    }

    public String getRussian(){
        return russian;
    }

}
