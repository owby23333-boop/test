package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BaseStochasticBean implements Serializable {
    private int add_count;
    private int back;
    private int interval_count;
    private int interval_min;
    private int loading;
    private String phone_list;
    private int play;
    private int scheme;
    private int second;
    private ArrayList<BaseAd> stochastic;
    private int style;
    private int today_count;
    private int total_count;
    private int video_count;

    public int getAdd_count() {
        return this.add_count;
    }

    public int getBack() {
        return this.back;
    }

    public int getInterval_count() {
        return this.interval_count;
    }

    public int getInterval_min() {
        return this.interval_min;
    }

    public int getLoading() {
        return this.loading;
    }

    public String getPhone_list() {
        return this.phone_list;
    }

    public int getPlay() {
        return this.play;
    }

    public int getScheme() {
        return this.scheme;
    }

    public int getSecond() {
        return this.second;
    }

    public ArrayList<BaseAd> getStochastic() {
        return this.stochastic;
    }

    public int getStyle() {
        return this.style;
    }

    public int getToday_count() {
        return this.today_count;
    }

    public int getTotal_count() {
        return this.total_count;
    }

    public int getVideo_count() {
        return this.video_count;
    }

    public void setAdd_count(int i2) {
        this.add_count = i2;
    }

    public void setBack(int i2) {
        this.back = i2;
    }

    public void setInterval_count(int i2) {
        this.interval_count = i2;
    }

    public void setInterval_min(int i2) {
        this.interval_min = i2;
    }

    public void setLoading(int i2) {
        this.loading = i2;
    }

    public void setPhone_list(String str) {
        this.phone_list = str;
    }

    public void setPlay(int i2) {
        this.play = i2;
    }

    public void setScheme(int i2) {
        this.scheme = i2;
    }

    public void setSecond(int i2) {
        this.second = i2;
    }

    public void setStochastic(ArrayList<BaseAd> arrayList) {
        this.stochastic = arrayList;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    public void setToday_count(int i2) {
        this.today_count = i2;
    }

    public void setTotal_count(int i2) {
        this.total_count = i2;
    }

    public void setVideo_count(int i2) {
        this.video_count = i2;
    }
}
