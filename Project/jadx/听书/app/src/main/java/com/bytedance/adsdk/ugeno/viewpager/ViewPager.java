package com.bytedance.adsdk.ugeno.viewpager;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.bytedance.sdk.component.utils.wp;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPager extends ViewGroup {
    static final int[] g = {R.attr.layout_gravity};
    private static final Comparator<g> gc = new Comparator<g>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            return gVar.g - gVar2.g;
        }
    };
    private static final Interpolator m = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final gz tc = new gz();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f248a;
    private int b;
    private boolean bv;
    com.bytedance.adsdk.ugeno.viewpager.g dl;
    private final ArrayList<g> e;
    private boolean ec;
    private float eo;
    private a f;
    private final Rect fo;
    private int fv;
    private boolean gb;
    private int gk;
    private int gp;
    private final g gz;
    private boolean h;
    private int hh;
    private Scroller i;
    private boolean io;
    private int iq;
    private int j;
    private int jq;
    private int js;
    private Parcelable kb;
    private boolean l;
    private int lq;
    private int ls;
    private int lw;
    private float mc;
    private final Runnable me;
    private int na;
    private int nh;
    private int oq;
    private Drawable p;
    private m pf;
    private float q;
    private List<Object> qd;
    private ArrayList<View> rv;
    private List<a> sv;
    private boolean sy;
    private boolean t;
    private float tb;
    private float ti;
    private boolean uf;
    private float un;
    private int uy;
    private boolean v;
    private EdgeEffect vm;
    private VelocityTracker wj;
    private ClassLoader wp;
    private int x;
    private int xl;
    private EdgeEffect y;
    private a yx;
    private int z;
    private int zw;
    private gc zx;

    public interface a {
        void fo(int i);

        void gz(int i);

        void z(int i, float f, int i2);
    }

    public interface gc {
        void z(View view, float f);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface z {
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f251a;
        boolean dl;
        int g;
        float gc;
        Object z;

        g() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.e = new ArrayList<>();
        this.gz = new g();
        this.fo = new Rect();
        this.uy = -1;
        this.kb = null;
        this.wp = null;
        this.tb = -3.4028235E38f;
        this.q = Float.MAX_VALUE;
        this.hh = 1;
        this.oq = -1;
        this.ec = true;
        this.bv = false;
        this.me = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.dl();
            }
        };
        this.nh = 0;
        z();
    }

    void z() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.i = new Scroller(context, m);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.lq = viewConfiguration.getScaledPagingTouchSlop();
        this.na = (int) (400.0f * f);
        this.xl = viewConfiguration.getScaledMaximumFlingVelocity();
        this.vm = new EdgeEffect(context);
        this.y = new EdgeEffect(context);
        this.j = (int) (25.0f * f);
        this.gp = (int) (2.0f * f);
        this.gk = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.i = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.me);
        Scroller scroller = this.i;
        if (scroller != null && !scroller.isFinished()) {
            this.i.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.nh == i) {
            return;
        }
        this.nh = i;
        if (this.zx != null) {
            g(i != 0);
        }
        m(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.g gVar) {
        com.bytedance.adsdk.ugeno.viewpager.g gVar2 = this.dl;
        if (gVar2 != null) {
            gVar2.z((DataSetObserver) null);
            for (int i = 0; i < this.e.size(); i++) {
                g gVar3 = this.e.get(i);
                this.dl.z((ViewGroup) this, gVar3.g, gVar3.z);
            }
            this.e.clear();
            m();
            this.f248a = 0;
            scrollTo(0, 0);
        }
        this.dl = gVar;
        this.z = 0;
        if (gVar != null) {
            if (this.pf == null) {
                this.pf = new m();
            }
            this.dl.z((DataSetObserver) this.pf);
            this.sy = false;
            boolean z2 = this.ec;
            this.ec = true;
            this.z = this.dl.z();
            int i2 = this.uy;
            if (i2 >= 0) {
                z(i2, false, true);
                this.uy = -1;
                this.kb = null;
                this.wp = null;
            } else if (!z2) {
                dl();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.qd;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.qd.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.qd.get(i3);
        }
    }

    private void m() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((dl) getChildAt(i).getLayoutParams()).z) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.viewpager.g getAdapter() {
        return this.dl;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.sy = false;
        z(i, !this.ec, false);
    }

    public void z(int i, boolean z2) {
        this.sy = false;
        z(i, z2, false);
    }

    public int getCurrentItem() {
        return this.f248a;
    }

    void z(int i, boolean z2, boolean z3) {
        z(i, z2, z3, 0);
    }

    void z(int i, boolean z2, boolean z3, int i2) {
        com.bytedance.adsdk.ugeno.viewpager.g gVar = this.dl;
        if (gVar == null || gVar.z() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z3 && this.f248a == i && this.e.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.dl.z()) {
            i = this.dl.z() - 1;
        }
        int i3 = this.hh;
        int i4 = this.f248a;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.e.size(); i5++) {
                this.e.get(i5).dl = true;
            }
        }
        boolean z4 = this.f248a != i;
        if (this.ec) {
            this.f248a = i;
            if (z4) {
                gc(i);
            }
            requestLayout();
            return;
        }
        z(i);
        z(i, z2, i2, z4);
    }

    private void z(int i, boolean z2, int i2, boolean z3) {
        g gVarG = g(i);
        int clientWidth = gVarG != null ? (int) (getClientWidth() * Math.max(this.tb, Math.min(gVarG.gc, this.q))) : 0;
        if (z2) {
            z(clientWidth, 0, i2);
            if (z3) {
                gc(i);
                return;
            }
            return;
        }
        if (z3) {
            gc(i);
        }
        z(false);
        scrollTo(clientWidth, 0);
        a(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(a aVar) {
        this.f = aVar;
    }

    public void z(a aVar) {
        if (this.sv == null) {
            this.sv = new ArrayList();
        }
        this.sv.add(aVar);
    }

    public void z(boolean z2, gc gcVar) {
        z(z2, gcVar, 2);
    }

    public void z(boolean z2, gc gcVar, int i) {
        boolean z3 = gcVar != null;
        boolean z4 = z3 != (this.zx != null);
        this.zx = gcVar;
        setChildrenDrawingOrderEnabled(z3);
        if (z3) {
            this.lw = z2 ? 2 : 1;
            this.b = i;
        } else {
            this.lw = 0;
        }
        if (z4) {
            dl();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.lw == 2) {
            i2 = (i - 1) - i2;
        }
        return ((dl) this.rv.get(i2).getLayoutParams()).m;
    }

    public int getOffscreenPageLimit() {
        return this.hh;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            wp.g("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.hh) {
            this.hh = i;
            dl();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.ls;
        this.ls = i;
        int width = getWidth();
        z(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.ls;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float z(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void z(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.i;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.v ? this.i.getCurrX() : this.i.getStartX();
            this.i.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            z(false);
            dl();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fZ = f2 + (z(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fZ / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.dl.z(this.f248a)) + this.ls)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.v = false;
        this.i.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    g z(int i, int i2) {
        g gVar = new g();
        gVar.g = i;
        gVar.z = this.dl.z((ViewGroup) this, i);
        gVar.f251a = this.dl.z(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(gVar);
        } else {
            this.e.add(i2, gVar);
        }
        return gVar;
    }

    void g() {
        int iZ = this.dl.z();
        this.z = iZ;
        boolean z2 = this.e.size() < (this.hh * 2) + 1 && this.e.size() < iZ;
        int iMax = this.f248a;
        int i = 0;
        while (i < this.e.size()) {
            g gVar = this.e.get(i);
            int iZ2 = this.dl.z(gVar.z);
            if (iZ2 != -1) {
                if (iZ2 == -2) {
                    this.e.remove(i);
                    i--;
                    this.dl.z((ViewGroup) this, gVar.g, gVar.z);
                    if (this.f248a == gVar.g) {
                        iMax = Math.max(0, Math.min(this.f248a, iZ - 1));
                    }
                } else if (gVar.g != iZ2) {
                    if (gVar.g == this.f248a) {
                        iMax = iZ2;
                    }
                    gVar.g = iZ2;
                }
                z2 = true;
            }
            i++;
        }
        Collections.sort(this.e, gc);
        if (z2) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                dl dlVar = (dl) getChildAt(i2).getLayoutParams();
                if (!dlVar.z) {
                    dlVar.dl = 0.0f;
                }
            }
            z(iMax, false, true);
            requestLayout();
        }
    }

    void dl() {
        z(this.f248a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f5 A[PHI: r7 r10 r15
  0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void z(int r18) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.z(int):void");
    }

    private void e() {
        if (this.lw != 0) {
            ArrayList<View> arrayList = this.rv;
            if (arrayList == null) {
                this.rv = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.rv.add(getChildAt(i));
            }
            Collections.sort(this.rv, tc);
        }
    }

    private void z(g gVar, int i, g gVar2) {
        g gVar3;
        g gVar4;
        int iZ = this.dl.z();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.ls / clientWidth : 0.0f;
        if (gVar2 != null) {
            int i2 = gVar2.g;
            if (i2 < gVar.g) {
                float fZ = gVar2.gc + gVar2.f251a + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= gVar.g && i4 < this.e.size()) {
                    g gVar5 = this.e.get(i4);
                    while (true) {
                        gVar4 = gVar5;
                        if (i3 <= gVar4.g || i4 >= this.e.size() - 1) {
                            break;
                        }
                        i4++;
                        gVar5 = this.e.get(i4);
                    }
                    while (i3 < gVar4.g) {
                        fZ += this.dl.z(i3) + f;
                        i3++;
                    }
                    gVar4.gc = fZ;
                    fZ += gVar4.f251a + f;
                    i3++;
                }
            } else if (i2 > gVar.g) {
                int size = this.e.size() - 1;
                float fZ2 = gVar2.gc;
                while (true) {
                    i2--;
                    if (i2 < gVar.g || size < 0) {
                        break;
                    }
                    g gVar6 = this.e.get(size);
                    while (true) {
                        gVar3 = gVar6;
                        if (i2 >= gVar3.g || size <= 0) {
                            break;
                        }
                        size--;
                        gVar6 = this.e.get(size);
                    }
                    while (i2 > gVar3.g) {
                        fZ2 -= this.dl.z(i2) + f;
                        i2--;
                    }
                    fZ2 -= gVar3.f251a + f;
                    gVar3.gc = fZ2;
                }
            }
        }
        int size2 = this.e.size();
        float fZ3 = gVar.gc;
        int i5 = gVar.g - 1;
        this.tb = gVar.g == 0 ? gVar.gc : -3.4028235E38f;
        int i6 = iZ - 1;
        this.q = gVar.g == i6 ? (gVar.gc + gVar.f251a) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            g gVar7 = this.e.get(i7);
            while (i5 > gVar7.g) {
                fZ3 -= this.dl.z(i5) + f;
                i5--;
            }
            fZ3 -= gVar7.f251a + f;
            gVar7.gc = fZ3;
            if (gVar7.g == 0) {
                this.tb = fZ3;
            }
            i7--;
            i5--;
        }
        float fZ4 = gVar.gc + gVar.f251a + f;
        int i8 = gVar.g + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            g gVar8 = this.e.get(i9);
            while (i8 < gVar8.g) {
                fZ4 += this.dl.z(i8) + f;
                i8++;
            }
            if (gVar8.g == i6) {
                this.q = (gVar8.f251a + fZ4) - 1.0f;
            }
            gVar8.gc = fZ4;
            fZ4 += gVar8.f251a + f;
            i9++;
            i8++;
        }
        this.bv = false;
    }

    public static class e extends com.bytedance.adsdk.ugeno.viewpager.z {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.e.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ClassLoader f250a;
        Parcelable dl;
        int g;

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.z, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
            parcel.writeParcelable(this.dl, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.g + "}";
        }

        e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.g = parcel.readInt();
            this.dl = parcel.readParcelable(classLoader);
            this.f250a = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.g = this.f248a;
        com.bytedance.adsdk.ugeno.viewpager.g gVar = this.dl;
        if (gVar != null) {
            eVar.dl = gVar.g();
        }
        return eVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.z());
        if (this.dl != null) {
            z(eVar.g, false, true);
            return;
        }
        this.uy = eVar.g;
        this.kb = eVar.dl;
        this.wp = eVar.f250a;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        dl dlVar = (dl) layoutParams;
        dlVar.z |= dl(view);
        if (this.io) {
            if (dlVar != null && dlVar.z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            dlVar.f249a = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean dl(View view) {
        return view.getClass().getAnnotation(z.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.io) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    g z(View view) {
        for (int i = 0; i < this.e.size(); i++) {
            g gVar = this.e.get(i);
            if (this.dl.z(view, gVar.z)) {
                return gVar;
            }
        }
        return null;
    }

    g g(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return z(view);
            }
        }
    }

    g g(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            g gVar = this.e.get(i2);
            if (gVar.g == i) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ec = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar;
        dl dlVar2;
        int i3;
        int i4;
        int i5;
        boolean z2 = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.x = Math.min(measuredWidth / 10, this.gk);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z3 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (dlVar2 = (dl) childAt.getLayoutParams()) != null && dlVar2.z) {
                int i8 = dlVar2.g & 7;
                int i9 = dlVar2.g & 112;
                boolean z4 = (i9 == 48 || i9 == 80) ? true : z2;
                if (i8 != 3 && i8 != 5) {
                    z3 = z2;
                }
                int i10 = Integer.MIN_VALUE;
                if (z4) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z3 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (dlVar2.width != -2) {
                    i4 = dlVar2.width != -1 ? dlVar2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (dlVar2.height != -2) {
                    i5 = dlVar2.height != -1 ? dlVar2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z4) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z3) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z2 = false;
        }
        this.iq = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.zw = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.io = true;
        dl();
        this.io = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((dlVar = (dl) childAt2.getLayoutParams()) == null || !dlVar.z)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * dlVar.dl), 1073741824), this.zw);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.ls;
            z(i, i3, i5, i5);
        }
    }

    private void z(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.e.isEmpty()) {
            if (!this.i.isFinished()) {
                this.i.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        g gVarG = g(this.f248a);
        int iMin = (int) ((gVarG != null ? Math.min(gVarG.gc, this.q) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            z(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        this.v = true;
        if (!this.i.isFinished() && this.i.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.i.getCurrX();
            int currY = this.i.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!a(currX)) {
                    this.i.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        z(true);
    }

    private boolean a(int i) {
        if (this.e.size() == 0) {
            if (this.ec) {
                return false;
            }
            this.gb = false;
            z(0, 0.0f, 0);
            if (this.gb) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        g gVarFo = fo();
        int clientWidth = getClientWidth();
        int i2 = this.ls;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = gVarFo.g;
        float f2 = ((i / f) - gVarFo.gc) / (gVarFo.f251a + (i2 / f));
        this.gb = false;
        z(i4, f2, (int) (i3 * f2));
        if (this.gb) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void z(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.jq
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6a
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6a
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$dl r9 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.dl) r9
            boolean r10 = r9.z
            if (r10 == 0) goto L67
            int r9 = r9.g
            r9 = r9 & 7
            if (r9 == r2) goto L4c
            r10 = 3
            if (r9 == r10) goto L46
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5b
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L58
        L46:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5b
        L4c:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L58:
            r11 = r9
            r9 = r3
            r3 = r11
        L5b:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L66
            r8.offsetLeftAndRight(r3)
        L66:
            r3 = r9
        L67:
            int r7 = r7 + 1
            goto L1b
        L6a:
            r12.g(r13, r14, r15)
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$gc r13 = r12.zx
            if (r13 == 0) goto L9d
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L79:
            if (r1 >= r14) goto L9d
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$dl r0 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.dl) r0
            boolean r0 = r0.z
            if (r0 != 0) goto L9a
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$gc r3 = r12.zx
            r3.z(r15, r0)
        L9a:
            int r1 = r1 + 1
            goto L79
        L9d:
            r12.gb = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.z(int, float, int):void");
    }

    private void g(int i, float f, int i2) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.z(i, f, i2);
        }
        List<a> list = this.sv;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar2 = this.sv.get(i3);
                if (aVar2 != null) {
                    aVar2.z(i, f, i2);
                }
            }
        }
        a aVar3 = this.yx;
        if (aVar3 != null) {
            aVar3.z(i, f, i2);
        }
    }

    private void gc(int i) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.gz(i);
        }
        List<a> list = this.sv;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.sv.get(i2);
                if (aVar2 != null) {
                    aVar2.gz(i);
                }
            }
        }
        a aVar3 = this.yx;
        if (aVar3 != null) {
            aVar3.gz(i);
        }
    }

    private void m(int i) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.fo(i);
        }
        List<a> list = this.sv;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.sv.get(i2);
                if (aVar2 != null) {
                    aVar2.fo(i);
                }
            }
        }
        a aVar3 = this.yx;
        if (aVar3 != null) {
            aVar3.fo(i);
        }
    }

    private void z(boolean z2) {
        boolean z3 = this.nh == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.i.isFinished()) {
                this.i.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.i.getCurrX();
                int currY = this.i.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        a(currX);
                    }
                }
            }
        }
        this.sy = false;
        for (int i = 0; i < this.e.size(); i++) {
            g gVar = this.e.get(i);
            if (gVar.dl) {
                gVar.dl = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                postOnAnimation(this.me);
            } else {
                this.me.run();
            }
        }
    }

    private boolean z(float f, float f2) {
        if (f >= this.x || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.x)) && f2 < 0.0f;
        }
        return true;
    }

    private void g(boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z2 ? this.b : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            gz();
            return false;
        }
        if (action != 0) {
            if (this.l) {
                return true;
            }
            if (this.h) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.ti = x;
            this.mc = x;
            float y = motionEvent.getY();
            this.eo = y;
            this.un = y;
            this.oq = motionEvent.getPointerId(0);
            this.h = false;
            this.v = true;
            this.i.computeScrollOffset();
            if (this.nh == 2 && Math.abs(this.i.getFinalX() - this.i.getCurrX()) > this.gp) {
                this.i.abortAnimation();
                this.sy = false;
                dl();
                this.l = true;
                dl(true);
                setScrollState(1);
            } else {
                z(false);
                this.l = false;
            }
        } else if (action == 2) {
            int i = this.oq;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.mc;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.eo);
                if (f != 0.0f && !z(this.mc, f) && z(this, false, (int) f, (int) x2, (int) y2)) {
                    this.mc = x2;
                    this.un = y2;
                    this.h = true;
                    return false;
                }
                int i2 = this.lq;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.l = true;
                    dl(true);
                    setScrollState(1);
                    this.mc = f > 0.0f ? this.ti + this.lq : this.ti - this.lq;
                    this.un = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.h = true;
                }
                if (this.l && g(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.wj == null) {
            this.wj = VelocityTracker.obtain();
        }
        this.wj.addMovement(motionEvent);
        return this.l;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.g gVar;
        int iFindPointerIndex;
        if (this.t) {
            return true;
        }
        boolean zGz = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (gVar = this.dl) == null || gVar.z() == 0) {
            return false;
        }
        if (this.wj == null) {
            this.wj = VelocityTracker.obtain();
        }
        this.wj.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.i.abortAnimation();
            this.sy = false;
            dl();
            float x = motionEvent.getX();
            this.ti = x;
            this.mc = x;
            float y = motionEvent.getY();
            this.eo = y;
            this.un = y;
            this.oq = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.mc = motionEvent.getX(actionIndex);
                            this.oq = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        z(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.oq);
                        if (iFindPointerIndex2 != -1) {
                            this.mc = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.l) {
                    z(this.f248a, true, 0, false);
                    zGz = gz();
                }
            } else if (!this.l) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.oq);
                if (iFindPointerIndex3 == -1) {
                    zGz = gz();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x2 - this.mc);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.un);
                    if (fAbs > this.lq && fAbs > fAbs2) {
                        this.l = true;
                        dl(true);
                        float f = this.ti;
                        this.mc = x2 - f > 0.0f ? f + this.lq : f - this.lq;
                        this.un = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.l) {
                        zGz = false | g(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.l && (iFindPointerIndex = motionEvent.findPointerIndex(this.oq)) != -1) {
                zGz = false | g(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.l) {
            VelocityTracker velocityTracker = this.wj;
            velocityTracker.computeCurrentVelocity(1000, this.xl);
            int xVelocity = (int) velocityTracker.getXVelocity(this.oq);
            this.sy = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            g gVarFo = fo();
            float f2 = clientWidth;
            int i = gVarFo.g;
            float f3 = ((scrollX / f2) - gVarFo.gc) / (gVarFo.f251a + (this.ls / f2));
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.oq);
            if (iFindPointerIndex4 != -1) {
                z(z(i, f3, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.ti)), true, true, xVelocity);
                zGz = gz();
            }
        }
        if (zGz) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean gz() {
        this.oq = -1;
        uy();
        this.vm.onRelease();
        this.y.onRelease();
        return this.vm.isFinished() || this.y.isFinished();
    }

    private void dl(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean g(float f) {
        boolean z2;
        boolean z3;
        float f2 = this.mc - f;
        this.mc = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.tb * clientWidth;
        float f4 = this.q * clientWidth;
        boolean z4 = false;
        g gVar = this.e.get(0);
        ArrayList<g> arrayList = this.e;
        g gVar2 = arrayList.get(arrayList.size() - 1);
        if (gVar.g != 0) {
            f3 = gVar.gc * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (gVar2.g != this.dl.z() - 1) {
            f4 = gVar2.gc * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f3) {
            if (z2) {
                this.vm.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z3) {
                this.y.onPull(Math.abs(scrollX - f4) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mc += scrollX - i;
        scrollTo(i, getScrollY());
        a(i);
        return z4;
    }

    private g fo() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.ls / clientWidth : 0.0f;
        int i2 = 0;
        boolean z2 = true;
        g gVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.e.size()) {
            g gVar2 = this.e.get(i2);
            if (!z2 && gVar2.g != (i = i3 + 1)) {
                gVar2 = this.gz;
                gVar2.gc = f + f3 + f2;
                gVar2.g = i;
                gVar2.f251a = this.dl.z(gVar2.g);
                i2--;
            }
            g gVar3 = gVar2;
            f = gVar3.gc;
            float f4 = gVar3.f251a + f + f2;
            if (!z2 && scrollX < f) {
                return gVar;
            }
            if (scrollX < f4 || i2 == this.e.size() - 1) {
                return gVar3;
            }
            int i4 = gVar3.g;
            float f5 = gVar3.f251a;
            i2++;
            z2 = false;
            i3 = i4;
            f3 = f5;
            gVar = gVar3;
        }
        return gVar;
    }

    private int z(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.j || Math.abs(i2) <= this.na) {
            i += (int) (f + (i >= this.f248a ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.e.size() <= 0) {
            return i;
        }
        return Math.max(this.e.get(0).g, Math.min(i, this.e.get(r4.size() - 1).g));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.g gVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (gVar = this.dl) != null && gVar.z() > 1)) {
            if (!this.vm.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.tb * width);
                this.vm.setSize(height, width);
                zDraw = false | this.vm.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.y.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.q + 1.0f)) * width2);
                this.y.setSize(height2, width2);
                zDraw |= this.y.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.vm.finish();
            this.y.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.ls <= 0 || this.p == null || this.e.size() <= 0 || this.dl == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.ls / width;
        int i = 0;
        g gVar = this.e.get(0);
        float f5 = gVar.gc;
        int size = this.e.size();
        int i2 = gVar.g;
        int i3 = this.e.get(size - 1).g;
        while (i2 < i3) {
            while (i2 > gVar.g && i < size) {
                i++;
                gVar = this.e.get(i);
            }
            if (i2 == gVar.g) {
                f2 = (gVar.gc + gVar.f251a) * width;
                f = gVar.gc + gVar.f251a + f4;
            } else {
                float fZ = this.dl.z(i2);
                float f6 = (f5 + fZ) * width;
                f = f5 + fZ + f4;
                f2 = f6;
            }
            if (this.ls + f2 > scrollX) {
                f3 = f4;
                this.p.setBounds(Math.round(f2), this.fv, Math.round(this.ls + f2), this.js);
                this.p.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f3;
        }
    }

    private void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.oq) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mc = motionEvent.getX(i);
            this.oq = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.wj;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void uy() {
        this.l = false;
        this.h = false;
        VelocityTracker velocityTracker = this.wj;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.wj = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.uf != z2) {
            this.uf = z2;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.dl == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.tb)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.q));
    }

    protected boolean z(View view, boolean z2, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && z(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || z(keyEvent);
    }

    public boolean z(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return a();
                }
                return dl(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return gc();
                }
                return dl(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return dl(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return dl(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dl(int r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.dl(int):boolean");
    }

    private Rect z(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean a() {
        int i = this.f248a;
        if (i <= 0) {
            return false;
        }
        z(i - 1, true);
        return true;
    }

    boolean gc() {
        com.bytedance.adsdk.ugeno.viewpager.g gVar = this.dl;
        if (gVar == null || this.f248a >= gVar.z() - 1) {
            return false;
        }
        z(this.f248a + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        g gVarZ;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (gVarZ = z(childAt)) != null && gVarZ.g == this.f248a) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        g gVarZ;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (gVarZ = z(childAt)) != null && gVarZ.g == this.f248a) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        g gVarZ;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (gVarZ = z(childAt)) != null && gVarZ.g == this.f248a && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        g gVarZ;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (gVarZ = z(childAt)) != null && gVarZ.g == this.f248a && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new dl();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof dl) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new dl(getContext(), attributeSet);
    }

    private class m extends DataSetObserver {
        m() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.g();
        }
    }

    public static class dl extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f249a;
        float dl;
        public int g;
        int gc;
        int m;
        public boolean z;

        public dl() {
            super(-1, -1);
            this.dl = 0.0f;
        }

        public dl(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.dl = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.g);
            this.g = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class gz implements Comparator<View> {
        gz() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            dl dlVar = (dl) view.getLayoutParams();
            dl dlVar2 = (dl) view2.getLayoutParams();
            if (dlVar.z != dlVar2.z) {
                return dlVar.z ? 1 : -1;
            }
            return dlVar.gc - dlVar2.gc;
        }
    }
}
