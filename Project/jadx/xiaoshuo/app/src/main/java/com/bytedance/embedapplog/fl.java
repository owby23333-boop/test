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
public class fl extends i {
    public String bh;
    public String dt;
    public String f;
    public int k;
    public String l;
    public String s;
    public String t;
    public String w;
    public long xu;

    private JSONObject xu() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.t);
        jSONObject.put("refer_page_key", this.bh);
        jSONObject.put("is_back", this.k);
        jSONObject.put("duration", this.xu);
        jSONObject.put("page_title", this.s);
        jSONObject.put("refer_page_title", this.w);
        jSONObject.put("page_path", this.l);
        jSONObject.put("referrer_page_path", this.f);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        super.bf(jSONObject);
        this.t = jSONObject.optString("page_key", null);
        this.bh = jSONObject.optString("refer_page_key", null);
        this.xu = jSONObject.optLong("duration", 0L);
        this.k = jSONObject.optInt("is_back", 0);
        this.s = jSONObject.optString("page_title", null);
        this.w = jSONObject.optString("refer_page_title", null);
        this.l = jSONObject.optString("page_path", null);
        this.f = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    public boolean m() {
        return this.xu == -1;
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return this.t + ", " + this.xu;
    }

    public boolean wu() {
        return this.t.contains(":");
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        int iE = super.e(cursor);
        int i = iE + 1;
        this.t = cursor.getString(iE);
        int i2 = i + 1;
        this.bh = cursor.getString(i);
        int i3 = i2 + 1;
        this.xu = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.k = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.dt = cursor.getString(i4);
        int i6 = i5 + 1;
        this.s = cursor.getString(i5);
        int i7 = i6 + 1;
        this.w = cursor.getString(i6);
        int i8 = i7 + 1;
        this.l = cursor.getString(i7);
        int i9 = i8 + 1;
        this.f = cursor.getString(i8);
        return i9;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", xu());
        jSONObject.put("datetime", this.wu);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        super.e(contentValues);
        contentValues.put("page_key", this.t);
        contentValues.put("refer_page_key", this.bh);
        contentValues.put("duration", Long.valueOf(this.xu));
        contentValues.put("is_back", Integer.valueOf(this.k));
        contentValues.put("last_session", this.dt);
        contentValues.put("page_title", this.s);
        contentValues.put("refer_page_title", this.w);
        contentValues.put("page_path", this.l);
        contentValues.put("referrer_page_path", this.f);
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) throws JSONException {
        super.e(jSONObject);
        jSONObject.put("page_key", this.t);
        jSONObject.put("refer_page_key", this.bh);
        jSONObject.put("duration", this.xu);
        jSONObject.put("is_back", this.k);
        jSONObject.put("page_title", this.s);
        jSONObject.put("refer_page_title", this.w);
        jSONObject.put("page_path", this.l);
        jSONObject.put("referrer_page_path", this.f);
    }
}
