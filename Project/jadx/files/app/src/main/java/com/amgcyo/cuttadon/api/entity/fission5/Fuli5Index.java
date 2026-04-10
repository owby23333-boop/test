package com.amgcyo.cuttadon.api.entity.fission5;

import com.amgcyo.cuttadon.api.entity.bookcity.BannerBean;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Fuli5Index implements Serializable {
    private int balance_gold;
    private String balance_money;
    private List<BannerBean> banner;
    private int bind_code_state;
    private String earnings;
    private List<String> notice;
    private List<Fuli5TaskBean> read_task;
    private String rules_url;
    private List<Fuli5SignInDataBean> sign_in_data;
    private Fuli5SignInLogBean sign_in_log;
    private int sign_in_state;
    private List<Fuli5TaskBean> task;
    private String treasure_chest_datetime;
    private int treasure_chest_state;
    private int video_switch;

    public int getBalance_gold() {
        return this.balance_gold;
    }

    public String getBalance_money() {
        return this.balance_money;
    }

    public List<BannerBean> getBanner() {
        return this.banner;
    }

    public int getBind_code_state() {
        return this.bind_code_state;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public List<String> getNotice() {
        return this.notice;
    }

    public List<Fuli5TaskBean> getRead_task() {
        return this.read_task;
    }

    public String getRules_url() {
        return this.rules_url;
    }

    public List<Fuli5SignInDataBean> getSign_in_data() {
        return this.sign_in_data;
    }

    public Fuli5SignInLogBean getSign_in_log() {
        return this.sign_in_log;
    }

    public int getSign_in_state() {
        return this.sign_in_state;
    }

    public List<Fuli5TaskBean> getTask() {
        return this.task;
    }

    public String getTreasure_chest_datetime() {
        return this.treasure_chest_datetime;
    }

    public int getTreasure_chest_state() {
        return this.treasure_chest_state;
    }

    public int getVideo_switch() {
        return this.video_switch;
    }

    public void setBalance_gold(int i2) {
        this.balance_gold = i2;
    }

    public void setBalance_money(String str) {
        this.balance_money = str;
    }

    public void setBanner(List<BannerBean> list) {
        this.banner = list;
    }

    public void setBind_code_state(int i2) {
        this.bind_code_state = i2;
    }

    public void setEarnings(String str) {
        this.earnings = str;
    }

    public void setNotice(List<String> list) {
        this.notice = list;
    }

    public void setRead_task(List<Fuli5TaskBean> list) {
        this.read_task = list;
    }

    public void setRules_url(String str) {
        this.rules_url = str;
    }

    public void setSign_in_data(List<Fuli5SignInDataBean> list) {
        this.sign_in_data = list;
    }

    public void setSign_in_log(Fuli5SignInLogBean fuli5SignInLogBean) {
        this.sign_in_log = fuli5SignInLogBean;
    }

    public void setSign_in_state(int i2) {
        this.sign_in_state = i2;
    }

    public void setTask(List<Fuli5TaskBean> list) {
        this.task = list;
    }

    public void setTreasure_chest_datetime(String str) {
        this.treasure_chest_datetime = str;
    }

    public void setTreasure_chest_state(int i2) {
        this.treasure_chest_state = i2;
    }

    public void setVideo_switch(int i2) {
        this.video_switch = i2;
    }
}
