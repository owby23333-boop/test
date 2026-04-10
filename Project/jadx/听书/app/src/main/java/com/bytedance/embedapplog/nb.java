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
public class nb extends sd {
    protected String i;
    private boolean v;
    protected String wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "eventv3";
    }

    public nb(String str, boolean z, String str2) {
        this.i = str;
        this.v = z;
        this.wp = str2;
        this.uy = 0;
    }

    public nb(String str, boolean z, String str2, int i) {
        this.i = str;
        this.v = z;
        this.wp = str2;
        this.uy = i;
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        List<String> listZ = super.z();
        ArrayList arrayList = new ArrayList(listZ.size());
        arrayList.addAll(listZ);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        int iZ = super.z(cursor);
        int i = iZ + 1;
        this.i = cursor.getString(iZ);
        int i2 = i + 1;
        this.wp = cursor.getString(i);
        int i3 = i2 + 1;
        this.v = cursor.getInt(i2) == 1;
        return i3;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        super.z(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.i);
        contentValues.put("params", this.wp);
        contentValues.put("is_bav", Integer.valueOf(this.v ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.i);
        jSONObject.put("params", this.wp);
        jSONObject.put("is_bav", this.v);
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.i);
        if (this.v) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.wp)) {
            jSONObject.put("params", new JSONObject(this.wp));
        }
        jSONObject.put("datetime", this.kb);
        if (!TextUtils.isEmpty(this.gz)) {
            jSONObject.put("ab_sdk_version", this.gz);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.i = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.wp = jSONObject.optString("params", null);
        this.v = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return this.i;
    }

    @Override // com.bytedance.embedapplog.sd
    public String fo() {
        return this.wp;
    }
}
