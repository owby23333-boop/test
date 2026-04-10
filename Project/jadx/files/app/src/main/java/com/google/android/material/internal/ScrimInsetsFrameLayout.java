package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    Drawable f15463s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Rect f15464t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Rect f15465u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f15466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f15467w;

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f15464t == null) {
                scrimInsetsFrameLayout.f15464t = new Rect();
            }
            ScrimInsetsFrameLayout.this.f15464t.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f15463s == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f15464t == null || this.f15463s == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f15466v) {
            this.f15465u.set(0, 0, width, this.f15464t.top);
            this.f15463s.setBounds(this.f15465u);
            this.f15463s.draw(canvas);
        }
        if (this.f15467w) {
            this.f15465u.set(0, height - this.f15464t.bottom, width, height);
            this.f15463s.setBounds(this.f15465u);
            this.f15463s.draw(canvas);
        }
        Rect rect = this.f15465u;
        Rect rect2 = this.f15464t;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f15463s.setBounds(this.f15465u);
        this.f15463s.draw(canvas);
        Rect rect3 = this.f15465u;
        Rect rect4 = this.f15464t;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f15463s.setBounds(this.f15465u);
        this.f15463s.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f15463s;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f15463s;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z2) {
        this.f15467w = z2;
    }

    public void setDrawTopInsetForeground(boolean z2) {
        this.f15466v = z2;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f15463s = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15465u = new Rect();
        this.f15466v = true;
        this.f15467w = true;
        TypedArray typedArrayC = l.c(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i2, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f15463s = typedArrayC.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayC.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }
}
