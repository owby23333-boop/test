package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class z extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile boolean f787l;

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f785j = cursor.getString(3);
        this.f784i = cursor.getInt(4);
        this.f751e = cursor.getString(5);
        this.f752f = cursor.getString(6);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("ver_name", this.f785j);
        contentValues.put("ver_code", Integer.valueOf(this.f784i));
        contentValues.put("ab_version", this.f751e);
        contentValues.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("ab_version", this.f751e);
        jSONObject.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f751e = jSONObject.optString("ab_version", null);
        this.f752f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        boolean z2 = this.f786k;
        if (z2) {
            jSONObject.put("is_background", z2);
        }
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
        return "launch";
    }
}
