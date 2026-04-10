package com.anythink.expressad.video.bt.a;

import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.bt.module.AnythinkBTVideoView;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11452c = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LinkedHashMap<String, AnythinkBTVideoView> f11453e = new LinkedHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11454d = "handlerNativeResult";
    int a = 0;
    int b = 1;

    /* JADX INFO: renamed from: com.anythink.expressad.video.bt.a.a$a, reason: collision with other inner class name */
    private static final class C0220a {
        private static a a = new a();

        private C0220a() {
        }
    }

    public static a a() {
        return C0220a.a;
    }

    public static void a(String str, AnythinkBTVideoView anythinkBTVideoView) {
        f11453e.put(str, anythinkBTVideoView);
    }

    public static void a(String str) {
        f11453e.remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r12, java.lang.String r13, org.json.JSONArray r14) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.a.a.a(java.lang.Object, java.lang.String, org.json.JSONArray):void");
    }

    private static void a(int i2, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            jSONObject.put("message", str);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            o.a(f11452c, e2.getMessage());
        } catch (Throwable th) {
            o.a(f11452c, th.getMessage());
        }
    }
}
