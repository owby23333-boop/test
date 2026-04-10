package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Chip f16024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final TextInputLayout f16025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final EditText f16026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextWatcher f16027v;

    private class b extends k {
        private b() {
        }

        @Override // com.google.android.material.internal.k, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f16024s.setText(ChipTextInputComboView.this.a("00"));
            } else {
                ChipTextInputComboView.this.f16024s.setText(ChipTextInputComboView.this.a(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f16024s.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.f16024s.setChecked(z2);
        this.f16026u.setVisibility(z2 ? 0 : 4);
        this.f16024s.setVisibility(z2 ? 8 : 0);
        if (isChecked()) {
            this.f16026u.requestFocus();
            if (TextUtils.isEmpty(this.f16026u.getText())) {
                return;
            }
            EditText editText = this.f16026u;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f16024s.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        this.f16024s.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f16024s.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f16024s = (Chip) layoutInflaterFrom.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f16025t = (TextInputLayout) layoutInflaterFrom.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f16026u = this.f16025t.getEditText();
        this.f16026u.setVisibility(4);
        this.f16027v = new b();
        this.f16026u.addTextChangedListener(this.f16027v);
        a();
        addView(this.f16024s);
        addView(this.f16025t);
        this.f16026u.setSaveEnabled(false);
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f16026u.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }
}
