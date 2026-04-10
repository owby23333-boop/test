package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.ContentResolver;
import android.net.Uri;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static ContentResolver a() {
        try {
            if (j.l().d() != null) {
                return j.l().d().getContentResolver();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "adLogDispatch?event=" + f.a(aVar.f())));
                c.a("dispatch event getType end ");
            }
        } catch (Throwable th) {
            c.b("dispatch event Throwable:" + th.toString());
        }
    }

    private static String b() {
        return g.b + "/ad_log_event/";
    }

    public static void c() {
        c.a("start()");
        if (j.l().d() == null) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }
}
