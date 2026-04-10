package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zz extends sd {
    public String fv;
    public String i;
    public boolean js;
    public int ls;
    public String p;
    public String pf;
    public boolean tb;
    public boolean v;
    public int wp;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "launch";
    }

    public zz(boolean z) {
        this.tb = z;
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        List<String> listZ = super.z();
        ArrayList arrayList = new ArrayList(listZ.size());
        arrayList.addAll(listZ);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT, "page_title", "varchar", "page_key", "varchar", "resume_from_background", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        int iZ = super.z(cursor);
        int i = iZ + 1;
        this.i = cursor.getString(iZ);
        int i2 = i + 1;
        this.wp = cursor.getInt(i);
        int i3 = i2 + 1;
        this.pf = cursor.getString(i2);
        int i4 = i3 + 1;
        this.ls = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.p = cursor.getString(i4);
        int i6 = i5 + 1;
        this.fv = cursor.getString(i5);
        int i7 = i6 + 1;
        this.js = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        super.z(contentValues);
        contentValues.put("ver_name", this.i);
        contentValues.put("ver_code", Integer.valueOf(this.wp));
        contentValues.put("last_session", this.pf);
        contentValues.put("is_first_time", Integer.valueOf(this.ls));
        contentValues.put("page_title", this.p);
        contentValues.put("page_key", this.fv);
        contentValues.put("resume_from_background", Integer.valueOf(this.js ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) {
        cb.g((Throwable) null);
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
        boolean z = this.v;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.kb);
        if (!TextUtils.isEmpty(this.gz)) {
            jSONObject.put("ab_sdk_version", this.gz);
        }
        if (!TextUtils.isEmpty(this.pf)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.pf);
        }
        if (this.ls == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.tb);
        jSONObject.put("is_background", !this.tb);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        cb.g((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return this.v ? "bg" : "fg";
    }
}
