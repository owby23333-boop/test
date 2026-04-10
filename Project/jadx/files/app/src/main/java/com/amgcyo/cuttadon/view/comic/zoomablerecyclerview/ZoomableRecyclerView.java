package com.amgcyo.cuttadon.view.comic.zoomablerecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.view.comic.j;
import com.amgcyo.cuttadon.view.comic.m.d;
import com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.b;
import com.github.chrisbanes.photoview.i;

/* JADX INFO: loaded from: classes.dex */
public class ZoomableRecyclerView extends RecyclerView implements d, b.a, GestureDetector.OnDoubleTapListener {
    private boolean A;
    private b B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Matrix f4569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final RectF f4570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rect f4571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private c f4572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private GestureDetectorCompat f4573w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private i f4574x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f4575y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4576z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ZoomableRecyclerView.this.f4574x != null) {
                ZoomableRecyclerView.this.f4574x.onLongPress(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
    }

    public ZoomableRecyclerView(Context context) {
        this(context, null, 0);
    }

    private void b(float f2, float f3, float f4) {
        if (f2 < 1.0f || f2 > 3.0f) {
            return;
        }
        post(new com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.a(f2, f3, f4, this, this.f4569s, this));
    }

    private void c() {
        b bVar = this.B;
        if (bVar != null) {
            bVar.a();
            this.B = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f4569s);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.A) {
            return false;
        }
        try {
            float fA = j.a(this.f4569s);
            b(fA < this.f4575y ? this.f4575y : 1.0f, motionEvent.getX(), motionEvent.getY());
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        i iVar = this.f4574x;
        if (iVar == null) {
            return false;
        }
        iVar.onSingleTap(motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            c();
        }
        boolean zA = this.f4572v.a();
        this.f4572v.a(motionEvent);
        if (!zA && !this.f4572v.a()) {
            super.onTouchEvent(motionEvent);
        }
        this.f4573w.onTouchEvent(motionEvent);
        return true;
    }

    public void setDoubleTap(boolean z2) {
        this.A = z2;
    }

    public void setScaleFactor(float f2) {
        this.f4575y = f2;
    }

    public void setTapListenerListener(i iVar) {
        this.f4574x = iVar;
    }

    public void setVertical(boolean z2) {
        this.f4576z = z2;
    }

    public ZoomableRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.amgcyo.cuttadon.view.comic.m.d
    public void a(float f2, float f3, float f4) {
        if (j.a(this.f4569s) < 3.0f || f2 < 1.0f) {
            this.f4569s.postScale(f2, f2, f3, f4);
            b();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r7 = this;
            android.graphics.Matrix r0 = r7.f4569s
            android.graphics.RectF r0 = r7.a(r0)
            float r1 = r0.height()
            float r2 = r0.width()
            int r3 = com.amgcyo.cuttadon.view.comic.j.a(r7)
            float r3 = (float) r3
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L21
            float r3 = r3 - r1
            float r3 = r3 / r4
            float r1 = r0.top
        L1e:
            float r1 = r3 - r1
            goto L31
        L21:
            float r1 = r0.top
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 <= 0) goto L29
            float r1 = -r1
            goto L31
        L29:
            float r1 = r0.bottom
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L30
            goto L1e
        L30:
            r1 = 0
        L31:
            int r3 = com.amgcyo.cuttadon.view.comic.j.b(r7)
            float r3 = (float) r3
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L41
            float r3 = r3 - r2
            float r3 = r3 / r4
            float r0 = r0.left
        L3e:
            float r5 = r3 - r0
            goto L50
        L41:
            float r2 = r0.left
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L49
            float r5 = -r2
            goto L50
        L49:
            float r0 = r0.right
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L50
            goto L3e
        L50:
            android.graphics.Matrix r0 = r7.f4569s
            r0.postTranslate(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.ZoomableRecyclerView.b():void");
    }

    public ZoomableRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4569s = new Matrix();
        this.f4570t = new RectF();
        this.f4571u = new Rect();
        this.f4575y = 2.0f;
        this.f4576z = true;
        this.A = true;
        this.f4572v = new c(context, this);
        this.f4573w = new GestureDetectorCompat(getContext(), new a());
        this.f4573w.setOnDoubleTapListener(this);
    }

    @Override // com.amgcyo.cuttadon.view.comic.m.d
    public void a() {
        if (j.a(this.f4569s) < 1.0f) {
            b();
            RectF rectFA = a(this.f4569s);
            post(new com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.a(1.0f, rectFA.centerX(), rectFA.centerY(), this, this.f4569s, this));
        }
    }

    @Override // com.amgcyo.cuttadon.view.comic.m.d
    public void a(float f2, float f3) {
        if (this.f4576z) {
            this.f4569s.postTranslate(f2, 0.0f);
        } else {
            this.f4569s.postTranslate(0.0f, f3);
        }
        b();
        invalidate();
    }

    @Override // com.amgcyo.cuttadon.view.comic.m.d
    public void a(float f2, float f3, float f4, float f5) {
        b();
        RectF rectFA = a(this.f4569s);
        this.B = new b(getContext(), this, this);
        this.B.a(rectFA, j.b(this), j.a(this), (int) f4, (int) f5);
        post(this.B);
    }

    @Override // com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.b.a
    public void a(int i2, int i3) {
        if (this.f4576z) {
            this.f4569s.postTranslate(i2, 0.0f);
        } else {
            this.f4569s.postTranslate(0.0f, i3);
        }
        invalidate();
    }

    private RectF a(Matrix matrix) {
        getLocalVisibleRect(this.f4571u);
        this.f4570t.set(this.f4571u);
        matrix.mapRect(this.f4570t);
        return this.f4570t;
    }
}
