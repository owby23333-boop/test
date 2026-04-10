package com.anythink.expressad.atsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String a = "a";
    public static int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f8279c = 1;

    /* JADX INFO: renamed from: com.anythink.expressad.atsignalcommon.communication.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ c a;

        AnonymousClass1(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.a(this.a.K(), this.a);
            } catch (Throwable th) {
                o.b(a.a, th.getMessage(), th);
            }
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            c cVarB = c.b(jSONObjectOptJSONObject);
            if (cVarB == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new AnonymousClass1(cVarB)).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e2) {
                a(obj, e2.getMessage());
                o.a(a, e2.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    private static void b(String str, c cVar) {
        if (f.f10448n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }

    private static void b(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(obj, e2.getMessage());
            o.a(a, e2.getMessage());
        }
    }

    private static void a(c cVar) {
        new Thread(new AnonymousClass1(cVar)).start();
    }

    private static String a(float f2, float f3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, t.a(com.anythink.expressad.foundation.b.a.b().d(), f2));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, t.a(com.anythink.expressad.foundation.b.a.b().d(), f3));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, 0);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, com.anythink.expressad.foundation.b.a.b().d().getResources().getConfiguration().orientation);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, t.c(com.anythink.expressad.foundation.b.a.b().d()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String a(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(a, "code to string is error");
            return "";
        }
    }

    private static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f8279c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
        }
    }

    static /* synthetic */ void a(String str, c cVar) {
        if (f.f10448n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }
}
