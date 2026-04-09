public class Package {

    private float weight;
    private Content content;
    private float value;

    public Package(float weight, Content content, float value) {
        this.weight = weight;
        this.content = content;
        this.value = value;
    }

    // Getters CLAVE (los usa todo el parcial)
    public float getWeight() {
        return weight;
    }

    public Content getContent() {
        return content;
    }

    public float getValue() {
        return value;
    }
}
