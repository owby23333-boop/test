package com.duokan.core.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.yuewen.e84;

/* JADX INFO: loaded from: classes12.dex */
public class TabBarView extends FrameLayout {
    public static final int n = e84.b0(0);
    public static final String o = "vertical";
    public static final String p = "horizontal";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f2928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2929b;
    public int c;
    public TranslateAnimation d;
    public TranslateAnimation e;
    public final LinearView f;
    public int g;
    public int h;
    public int i;
    public e j;
    public Transformation k;
    public Rect l;
    public boolean m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2930a;

        public a(boolean z) {
            this.f2930a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TabBarView.this.j != null) {
                TabBarView.this.j.b(TabBarView.this.c, TabBarView.this.f2929b, this.f2930a);
            }
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f2932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2933b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TabBarView.this.j != null) {
                    TabBarView.this.j.b(TabBarView.this.c, TabBarView.this.f2929b, b.this.f2933b);
                }
            }
        }

        public b(FrameLayout frameLayout, boolean z) {
            this.f2932a = frameLayout;
            this.f2933b = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FrameLayout frameLayout = this.f2932a;
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                this.f2932a.getChildAt(0).setSelected(true);
            }
            TabBarView.this.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabBarView.this.r(TabBarView.this.l((FrameLayout) view), true);
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                TabBarView.this.o(TabBarView.this.l((FrameLayout) view)).setPressed(true);
            } else if (motionEvent.getActionMasked() == 1) {
                TabBarView.this.o(TabBarView.this.l((FrameLayout) view)).setPressed(false);
            }
            return false;
        }
    }

    public interface e {
        void a(int i, int i2, boolean z);

        void b(int i, int i2, boolean z);
    }

    public TabBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getIndicatorCenter() {
        return this.g;
    }

    private int getIndicatorWidth() {
        return this.h;
    }

    private Rect getSelectedTabRect() {
        if (this.f2929b < 0) {
            return new Rect(0, 0, 0, 0);
        }
        Rect rect = new Rect();
        e84.o0(new RectF(), o(this.f2929b), this).round(rect);
        return rect;
    }

    private void setIndicatorCenter(int i) {
        this.g = i;
    }

    private void setIndicatorWidth(int i) {
        this.h = i;
    }

    public final FrameLayout f() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setOnClickListener(new c());
        frameLayout.setOnTouchListener(new d());
        this.f.c(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        return frameLayout;
    }

    public int g(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        f().addView(view);
        if (this.f.getChildCount() == 1) {
            r(0, false);
        }
        return this.f.getChildCount() - 1;
    }

    public ImageView.ScaleType getDividerScaleType() {
        return this.f.getDividerScaleType();
    }

    public Drawable getFirstDividerDrawable() {
        return this.f.getFirstDivider();
    }

    public Drawable getLastDividerDrawable() {
        return this.f.getLastDivider();
    }

    public Drawable getMiddleDividerDrawable() {
        return this.f.getMiddleDivider();
    }

    public int getSelectedTabIndex() {
        return this.f2929b;
    }

    public int getTabCount() {
        return this.f.getCellCount();
    }

    public View h(int i) {
        FrameLayout frameLayoutF = f();
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) frameLayoutF, true);
        if (this.f.getChildCount() == 1) {
            r(0, false);
        }
        return frameLayoutF.getChildAt(0);
    }

    public final void i(FrameLayout frameLayout, boolean z) {
        if (this.f2929b < 0) {
            this.d = null;
            this.e = null;
            setIndicatorCenter(0);
            setIndicatorWidth(0);
            invalidate();
            return;
        }
        if (this.f2928a == null || getVisibility() != 0) {
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
            post(new a(z));
            return;
        }
        Rect selectedTabRect = getSelectedTabRect();
        if (p(selectedTabRect)) {
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
                return;
            }
            return;
        }
        if (this.f instanceof VertLinearView) {
            this.d = new TranslateAnimation(0.0f, 0.0f, getIndicatorCenter(), k(selectedTabRect));
            this.e = new TranslateAnimation(0.0f, 0.0f, getIndicatorWidth(), n(selectedTabRect));
        } else {
            this.d = new TranslateAnimation(getIndicatorCenter(), k(selectedTabRect), 0.0f, 0.0f);
            this.e = new TranslateAnimation(getIndicatorWidth(), n(selectedTabRect), 0.0f, 0.0f);
        }
        this.d.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
        TranslateAnimation translateAnimation = this.d;
        int i = n;
        translateAnimation.setDuration(i);
        this.d.setFillAfter(true);
        this.d.setFillEnabled(true);
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.e.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
        this.e.setDuration(i);
        this.e.setFillAfter(true);
        this.e.setFillEnabled(true);
        this.e.setInterpolator(new AccelerateDecelerateInterpolator());
        this.e.setAnimationListener(new b(frameLayout, z));
        invalidate();
    }

    public final void j(Canvas canvas) {
        canvas.save();
        if (this.f instanceof VertLinearView) {
            this.l.set(0, this.g - (this.h / 2), getWidth(), this.g + ((this.h + 1) / 2));
        } else {
            Rect rect = this.l;
            int i = this.g;
            int i2 = this.h;
            rect.set(i - (i2 / 2), 0, i + ((i2 + 1) / 2), getHeight());
        }
        e84.n(canvas, this.f2928a, this.l, this.i);
        canvas.restore();
    }

    public final int k(Rect rect) {
        return this.f instanceof VertLinearView ? rect.centerY() : rect.centerX();
    }

    public final int l(FrameLayout frameLayout) {
        for (int i = 0; i < this.f.getCellCount(); i++) {
            if (this.f.e(i) == frameLayout) {
                return i;
            }
        }
        return -1;
    }

    public final FrameLayout m(int i) {
        return (FrameLayout) this.f.e(i);
    }

    public final int n(Rect rect) {
        return this.f instanceof VertLinearView ? rect.height() : rect.width();
    }

    public View o(int i) {
        return m(i).getChildAt(0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2928a != null && this.f2929b >= 0) {
            t();
            v();
            j(canvas);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2928a != null) {
            i(null, false);
        }
    }

    public final boolean p(Rect rect) {
        return this.f instanceof VertLinearView ? this.g == rect.centerY() && this.h == rect.height() : this.g == rect.centerX() && this.h == rect.width();
    }

    public void q() {
        this.f2929b = -1;
        this.c = -1;
        this.f.removeAllViews();
    }

    public final void r(int i, boolean z) {
        FrameLayout frameLayoutM;
        int i2 = this.f2929b;
        if (i2 == i && this.m) {
            return;
        }
        this.c = i2;
        if (i2 >= 0) {
            FrameLayout frameLayoutM2 = m(i2);
            frameLayoutM2.setSelected(false);
            frameLayoutM2.getChildAt(0).setSelected(false);
        }
        if (i >= 0) {
            frameLayoutM = m(i);
            this.f2929b = i;
        } else {
            frameLayoutM = null;
        }
        i(frameLayoutM, z);
        e eVar = this.j;
        if (eVar != null) {
            eVar.a(this.c, this.f2929b, z);
        }
    }

    public int s(int i) {
        int i2 = this.f2929b;
        r(i, false);
        return i2;
    }

    public void setDividerScaleType(ImageView.ScaleType scaleType) {
        this.f.setDividerScaleType(scaleType);
        requestLayout();
        invalidate();
    }

    public void setFirstDividerDrawable(int i) {
        setFirstDividerDrawable(getResources().getDrawable(i));
    }

    public void setIgnoreRepeatedClicks(boolean z) {
        this.m = z;
    }

    public void setIndicatorDrawable(int i) {
        setIndicatorDrawable(getResources().getDrawable(i));
    }

    public void setIndicatorGravity(int i) {
        this.i = i;
        invalidate();
    }

    public void setLastDividerDrawable(int i) {
        setLastDividerDrawable(getResources().getDrawable(i));
    }

    public void setMiddleDividerDrawable(int i) {
        setMiddleDividerDrawable(getResources().getDrawable(i));
    }

    public void setSelectionChangeListener(e eVar) {
        this.j = eVar;
    }

    public void setTabEnabled(boolean z) {
        for (int i = 0; i < this.f.getCellCount(); i++) {
            this.f.e(i).setEnabled(z);
        }
    }

    public final void t() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        TranslateAnimation translateAnimation = this.d;
        if (translateAnimation == null || translateAnimation.hasEnded()) {
            return;
        }
        if (!this.d.hasStarted()) {
            this.d.setStartTime(jCurrentAnimationTimeMillis);
        }
        float[] fArr = {0.0f, 0.0f};
        this.d.getTransformation(jCurrentAnimationTimeMillis, this.k);
        this.k.getMatrix().mapPoints(fArr);
        if (this.f instanceof VertLinearView) {
            this.g = Math.round(fArr[1]);
        } else {
            this.g = Math.round(fArr[0]);
        }
        invalidate();
    }

    public void u(int i) {
        setIndicatorCenter(i);
        invalidate();
    }

    public final void v() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        TranslateAnimation translateAnimation = this.e;
        if (translateAnimation == null || translateAnimation.hasEnded()) {
            return;
        }
        if (!this.e.hasStarted()) {
            this.e.setStartTime(jCurrentAnimationTimeMillis);
        }
        float[] fArr = {0.0f, 0.0f};
        this.e.getTransformation(jCurrentAnimationTimeMillis, this.k);
        this.k.getMatrix().mapPoints(fArr);
        if (this.f instanceof VertLinearView) {
            this.h = Math.round(fArr[1]);
        } else {
            this.h = Math.round(fArr[0]);
        }
        invalidate();
    }

    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2928a = null;
        this.f2929b = -1;
        this.c = -1;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = 0;
        this.i = 23;
        this.j = null;
        this.k = new Transformation();
        this.l = new Rect(0, 0, 0, 0);
        this.m = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.orientation});
        String string = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getString(0) : p;
        typedArrayObtainStyledAttributes.recycle();
        if (TextUtils.equals(string, p)) {
            this.f = new HorzLinearView(context);
        } else {
            this.f = new VertLinearView(context);
        }
        addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public void setFirstDividerDrawable(Drawable drawable2) {
        this.f.setFirstDivider(drawable2);
        requestLayout();
        invalidate();
    }

    public void setIndicatorDrawable(Drawable drawable2) {
        this.f2928a = drawable2;
        invalidate();
    }

    public void setLastDividerDrawable(Drawable drawable2) {
        this.f.setLastDivider(drawable2);
        requestLayout();
        invalidate();
    }

    public void setMiddleDividerDrawable(Drawable drawable2) {
        this.f.setMiddleDivider(drawable2);
        requestLayout();
        invalidate();
    }

    public TabBarView(Context context, int i) {
        super(context);
        this.f2928a = null;
        this.f2929b = -1;
        this.c = -1;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = 0;
        this.i = 23;
        this.j = null;
        this.k = new Transformation();
        this.l = new Rect(0, 0, 0, 0);
        this.m = true;
        if (i == 1) {
            this.f = new VertLinearView(context);
        } else {
            this.f = new HorzLinearView(context);
        }
        addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        setWillNotDraw(false);
    }
}
