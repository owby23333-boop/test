package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {
    private final Context a;

    @NonNull
    private final TextInputLayout b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f15993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f15995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Animator f15996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f15997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private CharSequence f16000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private TextView f16002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private CharSequence f16003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f16004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private ColorStateList f16005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f16006p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f16007q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private TextView f16008r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f16009s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private ColorStateList f16010t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Typeface f16011u;

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f16012s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ TextView f16013t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ int f16014u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ TextView f16015v;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.f16012s = i2;
            this.f16013t = textView;
            this.f16014u = i3;
            this.f16015v = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f15998h = this.f16012s;
            f.this.f15996f = null;
            TextView textView = this.f16013t;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f16014u == 1 && f.this.f16002l != null) {
                    f.this.f16002l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f16015v;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f16015v.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f16015v;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout.getContext();
        this.b = textInputLayout;
        this.f15997g = this.a.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    @Nullable
    private TextView d(int i2) {
        if (i2 == 1) {
            return this.f16002l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.f16008r;
    }

    private boolean e(int i2) {
        return (i2 != 1 || this.f16002l == null || TextUtils.isEmpty(this.f16000j)) ? false : true;
    }

    private boolean n() {
        return (this.f15993c == null || this.b.getEditText() == null) ? false : true;
    }

    boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    void b(CharSequence charSequence) {
        b();
        this.f16000j = charSequence;
        this.f16002l.setText(charSequence);
        if (this.f15998h != 1) {
            this.f15999i = 1;
        }
        a(this.f15998h, this.f15999i, a(this.f16002l, charSequence));
    }

    void c(CharSequence charSequence) {
        b();
        this.f16006p = charSequence;
        this.f16008r.setText(charSequence);
        if (this.f15998h != 2) {
            this.f15999i = 2;
        }
        a(this.f15998h, this.f15999i, a(this.f16008r, charSequence));
    }

    @ColorInt
    int f() {
        TextView textView = this.f16002l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    ColorStateList g() {
        TextView textView = this.f16002l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence h() {
        return this.f16006p;
    }

    @ColorInt
    int i() {
        TextView textView = this.f16008r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void j() {
        this.f16000j = null;
        b();
        if (this.f15998h == 1) {
            if (!this.f16007q || TextUtils.isEmpty(this.f16006p)) {
                this.f15999i = 0;
            } else {
                this.f15999i = 2;
            }
        }
        a(this.f15998h, this.f15999i, a(this.f16002l, (CharSequence) null));
    }

    void k() {
        b();
        if (this.f15998h == 2) {
            this.f15999i = 0;
        }
        a(this.f15998h, this.f15999i, a(this.f16008r, (CharSequence) null));
    }

    boolean l() {
        return this.f16001k;
    }

    boolean m() {
        return this.f16007q;
    }

    @Nullable
    CharSequence d() {
        return this.f16003m;
    }

    @Nullable
    CharSequence e() {
        return this.f16000j;
    }

    private boolean a(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.b) && this.b.isEnabled() && !(this.f15999i == this.f15998h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i2, int i3, boolean z2) {
        if (i2 == i3) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f15996f = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.f16007q, this.f16008r, 2, i2, i3);
            a(arrayList, this.f16001k, this.f16002l, 1, i2, i3);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, d(i2), i2, d(i3)));
            animatorSet.start();
        } else {
            a(i2, i3);
        }
        this.b.i();
        this.b.a(z2);
        this.b.j();
    }

    void b() {
        Animator animator = this.f15996f;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean c() {
        return e(this.f15999i);
    }

    void c(@StyleRes int i2) {
        this.f16009s = i2;
        TextView textView = this.f16008r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f15993c == null) {
            return;
        }
        if (a(i2) && (frameLayout = this.f15995e) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f15993c.removeView(textView);
        }
        this.f15994d--;
        a(this.f15993c, this.f15994d);
    }

    void b(boolean z2) {
        if (this.f16007q == z2) {
            return;
        }
        b();
        if (z2) {
            this.f16008r = new AppCompatTextView(this.a);
            this.f16008r.setId(R$id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f16008r.setTextAlignment(5);
            }
            Typeface typeface = this.f16011u;
            if (typeface != null) {
                this.f16008r.setTypeface(typeface);
            }
            this.f16008r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f16008r, 1);
            c(this.f16009s);
            b(this.f16010t);
            a(this.f16008r, 1);
        } else {
            k();
            b(this.f16008r, 1);
            this.f16008r = null;
            this.b.i();
            this.b.j();
        }
        this.f16007q = z2;
    }

    private void a(int i2, int i3) {
        TextView textViewD;
        TextView textViewD2;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (textViewD2 = d(i3)) != null) {
            textViewD2.setVisibility(0);
            textViewD2.setAlpha(1.0f);
        }
        if (i2 != 0 && (textViewD = d(i2)) != null) {
            textViewD.setVisibility(4);
            if (i2 == 1) {
                textViewD.setText((CharSequence) null);
            }
        }
        this.f15998h = i3;
    }

    private void a(@NonNull List<Animator> list, boolean z2, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z2) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(a(textView, i4 == i2));
            if (i4 == i2) {
                list.add(a(textView));
            }
        }
    }

    private ObjectAnimator a(TextView textView, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f15997g, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f14915d);
        return objectAnimatorOfFloat;
    }

    void b(@StyleRes int i2) {
        this.f16004n = i2;
        TextView textView = this.f16002l;
        if (textView != null) {
            this.b.a(textView, i2);
        }
    }

    void a() {
        if (n()) {
            EditText editText = this.b.getEditText();
            boolean zA = com.google.android.material.i.c.a(this.a);
            ViewCompat.setPaddingRelative(this.f15993c, a(zA, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), a(zA, R$dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), a(zA, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    void b(@Nullable ColorStateList colorStateList) {
        this.f16010t = colorStateList;
        TextView textView = this.f16008r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    private int a(boolean z2, @DimenRes int i2, int i3) {
        return z2 ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    void a(TextView textView, int i2) {
        if (this.f15993c == null && this.f15995e == null) {
            this.f15993c = new LinearLayout(this.a);
            this.f15993c.setOrientation(0);
            this.b.addView(this.f15993c, -1, -2);
            this.f15995e = new FrameLayout(this.a);
            this.f15993c.addView(this.f15995e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                a();
            }
        }
        if (a(i2)) {
            this.f15995e.setVisibility(0);
            this.f15995e.addView(textView);
        } else {
            this.f15993c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f15993c.setVisibility(0);
        this.f15994d++;
    }

    private void a(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    void a(boolean z2) {
        if (this.f16001k == z2) {
            return;
        }
        b();
        if (z2) {
            this.f16002l = new AppCompatTextView(this.a);
            this.f16002l.setId(R$id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f16002l.setTextAlignment(5);
            }
            Typeface typeface = this.f16011u;
            if (typeface != null) {
                this.f16002l.setTypeface(typeface);
            }
            b(this.f16004n);
            a(this.f16005o);
            a(this.f16003m);
            this.f16002l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f16002l, 1);
            a(this.f16002l, 0);
        } else {
            j();
            b(this.f16002l, 0);
            this.f16002l = null;
            this.b.i();
            this.b.j();
        }
        this.f16001k = z2;
    }

    void a(Typeface typeface) {
        if (typeface != this.f16011u) {
            this.f16011u = typeface;
            a(this.f16002l, typeface);
            a(this.f16008r, typeface);
        }
    }

    private void a(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    void a(@Nullable ColorStateList colorStateList) {
        this.f16005o = colorStateList;
        TextView textView = this.f16002l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void a(@Nullable CharSequence charSequence) {
        this.f16003m = charSequence;
        TextView textView = this.f16002l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }
}
