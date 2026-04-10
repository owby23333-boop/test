package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.c.a;
import com.lxj.xpopup.c.c;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes3.dex */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {
    a R;
    c S;
    TextView T;
    TextView U;
    TextView V;
    TextView W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    CharSequence f17476a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    CharSequence f17477b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    CharSequence f17478c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    CharSequence f17479d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    CharSequence f17480e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    EditText f17481f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    View f17482g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    View f17483h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f17484i0;

    public ConfirmPopupView(@NonNull Context context, int i2) {
        super(context);
        this.f17484i0 = false;
        this.O = i2;
        w();
    }

    public ConfirmPopupView a(c cVar, a aVar) {
        this.R = aVar;
        this.S = cVar;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        this.T.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.U.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.V.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        this.W.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        View view = this.f17482g0;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        }
        View view2 = this.f17483h0;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        this.T.setTextColor(getResources().getColor(R$color._xpopup_content_color));
        this.U.setTextColor(getResources().getColor(R$color._xpopup_content_color));
        this.V.setTextColor(Color.parseColor("#666666"));
        this.W.setTextColor(com.lxj.xpopup.a.c());
        View view = this.f17482g0;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        }
        View view2 = this.f17483h0;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        }
    }

    public TextView getCancelTextView() {
        return (TextView) findViewById(R$id.tv_cancel);
    }

    public TextView getConfirmTextView() {
        return (TextView) findViewById(R$id.tv_confirm);
    }

    public TextView getContentTextView() {
        return (TextView) findViewById(R$id.tv_content);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.O;
        return i2 != 0 ? i2 : R$layout._xpopup_center_impl_confirm;
    }

    public TextView getTitleTextView() {
        return (TextView) findViewById(R$id.tv_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.V) {
            a aVar = this.R;
            if (aVar != null) {
                aVar.onCancel();
            }
            g();
            return;
        }
        if (view == this.W) {
            c cVar = this.S;
            if (cVar != null) {
                cVar.onConfirm();
            }
            if (this.f17361s.f17409d.booleanValue()) {
                g();
            }
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.T = (TextView) findViewById(R$id.tv_title);
        this.U = (TextView) findViewById(R$id.tv_content);
        this.V = (TextView) findViewById(R$id.tv_cancel);
        this.W = (TextView) findViewById(R$id.tv_confirm);
        this.U.setMovementMethod(LinkMovementMethod.getInstance());
        this.f17481f0 = (EditText) findViewById(R$id.et_input);
        this.f17482g0 = findViewById(R$id.xpopup_divider1);
        this.f17483h0 = findViewById(R$id.xpopup_divider2);
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f17476a0)) {
            this.T.setVisibility(8);
        } else {
            this.T.setText(this.f17476a0);
        }
        if (TextUtils.isEmpty(this.f17477b0)) {
            this.U.setVisibility(8);
        } else {
            this.U.setText(this.f17477b0);
        }
        if (!TextUtils.isEmpty(this.f17479d0)) {
            this.V.setText(this.f17479d0);
        }
        if (!TextUtils.isEmpty(this.f17480e0)) {
            this.W.setText(this.f17480e0);
        }
        if (this.f17484i0) {
            this.V.setVisibility(8);
            View view = this.f17483h0;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        x();
    }

    public ConfirmPopupView a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f17476a0 = charSequence;
        this.f17477b0 = charSequence2;
        this.f17478c0 = charSequence3;
        return this;
    }

    public ConfirmPopupView a(CharSequence charSequence) {
        this.f17479d0 = charSequence;
        return this;
    }

    public ConfirmPopupView b(CharSequence charSequence) {
        this.f17480e0 = charSequence;
        return this;
    }
}
