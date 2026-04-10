package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f15468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f15469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static Constructor<StaticLayout> f15470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private static Object f15471q;
    private CharSequence a;
    private final TextPaint b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15472c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15474e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15481l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15473d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f15475f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15476g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f15477h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15478i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15479j = f15468n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15480k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private TextUtils.TruncateAt f15482m = null;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        f15468n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.a = charSequence;
        this.b = textPaint;
        this.f15472c = i2;
        this.f15474e = charSequence.length();
    }

    @NonNull
    public static StaticLayoutBuilderCompat a(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    @NonNull
    public StaticLayoutBuilderCompat b(@IntRange(from = 0) int i2) {
        this.f15476g = i2;
        return this;
    }

    private void b() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        if (f15469o) {
            return;
        }
        try {
            boolean z2 = this.f15481l && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f15471q = z2 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.f15481l ? "RTL" : "LTR";
                Class<?> clsLoadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> clsLoadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                f15471q = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            f15470p = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            f15470p.setAccessible(true);
            f15469o = true;
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat a(@NonNull Layout.Alignment alignment) {
        this.f15475f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat a(boolean z2) {
        this.f15480k = z2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat a(float f2, float f3) {
        this.f15477h = f2;
        this.f15478i = f3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat a(int i2) {
        this.f15479j = i2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat a(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f15482m = truncateAt;
        return this;
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.a == null) {
            this.a = "";
        }
        int iMax = Math.max(0, this.f15472c);
        CharSequence charSequenceEllipsize = this.a;
        if (this.f15476g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.b, iMax, this.f15482m);
        }
        this.f15474e = Math.min(charSequenceEllipsize.length(), this.f15474e);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f15481l && this.f15476g == 1) {
                this.f15475f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f15473d, this.f15474e, this.b, iMax);
            builderObtain.setAlignment(this.f15475f);
            builderObtain.setIncludePad(this.f15480k);
            builderObtain.setTextDirection(this.f15481l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f15482m;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.f15476g);
            if (this.f15477h != 0.0f || this.f15478i != 1.0f) {
                builderObtain.setLineSpacing(this.f15477h, this.f15478i);
            }
            if (this.f15476g > 1) {
                builderObtain.setHyphenationFrequency(this.f15479j);
            }
            return builderObtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f15470p)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f15473d), Integer.valueOf(this.f15474e), this.b, Integer.valueOf(iMax), this.f15475f, Preconditions.checkNotNull(f15471q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f15480k), null, Integer.valueOf(iMax), Integer.valueOf(this.f15476g));
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    public StaticLayoutBuilderCompat b(boolean z2) {
        this.f15481l = z2;
        return this;
    }
}
