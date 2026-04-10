package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.j.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.d;
import com.google.android.material.shape.e;
import com.google.android.material.shape.k;
import com.google.android.material.shape.l;

/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f15145t = {R.attr.state_checked};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final double f15146u = Math.cos(Math.toRadians(45.0d));

    @NonNull
    private final MaterialCardView a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f15147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f15148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Dimension
    private int f15149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Dimension
    private int f15150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Dimension
    private int f15151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Drawable f15152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f15153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f15154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f15155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private l f15156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private ColorStateList f15157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private Drawable f15158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private LayerDrawable f15159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f15160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f15161q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f15163s;

    @NonNull
    private final Rect b = new Rect();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f15162r = false;

    /* JADX INFO: renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCardViewHelper.java */
    class C0319a extends InsetDrawable {
        C0319a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.a = materialCardView;
        this.f15147c = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i2, i3);
        this.f15147c.a(materialCardView.getContext());
        this.f15147c.b(-12303292);
        l.b bVarM = this.f15147c.l().m();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
            bVarM.a(typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f15148d = new MaterialShapeDrawable();
        a(bVarM.a());
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean A() {
        return Build.VERSION.SDK_INT >= 21 && this.f15147c.u();
    }

    @NonNull
    private Drawable B() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f15153i;
        if (drawable != null) {
            stateListDrawable.addState(f15145t, drawable);
        }
        return stateListDrawable;
    }

    @NonNull
    private Drawable C() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f15160p = E();
        this.f15160p.a(this.f15154j);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f15160p);
        return stateListDrawable;
    }

    @NonNull
    private Drawable D() {
        if (!b.a) {
            return C();
        }
        this.f15161q = E();
        return new RippleDrawable(this.f15154j, null, this.f15161q);
    }

    @NonNull
    private MaterialShapeDrawable E() {
        return new MaterialShapeDrawable(this.f15156l);
    }

    @NonNull
    private Drawable F() {
        if (this.f15158n == null) {
            this.f15158n = D();
        }
        if (this.f15159o == null) {
            this.f15159o = new LayerDrawable(new Drawable[]{this.f15158n, this.f15148d, B()});
            this.f15159o.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f15159o;
    }

    private float G() {
        if (!this.a.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.a.getUseCompatPadding()) {
            return 0.0f;
        }
        double d2 = 1.0d - f15146u;
        double cardViewRadius = this.a.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d2 * cardViewRadius);
    }

    private boolean H() {
        return this.a.getPreventCornerOverlap() && !A();
    }

    private boolean I() {
        return this.a.getPreventCornerOverlap() && A() && this.a.getUseCompatPadding();
    }

    private void J() {
        Drawable drawable;
        if (b.a && (drawable = this.f15158n) != null) {
            ((RippleDrawable) drawable).setColor(this.f15154j);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f15160p;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.a(this.f15154j);
        }
    }

    private float x() {
        return Math.max(Math.max(a(this.f15156l.i(), this.f15147c.p()), a(this.f15156l.k(), this.f15147c.q())), Math.max(a(this.f15156l.d(), this.f15147c.c()), a(this.f15156l.b(), this.f15147c.b())));
    }

    private float y() {
        return this.a.getMaxCardElevation() + (I() ? x() : 0.0f);
    }

    private float z() {
        return (this.a.getMaxCardElevation() * 1.5f) + (I() ? x() : 0.0f);
    }

    void a(@NonNull TypedArray typedArray) {
        this.f15157m = c.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        if (this.f15157m == null) {
            this.f15157m = ColorStateList.valueOf(-1);
        }
        this.f15151g = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        this.f15163s = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.a.setLongClickable(this.f15163s);
        this.f15155k = c.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        a(c.b(this.a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        b(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0));
        a(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0));
        this.f15154j = c.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        if (this.f15154j == null) {
            this.f15154j = ColorStateList.valueOf(com.google.android.material.c.a.a(this.a, R$attr.colorControlHighlight));
        }
        b(c.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        J();
        u();
        w();
        this.a.setBackgroundInternal(b(this.f15147c));
        this.f15152h = this.a.isClickable() ? F() : this.f15148d;
        this.a.setForeground(b(this.f15152h));
    }

    @NonNull
    MaterialShapeDrawable b() {
        return this.f15147c;
    }

    void c(@Dimension int i2) {
        if (i2 == this.f15151g) {
            return;
        }
        this.f15151g = i2;
        w();
    }

    ColorStateList d() {
        return this.f15148d.f();
    }

    void e(ColorStateList colorStateList) {
        if (this.f15157m == colorStateList) {
            return;
        }
        this.f15157m = colorStateList;
        w();
    }

    @Dimension
    int f() {
        return this.f15149e;
    }

    @Dimension
    int g() {
        return this.f15150f;
    }

    @Nullable
    ColorStateList h() {
        return this.f15155k;
    }

    float i() {
        return this.f15147c.p();
    }

    @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d)
    float j() {
        return this.f15147c.g();
    }

    @Nullable
    ColorStateList k() {
        return this.f15154j;
    }

    l l() {
        return this.f15156l;
    }

    @ColorInt
    int m() {
        ColorStateList colorStateList = this.f15157m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    ColorStateList n() {
        return this.f15157m;
    }

    @Dimension
    int o() {
        return this.f15151g;
    }

    @NonNull
    Rect p() {
        return this.b;
    }

    boolean q() {
        return this.f15162r;
    }

    boolean r() {
        return this.f15163s;
    }

    void s() {
        Drawable drawable = this.f15152h;
        this.f15152h = this.a.isClickable() ? F() : this.f15148d;
        Drawable drawable2 = this.f15152h;
        if (drawable != drawable2) {
            c(drawable2);
        }
    }

    void t() {
        int iX = (int) ((H() || I() ? x() : 0.0f) - G());
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.a(rect.left + iX, rect.top + iX, rect.right + iX, rect.bottom + iX);
    }

    void u() {
        this.f15147c.b(this.a.getCardElevation());
    }

    void v() {
        if (!q()) {
            this.a.setBackgroundInternal(b(this.f15147c));
        }
        this.a.setForeground(b(this.f15152h));
    }

    void w() {
        this.f15148d.a(this.f15151g, this.f15157m);
    }

    void b(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f15148d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.a(colorStateList);
    }

    void d(@Nullable ColorStateList colorStateList) {
        this.f15154j = colorStateList;
        J();
    }

    ColorStateList c() {
        return this.f15147c.f();
    }

    @Nullable
    Drawable e() {
        return this.f15153i;
    }

    void b(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.f15147c.c(f2);
        MaterialShapeDrawable materialShapeDrawable = this.f15148d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.c(f2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f15161q;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.c(f2);
        }
    }

    void c(@Nullable ColorStateList colorStateList) {
        this.f15155k = colorStateList;
        Drawable drawable = this.f15153i;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    private void c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.a.getForeground()).setDrawable(drawable);
        } else {
            this.a.setForeground(b(drawable));
        }
    }

    void b(boolean z2) {
        this.f15163s = z2;
    }

    void b(@Dimension int i2) {
        this.f15150f = i2;
    }

    @NonNull
    private Drawable b(Drawable drawable) {
        int iCeil;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(z());
            iCeil = (int) Math.ceil(y());
            i2 = iCeil2;
        } else {
            iCeil = 0;
            i2 = 0;
        }
        return new C0319a(this, drawable, iCeil, i2, iCeil, i2);
    }

    void a(boolean z2) {
        this.f15162r = z2;
    }

    void a(ColorStateList colorStateList) {
        this.f15147c.a(colorStateList);
    }

    void a(int i2, int i3, int i4, int i5) {
        this.b.set(i2, i3, i4, i5);
        t();
    }

    void a(float f2) {
        a(this.f15156l.a(f2));
        this.f15152h.invalidateSelf();
        if (I() || H()) {
            t();
        }
        if (I()) {
            v();
        }
    }

    void a(@Nullable Drawable drawable) {
        this.f15153i = drawable;
        if (drawable != null) {
            this.f15153i = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(this.f15153i, this.f15155k);
        }
        if (this.f15159o != null) {
            this.f15159o.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, B());
        }
    }

    void a(@Dimension int i2) {
        this.f15149e = i2;
    }

    void a(int i2, int i3) {
        int i4;
        int i5;
        if (this.f15159o != null) {
            int i6 = this.f15149e;
            int i7 = this.f15150f;
            int iCeil = (i2 - i6) - i7;
            int iCeil2 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(z() * 2.0f);
                iCeil -= (int) Math.ceil(y() * 2.0f);
            }
            int i8 = iCeil2;
            int i9 = this.f15149e;
            if (ViewCompat.getLayoutDirection(this.a) == 1) {
                i5 = iCeil;
                i4 = i9;
            } else {
                i4 = iCeil;
                i5 = i9;
            }
            this.f15159o.setLayerInset(2, i4, this.f15149e, i5, i8);
        }
    }

    @RequiresApi(api = 23)
    void a() {
        Drawable drawable = this.f15158n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.f15158n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.f15158n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    void a(@NonNull l lVar) {
        this.f15156l = lVar;
        this.f15147c.setShapeAppearanceModel(lVar);
        this.f15147c.a(!r0.u());
        MaterialShapeDrawable materialShapeDrawable = this.f15148d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(lVar);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f15161q;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(lVar);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f15160p;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(lVar);
        }
    }

    private float a(d dVar, float f2) {
        if (dVar instanceof k) {
            double d2 = 1.0d - f15146u;
            double d3 = f2;
            Double.isNaN(d3);
            return (float) (d2 * d3);
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }
}
