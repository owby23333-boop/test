package com.anythink.banner.b;

import android.text.TextUtils;
import com.anythink.banner.a.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class a {
    String a;
    WeakReference<d> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Timer f5745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5746d = false;

    /* JADX INFO: renamed from: com.anythink.banner.b.a$1, reason: invalid class name */
    final class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a.a(a.this);
        }
    }

    public a(d dVar) {
        this.b = new WeakReference<>(dVar);
    }

    private TimerTask e() {
        return new AnonymousClass1();
    }

    private void f() {
        WeakReference<d> weakReference = this.b;
        d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar != null) {
            dVar.timeUpRefreshView();
        } else {
            d();
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final synchronized void b() {
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        com.anythink.core.c.d dVarA = e.a(n.a().g()).a(this.a);
        if (this.f5745c != null) {
            this.f5745c.cancel();
        }
        if (dVarA != null && dVarA.V() == 1) {
            this.f5746d = true;
            this.f5745c = new Timer();
            long jW = dVarA.W() > 5000 ? dVarA.W() : 5000L;
            this.f5745c.schedule(new AnonymousClass1(), jW, jW);
        }
    }

    public final boolean c() {
        return this.f5745c == null;
    }

    public final synchronized void d() {
        if (this.f5745c != null) {
            this.f5745c.cancel();
        }
        this.f5745c = null;
    }

    public final boolean a() {
        return this.f5746d;
    }

    static /* synthetic */ void a(a aVar) {
        WeakReference<d> weakReference = aVar.b;
        d dVar = weakReference != null ? weakReference.get() : null;
        if (dVar != null) {
            dVar.timeUpRefreshView();
        } else {
            aVar.d();
        }
    }
}
