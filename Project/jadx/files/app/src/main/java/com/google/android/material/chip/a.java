package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.i.c;
import com.google.android.material.i.d;
import com.google.android.material.internal.i;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import com.google.android.material.j.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: ChipDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, i.b {

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private static final int[] f15182a1 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private static final ShapeDrawable f15183b1 = new ShapeDrawable(new OvalShape());
    private final Paint.FontMetrics A0;
    private final RectF B0;
    private final PointF C0;
    private final Path D0;

    @NonNull
    private final i E0;

    @ColorInt
    private int F0;

    @ColorInt
    private int G0;

    @ColorInt
    private int H0;

    @ColorInt
    private int I0;

    @ColorInt
    private int J0;

    @ColorInt
    private int K0;
    private boolean L0;

    @ColorInt
    private int M0;
    private int N0;

    @Nullable
    private ColorFilter O0;

    @Nullable
    private PorterDuffColorFilter P0;

    @Nullable
    private ColorStateList Q;

    @Nullable
    private ColorStateList Q0;

    @Nullable
    private ColorStateList R;

    @Nullable
    private PorterDuff.Mode R0;
    private float S;
    private int[] S0;
    private float T;
    private boolean T0;

    @Nullable
    private ColorStateList U;

    @Nullable
    private ColorStateList U0;
    private float V;

    @NonNull
    private WeakReference<InterfaceC0320a> V0;

    @Nullable
    private ColorStateList W;
    private TextUtils.TruncateAt W0;

    @Nullable
    private CharSequence X;
    private boolean X0;
    private boolean Y;
    private int Y0;

    @Nullable
    private Drawable Z;
    private boolean Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    private ColorStateList f15184a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f15185b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f15186c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f15187d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    private Drawable f15188e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    private Drawable f15189f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    @Nullable
    private ColorStateList f15190g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f15191h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    private CharSequence f15192i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f15193j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f15194k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @Nullable
    private Drawable f15195l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @Nullable
    private ColorStateList f15196m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @Nullable
    private h f15197n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @Nullable
    private h f15198o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private float f15199p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f15200q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private float f15201r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private float f15202s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private float f15203t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private float f15204u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private float f15205v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private float f15206w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @NonNull
    private final Context f15207x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private final Paint f15208y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @Nullable
    private final Paint f15209z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChipDrawable.java */
    public interface InterfaceC0320a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.T = -1.0f;
        this.f15208y0 = new Paint(1);
        this.A0 = new Paint.FontMetrics();
        this.B0 = new RectF();
        this.C0 = new PointF();
        this.D0 = new Path();
        this.N0 = 255;
        this.R0 = PorterDuff.Mode.SRC_IN;
        this.V0 = new WeakReference<>(null);
        a(context);
        this.f15207x0 = context;
        this.E0 = new i(this);
        this.X = "";
        this.E0.b().density = context.getResources().getDisplayMetrics().density;
        this.f15209z0 = null;
        Paint paint = this.f15209z0;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(f15182a1);
        a(f15182a1);
        this.X0 = true;
        if (b.a) {
            f15183b1.setTint(-1);
        }
    }

    @NonNull
    public static a a(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    private void b(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.Z0) {
            return;
        }
        this.f15208y0.setColor(this.G0);
        this.f15208y0.setStyle(Paint.Style.FILL);
        this.f15208y0.setColorFilter(l0());
        this.B0.set(rect);
        canvas.drawRoundRect(this.B0, B(), B(), this.f15208y0);
    }

    private void c(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (n0()) {
            a(rect, this.B0);
            RectF rectF = this.B0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.Z.setBounds(0, 0, (int) this.B0.width(), (int) this.B0.height());
            this.Z.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void d(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.V <= 0.0f || this.Z0) {
            return;
        }
        this.f15208y0.setColor(this.I0);
        this.f15208y0.setStyle(Paint.Style.STROKE);
        if (!this.Z0) {
            this.f15208y0.setColorFilter(l0());
        }
        RectF rectF = this.B0;
        float f2 = rect.left;
        float f3 = this.V;
        rectF.set(f2 + (f3 / 2.0f), rect.top + (f3 / 2.0f), rect.right - (f3 / 2.0f), rect.bottom - (f3 / 2.0f));
        float f4 = this.T - (this.V / 2.0f);
        canvas.drawRoundRect(this.B0, f4, f4, this.f15208y0);
    }

    private void e(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.Z0) {
            return;
        }
        this.f15208y0.setColor(this.F0);
        this.f15208y0.setStyle(Paint.Style.FILL);
        this.B0.set(rect);
        canvas.drawRoundRect(this.B0, B(), B(), this.f15208y0);
    }

    private void f(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (o0()) {
            c(rect, this.B0);
            RectF rectF = this.B0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.f15188e0.setBounds(0, 0, (int) this.B0.width(), (int) this.B0.height());
            if (b.a) {
                this.f15189f0.setBounds(this.f15188e0.getBounds());
                this.f15189f0.jumpToCurrentState();
                this.f15189f0.draw(canvas);
            } else {
                this.f15188e0.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private void h(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f15209z0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.f15209z0);
            if (n0() || m0()) {
                a(rect, this.B0);
                canvas.drawRect(this.B0, this.f15209z0);
            }
            if (this.X != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f15209z0);
            }
            if (o0()) {
                c(rect, this.B0);
                canvas.drawRect(this.B0, this.f15209z0);
            }
            this.f15209z0.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            b(rect, this.B0);
            canvas.drawRect(this.B0, this.f15209z0);
            this.f15209z0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            d(rect, this.B0);
            canvas.drawRect(this.B0, this.f15209z0);
        }
    }

    private float h0() {
        this.E0.b().getFontMetrics(this.A0);
        Paint.FontMetrics fontMetrics = this.A0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private void i(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.X != null) {
            Paint.Align alignA = a(rect, this.C0);
            e(rect, this.B0);
            if (this.E0.a() != null) {
                this.E0.b().drawableState = getState();
                this.E0.a(this.f15207x0);
            }
            this.E0.b().setTextAlign(alignA);
            int iSave = 0;
            boolean z2 = Math.round(this.E0.a(X().toString())) > Math.round(this.B0.width());
            if (z2) {
                iSave = canvas.save();
                canvas.clipRect(this.B0);
            }
            CharSequence charSequenceEllipsize = this.X;
            if (z2 && this.W0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.E0.b(), this.B0.width(), this.W0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.C0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.E0.b());
            if (z2) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean i0() {
        return this.f15194k0 && this.f15195l0 != null && this.f15193j0;
    }

    private void j(@Nullable ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            onStateChange(getState());
        }
    }

    private float j0() {
        Drawable drawable = this.L0 ? this.f15195l0 : this.Z;
        if (this.f15185b0 > 0.0f || drawable == null) {
            return this.f15185b0;
        }
        float fCeil = (float) Math.ceil(s.a(this.f15207x0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    private float k0() {
        return (this.f15185b0 > 0.0f || (this.L0 ? this.f15195l0 : this.Z) == null) ? this.f15185b0 : r0.getIntrinsicWidth();
    }

    @Nullable
    private ColorFilter l0() {
        ColorFilter colorFilter = this.O0;
        return colorFilter != null ? colorFilter : this.P0;
    }

    private boolean m0() {
        return this.f15194k0 && this.f15195l0 != null && this.L0;
    }

    private boolean n0() {
        return this.Y && this.Z != null;
    }

    private boolean o0() {
        return this.f15187d0 && this.f15188e0 != null;
    }

    private void p0() {
        this.U0 = this.T0 ? b.b(this.W) : null;
    }

    @TargetApi(21)
    private void q0() {
        this.f15189f0 = new RippleDrawable(b.b(V()), this.f15188e0, f15183b1);
    }

    @Nullable
    public ColorStateList A() {
        return this.R;
    }

    public float B() {
        return this.Z0 ? p() : this.T;
    }

    public void C(@ColorRes int i2) {
        h(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    @Nullable
    public Drawable D() {
        Drawable drawable = this.Z;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void E(@StyleRes int i2) {
        a(new d(this.f15207x0, i2));
    }

    @Nullable
    public ColorStateList F() {
        return this.f15184a0;
    }

    public float G() {
        return this.S;
    }

    public float H() {
        return this.f15199p0;
    }

    @Nullable
    public ColorStateList I() {
        return this.U;
    }

    public float J() {
        return this.V;
    }

    @Nullable
    public Drawable K() {
        Drawable drawable = this.f15188e0;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public CharSequence L() {
        return this.f15192i0;
    }

    public float M() {
        return this.f15205v0;
    }

    public float N() {
        return this.f15191h0;
    }

    public float O() {
        return this.f15204u0;
    }

    @NonNull
    public int[] P() {
        return this.S0;
    }

    @Nullable
    public ColorStateList Q() {
        return this.f15190g0;
    }

    public TextUtils.TruncateAt R() {
        return this.W0;
    }

    @Nullable
    public h S() {
        return this.f15198o0;
    }

    public float T() {
        return this.f15201r0;
    }

    public float U() {
        return this.f15200q0;
    }

    @Nullable
    public ColorStateList V() {
        return this.W;
    }

    @Nullable
    public h W() {
        return this.f15197n0;
    }

    @Nullable
    public CharSequence X() {
        return this.X;
    }

    @Nullable
    public d Y() {
        return this.E0.a();
    }

    public float Z() {
        return this.f15203t0;
    }

    public float a0() {
        return this.f15202s0;
    }

    public boolean b0() {
        return this.T0;
    }

    public boolean c0() {
        return this.f15193j0;
    }

    public boolean d0() {
        return e(this.f15188e0);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.N0;
        int iA = i2 < 255 ? com.google.android.material.b.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        e(canvas, bounds);
        b(canvas, bounds);
        if (this.Z0) {
            super.draw(canvas);
        }
        d(canvas, bounds);
        g(canvas, bounds);
        c(canvas, bounds);
        a(canvas, bounds);
        if (this.X0) {
            i(canvas, bounds);
        }
        f(canvas, bounds);
        h(canvas, bounds);
        if (this.N0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public boolean e0() {
        return this.f15187d0;
    }

    protected void f0() {
        InterfaceC0320a interfaceC0320a = this.V0.get();
        if (interfaceC0320a != null) {
            interfaceC0320a.a();
        }
    }

    public void g(boolean z2) {
        if (this.T0 != z2) {
            this.T0 = z2;
            p0();
            onStateChange(getState());
        }
    }

    boolean g0() {
        return this.X0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.N0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.O0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.S;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f15199p0 + w() + this.f15202s0 + this.E0.a(X().toString()) + this.f15203t0 + x() + this.f15206w0), this.Y0);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.Z0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.T);
        } else {
            outline.setRoundRect(bounds, this.T);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return i(this.Q) || i(this.R) || i(this.U) || (this.T0 && i(this.U0)) || b(this.E0.a()) || i0() || e(this.Z) || e(this.f15195l0) || i(this.Q0);
    }

    public void k(float f2) {
        if (this.V != f2) {
            this.V = f2;
            this.f15208y0.setStrokeWidth(f2);
            if (this.Z0) {
                super.e(f2);
            }
            invalidateSelf();
        }
    }

    public void l(@DrawableRes int i2) {
        b(AppCompatResources.getDrawable(this.f15207x0, i2));
    }

    public void m(@DimenRes int i2) {
        h(this.f15207x0.getResources().getDimension(i2));
    }

    public void n(@ColorRes int i2) {
        e(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    public void o(@BoolRes int i2) {
        d(this.f15207x0.getResources().getBoolean(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (n0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Z, i2);
        }
        if (m0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f15195l0, i2);
        }
        if (o0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f15188e0, i2);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        boolean zOnLevelChange = super.onLevelChange(i2);
        if (n0()) {
            zOnLevelChange |= this.Z.setLevel(i2);
        }
        if (m0()) {
            zOnLevelChange |= this.f15195l0.setLevel(i2);
        }
        if (o0()) {
            zOnLevelChange |= this.f15188e0.setLevel(i2);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.Z0) {
            super.onStateChange(iArr);
        }
        return a(iArr, P());
    }

    public void p(@DimenRes int i2) {
        i(this.f15207x0.getResources().getDimension(i2));
    }

    public void q(@DimenRes int i2) {
        j(this.f15207x0.getResources().getDimension(i2));
    }

    public void r(@ColorRes int i2) {
        f(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    public void s(@DimenRes int i2) {
        k(this.f15207x0.getResources().getDimension(i2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.N0 != i2) {
            this.N0 = i2;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.O0 != colorFilter) {
            this.O0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.Q0 != colorStateList) {
            this.Q0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.R0 != mode) {
            this.R0 = mode;
            this.P0 = com.google.android.material.e.a.a(this, this.Q0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (n0()) {
            visible |= this.Z.setVisible(z2, z3);
        }
        if (m0()) {
            visible |= this.f15195l0.setVisible(z2, z3);
        }
        if (o0()) {
            visible |= this.f15188e0.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t(@DimenRes int i2) {
        l(this.f15207x0.getResources().getDimension(i2));
    }

    public void u(@DrawableRes int i2) {
        c(AppCompatResources.getDrawable(this.f15207x0, i2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v(@DimenRes int i2) {
        m(this.f15207x0.getResources().getDimension(i2));
    }

    float w() {
        if (n0() || m0()) {
            return this.f15200q0 + k0() + this.f15201r0;
        }
        return 0.0f;
    }

    float x() {
        if (o0()) {
            return this.f15204u0 + this.f15191h0 + this.f15205v0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable y() {
        return this.f15195l0;
    }

    @Nullable
    public ColorStateList z() {
        return this.f15196m0;
    }

    public void A(@DimenRes int i2) {
        p(this.f15207x0.getResources().getDimension(i2));
    }

    public void B(@Px int i2) {
        this.Y0 = i2;
    }

    public float C() {
        return this.f15206w0;
    }

    public void D(@AnimatorRes int i2) {
        b(h.a(this.f15207x0, i2));
    }

    public float E() {
        return this.f15185b0;
    }

    public void F(@DimenRes int i2) {
        q(this.f15207x0.getResources().getDimension(i2));
    }

    public void G(@DimenRes int i2) {
        r(this.f15207x0.getResources().getDimension(i2));
    }

    public void l(float f2) {
        if (this.f15205v0 != f2) {
            this.f15205v0 = f2;
            invalidateSelf();
            if (o0()) {
                f0();
            }
        }
    }

    public void m(float f2) {
        if (this.f15191h0 != f2) {
            this.f15191h0 = f2;
            invalidateSelf();
            if (o0()) {
                f0();
            }
        }
    }

    public void n(float f2) {
        if (this.f15204u0 != f2) {
            this.f15204u0 = f2;
            invalidateSelf();
            if (o0()) {
                f0();
            }
        }
    }

    public void o(float f2) {
        if (this.f15201r0 != f2) {
            float fW = w();
            this.f15201r0 = f2;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void p(float f2) {
        if (this.f15200q0 != f2) {
            float fW = w();
            this.f15200q0 = f2;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void q(float f2) {
        if (this.f15203t0 != f2) {
            this.f15203t0 = f2;
            invalidateSelf();
            f0();
        }
    }

    public void r(float f2) {
        if (this.f15202s0 != f2) {
            this.f15202s0 = f2;
            invalidateSelf();
            f0();
        }
    }

    public void y(@AnimatorRes int i2) {
        a(h.a(this.f15207x0, i2));
    }

    public void z(@DimenRes int i2) {
        o(this.f15207x0.getResources().getDimension(i2));
    }

    private void a(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray typedArrayC = l.c(this.f15207x0, attributeSet, R$styleable.Chip, i2, i3, new int[0]);
        this.Z0 = typedArrayC.hasValue(R$styleable.Chip_shapeAppearance);
        j(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_chipSurfaceColor));
        d(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_chipBackgroundColor));
        i(typedArrayC.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        if (typedArrayC.hasValue(R$styleable.Chip_chipCornerRadius)) {
            f(typedArrayC.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        }
        f(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_chipStrokeColor));
        k(typedArrayC.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        h(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_rippleColor));
        b(typedArrayC.getText(R$styleable.Chip_android_text));
        d dVarC = c.c(this.f15207x0, typedArrayC, R$styleable.Chip_android_textAppearance);
        dVarC.f15432k = typedArrayC.getDimension(R$styleable.Chip_android_textSize, dVarC.f15432k);
        a(dVarC);
        int i4 = typedArrayC.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        d(typedArrayC.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            d(typedArrayC.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        b(c.b(this.f15207x0, typedArrayC, R$styleable.Chip_chipIcon));
        if (typedArrayC.hasValue(R$styleable.Chip_chipIconTint)) {
            e(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_chipIconTint));
        }
        h(typedArrayC.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        e(typedArrayC.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            e(typedArrayC.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        c(c.b(this.f15207x0, typedArrayC, R$styleable.Chip_closeIcon));
        g(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_closeIconTint));
        m(typedArrayC.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        b(typedArrayC.getBoolean(R$styleable.Chip_android_checkable, false));
        c(typedArrayC.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            c(typedArrayC.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        a(c.b(this.f15207x0, typedArrayC, R$styleable.Chip_checkedIcon));
        if (typedArrayC.hasValue(R$styleable.Chip_checkedIconTint)) {
            c(c.a(this.f15207x0, typedArrayC, R$styleable.Chip_checkedIconTint));
        }
        b(h.a(this.f15207x0, typedArrayC, R$styleable.Chip_showMotionSpec));
        a(h.a(this.f15207x0, typedArrayC, R$styleable.Chip_hideMotionSpec));
        j(typedArrayC.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        p(typedArrayC.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        o(typedArrayC.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        r(typedArrayC.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        q(typedArrayC.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        n(typedArrayC.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        l(typedArrayC.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        g(typedArrayC.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        B(typedArrayC.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayC.recycle();
    }

    public void w(@DimenRes int i2) {
        n(this.f15207x0.getResources().getDimension(i2));
    }

    public void x(@ColorRes int i2) {
        g(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    @Deprecated
    public void j(@DimenRes int i2) {
        f(this.f15207x0.getResources().getDimension(i2));
    }

    private void g(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f15208y0.setColor(this.J0);
        this.f15208y0.setStyle(Paint.Style.FILL);
        this.B0.set(rect);
        if (!this.Z0) {
            canvas.drawRoundRect(this.B0, B(), B(), this.f15208y0);
        } else {
            a(new RectF(rect), this.D0);
            super.a(canvas, this.f15208y0, this.D0, d());
        }
    }

    public void j(float f2) {
        if (this.f15199p0 != f2) {
            this.f15199p0 = f2;
            invalidateSelf();
            f0();
        }
    }

    private void e(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.X != null) {
            float fW = this.f15199p0 + w() + this.f15202s0;
            float fX = this.f15206w0 + x() + this.f15203t0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + fW;
                rectF.right = rect.right - fX;
            } else {
                rectF.left = rect.left + fX;
                rectF.right = rect.right - fW;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void b(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (o0()) {
            float f2 = this.f15206w0 + this.f15205v0 + this.f15191h0 + this.f15204u0 + this.f15203t0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    public void k(@DimenRes int i2) {
        g(this.f15207x0.getResources().getDimension(i2));
    }

    private void c(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (o0()) {
            float f2 = this.f15206w0 + this.f15205v0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f2;
                rectF.left = rectF.right - this.f15191h0;
            } else {
                rectF.left = rect.left + f2;
                rectF.right = rectF.left + this.f15191h0;
            }
            float fExactCenterY = rect.exactCenterY();
            float f3 = this.f15191h0;
            rectF.top = fExactCenterY - (f3 / 2.0f);
            rectF.bottom = rectF.top + f3;
        }
    }

    private void d(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (o0()) {
            float f2 = this.f15206w0 + this.f15205v0 + this.f15191h0 + this.f15204u0 + this.f15203t0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void g(@Nullable ColorStateList colorStateList) {
        if (this.f15190g0 != colorStateList) {
            this.f15190g0 = colorStateList;
            if (o0()) {
                DrawableCompat.setTintList(this.f15188e0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    private static boolean b(@Nullable d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void f(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Deprecated
    public void f(float f2) {
        if (this.T != f2) {
            this.T = f2;
            setShapeAppearanceModel(l().a(f2));
        }
    }

    public void b(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.X, charSequence)) {
            return;
        }
        this.X = charSequence;
        this.E0.a(true);
        invalidateSelf();
        f0();
    }

    private static boolean e(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public void f(@Nullable ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (this.Z0) {
                b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void g(@ColorRes int i2) {
        c(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    public void e(@Nullable ColorStateList colorStateList) {
        this.f15186c0 = true;
        if (this.f15184a0 != colorStateList) {
            this.f15184a0 = colorStateList;
            if (n0()) {
                DrawableCompat.setTintList(this.Z, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void g(float f2) {
        if (this.f15206w0 != f2) {
            this.f15206w0 = f2;
            invalidateSelf();
            f0();
        }
    }

    private void d(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f15188e0) {
            if (drawable.isStateful()) {
                drawable.setState(P());
            }
            DrawableCompat.setTintList(drawable, this.f15190g0);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.Z;
        if (drawable == drawable2 && this.f15186c0) {
            DrawableCompat.setTintList(drawable2, this.f15184a0);
        }
    }

    public void c(@Nullable Drawable drawable) {
        Drawable drawableK = K();
        if (drawableK != drawable) {
            float fX = x();
            this.f15188e0 = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (b.a) {
                q0();
            }
            float fX2 = x();
            f(drawableK);
            if (o0()) {
                d(this.f15188e0);
            }
            invalidateSelf();
            if (fX != fX2) {
                f0();
            }
        }
    }

    private static boolean i(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public void b(@Nullable Drawable drawable) {
        Drawable drawableD = D();
        if (drawableD != drawable) {
            float fW = w();
            this.Z = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fW2 = w();
            f(drawableD);
            if (n0()) {
                d(this.Z);
            }
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void h(@Nullable ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            p0();
            onStateChange(getState());
        }
    }

    public void i(@ColorRes int i2) {
        d(AppCompatResources.getColorStateList(this.f15207x0, i2));
    }

    public void f(@DrawableRes int i2) {
        a(AppCompatResources.getDrawable(this.f15207x0, i2));
    }

    public void i(float f2) {
        if (this.S != f2) {
            this.S = f2;
            invalidateSelf();
            f0();
        }
    }

    void f(boolean z2) {
        this.X0 = z2;
    }

    public void e(boolean z2) {
        if (this.f15187d0 != z2) {
            boolean zO0 = o0();
            this.f15187d0 = z2;
            boolean zO02 = o0();
            if (zO0 != zO02) {
                if (zO02) {
                    d(this.f15188e0);
                } else {
                    f(this.f15188e0);
                }
                invalidateSelf();
                f0();
            }
        }
    }

    public void h(float f2) {
        if (this.f15185b0 != f2) {
            float fW = w();
            this.f15185b0 = f2;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void b(boolean z2) {
        if (this.f15193j0 != z2) {
            this.f15193j0 = z2;
            float fW = w();
            if (!z2 && this.L0) {
                this.L0 = false;
            }
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void c(boolean z2) {
        if (this.f15194k0 != z2) {
            boolean zM0 = m0();
            this.f15194k0 = z2;
            boolean zM02 = m0();
            if (zM0 != zM02) {
                if (zM02) {
                    d(this.f15195l0);
                } else {
                    f(this.f15195l0);
                }
                invalidateSelf();
                f0();
            }
        }
    }

    public void h(@BoolRes int i2) {
        c(this.f15207x0.getResources().getBoolean(i2));
    }

    public void d(@Nullable ColorStateList colorStateList) {
        if (this.R != colorStateList) {
            this.R = colorStateList;
            onStateChange(getState());
        }
    }

    public void e(@BoolRes int i2) {
        b(this.f15207x0.getResources().getBoolean(i2));
    }

    public void d(boolean z2) {
        if (this.Y != z2) {
            boolean zN0 = n0();
            this.Y = z2;
            boolean zN02 = n0();
            if (zN0 != zN02) {
                if (zN02) {
                    d(this.Z);
                } else {
                    f(this.Z);
                }
                invalidateSelf();
                f0();
            }
        }
    }

    public void b(@Nullable h hVar) {
        this.f15197n0 = hVar;
    }

    public void c(@Nullable ColorStateList colorStateList) {
        if (this.f15196m0 != colorStateList) {
            this.f15196m0 = colorStateList;
            if (i0()) {
                DrawableCompat.setTintList(this.f15195l0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void a(@Nullable InterfaceC0320a interfaceC0320a) {
        this.V0 = new WeakReference<>(interfaceC0320a);
    }

    public void a(@NonNull RectF rectF) {
        d(getBounds(), rectF);
    }

    private void a(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (m0()) {
            a(rect, this.B0);
            RectF rectF = this.B0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.f15195l0.setBounds(0, 0, (int) this.B0.width(), (int) this.B0.height());
            this.f15195l0.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void a(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (n0() || m0()) {
            float f2 = this.f15199p0 + this.f15200q0;
            float fK0 = k0();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + f2;
                rectF.right = rectF.left + fK0;
            } else {
                rectF.right = rect.right - f2;
                rectF.left = rectF.right - fK0;
            }
            float fJ0 = j0();
            rectF.top = rect.exactCenterY() - (fJ0 / 2.0f);
            rectF.bottom = rectF.top + fJ0;
        }
    }

    @NonNull
    Paint.Align a(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.X != null) {
            float fW = this.f15199p0 + w() + this.f15202s0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + fW;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fW;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - h0();
        }
        return align;
    }

    public boolean a(@NonNull int[] iArr) {
        if (Arrays.equals(this.S0, iArr)) {
            return false;
        }
        this.S0 = iArr;
        if (o0()) {
            return a(getState(), iArr);
        }
        return false;
    }

    @Override // com.google.android.material.internal.i.b
    public void a() {
        f0();
        invalidateSelf();
    }

    private boolean a(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z2;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.Q;
        int iA = a(colorStateList != null ? colorStateList.getColorForState(iArr, this.F0) : 0);
        if (this.F0 != iA) {
            this.F0 = iA;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.R;
        int iA2 = a(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.G0) : 0);
        if (this.G0 != iA2) {
            this.G0 = iA2;
            zOnStateChange = true;
        }
        int iB = com.google.android.material.c.a.b(iA, iA2);
        if ((this.H0 != iB) | (f() == null)) {
            this.H0 = iB;
            a(ColorStateList.valueOf(this.H0));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.U;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.I0) : 0;
        if (this.I0 != colorForState) {
            this.I0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.U0 == null || !b.a(iArr)) ? 0 : this.U0.getColorForState(iArr, this.J0);
        if (this.J0 != colorForState2) {
            this.J0 = colorForState2;
            if (this.T0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.E0.a() == null || this.E0.a().a == null) ? 0 : this.E0.a().a.getColorForState(iArr, this.K0);
        if (this.K0 != colorForState3) {
            this.K0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z3 = a(getState(), R.attr.state_checked) && this.f15193j0;
        if (this.L0 == z3 || this.f15195l0 == null) {
            z2 = false;
        } else {
            float fW = w();
            this.L0 = z3;
            if (fW != w()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                zOnStateChange = true;
                z2 = false;
            }
        }
        ColorStateList colorStateList4 = this.Q0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.M0) : 0;
        if (this.M0 != colorForState4) {
            this.M0 = colorForState4;
            this.P0 = com.google.android.material.e.a.a(this, this.Q0, this.R0);
            zOnStateChange = true;
        }
        if (e(this.Z)) {
            zOnStateChange |= this.Z.setState(iArr);
        }
        if (e(this.f15195l0)) {
            zOnStateChange |= this.f15195l0.setState(iArr);
        }
        if (e(this.f15188e0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            zOnStateChange |= this.f15188e0.setState(iArr3);
        }
        if (b.a && e(this.f15189f0)) {
            zOnStateChange |= this.f15189f0.setState(iArr2);
        }
        if (zOnStateChange) {
            invalidateSelf();
        }
        if (z2) {
            f0();
        }
        return zOnStateChange;
    }

    private static boolean a(@Nullable int[] iArr, @AttrRes int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(@Nullable d dVar) {
        this.E0.a(dVar, this.f15207x0);
    }

    public void a(@Nullable TextUtils.TruncateAt truncateAt) {
        this.W0 = truncateAt;
    }

    public void a(@Nullable CharSequence charSequence) {
        if (this.f15192i0 != charSequence) {
            this.f15192i0 = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public void a(@Nullable Drawable drawable) {
        if (this.f15195l0 != drawable) {
            float fW = w();
            this.f15195l0 = drawable;
            float fW2 = w();
            f(this.f15195l0);
            d(this.f15195l0);
            invalidateSelf();
            if (fW != fW2) {
                f0();
            }
        }
    }

    public void a(@Nullable h hVar) {
        this.f15198o0 = hVar;
    }
}
