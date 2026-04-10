package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.amgcyo.cuttadon.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/amgcyo/cuttadon/view/otherview/TextDrawable;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawableLeft", "Landroid/graphics/drawable/Drawable;", "drawableRight", "drawableTop", "leftHeight", "leftWidth", "mContext", "rightHeight", "rightWidth", "topHeight", "topWidth", "dip2px", "dpValue", "", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDrawableLeft", "setDrawableLeftColor", com.anythink.expressad.foundation.h.i.f10646d, "setDrawableLigtColor", "setDrawableRight", "drawableRightRes", "setDrawableRightColor", "setDrawableTop", "tintDrawable", com.anythink.expressad.foundation.h.i.f10645c, "colors", "Landroid/content/res/ColorStateList;", "app_fmydRelease"}, k = 1, mv = {1, 1, 16})
public final class TextDrawable extends TextView {
    private int A;
    private Context B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Drawable f5085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Drawable f5086t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Drawable f5087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5088v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5089w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5090x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5091y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5092z;

    @JvmOverloads
    public TextDrawable(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public TextDrawable(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TextDrawable(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.f fVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextDrawable);
        this.f5085s = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f5086t = typedArrayObtainStyledAttributes.getDrawable(3);
        this.f5087u = typedArrayObtainStyledAttributes.getDrawable(6);
        if (this.f5085s != null) {
            this.f5088v = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, a(context, 20.0f));
            this.f5091y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, a(context, 20.0f));
        }
        if (this.f5086t != null) {
            this.f5089w = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, a(context, 20.0f));
            this.f5092z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, a(context, 20.0f));
        }
        if (this.f5087u != null) {
            this.f5090x = typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, a(context, 20.0f));
            this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, a(context, 20.0f));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        super.onDraw(canvas);
        setCompoundDrawables(this.f5085s, this.f5087u, this.f5086t, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Drawable drawable = this.f5085s;
        if (drawable != null) {
            if (drawable == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            drawable.setBounds(0, 0, this.f5088v, this.f5091y);
        }
        Drawable drawable2 = this.f5086t;
        if (drawable2 != null) {
            if (drawable2 == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            drawable2.setBounds(0, 0, this.f5089w, this.f5092z);
        }
        Drawable drawable3 = this.f5087u;
        if (drawable3 != null) {
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, this.f5090x, this.A);
            } else {
                kotlin.jvm.internal.i.a();
                throw null;
            }
        }
    }

    public final void setDrawableLeft(@NotNull Drawable drawableLeft) {
        this.f5085s = drawableLeft;
        invalidate();
    }

    public final void setDrawableLeftColor(int color) {
        Drawable drawable = this.f5085s;
        if (drawable != null) {
            if (drawable == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            a(drawable, ColorStateList.valueOf(color));
        }
        invalidate();
    }

    public final void setDrawableLigtColor(int color) {
        Drawable drawable = this.f5085s;
        if (drawable != null) {
            if (drawable == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            a(drawable, ColorStateList.valueOf(color));
        }
        invalidate();
    }

    public final void setDrawableRight(@Nullable Drawable drawableRight) {
        this.f5086t = drawableRight;
        invalidate();
    }

    public final void setDrawableRightColor(int color) {
        Drawable drawable = this.f5086t;
        if (drawable != null) {
            if (drawable == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            a(drawable, ColorStateList.valueOf(color));
        }
        invalidate();
    }

    public final void setDrawableTop(@NotNull Drawable drawableTop) {
        this.f5087u = drawableTop;
        invalidate();
    }

    @JvmOverloads
    public TextDrawable(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = context;
        a(context, attributeSet);
    }

    public final void setDrawableRight(int drawableRightRes) {
        Context context = this.B;
        if (context != null) {
            this.f5086t = context.getResources().getDrawable(drawableRightRes, null);
            invalidate();
        } else {
            kotlin.jvm.internal.i.a();
            throw null;
        }
    }

    public final int a(@NotNull Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final Drawable a(Drawable drawable, ColorStateList colorStateList) {
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(drawableWrap, colorStateList);
        return drawableWrap;
    }
}
