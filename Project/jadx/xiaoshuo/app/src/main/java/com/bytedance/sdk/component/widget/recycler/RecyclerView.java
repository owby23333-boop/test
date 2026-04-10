package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.annotation.SuppressLint;
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
import android.util.Log;
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
import com.bytedance.sdk.component.widget.recycler.bf;
import com.bytedance.sdk.component.widget.recycler.bh;
import com.bytedance.sdk.component.widget.recycler.e;
import com.bytedance.sdk.component.widget.recycler.t;
import com.bytedance.sdk.component.widget.recycler.tg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.e.d.d {
    private static final Class<?>[] i;
    static final Interpolator r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.bytedance.sdk.component.widget.recycler.tg f2098a;
    private final t.bf aq;
    private final int[] as;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List<cv> f2099b;
    e bh;
    final int[] bm;
    private Runnable br;
    final int[] bx;
    private vn.bf c;
    boolean cv;
    boolean dt;
    private int em;
    private EdgeEffect ev;
    boolean f;
    private int fl;
    private int ft;
    final dt fy;
    private int g;
    final w ga;
    boolean h;
    boolean hb;
    private tg in;
    private com.bytedance.sdk.component.widget.recycler.e.d.tg jk;
    boolean k;
    boolean l;
    final y lc;
    private float lg;
    private int lw;
    final Runnable m;
    private bh n;
    private int nt;
    private final ArrayList<bh> ot;
    private ga ov;
    com.bytedance.sdk.component.widget.recycler.bf p;
    boolean pe;
    private int pl;
    private final Rect rb;
    private List<t> rk;
    private final int[] rw;
    l s;
    private xu sq;
    zk t;
    private final int tu;
    private t tv;
    private VelocityTracker tx;
    private int ue;
    tg.e uk;
    private final AccessibilityManager uq;
    final com.bytedance.sdk.component.widget.recycler.t v;
    private final int vg;
    com.bytedance.sdk.component.widget.recycler.e vn;
    private EdgeEffect vs;
    private EdgeEffect vu;
    final ArrayList<v> w;
    boolean wl;
    final Rect wu;
    boolean x;
    private int xn;
    final RectF xu;
    private int xy;
    boolean y;
    private boolean ya;
    private List<wu> yf;
    private final f yl;
    private final int[] ys;
    private EdgeEffect z;
    vn za;
    private int zb;
    boolean zk;
    private float zo;
    private boolean zr;
    private static final int[] rm = {R.attr.nestedScrollingEnabled};
    private static final int[] q = {R.attr.clipToPadding};
    static final boolean e = false;
    static final boolean bf = true;
    static final boolean d = true;
    static final boolean tg = true;
    private static final boolean rt = false;
    private static final boolean j = false;

    public interface bh {
        void bf(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z);

        boolean e(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class cv {
        private static final List<Object> e = Collections.emptyList();
        int bh;
        WeakReference<RecyclerView> ga;
        RecyclerView k;
        public final View tg;
        int vn = -1;
        int p = -1;
        long v = -1;
        int zk = -1;
        int m = -1;
        cv wu = null;
        cv xu = null;
        List<Object> t = null;
        List<Object> s = null;
        private int bf = 0;
        w w = null;
        boolean l = false;
        private int d = 0;
        int f = -1;

        public cv(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.tg = view;
        }

        public final boolean a() {
            return (this.bh & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.e.d.p.vn(this.tg);
        }

        void bf(int i) {
            this.bh = i | this.bh;
        }

        boolean bh() {
            return this.w != null;
        }

        boolean cv() {
            return (this.bh & 512) != 0 || f();
        }

        boolean dt() {
            return (this.bh & 1) != 0;
        }

        void e(int i, int i2, boolean z) {
            bf(8);
            e(i2, z);
            this.vn = i;
        }

        boolean f() {
            return (this.bh & 4) != 0;
        }

        boolean fy() {
            return (this.bh & 16) == 0 && com.bytedance.sdk.component.widget.recycler.e.d.p.vn(this.tg);
        }

        void ga() {
            this.p = -1;
            this.m = -1;
        }

        boolean h() {
            return (this.bh & 2) != 0;
        }

        boolean k() {
            return (this.bh & 2) != 0;
        }

        void l() {
            this.bh &= -257;
        }

        void lc() {
            this.bh = 0;
            this.vn = -1;
            this.p = -1;
            this.v = -1L;
            this.m = -1;
            this.bf = 0;
            this.wu = null;
            this.xu = null;
            wl();
            this.d = 0;
            this.f = -1;
            RecyclerView.d(this);
        }

        public final int m() {
            return this.p;
        }

        boolean p() {
            return (this.bh & 128) != 0;
        }

        boolean pe() {
            return (this.bh & 8) != 0;
        }

        boolean s() {
            return (this.bh & 32) != 0;
        }

        void t() {
            this.w.d(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.vn + " id=" + this.v + ", oldPos=" + this.p + ", pLpos:" + this.m);
            if (bh()) {
                sb.append(" scrap ");
                sb.append(this.l ? "[changeScrap]" : "[attachedScrap]");
            }
            if (f()) {
                sb.append(" invalid");
            }
            if (!dt()) {
                sb.append(" unbound");
            }
            if (k()) {
                sb.append(" update");
            }
            if (pe()) {
                sb.append(" removed");
            }
            if (p()) {
                sb.append(" ignored");
            }
            if (y()) {
                sb.append(" tmpDetached");
            }
            if (!a()) {
                sb.append(" not recyclable(" + this.bf + ")");
            }
            if (cv()) {
                sb.append(" undefined adapter position");
            }
            if (this.tg.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(com.alipay.sdk.m.y.l.d);
            return sb.toString();
        }

        boolean uk() {
            return (this.bh & 16) != 0;
        }

        public final int v() {
            int i = this.m;
            return i == -1 ? this.vn : i;
        }

        void vn() {
            if (this.p == -1) {
                this.p = this.vn;
            }
        }

        void w() {
            this.bh &= -33;
        }

        void wl() {
            List<Object> list = this.t;
            if (list != null) {
                list.clear();
            }
            this.bh &= -1025;
        }

        public final long wu() {
            return this.v;
        }

        public final int xu() {
            return this.zk;
        }

        boolean y() {
            return (this.bh & 256) != 0;
        }

        public List<Object> za() {
            if ((this.bh & 1024) != 0) {
                return e;
            }
            List<Object> list = this.t;
            return (list == null || list.size() == 0) ? e : this.s;
        }

        public final int zk() {
            RecyclerView recyclerView = this.k;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.tg(this);
        }

        public void bf(RecyclerView recyclerView) {
            recyclerView.e(this, this.d);
            this.d = 0;
        }

        void e(int i, boolean z) {
            if (this.p == -1) {
                this.p = this.vn;
            }
            if (this.m == -1) {
                this.m = this.vn;
            }
            if (z) {
                this.m += i;
            }
            this.vn += i;
            if (this.tg.getLayoutParams() != null) {
                ((m) this.tg.getLayoutParams()).d = true;
            }
        }

        public void e(w wVar, boolean z) {
            this.w = wVar;
            this.l = z;
        }

        boolean e(int i) {
            return (i & this.bh) != 0;
        }

        void e(int i, int i2) {
            this.bh = (i & i2) | (this.bh & (~i2));
        }

        void e(Object obj) {
            if (obj == null) {
                bf(1024);
            } else if ((1024 & this.bh) == 0) {
                e();
                this.t.add(obj);
            }
        }

        private void e() {
            if (this.t == null) {
                ArrayList arrayList = new ArrayList();
                this.t = arrayList;
                this.s = Collections.unmodifiableList(arrayList);
            }
        }

        public void e(RecyclerView recyclerView) {
            int i = this.f;
            if (i != -1) {
                this.d = i;
            } else {
                this.d = com.bytedance.sdk.component.widget.recycler.e.d.p.bf(this.tg);
            }
            recyclerView.e(this, 4);
        }

        public final void e(boolean z) {
            int i = this.bf;
            int i2 = z ? i - 1 : i + 1;
            this.bf = i2;
            if (i2 < 0) {
                this.bf = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.bh |= 16;
            } else if (z && i2 == 0) {
                this.bh &= -17;
            }
        }
    }

    public static abstract class d {
        public void e() {
        }

        public void e(int i, int i2) {
        }

        public void e(int i, int i2, Object obj) {
            e(i, i2);
        }
    }

    public static abstract class e<VH extends cv> {
        private final bf e = new bf();
        private boolean bf = false;

        public long bf(int i) {
            return -1L;
        }

        public void d(VH vh) {
        }

        public abstract int e();

        public int e(int i) {
            return 0;
        }

        public abstract VH e(ViewGroup viewGroup, int i);

        public abstract void e(VH vh, int i);

        public void tg(VH vh) {
        }

        public void bf(RecyclerView recyclerView) {
        }

        public final void d() {
            this.e.e();
        }

        public void e(VH vh) {
        }

        public boolean bf(VH vh) {
            return false;
        }

        public void e(RecyclerView recyclerView) {
        }

        public final VH bf(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV CreateView");
                VH vh = (VH) e(viewGroup, i);
                if (vh.tg.getParent() == null) {
                    vh.zk = i;
                    return vh;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                com.bytedance.sdk.component.widget.recycler.e.e.e.e();
            }
        }

        public void e(VH vh, int i, List<Object> list) {
            e(vh, i);
        }

        public void e(d dVar) {
            this.e.registerObserver(dVar);
        }

        public final void e(int i, Object obj) {
            this.e.e(i, 1, obj);
        }

        public final void e(int i, int i2) {
            this.e.e(i, i2);
        }

        public final void bf(VH vh, int i) {
            vh.vn = i;
            if (bf()) {
                vh.v = bf(i);
            }
            vh.e(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV OnBindView");
            e(vh, i, vh.za());
            vh.wl();
            ViewGroup.LayoutParams layoutParams = vh.tg.getLayoutParams();
            if (layoutParams instanceof m) {
                ((m) layoutParams).d = true;
            }
            com.bytedance.sdk.component.widget.recycler.e.e.e.e();
        }

        public final boolean bf() {
            return this.bf;
        }

        public void bf(d dVar) {
            this.e.unregisterObserver(dVar);
        }
    }

    public static class ga {
        public EdgeEffect e(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class k {
        private RecyclerView bf;
        private zk d;
        private boolean ga;
        private boolean tg;
        private boolean v;
        private View vn;
        private int e = -1;
        private final e p = new e(0, 0);

        public interface bf {
            PointF d(int i);
        }

        public static class e {
            private int bf;
            private int d;
            private int e;
            private Interpolator ga;
            private int p;
            private int tg;
            private boolean vn;

            public e(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void bf() {
                if (this.ga != null && this.d < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.d < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void e(int i) {
                this.tg = i;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.e = i;
                this.bf = i2;
                this.d = i3;
                this.ga = interpolator;
                this.vn = true;
            }

            public e(int i, int i2, int i3, Interpolator interpolator) {
                this.tg = -1;
                this.vn = false;
                this.p = 0;
                this.e = i;
                this.bf = i2;
                this.d = i3;
                this.ga = interpolator;
            }

            public boolean e() {
                return this.tg >= 0;
            }

            public void e(RecyclerView recyclerView) {
                int i = this.tg;
                if (i >= 0) {
                    this.tg = -1;
                    recyclerView.bf(i);
                    this.vn = false;
                    return;
                }
                if (this.vn) {
                    bf();
                    Interpolator interpolator = this.ga;
                    if (interpolator == null) {
                        int i2 = this.d;
                        if (i2 == Integer.MIN_VALUE) {
                            recyclerView.lc.bf(this.e, this.bf);
                        } else {
                            recyclerView.lc.e(this.e, this.bf, i2);
                        }
                    } else {
                        recyclerView.lc.e(this.e, this.bf, this.d, interpolator);
                    }
                    int i3 = this.p + 1;
                    this.p = i3;
                    if (i3 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.vn = false;
                    return;
                }
                this.p = 0;
            }
        }

        public abstract void bf();

        public void bf(View view) {
            if (e(view) == zk()) {
                this.vn = view;
            }
        }

        public void d(int i) {
            this.e = i;
        }

        public abstract void e();

        public abstract void e(int i, int i2, dt dtVar, e eVar);

        public abstract void e(View view, dt dtVar, e eVar);

        public void e(RecyclerView recyclerView, zk zkVar) {
            if (this.v) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.bf = recyclerView;
            this.d = zkVar;
            int i = this.e;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.fy.e = i;
            this.ga = true;
            this.tg = true;
            this.vn = ga(zk());
            e();
            this.bf.lc.e();
            this.v = true;
        }

        public zk ga() {
            return this.d;
        }

        public int m() {
            return this.bf.t.pe();
        }

        public boolean p() {
            return this.tg;
        }

        public PointF tg(int i) {
            Object objGa = ga();
            if (objGa instanceof bf) {
                return ((bf) objGa).d(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + bf.class.getCanonicalName());
            return null;
        }

        public boolean v() {
            return this.ga;
        }

        public final void vn() {
            if (this.ga) {
                this.ga = false;
                bf();
                this.bf.fy.e = -1;
                this.vn = null;
                this.e = -1;
                this.tg = false;
                this.d.bf(this);
                this.d = null;
                this.bf = null;
            }
        }

        public int zk() {
            return this.e;
        }

        public View ga(int i) {
            return this.bf.t.bf(i);
        }

        public void e(int i, int i2) {
            PointF pointFTg;
            RecyclerView recyclerView = this.bf;
            if (!this.ga || this.e == -1 || recyclerView == null) {
                vn();
            }
            if (this.tg && this.vn == null && this.d != null && (pointFTg = tg(this.e)) != null) {
                float f = pointFTg.x;
                if (f != 0.0f || pointFTg.y != 0.0f) {
                    recyclerView.e((int) Math.signum(f), (int) Math.signum(pointFTg.y), (int[]) null);
                }
            }
            this.tg = false;
            View view = this.vn;
            if (view != null) {
                if (e(view) == this.e) {
                    e(this.vn, recyclerView.fy, this.p);
                    this.p.e(recyclerView);
                    vn();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.vn = null;
                }
            }
            if (this.ga) {
                e(i, i2, recyclerView.fy, this.p);
                boolean zE = this.p.e();
                this.p.e(recyclerView);
                if (zE) {
                    if (this.ga) {
                        this.tg = true;
                        recyclerView.lc.e();
                    } else {
                        vn();
                    }
                }
            }
        }

        public int e(View view) {
            return this.bf.v(view);
        }

        public void e(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }
    }

    public interface l {
        void e(cv cvVar);
    }

    public class p implements vn.bf {
        public p() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn.bf
        public void e(cv cvVar) {
            cvVar.e(true);
            if (cvVar.wu != null && cvVar.xu == null) {
                cvVar.wu = null;
            }
            cvVar.xu = null;
            if (cvVar.uk() || RecyclerView.this.e(cvVar.tg) || !cvVar.y()) {
                return;
            }
            RecyclerView.this.removeDetachedView(cvVar.tg, false);
        }
    }

    public static abstract class pe {
        public abstract View e(w wVar, int i, int i2);
    }

    public static abstract class t {
        public void e(RecyclerView recyclerView, int i) {
        }

        public void e(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface tg {
        int e(int i, int i2);
    }

    public static abstract class v {
        @Deprecated
        public void bf(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void e(Canvas canvas, RecyclerView recyclerView) {
        }

        public void bf(Canvas canvas, RecyclerView recyclerView, dt dtVar) {
            bf(canvas, recyclerView);
        }

        public void e(Canvas canvas, RecyclerView recyclerView, dt dtVar) {
            e(canvas, recyclerView);
        }

        @Deprecated
        public void e(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, dt dtVar) {
            e(rect, ((m) view.getLayoutParams()).tg(), recyclerView);
        }
    }

    public static abstract class vn {
        private bf e = null;
        private ArrayList<e> bf = new ArrayList<>();
        private long d = 120;
        private long tg = 120;
        private long ga = 250;
        private long vn = 250;

        public interface bf {
            void e(cv cvVar);
        }

        public static class d {
            public int bf;
            public int d;
            public int e;
            public int tg;

            public d e(cv cvVar) {
                return e(cvVar, 0);
            }

            public d e(cv cvVar, int i) {
                View view = cvVar.tg;
                this.e = view.getLeft();
                this.bf = view.getTop();
                this.d = view.getRight();
                this.tg = view.getBottom();
                return this;
            }
        }

        public interface e {
            void e();
        }

        public abstract boolean bf();

        public abstract boolean bf(cv cvVar, d dVar, d dVar2);

        public abstract boolean d(cv cvVar, d dVar, d dVar2);

        public abstract void e();

        public void e(long j) {
            this.vn = j;
        }

        public abstract boolean e(cv cvVar, cv cvVar2, d dVar, d dVar2);

        public abstract boolean e(cv cvVar, d dVar, d dVar2);

        public long ga() {
            return this.ga;
        }

        public d m() {
            return new d();
        }

        public void p(cv cvVar) {
        }

        public abstract void tg();

        public abstract void tg(cv cvVar);

        public boolean v(cv cvVar) {
            return true;
        }

        public long vn() {
            return this.d;
        }

        public final void zk() {
            int size = this.bf.size();
            for (int i = 0; i < size; i++) {
                this.bf.get(i).e();
            }
            this.bf.clear();
        }

        public static int ga(cv cvVar) {
            int i = cvVar.bh & 14;
            if (cvVar.f()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iM = cvVar.m();
            int iZk = cvVar.zk();
            return (iM == -1 || iZk == -1 || iM == iZk) ? i : i | 2048;
        }

        public void e(bf bfVar) {
            this.e = bfVar;
        }

        public long p() {
            return this.tg;
        }

        public long v() {
            return this.vn;
        }

        public final void vn(cv cvVar) {
            p(cvVar);
            bf bfVar = this.e;
            if (bfVar != null) {
                bfVar.e(cvVar);
            }
        }

        public d e(dt dtVar, cv cvVar, int i, List<Object> list) {
            return m().e(cvVar);
        }

        public d e(dt dtVar, cv cvVar) {
            return m().e(cvVar);
        }

        public boolean e(cv cvVar, List<Object> list) {
            return v(cvVar);
        }
    }

    public final class w {
        ArrayList<cv> bf;
        final ArrayList<cv> d;
        final ArrayList<cv> e;
        s ga;
        private final List<cv> p;
        int tg;
        private int v;
        private pe zk;

        public w() {
            ArrayList<cv> arrayList = new ArrayList<>();
            this.e = arrayList;
            this.bf = null;
            this.d = new ArrayList<>();
            this.p = Collections.unmodifiableList(arrayList);
            this.v = 2;
            this.tg = 2;
        }

        private void ga(cv cvVar) {
            View view = cvVar.tg;
            if (view instanceof ViewGroup) {
                e((ViewGroup) view, false);
            }
        }

        public void bf() {
            zk zkVar = RecyclerView.this.t;
            this.tg = this.v + (zkVar != null ? zkVar.w : 0);
            for (int size = this.d.size() - 1; size >= 0 && this.d.size() > this.tg; size--) {
                d(size);
            }
        }

        public List<cv> d() {
            return this.p;
        }

        public void e() {
            this.e.clear();
            tg();
        }

        public void m() {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                m mVar = (m) this.d.get(i).tg.getLayoutParams();
                if (mVar != null) {
                    mVar.d = true;
                }
            }
        }

        public s p() {
            if (this.ga == null) {
                this.ga = new s();
            }
            return this.ga;
        }

        public void tg() {
            for (int size = this.d.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.d.clear();
            if (RecyclerView.tg) {
                RecyclerView.this.uk.e();
            }
        }

        public void v() {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                cv cvVar = this.d.get(i);
                if (cvVar != null) {
                    cvVar.bf(6);
                    cvVar.e((Object) null);
                }
            }
            e eVar = RecyclerView.this.bh;
            if (eVar == null || !eVar.bf()) {
                tg();
            }
        }

        public void vn() {
            this.e.clear();
            ArrayList<cv> arrayList = this.bf;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public void zk() {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                this.d.get(i).ga();
            }
            int size2 = this.e.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.e.get(i2).ga();
            }
            ArrayList<cv> arrayList = this.bf;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.bf.get(i3).ga();
                }
            }
        }

        public void d(int i) {
            e(this.d.get(i), true);
            this.d.remove(i);
        }

        public void e(int i) {
            this.v = i;
            bf();
        }

        public int ga() {
            return this.e.size();
        }

        public cv ga(int i) {
            int size;
            int iBf;
            ArrayList<cv> arrayList = this.bf;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    cv cvVar = this.bf.get(i2);
                    if (!cvVar.s() && cvVar.v() == i) {
                        cvVar.bf(32);
                        return cvVar;
                    }
                }
                if (RecyclerView.this.bh.bf() && (iBf = RecyclerView.this.vn.bf(i)) > 0 && iBf < RecyclerView.this.bh.e()) {
                    long jBf = RecyclerView.this.bh.bf(iBf);
                    for (int i3 = 0; i3 < size; i3++) {
                        cv cvVar2 = this.bf.get(i3);
                        if (!cvVar2.s() && cvVar2.wu() == jBf) {
                            cvVar2.bf(32);
                            return cvVar2;
                        }
                    }
                }
            }
            return null;
        }

        public View bf(int i) {
            return e(i, false);
        }

        public void d(View view) {
            cv cvVarGa = RecyclerView.ga(view);
            if (!cvVarGa.e(12) && cvVarGa.h() && !RecyclerView.this.bf(cvVarGa)) {
                if (this.bf == null) {
                    this.bf = new ArrayList<>();
                }
                cvVarGa.e(this, true);
                this.bf.add(cvVarGa);
                return;
            }
            if (cvVarGa.f() && !cvVarGa.pe() && !RecyclerView.this.bh.bf()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.e());
            }
            cvVarGa.e(this, false);
            this.e.add(cvVarGa);
        }

        public boolean e(cv cvVar) {
            if (cvVar.pe()) {
                return RecyclerView.this.fy.e();
            }
            int i = cvVar.vn;
            if (i >= 0 && i < RecyclerView.this.bh.e()) {
                if (RecyclerView.this.fy.e() || RecyclerView.this.bh.e(cvVar.vn) == cvVar.xu()) {
                    return !RecyclerView.this.bh.bf() || cvVar.wu() == RecyclerView.this.bh.bf(cvVar.vn);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + cvVar + RecyclerView.this.e());
        }

        public void bf(cv cvVar) {
            boolean z;
            boolean z2 = true;
            if (!cvVar.bh() && cvVar.tg.getParent() == null) {
                if (!cvVar.y()) {
                    if (!cvVar.p()) {
                        boolean zFy = cvVar.fy();
                        e eVar = RecyclerView.this.bh;
                        if ((eVar != null && zFy && eVar.bf(cvVar)) || cvVar.a()) {
                            if (this.tg <= 0 || cvVar.e(526)) {
                                z = false;
                            } else {
                                int size = this.d.size();
                                if (size >= this.tg && size > 0) {
                                    d(0);
                                    size--;
                                }
                                if (RecyclerView.tg && size > 0 && !RecyclerView.this.uk.e(cvVar.vn)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.uk.e(this.d.get(i).vn)) {
                                            break;
                                        } else {
                                            i--;
                                        }
                                    }
                                    size = i + 1;
                                }
                                this.d.add(size, cvVar);
                                z = true;
                            }
                            if (z) {
                                z2 = false;
                            } else {
                                e(cvVar, true);
                            }
                            z = z;
                        } else {
                            z2 = false;
                        }
                        RecyclerView.this.v.p(cvVar);
                        if (z || z2 || !zFy) {
                            return;
                        }
                        cvVar.k = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.e());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + cvVar + RecyclerView.this.e());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(cvVar.bh());
            sb.append(" isAttached:");
            sb.append(cvVar.tg.getParent() != null);
            sb.append(RecyclerView.this.e());
            throw new IllegalArgumentException(sb.toString());
        }

        public View tg(int i) {
            return this.e.get(i).tg;
        }

        public void tg(cv cvVar) {
            l lVar = RecyclerView.this.s;
            if (lVar != null) {
                lVar.e(cvVar);
            }
            e eVar = RecyclerView.this.bh;
            if (eVar != null) {
                eVar.e(cvVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.fy != null) {
                recyclerView.v.p(cvVar);
            }
        }

        private boolean e(cv cvVar, int i, int i2, long j) {
            cvVar.k = RecyclerView.this;
            int iXu = cvVar.xu();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.ga.bf(iXu, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.bh.bf(cvVar, i);
            this.ga.bf(cvVar.xu(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.fy.e()) {
                return true;
            }
            cvVar.m = i2;
            return true;
        }

        public void d(cv cvVar) {
            if (cvVar.l) {
                this.bf.remove(cvVar);
            } else {
                this.e.remove(cvVar);
            }
            cvVar.w = null;
            cvVar.l = false;
            cvVar.w();
        }

        public void d(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.d.size() - 1; size >= 0; size--) {
                cv cvVar = this.d.get(size);
                if (cvVar != null && (i3 = cvVar.vn) >= i && i3 < i4) {
                    cvVar.bf(2);
                    d(size);
                }
            }
        }

        public View e(int i, boolean z) {
            return e(i, z, Long.MAX_VALUE).tg;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0181 A[PHI: r1 r4
  0x0181: PHI (r1v12 com.bytedance.sdk.component.widget.recycler.RecyclerView$cv) = 
  (r1v11 com.bytedance.sdk.component.widget.recycler.RecyclerView$cv)
  (r1v31 com.bytedance.sdk.component.widget.recycler.RecyclerView$cv)
 binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.sdk.component.widget.recycler.RecyclerView.cv e(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.w.e(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$cv");
        }

        public void bf(View view) {
            cv cvVarGa = RecyclerView.ga(view);
            cvVarGa.w = null;
            cvVarGa.l = false;
            cvVarGa.w();
            bf(cvVarGa);
        }

        public cv bf(int i, boolean z) {
            View viewD;
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                cv cvVar = this.e.get(i2);
                if (!cvVar.s() && cvVar.v() == i && !cvVar.f() && (RecyclerView.this.fy.p || !cvVar.pe())) {
                    cvVar.bf(32);
                    return cvVar;
                }
            }
            if (!z && (viewD = RecyclerView.this.p.d(i)) != null) {
                cv cvVarGa = RecyclerView.ga(viewD);
                RecyclerView.this.p.ga(viewD);
                int iBf = RecyclerView.this.p.bf(viewD);
                if (iBf != -1) {
                    RecyclerView.this.p.ga(iBf);
                    d(viewD);
                    cvVarGa.bf(8224);
                    return cvVarGa;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + cvVarGa + RecyclerView.this.e());
            }
            int size2 = this.d.size();
            for (int i3 = 0; i3 < size2; i3++) {
                cv cvVar2 = this.d.get(i3);
                if (!cvVar2.f() && cvVar2.v() == i) {
                    if (!z) {
                        this.d.remove(i3);
                    }
                    return cvVar2;
                }
            }
            return null;
        }

        public void bf(int i, int i2) {
            int size = this.d.size();
            for (int i3 = 0; i3 < size; i3++) {
                cv cvVar = this.d.get(i3);
                if (cvVar != null && cvVar.vn >= i) {
                    cvVar.e(i2, true);
                }
            }
        }

        private void e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    e((ViewGroup) childAt, true);
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

        public void e(View view) {
            cv cvVarGa = RecyclerView.ga(view);
            if (cvVarGa.y()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (cvVarGa.bh()) {
                cvVarGa.t();
            } else if (cvVarGa.s()) {
                cvVarGa.w();
            }
            bf(cvVarGa);
        }

        public void e(cv cvVar, boolean z) {
            RecyclerView.d(cvVar);
            if (cvVar.e(16384)) {
                cvVar.e(0, 16384);
            }
            if (z) {
                tg(cvVar);
            }
            cvVar.k = null;
            p().e(cvVar);
        }

        public cv e(long j, int i, boolean z) {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                cv cvVar = this.e.get(size);
                if (cvVar.wu() == j && !cvVar.s()) {
                    if (i == cvVar.xu()) {
                        cvVar.bf(32);
                        if (cvVar.pe() && !RecyclerView.this.fy.e()) {
                            cvVar.e(2, 14);
                        }
                        return cvVar;
                    }
                    if (!z) {
                        this.e.remove(size);
                        RecyclerView.this.removeDetachedView(cvVar.tg, false);
                        bf(cvVar.tg);
                    }
                }
            }
            int size2 = this.d.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                cv cvVar2 = this.d.get(size2);
                if (cvVar2.wu() == j) {
                    if (i == cvVar2.xu()) {
                        if (!z) {
                            this.d.remove(size2);
                        }
                        return cvVar2;
                    }
                    if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        public void e(e eVar, e eVar2, boolean z) {
            e();
            p().e(eVar, eVar2, z);
        }

        public void e(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.d.size();
            for (int i7 = 0; i7 < size; i7++) {
                cv cvVar = this.d.get(i7);
                if (cvVar != null && (i6 = cvVar.vn) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        cvVar.e(i2 - i, false);
                    } else {
                        cvVar.e(i3, false);
                    }
                }
            }
        }

        public void e(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.d.size() - 1; size >= 0; size--) {
                cv cvVar = this.d.get(size);
                if (cvVar != null) {
                    int i4 = cvVar.vn;
                    if (i4 >= i3) {
                        cvVar.e(-i2, z);
                    } else if (i4 >= i) {
                        cvVar.bf(8);
                        d(size);
                    }
                }
            }
        }

        public void e(pe peVar) {
            this.zk = peVar;
        }

        public void e(s sVar) {
            s sVar2 = this.ga;
            if (sVar2 != null) {
                sVar2.d();
            }
            this.ga = sVar;
            if (sVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.ga.bf();
        }
    }

    public interface wu {
        void bf(View view);

        void e(View view);
    }

    public static abstract class xu {
        public abstract boolean e(int i, int i2);
    }

    public class y implements Runnable {
        Interpolator bf;
        OverScroller e;
        private int ga;
        private boolean p;
        private int tg;
        private boolean vn;

        public y() {
            Interpolator interpolator = RecyclerView.r;
            this.bf = interpolator;
            this.vn = false;
            this.p = false;
            this.e = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private void d() {
            this.p = false;
            this.vn = true;
        }

        private void tg() {
            this.vn = false;
            if (this.p) {
                e();
            }
        }

        public void bf(int i, int i2) {
            e(i, i2, 0, 0);
        }

        public void e() {
            if (this.vn) {
                this.p = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.e.d.p.e(RecyclerView.this, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 419
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.y.run():void");
        }

        private int bf(int i, int i2, int i3, int i4) {
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
            float fE = f2 + (e(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fE / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void e(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.ga = 0;
            this.tg = 0;
            this.e.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public void e(int i, int i2, int i3, int i4) {
            e(i, i2, bf(i, i2, i3, i4));
        }

        private float e(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void e(int i, int i2, int i3) {
            e(i, i2, i3, RecyclerView.r);
        }

        public void bf() {
            RecyclerView.this.removeCallbacks(this);
            this.e.abortAnimation();
        }

        public void e(int i, int i2, Interpolator interpolator) {
            int iBf = bf(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.r;
            }
            e(i, i2, iBf, interpolator);
        }

        public void e(int i, int i2, int i3, Interpolator interpolator) {
            if (this.bf != interpolator) {
                this.bf = interpolator;
                this.e = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.ga = 0;
            this.tg = 0;
            this.e.startScroll(0, 0, i, i2, i3);
            e();
        }
    }

    public static abstract class zk {
        private final bh.bf bf;
        boolean bh;
        private boolean d;
        private final bh.bf e;
        private int f;
        private int ga;
        boolean l;
        com.bytedance.sdk.component.widget.recycler.bh m;
        private int p;
        boolean s;
        boolean t;
        private boolean tg;
        com.bytedance.sdk.component.widget.recycler.bf v;
        private int vn;
        int w;
        com.bytedance.sdk.component.widget.recycler.bh wu;
        k xu;
        RecyclerView zk;

        public interface e {
            void bf(int i, int i2);
        }

        public zk() {
            bh.bf bfVar = new bh.bf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.zk.1
                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int bf() {
                    return zk.this.wl() - zk.this.uk();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public View e(int i) {
                    return zk.this.v(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int bf(View view) {
                    return zk.this.zk(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int e() {
                    return zk.this.lc();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int e(View view) {
                    return zk.this.p(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
                }
            };
            this.e = bfVar;
            bh.bf bfVar2 = new bh.bf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.zk.2
                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int bf() {
                    return zk.this.za() - zk.this.fy();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public View e(int i) {
                    return zk.this.v(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int bf(View view) {
                    return zk.this.m(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int e() {
                    return zk.this.a();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.bh.bf
                public int e(View view) {
                    return zk.this.v(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
                }
            };
            this.bf = bfVar2;
            this.m = new com.bytedance.sdk.component.widget.recycler.bh(bfVar);
            this.wu = new com.bytedance.sdk.component.widget.recycler.bh(bfVar2);
            this.bh = false;
            this.t = false;
            this.s = false;
            this.d = true;
            this.tg = true;
        }

        public int a() {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean b() {
            int iPe = pe();
            for (int i = 0; i < iPe; i++) {
                ViewGroup.LayoutParams layoutParams = v(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int bf(int i, w wVar, dt dtVar) {
            return 0;
        }

        public abstract m bf();

        public int bh(View view) {
            return ((m) view.getLayoutParams()).bf.left;
        }

        public void bm() {
            k kVar = this.xu;
            if (kVar != null) {
                kVar.vn();
            }
        }

        public int bx() {
            return com.bytedance.sdk.component.widget.recycler.e.d.p.ga(this.zk);
        }

        public int cv() {
            return this.vn;
        }

        public int d(dt dtVar) {
            return 0;
        }

        public int dt() {
            return -1;
        }

        public int e(int i, w wVar, dt dtVar) {
            return 0;
        }

        public boolean f() {
            k kVar = this.xu;
            return kVar != null && kVar.v();
        }

        public int fy() {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int ga(dt dtVar) {
            return 0;
        }

        public View h() {
            View focusedChild;
            RecyclerView recyclerView = this.zk;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.v.d(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int hb() {
            return com.bytedance.sdk.component.widget.recycler.e.d.p.tg(this.zk);
        }

        public int k() {
            return com.bytedance.sdk.component.widget.recycler.e.d.p.e(this.zk);
        }

        public boolean l() {
            RecyclerView recyclerView = this.zk;
            return recyclerView != null && recyclerView.zk;
        }

        public int lc() {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void m(int i) {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                recyclerView.vn(i);
            }
        }

        public int p(dt dtVar) {
            return 0;
        }

        public int pe() {
            com.bytedance.sdk.component.widget.recycler.bf bfVar = this.v;
            if (bfVar != null) {
                return bfVar.bf();
            }
            return 0;
        }

        public void s() {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public boolean t() {
            return false;
        }

        public int tg(dt dtVar) {
            return 0;
        }

        public int uk() {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int v(dt dtVar) {
            return 0;
        }

        public int vn(dt dtVar) {
            return 0;
        }

        public final boolean w() {
            return this.tg;
        }

        public int wl() {
            return this.p;
        }

        public void wu(int i) {
        }

        public int x() {
            RecyclerView recyclerView = this.zk;
            e adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.e();
            }
            return 0;
        }

        public int xu(View view) {
            return ((m) view.getLayoutParams()).bf.bottom;
        }

        public int y() {
            return this.ga;
        }

        public int za() {
            return this.f;
        }

        public boolean zk() {
            return false;
        }

        public void bf(dt dtVar) {
        }

        public void d(RecyclerView recyclerView) {
        }

        public View e(View view, int i, w wVar, dt dtVar) {
            return null;
        }

        public void ga(RecyclerView recyclerView) {
        }

        public void p(int i) {
            e(i, v(i));
        }

        public int t(View view) {
            return ((m) view.getLayoutParams()).bf.right;
        }

        public View tg(View view, int i) {
            return null;
        }

        public View v(int i) {
            com.bytedance.sdk.component.widget.recycler.bf bfVar = this.v;
            if (bfVar != null) {
                return bfVar.bf(i);
            }
            return null;
        }

        public void vn(int i) {
            if (v(i) != null) {
                this.v.e(i);
            }
        }

        public int wu(View view) {
            return ((m) view.getLayoutParams()).bf.top;
        }

        public void zk(int i) {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                recyclerView.p(i);
            }
        }

        public void bf(RecyclerView recyclerView, int i, int i2) {
        }

        public void d(RecyclerView recyclerView, int i, int i2) {
        }

        public void e(int i, int i2, dt dtVar, e eVar) {
        }

        public int ga(View view) {
            Rect rect = ((m) view.getLayoutParams()).bf;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int m(View view) {
            return view.getBottom() + xu(view);
        }

        public int p(View view) {
            return view.getLeft() - bh(view);
        }

        public void tg(int i) {
        }

        public int v(View view) {
            return view.getTop() - wu(view);
        }

        public void bf(int i, int i2) {
            this.p = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.ga = mode;
            if (mode == 0 && !RecyclerView.bf) {
                this.p = 0;
            }
            this.f = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.vn = mode2;
            if (mode2 != 0 || RecyclerView.bf) {
                return;
            }
            this.f = 0;
        }

        public boolean d() {
            return false;
        }

        public void e(int i, e eVar) {
        }

        @Deprecated
        public void tg(RecyclerView recyclerView) {
        }

        public int vn(View view) {
            Rect rect = ((m) view.getLayoutParams()).bf;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int zk(View view) {
            return view.getRight() + t(view);
        }

        public void d(int i, int i2) {
            int iPe = pe();
            if (iPe == 0) {
                this.zk.ga(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iPe; i7++) {
                View viewV = v(i7);
                Rect rect = this.zk.wu;
                e(viewV, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.zk.wu.set(i6, i4, i3, i5);
            e(this.zk.wu, i, i2);
        }

        public void e(e eVar, e eVar2) {
        }

        public void ga(int i, int i2) {
            this.zk.setMeasuredDimension(i, i2);
        }

        public boolean tg() {
            return false;
        }

        public void e(RecyclerView recyclerView, int i, int i2) {
        }

        public int tg(View view) {
            return ((m) view.getLayoutParams()).tg();
        }

        public void vn(RecyclerView recyclerView) {
            bf(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void e(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void tg(int i, int i2) {
            View viewV = v(i);
            if (viewV != null) {
                p(i);
                d(viewV, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.zk.toString());
            }
        }

        public boolean e(m mVar) {
            return mVar != null;
        }

        public boolean e(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void e(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.zk = null;
                this.v = null;
                this.p = 0;
                this.f = 0;
            } else {
                this.zk = recyclerView;
                this.v = recyclerView.p;
                this.p = recyclerView.getWidth();
                this.f = recyclerView.getHeight();
            }
            this.ga = 1073741824;
            this.vn = 1073741824;
        }

        private boolean tg(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iLc = lc();
            int iA = a();
            int iWl = wl() - uk();
            int iZa = za() - fy();
            Rect rect = this.zk.wu;
            e(focusedChild, rect);
            return rect.left - i < iWl && rect.right - i > iLc && rect.top - i2 < iZa && rect.bottom - i2 > iA;
        }

        public final void bf(boolean z) {
            if (z != this.tg) {
                this.tg = z;
                this.w = 0;
                RecyclerView recyclerView = this.zk;
                if (recyclerView != null) {
                    recyclerView.ga.bf();
                }
            }
        }

        public void d(View view) {
            this.v.e(view);
        }

        public void bf(RecyclerView recyclerView) {
            this.t = true;
            d(recyclerView);
        }

        public void d(View view, int i) {
            e(view, i, (m) view.getLayoutParams());
        }

        public void d(w wVar) {
            for (int iPe = pe() - 1; iPe >= 0; iPe--) {
                if (!RecyclerView.ga(v(iPe)).p()) {
                    e(iPe, wVar);
                }
            }
        }

        public void bf(RecyclerView recyclerView, w wVar) {
            this.t = false;
            e(recyclerView, wVar);
        }

        public void e(Rect rect, int i, int i2) {
            ga(e(i, rect.width() + lc() + uk(), hb()), e(i2, rect.height() + a() + fy(), bx()));
        }

        public void bf(View view) {
            bf(view, -1);
        }

        public void bf(View view, int i) {
            e(view, i, false);
        }

        public View bf(int i) {
            int iPe = pe();
            for (int i2 = 0; i2 < iPe; i2++) {
                View viewV = v(i2);
                cv cvVarGa = RecyclerView.ga(viewV);
                if (cvVarGa != null && cvVarGa.v() == i && !cvVarGa.p() && (this.zk.fy.e() || !cvVarGa.pe())) {
                    return viewV;
                }
            }
            return null;
        }

        public static int e(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void bf(w wVar) {
            int iGa = wVar.ga();
            for (int i = iGa - 1; i >= 0; i--) {
                View viewTg = wVar.tg(i);
                cv cvVarGa = RecyclerView.ga(viewTg);
                if (!cvVarGa.p()) {
                    cvVarGa.e(false);
                    if (cvVarGa.y()) {
                        this.zk.removeDetachedView(viewTg, false);
                    }
                    vn vnVar = this.zk.za;
                    if (vnVar != null) {
                        vnVar.tg(cvVarGa);
                    }
                    cvVarGa.e(true);
                    wVar.bf(viewTg);
                }
            }
            wVar.vn();
            if (iGa > 0) {
                this.zk.invalidate();
            }
        }

        public void e(String str) {
            RecyclerView recyclerView = this.zk;
            if (recyclerView != null) {
                recyclerView.e(str);
            }
        }

        public boolean e() {
            return this.s;
        }

        public void e(RecyclerView recyclerView, w wVar) {
            tg(recyclerView);
        }

        public void e(w wVar, dt dtVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public m e(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof m) {
                return new m((m) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public m e(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        public void e(RecyclerView recyclerView, dt dtVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void e(k kVar) {
            k kVar2 = this.xu;
            if (kVar2 != null && kVar != kVar2 && kVar2.v()) {
                this.xu.vn();
            }
            this.xu = kVar;
            kVar.e(this.zk, this);
        }

        private static boolean bf(int i, int i2, int i3) {
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

        private int[] bf(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iLc = lc();
            int iA = a();
            int iWl = wl() - uk();
            int iZa = za() - fy();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iLc;
            int iMin = Math.min(0, i);
            int i2 = top - iA;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iWl;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iZa);
            if (k() != 1) {
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

        public void e(View view) {
            e(view, -1);
        }

        public void e(View view, int i) {
            e(view, i, true);
        }

        private void e(View view, int i, boolean z) {
            cv cvVarGa = RecyclerView.ga(view);
            if (!z && !cvVarGa.pe()) {
                this.zk.v.vn(cvVarGa);
            } else {
                this.zk.v.ga(cvVarGa);
            }
            m mVar = (m) view.getLayoutParams();
            if (!cvVarGa.s() && !cvVarGa.bh()) {
                if (view.getParent() == this.zk) {
                    int iBf = this.v.bf(view);
                    if (i == -1) {
                        i = this.v.bf();
                    }
                    if (iBf == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.zk.indexOfChild(view) + this.zk.e());
                    }
                    if (iBf != i) {
                        this.zk.t.tg(iBf, i);
                    }
                } else {
                    this.v.e(view, i, false);
                    mVar.d = true;
                    k kVar = this.xu;
                    if (kVar != null && kVar.v()) {
                        this.xu.bf(view);
                    }
                }
            } else {
                if (cvVarGa.bh()) {
                    cvVarGa.t();
                } else {
                    cvVarGa.w();
                }
                this.v.e(view, i, view.getLayoutParams(), false);
            }
            if (mVar.tg) {
                cvVarGa.tg.invalidate();
                mVar.tg = false;
            }
        }

        public void bf(k kVar) {
            if (this.xu == kVar) {
                this.xu = null;
            }
        }

        private void e(int i, View view) {
            this.v.ga(i);
        }

        public void e(View view, int i, m mVar) {
            cv cvVarGa = RecyclerView.ga(view);
            if (cvVarGa.pe()) {
                this.zk.v.ga(cvVarGa);
            } else {
                this.zk.v.vn(cvVarGa);
            }
            this.v.e(view, i, mVar, cvVarGa.pe());
        }

        public void e(View view, w wVar) {
            d(view);
            wVar.e(view);
        }

        public void e(int i, w wVar) {
            View viewV = v(i);
            vn(i);
            wVar.e(viewV);
        }

        public void e(w wVar) {
            for (int iPe = pe() - 1; iPe >= 0; iPe--) {
                e(wVar, iPe, v(iPe));
            }
        }

        private void e(w wVar, int i, View view) {
            cv cvVarGa = RecyclerView.ga(view);
            if (cvVarGa.p()) {
                return;
            }
            if (cvVarGa.f() && !cvVarGa.pe() && !this.zk.bh.bf()) {
                vn(i);
                wVar.bf(cvVarGa);
            } else {
                p(i);
                wVar.d(view);
                this.zk.v.v(cvVarGa);
            }
        }

        public boolean e(View view, int i, int i2, m mVar) {
            return (!view.isLayoutRequested() && this.d && bf(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) mVar).width) && bf(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) mVar).height)) ? false : true;
        }

        public void e(View view, int i, int i2) {
            m mVar = (m) view.getLayoutParams();
            Rect rectWu = this.zk.wu(view);
            int i3 = i + rectWu.left + rectWu.right;
            int i4 = i2 + rectWu.top + rectWu.bottom;
            int iE = e(wl(), y(), lc() + uk() + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) mVar).width, d());
            int iE2 = e(za(), cv(), a() + fy() + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) mVar).height, tg());
            if (e(view, iE, iE2, mVar)) {
                view.measure(iE, iE2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int e(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2e
                if (r5 == r2) goto L20
                if (r5 == 0) goto L2e
                if (r5 == r3) goto L20
                goto L2e
            L1a:
                if (r7 < 0) goto L1e
            L1c:
                r5 = r3
                goto L30
            L1e:
                if (r7 != r1) goto L22
            L20:
                r7 = r4
                goto L30
            L22:
                if (r7 != r0) goto L2e
                if (r5 == r2) goto L2b
                if (r5 == r3) goto L2b
                r7 = r4
                r5 = r6
                goto L30
            L2b:
                r7 = r4
                r5 = r2
                goto L30
            L2e:
                r5 = r6
                r7 = r5
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.zk.e(int, int, int, int, boolean):int");
        }

        public void e(View view, int i, int i2, int i3, int i4) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.bf;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public void e(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((m) view.getLayoutParams()).bf;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.zk != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.zk.xu;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void e(View view, Rect rect) {
            RecyclerView.e(view, rect);
        }

        public boolean e(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return e(recyclerView, view, rect, z, false);
        }

        public boolean e(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrBf = bf(recyclerView, view, rect, z);
            int i = iArrBf[0];
            int i2 = iArrBf[1];
            if ((z2 && !tg(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.e(i, i2);
            }
            return true;
        }

        @Deprecated
        public boolean e(RecyclerView recyclerView, View view, View view2) {
            return f() || recyclerView.t();
        }

        public boolean e(RecyclerView recyclerView, dt dtVar, View view, View view2) {
            return e(recyclerView, view, view2);
        }

        public void e(RecyclerView recyclerView, int i, int i2, Object obj) {
            d(recyclerView, i, i2);
        }

        public void e(w wVar, dt dtVar, int i, int i2) {
            this.zk.ga(i, i2);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        i = new Class[]{Context.class, AttributeSet.class, cls, cls};
        r = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void a() {
        this.lc.bf();
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.bm();
        }
    }

    private void b() {
        dt dtVar = this.fy;
        dtVar.bh = -1L;
        dtVar.xu = -1;
        dtVar.t = -1;
    }

    private void bm() {
        View focusedChild = (this.zr && hasFocus() && this.bh != null) ? getFocusedChild() : null;
        cv cvVarTg = focusedChild != null ? tg(focusedChild) : null;
        if (cvVarTg == null) {
            b();
            return;
        }
        this.fy.bh = this.bh.bf() ? cvVarTg.wu() : -1L;
        this.fy.xu = this.cv ? -1 : cvVarTg.pe() ? cvVarTg.p : cvVarTg.zk();
        this.fy.t = s(cvVarTg.tg);
    }

    private void bx() {
        boolean z;
        if (this.cv) {
            this.vn.e();
            if (this.wl) {
                this.t.ga(this);
            }
        }
        if (hb()) {
            this.vn.bf();
        } else {
            this.vn.ga();
        }
        boolean z2 = false;
        boolean z3 = this.h || this.x;
        this.fy.m = this.k && this.za != null && ((z = this.cv) || z3 || this.t.bh) && (!z || this.bh.bf());
        dt dtVar = this.fy;
        if (dtVar.m && z3 && !this.cv && hb()) {
            z2 = true;
        }
        dtVar.wu = z2;
    }

    private void fy() {
        VelocityTracker velocityTracker = this.tx;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        m(0);
        uk();
    }

    private void ga(cv cvVar) {
        View view = cvVar.tg;
        boolean z = view.getParent() == this;
        this.ga.d(bf(view));
        if (cvVar.y()) {
            this.p.e(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.p.tg(view);
        } else {
            this.p.e(view, true);
        }
    }

    private com.bytedance.sdk.component.widget.recycler.e.d.tg getScrollingChildHelper() {
        if (this.jk == null) {
            this.jk = new com.bytedance.sdk.component.widget.recycler.e.d.tg(this);
        }
        return this.jk;
    }

    private void h() {
        fy();
        setScrollState(0);
    }

    private boolean hb() {
        return this.za != null && this.t.t();
    }

    private void j() {
        this.fy.e(4);
        ga();
        xu();
        dt dtVar = this.fy;
        dtVar.tg = 1;
        if (dtVar.m) {
            for (int iBf = this.p.bf() - 1; iBf >= 0; iBf--) {
                cv cvVarGa = ga(this.p.bf(iBf));
                if (!cvVarGa.p()) {
                    long jE = e(cvVarGa);
                    vn.d dVarE = this.za.e(this.fy, cvVarGa);
                    cv cvVarE = this.v.e(jE);
                    if (cvVarE == null || cvVarE.p()) {
                        this.v.d(cvVarGa, dVarE);
                    } else {
                        boolean zE = this.v.e(cvVarE);
                        boolean zE2 = this.v.e(cvVarGa);
                        if (zE && cvVarE == cvVarGa) {
                            this.v.d(cvVarGa, dVarE);
                        } else {
                            vn.d dVarBf = this.v.bf(cvVarE);
                            this.v.d(cvVarGa, dVarE);
                            vn.d dVarD = this.v.d(cvVarGa);
                            if (dVarBf == null) {
                                e(jE, cvVarGa, cvVarE);
                            } else {
                                e(cvVarE, cvVarGa, dVarBf, dVarD, zE, zE2);
                            }
                        }
                    }
                }
            }
            this.v.e(this.aq);
        }
        this.t.bf(this.ga);
        dt dtVar2 = this.fy;
        dtVar2.bf = dtVar2.ga;
        this.cv = false;
        this.wl = false;
        dtVar2.m = false;
        dtVar2.wu = false;
        this.t.bh = false;
        ArrayList<cv> arrayList = this.ga.bf;
        if (arrayList != null) {
            arrayList.clear();
        }
        zk zkVar = this.t;
        if (zkVar.l) {
            zkVar.w = 0;
            zkVar.l = false;
            this.ga.bf();
        }
        this.t.bf(this.fy);
        bh();
        e(false);
        this.v.e();
        int[] iArr = this.as;
        if (wu(iArr[0], iArr[1])) {
            zk(0, 0);
        }
        rm();
        b();
    }

    private boolean lc() {
        int iBf = this.p.bf();
        for (int i2 = 0; i2 < iBf; i2++) {
            cv cvVarGa = ga(this.p.bf(i2));
            if (cvVarGa != null && !cvVarGa.p() && cvVarGa.h()) {
                return true;
            }
        }
        return false;
    }

    private void q() {
        this.fy.e(1);
        e(this.fy);
        this.fy.zk = false;
        ga();
        this.v.e();
        xu();
        bx();
        bm();
        dt dtVar = this.fy;
        dtVar.v = dtVar.m && this.x;
        this.x = false;
        this.h = false;
        dtVar.p = dtVar.wu;
        dtVar.ga = this.bh.e();
        e(this.as);
        if (this.fy.m) {
            int iBf = this.p.bf();
            for (int i2 = 0; i2 < iBf; i2++) {
                cv cvVarGa = ga(this.p.bf(i2));
                if (!cvVarGa.p() && (!cvVarGa.f() || this.bh.bf())) {
                    this.v.e(cvVarGa, this.za.e(this.fy, cvVarGa, vn.ga(cvVarGa), cvVarGa.za()));
                    if (this.fy.v && cvVarGa.h() && !cvVarGa.pe() && !cvVarGa.p() && !cvVarGa.f()) {
                        this.v.e(e(cvVarGa), cvVarGa);
                    }
                }
            }
        }
        if (this.fy.wu) {
            f();
            dt dtVar2 = this.fy;
            boolean z = dtVar2.vn;
            dtVar2.vn = false;
            this.t.e(this.ga, dtVar2);
            this.fy.vn = z;
            for (int i3 = 0; i3 < this.p.bf(); i3++) {
                cv cvVarGa2 = ga(this.p.bf(i3));
                if (!cvVarGa2.p() && !this.v.tg(cvVarGa2)) {
                    int iGa = vn.ga(cvVarGa2);
                    boolean zE = cvVarGa2.e(8192);
                    if (!zE) {
                        iGa |= 4096;
                    }
                    vn.d dVarE = this.za.e(this.fy, cvVarGa2, iGa, cvVarGa2.za());
                    if (zE) {
                        e(cvVarGa2, dVarE);
                    } else {
                        this.v.bf(cvVarGa2, dVarE);
                    }
                }
            }
            k();
        } else {
            k();
        }
        bh();
        e(false);
        this.fy.tg = 2;
    }

    private View r() {
        cv cvVarGa;
        dt dtVar = this.fy;
        int i2 = dtVar.xu;
        if (i2 == -1) {
            i2 = 0;
        }
        int iTg = dtVar.tg();
        for (int i3 = i2; i3 < iTg; i3++) {
            cv cvVarGa2 = ga(i3);
            if (cvVarGa2 == null) {
                break;
            }
            if (cvVarGa2.tg.hasFocusable()) {
                return cvVarGa2.tg;
            }
        }
        int iMin = Math.min(iTg, i2);
        do {
            iMin--;
            if (iMin < 0 || (cvVarGa = ga(iMin)) == null) {
                return null;
            }
        } while (!cvVarGa.tg.hasFocusable());
        return cvVarGa.tg;
    }

    private void rm() {
        View viewFindViewById;
        if (!this.zr || this.bh == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!j || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.p.d(focusedChild)) {
                    return;
                }
            } else if (this.p.bf() == 0) {
                requestFocus();
                return;
            }
        }
        View viewR = null;
        cv cvVarE = (this.fy.bh == -1 || !this.bh.bf()) ? null : e(this.fy.bh);
        if (cvVarE != null && !this.p.d(cvVarE.tg) && cvVarE.tg.hasFocusable()) {
            viewR = cvVarE.tg;
        } else if (this.p.bf() > 0) {
            viewR = r();
        }
        if (viewR != null) {
            int i2 = this.fy.t;
            if (i2 != -1 && (viewFindViewById = viewR.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewR = viewFindViewById;
            }
            viewR.requestFocus();
        }
    }

    private void rt() {
        ga();
        xu();
        this.fy.e(6);
        this.vn.ga();
        this.fy.ga = this.bh.e();
        dt dtVar = this.fy;
        dtVar.d = 0;
        dtVar.p = false;
        this.t.e(this.ga, dtVar);
        dt dtVar2 = this.fy;
        dtVar2.vn = false;
        dtVar2.m = dtVar2.m && this.za != null;
        dtVar2.tg = 4;
        bh();
        e(false);
    }

    private void uk() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.vu;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.vu.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.z;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.z.isFinished();
        }
        EdgeEffect edgeEffect3 = this.ev;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.ev.isFinished();
        }
        EdgeEffect edgeEffect4 = this.vs;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.vs.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.e.d.p.d(this);
        }
    }

    @SuppressLint({"InlinedApi"})
    private void wl() {
        if (com.bytedance.sdk.component.widget.recycler.e.d.p.zk(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.e.d.p.bf(this, 8);
        }
    }

    private void x() {
        this.fl = 0;
    }

    private void za() {
        this.p = new com.bytedance.sdk.component.widget.recycler.bf(new bf.InterfaceC0108bf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public View bf(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void d(int i2) {
                cv cvVarGa;
                View viewBf = bf(i2);
                if (viewBf != null && (cvVarGa = RecyclerView.ga(viewBf)) != null) {
                    if (cvVarGa.y() && !cvVarGa.p()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + cvVarGa + RecyclerView.this.e());
                    }
                    cvVarGa.bf(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public int e() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void tg(View view) {
                cv cvVarGa = RecyclerView.ga(view);
                if (cvVarGa != null) {
                    cvVarGa.bf(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void bf() {
                int iE = e();
                for (int i2 = 0; i2 < iE; i2++) {
                    View viewBf = bf(i2);
                    RecyclerView.this.bh(viewBf);
                    viewBf.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void e(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.t(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public int e(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void e(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.bh(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public cv bf(View view) {
                return RecyclerView.ga(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void d(View view) {
                cv cvVarGa = RecyclerView.ga(view);
                if (cvVarGa != null) {
                    cvVarGa.e(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.bf.InterfaceC0108bf
            public void e(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                cv cvVarGa = RecyclerView.ga(view);
                if (cvVarGa != null) {
                    if (!cvVarGa.y() && !cvVarGa.p()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + cvVarGa + RecyclerView.this.e());
                    }
                    cvVarGa.l();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        zk zkVar = this.t;
        if (zkVar == null || !zkVar.e(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void bf() {
        this.vn = new com.bytedance.sdk.component.widget.recycler.e(new e.InterfaceC0109e() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void bf(int i2, int i3) {
                RecyclerView.this.e(i2, i3, false);
                RecyclerView.this.h = true;
            }

            public void d(e.bf bfVar) {
                int i2 = bfVar.e;
                if (i2 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.t.e(recyclerView, bfVar.bf, bfVar.tg);
                    return;
                }
                if (i2 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.t.bf(recyclerView2, bfVar.bf, bfVar.tg);
                } else if (i2 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.t.e(recyclerView3, bfVar.bf, bfVar.tg, bfVar.d);
                } else {
                    if (i2 != 8) {
                        return;
                    }
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.t.e(recyclerView4, bfVar.bf, bfVar.tg, 1);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public cv e(int i2) {
                cv cvVarE = RecyclerView.this.e(i2, true);
                if (cvVarE == null || RecyclerView.this.p.d(cvVarE.tg)) {
                    return null;
                }
                return cvVarE;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void tg(int i2, int i3) {
                RecyclerView.this.vn(i2, i3);
                RecyclerView.this.h = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void bf(e.bf bfVar) {
                d(bfVar);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void e(int i2, int i3) {
                RecyclerView.this.e(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.h = true;
                recyclerView.fy.d += i3;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void d(int i2, int i3) {
                RecyclerView.this.p(i2, i3);
                RecyclerView.this.h = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void e(int i2, int i3, Object obj) {
                RecyclerView.this.e(i2, i3, obj);
                RecyclerView.this.x = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.e.InterfaceC0109e
            public void e(e.bf bfVar) {
                d(bfVar);
            }
        });
    }

    public void bh() {
        bf(true);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.t.e((m) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.d()) {
            return this.t.ga(this.fy);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.d()) {
            return this.t.d(this.fy);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.d()) {
            return this.t.p(this.fy);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.tg()) {
            return this.t.vn(this.fy);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.tg()) {
            return this.t.tg(this.fy);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        zk zkVar = this.t;
        if (zkVar != null && zkVar.tg()) {
            return this.t.v(this.fy);
        }
        return 0;
    }

    public void cv() {
        int i2;
        for (int size = this.f2099b.size() - 1; size >= 0; size--) {
            cv cvVar = this.f2099b.get(size);
            if (cvVar.tg.getParent() == this && !cvVar.p() && (i2 = cvVar.f) != -1) {
                com.bytedance.sdk.component.widget.recycler.e.d.p.e(cvVar.tg, i2);
                cvVar.f = -1;
            }
        }
        this.f2099b.clear();
    }

    public void d() {
        vn vnVar = this.za;
        if (vnVar != null) {
            vnVar.tg();
        }
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.d(this.ga);
            this.t.bf(this.ga);
        }
        this.ga.e();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().e(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().e(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().e(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.w.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.w.get(i2).bf(canvas, this, this.fy);
        }
        EdgeEffect edgeEffect = this.vu;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.zk ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.vu;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.z;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.zk) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.z;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.ev;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.zk ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.ev;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.vs;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.zk) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.vs;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.za == null || this.w.size() <= 0 || !this.za.bf()) ? z : true) {
            com.bytedance.sdk.component.widget.recycler.e.d.p.d(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void dt() {
        int iD = this.p.d();
        for (int i2 = 0; i2 < iD; i2++) {
            cv cvVarGa = ga(this.p.tg(i2));
            if (cvVarGa != null && !cvVarGa.p()) {
                cvVarGa.bf(6);
            }
        }
        l();
        this.ga.v();
    }

    public void f() {
        int iD = this.p.d();
        for (int i2 = 0; i2 < iD; i2++) {
            cv cvVarGa = ga(this.p.tg(i2));
            if (!cvVarGa.p()) {
                cvVarGa.vn();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewE;
        boolean z;
        View viewTg = this.t.tg(view, i2);
        if (viewTg != null) {
            return viewTg;
        }
        boolean z2 = (this.bh == null || this.t == null || t() || this.pe) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.t.tg()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (rt) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.t.d()) {
                int i4 = (this.t.k() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i4) == null;
                if (rt) {
                    i2 = i4;
                }
                z = z3;
            }
            if (z) {
                tg();
                if (d(view) == null) {
                    return null;
                }
                ga();
                this.t.e(view, i2, this.ga, this.fy);
                e(false);
            }
            viewE = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z2) {
                tg();
                if (d(view) == null) {
                    return null;
                }
                ga();
                viewE = this.t.e(view, i2, this.ga, this.fy);
                e(false);
            } else {
                viewE = viewFindNextFocus;
            }
        }
        if (viewE == null || viewE.hasFocusable()) {
            return e(view, viewE, i2) ? viewE : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        e(viewE, (View) null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        zk zkVar = this.t;
        if (zkVar != null) {
            return zkVar.bf();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + e());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        zk zkVar = this.t;
        if (zkVar != null) {
            return zkVar.e(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + e());
    }

    public e getAdapter() {
        return this.bh;
    }

    @Override // android.view.View
    public int getBaseline() {
        zk zkVar = this.t;
        return zkVar != null ? zkVar.dt() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        tg tgVar = this.in;
        return tgVar == null ? super.getChildDrawingOrder(i2, i3) : tgVar.e(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.zk;
    }

    public ga getEdgeEffectFactory() {
        return this.ov;
    }

    public vn getItemAnimator() {
        return this.za;
    }

    public int getItemDecorationCount() {
        return this.w.size();
    }

    public zk getLayoutManager() {
        return this.t;
    }

    public int getMaxFlingVelocity() {
        return this.tu;
    }

    public int getMinFlingVelocity() {
        return this.vg;
    }

    public long getNanoTime() {
        if (tg) {
            return System.nanoTime();
        }
        return 0L;
    }

    public xu getOnFlingListener() {
        return this.sq;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.zr;
    }

    public s getRecycledViewPool() {
        return this.ga.p();
    }

    public int getScrollState() {
        return this.em;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().bf();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.l;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().e();
    }

    public void k() {
        int iD = this.p.d();
        for (int i2 = 0; i2 < iD; i2++) {
            cv cvVarGa = ga(this.p.tg(i2));
            if (!cvVarGa.p()) {
                cvVarGa.ga();
            }
        }
        this.ga.zk();
    }

    public void l() {
        int iD = this.p.d();
        for (int i2 = 0; i2 < iD; i2++) {
            ((m) this.p.tg(i2).getLayoutParams()).d = true;
        }
        this.ga.m();
    }

    public void m(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.ue = r0
            r1 = 1
            r5.l = r1
            boolean r2 = r5.k
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.k = r1
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r1 = r5.t
            if (r1 == 0) goto L1e
            r1.bf(r5)
        L1e:
            r5.hb = r0
            boolean r0 = com.bytedance.sdk.component.widget.recycler.RecyclerView.tg
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<com.bytedance.sdk.component.widget.recycler.tg> r0 = com.bytedance.sdk.component.widget.recycler.tg.e
            java.lang.Object r1 = r0.get()
            com.bytedance.sdk.component.widget.recycler.tg r1 = (com.bytedance.sdk.component.widget.recycler.tg) r1
            r5.f2098a = r1
            if (r1 != 0) goto L5c
            com.bytedance.sdk.component.widget.recycler.tg r1 = new com.bytedance.sdk.component.widget.recycler.tg
            r1.<init>()
            r5.f2098a = r1
            android.view.Display r1 = com.bytedance.sdk.component.widget.recycler.e.d.p.p(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            com.bytedance.sdk.component.widget.recycler.tg r2 = r5.f2098a
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.tg = r3
            r0.set(r2)
        L5c:
            com.bytedance.sdk.component.widget.recycler.tg r0 = r5.f2098a
            r0.e(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.tg tgVar;
        super.onDetachedFromWindow();
        vn vnVar = this.za;
        if (vnVar != null) {
            vnVar.tg();
        }
        vn();
        this.l = false;
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.bf(this, this.ga);
        }
        this.f2099b.clear();
        removeCallbacks(this.br);
        this.v.bf();
        if (!tg || (tgVar = this.f2098a) == null) {
            return;
        }
        tgVar.bf(this);
        this.f2098a = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.w.get(i2).e(canvas, this, this.fy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r0 = r5.t
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.pe
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r0 = r5.t
            boolean r0 = r0.tg()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r3 = r5.t
            boolean r3 = r3.d()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r3 = r5.t
            boolean r3 = r3.tg()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$zk r3 = r5.t
            boolean r3 = r3.d()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.zo
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.lg
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.e(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.pe) {
            return false;
        }
        if (e(motionEvent)) {
            h();
            return true;
        }
        zk zkVar = this.t;
        if (zkVar == null) {
            return false;
        }
        boolean zD = zkVar.d();
        boolean zTg = this.t.tg();
        if (this.tx == null) {
            this.tx = VelocityTracker.obtain();
        }
        this.tx.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.ya) {
                this.ya = false;
            }
            this.g = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.xn = x;
            this.pl = x;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.lw = y2;
            this.zb = y2;
            if (this.em == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.ys;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zD;
            if (zTg) {
                i2 = (zD ? 1 : 0) | 2;
            }
            m(i2, 0);
        } else if (actionMasked == 1) {
            this.tx.clear();
            m(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.g);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.g + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.em != 1) {
                int i3 = x2 - this.pl;
                int i4 = y3 - this.zb;
                if (!zD || Math.abs(i3) <= this.xy) {
                    z = false;
                } else {
                    this.xn = x2;
                    z = true;
                }
                if (zTg && Math.abs(i4) > this.xy) {
                    this.lw = y3;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            h();
        } else if (actionMasked == 5) {
            this.g = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.xn = x3;
            this.pl = x3;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.lw = y4;
            this.zb = y4;
        } else if (actionMasked == 6) {
            d(motionEvent);
        }
        return this.em == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV OnLayout");
        w();
        com.bytedance.sdk.component.widget.recycler.e.e.e.e();
        this.k = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        zk zkVar = this.t;
        if (zkVar == null) {
            ga(i2, i3);
            return;
        }
        boolean z = false;
        if (zkVar.e()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.t.e(this.ga, this.fy, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.bh == null) {
                return;
            }
            if (this.fy.tg == 1) {
                q();
            }
            this.t.bf(i2, i3);
            this.fy.zk = true;
            rt();
            this.t.d(i2, i3);
            if (this.t.zk()) {
                this.t.bf(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.fy.zk = true;
                rt();
                this.t.d(i2, i3);
                return;
            }
            return;
        }
        if (this.f) {
            this.t.e(this.ga, this.fy, i2, i3);
            return;
        }
        if (this.y) {
            ga();
            xu();
            bx();
            bh();
            dt dtVar = this.fy;
            if (dtVar.wu) {
                dtVar.p = true;
            } else {
                this.vn.ga();
                this.fy.p = false;
            }
            this.y = false;
            e(false);
        } else if (this.fy.wu) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        e eVar = this.bh;
        if (eVar != null) {
            this.fy.ga = eVar.e();
        } else {
            this.fy.ga = 0;
        }
        ga();
        this.t.e(this.ga, this.fy, i2, i3);
        e(false);
        this.fy.p = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (t()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        wu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0107  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p() {
        if (this.vu == null) {
            EdgeEffect edgeEffectE = this.ov.e(this, 0);
            this.vu = edgeEffectE;
            if (this.zk) {
                edgeEffectE.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectE.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public boolean pe() {
        return !this.k || this.cv || this.vn.tg();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        cv cvVarGa = ga(view);
        if (cvVarGa != null) {
            if (cvVarGa.y()) {
                cvVarGa.l();
            } else if (!cvVarGa.p()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + cvVarGa + e());
            }
        }
        view.clearAnimation();
        bh(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.t.e(this, this.fy, view, view2) && view2 != null) {
            e(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.t.e(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.ot.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ot.get(i2).e(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.nt != 0 || this.pe) {
            this.dt = true;
        } else {
            super.requestLayout();
        }
    }

    public void s() {
        if (this.hb || !this.l) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.e.d.p.e(this, this.br);
        this.hb = true;
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        zk zkVar = this.t;
        if (zkVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.pe) {
            return;
        }
        boolean zD = zkVar.d();
        boolean zTg = this.t.tg();
        if (zD || zTg) {
            if (!zD) {
                i2 = 0;
            }
            if (!zTg) {
                i3 = 0;
            }
            e(i2, i3, (MotionEvent) null);
        }
    }

    public void setAdapter(e eVar) {
        setLayoutFrozen(false);
        e(eVar, false, true);
        d(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(tg tgVar) {
        if (tgVar != this.in) {
            this.in = tgVar;
            setChildrenDrawingOrderEnabled(tgVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.zk) {
            wu();
        }
        this.zk = z;
        super.setClipToPadding(z);
        if (this.k) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(ga gaVar) {
        e(gaVar);
        this.ov = gaVar;
        wu();
    }

    public void setHasFixedSize(boolean z) {
        this.f = z;
    }

    public void setItemAnimator(vn vnVar) {
        vn vnVar2 = this.za;
        if (vnVar2 != null) {
            vnVar2.tg();
            this.za.e((vn.bf) null);
        }
        this.za = vnVar;
        if (vnVar != null) {
            vnVar.e(this.c);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.ga.e(i2);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.pe) {
            e("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.pe = true;
                this.ya = true;
                vn();
                return;
            }
            this.pe = false;
            if (this.dt && this.t != null && this.bh != null) {
                requestLayout();
            }
            this.dt = false;
        }
    }

    public void setLayoutManager(zk zkVar) {
        if (zkVar != this.t) {
            vn();
            if (this.t != null) {
                vn vnVar = this.za;
                if (vnVar != null) {
                    vnVar.tg();
                }
                this.t.d(this.ga);
                this.t.bf(this.ga);
                this.ga.e();
                if (this.l) {
                    this.t.bf(this, this.ga);
                }
                this.t.e((RecyclerView) null);
                this.t = null;
            } else {
                this.ga.e();
            }
            this.p.e();
            this.t = zkVar;
            if (zkVar != null) {
                if (zkVar.zk != null) {
                    throw new IllegalArgumentException("LayoutManager " + zkVar + " is already attached to a RecyclerView:" + zkVar.zk.e());
                }
                zkVar.e(this);
                if (this.l) {
                    this.t.bf(this);
                }
            }
            this.ga.bf();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().e(z);
    }

    public void setOnFlingListener(xu xuVar) {
        this.sq = xuVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.zr = z;
    }

    public void setRecycledViewPool(s sVar) {
        this.ga.e(sVar);
    }

    public void setRecyclerListener(l lVar) {
        this.s = lVar;
    }

    public void setScrollState(int i2) {
        if (i2 != this.em) {
            this.em = i2;
            if (i2 != 2) {
                a();
            }
            zk(i2);
        }
    }

    public void setViewCacheExtension(pe peVar) {
        this.ga.e(peVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().bf(i2);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.e.d.bf
    public void stopNestedScroll() {
        getScrollingChildHelper().d();
    }

    public boolean t() {
        return this.ue > 0;
    }

    public void tg() {
        if (!this.k || this.cv) {
            com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV FullInvalidate");
            w();
            com.bytedance.sdk.component.widget.recycler.e.e.e.e();
            return;
        }
        if (this.vn.tg()) {
            if (!this.vn.e(4) || this.vn.e(11)) {
                if (this.vn.tg()) {
                    com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV FullInvalidate");
                    w();
                    com.bytedance.sdk.component.widget.recycler.e.e.e.e();
                    return;
                }
                return;
            }
            com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV PartialInvalidate");
            ga();
            xu();
            this.vn.bf();
            if (!this.dt) {
                if (lc()) {
                    w();
                } else {
                    this.vn.d();
                }
            }
            e(true);
            bh();
            com.bytedance.sdk.component.widget.recycler.e.e.e.e();
        }
    }

    public void v(int i2) {
    }

    public void vn() {
        setScrollState(0);
        a();
    }

    public void w() {
        if (this.bh == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.t == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        dt dtVar = this.fy;
        dtVar.zk = false;
        if (dtVar.tg == 1) {
            q();
            this.t.vn(this);
            rt();
        } else if (!this.vn.vn() && this.t.wl() == getWidth() && this.t.za() == getHeight()) {
            this.t.vn(this);
        } else {
            this.t.vn(this);
            rt();
        }
        j();
    }

    public void wu() {
        this.vs = null;
        this.z = null;
        this.ev = null;
        this.vu = null;
    }

    public void xu() {
        this.ue++;
    }

    public void y() {
        cv cvVar;
        int iBf = this.p.bf();
        for (int i2 = 0; i2 < iBf; i2++) {
            View viewBf = this.p.bf(i2);
            cv cvVarBf = bf(viewBf);
            if (cvVarBf != null && (cvVar = cvVarBf.xu) != null) {
                View view = cvVar.tg;
                int left = viewBf.getLeft();
                int top = viewBf.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void zk(View view) {
    }

    public static class bf extends Observable<d> {
        public void e() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((d) ((Observable) this).mObservers.get(size)).e();
            }
        }

        public void e(int i, int i2) {
            e(i, i2, null);
        }

        public void e(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((d) ((Observable) this).mObservers.get(size)).e(i, i2, obj);
            }
        }
    }

    public static class dt {
        long bh;
        private SparseArray<Object> l;
        int s;
        int t;
        int w;
        int xu;
        int e = -1;
        int bf = 0;
        int d = 0;
        int tg = 1;
        int ga = 0;
        boolean vn = false;
        boolean p = false;
        boolean v = false;
        boolean zk = false;
        boolean m = false;
        boolean wu = false;

        public boolean bf() {
            return this.wu;
        }

        public boolean d() {
            return this.e != -1;
        }

        public void e(int i) {
            if ((this.tg & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.tg));
        }

        public int tg() {
            return this.p ? this.bf - this.d : this.ga;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.e + ", mData=" + this.l + ", mItemCount=" + this.ga + ", mIsMeasuring=" + this.zk + ", mPreviousLayoutItemCount=" + this.bf + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.vn + ", mInPreLayout=" + this.p + ", mRunSimpleAnimations=" + this.m + ", mRunPredictiveAnimations=" + this.wu + '}';
        }

        public void e(e eVar) {
            this.tg = 1;
            this.ga = eVar.e();
            this.p = false;
            this.v = false;
            this.zk = false;
        }

        public boolean e() {
            return this.p;
        }
    }

    public static class s {
        SparseArray<e> e = new SparseArray<>();
        private int bf = 0;

        public static class e {
            final ArrayList<cv> e = new ArrayList<>();
            int bf = 5;
            long d = 0;
            long tg = 0;
        }

        public void bf(int i, long j) {
            e eVarBf = bf(i);
            eVarBf.tg = e(eVarBf.tg, j);
        }

        public void d() {
            this.bf--;
        }

        public void e() {
            for (int i = 0; i < this.e.size(); i++) {
                this.e.valueAt(i).e.clear();
            }
        }

        public boolean bf(int i, long j, long j2) {
            long j3 = bf(i).tg;
            return j3 == 0 || j + j3 < j2;
        }

        public void bf() {
            this.bf++;
        }

        public cv e(int i) {
            e eVar = this.e.get(i);
            if (eVar == null || eVar.e.isEmpty()) {
                return null;
            }
            return eVar.e.remove(r2.size() - 1);
        }

        private e bf(int i) {
            e eVar = this.e.get(i);
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e();
            this.e.put(i, eVar2);
            return eVar2;
        }

        public void e(cv cvVar) {
            int iXu = cvVar.xu();
            ArrayList<cv> arrayList = bf(iXu).e;
            if (this.e.get(iXu).bf > arrayList.size()) {
                cvVar.lc();
                arrayList.add(cvVar);
            }
        }

        public long e(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }

        public void e(int i, long j) {
            e eVarBf = bf(i);
            eVarBf.d = e(eVarBf.d, j);
        }

        public boolean e(int i, long j, long j2) {
            long j3 = bf(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        public void e(e eVar, e eVar2, boolean z) {
            if (eVar != null) {
                d();
            }
            if (!z && this.bf == 0) {
                e();
            }
            if (eVar2 != null) {
                bf();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean wu(int i2, int i3) {
        e(this.as);
        int[] iArr = this.as;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    public static RecyclerView xu(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewXu = xu(viewGroup.getChildAt(i2));
            if (recyclerViewXu != null) {
                return recyclerViewXu;
            }
        }
        return null;
    }

    public void bf(t tVar) {
        List<t> list = this.rk;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void bh(View view) {
        cv cvVarGa = ga(view);
        m(view);
        e eVar = this.bh;
        if (eVar != null && cvVarGa != null) {
            eVar.tg(cvVarGa);
        }
        List<wu> list = this.yf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.yf.get(size).bf(view);
            }
        }
    }

    public void m() {
        if (this.vs == null) {
            EdgeEffect edgeEffectE = this.ov.e(this, 3);
            this.vs = edgeEffectE;
            if (this.zk) {
                edgeEffectE.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectE.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void t(View view) {
        cv cvVarGa = ga(view);
        zk(view);
        e eVar = this.bh;
        if (eVar != null && cvVarGa != null) {
            eVar.d(cvVarGa);
        }
        List<wu> list = this.yf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.yf.get(size).e(view);
            }
        }
    }

    public void v(int i2, int i3) {
    }

    public void zk() {
        if (this.z == null) {
            EdgeEffect edgeEffectE = this.ov.e(this, 1);
            this.z = edgeEffectE;
            if (this.zk) {
                edgeEffectE.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectE.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.yl = new f();
        this.ga = new w();
        this.v = new com.bytedance.sdk.component.widget.recycler.t();
        this.m = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.k || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.l) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.pe) {
                    recyclerView2.dt = true;
                } else {
                    recyclerView2.tg();
                }
            }
        };
        this.wu = new Rect();
        this.rb = new Rect();
        this.xu = new RectF();
        this.w = new ArrayList<>();
        this.ot = new ArrayList<>();
        this.nt = 0;
        this.cv = false;
        this.wl = false;
        this.ue = 0;
        this.ft = 0;
        this.ov = new ga();
        this.za = new com.bytedance.sdk.component.widget.recycler.d();
        this.em = 0;
        this.g = -1;
        this.zo = Float.MIN_VALUE;
        this.lg = Float.MIN_VALUE;
        this.zr = true;
        this.lc = new y();
        this.uk = tg ? new tg.e() : null;
        this.fy = new dt();
        this.h = false;
        this.x = false;
        this.c = new p();
        this.hb = false;
        this.as = new int[2];
        this.rw = new int[2];
        this.bx = new int[2];
        this.ys = new int[2];
        this.bm = new int[2];
        this.f2099b = new ArrayList();
        this.br = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                vn vnVar = RecyclerView.this.za;
                if (vnVar != null) {
                    vnVar.e();
                }
                RecyclerView.this.hb = false;
            }
        };
        this.aq = new t.bf() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.t.bf
            public void bf(cv cvVar, vn.d dVar, vn.d dVar2) {
                RecyclerView.this.e(cvVar, dVar, dVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.bf
            public void d(cv cvVar, vn.d dVar, vn.d dVar2) {
                cvVar.e(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.cv) {
                    if (recyclerView.za.e(cvVar, cvVar, dVar, dVar2)) {
                        RecyclerView.this.s();
                    }
                } else if (recyclerView.za.d(cvVar, dVar, dVar2)) {
                    RecyclerView.this.s();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.bf
            public void e(cv cvVar, vn.d dVar, vn.d dVar2) {
                RecyclerView.this.ga.d(cvVar);
                RecyclerView.this.bf(cvVar, dVar, dVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.t.bf
            public void e(cv cvVar) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.t.e(cvVar.tg, recyclerView.ga);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q, i2, 0);
                this.zk = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            this.zk = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.xy = viewConfiguration.getScaledTouchSlop();
        this.zo = com.bytedance.sdk.component.widget.recycler.e.d.p.e(viewConfiguration, context);
        this.lg = com.bytedance.sdk.component.widget.recycler.e.d.p.bf(viewConfiguration, context);
        this.vg = viewConfiguration.getScaledMinimumFlingVelocity();
        this.tu = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.za.e(this.c);
        bf();
        za();
        wl();
        if (com.bytedance.sdk.component.widget.recycler.e.d.p.bf(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.e.d.p.e(this, 1);
        }
        this.uq = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        setNestedScrollingEnabled(true);
    }

    public void v() {
        if (this.ev == null) {
            EdgeEffect edgeEffectE = this.ov.e(this, 2);
            this.ev = edgeEffectE;
            if (this.zk) {
                edgeEffectE.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectE.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void vn(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iD = this.p.d();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iD; i8++) {
            cv cvVarGa = ga(this.p.tg(i8));
            if (cvVarGa != null && (i7 = cvVarGa.vn) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    cvVarGa.e(i3 - i2, false);
                } else {
                    cvVarGa.e(i6, false);
                }
                this.fy.vn = true;
            }
        }
        this.ga.e(i2, i3);
        requestLayout();
    }

    public static class m extends ViewGroup.MarginLayoutParams {
        final Rect bf;
        boolean d;
        cv e;
        boolean tg;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bf = new Rect();
            this.d = true;
            this.tg = false;
        }

        public boolean bf() {
            return this.e.pe();
        }

        public boolean d() {
            return this.e.h();
        }

        public boolean e() {
            return this.e.f();
        }

        public int tg() {
            return this.e.v();
        }

        public m(int i, int i2) {
            super(i, i2);
            this.bf = new Rect();
            this.d = true;
            this.tg = false;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.bf = new Rect();
            this.d = true;
            this.tg = false;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bf = new Rect();
            this.d = true;
            this.tg = false;
        }

        public m(m mVar) {
            super((ViewGroup.MarginLayoutParams) mVar);
            this.bf = new Rect();
            this.d = true;
            this.tg = false;
        }
    }

    private int s(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public void bf(int i2) {
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.tg(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        zk zkVar = this.t;
        if (zkVar != null) {
            return zkVar.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + e());
    }

    public Rect wu(View view) {
        m mVar = (m) view.getLayoutParams();
        if (!mVar.d) {
            return mVar.bf;
        }
        if (this.fy.e() && (mVar.d() || mVar.e())) {
            return mVar.bf;
        }
        Rect rect = mVar.bf;
        rect.set(0, 0, 0, 0);
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.wu.set(0, 0, 0, 0);
            this.w.get(i2).e(this.wu, view, this, this.fy);
            int i3 = rect.left;
            Rect rect2 = this.wu;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        mVar.d = false;
        return rect;
    }

    public class f extends d {
        public f() {
        }

        public void bf() {
            if (RecyclerView.d) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f && recyclerView.l) {
                    com.bytedance.sdk.component.widget.recycler.e.d.p.e(recyclerView, recyclerView.m);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.y = true;
            recyclerView2.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
        public void e() {
            RecyclerView.this.e((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.fy.vn = true;
            recyclerView.d(true);
            if (RecyclerView.this.vn.tg()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
        public void e(int i, int i2, Object obj) {
            RecyclerView.this.e((String) null);
            if (RecyclerView.this.vn.e(i, i2, obj)) {
                bf();
            }
        }
    }

    public String e() {
        return " " + super.toString() + ", adapter:" + this.bh + ", layout:" + this.t + ", context:" + getContext();
    }

    private void e(e eVar, boolean z, boolean z2) {
        e eVar2 = this.bh;
        if (eVar2 != null) {
            eVar2.bf(this.yl);
            this.bh.bf(this);
        }
        if (!z || z2) {
            d();
        }
        this.vn.e();
        e eVar3 = this.bh;
        this.bh = eVar;
        if (eVar != null) {
            eVar.e(this.yl);
            eVar.e(this);
        }
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.e(eVar3, this.bh);
        }
        this.ga.e(eVar3, this.bh, z);
        this.fy.vn = true;
    }

    public void p(int i2, int i3) {
        int iD = this.p.d();
        for (int i4 = 0; i4 < iD; i4++) {
            cv cvVarGa = ga(this.p.tg(i4));
            if (cvVarGa != null && !cvVarGa.p() && cvVarGa.vn >= i2) {
                cvVarGa.e(i3, false);
                this.fy.vn = true;
            }
        }
        this.ga.bf(i2, i3);
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean bf(int i2, int i3) {
        zk zkVar = this.t;
        if (zkVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.pe) {
            return false;
        }
        int iD = zkVar.d();
        boolean zTg = this.t.tg();
        if (iD == 0 || Math.abs(i2) < this.vg) {
            i2 = 0;
        }
        if (!zTg || Math.abs(i3) < this.vg) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = iD != 0 || zTg;
            dispatchNestedFling(f2, f3, z);
            xu xuVar = this.sq;
            if (xuVar != null && xuVar.e(i2, i3)) {
                return true;
            }
            if (z) {
                if (zTg) {
                    iD = (iD == true ? 1 : 0) | 2;
                }
                m(iD, 1);
                int i4 = this.tu;
                int iMax = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.tu;
                this.lc.e(iMax, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    public void d(int i2) {
        if (this.pe) {
            return;
        }
        zk zkVar = this.t;
        if (zkVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            zkVar.e(this, this.fy, i2);
        }
    }

    public boolean m(int i2, int i3) {
        return getScrollingChildHelper().e(i2, i3);
    }

    public void zk(int i2, int i3) {
        this.ft++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        v(i2, i3);
        t tVar = this.tv;
        if (tVar != null) {
            tVar.e(this, i2, i3);
        }
        List<t> list = this.rk;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.rk.get(size).e(this, i2, i3);
            }
        }
        this.ft--;
    }

    public void ga() {
        int i2 = this.nt + 1;
        this.nt = i2;
        if (i2 != 1 || this.pe) {
            return;
        }
        this.dt = false;
    }

    public void m(int i2) {
        getScrollingChildHelper().d(i2);
    }

    public int v(View view) {
        cv cvVarGa = ga(view);
        if (cvVarGa != null) {
            return cvVarGa.v();
        }
        return -1;
    }

    public void d(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.vu;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.vu.onRelease();
            zIsFinished = this.vu.isFinished();
        }
        EdgeEffect edgeEffect2 = this.ev;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.ev.onRelease();
            zIsFinished |= this.ev.isFinished();
        }
        EdgeEffect edgeEffect3 = this.z;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.z.onRelease();
            zIsFinished |= this.z.isFinished();
        }
        EdgeEffect edgeEffect4 = this.vs;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.vs.onRelease();
            zIsFinished |= this.vs.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.e.d.p.d(this);
        }
    }

    public void ga(int i2, int i3) {
        setMeasuredDimension(zk.e(i2, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.e.d.p.tg(this)), zk.e(i3, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.e.d.p.ga(this)));
    }

    @Deprecated
    public int vn(View view) {
        return p(view);
    }

    public void vn(int i2) {
        int iBf = this.p.bf();
        for (int i3 = 0; i3 < iBf; i3++) {
            this.p.bf(i3).offsetTopAndBottom(i2);
        }
    }

    public int p(View view) {
        cv cvVarGa = ga(view);
        if (cvVarGa != null) {
            return cvVarGa.zk();
        }
        return -1;
    }

    public static cv ga(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).e;
    }

    public cv ga(int i2) {
        cv cvVar = null;
        if (this.cv) {
            return null;
        }
        int iD = this.p.d();
        for (int i3 = 0; i3 < iD; i3++) {
            cv cvVarGa = ga(this.p.tg(i3));
            if (cvVarGa != null && !cvVarGa.pe() && tg(cvVarGa) == i2) {
                if (!this.p.d(cvVarGa.tg)) {
                    return cvVarGa;
                }
                cvVar = cvVarGa;
            }
        }
        return cvVar;
    }

    public void p(int i2) {
        int iBf = this.p.bf();
        for (int i3 = 0; i3 < iBf; i3++) {
            this.p.bf(i3).offsetLeftAndRight(i2);
        }
    }

    public void zk(int i2) {
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.wu(i2);
        }
        v(i2);
        t tVar = this.tv;
        if (tVar != null) {
            tVar.e(this, i2);
        }
        List<t> list = this.rk;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.rk.get(size).e(this, i2);
            }
        }
    }

    public void e(wu wuVar) {
        if (this.yf == null) {
            this.yf = new ArrayList();
        }
        this.yf.add(wuVar);
    }

    public boolean wu(int i2) {
        return getScrollingChildHelper().e(i2);
    }

    private boolean bf(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        bh bhVar = this.n;
        if (bhVar != null) {
            if (action != 0) {
                bhVar.bf(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.n = null;
                }
                return true;
            }
            this.n = null;
        }
        if (action != 0) {
            int size = this.ot.size();
            for (int i2 = 0; i2 < size; i2++) {
                bh bhVar2 = this.ot.get(i2);
                if (bhVar2.e(this, motionEvent)) {
                    this.n = bhVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e(View view) {
        ga();
        boolean zVn = this.p.vn(view);
        if (zVn) {
            cv cvVarGa = ga(view);
            this.ga.d(cvVarGa);
            this.ga.bf(cvVarGa);
        }
        e(!zVn);
        return zVn;
    }

    public void tg(int i2, int i3) {
        if (i2 < 0) {
            p();
            this.vu.onAbsorb(-i2);
        } else if (i2 > 0) {
            v();
            this.ev.onAbsorb(i2);
        }
        if (i3 < 0) {
            zk();
            this.z.onAbsorb(-i3);
        } else if (i3 > 0) {
            m();
            this.vs.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.e.d.p.d(this);
    }

    private void d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.g) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.g = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.xn = x;
            this.pl = x;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.lw = y2;
            this.zb = y2;
        }
    }

    public void e(v vVar, int i2) {
        zk zkVar = this.t;
        if (zkVar != null) {
            zkVar.e("Cannot add item decoration during a scroll  or layout");
        }
        if (this.w.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.w.add(vVar);
        } else {
            this.w.add(i2, vVar);
        }
        l();
        requestLayout();
    }

    public void d(boolean z) {
        this.wl = z | this.wl;
        this.cv = true;
        dt();
    }

    public void bf(boolean z) {
        int i2 = this.ue - 1;
        this.ue = i2;
        if (i2 < 1) {
            this.ue = 0;
            if (z) {
                x();
                cv();
            }
        }
    }

    public cv tg(View view) {
        View viewD = d(view);
        if (viewD == null) {
            return null;
        }
        return bf(viewD);
    }

    public View d(View view) {
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

    public cv tg(int i2) {
        return e(i2, false);
    }

    public static void d(cv cvVar) {
        WeakReference<RecyclerView> weakReference = cvVar.ga;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == cvVar.tg) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            cvVar.ga = null;
        }
    }

    public void bf(cv cvVar, vn.d dVar, vn.d dVar2) {
        ga(cvVar);
        cvVar.e(false);
        if (this.za.e(cvVar, dVar, dVar2)) {
            s();
        }
    }

    public int tg(cv cvVar) {
        if (cvVar.e(524) || !cvVar.dt()) {
            return -1;
        }
        return this.vn.d(cvVar.vn);
    }

    public void e(v vVar) {
        e(vVar, -1);
    }

    public void e(t tVar) {
        if (this.rk == null) {
            this.rk = new ArrayList();
        }
        this.rk.add(tVar);
    }

    public boolean bf(cv cvVar) {
        vn vnVar = this.za;
        return vnVar == null || vnVar.e(cvVar, cvVar.za());
    }

    public cv bf(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return ga(view);
    }

    public void e(int i2) {
        if (this.pe) {
            return;
        }
        vn();
        zk zkVar = this.t;
        if (zkVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            zkVar.tg(i2);
            awakenScrollBars();
        }
    }

    public void e(int i2, int i3, int[] iArr) {
        ga();
        xu();
        com.bytedance.sdk.component.widget.recycler.e.e.e.e("RV Scroll");
        e(this.fy);
        int iE = i2 != 0 ? this.t.e(i2, this.ga, this.fy) : 0;
        int iBf = i3 != 0 ? this.t.bf(i3, this.ga, this.fy) : 0;
        com.bytedance.sdk.component.widget.recycler.e.e.e.e();
        y();
        bh();
        e(false);
        if (iArr != null) {
            iArr[0] = iE;
            iArr[1] = iBf;
        }
    }

    public boolean e(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        tg();
        if (this.bh != null) {
            e(i2, i3, this.bm);
            int[] iArr = this.bm;
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
        if (!this.w.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (e(i6, i5, i7, i4, this.rw, 0)) {
            int i11 = this.xn;
            int[] iArr2 = this.rw;
            int i12 = iArr2[0];
            this.xn = i11 - i12;
            int i13 = this.lw;
            int i14 = iArr2[1];
            this.lw = i13 - i14;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i12, i14);
            }
            int[] iArr3 = this.ys;
            int i15 = iArr3[0];
            int[] iArr4 = this.rw;
            iArr3[0] = i15 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.e.d.p.e(motionEvent, 8194)) {
                e(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            d(i2, i3);
        }
        if (i6 != 0 || i5 != 0) {
            zk(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    public void e(boolean z) {
        if (this.nt < 1) {
            this.nt = 1;
        }
        if (!z && !this.pe) {
            this.dt = false;
        }
        if (this.nt == 1) {
            if (z && this.dt && !this.pe && this.t != null && this.bh != null) {
                w();
            }
            if (!this.pe) {
                this.dt = false;
            }
        }
        this.nt--;
    }

    public void e(int i2, int i3) {
        e(i2, i3, (Interpolator) null);
    }

    public void e(int i2, int i3, Interpolator interpolator) {
        zk zkVar = this.t;
        if (zkVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.pe) {
            return;
        }
        if (!zkVar.d()) {
            i2 = 0;
        }
        if (!this.t.tg()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.lc.e(i2, i3, interpolator);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.p()
            android.widget.EdgeEffect r1 = r6.vu
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            com.bytedance.sdk.component.widget.recycler.e.d.e.e(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.v()
            android.widget.EdgeEffect r1 = r6.ev
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.e.d.e.e(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.zk()
            android.widget.EdgeEffect r9 = r6.z
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            com.bytedance.sdk.component.widget.recycler.e.d.e.e(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.m()
            android.widget.EdgeEffect r9 = r6.vs
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            com.bytedance.sdk.component.widget.recycler.e.d.e.e(r9, r1, r2)
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
            com.bytedance.sdk.component.widget.recycler.e.d.p.d(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.e(float, float, float, float):void");
    }

    public static <T> T e(T t2) {
        t2.getClass();
        return t2;
    }

    private boolean e(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || d(view2) == null) {
            return false;
        }
        if (view == null || d(view) == null) {
            return true;
        }
        this.wu.set(0, 0, view.getWidth(), view.getHeight());
        this.rb.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.wu);
        offsetDescendantRectToMyCoords(view2, this.rb);
        byte b2 = -1;
        int i4 = this.t.k() == 1 ? -1 : 1;
        Rect rect = this.wu;
        int i5 = rect.left;
        Rect rect2 = this.rb;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            b2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                b2 = 0;
            }
        }
        if (i2 == 1) {
            return b2 < 0 || (b2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b2 > 0 || (b2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + e());
    }

    private void e(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.wu.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.d) {
                Rect rect = mVar.bf;
                Rect rect2 = this.wu;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.wu);
            offsetRectIntoDescendantCoords(view, this.wu);
        }
        this.t.e(this, view, this.wu, !this.k, view2 == null);
    }

    public void e(String str) {
        if (t()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + e());
            }
            throw new IllegalStateException(str);
        }
        if (this.ft > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + e()));
        }
    }

    private boolean e(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.n = null;
        }
        int size = this.ot.size();
        for (int i2 = 0; i2 < size; i2++) {
            bh bhVar = this.ot.get(i2);
            if (bhVar.e(this, motionEvent) && action != 3) {
                this.n = bhVar;
                return true;
            }
        }
        return false;
    }

    public final void e(dt dtVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.lc.e;
            dtVar.s = overScroller.getFinalX() - overScroller.getCurrX();
            dtVar.w = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            dtVar.s = 0;
            dtVar.w = 0;
        }
    }

    private void e(long j2, cv cvVar, cv cvVar2) {
        int iBf = this.p.bf();
        for (int i2 = 0; i2 < iBf; i2++) {
            cv cvVarGa = ga(this.p.bf(i2));
            if (cvVarGa != cvVar && e(cvVarGa) == j2) {
                e eVar = this.bh;
                if (eVar != null && eVar.bf()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + cvVarGa + " \n View Holder 2:" + cvVar + e());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + cvVarGa + " \n View Holder 2:" + cvVar + e());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + cvVar2 + " cannot be found but it is necessary for " + cvVar + e());
    }

    public void e(cv cvVar, vn.d dVar) {
        cvVar.e(0, 8192);
        if (this.fy.v && cvVar.h() && !cvVar.pe() && !cvVar.p()) {
            this.v.e(e(cvVar), cvVar);
        }
        this.v.e(cvVar, dVar);
    }

    private void e(int[] iArr) {
        int iBf = this.p.bf();
        if (iBf == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iBf; i4++) {
            cv cvVarGa = ga(this.p.bf(i4));
            if (!cvVarGa.p()) {
                int iV = cvVarGa.v();
                if (iV < i2) {
                    i2 = iV;
                }
                if (iV > i3) {
                    i3 = iV;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public long e(cv cvVar) {
        return this.bh.bf() ? cvVar.wu() : cvVar.vn;
    }

    public void e(cv cvVar, vn.d dVar, vn.d dVar2) {
        cvVar.e(false);
        if (this.za.bf(cvVar, dVar, dVar2)) {
            s();
        }
    }

    private void e(cv cvVar, cv cvVar2, vn.d dVar, vn.d dVar2, boolean z, boolean z2) {
        cvVar.e(false);
        if (z) {
            ga(cvVar);
        }
        if (cvVar != cvVar2) {
            if (z2) {
                ga(cvVar2);
            }
            cvVar.wu = cvVar2;
            ga(cvVar);
            this.ga.d(cvVar);
            cvVar2.e(false);
            cvVar2.xu = cvVar;
        }
        if (this.za.e(cvVar, cvVar2, dVar, dVar2)) {
            s();
        }
    }

    public void e(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iD = this.p.d();
        for (int i5 = 0; i5 < iD; i5++) {
            cv cvVarGa = ga(this.p.tg(i5));
            if (cvVarGa != null && !cvVarGa.p()) {
                int i6 = cvVarGa.vn;
                if (i6 >= i4) {
                    cvVarGa.e(-i3, z);
                    this.fy.vn = true;
                } else if (i6 >= i2) {
                    cvVarGa.e(i2 - 1, -i3, z);
                    this.fy.vn = true;
                }
            }
        }
        this.ga.e(i2, i3, z);
        requestLayout();
    }

    public void e(int i2, int i3, Object obj) {
        int i4;
        int iD = this.p.d();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iD; i6++) {
            View viewTg = this.p.tg(i6);
            cv cvVarGa = ga(viewTg);
            if (cvVarGa != null && !cvVarGa.p() && (i4 = cvVarGa.vn) >= i2 && i4 < i5) {
                cvVarGa.bf(2);
                cvVarGa.e(obj);
                ((m) viewTg.getLayoutParams()).d = true;
            }
        }
        this.ga.d(i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.widget.recycler.RecyclerView.cv e(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.bf r0 = r5.p
            int r0 = r0.d()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L39
            com.bytedance.sdk.component.widget.recycler.bf r3 = r5.p
            android.view.View r3 = r3.tg(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$cv r3 = ga(r3)
            if (r3 == 0) goto L36
            boolean r4 = r3.pe()
            if (r4 != 0) goto L36
            if (r7 == 0) goto L23
            int r4 = r3.vn
            if (r4 == r6) goto L2a
            goto L36
        L23:
            int r4 = r3.v()
            if (r4 == r6) goto L2a
            goto L36
        L2a:
            com.bytedance.sdk.component.widget.recycler.bf r1 = r5.p
            android.view.View r4 = r3.tg
            boolean r1 = r1.d(r4)
            if (r1 != 0) goto L35
            return r3
        L35:
            r1 = r3
        L36:
            int r2 = r2 + 1
            goto L8
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.e(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$cv");
    }

    public cv e(long j2) {
        e eVar = this.bh;
        cv cvVar = null;
        if (eVar != null && eVar.bf()) {
            int iD = this.p.d();
            for (int i2 = 0; i2 < iD; i2++) {
                cv cvVarGa = ga(this.p.tg(i2));
                if (cvVarGa != null && !cvVarGa.pe() && cvVarGa.wu() == j2) {
                    if (!this.p.d(cvVarGa.tg)) {
                        return cvVarGa;
                    }
                    cvVar = cvVarGa;
                }
            }
        }
        return cvVar;
    }

    public static void e(View view, Rect rect) {
        m mVar = (m) view.getLayoutParams();
        Rect rect2 = mVar.bf;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
    }

    public boolean e(cv cvVar, int i2) {
        if (t()) {
            cvVar.f = i2;
            this.f2099b.add(cvVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.e.d.p.e(cvVar.tg, i2);
        return true;
    }

    public boolean e(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6);
    }

    public boolean e(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().e(i2, i3, iArr, iArr2, i4);
    }
}
