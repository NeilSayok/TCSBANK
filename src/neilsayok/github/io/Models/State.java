package neilsayok.github.io.Models;

public class State {
    private int id;
    private String name;
    private int country_code;

    public State(int id, String name, int country_code) {
        this.id = id;
        this.name = name;
        this.country_code = country_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountry_code() {
        return country_code;
    }

    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }
}
