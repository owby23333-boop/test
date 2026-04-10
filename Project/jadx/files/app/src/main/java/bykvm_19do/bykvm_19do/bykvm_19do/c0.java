package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends u {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static String f658o = "succEvent";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f664n;

    c0() {
    }

    public c0(String str, String str2, int i2) {
        this.f660j = 1;
        this.f661k = a.l();
        this.f659i = str;
        this.f662l = str2;
        this.f663m = i2;
        this.f664n = k0.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f750d = cursor.getString(3);
        this.f659i = cursor.getString(4);
        this.f660j = cursor.getInt(5);
        this.f661k = cursor.getInt(6);
        this.f662l = cursor.getString(7);
        this.f663m = cursor.getInt(8);
        this.f664n = cursor.getLong(9);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("user_unique_id", this.f750d);
        contentValues.put("event_name", this.f659i);
        contentValues.put("is_monitor", Integer.valueOf(this.f660j));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.f661k));
        contentValues.put("monitor_status", this.f662l);
        contentValues.put("monitor_num", Integer.valueOf(this.f663m));
        contentValues.put("date", Long.valueOf(this.f664n));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("user_unique_id", this.f750d);
        jSONObject.put("event_name", this.f659i);
        jSONObject.put("is_monitor", this.f660j);
        jSONObject.put("bav_monitor_rate", this.f661k);
        jSONObject.put("monitor_status", this.f662l);
        jSONObject.put("monitor_num", this.f663m);
        jSONObject.put("date", this.f664n);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "event_name", "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f750d = jSONObject.optString("user_unique_id", null);
        this.f659i = jSONObject.optString("event_name", null);
        this.f660j = jSONObject.optInt("is_monitor", 0);
        this.f661k = jSONObject.optInt("bav_monitor_rate", 0);
        this.f662l = jSONObject.optString("monitor_status", null);
        this.f663m = jSONObject.optInt("monitor_num", 0);
        this.f664n = jSONObject.optLong("date", 0L);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_name", this.f659i);
        jSONObject.put("is_monitor", this.f660j);
        jSONObject.put("bav_monitor_rate", this.f661k);
        jSONObject.put("monitor_status", this.f662l);
        jSONObject.put("monitor_num", this.f663m);
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    String d() {
        return f658o;
    }
}
