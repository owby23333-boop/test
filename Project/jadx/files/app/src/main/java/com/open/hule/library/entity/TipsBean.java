package com.open.hule.library.entity;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public class TipsBean implements Serializable {
    private String jump_url;
    private String matchFormat;
    private int maxHeight;
    private String md5_key;
    private int read_tips_switch;
    private String tips_app;
    private String tips_appremark;
    private String tips_classname;
    private String tips_content;
    private String tips_logo;
    private int tips_switch;

    public TipsBean(String str, int i2) {
        this.tips_content = str;
        this.maxHeight = i2;
    }

    public String getJump_url() {
        return this.jump_url;
    }

    public String getMatchFormat() {
        return this.matchFormat;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public String getMd5_key() {
        return this.md5_key;
    }

    public int getRead_tips_switch() {
        return this.read_tips_switch;
    }

    public String getTips_app() {
        return this.tips_app;
    }

    public String getTips_appremark() {
        return this.tips_appremark;
    }

    public String getTips_classname() {
        return this.tips_classname;
    }

    public String getTips_content() {
        return this.tips_content;
    }

    public String getTips_logo() {
        return this.tips_logo;
    }

    public int getTips_switch() {
        return this.tips_switch;
    }

    public void setJump_url(String str) {
        this.jump_url = str;
    }

    public void setMatchFormat(String str) {
        this.matchFormat = str;
    }

    public void setMaxHeight(int i2) {
        this.maxHeight = i2;
    }

    public void setMd5_key(String str) {
        this.md5_key = str;
    }

    public void setRead_tips_switch(int i2) {
        this.read_tips_switch = i2;
    }

    public void setTips_app(String str) {
        this.tips_app = str;
    }

    public void setTips_appremark(String str) {
        this.tips_appremark = str;
    }

    public void setTips_classname(String str) {
        this.tips_classname = str;
    }

    public void setTips_content(String str) {
        this.tips_content = str;
    }

    public void setTips_logo(String str) {
        this.tips_logo = str;
    }

    public void setTips_switch(int i2) {
        this.tips_switch = i2;
    }

    @NotNull
    public String toString() {
        return "TipsBean{read_tips_switch=" + this.read_tips_switch + ", tips_content='" + this.tips_content + "', tips_switch=" + this.tips_switch + ", jump_url='" + this.jump_url + "', md5_key='" + this.md5_key + "', tips_app='" + this.tips_app + "', tips_logo='" + this.tips_logo + "', tips_appremark='" + this.tips_appremark + "', maxHeight=" + this.maxHeight + "', matchFormat='" + this.matchFormat + "', tips_classname='" + this.tips_classname + "'}";
    }

    public TipsBean(int i2, String str, int i3, String str2) {
        this.read_tips_switch = i2;
        this.tips_content = str;
        this.tips_switch = i3;
        this.jump_url = str2;
    }

    public TipsBean(int i2, String str, int i3, String str2, String str3) {
        this.read_tips_switch = i2;
        this.tips_content = str;
        this.tips_switch = i3;
        this.jump_url = str2;
        this.md5_key = str3;
    }

    public TipsBean() {
    }
}
