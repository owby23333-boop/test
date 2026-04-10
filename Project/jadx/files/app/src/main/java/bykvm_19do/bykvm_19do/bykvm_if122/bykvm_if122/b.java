package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.n;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile b b;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a a;

    private b(Context context) {
        if (context == null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        } else {
            context.getApplicationContext();
        }
        this.a = new a.b().a(10000L, TimeUnit.MILLISECONDS).b(10000L, TimeUnit.MILLISECONDS).c(10000L, TimeUnit.MILLISECONDS).a(true).a();
        n nVarG = this.a.b().g();
        if (nVarG != null) {
            nVarG.a(16);
        }
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                }
            }
        }
        return b;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a a() {
        return this.a;
    }
}
