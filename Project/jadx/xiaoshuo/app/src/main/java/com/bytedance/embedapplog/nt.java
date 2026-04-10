package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yuewen.am;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class nt extends i {
    public String bh;
    public String f;
    public boolean k;
    public String l;
    public String s;
    public boolean t;
    public int w;
    public int xu;

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
        boolean z = this.t;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.wu);
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("ab_sdk_version", this.v);
        }
        if (!TextUtils.isEmpty(this.s)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.s);
        }
        if (this.w == 1) {
            jSONObject.put("$is_first_time", com.duokan.reader.domain.payment.a.c);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.i
    public List<String> e() {
        List<String> listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT, "page_title", "varchar", "page_key", "varchar", "resume_from_background", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.i
    @NonNull
    public String tg() {
        return am.b1;
    }

    @Override // com.bytedance.embedapplog.i
    public String v() {
        return this.t ? "bg" : "fg";
    }

    @Override // com.bytedance.embedapplog.i
    public int e(@NonNull Cursor cursor) {
        int iE = super.e(cursor);
        int i = iE + 1;
        this.bh = cursor.getString(iE);
        int i2 = i + 1;
        this.xu = cursor.getInt(i);
        int i3 = i2 + 1;
        this.s = cursor.getString(i2);
        int i4 = i3 + 1;
        this.w = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.l = cursor.getString(i4);
        int i6 = i5 + 1;
        this.f = cursor.getString(i5);
        int i7 = i6 + 1;
        this.k = cursor.getInt(i6) == 1;
        return i7;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull ContentValues contentValues) {
        super.e(contentValues);
        contentValues.put("ver_name", this.bh);
        contentValues.put("ver_code", Integer.valueOf(this.xu));
        contentValues.put("last_session", this.s);
        contentValues.put("is_first_time", Integer.valueOf(this.w));
        contentValues.put("page_title", this.l);
        contentValues.put("page_key", this.f);
        contentValues.put("resume_from_background", Integer.valueOf(this.k ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.i
    public i bf(@NonNull JSONObject jSONObject) {
        tx.bf((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.i
    public void e(@NonNull JSONObject jSONObject) {
        tx.bf((Throwable) null);
    }
}
