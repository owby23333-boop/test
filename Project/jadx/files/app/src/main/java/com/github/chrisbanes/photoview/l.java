package com.github.chrisbanes.photoview;

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
/* JADX INFO: loaded from: classes2.dex */
public class l implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static float f14862a0 = 3.0f;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static float f14863b0 = 1.75f;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static float f14864c0 = 1.0f;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static int f14865d0 = 200;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static int f14866e0 = 1;
    private GestureDetector A;
    private i B;
    private com.github.chrisbanes.photoview.b C;
    private com.github.chrisbanes.photoview.d K;
    private com.github.chrisbanes.photoview.f L;
    private com.github.chrisbanes.photoview.e M;
    private k N;
    private View.OnClickListener O;
    private View.OnLongClickListener P;
    private g Q;
    private h R;
    private j S;
    private f T;
    private float W;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f14874z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Interpolator f14867s = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f14868t = f14865d0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f14869u = f14864c0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f14870v = f14863b0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f14871w = f14862a0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f14872x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f14873y = false;
    private boolean D = true;
    private float E = 2.0f;
    private final Matrix F = new Matrix();
    private final Matrix G = new Matrix();
    private final Matrix H = new Matrix();
    private final RectF I = new RectF();
    private final float[] J = new float[9];
    private int U = 2;
    private int V = 2;
    private boolean X = true;
    private ImageView.ScaleType Y = ImageView.ScaleType.FIT_CENTER;
    private com.github.chrisbanes.photoview.c Z = new a();

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (l.this.R == null || l.this.f() > l.f14864c0 || motionEvent.getPointerCount() > l.f14866e0 || motionEvent2.getPointerCount() > l.f14866e0) {
                return false;
            }
            return l.this.R.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (l.this.P != null) {
                l.this.P.onLongClick(l.this.f14874z);
            }
            if (l.this.B != null) {
                l.this.B.onLongPress(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!l.this.D) {
                return false;
            }
            try {
                float f2 = l.this.f();
                l.this.a(f2 < l.this.E ? l.this.E : l.this.f14869u, motionEvent.getX(), motionEvent.getY(), true);
            } catch (Exception unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (l.this.B != null) {
                l.this.B.onSingleTap(motionEvent.getRawX(), motionEvent.getRawY());
                return true;
            }
            if (l.this.O != null) {
                l.this.O.onClick(l.this.f14874z);
            }
            RectF rectFA = l.this.a();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (l.this.N != null) {
                l.this.N.a(l.this.f14874z, x2, y2);
            }
            if (rectFA == null) {
                return false;
            }
            if (!rectFA.contains(x2, y2)) {
                if (l.this.M == null) {
                    return false;
                }
                l.this.M.a(l.this.f14874z);
                return false;
            }
            float fWidth = (x2 - rectFA.left) / rectFA.width();
            float fHeight = (y2 - rectFA.top) / rectFA.height();
            if (l.this.L != null) {
                l.this.L.a(l.this.f14874z, fWidth, fHeight);
            }
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
        private final float f14877s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f14878t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final long f14879u = System.currentTimeMillis();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final float f14880v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final float f14881w;

        public e(float f2, float f3, float f4, float f5) {
            this.f14877s = f4;
            this.f14878t = f5;
            this.f14880v = f2;
            this.f14881w = f3;
        }

        private float a() {
            return l.this.f14867s.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f14879u) * 1.0f) / l.this.f14868t));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f2 = this.f14880v;
            l.this.Z.a((f2 + ((this.f14881w - f2) * fA)) / l.this.f(), this.f14877s, this.f14878t);
            if (fA < 1.0f) {
                com.github.chrisbanes.photoview.a.a(l.this.f14874z, this);
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    private class f implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final OverScroller f14883s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f14884t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f14885u;

        public f(Context context) {
            this.f14883s = new OverScroller(context);
        }

        public void a() {
            this.f14883s.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f14883s.isFinished() && this.f14883s.computeScrollOffset()) {
                int currX = this.f14883s.getCurrX();
                int currY = this.f14883s.getCurrY();
                l.this.H.postTranslate(this.f14884t - currX, this.f14885u - currY);
                l.this.k();
                this.f14884t = currX;
                this.f14885u = currY;
                com.github.chrisbanes.photoview.a.a(l.this.f14874z, this);
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int iRound;
            int i7;
            int iRound2;
            RectF rectFA = l.this.a();
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
            this.f14884t = iRound3;
            this.f14885u = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f14883s.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
        }
    }

    public l(ImageView imageView) {
        this.f14874z = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.W = 0.0f;
        this.C = new com.github.chrisbanes.photoview.b(imageView.getContext(), this.Z);
        this.A = new GestureDetector(imageView.getContext(), new b());
        this.A.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.f14874z.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.X
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.github.chrisbanes.photoview.m.a(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.f()
            float r3 = r10.f14869u
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L7a
            com.github.chrisbanes.photoview.l$e r9 = new com.github.chrisbanes.photoview.l$e
            float r5 = r10.f()
            float r6 = r10.f14869u
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.f()
            float r3 = r10.f14871w
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L7a
            com.github.chrisbanes.photoview.l$e r9 = new com.github.chrisbanes.photoview.l$e
            float r5 = r10.f()
            float r6 = r10.f14871w
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.j()
        L7a:
            r11 = 0
        L7b:
            com.github.chrisbanes.photoview.b r0 = r10.C
            if (r0 == 0) goto Lb2
            boolean r11 = r0.b()
            com.github.chrisbanes.photoview.b r0 = r10.C
            boolean r0 = r0.a()
            com.github.chrisbanes.photoview.b r3 = r10.C
            boolean r3 = r3.a(r12)
            if (r11 != 0) goto L9b
            com.github.chrisbanes.photoview.b r11 = r10.C
            boolean r11 = r11.b()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            com.github.chrisbanes.photoview.b r0 = r10.C
            boolean r0 = r0.a()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.f14873y = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.A
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void update() {
        if (this.X) {
            a(this.f14874z.getDrawable());
        } else {
            n();
        }
    }

    private void j() {
        f fVar = this.T;
        if (fVar != null) {
            fVar.a();
            this.T = null;
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
        float fA = a(this.f14874z);
        float f8 = 0.0f;
        if (fHeight <= fA) {
            int i2 = d.a[this.Y.ordinal()];
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
            this.V = 2;
            f2 = f5;
        } else {
            float f9 = rectFA.top;
            if (f9 > 0.0f) {
                this.V = 0;
                f2 = -f9;
            } else {
                float f10 = rectFA.bottom;
                if (f10 < fA) {
                    this.V = 1;
                    f2 = fA - f10;
                } else {
                    this.V = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fB = b(this.f14874z);
        if (fWidth <= fB) {
            int i3 = d.a[this.Y.ordinal()];
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
            this.U = 2;
        } else {
            float f11 = rectFA.left;
            if (f11 > 0.0f) {
                this.U = 0;
                f8 = -f11;
            } else {
                float f12 = rectFA.right;
                if (f12 < fB) {
                    f8 = fB - f12;
                    this.U = 1;
                } else {
                    this.U = -1;
                }
            }
        }
        this.H.postTranslate(f8, f2);
        return true;
    }

    private Matrix m() {
        this.G.set(this.F);
        this.G.postConcat(this.H);
        return this.G;
    }

    private void n() {
        this.H.reset();
        d(this.W);
        b(m());
        l();
    }

    public float c() {
        return this.f14871w;
    }

    public void d(float f2) {
        this.H.postRotate(f2 % 360.0f);
        k();
    }

    public void e(float f2) {
        this.H.setRotate(f2 % 360.0f);
        k();
    }

    public float f() {
        return (float) Math.sqrt(((float) Math.pow(a(this.H, 0), 2.0d)) + ((float) Math.pow(a(this.H, 3), 2.0d)));
    }

    public ImageView.ScaleType g() {
        return this.Y;
    }

    public void b(float f2) {
        m.a(this.f14869u, f2, this.f14871w);
        this.f14870v = f2;
    }

    public void c(float f2) {
        m.a(f2, this.f14870v, this.f14871w);
        this.f14869u = f2;
    }

    public void g(float f2) {
        this.E = f2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.A.setOnDoubleTapListener(onDoubleTapListener);
    }

    public float d() {
        return this.f14870v;
    }

    public float e() {
        return this.f14869u;
    }

    public void a(g gVar) {
        this.Q = gVar;
    }

    public Matrix b() {
        return this.G;
    }

    public void c(boolean z2) {
        this.X = z2;
        update();
    }

    public void f(float f2) {
        a(f2, false);
    }

    private void b(Matrix matrix) {
        RectF rectFA;
        this.f14874z.setImageMatrix(matrix);
        if (this.K == null || (rectFA = a(matrix)) == null) {
            return;
        }
        this.K.a(rectFA);
    }

    public void a(h hVar) {
        this.R = hVar;
    }

    public void a(i iVar) {
        this.B = iVar;
    }

    public RectF a() {
        l();
        return a(m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(boolean z2) {
        this.f14872x = z2;
    }

    public void a(float f2) {
        m.a(this.f14869u, this.f14870v, f2);
        this.f14871w = f2;
    }

    public void b(boolean z2) {
        this.D = z2;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.P = onLongClickListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class a implements com.github.chrisbanes.photoview.c {
        a() {
        }

        @Override // com.github.chrisbanes.photoview.c
        public void a(float f2, float f3) {
            if (l.this.C.b()) {
                return;
            }
            if (l.this.S != null) {
                l.this.S.a(f2, f3);
            }
            l.this.H.postTranslate(f2, f3);
            l.this.k();
            ViewParent parent = l.this.f14874z.getParent();
            if (!l.this.f14872x || l.this.C.b() || l.this.f14873y) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l.this.U == 2 || ((l.this.U == 0 && f2 >= 1.0f) || ((l.this.U == 1 && f2 <= -1.0f) || ((l.this.V == 0 && f3 >= 1.0f) || (l.this.V == 1 && f3 <= -1.0f))))) && Math.abs(f2) >= 10.0f && Math.abs(f2) > Math.abs(f3) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // com.github.chrisbanes.photoview.c
        public void a(float f2, float f3, float f4, float f5) {
            l lVar = l.this;
            lVar.T = lVar.new f(lVar.f14874z.getContext());
            f fVar = l.this.T;
            l lVar2 = l.this;
            int iB = lVar2.b(lVar2.f14874z);
            l lVar3 = l.this;
            fVar.a(iB, lVar3.a(lVar3.f14874z), (int) f4, (int) f5);
            l.this.f14874z.post(l.this.T);
        }

        @Override // com.github.chrisbanes.photoview.c
        public void a(float f2, float f3, float f4) {
            if (l.this.f() < l.this.f14871w || f2 < 1.0f) {
                if (l.this.f() > l.this.f14869u || f2 > 1.0f) {
                    if (l.this.Q != null) {
                        l.this.Q.a(f2, f3, f4);
                    }
                    l.this.H.postScale(f2, f2, f3, f4);
                    l.this.k();
                }
            }
        }
    }

    public void a(com.github.chrisbanes.photoview.d dVar) {
        this.K = dVar;
    }

    public void a(com.github.chrisbanes.photoview.f fVar) {
        this.L = fVar;
    }

    public void a(com.github.chrisbanes.photoview.e eVar) {
        this.M = eVar;
    }

    public void a(k kVar) {
        this.N = kVar;
    }

    public void a(j jVar) {
        this.S = jVar;
    }

    public void a(float f2, boolean z2) {
        a(f2, this.f14874z.getRight() / 2, this.f14874z.getBottom() / 2, z2);
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.f14869u || f2 > this.f14871w) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z2) {
            this.f14874z.post(new e(f(), f2, f3, f4));
        } else {
            this.H.setScale(f2, f2, f3, f4);
            k();
        }
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!m.a(scaleType) || scaleType == this.Y) {
            return;
        }
        this.Y = scaleType;
        update();
    }

    public void a(int i2) {
        this.f14868t = i2;
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.J);
        return this.J[i2];
    }

    private RectF a(Matrix matrix) {
        if (this.f14874z.getDrawable() == null) {
            return null;
        }
        this.I.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.I);
        return this.I;
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fB = b(this.f14874z);
        float fA = a(this.f14874z);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.F.reset();
        float f2 = intrinsicWidth;
        float f3 = fB / f2;
        float f4 = intrinsicHeight;
        float f5 = fA / f4;
        ImageView.ScaleType scaleType = this.Y;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.F.postTranslate((fB - f2) / 2.0f, (fA - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.F.postScale(fMax, fMax);
            this.F.postTranslate((fB - (f2 * fMax)) / 2.0f, (fA - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.F.postScale(fMin, fMin);
            this.F.postTranslate((fB - (f2 * fMin)) / 2.0f, (fA - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fB, fA);
            if (((int) this.W) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.a[this.Y.ordinal()];
            if (i2 == 1) {
                this.F.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 2) {
                this.F.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.F.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.F.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
