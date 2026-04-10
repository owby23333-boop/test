package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.Context;
import android.net.Uri;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.h;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static h a;

    public static h a(Context context) {
        try {
            c.a("getResolver");
            if (a == null) {
                a = j.l().b().g();
            }
        } catch (Exception unused) {
        }
        return a;
    }

    private static String a() {
        return g.b + "/ad_log_event/";
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            c.a("dispatch event getResolver before");
            h hVarA = a(j.l().d());
            c.a("dispatch event getResolver end");
            if (hVarA != null) {
                Uri uri = Uri.parse(a() + "adLogDispatch?event=" + f.a(aVar.f()));
                c.a("dispatch event getType:");
                hVarA.a(uri);
                c.a("dispatch event getType end ");
            }
        } catch (Throwable th) {
            c.b("dispatch event Throwable:" + th.toString());
        }
    }

    public static void b() {
        c.a("EventProviderImpl#start");
        if (j.l().d() == null) {
            return;
        }
        try {
            h hVarA = a(j.l().d());
            if (hVarA != null) {
                Uri uri = Uri.parse(a() + "adLogStart");
                c.a("EventProviderImpl#gettype");
                hVarA.a(uri);
            }
        } catch (Throwable unused) {
        }
    }
}
