package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.PositionPopupView;

/* JADX INFO: loaded from: classes.dex */
public class VideoTipsPopup extends PositionPopupView {
    TextView O;
    String P;

    public VideoTipsPopup(@NonNull Context context, String str) {
        super(context);
        this.P = str;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_tips_video;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.O = (TextView) findViewById(R.id.tv_coin);
        this.O.setText(this.P);
    }

    public void setMsg(String str) {
        this.P = str;
        TextView textView = this.O;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
