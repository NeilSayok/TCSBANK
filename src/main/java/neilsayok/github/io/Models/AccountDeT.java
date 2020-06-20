package neilsayok.github.io.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountDeT {
    private Integer acc_id;
    private Integer customer_id;
    private String acc_type;
    private String acc_status;
    private String acc_msg;
    private Long acc_last_upd;
    private String acc_last_upd_string;

    public AccountDeT() {
        if (acc_last_upd != null){
            setAcc_last_upd_string(getAcc_last_upd_string());
        }
    }

    public AccountDeT(int acc_id, int customer_id, String acc_type, String acc_status, String acc_msg, long acc_last_upd) {
        this.acc_id = acc_id;
        this.customer_id = customer_id;
        this.acc_type = acc_type;
        this.acc_status = acc_status;
        this.acc_msg = acc_msg;
        this.acc_last_upd = acc_last_upd;
        if (acc_last_upd != 0){
            setAcc_last_upd_string(getAcc_last_upd_string());
        }
    }

    public Integer getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }

    public String getAcc_msg() {
        return acc_msg;
    }

    public void setAcc_msg(String acc_msg) {
        this.acc_msg = acc_msg;
    }

    public Long getAcc_last_upd() {
        return acc_last_upd;
    }

    public void setAcc_last_upd(Long acc_last_upd) {
        this.acc_last_upd = acc_last_upd;
    }

    public String getAcc_last_upd_string() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date resultdate = new Date(acc_last_upd);
        return sdf.format(resultdate);
    }

    public void setAcc_last_upd_string(String acc_last_upd_string) {
        this.acc_last_upd_string = acc_last_upd_string;
    }
}
