package com.sntech.cc.data;

import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class ActionData {

    @SerializedName(NativeAdvancedJsUtils.f8246p)
    @Expose
    private String action;
    private BroadCastItemInfo broadcast_info;
    private ClickInfo click_info;

    @SerializedName("delay_time")
    @Expose
    private int delay_time;

    @SerializedName("polling_flag")
    @Expose
    private int polling_flag;

    @SerializedName("task_uuid")
    @Expose
    private String task_uuid;

    public String getAction() {
        return this.action;
    }

    public BroadCastItemInfo getBroadcast_info() {
        return this.broadcast_info;
    }

    public ClickInfo getClick_info() {
        return this.click_info;
    }

    public int getDelay_time() {
        return this.delay_time;
    }

    public int getPolling_flag() {
        return this.polling_flag;
    }

    public String getTask_uuid() {
        return this.task_uuid;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setBroadcast_info(BroadCastItemInfo broadCastItemInfo) {
        this.broadcast_info = broadCastItemInfo;
    }

    public void setClick_info(ClickInfo clickInfo) {
        this.click_info = clickInfo;
    }

    public void setDelay_time(int i2) {
        this.delay_time = i2;
    }

    public void setPolling_flag(int i2) {
        this.polling_flag = i2;
    }

    public void setTask_uuid(String str) {
        this.task_uuid = str;
    }
}
