package entity;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.util.Arrays;

@ManagedBean(name = "newField", eager = true)
@SessionScoped
@Entity
@Table(name = "fields")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    @Enumerated(EnumType.STRING)
    private Type type;

    private boolean required;

    @Column(name = "is_active")
    private boolean isActive;

    private String options;

    @Transient
    private String[] optionsList;

    public Field() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getOptions() {
        return options;
    }


    public void setOptions(String options) {
        this.options = options;
    }

    public String[] getOptionsList() {
        if (options != null)
            optionsList = options.split(" ");
        return optionsList;
    }

    public void setOptionsList(String[] optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", required=" + required +
                ", isActive=" + isActive +
                ", options='" + options + '\'' +
                ", optionsList=" + Arrays.toString(optionsList) +
                '}';
    }
}
