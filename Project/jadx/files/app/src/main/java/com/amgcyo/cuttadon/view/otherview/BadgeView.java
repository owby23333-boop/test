package com.amgcyo.cuttadon.view.otherview;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class BadgeView extends AppCompatTextView {
    private static final int B = Color.parseColor("#CCFF0000");
    private static Animation C;
    private static Animation D;
    private int A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f4911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4914w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4915x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4916y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ShapeDrawable f4917z;

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void a(Context context, View view, int i2) {
        this.f4910s = context;
        this.f4911t = view;
        this.A = i2;
        this.f4912u = 2;
        this.f4913v = a(5);
        this.f4914w = this.f4913v;
        this.f4915x = B;
        setTypeface(Typeface.DEFAULT_BOLD);
        int iA = a(5);
        setPadding(iA, 0, iA, 0);
        setTextColor(-1);
        C = new AlphaAnimation(0.0f, 1.0f);
        C.setInterpolator(new DecelerateInterpolator());
        C.setDuration(200L);
        D = new AlphaAnimation(1.0f, 0.0f);
        D.setInterpolator(new AccelerateInterpolator());
        D.setDuration(200L);
        this.f4916y = false;
        View view2 = this.f4911t;
        if (view2 != null) {
            a(view2);
        } else {
            b();
        }
    }

    private void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (this.f4912u) {
            case 1:
                layoutParams.gravity = 51;
                layoutParams.setMargins(this.f4913v, this.f4914w, 0, 0);
                break;
            case 2:
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, this.f4914w, this.f4913v, 0);
                break;
            case 3:
                layoutParams.gravity = 83;
                layoutParams.setMargins(this.f4913v, 0, 0, this.f4914w);
                break;
            case 4:
                layoutParams.gravity = 85;
                layoutParams.setMargins(0, 0, this.f4913v, this.f4914w);
                break;
            case 5:
                layoutParams.gravity = 17;
                layoutParams.setMargins(0, 0, 0, 0);
                break;
            case 6:
                layoutParams.gravity = 19;
                layoutParams.setMargins(0, 0, 0, 0);
                break;
            case 7:
                layoutParams.gravity = 21;
                layoutParams.setMargins(0, 0, this.f4913v, 0);
                break;
        }
        setLayoutParams(layoutParams);
    }

    private ShapeDrawable getDefaultBackground() {
        float fA = a(8);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
        shapeDrawable.getPaint().setColor(this.f4915x);
        return shapeDrawable;
    }

    public void b() {
        b(false, null);
    }

    public int getBadgeBackgroundColor() {
        return this.f4915x;
    }

    public int getBadgePosition() {
        return this.f4912u;
    }

    public int getHorizontalBadgeMargin() {
        return this.f4913v;
    }

    public View getTarget() {
        return this.f4911t;
    }

    public int getVerticalBadgeMargin() {
        return this.f4914w;
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.f4916y;
    }

    public void setBadgeBackgroundColor(int i2) {
        this.f4915x = i2;
        this.f4917z = getDefaultBackground();
    }

    public void setBadgeMargin(int i2) {
        this.f4913v = i2;
        this.f4914w = i2;
    }

    public void setBadgePosition(int i2) {
        this.f4912u = i2;
    }

    public BadgeView(Context context, View view) {
        this(context, null, R.attr.textViewStyle, view, 0);
    }

    private void b(boolean z2, Animation animation) {
        if (getBackground() == null) {
            if (this.f4917z == null) {
                this.f4917z = getDefaultBackground();
            }
            setBackgroundDrawable(this.f4917z);
        }
        c();
        if (z2) {
            startAnimation(animation);
        }
        setVisibility(0);
        this.f4916y = true;
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null, 0);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i2, View view, int i3) {
        super(context, attributeSet, i2);
        a(context, view, i3);
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = new FrameLayout(this.f4910s);
        if (view instanceof TabWidget) {
            View childTabViewAt = ((TabWidget) view).getChildTabViewAt(this.A);
            this.f4911t = childTabViewAt;
            ((ViewGroup) childTabViewAt).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            frameLayout.addView(this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(frameLayout, iIndexOfChild, layoutParams);
        frameLayout.addView(view);
        setVisibility(8);
        frameLayout.addView(this);
        viewGroup.invalidate();
    }

    public void a() {
        a(false, (Animation) null);
    }

    private void a(boolean z2, Animation animation) {
        setVisibility(8);
        if (z2) {
            startAnimation(animation);
        }
        this.f4916y = false;
    }

    public void a(int i2, int i3) {
        this.f4913v = i2;
        this.f4914w = i3;
    }

    private int a(int i2) {
        return (int) TypedValue.applyDimension(1, i2, getResources().getDisplayMetrics());
    }
}
