package entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public enum Type {
    single_line_text("Single line text"),
    multi_line_text("Multi line text"),
    radio_button("Radio button"),
    check_box("Check box"),
    combo_box("Combo box"),
    date("Date");

    private String name;
    Type(String name ){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
