package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.i.a;
import com.google.android.material.internal.StaticLayoutBuilderCompat;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final boolean f15484j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @NonNull
    private static final Paint f15485k0;
    private com.google.android.material.i.a A;

    @Nullable
    private CharSequence B;

    @Nullable
    private CharSequence C;
    private boolean D;
    private boolean F;

    @Nullable
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;
    private final View a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private StaticLayout f15486a0;
    private boolean b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f15487b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f15488c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f15489c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15490d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f15491d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15492e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private CharSequence f15493e0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15496g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f15507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f15508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f15509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f15510r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f15511s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f15512t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f15513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f15514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Typeface f15515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f15516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f15517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.google.android.material.i.a f15518z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15503k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15504l = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f15505m = 15.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f15506n = 15.0f;
    private boolean E = true;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f15495f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float f15497g0 = 0.0f;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f15499h0 = 1.0f;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f15501i0 = StaticLayoutBuilderCompat.f15468n;

    @NonNull
    private final TextPaint M = new TextPaint(129);

    @NonNull
    private final TextPaint N = new TextPaint(this.M);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final Rect f15500i = new Rect();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final Rect f15498h = new Rect();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final RectF f15502j = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f15494f = w();

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    class C0325a implements a.InterfaceC0324a {
        C0325a() {
        }

        @Override // com.google.android.material.i.a.InterfaceC0324a
        public void a(Typeface typeface) {
            a.this.a(typeface);
        }
    }

    /* JADX INFO: compiled from: CollapsingTextHelper.java */
    class b implements a.InterfaceC0324a {
        b() {
        }

        @Override // com.google.android.material.i.a.InterfaceC0324a
        public void a(Typeface typeface) {
            a.this.b(typeface);
        }
    }

    static {
        f15484j0 = Build.VERSION.SDK_INT < 18;
        f15485k0 = null;
        Paint paint = f15485k0;
        if (paint != null) {
            paint.setAntiAlias(true);
            f15485k0.setColor(-65281);
        }
    }

    public a(View view) {
        this.a = view;
    }

    private boolean A() {
        return ViewCompat.getLayoutDirection(this.a) == 1;
    }

    private boolean B() {
        return this.f15495f0 > 1 && (!this.D || this.f15490d) && !this.F;
    }

    private float f(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        float f3 = this.f15494f;
        return f2 <= f3 ? com.google.android.material.a.a.a(1.0f, 0.0f, this.f15492e, f3, f2) : com.google.android.material.a.a.a(0.0f, 1.0f, f3, 1.0f, f2);
    }

    private void v() {
        g(this.f15488c);
    }

    private float w() {
        float f2 = this.f15492e;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    private void x() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private void y() {
        if (this.G != null || this.f15498h.isEmpty() || TextUtils.isEmpty(this.C)) {
            return;
        }
        g(0.0f);
        int width = this.f15486a0.getWidth();
        int height = this.f15486a0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f15486a0.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    @ColorInt
    private int z() {
        return c(this.f15507o);
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        u();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        u();
    }

    public void c(int i2) {
        this.f15496g = i2;
    }

    public float d() {
        a(this.N);
        return -this.N.ascent();
    }

    public void e(int i2) {
        if (this.f15503k != i2) {
            this.f15503k = i2;
            u();
        }
    }

    public float g() {
        b(this.N);
        return (-this.N.ascent()) + this.N.descent();
    }

    public int h() {
        return this.f15503k;
    }

    public float i() {
        b(this.N);
        return -this.N.ascent();
    }

    public Typeface j() {
        Typeface typeface = this.f15516x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float k() {
        return this.f15488c;
    }

    public float l() {
        return this.f15494f;
    }

    @RequiresApi(23)
    public int m() {
        return this.f15501i0;
    }

    public int n() {
        StaticLayout staticLayout = this.f15486a0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float o() {
        return this.f15486a0.getSpacingAdd();
    }

    @RequiresApi(23)
    public float p() {
        return this.f15486a0.getSpacingMultiplier();
    }

    public int q() {
        return this.f15495f0;
    }

    @Nullable
    public CharSequence r() {
        return this.B;
    }

    public final boolean s() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f15508p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f15507o) != null && colorStateList.isStateful());
    }

    void t() {
        this.b = this.f15500i.width() > 0 && this.f15500i.height() > 0 && this.f15498h.width() > 0 && this.f15498h.height() > 0;
    }

    public void u() {
        a(false);
    }

    private void h(float f2) {
        a(f2, false);
    }

    private void j(float f2) {
        this.f15487b0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void k(float f2) {
        this.f15489c0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void l(float f2) {
        h(f2);
        this.F = f15484j0 && this.I != 1.0f;
        if (this.F) {
            y();
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public void c(float f2) {
        this.f15492e = f2;
        this.f15494f = w();
    }

    private void g(float f2) {
        float f3;
        i(f2);
        if (!this.f15490d) {
            this.f15513u = a(this.f15511s, this.f15512t, f2, this.O);
            this.f15514v = a(this.f15509q, this.f15510r, f2, this.O);
            l(a(this.f15505m, this.f15506n, f2, this.P));
            f3 = f2;
        } else if (f2 < this.f15494f) {
            this.f15513u = this.f15511s;
            this.f15514v = this.f15509q;
            l(this.f15505m);
            f3 = 0.0f;
        } else {
            this.f15513u = this.f15512t;
            this.f15514v = this.f15510r - Math.max(0, this.f15496g);
            l(this.f15506n);
            f3 = 1.0f;
        }
        j(1.0f - a(0.0f, 1.0f, 1.0f - f2, com.google.android.material.a.a.b));
        k(a(1.0f, 0.0f, f2, com.google.android.material.a.a.b));
        if (this.f15508p != this.f15507o) {
            this.M.setColor(a(z(), f(), f3));
        } else {
            this.M.setColor(f());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f4 = this.Y;
            float f5 = this.Z;
            if (f4 != f5) {
                this.M.setLetterSpacing(a(f5, f4, f2, com.google.android.material.a.a.b));
            } else {
                this.M.setLetterSpacing(f4);
            }
        }
        this.M.setShadowLayer(a(this.U, this.Q, f2, (TimeInterpolator) null), a(this.V, this.R, f2, (TimeInterpolator) null), a(this.W, this.S, f2, (TimeInterpolator) null), a(c(this.X), c(this.T), f2));
        if (this.f15490d) {
            this.M.setAlpha((int) (f(f2) * 255.0f));
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void i(float f2) {
        if (this.f15490d) {
            this.f15502j.set(f2 < this.f15494f ? this.f15498h : this.f15500i);
            return;
        }
        this.f15502j.left = a(this.f15498h.left, this.f15500i.left, f2, this.O);
        this.f15502j.top = a(this.f15509q, this.f15510r, f2, this.O);
        this.f15502j.right = a(this.f15498h.right, this.f15500i.right, f2, this.O);
        this.f15502j.bottom = a(this.f15498h.bottom, this.f15500i.bottom, f2, this.O);
    }

    public void a(float f2) {
        if (this.f15505m != f2) {
            this.f15505m = f2;
            u();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.f15507o != colorStateList) {
            this.f15507o = colorStateList;
            u();
        }
    }

    public void d(int i2) {
        com.google.android.material.i.d dVar = new com.google.android.material.i.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.f15507o = colorStateList;
        }
        float f2 = dVar.f15432k;
        if (f2 != 0.0f) {
            this.f15505m = f2;
        }
        ColorStateList colorStateList2 = dVar.b;
        if (colorStateList2 != null) {
            this.X = colorStateList2;
        }
        this.V = dVar.f15427f;
        this.W = dVar.f15428g;
        this.U = dVar.f15429h;
        this.Z = dVar.f15431j;
        com.google.android.material.i.a aVar = this.f15518z;
        if (aVar != null) {
            aVar.a();
        }
        this.f15518z = new com.google.android.material.i.a(new b(), dVar.a());
        dVar.a(this.a.getContext(), this.f15518z);
        u();
    }

    private boolean e(Typeface typeface) {
        com.google.android.material.i.a aVar = this.f15518z;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f15516x == typeface) {
            return false;
        }
        this.f15516x = typeface;
        return true;
    }

    public int c() {
        return this.f15504l;
    }

    @ColorInt
    public int f() {
        return c(this.f15508p);
    }

    public void c(Typeface typeface) {
        boolean zD = d(typeface);
        boolean zE = e(typeface);
        if (zD || zE) {
            u();
        }
    }

    @RequiresApi(23)
    public void f(int i2) {
        this.f15501i0 = i2;
    }

    public void a(ColorStateList colorStateList) {
        if (this.f15508p != colorStateList) {
            this.f15508p = colorStateList;
            u();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (a(this.f15498h, i2, i3, i4, i5)) {
            return;
        }
        this.f15498h.set(i2, i3, i4, i5);
        this.L = true;
        t();
    }

    public void c(boolean z2) {
        this.E = z2;
    }

    public Typeface e() {
        Typeface typeface = this.f15515w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    private int c(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (a(this.f15500i, i2, i3, i4, i5)) {
            return;
        }
        this.f15500i.set(i2, i3, i4, i5);
        this.L = true;
        t();
    }

    @RequiresApi(23)
    public void e(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE) float f2) {
        this.f15499h0 = f2;
    }

    public void b(@NonNull Rect rect) {
        b(rect.left, rect.top, rect.right, rect.bottom);
    }

    private float b(@NonNull RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) + (a() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? rectF.left + a() : this.f15500i.right : this.D ? this.f15500i.right : rectF.left + a();
    }

    public void a(@NonNull Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(@NonNull RectF rectF, int i2, int i3) {
        this.D = b(this.B);
        rectF.left = a(i2, i3);
        rectF.top = this.f15500i.top;
        rectF.right = b(rectF, i2, i3);
        rectF.bottom = this.f15500i.top + d();
    }

    public void b(boolean z2) {
        this.f15490d = z2;
    }

    private void b(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f15505m);
        textPaint.setTypeface(this.f15516x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Z);
        }
    }

    private float a(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) - (a() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? this.f15500i.left : this.f15500i.right - a() : this.D ? this.f15500i.right - a() : this.f15500i.left;
    }

    public void b(int i2) {
        if (this.f15504l != i2) {
            this.f15504l = i2;
            u();
        }
    }

    private boolean d(Typeface typeface) {
        com.google.android.material.i.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f15515w == typeface) {
            return false;
        }
        this.f15515w = typeface;
        return true;
    }

    public float a() {
        if (this.B == null) {
            return 0.0f;
        }
        a(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void b(Typeface typeface) {
        if (e(typeface)) {
            u();
        }
    }

    private void d(boolean z2) {
        StaticLayout staticLayout;
        float f2 = this.J;
        a(this.f15506n, z2);
        CharSequence charSequence = this.C;
        if (charSequence != null && (staticLayout = this.f15486a0) != null) {
            this.f15493e0 = TextUtils.ellipsize(charSequence, this.M, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f15493e0;
        float lineStart = 0.0f;
        float fMeasureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f15504l, this.D ? 1 : 0);
        int i2 = absoluteGravity & 112;
        if (i2 == 48) {
            this.f15510r = this.f15500i.top;
        } else if (i2 != 80) {
            this.f15510r = this.f15500i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.f15510r = this.f15500i.bottom + this.M.ascent();
        }
        int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 == 1) {
            this.f15512t = this.f15500i.centerX() - (fMeasureText / 2.0f);
        } else if (i3 != 5) {
            this.f15512t = this.f15500i.left;
        } else {
            this.f15512t = this.f15500i.right - fMeasureText;
        }
        a(this.f15505m, z2);
        float height = this.f15486a0 != null ? r13.getHeight() : 0.0f;
        CharSequence charSequence3 = this.C;
        float fMeasureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.f15486a0;
        if (staticLayout2 != null && this.f15495f0 > 1) {
            fMeasureText2 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f15486a0;
        if (staticLayout3 != null) {
            lineStart = this.f15495f0 > 1 ? staticLayout3.getLineStart(0) : staticLayout3.getLineLeft(0);
        }
        this.f15491d0 = lineStart;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f15503k, this.D ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        if (i4 == 48) {
            this.f15509q = this.f15498h.top;
        } else if (i4 != 80) {
            this.f15509q = this.f15498h.centerY() - (height / 2.0f);
        } else {
            this.f15509q = (this.f15498h.bottom - height) + this.M.descent();
        }
        int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 1) {
            this.f15511s = this.f15498h.centerX() - (fMeasureText2 / 2.0f);
        } else if (i5 != 5) {
            this.f15511s = this.f15498h.left;
        } else {
            this.f15511s = this.f15498h.right - fMeasureText2;
        }
        x();
        l(f2);
    }

    public void b(float f2) {
        float fClamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (fClamp != this.f15488c) {
            this.f15488c = fClamp;
            v();
        }
    }

    private void a(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f15506n);
        textPaint.setTypeface(this.f15515w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Y);
        }
    }

    private boolean b(@NonNull CharSequence charSequence) {
        boolean zA = A();
        return this.E ? a(charSequence, zA) : zA;
    }

    public void a(int i2) {
        com.google.android.material.i.d dVar = new com.google.android.material.i.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.f15508p = colorStateList;
        }
        float f2 = dVar.f15432k;
        if (f2 != 0.0f) {
            this.f15506n = f2;
        }
        ColorStateList colorStateList2 = dVar.b;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.f15427f;
        this.S = dVar.f15428g;
        this.Q = dVar.f15429h;
        this.Y = dVar.f15431j;
        com.google.android.material.i.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
        this.A = new com.google.android.material.i.a(new C0325a(), dVar.a());
        dVar.a(this.a.getContext(), this.A);
        u();
    }

    public ColorStateList b() {
        return this.f15508p;
    }

    public void g(int i2) {
        if (i2 != this.f15495f0) {
            this.f15495f0 = i2;
            x();
            u();
        }
    }

    public void a(Typeface typeface) {
        if (d(typeface)) {
            u();
        }
    }

    public final boolean a(int[] iArr) {
        this.K = iArr;
        if (!s()) {
            return false;
        }
        u();
        return true;
    }

    public void a(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (this.C == null || !this.b) {
            return;
        }
        float lineStart = (this.f15513u + (this.f15495f0 > 1 ? this.f15486a0.getLineStart(0) : this.f15486a0.getLineLeft(0))) - (this.f15491d0 * 2.0f);
        this.M.setTextSize(this.J);
        float f2 = this.f15513u;
        float f3 = this.f15514v;
        boolean z2 = this.F && this.G != null;
        float f4 = this.I;
        if (f4 != 1.0f && !this.f15490d) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (z2) {
            canvas.drawBitmap(this.G, f2, f3, this.H);
            canvas.restoreToCount(iSave);
            return;
        }
        if (B() && (!this.f15490d || this.f15488c > this.f15494f)) {
            a(canvas, lineStart, f3);
        } else {
            canvas.translate(f2, f3);
            this.f15486a0.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @RequiresApi(23)
    public void d(float f2) {
        this.f15497g0 = f2;
    }

    private void a(@NonNull Canvas canvas, float f2, float f3) {
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = alpha;
        this.M.setAlpha((int) (this.f15489c0 * f4));
        this.f15486a0.draw(canvas);
        this.M.setAlpha((int) (this.f15487b0 * f4));
        int lineBaseline = this.f15486a0.getLineBaseline(0);
        CharSequence charSequence = this.f15493e0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.M);
        if (this.f15490d) {
            return;
        }
        String strTrim = this.f15493e0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f15486a0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.M);
    }

    private boolean a(@NonNull CharSequence charSequence, boolean z2) {
        return (z2 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void a(float f2, boolean z2) {
        float f3;
        boolean z3;
        boolean z4;
        if (this.B == null) {
            return;
        }
        float fWidth = this.f15500i.width();
        float fWidth2 = this.f15498h.width();
        if (a(f2, this.f15506n)) {
            float f4 = this.f15506n;
            this.I = 1.0f;
            Typeface typeface = this.f15517y;
            Typeface typeface2 = this.f15515w;
            if (typeface != typeface2) {
                this.f15517y = typeface2;
                z4 = true;
            } else {
                z4 = false;
            }
            f3 = f4;
            z3 = z4;
        } else {
            f3 = this.f15505m;
            Typeface typeface3 = this.f15517y;
            Typeface typeface4 = this.f15516x;
            if (typeface3 != typeface4) {
                this.f15517y = typeface4;
                z3 = true;
            } else {
                z3 = false;
            }
            if (a(f2, this.f15505m)) {
                this.I = 1.0f;
            } else {
                this.I = f2 / this.f15505m;
            }
            float f5 = this.f15506n / this.f15505m;
            fWidth = (!z2 && fWidth2 * f5 > fWidth) ? Math.min(fWidth / f5, fWidth2) : fWidth2;
        }
        if (fWidth > 0.0f) {
            z3 = this.J != f3 || this.L || z3;
            this.J = f3;
            this.L = false;
        }
        if (this.C == null || z3) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.f15517y);
            this.M.setLinearText(this.I != 1.0f);
            this.D = b(this.B);
            this.f15486a0 = a(B() ? this.f15495f0 : 1, fWidth, this.D);
            this.C = this.f15486a0.getText();
        }
    }

    private StaticLayout a(int i2, float f2, boolean z2) {
        StaticLayout staticLayoutA;
        try {
            StaticLayoutBuilderCompat staticLayoutBuilderCompatA = StaticLayoutBuilderCompat.a(this.B, this.M, (int) f2);
            staticLayoutBuilderCompatA.a(TextUtils.TruncateAt.END);
            staticLayoutBuilderCompatA.b(z2);
            staticLayoutBuilderCompatA.a(Layout.Alignment.ALIGN_NORMAL);
            staticLayoutBuilderCompatA.a(false);
            staticLayoutBuilderCompatA.b(i2);
            staticLayoutBuilderCompatA.a(this.f15497g0, this.f15499h0);
            staticLayoutBuilderCompatA.a(this.f15501i0);
            staticLayoutA = staticLayoutBuilderCompatA.a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            e2.getCause().getMessage();
            staticLayoutA = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayoutA);
    }

    public void a(boolean z2) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z2) {
            return;
        }
        d(z2);
        v();
    }

    public void a(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            x();
            u();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    private static float a(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean a(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
