package com.amgcyo.cuttadon.sdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6IndexActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.utils.otherutils.e0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.dialog.z0;
import com.amgcyo.cuttadon.view.otherview.LabelTextView;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.c;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class MyRewardBaseAdActivity<P extends me.jessyan.art.mvp.c> extends BaseTitleBarActivity implements com.amgcyo.cuttadon.h.f.c {
    protected Disposable A0;
    private String C0;
    public int bottom_adHeight;

    @BindView(R.id.cons_root_have_net)
    ConstraintLayout cons_root_have_net;

    @BindView(R.id.continue_img)
    ImageView continue_img;

    @BindView(R.id.dialog_message)
    TextView dialog_message;

    @BindView(R.id.dialog_tv_ok)
    TextView dialog_tv_ok;

    @BindView(R.id.labeltextview)
    LabelTextView labeltextview;

    @BindView(R.id.ll_continue_root)
    protected LinearLayout ll_continue_root;

    @BindView(R.id.material_background)
    LinearLayout material_background;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected Disposable f4265n0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private List<BaseAd> f4268q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f4269r0;
    public int readBottomSwitch;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f4270s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f4271t0;

    @BindView(R.id.tv_look_video_have_net)
    TextView tv_look_video_have_net;

    @BindView(R.id.tv_not_have_net)
    TextView tv_not_have_net;

    @BindView(R.id.tv_read_time_have_net)
    TextView tv_read_time_have_net;

    @BindView(R.id.tv_tip)
    TextView tv_tip;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected boolean f4273v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected Disposable f4274w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected String f4276y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected Disposable f4277z0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f4266o0 = false;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f4267p0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f4272u0 = 1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f4275x0 = false;
    protected boolean B0 = false;

    private void g(String str) {
        com.amgcyo.cuttadon.h.h.c.c("preload_click", str);
    }

    private void j(final int i2) {
        LinearLayout linearLayout = this.ll_continue_root;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.material_background.setVisibility(8);
            this.cons_root_have_net.setVisibility(0);
            this.labeltextview.setVisibility(8);
            this.G.a(this.f2277w, ImageConfigImpl.builder().resId(R.drawable.bg_dialog_continue_read).imageRadius(8).imageView(this.continue_img).build());
            ViewGroup.LayoutParams layoutParams = this.continue_img.getLayoutParams();
            int iA = com.amgcyo.cuttadon.utils.otherutils.n.a(this) / 2;
            if (com.amgcyo.cuttadon.utils.otherutils.h.I0()) {
                this.labeltextview.setVisibility(0);
                double dA = com.amgcyo.cuttadon.utils.otherutils.n.a(this);
                Double.isNaN(dA);
                iA = (int) (dA / 1.5d);
                layoutParams.width = com.amgcyo.cuttadon.utils.otherutils.n.c(this) - (com.amgcyo.cuttadon.utils.otherutils.n.a(20.0f) * 2);
                this.labeltextview.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.ui.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f4306s.e(view);
                    }
                });
            }
            layoutParams.height = iA;
            String str = "高度为：" + layoutParams.height + "  " + com.amgcyo.cuttadon.utils.otherutils.n.a(380.0f);
            this.continue_img.setLayoutParams(layoutParams);
            n();
            if (3 == i2) {
                com.amgcyo.cuttadon.utils.otherutils.g.g(false);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.j(false);
            }
            int iW = com.amgcyo.cuttadon.utils.otherutils.h.W();
            int iO = com.amgcyo.cuttadon.utils.otherutils.h.o(i2);
            String str2 = iO <= 0 ? "今日仅需解锁" : "今日再解锁";
            String str3 = (iW - iO) + "";
            SpannableString spannableString = new SpannableString(str2 + str3 + "次，全天免广告");
            int length = str2.length();
            int length2 = str3.length() + length;
            spannableString.setSpan(new AbsoluteSizeSpan(40, true), length, length2, 33);
            spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_FED587)), length, length2, 33);
            this.tv_read_time_have_net.setText(spannableString);
            this.tv_tip.setVisibility(8);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
                this.tv_tip.setVisibility(0);
                this.tv_tip.setText("温馨提示：小说与漫画需要分别解锁！");
                Animation animationA = com.amgcyo.cuttadon.j.g.a.a(5);
                this.tv_tip.setAnimation(animationA);
                this.tv_tip.startAnimation(animationA);
            }
            this.tv_not_have_net.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4314s.a(i2, view);
                }
            });
            this.tv_look_video_have_net.setTag(0);
            this.tv_look_video_have_net.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.ui.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4310s.b(i2, view);
                }
            });
        }
    }

    private void k(int i2) {
        String str = 3 == i2 ? "position_unlock_comic_reward_ad_video" : "position_unlock_novel_reward_ad_video";
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a(str, str);
        if (normalAdParamsA == null) {
            showMessage("错误码：c6002");
            return;
        }
        BaseAd baseAd = normalAdParamsA.getBaseAd();
        if (baseAd == null) {
            showMessage("错误码：c6003");
            return;
        }
        if (TextUtils.isEmpty(baseAd.getPlatform())) {
            showMessage("错误码：c6004");
            return;
        }
        h("45分钟解锁广告位");
        baseAd.setLoad_type(((Integer) this.tv_look_video_have_net.getTag()).intValue());
        String str2 = "loadType:" + baseAd.getLoad_type();
        a(str, baseAd);
    }

    @Subscriber(mode = ThreadMode.POST, tag = "finish_activity")
    private void subscriberLoginOrRegUser(MkUser mkUser) {
        if (mkUser == null || !com.amgcyo.cuttadon.utils.otherutils.h.I0()) {
            return;
        }
        LinearLayout linearLayout = this.ll_continue_root;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.ll_continue_root.setVisibility(8);
        }
        d(this.f4272u0);
    }

    static /* synthetic */ void x() throws Exception {
    }

    public /* synthetic */ void b(int i2, View view) {
        if (networkisAvailable()) {
            k(i2);
        } else {
            showErrorMsgGravityBottom("网络连接不可用，请检查网络设置!");
        }
    }

    protected void c(final int i2) {
        boolean zE = 3 == i2 ? com.amgcyo.cuttadon.app.o.c.e() : com.amgcyo.cuttadon.app.o.c.f();
        String str = "rewardverify:" + zE;
        if (zE) {
            a(this.f4277z0);
            this.f4277z0 = com.amgcyo.cuttadon.j.g.b.a(0L, 30L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.amgcyo.cuttadon.sdk.ui.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f4316s.a(i2, (Long) obj);
                }
            });
        }
    }

    public abstract void chooseListenerType();

    protected void d(int i2) {
        this.f4273v0 = g(i2);
        if (this.f4273v0) {
            h(i2);
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.p(i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("启动45分钟解锁倒计时:");
            sb.append(this.f4274w0 == null);
            sb.toString();
            if (this.f4274w0 == null) {
                i(i2);
            }
        }
    }

    protected boolean e(int i2) {
        int iO = com.amgcyo.cuttadon.utils.otherutils.h.o(i2);
        int iW = com.amgcyo.cuttadon.utils.otherutils.h.W();
        String str = i2 + " seenTodayVideoCountByForm:" + iO + " max_ad_count " + iW;
        return iO >= iW;
    }

    public /* synthetic */ void f(String str) {
        showMessage(str);
    }

    public int getRefreshAdTime() {
        return g0.a().a("ad_polling_second_value", 60);
    }

    protected void h(int i2) {
        if (this.ll_continue_root == null) {
            showMessage("系统参数异常，请重试！错误码：c1126");
            finish();
            return;
        }
        String str = "form:" + i2;
        this.f4272u0 = i2;
        if (this.ll_continue_root.getVisibility() != 0) {
            if (!networkisAvailable()) {
                showErrorMsgGravityBottom("网络连接不可用，请检查网络设置!");
                j(i2);
            } else if (com.amgcyo.cuttadon.utils.otherutils.h.q(i2)) {
                this.tv_look_video_have_net.setTag(1);
                k(i2);
            } else {
                j(i2);
                hideMenu();
            }
        }
    }

    public abstract void hideMenu();

    protected void i(final int i2) {
        n();
        if (e(i2)) {
            return;
        }
        final long j2 = 864000;
        this.f4274w0 = Flowable.intervalRange(0L, 864001L, 30L, 30L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new Function() { // from class: com.amgcyo.cuttadon.sdk.ui.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Long.valueOf(j2 - ((Long) obj).longValue());
            }
        }).doOnNext(new Consumer() { // from class: com.amgcyo.cuttadon.sdk.ui.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f4321s.b(i2, (Long) obj);
            }
        }).doOnComplete(new Action() { // from class: com.amgcyo.cuttadon.sdk.ui.e
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                MyRewardBaseAdActivity.x();
            }
        }).subscribe();
    }

    public void initData(@Nullable Bundle bundle) {
        this.readBottomSwitch = com.amgcyo.cuttadon.sdk.utils.g.a("read_bottom_switch", 0);
        String str = "readBottomSwitch:" + this.readBottomSwitch;
        if (com.amgcyo.cuttadon.utils.otherutils.h.F0()) {
            if (TextUtils.isEmpty(this.C0)) {
                this.f4276y0 = p();
                this.C0 = com.open.hule.library.c.b.a(this.f4276y0);
            }
            String str2 = this.f4276y0 + " md5: " + this.C0;
            File[] fileArrListFiles = new File(getFilesDir().getAbsolutePath() + "/mmkv").listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (!name.startsWith("mofish") && !name.startsWith(this.C0) && file.isFile() && file.delete()) {
                    String str3 = name + " is deleted ";
                }
            }
        }
    }

    protected void n() {
        Disposable disposable = this.f4274w0;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.f4274w0.dispose();
        this.f4274w0 = null;
    }

    protected BaseAd o() {
        return com.amgcyo.cuttadon.sdk.utils.e.b("position_download_cache_reward_ad_video", "down_cache");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        LinearLayout linearLayout = this.ll_continue_root;
        if (linearLayout != null && linearLayout.getVisibility() == 0 && (i2 == 4 || i2 == 3 || i2 == 24 || i2 == 25)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.B0 = true;
        a(this.f4265n0, this.f4277z0, this.A0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdClose(String str) {
        String str2;
        this.f4267p0 = false;
        this.f4275x0 = false;
        if (TextUtils.isEmpty(str)) {
            showMessage("参数异常，请重试！");
            finish();
            return;
        }
        byte b = -1;
        int i2 = 3;
        switch (str.hashCode()) {
            case -1032881370:
                if (str.equals("position_unlock_comic_reward_ad_video")) {
                    b = 4;
                }
                break;
            case -178773517:
                if (str.equals("position_listening_book_reward_ad_video")) {
                    b = 0;
                }
                break;
            case 294203968:
                if (str.equals("comics_position_reward_ad_video")) {
                    b = 2;
                }
                break;
            case 1191092569:
                if (str.equals("position_reward_ad_video")) {
                    b = 3;
                }
                break;
            case 1269873927:
                if (str.equals("position_unlock_novel_reward_ad_video")) {
                    b = 5;
                }
                break;
            case 1291070225:
                if (str.equals("position_download_cache_reward_ad_video")) {
                    b = 1;
                }
                break;
        }
        if (b != 0) {
            if (b != 1) {
                if (b == 2 || b == 3) {
                    if (this.f4266o0) {
                        int iB = g0.a().b("value_last_time_novel");
                        if ("comics_position_reward_ad_video".equals(str)) {
                            iB = g0.a().b("value_last_time_comics");
                        }
                        b1 b1Var = new b1(a());
                        b1Var.a(new p(this));
                        b1Var.show();
                        b1Var.a("已成功去除" + iB + "分钟阅读器内广告.");
                    } else {
                        c("未看完完整视频或获取数据失败，请重试！");
                    }
                } else if (b == 4 || b == 5) {
                    if ("position_unlock_comic_reward_ad_video".equals(str)) {
                        str2 = "comic";
                    } else {
                        str2 = "novel";
                        i2 = 1;
                    }
                    if (this.f4266o0) {
                        com.amgcyo.cuttadon.h.a.i.a(i2, true);
                        LinearLayout linearLayout = this.ll_continue_root;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                            i(i2);
                            if (e(i2)) {
                                d(com.amgcyo.cuttadon.f.o.d(R.string.success_unlock_today));
                                com.amgcyo.cuttadon.h.h.c.a(a(), str2);
                            } else {
                                d("解锁成功~");
                            }
                            unlockContinueSuccess();
                        } else {
                            finish();
                        }
                    } else {
                        c("未看完完整视频或奖励获取失败！");
                        if (this.ll_continue_root != null) {
                            j(i2);
                        } else {
                            finish();
                        }
                    }
                }
            } else if (this.f4266o0) {
                reallyStartDownloadCache();
            } else {
                showMessage("获取奖励失败，请重试！");
            }
        } else if (this.f4266o0) {
            showMessage("正在开始语音听书");
            chooseListenerType();
            u();
        } else {
            showMessage("获取奖励失败，请重试！");
        }
        this.f4266o0 = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    @Override // com.amgcyo.cuttadon.h.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRewardAdFail(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 1308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity.onRewardAdFail(int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    @Override // com.amgcyo.cuttadon.h.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h r11) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity.onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h):void");
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdVideoCached(final Object obj) {
        this.f4275x0 = false;
        if (obj == null) {
            com.amgcyo.cuttadon.h.h.c.c("preload_provider_is_null", "provider is null");
            return;
        }
        if (this.ll_continue_root == null) {
            com.amgcyo.cuttadon.h.h.c.c("preload_textview_is_null", "textview or activity is null");
            return;
        }
        n();
        this.ll_continue_root.setVisibility(0);
        this.material_background.setVisibility(0);
        this.cons_root_have_net.setVisibility(8);
        hideMenu();
        int iW = com.amgcyo.cuttadon.utils.otherutils.h.W();
        int iO = com.amgcyo.cuttadon.utils.otherutils.h.o(this.f4272u0);
        StringBuilder sb = new StringBuilder();
        sb.append("今日");
        sb.append(this.f4272u0 == 1 ? "小说" : "漫画");
        sb.append("解锁统计：");
        String str = sb.toString() + "\n今日已解锁" + iO + "次，再解锁" + (iW - iO) + "次将开启阅读器内全天无广告阅读模式！";
        SpannableString spannableString = new SpannableString("本次纯净模式阅读时间已到，需要继续解锁。\n\n" + str);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), 22, str.length() + 22, 17);
        spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.a2a9b2)), 22, str.length() + 22, 33);
        this.dialog_message.setText(spannableString);
        this.dialog_tv_ok.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4318s.a(obj, view);
            }
        });
    }

    protected String p() {
        return com.amgcyo.cuttadon.utils.otherutils.g.B();
    }

    protected BaseAd q() {
        return com.amgcyo.cuttadon.sdk.utils.e.b("position_listening_book_reward_ad_video", "listening_book");
    }

    public /* synthetic */ void r() {
        c("阅读器免广告时间已经使用完毕！");
    }

    public abstract void reallyStartDownloadCache();

    public abstract void restartActivityPage();

    public /* synthetic */ void s() {
        a(q());
    }

    public /* synthetic */ void t() {
        a(o());
    }

    protected void u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iD = com.amgcyo.cuttadon.app.o.c.d();
        g0.a().b("therapeutic", iD <= 0 ? 0L : ((long) (iD * 60 * 1000)) + jCurrentTimeMillis);
        g0.a().b("thera_focus_peutic", jCurrentTimeMillis);
        g0.a().b("contractive", true);
    }

    public abstract void unlockContinueSuccess();

    protected void w() {
        a(this.A0);
        final int i2 = 10;
        long j2 = 10;
        this.A0 = com.amgcyo.cuttadon.j.g.b.a(j2, j2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.amgcyo.cuttadon.sdk.ui.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f4307s.c(i2, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, Activity activity) {
        if (activity == null || activity.isFinishing()) {
            com.amgcyo.cuttadon.h.h.c.c("preload_textview_is_null", "textview or activity is null");
            return;
        }
        try {
            if (obj instanceof RewardVideoAD) {
                g("gdt showAd");
                ((RewardVideoAD) obj).showAD(activity);
            } else if (obj instanceof TTRewardVideoAd) {
                g("csj showRewardVideoAd");
                ((TTRewardVideoAd) obj).showRewardVideoAd(activity);
            } else if (obj instanceof KsRewardVideoAd) {
                g("ks showRewardVideoAd");
                ((KsRewardVideoAd) obj).showRewardVideoAd(activity, null);
            } else if (obj instanceof GMRewardAd) {
                ((GMRewardAd) obj).showRewardAd(activity);
            } else if (obj instanceof ATRewardVideoAd) {
                ((ATRewardVideoAd) obj).show(activity);
            } else {
                g("unknow value");
                showMessage("系统参数异常，请重试！错误码：c1128");
                j(this.f4272u0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.amgcyo.cuttadon.utils.otherutils.g.a(e2, "base reward");
            com.amgcyo.cuttadon.h.h.c.c("preload_try_catch", e2.getMessage());
            j(this.f4272u0);
        }
    }

    protected boolean f(int i2) {
        return 3 == i2 ? com.amgcyo.cuttadon.utils.otherutils.g.i0() : com.amgcyo.cuttadon.utils.otherutils.g.n0();
    }

    protected boolean g(int i2) {
        return com.amgcyo.cuttadon.utils.otherutils.h.r(i2);
    }

    public /* synthetic */ void b(int i2, Long l2) throws Exception {
        if (g(i2)) {
            h(i2);
            n();
        }
    }

    public /* synthetic */ void e(View view) {
        r0.startActivity(this.f2277w, Fission6IndexActivity.class);
    }

    protected void e(@NonNull String str) {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a(str, str);
        if (normalAdParamsA == null) {
            showMessage("错误码：c1213");
            return;
        }
        BaseAd baseAd = normalAdParamsA.getBaseAd();
        if (baseAd == null) {
            showMessage("错误码：c1214");
            return;
        }
        if (TextUtils.isEmpty(normalAdParamsA.getStochasticKey())) {
            showMessage("错误码：c1215");
            return;
        }
        h("看广告免广告");
        this.f4276y0 = p();
        String str2 = this.f4276y0 + "academic";
        int iX = com.amgcyo.cuttadon.utils.otherutils.h.X();
        if ("comics_position_reward_ad_video".equals(str)) {
            str2 = this.f4276y0 + "academic";
            iX = com.amgcyo.cuttadon.utils.otherutils.h.v();
        } else if ("position_reward_ad_video".equals(str)) {
            str2 = this.f4276y0 + "academic";
            iX = com.amgcyo.cuttadon.utils.otherutils.h.X();
        }
        int iA = g0.a().a(str2, -1);
        String str3 = "今日剩余看视频免广告次数：" + iA;
        if (iA >= iX) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.mingting));
        } else {
            baseAd.setLoad_type(0);
            a(str, baseAd);
        }
    }

    public /* synthetic */ void c(int i2, Long l2) throws Exception {
        Long lJ = com.amgcyo.cuttadon.utils.otherutils.g.J();
        if (lJ.longValue() % 1200 == 0) {
            f();
        }
        com.amgcyo.cuttadon.utils.otherutils.g.c(lJ.longValue() + ((long) i2));
    }

    private void h(String str) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.b(this.f4268q0)) {
            this.f4268q0.clear();
            this.f4268q0 = null;
        }
        List<BaseAd> listJ = com.amgcyo.cuttadon.utils.otherutils.h.J();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listJ)) {
            return;
        }
        String str2 = str + "———错误后广告轮询列表大小：" + listJ.size();
        this.f4268q0 = new ArrayList(listJ);
    }

    public /* synthetic */ void a(int i2, View view) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.a(i2) == 0) {
            finish();
            return;
        }
        com.amgcyo.cuttadon.h.a.i.a(i2, false);
        if (3 == i2) {
            com.amgcyo.cuttadon.utils.otherutils.g.g(true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.j(true);
        }
        restartActivityPage();
    }

    private void a(int i2, int i3, String str, int i4) {
        com.amgcyo.cuttadon.h.a.i.a(i3, i4, false);
        if (3 == i3) {
            com.amgcyo.cuttadon.utils.otherutils.g.g(true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.j(true);
        }
        this.ll_continue_root.setVisibility(8);
        b1 b1Var = new b1(a());
        b1Var.a(new p(this));
        b1Var.show();
        this.f4269r0 = 0;
        b1Var.setCanceledOnTouchOutside(false);
        b1Var.setCancelable(false);
        b1Var.a(str + "解锁失败(" + i2 + ")，系统赠送您" + i4 + "分钟非纯净模式阅读时长！", "继续阅读");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BaseAd baseAd) {
        if (baseAd == null) {
            showMessage("错误码：c6018");
            return;
        }
        String stochasticKey = baseAd.getStochasticKey();
        h("听书或缓存广告位");
        baseAd.setLoad_type(0);
        a(stochasticKey, baseAd);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected void a(String str, BaseAd baseAd) {
        String strA;
        int i2;
        String strA2;
        if (this.f2277w == null || baseAd == null) {
            return;
        }
        int load_type = baseAd.getLoad_type();
        if (1 == load_type && this.f4275x0) {
            return;
        }
        String platform = baseAd.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            showMessage("错误码：c1215");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            showMessage("错误码：c1332");
            return;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1032881370:
                if (str.equals("position_unlock_comic_reward_ad_video")) {
                    b = 5;
                }
                break;
            case -178773517:
                if (str.equals("position_listening_book_reward_ad_video")) {
                    b = 0;
                }
                break;
            case 294203968:
                if (str.equals("comics_position_reward_ad_video")) {
                    b = 3;
                }
                break;
            case 1191092569:
                if (str.equals("position_reward_ad_video")) {
                    b = 2;
                }
                break;
            case 1269873927:
                if (str.equals("position_unlock_novel_reward_ad_video")) {
                    b = 4;
                }
                break;
            case 1291070225:
                if (str.equals("position_download_cache_reward_ad_video")) {
                    b = 1;
                }
                break;
        }
        if (b == 0) {
            strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "h");
        } else if (b == 1) {
            strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "i");
        } else if (b == 2) {
            strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "d");
        } else {
            if (b == 3) {
                strA2 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "j");
            } else if (b == 4) {
                strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "n");
                if (1 == load_type) {
                    showMessage("本次纯净阅读模式时间已快用完~");
                    this.f4275x0 = true;
                    com.amgcyo.cuttadon.h.h.c.c("preload_loading", "start novel preload");
                }
                LinearLayout linearLayout = this.ll_continue_root;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else if (b != 5) {
                strA = "";
            } else {
                String strA3 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "o");
                if (1 == load_type) {
                    hideMenu();
                    com.amgcyo.cuttadon.view.comic.comictoast.a.a(com.amgcyo.cuttadon.f.o.b(R.color.colorBlackAlpha8));
                    com.amgcyo.cuttadon.view.comic.comictoast.a.b(com.amgcyo.cuttadon.f.o.b(R.color.color_F8F8F8));
                    com.amgcyo.cuttadon.view.comic.comictoast.a.a(a(), "本次纯净阅读模式时间已快用完~", 5000L).a();
                    this.f4275x0 = true;
                    com.amgcyo.cuttadon.h.h.c.c("preload_loading", "start comics preload");
                }
                LinearLayout linearLayout2 = this.ll_continue_root;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                strA2 = strA3;
            }
            i2 = 3;
            String str2 = "codeId:" + strA2;
            com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, str, strA2, load_type, i2, baseAd.getStyle()), this);
        }
        strA2 = strA;
        i2 = 1;
        String str22 = "codeId:" + strA2;
        com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, str, strA2, load_type, i2, baseAd.getStyle()), this);
    }

    public /* synthetic */ void a(int i2, Long l2) throws Exception {
        boolean zJ;
        if (3 == i2) {
            zJ = com.amgcyo.cuttadon.app.o.c.i();
        } else {
            zJ = com.amgcyo.cuttadon.app.o.c.j();
        }
        String str = "protectExpam:" + zJ;
        if (zJ) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f4320s.r();
            }
        });
        a(this.f4277z0);
        if (3 == i2) {
            com.amgcyo.cuttadon.app.o.c.a(false);
        } else {
            com.amgcyo.cuttadon.app.o.c.b(false);
        }
    }

    protected void a(MkBook mkBook, int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.F0()) {
            int iA = com.amgcyo.cuttadon.sdk.utils.g.a("chapter_count");
            if (iA <= 0 || mkBook == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f4276y0)) {
                this.f4276y0 = p();
            }
            if (TextUtils.isEmpty(this.C0)) {
                this.C0 = com.open.hule.library.c.b.a(this.f4276y0);
            }
            e0.c(this.C0);
            String str = this.f4276y0 + " md5: " + this.C0;
            String str2 = this.f4276y0 + mkBook.getForm();
            int iIntValue = e0.b(str2).intValue();
            String str3 = mkBook.getBook_id() + "_" + i2;
            String str4 = "今天key：" + str2 + " 章节key: " + str3 + " chapter_count " + iA + " \ntodayReadCount " + iIntValue + " bookId: " + mkBook.getBook_id() + "  " + i2;
            if (iIntValue >= iA) {
                if (!com.amgcyo.cuttadon.utils.otherutils.g.m0()) {
                    new z0(this).show();
                }
            } else if (!e0.a(str3).booleanValue()) {
                e0.a(str2, Integer.valueOf(iIntValue + 1));
                e0.a(str3, true);
            }
            String str5 = "计算后：" + e0.b(str2).intValue();
        }
        if (mkBook == null || !f(mkBook.getForm())) {
            return;
        }
        a(mkBook.getForm(), i2);
    }

    private void a(int i2, int i3) {
        int iD = com.amgcyo.cuttadon.utils.otherutils.h.d(i2);
        if (iD <= 0 || i3 <= 0) {
            return;
        }
        int iE = com.amgcyo.cuttadon.utils.otherutils.h.e(i2);
        String str = iE + "  " + iD + "  " + i3;
        if (3 == iE && i3 % iD == 0) {
            com.amgcyo.cuttadon.h.a.h.a(this, "position_page_ad", i2);
        }
    }
}
