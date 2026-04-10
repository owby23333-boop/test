package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.yuewen.az3;
import com.yuewen.e84;
import com.yuewen.rv1;

/* JADX INFO: loaded from: classes12.dex */
public class LinearSelectableView extends LinearLayout {
    public static final /* synthetic */ boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f2908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f2909b;
    public View c;
    public boolean d;
    public boolean e;
    public f f;
    public e g;
    public d h;

    public class a implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: com.duokan.core.ui.LinearSelectableView$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0207a implements View.OnClickListener {
            public ViewOnClickListenerC0207a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LinearSelectableView.this.o(view, true);
            }
        }

        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == LinearSelectableView.this) {
                view2.setOnClickListener(new ViewOnClickListenerC0207a());
            }
            if (LinearSelectableView.this.f2908a != null) {
                LinearSelectableView.this.f2908a.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            LinearSelectableView linearSelectableView = LinearSelectableView.this;
            if (view == linearSelectableView && linearSelectableView.c == view2) {
                LinearSelectableView.this.o(null, false);
            }
            if (LinearSelectableView.this.f2908a != null) {
                LinearSelectableView.this.f2908a.onChildViewRemoved(view, view2);
            }
        }
    }

    public class b implements Animation.AnimationListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (LinearSelectableView.this.f.f2916a != LinearSelectableView.this.f.f2917b) {
                    LinearSelectableView linearSelectableView = LinearSelectableView.this;
                    linearSelectableView.l(linearSelectableView.f.f2916a, LinearSelectableView.this.f.f2917b, LinearSelectableView.this.d);
                }
                LinearSelectableView.this.f = null;
            }
        }

        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            rv1.m(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class c extends InsetDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2914a;

        public c(Drawable drawable2, int i) {
            super(drawable2, i);
            this.f2914a = false;
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.f2914a = true;
            az3<Rect> az3Var = e84.m;
            Rect rectA = az3Var.a();
            if (LinearSelectableView.this.f != null) {
                if (!LinearSelectableView.this.f.hasStarted()) {
                    LinearSelectableView.this.f.start();
                }
                LinearSelectableView.this.f.a(rectA, LinearSelectableView.this.getDrawingTime());
                invalidateSelf();
            } else {
                LinearSelectableView linearSelectableView = LinearSelectableView.this;
                linearSelectableView.k(rectA, linearSelectableView.c);
            }
            LinearSelectableView.this.f2909b.setState(getState());
            LinearSelectableView.this.f2909b.setBounds(0, 0, LinearSelectableView.this.getWidth(), LinearSelectableView.this.getHeight());
            if (LinearSelectableView.this.getOrientation() == 0) {
                canvas.save();
                canvas.clipRect(0, 0, rectA.left, LinearSelectableView.this.getHeight());
                LinearSelectableView.this.f2909b.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.clipRect(rectA.right, 0, LinearSelectableView.this.getWidth(), LinearSelectableView.this.getHeight());
                LinearSelectableView.this.f2909b.draw(canvas);
                canvas.restore();
            } else {
                canvas.save();
                canvas.clipRect(0, 0, LinearSelectableView.this.getWidth(), rectA.top);
                LinearSelectableView.this.f2909b.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.clipRect(0, rectA.bottom, LinearSelectableView.this.getWidth(), LinearSelectableView.this.getHeight());
                LinearSelectableView.this.f2909b.draw(canvas);
                canvas.restore();
            }
            LinearSelectableView.this.f2909b.draw(canvas);
            if (!rectA.isEmpty()) {
                canvas.save();
                canvas.clipRect(rectA);
                LinearSelectableView.this.f2909b.setState(LinearLayout.SELECTED_STATE_SET);
                LinearSelectableView.this.f2909b.setBounds(0, 0, LinearSelectableView.this.getWidth(), LinearSelectableView.this.getHeight());
                LinearSelectableView.this.f2909b.draw(canvas);
                canvas.restore();
            }
            az3Var.d(rectA);
            this.f2914a = false;
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable2) {
            if (this.f2914a && drawable2 == LinearSelectableView.this.f2909b) {
                return;
            }
            super.invalidateDrawable(drawable2);
        }
    }

    public interface d {
        void a(LinearSelectableView linearSelectableView, View view, View view2, boolean z);
    }

    public interface e {
        void a(LinearSelectableView linearSelectableView, View view, View view2, boolean z);
    }

    public class f extends AlphaAnimation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f2916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f2917b;

        public f() {
            super(0.0f, 1.0f);
            this.f2916a = null;
            this.f2917b = null;
            setDuration(e84.b0(0));
            initialize(0, 0, 0, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(android.graphics.Rect r7, long r8) {
            /*
                r6 = this;
                com.yuewen.az3<android.view.animation.Transformation> r0 = com.yuewen.e84.i
                java.lang.Object r1 = r0.a()
                android.view.animation.Transformation r1 = (android.view.animation.Transformation) r1
                com.yuewen.az3<android.graphics.Rect> r2 = com.yuewen.e84.m
                java.lang.Object r3 = r2.a()
                android.graphics.Rect r3 = (android.graphics.Rect) r3
                java.lang.Object r4 = r2.a()
                android.graphics.Rect r4 = (android.graphics.Rect) r4
                r6.getTransformation(r8, r1)
                android.view.View r8 = r6.f2917b
                if (r8 == 0) goto L94
                android.view.ViewParent r8 = r8.getParent()
                com.duokan.core.ui.LinearSelectableView r9 = com.duokan.core.ui.LinearSelectableView.this
                if (r8 == r9) goto L26
                goto L94
            L26:
                android.view.View r8 = r6.f2916a
                if (r8 == 0) goto L8c
                android.view.ViewParent r8 = r8.getParent()
                com.duokan.core.ui.LinearSelectableView r9 = com.duokan.core.ui.LinearSelectableView.this
                if (r8 == r9) goto L33
                goto L8c
            L33:
                android.view.View r8 = r6.f2916a
                com.duokan.core.ui.LinearSelectableView.g(r9, r3, r8)
                com.duokan.core.ui.LinearSelectableView r8 = com.duokan.core.ui.LinearSelectableView.this
                android.view.View r9 = r6.f2917b
                com.duokan.core.ui.LinearSelectableView.g(r8, r4, r9)
                int r8 = r3.left
                float r9 = (float) r8
                int r5 = r4.left
                int r5 = r5 - r8
                float r8 = (float) r5
                float r5 = r1.getAlpha()
                float r8 = r8 * r5
                float r9 = r9 + r8
                int r8 = java.lang.Math.round(r9)
                r7.left = r8
                int r8 = r3.top
                float r9 = (float) r8
                int r5 = r4.top
                int r5 = r5 - r8
                float r8 = (float) r5
                float r5 = r1.getAlpha()
                float r8 = r8 * r5
                float r9 = r9 + r8
                int r8 = java.lang.Math.round(r9)
                r7.top = r8
                int r8 = r3.right
                float r9 = (float) r8
                int r5 = r4.right
                int r5 = r5 - r8
                float r8 = (float) r5
                float r5 = r1.getAlpha()
                float r8 = r8 * r5
                float r9 = r9 + r8
                int r8 = java.lang.Math.round(r9)
                r7.right = r8
                int r8 = r3.bottom
                float r9 = (float) r8
                int r5 = r4.bottom
                int r5 = r5 - r8
                float r8 = (float) r5
                float r5 = r1.getAlpha()
                float r8 = r8 * r5
                float r9 = r9 + r8
                int r8 = java.lang.Math.round(r9)
                r7.bottom = r8
                goto L97
            L8c:
                com.duokan.core.ui.LinearSelectableView r8 = com.duokan.core.ui.LinearSelectableView.this
                android.view.View r9 = r6.f2917b
                com.duokan.core.ui.LinearSelectableView.g(r8, r7, r9)
                goto L97
            L94:
                r7.setEmpty()
            L97:
                r0.d(r1)
                r2.d(r3)
                r2.d(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.ui.LinearSelectableView.f.a(android.graphics.Rect, long):void");
        }
    }

    public LinearSelectableView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.f2909b;
    }

    public final View getSelectedChild() {
        return this.c;
    }

    public final int getSelectedId() {
        View selectedChild = getSelectedChild();
        if (selectedChild == null) {
            return -1;
        }
        return selectedChild.getId();
    }

    public final int getSelectedIndex() {
        if (this.c == null) {
            return -1;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == this.c) {
                return i2;
            }
        }
        return -1;
    }

    public final void k(Rect rect, View view) {
        if (view == null) {
            rect.setEmpty();
            return;
        }
        int iIndexOfChild = indexOfChild(view);
        if (getOrientation() == 0) {
            rect.left = iIndexOfChild == 0 ? 0 : view.getLeft();
            rect.top = 0;
            rect.right = iIndexOfChild == getChildCount() + (-1) ? getWidth() : view.getRight();
            rect.bottom = getHeight();
            return;
        }
        rect.left = 0;
        rect.top = iIndexOfChild != 0 ? view.getTop() : 0;
        rect.right = getWidth();
        rect.bottom = iIndexOfChild == getChildCount() + (-1) ? getHeight() : view.getBottom();
    }

    public final void l(View view, View view2, boolean z) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(this, view, view2, z);
        }
    }

    public final void m(View view, View view2, boolean z) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(this, view, view2, z);
        }
    }

    public final boolean n(View view) {
        return o(view, false);
    }

    public final boolean o(View view, boolean z) {
        View selectedChild;
        if ((view != null && view.getParent() != this) || view == (selectedChild = getSelectedChild())) {
            return false;
        }
        if (selectedChild != null) {
            selectedChild.setSelected(false);
        }
        if (view != null) {
            view.setSelected(true);
        }
        if (this.e) {
            f fVar = this.f;
            if (fVar != null) {
                fVar.f2917b = view;
            } else {
                f fVar2 = new f();
                this.f = fVar2;
                fVar2.f2916a = selectedChild;
                fVar2.f2917b = view;
                fVar2.setAnimationListener(new b());
            }
        }
        this.c = view;
        this.d = z;
        m(selectedChild, view, z);
        if (!this.e) {
            l(selectedChild, view, this.d);
        }
        invalidate();
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f = null;
        }
    }

    public final boolean p(int i2) {
        return n(findViewById(i2));
    }

    public final boolean q(int i2) {
        return n(getChildAt(i2));
    }

    public final void r() {
        if (this.f2909b == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new c(this.f2909b, 0));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable2) {
        if (this.f2909b != drawable2) {
            this.f2909b = drawable2;
            r();
        }
    }

    public final void setOnDelayedSelectionChangeListener(d dVar) {
        this.h = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2908a = onHierarchyChangeListener;
    }

    public final void setOnSelectionChangeListener(e eVar) {
        this.g = eVar;
    }

    public final void setSelectAnimateEnable(boolean z) {
        this.e = z;
    }

    public LinearSelectableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = false;
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = null;
        super.setOnHierarchyChangeListener(new a());
    }
}
