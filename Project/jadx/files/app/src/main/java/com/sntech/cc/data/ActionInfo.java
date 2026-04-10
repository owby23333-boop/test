package com.sntech.cc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ActionInfo implements Serializable {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("data")
    @Expose
    private ActionData data;

    @SerializedName("message")
    @Expose
    private String message;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SerializedName("r")
    @Expose
    private String f17908r;

    public int getCode() {
        return this.code;
    }

    public ActionData getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getR() {
        return this.f17908r;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(ActionData actionData) {
        this.data = actionData;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setR(String str) {
        this.f17908r = str;
    }
}
