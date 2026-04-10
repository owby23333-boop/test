package com.amgcyo.cuttadon.view.otherview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class DrawTextImageView extends RadioButton {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4970s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4971t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4972u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f4973v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Drawable f4974w;

    public DrawTextImageView(Context context) {
        super(context, null);
        this.f4970s = 20;
        this.f4971t = 20;
        this.f4972u = 255;
    }

    private void a(Drawable drawable) {
        int i2 = this.f4973v;
        if (i2 == 1) {
            setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (i2 == 2) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (i2 == 3) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else if (i2 == 4) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        if (drawable != null) {
            drawable.setBounds(0, 0, this.f4970s, this.f4971t);
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.f4970s, this.f4971t);
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.f4970s, this.f4971t);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, this.f4970s, this.f4971t);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setDrawable(Drawable drawable) {
        this.f4974w = drawable;
        a(drawable);
    }

    public void setSignStates(boolean z2) {
        Drawable drawable = this.f4974w;
        if (drawable == null || !z2) {
            return;
        }
        this.f4972u = 125;
        drawable.mutate().setAlpha(this.f4972u);
        setChecked(true);
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4970s = 20;
        this.f4971t = 20;
        this.f4972u = 255;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DrawTextImageView);
        this.f4970s = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, this.f4970s);
        this.f4971t = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, this.f4971t);
        this.f4972u = typedArrayObtainStyledAttributes.getInteger(1, this.f4972u);
        this.f4974w = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f4973v = typedArrayObtainStyledAttributes.getInt(4, 1);
        typedArrayObtainStyledAttributes.recycle();
        a(this.f4974w);
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4970s = 20;
        this.f4971t = 20;
        this.f4972u = 255;
    }
}
