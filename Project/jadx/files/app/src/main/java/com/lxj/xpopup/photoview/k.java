package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* JADX INFO: compiled from: PhotoViewAttacher.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static float f17504g0 = 4.0f;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static float f17505h0 = 2.5f;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static float f17506i0 = 1.0f;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static int f17507j0 = 200;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static int f17508k0 = 1;
    private GestureDetector A;
    private com.lxj.xpopup.photoview.b B;
    private com.lxj.xpopup.photoview.d H;
    private com.lxj.xpopup.photoview.f I;
    private com.lxj.xpopup.photoview.e J;
    private j K;
    private View.OnClickListener L;
    private View.OnLongClickListener M;
    private g N;
    private h O;
    private i P;
    private f Q;
    private float T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    float f17513e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    float f17514f0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f17522z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Interpolator f17515s = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17516t = f17507j0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f17517u = f17506i0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f17518v = f17505h0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17519w = f17504g0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17520x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f17521y = false;
    private final Matrix C = new Matrix();
    private final Matrix D = new Matrix();
    private final Matrix E = new Matrix();
    private final RectF F = new RectF();
    private final float[] G = new float[9];
    private int R = 2;
    private int S = 2;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f17509a0 = true;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f17510b0 = false;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ImageView.ScaleType f17511c0 = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private com.lxj.xpopup.photoview.c f17512d0 = new a();

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (k.this.O == null || k.this.f() > k.f17506i0 || motionEvent.getPointerCount() > k.f17508k0 || motionEvent2.getPointerCount() > k.f17508k0) {
                return false;
            }
            return k.this.O.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.M != null) {
                k.this.M.onLongClick(k.this.f17522z);
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float f2 = k.this.f();
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (f2 < k.this.d()) {
                    k.this.a(k.this.d(), x2, y2, true);
                } else if (f2 < k.this.d() || f2 >= k.this.c()) {
                    k.this.a(k.this.e(), x2, y2, true);
                } else {
                    k.this.a(k.this.c(), x2, y2, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.L != null) {
                k.this.L.onClick(k.this.f17522z);
            }
            RectF rectFA = k.this.a();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (k.this.K != null) {
                k.this.K.a(k.this.f17522z, x2, y2);
            }
            if (rectFA == null) {
                return false;
            }
            if (!rectFA.contains(x2, y2)) {
                if (k.this.J == null) {
                    return false;
                }
                k.this.J.a(k.this.f17522z);
                return false;
            }
            float fWidth = (x2 - rectFA.left) / rectFA.width();
            float fHeight = (y2 - rectFA.top) / rectFA.height();
            if (k.this.I == null) {
                return true;
            }
            k.this.I.a(k.this.f17522z, fWidth, fHeight);
            return true;
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    private class e implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f17525s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f17526t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final long f17527u = System.currentTimeMillis();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final float f17528v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final float f17529w;

        public e(float f2, float f3, float f4, float f5) {
            this.f17525s = f4;
            this.f17526t = f5;
            this.f17528v = f2;
            this.f17529w = f3;
        }

        private float a() {
            return k.this.f17515s.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f17527u) * 1.0f) / k.this.f17516t));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f2 = this.f17528v;
            k.this.f17512d0.a((f2 + ((this.f17529w - f2) * fA)) / k.this.f(), this.f17525s, this.f17526t);
            if (fA < 1.0f) {
                com.lxj.xpopup.photoview.a.a(k.this.f17522z, this);
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    private class f implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final OverScroller f17531s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f17532t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f17533u;

        public f(Context context) {
            this.f17531s = new OverScroller(context);
        }

        public void a() {
            this.f17531s.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f17531s.isFinished() && this.f17531s.computeScrollOffset()) {
                int currX = this.f17531s.getCurrX();
                int currY = this.f17531s.getCurrY();
                k.this.E.postTranslate(this.f17532t - currX, this.f17533u - currY);
                k.this.k();
                this.f17532t = currX;
                this.f17533u = currY;
                com.lxj.xpopup.photoview.a.a(k.this.f17522z, this);
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int iRound;
            int i7;
            int iRound2;
            RectF rectFA = k.this.a();
            if (rectFA == null) {
                return;
            }
            int iRound3 = Math.round(-rectFA.left);
            float f2 = i2;
            if (f2 < rectFA.width()) {
                iRound = Math.round(rectFA.width() - f2);
                i6 = 0;
            } else {
                i6 = iRound3;
                iRound = i6;
            }
            int iRound4 = Math.round(-rectFA.top);
            float f3 = i3;
            if (f3 < rectFA.height()) {
                iRound2 = Math.round(rectFA.height() - f3);
                i7 = 0;
            } else {
                i7 = iRound4;
                iRound2 = i7;
            }
            this.f17532t = iRound3;
            this.f17533u = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f17531s.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
        }
    }

    public k(ImageView imageView) {
        this.f17522z = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.T = 0.0f;
        this.B = new com.lxj.xpopup.photoview.b(imageView.getContext(), this.f17512d0);
        this.A = new GestureDetector(imageView.getContext(), new b());
        this.A.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.f17522z.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.photoview.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void update() {
        if (this.f17509a0) {
            a(this.f17522z.getDrawable());
        } else {
            n();
        }
    }

    private void j() {
        f fVar = this.Q;
        if (fVar != null) {
            fVar.a();
            this.Q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (l()) {
            b(m());
        }
    }

    private boolean l() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        RectF rectFA = a(m());
        if (rectFA == null) {
            return false;
        }
        float fHeight = rectFA.height();
        float fWidth = rectFA.width();
        float fA = a(this.f17522z);
        float f8 = 0.0f;
        if (fHeight > fA || rectFA.top < 0.0f) {
            float f9 = rectFA.top;
            if (f9 >= 0.0f) {
                this.S = 0;
                f2 = -f9;
            } else {
                float f10 = rectFA.bottom;
                if (f10 <= fA) {
                    this.S = 1;
                    f2 = fA - f10;
                } else {
                    this.S = -1;
                    f2 = 0.0f;
                }
            }
        } else {
            int i2 = d.a[this.f17511c0.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (fA - fHeight) / 2.0f;
                    f7 = rectFA.top;
                } else {
                    f6 = fA - fHeight;
                    f7 = rectFA.top;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFA.top;
            }
            this.S = 2;
            f2 = f5;
        }
        float fB = b(this.f17522z);
        if (fWidth > fB || rectFA.left < 0.0f) {
            float f11 = rectFA.left;
            if (f11 >= 0.0f) {
                this.R = 0;
                f8 = -f11;
            } else {
                float f12 = rectFA.right;
                if (f12 <= fB) {
                    f8 = fB - f12;
                    this.R = 1;
                } else {
                    this.R = -1;
                }
            }
        } else {
            int i3 = d.a[this.f17511c0.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (fB - fWidth) / 2.0f;
                    f4 = rectFA.left;
                } else {
                    f3 = fB - fWidth;
                    f4 = rectFA.left;
                }
                f8 = f3 - f4;
            } else {
                f8 = -rectFA.left;
            }
            this.R = 2;
        }
        this.E.postTranslate(f8, f2);
        return true;
    }

    private Matrix m() {
        this.D.set(this.C);
        this.D.postConcat(this.E);
        return this.D;
    }

    private void n() {
        this.E.reset();
        d(this.T);
        b(m());
        l();
    }

    public float c() {
        return this.f17519w;
    }

    public void d(float f2) {
        this.E.postRotate(f2 % 360.0f);
        k();
    }

    public void e(float f2) {
        this.E.setRotate(f2 % 360.0f);
        k();
    }

    public float f() {
        return (float) Math.sqrt(((float) Math.pow(a(this.E, 0), 2.0d)) + ((float) Math.pow(a(this.E, 3), 2.0d)));
    }

    public ImageView.ScaleType g() {
        return this.f17511c0;
    }

    public void b(float f2) {
        l.a(this.f17517u, f2, this.f17519w);
        this.f17518v = f2;
    }

    public void c(float f2) {
        l.a(f2, this.f17518v, this.f17519w);
        this.f17517u = f2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.A.setOnDoubleTapListener(onDoubleTapListener);
    }

    public float d() {
        return this.f17518v;
    }

    public float e() {
        return this.f17517u;
    }

    public void a(g gVar) {
        this.N = gVar;
    }

    public void b(boolean z2) {
        this.f17509a0 = z2;
        update();
    }

    public void f(float f2) {
        a(f2, false);
    }

    public void a(h hVar) {
        this.O = hVar;
    }

    public RectF a() {
        l();
        return a(m());
    }

    public Matrix b() {
        return this.D;
    }

    private void b(Matrix matrix) {
        RectF rectFA;
        this.f17522z.setImageMatrix(matrix);
        if (this.H == null || (rectFA = a(matrix)) == null) {
            return;
        }
        this.H.a(rectFA);
    }

    public void a(boolean z2) {
        this.f17520x = z2;
    }

    public void a(float f2) {
        l.a(this.f17517u, this.f17518v, f2);
        this.f17519w = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.M = onLongClickListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void a(com.lxj.xpopup.photoview.d dVar) {
        this.H = dVar;
    }

    public void a(com.lxj.xpopup.photoview.f fVar) {
        this.I = fVar;
    }

    public void a(com.lxj.xpopup.photoview.e eVar) {
        this.J = eVar;
    }

    public void a(j jVar) {
        this.K = jVar;
    }

    public void a(i iVar) {
        this.P = iVar;
    }

    public void a(float f2, boolean z2) {
        a(f2, this.f17522z.getRight() / 2, this.f17522z.getBottom() / 2, z2);
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        if (z2) {
            this.f17522z.post(new e(f(), f2, f3, f4));
        } else {
            this.E.setScale(f2, f2, f3, f4);
            k();
        }
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!l.a(scaleType) || scaleType == this.f17511c0) {
            return;
        }
        this.f17511c0 = scaleType;
        update();
    }

    public void a(int i2) {
        this.f17516t = i2;
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class a implements com.lxj.xpopup.photoview.c {
        a() {
        }

        @Override // com.lxj.xpopup.photoview.c
        public void a(float f2, float f3) {
            if (k.this.B.b()) {
                return;
            }
            if (k.this.P != null) {
                k.this.P.a(f2, f3);
            }
            k.this.E.postTranslate(f2, f3);
            k.this.k();
            k kVar = k.this;
            kVar.U = kVar.S == 0 && k.this.f() != 1.0f;
            k kVar2 = k.this;
            kVar2.V = kVar2.S == 1 && k.this.f() != 1.0f;
            k kVar3 = k.this;
            kVar3.W = kVar3.R == 0 && k.this.f() != 1.0f;
            k kVar4 = k.this;
            kVar4.X = kVar4.R == 1 && k.this.f() != 1.0f;
            ViewParent parent = k.this.f17522z.getParent();
            if (parent == null) {
                return;
            }
            if (!k.this.f17520x || k.this.B.b() || k.this.f17521y) {
                if (k.this.R == 2 && k.this.f17510b0 && k.this.Z) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
                if ((k.this.R != 1 && k.this.R != 0) || k.this.f17510b0 || k.this.Z) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                } else {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
            }
            if ((k.this.R == 2 && !k.this.f17510b0) || ((k.this.R == 0 && f2 >= 0.0f && k.this.Z) || (k.this.R == 1 && f2 <= -0.0f && k.this.Z))) {
                parent.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (k.this.S != 2 || !k.this.Y) {
                k kVar5 = k.this;
                if (!kVar5.U || f3 <= 0.0f || !kVar5.Y) {
                    k kVar6 = k.this;
                    if (!kVar6.V || f3 >= 0.0f || !kVar6.Y) {
                        if (k.this.f17510b0) {
                            if ((k.this.S == 0 && f3 > 0.0f && k.this.Y) || (k.this.S == 1 && f3 < 0.0f && k.this.Y)) {
                                parent.requestDisallowInterceptTouchEvent(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            parent.requestDisallowInterceptTouchEvent(false);
        }

        @Override // com.lxj.xpopup.photoview.c
        public void a(float f2, float f3, float f4, float f5) {
            k kVar = k.this;
            kVar.Q = kVar.new f(kVar.f17522z.getContext());
            f fVar = k.this.Q;
            k kVar2 = k.this;
            int iB = kVar2.b(kVar2.f17522z);
            k kVar3 = k.this;
            fVar.a(iB, kVar3.a(kVar3.f17522z), (int) f4, (int) f5);
            k.this.f17522z.post(k.this.Q);
        }

        @Override // com.lxj.xpopup.photoview.c
        public void a(float f2, float f3, float f4) {
            if (k.this.f() < k.this.f17519w || f2 < 1.0f) {
                if (k.this.N != null) {
                    k.this.N.a(f2, f3, f4);
                }
                k.this.E.postScale(f2, f2, f3, f4);
                k.this.k();
            }
        }
    }

    public float a(Matrix matrix, int i2) {
        matrix.getValues(this.G);
        return this.G[i2];
    }

    private RectF a(Matrix matrix) {
        if (this.f17522z.getDrawable() == null) {
            return null;
        }
        this.F.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.F);
        return this.F;
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fB = b(this.f17522z);
        float fA = a(this.f17522z);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.C.reset();
        float f2 = intrinsicWidth;
        float f3 = fB / f2;
        float f4 = intrinsicHeight;
        float f5 = fA / f4;
        ImageView.ScaleType scaleType = this.f17511c0;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.C.postTranslate((fB - f2) / 2.0f, (fA - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.C.postScale(fMax, fMax);
            this.C.postTranslate((fB - (f2 * fMax)) / 2.0f, (fA - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.C.postScale(fMin, fMin);
            this.C.postTranslate((fB - (f2 * fMin)) / 2.0f, (fA - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fB, fA);
            if (((int) this.T) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.a[this.f17511c0.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.C.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.C.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.C.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if ((f4 * 1.0f) / f2 > (fA * 1.0f) / fB) {
                this.f17510b0 = true;
                this.C.setRectToRect(rectF, new RectF(0.0f, 0.0f, fB, f4 * f3), Matrix.ScaleToFit.START);
            } else {
                this.C.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
