package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ShowCurrentPhoneActivity extends BaseTitleBarActivity {

    @BindView(R.id.btn_change)
    CommonShapeButton btn_change;

    @BindView(R.id.tv_current_login_user)
    TextView tv_current_login_user;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return com.amgcyo.cuttadon.f.o.d(R.string.change_phone);
    }

    public /* synthetic */ void e(View view) {
        r0.startActivity(this.f2277w, ChangeUserPhoneActivity.class);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ != null) {
            this.tv_current_login_user.setText(String.format("当前登录手机号：%s", mkUserJ.getUser()));
            this.btn_change.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3009s.e(view);
                }
            });
        } else {
            showMessage("请先登录！");
            finish();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.band_phone_page;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }
}
