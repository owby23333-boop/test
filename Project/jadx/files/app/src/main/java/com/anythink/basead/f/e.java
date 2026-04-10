package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.basead.c.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {
    com.anythink.basead.e.a a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    com.anythink.core.common.k.a.c f6039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.anythink.basead.a.c f6040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    View f6041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    volatile boolean f6042n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    View.OnClickListener f6043o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    com.anythink.basead.a.a f6044p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f6045q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f6046r;

    /* JADX INFO: renamed from: com.anythink.basead.f.e$3, reason: invalid class name */
    final class AnonymousClass3 implements a.InterfaceC0128a {
        AnonymousClass3() {
        }

        @Override // com.anythink.basead.a.a.InterfaceC0128a
        public final void a(int i2) {
            e.a(e.this, 2);
        }
    }

    public e(Context context, j jVar, String str, boolean z2) {
        super(context, jVar, str, z2);
        this.f6046r = e.class.getSimpleName();
        this.f6043o = new View.OnClickListener() { // from class: com.anythink.basead.f.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.a(e.this, 1);
            }
        };
        this.f6045q = false;
    }

    private void b(View view) {
        if (this.f6034d.f7312m.F() != 2 || view == null || this.f6045q) {
            return;
        }
        this.f6045q = true;
        this.f6044p = new com.anythink.basead.a.a(view, this.f6034d, new AnonymousClass3());
    }

    private void c(View view) {
        this.f6041m = view;
        com.anythink.core.common.k.a.a aVar = new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.f.e.4
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view2) {
                e.this.p();
            }
        };
        if (this.f6039k == null) {
            view.getContext();
            this.f6039k = new com.anythink.core.common.k.a.c();
        }
        this.f6039k.a(view, aVar);
    }

    public static View k() {
        return null;
    }

    private void n() {
        com.anythink.basead.a.a aVar = this.f6044p;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void o() {
        com.anythink.basead.a.a aVar = this.f6044p;
        if (aVar != null) {
            aVar.b();
            this.f6044p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f6042n) {
            return;
        }
        this.f6042n = true;
        com.anythink.basead.f.a.b.a(this.f6033c).a(this.f6037g);
        com.anythink.basead.a.b.a(8, this.f6037g, new i(this.f6034d.f7303d, ""));
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow();
        }
        n();
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final String f() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.s() : "";
    }

    public final String g() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.w() : "";
    }

    public final String h() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.t() : "";
    }

    public final String i() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.u() : "";
    }

    public final String j() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.v() : "";
    }

    public final void l() {
        com.anythink.core.common.k.a.c cVar = this.f6039k;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void m() {
        l();
        o();
        this.a = null;
        com.anythink.basead.a.c cVar = this.f6040l;
        if (cVar != null) {
            cVar.d();
            this.f6040l = null;
        }
        this.f6039k = null;
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.e$2, reason: invalid class name */
    final class AnonymousClass2 implements c.b {
        final /* synthetic */ int a;

        AnonymousClass2(int i2) {
            this.a = i2;
        }

        @Override // com.anythink.basead.a.c.b
        public final void a() {
            com.anythink.basead.e.a aVar = e.this.a;
            if (aVar != null) {
                aVar.onAdClick(this.a);
            }
        }

        @Override // com.anythink.basead.a.c.b
        public final void b() {
        }

        @Override // com.anythink.basead.a.c.b
        public final void a(boolean z2) {
            com.anythink.basead.e.a aVar = e.this.a;
            if (aVar != null) {
                aVar.onDeeplinkCallback(z2);
            }
        }
    }

    private void a(int i2) {
        o();
        p();
        if (this.f6040l == null) {
            this.f6040l = new com.anythink.basead.a.c(this.f6033c, this.f6034d, this.f6037g);
        }
        if (this.f6040l.a()) {
            return;
        }
        this.f6040l.a(new AnonymousClass2(i2));
        this.f6040l.a(new i(this.f6034d.f7303d, ""));
    }

    public final String b() {
        s sVar = this.f6037g;
        return sVar != null ? sVar.r() : "";
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    public final void a(View view) {
        c(view);
        a(view, this.f6043o);
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public final void a(View view, List<View> list) {
        if (this.f6034d.f7312m.F() == 2 && view != null && !this.f6045q) {
            this.f6045q = true;
            this.f6044p = new com.anythink.basead.a.a(view, this.f6034d, new AnonymousClass3());
        }
        c(view);
        if (list != null) {
            for (View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(this.f6043o);
                }
            }
            return;
        }
        view.setOnClickListener(this.f6043o);
    }

    static /* synthetic */ void a(e eVar, int i2) {
        eVar.o();
        eVar.p();
        if (eVar.f6040l == null) {
            eVar.f6040l = new com.anythink.basead.a.c(eVar.f6033c, eVar.f6034d, eVar.f6037g);
        }
        if (eVar.f6040l.a()) {
            return;
        }
        eVar.f6040l.a(eVar.new AnonymousClass2(i2));
        eVar.f6040l.a(new i(eVar.f6034d.f7303d, ""));
    }
}
