package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f16017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.f f16018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.g f16019f;

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class a extends k {
        a() {
        }

        @Override // com.google.android.material.internal.k, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f15992c.setChecked(!r1.c());
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h.this.f15992c.setChecked(!r4.c());
            editText.removeTextChangedListener(h.this.f16017d);
            editText.addTextChangedListener(h.this.f16017d);
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class c implements TextInputLayout.g {

        /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ EditText f16021s;

            a(EditText editText) {
                this.f16021s = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16021s.removeTextChangedListener(h.this.f16017d);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (h.this.c()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            h.this.a.f();
        }
    }

    h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f16017d = new a();
        this.f16018e = new b();
        this.f16019f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.a(this.f16018e);
        this.a.a(this.f16019f);
        EditText editText = this.a.getEditText();
        if (a(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    private static boolean a(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
