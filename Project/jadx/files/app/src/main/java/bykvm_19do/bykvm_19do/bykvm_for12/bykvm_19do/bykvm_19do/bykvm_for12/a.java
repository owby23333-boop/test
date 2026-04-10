package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private v a;
    private g b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f799c;

    public static final class b {
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f801d = true;

        public b() {
            new ArrayList();
            this.a = 10000;
            this.b = 10000;
            this.f800c = 10000;
        }

        private static int a(String str, long j2, TimeUnit timeUnit) {
            if (j2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j2 <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public b a(long j2, TimeUnit timeUnit) {
            this.a = a("timeout", j2, timeUnit);
            return this;
        }

        public b a(boolean z2) {
            this.f801d = z2;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public b b(long j2, TimeUnit timeUnit) {
            this.b = a("timeout", j2, timeUnit);
            return this;
        }

        public b c(long j2, TimeUnit timeUnit) {
            this.f800c = a("timeout", j2, timeUnit);
            return this;
        }
    }

    private a(b bVar) {
        v.b bVarB = new v.b().a(bVar.a, TimeUnit.MILLISECONDS).c(bVar.f800c, TimeUnit.MILLISECONDS).b(bVar.b, TimeUnit.MILLISECONDS);
        if (bVar.f801d) {
            this.b = new g();
            bVarB.a(this.b);
        }
        this.a = bVarB.a();
    }

    public static void d() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a(b.EnumC0025b.DEBUG);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a a() {
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a(this.a);
    }

    public void a(Context context, boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a.a(context);
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a.d(true);
        if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.c(context) || (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context) && z2)) {
            h.a().a(this.f799c, context).d();
            h.a().a(this.f799c, context).f();
        }
        if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context)) {
            h.a().a(this.f799c, context).d();
            h.a().a(this.f799c, context).f();
        }
    }

    public void a(Context context, boolean z2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        this.f799c = bVar.c();
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(this.f799c);
        }
        h.a().a(this.f799c).a(z2);
        h.a().a(this.f799c).a(bVar);
        h.a().a(this.f799c).a(context, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context));
    }

    public v b() {
        return this.a;
    }

    public c c() {
        return new c(this.a);
    }
}
