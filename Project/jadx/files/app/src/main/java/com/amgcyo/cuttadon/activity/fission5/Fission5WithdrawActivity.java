package com.amgcyo.cuttadon.activity.fission5;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.adapter.bookcity.MkPayDrawlIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MlPayTitleIVB;
import com.amgcyo.cuttadon.api.entity.fission5.ApBean;
import com.amgcyo.cuttadon.api.entity.fission5.BasePlay;
import com.amgcyo.cuttadon.api.entity.fission5.PlayTitleBean;
import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import com.amgcyo.cuttadon.api.entity.fission5.TxStepBean;
import com.amgcyo.cuttadon.api.entity.fission5.WithDrawBean;
import com.amgcyo.cuttadon.api.entity.fission5.WpBean;
import com.amgcyo.cuttadon.api.entity.other.FissionUser;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.popupview.ConfirmAccountPopupView;
import com.amgcyo.cuttadon.view.popupview.WebViewPopupView;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import java.util.List;
import me.drakeet.multitype.Items;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission5WithdrawActivity extends BaseTitleBarActivity<UserPresenter> implements MkPayDrawlIVB.a, ConfirmAccountPopupView.a {

    @BindView(R.id.ll_tips)
    LinearLayout ll_tips;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    me.drakeet.multitype.d f2531n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private Items f2532o0 = new Items();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    MkUser f2533p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private BasePlay f2534q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private Bundle f2535r0;

    @BindView(R.id.rv_daylist)
    RecyclerView rv_daylist;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    BasePopupView f2536s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private BasePopupView f2537t0;

    @BindView(R.id.tv_money)
    TextView tv_money;

    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return Fission5WithdrawActivity.this.f2532o0.get(i2) instanceof BasePlay ? 1 : 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        r0.startActivity(this.f2277w, Fission5InvaliUserActivity.class);
    }

    private void o() {
        Intent intent = new Intent(this.f2277w, (Class<?>) Fission5BankCountActivity.class);
        intent.putExtras(this.f2535r0);
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.fission5.e
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent2) {
                this.a.b(i2, intent2);
            }
        });
    }

    private void p() {
        this.f2533p0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.f2533p0 == null) {
            r0.a(this.f2277w, true);
            return;
        }
        BasePlay basePlay = this.f2534q0;
        if (basePlay == null) {
            return;
        }
        if (basePlay.getRead_time() <= 0 && this.f2535r0 != null) {
            o();
            return;
        }
        BasePopupView basePopupView = this.f2536s0;
        if (basePopupView != null) {
            basePopupView.u();
            return;
        }
        ConfirmAccountPopupView confirmAccountPopupView = new ConfirmAccountPopupView(this.f2277w, this.f2533p0.getPhone().replace("****", " **** "));
        confirmAccountPopupView.setListener(this);
        a.b bVar = new a.b(this.f2277w);
        bVar.b(true);
        bVar.d(false);
        bVar.e(true);
        bVar.a((BasePopupView) confirmAccountPopupView);
        this.f2536s0 = confirmAccountPopupView.u();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        FissionUser fissionUser;
        if (intent == null || (fissionUser = (FissionUser) intent.getSerializableExtra("FissionUser")) == null || this.f2534q0 == null) {
            return;
        }
        showLoading("正在申请提现中...");
        ((UserPresenter) this.f2276v).F(Message.a(this, new Object[]{Integer.valueOf(this.f2534q0.getAid()), Integer.valueOf(this.f2534q0.getAmount_type()), fissionUser.getFissionName(), fissionUser.getFissionZfb()}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "提现";
    }

    public /* synthetic */ void e(View view) {
        r0.startActivity(a(), Fission5TixianListActivity.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        TxStepBean txStepBean;
        super.handleMessage(message);
        hideLoading();
        int i2 = message.f21197s;
        if (i2 != 903) {
            if (i2 == 905 && (txStepBean = (TxStepBean) message.f21202x) != null) {
                String balance_money = txStepBean.getBalance_money();
                TextView textView = this.tv_money;
                if (textView != null) {
                    textView.setText(balance_money);
                }
                me.jessyan.art.d.f.a().a(new Task5ResultBean(txStepBean.getBalance_gold(), balance_money, txStepBean.getEarnings()), "refreshLoginStatus");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_tx", txStepBean);
                Intent intent = new Intent(this, (Class<?>) Fission5TixianActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                this.f2534q0 = null;
                return;
            }
            return;
        }
        WithDrawBean withDrawBean = (WithDrawBean) message.f21202x;
        if (withDrawBean == null) {
            showEmpty();
            return;
        }
        List<WpBean> wp = withDrawBean.getWp();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(wp)) {
            this.f2532o0.add(new PlayTitleBean(R.drawable.pay_wx, "微信提现"));
            this.f2532o0.addAll(wp);
        }
        List<ApBean> ap = withDrawBean.getAp();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(ap)) {
            this.f2532o0.add(new PlayTitleBean(R.drawable.pay_zfb, "支付宝提现"));
            this.f2532o0.addAll(ap);
        }
        me.drakeet.multitype.d dVar = this.f2531n0;
        if (dVar != null) {
            dVar.a(this.f2532o0);
            this.f2531n0.notifyDataSetChanged();
        }
        this.ll_tips.setVisibility(0);
        this.tv_money.setText(withDrawBean.getBalance_money());
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        if (getIntent().getExtras() == null) {
            return;
        }
        this.f2533p0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.f2533p0 == null) {
            r0.a(this.f2277w, true);
            return;
        }
        this.D.setText(o.d(R.string.txjl));
        this.D.setTextColor(o.b(R.color.color_ff403a));
        this.D.setVisibility(0);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2547s.e(view);
            }
        });
        this.f2531n0 = new me.drakeet.multitype.d();
        this.f2531n0.a(PlayTitleBean.class, new MlPayTitleIVB());
        MkPayDrawlIVB mkPayDrawlIVB = new MkPayDrawlIVB();
        mkPayDrawlIVB.a((MkPayDrawlIVB.a) this);
        this.f2531n0.a(BasePlay.class, mkPayDrawlIVB);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f2277w, 3);
        gridLayoutManager.setSpanSizeLookup(new a());
        this.rv_daylist.setLayoutManager(gridLayoutManager);
        this.f2531n0.a(this.f2532o0);
        this.rv_daylist.setAdapter(this.f2531n0);
        ((UserPresenter) this.f2276v).G(Message.a(this, new Object[0]));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission5_withdraw;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.tv_yq, R.id.iv_help})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.tv_yq) {
            n();
            return;
        }
        if (view.getId() == R.id.iv_help) {
            String strE = com.amgcyo.cuttadon.utils.otherutils.g.e("withdrawal");
            String str = "withdrawal: " + strE;
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            WebViewPopupView webViewPopupView = new WebViewPopupView(this.f2277w, strE, o.d(R.string.txsm));
            a.b bVar = new a.b(this.f2277w);
            bVar.b(true);
            bVar.d(false);
            bVar.e(true);
            bVar.a((BasePopupView) webViewPopupView);
            webViewPopupView.u();
        }
    }

    @Override // com.amgcyo.cuttadon.adapter.bookcity.MkPayDrawlIVB.a
    public void onclickListener(BasePlay basePlay) {
        if (basePlay == null) {
            return;
        }
        try {
            this.f2534q0 = basePlay;
            String amount = basePlay.getAmount();
            this.f2535r0 = new Bundle();
            this.f2535r0.putString("key_txmoney", amount);
            Float fValueOf = Float.valueOf(this.tv_money.getText().toString());
            Float fValueOf2 = Float.valueOf(amount);
            if (fValueOf.floatValue() > 0.0f && fValueOf.floatValue() >= fValueOf2.floatValue()) {
                p();
            } else if (this.f2537t0 == null) {
                com.lxj.xpopup.a.a(o.b(R.color.color_ff403a));
                a.b bVar = new a.b(a());
                bVar.d(false);
                this.f2537t0 = bVar.a((CharSequence) "温馨提示", (CharSequence) "余额不足，快去邀请好友赚钱吧~", (CharSequence) "取消", (CharSequence) "去邀请", new com.lxj.xpopup.c.c() { // from class: com.amgcyo.cuttadon.activity.fission5.g
                    @Override // com.lxj.xpopup.c.c
                    public final void onConfirm() {
                        this.a.n();
                    }
                }, (com.lxj.xpopup.c.a) null, false).u();
            } else {
                this.f2537t0.u();
            }
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.view.popupview.ConfirmAccountPopupView.a
    public void onstartTx() {
        if (this.f2534q0 == null) {
            return;
        }
        showLoading("正在申请提现中...");
        ((UserPresenter) this.f2276v).F(Message.a(this, new Object[]{Integer.valueOf(this.f2534q0.getAid()), Integer.valueOf(this.f2534q0.getAmount_type()), "", ""}));
    }

    @Override // com.amgcyo.cuttadon.view.popupview.ConfirmAccountPopupView.a
    public void onstartTxOtherAccount() {
        if (this.f2534q0 == null || this.f2535r0 == null) {
            return;
        }
        o();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
