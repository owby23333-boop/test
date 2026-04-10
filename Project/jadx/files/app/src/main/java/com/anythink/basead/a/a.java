package com.anythink.basead.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    com.anythink.basead.d a;
    com.anythink.core.common.k.a.c b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f5748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.core.common.e.j f5749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InterfaceC0128a f5750f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f5753i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5747c = a.class.getSimpleName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f5751g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5752h = false;

    /* JADX INFO: renamed from: com.anythink.basead.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0128a {
        void a(int i2);
    }

    public a(View view, com.anythink.core.common.e.j jVar, InterfaceC0128a interfaceC0128a) {
        this.f5748d = view;
        this.f5749e = jVar;
        this.f5750f = interfaceC0128a;
        final Context applicationContext = view.getContext().getApplicationContext();
        applicationContext = applicationContext instanceof Application ? applicationContext : n.a().g();
        this.f5753i = new com.anythink.basead.a() { // from class: com.anythink.basead.a.a.1
            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                if ((a.this.f5751g == activity || a.b(a.this)) && a.this.f5753i != null) {
                    ((Application) applicationContext).unregisterActivityLifecycleCallbacks(a.this.f5753i);
                    a.this.f5753i = null;
                }
            }

            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                if (a.this.f5751g == activity || a.b(a.this)) {
                    a.this.a.b();
                }
            }

            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                if (a.this.f5751g == null && (activity instanceof BaseAdActivity)) {
                    a.this.f5751g = activity;
                }
                if (a.this.f5751g == activity || a.b(a.this)) {
                    a.c(a.this);
                }
            }
        };
        try {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.f5753i);
        } catch (Exception unused) {
            com.anythink.core.common.j.c.a("Error", "Error, cannot registerActivityLifecycleCallbacks here!", n.a().r());
        }
        this.a = new com.anythink.basead.d(this.f5749e.f7312m.G(), new Runnable() { // from class: com.anythink.basead.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(2);
            }
        });
    }

    public final void b() {
        if (this.f5753i != null) {
            ((Application) n.a().g()).unregisterActivityLifecycleCallbacks(this.f5753i);
            this.f5753i = null;
        }
        this.a.c();
        com.anythink.core.common.k.a.c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void c() {
        if (this.f5749e.f7312m.F() == 3) {
            a(3);
        }
    }

    private boolean d() {
        return this.f5749e.f7309j == 4;
    }

    private void e() {
        if (this.f5752h) {
            a();
        }
    }

    private void f() {
        this.a.b();
    }

    static /* synthetic */ void c(a aVar) {
        if (aVar.f5752h) {
            aVar.a();
        }
    }

    public final void a() {
        this.f5752h = true;
        k kVar = this.f5749e.f7312m;
        if (kVar.F() != 2 || kVar.G() < 0) {
            return;
        }
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i2) {
        if (this.f5750f != null) {
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.f5750f.a(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2) {
        int i3;
        View view;
        View view2;
        boolean z2 = true;
        if (i2 == 2 && ((i3 = this.f5749e.f7309j) == 0 || i3 == 2 ? (view = this.f5748d) == null || view.getParent() == null || !this.f5748d.isShown() || !u.b(this.f5748d) : (view2 = this.f5748d) == null || view2.getParent() == null || !this.f5748d.isShown())) {
            z2 = false;
        }
        if (z2) {
            b(i2);
            return;
        }
        int i4 = this.f5749e.f7309j;
        if (i4 == 2 || i4 == 0) {
            com.anythink.core.common.k.a.a aVar = new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.a.a.3
                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 30;
                }

                @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
                public final void recordImpression(View view3) {
                    a.this.b(i2);
                }
            };
            if (this.b == null) {
                this.f5748d.getContext();
                this.b = new com.anythink.core.common.k.a.c();
            }
            this.b.a(this.f5748d, aVar);
        }
    }

    static /* synthetic */ boolean b(a aVar) {
        return aVar.f5749e.f7309j == 4;
    }
}
