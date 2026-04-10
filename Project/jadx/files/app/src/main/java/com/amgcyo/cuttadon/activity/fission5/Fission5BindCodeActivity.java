package com.amgcyo.cuttadon.activity.fission5;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.popupview.BindMasterCodeResultPopup;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission5BindCodeActivity extends BaseTitleBarActivity<UserPresenter> implements BindMasterCodeResultPopup.a {

    @BindView(R.id.et_code)
    EditText etCode;

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity<UserPresenter> a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return o.d(R.string.exchange_code);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, com.amgcyo.cuttadon.view.popupview.BindMasterCodeResultPopup.a
    public void finishActivity() {
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        Task5ResultBean task5ResultBean;
        super.handleMessage(message);
        if (message.f21197s != 901 || (task5ResultBean = (Task5ResultBean) message.f21202x) == null) {
            return;
        }
        String str = 1 == task5ResultBean.getAmount_type() ? "金币" : "元";
        BindMasterCodeResultPopup bindMasterCodeResultPopup = new BindMasterCodeResultPopup(this.f2277w, task5ResultBean.getAmount() + str);
        bindMasterCodeResultPopup.setListener(this);
        a.b bVar = new a.b(this.f2277w);
        bVar.b(true);
        bVar.d(false);
        bVar.e(true);
        bVar.a((BasePopupView) bindMasterCodeResultPopup);
        bindMasterCodeResultPopup.u();
        me.jessyan.art.d.f.a().a(task5ResultBean, "refreshLoginStatus");
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.tv_desc.setText("温馨提示\n1.  安装打开阅读器后的 10 天内可以输入邀请码，超过时间不能输入。 \n2.  一个手机只能输入一次邀请码。已输入过邀请码的手机，切换账号也无法输入其他邀请码。 \n3.  使用 App 分身软件、高危手机号等非正常用户不能输入邀请码，且会被系统记录。\n4.  " + o.d(R.string.app_name) + "享有最终解释权！");
        this.etCode.setTransformationMethod(new com.amgcyo.cuttadon.utils.otherutils.e(true));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission5_bind_code;
    }

    @Override // com.amgcyo.cuttadon.view.popupview.BindMasterCodeResultPopup.a
    public void invaliUser() {
        r0.startActivity(this.f2277w, Fission5InvaliUserActivity.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.tv_exchange})
    public void onClick() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        String string = this.etCode.getText().toString();
        if (TextUtils.isEmpty(string)) {
            showMessage("请输入邀请码");
        } else if (!com.amgcyo.cuttadon.utils.otherutils.g.n(string)) {
            showMessage("邀请码格式不正确");
        } else {
            obtainPresenter().A(Message.a(a(), new Object[]{com.amgcyo.cuttadon.utils.otherutils.g.v(string), com.amgcyo.cuttadon.utils.otherutils.g.f(a())}));
        }
    }

    @OnClick({R.id.tv_exchange})
    public void onViewClicked() {
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public UserPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new UserPresenter(me.jessyan.art.f.e.a(this));
        }
        return (UserPresenter) this.f2276v;
    }
}
