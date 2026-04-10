package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wn extends sd {
    private String i;
    private String wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "event_misc";
    }

    public wn(String str, JSONObject jSONObject) {
        this.i = str;
        this.wp = jSONObject.toString();
        this.uy = 0;
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        List<String> listZ = super.z();
        ArrayList arrayList = new ArrayList(listZ.size());
        arrayList.addAll(listZ);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        int iZ = super.z(cursor);
        int i = iZ + 1;
        this.wp = cursor.getString(iZ);
        int i2 = i + 1;
        this.i = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        super.z(contentValues);
        contentValues.put("params", this.wp);
        contentValues.put("log_type", this.i);
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        jSONObject.put("params", this.wp);
        jSONObject.put("log_type", this.i);
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
        jSONObject.put("log_type", this.i);
        try {
            JSONObject jSONObject2 = new JSONObject(this.wp);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    cb.g("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            cb.dl("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.wp = jSONObject.optString("params", null);
        this.i = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return "param:" + this.wp + " logType:" + this.i;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String fo() {
        return this.wp;
    }
}
