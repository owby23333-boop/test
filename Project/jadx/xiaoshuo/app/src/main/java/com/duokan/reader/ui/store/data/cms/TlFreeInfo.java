package com.duokan.reader.ui.store.data.cms;

import android.text.TextUtils;
import com.dangdang.zframework.utils.DateUtil;
import com.duokan.core.diagnostic.LogLevel;
import com.google.gson.annotations.SerializedName;
import com.yuewen.ia0;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TlFreeInfo implements Serializable {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2);

    @SerializedName("end_time")
    public String endTime;
    private long mExpireTime;

    @SerializedName("start_time")
    public String startTime;

    @SerializedName("tlfree")
    public int tlFree;

    private long getExpireTime() {
        if (this.mExpireTime <= 0) {
            try {
                Date date = DATE_FORMAT.parse(this.endTime);
                if (date != null) {
                    this.mExpireTime = date.getTime();
                }
            } catch (ParseException unused) {
                ia0.w().f(LogLevel.INFO, "tl_free_info", "parse error");
            }
        }
        return this.mExpireTime;
    }

    public static TlFreeInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TlFreeInfo tlFreeInfo = new TlFreeInfo();
        try {
            tlFreeInfo.tlFree = jSONObject.getInt("tlfree");
            tlFreeInfo.startTime = jSONObject.optString("start_time");
            tlFreeInfo.endTime = jSONObject.optString("end_time");
        } catch (JSONException unused) {
            ia0.w().f(LogLevel.INFO, "TlFreeInfo", "parse error");
        }
        return tlFreeInfo;
    }

    public boolean available() {
        return this.tlFree == 1 && getExpireTime() > System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TlFreeInfo tlFreeInfo = (TlFreeInfo) obj;
        return this.tlFree == tlFreeInfo.tlFree && Objects.equals(this.startTime, tlFreeInfo.startTime) && Objects.equals(this.endTime, tlFreeInfo.endTime);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.tlFree), this.startTime, this.endTime);
    }

    public boolean isTlFree() {
        return this.tlFree == 1;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tlfree", this.tlFree);
            if (!TextUtils.isEmpty(this.startTime)) {
                jSONObject.put("start_time", this.startTime);
            }
            if (!TextUtils.isEmpty(this.endTime)) {
                jSONObject.put("end_time", this.endTime);
            }
        } catch (JSONException unused) {
            ia0.w().f(LogLevel.INFO, "TlFreeInfo", "toJson error");
        }
        return jSONObject;
    }
}
