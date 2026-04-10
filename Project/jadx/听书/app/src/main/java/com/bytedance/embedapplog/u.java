package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u extends sd {
    long i;
    public int pf = 0;
    String v;
    long wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        return null;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        cb.g((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        cb.g((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) {
        cb.g((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.sd
    protected JSONObject g() throws JSONException {
        zz zzVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.g);
        jSONObject.put("tea_event_index", this.dl);
        jSONObject.put("session_id", this.f299a);
        jSONObject.put("stop_timestamp", this.i / 1000);
        jSONObject.put("duration", this.wp / 1000);
        jSONObject.put("datetime", this.kb);
        if (this.gc > 0) {
            jSONObject.put("user_id", this.gc);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.m) ? JSONObject.NULL : this.m);
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("ssid", this.e);
        }
        if (!TextUtils.isEmpty(this.gz)) {
            jSONObject.put("ab_sdk_version", this.gz);
        }
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.v, this.f299a)) {
                jSONObject.put("original_session_id", this.v);
            }
        }
        if (this.pf == 0 && (zzVar = (zz) tf.g.get("launch")) != null && !zzVar.tb) {
            this.pf = 6;
        }
        jSONObject.put("launch_from", this.pf);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        cb.g((Throwable) null);
        return this;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return String.valueOf(this.wp);
    }
}
