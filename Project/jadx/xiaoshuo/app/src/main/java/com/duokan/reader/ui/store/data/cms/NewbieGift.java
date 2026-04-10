package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class NewbieGift implements Serializable {
    public static final int STATUS_DRAWED = 4;
    public static final int STATUS_FINISH = 3;
    public static final int STATUS_PROCESS = 2;
    public static final int STATUS_WAIT = 1;

    @SerializedName("achieve")
    public int achieve;

    @SerializedName(TTDownloadField.TT_ACTIVITY)
    public int activity;

    @SerializedName("coins")
    public int coins;

    @SerializedName("desc")
    public String desc;

    @SerializedName("detail")
    public String detail;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("icon")
    public String icon;

    @SerializedName("name")
    public String name;

    @SerializedName("read_source")
    public List<Integer> readSource;

    @SerializedName("scene")
    public int scene;

    @SerializedName("start_time")
    public int startTime;

    @SerializedName("status")
    public int status;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("type")
    public int type;

    @SerializedName("use_days")
    public int useDays;

    @SerializedName("value")
    public int value;

    public String toString() {
        return "NewbieGift{activity = '" + this.activity + "',coins = '" + this.coins + "',achieve = '" + this.achieve + "',end_time = '" + this.endTime + "',icon = '" + this.icon + "',task_id = '" + this.taskId + "',type = '" + this.type + "',scene = '" + this.scene + "',start_time = '" + this.startTime + "',read_source = '" + this.readSource + "',use_days = '" + this.useDays + "',name = '" + this.name + "',detail = '" + this.detail + "',value = '" + this.value + "',status = '" + this.status + "',desc = '" + this.desc + '\'' + l.d;
    }
}
