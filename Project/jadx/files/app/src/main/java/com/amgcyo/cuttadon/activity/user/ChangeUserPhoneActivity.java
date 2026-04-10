package com.amgcyo.cuttadon.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.fatcatfat.io.R;
import java.util.regex.Pattern;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class ChangeUserPhoneActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.et_username)
    EditText etPhoneNum;

    @BindView(R.id.et_smsCode)
    EditText etSmsCode;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String f2908n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2909o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    TextWatcher f2910p0 = new a();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private MkAreaCodeBean f2911q0;

    @BindView(R.id.tv_reg)
    TextView tvReg;

    @BindView(R.id.tv_change_tips)
    TextView tv_change_tips;

    @BindView(R.id.tv_countryCode)
    TextView tv_countryCode;

    @BindView(R.id.tv_getCode)
    TextView tv_getCode;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            ChangeUserPhoneActivity.this.tvReg.setEnabled(false);
            ChangeUserPhoneActivity.this.tv_getCode.setEnabled(false);
            ChangeUserPhoneActivity.this.tv_getCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.dddddd));
            ChangeUserPhoneActivity.this.o();
            if (TextUtils.isEmpty(charSequence) || charSequence.length() == 0) {
                ChangeUserPhoneActivity.this.showMessage(com.amgcyo.cuttadon.f.o.d(R.string.input_phone));
                return;
            }
            if (charSequence.length() <= 4) {
                return;
            }
            if (ChangeUserPhoneActivity.this.f2911q0.getLen() <= 4 || ChangeUserPhoneActivity.this.f2911q0.getLen() == charSequence.length()) {
                if (!com.amgcyo.cuttadon.utils.otherutils.g.b(ChangeUserPhoneActivity.this.f2911q0.getRegexp_literal(), charSequence)) {
                    com.amgcyo.cuttadon.f.o.b("手机号格式不正确~");
                } else {
                    ChangeUserPhoneActivity.this.tv_getCode.setEnabled(true);
                    ChangeUserPhoneActivity.this.tv_getCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
                }
            }
        }
    }

    private void n() {
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(new Intent(this.f2277w, (Class<?>) MkAreaCodeActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.user.a
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.b(i2, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f2911q0 == null) {
            this.f2911q0 = com.amgcyo.cuttadon.utils.otherutils.g.u();
        }
    }

    private void p() {
        final String strTrim = this.etPhoneNum.getText().toString().trim();
        final String strTrim2 = this.etSmsCode.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() == 0) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.input_phone));
            return;
        }
        if (TextUtils.isEmpty(strTrim2) || strTrim2.length() == 0) {
            showMessage("请输入验证码");
        } else if (Pattern.compile("^[0-9]{6}$").matcher(strTrim2).matches()) {
            com.amgcyo.cuttadon.f.o.a(this, "确定更换", "继续使用", "重要提示", "更换手机号后，下次登录需要使用新手机号登录，旧手机号将无法继续使用！", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2996s.a(strTrim, strTrim2, view);
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

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return com.amgcyo.cuttadon.f.o.d(R.string.change_phone);
    }

    public /* synthetic */ void e(View view) {
        r0.b(this.f2277w);
        me.jessyan.art.d.d.e().a(MkUserModifyActivity.class, ShowCurrentPhoneActivity.class, ChangeUserPhoneActivity.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        switch (message.f21197s) {
            case 2119:
                this.tv_getCode.setEnabled(false);
                new com.amgcyo.cuttadon.utils.otherutils.o(this.tv_getCode, 60000L, 1000L).start();
                this.etSmsCode.setEnabled(true);
                this.etSmsCode.requestFocus();
                this.tvReg.setEnabled(true);
                break;
            case 2120:
                BaseModel baseModel = (BaseModel) message.f21202x;
                if (baseModel == null) {
                    showMessage("更换手机号失败，请重试！");
                    TextView textView = this.tvReg;
                    if (textView != null) {
                        textView.setClickable(true);
                    }
                } else if (com.amgcyo.cuttadon.utils.otherutils.g.t(this.f2909o0) <= 0) {
                    showMessage("更换手机号失败，请重试！");
                    TextView textView2 = this.tvReg;
                    if (textView2 != null) {
                        textView2.setClickable(true);
                    }
                } else {
                    com.amgcyo.cuttadon.f.o.a((Context) a(), "确定", true, (CharSequence) "操作提示", (CharSequence) baseModel.getMsg(), new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f2995s.e(view);
                        }
                    });
                }
                break;
            case 2121:
                TextView textView3 = this.tvReg;
                if (textView3 != null) {
                    textView3.setClickable(true);
                }
                break;
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.f2908n0 = g0.a().d("tel");
        String str = "tel：" + this.f2908n0;
        if (mkUserJ == null || TextUtils.isEmpty(this.f2908n0)) {
            b1 b1Var = new b1(a());
            b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.user.u
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.finish();
                }
            });
            b1Var.show();
            b1Var.a("参数异常，请先退出登录，然后再重新登陆后重试！");
            return;
        }
        String user = mkUserJ.getUser();
        this.f2909o0 = mkUserJ.getUser_id();
        this.tv_countryCode.setText(String.format("+%s", this.f2908n0));
        this.tvReg.setText(com.amgcyo.cuttadon.f.o.d(R.string.change_phone));
        this.tv_change_tips.setText(String.format("成功更换手机号后，下次登录需要使用新手机号登录。\n当前手机号：%s", user));
        this.tv_getCode.setEnabled(false);
        this.tv_getCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.dddddd));
        this.etPhoneNum.addTextChangedListener(this.f2910p0);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_change_phone;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.tv_reg, R.id.tv_getCode, R.id.tv_countryCode})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_countryCode) {
            n();
            return;
        }
        if (id == R.id.tv_getCode) {
            ((UserPresenter) this.f2276v).n(Message.a(this, new Object[]{this.etPhoneNum.getText().toString(), this.f2908n0}));
        } else {
            if (id != R.id.tv_reg) {
                return;
            }
            p();
        }
    }

    public /* synthetic */ void a(String str, String str2, View view) {
        ((UserPresenter) this.f2276v).J(Message.a(this, new Object[]{str, str2, this.f2911q0.getTel()}));
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        this.f2911q0 = (MkAreaCodeBean) intent.getSerializableExtra("MkAreaCodeBean");
        MkAreaCodeBean mkAreaCodeBean = this.f2911q0;
        if (mkAreaCodeBean == null) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.set_areacode_error));
            return;
        }
        this.tv_countryCode.setText(String.format("+%s", mkAreaCodeBean.getTel()));
        this.etPhoneNum.setText("");
        showMessage("已选择“" + this.f2911q0.getName() + "”");
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
