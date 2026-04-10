package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {

    @Nullable
    public final ColorStateList a;

    @Nullable
    public final ColorStateList b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f15424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f15427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f15428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f15429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f15431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f15432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @FontRes
    private final int f15433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15434m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Typeface f15435n;

    /* JADX INFO: compiled from: TextAppearance.java */
    class a extends ResourcesCompat.FontCallback {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
            d.this.f15434m = true;
            this.a.a(i2);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.f15435n = Typeface.create(typeface, dVar.f15425d);
            d.this.f15434m = true;
            this.a.a(d.this.f15435n, false);
        }
    }

    public d(@NonNull Context context, @StyleRes int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
        this.f15432k = typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.a = c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f15425d = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f15426e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int iA = c.a(typedArrayObtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.f15433l = typedArrayObtainStyledAttributes.getResourceId(iA, 0);
        this.f15424c = typedArrayObtainStyledAttributes.getString(iA);
        typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.b = c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f15427f = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f15428g = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f15429h = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 21) {
            this.f15430i = false;
            this.f15431j = 0.0f;
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
            this.f15430i = typedArrayObtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
            this.f15431j = typedArrayObtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
        }
    }

    private void b() {
        String str;
        if (this.f15435n == null && (str = this.f15424c) != null) {
            this.f15435n = Typeface.create(str, this.f15425d);
        }
        if (this.f15435n == null) {
            int i2 = this.f15426e;
            if (i2 == 1) {
                this.f15435n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.f15435n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.f15435n = Typeface.DEFAULT;
            } else {
                this.f15435n = Typeface.MONOSPACE;
            }
            this.f15435n = Typeface.create(this.f15435n, this.f15425d);
        }
    }

    public void c(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (b(context)) {
            a(textPaint, a(context));
        } else {
            a(context, textPaint, fVar);
        }
    }

    /* JADX INFO: compiled from: TextAppearance.java */
    class b extends f {
        final /* synthetic */ TextPaint a;
        final /* synthetic */ f b;

        b(TextPaint textPaint, f fVar) {
            this.a = textPaint;
            this.b = fVar;
        }

        @Override // com.google.android.material.i.f
        public void a(@NonNull Typeface typeface, boolean z2) {
            d.this.a(this.a, typeface);
            this.b.a(typeface, z2);
        }

        @Override // com.google.android.material.i.f
        public void a(int i2) {
            this.b.a(i2);
        }
    }

    @NonNull
    @VisibleForTesting
    public Typeface a(@NonNull Context context) {
        if (this.f15434m) {
            return this.f15435n;
        }
        if (!context.isRestricted()) {
            try {
                this.f15435n = ResourcesCompat.getFont(context, this.f15433l);
                if (this.f15435n != null) {
                    this.f15435n = Typeface.create(this.f15435n, this.f15425d);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                String str = "Error loading font " + this.f15424c;
            }
        }
        b();
        this.f15434m = true;
        return this.f15435n;
    }

    public void b(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        c(context, textPaint, fVar);
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f15429h;
        float f3 = this.f15427f;
        float f4 = this.f15428g;
        ColorStateList colorStateList2 = this.b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void a(@NonNull Context context, @NonNull f fVar) {
        if (b(context)) {
            a(context);
        } else {
            b();
        }
        if (this.f15433l == 0) {
            this.f15434m = true;
        }
        if (this.f15434m) {
            fVar.a(this.f15435n, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, this.f15433l, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f15434m = true;
            fVar.a(1);
        } catch (Exception unused2) {
            String str = "Error loading font " + this.f15424c;
            this.f15434m = true;
            fVar.a(-3);
        }
    }

    private boolean b(Context context) {
        if (e.a()) {
            return true;
        }
        int i2 = this.f15433l;
        return (i2 != 0 ? ResourcesCompat.getCachedFont(context, i2) : null) != null;
    }

    public void a(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        a(textPaint, a());
        a(context, new b(textPaint, fVar));
    }

    public Typeface a() {
        b();
        return this.f15435n;
    }

    public void a(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.f15425d;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f15432k);
        if (Build.VERSION.SDK_INT < 21 || !this.f15430i) {
            return;
        }
        textPaint.setLetterSpacing(this.f15431j);
    }
}
