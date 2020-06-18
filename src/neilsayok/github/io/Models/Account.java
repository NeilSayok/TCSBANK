package neilsayok.github.io.Models;

public class Account {
    private int acc_id;
    private int customer_id;
    private int acc_type;
    private int acc_status;
    private String acc_msg;
    private long acc_last_upd;

    public Account() {
    }

    public Account(int acc_id, int customer_id, int acc_type, int acc_status, String acc_msg, long acc_last_upd) {
        this.acc_id = acc_id;
        this.customer_id = customer_id;
        this.acc_type = acc_type;
        this.acc_status = acc_status;
        this.acc_msg = acc_msg;
        this.acc_last_upd = acc_last_upd;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(int acc_type) {
        this.acc_type = acc_type;
    }

    public int getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(int acc_status) {
        this.acc_status = acc_status;
    }

    public String getAcc_msg() {
        return acc_msg;
    }

    public void setAcc_msg(String acc_msg) {
        this.acc_msg = acc_msg;
    }

    public long getAcc_last_upd() {
        return acc_last_upd;
    }

    public void setAcc_last_upd(long acc_last_upd) {
        this.acc_last_upd = acc_last_upd;
    }
}
