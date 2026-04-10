package com.anythink.basead.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAdView extends RelativeLayout {
    private com.anythink.basead.a.a a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j f6114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    i f6115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    com.anythink.core.common.k.a.c f6116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.anythink.basead.a.c f6117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f6118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f6119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f6120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f6121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f6122k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f6123l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f6124m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f6125n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f6126o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f6127p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String f6128q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    List<View> f6129r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    View f6130s;

    public BaseAdView(Context context, j jVar, i iVar, String str) {
        super(context);
        this.b = "BaseAdView";
        this.f6114c = jVar;
        this.f6115d = iVar;
        this.f6128q = str;
        this.f6129r = new ArrayList();
        if (!this.f6115d.L() && this.f6114c.f7312m.F() != 1) {
            this.a = new com.anythink.basead.a.a(this, this.f6114c, new a.InterfaceC0128a() { // from class: com.anythink.basead.ui.BaseAdView.1
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.anythink.basead.a.a.InterfaceC0128a
                public final void a(int i2) {
                    BaseAdView baseAdView = BaseAdView.this;
                    View view = baseAdView.f6130s;
                    if (view != null) {
                        baseAdView.a(view);
                    } else {
                        baseAdView.a(baseAdView);
                    }
                    BaseAdView.this.b(i2);
                }
            });
        }
        d();
        a();
        setFocusable(true);
        setClickable(true);
    }

    private void c() {
        i iVar = this.f6115d;
        if ((iVar instanceof aa) && this.f6114c.f7305f == 67) {
            if (((aa) iVar).a(true, false)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.f6115d.p(), 1, 0);
            }
            if (((aa) this.f6115d).a(false, false)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.f6115d.q(), 1, 0);
            }
        }
    }

    private void o() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    protected abstract void a();

    protected abstract void a(int i2);

    protected final void a(final int i2, final Runnable runnable) {
        if (i2 > 0) {
            getContext();
            this.f6116e = new com.anythink.core.common.k.a.c(i2);
        } else {
            getContext();
            this.f6116e = new com.anythink.core.common.k.a.c();
        }
        this.f6116e.a(this, new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.ui.BaseAdView.3
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final int getImpressionMinTimeViewed() {
                int i3 = i2;
                if (i3 > 0) {
                    return i3;
                }
                return 50;
            }

            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    protected abstract void a(boolean z2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final int i2) {
        b();
        k();
        if (this.f6117f == null) {
            this.f6117f = new com.anythink.basead.a.c(getContext(), this.f6114c, this.f6115d);
        }
        if (this.f6117f.a()) {
            return;
        }
        this.f6117f.a(new c.b() { // from class: com.anythink.basead.ui.BaseAdView.2
            @Override // com.anythink.basead.a.c.b
            public final void a() {
                BaseAdView.this.a(i2);
                BaseAdView.this.f();
                BaseAdView baseAdView = BaseAdView.this;
                i iVar = baseAdView.f6115d;
                if ((iVar instanceof aa) && baseAdView.f6114c.f7305f == 67) {
                    if (((aa) iVar).a(true, false)) {
                        com.anythink.core.common.d.c.a(baseAdView.getContext()).a(baseAdView.f6115d.p(), 1, 0);
                    }
                    if (((aa) baseAdView.f6115d).a(false, false)) {
                        com.anythink.core.common.d.b.a(baseAdView.getContext()).a(baseAdView.f6115d.q(), 1, 0);
                    }
                }
            }

            @Override // com.anythink.basead.a.c.b
            public final void b() {
                BaseAdView.this.g();
            }

            @Override // com.anythink.basead.a.c.b
            public final void a(boolean z2) {
                BaseAdView.this.a(z2);
            }
        });
        com.anythink.basead.c.i iVarI = i();
        iVarI.f5935g = j();
        this.f6117f.a(iVarI);
    }

    protected void d() {
    }

    protected void destroy() {
        k();
        com.anythink.basead.a.c cVar = this.f6117f;
        if (cVar != null) {
            cVar.d();
        }
        com.anythink.core.common.k.a.c cVar2 = this.f6116e;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6120i = (int) motionEvent.getRawX();
            this.f6121j = (int) motionEvent.getRawY();
            this.f6124m = (int) motionEvent.getX();
            this.f6125n = (int) motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.f6122k = (int) motionEvent.getRawX();
            this.f6123l = (int) motionEvent.getRawY();
            this.f6126o = (int) motionEvent.getX();
            this.f6127p = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected abstract void e();

    protected void f() {
    }

    protected void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void h() {
        b();
    }

    protected com.anythink.basead.c.i i() {
        com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.f6114c.f7303d, "");
        iVar.f5933e = getWidth();
        iVar.f5934f = getHeight();
        return iVar;
    }

    protected final com.anythink.basead.c.a j() {
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = this.f6120i;
        aVar.b = this.f6121j;
        aVar.f5886c = this.f6122k;
        aVar.f5887d = this.f6123l;
        aVar.f5888e = this.f6124m;
        aVar.f5889f = this.f6125n;
        aVar.f5890g = this.f6126o;
        aVar.f5891h = this.f6127p;
        return aVar;
    }

    protected final void k() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.b();
            this.a = null;
        }
    }

    protected final void l() {
        com.anythink.basead.a.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    protected boolean m() {
        j jVar;
        k kVar;
        return com.anythink.expressad.shake.a.a().b() && (jVar = this.f6114c) != null && (kVar = jVar.f7312m) != null && kVar.M() == 1;
    }

    protected final boolean n() {
        i iVar = this.f6115d;
        return iVar != null && iVar.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    protected final void a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int iC = c(width);
        int iC2 = c(height);
        int i4 = i2 + iC;
        this.f6120i = i4;
        this.f6121j = i3 + iC2;
        this.f6124m = iC;
        this.f6125n = iC2;
        this.f6122k = i4 + ((int) (Math.random() * 15.0d));
        this.f6123l = iC + i3 + ((int) (Math.random() * 15.0d));
        this.f6126o = this.f6122k - i2;
        this.f6127p = this.f6123l - i3;
    }

    private static int c(int i2) {
        Random random = new Random();
        if (i2 <= 0) {
            return 0;
        }
        double d2 = i2;
        Double.isNaN(d2);
        int i3 = (int) (0.1d * d2);
        Double.isNaN(d2);
        return random.nextInt((((int) (d2 * 0.9d)) - i3) + 1) + i3;
    }

    private void b() {
        if (this.f6118g) {
            return;
        }
        this.f6118g = true;
        i iVar = this.f6115d;
        if (iVar instanceof s) {
            com.anythink.basead.f.a.b.a(getContext()).a((s) this.f6115d);
        } else if (iVar instanceof aa) {
            com.anythink.basead.d.c.c cVarA = com.anythink.basead.d.c.c.a();
            Context context = getContext();
            j jVar = this.f6114c;
            cVarA.a(context, com.anythink.basead.d.c.c.a(jVar.b, jVar.f7302c), this.f6115d, this.f6114c.f7312m);
        }
        i iVar2 = this.f6115d;
        if ((iVar2 instanceof aa) && this.f6114c.f7305f == 67) {
            if (((aa) iVar2).a(true, true)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.f6115d.p(), 0, 1);
            }
            if (((aa) this.f6115d).a(false, true)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.f6115d.q(), 0, 1);
            }
        }
        e();
        o();
    }

    public BaseAdView(Context context, j jVar, i iVar) {
        this(context, jVar, iVar, "");
    }

    public BaseAdView(Context context) {
        super(context);
        this.b = "BaseAdView";
    }

    protected float a(a aVar, int i2) {
        float f2 = 1.0f;
        if (aVar != null) {
            if (i2 == 2) {
                f2 = 1.5f;
            } else if (i2 == 3) {
                f2 = 0.75f;
            } else if (i2 == 4) {
                f2 = 0.5f;
            }
            aVar.setClickAreaScaleFactor(f2);
        }
        return f2;
    }

    private void b(View view) {
        this.f6130s = view;
    }
}
