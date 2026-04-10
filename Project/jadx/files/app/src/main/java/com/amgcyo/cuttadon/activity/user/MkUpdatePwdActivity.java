package com.amgcyo.cuttadon.activity.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkUpdatePwdActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.et_new_pwd)
    EditText etNewPwd;

    @BindView(R.id.et_old_pwd)
    EditText etOldPwd;

    @BindView(R.id.et_password_confirm)
    EditText etPasswordConfirm;

    @BindView(R.id.ll_root)
    LinearLayout llRoot;

    @BindView(R.id.tv_update_pwd)
    TextView tvUpdatePwd;

    private void n() {
        String strTrim = this.etOldPwd.getText().toString().trim();
        String strTrim2 = this.etNewPwd.getText().toString().trim();
        String strTrim3 = this.etPasswordConfirm.getText().toString().trim();
        if (com.amgcyo.cuttadon.f.o.a(strTrim, strTrim2)) {
            if (strTrim3.equals(strTrim2)) {
                ((UserPresenter) this.f2276v).O(Message.a(this, new Object[]{strTrim, strTrim2, strTrim3}));
            } else {
                showMessage("两次密码输入不一致!");
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "修改密码";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            r0.a((Activity) this);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        com.amgcyo.cuttadon.f.o.a(this.llRoot, this.tvUpdatePwd);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_update_pwd;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @OnClick({R.id.iv_exitupdate_pwd, R.id.tv_update_pwd, R.id.iv_find_pwd})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.iv_exitupdate_pwd /* 2131297172 */:
                r0.a((Activity) a());
                break;
            case R.id.iv_find_pwd /* 2131297173 */:
                Bundle bundle = new Bundle();
                bundle.putInt("find_pwd", 5);
                bundle.putBoolean("find_pwd_to_login", true);
                r0.a(this, bundle);
                break;
            case R.id.tv_update_pwd /* 2131298873 */:
                n();
                break;
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
