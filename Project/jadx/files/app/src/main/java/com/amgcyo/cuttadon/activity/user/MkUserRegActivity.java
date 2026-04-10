package com.amgcyo.cuttadon.activity.user;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.amgcyo.cuttadon.api.entity.comic.IdsBean;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.baidu.mobads.sdk.internal.am;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkUserRegActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.checkbox_private)
    CheckBox checkbox_private;

    @BindView(R.id.cus_info)
    TextView cus_info;

    @BindView(R.id.et_username)
    EditText etPhoneNum;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.et_smsCode)
    EditText etSmsCode;

    @BindView(R.id.et_invitation_code)
    EditText et_invitation_code;

    @BindView(R.id.ll_tip)
    LinearLayout ll_tip;

    @BindView(R.id.ll_valicode)
    LinearLayout ll_valicode;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f2974n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    int f2975o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    boolean f2976p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private TextWatcher f2977q0 = new a();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    TextWatcher f2978r0 = new b();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private MkAreaCodeBean f2979s0;

    @BindView(R.id.tv_getCode)
    TextView tvGetCode;

    @BindView(R.id.tv_reg)
    TextView tvReg;

    @BindView(R.id.tv_countryCode)
    TextView tv_countryCode;

    @BindView(R.id.view_codeline)
    View view_codeline;

    @BindView(R.id.view_line_invli)
    View view_line_invli;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MkUserRegActivity mkUserRegActivity = MkUserRegActivity.this;
            mkUserRegActivity.et_invitation_code.removeTextChangedListener(mkUserRegActivity.f2977q0);
            MkUserRegActivity.this.et_invitation_code.setText(editable.toString().replaceAll("FromShare#", ""));
            EditText editText = MkUserRegActivity.this.et_invitation_code;
            editText.setSelection(editText.getText().length());
            MkUserRegActivity mkUserRegActivity2 = MkUserRegActivity.this;
            mkUserRegActivity2.et_invitation_code.addTextChangedListener(mkUserRegActivity2.f2977q0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements TextWatcher {
        b() {
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
            MkUserRegActivity.this.tvReg.setEnabled(false);
            MkUserRegActivity.this.tvGetCode.setEnabled(false);
            MkUserRegActivity.this.tvGetCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.dddddd));
            MkUserRegActivity.this.p();
            if (TextUtils.isEmpty(charSequence) || charSequence.length() == 0) {
                MkUserRegActivity.this.showMessage(com.amgcyo.cuttadon.f.o.d(R.string.input_phone));
                return;
            }
            if (charSequence.length() <= 4) {
                return;
            }
            if (MkUserRegActivity.this.f2979s0.getLen() <= 4 || MkUserRegActivity.this.f2979s0.getLen() == charSequence.length()) {
                if (!com.amgcyo.cuttadon.utils.otherutils.g.b(MkUserRegActivity.this.f2979s0.getRegexp_literal(), charSequence)) {
                    com.amgcyo.cuttadon.f.o.b("手机号格式不正确~");
                } else {
                    MkUserRegActivity.this.tvGetCode.setEnabled(true);
                    MkUserRegActivity.this.tvGetCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
                }
            }
        }
    }

    private void o() {
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(new Intent(this.f2277w, (Class<?>) MkAreaCodeActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.user.r
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.b(i2, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f2979s0 == null) {
            this.f2979s0 = com.amgcyo.cuttadon.utils.otherutils.g.u();
        }
    }

    private String q() {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip()) {
            return "";
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
        if (primaryClip == null || primaryClip.getItemCount() <= 0 || primaryClipDescription == null || !primaryClipDescription.hasMimeType(am.f12848e)) {
            return "";
        }
        int itemCount = primaryClip.getItemCount();
        String str = "itemCount:" + itemCount;
        for (int i2 = 0; i2 < itemCount; i2++) {
            ClipData.Item itemAt = primaryClip.getItemAt(i2);
            if (itemAt != null && itemAt.getText() != null && !TextUtils.isEmpty(itemAt.getText())) {
                String string = itemAt.getText().toString();
                String str2 = "str:" + string;
                if (!TextUtils.isEmpty(string) && string.contains("FromShare#")) {
                    String str3 = "邀请码前:" + string;
                    String strReplaceAll = string.replaceAll("FromShare#", "");
                    String str4 = "邀请码后:" + strReplaceAll;
                    return strReplaceAll;
                }
            }
        }
        return "";
    }

    private boolean r() {
        String strTrim = this.etPhoneNum.getText().toString().trim();
        String strTrim2 = this.etPwd.getText().toString().trim();
        String strTrim3 = this.etSmsCode.getText().toString().trim();
        p();
        return com.amgcyo.cuttadon.f.o.a(this.f2979s0, strTrim, strTrim2, strTrim3);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
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
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 823) {
            MkUser mkUser = (MkUser) message.f21202x;
            TextView textView = this.tvReg;
            if (textView != null) {
                textView.setEnabled(true);
            }
            if (mkUser != null) {
                r0.a((Activity) a());
                return;
            }
            return;
        }
        if (i2 == 824) {
            TextView textView2 = this.tvReg;
            if (textView2 != null) {
                textView2.setEnabled(true);
                return;
            }
            return;
        }
        if (i2 == 856) {
            this.tvGetCode.setEnabled(false);
            new com.amgcyo.cuttadon.utils.otherutils.o(this.tvGetCode, 60000L, 1000L).start();
            this.etSmsCode.setEnabled(true);
            this.etSmsCode.requestFocus();
            this.view_codeline.setVisibility(0);
            this.etPwd.setVisibility(0);
            this.tvReg.setEnabled(true);
            return;
        }
        if (i2 != 858) {
            return;
        }
        if (this.f2976p0) {
            MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
            if (mkUserJ != null) {
                me.jessyan.art.d.d.e().a(MkUserModifyActivity.class, MkUpdatePwdActivity.class);
                if (com.amgcyo.cuttadon.utils.otherutils.g.t(mkUserJ.getUser_id()) > 0) {
                    showMessage("成功退出账号，请重新登录");
                    r0.b(a());
                } else {
                    showMessage("账号退出异常，请重试！");
                }
            } else {
                showMessage("登录参数异常，请退出重新登录!");
            }
        }
        finish();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null) {
            showMessage("参数异常");
            finish();
            return;
        }
        this.ll_valicode.setVisibility(8);
        this.f2979s0 = com.amgcyo.cuttadon.utils.otherutils.g.u();
        this.etPhoneNum.requestFocus();
        this.f2974n0 = intent.getIntExtra("find_pwd", 2);
        this.f2976p0 = intent.getBooleanExtra("find_pwd_to_login", false);
        this.f2975o0 = intent.getIntExtra("fission_index_page", 0);
        if (2 == this.f2974n0) {
            this.cus_info.setText(String.format("欢迎注册使用%s", com.amgcyo.cuttadon.f.o.d(R.string.app_name)));
            this.tvReg.setText("立即注册");
            this.ll_tip.setVisibility(0);
            this.et_invitation_code.setVisibility(0);
            this.view_line_invli.setVisibility(0);
            this.checkbox_private.setChecked(false);
            if (com.amgcyo.cuttadon.utils.otherutils.h.I0() || com.amgcyo.cuttadon.utils.otherutils.h.J0()) {
                this.et_invitation_code.addTextChangedListener(this.f2977q0);
            }
        } else {
            this.cus_info.setText("找回后可不要再忘了哦~");
            this.tvReg.setText("找回密码");
            this.ll_tip.setVisibility(8);
            this.ll_valicode.setVisibility(8);
            this.et_invitation_code.setVisibility(8);
            this.view_line_invli.setVisibility(8);
        }
        this.tvGetCode.setEnabled(false);
        this.tvGetCode.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.dddddd));
        this.etPhoneNum.addTextChangedListener(this.f2978r0);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_reg;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        String strQ = q();
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        this.et_invitation_code.setText(strQ);
        showMessage("好友邀请码已自动设置！");
    }

    @OnClick({R.id.tv_countryCode, R.id.ll_tip, R.id.iv_exitreg, R.id.tv_reg, R.id.tv_useragree, R.id.tv_privacy, R.id.tv_getCode})
    public void onClick(View view) {
        String strA;
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.iv_exitreg /* 2131297171 */:
                finish();
                break;
            case R.id.ll_tip /* 2131297973 */:
                if (this.checkbox_private.isChecked()) {
                    this.checkbox_private.setChecked(false);
                } else {
                    this.checkbox_private.setChecked(true);
                }
                break;
            case R.id.tv_countryCode /* 2131298652 */:
                o();
                break;
            case R.id.tv_getCode /* 2131298715 */:
                String string = this.etPhoneNum.getText().toString();
                p();
                ((UserPresenter) this.f2276v).l(Message.a(this, new Object[]{string, Integer.valueOf(this.f2974n0), this.f2979s0.getTel()}));
                break;
            case R.id.tv_privacy /* 2131298778 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.C());
                zhugeIodEvent("[MY]隐私政策");
                break;
            case R.id.tv_reg /* 2131298787 */:
                int i2 = this.f2974n0;
                if (2 == i2) {
                    p();
                    if (r()) {
                        if (this.checkbox_private.isChecked()) {
                            HashMap map = new HashMap();
                            List<MkBook> listC = AppDatabase.i().a().c();
                            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listC)) {
                                for (MkBook mkBook : listC) {
                                    if (map.containsKey(Integer.valueOf(mkBook.getForm()))) {
                                        List list = (List) map.get(Integer.valueOf(mkBook.getForm()));
                                        if (list != null) {
                                            list.add(Integer.valueOf(mkBook.getBook_id()));
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(mkBook.getBook_id()));
                                        map.put(Integer.valueOf(mkBook.getForm()), arrayList);
                                    }
                                }
                            }
                            String str = "map的大小：" + map.size();
                            if (map.size() > 0) {
                                Set<Map.Entry> setEntrySet = map.entrySet();
                                ArrayList arrayList2 = new ArrayList();
                                for (Map.Entry entry : setEntrySet) {
                                    IdsBean idsBean = new IdsBean();
                                    idsBean.setForm(((Integer) entry.getKey()).intValue());
                                    idsBean.setBook_id((List) entry.getValue());
                                    arrayList2.add(idsBean);
                                }
                                String str2 = "idsBeans的大小：" + arrayList2.size();
                                strA = com.amgcyo.cuttadon.utils.otherutils.r.a(arrayList2);
                            } else {
                                strA = "";
                            }
                            this.tvReg.setEnabled(false);
                            AppDatabase.i().d().b();
                            ((UserPresenter) this.f2276v).I(Message.a(this, new Object[]{this.etPhoneNum.getText().toString().trim(), this.etPwd.getText().toString().trim(), this.etSmsCode.getText().toString().trim(), strA, this.et_invitation_code.getText().toString().trim(), this.f2979s0.getTel(), Integer.valueOf(this.f2975o0)}));
                        } else {
                            com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) this);
                            showMessage("请点击同意用户协议及隐私政策！");
                            com.amgcyo.cuttadon.utils.otherutils.g.a(this.ll_tip);
                        }
                        break;
                    }
                } else if (5 == i2 && r()) {
                    p();
                    ((UserPresenter) this.f2276v).c(Message.a(this, new Object[]{this.etPhoneNum.getText().toString().trim(), this.etSmsCode.getText().toString().trim(), this.etPwd.getText().toString().trim(), this.f2979s0.getTel()}));
                    break;
                }
                break;
            case R.id.tv_useragree /* 2131298875 */:
                r0.a(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.b0());
                zhugeIodEvent("[MY]用户协议");
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        TextWatcher textWatcher;
        super.onDestroy();
        EditText editText = this.etPhoneNum;
        if (editText == null || (textWatcher = this.f2978r0) == null) {
            return;
        }
        editText.removeTextChangedListener(textWatcher);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.ll_valicode != null) {
            if (com.amgcyo.cuttadon.utils.otherutils.h.I0() || com.amgcyo.cuttadon.utils.otherutils.h.J0()) {
                this.ll_valicode.setVisibility(0);
                this.ll_valicode.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.user.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3008s.n();
                    }
                }, 500L);
            }
        }
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        this.f2979s0 = (MkAreaCodeBean) intent.getSerializableExtra("MkAreaCodeBean");
        MkAreaCodeBean mkAreaCodeBean = this.f2979s0;
        if (mkAreaCodeBean == null) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.set_areacode_error));
            return;
        }
        this.tv_countryCode.setText(String.format("+%s", mkAreaCodeBean.getTel()));
        this.etPhoneNum.setText("");
        showMessage("已选择“" + this.f2979s0.getName() + "”");
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
