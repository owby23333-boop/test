package com.amgcyo.cuttadon.activity.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.fatcatfat.io.R;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.regex.Pattern;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkUserLoginActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.checkbox_private)
    CheckBox checkbox_private;

    @BindView(R.id.et_username)
    EditText etPhoneNum;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.ll_tip)
    LinearLayout ll_tip;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    boolean f2937n0 = false;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    int f2938o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private MkAreaCodeBean f2939p0;

    @BindView(R.id.tv_login)
    TextView tvLogin;

    @BindView(R.id.tv_privacy)
    TextView tvPrivacy;

    @BindView(R.id.tv_useragree)
    TextView tvUseragree;

    @BindView(R.id.tv_countryCode)
    TextView tv_countryCode;

    @BindView(R.id.tv_welcome)
    TextView tv_welcome;

    class a extends com.amgcyo.cuttadon.j.e.a {
        a(int i2) {
            super(i2);
        }

        @Override // com.amgcyo.cuttadon.j.e.a
        public void a(View view) {
            MkUserLoginActivity.this.p();
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "finish_activity")
    private void finishShelf(MkUser mkUser) {
        if (mkUser != null) {
            if (mkUser.isLogin()) {
                me.jessyan.art.d.f.a().a(mkUser, "refreshingBookShelf");
            }
            finish();
        }
    }

    private void n() {
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(new Intent(this.f2277w, (Class<?>) MkAreaCodeActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.user.j
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.b(i2, intent);
            }
        });
    }

    private void o() {
        if (this.f2939p0 == null) {
            this.f2939p0 = com.amgcyo.cuttadon.utils.otherutils.g.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        o();
        String strTrim = this.etPhoneNum.getText().toString().trim();
        String strTrim2 = this.etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() == 0) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.input_phone));
            return;
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.b(this.f2939p0.getRegexp_literal(), strTrim)) {
            com.amgcyo.cuttadon.f.o.b("手机号格式不正确~");
            return;
        }
        if (TextUtils.isEmpty(strTrim2) || strTrim2.length() == 0) {
            com.amgcyo.cuttadon.f.o.b("请输入密码");
            return;
        }
        if (!Pattern.compile("^.{6,20}$").matcher(strTrim2).matches()) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.pwd_error));
            return;
        }
        if (this.checkbox_private.isChecked()) {
            this.tvLogin.setEnabled(false);
            AppDatabase.i().d().b();
            ((UserPresenter) this.f2276v).o(Message.a(this, new Object[]{strTrim, strTrim2, this.f2939p0.getTel(), Integer.valueOf(this.f2938o0)}));
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) this);
            showMessage("请点击同意用户协议及隐私政策！");
            com.amgcyo.cuttadon.utils.otherutils.g.a(this.ll_tip);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        this.f2939p0 = (MkAreaCodeBean) intent.getSerializableExtra("MkAreaCodeBean");
        MkAreaCodeBean mkAreaCodeBean = this.f2939p0;
        if (mkAreaCodeBean == null) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.set_areacode_error));
            return;
        }
        this.tv_countryCode.setText(String.format("+%s", mkAreaCodeBean.getTel()));
        this.etPhoneNum.setText("");
        showMessage("已选择“" + this.f2939p0.getName() + "”");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.from_top_to_bottom);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        TextView textView;
        super.handleMessage(message);
        if (message.f21197s != 824 || (textView = this.tvLogin) == null) {
            return;
        }
        textView.setEnabled(true);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f2937n0 = extras.getBoolean(DownloadSettingKeys.AhPlans.KEY_SHOW_TIPS, false);
            this.f2938o0 = extras.getInt("fission_index_page", 0);
            if (this.f2937n0) {
                showMessage("请您先登录");
            }
        }
        this.tv_welcome.setText(com.amgcyo.cuttadon.f.o.d(R.string.welcome_desc));
        this.tvLogin.setOnClickListener(new a(TTAdConstant.STYLE_SIZE_RADIO_3_2));
        o();
        this.checkbox_private.setChecked(false);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_login;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @OnClick({R.id.iv_exitLogin, R.id.ll_tip, R.id.tv_countryCode, R.id.tv_useragree, R.id.tv_privacy, R.id.iv_reg, R.id.iv_find_pwd})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fission_index_page", this.f2938o0);
        switch (view.getId()) {
            case R.id.iv_exitLogin /* 2131297170 */:
                finish();
                break;
            case R.id.iv_find_pwd /* 2131297173 */:
                bundle.putInt("find_pwd", 5);
                r0.a(this, bundle);
                break;
            case R.id.iv_reg /* 2131297207 */:
                bundle.putInt("find_pwd", 2);
                r0.a(this, bundle);
                break;
            case R.id.ll_tip /* 2131297973 */:
                if (!this.checkbox_private.isChecked()) {
                    this.checkbox_private.setChecked(true);
                } else {
                    this.checkbox_private.setChecked(false);
                }
                break;
            case R.id.tv_countryCode /* 2131298652 */:
                n();
                break;
            case R.id.tv_privacy /* 2131298778 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.C());
                break;
            case R.id.tv_useragree /* 2131298875 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.b0());
                break;
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
