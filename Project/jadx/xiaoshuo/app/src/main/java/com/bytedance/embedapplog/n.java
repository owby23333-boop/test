package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n extends i {
    protected String bh;
    private boolean t;
    protected String xu;

    public n(String str, boolean z, String str2) {
        this.bh = str;
        this.t = z;
        this.xu = str2;
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
        jSONObject.put("event", this.bh);
        if (this.t) {
            jSONObject.put("is_bav", 1);
        }
        if (this.t && this.xu == null) {
            m();
        }
        if (!TextUtils.isEmpty(this.xu)) {
            jSONObject.put("params", new JSONObject(this.xu));
        }
        jSONObject.put("datetime", this.wu);
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("ab_sdk_version", this.v);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
        return arrayList;
    }

    public void m() {
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return "eventv3";
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return this.bh;
    }

    @Override // com.bytedance.embedapplog.i
    public String zk() {
        return this.xu;
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        int iE = super.e(cursor);
        int i = iE + 1;
        this.bh = cursor.getString(iE);
        int i2 = i + 1;
        this.xu = cursor.getString(i);
        int i3 = i2 + 1;
        this.t = cursor.getInt(i2) == 1;
        return i3;
    }

    public n(String str, boolean z, String str2, int i) {
        this.bh = str;
        this.t = z;
        this.xu = str2;
        this.m = i;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        super.e(contentValues);
        contentValues.put("event", this.bh);
        if (this.t && this.xu == null) {
            try {
                m();
            } catch (JSONException e) {
                tx.bf(e);
            }
        }
        contentValues.put("params", this.xu);
        contentValues.put("is_bav", Integer.valueOf(this.t ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) throws JSONException {
        super.e(jSONObject);
        jSONObject.put("event", this.bh);
        if (this.t && this.xu == null) {
            m();
        }
        jSONObject.put("params", this.xu);
        jSONObject.put("is_bav", this.t);
    }

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        super.bf(jSONObject);
        this.bh = jSONObject.optString("event", null);
        this.xu = jSONObject.optString("params", null);
        this.t = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
