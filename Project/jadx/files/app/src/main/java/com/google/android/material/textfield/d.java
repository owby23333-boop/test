package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.internal.k;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f15967q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f15968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f15969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.e f15970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.f f15971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.g f15972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f15975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private StateListDrawable f15976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MaterialShapeDrawable f15977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private AccessibilityManager f15978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueAnimator f15979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f15980p;

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class a extends k {

        /* JADX INFO: renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        class RunnableC0333a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f15982s;

            RunnableC0333a(AutoCompleteTextView autoCompleteTextView) {
                this.f15982s = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f15982s.isPopupShowing();
                d.this.b(zIsPopupShowing);
                d.this.f15973i = zIsPopupShowing;
            }
        }

        a() {
        }

        @Override // com.google.android.material.internal.k, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewC = d.c(d.this.a.getEditText());
            if (d.this.f15978n.isTouchExplorationEnabled() && d.d((EditText) autoCompleteTextViewC) && !d.this.f15992c.hasFocus()) {
                autoCompleteTextViewC.dismissDropDown();
            }
            autoCompleteTextViewC.post(new RunnableC0333a(autoCompleteTextViewC));
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            d.this.f15992c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            d.this.a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            d.this.b(false);
            d.this.f15973i = false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class C0334d extends TextInputLayout.e {
        C0334d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!d.d(d.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewC = d.c(d.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f15978n.isTouchExplorationEnabled() && !d.d(d.this.a.getEditText())) {
                d.this.d(autoCompleteTextViewC);
            }
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class e implements TextInputLayout.f {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewC = d.c(textInputLayout.getEditText());
            d.this.b(autoCompleteTextViewC);
            d.this.a(autoCompleteTextViewC);
            d.this.c(autoCompleteTextViewC);
            autoCompleteTextViewC.setThreshold(0);
            autoCompleteTextViewC.removeTextChangedListener(d.this.f15968d);
            autoCompleteTextViewC.addTextChangedListener(d.this.f15968d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.d((EditText) autoCompleteTextViewC)) {
                ViewCompat.setImportantForAccessibility(d.this.f15992c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f15970f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class f implements TextInputLayout.g {

        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f15986s;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f15986s = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15986s.removeTextChangedListener(d.this.f15968d);
            }
        }

        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f15969e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f15967q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.d((AutoCompleteTextView) d.this.a.getEditText());
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class h implements View.OnTouchListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f15989s;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f15989s = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.e()) {
                    d.this.f15973i = false;
                }
                d.this.d(this.f15989s);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f15973i = true;
            d.this.f15975k = System.currentTimeMillis();
            d.this.b(false);
        }
    }

    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f15992c.setChecked(dVar.f15974j);
            d.this.f15980p.start();
        }
    }

    static {
        f15967q = Build.VERSION.SDK_INT >= 21;
    }

    d(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f15968d = new a();
        this.f15969e = new c();
        this.f15970f = new C0334d(this.a);
        this.f15971g = new e();
        this.f15972h = new f();
        this.f15973i = false;
        this.f15974j = false;
        this.f15975k = Long.MAX_VALUE;
    }

    @Override // com.google.android.material.textfield.e
    boolean a(int i2) {
        return i2 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f15975k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (e()) {
            this.f15973i = false;
        }
        if (!this.f15973i) {
            if (f15967q) {
                b(!this.f15974j);
            } else {
                this.f15974j = !this.f15974j;
                this.f15992c.toggle();
            }
            if (this.f15974j) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.f15973i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f15969e);
        if (f15967q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (f15967q) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f15977m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f15976l);
            }
        }
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        float dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableA = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableA2 = a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f15977m = materialShapeDrawableA;
        this.f15976l = new StateListDrawable();
        this.f15976l.addState(new int[]{R.attr.state_above_anchor}, materialShapeDrawableA);
        this.f15976l.addState(new int[0], materialShapeDrawableA2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, f15967q ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new g());
        this.a.a(this.f15971g);
        this.a.a(this.f15972h);
        d();
        this.f15978n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AutoCompleteTextView c(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void b(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int iA = com.google.android.material.c.a.a(autoCompleteTextView, R$attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.l());
        int iA2 = com.google.android.material.c.a.a(i2, iA, 0.1f);
        materialShapeDrawable2.a(new ColorStateList(iArr, new int[]{iA2, 0}));
        if (f15967q) {
            materialShapeDrawable2.setTint(iA);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iA2, iA});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.l());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(@NonNull EditText editText) {
        return editText.getKeyListener() != null;
    }

    private void d() {
        this.f15980p = a(67, 0.0f, 1.0f);
        this.f15979o = a(50, 1.0f, 0.0f);
        this.f15979o.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (this.f15974j != z2) {
            this.f15974j = z2;
            this.f15980p.cancel();
            this.f15979o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (d((EditText) autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        MaterialShapeDrawable boxBackground = this.a.getBoxBackground();
        int iA = com.google.android.material.c.a.a(autoCompleteTextView, R$attr.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            b(autoCompleteTextView, iA, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            a(autoCompleteTextView, iA, iArr, boxBackground);
        }
    }

    private void a(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {com.google.android.material.c.a.a(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f15967q) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.l());
        materialShapeDrawable2.a(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private MaterialShapeDrawable a(float f2, float f3, float f4, int i2) {
        l.b bVarN = l.n();
        bVarN.d(f2);
        bVarN.e(f2);
        bVarN.b(f3);
        bVarN.c(f3);
        l lVarA = bVarN.a();
        MaterialShapeDrawable materialShapeDrawableA = MaterialShapeDrawable.a(this.b, f4);
        materialShapeDrawableA.setShapeAppearanceModel(lVarA);
        materialShapeDrawableA.a(0, i2, 0, i2);
        return materialShapeDrawableA;
    }

    private ValueAnimator a(int i2, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.a);
        valueAnimatorOfFloat.setDuration(i2);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }
}
