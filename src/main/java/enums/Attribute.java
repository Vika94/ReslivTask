package enums;

public enum Attribute {
    VALUE("value");

    public String value;

    Attribute(String value) {
        this.value = value;
    }

    public String getElement() {
        return value;
    }

}