package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b0 extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f644l;

    private JSONObject l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.f643k);
        jSONObject.put("refer_page_key", this.f642j);
        jSONObject.put("is_back", this.f644l);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f750d = cursor.getString(3);
        this.f643k = cursor.getString(4);
        this.f642j = cursor.getString(5);
        this.f641i = cursor.getLong(6);
        this.f644l = cursor.getInt(7);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("user_unique_id", this.f750d);
        contentValues.put("page_key", this.f643k);
        contentValues.put("refer_page_key", this.f642j);
        contentValues.put("duration", Long.valueOf(this.f641i));
        contentValues.put("is_back", Integer.valueOf(this.f644l));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("page_key", this.f643k);
        jSONObject.put("refer_page_key", this.f642j);
        jSONObject.put("duration", this.f641i);
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("is_back", this.f644l);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f643k = jSONObject.optString("page_key", null);
        this.f642j = jSONObject.optString("refer_page_key", null);
        this.f641i = jSONObject.optLong("duration", 0L);
        this.f644l = jSONObject.optInt("is_back", 0);
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", l());
        jSONObject.put("datetime", this.f753g);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    String d() {
        return "page";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String h() {
        return super.h() + " name:" + this.f643k + " duration:" + this.f641i;
    }

    public boolean j() {
        return this.f641i == -1;
    }

    public boolean k() {
        return this.f643k.contains(":");
    }
}
