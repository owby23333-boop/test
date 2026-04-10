package com.gongwen.marqueen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import com.gongwen.marqueen.c;

/* JADX INFO: loaded from: classes2.dex */
public class XMarqueeView extends ViewFlipper implements c.a {
    private boolean A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f14904s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f14905t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14906u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f14907v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f14908w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f14909x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f14910y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private c f14911z;

    public XMarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14904s = false;
        this.f14905t = true;
        this.f14906u = 3000;
        this.f14907v = 1000;
        this.f14908w = 14;
        this.f14909x = Color.parseColor("#888888");
        this.f14910y = 1;
        this.A = true;
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XMarqueeView, i2, 0);
        this.f14904s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.XMarqueeView_isSetAnimDuration, false);
        this.f14905t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.XMarqueeView_isSingleLine, true);
        this.A = typedArrayObtainStyledAttributes.getBoolean(R$styleable.XMarqueeView_isFlippingLessCount, true);
        this.f14906u = typedArrayObtainStyledAttributes.getInteger(R$styleable.XMarqueeView_marquee_interval, this.f14906u);
        this.f14907v = typedArrayObtainStyledAttributes.getInteger(R$styleable.XMarqueeView_marquee_animDuration, this.f14907v);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.XMarqueeView_marquee_textSize)) {
            this.f14908w = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.XMarqueeView_marquee_textSize, this.f14908w);
            this.f14908w = com.gongwen.marqueen.d.c.a(context, this.f14908w);
        }
        this.f14909x = typedArrayObtainStyledAttributes.getColor(R$styleable.XMarqueeView_marquee_textColor, this.f14909x);
        this.f14910y = typedArrayObtainStyledAttributes.getInt(R$styleable.XMarqueeView_marquee_count, this.f14910y);
        typedArrayObtainStyledAttributes.recycle();
        this.f14905t = this.f14910y == 1;
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.anim_marquee_in);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R$anim.anim_marquee_out);
        if (this.f14904s) {
            animationLoadAnimation.setDuration(this.f14907v);
            animationLoadAnimation2.setDuration(this.f14907v);
        }
        setInAnimation(animationLoadAnimation);
        setOutAnimation(animationLoadAnimation2);
        setFlipInterval(this.f14906u);
        setMeasureAllChildren(false);
    }

    private void b() {
        removeAllViews();
        int iA = this.f14911z.a() % this.f14910y == 0 ? this.f14911z.a() / this.f14910y : (this.f14911z.a() / this.f14910y) + 1;
        int i2 = 0;
        for (int i3 = 0; i3 < iA; i3++) {
            if (this.f14905t) {
                View viewA = this.f14911z.a(this);
                if (i2 < this.f14911z.a()) {
                    this.f14911z.a(viewA, viewA, i2);
                }
                i2++;
                addView(viewA);
            } else {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(1);
                linearLayout.setGravity(17);
                linearLayout.removeAllViews();
                int iA2 = i2;
                for (int i4 = 0; i4 < this.f14910y; i4++) {
                    View viewA2 = this.f14911z.a(this);
                    linearLayout.addView(viewA2);
                    iA2 = a(i4, iA2);
                    if (iA2 < this.f14911z.a()) {
                        this.f14911z.a(linearLayout, viewA2, iA2);
                    }
                }
                addView(linearLayout);
                i2 = iA2;
            }
        }
        if (this.A || this.f14910y >= this.f14911z.a()) {
            startFlipping();
        }
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startFlipping();
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            startFlipping();
        } else if (8 == i2 || 4 == i2) {
            stopFlipping();
        }
    }

    public void setAdapter(c cVar) {
        if (cVar == null) {
            throw new RuntimeException("adapter must not be null");
        }
        if (this.f14911z != null) {
            throw new RuntimeException("you have already set an Adapter");
        }
        this.f14911z = cVar;
        this.f14911z.a((c.a) this);
        b();
    }

    public void setFlippingLessCount(boolean z2) {
        this.A = z2;
    }

    public void setItemCount(int i2) {
        this.f14910y = i2;
    }

    public void setSingleLine(boolean z2) {
        this.f14905t = z2;
    }

    private int a(int i2, int i3) {
        if ((i2 == 0 && i3 == 0) || i3 == this.f14911z.a() - 1) {
            return 0;
        }
        return i3 + 1;
    }

    @Override // com.gongwen.marqueen.c.a
    public void a() {
        b();
    }
}
