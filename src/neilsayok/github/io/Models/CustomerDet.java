package neilsayok.github.io.Models;


import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDet {

    private Integer cust_id;
    private Integer ssn_id;
    private String cust_name;
    private Integer cust_age;
    private String cust_address;
    private String cust_city;
    private String cust_state;
    private String cust_stat;
    private String cust_msg;
    private Long cust_last_update;
    private String cust_last_update_string;



    public CustomerDet() {
        if (cust_last_update != null){
            setCust_last_update_string(getCust_last_update_string());
        }
    }

    public CustomerDet(int cust_id, int ssn_id, String cust_name, int cust_age, String cust_address, String cust_city, String cust_state, String cust_stat, String cust_msg, long cust_last_update) {

        this.cust_id = cust_id;
        this.ssn_id = ssn_id;
        this.cust_name = cust_name;
        this.cust_age = cust_age;
        this.cust_address = cust_address;
        this.cust_city = cust_city;
        this.cust_state = cust_state;
        this.cust_stat = cust_stat;
        this.cust_msg = cust_msg;
        this.cust_last_update = cust_last_update;
        if (cust_last_update != 0  ){
            setCust_last_update_string(getCust_last_update_string());
        }
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getSsn_id() {
        return ssn_id;
    }

    public void setSsn_id(Integer ssn_id) {
        this.ssn_id = ssn_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public Integer getCust_age() {
        return cust_age;
    }

    public void setCust_age(Integer cust_age) {
        this.cust_age = cust_age;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_city() {
        return cust_city;
    }

    public void setCust_city(String cust_city) {
        this.cust_city = cust_city;
    }

    public String getCust_state() {
        return cust_state;
    }

    public void setCust_state(String cust_state) {
        this.cust_state = cust_state;
    }

    public String getCust_stat() {
        return cust_stat;
    }

    public void setCust_stat(String cust_stat) {
        this.cust_stat = cust_stat;
    }

    public String getCust_msg() {
        return cust_msg;
    }

    public void setCust_msg(String cust_msg) {
        this.cust_msg = cust_msg;
    }

    public Long getCust_last_update() {
        return cust_last_update;
    }

    public void setCust_last_update(Long cust_last_update) {
        this.cust_last_update = cust_last_update;
    }







    public void setCust_last_update_string(String cust_last_update_string) {
        this.cust_last_update_string = cust_last_update_string;
    }

    public String getCust_last_update_string() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date resultdate = new Date(cust_last_update);
        return sdf.format(resultdate);
    }
}