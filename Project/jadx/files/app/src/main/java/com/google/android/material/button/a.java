package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.internal.s;
import com.google.android.material.j.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final boolean f15119t;
    private final MaterialButton a;

    @NonNull
    private l b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f15126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f15127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f15128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f15129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Drawable f15130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15131n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f15132o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f15133p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f15134q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LayerDrawable f15135r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f15136s;

    static {
        f15119t = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, @NonNull l lVar) {
        this.a = materialButton;
        this.b = lVar;
    }

    private Drawable o() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.b);
        materialShapeDrawable.a(this.a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f15127j);
        PorterDuff.Mode mode = this.f15126i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.a(this.f15125h, this.f15128k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.a(this.f15125h, this.f15131n ? com.google.android.material.c.a.a(this.a, R$attr.colorSurface) : 0);
        if (f15119t) {
            this.f15130m = new MaterialShapeDrawable(this.b);
            DrawableCompat.setTint(this.f15130m, -1);
            this.f15135r = new RippleDrawable(b.b(this.f15129l), a(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f15130m);
            return this.f15135r;
        }
        this.f15130m = new com.google.android.material.j.a(this.b);
        DrawableCompat.setTintList(this.f15130m, b.b(this.f15129l));
        this.f15135r = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f15130m});
        return a(this.f15135r);
    }

    @Nullable
    private MaterialShapeDrawable p() {
        return c(true);
    }

    private void q() {
        this.a.setInternalBackground(o());
        MaterialShapeDrawable materialShapeDrawableE = e();
        if (materialShapeDrawableE != null) {
            materialShapeDrawableE.b(this.f15136s);
        }
    }

    private void r() {
        MaterialShapeDrawable materialShapeDrawableE = e();
        MaterialShapeDrawable materialShapeDrawableP = p();
        if (materialShapeDrawableE != null) {
            materialShapeDrawableE.a(this.f15125h, this.f15128k);
            if (materialShapeDrawableP != null) {
                materialShapeDrawableP.a(this.f15125h, this.f15131n ? com.google.android.material.c.a.a(this.a, R$attr.colorSurface) : 0);
            }
        }
    }

    void a(@NonNull TypedArray typedArray) {
        this.f15120c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f15121d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f15122e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f15123f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            this.f15124g = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            a(this.b.a(this.f15124g));
            this.f15133p = true;
        }
        this.f15125h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f15126i = s.a(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f15127j = c.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f15128k = c.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f15129l = c.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f15134q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f15136s = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            n();
        } else {
            q();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart + this.f15120c, paddingTop + this.f15122e, paddingEnd + this.f15121d, paddingBottom + this.f15123f);
    }

    void b(boolean z2) {
        this.f15131n = z2;
        r();
    }

    void c(@Nullable ColorStateList colorStateList) {
        if (this.f15127j != colorStateList) {
            this.f15127j = colorStateList;
            if (e() != null) {
                DrawableCompat.setTintList(e(), this.f15127j);
            }
        }
    }

    @Nullable
    public o d() {
        LayerDrawable layerDrawable = this.f15135r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f15135r.getNumberOfLayers() > 2 ? (o) this.f15135r.getDrawable(2) : (o) this.f15135r.getDrawable(1);
    }

    void e(int i2) {
        if (this.f15125h != i2) {
            this.f15125h = i2;
            r();
        }
    }

    @Nullable
    ColorStateList f() {
        return this.f15129l;
    }

    @NonNull
    l g() {
        return this.b;
    }

    @Nullable
    ColorStateList h() {
        return this.f15128k;
    }

    int i() {
        return this.f15125h;
    }

    ColorStateList j() {
        return this.f15127j;
    }

    PorterDuff.Mode k() {
        return this.f15126i;
    }

    boolean l() {
        return this.f15132o;
    }

    boolean m() {
        return this.f15134q;
    }

    void n() {
        this.f15132o = true;
        this.a.setSupportBackgroundTintList(this.f15127j);
        this.a.setSupportBackgroundTintMode(this.f15126i);
    }

    void b(@Nullable ColorStateList colorStateList) {
        if (this.f15128k != colorStateList) {
            this.f15128k = colorStateList;
            r();
        }
    }

    @Nullable
    MaterialShapeDrawable e() {
        return c(false);
    }

    @Nullable
    private MaterialShapeDrawable c(boolean z2) {
        LayerDrawable layerDrawable = this.f15135r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f15119t) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f15135r.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0);
        }
        return (MaterialShapeDrawable) this.f15135r.getDrawable(!z2 ? 1 : 0);
    }

    public void d(@Dimension int i2) {
        b(i2, this.f15123f);
    }

    void b(int i2) {
        if (this.f15133p && this.f15124g == i2) {
            return;
        }
        this.f15124g = i2;
        this.f15133p = true;
        a(this.b.a(i2));
    }

    private void b(@NonNull l lVar) {
        if (e() != null) {
            e().setShapeAppearanceModel(lVar);
        }
        if (p() != null) {
            p().setShapeAppearanceModel(lVar);
        }
        if (d() != null) {
            d().setShapeAppearanceModel(lVar);
        }
    }

    public void c(@Dimension int i2) {
        b(this.f15122e, i2);
    }

    public int c() {
        return this.f15122e;
    }

    public int b() {
        return this.f15123f;
    }

    private void b(@Dimension int i2, @Dimension int i3) {
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f15122e;
        int i5 = this.f15123f;
        this.f15123f = i3;
        this.f15122e = i2;
        if (!this.f15132o) {
            q();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    @NonNull
    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f15120c, this.f15122e, this.f15121d, this.f15123f);
    }

    void a(@Nullable PorterDuff.Mode mode) {
        if (this.f15126i != mode) {
            this.f15126i = mode;
            if (e() == null || this.f15126i == null) {
                return;
            }
            DrawableCompat.setTintMode(e(), this.f15126i);
        }
    }

    void a(int i2, int i3) {
        Drawable drawable = this.f15130m;
        if (drawable != null) {
            drawable.setBounds(this.f15120c, this.f15122e, i3 - this.f15121d, i2 - this.f15123f);
        }
    }

    void a(int i2) {
        if (e() != null) {
            e().setTint(i2);
        }
    }

    void a(@Nullable ColorStateList colorStateList) {
        if (this.f15129l != colorStateList) {
            this.f15129l = colorStateList;
            if (f15119t && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(b.b(colorStateList));
            } else {
                if (f15119t || !(this.a.getBackground() instanceof com.google.android.material.j.a)) {
                    return;
                }
                ((com.google.android.material.j.a) this.a.getBackground()).setTintList(b.b(colorStateList));
            }
        }
    }

    int a() {
        return this.f15124g;
    }

    void a(boolean z2) {
        this.f15134q = z2;
    }

    void a(@NonNull l lVar) {
        this.b = lVar;
        b(lVar);
    }
}
