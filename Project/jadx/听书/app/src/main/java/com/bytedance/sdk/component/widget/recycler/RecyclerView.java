package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.a;
import com.bytedance.sdk.component.widget.recycler.g;
import com.bytedance.sdk.component.widget.recycler.i;
import com.bytedance.sdk.component.widget.recycler.v;
import com.bytedance.sdk.component.widget.recycler.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.z.dl.dl {
    private EdgeEffect b;
    private int bm;
    private boolean bv;
    com.bytedance.sdk.component.widget.recycler.g e;
    private int ec;
    private int f;
    boolean fo;
    boolean fv;
    private int gb;
    final ls gc;
    boolean gk;
    private final fv gp;
    final com.bytedance.sdk.component.widget.recycler.v gz;
    final tb h;
    com.bytedance.sdk.component.widget.recycler.a hh;
    private final int[] hn;
    z i;
    boolean io;
    boolean iq;
    private wp ja;
    private final AccessibilityManager jq;
    boolean js;
    private Runnable k;
    final Rect kb;
    a.z l;
    private boolean lk;
    boolean lq;
    final ArrayList<gz> ls;
    private EdgeEffect lw;
    private com.bytedance.sdk.component.widget.recycler.z.dl.a ly;
    com.bytedance.sdk.component.widget.recycler.z m;
    final int[] mc;
    private int me;
    private final int[] n;
    private final int nb;
    private VelocityTracker nh;
    boolean p;
    p pf;
    boolean q;
    private gc qd;
    private int r;
    private EdgeEffect rv;
    private a s;
    private int sd;
    private List<v> sf;
    private List<kb> sv;
    final iq sy;
    private final Rect t;
    boolean tb;
    private int tc;
    private int tf;
    final List<zw> ti;
    private v u;
    m uf;
    final int[] un;
    final Runnable uy;
    fo v;
    private final ArrayList<i> vm;
    private float vo;
    private final int wn;
    private final int[] wo;
    final RectF wp;
    private final v.g wx;
    boolean x;
    private i y;
    private m.z yw;
    private int yx;
    private int yz;
    boolean zw;
    private EdgeEffect zx;
    private float zz;
    private static final int[] oq = {R.attr.nestedScrollingEnabled};
    private static final int[] wj = {R.attr.clipToPadding};
    static final boolean z = false;
    static final boolean g = true;
    static final boolean dl = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f810a = true;
    private static final boolean na = false;
    private static final boolean xl = false;
    private static final Class<?>[] j = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator eo = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    public interface a {
        int z(int i, int i2);
    }

    public static abstract class dl {
        public void z() {
        }

        public void z(int i, int i2, Object obj) {
        }
    }

    public interface i {
        boolean z(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface kb {
        void g(View view);

        void z(View view);
    }

    public interface p {
    }

    public static abstract class q {
        public abstract View z(ls lsVar, int i, int i2);
    }

    public static abstract class v {
        public void z(RecyclerView recyclerView, int i) {
        }

        public void z(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static abstract class wp {
        public abstract boolean z(int i, int i2);
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.gp = new fv();
        this.gc = new ls();
        this.gz = new com.bytedance.sdk.component.widget.recycler.v();
        this.uy = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.js || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.p) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.q) {
                    RecyclerView.this.tb = true;
                } else {
                    RecyclerView.this.a();
                }
            }
        };
        this.kb = new Rect();
        this.t = new Rect();
        this.wp = new RectF();
        this.ls = new ArrayList<>();
        this.vm = new ArrayList<>();
        this.ec = 0;
        this.zw = false;
        this.io = false;
        this.f = 0;
        this.yx = 0;
        this.qd = new gc();
        this.uf = new com.bytedance.sdk.component.widget.recycler.dl();
        this.tc = 0;
        this.me = -1;
        this.zz = Float.MIN_VALUE;
        this.vo = Float.MIN_VALUE;
        this.lk = true;
        this.sy = new iq();
        this.l = f810a ? new a.z() : null;
        this.h = new tb();
        this.gk = false;
        this.x = false;
        this.yw = new e();
        this.lq = false;
        this.n = new int[2];
        this.hn = new int[2];
        this.mc = new int[2];
        this.wo = new int[2];
        this.un = new int[2];
        this.ti = new ArrayList();
        this.k = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.uf != null) {
                    RecyclerView.this.uf.z();
                }
                RecyclerView.this.lq = false;
            }
        };
        this.wx = new v.g() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.v.g
            public void z(zw zwVar, m.g gVar, m.g gVar2) {
                RecyclerView.this.gc.dl(zwVar);
                RecyclerView.this.g(zwVar, gVar, gVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v.g
            public void g(zw zwVar, m.g gVar, m.g gVar2) {
                RecyclerView.this.z(zwVar, gVar, gVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v.g
            public void dl(zw zwVar, m.g gVar, m.g gVar2) {
                zwVar.z(false);
                if (RecyclerView.this.zw) {
                    if (RecyclerView.this.uf.z(zwVar, zwVar, gVar, gVar2)) {
                        RecyclerView.this.pf();
                    }
                } else if (RecyclerView.this.uf.dl(zwVar, gVar, gVar2)) {
                    RecyclerView.this.pf();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v.g
            public void z(zw zwVar) {
                RecyclerView.this.v.z(zwVar.z, RecyclerView.this.gc);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wj, i2, 0);
                this.fo = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
        } else {
            this.fo = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.tf = viewConfiguration.getScaledTouchSlop();
        this.zz = com.bytedance.sdk.component.widget.recycler.z.dl.e.z(viewConfiguration, context);
        this.vo = com.bytedance.sdk.component.widget.recycler.z.dl.e.g(viewConfiguration, context);
        this.wn = viewConfiguration.getScaledMinimumFlingVelocity();
        this.nb = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.uf.z(this.yw);
        g();
        uf();
        io();
        if (com.bytedance.sdk.component.widget.recycler.z.dl.e.g(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.z.dl.e.z(this, 1);
        }
        this.jq = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        setNestedScrollingEnabled(true);
    }

    String z() {
        return " " + super.toString() + ", adapter:" + this.i + ", layout:" + this.v + ", context:" + getContext();
    }

    private void io() {
        if (com.bytedance.sdk.component.widget.recycler.z.dl.e.fo(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.z.dl.e.g(this, 8);
        }
    }

    private void uf() {
        this.e = new com.bytedance.sdk.component.widget.recycler.g(new g.InterfaceC0144g() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public int z() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void z(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.wp(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public int z(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void z(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.kb(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public View g(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void g() {
                int iZ = z();
                for (int i2 = 0; i2 < iZ; i2++) {
                    View viewG = g(i2);
                    RecyclerView.this.kb(viewG);
                    viewG.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public zw g(View view) {
                return RecyclerView.gc(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void z(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                zw zwVarGc = RecyclerView.gc(view);
                if (zwVarGc != null) {
                    if (!zwVarGc.fv() && !zwVarGc.L_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + zwVarGc + RecyclerView.this.z());
                    }
                    zwVarGc.i();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void dl(int i2) {
                zw zwVarGc;
                View viewG = g(i2);
                if (viewG != null && (zwVarGc = RecyclerView.gc(viewG)) != null) {
                    if (zwVarGc.fv() && !zwVarGc.L_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + zwVarGc + RecyclerView.this.z());
                    }
                    zwVarGc.g(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void dl(View view) {
                zw zwVarGc = RecyclerView.gc(view);
                if (zwVarGc != null) {
                    zwVarGc.z(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.g.InterfaceC0144g
            public void a(View view) {
                zw zwVarGc = RecyclerView.gc(view);
                if (zwVarGc != null) {
                    zwVarGc.g(RecyclerView.this);
                }
            }
        });
    }

    void g() {
        this.m = new com.bytedance.sdk.component.widget.recycler.z(new z.InterfaceC0145z() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public zw z(int i2) {
                zw zwVarZ = RecyclerView.this.z(i2, true);
                if (zwVarZ == null || RecyclerView.this.e.dl(zwVarZ.z)) {
                    return null;
                }
                return zwVarZ;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public void z(int i2, int i3) {
                RecyclerView.this.z(i2, i3, true);
                RecyclerView.this.gk = true;
                RecyclerView.this.h.dl += i3;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public void g(int i2, int i3) {
                RecyclerView.this.z(i2, i3, false);
                RecyclerView.this.gk = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public void z(int i2, int i3, Object obj) {
                RecyclerView.this.z(i2, i3, obj);
                RecyclerView.this.x = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public void dl(int i2, int i3) {
                RecyclerView.this.e(i2, i3);
                RecyclerView.this.gk = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.z.InterfaceC0145z
            public void a(int i2, int i3) {
                RecyclerView.this.m(i2, i3);
                RecyclerView.this.gk = true;
            }
        });
    }

    public void setHasFixedSize(boolean z2) {
        this.fv = z2;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.fo) {
            kb();
        }
        this.fo = z2;
        super.setClipToPadding(z2);
        if (this.js) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.fo;
    }

    public void setAdapter(z zVar) {
        setLayoutFrozen(false);
        z(zVar, false, true);
        dl(false);
        requestLayout();
    }

    void dl() {
        m mVar = this.uf;
        if (mVar != null) {
            mVar.a();
        }
        fo foVar = this.v;
        if (foVar != null) {
            foVar.dl(this.gc);
            this.v.g(this.gc);
        }
        this.gc.z();
    }

    private void z(z zVar, boolean z2, boolean z3) {
        z zVar2 = this.i;
        if (zVar2 != null) {
            zVar2.g(this.gp);
        }
        if (!z2 || z3) {
            dl();
        }
        this.m.z();
        z zVar3 = this.i;
        this.i = zVar;
        if (zVar != null) {
            zVar.z(this.gp);
        }
        this.gc.z(zVar3, this.i, z2);
        this.h.m = true;
    }

    public z getAdapter() {
        return this.i;
    }

    public void setRecyclerListener(p pVar) {
        this.pf = pVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        fo foVar = this.v;
        return foVar != null ? foVar.fv() : super.getBaseline();
    }

    public void z(kb kbVar) {
        if (this.sv == null) {
            this.sv = new ArrayList();
        }
        this.sv.add(kbVar);
    }

    public void setLayoutManager(fo foVar) {
        if (foVar != this.v) {
            m();
            if (this.v != null) {
                m mVar = this.uf;
                if (mVar != null) {
                    mVar.a();
                }
                this.v.dl(this.gc);
                this.v.g(this.gc);
                this.gc.z();
                if (this.p) {
                    this.v.g(this, this.gc);
                }
                this.v.z((RecyclerView) null);
                this.v = null;
            } else {
                this.gc.z();
            }
            this.e.z();
            this.v = foVar;
            if (foVar != null) {
                if (foVar.fo != null) {
                    throw new IllegalArgumentException("LayoutManager " + foVar + " is already attached to a RecyclerView:" + foVar.fo.z());
                }
                this.v.z(this);
                if (this.p) {
                    this.v.g(this);
                }
            }
            this.gc.g();
            requestLayout();
        }
    }

    public void setOnFlingListener(wp wpVar) {
        this.ja = wpVar;
    }

    public wp getOnFlingListener() {
        return this.ja;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void gc(zw zwVar) {
        View view = zwVar.z;
        boolean z2 = view.getParent() == this;
        this.gc.dl(g(view));
        if (zwVar.fv()) {
            this.e.z(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.e.z(view, true);
        } else {
            this.e.a(view);
        }
    }

    boolean z(View view) {
        gc();
        boolean zM = this.e.m(view);
        if (zM) {
            zw zwVarGc = gc(view);
            this.gc.dl(zwVarGc);
            this.gc.g(zwVarGc);
        }
        z(!zM);
        return zM;
    }

    public fo getLayoutManager() {
        return this.v;
    }

    public pf getRecycledViewPool() {
        return this.gc.e();
    }

    public void setRecycledViewPool(pf pfVar) {
        this.gc.z(pfVar);
    }

    public void setViewCacheExtension(q qVar) {
        this.gc.z(qVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.gc.z(i2);
    }

    public int getScrollState() {
        return this.tc;
    }

    void setScrollState(int i2) {
        if (i2 != this.tc) {
            this.tc = i2;
            if (i2 != 2) {
                hh();
            }
            e(i2);
        }
    }

    public void z(gz gzVar, int i2) {
        fo foVar = this.v;
        if (foVar != null) {
            foVar.z("Cannot add item decoration during a scroll  or layout");
        }
        if (this.ls.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.ls.add(gzVar);
        } else {
            this.ls.add(i2, gzVar);
        }
        p();
        requestLayout();
    }

    public void z(gz gzVar) {
        z(gzVar, -1);
    }

    public int getItemDecorationCount() {
        return this.ls.size();
    }

    public void setChildDrawingOrderCallback(a aVar) {
        if (aVar != this.s) {
            this.s = aVar;
            setChildrenDrawingOrderEnabled(aVar != null);
        }
    }

    public void z(v vVar) {
        if (this.sf == null) {
            this.sf = new ArrayList();
        }
        this.sf.add(vVar);
    }

    public void g(v vVar) {
        List<v> list = this.sf;
        if (list != null) {
            list.remove(vVar);
        }
    }

    void z(int i2) {
        fo foVar = this.v;
        if (foVar != null) {
            foVar.a(i2);
            awakenScrollBars();
        }
    }

    public void g(int i2) {
        if (this.q) {
            return;
        }
        fo foVar = this.v;
        if (foVar == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            foVar.z(this, this.h, i2);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        fo foVar = this.v;
        if (foVar == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.q) {
            return;
        }
        boolean zDl = foVar.dl();
        boolean zA = this.v.a();
        if (zDl || zA) {
            if (!zDl) {
                i2 = 0;
            }
            if (!zA) {
                i3 = 0;
            }
            z(i2, i3, (MotionEvent) null);
        }
    }

    void z(int i2, int i3, int[] iArr) {
        gc();
        wp();
        com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV Scroll");
        z(this.h);
        int iZ = i2 != 0 ? this.v.z(i2, this.gc, this.h) : 0;
        int iG = i3 != 0 ? this.v.g(i3, this.gc, this.h) : 0;
        com.bytedance.sdk.component.widget.recycler.z.z.z.z();
        iq();
        i();
        z(false);
        if (iArr != null) {
            iArr[0] = iZ;
            iArr[1] = iG;
        }
    }

    void a() {
        if (this.js && !this.zw) {
            if (!this.m.a()) {
                return;
            }
            if (this.m.z(4) && !this.m.z(11)) {
                com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV PartialInvalidate");
                gc();
                wp();
                this.m.g();
                if (!this.tb) {
                    if (sy()) {
                        ls();
                    } else {
                        this.m.dl();
                    }
                }
                z(true);
                i();
                com.bytedance.sdk.component.widget.recycler.z.z.z.z();
                return;
            }
            if (!this.m.a()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV FullInvalidate");
        ls();
        com.bytedance.sdk.component.widget.recycler.z.z.z.z();
    }

    private boolean sy() {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            zw zwVarGc = gc(this.e.g(i2));
            if (zwVarGc != null && !zwVarGc.L_() && zwVarGc.sy()) {
                return true;
            }
        }
        return false;
    }

    boolean z(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        a();
        if (this.i != null) {
            z(i2, i3, this.un);
            int[] iArr = this.un;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i5 = i9;
            i6 = i8;
            i7 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.ls.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (z(i6, i5, i7, i4, this.hn, 0)) {
            int i11 = this.bm;
            int[] iArr2 = this.hn;
            int i12 = iArr2[0];
            this.bm = i11 - i12;
            int i13 = this.sd;
            int i14 = iArr2[1];
            this.sd = i13 - i14;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i12, i14);
            }
            int[] iArr3 = this.wo;
            int i15 = iArr3[0];
            int[] iArr4 = this.hn;
            iArr3[0] = i15 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.z.dl.e.z(motionEvent, 8194)) {
                z(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            dl(i2, i3);
        }
        if (i6 != 0 || i5 != 0) {
            gz(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        fo foVar = this.v;
        if (foVar != null && foVar.dl()) {
            return this.v.dl(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        fo foVar = this.v;
        if (foVar != null && foVar.dl()) {
            return this.v.gc(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        fo foVar = this.v;
        if (foVar != null && foVar.dl()) {
            return this.v.e(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        fo foVar = this.v;
        if (foVar != null && foVar.a()) {
            return this.v.a(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        fo foVar = this.v;
        if (foVar != null && foVar.a()) {
            return this.v.m(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        fo foVar = this.v;
        if (foVar != null && foVar.a()) {
            return this.v.gz(this.h);
        }
        return 0;
    }

    void gc() {
        int i2 = this.ec + 1;
        this.ec = i2;
        if (i2 != 1 || this.q) {
            return;
        }
        this.tb = false;
    }

    void z(boolean z2) {
        if (this.ec <= 0) {
            this.ec = 1;
        }
        if (!z2 && !this.q) {
            this.tb = false;
        }
        if (this.ec == 1) {
            if (z2 && this.tb && !this.q && this.v != null && this.i != null) {
                ls();
            }
            if (!this.q) {
                this.tb = false;
            }
        }
        this.ec--;
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.q) {
            z("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.q = false;
                if (this.tb && this.v != null && this.i != null) {
                    requestLayout();
                }
                this.tb = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.q = true;
            this.bv = true;
            m();
        }
    }

    public void z(int i2, int i3) {
        z(i2, i3, (Interpolator) null);
    }

    public void z(int i2, int i3, Interpolator interpolator) {
        fo foVar = this.v;
        if (foVar == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.q) {
            return;
        }
        if (!foVar.dl()) {
            i2 = 0;
        }
        if (!this.v.a()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.sy.z(i2, i3, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean g(int i2, int i3) {
        fo foVar = this.v;
        if (foVar == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.q) {
            return false;
        }
        int iDl = foVar.dl();
        boolean zA = this.v.a();
        if (iDl == 0 || Math.abs(i2) < this.wn) {
            i2 = 0;
        }
        if (!zA || Math.abs(i3) < this.wn) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f = i2;
        float f2 = i3;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z2 = iDl != 0 || zA;
            dispatchNestedFling(f, f2, z2);
            wp wpVar = this.ja;
            if (wpVar != null && wpVar.z(i2, i3)) {
                return true;
            }
            if (z2) {
                if (zA) {
                    iDl = (iDl == true ? 1 : 0) | 2;
                }
                fo(iDl, 1);
                int i4 = this.nb;
                int iMax = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.nb;
                this.sy.z(iMax, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    public void m() {
        setScrollState(0);
        hh();
    }

    private void hh() {
        this.sy.g();
        fo foVar = this.v;
        if (foVar != null) {
            foVar.lq();
        }
    }

    public int getMinFlingVelocity() {
        return this.wn;
    }

    public int getMaxFlingVelocity() {
        return this.nb;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.e()
            android.widget.EdgeEffect r1 = r6.zx
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            com.bytedance.sdk.component.widget.recycler.z.dl.z.z(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.gz()
            android.widget.EdgeEffect r1 = r6.lw
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.z.dl.z.z(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.fo()
            android.widget.EdgeEffect r9 = r6.b
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            com.bytedance.sdk.component.widget.recycler.z.dl.z.z(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.uy()
            android.widget.EdgeEffect r9 = r6.rv
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            com.bytedance.sdk.component.widget.recycler.z.dl.z.z(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            com.bytedance.sdk.component.widget.recycler.z.dl.e.dl(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.z(float, float, float, float):void");
    }

    private void l() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.zx;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.zx.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.b;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.b.isFinished();
        }
        EdgeEffect edgeEffect3 = this.lw;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.lw.isFinished();
        }
        EdgeEffect edgeEffect4 = this.rv;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.rv.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.z.dl.e.dl(this);
        }
    }

    void dl(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.zx;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.zx.onRelease();
            zIsFinished = this.zx.isFinished();
        }
        EdgeEffect edgeEffect2 = this.lw;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.lw.onRelease();
            zIsFinished |= this.lw.isFinished();
        }
        EdgeEffect edgeEffect3 = this.b;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.b.onRelease();
            zIsFinished |= this.b.isFinished();
        }
        EdgeEffect edgeEffect4 = this.rv;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.rv.onRelease();
            zIsFinished |= this.rv.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.z.dl.e.dl(this);
        }
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            e();
            this.zx.onAbsorb(-i2);
        } else if (i2 > 0) {
            gz();
            this.lw.onAbsorb(i2);
        }
        if (i3 < 0) {
            fo();
            this.b.onAbsorb(-i3);
        } else if (i3 > 0) {
            uy();
            this.rv.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.z.dl.e.dl(this);
    }

    void e() {
        if (this.zx == null) {
            EdgeEffect edgeEffectZ = this.qd.z(this, 0);
            this.zx = edgeEffectZ;
            if (this.fo) {
                edgeEffectZ.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectZ.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gz() {
        if (this.lw == null) {
            EdgeEffect edgeEffectZ = this.qd.z(this, 2);
            this.lw = edgeEffectZ;
            if (this.fo) {
                edgeEffectZ.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectZ.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void fo() {
        if (this.b == null) {
            EdgeEffect edgeEffectZ = this.qd.z(this, 1);
            this.b = edgeEffectZ;
            if (this.fo) {
                edgeEffectZ.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectZ.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void uy() {
        if (this.rv == null) {
            EdgeEffect edgeEffectZ = this.qd.z(this, 3);
            this.rv = edgeEffectZ;
            if (this.fo) {
                edgeEffectZ.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectZ.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void kb() {
        this.rv = null;
        this.b = null;
        this.lw = null;
        this.zx = null;
    }

    public static <T> T z(T t) {
        t.getClass();
        return t;
    }

    public void setEdgeEffectFactory(gc gcVar) {
        z(gcVar);
        this.qd = gcVar;
        kb();
    }

    public gc getEdgeEffectFactory() {
        return this.qd;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewZ;
        boolean z2;
        View viewA = this.v.a(view, i2);
        if (viewA != null) {
            return viewA;
        }
        boolean z3 = (this.i == null || this.v == null || v() || this.q) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.v.a()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (na) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.v.dl()) {
                int i4 = (this.v.p() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (na) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                a();
                if (dl(view) == null) {
                    return null;
                }
                gc();
                this.v.z(view, i2, this.gc, this.h);
                z(false);
            }
            viewZ = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                a();
                if (dl(view) == null) {
                    return null;
                }
                gc();
                viewZ = this.v.z(view, i2, this.gc, this.h);
                z(false);
            } else {
                viewZ = viewFindNextFocus;
            }
        }
        if (viewZ == null || viewZ.hasFocusable()) {
            return z(view, viewZ, i2) ? viewZ : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        z(viewZ, (View) null);
        return view;
    }

    private boolean z(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || dl(view2) == null) {
            return false;
        }
        if (view == null || dl(view) == null) {
            return true;
        }
        this.kb.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.kb);
        offsetDescendantRectToMyCoords(view2, this.t);
        byte b = -1;
        int i4 = this.v.p() == 1 ? -1 : 1;
        if ((this.kb.left < this.t.left || this.kb.right <= this.t.left) && this.kb.right < this.t.right) {
            i3 = 1;
        } else {
            i3 = ((this.kb.right > this.t.right || this.kb.left >= this.t.right) && this.kb.left > this.t.left) ? -1 : 0;
        }
        if ((this.kb.top < this.t.top || this.kb.bottom <= this.t.top) && this.kb.bottom < this.t.bottom) {
            b = 1;
        } else if ((this.kb.bottom <= this.t.bottom && this.kb.top < this.t.bottom) || this.kb.top <= this.t.top) {
            b = 0;
        }
        if (i2 == 1) {
            return b < 0 || (b == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b > 0 || (b == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + z());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.v.z(this, this.h, view, view2) && view2 != null) {
            z(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void z(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.kb.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof uy) {
            uy uyVar = (uy) layoutParams;
            if (!uyVar.dl) {
                Rect rect = uyVar.g;
                this.kb.left -= rect.left;
                this.kb.right += rect.right;
                this.kb.top -= rect.top;
                this.kb.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.kb);
            offsetRectIntoDescendantCoords(view, this.kb);
        }
        this.v.z(this, view, this.kb, !this.js, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.v.z(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        fo foVar = this.v;
        if (foVar == null || !foVar.z(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (v()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.f = r0
            r1 = 1
            r4.p = r1
            boolean r2 = r4.js
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r4.js = r1
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r1 = r4.v
            if (r1 == 0) goto L1e
            r1.g(r4)
        L1e:
            r4.lq = r0
            boolean r0 = com.bytedance.sdk.component.widget.recycler.RecyclerView.f810a
            if (r0 == 0) goto L65
            java.lang.ThreadLocal<com.bytedance.sdk.component.widget.recycler.a> r0 = com.bytedance.sdk.component.widget.recycler.a.z
            java.lang.Object r0 = r0.get()
            com.bytedance.sdk.component.widget.recycler.a r0 = (com.bytedance.sdk.component.widget.recycler.a) r0
            r4.hh = r0
            if (r0 != 0) goto L60
            com.bytedance.sdk.component.widget.recycler.a r0 = new com.bytedance.sdk.component.widget.recycler.a
            r0.<init>()
            r4.hh = r0
            android.view.Display r0 = com.bytedance.sdk.component.widget.recycler.z.dl.e.e(r4)
            boolean r1 = r4.isInEditMode()
            if (r1 != 0) goto L4e
            if (r0 == 0) goto L4e
            float r0 = r0.getRefreshRate()
            r1 = 1106247680(0x41f00000, float:30.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L4e
            goto L50
        L4e:
            r0 = 1114636288(0x42700000, float:60.0)
        L50:
            com.bytedance.sdk.component.widget.recycler.a r1 = r4.hh
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f822a = r2
            java.lang.ThreadLocal<com.bytedance.sdk.component.widget.recycler.a> r0 = com.bytedance.sdk.component.widget.recycler.a.z
            com.bytedance.sdk.component.widget.recycler.a r1 = r4.hh
            r0.set(r1)
        L60:
            com.bytedance.sdk.component.widget.recycler.a r0 = r4.hh
            r0.z(r4)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.a aVar;
        super.onDetachedFromWindow();
        m mVar = this.uf;
        if (mVar != null) {
            mVar.a();
        }
        m();
        this.p = false;
        fo foVar = this.v;
        if (foVar != null) {
            foVar.g(this, this.gc);
        }
        this.ti.clear();
        removeCallbacks(this.k);
        this.gz.g();
        if (!f810a || (aVar = this.hh) == null) {
            return;
        }
        aVar.g(this);
        this.hh = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.p;
    }

    void z(String str) {
        if (v()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + z());
            }
            throw new IllegalStateException(str);
        }
        if (this.yx > 0) {
            com.bytedance.sdk.component.utils.wp.g("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(z()));
        }
    }

    private boolean z(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.y = null;
        }
        int size = this.vm.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.vm.get(i2);
            if (iVar.z(this, motionEvent) && action != 3) {
                this.y = iVar;
                return true;
            }
        }
        return false;
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.y != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.y = null;
                }
                return true;
            }
            this.y = null;
        }
        if (action != 0) {
            int size = this.vm.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = this.vm.get(i2);
                if (iVar.z(this, motionEvent)) {
                    this.y = iVar;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.q) {
            return false;
        }
        if (z(motionEvent)) {
            gk();
            return true;
        }
        fo foVar = this.v;
        if (foVar == null) {
            return false;
        }
        boolean zDl = foVar.dl();
        boolean zA = this.v.a();
        if (this.nh == null) {
            this.nh = VelocityTracker.obtain();
        }
        this.nh.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.bv) {
                this.bv = false;
            }
            this.me = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.bm = x;
            this.r = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.sd = y;
            this.yz = y;
            if (this.tc == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.wo;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zDl;
            if (zA) {
                i2 = (zDl ? 1 : 0) | 2;
            }
            fo(i2, 0);
        } else if (actionMasked == 1) {
            this.nh.clear();
            gz(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.me);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Error processing scroll; pointer index for id " + this.me + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.tc != 1) {
                int i3 = x2 - this.r;
                int i4 = y2 - this.yz;
                if (!zDl || Math.abs(i3) <= this.tf) {
                    z2 = false;
                } else {
                    this.bm = x2;
                    z2 = true;
                }
                if (zA && Math.abs(i4) > this.tf) {
                    this.sd = y2;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            gk();
        } else if (actionMasked == 5) {
            this.me = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.bm = x3;
            this.r = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.sd = y3;
            this.yz = y3;
        } else if (actionMasked == 6) {
            dl(motionEvent);
        }
        return this.tc == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.vm.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.vm.get(i2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void h() {
        VelocityTracker velocityTracker = this.nh;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        gz(0);
        l();
    }

    private void gk() {
        h();
        setScrollState(0);
    }

    private void dl(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.me) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.me = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.bm = x;
            this.r = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.sd = y;
            this.yz = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r0 = r5.v
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.q
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L75
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r0 = r5.v
            boolean r0 = r0.a()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r3 = r5.v
            boolean r3 = r3.dl()
            if (r3 == 0) goto L54
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r3 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r0 = r5.v
            boolean r0 = r0.a()
            if (r0 == 0) goto L56
            float r0 = -r3
        L54:
            r3 = r2
            goto L62
        L56:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$fo r0 = r5.v
            boolean r0 = r0.dl()
            if (r0 == 0) goto L60
            r0 = r2
            goto L62
        L60:
            r0 = r2
            r3 = r0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L75
        L6a:
            float r2 = r5.zz
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.vo
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.z(r2, r0, r6)
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        fo foVar = this.v;
        if (foVar == null) {
            gc(i2, i3);
            return;
        }
        boolean z2 = false;
        if (!foVar.z()) {
            if (this.fv) {
                this.v.z(this.gc, this.h, i2, i3);
                return;
            }
            if (this.iq) {
                gc();
                wp();
                mc();
                i();
                if (this.h.kb) {
                    this.h.e = true;
                } else {
                    this.m.gc();
                    this.h.e = false;
                }
                this.iq = false;
                z(false);
            } else if (this.h.kb) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            z zVar = this.i;
            if (zVar != null) {
                this.h.gc = zVar.z();
            } else {
                this.h.gc = 0;
            }
            gc();
            this.v.z(this.gc, this.h, i2, i3);
            z(false);
            this.h.e = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.v.z(this.gc, this.h, i2, i3);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z2 = true;
        }
        if (z2 || this.i == null) {
            return;
        }
        if (this.h.f819a == 1) {
            wj();
        }
        this.v.g(i2, i3);
        this.h.fo = true;
        na();
        this.v.dl(i2, i3);
        if (this.v.fo()) {
            this.v.g(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.h.fo = true;
            na();
            this.v.dl(i2, i3);
        }
    }

    void gc(int i2, int i3) {
        setMeasuredDimension(fo.z(i2, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.z.dl.e.a(this)), fo.z(i3, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.z.dl.e.gc(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        kb();
    }

    public void setItemAnimator(m mVar) {
        m mVar2 = this.uf;
        if (mVar2 != null) {
            mVar2.a();
            this.uf.z(null);
        }
        this.uf = mVar;
        if (mVar != null) {
            mVar.z(this.yw);
        }
    }

    void wp() {
        this.f++;
    }

    void i() {
        g(true);
    }

    void g(boolean z2) {
        int i2 = this.f - 1;
        this.f = i2;
        if (i2 <= 0) {
            this.f = 0;
            if (z2) {
                x();
                zw();
            }
        }
    }

    private void x() {
        this.gb = 0;
    }

    public boolean v() {
        return this.f > 0;
    }

    public m getItemAnimator() {
        return this.uf;
    }

    void pf() {
        if (this.lq || !this.p) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.z.dl.e.z(this, this.k);
        this.lq = true;
    }

    private boolean lq() {
        return this.uf != null && this.v.wp();
    }

    private void mc() {
        if (this.zw) {
            this.m.z();
        }
        if (lq()) {
            this.m.g();
        } else {
            this.m.gc();
        }
        boolean z2 = false;
        boolean z3 = this.gk || this.x;
        this.h.uy = this.js && this.uf != null && (this.zw || z3 || this.v.i) && (!this.zw || this.i.g());
        tb tbVar = this.h;
        if (tbVar.uy && z3 && !this.zw && lq()) {
            z2 = true;
        }
        tbVar.kb = z2;
    }

    void ls() {
        if (this.i == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.v == null) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.h.fo = false;
        if (this.h.f819a == 1) {
            wj();
        } else {
            if (!this.m.m() && this.v.iq() == getWidth() && this.v.zw() == getHeight()) {
                this.v.a(this);
            }
            xl();
        }
        this.v.a(this);
        na();
        xl();
    }

    private void un() {
        View focusedChild = (this.lk && hasFocus() && this.i != null) ? getFocusedChild() : null;
        zw zwVarA = focusedChild != null ? a(focusedChild) : null;
        if (zwVarA == null) {
            ti();
            return;
        }
        this.h.i = this.i.g() ? zwVarA.e() : -1L;
        this.h.wp = this.zw ? -1 : zwVarA.p() ? zwVarA.f821a : zwVarA.gc();
        this.h.v = i(zwVarA.z);
    }

    private void ti() {
        this.h.i = -1L;
        this.h.wp = -1;
        this.h.v = -1;
    }

    private View eo() {
        zw zwVarA;
        int i2 = this.h.wp != -1 ? this.h.wp : 0;
        int iA = this.h.a();
        for (int i3 = i2; i3 < iA; i3++) {
            zw zwVarA2 = a(i3);
            if (zwVarA2 == null) {
                break;
            }
            if (zwVarA2.z.hasFocusable()) {
                return zwVarA2.z;
            }
        }
        int iMin = Math.min(iA, i2);
        do {
            iMin--;
            if (iMin < 0 || (zwVarA = a(iMin)) == null) {
                return null;
            }
        } while (!zwVarA.z.hasFocusable());
        return zwVarA.z;
    }

    private void oq() {
        View viewFindViewById;
        if (!this.lk || this.i == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (xl && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.e.g() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.e.dl(focusedChild)) {
                return;
            }
        }
        View viewEo = null;
        zw zwVarZ = (this.h.i == -1 || !this.i.g()) ? null : z(this.h.i);
        if (zwVarZ != null && !this.e.dl(zwVarZ.z) && zwVarZ.z.hasFocusable()) {
            viewEo = zwVarZ.z;
        } else if (this.e.g() > 0) {
            viewEo = eo();
        }
        if (viewEo != null) {
            if (this.h.v != -1 && (viewFindViewById = viewEo.findViewById(this.h.v)) != null && viewFindViewById.isFocusable()) {
                viewEo = viewFindViewById;
            }
            viewEo.requestFocus();
        }
    }

    private int i(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void z(tb tbVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.sy.z;
            tbVar.pf = overScroller.getFinalX() - overScroller.getCurrX();
            tbVar.ls = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            tbVar.pf = 0;
            tbVar.ls = 0;
        }
    }

    private void wj() {
        this.h.z(1);
        z(this.h);
        this.h.fo = false;
        gc();
        this.gz.z();
        wp();
        mc();
        un();
        tb tbVar = this.h;
        tbVar.gz = tbVar.uy && this.x;
        this.x = false;
        this.gk = false;
        tb tbVar2 = this.h;
        tbVar2.e = tbVar2.kb;
        this.h.gc = this.i.z();
        z(this.n);
        if (this.h.uy) {
            int iG = this.e.g();
            for (int i2 = 0; i2 < iG; i2++) {
                zw zwVarGc = gc(this.e.g(i2));
                if (!zwVarGc.L_() && (!zwVarGc.v() || this.i.g())) {
                    this.gz.z(zwVarGc, this.uf.z(this.h, zwVarGc, m.gc(zwVarGc), zwVarGc.q()));
                    if (this.h.gz && zwVarGc.sy() && !zwVarGc.p() && !zwVarGc.L_() && !zwVarGc.v()) {
                        this.gz.z(z(zwVarGc), zwVarGc);
                    }
                }
            }
        }
        if (this.h.kb) {
            fv();
            boolean z2 = this.h.m;
            this.h.m = false;
            this.v.z(this.gc, this.h);
            this.h.m = z2;
            for (int i3 = 0; i3 < this.e.g(); i3++) {
                zw zwVarGc2 = gc(this.e.g(i3));
                if (!zwVarGc2.L_() && !this.gz.a(zwVarGc2)) {
                    int iGc = m.gc(zwVarGc2);
                    boolean z3 = zwVarGc2.z(8192);
                    if (!z3) {
                        iGc |= 4096;
                    }
                    m.g gVarZ = this.uf.z(this.h, zwVarGc2, iGc, zwVarGc2.q());
                    if (z3) {
                        z(zwVarGc2, gVarZ);
                    } else {
                        this.gz.g(zwVarGc2, gVarZ);
                    }
                }
            }
            js();
        } else {
            js();
        }
        i();
        z(false);
        this.h.f819a = 2;
    }

    private void na() {
        gc();
        wp();
        this.h.z(6);
        this.m.gc();
        this.h.gc = this.i.z();
        this.h.dl = 0;
        this.h.e = false;
        this.v.z(this.gc, this.h);
        this.h.m = false;
        tb tbVar = this.h;
        tbVar.uy = tbVar.uy && this.uf != null;
        this.h.f819a = 4;
        i();
        z(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void xl() {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.xl():void");
    }

    private void z(long j2, zw zwVar, zw zwVar2) {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            zw zwVarGc = gc(this.e.g(i2));
            if (zwVarGc != zwVar && z(zwVarGc) == j2) {
                z zVar = this.i;
                if (zVar != null && zVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + zwVarGc + " \n View Holder 2:" + zwVar + z());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + zwVarGc + " \n View Holder 2:" + zwVar + z());
            }
        }
        com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + zwVar2 + " cannot be found but it is necessary for " + zwVar + z());
    }

    void z(zw zwVar, m.g gVar) {
        zwVar.z(0, 8192);
        if (this.h.gz && zwVar.sy() && !zwVar.p() && !zwVar.L_()) {
            this.gz.z(z(zwVar), zwVar);
        }
        this.gz.z(zwVar, gVar);
    }

    private void z(int[] iArr) {
        int iG = this.e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iG; i4++) {
            zw zwVarGc = gc(this.e.g(i4));
            if (!zwVarGc.L_()) {
                int iA = zwVarGc.a();
                if (iA < i2) {
                    i2 = iA;
                }
                if (iA > i3) {
                    i3 = iA;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean uy(int i2, int i3) {
        z(this.n);
        int[] iArr = this.n;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        zw zwVarGc = gc(view);
        if (zwVarGc != null) {
            if (zwVarGc.fv()) {
                zwVarGc.i();
            } else if (!zwVarGc.L_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + zwVarGc + z());
            }
        }
        view.clearAnimation();
        kb(view);
        super.removeDetachedView(view, z2);
    }

    long z(zw zwVar) {
        return this.i.g() ? zwVar.e() : zwVar.dl;
    }

    void z(zw zwVar, m.g gVar, m.g gVar2) {
        zwVar.z(false);
        if (this.uf.g(zwVar, gVar, gVar2)) {
            pf();
        }
    }

    void g(zw zwVar, m.g gVar, m.g gVar2) {
        gc(zwVar);
        zwVar.z(false);
        if (this.uf.z(zwVar, gVar, gVar2)) {
            pf();
        }
    }

    private void z(zw zwVar, zw zwVar2, m.g gVar, m.g gVar2, boolean z2, boolean z3) {
        zwVar.z(false);
        if (z2) {
            gc(zwVar);
        }
        if (zwVar != zwVar2) {
            if (z3) {
                gc(zwVar2);
            }
            zwVar.gz = zwVar2;
            gc(zwVar);
            this.gc.dl(zwVar);
            zwVar2.z(false);
            zwVar2.fo = zwVar;
        }
        if (this.uf.z(zwVar, zwVar2, gVar, gVar2)) {
            pf();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV OnLayout");
        ls();
        com.bytedance.sdk.component.widget.recycler.z.z.z.z();
        this.js = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ec == 0 && !this.q) {
            super.requestLayout();
        } else {
            this.tb = true;
        }
    }

    void p() {
        int iDl = this.e.dl();
        for (int i2 = 0; i2 < iDl; i2++) {
            ((uy) this.e.a(i2).getLayoutParams()).dl = true;
        }
        this.gc.uy();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.ls.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.ls.get(i2);
        }
        EdgeEffect edgeEffect = this.zx;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.fo ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.zx;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.b;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.fo) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.b;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.lw;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.fo ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.lw;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.rv;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.fo) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.rv;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.uf == null || this.ls.size() <= 0 || !this.uf.g()) ? z2 : true) {
            com.bytedance.sdk.component.widget.recycler.z.dl.e.dl(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.ls.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ls.get(i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof uy) && this.v.z((uy) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        fo foVar = this.v;
        if (foVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
        }
        return foVar.g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        fo foVar = this.v;
        if (foVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
        }
        return foVar.z(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        fo foVar = this.v;
        if (foVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
        }
        return foVar.z(layoutParams);
    }

    void fv() {
        int iDl = this.e.dl();
        for (int i2 = 0; i2 < iDl; i2++) {
            zw zwVarGc = gc(this.e.a(i2));
            if (!zwVarGc.L_()) {
                zwVarGc.g();
            }
        }
    }

    void js() {
        int iDl = this.e.dl();
        for (int i2 = 0; i2 < iDl; i2++) {
            zw zwVarGc = gc(this.e.a(i2));
            if (!zwVarGc.L_()) {
                zwVarGc.z();
            }
        }
        this.gc.fo();
    }

    void m(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iDl = this.e.dl();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < iDl; i7++) {
            zw zwVarGc = gc(this.e.a(i7));
            if (zwVarGc != null && zwVarGc.dl >= i5 && zwVarGc.dl <= i4) {
                if (zwVarGc.dl == i2) {
                    zwVarGc.z(i3 - i2, false);
                } else {
                    zwVarGc.z(i6, false);
                }
                this.h.m = true;
            }
        }
        this.gc.z(i2, i3);
        requestLayout();
    }

    void e(int i2, int i3) {
        int iDl = this.e.dl();
        for (int i4 = 0; i4 < iDl; i4++) {
            zw zwVarGc = gc(this.e.a(i4));
            if (zwVarGc != null && !zwVarGc.L_() && zwVarGc.dl >= i2) {
                zwVarGc.z(i3, false);
                this.h.m = true;
            }
        }
        this.gc.g(i2, i3);
        requestLayout();
    }

    void z(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iDl = this.e.dl();
        for (int i5 = 0; i5 < iDl; i5++) {
            zw zwVarGc = gc(this.e.a(i5));
            if (zwVarGc != null && !zwVarGc.L_()) {
                if (zwVarGc.dl >= i4) {
                    zwVarGc.z(-i3, z2);
                    this.h.m = true;
                } else if (zwVarGc.dl >= i2) {
                    zwVarGc.z(i2 - 1, -i3, z2);
                    this.h.m = true;
                }
            }
        }
        this.gc.z(i2, i3, z2);
        requestLayout();
    }

    void z(int i2, int i3, Object obj) {
        int iDl = this.e.dl();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iDl; i5++) {
            View viewA = this.e.a(i5);
            zw zwVarGc = gc(viewA);
            if (zwVarGc != null && !zwVarGc.L_() && zwVarGc.dl >= i2 && zwVarGc.dl < i4) {
                zwVarGc.g(2);
                zwVarGc.z(obj);
                ((uy) viewA.getLayoutParams()).dl = true;
            }
        }
        this.gc.dl(i2, i3);
    }

    boolean g(zw zwVar) {
        m mVar = this.uf;
        return mVar == null || mVar.z(zwVar, zwVar.q());
    }

    void dl(boolean z2) {
        this.io = z2 | this.io;
        this.zw = true;
        tb();
    }

    void tb() {
        int iDl = this.e.dl();
        for (int i2 = 0; i2 < iDl; i2++) {
            zw zwVarGc = gc(this.e.a(i2));
            if (zwVarGc != null && !zwVarGc.L_()) {
                zwVarGc.g(6);
            }
        }
        p();
        this.gc.gz();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.lk;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.lk = z2;
    }

    public zw g(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return gc(view);
    }

    public View dl(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public zw a(View view) {
        View viewDl = dl(view);
        if (viewDl == null) {
            return null;
        }
        return g(viewDl);
    }

    static zw gc(View view) {
        if (view == null) {
            return null;
        }
        return ((uy) view.getLayoutParams()).z;
    }

    @Deprecated
    public int m(View view) {
        return e(view);
    }

    public int e(View view) {
        zw zwVarGc = gc(view);
        if (zwVarGc != null) {
            return zwVarGc.gc();
        }
        return -1;
    }

    public int gz(View view) {
        zw zwVarGc = gc(view);
        if (zwVarGc != null) {
            return zwVarGc.a();
        }
        return -1;
    }

    public zw dl(int i2) {
        return z(i2, false);
    }

    public zw a(int i2) {
        zw zwVar = null;
        if (this.zw) {
            return null;
        }
        int iDl = this.e.dl();
        for (int i3 = 0; i3 < iDl; i3++) {
            zw zwVarGc = gc(this.e.a(i3));
            if (zwVarGc != null && !zwVarGc.p() && a(zwVarGc) == i2) {
                if (!this.e.dl(zwVarGc.z)) {
                    return zwVarGc;
                }
                zwVar = zwVarGc;
            }
        }
        return zwVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.bytedance.sdk.component.widget.recycler.RecyclerView.zw z(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.g r0 = r5.e
            int r0 = r0.dl()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L38
            com.bytedance.sdk.component.widget.recycler.g r3 = r5.e
            android.view.View r3 = r3.a(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zw r3 = gc(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.p()
            if (r4 != 0) goto L35
            if (r7 == 0) goto L23
            int r4 = r3.dl
            if (r4 == r6) goto L29
            goto L35
        L23:
            int r4 = r3.a()
            if (r4 != r6) goto L35
        L29:
            com.bytedance.sdk.component.widget.recycler.g r1 = r5.e
            android.view.View r4 = r3.z
            boolean r1 = r1.dl(r4)
            if (r1 != 0) goto L34
            return r3
        L34:
            r1 = r3
        L35:
            int r2 = r2 + 1
            goto L8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.z(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$zw");
    }

    public zw z(long j2) {
        z zVar = this.i;
        zw zwVar = null;
        if (zVar != null && zVar.g()) {
            int iDl = this.e.dl();
            for (int i2 = 0; i2 < iDl; i2++) {
                zw zwVarGc = gc(this.e.a(i2));
                if (zwVarGc != null && !zwVarGc.p() && zwVarGc.e() == j2) {
                    if (!this.e.dl(zwVarGc.z)) {
                        return zwVarGc;
                    }
                    zwVar = zwVarGc;
                }
            }
        }
        return zwVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void gc(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.g(i3).offsetTopAndBottom(i2);
        }
    }

    public void m(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.g(i3).offsetLeftAndRight(i2);
        }
    }

    static void z(View view, Rect rect) {
        uy uyVar = (uy) view.getLayoutParams();
        Rect rect2 = uyVar.g;
        rect.set((view.getLeft() - rect2.left) - uyVar.leftMargin, (view.getTop() - rect2.top) - uyVar.topMargin, view.getRight() + rect2.right + uyVar.rightMargin, view.getBottom() + rect2.bottom + uyVar.bottomMargin);
    }

    Rect fo(View view) {
        uy uyVar = (uy) view.getLayoutParams();
        if (!uyVar.dl) {
            return uyVar.g;
        }
        if (this.h.z() && (uyVar.dl() || uyVar.z())) {
            return uyVar.g;
        }
        Rect rect = uyVar.g;
        rect.set(0, 0, 0, 0);
        int size = this.ls.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.kb.set(0, 0, 0, 0);
            this.ls.get(i2).z(this.kb, view, this, this.h);
            rect.left += this.kb.left;
            rect.top += this.kb.top;
            rect.right += this.kb.right;
            rect.bottom += this.kb.bottom;
        }
        uyVar.dl = false;
        return rect;
    }

    void gz(int i2, int i3) {
        this.yx++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        v vVar = this.u;
        if (vVar != null) {
            vVar.z(this, i2, i3);
        }
        List<v> list = this.sf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sf.get(size).z(this, i2, i3);
            }
        }
        this.yx--;
    }

    void e(int i2) {
        fo foVar = this.v;
        if (foVar != null) {
            foVar.kb(i2);
        }
        v vVar = this.u;
        if (vVar != null) {
            vVar.z(this, i2);
        }
        List<v> list = this.sf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sf.get(size).z(this, i2);
            }
        }
    }

    public boolean q() {
        return !this.js || this.zw || this.m.a();
    }

    void iq() {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewG = this.e.g(i2);
            zw zwVarG = g(viewG);
            if (zwVarG != null && zwVarG.fo != null) {
                View view = zwVarG.fo.z;
                int left = viewG.getLeft();
                int top2 = viewG.getTop();
                if (left != view.getLeft() || top2 != view.getTop()) {
                    view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
                }
            }
        }
    }

    static RecyclerView uy(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewUy = uy(viewGroup.getChildAt(i2));
            if (recyclerViewUy != null) {
                return recyclerViewUy;
            }
        }
        return null;
    }

    static void dl(zw zwVar) {
        if (zwVar.g != null) {
            RecyclerView recyclerView = zwVar.g.get();
            while (recyclerView != null) {
                if (recyclerView == zwVar.z) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            zwVar.g = null;
        }
    }

    long getNanoTime() {
        if (f810a) {
            return System.nanoTime();
        }
        return 0L;
    }

    void kb(View view) {
        gc(view);
        List<kb> list = this.sv;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sv.get(size).g(view);
            }
        }
    }

    void wp(View view) {
        gc(view);
        List<kb> list = this.sv;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sv.get(size).z(view);
            }
        }
    }

    boolean z(zw zwVar, int i2) {
        if (v()) {
            zwVar.pf = i2;
            this.ti.add(zwVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.z.dl.e.z(zwVar.z, i2);
        return true;
    }

    void zw() {
        int i2;
        for (int size = this.ti.size() - 1; size >= 0; size--) {
            zw zwVar = this.ti.get(size);
            if (zwVar.z.getParent() == this && !zwVar.L_() && (i2 = zwVar.pf) != -1) {
                com.bytedance.sdk.component.widget.recycler.z.dl.e.z(zwVar.z, i2);
                zwVar.pf = -1;
            }
        }
        this.ti.clear();
    }

    int a(zw zwVar) {
        if (zwVar.z(524) || !zwVar.ls()) {
            return -1;
        }
        return this.m.dl(zwVar.dl);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().z(z2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().z();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().g(i2);
    }

    public boolean fo(int i2, int i3) {
        return getScrollingChildHelper().z(i2, i3);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.z.dl.g
    public void stopNestedScroll() {
        getScrollingChildHelper().dl();
    }

    public void gz(int i2) {
        getScrollingChildHelper().dl(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g();
    }

    public boolean fo(int i2) {
        return getScrollingChildHelper().z(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().z(i2, i3, i4, i5, iArr);
    }

    public boolean z(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().z(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().z(i2, i3, iArr, iArr2);
    }

    public boolean z(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().z(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z2) {
        return getScrollingChildHelper().z(f, f2, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().z(f, f2);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        a aVar = this.s;
        return aVar == null ? super.getChildDrawingOrder(i2, i3) : aVar.z(i2, i3);
    }

    private com.bytedance.sdk.component.widget.recycler.z.dl.a getScrollingChildHelper() {
        if (this.ly == null) {
            this.ly = new com.bytedance.sdk.component.widget.recycler.z.dl.a(this);
        }
        return this.ly;
    }

    public static abstract class m {
        private z z = null;
        private ArrayList<Object> g = new ArrayList<>();
        private long dl = 120;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f816a = 120;
        private long gc = 250;
        private long m = 250;

        interface z {
            void z(zw zwVar);
        }

        public abstract void a();

        public abstract void a(zw zwVar);

        public abstract boolean dl(zw zwVar, g gVar, g gVar2);

        public boolean e(zw zwVar) {
            return true;
        }

        public abstract boolean g();

        public abstract boolean g(zw zwVar, g gVar, g gVar2);

        public abstract void z();

        public abstract boolean z(zw zwVar, g gVar, g gVar2);

        public abstract boolean z(zw zwVar, zw zwVar2, g gVar, g gVar2);

        public long gc() {
            return this.gc;
        }

        public long m() {
            return this.dl;
        }

        public long e() {
            return this.f816a;
        }

        public long gz() {
            return this.m;
        }

        void z(z zVar) {
            this.z = zVar;
        }

        public g z(tb tbVar, zw zwVar, int i, List<Object> list) {
            return uy().z(zwVar);
        }

        public g z(tb tbVar, zw zwVar) {
            return uy().z(zwVar);
        }

        static int gc(zw zwVar) {
            int i = zwVar.uy & 14;
            if (zwVar.v()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iM = zwVar.m();
            int iGc = zwVar.gc();
            return (iM == -1 || iGc == -1 || iM == iGc) ? i : i | 2048;
        }

        public final void m(zw zwVar) {
            z zVar = this.z;
            if (zVar != null) {
                zVar.z(zwVar);
            }
        }

        public boolean z(zw zwVar, List<Object> list) {
            return e(zwVar);
        }

        public final void fo() {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.g.get(i);
            }
            this.g.clear();
        }

        public g uy() {
            return new g();
        }

        public static class g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f817a;
            public int dl;
            public int g;
            public int z;

            public g z(zw zwVar) {
                return z(zwVar, 0);
            }

            public g z(zw zwVar, int i) {
                View view = zwVar.z;
                this.z = view.getLeft();
                this.g = view.getTop();
                this.dl = view.getRight();
                this.f817a = view.getBottom();
                return this;
            }
        }
    }

    private class e implements m.z {
        e() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m.z
        public void z(zw zwVar) {
            zwVar.z(true);
            if (zwVar.gz != null && zwVar.fo == null) {
                zwVar.gz = null;
            }
            zwVar.fo = null;
            if (zwVar.io() || RecyclerView.this.z(zwVar.z) || !zwVar.fv()) {
                return;
            }
            RecyclerView.this.removeDetachedView(zwVar.z, false);
        }
    }

    public static class tb {
        long i;
        int ls;
        private SparseArray<Object> p;
        int pf;
        int v;
        int wp;
        int z = -1;
        int g = 0;
        int dl = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f819a = 1;
        int gc = 0;
        boolean m = false;
        boolean e = false;
        boolean gz = false;
        boolean fo = false;
        boolean uy = false;
        boolean kb = false;

        void z(int i) {
            if ((this.f819a & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f819a));
            }
        }

        void z(z zVar) {
            this.f819a = 1;
            this.gc = zVar.z();
            this.e = false;
            this.gz = false;
            this.fo = false;
        }

        public boolean z() {
            return this.e;
        }

        public boolean g() {
            return this.kb;
        }

        public boolean dl() {
            return this.z != -1;
        }

        public int a() {
            return this.e ? this.g - this.dl : this.gc;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.z + ", mData=" + this.p + ", mItemCount=" + this.gc + ", mIsMeasuring=" + this.fo + ", mPreviousLayoutItemCount=" + this.g + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.dl + ", mStructureChanged=" + this.m + ", mInPreLayout=" + this.e + ", mRunSimpleAnimations=" + this.uy + ", mRunPredictiveAnimations=" + this.kb + '}';
        }
    }

    static class g extends Observable<dl> {
        g() {
        }

        public void z() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((dl) this.mObservers.get(size)).z();
            }
        }

        public void z(int i, int i2) {
            z(i, i2, null);
        }

        public void z(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((dl) this.mObservers.get(size)).z(i, i2, obj);
            }
        }
    }

    public static abstract class js {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f813a;
        private fo dl;
        private RecyclerView g;
        private boolean gc;
        private boolean gz;
        private View m;
        private int z = -1;
        private final z e = new z(0, 0);

        public interface g {
            PointF dl(int i);
        }

        protected abstract void z();

        protected abstract void z(int i, int i2, tb tbVar, z zVar);

        protected abstract void z(View view, tb tbVar, z zVar);

        void z(RecyclerView recyclerView, fo foVar) {
            if (this.gz) {
                com.bytedance.sdk.component.utils.wp.g("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.g = recyclerView;
            this.dl = foVar;
            if (this.z == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.h.z = this.z;
            this.gc = true;
            this.f813a = true;
            this.m = gc(gz());
            this.g.sy.z();
            this.gz = true;
        }

        public void dl(int i) {
            this.z = i;
        }

        public PointF a(int i) {
            Object objA = a();
            if (objA instanceof g) {
                return ((g) objA).dl(i);
            }
            com.bytedance.sdk.component.utils.wp.g("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + g.class.getCanonicalName());
            return null;
        }

        public fo a() {
            return this.dl;
        }

        protected final void gc() {
            if (this.gc) {
                this.gc = false;
                z();
                this.g.h.z = -1;
                this.m = null;
                this.z = -1;
                this.f813a = false;
                this.dl.g(this);
                this.dl = null;
                this.g = null;
            }
        }

        public boolean m() {
            return this.f813a;
        }

        public boolean e() {
            return this.gc;
        }

        public int gz() {
            return this.z;
        }

        void z(int i, int i2) {
            PointF pointFA;
            RecyclerView recyclerView = this.g;
            if (!this.gc || this.z == -1 || recyclerView == null) {
                gc();
            }
            if (this.f813a && this.m == null && this.dl != null && (pointFA = a(this.z)) != null && (pointFA.x != 0.0f || pointFA.y != 0.0f)) {
                recyclerView.z((int) Math.signum(pointFA.x), (int) Math.signum(pointFA.y), (int[]) null);
            }
            this.f813a = false;
            View view = this.m;
            if (view != null) {
                if (z(view) == this.z) {
                    z(this.m, recyclerView.h, this.e);
                    this.e.z(recyclerView);
                    gc();
                } else {
                    com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.m = null;
                }
            }
            if (this.gc) {
                z(i, i2, recyclerView.h, this.e);
                boolean z2 = this.e.z();
                this.e.z(recyclerView);
                if (z2) {
                    if (this.gc) {
                        this.f813a = true;
                        recyclerView.sy.z();
                    } else {
                        gc();
                    }
                }
            }
        }

        public int z(View view) {
            return this.g.gz(view);
        }

        public int fo() {
            return this.g.v.js();
        }

        public View gc(int i) {
            return this.g.v.g(i);
        }

        protected void g(View view) {
            if (z(view) == gz()) {
                this.m = view;
            }
        }

        protected void z(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class z {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f814a;
            private int dl;
            private int e;
            private int g;
            private Interpolator gc;
            private boolean m;
            private int z;

            public z(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public z(int i, int i2, int i3, Interpolator interpolator) {
                this.f814a = -1;
                this.m = false;
                this.e = 0;
                this.z = i;
                this.g = i2;
                this.dl = i3;
                this.gc = interpolator;
            }

            public void z(int i) {
                this.f814a = i;
            }

            boolean z() {
                return this.f814a >= 0;
            }

            void z(RecyclerView recyclerView) {
                int i = this.f814a;
                if (i >= 0) {
                    this.f814a = -1;
                    recyclerView.z(i);
                    this.m = false;
                } else {
                    if (this.m) {
                        g();
                        if (this.gc == null) {
                            if (this.dl == Integer.MIN_VALUE) {
                                recyclerView.sy.g(this.z, this.g);
                            } else {
                                recyclerView.sy.z(this.z, this.g, this.dl);
                            }
                        } else {
                            recyclerView.sy.z(this.z, this.g, this.dl, this.gc);
                        }
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (i2 > 10) {
                            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.m = false;
                        return;
                    }
                    this.e = 0;
                }
            }

            private void g() {
                if (this.gc != null && this.dl <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.dl <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.z = i;
                this.g = i2;
                this.dl = i3;
                this.gc = interpolator;
                this.m = true;
            }
        }
    }

    public static class uy extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f820a;
        boolean dl;
        final Rect g;
        zw z;

        public uy(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.g = new Rect();
            this.dl = true;
            this.f820a = false;
        }

        public uy(int i, int i2) {
            super(i, i2);
            this.g = new Rect();
            this.dl = true;
            this.f820a = false;
        }

        public uy(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.g = new Rect();
            this.dl = true;
            this.f820a = false;
        }

        public uy(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.g = new Rect();
            this.dl = true;
            this.f820a = false;
        }

        public uy(uy uyVar) {
            super((ViewGroup.MarginLayoutParams) uyVar);
            this.g = new Rect();
            this.dl = true;
            this.f820a = false;
        }

        public boolean z() {
            return this.z.v();
        }

        public boolean g() {
            return this.z.p();
        }

        public boolean dl() {
            return this.z.sy();
        }

        public int a() {
            return this.z.a();
        }
    }

    public static abstract class zw {
        private static final List<Object> p = Collections.emptyList();
        WeakReference<RecyclerView> g;
        RecyclerView ls;
        int uy;
        public final View z;
        int dl = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f821a = -1;
        long gc = -1;
        int m = -1;
        int e = -1;
        zw gz = null;
        zw fo = null;
        List<Object> kb = null;
        List<Object> wp = null;
        private int fv = 0;
        ls i = null;
        boolean v = false;
        private int js = 0;
        int pf = -1;

        public zw(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.z = view;
        }

        void z(int i, int i2, boolean z) {
            g(8);
            z(i2, z);
            this.dl = i;
        }

        void z(int i, boolean z) {
            if (this.f821a == -1) {
                this.f821a = this.dl;
            }
            if (this.e == -1) {
                this.e = this.dl;
            }
            if (z) {
                this.e += i;
            }
            this.dl += i;
            if (this.z.getLayoutParams() != null) {
                ((uy) this.z.getLayoutParams()).dl = true;
            }
        }

        void z() {
            this.f821a = -1;
            this.e = -1;
        }

        void g() {
            if (this.f821a == -1) {
                this.f821a = this.dl;
            }
        }

        boolean L_() {
            return (this.uy & 128) != 0;
        }

        public final int a() {
            int i = this.e;
            return i == -1 ? this.dl : i;
        }

        public final int gc() {
            RecyclerView recyclerView = this.ls;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.a(this);
        }

        public final int m() {
            return this.f821a;
        }

        public final long e() {
            return this.gc;
        }

        public final int gz() {
            return this.m;
        }

        boolean fo() {
            return this.i != null;
        }

        void uy() {
            this.i.dl(this);
        }

        boolean kb() {
            return (this.uy & 32) != 0;
        }

        void wp() {
            this.uy &= -33;
        }

        void i() {
            this.uy &= -257;
        }

        void z(ls lsVar, boolean z) {
            this.i = lsVar;
            this.v = z;
        }

        boolean v() {
            return (this.uy & 4) != 0;
        }

        boolean pf() {
            return (this.uy & 2) != 0;
        }

        boolean ls() {
            return (this.uy & 1) != 0;
        }

        boolean p() {
            return (this.uy & 8) != 0;
        }

        boolean z(int i) {
            return (i & this.uy) != 0;
        }

        boolean fv() {
            return (this.uy & 256) != 0;
        }

        boolean js() {
            return (this.uy & 512) != 0 || v();
        }

        void z(int i, int i2) {
            this.uy = (i & i2) | (this.uy & (~i2));
        }

        void g(int i) {
            this.uy = i | this.uy;
        }

        void z(Object obj) {
            if (obj == null) {
                g(1024);
            } else if ((1024 & this.uy) == 0) {
                hh();
                this.kb.add(obj);
            }
        }

        private void hh() {
            if (this.kb == null) {
                ArrayList arrayList = new ArrayList();
                this.kb = arrayList;
                this.wp = Collections.unmodifiableList(arrayList);
            }
        }

        void tb() {
            List<Object> list = this.kb;
            if (list != null) {
                list.clear();
            }
            this.uy &= -1025;
        }

        List<Object> q() {
            if ((this.uy & 1024) == 0) {
                List<Object> list = this.kb;
                return (list == null || list.size() == 0) ? p : this.wp;
            }
            return p;
        }

        void iq() {
            this.uy = 0;
            this.dl = -1;
            this.f821a = -1;
            this.gc = -1L;
            this.e = -1;
            this.fv = 0;
            this.gz = null;
            this.fo = null;
            tb();
            this.js = 0;
            this.pf = -1;
            RecyclerView.dl(this);
        }

        void z(RecyclerView recyclerView) {
            int i = this.pf;
            if (i != -1) {
                this.js = i;
            } else {
                this.js = com.bytedance.sdk.component.widget.recycler.z.dl.e.g(this.z);
            }
            recyclerView.z(this, 4);
        }

        void g(RecyclerView recyclerView) {
            recyclerView.z(this, this.js);
            this.js = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.dl + " id=" + this.gc + ", oldPos=" + this.f821a + ", pLpos:" + this.e);
            if (fo()) {
                sb.append(" scrap ").append(this.v ? "[changeScrap]" : "[attachedScrap]");
            }
            if (v()) {
                sb.append(" invalid");
            }
            if (!ls()) {
                sb.append(" unbound");
            }
            if (pf()) {
                sb.append(" update");
            }
            if (p()) {
                sb.append(" removed");
            }
            if (L_()) {
                sb.append(" ignored");
            }
            if (fv()) {
                sb.append(" tmpDetached");
            }
            if (!zw()) {
                sb.append(" not recyclable(" + this.fv + ")");
            }
            if (js()) {
                sb.append(" undefined adapter position");
            }
            if (this.z.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void z(boolean z) {
            int i = this.fv;
            int i2 = z ? i - 1 : i + 1;
            this.fv = i2;
            if (i2 < 0) {
                this.fv = 0;
                com.bytedance.sdk.component.utils.wp.a("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.uy |= 16;
            } else if (z && i2 == 0) {
                this.uy &= -17;
            }
        }

        public final boolean zw() {
            return (this.uy & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.z.dl.e.m(this.z);
        }

        boolean io() {
            return (this.uy & 16) != 0;
        }

        boolean uf() {
            return (this.uy & 16) == 0 && com.bytedance.sdk.component.widget.recycler.z.dl.e.m(this.z);
        }

        boolean sy() {
            return (this.uy & 2) != 0;
        }
    }

    public static abstract class gz {
        @Deprecated
        public void z(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void z(Rect rect, View view, RecyclerView recyclerView, tb tbVar) {
            z(rect, ((uy) view.getLayoutParams()).a(), recyclerView);
        }
    }

    public static abstract class fo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f811a;
        private boolean dl;
        private int e;
        RecyclerView fo;
        private int fv;
        private final i.g g;
        private int gc;
        com.bytedance.sdk.component.widget.recycler.g gz;
        boolean i;
        com.bytedance.sdk.component.widget.recycler.i kb;
        int ls;
        private int m;
        boolean p;
        boolean pf;
        com.bytedance.sdk.component.widget.recycler.i uy;
        boolean v;
        js wp;
        private final i.g z;

        public interface z {
            void g(int i, int i2);
        }

        public int a(tb tbVar) {
            return 0;
        }

        public View a(View view, int i) {
            return null;
        }

        public void a(int i) {
        }

        public boolean a() {
            return false;
        }

        public int dl(tb tbVar) {
            return 0;
        }

        public void dl(RecyclerView recyclerView) {
        }

        public boolean dl() {
            return false;
        }

        public int e(tb tbVar) {
            return 0;
        }

        boolean fo() {
            return false;
        }

        public int fv() {
            return -1;
        }

        public int g(int i, ls lsVar, tb tbVar) {
            return 0;
        }

        public abstract uy g();

        public void g(tb tbVar) {
        }

        public int gc(tb tbVar) {
            return 0;
        }

        public int gz(tb tbVar) {
            return 0;
        }

        public void kb(int i) {
        }

        public int m(tb tbVar) {
            return 0;
        }

        public boolean wp() {
            return false;
        }

        public int z(int i, ls lsVar, tb tbVar) {
            return 0;
        }

        public View z(View view, int i, ls lsVar, tb tbVar) {
            return null;
        }

        public void z(int i, int i2, tb tbVar, z zVar) {
        }

        public void z(int i, z zVar) {
        }

        public void z(RecyclerView recyclerView, ls lsVar) {
        }

        public boolean z(uy uyVar) {
            return uyVar != null;
        }

        public boolean z(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public fo() {
            i.g gVar = new i.g() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.fo.1
                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public View z(int i) {
                    return fo.this.gz(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int z() {
                    return fo.this.io();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int g() {
                    return fo.this.iq() - fo.this.sy();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int z(View view) {
                    return fo.this.e(view) - ((uy) view.getLayoutParams()).leftMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int g(View view) {
                    return fo.this.fo(view) + ((uy) view.getLayoutParams()).rightMargin;
                }
            };
            this.z = gVar;
            i.g gVar2 = new i.g() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.fo.2
                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public View z(int i) {
                    return fo.this.gz(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int z() {
                    return fo.this.uf();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int g() {
                    return fo.this.zw() - fo.this.hh();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int z(View view) {
                    return fo.this.gz(view) - ((uy) view.getLayoutParams()).topMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.i.g
                public int g(View view) {
                    return fo.this.uy(view) + ((uy) view.getLayoutParams()).bottomMargin;
                }
            };
            this.g = gVar2;
            this.uy = new com.bytedance.sdk.component.widget.recycler.i(gVar);
            this.kb = new com.bytedance.sdk.component.widget.recycler.i(gVar2);
            this.i = false;
            this.v = false;
            this.pf = false;
            this.dl = true;
            this.f811a = true;
        }

        void z(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.fo = null;
                this.gz = null;
                this.e = 0;
                this.fv = 0;
            } else {
                this.fo = recyclerView;
                this.gz = recyclerView.e;
                this.e = recyclerView.getWidth();
                this.fv = recyclerView.getHeight();
            }
            this.gc = 1073741824;
            this.m = 1073741824;
        }

        void g(int i, int i2) {
            this.e = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.gc = mode;
            if (mode == 0 && !RecyclerView.g) {
                this.e = 0;
            }
            this.fv = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.m = mode2;
            if (mode2 != 0 || RecyclerView.g) {
                return;
            }
            this.fv = 0;
        }

        void dl(int i, int i2) {
            int iJs = js();
            if (iJs == 0) {
                this.fo.gc(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iJs; i7++) {
                View viewGz = gz(i7);
                Rect rect = this.fo.kb;
                z(viewGz, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.fo.kb.set(i6, i4, i3, i5);
            z(this.fo.kb, i, i2);
        }

        public void z(Rect rect, int i, int i2) {
            gc(z(i, rect.width() + io() + sy(), gk()), z(i2, rect.height() + uf() + hh(), x()));
        }

        public void i() {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int z(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void z(String str) {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                recyclerView.z(str);
            }
        }

        public boolean z() {
            return this.pf;
        }

        public final boolean v() {
            return this.f811a;
        }

        void g(RecyclerView recyclerView) {
            this.v = true;
            dl(recyclerView);
        }

        void g(RecyclerView recyclerView, ls lsVar) {
            this.v = false;
            z(recyclerView, lsVar);
        }

        public boolean pf() {
            RecyclerView recyclerView = this.fo;
            return recyclerView != null && recyclerView.fo;
        }

        public void z(ls lsVar, tb tbVar) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public uy z(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof uy) {
                return new uy((uy) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new uy((ViewGroup.MarginLayoutParams) layoutParams) : new uy(layoutParams);
        }

        public uy z(Context context, AttributeSet attributeSet) {
            return new uy(context, attributeSet);
        }

        public void z(RecyclerView recyclerView, tb tbVar, int i) {
            com.bytedance.sdk.component.utils.wp.a("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void z(js jsVar) {
            js jsVar2 = this.wp;
            if (jsVar2 != null && jsVar != jsVar2 && jsVar2.e()) {
                this.wp.gc();
            }
            this.wp = jsVar;
            jsVar.z(this.fo, this);
        }

        public boolean ls() {
            js jsVar = this.wp;
            return jsVar != null && jsVar.e();
        }

        public int p() {
            return com.bytedance.sdk.component.widget.recycler.z.dl.e.z(this.fo);
        }

        public void z(View view) {
            z(view, -1);
        }

        public void z(View view, int i) {
            z(view, i, true);
        }

        public void g(View view) {
            g(view, -1);
        }

        public void g(View view, int i) {
            z(view, i, false);
        }

        private void z(View view, int i, boolean z2) {
            zw zwVarGc = RecyclerView.gc(view);
            if (!z2 && !zwVarGc.p()) {
                this.fo.gz.m(zwVarGc);
            } else {
                this.fo.gz.gc(zwVarGc);
            }
            uy uyVar = (uy) view.getLayoutParams();
            if (!zwVarGc.kb() && !zwVarGc.fo()) {
                if (view.getParent() == this.fo) {
                    int iG = this.gz.g(view);
                    if (i == -1) {
                        i = this.gz.g();
                    }
                    if (iG == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.fo.indexOfChild(view) + this.fo.z());
                    }
                    if (iG != i) {
                        this.fo.v.a(iG, i);
                    }
                } else {
                    this.gz.z(view, i, false);
                    uyVar.dl = true;
                    js jsVar = this.wp;
                    if (jsVar != null && jsVar.e()) {
                        this.wp.g(view);
                    }
                }
            } else {
                if (zwVarGc.fo()) {
                    zwVarGc.uy();
                } else {
                    zwVarGc.wp();
                }
                this.gz.z(view, i, view.getLayoutParams(), false);
            }
            if (uyVar.f820a) {
                zwVarGc.z.invalidate();
                uyVar.f820a = false;
            }
        }

        public void dl(View view) {
            this.gz.z(view);
        }

        public void m(int i) {
            if (gz(i) != null) {
                this.gz.z(i);
            }
        }

        public int a(View view) {
            return ((uy) view.getLayoutParams()).a();
        }

        public View g(int i) {
            int iJs = js();
            for (int i2 = 0; i2 < iJs; i2++) {
                View viewGz = gz(i2);
                zw zwVarGc = RecyclerView.gc(viewGz);
                if (zwVarGc != null && zwVarGc.a() == i && !zwVarGc.L_() && (this.fo.h.z() || !zwVarGc.p())) {
                    return viewGz;
                }
            }
            return null;
        }

        public void e(int i) {
            z(i, gz(i));
        }

        private void z(int i, View view) {
            this.gz.gc(i);
        }

        public void z(View view, int i, uy uyVar) {
            zw zwVarGc = RecyclerView.gc(view);
            if (zwVarGc.p()) {
                this.fo.gz.gc(zwVarGc);
            } else {
                this.fo.gz.m(zwVarGc);
            }
            this.gz.z(view, i, uyVar, zwVarGc.p());
        }

        public void dl(View view, int i) {
            z(view, i, (uy) view.getLayoutParams());
        }

        public void a(int i, int i2) {
            View viewGz = gz(i);
            if (viewGz == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.fo.toString());
            }
            e(i);
            dl(viewGz, i2);
        }

        public void z(View view, ls lsVar) {
            dl(view);
            lsVar.z(view);
        }

        public void z(int i, ls lsVar) {
            View viewGz = gz(i);
            m(i);
            lsVar.z(viewGz);
        }

        public int js() {
            com.bytedance.sdk.component.widget.recycler.g gVar = this.gz;
            if (gVar != null) {
                return gVar.g();
            }
            return 0;
        }

        public View gz(int i) {
            com.bytedance.sdk.component.widget.recycler.g gVar = this.gz;
            if (gVar != null) {
                return gVar.g(i);
            }
            return null;
        }

        public int tb() {
            return this.gc;
        }

        public int q() {
            return this.m;
        }

        public int iq() {
            return this.e;
        }

        public int zw() {
            return this.fv;
        }

        public int io() {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int uf() {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int sy() {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int hh() {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View l() {
            View focusedChild;
            RecyclerView recyclerView = this.fo;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.gz.dl(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int h() {
            RecyclerView recyclerView = this.fo;
            z adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.z();
            }
            return 0;
        }

        public void fo(int i) {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                recyclerView.m(i);
            }
        }

        public void uy(int i) {
            RecyclerView recyclerView = this.fo;
            if (recyclerView != null) {
                recyclerView.gc(i);
            }
        }

        public void z(ls lsVar) {
            for (int iJs = js() - 1; iJs >= 0; iJs--) {
                z(lsVar, iJs, gz(iJs));
            }
        }

        private void z(ls lsVar, int i, View view) {
            zw zwVarGc = RecyclerView.gc(view);
            if (zwVarGc.L_()) {
                return;
            }
            if (zwVarGc.v() && !zwVarGc.p() && !this.fo.i.g()) {
                m(i);
                lsVar.g(zwVarGc);
            } else {
                e(i);
                lsVar.dl(view);
                this.fo.gz.gz(zwVarGc);
            }
        }

        void g(ls lsVar) {
            int iGc = lsVar.gc();
            for (int i = iGc - 1; i >= 0; i--) {
                View viewA = lsVar.a(i);
                zw zwVarGc = RecyclerView.gc(viewA);
                if (!zwVarGc.L_()) {
                    zwVarGc.z(false);
                    if (zwVarGc.fv()) {
                        this.fo.removeDetachedView(viewA, false);
                    }
                    if (this.fo.uf != null) {
                        this.fo.uf.a(zwVarGc);
                    }
                    zwVarGc.z(true);
                    lsVar.g(viewA);
                }
            }
            lsVar.m();
            if (iGc > 0) {
                this.fo.invalidate();
            }
        }

        boolean z(View view, int i, int i2, uy uyVar) {
            return (!view.isLayoutRequested() && this.dl && g(view.getWidth(), i, uyVar.width) && g(view.getHeight(), i2, uyVar.height)) ? false : true;
        }

        private static boolean g(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void z(View view, int i, int i2) {
            uy uyVar = (uy) view.getLayoutParams();
            Rect rectFo = this.fo.fo(view);
            int i3 = i + rectFo.left + rectFo.right;
            int i4 = i2 + rectFo.top + rectFo.bottom;
            int iZ = z(iq(), tb(), io() + sy() + uyVar.leftMargin + uyVar.rightMargin + i3, uyVar.width, dl());
            int iZ2 = z(zw(), q(), uf() + hh() + uyVar.topMargin + uyVar.bottomMargin + i4, uyVar.height, a());
            if (z(view, iZ, iZ2, uyVar)) {
                view.measure(iZ, iZ2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int z(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L18
                if (r7 < 0) goto L11
                goto L1a
            L11:
                if (r7 != r1) goto L2c
                if (r5 == r2) goto L1e
                if (r5 == r3) goto L1e
                goto L2c
            L18:
                if (r7 < 0) goto L1c
            L1a:
                r5 = r3
                goto L2e
            L1c:
                if (r7 != r1) goto L20
            L1e:
                r7 = r4
                goto L2e
            L20:
                if (r7 != r0) goto L2c
                if (r5 == r2) goto L29
                if (r5 == r3) goto L29
                r7 = r4
                r5 = r6
                goto L2e
            L29:
                r7 = r4
                r5 = r2
                goto L2e
            L2c:
                r5 = r6
                r7 = r5
            L2e:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.fo.z(int, int, int, int, boolean):int");
        }

        public int gc(View view) {
            Rect rect = ((uy) view.getLayoutParams()).g;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int m(View view) {
            Rect rect = ((uy) view.getLayoutParams()).g;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void z(View view, int i, int i2, int i3, int i4) {
            uy uyVar = (uy) view.getLayoutParams();
            Rect rect = uyVar.g;
            view.layout(i + rect.left + uyVar.leftMargin, i2 + rect.top + uyVar.topMargin, (i3 - rect.right) - uyVar.rightMargin, (i4 - rect.bottom) - uyVar.bottomMargin);
        }

        public void z(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((uy) view.getLayoutParams()).g;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.fo != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.fo.wp;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void z(View view, Rect rect) {
            RecyclerView.z(view, rect);
        }

        public int e(View view) {
            return view.getLeft() - i(view);
        }

        public int gz(View view) {
            return view.getTop() - kb(view);
        }

        public int fo(View view) {
            return view.getRight() + v(view);
        }

        public int uy(View view) {
            return view.getBottom() + wp(view);
        }

        public int kb(View view) {
            return ((uy) view.getLayoutParams()).g.top;
        }

        public int wp(View view) {
            return ((uy) view.getLayoutParams()).g.bottom;
        }

        public int i(View view) {
            return ((uy) view.getLayoutParams()).g.left;
        }

        public int v(View view) {
            return ((uy) view.getLayoutParams()).g.right;
        }

        private int[] g(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            int[] iArr = new int[2];
            int iIo = io();
            int iUf = uf();
            int iIq = iq() - sy();
            int iZw = zw() - hh();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top2 = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top2;
            int i = left - iIo;
            int iMin = Math.min(0, i);
            int i2 = top2 - iUf;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iIq;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iZw);
            if (p() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean z(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return z(recyclerView, view, rect, z2, false);
        }

        public boolean z(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] iArrG = g(recyclerView, view, rect, z2);
            int i = iArrG[0];
            int i2 = iArrG[1];
            if ((z3 && !z(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.z(i, i2);
            }
            return true;
        }

        private boolean z(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iIo = io();
            int iUf = uf();
            int iIq = iq() - sy();
            int iZw = zw() - hh();
            Rect rect = this.fo.kb;
            z(focusedChild, rect);
            return rect.left - i < iIq && rect.right - i > iIo && rect.top - i2 < iZw && rect.bottom - i2 > iUf;
        }

        @Deprecated
        public boolean z(RecyclerView recyclerView, View view, View view2) {
            return ls() || recyclerView.v();
        }

        public boolean z(RecyclerView recyclerView, tb tbVar, View view, View view2) {
            return z(recyclerView, view, view2);
        }

        public void z(ls lsVar, tb tbVar, int i, int i2) {
            this.fo.gc(i, i2);
        }

        public void gc(int i, int i2) {
            this.fo.setMeasuredDimension(i, i2);
        }

        public int gk() {
            return com.bytedance.sdk.component.widget.recycler.z.dl.e.a(this.fo);
        }

        public int x() {
            return com.bytedance.sdk.component.widget.recycler.z.dl.e.gc(this.fo);
        }

        void lq() {
            js jsVar = this.wp;
            if (jsVar != null) {
                jsVar.gc();
            }
        }

        void g(js jsVar) {
            if (this.wp == jsVar) {
                this.wp = null;
            }
        }

        public void dl(ls lsVar) {
            for (int iJs = js() - 1; iJs >= 0; iJs--) {
                if (!RecyclerView.gc(gz(iJs)).L_()) {
                    z(iJs, lsVar);
                }
            }
        }

        void a(RecyclerView recyclerView) {
            g(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean mc() {
            int iJs = js();
            for (int i = 0; i < iJs; i++) {
                ViewGroup.LayoutParams layoutParams = gz(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class z<VH extends zw> {
        private final g z = new g();
        private boolean g = false;

        public long g(int i) {
            return -1L;
        }

        public boolean g(VH vh) {
            return false;
        }

        public abstract int z();

        public int z(int i) {
            return 0;
        }

        public abstract VH z(ViewGroup viewGroup, int i);

        public void z(VH vh) {
        }

        public abstract void z(VH vh, int i);

        public void z(VH vh, int i, List<Object> list) {
            z(vh, i);
        }

        public final VH g(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV CreateView");
                VH vh = (VH) z(viewGroup, i);
                if (vh.z.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.m = i;
                return vh;
            } finally {
                com.bytedance.sdk.component.widget.recycler.z.z.z.z();
            }
        }

        public final void g(VH vh, int i) {
            vh.dl = i;
            if (g()) {
                vh.gc = g(i);
            }
            vh.z(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV OnBindView");
            z(vh, i, vh.q());
            vh.tb();
            ViewGroup.LayoutParams layoutParams = vh.z.getLayoutParams();
            if (layoutParams instanceof uy) {
                ((uy) layoutParams).dl = true;
            }
            com.bytedance.sdk.component.widget.recycler.z.z.z.z();
        }

        public final boolean g() {
            return this.g;
        }

        public void z(dl dlVar) {
            this.z.registerObserver(dlVar);
        }

        public void g(dl dlVar) {
            this.z.unregisterObserver(dlVar);
        }

        public final void dl() {
            this.z.z();
        }

        public final void z(int i, Object obj) {
            this.z.z(i, 1, obj);
        }

        public final void z(int i, int i2) {
            this.z.z(i, i2);
        }
    }

    public final class ls {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f815a;
        final ArrayList<zw> dl;
        private final List<zw> e;
        private q fo;
        ArrayList<zw> g;
        pf gc;
        private int gz;
        final ArrayList<zw> z;

        public ls() {
            ArrayList<zw> arrayList = new ArrayList<>();
            this.z = arrayList;
            this.g = null;
            this.dl = new ArrayList<>();
            this.e = Collections.unmodifiableList(arrayList);
            this.gz = 2;
            this.f815a = 2;
        }

        public void z() {
            this.z.clear();
            a();
        }

        public void z(int i) {
            this.gz = i;
            g();
        }

        void g() {
            this.f815a = this.gz + (RecyclerView.this.v != null ? RecyclerView.this.v.ls : 0);
            for (int size = this.dl.size() - 1; size >= 0 && this.dl.size() > this.f815a; size--) {
                dl(size);
            }
        }

        public List<zw> dl() {
            return this.e;
        }

        boolean z(zw zwVar) {
            if (zwVar.p()) {
                return RecyclerView.this.h.z();
            }
            if (zwVar.dl >= 0 && zwVar.dl < RecyclerView.this.i.z()) {
                if (RecyclerView.this.h.z() || RecyclerView.this.i.z(zwVar.dl) == zwVar.gz()) {
                    return !RecyclerView.this.i.g() || zwVar.e() == RecyclerView.this.i.g(zwVar.dl);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + zwVar + RecyclerView.this.z());
        }

        private boolean z(zw zwVar, int i, int i2, long j) {
            zwVar.ls = RecyclerView.this;
            int iGz = zwVar.gz();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.gc.g(iGz, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.i.g(zwVar, i);
            this.gc.g(zwVar.gz(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.h.z()) {
                return true;
            }
            zwVar.e = i2;
            return true;
        }

        public View g(int i) {
            return z(i, false);
        }

        View z(int i, boolean z) {
            return z(i, z, Long.MAX_VALUE).z;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x022b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0182 A[PHI: r1 r4
  0x0182: PHI (r1v18 com.bytedance.sdk.component.widget.recycler.RecyclerView$zw) = 
  (r1v17 com.bytedance.sdk.component.widget.recycler.RecyclerView$zw)
  (r1v43 com.bytedance.sdk.component.widget.recycler.RecyclerView$zw)
 binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]
  0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0201  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.bytedance.sdk.component.widget.recycler.RecyclerView.zw z(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 621
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.ls.z(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$zw");
        }

        private void gc(zw zwVar) {
            if (zwVar.z instanceof ViewGroup) {
                z((ViewGroup) zwVar.z, false);
            }
        }

        private void z(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    z((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void z(View view) {
            zw zwVarGc = RecyclerView.gc(view);
            if (zwVarGc.fv()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (zwVarGc.fo()) {
                zwVarGc.uy();
            } else if (zwVarGc.kb()) {
                zwVarGc.wp();
            }
            g(zwVarGc);
        }

        void a() {
            for (int size = this.dl.size() - 1; size >= 0; size--) {
                dl(size);
            }
            this.dl.clear();
            if (RecyclerView.f810a) {
                RecyclerView.this.l.z();
            }
        }

        void dl(int i) {
            z(this.dl.get(i), true);
            this.dl.remove(i);
        }

        void g(zw zwVar) {
            boolean z;
            boolean z2 = true;
            if (!zwVar.fo() && zwVar.z.getParent() == null) {
                if (zwVar.fv()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + zwVar + RecyclerView.this.z());
                }
                if (zwVar.L_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.z());
                }
                boolean zUf = zwVar.uf();
                if ((RecyclerView.this.i != null && zUf && RecyclerView.this.i.g(zwVar)) || zwVar.zw()) {
                    if (this.f815a <= 0 || zwVar.z(526)) {
                        z = false;
                    } else {
                        int size = this.dl.size();
                        if (size >= this.f815a && size > 0) {
                            dl(0);
                            size--;
                        }
                        if (RecyclerView.f810a && size > 0 && !RecyclerView.this.l.z(zwVar.dl)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.l.z(this.dl.get(i).dl)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.dl.add(size, zwVar);
                        z = true;
                    }
                    if (z) {
                        z2 = false;
                    } else {
                        z(zwVar, true);
                    }
                    z = z;
                } else {
                    z2 = false;
                }
                RecyclerView.this.gz.e(zwVar);
                if (z || z2 || !zUf) {
                    return;
                }
                zwVar.ls = null;
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + zwVar.fo() + " isAttached:" + (zwVar.z.getParent() != null) + RecyclerView.this.z());
        }

        void z(zw zwVar, boolean z) {
            RecyclerView.dl(zwVar);
            if (zwVar.z(16384)) {
                zwVar.z(0, 16384);
            }
            if (z) {
                a(zwVar);
            }
            zwVar.ls = null;
            e().z(zwVar);
        }

        void g(View view) {
            zw zwVarGc = RecyclerView.gc(view);
            zwVarGc.i = null;
            zwVarGc.v = false;
            zwVarGc.wp();
            g(zwVarGc);
        }

        void dl(View view) {
            zw zwVarGc = RecyclerView.gc(view);
            if (!zwVarGc.z(12) && zwVarGc.sy() && !RecyclerView.this.g(zwVarGc)) {
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                zwVarGc.z(this, true);
                this.g.add(zwVarGc);
                return;
            }
            if (zwVarGc.v() && !zwVarGc.p() && !RecyclerView.this.i.g()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.z());
            }
            zwVarGc.z(this, false);
            this.z.add(zwVarGc);
        }

        void dl(zw zwVar) {
            if (zwVar.v) {
                this.g.remove(zwVar);
            } else {
                this.z.remove(zwVar);
            }
            zwVar.i = null;
            zwVar.v = false;
            zwVar.wp();
        }

        int gc() {
            return this.z.size();
        }

        View a(int i) {
            return this.z.get(i).z;
        }

        void m() {
            this.z.clear();
            ArrayList<zw> arrayList = this.g;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        zw gc(int i) {
            int size;
            int iG;
            ArrayList<zw> arrayList = this.g;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    zw zwVar = this.g.get(i2);
                    if (!zwVar.kb() && zwVar.a() == i) {
                        zwVar.g(32);
                        return zwVar;
                    }
                }
                if (RecyclerView.this.i.g() && (iG = RecyclerView.this.m.g(i)) > 0 && iG < RecyclerView.this.i.z()) {
                    long jG = RecyclerView.this.i.g(iG);
                    for (int i3 = 0; i3 < size; i3++) {
                        zw zwVar2 = this.g.get(i3);
                        if (!zwVar2.kb() && zwVar2.e() == jG) {
                            zwVar2.g(32);
                            return zwVar2;
                        }
                    }
                }
            }
            return null;
        }

        zw g(int i, boolean z) {
            View viewDl;
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                zw zwVar = this.z.get(i2);
                if (!zwVar.kb() && zwVar.a() == i && !zwVar.v() && (RecyclerView.this.h.e || !zwVar.p())) {
                    zwVar.g(32);
                    return zwVar;
                }
            }
            if (!z && (viewDl = RecyclerView.this.e.dl(i)) != null) {
                zw zwVarGc = RecyclerView.gc(viewDl);
                RecyclerView.this.e.gc(viewDl);
                int iG = RecyclerView.this.e.g(viewDl);
                if (iG == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + zwVarGc + RecyclerView.this.z());
                }
                RecyclerView.this.e.gc(iG);
                dl(viewDl);
                zwVarGc.g(8224);
                return zwVarGc;
            }
            int size2 = this.dl.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zw zwVar2 = this.dl.get(i3);
                if (!zwVar2.v() && zwVar2.a() == i) {
                    if (!z) {
                        this.dl.remove(i3);
                    }
                    return zwVar2;
                }
            }
            return null;
        }

        zw z(long j, int i, boolean z) {
            for (int size = this.z.size() - 1; size >= 0; size--) {
                zw zwVar = this.z.get(size);
                if (zwVar.e() == j && !zwVar.kb()) {
                    if (i == zwVar.gz()) {
                        zwVar.g(32);
                        if (zwVar.p() && !RecyclerView.this.h.z()) {
                            zwVar.z(2, 14);
                        }
                        return zwVar;
                    }
                    if (!z) {
                        this.z.remove(size);
                        RecyclerView.this.removeDetachedView(zwVar.z, false);
                        g(zwVar.z);
                    }
                }
            }
            int size2 = this.dl.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                zw zwVar2 = this.dl.get(size2);
                if (zwVar2.e() == j) {
                    if (i == zwVar2.gz()) {
                        if (!z) {
                            this.dl.remove(size2);
                        }
                        return zwVar2;
                    }
                    if (!z) {
                        dl(size2);
                        return null;
                    }
                }
            }
        }

        void a(zw zwVar) {
            if (RecyclerView.this.i != null) {
                RecyclerView.this.i.z(zwVar);
            }
            if (RecyclerView.this.h != null) {
                RecyclerView.this.gz.e(zwVar);
            }
        }

        void z(z zVar, z zVar2, boolean z) {
            z();
            e().z(zVar, zVar2, z);
        }

        void z(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.dl.size();
            for (int i6 = 0; i6 < size; i6++) {
                zw zwVar = this.dl.get(i6);
                if (zwVar != null && zwVar.dl >= i5 && zwVar.dl <= i4) {
                    if (zwVar.dl == i) {
                        zwVar.z(i2 - i, false);
                    } else {
                        zwVar.z(i3, false);
                    }
                }
            }
        }

        void g(int i, int i2) {
            int size = this.dl.size();
            for (int i3 = 0; i3 < size; i3++) {
                zw zwVar = this.dl.get(i3);
                if (zwVar != null && zwVar.dl >= i) {
                    zwVar.z(i2, true);
                }
            }
        }

        void z(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.dl.size() - 1; size >= 0; size--) {
                zw zwVar = this.dl.get(size);
                if (zwVar != null) {
                    if (zwVar.dl >= i3) {
                        zwVar.z(-i2, z);
                    } else if (zwVar.dl >= i) {
                        zwVar.g(8);
                        dl(size);
                    }
                }
            }
        }

        void z(q qVar) {
            this.fo = qVar;
        }

        void z(pf pfVar) {
            pf pfVar2 = this.gc;
            if (pfVar2 != null) {
                pfVar2.dl();
            }
            this.gc = pfVar;
            if (pfVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.gc.g();
        }

        pf e() {
            if (this.gc == null) {
                this.gc = new pf();
            }
            return this.gc;
        }

        void dl(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.dl.size() - 1; size >= 0; size--) {
                zw zwVar = this.dl.get(size);
                if (zwVar != null && (i3 = zwVar.dl) >= i && i3 < i4) {
                    zwVar.g(2);
                    dl(size);
                }
            }
        }

        void gz() {
            int size = this.dl.size();
            for (int i = 0; i < size; i++) {
                zw zwVar = this.dl.get(i);
                if (zwVar != null) {
                    zwVar.g(6);
                    zwVar.z((Object) null);
                }
            }
            if (RecyclerView.this.i == null || !RecyclerView.this.i.g()) {
                a();
            }
        }

        void fo() {
            int size = this.dl.size();
            for (int i = 0; i < size; i++) {
                this.dl.get(i).z();
            }
            int size2 = this.z.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.z.get(i2).z();
            }
            ArrayList<zw> arrayList = this.g;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.g.get(i3).z();
                }
            }
        }

        void uy() {
            int size = this.dl.size();
            for (int i = 0; i < size; i++) {
                uy uyVar = (uy) this.dl.get(i).z.getLayoutParams();
                if (uyVar != null) {
                    uyVar.dl = true;
                }
            }
        }
    }

    public static class pf {
        SparseArray<z> z = new SparseArray<>();
        private int g = 0;

        public void z() {
            for (int i = 0; i < this.z.size(); i++) {
                this.z.valueAt(i).z.clear();
            }
        }

        public zw z(int i) {
            z zVar = this.z.get(i);
            if (zVar == null || zVar.z.isEmpty()) {
                return null;
            }
            return zVar.z.remove(r2.size() - 1);
        }

        public void z(zw zwVar) {
            int iGz = zwVar.gz();
            ArrayList<zw> arrayList = g(iGz).z;
            if (this.z.get(iGz).g > arrayList.size()) {
                zwVar.iq();
                arrayList.add(zwVar);
            }
        }

        long z(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void z(int i, long j) {
            z zVarG = g(i);
            zVarG.dl = z(zVarG.dl, j);
        }

        void g(int i, long j) {
            z zVarG = g(i);
            zVarG.f818a = z(zVarG.f818a, j);
        }

        boolean z(int i, long j, long j2) {
            long j3 = g(i).dl;
            return j3 == 0 || j + j3 < j2;
        }

        boolean g(int i, long j, long j2) {
            long j3 = g(i).f818a;
            return j3 == 0 || j + j3 < j2;
        }

        void g() {
            this.g++;
        }

        void dl() {
            this.g--;
        }

        void z(z zVar, z zVar2, boolean z2) {
            if (zVar != null) {
                dl();
            }
            if (!z2 && this.g == 0) {
                z();
            }
            if (zVar2 != null) {
                g();
            }
        }

        private z g(int i) {
            z zVar = this.z.get(i);
            if (zVar != null) {
                return zVar;
            }
            z zVar2 = new z();
            this.z.put(i, zVar2);
            return zVar2;
        }

        static class z {
            final ArrayList<zw> z = new ArrayList<>();
            int g = 5;
            long dl = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f818a = 0;

            z() {
            }
        }
    }

    public static class gc {
        protected EdgeEffect z(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    private class fv extends dl {
        fv() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.dl
        public void z() {
            RecyclerView.this.z((String) null);
            RecyclerView.this.h.m = true;
            RecyclerView.this.dl(true);
            if (RecyclerView.this.m.a()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.dl
        public void z(int i, int i2, Object obj) {
            RecyclerView.this.z((String) null);
            if (RecyclerView.this.m.z(i, i2, obj)) {
                g();
            }
        }

        void g() {
            if (RecyclerView.dl && RecyclerView.this.fv && RecyclerView.this.p) {
                RecyclerView recyclerView = RecyclerView.this;
                com.bytedance.sdk.component.widget.recycler.z.dl.e.z(recyclerView, recyclerView.uy);
            } else {
                RecyclerView.this.iq = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    class iq implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f812a;
        private int gc;
        OverScroller z;
        Interpolator g = RecyclerView.eo;
        private boolean m = false;
        private boolean e = false;

        iq() {
            this.z = new OverScroller(RecyclerView.this.getContext(), RecyclerView.eo);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.iq.run():void");
        }

        private void dl() {
            this.e = false;
            this.m = true;
        }

        private void a() {
            this.m = false;
            if (this.e) {
                z();
            }
        }

        void z() {
            if (this.m) {
                this.e = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.z.dl.e.z(RecyclerView.this, this);
            }
        }

        public void z(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.gc = 0;
            this.f812a = 0;
            this.z.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            z();
        }

        public void g(int i, int i2) {
            z(i, i2, 0, 0);
        }

        public void z(int i, int i2, int i3, int i4) {
            z(i, i2, g(i, i2, i3, i4));
        }

        private float z(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int g(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fZ = f2 + (z(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fZ / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void z(int i, int i2, int i3) {
            z(i, i2, i3, RecyclerView.eo);
        }

        public void z(int i, int i2, Interpolator interpolator) {
            int iG = g(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.eo;
            }
            z(i, i2, iG, interpolator);
        }

        public void z(int i, int i2, int i3, Interpolator interpolator) {
            if (this.g != interpolator) {
                this.g = interpolator;
                this.z = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.gc = 0;
            this.f812a = 0;
            this.z.startScroll(0, 0, i, i2, i3);
            z();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.z.abortAnimation();
        }
    }
}
