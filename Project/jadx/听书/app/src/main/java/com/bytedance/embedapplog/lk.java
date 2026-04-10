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
public class lk extends sd {
    public String fv;
    public String i;
    public int js;
    public String ls;
    public String p;
    public String pf;
    public String tb;
    public String v;
    public long wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        List<String> listZ = super.z();
        ArrayList arrayList = new ArrayList(listZ.size());
        arrayList.addAll(listZ);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        int iZ = super.z(cursor);
        int i = iZ + 1;
        this.v = cursor.getString(iZ);
        int i2 = i + 1;
        this.i = cursor.getString(i);
        int i3 = i2 + 1;
        this.wp = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.js = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.tb = cursor.getString(i4);
        int i6 = i5 + 1;
        this.pf = cursor.getString(i5);
        int i7 = i6 + 1;
        this.ls = cursor.getString(i6);
        int i8 = i7 + 1;
        this.p = cursor.getString(i7);
        int i9 = i8 + 1;
        this.fv = cursor.getString(i8);
        return i9;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        super.z(contentValues);
        contentValues.put("page_key", this.v);
        contentValues.put("refer_page_key", this.i);
        contentValues.put("duration", Long.valueOf(this.wp));
        contentValues.put("is_back", Integer.valueOf(this.js));
        contentValues.put("last_session", this.tb);
        contentValues.put("page_title", this.pf);
        contentValues.put("refer_page_title", this.ls);
        contentValues.put("page_path", this.p);
        contentValues.put("referrer_page_path", this.fv);
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        jSONObject.put("page_key", this.v);
        jSONObject.put("refer_page_key", this.i);
        jSONObject.put("duration", this.wp);
        jSONObject.put("is_back", this.js);
        jSONObject.put("page_title", this.pf);
        jSONObject.put("refer_page_title", this.ls);
        jSONObject.put("page_path", this.p);
        jSONObject.put("referrer_page_path", this.fv);
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.v = jSONObject.optString("page_key", null);
        this.i = jSONObject.optString("refer_page_key", null);
        this.wp = jSONObject.optLong("duration", 0L);
        this.js = jSONObject.optInt("is_back", 0);
        this.pf = jSONObject.optString("page_title", null);
        this.ls = jSONObject.optString("refer_page_title", null);
        this.p = jSONObject.optString("page_path", null);
        this.fv = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.sd
    protected JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", wp());
        jSONObject.put("datetime", this.kb);
        return jSONObject;
    }

    private JSONObject wp() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.v);
        jSONObject.put("refer_page_key", this.i);
        jSONObject.put("is_back", this.js);
        jSONObject.put("duration", this.wp);
        jSONObject.put("page_title", this.pf);
        jSONObject.put("refer_page_title", this.ls);
        jSONObject.put("page_path", this.p);
        jSONObject.put("referrer_page_path", this.fv);
        return jSONObject;
    }

    public boolean uy() {
        return this.wp == -1;
    }

    public boolean kb() {
        return this.v.contains(":");
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return this.v + ", " + this.wp;
    }
}
