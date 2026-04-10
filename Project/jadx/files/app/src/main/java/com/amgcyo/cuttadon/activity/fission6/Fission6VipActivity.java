package com.amgcyo.cuttadon.activity.fission6;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.cz.CzChannelBean;
import com.amgcyo.cuttadon.api.entity.cz.CzIndexBean;
import com.amgcyo.cuttadon.api.entity.cz.CzOrderBean;
import com.amgcyo.cuttadon.api.entity.cz.CzPayDataBean;
import com.amgcyo.cuttadon.api.entity.cz.SubmitOrderBean;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.u;
import com.amgcyo.cuttadon.utils.otherutils.y;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.dialog.k1;
import com.amgcyo.cuttadon.view.otherview.CenterLinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class Fission6VipActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.btn_submit)
    Button btn_submit;

    @BindView(R.id.cz_recyclerview)
    RecyclerView cz_recyclerview;

    @BindView(R.id.ll_free_time)
    LinearLayout ll_free_time;

    @BindView(R.id.ll_package)
    LinearLayout ll_package;

    @BindView(R.id.ll_pay)
    LinearLayout ll_pay;

    @BindView(R.id.ll_submit)
    LinearLayout ll_submit;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private com.amgcyo.cuttadon.b.a.b f2552n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private com.amgcyo.cuttadon.b.a.a f2553o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private MkUser f2554p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private k1 f2555q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f2556r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private String f2557s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private SubmitOrderBean f2558t0;

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @BindView(R.id.tv_money)
    TextView tv_money;

    @BindView(R.id.tv_pack)
    TextView tv_pack;

    @BindView(R.id.tv_time)
    TextView tv_time;

    @BindView(R.id.tv_vip_title)
    TextView tv_vip_title;

    @BindView(R.id.zffs_recyclerview)
    RecyclerView zffs_recyclerview;

    private void n() {
        k1 k1Var;
        if (this.f2556r0 && (k1Var = this.f2555q0) != null && k1Var.isShowing()) {
            this.f2555q0.dismiss();
        }
    }

    private void o() {
        ((UserPresenter) this.f2276v).g(Message.a(this, new Object[0]));
    }

    private void p() {
        if (this.f2554p0 == null) {
            r0.a(this.f2277w, true);
            return;
        }
        if (this.f2558t0 == null) {
            c("提交失败，请关闭重试！");
            return;
        }
        String str = "订单信息：" + this.f2558t0.toString();
        ((UserPresenter) this.f2276v).t(Message.a(this, new Object[]{this.f2558t0}));
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "mkadbean")
    private void subscriberAd(MkAdBean mkAdBean) {
        this.f2554p0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkAdBean != null) {
            String str = "indexAd:" + mkAdBean.toString();
        }
        a(mkAdBean, this.f2554p0);
    }

    @Subscriber(mode = ThreadMode.POST, tag = "finish_activity")
    private void subscriberLoginOrRegUser(MkUser mkUser) {
        this.f2554p0 = mkUser;
        a((MkAdBean) null, this.f2554p0);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(List list, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        CzPayDataBean czPayDataBean = (CzPayDataBean) list.get(i2);
        if (czPayDataBean != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CzPayDataBean czPayDataBean2 = (CzPayDataBean) it.next();
                if (czPayDataBean.getId() == czPayDataBean2.getId()) {
                    czPayDataBean.setSelected(true);
                    this.f2558t0.setProduct(czPayDataBean.getId());
                } else {
                    czPayDataBean2.setSelected(false);
                }
            }
            this.cz_recyclerview.smoothScrollToPosition(i2);
            a(czPayDataBean);
            this.f2552n0.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void b(List list, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        CzChannelBean czChannelBean = (CzChannelBean) list.get(i2);
        if (czChannelBean != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CzChannelBean czChannelBean2 = (CzChannelBean) it.next();
                if (czChannelBean.getPos() == czChannelBean2.getPos()) {
                    czChannelBean.setSelected(true);
                    this.f2558t0.setChannel(czChannelBean.getChannel_id());
                    this.f2558t0.setType(czChannelBean.getPay_id());
                } else {
                    czChannelBean2.setSelected(false);
                }
            }
            this.f2553o0.notifyDataSetChanged();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return o.c(R.string.vip_submit_str);
    }

    public /* synthetic */ void e(View view) {
        if (this.f2554p0 == null) {
            r0.a(this.f2277w, true);
        } else {
            r0.startActivity(this.f2277w, Fission6CzRecoredListActivity.class);
        }
    }

    public /* synthetic */ void f(View view) {
        r0.b(this.f2277w);
    }

    public /* synthetic */ void g(View view) {
        r0.startActivity(this.f2277w, Fission6CzHelperListActivity.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 189) {
            a((CzOrderBean) message.f21202x);
            return;
        }
        if (i2 == 191) {
            MkAdBean mkAdBean = (MkAdBean) message.f21202x;
            int status = mkAdBean.getStatus();
            if (1 == status) {
                mkAdBean.setAd_state(status);
                com.amgcyo.cuttadon.utils.otherutils.h.k(r.a(mkAdBean));
                me.jessyan.art.d.f.a().a(mkAdBean, "mkadbean");
                d("支付完成！");
                com.amgcyo.cuttadon.utils.otherutils.g.w(mkAdBean.getAd_end_datetime());
                b1 b1Var = new b1(this);
                b1Var.show();
                b1Var.a("恭喜你，成功获取免广告特权！\n特权到期时间为：\n" + mkAdBean.getAd_end_datetime() + "\n" + o.d(R.string.cz_help_tips), "", new String[0]);
                k1 k1Var = this.f2555q0;
                if (k1Var != null && k1Var.isShowing()) {
                    this.f2555q0.dismiss();
                }
                if (this.tv_time != null) {
                    this.tv_time.startAnimation(u.a(5));
                }
            } else {
                showToasyErrorMessage("本次充值还未成功，请确认是否完成支付！");
            }
            n();
            return;
        }
        if (i2 == 826) {
            n();
            return;
        }
        if (i2 != 920) {
            if (i2 != 921) {
                return;
            }
            showLoadFailed();
            return;
        }
        CzIndexBean czIndexBean = (CzIndexBean) message.f21202x;
        final List<CzPayDataBean> pay_data = czIndexBean.getPay_data();
        this.f2558t0 = new SubmitOrderBean();
        CzPayDataBean czPayDataBean = pay_data.get(0);
        czPayDataBean.setRecommend(1);
        czPayDataBean.setSelected(true);
        this.f2558t0.setProduct(czPayDataBean.getId());
        a(czPayDataBean);
        a(com.amgcyo.cuttadon.utils.otherutils.h.l0(), this.f2554p0);
        this.f2552n0 = new com.amgcyo.cuttadon.b.a.b(pay_data);
        this.cz_recyclerview.setLayoutManager(new CenterLinearLayoutManager(this.f2277w, 0, false));
        this.f2552n0.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.activity.fission6.c
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.f2562s.a(pay_data, baseQuickAdapter, view, i3);
            }
        });
        this.cz_recyclerview.setAdapter(this.f2552n0);
        final List<CzChannelBean> channel = czIndexBean.getChannel();
        for (int i3 = 0; i3 < channel.size(); i3++) {
            CzChannelBean czChannelBean = channel.get(i3);
            if (i3 == 0) {
                czChannelBean.setSelected(true);
                this.f2558t0.setChannel(czChannelBean.getChannel_id());
                this.f2558t0.setType(czChannelBean.getPay_id());
            }
            czChannelBean.setPos(i3);
        }
        this.f2553o0 = new com.amgcyo.cuttadon.b.a.a(channel);
        this.zffs_recyclerview.setLayoutManager(new LinearLayoutManager(this.f2277w));
        this.f2553o0.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.activity.fission6.e
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i4) {
                this.f2565s.b(channel, baseQuickAdapter, view, i4);
            }
        });
        this.zffs_recyclerview.setAdapter(this.f2553o0);
        b(this.ll_submit, this.ll_free_time, this.ll_package, this.ll_pay);
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.isNeedNightModel = false;
        int iB = o.b(R.color.color_titlebar);
        me.jessyan.art.f.h.c(this, iB);
        me.jessyan.art.f.h.d(this, iB);
        this.f2279y.setBackgroundColor(iB);
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.white);
        if (colorStateList != null) {
            this.C.setColorFilter(colorStateList);
        } else {
            this.C.setImageResource(R.drawable.fission5_back);
        }
        this.B.setTextColor(o.b(R.color.white));
        this.D.setVisibility(0);
        this.D.setText(o.d(R.string.cz_recored));
        this.f2554p0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2567s.e(view);
            }
        });
        this.D.setTextColor(o.b(R.color.color_9E9FA3));
        this.tv_vip_title.setText(o.c(R.string.vip_title));
        this.tv_pack.setText(o.c(R.string.vip_package));
        this.btn_submit.setText(o.c(R.string.vip_submit_str));
        o();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fission6vip_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    public void j() {
        super.j();
        o();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.btn_submit, R.id.tv_cz_help})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_submit) {
            p();
        } else {
            if (id != R.id.tv_cz_help) {
                return;
            }
            r0.startActivity(this.f2277w, Fission6CzHelperListActivity.class);
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }

    private void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((UserPresenter) this.f2276v).u(Message.a(this, new Object[]{str}));
            return;
        }
        c("订单信息异常！");
        k1 k1Var = this.f2555q0;
        if (k1Var == null || !k1Var.isShowing()) {
            return;
        }
        this.f2555q0.dismiss();
    }

    private void a(final CzOrderBean czOrderBean) {
        this.f2555q0 = new k1(this.f2277w);
        this.f2555q0.show();
        this.f2555q0.setCancelable(false);
        this.f2555q0.setCanceledOnTouchOutside(false);
        this.f2555q0.a(czOrderBean, this.f2557s0, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2568s.a(czOrderBean, view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2570s.g(view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(com.amgcyo.cuttadon.api.entity.cz.CzOrderBean r5, android.view.View r6) {
        /*
            r4 = this;
            int r0 = r6.getId()
            r1 = 1
            r2 = 0
            r3 = 2131298699(0x7f09098b, float:1.8215379E38)
            if (r0 != r3) goto L25
            boolean r0 = r6 instanceof android.widget.TextView
            if (r0 == 0) goto L25
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            r3 = 2131755479(0x7f1001d7, float:1.9141838E38)
            java.lang.String r3 = com.amgcyo.cuttadon.f.o.d(r3)
            boolean r0 = r3.contentEquals(r0)
            if (r0 == 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            int r6 = r6.getId()
            r3 = 2131297162(0x7f09038a, float:1.8212261E38)
            if (r6 == r3) goto L33
            if (r0 == 0) goto L32
            goto L33
        L32:
            r1 = 0
        L33:
            r4.f2556r0 = r1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "isCloseOrderDialog："
            r6.append(r1)
            boolean r1 = r4.f2556r0
            r6.append(r1)
            java.lang.String r1 = " btnColseDialog: "
            r6.append(r1)
            r6.append(r0)
            r6.toString()
            java.lang.String r5 = r5.getPay_order_id()
            r4.e(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.fission6.Fission6VipActivity.a(com.amgcyo.cuttadon.api.entity.cz.CzOrderBean, android.view.View):void");
    }

    private void a(CzPayDataBean czPayDataBean) {
        if (czPayDataBean != null) {
            this.f2557s0 = czPayDataBean.getName();
            this.tv_desc.setText(String.format("已选择%s会员套餐", this.f2557s0));
            this.tv_money.setText(String.format("￥%s", czPayDataBean.getMoney()));
        }
    }

    private void a(MkAdBean mkAdBean, MkUser mkUser) {
        StringBuilder sb = new StringBuilder();
        sb.append("indexAd:");
        sb.append(mkAdBean != null);
        sb.toString();
        TextView textView = this.tv_time;
        if (textView != null) {
            if (mkUser == null) {
                textView.setText("请先登录");
                this.tv_time.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission6.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2564s.f(view);
                    }
                });
            } else {
                if (mkAdBean != null) {
                    int ad_state = mkAdBean.getAd_state();
                    if (ad_state == 1) {
                        this.tv_time.setText(t0.d(y.f(mkAdBean.getAd_end_datetime())));
                        return;
                    } else {
                        this.tv_time.setText(o.e(ad_state));
                        return;
                    }
                }
                textView.setText(o.d(R.string.fission6_not_free));
            }
        }
    }
}
