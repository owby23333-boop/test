package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class uq extends i {
    long bh;
    String t;
    long xu;

    @Override // com.bytedance.embedapplog.i
    public JSONObject bf() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.bf);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.tg);
        jSONObject.put("stop_timestamp", this.bh / 1000);
        jSONObject.put("duration", this.xu / 1000);
        jSONObject.put("datetime", this.wu);
        long j = this.ga;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.vn) ? JSONObject.NULL : this.vn);
        if (!TextUtils.isEmpty(this.p)) {
            jSONObject.put("ssid", this.p);
        }
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("ab_sdk_version", this.v);
        }
        if (!TextUtils.isEmpty(this.t)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.t, this.tg)) {
                jSONObject.put("original_session_id", this.t);
            }
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        return null;
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return String.valueOf(this.xu);
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        tx.bf((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        tx.bf((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) {
        tx.bf((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        tx.bf((Throwable) null);
        return this;
    }
}
