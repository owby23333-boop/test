package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.BottomPopupView;

/* JADX INFO: loaded from: classes.dex */
public class BottomSharePopupView extends BottomPopupView implements View.OnClickListener {
    a O;

    public interface a {
        void wxShare();

        void zfbShare();
    }

    public BottomSharePopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.custom_bottom_share_popup;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return (int) (com.lxj.xpopup.util.b.a(getContext()) * 0.9f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.O == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_qrcode) {
            this.O.zfbShare();
        } else if (id == R.id.tv_wx) {
            this.O.wxShare();
        }
        g();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        TextView textView = (TextView) findViewById(R.id.tv_qrcode);
        ((TextView) findViewById(R.id.tv_wx)).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
    }

    public void setListener(a aVar) {
        this.O = aVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
