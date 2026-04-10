package com.google.android.material.l;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.i.d;
import com.google.android.material.internal.i;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.f;
import com.google.android.material.shape.g;
import com.google.android.material.shape.l;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: TooltipDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends MaterialShapeDrawable implements i.b {

    @Nullable
    private CharSequence Q;

    @NonNull
    private final Context R;

    @Nullable
    private final Paint.FontMetrics S;

    @NonNull
    private final i T;

    @NonNull
    private final View.OnLayoutChangeListener U;

    @NonNull
    private final Rect V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f15569a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f15570b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f15571c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f15572d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f15573e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f15574f0;

    /* JADX INFO: renamed from: com.google.android.material.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TooltipDrawable.java */
    class ViewOnLayoutChangeListenerC0328a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0328a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.c(view);
        }
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.S = new Paint.FontMetrics();
        this.T = new i(this);
        this.U = new ViewOnLayoutChangeListenerC0328a();
        this.V = new Rect();
        this.f15571c0 = 1.0f;
        this.f15572d0 = 1.0f;
        this.f15573e0 = 0.5f;
        this.f15574f0 = 1.0f;
        this.R = context;
        this.T.b().density = context.getResources().getDisplayMetrics().density;
        this.T.b().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f15570b0 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.V);
    }

    private float w() {
        int i2;
        if (((this.V.right - getBounds().right) - this.f15570b0) - this.Z < 0) {
            i2 = ((this.V.right - getBounds().right) - this.f15570b0) - this.Z;
        } else {
            if (((this.V.left - getBounds().left) - this.f15570b0) + this.Z <= 0) {
                return 0.0f;
            }
            i2 = ((this.V.left - getBounds().left) - this.f15570b0) + this.Z;
        }
        return i2;
    }

    private float x() {
        this.T.b().getFontMetrics(this.S);
        Paint.FontMetrics fontMetrics = this.S;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private f y() {
        float f2 = -w();
        double dWidth = getBounds().width();
        double d2 = this.f15569a0;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        Double.isNaN(dWidth);
        float f3 = ((float) (dWidth - (d2 * dSqrt))) / 2.0f;
        return new com.google.android.material.shape.i(new g(this.f15569a0), Math.min(Math.max(f2, -f3), f3));
    }

    private float z() {
        CharSequence charSequence = this.Q;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.T.a(charSequence.toString());
    }

    public void b(@Nullable View view) {
        if (view == null) {
            return;
        }
        c(view);
        view.addOnLayoutChangeListener(this.U);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float fW = w();
        double d2 = this.f15569a0;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        double d3 = d2 * dSqrt;
        double d4 = this.f15569a0;
        Double.isNaN(d4);
        canvas.scale(this.f15571c0, this.f15572d0, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.f15573e0));
        canvas.translate(fW, (float) (-(d3 - d4)));
        super.draw(canvas);
        a(canvas);
        canvas.restore();
    }

    public void f(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.f15573e0 = 1.2f;
        this.f15571c0 = f2;
        this.f15572d0 = f2;
        this.f15574f0 = com.google.android.material.a.a.a(0.0f, 1.0f, 0.19f, 1.0f, f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.T.b().getTextSize(), this.Y);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.W * 2) + z(), this.X);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        l.b bVarM = l().m();
        bVarM.a(y());
        setShapeAppearanceModel(bVarM.a());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @NonNull
    public static a a(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    private void a(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray typedArrayC = com.google.android.material.internal.l.c(this.R, attributeSet, R$styleable.Tooltip, i2, i3, new int[0]);
        this.f15569a0 = this.R.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
        l.b bVarM = l().m();
        bVarM.a(y());
        setShapeAppearanceModel(bVarM.a());
        a(typedArrayC.getText(R$styleable.Tooltip_android_text));
        a(c.c(this.R, typedArrayC, R$styleable.Tooltip_android_textAppearance));
        a(ColorStateList.valueOf(typedArrayC.getColor(R$styleable.Tooltip_backgroundTint, com.google.android.material.c.a.b(ColorUtils.setAlphaComponent(com.google.android.material.c.a.a(this.R, R.attr.colorBackground, a.class.getCanonicalName()), TbsListener.ErrorCode.INSTALL_FROM_UNZIP), ColorUtils.setAlphaComponent(com.google.android.material.c.a.a(this.R, R$attr.colorOnBackground, a.class.getCanonicalName()), TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED)))));
        b(ColorStateList.valueOf(com.google.android.material.c.a.a(this.R, R$attr.colorSurface, a.class.getCanonicalName())));
        this.W = typedArrayC.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
        this.X = typedArrayC.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
        this.Y = typedArrayC.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
        this.Z = typedArrayC.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
        typedArrayC.recycle();
    }

    public void a(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(this.Q, charSequence)) {
            return;
        }
        this.Q = charSequence;
        this.T.a(true);
        invalidateSelf();
    }

    public void a(@Nullable d dVar) {
        this.T.a(dVar, this.R);
    }

    public void a(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.U);
    }

    @Override // com.google.android.material.internal.i.b
    public void a() {
        invalidateSelf();
    }

    private void a(@NonNull Canvas canvas) {
        if (this.Q == null) {
            return;
        }
        int iA = (int) a(getBounds());
        if (this.T.a() != null) {
            this.T.b().drawableState = getState();
            this.T.a(this.R);
            this.T.b().setAlpha((int) (this.f15574f0 * 255.0f));
        }
        CharSequence charSequence = this.Q;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iA, this.T.b());
    }

    private float a(@NonNull Rect rect) {
        return rect.centerY() - x();
    }
}
