package entity;

public class UserInputDTO {

    private String label;
    private String value;
    private Type type;
    private Integer uid;
    private boolean isRequired;

    public UserInputDTO() {
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
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserInputDTO{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", type=" + type +
                ", uid='" + uid + '\'' +
                ", isRequired=" + isRequired +
                '}';
    }
}
