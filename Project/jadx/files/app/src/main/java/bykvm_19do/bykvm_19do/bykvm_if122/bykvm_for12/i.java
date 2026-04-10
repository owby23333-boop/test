package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f1718d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public i(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static i b(Context context, d dVar, JSONObject jSONObject) {
        return new i(UUID.randomUUID().toString(), d(context, dVar, jSONObject));
    }

    private static JSONObject d(Context context, d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", dVar.a);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt(com.anythink.expressad.foundation.g.a.S, Integer.valueOf(e.a(context)));
            jSONObject2.putOpt("datetime", f1718d.format(new Date()));
        } catch (Exception e2) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject3 = new JSONObject(strOptString);
                        jSONObject3.putOpt("v3_err_msg", e2.toString());
                        jSONObjectOptJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (dVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", dVar.f1700v.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e2.toString());
                    e0.a(jSONObject4);
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a
    public String toString() {
        return "AdEventV3{localId='" + this.a + "', event=" + this.b + '}';
    }
}
