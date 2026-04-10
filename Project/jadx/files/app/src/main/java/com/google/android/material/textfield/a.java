package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f15952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f15953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.f f15954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.g f15955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AnimatorSet f15956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ValueAnimator f15957i;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class C0331a implements TextWatcher {
        C0331a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a aVar = a.this;
            aVar.b(aVar.a.hasFocus() && a.b(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            a.this.b((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z2);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.b(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f15953e);
            editText.removeTextChangedListener(a.this.f15952d);
            editText.addTextChangedListener(a.this.f15952d);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class d implements TextInputLayout.g {

        /* JADX INFO: renamed from: com.google.android.material.textfield.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
        class RunnableC0332a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ EditText f15960s;

            RunnableC0332a(EditText editText) {
                this.f15960s = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15960s.removeTextChangedListener(a.this.f15952d);
            }
        }

        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.post(new RunnableC0332a(editText));
            if (editText.getOnFocusChangeListener() == a.this.f15953e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.f();
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            a.this.f15992c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f15992c.setScaleX(fFloatValue);
            a.this.f15992c.setScaleY(fFloatValue);
        }
    }

    a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f15952d = new C0331a();
        this.f15953e = new b();
        this.f15954f = new c();
        this.f15955g = new d();
    }

    private ValueAnimator c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f14915d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    private void d() {
        ValueAnimator valueAnimatorC = c();
        ValueAnimator valueAnimatorA = a(0.0f, 1.0f);
        this.f15956h = new AnimatorSet();
        this.f15956h.playTogether(valueAnimatorC, valueAnimatorA);
        this.f15956h.addListener(new f());
        this.f15957i = a(1.0f, 0.0f);
        this.f15957i.addListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        boolean z3 = this.a.a() == z2;
        if (z2 && !this.f15956h.isRunning()) {
            this.f15957i.cancel();
            this.f15956h.start();
            if (z3) {
                this.f15956h.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.f15956h.cancel();
        this.f15957i.start();
        if (z3) {
            this.f15957i.end();
        }
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.a(this.f15954f);
        this.a.a(this.f15955g);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(@NonNull Editable editable) {
        return editable.length() > 0;
    }

    @Override // com.google.android.material.textfield.e
    void a(boolean z2) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        b(z2);
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }
}
