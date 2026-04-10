package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class ConfirmAccountPopupView extends CenterPopupView implements View.OnClickListener {
    TextView R;
    TextView S;
    TextView T;
    ImageView U;
    String V;
    a W;

    public interface a {
        void onstartTx();

        void onstartTxOtherAccount();
    }

    public ConfirmAccountPopupView(@NonNull Context context, String str) {
        super(context);
        this.V = str;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_confirm_account;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g();
        if (this.W == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_other_account) {
            this.W.onstartTxOtherAccount();
        } else {
            if (id != R.id.tv_tx) {
                return;
            }
            this.W.onstartTx();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.U = (ImageView) findViewById(R.id.iv_close);
        this.R = (TextView) findViewById(R.id.tv_account);
        this.T = (TextView) findViewById(R.id.tv_other_account);
        this.S = (TextView) findViewById(R.id.tv_tx);
        this.R.setText(this.V);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.S.setOnClickListener(this);
    }

    public void setListener(a aVar) {
        this.W = aVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
