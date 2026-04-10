package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class w extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f774n;

    w() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f750d = cursor.getString(3);
        this.f769i = cursor.getString(4);
        this.f770j = cursor.getString(5);
        this.f773m = cursor.getInt(6);
        this.f774n = cursor.getInt(7);
        this.f772l = cursor.getString(8);
        this.f771k = cursor.getString(9);
        this.f751e = cursor.getString(10);
        this.f752f = cursor.getString(11);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("user_unique_id", this.f750d);
        contentValues.put("category", this.f769i);
        contentValues.put("tag", this.f770j);
        contentValues.put("value", Long.valueOf(this.f773m));
        contentValues.put("ext_value", Long.valueOf(this.f774n));
        contentValues.put("params", this.f772l);
        contentValues.put("label", this.f771k);
        contentValues.put("ab_version", this.f751e);
        contentValues.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("user_unique_id", this.f750d);
        jSONObject.put("category", this.f769i);
        jSONObject.put("tag", this.f770j);
        jSONObject.put("value", this.f773m);
        jSONObject.put("ext_value", this.f774n);
        jSONObject.put("params", this.f772l);
        jSONObject.put("label", this.f771k);
        jSONObject.put("ab_version", this.f751e);
        jSONObject.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", "label", "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f750d = jSONObject.optString("user_unique_id", null);
        this.f769i = jSONObject.optString("category", null);
        this.f770j = jSONObject.optString("tag", null);
        this.f773m = jSONObject.optLong("value", 0L);
        this.f774n = jSONObject.optLong("ext_value", 0L);
        this.f772l = jSONObject.optString("params", null);
        this.f771k = jSONObject.optString("label", null);
        this.f751e = jSONObject.optString("ab_version", null);
        this.f752f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected JSONObject b() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.f772l) ? new JSONObject(this.f772l) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        if (!TextUtils.isEmpty(this.f750d)) {
            jSONObject.put("user_unique_id", this.f750d);
        }
        jSONObject.put("category", this.f769i);
        jSONObject.put("tag", this.f770j);
        jSONObject.put("value", this.f773m);
        jSONObject.put("ext_value", this.f774n);
        jSONObject.put("label", this.f771k);
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
        return "event";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String h() {
        return "" + this.f770j + ", " + this.f771k;
    }

    public String j() {
        return this.f770j;
    }

    public String k() {
        return this.f771k;
    }
}
