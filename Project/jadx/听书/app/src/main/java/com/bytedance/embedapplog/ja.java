package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ja extends sd {
    public String i;
    public long ls;
    long p;
    public String pf;
    public String v;
    public String wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    ja() {
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        List<String> listZ = super.z();
        ArrayList arrayList = new ArrayList(listZ.size());
        arrayList.addAll(listZ);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", "value", TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        int iZ = super.z(cursor);
        int i = iZ + 1;
        this.wp = cursor.getString(iZ);
        int i2 = i + 1;
        this.i = cursor.getString(i);
        int i3 = i2 + 1;
        this.ls = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.p = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.pf = cursor.getString(i4);
        int i6 = i5 + 1;
        this.v = cursor.getString(i5);
        return i6;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        super.z(contentValues);
        contentValues.put("category", this.wp);
        contentValues.put("tag", this.i);
        contentValues.put("value", Long.valueOf(this.ls));
        contentValues.put("ext_value", Long.valueOf(this.p));
        contentValues.put("params", this.pf);
        contentValues.put("label", this.v);
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        jSONObject.put("tea_event_index", this.dl);
        jSONObject.put("category", this.wp);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.ls);
        jSONObject.put("ext_value", this.p);
        jSONObject.put("params", this.pf);
        jSONObject.put("label", this.v);
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.dl = jSONObject.optLong("tea_event_index", 0L);
        this.wp = jSONObject.optString("category", null);
        this.i = jSONObject.optString("tag", null);
        this.ls = jSONObject.optLong("value", 0L);
        this.p = jSONObject.optLong("ext_value", 0L);
        this.pf = jSONObject.optString("params", null);
        this.v = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.sd
    protected JSONObject g() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.pf) ? new JSONObject(this.pf) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.g);
        jSONObject.put("tea_event_index", this.dl);
        jSONObject.put("session_id", this.f299a);
        if (this.gc > 0) {
            jSONObject.put("user_id", this.gc);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.m) ? JSONObject.NULL : this.m);
        if (!TextUtils.isEmpty(this.e)) {
            jSONObject.put("ssid", this.e);
        }
        jSONObject.put("category", this.wp);
        jSONObject.put("tag", this.i);
        jSONObject.put("value", this.ls);
        jSONObject.put("ext_value", this.p);
        jSONObject.put("label", this.v);
        jSONObject.put("datetime", this.kb);
        if (!TextUtils.isEmpty(this.gz)) {
            jSONObject.put("ab_sdk_version", this.gz);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return this.i + ", " + this.v;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String fo() {
        return this.pf;
    }
}
