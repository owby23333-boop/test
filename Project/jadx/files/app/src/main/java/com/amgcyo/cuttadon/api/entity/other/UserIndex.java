package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UserIndex implements Serializable {
    private MkAdBean ad;
    private int asking_book_number;
    private int comment_number;
    private MkFission fission;
    private String gold;
    private String invitation_code;
    private int invitation_count;
    private int is_red_packet;
    private int master_user_id;
    private String money;
    private int service_appeal_number;
    private int sign_in;
    private int today_read;
    private int total_read;
    private String user_avatar;
    private String user_login;
    private String user_nickname;
    private String user_phone;

    public UserIndex(String str) {
        this.user_login = str;
    }

    public MkAdBean getAd() {
        return this.ad;
    }

    public int getAsking_book_number() {
        return this.asking_book_number;
    }

    public int getComment_number() {
        return this.comment_number;
    }

    public MkFission getFission() {
        return this.fission;
    }

    public String getGold() {
        return this.gold;
    }

    public String getInvitation_code() {
        return this.invitation_code;
    }

    public int getInvitation_count() {
        return this.invitation_count;
    }

    public int getIs_red_packet() {
        return this.is_red_packet;
    }

    public int getMaster_user_id() {
        return this.master_user_id;
    }

    public String getMoney() {
        return this.money;
    }

    public int getService_appeal_number() {
        return this.service_appeal_number;
    }

    public int getSign_in() {
        return this.sign_in;
    }

    public int getToday_read() {
        return this.today_read;
    }

    public int getTotal_read() {
        return this.total_read;
    }

    public String getUser_avatar() {
        return this.user_avatar;
    }

    public String getUser_login() {
        return this.user_login;
    }

    public String getUser_nickname() {
        return this.user_nickname;
    }

    public String getUser_phone() {
        return this.user_phone;
    }

    public void setAd(MkAdBean mkAdBean) {
        this.ad = mkAdBean;
    }

    public void setAsking_book_number(int i2) {
        this.asking_book_number = i2;
    }

    public void setComment_number(int i2) {
        this.comment_number = i2;
    }

    public void setFission(MkFission mkFission) {
        this.fission = mkFission;
    }

    public void setGold(String str) {
        this.gold = str;
    }

    public void setInvitation_code(String str) {
        this.invitation_code = str;
    }

    public void setInvitation_count(int i2) {
        this.invitation_count = i2;
    }

    public void setIs_red_packet(int i2) {
        this.is_red_packet = i2;
    }

    public void setMaster_user_id(int i2) {
        this.master_user_id = i2;
    }

    public void setMoney(String str) {
        this.money = str;
    }

    public void setService_appeal_number(int i2) {
        this.service_appeal_number = i2;
    }

    public void setSign_in(int i2) {
        this.sign_in = i2;
    }

    public void setToday_read(int i2) {
        this.today_read = i2;
    }

    public void setTotal_read(int i2) {
        this.total_read = i2;
    }

    public void setUser_avatar(String str) {
        this.user_avatar = str;
    }

    public void setUser_login(String str) {
        this.user_login = str;
    }

    public void setUser_nickname(String str) {
        this.user_nickname = str;
    }

    public void setUser_phone(String str) {
        this.user_phone = str;
    }

    public UserIndex() {
    }
}
