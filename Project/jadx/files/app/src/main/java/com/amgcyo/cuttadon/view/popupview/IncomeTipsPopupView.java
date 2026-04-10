package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class IncomeTipsPopupView extends CenterPopupView implements View.OnClickListener {
    TextView R;
    TextView S;
    TextView T;
    ImageView U;
    SpannableString V;
    SpannableString W;

    public IncomeTipsPopupView(@NonNull Context context, SpannableString spannableString, SpannableString spannableString2) {
        super(context);
        this.V = spannableString;
        this.W = spannableString2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_income_tips;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.U = (ImageView) findViewById(R.id.iv_close);
        this.S = (TextView) findViewById(R.id.tv_knows);
        this.R = (TextView) findViewById(R.id.tv_rule1);
        this.T = (TextView) findViewById(R.id.tv_rule2);
        this.R.setText(this.V);
        this.T.setText(this.W);
        this.U.setOnClickListener(this);
        this.S.setOnClickListener(this);
    }

    public void setSpannableString1(SpannableString spannableString) {
        this.V = spannableString;
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(spannableString);
        }
    }

    public void setSpannableString2(SpannableString spannableString) {
        this.W = spannableString;
        TextView textView = this.T;
        if (textView != null) {
            textView.setText(spannableString);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
