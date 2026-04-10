package com.sntech.cc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class ClickInfo {

    @SerializedName("client_ad_uuid")
    @Expose
    private String client_ad_uuid;

    @SerializedName("pos_type")
    @Expose
    private String pos_type;

    @SerializedName("x_axis_ratio")
    @Expose
    private float x_axis_ratio;

    @SerializedName("y_axis_ratio")
    @Expose
    private float y_axis_ratio;

    public String getClient_ad_uuid() {
        return this.client_ad_uuid;
    }

    public String getPos_type() {
        return this.pos_type;
    }

    public float getX_axis_ratio() {
        return this.x_axis_ratio;
    }

    public float getY_axis_ratio() {
        return this.y_axis_ratio;
    }

    public void setClient_ad_uuid(String str) {
        this.client_ad_uuid = str;
    }

    public void setPos_type(String str) {
        this.pos_type = str;
    }

    public void setX_axis_ratio(float f2) {
        this.x_axis_ratio = f2;
    }

    public void setY_axis_ratio(float f2) {
        this.y_axis_ratio = f2;
    }
}
