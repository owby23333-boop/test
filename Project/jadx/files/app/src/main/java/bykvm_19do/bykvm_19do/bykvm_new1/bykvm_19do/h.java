package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static boolean a;

    static final class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        a(Context context, boolean z2) {
            this.a = context;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.a.a().a(this.a);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.d.a(this.a);
            if (this.b) {
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do.f.a(this.a).a();
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull e eVar, boolean z2, boolean z3) {
        synchronized (h.class) {
            a(context, eVar, z2, false, z3);
        }
    }

    public static void a(@NonNull Context context, @NonNull e eVar, boolean z2, boolean z3, boolean z4) {
        synchronized (h.class) {
            a(context, eVar, z2, z2, z3, z4);
        }
    }

    public static void a(@NonNull Context context, @NonNull e eVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        synchronized (h.class) {
            if (!a) {
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                }
                if (eVar == null) {
                    throw new IllegalArgumentException("params must be not null.");
                }
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                if (!bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.f(context)) {
                    i.a(context, eVar);
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.e.a(context);
                    if (z2 || z3) {
                        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108.a aVarA = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108.a.a();
                        if (z2) {
                            aVarA.a(new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108.c(context));
                        }
                    }
                    a = true;
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.h.a().post(new a(context, z5));
                }
            }
        }
    }

    public static void a(g gVar) {
        i.d().a(gVar);
    }

    @Deprecated
    public static void a(String str) {
        if (i.f().e()) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108.a.a(str);
        }
    }

    public static void a(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        i.d().a(map);
    }
}
