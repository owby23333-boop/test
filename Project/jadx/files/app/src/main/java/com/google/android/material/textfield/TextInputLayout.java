package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private static final int e1 = R$style.Widget_Design_TextInputLayout;
    private final com.google.android.material.textfield.f A;
    private final LinkedHashSet<g> A0;
    boolean B;
    private ColorStateList B0;
    private int C;
    private boolean C0;
    private boolean D;
    private PorterDuff.Mode D0;

    @Nullable
    private TextView E;
    private boolean E0;
    private int F;

    @Nullable
    private Drawable F0;
    private int G;
    private int G0;
    private CharSequence H;
    private Drawable H0;
    private boolean I;
    private View.OnLongClickListener I0;
    private TextView J;
    private View.OnLongClickListener J0;

    @Nullable
    private ColorStateList K;

    @NonNull
    private final CheckableImageButton K0;
    private int L;
    private ColorStateList L0;

    @Nullable
    private ColorStateList M;
    private ColorStateList M0;

    @Nullable
    private ColorStateList N;
    private ColorStateList N0;

    @Nullable
    private CharSequence O;

    @ColorInt
    private int O0;

    @NonNull
    private final TextView P;

    @ColorInt
    private int P0;

    @Nullable
    private CharSequence Q;

    @ColorInt
    private int Q0;

    @NonNull
    private final TextView R;
    private ColorStateList R0;
    private boolean S;

    @ColorInt
    private int S0;
    private CharSequence T;

    @ColorInt
    private int T0;
    private boolean U;

    @ColorInt
    private int U0;

    @Nullable
    private MaterialShapeDrawable V;

    @ColorInt
    private int V0;

    @Nullable
    private MaterialShapeDrawable W;

    @ColorInt
    private int W0;
    private boolean X0;
    final com.google.android.material.internal.a Y0;
    private boolean Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @NonNull
    private l f15905a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private boolean f15906a1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final int f15907b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private ValueAnimator f15908b1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f15909c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private boolean f15910c1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f15911d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private boolean f15912d1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f15913e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f15914f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f15915g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f15916h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @ColorInt
    private int f15917i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @ColorInt
    private int f15918j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Rect f15919k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final Rect f15920l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final RectF f15921m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private Typeface f15922n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f15923o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private ColorStateList f15924p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f15925q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private PorterDuff.Mode f15926r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final FrameLayout f15927s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f15928s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final LinearLayout f15929t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @Nullable
    private Drawable f15930t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final LinearLayout f15931u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f15932u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final FrameLayout f15933v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private View.OnLongClickListener f15934v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    EditText f15935w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final LinkedHashSet<f> f15936w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f15937x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f15938x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15939y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private final SparseArray<com.google.android.material.textfield.e> f15940y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f15941z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @NonNull
    private final CheckableImageButton f15942z0;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        CharSequence f15943s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f15944t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        CharSequence f15945u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        CharSequence f15946v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        CharSequence f15947w;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f15943s) + " hint=" + ((Object) this.f15945u) + " helperText=" + ((Object) this.f15946v) + " placeholderText=" + ((Object) this.f15947w) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f15943s, parcel, i2);
            parcel.writeInt(this.f15944t ? 1 : 0);
            TextUtils.writeToParcel(this.f15945u, parcel, i2);
            TextUtils.writeToParcel(this.f15946v, parcel, i2);
            TextUtils.writeToParcel(this.f15947w, parcel, i2);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f15943s = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f15944t = parcel.readInt() == 1;
            this.f15945u = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f15946v = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f15947w = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout.this.a(!r0.f15912d1);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.B) {
                textInputLayout.a(editable.length());
            }
            if (TextInputLayout.this.I) {
                TextInputLayout.this.c(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f15942z0.performClick();
            TextInputLayout.this.f15942z0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f15935w.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.Y0.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends AccessibilityDelegateCompat {
        private final TextInputLayout a;

        public e(@NonNull TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.a.getHint();
            CharSequence error = this.a.getError();
            CharSequence placeholderText = this.a.getPlaceholderText();
            int counterMaxLength = this.a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.a.getCounterOverflowDescription();
            boolean z2 = !TextUtils.isEmpty(text);
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !this.a.c();
            boolean z5 = !TextUtils.isEmpty(error);
            boolean z6 = z5 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z3 ? hint.toString() : "";
            if (z2) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (z4 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (z2) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z2);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z6) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (Build.VERSION.SDK_INT < 17 || editText == null) {
                return;
            }
            editText.setLabelFor(R$id.textinput_helper_text);
        }
    }

    public interface f {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface g {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean A() {
        return this.K0.getVisibility() == 0;
    }

    private boolean B() {
        return this.f15911d0 == 1 && (Build.VERSION.SDK_INT < 16 || this.f15935w.getMinLines() <= 1);
    }

    private void C() {
        q();
        F();
        j();
        K();
        l();
        if (this.f15911d0 != 0) {
            Q();
        }
    }

    private void D() {
        if (w()) {
            RectF rectF = this.f15921m0;
            this.Y0.a(rectF, this.f15935w.getWidth(), this.f15935w.getGravity());
            a(rectF);
            this.f15909c0 = this.f15914f0;
            rectF.top = 0.0f;
            rectF.bottom = this.f15909c0;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.c) this.V).a(rectF);
        }
    }

    private void E() {
        TextView textView = this.J;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void F() {
        if (I()) {
            ViewCompat.setBackground(this.f15935w, this.V);
        }
    }

    private boolean G() {
        return (this.K0.getVisibility() == 0 || ((y() && a()) || this.Q != null)) && this.f15931u.getMeasuredWidth() > 0;
    }

    private boolean H() {
        return !(getStartIconDrawable() == null && this.O == null) && this.f15929t.getMeasuredWidth() > 0;
    }

    private boolean I() {
        EditText editText = this.f15935w;
        return (editText == null || this.V == null || editText.getBackground() != null || this.f15911d0 == 0) ? false : true;
    }

    private void J() {
        TextView textView = this.J;
        if (textView == null || !this.I) {
            return;
        }
        textView.setText(this.H);
        this.J.setVisibility(0);
        this.J.bringToFront();
    }

    private void K() {
        if (this.f15911d0 == 1) {
            if (com.google.android.material.i.c.b(getContext())) {
                this.f15913e0 = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (com.google.android.material.i.c.a(getContext())) {
                this.f15913e0 = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void L() {
        if (this.E != null) {
            EditText editText = this.f15935w;
            a(editText == null ? 0 : editText.getText().length());
        }
    }

    private void M() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.E;
        if (textView != null) {
            a(textView, this.D ? this.F : this.G);
            if (!this.D && (colorStateList2 = this.M) != null) {
                this.E.setTextColor(colorStateList2);
            }
            if (!this.D || (colorStateList = this.N) == null) {
                return;
            }
            this.E.setTextColor(colorStateList);
        }
    }

    private void N() {
        if (!w() || this.X0 || this.f15909c0 == this.f15914f0) {
            return;
        }
        v();
        D();
    }

    private boolean O() {
        boolean z2;
        if (this.f15935w == null) {
            return false;
        }
        if (H()) {
            int measuredWidth = this.f15929t.getMeasuredWidth() - this.f15935w.getPaddingLeft();
            if (this.f15930t0 == null || this.f15932u0 != measuredWidth) {
                this.f15930t0 = new ColorDrawable();
                this.f15932u0 = measuredWidth;
                this.f15930t0.setBounds(0, 0, this.f15932u0, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f15935w);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f15930t0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f15935w, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.f15930t0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f15935w);
                TextViewCompat.setCompoundDrawablesRelative(this.f15935w, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f15930t0 = null;
                z2 = true;
            }
            z2 = false;
        }
        if (!G()) {
            if (this.F0 == null) {
                return z2;
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f15935w);
            if (compoundDrawablesRelative3[2] == this.F0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f15935w, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.H0, compoundDrawablesRelative3[3]);
                z2 = true;
            }
            this.F0 = null;
            return z2;
        }
        int measuredWidth2 = this.R.getMeasuredWidth() - this.f15935w.getPaddingRight();
        CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
        if (endIconToUpdateDummyDrawable != null) {
            measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
        }
        Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f15935w);
        Drawable drawable3 = this.F0;
        if (drawable3 == null || this.G0 == measuredWidth2) {
            if (this.F0 == null) {
                this.F0 = new ColorDrawable();
                this.G0 = measuredWidth2;
                this.F0.setBounds(0, 0, this.G0, 1);
            }
            Drawable drawable4 = compoundDrawablesRelative4[2];
            Drawable drawable5 = this.F0;
            if (drawable4 == drawable5) {
                return z2;
            }
            this.H0 = compoundDrawablesRelative4[2];
            TextViewCompat.setCompoundDrawablesRelative(this.f15935w, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], drawable5, compoundDrawablesRelative4[3]);
        } else {
            this.G0 = measuredWidth2;
            drawable3.setBounds(0, 0, this.G0, 1);
            TextViewCompat.setCompoundDrawablesRelative(this.f15935w, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.F0, compoundDrawablesRelative4[3]);
        }
        return true;
    }

    private boolean P() {
        int iMax;
        if (this.f15935w == null || this.f15935w.getMeasuredHeight() >= (iMax = Math.max(this.f15931u.getMeasuredHeight(), this.f15929t.getMeasuredHeight()))) {
            return false;
        }
        this.f15935w.setMinimumHeight(iMax);
        return true;
    }

    private void Q() {
        if (this.f15911d0 != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15927s.getLayoutParams();
            int iS = s();
            if (iS != layoutParams.topMargin) {
                layoutParams.topMargin = iS;
                this.f15927s.requestLayout();
            }
        }
    }

    private void R() {
        EditText editText;
        if (this.J == null || (editText = this.f15935w) == null) {
            return;
        }
        this.J.setGravity(editText.getGravity());
        this.J.setPadding(this.f15935w.getCompoundPaddingLeft(), this.f15935w.getCompoundPaddingTop(), this.f15935w.getCompoundPaddingRight(), this.f15935w.getCompoundPaddingBottom());
    }

    private void S() {
        EditText editText = this.f15935w;
        c(editText == null ? 0 : editText.getText().length());
    }

    private void T() {
        if (this.f15935w == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.P, e() ? 0 : ViewCompat.getPaddingStart(this.f15935w), this.f15935w.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f15935w.getCompoundPaddingBottom());
    }

    private void U() {
        this.P.setVisibility((this.O == null || c()) ? 8 : 0);
        O();
    }

    private void V() {
        if (this.f15935w == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.R, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f15935w.getPaddingTop(), (a() || A()) ? 0 : ViewCompat.getPaddingEnd(this.f15935w), this.f15935w.getPaddingBottom());
    }

    private void W() {
        int visibility = this.R.getVisibility();
        boolean z2 = (this.Q == null || c()) ? false : true;
        this.R.setVisibility(z2 ? 0 : 8);
        if (visibility != this.R.getVisibility()) {
            getEndIconDelegate().a(z2);
        }
        O();
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.f15940y0.get(this.f15938x0);
        return eVar != null ? eVar : this.f15940y0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.K0.getVisibility() == 0) {
            return this.K0;
        }
        if (y() && a()) {
            return this.f15942z0;
        }
        return null;
    }

    private void k() {
        TextView textView = this.J;
        if (textView != null) {
            this.f15927s.addView(textView);
            this.J.setVisibility(0);
        }
    }

    private void l() {
        if (this.f15935w == null || this.f15911d0 != 1) {
            return;
        }
        if (com.google.android.material.i.c.b(getContext())) {
            EditText editText = this.f15935w;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f15935w), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (com.google.android.material.i.c.a(getContext())) {
            EditText editText2 = this.f15935w;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f15935w), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void m() {
        MaterialShapeDrawable materialShapeDrawable = this.V;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.f15905a0);
        if (t()) {
            this.V.a(this.f15914f0, this.f15917i0);
        }
        this.f15918j0 = r();
        this.V.a(ColorStateList.valueOf(this.f15918j0));
        if (this.f15938x0 == 3) {
            this.f15935w.getBackground().invalidateSelf();
        }
        n();
        invalidate();
    }

    private void n() {
        if (this.W == null) {
            return;
        }
        if (u()) {
            this.W.a(ColorStateList.valueOf(this.f15917i0));
        }
        invalidate();
    }

    private void o() {
        a(this.f15942z0, this.C0, this.B0, this.E0, this.D0);
    }

    private void p() {
        a(this.f15923o0, this.f15925q0, this.f15924p0, this.f15928s0, this.f15926r0);
    }

    private void q() {
        int i2 = this.f15911d0;
        if (i2 == 0) {
            this.V = null;
            this.W = null;
            return;
        }
        if (i2 == 1) {
            this.V = new MaterialShapeDrawable(this.f15905a0);
            this.W = new MaterialShapeDrawable();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(this.f15911d0 + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.S || (this.V instanceof com.google.android.material.textfield.c)) {
                this.V = new MaterialShapeDrawable(this.f15905a0);
            } else {
                this.V = new com.google.android.material.textfield.c(this.f15905a0);
            }
            this.W = null;
        }
    }

    private int r() {
        return this.f15911d0 == 1 ? com.google.android.material.c.a.b(com.google.android.material.c.a.a(this, R$attr.colorSurface, 0), this.f15918j0) : this.f15918j0;
    }

    private int s() {
        float fD;
        if (!this.S) {
            return 0;
        }
        int i2 = this.f15911d0;
        if (i2 == 0 || i2 == 1) {
            fD = this.Y0.d();
        } else {
            if (i2 != 2) {
                return 0;
            }
            fD = this.Y0.d() / 2.0f;
        }
        return (int) fD;
    }

    private void setEditText(EditText editText) {
        if (this.f15935w != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f15938x0 != 3) {
            boolean z2 = editText instanceof TextInputEditText;
        }
        this.f15935w = editText;
        setMinWidth(this.f15939y);
        setMaxWidth(this.f15941z);
        C();
        setTextInputAccessibilityDelegate(new e(this));
        this.Y0.c(this.f15935w.getTypeface());
        this.Y0.a(this.f15935w.getTextSize());
        int gravity = this.f15935w.getGravity();
        this.Y0.b((gravity & (-113)) | 48);
        this.Y0.e(gravity);
        this.f15935w.addTextChangedListener(new a());
        if (this.M0 == null) {
            this.M0 = this.f15935w.getHintTextColors();
        }
        if (this.S) {
            if (TextUtils.isEmpty(this.T)) {
                this.f15937x = this.f15935w.getHint();
                setHint(this.f15937x);
                this.f15935w.setHint((CharSequence) null);
            }
            this.U = true;
        }
        if (this.E != null) {
            a(this.f15935w.getText().length());
        }
        i();
        this.A.a();
        this.f15929t.bringToFront();
        this.f15931u.bringToFront();
        this.f15933v.bringToFront();
        this.K0.bringToFront();
        x();
        T();
        V();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        a(false, true);
    }

    private void setErrorIconVisible(boolean z2) {
        this.K0.setVisibility(z2 ? 0 : 8);
        this.f15933v.setVisibility(z2 ? 8 : 0);
        V();
        if (y()) {
            return;
        }
        O();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.T)) {
            return;
        }
        this.T = charSequence;
        this.Y0.a(charSequence);
        if (this.X0) {
            return;
        }
        D();
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.I == z2) {
            return;
        }
        if (z2) {
            this.J = new AppCompatTextView(getContext());
            this.J.setId(R$id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.J, 1);
            setPlaceholderTextAppearance(this.L);
            setPlaceholderTextColor(this.K);
            k();
        } else {
            E();
            this.J = null;
        }
        this.I = z2;
    }

    private boolean t() {
        return this.f15911d0 == 2 && u();
    }

    private boolean u() {
        return this.f15914f0 > -1 && this.f15917i0 != 0;
    }

    private void v() {
        if (w()) {
            ((com.google.android.material.textfield.c) this.V).x();
        }
    }

    private boolean w() {
        return this.S && !TextUtils.isEmpty(this.T) && (this.V instanceof com.google.android.material.textfield.c);
    }

    private void x() {
        Iterator<f> it = this.f15936w0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private boolean y() {
        return this.f15938x0 != 0;
    }

    private void z() {
        TextView textView = this.J;
        if (textView == null || !this.I) {
            return;
        }
        textView.setText((CharSequence) null);
        this.J.setVisibility(4);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f15927s.addView(view, layoutParams2);
        this.f15927s.setLayoutParams(layoutParams);
        Q();
        setEditText((EditText) view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean d() {
        return this.U;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.f15935w;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f15937x != null) {
            boolean z2 = this.U;
            this.U = false;
            CharSequence hint = editText.getHint();
            this.f15935w.setHint(this.f15937x);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f15935w.setHint(hint);
                this.U = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        viewStructure.setChildCount(this.f15927s.getChildCount());
        for (int i3 = 0; i3 < this.f15927s.getChildCount(); i3++) {
            View childAt = this.f15927s.getChildAt(i3);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i2);
            if (childAt == this.f15935w) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.f15912d1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f15912d1 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f15910c1) {
            return;
        }
        this.f15910c1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.Y0;
        boolean zA = aVar != null ? aVar.a(drawableState) | false : false;
        if (this.f15935w != null) {
            a(ViewCompat.isLaidOut(this) && isEnabled());
        }
        i();
        j();
        if (zA) {
            invalidate();
        }
        this.f15910c1 = false;
    }

    public boolean e() {
        return this.f15923o0.getVisibility() == 0;
    }

    public void f() {
        a(this.f15942z0, this.B0);
    }

    public void g() {
        a(this.K0, this.L0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f15935w;
        return editText != null ? editText.getBaseline() + getPaddingTop() + s() : super.getBaseline();
    }

    @NonNull
    MaterialShapeDrawable getBoxBackground() {
        int i2 = this.f15911d0;
        if (i2 == 1 || i2 == 2) {
            return this.V;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f15918j0;
    }

    public int getBoxBackgroundMode() {
        return this.f15911d0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.V.b();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.V.c();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.V.q();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.V.p();
    }

    public int getBoxStrokeColor() {
        return this.Q0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.R0;
    }

    public int getBoxStrokeWidth() {
        return this.f15915g0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f15916h0;
    }

    public int getCounterMaxLength() {
        return this.C;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.B && this.D && (textView = this.E) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.M;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.M;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.M0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f15935w;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f15942z0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f15942z0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f15938x0;
    }

    @NonNull
    CheckableImageButton getEndIconView() {
        return this.f15942z0;
    }

    @Nullable
    public CharSequence getError() {
        if (this.A.l()) {
            return this.A.e();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.A.d();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.A.f();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.K0.getDrawable();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.A.f();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.A.m()) {
            return this.A.h();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.A.i();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.S) {
            return this.T;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.Y0.d();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.Y0.f();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.N0;
    }

    @Px
    public int getMaxWidth() {
        return this.f15941z;
    }

    @Px
    public int getMinWidth() {
        return this.f15939y;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f15942z0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f15942z0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.I) {
            return this.H;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.L;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.K;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.O;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.P.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.P;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f15923o0.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f15923o0.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.Q;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.R.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.R;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f15922n0;
    }

    public void h() {
        a(this.f15923o0, this.f15924p0);
    }

    void i() {
        Drawable background;
        TextView textView;
        EditText editText = this.f15935w;
        if (editText == null || this.f15911d0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.A.c()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.A.f(), PorterDuff.Mode.SRC_IN));
        } else if (this.D && (textView = this.E) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f15935w.refreshDrawableState();
        }
    }

    void j() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.V == null || this.f15911d0 == 0) {
            return;
        }
        boolean z2 = false;
        boolean z3 = isFocused() || ((editText2 = this.f15935w) != null && editText2.hasFocus());
        boolean z4 = isHovered() || ((editText = this.f15935w) != null && editText.isHovered());
        if (!isEnabled()) {
            this.f15917i0 = this.W0;
        } else if (this.A.c()) {
            if (this.R0 != null) {
                b(z3, z4);
            } else {
                this.f15917i0 = this.A.f();
            }
        } else if (!this.D || (textView = this.E) == null) {
            if (z3) {
                this.f15917i0 = this.Q0;
            } else if (z4) {
                this.f15917i0 = this.P0;
            } else {
                this.f15917i0 = this.O0;
            }
        } else if (this.R0 != null) {
            b(z3, z4);
        } else {
            this.f15917i0 = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.A.l() && this.A.c()) {
            z2 = true;
        }
        setErrorIconVisible(z2);
        g();
        h();
        f();
        if (getEndIconDelegate().b()) {
            d(this.A.c());
        }
        if (z3 && isEnabled()) {
            this.f15914f0 = this.f15916h0;
        } else {
            this.f15914f0 = this.f15915g0;
        }
        if (this.f15911d0 == 2) {
            N();
        }
        if (this.f15911d0 == 1) {
            if (!isEnabled()) {
                this.f15918j0 = this.T0;
            } else if (z4 && !z3) {
                this.f15918j0 = this.V0;
            } else if (z3) {
                this.f15918j0 = this.U0;
            } else {
                this.f15918j0 = this.S0;
            }
        }
        m();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f15935w;
        if (editText != null) {
            Rect rect = this.f15919k0;
            com.google.android.material.internal.c.a(this, editText, rect);
            c(rect);
            if (this.S) {
                this.Y0.a(this.f15935w.getTextSize());
                int gravity = this.f15935w.getGravity();
                this.Y0.b((gravity & (-113)) | 48);
                this.Y0.e(gravity);
                this.Y0.a(a(rect));
                this.Y0.b(b(rect));
                this.Y0.u();
                if (!w() || this.X0) {
                    return;
                }
                D();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean zP = P();
        boolean zO = O();
        if (zP || zO) {
            this.f15935w.post(new c());
        }
        R();
        T();
        V();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f15943s);
        if (savedState.f15944t) {
            this.f15942z0.post(new b());
        }
        setHint(savedState.f15945u);
        setHelperText(savedState.f15946v);
        setPlaceholderText(savedState.f15947w);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.A.c()) {
            savedState.f15943s = getError();
        }
        savedState.f15944t = y() && this.f15942z0.isChecked();
        savedState.f15945u = getHint();
        savedState.f15946v = getHelperText();
        savedState.f15947w = getPlaceholderText();
        return savedState;
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.f15918j0 != i2) {
            this.f15918j0 = i2;
            this.S0 = i2;
            this.U0 = i2;
            this.V0 = i2;
            m();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        this.S0 = colorStateList.getDefaultColor();
        this.f15918j0 = this.S0;
        this.T0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.U0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.V0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.f15911d0) {
            return;
        }
        this.f15911d0 = i2;
        if (this.f15935w != null) {
            C();
        }
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.Q0 != i2) {
            this.Q0 = i2;
            j();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.O0 = colorStateList.getDefaultColor();
            this.W0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.P0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.Q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.Q0 != colorStateList.getDefaultColor()) {
            this.Q0 = colorStateList.getDefaultColor();
        }
        j();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.R0 != colorStateList) {
            this.R0 = colorStateList;
            j();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.f15915g0 = i2;
        j();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.f15916h0 = i2;
        j();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.B != z2) {
            if (z2) {
                this.E = new AppCompatTextView(getContext());
                this.E.setId(R$id.textinput_counter);
                Typeface typeface = this.f15922n0;
                if (typeface != null) {
                    this.E.setTypeface(typeface);
                }
                this.E.setMaxLines(1);
                this.A.a(this.E, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.E.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                M();
                L();
            } else {
                this.A.b(this.E, 2);
                this.E = null;
            }
            this.B = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.C != i2) {
            if (i2 > 0) {
                this.C = i2;
            } else {
                this.C = -1;
            }
            if (this.B) {
                L();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.F != i2) {
            this.F = i2;
            M();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            M();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.G != i2) {
            this.G = i2;
            M();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.M != colorStateList) {
            this.M = colorStateList;
            M();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.M0 = colorStateList;
        this.N0 = colorStateList;
        if (this.f15935w != null) {
            a(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        a(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f15942z0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f15942z0.setCheckable(z2);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.f15938x0;
        this.f15938x0 = i2;
        b(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().a(this.f15911d0)) {
            getEndIconDelegate().a();
            o();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f15911d0 + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        a(this.f15942z0, onClickListener, this.I0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.I0 = onLongClickListener;
        b(this.f15942z0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.B0 != colorStateList) {
            this.B0 = colorStateList;
            this.C0 = true;
            o();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            this.E0 = true;
            o();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (a() != z2) {
            this.f15942z0.setVisibility(z2 ? 0 : 8);
            V();
            O();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.A.l()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.A.j();
        } else {
            this.A.b(charSequence);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.A.a(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.A.a(z2);
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        g();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        a(this.K0, onClickListener, this.J0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.J0 = onLongClickListener;
        b(this.K0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.L0 = colorStateList;
        Drawable drawable = this.K0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.K0.getDrawable() != drawable) {
            this.K0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.K0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.K0.getDrawable() != drawable) {
            this.K0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.A.b(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.A.a(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.Z0 != z2) {
            this.Z0 = z2;
            a(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (b()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!b()) {
                setHelperTextEnabled(true);
            }
            this.A.c(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.A.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.A.b(z2);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.A.c(i2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.S) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.f15906a1 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.S) {
            this.S = z2;
            if (this.S) {
                CharSequence hint = this.f15935w.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.T)) {
                        setHint(hint);
                    }
                    this.f15935w.setHint((CharSequence) null);
                }
                this.U = true;
            } else {
                this.U = false;
                if (!TextUtils.isEmpty(this.T) && TextUtils.isEmpty(this.f15935w.getHint())) {
                    this.f15935w.setHint(this.T);
                }
                setHintInternal(null);
            }
            if (this.f15935w != null) {
                Q();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.Y0.a(i2);
        this.N0 = this.Y0.b();
        if (this.f15935w != null) {
            a(false);
            Q();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.N0 != colorStateList) {
            if (this.M0 == null) {
                this.Y0.a(colorStateList);
            }
            this.N0 = colorStateList;
            if (this.f15935w != null) {
                a(false);
            }
        }
    }

    public void setMaxWidth(@Px int i2) {
        this.f15941z = i2;
        EditText editText = this.f15935w;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxWidth(i2);
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(@Px int i2) {
        this.f15939y = i2;
        EditText editText = this.f15935w;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinWidth(i2);
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.f15938x0 != 1) {
            setEndIconMode(1);
        } else {
            if (z2) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.B0 = colorStateList;
        this.C0 = true;
        o();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.D0 = mode;
        this.E0 = true;
        o();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.I && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.I) {
                setPlaceholderTextEnabled(true);
            }
            this.H = charSequence;
        }
        S();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.L = i2;
        TextView textView = this.J;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            TextView textView = this.J;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.O = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.P.setText(charSequence);
        U();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.P, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.P.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.f15923o0.setCheckable(z2);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        a(this.f15923o0, onClickListener, this.f15934v0);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f15934v0 = onLongClickListener;
        b(this.f15923o0, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f15924p0 != colorStateList) {
            this.f15924p0 = colorStateList;
            this.f15925q0 = true;
            p();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f15926r0 != mode) {
            this.f15926r0 = mode;
            this.f15928s0 = true;
            p();
        }
    }

    public void setStartIconVisible(boolean z2) {
        if (e() != z2) {
            this.f15923o0.setVisibility(z2 ? 0 : 8);
            T();
            O();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.Q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.R.setText(charSequence);
        W();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.R, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.R.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable e eVar) {
        EditText editText = this.f15935w;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, eVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f15922n0) {
            this.f15922n0 = typeface;
            this.Y0.c(typeface);
            this.A.a(typeface);
            TextView textView = this.E;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (i2 != 0 || this.X0) {
            z();
        } else {
            J();
        }
    }

    private void d(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            o();
            return;
        }
        Drawable drawableMutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(drawableMutate, this.A.f());
        this.f15942z0.setImageDrawable(drawableMutate);
    }

    public boolean b() {
        return this.A.m();
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f15942z0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f15942z0.setImageDrawable(drawable);
        f();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.f15923o0.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f15923o0.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            h();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3;
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, e1), attributeSet, i2);
        this.f15939y = -1;
        this.f15941z = -1;
        this.A = new com.google.android.material.textfield.f(this);
        this.f15919k0 = new Rect();
        this.f15920l0 = new Rect();
        this.f15921m0 = new RectF();
        this.f15936w0 = new LinkedHashSet<>();
        this.f15938x0 = 0;
        this.f15940y0 = new SparseArray<>();
        this.A0 = new LinkedHashSet<>();
        this.Y0 = new com.google.android.material.internal.a(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f15927s = new FrameLayout(context2);
        this.f15927s.setAddStatesFromChildren(true);
        addView(this.f15927s);
        this.f15929t = new LinearLayout(context2);
        this.f15929t.setOrientation(0);
        this.f15929t.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        this.f15927s.addView(this.f15929t);
        this.f15931u = new LinearLayout(context2);
        this.f15931u.setOrientation(0);
        this.f15931u.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        this.f15927s.addView(this.f15931u);
        this.f15933v = new FrameLayout(context2);
        this.f15933v.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.Y0.b(com.google.android.material.a.a.a);
        this.Y0.a(com.google.android.material.a.a.a);
        this.Y0.b(8388659);
        TintTypedArray tintTypedArrayD = com.google.android.material.internal.l.d(context2, attributeSet, R$styleable.TextInputLayout, i2, e1, R$styleable.TextInputLayout_counterTextAppearance, R$styleable.TextInputLayout_counterOverflowTextAppearance, R$styleable.TextInputLayout_errorTextAppearance, R$styleable.TextInputLayout_helperTextTextAppearance, R$styleable.TextInputLayout_hintTextAppearance);
        this.S = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArrayD.getText(R$styleable.TextInputLayout_android_hint));
        this.f15906a1 = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.Z0 = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_expandedHintEnabled, true);
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_android_minWidth)) {
            setMinWidth(tintTypedArrayD.getDimensionPixelSize(R$styleable.TextInputLayout_android_minWidth, -1));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_android_maxWidth)) {
            setMaxWidth(tintTypedArrayD.getDimensionPixelSize(R$styleable.TextInputLayout_android_maxWidth, -1));
        }
        this.f15905a0 = l.a(context2, attributeSet, i2, e1).a();
        this.f15907b0 = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.f15913e0 = tintTypedArrayD.getDimensionPixelOffset(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f15915g0 = tintTypedArrayD.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.f15916h0 = tintTypedArrayD.getDimensionPixelSize(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.f15914f0 = this.f15915g0;
        float dimension = tintTypedArrayD.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = tintTypedArrayD.getDimension(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = tintTypedArrayD.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = tintTypedArrayD.getDimension(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        l.b bVarM = this.f15905a0.m();
        if (dimension >= 0.0f) {
            bVarM.d(dimension);
        }
        if (dimension2 >= 0.0f) {
            bVarM.e(dimension2);
        }
        if (dimension3 >= 0.0f) {
            bVarM.c(dimension3);
        }
        if (dimension4 >= 0.0f) {
            bVarM.b(dimension4);
        }
        this.f15905a0 = bVarM.a();
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListA != null) {
            this.S0 = colorStateListA.getDefaultColor();
            this.f15918j0 = this.S0;
            if (colorStateListA.isStateful()) {
                this.T0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.U0 = colorStateListA.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.V0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.U0 = this.S0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, R$color.mtrl_filled_background_color);
                this.T0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.V0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f15918j0 = 0;
            this.S0 = 0;
            this.T0 = 0;
            this.U0 = 0;
            this.V0 = 0;
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList2 = tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_android_textColorHint);
            this.N0 = colorStateList2;
            this.M0 = colorStateList2;
        }
        ColorStateList colorStateListA2 = com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_boxStrokeColor);
        this.Q0 = tintTypedArrayD.getColor(R$styleable.TextInputLayout_boxStrokeColor, 0);
        this.O0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.W0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_disabled_color);
        this.P0 = ContextCompat.getColor(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListA2 != null) {
            setBoxStrokeColorStateList(colorStateListA2);
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_boxStrokeErrorColor));
        }
        if (tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int resourceId = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_errorTextAppearance, 0);
        CharSequence text = tintTypedArrayD.getText(R$styleable.TextInputLayout_errorContentDescription);
        boolean z2 = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_errorEnabled, false);
        this.K0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.f15931u, false);
        this.K0.setId(R$id.text_input_error_icon);
        this.K0.setVisibility(8);
        if (com.google.android.material.i.c.a(context2)) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.K0.getLayoutParams(), 0);
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(tintTypedArrayD.getDrawable(R$styleable.TextInputLayout_errorIconDrawable));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_errorIconTint));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(s.a(tintTypedArrayD.getInt(R$styleable.TextInputLayout_errorIconTintMode, -1), (PorterDuff.Mode) null));
        }
        this.K0.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.K0, 2);
        this.K0.setClickable(false);
        this.K0.setPressable(false);
        this.K0.setFocusable(false);
        int resourceId2 = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean z3 = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = tintTypedArrayD.getText(R$styleable.TextInputLayout_helperText);
        int resourceId3 = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = tintTypedArrayD.getText(R$styleable.TextInputLayout_placeholderText);
        int resourceId4 = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence text4 = tintTypedArrayD.getText(R$styleable.TextInputLayout_prefixText);
        int resourceId5 = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence text5 = tintTypedArrayD.getText(R$styleable.TextInputLayout_suffixText);
        boolean z4 = tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(tintTypedArrayD.getInt(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.G = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_counterTextAppearance, 0);
        this.F = tintTypedArrayD.getResourceId(R$styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f15923o0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.f15929t, false);
        this.f15923o0.setVisibility(8);
        if (com.google.android.material.i.c.a(context2)) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f15923o0.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(tintTypedArrayD.getDrawable(R$styleable.TextInputLayout_startIconDrawable));
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(tintTypedArrayD.getText(R$styleable.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_startIconTint)) {
            setStartIconTintList(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_startIconTint));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(s.a(tintTypedArrayD.getInt(R$styleable.TextInputLayout_startIconTintMode, -1), (PorterDuff.Mode) null));
        }
        setBoxBackgroundMode(tintTypedArrayD.getInt(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        this.f15942z0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_end_icon, (ViewGroup) this.f15933v, false);
        this.f15933v.addView(this.f15942z0);
        this.f15942z0.setVisibility(8);
        if (com.google.android.material.i.c.a(context2)) {
            i3 = 0;
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f15942z0.getLayoutParams(), 0);
        } else {
            i3 = 0;
        }
        this.f15940y0.append(-1, new com.google.android.material.textfield.b(this));
        this.f15940y0.append(i3, new com.google.android.material.textfield.g(this));
        this.f15940y0.append(1, new h(this));
        this.f15940y0.append(2, new com.google.android.material.textfield.a(this));
        this.f15940y0.append(3, new com.google.android.material.textfield.d(this));
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_endIconMode)) {
            setEndIconMode(tintTypedArrayD.getInt(R$styleable.TextInputLayout_endIconMode, 0));
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(tintTypedArrayD.getDrawable(R$styleable.TextInputLayout_endIconDrawable));
            }
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(tintTypedArrayD.getText(R$styleable.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(tintTypedArrayD.getDrawable(R$styleable.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(tintTypedArrayD.getText(R$styleable.TextInputLayout_passwordToggleContentDescription));
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_passwordToggleTint));
            }
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(s.a(tintTypedArrayD.getInt(R$styleable.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        if (!tintTypedArrayD.hasValue(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_endIconTint)) {
                setEndIconTintList(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.TextInputLayout_endIconTint));
            }
            if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(s.a(tintTypedArrayD.getInt(R$styleable.TextInputLayout_endIconTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        this.P = new AppCompatTextView(context2);
        this.P.setId(R$id.textinput_prefix_text);
        this.P.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.P, 1);
        this.f15929t.addView(this.f15923o0);
        this.f15929t.addView(this.P);
        this.R = new AppCompatTextView(context2);
        this.R.setId(R$id.textinput_suffix_text);
        this.R.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(this.R, 1);
        this.f15931u.addView(this.R);
        this.f15931u.addView(this.K0);
        this.f15931u.addView(this.f15933v);
        setHelperTextEnabled(z3);
        setHelperText(text2);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z2);
        setErrorTextAppearance(resourceId);
        setErrorContentDescription(text);
        setCounterTextAppearance(this.G);
        setCounterOverflowTextAppearance(this.F);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setPrefixText(text4);
        setPrefixTextAppearance(resourceId4);
        setSuffixText(text5);
        setSuffixTextAppearance(resourceId5);
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_errorTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_helperTextTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_hintTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_counterTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_counterOverflowTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_placeholderTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_prefixTextColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(tintTypedArrayD.getColorStateList(R$styleable.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(z4);
        setEnabled(tintTypedArrayD.getBoolean(R$styleable.TextInputLayout_android_enabled, true));
        tintTypedArrayD.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
    }

    private int b(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f15935w.getCompoundPaddingRight();
        return (this.O == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.P.getMeasuredWidth() - this.P.getPaddingRight());
    }

    void a(boolean z2) {
        a(z2, false);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.K0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.A.l());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f15942z0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f15942z0.setImageDrawable(drawable);
    }

    private void a(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f15935w;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f15935w;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean zC = this.A.c();
        ColorStateList colorStateList2 = this.M0;
        if (colorStateList2 != null) {
            this.Y0.a(colorStateList2);
            this.Y0.b(this.M0);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.M0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.W0) : this.W0;
            this.Y0.a(ColorStateList.valueOf(colorForState));
            this.Y0.b(ColorStateList.valueOf(colorForState));
        } else if (zC) {
            this.Y0.a(this.A.g());
        } else if (this.D && (textView = this.E) != null) {
            this.Y0.a(textView.getTextColors());
        } else if (z5 && (colorStateList = this.N0) != null) {
            this.Y0.a(colorStateList);
        }
        if (!z4 && this.Z0 && (!isEnabled() || !z5)) {
            if (z3 || !this.X0) {
                c(z2);
                return;
            }
            return;
        }
        if (z3 || this.X0) {
            b(z2);
        }
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    private void c(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.W;
        if (materialShapeDrawable != null) {
            int i2 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i2 - this.f15916h0, rect.right, i2);
        }
    }

    @NonNull
    private Rect b(@NonNull Rect rect) {
        if (this.f15935w != null) {
            Rect rect2 = this.f15920l0;
            float fI = this.Y0.i();
            rect2.left = rect.left + this.f15935w.getCompoundPaddingLeft();
            rect2.top = a(rect, fI);
            rect2.right = rect.right - this.f15935w.getCompoundPaddingRight();
            rect2.bottom = a(rect, rect2, fI);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void c(boolean z2) {
        ValueAnimator valueAnimator = this.f15908b1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f15908b1.cancel();
        }
        if (z2 && this.f15906a1) {
            a(0.0f);
        } else {
            this.Y0.b(0.0f);
        }
        if (w() && ((com.google.android.material.textfield.c) this.V).w()) {
            v();
        }
        this.X0 = true;
        z();
        U();
        W();
    }

    private void b(int i2) {
        Iterator<g> it = this.A0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private static void b(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a(checkableImageButton, onLongClickListener);
    }

    private void b(@NonNull Canvas canvas) {
        if (this.S) {
            this.Y0.a(canvas);
        }
    }

    @VisibleForTesting
    final boolean c() {
        return this.X0;
    }

    private void b(boolean z2) {
        ValueAnimator valueAnimator = this.f15908b1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f15908b1.cancel();
        }
        if (z2 && this.f15906a1) {
            a(1.0f);
        } else {
            this.Y0.b(1.0f);
        }
        this.X0 = false;
        if (w()) {
            D();
        }
        S();
        U();
        W();
    }

    void a(int i2) {
        boolean z2 = this.D;
        int i3 = this.C;
        if (i3 == -1) {
            this.E.setText(String.valueOf(i2));
            this.E.setContentDescription(null);
            this.D = false;
        } else {
            this.D = i2 > i3;
            a(getContext(), this.E, i2, this.C, this.D);
            if (z2 != this.D) {
                M();
            }
            this.E.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.C))));
        }
        if (this.f15935w == null || z2 == this.D) {
            return;
        }
        a(false);
        j();
        i();
    }

    private void b(boolean z2, boolean z3) {
        int defaultColor = this.R0.getDefaultColor();
        int colorForState = this.R0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.R0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.f15917i0 = colorForState2;
        } else if (z3) {
            this.f15917i0 = colorForState;
        } else {
            this.f15917i0 = defaultColor;
        }
    }

    private static void a(@NonNull Context context, @NonNull TextView textView, int i2, int i3, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private static void a(@NonNull ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R$style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R$color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a(android.widget.TextView, int):void");
    }

    @NonNull
    private Rect a(@NonNull Rect rect) {
        if (this.f15935w != null) {
            Rect rect2 = this.f15920l0;
            boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i2 = this.f15911d0;
            if (i2 == 1) {
                rect2.left = a(rect.left, z2);
                rect2.top = rect.top + this.f15913e0;
                rect2.right = b(rect.right, z2);
                return rect2;
            }
            if (i2 != 2) {
                rect2.left = a(rect.left, z2);
                rect2.top = getPaddingTop();
                rect2.right = b(rect.right, z2);
                return rect2;
            }
            rect2.left = rect.left + this.f15935w.getPaddingLeft();
            rect2.top = rect.top - s();
            rect2.right = rect.right - this.f15935w.getPaddingRight();
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int a(int i2, boolean z2) {
        int compoundPaddingLeft = i2 + this.f15935w.getCompoundPaddingLeft();
        return (this.O == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.P.getMeasuredWidth()) + this.P.getPaddingLeft();
    }

    private int a(@NonNull Rect rect, float f2) {
        if (B()) {
            return (int) (rect.centerY() - (f2 / 2.0f));
        }
        return rect.top + this.f15935w.getCompoundPaddingTop();
    }

    private int a(@NonNull Rect rect, @NonNull Rect rect2, float f2) {
        if (B()) {
            return (int) (rect2.top + f2);
        }
        return rect.bottom - this.f15935w.getCompoundPaddingBottom();
    }

    public boolean a() {
        return this.f15933v.getVisibility() == 0 && this.f15942z0.getVisibility() == 0;
    }

    public void a(@NonNull g gVar) {
        this.A0.add(gVar);
    }

    public void a(@NonNull f fVar) {
        this.f15936w0.add(fVar);
        if (this.f15935w != null) {
            fVar.a(this);
        }
    }

    private void a(@NonNull CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z2) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z3) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void a(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        a(checkableImageButton, onLongClickListener);
    }

    private static void a(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z2 = onLongClickListener != null;
        boolean z3 = zHasOnClickListeners || z2;
        checkableImageButton.setFocusable(z3);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z3 ? 1 : 2);
    }

    private void a(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.W;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.f15914f0;
            this.W.draw(canvas);
        }
    }

    private void a(@NonNull RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.f15907b0;
        rectF.left = f2 - i2;
        rectF.right += i2;
    }

    private void a(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(a(checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private int[] a(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    @VisibleForTesting
    void a(float f2) {
        if (this.Y0.k() == f2) {
            return;
        }
        if (this.f15908b1 == null) {
            this.f15908b1 = new ValueAnimator();
            this.f15908b1.setInterpolator(com.google.android.material.a.a.b);
            this.f15908b1.setDuration(167L);
            this.f15908b1.addUpdateListener(new d());
        }
        this.f15908b1.setFloatValues(this.Y0.k(), f2);
        this.f15908b1.start();
    }
}
