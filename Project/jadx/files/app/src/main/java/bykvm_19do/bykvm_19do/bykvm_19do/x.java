package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class x extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f777j;

    public x(String str, JSONObject jSONObject) {
        this.f777j = str;
        this.f776i = jSONObject.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    public u a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f749c = cursor.getString(2);
        this.f750d = cursor.getString(3);
        this.f776i = cursor.getString(4);
        this.f777j = cursor.getString(5);
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.a));
        contentValues.put("tea_event_index", Long.valueOf(this.b));
        contentValues.put("session_id", this.f749c);
        contentValues.put("user_unique_id", this.f750d);
        contentValues.put("params", this.f776i);
        contentValues.put("log_type", this.f777j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.a);
        jSONObject.put("tea_event_index", this.b);
        jSONObject.put("session_id", this.f749c);
        jSONObject.put("user_unique_id", this.f750d);
        jSONObject.put("params", this.f776i);
        jSONObject.put("log_type", this.f777j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String[] a() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", "session_id", "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected u b(JSONObject jSONObject) {
        this.a = jSONObject.optLong("local_time_ms", 0L);
        this.b = jSONObject.optLong("tea_event_index", 0L);
        this.f749c = jSONObject.optString("session_id", null);
        this.f750d = jSONObject.optString("user_unique_id", null);
        this.f776i = jSONObject.optString("params", null);
        this.f777j = jSONObject.optString("log_type", null);
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
        jSONObject.put("log_type", this.f777j);
        try {
            JSONObject jSONObject2 = new JSONObject(this.f776i);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    l0.b("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e2) {
            l0.c("解析 event misc 失败", e2);
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    String d() {
        return "event_misc";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.u
    protected String h() {
        return "param:" + this.f776i + " logType:" + this.f777j;
    }
}
