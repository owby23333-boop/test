package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.fatcatfat.io.R;
import java.util.regex.Pattern;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkCancelAccountActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.et_username)
    EditText etPhoneNum;

    @BindView(R.id.et_smsCode)
    EditText etSmsCode;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String f2920n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2921o0;

    @BindView(R.id.tv_reg)
    TextView tvReg;

    @BindView(R.id.tv_countryCode)
    TextView tv_countryCode;

    @BindView(R.id.tv_getCode)
    TextView tv_getCode;

    private void n() {
        String strTrim = this.etPhoneNum.getText().toString().trim();
        final String strTrim2 = this.etSmsCode.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() == 0) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.input_phone));
            return;
        }
        if (TextUtils.isEmpty(strTrim2) || strTrim2.length() == 0) {
            showMessage("请输入验证码");
        } else if (Pattern.compile("^[0-9]{6}$").matcher(strTrim2).matches()) {
            com.amgcyo.cuttadon.f.o.a(this, "确定注销", "继续使用", "重要提示", com.amgcyo.cuttadon.f.o.d(R.string.zhuxiao_tips), new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3000s.a(strTrim2, view);
                }
            }, (View.OnClickListener) null);
        } else {
            showMessage("验证码只能是6位数字");
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(String str, View view) {
        ((UserPresenter) this.f2276v).a(Message.a(this, new Object[]{str}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "账号注销";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        BaseModel baseModel;
        int i2;
        super.handleMessage(message);
        int i3 = message.f21197s;
        if (i3 == 1901) {
            this.tv_getCode.setEnabled(false);
            new com.amgcyo.cuttadon.utils.otherutils.o(this.tv_getCode, 60000L, 1000L).start();
            this.etSmsCode.setEnabled(true);
            this.etSmsCode.requestFocus();
            this.tvReg.setEnabled(true);
            return;
        }
        if (i3 != 1101 || (baseModel = (BaseModel) message.f21202x) == null || (i2 = this.f2921o0) <= 0) {
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.t(i2) <= 0) {
            showMessage("系统参数异常，请稍后重试！");
            return;
        }
        showMessage(baseModel.getMsg() + "，书架所有书籍已清空！");
        me.jessyan.art.d.d.e().a(MkUserModifyActivity.class, MkCancelAccountActivity.class);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.f2920n0 = g0.a().d("tel");
        String str = "tel：" + this.f2920n0;
        if (mkUserJ == null || TextUtils.isEmpty(this.f2920n0)) {
            b1 b1Var = new b1(a());
            b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.user.t
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.finish();
                }
            });
            b1Var.show();
            b1Var.a("参数异常，请先退出登录，然后再重新登陆后重试！");
            return;
        }
        this.etPhoneNum.setText(mkUserJ.getUser());
        this.etPhoneNum.setEnabled(false);
        this.f2921o0 = mkUserJ.getUser_id();
        this.tv_countryCode.setText(String.format("+%s", this.f2920n0));
        this.tv_countryCode.setEnabled(false);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_cancel_account;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.tv_reg, R.id.tv_getCode})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_getCode) {
            ((UserPresenter) this.f2276v).m(Message.a(this, new Object[]{this.etPhoneNum.getText().toString(), this.f2920n0}));
        } else {
            if (id != R.id.tv_reg) {
                return;
            }
            n();
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
