package com.amgcyo.cuttadon.activity.fission5;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.FissionUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.view.dialog.y0;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class Fission5BankCountActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.et_real_name)
    EditText etRealName;

    @BindView(R.id.tv_moneys)
    TextView tv_moneys;

    @BindView(R.id.zfb_account_tv)
    EditText zfbAccountTv;

    class a implements y0.a {
        final /* synthetic */ FissionUser a;

        a(FissionUser fissionUser) {
            this.a = fissionUser;
        }

        @Override // com.amgcyo.cuttadon.view.dialog.y0.a
        public void a() {
            EditText editText = Fission5BankCountActivity.this.zfbAccountTv;
            if (editText != null) {
                editText.setText("");
                Fission5BankCountActivity.this.etRealName.setText("");
            }
        }

        @Override // com.amgcyo.cuttadon.view.dialog.y0.a
        public void b() {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putSerializable("FissionUser", this.a);
            intent.putExtras(bundle);
            Fission5BankCountActivity.this.setResult(836, intent);
            Fission5BankCountActivity.this.finish();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "提现";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("key_txmoney", "0.00");
        SpannableString spannableString = new SpannableString(string + "  元");
        spannableString.setSpan(new RelativeSizeSpan(2.0f), 0, string.length(), 33);
        this.tv_moneys.setText(spannableString);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission5_bank_account;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.btn_save_count})
    public void onClick() {
        String string = this.etRealName.getText().toString();
        String string2 = this.zfbAccountTv.getText().toString();
        String string3 = this.tv_moneys.getText().toString();
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            showMessage("请输入必要信息");
            return;
        }
        if (string.length() < 2) {
            showMessage("请输入正确的姓名");
            return;
        }
        if (string2.length() < 5) {
            showMessage("请输入正确的支付宝账户");
            return;
        }
        FissionUser fissionUser = new FissionUser(string, string2);
        y0 y0Var = new y0(a(), fissionUser, string3);
        y0Var.a(new a(fissionUser));
        y0Var.show();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
