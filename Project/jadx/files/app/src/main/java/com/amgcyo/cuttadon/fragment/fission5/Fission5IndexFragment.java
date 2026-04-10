package com.amgcyo.cuttadon.fragment.fission5;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.fission5.Fission5BindCodeActivity;
import com.amgcyo.cuttadon.activity.fission5.Fission5InvaliUserActivity;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.BannerBean;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5Index;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5SignIndex;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5TaskBean;
import com.amgcyo.cuttadon.api.entity.fission5.IncomeBean5;
import com.amgcyo.cuttadon.api.entity.fission5.OpenBoxBean;
import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.h.g.i;
import com.amgcyo.cuttadon.j.itemdecoration.a;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.view.otherview.ImageCycleView;
import com.amgcyo.cuttadon.view.popupview.BindMasterCodeOverResultPopup;
import com.amgcyo.cuttadon.view.popupview.OpenBoxResultPopup;
import com.amgcyo.cuttadon.view.popupview.QQMsgPopup;
import com.amgcyo.cuttadon.view.popupview.Sign5PopupView;
import com.amgcyo.cuttadon.view.popupview.VideoTipsPopup;
import com.amgcyo.cuttadon.view.smilerefresh.MkPullToRefresh;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.widget.ui.ObservableScrollView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.d.f;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class Fission5IndexFragment extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> implements PullToRefreshView.j, OpenBoxResultPopup.a, com.amgcyo.cuttadon.h.f.c, BaseQuickAdapter.f, ObservableScrollView.a {
    private AnimationDrawable G;
    private MkUser H;
    private int I;
    private com.amgcyo.cuttadon.b.b.a J;
    private Fuli5SignIndex K;
    private CountDownTimer L;
    private IncomeBean5 M;
    private String R;
    private Fuli5TaskBean S;
    private BasePopupView T;

    @BindView(R.id.card_view_banner)
    CardView card_view_banner;

    @BindView(R.id.cd_notice)
    CardView cd_notice;

    @BindView(R.id.icv_topView)
    ImageCycleView icvTopView;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.img_box)
    ImageView img_box;

    @BindView(R.id.iv)
    ImageView iv;

    @BindView(R.id.laba)
    ImageView laba;

    @BindView(R.id.ll_bar)
    LinearLayout llBar;

    @BindView(R.id.ll_login)
    LinearLayout llLogin;

    @BindView(R.id.ll_nologin)
    LinearLayout llNologin;

    @BindView(R.id.ll_bottom_tips)
    LinearLayout ll_bottom_tips;

    @BindView(R.id.ll_notice)
    LinearLayout ll_notice;

    @BindView(R.id.swipe_refresh_layout)
    MkPullToRefresh mRefreshView;

    @BindView(R.id.marqueerewardview)
    SimpleMarqueeView marqueerewardview;

    @BindView(R.id.observablescrollview)
    ObservableScrollView observableScrollView;

    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;

    @BindView(R.id.rv_daylist)
    RecyclerView rvDaylist;

    @BindView(R.id.text)
    TextView text;

    @BindView(R.id.tv_bx)
    TextView tvBx;

    @BindView(R.id.tv_coin)
    TextView tvCoin;

    @BindView(R.id.tv_login)
    TextView tvLogin;

    @BindView(R.id.tv_login_dh)
    TextView tvLoginDh;

    @BindView(R.id.tv_money)
    TextView tvMoney;

    @BindView(R.id.tv_rule_text)
    TextView tvRuleText;

    @BindView(R.id.tv_tipsmoney)
    TextView tv_tipsmoney;

    @BindView(R.id.tv_yuan)
    TextView tv_yuan;

    @BindView(R.id.view_line)
    View view_line;
    private int N = 0;
    private boolean O = false;
    private boolean P = false;
    private int Q = -1;
    private int U = n.a(300.0f);

    class a extends LinearLayoutManager {
        a(Fission5IndexFragment fission5IndexFragment, Context context, int i2, boolean z2) {
            super(context, i2, z2);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    class b extends CountDownTimer {
        b(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            TextView textView = Fission5IndexFragment.this.tvBx;
            if (textView != null) {
                textView.setText(o.d(R.string.kbx));
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            TextView textView = Fission5IndexFragment.this.tvBx;
            if (textView != null) {
                long j3 = j2 - ((j2 / 86400000) * 86400000);
                long j4 = j3 / 3600000;
                long j5 = j3 - (3600000 * j4);
                long j6 = j5 / 60000;
                textView.setText(String.format(Locale.getDefault(), "%d时%d分%d秒", Long.valueOf(j4), Long.valueOf(j6), Long.valueOf((j5 - (60000 * j6)) / 1000)));
            }
        }
    }

    class c implements ImageCycleView.h {
        c() {
        }

        @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.h
        public void a(int i2) {
        }

        @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.h
        public void a(View view, ImageCycleView.f fVar) {
            Fission5IndexFragment.this.a(fVar.f4993c, -1);
        }
    }

    private void b(List<Fuli5TaskBean> list) {
        Collections.sort(list, new Comparator() { // from class: com.amgcyo.cuttadon.fragment.fission5.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Fission5IndexFragment.a((Fuli5TaskBean) obj, (Fuli5TaskBean) obj2);
            }
        });
        Collections.sort(list, new Comparator() { // from class: com.amgcyo.cuttadon.fragment.fission5.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Fission5IndexFragment.b((Fuli5TaskBean) obj, (Fuli5TaskBean) obj2);
            }
        });
        this.J.b((Collection) list);
        this.rvDaylist.setAdapter(this.J);
        this.J.a((BaseQuickAdapter.f) this);
    }

    private void c(List<BannerBean> list) {
        if (g.a(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BannerBean bannerBean : list) {
            arrayList.add(new ImageCycleView.f(g.E() + bannerBean.getImg(), bannerBean.getTitle(), bannerBean.getButton(), bannerBean.getData()));
        }
        this.icvTopView.a(arrayList, new ImageCycleView.g() { // from class: com.amgcyo.cuttadon.fragment.fission5.a
            @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.g
            public final ImageView a(ImageCycleView.f fVar) {
                return this.a.a(fVar);
            }
        });
        this.icvTopView.setOnPageClickListener(new c());
        this.card_view_banner.setVisibility(0);
    }

    private void d(String str) {
        a.b bVar = new a.b(getContext());
        bVar.c(true);
        bVar.b(true);
        bVar.a((Boolean) true);
        bVar.a(PopupAnimation.NoAnimation);
        VideoTipsPopup videoTipsPopup = new VideoTipsPopup(this.f3725t, str);
        bVar.a((BasePopupView) videoTipsPopup);
        videoTipsPopup.u().a(2500L);
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jA = t0.a(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jA < jCurrentTimeMillis) {
            this.tvBx.setText(o.d(R.string.kbx));
            return;
        }
        long j2 = jA - jCurrentTimeMillis;
        CountDownTimer countDownTimer = this.L;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.L = null;
        }
        this.L = new b(j2, 1000L);
        this.L.start();
    }

    private MkMainActivity l() {
        Context context = this.f3725t;
        if (context != null && (context instanceof MkMainActivity)) {
            return (MkMainActivity) context;
        }
        return null;
    }

    private void m() {
        r0.a(this.f3725t, true, -100);
    }

    private void o() {
        P p2 = this.f3726u;
        if (p2 != 0) {
            int i2 = this.N;
            if (i2 != 0) {
                ((UserPresenter) p2).E(Message.a(this, new Object[]{Integer.valueOf(i2)}));
            } else {
                ((UserPresenter) p2).D(Message.a(this, new Object[0]));
            }
        }
    }

    private void p() {
        MkPullToRefresh mkPullToRefresh = this.mRefreshView;
        if (mkPullToRefresh != null) {
            mkPullToRefresh.setRefreshing(true);
        }
        this.H = g.j();
        ((UserPresenter) this.f3726u).w(Message.a(this, new Object[]{this.H != null ? "/v3/gold/index_login.api" : "/v3/gold/index.api"}));
    }

    private void q() {
        if (this.f3725t == null) {
            return;
        }
        BaseAd baseAdB = com.amgcyo.cuttadon.sdk.utils.e.b("position_fission5_reward_ad_video", "welfare_center");
        if (baseAdB == null) {
            showMessage("错误码：c1227");
            return;
        }
        String platform = baseAdB.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            showMessage("错误码：c1228");
            return;
        }
        i.a().a(this.f3725t, new RewardAdParam(platform, this.R, h.a(platform, "g"), baseAdB.getStyle(), baseAdB.isNoExempt()), this);
    }

    private void r() {
        if (this.H != null) {
            this.llNologin.setVisibility(8);
            this.llLogin.setVisibility(0);
        } else {
            this.tvBx.setText(o.d(R.string.kbx));
            this.llNologin.setVisibility(0);
            this.llLogin.setVisibility(8);
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "refreshLoginStatus")
    private void refreshLoginStatus(Task5ResultBean task5ResultBean) {
        if (task5ResultBean == null) {
            return;
        }
        onRefresh();
        a(task5ResultBean.getBalance_money(), task5ResultBean.getBalance_gold());
        IncomeBean5 incomeBean5 = this.M;
        if (incomeBean5 != null) {
            incomeBean5.setEarnings(task5ResultBean.getEarnings());
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_fuli55;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        h.u(0);
        this.H = g.j();
        r();
        p();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        hideLoading();
        MkPullToRefresh mkPullToRefresh = this.mRefreshView;
        if (mkPullToRefresh != null) {
            mkPullToRefresh.setRefreshing(false);
        }
        switch (message.f21197s) {
            case 899:
                Fuli5Index fuli5Index = (Fuli5Index) message.f21202x;
                if (fuli5Index == null) {
                    this.rlEmpty.setVisibility(0);
                    a(this.mRefreshView, this.img_box, this.tvBx, this.tvLoginDh, this.tv_yuan, this.tv_tipsmoney);
                    break;
                } else {
                    this.rlEmpty.setVisibility(8);
                    me.jessyan.art.f.h.c((Activity) this.f3725t);
                    b(this.mRefreshView, this.img_box, this.tvBx, this.tvLoginDh, this.tv_yuan, this.tv_tipsmoney, this.view_line);
                    this.I = fuli5Index.getBind_code_state();
                    MkApplication.getAppContext().setFissionUrl(fuli5Index.getRules_url());
                    c(fuli5Index.getBanner());
                    if (this.M == null) {
                        this.M = new IncomeBean5();
                    }
                    this.M.setEarnings(fuli5Index.getEarnings());
                    a(fuli5Index.getBalance_money(), fuli5Index.getBalance_gold());
                    List<String> notice = fuli5Index.getNotice();
                    if (g.a(notice)) {
                        a(this.ll_notice, this.cd_notice);
                    } else {
                        a(notice);
                        b(this.ll_notice, this.cd_notice);
                        this.laba.setImageResource(R.drawable.laba_animl);
                        this.G = (AnimationDrawable) this.laba.getDrawable();
                        this.G.start();
                    }
                    e(fuli5Index.getTreasure_chest_datetime());
                    List<Fuli5TaskBean> task = fuli5Index.getTask();
                    List<Fuli5TaskBean> read_task = fuli5Index.getRead_task();
                    if (!g.a(task) && !g.a(read_task)) {
                        List<Fuli5TaskBean> arrayList = new ArrayList<>();
                        arrayList.addAll(task);
                        arrayList.addAll(read_task);
                        b(arrayList);
                        this.ll_bottom_tips.setVisibility(0);
                    }
                    if (fuli5Index.getSign_in_state() != 1 && this.H != null) {
                        showLoading("正在签到中...");
                        ((UserPresenter) this.f3726u).x(Message.a(this, new Object[0]));
                        break;
                    }
                }
                break;
            case 900:
                OpenBoxBean openBoxBean = (OpenBoxBean) message.f21202x;
                if (openBoxBean != null) {
                    e(openBoxBean.getTreasure_chest_datetime());
                    OpenBoxResultPopup openBoxResultPopup = new OpenBoxResultPopup(this.f3725t, openBoxBean);
                    openBoxResultPopup.setListener(this);
                    a.b bVar = new a.b(this.f3725t);
                    bVar.d(false);
                    bVar.a((BasePopupView) openBoxResultPopup);
                    openBoxResultPopup.u();
                    a(openBoxBean.getBalance_money(), openBoxBean.getBalance_gold());
                }
                hideLoading();
                break;
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                Task5ResultBean task5ResultBean = (Task5ResultBean) message.f21202x;
                if (task5ResultBean != null) {
                    int balance_gold = task5ResultBean.getBalance_gold();
                    d("获取" + task5ResultBean.getAmount() + "金币");
                    this.N = 0;
                    this.O = false;
                    a(task5ResultBean.getBalance_money(), balance_gold);
                    if (this.Q != -1 && this.J != null && this.S != null) {
                        String task_desc = task5ResultBean.getTask_desc();
                        if (!TextUtils.isEmpty(task_desc)) {
                            this.S.setDesc(task_desc);
                        }
                        int task_state = task5ResultBean.getTask_state();
                        this.S.setState(task_state);
                        if (task_state == 1) {
                            this.S.setButton("已完成");
                        }
                        this.J.notifyItemChanged(this.Q);
                        this.Q = -1;
                        this.S = null;
                        break;
                    }
                }
                break;
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT /* 902 */:
                Task5ResultBean task5ResultBean2 = (Task5ResultBean) message.f21202x;
                if (task5ResultBean2 != null) {
                    String str = 1 != task5ResultBean2.getAmount_type() ? "元" : "金币";
                    BindMasterCodeOverResultPopup bindMasterCodeOverResultPopup = new BindMasterCodeOverResultPopup(this.f3725t, task5ResultBean2.getAmount() + str, g.e("invitation"));
                    a.b bVar2 = new a.b(this.f3725t);
                    bVar2.b(true);
                    bVar2.d(false);
                    bVar2.e(true);
                    bVar2.a((BasePopupView) bindMasterCodeOverResultPopup);
                    bindMasterCodeOverResultPopup.u();
                    a(task5ResultBean2.getBalance_money(), task5ResultBean2.getBalance_gold());
                    onRefresh();
                }
                break;
            case com.anythink.expressad.video.dynview.a.a.f11586s /* 904 */:
                this.K = (Fuli5SignIndex) message.f21202x;
                Fuli5SignIndex fuli5SignIndex = this.K;
                if (fuli5SignIndex != null) {
                    if (fuli5SignIndex.getSignin_state() == 0) {
                        a(this.K.getBalance_money(), this.K.getBalance_gold());
                    }
                    a(this.K);
                    break;
                }
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void i() {
        super.i();
        p();
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.icvTopView.a(ImageCycleView.IndicationStyle.COLOR, Color.parseColor("#e8e8e8"), Color.parseColor("#fe0b3a"), 0.5f);
        this.mRefreshView.setColorSchemeColors(g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.setOnRefreshListener(this);
        this.J = new com.amgcyo.cuttadon.b.b.a();
        this.rvDaylist.setLayoutManager(new a(this, this.f3725t, 1, false));
        this.rvDaylist.setHasFixedSize(true);
        this.rvDaylist.setNestedScrollingEnabled(false);
        a.b bVar = new a.b(this.f3725t);
        bVar.c(R.dimen.dimen0_5dp);
        bVar.e(R.dimen.dimen0_5dp);
        bVar.b(R.color.dddddd);
        bVar.d(R.dimen.dimen15dp);
        bVar.f(R.dimen.dimen15dp);
        this.rvDaylist.addItemDecoration(bVar.a());
        this.observableScrollView.setScrollViewListener(this);
        this.R = "position_fission5_reward_ad_video";
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.llBar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.L;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        com.amgcyo.cuttadon.b.b.a aVar;
        if (view.getId() != R.id.tv_task_action || (aVar = this.J) == null) {
            return;
        }
        this.S = null;
        this.S = aVar.getItem(i2);
        Fuli5TaskBean fuli5TaskBean = this.S;
        if (fuli5TaskBean == null) {
            return;
        }
        this.N = 0;
        if (fuli5TaskBean.getButton_type() == 8 || 1 != this.S.getState()) {
            a(this.S.getButton_type(), i2);
        } else {
            c(o.d(R.string.today_task_is_finish));
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.stopFlipping();
        }
        AnimationDrawable animationDrawable = this.G;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        CountDownTimer countDownTimer = this.L;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        p();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.H = g.j();
        if (this.P) {
            int iU = h.U();
            String str = "onResume: " + iU;
            if (iU == -100 && this.H != null) {
                p();
                r();
            }
        }
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.startFlipping();
        }
        AnimationDrawable animationDrawable = this.G;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdClose(String str) {
        if (this.O) {
            showLoading("正在获取奖励...");
            o();
        } else {
            showMessage("获取数据失败，请稍后重试！错误码：c1120");
        }
        this.O = false;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdFail(int i2, String str, String str2, String str3) {
        showMessage("获取数据失败，错误码：" + i2);
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
        this.O = hVar != null;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdVideoCached(Object obj) {
    }

    @Override // com.amgcyo.cuttadon.widget.ui.ObservableScrollView.a
    public void onScrollChanged(ObservableScrollView observableScrollView, int i2, int i3, int i4, int i5) {
        if (i3 <= 0) {
            me.jessyan.art.f.h.b((Activity) this.f3725t);
        } else if (i3 >= this.U) {
            me.jessyan.art.f.h.a((Activity) this.f3725t);
        }
    }

    @OnClick({R.id.tv_login, R.id.tv_login_dh, R.id.ll_bottom_tips, R.id.tv_rule_text, R.id.tv_bx, R.id.img_box, R.id.tv_coin, R.id.rl_money})
    public void onViewClicked(View view) {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
        }
        switch (view.getId()) {
            case R.id.img_box /* 2131297099 */:
            case R.id.tv_bx /* 2131298619 */:
                if (this.H != null) {
                    if (!o.d(R.string.kbx).equals(this.tvBx.getText().toString())) {
                        c(o.d(R.string.bx_tips));
                    } else {
                        showLoading("");
                        ((UserPresenter) this.f3726u).B(Message.a(this, new Object[0]));
                    }
                } else {
                    m();
                }
                break;
            case R.id.ll_bottom_tips /* 2131297914 */:
            case R.id.tv_rule_text /* 2131298795 */:
                r0.a(this.f3725t, g.e("gold_rules"));
                break;
            case R.id.rl_money /* 2131298263 */:
                r0.a(this.f3725t, 2);
                break;
            case R.id.tv_coin /* 2131298635 */:
                r0.a(this.f3725t, 1);
                break;
            case R.id.tv_login /* 2131298738 */:
                m();
                break;
            case R.id.tv_login_dh /* 2131298739 */:
                c(o.d(R.string.dh_tips));
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.H = g.j();
        this.P = z2;
        if (this.P) {
            int iU = h.U();
            StringBuilder sb = new StringBuilder();
            sb.append(iU > 0 ? "需要" : "不需要");
            sb.append("刷新福利中心数据");
            sb.toString();
            if (iU > 0) {
                p();
            }
            r();
        }
    }

    private void a(String str, int i2) {
        if (this.M == null) {
            this.M = new IncomeBean5();
        }
        this.M.setBalance_gold(i2);
        this.M.setBalance_money(str);
        TextView textView = this.tvCoin;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "金币金额：%d币", Integer.valueOf(i2)));
        }
        TextView textView2 = this.tvMoney;
        if (textView2 != null) {
            textView2.setText(str);
        }
        f.a().a(new com.amgcyo.cuttadon.view.read.page.i(String.valueOf(i2), str), "golde_money");
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    static /* synthetic */ int b(Fuli5TaskBean fuli5TaskBean, Fuli5TaskBean fuli5TaskBean2) {
        return fuli5TaskBean.getState() - fuli5TaskBean2.getState();
    }

    private void c(String str) {
        a.b bVar = new a.b(getContext());
        bVar.c(true);
        bVar.b(true);
        bVar.a((Boolean) true);
        bVar.e(false);
        bVar.a(PopupAnimation.NoAnimation);
        QQMsgPopup qQMsgPopup = new QQMsgPopup(this.f3725t, str);
        bVar.a((BasePopupView) qQMsgPopup);
        qQMsgPopup.u().a(2500L);
    }

    static /* synthetic */ int a(Fuli5TaskBean fuli5TaskBean, Fuli5TaskBean fuli5TaskBean2) {
        return fuli5TaskBean.getTid() - fuli5TaskBean2.getTid();
    }

    public /* synthetic */ ImageView a(ImageCycleView.f fVar) {
        ImageView imageView = new ImageView(this.f3725t);
        this.f3728w.a(this.f3725t, ImageConfigImpl.builder().form(fVar.f4993c).url(fVar.a).imageView(imageView).build());
        return imageView;
    }

    @Override // com.amgcyo.cuttadon.view.popupview.OpenBoxResultPopup.a
    public void a(int i2) {
        this.N = i2;
        this.Q = -1;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        this.H = g.j();
        if (this.H == null) {
            m();
        }
        switch (i2) {
            case 1:
                this.H = g.j();
                if (this.H == null) {
                    m();
                } else {
                    r0.c(this.f3725t);
                }
                break;
            case 3:
                r0.startActivity(this.f3725t, Fission5InvaliUserActivity.class);
                break;
            case 4:
                if (this.I == 1) {
                    showLoading("正在获取数据...");
                    ((UserPresenter) this.f3726u).r(Message.a(this, new Object[0]));
                } else {
                    r0.startActivity(this.f3725t, Fission5BindCodeActivity.class);
                }
                break;
            case 5:
                this.Q = i3;
                q();
                break;
            case 6:
                MkMainActivity mkMainActivityL = l();
                if (mkMainActivityL != null) {
                    showMessage("阅读书架任意书籍即可获取奖励");
                    mkMainActivityL.toBookBookshelf();
                }
                break;
            case 7:
                this.Q = i3;
                showLoading("正在获取大礼包...");
                ((UserPresenter) this.f3726u).C(Message.a(this, new Object[0]));
                break;
            case 8:
                Fuli5SignIndex fuli5SignIndex = this.K;
                if (fuli5SignIndex == null) {
                    showLoading("正在签到中...");
                    ((UserPresenter) this.f3726u).x(Message.a(this, new Object[0]));
                } else {
                    a(fuli5SignIndex);
                }
                break;
        }
    }

    private void a(Fuli5SignIndex fuli5SignIndex) {
        BasePopupView basePopupView = this.T;
        if (basePopupView == null) {
            Sign5PopupView sign5PopupView = new Sign5PopupView(this.f3725t, fuli5SignIndex);
            a.b bVar = new a.b(this.f3725t);
            bVar.b(true);
            bVar.d(false);
            bVar.e(true);
            bVar.a((BasePopupView) sign5PopupView);
            this.T = sign5PopupView.u();
            return;
        }
        basePopupView.u();
    }

    private void a(List<String> list) {
        com.gongwen.marqueen.b bVar = new com.gongwen.marqueen.b(this.f3725t);
        bVar.a((List) list);
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.setMarqueeFactory(bVar);
        }
    }
}
