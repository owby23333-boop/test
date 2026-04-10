package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected String f779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f781k;

    public y(String str, boolean z2, String str2) {
        this.f781k = str;
        this.f780j = z2;
        this.f779i = str2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f750d = cursor.getString(3);
        this.f781k = cursor.getString(4);
        this.f779i = cursor.getString(5);
        this.f780j = cursor.getInt(6) == 1;
        this.f751e = cursor.getString(7);
        this.f752f = cursor.getString(8);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("user_unique_id", this.f750d);
        contentValues.put("event", this.f781k);
        if (this.f780j && this.f779i == null) {
            try {
                j();
            } catch (JSONException e2) {
                l0.a(e2);
            }
        }
        contentValues.put("params", this.f779i);
        contentValues.put("is_bav", Integer.valueOf(this.f780j ? 1 : 0));
        contentValues.put("ab_version", this.f751e);
        contentValues.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("user_unique_id", this.f750d);
        jSONObject.put("event", this.f781k);
        if (this.f780j && this.f779i == null) {
            j();
        }
        jSONObject.put("params", this.f779i);
        jSONObject.put("is_bav", this.f780j);
        jSONObject.put("ab_version", this.f751e);
        jSONObject.put("ab_sdk_version", this.f752f);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f750d = jSONObject.optString("user_unique_id", null);
        this.f781k = jSONObject.optString("event", null);
        this.f779i = jSONObject.optString("params", null);
        this.f780j = jSONObject.optBoolean("is_bav", false);
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
        if (!TextUtils.isEmpty(this.f750d)) {
            jSONObject.put("user_unique_id", this.f750d);
        }
        jSONObject.put("event", this.f781k);
        if (this.f780j) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.f779i)) {
            jSONObject.put("params", new JSONObject(this.f779i));
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
        return "eventv3";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String h() {
        return this.f781k;
    }

    protected void j() {
    }

    public String k() {
        return this.f781k;
    }
}
