package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.amgcyo.cuttadon.j.c.c;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@Entity(indices = {@Index(unique = true, value = {"user_id"})}, tableName = "MkUser")
public class MkUser implements Serializable {

    @Ignore
    private String ad_end_datetime;

    @Ignore
    private int ad_state;

    @ColumnInfo(name = "ad_style")
    private int ad_style;

    @Ignore
    private String ad_tips;

    @Ignore
    private int appFlag;

    @Ignore
    private String appName;

    @PrimaryKey(autoGenerate = true)
    private int art_id;

    @ColumnInfo(name = "avatar")
    private String avatar;

    @TypeConverters({c.class})
    private MkDataBean data;

    @ColumnInfo(name = "invitation_code")
    private String invitation_code;

    @ColumnInfo(name = "invitation_count")
    private int invitation_count;

    @Ignore
    private boolean isLogin;

    @ColumnInfo(name = "master_user_id")
    private int master_user_id;

    @ColumnInfo(name = "nick")
    private String nick;

    @ColumnInfo(name = "phone")
    private String phone;

    @Ignore
    private String serv_datetime;

    @ColumnInfo(name = ArticleInfo.USER_SEX)
    private int sex;

    @Ignore
    private String tel;

    @ColumnInfo(name = "token")
    private String token;

    @ColumnInfo(name = BmobDbOpenHelper.USER)
    private String user;

    @ColumnInfo(name = "user_id")
    private int user_id;

    @Ignore
    public MkUser(int i2) {
        this.user_id = i2;
    }

    public String getAd_end_datetime() {
        return this.ad_end_datetime;
    }

    public int getAd_state() {
        return this.ad_state;
    }

    public int getAd_style() {
        return this.ad_style;
    }

    public String getAd_tips() {
        return this.ad_tips;
    }

    public int getAppFlag() {
        return this.appFlag;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getArt_id() {
        return this.art_id;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public MkDataBean getData() {
        return this.data;
    }

    public String getInvitation_code() {
        return this.invitation_code;
    }

    public int getInvitation_count() {
        return this.invitation_count;
    }

    public int getMaster_user_id() {
        return this.master_user_id;
    }

    public String getNick() {
        return this.nick;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getServ_datetime() {
        return this.serv_datetime;
    }

    public int getSex() {
        return this.sex;
    }

    public String getTel() {
        return this.tel;
    }

    public String getToken() {
        return this.token;
    }

    public String getUser() {
        return this.user;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setAd_end_datetime(String str) {
        this.ad_end_datetime = str;
    }

    public void setAd_state(int i2) {
        this.ad_state = i2;
    }

    public void setAd_style(int i2) {
        this.ad_style = i2;
    }

    public void setAd_tips(String str) {
        this.ad_tips = str;
    }

    public void setAppFlag(int i2) {
        this.appFlag = i2;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setArt_id(int i2) {
        this.art_id = i2;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setData(MkDataBean mkDataBean) {
        this.data = mkDataBean;
    }

    public void setInvitation_code(String str) {
        this.invitation_code = str;
    }

    public void setInvitation_count(int i2) {
        this.invitation_count = i2;
    }

    public void setLogin(boolean z2) {
        this.isLogin = z2;
    }

    public void setMaster_user_id(int i2) {
        this.master_user_id = i2;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setServ_datetime(String str) {
        this.serv_datetime = str;
    }

    public void setSex(int i2) {
        this.sex = i2;
    }

    public void setTel(String str) {
        this.tel = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setUser_id(int i2) {
        this.user_id = i2;
    }

    public String toString() {
        return "MkUser{art_id=" + this.art_id + ", user_id=" + this.user_id + ", user='" + this.user + "', phone='" + this.phone + "', token='" + this.token + "', nick='" + this.nick + "', avatar='" + this.avatar + "', sex=" + this.sex + ", data=" + this.data + '}';
    }

    public MkUser() {
    }
}
