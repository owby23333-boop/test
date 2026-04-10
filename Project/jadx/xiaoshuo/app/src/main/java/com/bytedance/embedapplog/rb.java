package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class rb extends i {
    public String bh;
    long l;
    public String s;
    public String t;
    public long w;
    public String xu;

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        super.bf(jSONObject);
        this.d = jSONObject.optLong("tea_event_index", 0L);
        this.xu = jSONObject.optString("category", null);
        this.bh = jSONObject.optString("tag", null);
        this.w = jSONObject.optLong("value", 0L);
        this.l = jSONObject.optLong("ext_value", 0L);
        this.s = jSONObject.optString("params", null);
        this.t = jSONObject.optString(TTDownloadField.TT_LABEL, null);
        return this;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", "value", TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", TTDownloadField.TT_LABEL, "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return "event";
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return "" + this.bh + ", " + this.t;
    }

    @Override // com.bytedance.embedapplog.i
    public String zk() {
        return this.s;
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        int iE = super.e(cursor);
        int i = iE + 1;
        this.xu = cursor.getString(iE);
        int i2 = i + 1;
        this.bh = cursor.getString(i);
        int i3 = i2 + 1;
        this.w = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.l = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.s = cursor.getString(i4);
        int i6 = i5 + 1;
        this.t = cursor.getString(i5);
        return i6;
    }

    @Override // com.bytedance.embedapplog.i
    public JSONObject bf() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.s) ? new JSONObject(this.s) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.bf);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("session_id", this.tg);
        long j = this.ga;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.vn) ? JSONObject.NULL : this.vn);
        if (!TextUtils.isEmpty(this.p)) {
            jSONObject.put("ssid", this.p);
        }
        jSONObject.put("category", this.xu);
        jSONObject.put("tag", this.bh);
        jSONObject.put("value", this.w);
        jSONObject.put("ext_value", this.l);
        jSONObject.put(TTDownloadField.TT_LABEL, this.t);
        jSONObject.put("datetime", this.wu);
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("ab_sdk_version", this.v);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        super.e(contentValues);
        contentValues.put("category", this.xu);
        contentValues.put("tag", this.bh);
        contentValues.put("value", Long.valueOf(this.w));
        contentValues.put("ext_value", Long.valueOf(this.l));
        contentValues.put("params", this.s);
        contentValues.put(TTDownloadField.TT_LABEL, this.t);
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) throws JSONException {
        super.e(jSONObject);
        jSONObject.put("tea_event_index", this.d);
        jSONObject.put("category", this.xu);
        jSONObject.put("tag", this.bh);
        jSONObject.put("value", this.w);
        jSONObject.put("ext_value", this.l);
        jSONObject.put("params", this.s);
        jSONObject.put(TTDownloadField.TT_LABEL, this.t);
    }
}
