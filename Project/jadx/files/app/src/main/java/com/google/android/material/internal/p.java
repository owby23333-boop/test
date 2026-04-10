package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: compiled from: ViewOverlayApi14.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements r {
    protected a a;

    p(Context context, ViewGroup viewGroup, View view) {
        this.a = new a(context, viewGroup, view, this);
    }

    static p a(View view) {
        ViewGroup viewGroupA = s.a(view);
        if (viewGroupA == null) {
            return null;
        }
        int childCount = viewGroupA.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroupA.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).f15541v;
            }
        }
        return new n(viewGroupA.getContext(), viewGroupA, view);
    }

    @Override // com.google.android.material.internal.r
    public void add(@NonNull Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // com.google.android.material.internal.r
    public void remove(@NonNull Drawable drawable) {
        this.a.b(drawable);
    }

    /* JADX INFO: compiled from: ViewOverlayApi14.java */
    @SuppressLint({"ViewConstructor", "PrivateApi"})
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        ViewGroup f15538s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        View f15539t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        ArrayList<Drawable> f15540u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        p f15541v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private boolean f15542w;

        static {
            try {
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, p pVar) {
            super(context);
            this.f15540u = null;
            this.f15538s = viewGroup;
            this.f15539t = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f15541v = pVar;
        }

        public void a(Drawable drawable) {
            a();
            if (this.f15540u == null) {
                this.f15540u = new ArrayList<>();
            }
            if (this.f15540u.contains(drawable)) {
                return;
            }
            this.f15540u.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f15540u;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f15538s.getLocationOnScreen(new int[2]);
            this.f15539t.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f15539t.getWidth(), this.f15539t.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f15540u;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15540u.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f15538s == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f15538s == null) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            a(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f15540u) != null && arrayList.contains(drawable));
        }

        private void b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f15540u;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f15542w = true;
                    this.f15538s.removeView(this);
                }
            }
        }

        private void a() {
            if (this.f15542w) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f15538s.getLocationOnScreen(iArr2);
            this.f15539t.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }
    }
}
