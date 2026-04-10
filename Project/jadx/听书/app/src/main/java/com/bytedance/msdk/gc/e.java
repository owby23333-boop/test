package com.bytedance.msdk.gc;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f467a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public e(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static e z(Context context, a aVar, JSONObject jSONObject) {
        return new e(UUID.randomUUID().toString(), g(context, aVar, jSONObject));
    }

    private static JSONObject g(Context context, a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, aVar.z);
            jSONObject2.putOpt("params", jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(io.gc()));
            jSONObject2.putOpt("datetime", f467a.format(new Date()));
        } catch (Exception e) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject3 = new JSONObject(strOptString);
                        jSONObject3.putOpt("v3_err_msg", e.toString());
                        jSONObjectOptJSONObject.putOpt("event_extra", jSONObject3.toString());
                    }
                }
                if (aVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", aVar.iq.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e.toString());
                    l.z(jSONObject4);
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    @Override // com.bytedance.msdk.gc.z
    public String toString() {
        return "AdEventV3{localId='" + this.z + "', event=" + this.g + '}';
    }
}
