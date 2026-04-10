package com.lxj.xpopup.impl;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.lxj.xpopup.c.e;
import com.lxj.xpopup.util.b;

/* JADX INFO: loaded from: classes3.dex */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public CharSequence f17486j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    com.lxj.xpopup.c.a f17487k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    e f17488l0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputConfirmPopupView.this.f17481f0.setBackgroundDrawable(b.a(b.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.f17481f0.getMeasuredWidth(), Color.parseColor("#888888")), b.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.f17481f0.getMeasuredWidth(), com.lxj.xpopup.a.c())));
        }
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        this.f17481f0.setHintTextColor(Color.parseColor("#888888"));
        this.f17481f0.setTextColor(Color.parseColor("#dddddd"));
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        this.f17481f0.setHintTextColor(Color.parseColor("#888888"));
        this.f17481f0.setTextColor(Color.parseColor("#333333"));
    }

    public EditText getEditText() {
        return this.f17481f0;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.V) {
            com.lxj.xpopup.c.a aVar = this.f17487k0;
            if (aVar != null) {
                aVar.onCancel();
            }
            g();
            return;
        }
        if (view == this.W) {
            e eVar = this.f17488l0;
            if (eVar != null) {
                eVar.a(this.f17481f0.getText().toString().trim());
            }
            if (this.f17361s.f17409d.booleanValue()) {
                g();
            }
        }
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f17481f0.setVisibility(0);
        if (!TextUtils.isEmpty(this.f17478c0)) {
            this.f17481f0.setHint(this.f17478c0);
        }
        if (!TextUtils.isEmpty(this.f17486j0)) {
            this.f17481f0.setText(this.f17486j0);
            this.f17481f0.setSelection(this.f17486j0.length());
        }
        b.a(this.f17481f0, com.lxj.xpopup.a.c());
        this.f17481f0.post(new a());
    }
}
