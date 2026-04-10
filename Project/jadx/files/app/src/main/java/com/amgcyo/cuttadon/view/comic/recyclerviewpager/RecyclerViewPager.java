package com.amgcyo.cuttadon.view.comic.recyclerviewpager;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewPager extends RecyclerView {
    int A;
    private BaseQuickAdapter B;
    private float C;
    private OnPageChangedListener D;
    private GlobalLayoutListener E;
    private int F;
    private int G;
    private float H;
    private Float I;
    private int J;
    private boolean K;
    private boolean L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f4555s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f4556t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f4557u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f4558v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    View f4559w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f4560x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f4561y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f4562z;

    private class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private GlobalLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RecyclerViewPager.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (RecyclerViewPager.this.F < 0 || RecyclerViewPager.this.F >= RecyclerViewPager.this.getItemCount() || RecyclerViewPager.this.D == null) {
                return;
            }
            OnPageChangedListener onPageChangedListener = RecyclerViewPager.this.D;
            RecyclerViewPager recyclerViewPager = RecyclerViewPager.this;
            onPageChangedListener.OnPageChanged(recyclerViewPager, recyclerViewPager.G, RecyclerViewPager.this.getCurrentPosition());
        }
    }

    public interface OnPageChangedListener {
        void OnPageChanged(RecyclerView recyclerView, int i2, int i3);
    }

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    private int c(int i2, int i3) {
        if (i2 < 0) {
            return 0;
        }
        return i2 >= i3 ? i3 - 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        BaseQuickAdapter baseQuickAdapter = this.B;
        if (baseQuickAdapter == null) {
            return 0;
        }
        return baseQuickAdapter.getItemCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getLayoutManager() != null) {
            this.J = getLayoutManager().canScrollHorizontally() ? RecyclerViewUtils.b(this) : RecyclerViewUtils.d(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i2, int i3) {
        float f2 = this.f4555s;
        boolean zFling = super.fling((int) (i2 * f2), (int) (i3 * f2));
        if (zFling) {
            if (getLayoutManager().canScrollHorizontally()) {
                a(i2);
            } else {
                b(i3);
            }
        }
        return zFling;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        BaseQuickAdapter baseQuickAdapter = this.B;
        if (baseQuickAdapter != null) {
            return baseQuickAdapter;
        }
        return null;
    }

    public int getCurrentPosition() {
        int iB = getLayoutManager().canScrollHorizontally() ? RecyclerViewUtils.b(this) : RecyclerViewUtils.d(this);
        return iB < 0 ? this.F : iB;
    }

    public float getFlingFactor() {
        return this.f4555s;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptHoverEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        try {
            Field declaredField = parcelable.getClass().getDeclaredField("mLayoutState");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(parcelable);
            Field declaredField2 = obj.getClass().getDeclaredField("mAnchorOffset");
            Field declaredField3 = obj.getClass().getDeclaredField("mAnchorPosition");
            declaredField3.setAccessible(true);
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) > 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) - 1));
            } else if (declaredField2.getInt(obj) < 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) + 1));
            }
            declaredField2.setInt(obj, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    @Override // androidx.recyclerview.widget.RecyclerView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrollStateChanged(int r6) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager.onScrollStateChanged(int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (motionEvent.getAction() == 2 && (view = this.f4559w) != null) {
            this.f4560x = Math.max(view.getLeft(), this.f4560x);
            this.f4562z = Math.max(this.f4559w.getTop(), this.f4562z);
            this.f4561y = Math.min(this.f4559w.getLeft(), this.f4561y);
            this.A = Math.min(this.f4559w.getTop(), this.A);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        this.G = getCurrentPosition();
        this.F = i2;
        super.scrollToPosition(i2);
        int i3 = this.F;
        if (i3 < 0 || i3 >= getItemCount() || this.F == this.G || this.D == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        this.B = a(adapter);
        super.setAdapter(this.B);
    }

    public void setFlingFactor(float f2) {
        this.f4555s = f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager instanceof LinearLayoutManager) {
            this.L = ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
    }

    public void setOnPageChangedListener(OnPageChangedListener onPageChangedListener) {
        this.D = onPageChangedListener;
    }

    public void setScrollSpeed(float f2) {
        this.I = Float.valueOf(f2);
    }

    public void setTriggerOffset(float f2) {
        this.H = f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i2) {
        if (this.G < 0) {
            this.G = getCurrentPosition();
        }
        c(i2);
        int i3 = this.F;
        if (i3 < 0 || i3 >= getItemCount() || this.F == this.G || this.D == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z2) {
        this.B = a(adapter);
        super.swapAdapter(this.B, z2);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.L
            if (r0 == 0) goto L6
            int r6 = r6 * (-1)
        L6:
            int r0 = r5.getChildCount()
            if (r0 <= 0) goto L91
            int r0 = com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewUtils.b(r5)
            int r1 = r5.getWidth()
            int r2 = r5.getPaddingLeft()
            int r1 = r1 - r2
            int r2 = r5.getPaddingRight()
            int r1 = r1 - r2
            int r6 = r5.b(r6, r1)
            r1 = 1
            int r6 = java.lang.Math.min(r1, r6)
            r2 = -1
            int r6 = java.lang.Math.max(r2, r6)
            if (r6 != 0) goto L30
            r6 = r0
            goto L33
        L30:
            int r2 = r5.J
            int r6 = r6 + r2
        L33:
            r2 = 0
            int r6 = java.lang.Math.max(r6, r2)
            int r2 = r5.getItemCount()
            int r2 = r2 - r1
            int r6 = java.lang.Math.min(r6, r2)
            if (r6 != r0) goto L86
            int r2 = r5.J
            if (r2 != r0) goto L86
            android.view.View r0 = com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewUtils.a(r5)
            if (r0 == 0) goto L86
            float r2 = r5.C
            int r3 = r0.getWidth()
            float r3 = (float) r3
            float r4 = r5.H
            float r3 = r3 * r4
            float r3 = r3 * r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L6a
            if (r6 == 0) goto L6a
            boolean r0 = r5.L
            if (r0 != 0) goto L67
        L64:
            int r6 = r6 + (-1)
            goto L86
        L67:
            int r6 = r6 + 1
            goto L86
        L6a:
            float r2 = r5.C
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r3 = r5.H
            float r3 = -r3
            float r0 = r0 * r3
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L86
            int r0 = r5.getItemCount()
            int r0 = r0 - r1
            if (r6 == r0) goto L86
            boolean r0 = r5.L
            if (r0 != 0) goto L64
            goto L67
        L86:
            int r0 = r5.getItemCount()
            int r6 = r5.c(r6, r0)
            r5.c(r6)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager.a(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.L
            if (r0 == 0) goto L6
            int r6 = r6 * (-1)
        L6:
            int r0 = r5.getChildCount()
            if (r0 <= 0) goto L8f
            int r0 = com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewUtils.d(r5)
            int r1 = r5.getHeight()
            int r2 = r5.getPaddingTop()
            int r1 = r1 - r2
            int r2 = r5.getPaddingBottom()
            int r1 = r1 - r2
            int r6 = r5.b(r6, r1)
            r1 = 1
            int r6 = java.lang.Math.min(r1, r6)
            r2 = -1
            int r6 = java.lang.Math.max(r2, r6)
            if (r6 != 0) goto L30
            r6 = r0
            goto L33
        L30:
            int r2 = r5.J
            int r6 = r6 + r2
        L33:
            r2 = 0
            int r6 = java.lang.Math.max(r6, r2)
            int r2 = r5.getItemCount()
            int r2 = r2 - r1
            int r6 = java.lang.Math.min(r6, r2)
            if (r6 != r0) goto L84
            int r2 = r5.J
            if (r2 != r0) goto L84
            android.view.View r0 = com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewUtils.c(r5)
            if (r0 == 0) goto L84
            float r2 = r5.C
            int r3 = r0.getHeight()
            float r3 = (float) r3
            float r4 = r5.H
            float r3 = r3 * r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L68
            if (r6 == 0) goto L68
            boolean r0 = r5.L
            if (r0 != 0) goto L65
        L62:
            int r6 = r6 + (-1)
            goto L84
        L65:
            int r6 = r6 + 1
            goto L84
        L68:
            float r2 = r5.C
            int r0 = r0.getHeight()
            float r0 = (float) r0
            float r3 = r5.H
            float r3 = -r3
            float r0 = r0 * r3
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L84
            int r0 = r5.getItemCount()
            int r0 = r0 - r1
            if (r6 == r0) goto L84
            boolean r0 = r5.L
            if (r0 != 0) goto L62
            goto L65
        L84:
            int r0 = r5.getItemCount()
            int r6 = r5.c(r6, r0)
            r5.c(r6)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager.b(int):void");
    }

    public void c(int i2) {
        this.F = i2;
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(getContext()) { // from class: com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return (RecyclerViewPager.this.getContext().getResources().getDisplayMetrics().density * RecyclerViewPager.this.I.floatValue()) / displayMetrics.density;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i3) {
                if (getLayoutManager() == null) {
                    return null;
                }
                return ((LinearLayoutManager) getLayoutManager()).computeScrollVectorForPosition(i3);
            }
        };
        linearSmoothScroller.setTargetPosition(i2);
        if (i2 == -1) {
            return;
        }
        getLayoutManager().startSmoothScroll(linearSmoothScroller);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4555s = 0.1f;
        this.f4560x = Integer.MIN_VALUE;
        this.f4561y = Integer.MAX_VALUE;
        this.f4562z = Integer.MIN_VALUE;
        this.A = Integer.MAX_VALUE;
        this.E = new GlobalLayoutListener();
        this.F = -1;
        this.G = -1;
        this.H = 0.05f;
        this.J = -1;
        this.K = true;
        this.L = false;
        setNestedScrollingEnabled(false);
    }

    @NonNull
    protected BaseQuickAdapter a(RecyclerView.Adapter adapter) {
        return (BaseQuickAdapter) adapter;
    }

    public void b() {
        int currentPosition = getCurrentPosition();
        int i2 = this.G;
        if (i2 != -1) {
            this.G = i2 + currentPosition;
        }
        this.J += currentPosition;
        this.F += currentPosition;
    }

    private int b(int i2, int i3) {
        if (i2 == 0) {
            return 0;
        }
        double d2 = i2 > 0 ? 1 : -1;
        double dCeil = Math.ceil((((i2 * r0) * this.f4555s) / i3) - this.H);
        Double.isNaN(d2);
        return (int) (d2 * dCeil);
    }
}
