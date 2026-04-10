package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class QQMsgPopup extends CenterPopupView {
    TextView R;
    String S;

    public QQMsgPopup(@NonNull Context context, String str) {
        super(context);
        this.S = str;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_qq_msg;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (TextView) findViewById(R.id.tv_msg);
        this.R.setText(this.S);
    }

    public void setMsg(String str) {
        this.S = str;
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
