package com.anythink.expressad.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11455c = "HandlerH5MessageManager";
    int a;
    int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11456d;

    private static final class a {
        private static b a = new b(0);

        private a() {
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private b() {
        this.f11456d = "handlerNativeResult";
        this.a = 0;
        this.b = 1;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                a(this.b, "params is null", obj);
                return;
            }
            String strOptString = jSONObject.optString("uniqueIdentifier");
            String strOptString2 = jSONObject.optString("name");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.toString())) {
                    jSONObjectOptJSONObject.optInt("type", 0);
                }
                a(this.a, "receivedMessage", obj);
                if (strOptString.equalsIgnoreCase("reporter") || !strOptString.equalsIgnoreCase("MediaPlayer")) {
                    return;
                }
                com.anythink.expressad.video.bt.a.a.a().a(obj, strOptString2, jSONArrayOptJSONArray);
                return;
            }
            a(this.b, "module or method is null", obj);
        } catch (Exception e2) {
            o.a(f11455c, e2.getMessage());
            a(this.b, e2.getMessage(), obj);
        } catch (Throwable th) {
            o.a(f11455c, th.getMessage());
            a(this.b, th.getMessage(), obj);
        }
    }

    private static void a(int i2, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            jSONObject.put("message", str);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            o.a(f11455c, e2.getMessage());
        } catch (Throwable th) {
            o.a(f11455c, th.getMessage());
        }
    }
}
