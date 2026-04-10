package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ot extends i {

    @NonNull
    private String bh;

    @NonNull
    private String xu;

    public ot(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.bh = str;
        this.xu = jSONObject.toString();
        this.m = 0;
    }

    @Override // com.bytedance.embedapplog.i
    public JSONObject bf() throws JSONException {
        JSONObject jSONObject = new JSONObject();
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
        jSONObject.put("log_type", this.bh);
        try {
            JSONObject jSONObject2 = new JSONObject(this.xu);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    tx.bf("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            tx.d("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return "event_misc";
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return "param:" + this.xu + " logType:" + this.bh;
    }

    @Override // com.bytedance.embedapplog.i
    public String zk() {
        return this.xu;
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        int iE = super.e(cursor);
        int i = iE + 1;
        this.xu = cursor.getString(iE);
        int i2 = i + 1;
        this.bh = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        super.e(contentValues);
        contentValues.put("params", this.xu);
        contentValues.put("log_type", this.bh);
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) throws JSONException {
        super.e(jSONObject);
        jSONObject.put("params", this.xu);
        jSONObject.put("log_type", this.bh);
    }

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        super.bf(jSONObject);
        this.xu = jSONObject.optString("params", null);
        this.bh = jSONObject.optString("log_type", null);
        return this;
    }
}
