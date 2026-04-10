package com.amgcyo.cuttadon.activity.main;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.SecondaryDomain;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.sdk.ui.OwnerRewardFullVideoActivity;
import com.amgcyo.cuttadon.sdk.ui.OwnerSplashActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkFullVideoActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.dialog.i1;
import com.amgcyo.cuttadon.widget.lovelydialog.LovelyStandardDialog;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.fatcatfat.io.R;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.ads.impl.SNADS;
import java.util.Arrays;
import java.util.List;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkLauncherActivity extends BaseTitleBarActivity<ConfigPresenter> implements com.amgcyo.cuttadon.h.f.a {
    public int delaymillis;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2575o0;

    @BindView(R.id.rl_root)
    RelativeLayout rl_root;

    @BindView(R.id.tv_msg)
    TextView tv_msg;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    String[] f2574n0 = {"android.permission.READ_PHONE_STATE"};

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f2576p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private com.amgcyo.cuttadon.h.f.c f2577q0 = new d();

    class a implements com.hjq.permissions.a {
        final /* synthetic */ boolean a;

        a(boolean z2) {
            this.a = z2;
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            String str = "onDenied configIsNull:" + this.a;
            if (this.a) {
                MkLauncherActivity.this.J();
            } else {
                MkLauncherActivity.this.a(list);
            }
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            String str = "onGranted configIsNull:" + this.a + " all: " + z2;
            if (this.a) {
                MkLauncherActivity.this.J();
            } else if (z2) {
                MkLauncherActivity.this.A();
            }
        }
    }

    class b implements com.hjq.permissions.a {
        b() {
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            MkLauncherActivity.this.D();
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            MkLauncherActivity.this.D();
        }
    }

    class c implements i1.a {
        final /* synthetic */ MkAppConfig a;

        c(MkAppConfig mkAppConfig) {
            this.a = mkAppConfig;
        }

        @Override // com.amgcyo.cuttadon.view.dialog.i1.a
        public void a() {
            MkLauncherActivity mkLauncherActivity = MkLauncherActivity.this;
            mkLauncherActivity.a(this.a, mkLauncherActivity.f2574n0);
        }

        @Override // com.amgcyo.cuttadon.view.dialog.i1.a
        public void b() {
            MkLauncherActivity mkLauncherActivity = MkLauncherActivity.this;
            mkLauncherActivity.a((List<String>) Arrays.asList(mkLauncherActivity.f2574n0));
        }
    }

    class d implements com.amgcyo.cuttadon.h.f.c {
        d() {
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdClose(String str) {
            if (MkLauncherActivity.this.f2576p0) {
                com.amgcyo.cuttadon.utils.otherutils.h.R0();
            }
            MkLauncherActivity.this.J();
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdFail(int i2, String str, String str2, String str3) {
            MkLauncherActivity.this.J();
            System.out.println(str2 + "splash load reward data fail code:" + i2 + " msg: " + str);
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
            MkLauncherActivity.this.f2576p0 = false;
            if (hVar != null) {
                MkLauncherActivity.this.f2576p0 = true;
                System.out.println("splash load reward data success, thanks");
            }
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdVideoCached(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.f2575o0 = com.amgcyo.cuttadon.utils.otherutils.g.h();
        if (this.f2575o0 < 0) {
            D();
            return;
        }
        if (!com.amgcyo.cuttadon.app.o.c.h()) {
            D();
            return;
        }
        final String str = "cancle_location";
        if (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("cancle_location", false)) {
            D();
            return;
        }
        final String[] strArr = {com.kuaishou.weapon.p0.g.f16727g};
        if (com.hjq.permissions.f.a(a(), strArr)) {
            D();
            return;
        }
        final String str2 = "permission_location";
        if (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("permission_location", false)) {
            a(strArr);
        } else {
            com.amgcyo.cuttadon.f.o.a(this.f2277w, "提示", "为匹配附近最优网络线路，应用需要获取您的粗略地理位置信息，是否允许?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2683s.a(strArr, str2, view);
                }
            }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2669s.a(str2, str, view);
                }
            });
        }
    }

    @SuppressLint({"MissingPermission"})
    private void B() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
            if (telephonyManager == null) {
                String strB = com.github.gzuliyujiang.oaid.b.b(this);
                if (TextUtils.isEmpty(strB)) {
                    strB = com.github.gzuliyujiang.oaid.b.c(this);
                }
                String str = "telephonyManager为空时通过第三方获取设备号：" + strB;
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                String str2 = "8.0以上系统获取imei：" + telephonyManager.getImei();
                return;
            }
            String str3 = "8.0以下系统获取deviceId：" + telephonyManager.getDeviceId();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int C() {
        int iA = com.amgcyo.cuttadon.sdk.utils.g.a("sdk_init_time") * 1000;
        Integer.valueOf(iA);
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (com.amgcyo.cuttadon.utils.otherutils.h.M0()) {
            obtainPresenter().i(Message.a(this, new Object[]{false}));
        }
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        final boolean zA = g0VarA.a("csj_new", false);
        final boolean zA2 = g0VarA.a("gdt_new", false);
        final boolean zA3 = g0VarA.a("ks", false);
        final boolean zA4 = g0VarA.a("gm", false);
        final boolean zA5 = g0VarA.a("topon_new", false);
        String str = "initAdSdk需要初始化的广告平台：\ncsjInit: " + zA + "\ngdtInit: " + zA2 + "\nksInit: " + zA3 + "\ngromoreInit: " + zA4 + "\ntoponInit: " + zA5;
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f2676s.a(zA4, zA5, zA2, zA3, zA);
            }
        });
    }

    private boolean E() {
        return com.hjq.permissions.f.a(a(), this.f2574n0);
    }

    private void F() {
        BaseAd baseAd;
        if (com.amgcyo.cuttadon.utils.otherutils.g.c()) {
            J();
            return;
        }
        List<BaseAd> listX0 = com.amgcyo.cuttadon.utils.otherutils.h.x0();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listX0)) {
            J();
            return;
        }
        if (1 == listX0.size()) {
            baseAd = listX0.get(0);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
            int iA = g0VarA.a("tendency", 0);
            try {
                BaseAd baseAd2 = listX0.get(iA);
                if (baseAd2 != null) {
                    g0VarA.b("tendency", iA + 1);
                }
                baseAd = baseAd2;
            } catch (Exception unused) {
                baseAd = listX0.get(0);
                if (baseAd != null) {
                    g0VarA.b("tendency", 1);
                }
            }
        }
        if (baseAd == null) {
            J();
            return;
        }
        String platform = baseAd.getPlatform();
        int style = baseAd.getStyle();
        if (TextUtils.isEmpty(platform) || style <= 0) {
            String str = "闪屏广告不满足条件：platform: " + platform;
            J();
            return;
        }
        this.T = com.amgcyo.cuttadon.sdk.utils.h.a("splash_screen", "interval_count");
        this.V = com.amgcyo.cuttadon.sdk.utils.h.a("splash_screen", "second");
        int iG = com.amgcyo.cuttadon.app.o.c.g();
        if (!c(iG)) {
            String str2 = "闪屏广告不满足条件：checkStartCount: " + iG + "  interval_count: " + this.T;
            J();
            return;
        }
        String str3 = "platform: " + platform + " style: " + style;
        if ("self".equals(platform)) {
            if (style == 1) {
                OwnerSplashActivity.launch(a(), this.V, true);
                finish();
                return;
            } else {
                if (style == 9) {
                    Intent intent = new Intent(this.f2277w, (Class<?>) OwnerRewardFullVideoActivity.class);
                    intent.putExtra("key_txmoney", style);
                    intent.putExtra("ltype", false);
                    com.amgcyo.cuttadon.f.s.a.c((Activity) this.f2277w).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.main.h
                        @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
                        public final void a(int i2, Intent intent2) {
                            this.a.b(i2, intent2);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (style == 1) {
            this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "b");
            g(platform);
            return;
        }
        if (style != 2) {
            if (style == 3) {
                this.W = com.amgcyo.cuttadon.utils.otherutils.h.y0();
                this.X = com.amgcyo.cuttadon.utils.otherutils.h.A0();
                String str4 = "闪屏 当天需要观看激励视频次数:" + this.W + " 当天已观看激励视频次数: " + this.X;
                if (this.X < this.W) {
                    a(new BaseAd(platform, style));
                    return;
                } else {
                    b(platform, com.amgcyo.cuttadon.utils.otherutils.g.D());
                    return;
                }
            }
            if (style != 4) {
                String str5 = "不支持的广告样式：" + style + " ，直接进入主页。";
                J();
                return;
            }
        }
        b(platform, style);
    }

    private void G() {
        showMessage("网络不可用");
        Message messageA = Message.a(this, new Object[0]);
        String str = "没网络时，上一次保存的：" + com.amgcyo.cuttadon.utils.otherutils.g.F();
        MkAppConfig mkAppConfigJ0 = com.amgcyo.cuttadon.utils.otherutils.h.j0();
        messageA.f21202x = mkAppConfigJ0;
        if (mkAppConfigJ0 != null) {
            mkAppConfigJ0.setIs_cache(true);
            MkApplication.getAppContext().setAppConfig(mkAppConfigJ0);
        }
        String strF = com.amgcyo.cuttadon.utils.otherutils.g.F();
        com.amgcyo.cuttadon.utils.otherutils.g.a(mkAppConfigJ0);
        String str2 = "使用默认的域名：" + strF;
        SecondaryDomain secondaryDomainH = com.amgcyo.cuttadon.utils.otherutils.h.h();
        if (secondaryDomainH != null) {
            MkApplication.getAppContext().setDomainUrlBySecondDomain(secondaryDomainH);
        } else {
            MkApplication.getAppContext().setDomainUrl(strF);
        }
        messageA.f21197s = 853;
        messageA.b();
    }

    private void H() {
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.h.x0());
        if ((!com.amgcyo.cuttadon.app.o.c.h()) || zA) {
            J();
        } else {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean zA = com.amgcyo.cuttadon.h.j.a.a();
        com.amgcyo.cuttadon.utils.otherutils.g.x("");
        if (zA) {
            SNADS.isRiskUser(new RiskUserCallback() { // from class: com.amgcyo.cuttadon.activity.main.s
                @Override // com.sntech.ads.callback.RiskUserCallback
                public final void callback(boolean z2) {
                    MkLauncherActivity.c(z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.f2576p0 = false;
        com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) a(), (Class<?>) MkMainActivity.class, true);
    }

    static /* synthetic */ void f(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return;
        }
        DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        if (displayCutout == null) {
            g0VarA.b("hasNotch", false);
            return;
        }
        List<Rect> boundingRects = displayCutout.getBoundingRects();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(boundingRects)) {
            return;
        }
        for (Rect rect : boundingRects) {
            g0VarA.b("SafeInsetLeft", rect.left);
            g0VarA.b("SafeInsetTop", rect.top);
            g0VarA.b("SafeInsetRight", rect.right);
            g0VarA.b("SafeInsetBottom", rect.bottom);
            g0VarA.b("hasNotch", true);
        }
    }

    private void g(String str) {
        SdkSplashActivity.launch(this, str, this.Y, true);
        finish();
    }

    private void h(String str) {
        int iH = com.amgcyo.cuttadon.utils.otherutils.g.h();
        String str2 = "sex:" + iH;
        if (iH < 0) {
            e(str);
        } else {
            J();
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "getAvailableDomainName")
    private void subscriber(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent == null || this.rl_root == null || this.tv_msg == null) {
            return;
        }
        int iF = mkCommentEvent.f();
        if (iF > 0) {
            this.tv_msg.setText(String.format("正在为你寻找高速线路(%s)", Integer.valueOf(iF)));
        } else {
            this.tv_msg.setText("正在为你寻找高速线路");
        }
        this.rl_root.setVisibility(0);
    }

    private void y() {
        this.delaymillis = C();
        TextView textView = this.tv_msg;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2689s.o();
                }
            });
        } else if (getWindow() != null) {
            getWindow().getDecorView().post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2644s.q();
                }
            });
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2652s.r();
                }
            }, this.delaymillis);
        }
    }

    private void z() {
        if (networkisAvailable()) {
            MkApplication.getAppContext().setDomainUrl(com.amgcyo.cuttadon.utils.otherutils.g.F());
            obtainPresenter().c(Message.a(this, new Object[]{true}));
            return;
        }
        int iH = com.amgcyo.cuttadon.utils.otherutils.g.h();
        String str = "sex:" + iH;
        if (iH < 0) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(ArticleInfo.USER_SEX, 0);
        }
        G();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        a().finish();
    }

    @Override // com.amgcyo.cuttadon.h.f.a
    public void fail(int i2, String str) {
        y();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @TargetApi(28)
    public void getNotchParams() {
        final View decorView = getWindow().getDecorView();
        decorView.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.u
            @Override // java.lang.Runnable
            public final void run() {
                MkLauncherActivity.f(decorView);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        int i2 = message.f21197s;
        if (i2 == 198) {
            H();
            return;
        }
        if (i2 == 612) {
            this.delaymillis = C();
            TextView textView = this.tv_msg;
            if (textView != null) {
                textView.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2661s.t();
                    }
                });
                return;
            } else if (getWindow() != null) {
                getWindow().getDecorView().post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2647s.w();
                    }
                });
                return;
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2658s.x();
                    }
                }, this.delaymillis);
                return;
            }
        }
        if (i2 != 853) {
            if (i2 != 1803) {
                return;
            }
            G();
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        MkAppConfig mkAppConfig = (MkAppConfig) message.f21202x;
        if (Build.VERSION.SDK_INT < 23) {
            if (mkAppConfig == null) {
                J();
                return;
            } else {
                A();
                return;
            }
        }
        if (E()) {
            if (mkAppConfig == null) {
                J();
                return;
            } else {
                A();
                return;
            }
        }
        int iA = g0VarA.a("never_count", 0);
        String str = "never_count:" + iA;
        if (iA >= 1) {
            String str2 = "已经弹出过" + iA + "次权限申请提示框";
            if (com.amgcyo.cuttadon.utils.otherutils.g.p0()) {
                a(mkAppConfig, this.f2574n0);
                return;
            } else {
                A();
                return;
            }
        }
        String str3 = "第" + iA + "次弹出自定义申请权限提示框";
        new i1(this).a(new c(mkAppConfig));
        if (isFinishing()) {
            return;
        }
        g0VarA.b("never_count", iA + 1);
        A();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        com.amgcyo.cuttadon.utils.otherutils.g.r0();
        z();
        if (Build.VERSION.SDK_INT >= 28) {
            getNotchParams();
        }
        f();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_launcher;
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
        f("init tv_msg");
    }

    public /* synthetic */ void o() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f2654s.n();
            }
        }, this.delaymillis);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1024) {
            z();
        }
    }

    public /* synthetic */ void p() {
        f("init getDecorView");
    }

    public /* synthetic */ void q() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f2650s.p();
            }
        }, this.delaymillis);
    }

    public /* synthetic */ void r() {
        f("init else");
    }

    public /* synthetic */ void s() {
        h("poll tv_msg");
    }

    @Override // com.amgcyo.cuttadon.h.f.a
    public void success() {
        y();
    }

    public /* synthetic */ void t() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f2686s.s();
            }
        }, this.delaymillis);
    }

    public /* synthetic */ void u() {
        h("poll getDecorView");
    }

    public /* synthetic */ void w() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f2666s.u();
            }
        }, this.delaymillis);
    }

    public /* synthetic */ void x() {
        h("poll else");
    }

    private void b(final List<String> list) {
        final String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        String string = getString(R.string.message_permission_always_failed, new Object[]{TextUtils.join("\n", getResources().getStringArray(R.array.permission_title))});
        String str = "\n\n温馨提示：\n如果出现权限申请失败或重复申请权限从而导致APP不能正常使用的问题，请点击下方“去官网”按钮访问我们的官网:" + strC0 + "下载最新版本。";
        SpannableString spannableString = new SpannableString(string + str);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.65f);
        int length = string.length();
        int length2 = str.length() + length;
        spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2)), length, length2, 17);
        spannableString.setSpan(relativeSizeSpan, length, length2, 17);
        if (a().isFinishing()) {
            return;
        }
        new LovelyStandardDialog(a(), LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(getResources().getDrawable(R.drawable.dialog_bg_round_top)).f(R.color.colorPrimary).c(R.drawable.ic_info_outline_black_32dp).b("提示").a(false).a(spannableString).b(R.string.go_setting, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2662s.a(list, view);
            }
        }).a(R.string.cancel, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2643s.e(view);
            }
        }).b("去官网", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2687s.a(strC0, view);
            }
        }).c();
    }

    private boolean c(int i2) {
        int i3 = this.T;
        if (i3 != 1) {
            return i3 != 0 && i2 % i3 == 0;
        }
        return true;
    }

    private void e(String str) {
        int iH = com.amgcyo.cuttadon.utils.otherutils.g.h();
        String str2 = "sex:" + iH + " type: " + str;
        if (iH >= 0) {
            J();
        } else if (com.amgcyo.cuttadon.a.f2254e.intValue() == 0) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) a(), (Class<?>) SexModel0guiderActivity.class, true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) a(), (Class<?>) SexModel1guiderActivity.class, true);
        }
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public ConfigPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ConfigPresenter) this.f2276v;
    }

    static /* synthetic */ void c(boolean z2) {
        com.amgcyo.cuttadon.utils.otherutils.g.x("风险用户或设备,结果仅供参考。");
        com.amgcyo.cuttadon.utils.otherutils.g.x(z2 ? "风险用户或设备,结果仅供参考。" : "正常用户或设备,结果仅供参考。");
        String str = "x1 sdk 判断该用户或设备为：" + z2 + "  " + com.amgcyo.cuttadon.utils.otherutils.g.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MkAppConfig mkAppConfig, String[] strArr) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.e0() >= 200) {
            B();
        }
        boolean z2 = mkAppConfig == null;
        com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) this);
        fVarA.a(strArr);
        fVarA.a(new a(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        boolean zP0 = com.amgcyo.cuttadon.utils.otherutils.g.p0();
        String str = "forceRequestPermission:" + zP0;
        if (zP0) {
            b(list);
        } else {
            showErrorMsgGravityBottom("必要权限被拒绝，可能影响你正常阅读书籍！");
            A();
        }
    }

    private void f(String str) {
        this.f2575o0 = com.amgcyo.cuttadon.utils.otherutils.g.h();
        String str2 = " type: " + str + " sex:" + this.f2575o0;
        if (this.f2575o0 < 0) {
            e(str);
            return;
        }
        boolean zI0 = com.amgcyo.cuttadon.utils.otherutils.h.I0();
        boolean zJ0 = com.amgcyo.cuttadon.utils.otherutils.h.J0();
        boolean zN0 = com.amgcyo.cuttadon.utils.otherutils.h.N0();
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            H();
            return;
        }
        if (!zI0 && !zJ0 && !zN0) {
            H();
        } else if (com.amgcyo.cuttadon.app.o.c.h()) {
            a(mkUserJ);
        } else {
            H();
        }
    }

    private void a(String[] strArr) {
        com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) this);
        fVarA.a(strArr);
        fVarA.a(new b());
    }

    public /* synthetic */ void a(List list, View view) {
        com.hjq.permissions.f.a((Activity) this, (List<String>) list);
    }

    public /* synthetic */ void a(String str, View view) {
        try {
            com.amgcyo.cuttadon.f.o.a(this.f2277w, str, R.string.website_copy_suc);
            com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, str);
            a().finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(String[] strArr, String str, View view) {
        a(strArr);
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b(str, true);
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        J();
    }

    private void b(String str, int i2) {
        if (i2 == 2) {
            this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, com.anythink.core.c.e.a);
            if ("csj_new".equals(str)) {
                this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, "l");
            }
        } else if (i2 == 4) {
            this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, "s");
        }
        SdkFullVideoActivity.launch(this, str, this.Y, true);
        finish();
    }

    public /* synthetic */ void a(String str, String str2, View view) {
        D();
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b(str, true);
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b(str2, true);
    }

    private void a(BaseAd baseAd) {
        String platform = baseAd.getPlatform();
        com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, "position_splash_reward_ad_video", com.amgcyo.cuttadon.utils.otherutils.h.a(platform, com.anythink.expressad.foundation.d.c.bj), baseAd.getStyle(), baseAd.isNoExempt()), this.f2577q0);
    }

    public /* synthetic */ void a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        MkApplication appContext = MkApplication.getAppContext();
        String strJ = com.amgcyo.cuttadon.sdk.utils.d.j("aid");
        String strE = com.amgcyo.cuttadon.sdk.utils.d.e(com.anythink.expressad.d.a.b.cZ);
        String strH = com.amgcyo.cuttadon.sdk.utils.d.h(com.anythink.expressad.d.a.b.cZ);
        String strK = com.amgcyo.cuttadon.sdk.utils.d.k(com.anythink.expressad.d.a.b.cZ);
        String strA = com.amgcyo.cuttadon.sdk.utils.d.a(com.anythink.expressad.d.a.b.cZ);
        String strP = com.amgcyo.cuttadon.sdk.utils.d.p("aid");
        String strP2 = com.amgcyo.cuttadon.sdk.utils.d.p("as");
        String str = "\ncsj_appId:" + strE + "\ngdt_appId:" + strH + "\nks_appId:" + strK + "\nbaidu_appId:" + strA;
        if (com.amgcyo.cuttadon.utils.otherutils.g.d0()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2648s.I();
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }
        String str2 = "gromoreInit: " + z2 + " gromoreAppId: " + strJ;
        if (z2) {
            if (!TextUtils.isEmpty(strJ)) {
                appContext.initGromoreSdk(strJ);
                this.f2575o0 = com.amgcyo.cuttadon.utils.otherutils.g.h();
                String str3 = "gm config:" + GMMediationAdSdk.configLoadSuccess();
                y();
                return;
            }
            y();
            return;
        }
        String str4 = "toponInit: " + z3 + " toponSdkAppId: " + strP + " toponSdkAppKey: " + strP2;
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strP2)) {
            appContext.initToponSdk(strP, strP2);
        }
        String str5 = "gdtInit: " + z4 + " gdt_appId: " + strH;
        if (z4 && !TextUtils.isEmpty(strH)) {
            appContext.initGdtSdk();
        }
        String str6 = "ksInit: " + z5 + " ks_appId: " + strK;
        if (z5 && !TextUtils.isEmpty(strK)) {
            appContext.initKsSdk();
        }
        String str7 = "csjInit: " + z6 + " csj_appId: " + strE;
        if (z6) {
            if (!TextUtils.isEmpty(strE)) {
                appContext.initCsjSdk(this);
                return;
            } else {
                y();
                return;
            }
        }
        y();
    }

    private void a(MkUser mkUser) {
        if (mkUser != null) {
            obtainPresenter().j(Message.a(this, new Object[]{false, 198}));
        }
    }
}
