package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d0 extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f672j;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        l0.a(null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) {
        l0.a(null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        l0.a(null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("stop_timestamp", this.f672j);
        jSONObject.put("duration", this.f671i / 1000);
        jSONObject.put("datetime", this.f753g);
        if (!TextUtils.isEmpty(this.f751e)) {
            jSONObject.put("ab_version", this.f751e);
        }
        if (!TextUtils.isEmpty(this.f752f)) {
            jSONObject.put("ab_sdk_version", this.f752f);
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    String d() {
        return "terminate";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String h() {
        return super.h() + " duration:" + this.f671i;
    }
}
