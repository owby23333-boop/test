package com.amgcyo.cuttadon.activity.read;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.api.entity.fission5.TipsInfo;
import com.amgcyo.cuttadon.api.entity.other.DownloadBean;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.api.entity.reader.FontBean;
import com.amgcyo.cuttadon.api.entity.reader.ReadLog;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.api.presenter.CatalogPresenter;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity;
import com.amgcyo.cuttadon.service.MkCacheBookService;
import com.amgcyo.cuttadon.utils.event.MkChapterListEvent;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.comic.k;
import com.amgcyo.cuttadon.view.dialog.r1;
import com.amgcyo.cuttadon.view.dialog.v0;
import com.amgcyo.cuttadon.view.otherview.BatteryView;
import com.amgcyo.cuttadon.view.otherview.DarkFrameLayout;
import com.amgcyo.cuttadon.view.otherview.PercentageRing;
import com.amgcyo.cuttadon.view.otherview.RoundRelativeLayout;
import com.amgcyo.cuttadon.view.popupview.IncomeTipsPopupView;
import com.amgcyo.cuttadon.view.popupview.NovelCatalogDrawerPopup;
import com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup;
import com.amgcyo.cuttadon.view.popupview.VideoTipsPopup;
import com.amgcyo.cuttadon.view.read.page.PageMode;
import com.amgcyo.cuttadon.view.read.page.PageView;
import com.amgcyo.cuttadon.view.readermenu.ReaderMenuMain;
import com.amgcyo.cuttadon.view.readermenu.ReaderMenuVoice;
import com.amgcyo.cuttadon.view.readermenu.ReaderNewPanel;
import com.amgcyo.cuttadon.view.readermenu.ReaderNewTitle;
import com.amgcyo.cuttadon.widget.ui.HProgressBarWithNumber;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.XMarqueeView;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.sdk.TbsListener;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class MkNovelBaseReaderActivity extends MyRewardBaseAdActivity<CatalogPresenter> implements com.amgcyo.cuttadon.g.h, com.open.hule.library.b.a, com.amgcyo.cuttadon.g.i {
    protected com.amgcyo.cuttadon.adapter.other.d D0;
    protected MkBook E0;
    protected boolean F0;
    protected com.amgcyo.cuttadon.view.read.page.k H0;
    protected int I0;
    protected int J0;
    int L0;
    protected MkCatalog M0;
    protected String N0;
    protected String O0;
    protected String P0;
    protected int R0;
    protected int S0;
    protected MkConfigSource T0;
    protected com.amgcyo.cuttadon.utils.otherutils.k W0;
    protected MkUser Y0;
    BasePopupView Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    IncomeTipsPopupView f2695a1;

    @BindView(R.id.app_des)
    protected TextView app_des;
    public com.amgcyo.cuttadon.database.f artBookDao;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private View f2696b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    ReadLog f2697c1;

    @BindView(R.id.ad_bottom)
    protected DarkFrameLayout chapterBottomAdView;

    @BindView(R.id.zx_ad_page_content)
    protected DarkFrameLayout chapterContentAdView;

    @BindView(R.id.ad_end)
    protected FrameLayout chapterEndAdView;

    @BindView(R.id.chapter_name)
    protected TextView chapter_name;

    @BindView(R.id.chapter_page)
    protected TextView chapter_page;

    @BindView(R.id.circle_progress_bar)
    protected PercentageRing circle_progress_bar;
    public int curPage;
    NovelCatalogDrawerPopup e1;
    NovelSourceDrawerPopup f1;
    MkBook g1;
    BookPresenter h1;

    @BindView(R.id.horizontalBattery)
    protected BatteryView horizontalBattery;
    protected int i1;

    @BindView(R.id.iv_read_jb)
    protected ImageView iv_read_jb;
    protected String k1;
    private int l1;

    @BindView(R.id.layout_bookview)
    protected LinearLayout layoutBookView;

    @BindView(R.id.layout_root)
    protected RelativeLayout layout_root;

    @BindView(R.id.ll_bottom)
    protected RelativeLayout ll_bottom;

    @BindView(R.id.ll_coin_tips)
    protected LinearLayout ll_coin_tips;
    private int m1;
    private View n1;
    private com.amgcyo.cuttadon.view.dialog.u0 o1;
    Intent p1;

    @BindView(R.id.progress_circular)
    protected View progress_circular;
    private j q1;
    HProgressBarWithNumber r1;

    @BindView(R.id.read_count)
    protected TextView read_count;

    @BindView(R.id.readerNewPanel)
    ReaderNewPanel readerNewPanel;

    @BindView(R.id.rl_top_bar)
    protected RelativeLayout rl_top_bar;

    @BindView(R.id.rrl_fiision5)
    protected RoundRelativeLayout rrl_fiision5;
    LinearLayout s1;

    @BindView(R.id.tagView)
    protected XMarqueeView tagView;
    public int totalPage;

    @BindView(R.id.tv_msg)
    protected TextView tv_msg;

    @BindView(R.id.tv_tips)
    protected TextView tv_tips;
    private com.amgcyo.cuttadon.view.dialog.v0 u1;
    UserPresenter v1;

    @BindView(R.id.view_time)
    protected TextView view_time;
    protected boolean x1;
    protected int G0 = -1;
    protected List<MkChapterContent> K0 = new ArrayList();
    public int currentChpaterId = 0;
    public boolean isAutoRead = false;
    public int speed = 4;
    protected boolean Q0 = false;
    protected boolean U0 = false;
    protected int V0 = -1;
    private BroadcastReceiver X0 = new c();
    public boolean is_screen_orientation_landscape = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private Handler f2698d1 = new e(Looper.getMainLooper());
    protected boolean j1 = false;
    private boolean t1 = false;
    private boolean w1 = false;
    PowerManager.WakeLock y1 = null;

    class a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
        final /* synthetic */ MkChapterListEvent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, MkChapterListEvent mkChapterListEvent) {
            super(obj);
            this.b = mkChapterListEvent;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(Object obj) {
            try {
                com.amgcyo.cuttadon.utils.otherutils.z.a(this.b.f(), this.b.h(), this.b.g(), new String[]{"onErrorReturn"});
                if (MkNovelBaseReaderActivity.this.E0 == null) {
                    return null;
                }
                MkNovelBaseReaderActivity.this.E0.setUpdated(8);
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    class b implements com.amgcyo.cuttadon.g.e {
        final /* synthetic */ BaseAd a;

        b(BaseAd baseAd) {
            this.a = baseAd;
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void a() {
        }

        @Override // com.amgcyo.cuttadon.g.e
        public void b() {
            MkNovelBaseReaderActivity.this.a(this.a);
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TextView textView;
            if (intent == null || intent.getAction() == null) {
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                try {
                    MkNovelBaseReaderActivity.this.horizontalBattery.setProgress((intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100));
                    MkNovelBaseReaderActivity.this.horizontalBattery.setShowBatteryNumber(true);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (!intent.getAction().equals("android.intent.action.TIME_TICK") || (textView = MkNovelBaseReaderActivity.this.view_time) == null) {
                return;
            }
            com.amgcyo.cuttadon.f.o.c(textView);
            String string = MkNovelBaseReaderActivity.this.view_time.getText().toString();
            if (!TextUtils.isEmpty(string) && "00:00".equals(string) && com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
                com.amgcyo.cuttadon.utils.comic.d.a("apcprkloertlove", (Object) 0);
                MkNovelBaseReaderActivity.this.f2697c1 = null;
            }
        }
    }

    class d implements com.lxj.xpopup.c.h {
        d() {
        }

        @Override // com.lxj.xpopup.c.h
        public void a(BasePopupView basePopupView) {
        }

        @Override // com.lxj.xpopup.c.h
        public void a(BasePopupView basePopupView, int i2) {
        }

        @Override // com.lxj.xpopup.c.h
        public void a(BasePopupView basePopupView, int i2, float f2, boolean z2) {
        }

        @Override // com.lxj.xpopup.c.h
        public boolean b(BasePopupView basePopupView) {
            return false;
        }

        @Override // com.lxj.xpopup.c.h
        public void c(BasePopupView basePopupView) {
        }

        @Override // com.lxj.xpopup.c.h
        public void d(BasePopupView basePopupView) {
        }

        @Override // com.lxj.xpopup.c.h
        public void e(BasePopupView basePopupView) {
            MkNovelBaseReaderActivity.this.a(0);
        }

        @Override // com.lxj.xpopup.c.h
        public void f(BasePopupView basePopupView) {
        }
    }

    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LinearLayout linearLayout;
            if (message.what == 3) {
                MkNovelBaseReaderActivity mkNovelBaseReaderActivity = MkNovelBaseReaderActivity.this;
                if (mkNovelBaseReaderActivity.f2697c1 != null) {
                    mkNovelBaseReaderActivity.ll_coin_tips.setVisibility(0);
                    MkNovelBaseReaderActivity.this.tv_msg.setText(String.format(Locale.getDefault(), "今日已赚%d金币\n继续阅读得%d金币", Integer.valueOf(MkNovelBaseReaderActivity.this.f2697c1.getAmount_total()), Integer.valueOf(MkNovelBaseReaderActivity.this.f2697c1.getNext_amount())));
                    MkNovelBaseReaderActivity mkNovelBaseReaderActivity2 = MkNovelBaseReaderActivity.this;
                    mkNovelBaseReaderActivity2.f2697c1 = null;
                    if (mkNovelBaseReaderActivity2.f2698d1 != null) {
                        MkNovelBaseReaderActivity.this.f2698d1.removeMessages(4);
                        MkNovelBaseReaderActivity.this.f2698d1.sendEmptyMessageDelayed(4, 3500L);
                        return;
                    }
                    return;
                }
            }
            if (message.what != 4 || (linearLayout = MkNovelBaseReaderActivity.this.ll_coin_tips) == null) {
                return;
            }
            linearLayout.setVisibility(8);
            MkNovelBaseReaderActivity.this.U();
        }
    }

    class f implements NovelSourceDrawerPopup.b {
        f() {
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void a(MkBook mkBook) {
            ((MkNovelBaseReaderActivity) ((BaseTitleBarActivity) MkNovelBaseReaderActivity.this).f2277w).getArtCatalogBeanListFragment(898, mkBook);
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void b(MkBook mkBook) {
            MkNovelBaseReaderActivity.this.getArtBookSourceList();
        }
    }

    class g implements v0.a {

        class a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
            a(Object obj) {
                super(obj);
            }

            @Override // com.amgcyo.cuttadon.j.g.g.a
            public Void a(Object obj) {
                com.amgcyo.cuttadon.utils.otherutils.g.g(com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.z.b(MkNovelBaseReaderActivity.this.E0.getBook_id())) ? R.string.clear_cache_success : R.string.clear_cache_error);
                return null;
            }
        }

        g() {
        }

        @Override // com.amgcyo.cuttadon.view.dialog.v0.a
        public void a() {
            com.amgcyo.cuttadon.j.g.b.a(new a(""));
            MkNovelBaseReaderActivity.this.finish();
        }

        @Override // com.amgcyo.cuttadon.view.dialog.v0.a
        public void b() {
            MkNovelBaseReaderActivity.this.c(true);
        }
    }

    class h extends com.amgcyo.cuttadon.j.g.h.b<String> {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f2700c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, int i2, List list) {
            super(str);
            this.b = i2;
            this.f2700c = list;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(String str) {
            int i2 = this.b;
            for (int i3 = i2 <= 0 ? 0 : i2 - 1; i3 >= 0 && i3 <= this.b + 1 && i3 < this.f2700c.size(); i3++) {
                try {
                    MkCatalog mkCatalog = (MkCatalog) this.f2700c.get(i3);
                    if (mkCatalog.isIs_content() && !mkCatalog.isCacheExists()) {
                        mkCatalog.setCacheExists(!com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.z.a(String.valueOf(MkNovelBaseReaderActivity.this.E0.getBook_id()), MkNovelBaseReaderActivity.this.E0.getReading_site_id(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()))));
                        if (!mkCatalog.isCacheExists()) {
                            String str2 = mkCatalog.getName() + " 没有缓存，需要去请求";
                            MkNovelBaseReaderActivity.this.a(mkCatalog, MkNovelBaseReaderActivity.this.E0, true);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }

    class i extends ConnectivityManager.NetworkCallback {
        i() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            MkNovelBaseReaderActivity.this.a("read_page");
            me.jessyan.art.d.f.a().a(new com.amgcyo.cuttadon.view.read.page.i(), "refresh_user_center");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(@NonNull Network network, @NonNull LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(@NonNull Network network, int i2) {
            super.onLosing(network, i2);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
        }
    }

    private class j extends BroadcastReceiver {
        private j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("total", 0);
            MkNovelBaseReaderActivity mkNovelBaseReaderActivity = MkNovelBaseReaderActivity.this;
            if (mkNovelBaseReaderActivity.s1 == null || mkNovelBaseReaderActivity.r1 == null) {
                if (MkNovelBaseReaderActivity.this.E0 == null || MkApplication.getAppContext().downloadArray.get(MkNovelBaseReaderActivity.this.E0.getBook_id()) != MkNovelBaseReaderActivity.this.E0.getBook_id()) {
                    return;
                }
                MkNovelBaseReaderActivity.this.m(intExtra);
                return;
            }
            int intExtra2 = intent.getIntExtra(NotificationCompat.CATEGORY_PROGRESS, 0);
            MkNovelBaseReaderActivity.this.r1.setProgress(intExtra2 + 1);
            if (intExtra2 == intExtra - 1) {
                MkNovelBaseReaderActivity.this.s1.setVisibility(8);
                MkNovelBaseReaderActivity.this.r1.setVisibility(8);
                MkNovelBaseReaderActivity.this.showMessage("缓存完成!");
                MkApplication.getAppContext().downloadArray.clear();
            }
        }

        /* synthetic */ j(MkNovelBaseReaderActivity mkNovelBaseReaderActivity, a aVar) {
            this();
        }
    }

    private void X() {
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f2762s.E();
            }
        });
    }

    private void Y() {
        this.q1 = new j(this, null);
        registerReceiver(this.q1, new IntentFilter("com.example.servicecallback.content"));
    }

    private NormalAdParams Z() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_bottom_ad", "csj_new_position_read_bottom", 1);
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.B);
        }
        return normalAdParamsA;
    }

    private void a0() {
        MkBook mkBook = this.E0;
        if (mkBook == null || TextUtils.isEmpty(mkBook.getReading_site_path())) {
            showMessage("参数异常!");
            com.amgcyo.cuttadon.utils.otherutils.r0.a((Activity) this);
            return;
        }
        this.T0 = AppDatabase.i().c().a(this.E0.getReading_site_id());
        this.E0.setIsChangeSiteId(false);
        this.H0 = com.amgcyo.cuttadon.view.read.page.k.c(this);
        if (this.H0.n() == 0) {
            setRequestedOrientation(0);
            this.is_screen_orientation_landscape = true;
        }
        applyKeepOn(com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_screen_keep_on", false));
        this.W0 = getReaderColorStyle();
        g0();
        setEye_protection_viewStatus(com.amgcyo.cuttadon.utils.otherutils.g.g0());
        if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
            this.rrl_fiision5.setVisibility(8);
            this.progress_circular.setVisibility(0);
            this.iv_read_jb.setVisibility(8);
            this.read_count.setVisibility(8);
            D();
        } else {
            this.rrl_fiision5.setVisibility(8);
            this.progress_circular.setVisibility(8);
            this.iv_read_jb.setVisibility(8);
            this.read_count.setVisibility(0);
        }
        a(this.W0);
        boolean zG = this.H0.g();
        this.L0 = this.H0.f();
        String str = "获取到的亮度值：" + this.L0 + " 系统：" + com.amgcyo.cuttadon.utils.otherutils.c0.c(a());
        if (zG) {
            this.L0 = com.amgcyo.cuttadon.utils.otherutils.c0.c(a());
            com.amgcyo.cuttadon.utils.otherutils.c0.b(this, -1);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.c0.c(this, this.L0);
        }
        this.currentChpaterId = this.E0.getReading_chapter_key();
        this.layoutBookView.addView(C(), new LinearLayout.LayoutParams(-1, -1));
        try {
            showUserGuideIfNeed((ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.I0 = com.amgcyo.cuttadon.utils.otherutils.g.a((Activity) this);
        this.J0 = com.amgcyo.cuttadon.utils.otherutils.g.b((Activity) this);
        try {
            R();
            O();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private boolean b0() {
        return com.amgcyo.cuttadon.utils.otherutils.g.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        BookPresenter bookPresenter = new BookPresenter(me.jessyan.art.f.e.a(this));
        this.E0.setSkipToDetailPage(false);
        this.E0.setNeedFinishActivity(z2);
        bookPresenter.a(me.jessyan.art.mvp.Message.a(this, new Object[]{this.E0}));
    }

    private void c0() {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < 21 || (connectivityManager = (ConnectivityManager) getSystemService("connectivity")) == null) {
            return;
        }
        connectivityManager.requestNetwork(new NetworkRequest.Builder().build(), new i());
    }

    private void d0() {
        try {
            if (this.y1 != null) {
                this.y1.release();
                this.y1 = null;
            }
        } catch (Exception unused) {
        }
    }

    private void e0() {
        com.amgcyo.cuttadon.database.a aVarA = ReadHistoryDatabase.b().a();
        LocalReadHistoryBean localReadHistoryBeanC = aVarA.c(this.E0.getBook_id());
        LocalReadHistoryBean localReadHistoryBean = new LocalReadHistoryBean(this.E0.getBook_id(), this.E0.getForm(), this.E0.getName(), this.E0.getAuthor(), this.E0.getImage(), com.amgcyo.cuttadon.utils.otherutils.t0.d(System.currentTimeMillis()), this.E0.getLtype(), this.E0.getStype(), this.E0.getStatus(), this.E0.getFav_count(), this.E0.getComment_number(), this.E0.getWords_number(), this.E0.getLast_chapter_name(), this.E0.getUpdated_at());
        if (localReadHistoryBeanC == null) {
            String str = "保存id为：" + aVarA.insert(localReadHistoryBean);
        }
    }

    private void f0() {
        if (!this.is_screen_orientation_landscape && f(1)) {
            boolean zH = com.amgcyo.cuttadon.app.o.c.h();
            NormalAdParams normalAdParamsZ = Z();
            if (!zH || normalAdParamsZ == null) {
                this.chapterBottomAdView.setVisibility(8);
                return;
            }
            BaseAd baseAd = normalAdParamsZ.getBaseAd();
            if (baseAd != null) {
                this.bottom_adHeight = com.amgcyo.cuttadon.h.a.d.a(this, baseAd.getPlatform(), baseAd.getStyle());
            } else {
                this.bottom_adHeight = com.amgcyo.cuttadon.h.a.d.a(this);
            }
            l(this.bottom_adHeight);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.chapterBottomAdView.getLayoutParams());
            layoutParams.height = this.bottom_adHeight;
            this.chapterBottomAdView.setBackgroundColor(this.W0.f4406j);
            this.chapterBottomAdView.setVisibility(0);
            layoutParams.addRule(12, R.id.reader_view);
            this.chapterBottomAdView.setLayoutParams(layoutParams);
            String str = "bottom_adHeight-px：" + this.bottom_adHeight + " \ndp: " + com.amgcyo.cuttadon.utils.otherutils.n.b(this.bottom_adHeight);
            b(normalAdParamsZ);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_finish_reader")
    private void finishShelf(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            finish();
        }
    }

    private void g0() {
        com.amgcyo.cuttadon.utils.otherutils.k kVar = this.W0;
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("json_colorstyle", com.amgcyo.cuttadon.utils.otherutils.r.a(new JsonColorStyle(kVar.f4406j, kVar.a, kVar.b, kVar.f4412p, kVar.f4407k)));
    }

    public static int getAd_chapter_count() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("ad_chapter_count", 100);
    }

    private void h0() {
        try {
            if (this.u1 == null) {
                this.u1 = new com.amgcyo.cuttadon.view.dialog.v0(this.f2277w, View.inflate(this.f2277w, R.layout.dialog_add_book, null), R.style.custom_dialog);
                this.u1.setCancelable(true);
                this.u1.a(this.E0, this.G);
                this.u1.a(new g());
                this.u1.show();
            } else {
                this.u1.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void i(View view) {
    }

    private void i(String str) {
        String str2 = "点击按钮，即可免费缓存后面" + this.l1 + "章节！";
        if (this.l1 >= 999999) {
            str2 = "点击按钮，即可免费缓存后面全部章节！";
        }
        this.o1.a(8);
        this.o1.a(str2, str, "开始缓存");
        this.o1.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.read.a
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                this.a.reallyStartDownloadCache();
            }
        });
        this.o1.show();
    }

    private void i0() {
        String str;
        String str2;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_363636));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_8a8a8a));
        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_ab4d4d));
        int min = this.f2697c1.getMin();
        if (min <= 0) {
            str = "不足1分钟";
        } else {
            str = min + "分钟";
        }
        if (this.f2697c1.getNext_id() <= 0) {
            str2 = "今日已阅读" + str + "；已赚" + this.f2697c1.getAmount_total() + "金币，阅读任务已完成，详细收益可到福利页面查看。";
            com.amgcyo.cuttadon.adapter.other.d dVar = this.D0;
            if (dVar != null) {
                dVar.a("任务\n完成");
                onStop();
            }
        } else {
            str2 = "今日已阅读" + str + "；已赚" + this.f2697c1.getAmount_total() + "金币，继续阅读" + this.f2697c1.getNext_min() + "分钟可得" + this.f2697c1.getNext_amount() + "金币，详细收益可到福利页面查看。";
        }
        SpannableString spannableString = new SpannableString("我的奖励：" + str2);
        int length = str2.length() + 5;
        spannableString.setSpan(foregroundColorSpan, 0, 5, 17);
        spannableString.setSpan(foregroundColorSpan2, 5, length, 17);
        SpannableString spannableString2 = new SpannableString("活动规则：每天完成阅读等任务可获得金币，金币每晚自动兑换现金，累计一定金额可提现。\n（听书、自动阅读不计算阅读时间）");
        spannableString2.setSpan(foregroundColorSpan, 0, 5, 17);
        spannableString2.setSpan(foregroundColorSpan2, 5, 41, 17);
        spannableString2.setSpan(foregroundColorSpan3, 41, 58, 17);
        if (this.Z0 != null) {
            this.f2695a1.setSpannableString1(spannableString);
            this.f2695a1.setSpannableString2(spannableString2);
            this.Z0.u();
            return;
        }
        this.f2695a1 = new IncomeTipsPopupView(this.f2277w, spannableString, spannableString2);
        a.b bVar = new a.b(this.f2277w);
        bVar.b(true);
        bVar.a(new d());
        bVar.d(false);
        bVar.e(true);
        IncomeTipsPopupView incomeTipsPopupView = this.f2695a1;
        bVar.a((BasePopupView) incomeTipsPopupView);
        this.Z0 = incomeTipsPopupView.u();
    }

    private void j0() {
        if (this.f2276v == 0 || y() == null || this.E0 == null) {
            showMessage("错误码：c1637");
            return;
        }
        if (this.n1 == null) {
            this.n1 = View.inflate(this.f2277w, R.layout.dialog_tips_dialog, null);
        }
        if (this.o1 == null) {
            this.o1 = new com.amgcyo.cuttadon.view.dialog.u0(this.f2277w, this.n1, R.style.custom_dialog);
            this.o1.setCancelable(false);
        }
        this.l1 = getAd_chapter_count();
        final BaseAd baseAdO = o();
        boolean zB0 = b0();
        if (baseAdO == null || zB0) {
            i("缓存模式");
            return;
        }
        int iA = com.amgcyo.cuttadon.sdk.utils.h.a("down_cache", "total_count");
        this.f4276y0 = p();
        this.m1 = com.amgcyo.cuttadon.utils.otherutils.g0.a().a(this.f4276y0 + "conductance", 0);
        String str = "用户今天已缓存次数：" + this.m1 + " 总次数：" + iA;
        String str2 = "观看小视频，即可缓存当前章节后面的" + this.l1 + "个章节！中途退出观看则视为放弃哦~";
        if (this.l1 >= 999999) {
            str2 = "观看小视频，即可免费缓存后面全部章节！中途退出观看则视为放弃哦~";
        }
        if (iA <= 0 || this.m1 >= iA) {
            this.o1.a(str2, "缓存模式", "看小视频缓存书籍");
            com.amgcyo.cuttadon.g.f fVar = new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.read.i
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.b(baseAdO);
                }
            };
            this.o1.a(0);
            this.o1.a(fVar);
            this.o1.show();
            return;
        }
        String str3 = "有" + iA + "次免费机会，并且今天用户已经缓存的次数小于总次数";
        i("缓存模式");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i2) {
        try {
            this.r1 = this.readerNewPanel.getReaderMenuMain().getProgressBar();
            this.r1.setMax(i2);
            this.s1 = this.readerNewPanel.getReaderMenuMain().getLl_download();
            this.r1.setVisibility(0);
            this.r1.setProgress(1);
            this.s1.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        registerReceiver(this.X0, intentFilter);
    }

    @Subscriber(mode = ThreadMode.POST, tag = "setFont")
    private void subscriberSetFontType(FontBean fontBean) {
        String str = "";
        if (fontBean != null && !TextUtils.isEmpty(fontBean.getFont_en_name())) {
            str = com.amgcyo.cuttadon.utils.otherutils.z.d() + File.separator + fontBean.getFont_en_name();
        }
        String str2 = "设置字体: " + str;
        this.H0.d(str);
        applyFont(str);
    }

    @Subscriber(mode = ThreadMode.ASYNC, tag = "tag_save_chapter_list_to_tile")
    private void subscribersaveBookChapter(MkChapterListEvent mkChapterListEvent) {
        if (mkChapterListEvent != null) {
            this.U0 = true;
            com.amgcyo.cuttadon.j.g.b.a(new a("", mkChapterListEvent));
        }
    }

    private void unregisterReceiver() {
        try {
            if (this.X0 != null) {
                unregisterReceiver(this.X0);
            }
        } catch (Exception e2) {
            String str = e2.getLocalizedMessage() + "!";
        }
    }

    protected String A() {
        MkBook mkBook = this.E0;
        return mkBook == null ? "" : mkBook.getStatus() == 1 ? com.amgcyo.cuttadon.f.o.d(R.string.read_end_book) : com.amgcyo.cuttadon.f.o.d(R.string.read_wait_update);
    }

    protected void B() {
        MkBook mkBook = this.E0;
        if (mkBook == null || this.f2276v == 0 || 8 != mkBook.getUpdated()) {
            return;
        }
        obtainPresenter().f(me.jessyan.art.mvp.Message.a(this, new Object[]{this.E0, 857}));
    }

    protected abstract View C();

    protected void D() {
        com.amgcyo.cuttadon.adapter.other.d dVar;
        this.Y0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.Y0 == null) {
            this.tv_tips.setText("登录赚钱");
        } else {
            this.tv_tips.setText("正在赚钱");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TipsInfo(1));
        arrayList.add(new TipsInfo(2));
        this.D0 = new com.amgcyo.cuttadon.adapter.other.d(arrayList, this, R.layout.item_read_tips);
        this.D0.a(getReaderColorStyle().b);
        S();
        this.tagView.setAdapter(this.D0);
        if (com.amgcyo.cuttadon.utils.otherutils.h.z0() > 0 && this.Y0 != null && (dVar = this.D0) != null) {
            dVar.a("任务\n完成");
            onStop();
        }
        this.circle_progress_bar.setMax(60);
        this.circle_progress_bar.setProgress(60);
        this.circle_progress_bar.a(R.color.translucent, getReaderColorStyle().b);
        this.progress_circular.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2757s.g(view);
            }
        });
        com.amgcyo.cuttadon.utils.otherutils.k kVar = this.W0;
        if (kVar != null) {
            this.tv_tips.setTextColor(kVar.a);
            this.rrl_fiision5.setBackground(new ColorDrawable(this.W0.f4411o));
        }
    }

    public /* synthetic */ void E() {
        showMessage("无法缓存,请退出重试!");
    }

    public /* synthetic */ void F() {
        com.amgcyo.cuttadon.view.webview.b.startActivity(a(), com.amgcyo.cuttadon.utils.otherutils.h.C0());
    }

    public /* synthetic */ void G() {
        a(0);
    }

    protected void H() {
        this.E0.setFirstLineText("");
        this.E0.setVertical_top(1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", this.E0);
        PageMode pageMode = PageMode.SCROLL;
        getConfig().a(pageMode);
        getConfig().a(pageMode.ordinal());
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelVActivity.class);
        finish();
    }

    protected void I() {
        String str;
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f2277w, true);
            return;
        }
        if (this.v1 == null) {
            this.v1 = new UserPresenter(me.jessyan.art.f.e.a(this));
        }
        if (this.E0 == null) {
            return;
        }
        if (this.M0 != null) {
            str = "《" + this.E0.getName() + "》\u3000 当前书源：" + this.E0.getReading_site_id() + "\u3000" + this.M0.getName() + "\u3000存在章节缺失，请处理!";
        } else {
            str = "章节缺失";
        }
        this.v1.s(me.jessyan.art.mvp.Message.a(this, new Object[]{Integer.valueOf(this.E0.getBook_id()), this.O0, str, 1, 7}));
    }

    protected void J() {
        if (this.f2276v == 0 || this.f2277w == null || this.E0 == null || com.amgcyo.cuttadon.utils.otherutils.g.j() == null || !me.jessyan.art.f.f.c(this.f2277w)) {
            return;
        }
        String str = "阅读到的章节：" + this.currentChpaterId;
        String str2 = "jpush_id" + this.E0.getBook_id();
        String strD = com.amgcyo.cuttadon.utils.otherutils.g0.a().d(str2);
        if (TextUtils.isEmpty(strD) || !strD.equals(com.amgcyo.cuttadon.utils.otherutils.t0.e(System.currentTimeMillis()))) {
            obtainPresenter().g(me.jessyan.art.mvp.Message.a(this, new Object[]{this.E0, Integer.valueOf(this.currentChpaterId), 1, str2}));
        }
    }

    protected abstract void K();

    protected void L() {
        if (this.G0 != -1) {
            H();
        }
    }

    protected abstract void M();

    protected void N() {
        TextView textView = this.app_des;
        if (textView != null) {
            textView.setText(com.amgcyo.cuttadon.utils.otherutils.h.g0());
        }
    }

    protected void O() {
        if (this.app_des != null) {
            f0();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ll_bottom.getLayoutParams());
            if (this.H0.n() == 0) {
                int i2 = this.I0;
                layoutParams.setMargins(i2, 0, i2, this.bottom_adHeight);
            } else {
                layoutParams.setMargins(com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), 0, com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), this.bottom_adHeight);
            }
            layoutParams.height = this.I0;
            layoutParams.addRule(12);
            this.ll_bottom.setLayoutParams(layoutParams);
            this.ll_bottom.setVisibility(0);
        }
    }

    protected void P() {
        c();
        if (getConfig() == null) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, com.amgcyo.cuttadon.utils.otherutils.g.M());
            return;
        }
        int iL = getConfig().l();
        String str = "锁屏类型是：" + iL;
        if (iL == 0) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, 300000);
            return;
        }
        if (iL == 1) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, 900000);
            return;
        }
        if (iL == 2) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, 1800000);
        } else if (iL != 4) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, com.amgcyo.cuttadon.utils.otherutils.g.M());
        } else {
            b();
        }
    }

    protected void Q() {
        if (this.read_count == null || this.E0 == null || this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
            return;
        }
        int size = y().size() - (this.currentChpaterId + 1);
        if (size > 0) {
            this.read_count.setText(String.format(Locale.getDefault(), "剩余%d章未读", Integer.valueOf(size)));
        } else {
            this.read_count.setText(A());
        }
    }

    protected void R() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.rl_top_bar.getLayoutParams());
        if (this.H0.n() == 0) {
            int i2 = this.I0;
            layoutParams2.setMargins(i2, 0, i2, 0);
        } else {
            layoutParams2.setMargins(com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), 0, com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), 0);
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
            this.I0 += com.amgcyo.cuttadon.utils.otherutils.n.a(15.0f);
        }
        layoutParams2.height = this.I0;
        layoutParams2.addRule(10);
        this.rl_top_bar.setLayoutParams(layoutParams2);
        this.rl_top_bar.bringToFront();
        this.rl_top_bar.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.chapter_name.getLayoutParams();
        if (layoutParams3 == null) {
            this.chapter_name.setText(this.E0.getName());
            return;
        }
        int iC = com.amgcyo.cuttadon.utils.otherutils.n.c(this);
        int i3 = iC / 2;
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("hasNotch", false);
        int i4 = i3 - (this.J0 / 2);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.f0() || !zA) {
            a(layoutParams3, i4);
            return;
        }
        int iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("SafeInsetLeft", 0);
        int iA2 = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("SafeInsetRight", 0);
        if (iA > 0 || iA2 <= 0) {
            a(layoutParams3, i4);
        } else {
            layoutParams3.width = i4;
            layoutParams3.leftMargin = iA2;
            this.chapter_name.setLayoutParams(layoutParams3);
        }
        if (iA <= i3 || iA2 <= iA || (layoutParams = (RelativeLayout.LayoutParams) this.read_count.getLayoutParams()) == null) {
            return;
        }
        int i5 = iA2 - iA;
        int i6 = (iC - iA2) + i5;
        String str = "右边刘海屏: " + i5 + " 新的：" + i6;
        layoutParams.rightMargin = i6;
        this.read_count.setLayoutParams(layoutParams);
    }

    protected void S() {
        if (this.D0 != null) {
            this.D0.a(com.amgcyo.cuttadon.utils.otherutils.g.j() != null ? "正在\n赚钱" : "登录\n赚钱");
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
            onStart();
        }
    }

    protected void T() {
        if (this.f2276v != 0) {
            obtainPresenter().d();
        }
        com.amgcyo.cuttadon.adapter.other.d dVar = this.D0;
        if (dVar != null) {
            dVar.a("停止\n赚钱");
        }
        onStop();
    }

    protected void U() {
        if (this.f2276v == 0 || !obtainPresenter().f3246v) {
            runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2754s.G();
                }
            });
        }
    }

    protected void V() {
        com.amgcyo.cuttadon.f.o.a(this, "切换", "取消", "温馨提示", "上下翻页模式暂不支持语音听书功能；是否切换到水平翻页模式？", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2761s.h(view);
            }
        }, (View.OnClickListener) null);
    }

    protected void W() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null && this.f2276v != 0 && com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
            obtainPresenter().a(this);
        }
        S();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity<CatalogPresenter> a() {
        return this;
    }

    public void applyAnim(int i2) {
    }

    public void applyBaiduReadVoicer() {
    }

    public void applyBaiduSpeed(int i2) {
    }

    public void applyColorStyle(String str) {
        PercentageRing percentageRing;
        String str2 = "key：" + str;
        this.W0 = getReaderColorStyle();
        g0();
        a(this.W0);
        DarkFrameLayout darkFrameLayout = this.chapterBottomAdView;
        if (darkFrameLayout != null) {
            int childCount = darkFrameLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.chapterBottomAdView.getChildAt(i2);
                if (childAt instanceof BaseSelfRenderView) {
                    ((BaseSelfRenderView) childAt).a();
                }
            }
            this.chapterBottomAdView.setBackgroundColor(this.W0.f4405i);
        }
        DarkFrameLayout darkFrameLayout2 = this.chapterContentAdView;
        if (darkFrameLayout2 != null) {
            darkFrameLayout2.setBackgroundColor(this.W0.f4405i);
        }
        FrameLayout frameLayout = this.chapterEndAdView;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(this.W0.f4405i);
        }
        this.e1 = null;
        com.amgcyo.cuttadon.utils.otherutils.k kVar = this.W0;
        if (kVar != null) {
            this.tv_tips.setTextColor(kVar.a);
            this.rrl_fiision5.setBackground(new ColorDrawable(this.W0.f4411o));
        }
        if (this.D0 == null || (percentageRing = this.circle_progress_bar) == null || !percentageRing.isShown()) {
            return;
        }
        this.D0.a(this.W0.b);
        this.circle_progress_bar.a(R.color.translucent, this.W0.b);
    }

    public void applyFont(String str) {
    }

    public void applyFontSize(int i2) {
    }

    public void applyFullscreen(int i2) {
        a(i2);
    }

    public void applyKeepOn(boolean z2) {
        if (z2) {
            b();
        } else {
            c();
        }
    }

    public void applyLayoutStyle(int i2) {
    }

    public void applyLockTime(int i2) {
        P();
    }

    public abstract void applyOrientation();

    public void applyProgress(int i2) {
    }

    public void applyStrTraditional(boolean z2) {
        getConfig().a(z2);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void chooseListenerType() {
        showTtsEngine(true);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void f(View view) {
        c(false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.w1) {
            return;
        }
        this.w1 = true;
        J();
    }

    public void finishAutoRead() {
        c();
        hideMenuPanel(true);
        setMenuState(1);
        P();
        W();
    }

    public void finishBaiduTtsSpeech() {
        P();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void finishReadActivity() {
        super.finishReadActivity();
        finish();
    }

    protected Typeface g(String str) {
        return TextUtils.isEmpty(str) ? Typeface.DEFAULT : com.amgcyo.cuttadon.view.read.page.m.b(str);
    }

    public void getArtBookSourceList() {
        if (this.h1 == null) {
            this.h1 = new BookPresenter(me.jessyan.art.f.e.a(this));
        }
        this.h1.m(me.jessyan.art.mvp.Message.a(this, new Object[]{Integer.valueOf(this.E0.getBook_id())}));
    }

    public void getArtCatalogBeanListFragment(int i2, MkBook mkBook) {
        if (mkBook != null) {
            obtainPresenter().c(me.jessyan.art.mvp.Message.a(this, new Object[]{true, mkBook, Integer.valueOf(i2)}));
            this.g1 = mkBook;
        }
    }

    public com.amgcyo.cuttadon.view.read.page.j getBasePageLoader() {
        return null;
    }

    public MkBook getBook() {
        return this.E0;
    }

    public com.amgcyo.cuttadon.view.read.page.k getConfig() {
        if (this.H0 == null) {
            this.H0 = com.amgcyo.cuttadon.view.read.page.k.c(this);
        }
        return this.H0;
    }

    public void getDownloadInfo() {
        if (z().i(this.E0.getBook_id()) != null) {
            j0();
        } else {
            this.t1 = true;
            com.amgcyo.cuttadon.f.o.a(a(), "提示", "需要加入到书架后才能缓存，是否加入?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2764s.f(view);
                }
            }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MkNovelBaseReaderActivity.i(view);
                }
            });
        }
    }

    public int getMenuState() {
        ReaderNewPanel readerNewPanel = this.readerNewPanel;
        if (readerNewPanel != null) {
            return readerNewPanel.getState();
        }
        return 1;
    }

    public abstract PageView getPageView();

    public CatalogPresenter getPresenter() {
        return new CatalogPresenter(me.jessyan.art.f.e.a(this));
    }

    public com.amgcyo.cuttadon.utils.otherutils.k getReaderColorStyle() {
        return getConfig().h();
    }

    public int getTaskCacheType() {
        return this.S0;
    }

    public int getTaskSourceType() {
        return this.R0;
    }

    public int getVoiceType() {
        return this.V0;
    }

    public /* synthetic */ void h(View view) {
        getConfig().a(PageMode.values()[0]);
        getConfig().a(0);
        k(0);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull me.jessyan.art.mvp.Message message) {
        MkCatalog mkCatalog;
        MkBook mkBook;
        super.handleMessage(message);
        U();
        int i2 = message.f21197s;
        boolean z2 = false;
        if (i2 == 832) {
            if (this.t1) {
                showMessage("添加成功，请点击缓存按钮重新开始缓存");
                this.t1 = false;
                return;
            }
            finish();
        }
        if (i2 == 857) {
            MkBook mkBook2 = (MkBook) message.f21202x;
            if (mkBook2 == null || mkBook2.getUpdated() != 0) {
                return;
            }
            this.E0 = mkBook2;
            obtainPresenter().e(me.jessyan.art.mvp.Message.a(this, new Object[]{this.E0}));
            return;
        }
        if (i2 == 878) {
            this.j1 = true;
            MkBook mkBook3 = this.E0;
            if (mkBook3 != null) {
                mkBook3.setUpdated(8);
            }
            K();
            return;
        }
        if (i2 == 1339) {
            ArrayList arrayList = (ArrayList) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList) || (mkCatalog = this.M0) == null) {
                return;
            }
            if (arrayList.contains(mkCatalog)) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MkCatalog mkCatalog2 = (MkCatalog) it.next();
                    if (!TextUtils.isEmpty(this.M0.getName()) && !TextUtils.isEmpty(mkCatalog2.getName()) && this.M0.getName().equals(mkCatalog2.getName())) {
                        if (this.M0.getUpdated_at() != mkCatalog2.getUpdated_at()) {
                        }
                    }
                }
            } else {
                z2 = true;
            }
            if (z2) {
                b(this.M0);
                return;
            }
            return;
        }
        if (i2 == 906) {
            ReadLog readLog = (ReadLog) message.f21202x;
            if (readLog != null) {
                this.f2697c1 = readLog;
                if (readLog.getAmount() > 0) {
                    h(String.format(Locale.getDefault(), "获取%d金币", Integer.valueOf(this.f2697c1.getAmount())));
                    Handler handler = this.f2698d1;
                    if (handler != null) {
                        handler.removeMessages(3);
                        this.f2698d1.sendEmptyMessageDelayed(3, com.anythink.expressad.exoplayer.i.a.f9492f);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 907) {
            ReadLog readLog2 = (ReadLog) message.f21202x;
            if (readLog2 != null) {
                this.f2697c1 = readLog2;
                i0();
            }
            hideLoading();
            return;
        }
        switch (i2) {
            case 896:
                MkBook mkBook4 = this.E0;
                if (mkBook4 != null) {
                    mkBook4.setUpdated(8);
                }
                ArrayList arrayList2 = (ArrayList) message.f21202x;
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList2) && this.e1 != null) {
                    this.e1.setAdapterData(new ArrayList<>(arrayList2));
                    break;
                }
                break;
            case 897:
                List<MkSiteBean> list = (List) message.f21202x;
                if (this.f1 != null) {
                    if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                        this.f1.a(list, getReaderColorStyle());
                    } else {
                        this.f1.g();
                    }
                }
                break;
            case 898:
                ArrayList arrayList3 = (ArrayList) message.f21202x;
                if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList3) || this.g1 == null || (mkBook = this.E0) == null) {
                    showMessage("更换书源失败，请退出重试!");
                } else {
                    mkBook.setUpdated(8);
                    this.E0.setReading_site_path(this.g1.getReading_site_path());
                    this.E0.setReading_site_id(this.g1.getReading_site_id());
                    this.E0.setSiteName(this.g1.getSiteName());
                    this.E0.setCrawl_book_id(this.g1.getCrawl_book_id());
                    this.E0.setSite_path_reload(this.g1.getSite_path_reload());
                    String str = "换源：" + this.E0.getReading_site_id();
                    int iA = AppDatabase.i().a().a(this.E0.getReading_site_id(), this.E0.getReading_site_path(), this.E0.getReading_site_id(), this.E0.getBook_id(), this.E0.getSite_path_reload(), this.E0.getCrawl_book_id());
                    this.E0.setReading_chapter_key(this.currentChpaterId);
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            MkCatalog mkCatalog3 = (MkCatalog) it2.next();
                            if (this.k1.contains(mkCatalog3.getName())) {
                                String str2 = "找到了了newid：" + mkCatalog3.getCatalogId() + " name: " + mkCatalog3.getName() + "\nchapterName:" + this.k1 + " oldid:" + this.currentChpaterId;
                                this.E0.setReading_chapter_key(mkCatalog3.getCatalogId());
                                this.M0 = mkCatalog3;
                            }
                        }
                    }
                    this.E0.setUpdated(8);
                    this.E0.setRead_begin(0);
                    this.E0.setVertical_top(0);
                    NovelSourceDrawerPopup novelSourceDrawerPopup = this.f1;
                    if (novelSourceDrawerPopup != null) {
                        novelSourceDrawerPopup.g();
                        this.f1 = null;
                    }
                    this.e1 = null;
                    if (iA > 0) {
                        showMessage("更换书源成功~");
                    }
                    finish();
                    overridePendingTransition(0, 0);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("book", this.E0);
                    com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
                }
                hideLoading();
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void hideMenu() {
        hideMenuPanel(true);
        if (this.Q0) {
            finishBaiduTtsSpeech();
        }
        if (this.isAutoRead) {
            finishAutoRead();
        }
    }

    public void hideMenuPanel(boolean z2) {
        if (this.f2276v == 0 || this.readerNewPanel == null) {
            return;
        }
        obtainPresenter().f3246v = false;
        this.readerNewPanel.a(z2);
        this.rl_top_bar.setVisibility(0);
        this.ll_bottom.setVisibility(0);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.isNeedNightModel = false;
        com.amgcyo.cuttadon.utils.otherutils.g.d((Activity) this);
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("json_colorstyle", "");
        com.amgcyo.cuttadon.h.a.c.a("position_page_ad", 0L);
        MkApplication.getAppContext().setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            getWindow().addFlags(DownloadExpSwitchCode.BUGFIX_SIGBUS_24_25);
        }
        h();
        try {
            c0();
        } catch (Exception unused) {
        }
        if (bundle != null) {
            this.E0 = (MkBook) bundle.getSerializable("book");
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                showMessage("参数异常!");
                com.amgcyo.cuttadon.utils.otherutils.r0.a((Activity) this);
                return;
            }
            this.E0 = (MkBook) extras.getSerializable("book");
            this.F0 = extras.getBoolean("from_unlock_activity", false);
            this.G0 = extras.getInt("listener_type", -1);
            this.R0 = extras.getInt("is_from_fuli_source");
            this.S0 = extras.getInt("is_from_fuli_cache");
            this.P0 = extras.getString("restoreInstanceStateText");
        }
        this.f4273v0 = g(1);
        if (this.f4273v0) {
            com.amgcyo.cuttadon.utils.otherutils.g.j(false);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.h.p(1)) {
            com.amgcyo.cuttadon.utils.otherutils.g.j(true);
        }
        com.amgcyo.cuttadon.utils.otherutils.h.t(1);
        a0();
        com.amgcyo.cuttadon.f.o.c(this.view_time);
        this.horizontalBattery.setColor(this.view_time.getCurrentTextColor());
        this.artBookDao = AppDatabase.i().a();
        Y();
        registerReceiver();
        if (this.E0 != null) {
            e0();
            if (z().i(this.E0.getBook_id()) == null) {
                com.amgcyo.cuttadon.utils.otherutils.g.g(com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.z.b(this.E0.getBook_id())) ? R.string.clear_cache_success : R.string.clear_cache_error);
            }
            B();
            com.amgcyo.cuttadon.h.h.c.a(1);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_view_v_reader_content;
    }

    public boolean isListenTobooks() {
        return false;
    }

    public boolean isPortrait() {
        return getConfig().n() == 1;
    }

    protected void j(int i2) {
        if (me.jessyan.art.f.f.a(this.f2277w) && me.jessyan.art.f.f.b(this.f2277w) && !this.f4273v0) {
            ArrayList<MkCatalog> arrayListY = y();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListY) || this.E0 == null) {
                return;
            }
            com.amgcyo.cuttadon.utils.otherutils.b0.a(new h(null, i2, arrayListY));
        }
    }

    protected void k(int i2) {
        MkBook mkBook = this.E0;
        if (mkBook == null) {
            return;
        }
        mkBook.setVertical_top(0);
        this.E0.setRead_begin(this.curPage - 1);
        this.E0.setReading_chapter_key(this.currentChpaterId);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", this.E0);
        bundle.putInt("listener_type", i2);
        if (i2 == 0) {
            bundle.putBoolean("from_unlock_activity", true);
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
        finish();
    }

    protected abstract void l(int i2);

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        ReaderNewTitle readerTitleView;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 864 && i3 == 0) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((Context) a())) {
                showMessage(com.amgcyo.cuttadon.f.o.d(R.string.request_write_success));
                Settings.System.putInt(getContentResolver(), "screen_off_timeout", 300);
                return;
            }
            return;
        }
        if (i2 == 871) {
            ReaderNewPanel readerNewPanel = this.readerNewPanel;
            if (readerNewPanel == null) {
                showMessage("处理成功，请重新点击听书按钮");
                return;
            }
            ReaderMenuMain readerMenuMain = readerNewPanel.getReaderMenuMain();
            if (readerMenuMain == null || (readerTitleView = readerMenuMain.getReaderTitleView()) == null) {
                return;
            }
            readerTitleView.a(this);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.t1 = false;
        if (this.E0 != null) {
            if (z().i(this.E0.getBook_id()) == null) {
                h0();
                return;
            }
            finish();
        }
        super.onBackPressed();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
        j jVar = this.q1;
        if (jVar != null) {
            unregisterReceiver(jVar);
        }
        DarkFrameLayout darkFrameLayout = this.chapterBottomAdView;
        if (darkFrameLayout != null && darkFrameLayout.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.chapterBottomAdView.getChildCount(); i2++) {
                View childAt = this.chapterBottomAdView.getChildAt(i2);
                if (childAt instanceof NativeExpressADView) {
                    ((NativeExpressADView) childAt).destroy();
                }
            }
        }
        FrameLayout frameLayout = this.chapterEndAdView;
        if (frameLayout != null && frameLayout.getChildCount() > 0) {
            for (int i3 = 0; i3 < this.chapterEndAdView.getChildCount(); i3++) {
                View childAt2 = this.chapterEndAdView.getChildAt(i3);
                if (childAt2 instanceof NativeExpressADView) {
                    ((NativeExpressADView) childAt2).destroy();
                }
            }
        }
        d0();
        n();
        zhugeIodEvent("[READ]关闭阅读器1");
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        T();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((Context) this)) {
            com.amgcyo.cuttadon.view.read.page.k kVarC = com.amgcyo.cuttadon.view.read.page.k.c(this);
            if (kVarC != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(this, kVarC.q());
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(this, com.amgcyo.cuttadon.utils.otherutils.g.M());
            }
        }
        a(1);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.Y0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.f4276y0 = p();
        U();
        W();
        if (this.B0) {
            b(Z());
        }
        this.B0 = false;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((Context) this)) {
            if (com.amgcyo.cuttadon.view.read.page.k.c(this) != null) {
                P();
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(this, com.amgcyo.cuttadon.utils.otherutils.g.M());
            }
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.s(1)) {
            c(1);
        }
        w();
        a("read_page");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        XMarqueeView xMarqueeView;
        super.onStart();
        if (!com.amgcyo.cuttadon.utils.otherutils.h.H0() || (xMarqueeView = this.tagView) == null) {
            return;
        }
        xMarqueeView.startFlipping();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        XMarqueeView xMarqueeView;
        super.onStop();
        if (!com.amgcyo.cuttadon.utils.otherutils.h.H0() || (xMarqueeView = this.tagView) == null) {
            return;
        }
        xMarqueeView.stopFlipping();
    }

    public void pauseAutoRead(boolean z2) {
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void reallyStartDownloadCache() {
        this.l1 = getAd_chapter_count();
        String str = "缓存章节数是：" + this.l1;
        final DownloadBean downloadBean = new DownloadBean(TbsListener.ErrorCode.INFO_CODE_BASE, this.l1);
        if (this.f2277w == null) {
            showMessage("错误码：c1638");
            return;
        }
        if (this.f2276v == 0) {
            showMessage("错误码：c1158");
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
            showMessage("错误码：c1159");
            return;
        }
        if (this.currentChpaterId >= y().size() - 1) {
            showMessage("当前是最后一章!");
            return;
        }
        downloadBean.setFrom(this.currentChpaterId + 1);
        downloadBean.setBook(this.E0);
        int i2 = MkApplication.getAppContext().downloadArray.get(this.E0.getBook_id());
        String str2 = "value:" + i2;
        if (this.E0.getBook_id() == i2) {
            showMessage("当前缓存任务已存在");
            return;
        }
        if (MkApplication.getAppContext().downloadArray.size() > 0) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.wait_pre_cache_finish));
            return;
        }
        showMessage("正在开始缓存...");
        int count = downloadBean.getCount();
        int from = downloadBean.getFrom();
        ArrayList arrayList = new ArrayList(y());
        int size = arrayList.size();
        if (size <= 0) {
            X();
            return;
        }
        String str3 = "原来大小：" + size;
        int i3 = from + count;
        if (i3 <= 0) {
            X();
            return;
        }
        if (i3 < from) {
            i3 = size;
        }
        if (i3 > size) {
            i3 = size;
        }
        if (count < 999999) {
            size = i3;
        }
        try {
            ArrayList<MkCatalog> arrayList2 = new ArrayList<>(arrayList.subList(from, size));
            String str4 = "处理后大小：" + arrayList2.size();
            downloadBean.setCatalogList(arrayList2);
            m(arrayList2.size());
            if (MkCacheBookService.B) {
                showMessage("缓存服务运行中,请重新缓存或退出APP重试！");
                this.f2277w.stopService(this.p1);
            } else {
                this.p1 = new Intent(this.f2277w, (Class<?>) MkCacheBookService.class);
                this.p1.putExtra("book_name", this.E0.getName());
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f2277w.startForegroundService(this.p1);
                } else {
                    this.f2277w.startService(this.p1);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        me.jessyan.art.d.f.a().a(downloadBean, "DownloadBean");
                    }
                }, 100L);
            }
            this.f4276y0 = p();
            int i4 = this.m1 + 1;
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(this.f4276y0 + "conductance", i4);
            com.amgcyo.cuttadon.h.h.c.a(i4 + "");
        } catch (Exception e2) {
            e2.printStackTrace();
            X();
        }
    }

    public void refreshTopBottomTipStatus() {
        RelativeLayout relativeLayout = this.rl_top_bar;
        if (relativeLayout == null || this.ll_bottom == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        this.ll_bottom.setVisibility(0);
    }

    @RequiresApi(api = 23)
    public void requestIgnoreBatteryOptimizations() {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 871);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resetVoiceTime(int i2) {
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void restartActivityPage() {
        M();
    }

    public void setEye_protection_viewStatus(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        if (z2) {
            int iA = com.amgcyo.cuttadon.utils.otherutils.c0.a(com.amgcyo.cuttadon.utils.otherutils.g.v());
            this.f2696b1 = new View(this);
            this.f2696b1.setBackgroundColor(iA);
            viewGroup.addView(this.f2696b1, new WindowManager.LayoutParams(-1, -1));
            return;
        }
        View view = this.f2696b1;
        if (view != null) {
            viewGroup.removeView(view);
            this.f2696b1 = null;
        }
    }

    public void setMenuState(int i2) {
        ReaderNewPanel readerNewPanel = this.readerNewPanel;
        if (readerNewPanel != null) {
            readerNewPanel.setState(i2);
        }
    }

    public void setSourceUrlStatus(View view, LinearLayout linearLayout, TextView textView, TextView textView2) {
        if (textView == null) {
            return;
        }
        linearLayout.setEnabled(true);
        MkBook mkBook = this.E0;
        if (mkBook != null && com.anythink.expressad.d.a.b.cZ.equals(mkBook.getReading_site_id())) {
            linearLayout.setVisibility(0);
            view.setVisibility(0);
            linearLayout.setEnabled(false);
            textView.setVisibility(0);
            textView.setText("章节内容源于聚合校对");
            textView2.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(this.N0)) {
            view.setVisibility(8);
            linearLayout.setVisibility(8);
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.T0()) {
            linearLayout.setEnabled(true);
            linearLayout.setVisibility(0);
            view.setVisibility(0);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(this.N0);
            return;
        }
        linearLayout.setVisibility(0);
        view.setVisibility(0);
        linearLayout.setEnabled(false);
        textView.setVisibility(0);
        textView2.setVisibility(8);
        textView.setText("内容由书友整理、校对并上传，如有疑问请联系我们");
    }

    public void setSystemBrightnessModeType(boolean z2) {
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.c0.b(this, -1);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.c0.c(this, this.L0);
        }
    }

    public void setTaskCacheType(int i2) {
        this.S0 = i2;
    }

    public void setTaskSourceType(int i2) {
        this.R0 = i2;
    }

    public void showMenuPanel() {
        DarkFrameLayout darkFrameLayout;
        if (this.f2276v == 0) {
            return;
        }
        obtainPresenter().f3246v = true;
        this.readerNewPanel.bringToFront();
        String str = "readBottomSwitch:" + this.readBottomSwitch;
        if (this.readBottomSwitch == 1 && this.bottom_adHeight > 0 && (darkFrameLayout = this.chapterBottomAdView) != null && darkFrameLayout.getVisibility() == 0) {
            this.chapterBottomAdView.bringToFront();
        }
        this.readerNewPanel.b();
    }

    public void showNotUseDialog() {
        com.amgcyo.cuttadon.view.dialog.b1 b1Var = new com.amgcyo.cuttadon.view.dialog.b1(a());
        b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.read.n
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                this.a.F();
            }
        });
        b1Var.show();
        b1Var.a(String.format(com.amgcyo.cuttadon.f.o.d(R.string.string_enable), "5.0.2", com.amgcyo.cuttadon.utils.otherutils.h.C0()));
    }

    public abstract void showTtsEngine(boolean z2);

    public void showTtsEngineChoiceDialog(int i2) {
        LinearLayout linearLayout = this.ll_continue_root;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            showMessage("请先看视频解锁章节!");
            return;
        }
        BaseAd baseAdQ = q();
        boolean zB0 = b0();
        if (baseAdQ == null || zB0) {
            chooseListenerType();
        } else {
            int iR = com.amgcyo.cuttadon.utils.otherutils.g.R();
            int iA = com.amgcyo.cuttadon.sdk.utils.h.a("listening_book", "interval_count");
            String str = iR + " 当天免费次数：" + iA;
            boolean z2 = iR < iA;
            boolean zL = com.amgcyo.cuttadon.app.o.c.l();
            String str2 = "次数比较：" + z2 + " 过期时间比较：" + zL;
            if (z2 || zL) {
                chooseListenerType();
            } else {
                r1 r1Var = new r1(this.f2277w);
                r1Var.a(new b(baseAdQ));
                r1Var.show();
            }
        }
        this.f4276y0 = p();
    }

    public void showUserGuideIfNeed(ViewGroup viewGroup) {
        final View viewInflate;
        if (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("sp.is.open.guider.art", false) || (viewInflate = getLayoutInflater().inflate(R.layout.view_p_right, (ViewGroup) null)) == null) {
            return;
        }
        viewGroup.addView(viewInflate, new FrameLayout.LayoutParams(-1, -1));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MkNovelBaseReaderActivity.a(viewInflate, view);
            }
        });
    }

    public void startAutoRead(int i2, int i3, boolean z2) {
        c();
        b();
    }

    public void startCatalog() {
        hideMenuPanel(true);
        if (this.e1 != null) {
            this.E0.setReading_chapter_key(this.currentChpaterId);
            this.e1.u();
            return;
        }
        a.b bVar = new a.b(this);
        bVar.e(true);
        bVar.a(false);
        NovelCatalogDrawerPopup novelCatalogDrawerPopup = new NovelCatalogDrawerPopup(this, this.E0, this.G);
        bVar.a((BasePopupView) novelCatalogDrawerPopup);
        this.e1 = (NovelCatalogDrawerPopup) novelCatalogDrawerPopup.u();
    }

    public void startSourcePopup() {
        hideMenuPanel(true);
        NovelSourceDrawerPopup novelSourceDrawerPopup = this.f1;
        if (novelSourceDrawerPopup != null) {
            novelSourceDrawerPopup.u();
            return;
        }
        a.b bVar = new a.b(this);
        bVar.a(PopupPosition.Left);
        bVar.e(true);
        bVar.a(false);
        NovelSourceDrawerPopup novelSourceDrawerPopup2 = new NovelSourceDrawerPopup(this, this.E0);
        bVar.a((BasePopupView) novelSourceDrawerPopup2);
        this.f1 = (NovelSourceDrawerPopup) novelSourceDrawerPopup2.u();
        this.f1.setListener(new f());
    }

    public void turnChapter(MkCatalog mkCatalog, boolean z2, String str) {
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void unlockContinueSuccess() {
        DarkFrameLayout darkFrameLayout;
        if (this.Q0) {
            hideMenuPanel(false);
            ReaderMenuVoice readerMenuVoice = this.readerNewPanel.getReaderMenuVoice();
            if (readerMenuVoice != null) {
                readerMenuVoice.a(true);
            }
        }
        if (this.isAutoRead) {
            finishAutoRead();
        }
        if (this.bottom_adHeight <= 0 || (darkFrameLayout = this.chapterBottomAdView) == null || darkFrameLayout.getVisibility() != 0) {
            return;
        }
        M();
    }

    protected ArrayList<MkCatalog> y() {
        return obtainPresenter().f3247w;
    }

    protected com.amgcyo.cuttadon.database.f z() {
        if (this.artBookDao == null) {
            this.artBookDao = AppDatabase.i().a();
        }
        return this.artBookDao;
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public CatalogPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new CatalogPresenter(me.jessyan.art.f.e.a(this), this);
        }
        return (CatalogPresenter) this.f2276v;
    }

    private void b(NormalAdParams normalAdParams) {
        a(this.f4265n0);
        if (!f(1) || this.bottom_adHeight <= 0) {
            return;
        }
        int refreshAdTime = getRefreshAdTime();
        String str = "使用旧版本广告方案-adPollingSecond: " + refreshAdTime;
        if (refreshAdTime > 0) {
            this.f4265n0 = com.amgcyo.cuttadon.utils.otherutils.b0.a(0L, refreshAdTime, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.amgcyo.cuttadon.activity.read.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f2752s.a((Long) obj);
                }
            });
        } else {
            a(normalAdParams);
        }
    }

    public /* synthetic */ void g(View view) {
        if (BaseTitleBarActivity.v()) {
            return;
        }
        this.Y0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.Y0 == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f2277w, true);
            return;
        }
        if (this.f2276v == 0 || this.E0 == null || !com.amgcyo.cuttadon.utils.otherutils.t0.a(System.currentTimeMillis())) {
            return;
        }
        if (this.f2697c1 != null) {
            i0();
            return;
        }
        String str = "是否语音朗读：" + this.Q0 + " 是否自动阅读：" + this.isAutoRead;
        if (this.Q0 || this.isAutoRead) {
            return;
        }
        String str2 = "" + com.amgcyo.cuttadon.utils.otherutils.h.P0();
        if (com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
            showLoading("");
            obtainPresenter().i(me.jessyan.art.mvp.Message.a(this, new Object[]{Integer.valueOf(this.E0.getBook_id()), this.O0, this.E0.getReading_site_id(), Integer.valueOf(obtainPresenter().f3249y), 907, Integer.valueOf(this.E0.getForm())}));
        }
    }

    protected void h(String str) {
        a.b bVar = new a.b(a());
        bVar.c(true);
        bVar.b(true);
        bVar.a((Boolean) true);
        bVar.a(PopupAnimation.NoAnimation);
        VideoTipsPopup videoTipsPopup = new VideoTipsPopup(this.f2277w, str);
        bVar.a((BasePopupView) videoTipsPopup);
        videoTipsPopup.u().a(2500L);
    }

    static /* synthetic */ void a(View view, View view2) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("sp.is.open.guider.art", true);
        }
    }

    private void a(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (com.amgcyo.cuttadon.j.f.b.e() && com.amgcyo.cuttadon.j.f.e.c(this)) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.f0()) {
                this.J0 = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("SafeInsetLeft", 0);
                int i3 = this.J0;
                if (i3 != 0) {
                    i2 = i3;
                }
            } else {
                i2 = (int) (i2 - this.chapter_name.getPaint().measureText("我"));
            }
        }
        layoutParams.width = i2;
        this.chapter_name.setLayoutParams(layoutParams);
    }

    private void b(final MkCatalog mkCatalog) {
        if (this.E0 == null) {
            return;
        }
        try {
            com.amgcyo.cuttadon.view.comic.k kVar = new com.amgcyo.cuttadon.view.comic.k(this.f2277w, View.inflate(this.f2277w, R.layout.dialog_reload_current_chapter, null), R.style.custom_dialog);
            kVar.setCancelable(true);
            kVar.a(this.E0, this.G);
            kVar.a(new k.a() { // from class: com.amgcyo.cuttadon.activity.read.s
                @Override // com.amgcyo.cuttadon.view.comic.k.a
                public final void a() {
                    this.a.a(mkCatalog);
                }
            });
            kVar.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Long l2) throws Exception {
        a(Z());
    }

    private void a(NormalAdParams normalAdParams) {
        if (normalAdParams != null) {
            normalAdParams.setAdHeight(com.amgcyo.cuttadon.utils.otherutils.n.b(this.bottom_adHeight));
            normalAdParams.setSpecialAdPosition(true);
            this.chapterBottomAdView.b(normalAdParams);
        }
    }

    public /* synthetic */ void b(BaseAd baseAd) {
        a(baseAd);
    }

    public /* synthetic */ void a(MkCatalog mkCatalog) {
        File fileA = com.amgcyo.cuttadon.utils.otherutils.z.a(String.valueOf(this.E0.getBook_id()), this.E0.getReading_site_id(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()));
        if (fileA.exists()) {
            fileA.delete();
        }
        a(this.E0);
    }

    private void a(MkBook mkBook) {
        Bundle bundle = new Bundle();
        mkBook.setUpdated(0);
        bundle.putSerializable("book", mkBook);
        if (com.amgcyo.cuttadon.view.read.page.m.a(this.f2277w)) {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelVActivity.class);
        }
        finish();
    }

    protected void a(com.amgcyo.cuttadon.utils.otherutils.k kVar) {
        if (kVar == null) {
            kVar = getReaderColorStyle();
            this.W0 = kVar;
        }
        this.view_time.setTextColor(kVar.b);
        this.horizontalBattery.setColor(kVar.b);
        this.read_count.setTextColor(kVar.b);
        this.app_des.setTextColor(kVar.b);
        this.chapter_page.setTextColor(kVar.b);
        this.chapter_name.setTextColor(kVar.b);
    }

    protected void a(MkCatalog mkCatalog, MkBook mkBook, boolean z2) {
        if (this.f2276v == 0 || mkCatalog == null || mkBook == null) {
            return;
        }
        obtainPresenter().d(me.jessyan.art.mvp.Message.a(a(), new Object[]{mkCatalog, mkBook, Boolean.valueOf(z2)}));
    }

    protected void a(Slippage slippage) {
        if (slippage != null && this.E0 != null) {
            String str = "解锁下一章:" + slippage.getChapterName() + " " + slippage.getBook_id() + " " + slippage.getCatalog_id();
            com.amgcyo.cuttadon.utils.otherutils.r0.a(a(), this.E0, slippage);
        } else {
            showMessage("解锁失败，请重试！");
        }
        finish();
    }
}
