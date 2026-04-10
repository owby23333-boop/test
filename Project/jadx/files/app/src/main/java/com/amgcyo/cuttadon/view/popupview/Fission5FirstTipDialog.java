package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;

/* JADX INFO: loaded from: classes.dex */
public class Fission5FirstTipDialog extends CenterPopupView {
    private Unbinder R;
    Context S;

    @BindView(R.id.iv_bg)
    ImageView iv_bg;

    @BindView(R.id.iv_close)
    ImageView iv_close;

    @BindView(R.id.tv_money)
    TextView tv_money;

    public Fission5FirstTipDialog(@NonNull Context context) {
        super(context);
        this.S = context;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popupview_fission5_tips;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.R;
        if (unbinder == null || unbinder == Unbinder.EMPTY) {
            return;
        }
        unbinder.unbind();
    }

    @OnClick({R.id.iv_ljtx, R.id.iv_close})
    public void onViewClicked(View view) {
        if (this.S == null) {
            return;
        }
        if (view.getId() == R.id.iv_ljtx) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("fission_index_page", 1);
                bundle.putInt("find_pwd", 2);
                r0.a(this.S, bundle);
            } else {
                r0.c(this.S);
            }
        }
        g();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = ButterKnife.bind(this);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
        g0.a().b("is_show_with_draw" + t0.a(), true);
    }
}
