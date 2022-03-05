package domain;


public abstract class Dictionary {
    private String version;
    private Long id;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
