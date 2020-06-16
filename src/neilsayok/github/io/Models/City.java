package neilsayok.github.io.Models;



public class City {
    private int id;
    private String city_name;
    private int state_id;

    public City(int id, String city_name, int state_id) {
        this.id = id;
        this.city_name = city_name;
        this.state_id = state_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }
}
