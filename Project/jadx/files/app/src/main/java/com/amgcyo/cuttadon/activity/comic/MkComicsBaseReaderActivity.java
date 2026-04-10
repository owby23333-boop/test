package com.amgcyo.cuttadon.activity.comic;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.adapter.comic.MkReaderAdapterQuick;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.ComicSourceBean;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.api.presenter.CatalogPresenter;
import com.amgcyo.cuttadon.api.presenter.ComicPresenter;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.comic.ClickEvents;
import com.amgcyo.cuttadon.utils.comic.PreCacheLayoutManager;
import com.amgcyo.cuttadon.utils.comic.network.ComicsNetUtil;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.b0;
import com.amgcyo.cuttadon.utils.otherutils.c0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.comic.ComicCatalogDrawerPopup;
import com.amgcyo.cuttadon.view.comic.ComicReadMorePopupView;
import com.amgcyo.cuttadon.view.comic.DanmuSettingDialog;
import com.amgcyo.cuttadon.view.comic.ReadMoreSettingDialog;
import com.amgcyo.cuttadon.view.comic.ReverseSeekBar;
import com.amgcyo.cuttadon.view.comic.k;
import com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager;
import com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.ZoomableRecyclerView;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.dialog.v0;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.amgcyo.cuttadon.view.popupview.SendDanmuBottomPopup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.kathline.horizontalrefresh.HorizontalRefreshLayout;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BottomView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.mardous.discreteseekbar.DiscreteSeekBar;
import com.zwb.danmaku.MkDanmakuView;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import me.jessyan.art.mvp.Message;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class MkComicsBaseReaderActivity extends MyRewardBaseAdActivity<ComicPresenter> implements DiscreteSeekBar.g, com.amgcyo.cuttadon.view.comic.m.e, com.github.chrisbanes.photoview.i, com.amgcyo.cuttadon.view.comic.m.c, com.amgcyo.cuttadon.g.i {
    protected String D0;
    protected Point D1;
    protected int E0;
    protected float E1;
    protected com.amgcyo.cuttadon.utils.comic.a F0;
    protected float F1;
    protected String G0;
    protected com.amgcyo.cuttadon.database.f H0;
    protected int I0;
    private Animation I1;
    protected MkBook J0;
    private Animation J1;
    protected boolean K0;
    private Animation K1;
    protected MkReaderAdapterQuick L0;
    private Animation L1;
    protected PreCacheLayoutManager M0;
    private Animation M1;
    protected int N0;
    protected int O0;
    v0 P1;
    protected boolean Q1;
    protected int S0;
    protected ReadMoreSettingDialog T0;
    protected DanmuSettingDialog U0;
    private boolean V0;
    protected boolean X0;
    protected boolean Y0;
    protected boolean Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    protected boolean f2357a1;

    @BindView(R.id.ad_comics_bottom)
    protected AdFrameLayout ad_comics_bottom;

    @BindView(R.id.ad_comics_top)
    protected AdFrameLayout ad_comics_top;
    public float alpha;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    protected boolean f2358b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    protected boolean f2359c1;

    @BindView(R.id.cb_brightness)
    CheckBox cb_brightness;
    public int currentId;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    protected float f2360d1;

    @BindView(R.id.danmu_hint)
    TextView danmu_hint;

    @BindView(R.id.danmu_num)
    TextView danmu_num;
    protected RecyclerView.ItemDecoration e1;
    private int[] f1;

    @BindView(R.id.fb_comment)
    FloatingActionButton fbNightModel;

    @BindView(R.id.fl_brightness)
    FrameLayout fl_brightness;

    @BindView(R.id.fl_p)
    FrameLayout fl_p;

    @BindView(R.id.fr_comic_loading)
    FrameLayout fr_comic_loading;
    private int[] g1;
    protected boolean h1;
    protected int i1;

    @BindView(R.id.ib_more)
    ImageView ib_more;
    public boolean isDanmuOpen;

    @BindView(R.id.iv_auto)
    ImageView ivAuto;

    @BindView(R.id.iv_danmu_states)
    ImageView iv_danmu_states;

    @BindView(R.id.iv_loading)
    ImageView iv_loading;
    protected int j1;
    protected List<ZymkChapter> k1;
    protected TwinklingRefreshLayout l1;

    @BindView(R.id.layout_danmu)
    RelativeLayout layout_danmu;
    public int level;

    @BindView(R.id.ll_p)
    LinearLayout llP;

    @BindView(R.id.ll_read_speed_p)
    LinearLayout llReadSpeedP;

    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;

    @BindView(R.id.ll_bottom_root)
    LinearLayout ll_bottom_root;

    @BindView(R.id.ll_danmu_swtich)
    LinearLayout ll_danmu_swtich;

    @BindView(R.id.ll_fail)
    LinearLayout ll_fail;

    @BindView(R.id.ll_loading)
    LinearLayout ll_loading;

    @BindView(R.id.ll_top)
    LinearLayout ll_top;
    protected HorizontalRefreshLayout m1;

    @BindView(R.id.reader_battery)
    TextView mBatteryText;

    @BindView(R.id.reader_chapter_page)
    TextView mChapterPage;

    @BindView(R.id.reader_chapter_title)
    TextView mChapterTitle;

    @BindView(R.id.reader_info_layout)
    View mInfoLayout;

    @BindView(R.id.reader_box)
    RelativeLayout mReaderBox;

    @BindView(R.id.reader_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.reader_seek_bar_p)
    ReverseSeekBar mSeekBarP;
    public int mode;
    public int orientation;

    @BindView(R.id.pb_battery)
    ProgressBar pb_battery;

    @BindView(R.id.rel_danmu_button)
    RelativeLayout rel_danmu_button;
    protected boolean s1;

    @BindView(R.id.sb_read_speed_p)
    SeekBar sbReadSpeedP;

    @BindView(R.id.sb_brightness)
    SeekBar sb_brightness;
    public com.amgcyo.cuttadon.utils.comic.e scrollHelper;
    public int speed;
    private UserPresenter t1;
    public int tempCurrentId;
    public int turn;

    @BindView(R.id.tv_auto)
    TextView tv_auto;

    @BindView(R.id.tv_load_tip)
    TextView tv_load_fail_tip;

    @BindView(R.id.tv_loading_msg)
    TextView tv_loading_msg;

    @BindView(R.id.tv_menu_add_book)
    TextView tv_menu_add_book;

    @BindView(R.id.tv_net)
    TextView tv_net;

    @BindView(R.id.tv_seek_p)
    TextView tv_seek_p;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_unread)
    TextView tv_unread;
    private CatalogPresenter u1;
    private BasePopupView w1;
    private BookPresenter x1;
    ComicCatalogDrawerPopup y1;
    BasePopupView z1;
    protected int P0 = 1;
    protected int Q0 = 1;
    protected int R0 = 0;
    private boolean W0 = true;
    private BroadcastReceiver n1 = new d();
    private SeekBar.OnSeekBarChangeListener o1 = new e();
    private boolean p1 = false;
    private boolean q1 = true;
    private Handler r1 = new Handler(Looper.getMainLooper());
    private boolean v1 = false;
    private boolean[] A1 = {false, false};
    private int[] B1 = {7, 8};
    private float C1 = 0.3f;
    private RectF G1 = null;
    protected String H1 = "myTag";
    protected int N1 = 0;
    private int O1 = 8;

    class a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
        final /* synthetic */ ZymkChapter b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, ZymkChapter zymkChapter) {
            super(obj);
            this.b = zymkChapter;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(Object obj) {
            MkComicsBaseReaderActivity.this.obtainPresenter().c(Message.a(MkComicsBaseReaderActivity.this, new Object[]{this.b, 3, Integer.valueOf(MkComicsBaseReaderActivity.this.I0)}));
            return null;
        }
    }

    class b implements v0.a {
        b() {
        }

        @Override // com.amgcyo.cuttadon.view.dialog.v0.a
        public void a() {
            com.amgcyo.cuttadon.j.a.e.a(z.a(MkComicsBaseReaderActivity.this.J0.getBook_id()));
            MkComicsBaseReaderActivity.this.finish();
        }

        @Override // com.amgcyo.cuttadon.view.dialog.v0.a
        public void b() {
            MkComicsBaseReaderActivity.this.d(true);
        }
    }

    class c extends com.amgcyo.cuttadon.j.g.h.a<String, Boolean> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2362c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2) {
            super(str);
            this.f2362c = str2;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Boolean a(String str) {
            return Boolean.valueOf(z.b(this.f2362c));
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            MkComicsBaseReaderActivity.this.hideLoading();
            if (bool.booleanValue()) {
                MkComicsBaseReaderActivity.this.showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_success));
                MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
                mkComicsBaseReaderActivity.b(mkComicsBaseReaderActivity.J0);
                return;
            }
            MkComicsBaseReaderActivity.this.showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error));
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                String str = intExtra + "%";
                TextView textView = MkComicsBaseReaderActivity.this.mBatteryText;
                if (textView != null) {
                    textView.setText(str);
                }
                ProgressBar progressBar = MkComicsBaseReaderActivity.this.pb_battery;
                if (progressBar != null) {
                    progressBar.setProgress(intExtra);
                }
            }
        }
    }

    class e implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (z2) {
                MkComicsBaseReaderActivity.this.clickButton();
                MkComicsBaseReaderActivity.this.setScrollHelperSpeed(16000 - ((i2 * 15000) / 100));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = MkComicsBaseReaderActivity.this.sbReadSpeedP;
            if (seekBar2 != null) {
                seekBar2.setProgress(progress);
            }
        }
    }

    class f extends com.lcodecore.tkrefreshlayout.f {
        f() {
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void a(TwinklingRefreshLayout twinklingRefreshLayout) {
            MkComicsBaseReaderActivity.this.Q();
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void b(TwinklingRefreshLayout twinklingRefreshLayout) {
            String str = MkComicsBaseReaderActivity.this.H1;
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            View view = mkComicsBaseReaderActivity.mInfoLayout;
            if (view != null && !mkComicsBaseReaderActivity.f2359c1) {
                view.setVisibility(8);
            }
            MkComicsBaseReaderActivity.this.s(2);
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void c(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity;
            View view;
            super.c(twinklingRefreshLayout, f2);
            if (f2 > 1.0f || (view = (mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this).mInfoLayout) == null || mkComicsBaseReaderActivity.f2359c1) {
                return;
            }
            view.setVisibility(0);
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void d() {
            super.d();
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            View view = mkComicsBaseReaderActivity.mInfoLayout;
            if (view == null || mkComicsBaseReaderActivity.f2359c1) {
                return;
            }
            view.setVisibility(0);
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void a(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
            super.a(twinklingRefreshLayout, f2);
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            View view = mkComicsBaseReaderActivity.mInfoLayout;
            if (view == null || mkComicsBaseReaderActivity.f2359c1) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class g implements com.kathline.horizontalrefresh.a {
        g() {
        }

        @Override // com.kathline.horizontalrefresh.a
        public void a() {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            if (mkComicsBaseReaderActivity.s1) {
                mkComicsBaseReaderActivity.Q();
            } else {
                mkComicsBaseReaderActivity.s(3);
            }
        }

        @Override // com.kathline.horizontalrefresh.a
        public void b() {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            if (mkComicsBaseReaderActivity.s1) {
                mkComicsBaseReaderActivity.s(3);
            } else {
                mkComicsBaseReaderActivity.Q();
            }
        }
    }

    class h extends RecyclerView.OnScrollListener {
        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            mkComicsBaseReaderActivity.N0 = i2;
            mkComicsBaseReaderActivity.O0 = i3;
        }
    }

    class i implements SeekBar.OnSeekBarChangeListener {
        i() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            if (z2) {
                MkComicsBaseReaderActivity.this.sb_brightness.setProgress(i2);
                c0.c(MkComicsBaseReaderActivity.this.a(), i2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MkComicsBaseReaderActivity.this.cb_brightness.setChecked(false);
            MkComicsBaseReaderActivity.this.F0.c("key_brightness", seekBar.getProgress());
        }
    }

    class j implements com.amgcyo.cuttadon.view.comic.m.a {
        j() {
        }

        @Override // com.amgcyo.cuttadon.view.comic.m.a
        public void a() {
            MkComicsBaseReaderActivity.this.q(923);
        }

        @Override // com.amgcyo.cuttadon.view.comic.m.a
        public void a(int i2) {
            MkBook mkBook = MkComicsBaseReaderActivity.this.J0;
            if (mkBook == null) {
                return;
            }
            mkBook.setUpdated(8);
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            mkComicsBaseReaderActivity.currentId = i2;
            mkComicsBaseReaderActivity.P0 = 0;
            mkComicsBaseReaderActivity.J0.setRead_begin(0);
            MkComicsBaseReaderActivity.this.J0.setReading_chapter_key(i2);
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity2 = MkComicsBaseReaderActivity.this;
            mkComicsBaseReaderActivity2.b(mkComicsBaseReaderActivity2.J0);
        }
    }

    class k extends com.amgcyo.cuttadon.j.g.h.b<Object> {
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZymkChapter f2365c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Object obj, int i2, ZymkChapter zymkChapter) {
            super(obj);
            this.b = i2;
            this.f2365c = zymkChapter;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(Object obj) {
            ComicPresenter comicPresenterObtainPresenter = MkComicsBaseReaderActivity.this.obtainPresenter();
            MkComicsBaseReaderActivity mkComicsBaseReaderActivity = MkComicsBaseReaderActivity.this;
            comicPresenterObtainPresenter.b(Message.a(mkComicsBaseReaderActivity, new Object[]{Integer.valueOf(mkComicsBaseReaderActivity.I0), Integer.valueOf(this.b), Integer.valueOf(MkComicsBaseReaderActivity.this.mode), this.f2365c, Boolean.valueOf(MkComicsBaseReaderActivity.this.q1)}));
            return null;
        }
    }

    private void A0() {
    }

    private void B0() {
        this.q1 = f(3);
        if (this.q1) {
            boolean zH = com.amgcyo.cuttadon.app.o.c.h();
            NormalAdParams normalAdParamsL0 = l0();
            if (!zH || normalAdParamsL0 == null) {
                this.ad_comics_bottom.setVisibility(8);
                return;
            }
            BaseAd baseAd = normalAdParamsL0.getBaseAd();
            if (baseAd != null) {
                this.bottom_adHeight = com.amgcyo.cuttadon.h.a.d.a(this, baseAd.getPlatform(), baseAd.getStyle());
            } else {
                this.bottom_adHeight = com.amgcyo.cuttadon.h.a.d.a(this);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ad_comics_bottom.getLayoutParams());
            int i2 = this.bottom_adHeight;
            layoutParams.height = i2;
            layoutParams.gravity = 80;
            com.amgcyo.cuttadon.f.o.a(this.mReaderBox, 0, 0, 0, i2);
            this.ad_comics_bottom.setVisibility(0);
            this.ad_comics_bottom.setLayoutParams(layoutParams);
            String str = "bottom_adHeight-px：" + this.bottom_adHeight + " \ndp: " + com.amgcyo.cuttadon.utils.otherutils.n.b(this.bottom_adHeight);
            b(normalAdParamsL0);
        }
    }

    private void C0() {
        this.ll_danmu_swtich.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f2421s.P();
            }
        });
    }

    private void D0() {
        try {
            if (this.P1 == null) {
                this.P1 = new v0(this.f2277w, View.inflate(this.f2277w, R.layout.dialog_add_book, null), R.style.custom_dialog);
                this.P1.setCancelable(true);
                this.P1.a(this.J0, this.G);
                this.P1.a(new b());
                this.P1.show();
            } else {
                this.P1.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void E0() {
        FrameLayout frameLayout = this.fl_brightness;
        if (frameLayout == null || frameLayout.isShown()) {
            return;
        }
        this.fl_brightness.setVisibility(0);
    }

    public static Intent createIntent(Context context, MkBook mkBook, int i2, int i3) {
        Intent intentA = a(context, i2, i3);
        intentA.putExtra("book", mkBook);
        intentA.putExtra("cimoc.intent.extra.EXTRA_MODE", i2);
        intentA.putExtra("cimoc.intent.extra.EXTRA_ORIENTATION", i3);
        return intentA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z2) {
        if (this.x1 == null) {
            this.x1 = new BookPresenter(me.jessyan.art.f.e.a(this));
        }
        this.J0.setSkipToDetailPage(false);
        this.J0.setNeedFinishActivity(z2);
        this.x1.a(Message.a(this, new Object[]{this.J0}));
    }

    private void e(boolean z2) {
        int height = (this.ll_bottom_root.getHeight() - this.rel_danmu_button.getHeight()) - this.rel_danmu_button.getBottom();
        if (z2) {
            v(this.i1 / 2);
            height = 0;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ll_bottom_root, "translationY", height);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_finish_reader")
    private void finishShelf(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            finish();
        }
    }

    private void i0() {
        if (this.L0 != null) {
            final View viewE = E();
            this.L0.a(viewE);
            viewE.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2409s.f(viewE);
                }
            });
            if (L()) {
                viewE.setBackgroundColor(-1);
            } else {
                viewE.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.color_5_0c000000));
            }
            this.L0.a("");
            this.L0.n();
            this.L0.b(false);
        }
    }

    private void j0() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1)) {
            return;
        }
        if (this.tempCurrentId >= this.k1.size()) {
            this.tempCurrentId = this.k1.size() - 1;
        }
        ZymkChapter zymkChapter = this.k1.get(this.tempCurrentId);
        String str = "标题：" + zymkChapter.getName();
        String strE = z.e(this.I0 + z.a + zymkChapter.getUpdated_at() + "_" + zymkChapter.getPath().replaceAll("/", "_").replaceAll(".html", ""));
        StringBuilder sb = new StringBuilder();
        sb.append("comicPath:");
        sb.append(strE);
        sb.toString();
        File file = new File(strE, "comic_32767.comic");
        if (file.exists()) {
            file.delete();
        }
    }

    private void k0() {
        if (this.U0 == null) {
            if (this.W0) {
                this.U0 = new DanmuSettingDialog(this, 2131821359);
            } else {
                this.U0 = new DanmuSettingDialog(this, R.style.sheetDialog);
            }
        }
        this.U0.show();
    }

    private NormalAdParams l0() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("comics_position_bottom_ad", "csj_new_position_read_bottom_comics", 3);
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.B);
        }
        return normalAdParamsA;
    }

    private ZymkChapter m0() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1)) {
            return null;
        }
        if (this.tempCurrentId >= this.k1.size()) {
            this.tempCurrentId = this.k1.size() - 1;
        }
        return this.k1.get(this.tempCurrentId);
    }

    private NormalAdParams n0() {
        return com.amgcyo.cuttadon.sdk.utils.e.d("adkey_comics_unlock_next");
    }

    private void o0() {
        if (this.mInfoLayout != null) {
            final int iB = com.amgcyo.cuttadon.utils.otherutils.n.b(16.0f);
            if (this.f2359c1) {
                this.mInfoLayout.setVisibility(8);
                v(this.i1);
                return;
            }
            this.mInfoLayout.setVisibility(0);
            int i2 = this.i1;
            if (i2 == 0) {
                this.mInfoLayout.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2428s.j(iB);
                    }
                });
                return;
            }
            v(i2);
            if (L()) {
                RecyclerView recyclerView = this.mRecyclerView;
                int i3 = this.i1;
                com.amgcyo.cuttadon.f.o.a(recyclerView, 0, -i3, 0, i3 - iB);
            }
        }
    }

    private void p(int i2) {
        switch (i2) {
            case 1:
                if (L() || this.Z0) {
                    S();
                } else {
                    b0();
                }
                break;
            case 2:
                if (L() || this.Z0) {
                    nextPage();
                } else {
                    b0();
                }
                break;
            case 3:
                A0();
                break;
            case 4:
                Q();
                break;
            case 6:
                exitReader();
                break;
            case 7:
                f0();
                break;
            case 8:
                g0();
                break;
            case 9:
                e0();
                break;
            case 10:
                c0();
                break;
            case 11:
                b0();
                break;
            case 12:
                T();
                break;
        }
    }

    private void p0() {
        if (this.u1 == null) {
            this.u1 = new CatalogPresenter(me.jessyan.art.f.e.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1) && this.J0 != null) {
            obtainPresenter().d(Message.a(this, new Object[]{this.J0.getList_path(), Integer.valueOf(this.I0), Integer.valueOf(this.J0.getUpdated()), Integer.valueOf(i2), Integer.valueOf(this.currentId), false}));
            return;
        }
        ComicCatalogDrawerPopup comicCatalogDrawerPopup = this.y1;
        if (comicCatalogDrawerPopup != null) {
            comicCatalogDrawerPopup.setAdapterData(this.k1);
        }
    }

    private void q0() {
        this.M0 = new PreCacheLayoutManager(this);
        this.M0.setOrientation(this.turn == 2 ? 1 : 0);
        this.M0.setReverseLayout(this.s1);
        this.M0.a(2);
    }

    private void r(int i2) {
        ((com.amgcyo.cuttadon.k.c.a) new ViewModelProvider(this).get(com.amgcyo.cuttadon.k.c.a.class)).a(i2).observe(this, new Observer() { // from class: com.amgcyo.cuttadon.activity.comic.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.a.a((MkBook) obj);
            }
        });
    }

    private void r0() {
        this.X0 = this.F0.a("pref_reader_ban_double_click", false);
        String book_text_filed_1 = this.J0.getBook_text_filed_1();
        if (TextUtils.isEmpty(book_text_filed_1)) {
            book_text_filed_1 = String.valueOf(this.I0);
        }
        this.L0 = new MkReaderAdapterQuick(new LinkedList(), book_text_filed_1);
        this.L0.a(this, this, this.G);
        this.L0.a((com.github.chrisbanes.photoview.i) this);
        this.f2360d1 = this.F0.b("pref_reader_scale_factor", 200) * 0.01f;
        this.L0.b(this.f2360d1);
        this.L0.setHasStableIds(true);
        this.L0.a((com.chad.library.adapter.base.e.a) new com.amgcyo.cuttadon.view.comic.i(L()));
        this.L0.d(!this.X0);
        this.L0.f(this.turn == 2);
        this.L0.c(this.isDanmuOpen);
        this.L0.a(this.alpha);
        this.L0.f(this.level);
        this.L0.h(this.speed);
        this.L0.e(this.orientation == 1);
        this.L0.q();
        this.L0.a(new BaseQuickAdapter.f() { // from class: com.amgcyo.cuttadon.activity.comic.l
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f2420s.a(baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1)) {
            return;
        }
        int i3 = this.R0;
        if (i3 > 0 && this.currentId >= i3 - 1) {
            if (this.J0 == null || this.f2276v == 0) {
                return;
            }
            obtainPresenter().a(Message.a(this, new Object[]{this.J0, 909}));
            return;
        }
        if (this.r1 == null) {
            this.r1 = new Handler(Looper.getMainLooper());
        }
        String str = "max:" + this.Q0 + " delayMills 10";
        final ZymkChapter zymkChapter = this.k1.get(this.currentId + 1);
        if (zymkChapter == null || !b(zymkChapter)) {
            a(i2, 10L);
            return;
        }
        final NormalAdParams normalAdParamsN0 = n0();
        if (normalAdParamsN0 == null) {
            a(i2, 10L);
            return;
        }
        String str2 = "setReardAdData:" + this.Q0 + " 进度：" + this.P0;
        this.r1.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2411s.a(zymkChapter, normalAdParamsN0, i2);
            }
        }, 10L);
    }

    private void s0() {
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(this.M0);
        this.mRecyclerView.setAdapter(this.L0);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(10);
        this.mRecyclerView.setDrawingCacheEnabled(true);
        this.mRecyclerView.setDrawingCacheQuality(1048576);
        this.mRecyclerView.addOnScrollListener(new h());
        int iF = F();
        String str = "comicsNext_button_switch:" + iF;
        if (iF <= 0) {
            this.L0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.comic.c
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
                public final void a() {
                    this.a.O();
                }
            }, this.mRecyclerView);
        }
    }

    private void startCatalog() {
        MkBook mkBook = this.J0;
        if (mkBook == null || TextUtils.isEmpty(mkBook.getList_path())) {
            return;
        }
        if (this.y1 == null) {
            a.b bVar = new a.b(this);
            bVar.e(true);
            bVar.a(false);
            ComicCatalogDrawerPopup comicCatalogDrawerPopup = new ComicCatalogDrawerPopup(this, this.J0, this.G, new j());
            bVar.a((BasePopupView) comicCatalogDrawerPopup);
            this.y1 = (ComicCatalogDrawerPopup) comicCatalogDrawerPopup.u();
            return;
        }
        String str = "currentId:" + this.currentId;
        this.J0.setReading_chapter_key(this.currentId);
        this.y1.u();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "comic_finish_activity")
    private void subscriberFinishActivity(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            finish();
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "comic_tag_finish_activity")
    private void subscriberfinishActivity(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            finish();
            this.O1 = mkCommentEvent.f();
        }
    }

    private void t(int i2) {
        this.currentId = i2;
        showLoading(com.amgcyo.cuttadon.f.o.d(R.string.reader_load_prev));
        a(i2, 1);
    }

    private void t0() {
        this.mSeekBarP.setReverse(this.turn == 1);
        this.mSeekBarP.setOnProgressChangeListener(this);
        this.sb_brightness.setMax(255);
        int iC = c0.c(this);
        boolean zA = this.F0.a("key_brightness_system", true);
        final int iB = this.F0.b("key_brightness", iC);
        this.cb_brightness.setChecked(zA);
        String str = "亮度值：" + iB + " 是否是系统亮度：" + zA;
        String str2 = "是不是自动调节亮度：" + c0.a(this) + " 当前亮度值：" + c0.b(this) + "   " + iC;
        if (zA) {
            this.sb_brightness.setProgress(iC);
            c0.b(this, -1);
        } else {
            c0.c(this, iB);
            this.sb_brightness.setProgress(iB);
        }
        this.sb_brightness.setOnSeekBarChangeListener(new i());
        this.cb_brightness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.activity.comic.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.a.a(iB, compoundButton, z2);
            }
        });
        this.scrollHelper = new com.amgcyo.cuttadon.utils.comic.e(this, 16000);
        this.scrollHelper.a(8500);
        this.sbReadSpeedP.setOnSeekBarChangeListener(this.o1);
        this.sbReadSpeedP.setProgress(50);
    }

    private void u(int i2) {
        MkReaderAdapterQuick mkReaderAdapterQuick;
        HashMap<String, MkDanmakuView> mapS;
        if (u0() && (mkReaderAdapterQuick = this.L0) != null && (mapS = mkReaderAdapterQuick.s()) != null && mapS.size() > 0) {
            Iterator<Map.Entry<String, MkDanmakuView>> it = mapS.entrySet().iterator();
            while (it.hasNext()) {
                MkDanmakuView value = it.next().getValue();
                if (value != null) {
                    if (i2 == 0) {
                        value.c();
                    } else if (i2 == 1) {
                        value.d();
                    } else if (i2 == 2) {
                        value.a();
                    }
                }
            }
        }
    }

    private boolean u0() {
        return com.amgcyo.cuttadon.utils.otherutils.g.l0();
    }

    private void v(int i2) {
        RelativeLayout relativeLayout = this.rel_danmu_button;
        if (relativeLayout != null) {
            com.amgcyo.cuttadon.f.o.a(relativeLayout, this.j1, 0, 0, i2);
        }
    }

    private void v0() {
        NormalAdParams normalAdParamsA;
        this.q1 = f(3);
        String str = "oldAdModel:" + this.q1;
        if (this.q1 && com.amgcyo.cuttadon.h.a.c.b("comics_position_top_chapter_ad") && (normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("comics_position_top_chapter_ad", "csj_new_position_lists", 3)) != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.I);
            this.ad_comics_top.b(normalAdParamsA);
        }
    }

    private void w(int i2) {
        RelativeLayout relativeLayout = this.rel_danmu_button;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
        }
    }

    private void w0() {
        if (this.J0 == null) {
            showMessage("参数异常，请重试！");
            finish();
        } else {
            j0();
            this.O1 = 0;
            this.J0.setUpdated(0);
            b(this.J0);
        }
    }

    private void x0() {
        this.J0.setRead_begin(this.P0);
        this.J0.setReading_chapter_key(this.currentId);
        r0.b(this.f2277w, this.J0);
    }

    private void y0() {
        if (this.T0 == null) {
            if (this.W0) {
                this.T0 = new ReadMoreSettingDialog(this, 2131821359);
            } else {
                this.T0 = new ReadMoreSettingDialog(this, R.style.sheetDialog);
            }
        }
        this.T0.show();
    }

    private void z0() {
        com.amgcyo.cuttadon.database.a aVarA = ReadHistoryDatabase.b().a();
        LocalReadHistoryBean localReadHistoryBeanC = aVarA.c(this.J0.getBook_id());
        LocalReadHistoryBean localReadHistoryBean = new LocalReadHistoryBean(32767, this.J0.getBook_id(), this.J0.getForm(), this.J0.getName(), this.J0.getAuthor(), this.J0.getImage(), t0.d(System.currentTimeMillis()), this.J0.getList_path(), this.J0.getList_reload_path(), this.J0.getStatus(), this.J0.getComment_number(), this.J0.getChapter_count(), this.J0.getLast_chapter_name(), this.J0.getUpdated_at());
        if (localReadHistoryBeanC == null) {
            String str = "保存阅读历史记录id为：" + aVarA.insert(localReadHistoryBean);
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            p0();
        }
    }

    protected void A() {
        MkBook mkBook = this.J0;
        if (mkBook == null) {
            showMessage("错误码：c3031");
            finish();
            return;
        }
        if (TextUtils.isEmpty(mkBook.getList_path())) {
            int retryCount = this.J0.getRetryCount();
            String str = "重试次数：" + retryCount;
            if (retryCount > 1) {
                showMessage("错误码：c3032");
                finish();
                return;
            }
            showMessage("参数异常，正在重新请求数据...");
            if (this.x1 == null) {
                this.x1 = new BookPresenter(me.jessyan.art.f.e.a(this));
            }
            this.I0 = this.J0.getBook_id();
            this.x1.l(Message.a(this, new Object[]{Integer.valueOf(this.I0), 3}));
        }
    }

    protected abstract int B();

    protected int C() {
        PreCacheLayoutManager preCacheLayoutManager = this.M0;
        if (preCacheLayoutManager == null) {
            return -1;
        }
        int iFindFirstCompletelyVisibleItemPosition = preCacheLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (iFindFirstCompletelyVisibleItemPosition != -1) {
            String str = "返回当前第一个完全可见Item的position:" + iFindFirstCompletelyVisibleItemPosition;
            return iFindFirstCompletelyVisibleItemPosition;
        }
        int iFindFirstVisibleItemPosition = this.M0.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.M0.findLastVisibleItemPosition();
        int i2 = iFindFirstVisibleItemPosition;
        int i3 = i2;
        int i4 = 0;
        while (i2 <= iFindLastVisibleItemPosition) {
            View childAt = this.M0.getChildAt(i2 - iFindFirstVisibleItemPosition);
            if (childAt != null) {
                childAt.getLocationOnScreen(new int[2]);
                int height = childAt.getHeight();
                Rect rect = new Rect();
                childAt.getLocalVisibleRect(rect);
                if (rect.top > 0 && rect.left == 0 && rect.bottom == height) {
                    String str2 = i2 + "  上面被遮挡  ";
                } else if (rect.top <= 0 || rect.left != 0 || rect.bottom >= height) {
                    String str3 = i2 + "  没有被遮挡  " + rect.bottom + " height:" + height;
                    i3 = i2;
                } else {
                    String str4 = i2 + "  下面被遮挡  ";
                }
                int i5 = rect.bottom - rect.top;
                if (i5 > i4) {
                    i3 = i2;
                    i4 = i5;
                }
            }
            i2++;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    protected String D() {
        MkBook mkBook = this.J0;
        return mkBook == null ? "" : mkBook.getStatus() == 1 ? com.amgcyo.cuttadon.f.o.d(R.string.read_end_book) : com.amgcyo.cuttadon.f.o.d(R.string.read_wait_update);
    }

    @SuppressLint({"SetTextI18n"})
    protected View E() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_chapter_endview, (ViewGroup) null);
        AdFrameLayout adFrameLayout = (AdFrameLayout) viewInflate.findViewById(R.id.chapter_last_page_ad);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_root);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_book_status);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_desc_status);
        if (this.J0.getStatus() == 1) {
            textView.setText("全  书  完");
            textView2.setText("THE    END");
        } else {
            textView.setText("作  者  努  力  更  新  中");
            textView2.setText("后 面 更 精 彩    晚 点 再 来 看 看 吧");
        }
        CommonShapeButton commonShapeButton = (CommonShapeButton) viewInflate.findViewById(R.id.shape_hy);
        commonShapeButton.setText("换书源");
        CommonShapeButton commonShapeButton2 = (CommonShapeButton) viewInflate.findViewById(R.id.shape_sj);
        commonShapeButton2.setText("回书架");
        CommonShapeButton commonShapeButton3 = (CommonShapeButton) viewInflate.findViewById(R.id.shape_sc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(linearLayout.getLayoutParams());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(textView.getLayoutParams());
        layoutParams2.topMargin = com.amgcyo.cuttadon.h.a.d.b;
        textView.setLayoutParams(layoutParams2);
        int I = com.amgcyo.cuttadon.utils.otherutils.h.I();
        String str = "末尾广告状态：" + I;
        if (I <= 0) {
            layoutParams.height = com.amgcyo.cuttadon.utils.otherutils.n.a(a()) / 3;
            adFrameLayout.setVisibility(8);
        } else {
            adFrameLayout.getLayoutParams().height = com.amgcyo.cuttadon.h.a.d.f3859c;
            adFrameLayout.setVisibility(0);
            int childCount = adFrameLayout.getChildCount();
            String str2 = "末尾广告状态childCount ：" + childCount;
            NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c();
            if (normalAdParamsC != null && childCount <= 0) {
                normalAdParamsC.setSelfAdPosition(com.amgcyo.cuttadon.f.n.D);
                adFrameLayout.b(normalAdParamsC);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
        commonShapeButton.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2407s.g(view);
            }
        });
        commonShapeButton2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2423s.h(view);
            }
        });
        commonShapeButton3.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2422s.i(view);
            }
        });
        return viewInflate;
    }

    protected int F() {
        if (com.amgcyo.cuttadon.app.o.c.i()) {
            return 0;
        }
        return com.amgcyo.cuttadon.sdk.utils.f.a(3);
    }

    protected void G() {
        LinearLayout linearLayout = this.ll_bottom;
        if (linearLayout == null || !linearLayout.isShown()) {
            return;
        }
        if (this.I1 == null) {
            this.I1 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            this.I1.setDuration(300L);
        }
        if (this.J1 == null) {
            this.J1 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            this.J1.setDuration(300L);
            this.ll_bottom.startAnimation(this.J1);
        }
        e(false);
        v(this.rel_danmu_button.getBottom());
        this.ll_bottom.setVisibility(4);
        this.tv_menu_add_book.setVisibility(8);
        this.ll_top.startAnimation(this.I1);
        this.ll_top.setVisibility(4);
        AdFrameLayout adFrameLayout = this.ad_comics_top;
        if (adFrameLayout != null && adFrameLayout.getChildCount() > 0) {
            this.ad_comics_top.setVisibility(8);
            this.ad_comics_top.removeAllViews();
        }
        b(this.W0);
        this.fbNightModel.b();
        w(8);
    }

    protected void H() {
        this.Z0 = this.F0.a("pref_reader_volume_key_controls_page_turning", false);
        z();
        n(0);
        this.fr_comic_loading.setVisibility(0);
        this.ll_loading.setVisibility(0);
        this.ll_fail.setVisibility(8);
        ((AnimationDrawable) this.iv_loading.getDrawable()).start();
        q(922);
    }

    protected void I() {
        if (this.isDanmuOpen) {
            this.iv_danmu_states.setImageResource(R.drawable.menu_danmu_switch_open);
        } else {
            this.iv_danmu_states.setImageResource(R.drawable.menu_danmu_switch_close);
        }
    }

    protected void J() {
        if (this.h1) {
            this.fbNightModel.setImageResource(R.drawable.mk_menu_light);
        } else {
            this.fbNightModel.setImageResource(R.drawable.mk_menu_night);
        }
    }

    protected void K() {
        this.f4273v0 = g(3);
        if (this.f4273v0) {
            com.amgcyo.cuttadon.utils.otherutils.g.g(false);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.h.p(3)) {
            com.amgcyo.cuttadon.utils.otherutils.g.g(true);
        }
        com.amgcyo.cuttadon.utils.otherutils.h.t(3);
        this.q1 = f(3);
        String str = "oldAdModel:" + this.q1;
        this.C1 = this.F0.b("pref_reader_controller_trig_threshold", 30) * 0.01f;
        String str2 = L() ? "pref_reader_page_turn" : "pref_reader_stream_turn";
        if (L()) {
            this.turn = this.F0.b(str2, 0);
        }
        this.s1 = this.turn == 1;
        if (M()) {
            this.turn = this.F0.b(str2, 2);
            this.l1 = (TwinklingRefreshLayout) findViewById(R.id.refresh);
            SinaRefreshView sinaRefreshView = new SinaRefreshView(this);
            BottomView bottomView = new BottomView(this);
            sinaRefreshView.setHeadViewBgColor(com.amgcyo.cuttadon.f.o.b(R.color.white));
            this.l1.setHeaderView(sinaRefreshView);
            this.l1.setBottomView(bottomView);
            boolean z2 = F() == 1;
            String str3 = "b:" + z2;
            this.l1.setEnableLoadmore(z2);
            this.l1.setAutoLoadMore(z2);
            this.l1.setEnableOverScroll(false);
            this.l1.setOnRefreshListener(new f());
        } else {
            this.m1 = (HorizontalRefreshLayout) findViewById(R.id.refreshLayout);
            this.m1.setRefreshCallback(new g());
            if (this.s1) {
                this.m1.a(new com.kathline.horizontalrefresh.c.a(this, "正在加载下一话..."), 0);
                this.m1.a(new com.kathline.horizontalrefresh.c.a(this, "正在加载上一话..."), 1);
            } else {
                this.m1.a(new com.kathline.horizontalrefresh.c.a(this, "正在加载上一话..."), 0);
                this.m1.a(new com.kathline.horizontalrefresh.c.a(this, "正在加载下一话..."), 1);
            }
        }
        if (this.orientation == 1) {
            B0();
        }
        this.V0 = this.F0.a("pref_reader_keep_on", false);
        if (this.V0) {
            b();
        } else {
            c();
        }
        t0();
        q0();
        r0();
        H();
        s0();
        J();
        I();
        this.fbNightModel.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2427s.j(view);
            }
        });
        this.ib_more.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2408s.k(view);
            }
        });
        this.danmu_hint.setText("点击此处发送弹幕吧~");
    }

    protected boolean L() {
        return this.mode == 0;
    }

    protected boolean M() {
        return this.mode == 1;
    }

    public /* synthetic */ void N() {
        o(0);
    }

    public /* synthetic */ void O() {
        int i2 = this.R0;
        if (i2 > 0 && this.currentId >= i2 - 1) {
            if (this.J0 == null || this.f2276v == 0) {
                return;
            }
            obtainPresenter().a(Message.a(this, new Object[]{this.J0, 909}));
            return;
        }
        this.currentId++;
        String str = "mReaderAdapter 加载下一章: " + this.currentId + " tempCurrentId: " + this.tempCurrentId;
        ZymkChapter zymkChapter = this.k1.get(this.currentId);
        if (zymkChapter == null || !b(zymkChapter)) {
            String str2 = "initRecyclerView: else" + this.currentId;
            a(this.currentId, 2);
            return;
        }
        NormalAdParams normalAdParamsN0 = n0();
        if (normalAdParamsN0 == null) {
            a(this.currentId, 2);
            return;
        }
        String str3 = "setReardAdData:" + this.Q0 + " 进度：" + this.P0;
        this.L0.a("");
        this.L0.n();
        this.L0.b(false);
        ComicChapter comicChapter = new ComicChapter(3, this.Q0, this.J0.getImage(), com.amgcyo.cuttadon.utils.otherutils.h.U0(), "下一话：" + zymkChapter.getName(), zymkChapter, normalAdParamsN0);
        Message messageA = Message.a(this, new Object[]{Integer.valueOf(this.I0), 2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(comicChapter);
        messageA.f21197s = 2;
        Object[] objArr = messageA.f21203y;
        objArr[0] = arrayList;
        objArr[1] = null;
        messageA.b();
    }

    public /* synthetic */ void P() {
        if (this.rel_danmu_button != null) {
            com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(a(), "danmu_key");
            BaseTitleBarActivity baseTitleBarActivityA = a();
            RelativeLayout relativeLayout = this.rel_danmu_button;
            fVar.a(com.amgcyo.cuttadon.f.o.a(baseTitleBarActivityA, relativeLayout, "点击这里可以关闭/打开弹幕\n调整弹幕滚动速度等设置哦~", new com.amgcyo.cuttadon.view.showcaseview.i.d(relativeLayout.getWidth(), this.rel_danmu_button.getHeight()), 30, 1, 30, new w(this)));
            fVar.b();
        }
    }

    protected void Q() {
        HorizontalRefreshLayout horizontalRefreshLayout;
        TwinklingRefreshLayout twinklingRefreshLayout;
        String str = "this.currentId :" + this.currentId;
        int i2 = this.currentId;
        int size = i2 - 1;
        if (i2 <= 0 || size < 0) {
            g("已经是第一章了...");
            if (1 == this.mode && (twinklingRefreshLayout = this.l1) != null) {
                twinklingRefreshLayout.f();
            }
            if (!L() || (horizontalRefreshLayout = this.m1) == null) {
                return;
            }
            horizontalRefreshLayout.c();
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1)) {
            t(size);
            return;
        }
        if (size >= this.k1.size()) {
            size = this.k1.size() - 1;
        }
        ZymkChapter zymkChapter = this.k1.get(size);
        if (zymkChapter == null || !b(zymkChapter)) {
            t(size);
            return;
        }
        NormalAdParams normalAdParamsN0 = n0();
        if (normalAdParamsN0 == null) {
            t(size);
            return;
        }
        String str2 = "setReardAdData:" + this.Q0 + " 进度：" + this.P0;
        TwinklingRefreshLayout twinklingRefreshLayout2 = this.l1;
        if (twinklingRefreshLayout2 != null) {
            twinklingRefreshLayout2.f();
            this.l1.setEnableRefresh(false);
            this.l1.f();
            this.l1.setEnableRefresh(false);
        }
        HorizontalRefreshLayout horizontalRefreshLayout2 = this.m1;
        if (horizontalRefreshLayout2 != null) {
            horizontalRefreshLayout2.c();
            if (this.s1) {
                this.m1.setRightEnable(false);
            } else {
                this.m1.setLeftEnable(false);
            }
        }
        MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
        if (mkReaderAdapterQuick != null) {
            mkReaderAdapterQuick.a("");
            this.L0.n();
            this.L0.b(false);
        }
        ComicChapter comicChapter = new ComicChapter(3, this.Q0, this.J0.getImage(), com.amgcyo.cuttadon.utils.otherutils.h.U0(), "上一话：" + zymkChapter.getName(), zymkChapter, normalAdParamsN0);
        Message messageA = Message.a(this, new Object[]{Integer.valueOf(this.I0), 1});
        ArrayList arrayList = new ArrayList();
        arrayList.add(comicChapter);
        messageA.f21197s = 1;
        Object[] objArr = messageA.f21203y;
        objArr[0] = arrayList;
        objArr[1] = null;
        messageA.b();
    }

    protected void R() {
        if (this.u1 == null || this.f2277w == null || this.J0 == null || com.amgcyo.cuttadon.utils.otherutils.g.j() == null || !me.jessyan.art.f.f.c(this.f2277w)) {
            return;
        }
        String str = "阅读到的章节：" + this.tempCurrentId;
        String str2 = "jpush_id" + this.J0.getBook_id();
        g0.a().d(str2);
        this.u1.g(Message.a(this, new Object[]{this.J0, Integer.valueOf(this.tempCurrentId), 3, str2}));
    }

    protected abstract void S();

    protected void T() {
        int iB = B();
        if (iB == -1) {
            iB = this.M0.findFirstVisibleItemPosition();
        }
        this.L0.notifyItemChanged(iB);
    }

    protected void U() {
        MkBook mkBook = this.J0;
        if (mkBook == null) {
            return;
        }
        mkBook.setUpdated(this.O1);
        if (y().a(this.tempCurrentId, System.currentTimeMillis() / 1000, this.J0.getUpdated(), this.J0.getBook_id(), this.P0, 0, this.G0) > 0) {
            String str = "onPause 保存成功,章节id：" + this.tempCurrentId + " 进度progress: " + this.P0 + "  书籍状态：" + this.J0.getUpdated();
        }
    }

    protected void V() {
        if (M()) {
            return;
        }
        if (this.Y0) {
            ((RecyclerViewPager) this.mRecyclerView).setScrollSpeed(1.0E-6f);
        } else {
            ((RecyclerViewPager) this.mRecyclerView).setScrollSpeed(0.12f);
        }
    }

    protected void W() {
        if (M()) {
            ((ZoomableRecyclerView) this.mRecyclerView).setScaleFactor(this.f2360d1);
        }
    }

    protected void X() {
        RelativeLayout relativeLayout = this.mReaderBox;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.black));
        }
    }

    protected void Y() {
        if (this.L1 == null) {
            this.L1 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            this.L1.setDuration(300L);
        }
        if (this.M1 == null) {
            this.M1 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            this.M1.setDuration(300L);
        }
        int max = this.mSeekBarP.getMax();
        int i2 = this.Q0;
        if (max != i2) {
            this.mSeekBarP.setMax(i2);
            this.mSeekBarP.setProgress(this.Q0);
        }
        e(true);
        this.mSeekBarP.setProgress(this.P0);
        this.ll_bottom.startAnimation(this.L1);
        if (this.K0) {
            this.tv_menu_add_book.setVisibility(8);
        } else {
            if (this.K1 == null) {
                this.K1 = AnimationUtils.loadAnimation(a(), R.anim.reader_addbook_in);
            }
            this.tv_menu_add_book.startAnimation(this.K1);
            this.tv_menu_add_book.setVisibility(0);
        }
        int i3 = this.R0 - (this.tempCurrentId + 1);
        if (i3 > 0) {
            this.tv_unread.setText(String.format(Locale.getDefault(), "剩余%d章未读", Integer.valueOf(i3)));
        } else {
            this.tv_unread.setText(D());
        }
        if (u0()) {
            this.layout_danmu.setVisibility(0);
            this.ll_danmu_swtich.setVisibility(0);
            C0();
        } else {
            this.layout_danmu.setVisibility(8);
            this.ll_danmu_swtich.setVisibility(8);
        }
        this.ll_bottom_root.setVisibility(0);
        this.ll_bottom.setVisibility(0);
        this.ll_top.startAnimation(this.M1);
        this.ll_top.setVisibility(0);
        if (this.W0) {
            b(false);
            h();
            this.ll_top.setPadding(0, me.jessyan.art.f.h.a((Context) this), 0, 0);
            me.jessyan.art.f.h.d(this, getResources().getColor(R.color.colorBlackAlpha8));
        }
        this.fbNightModel.e();
        w(0);
        clickButton();
        v0();
    }

    protected void Z() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a((Context) a(), true);
            return;
        }
        G();
        BasePopupView basePopupView = this.w1;
        if (basePopupView != null) {
            basePopupView.u();
            return;
        }
        SendDanmuBottomPopup sendDanmuBottomPopup = new SendDanmuBottomPopup(this);
        a.b bVar = new a.b(this);
        bVar.b((Boolean) true);
        bVar.a((BasePopupView) sendDanmuBottomPopup);
        this.w1 = sendDanmuBottomPopup.u();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    protected void a0() {
        p0();
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null || this.u1 == null || !com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
            return;
        }
        this.u1.a(this);
    }

    protected void b0() {
        LinearLayout linearLayout = this.ll_bottom;
        if (linearLayout != null && linearLayout.isShown()) {
            G();
            return;
        }
        try {
            Y();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void c(boolean z2) {
        if (!z2) {
            b(false);
            me.jessyan.art.f.h.d(this, getResources().getColor(R.color.colorBlackAlpha8));
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.d((Activity) this);
            h();
            b(true);
        }
    }

    protected void c0() {
        Intent intent = getIntent();
        if (this.mode == 0) {
            intent.setClass(this, MkStreamReaderPActivity.class);
            intent.putExtra("cimoc.intent.extra.EXTRA_MODE", 1);
        } else {
            intent.setClass(this, MkPageReaderActivity.class);
            intent.putExtra("cimoc.intent.extra.EXTRA_MODE", 0);
        }
        finish();
        startActivity(intent);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void chooseListenerType() {
    }

    public void clickButton() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    protected void d0() {
        this.h1 = !this.h1;
        com.amgcyo.cuttadon.utils.otherutils.g.e(this.h1);
        setChipioAppNightModel();
        J();
        b0();
    }

    protected void e0() {
        setRequestedOrientation(new int[]{-1, 0, 1}[getResources().getConfiguration().orientation]);
    }

    protected void exitReader() {
        finish();
    }

    public /* synthetic */ void f(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = (com.amgcyo.cuttadon.utils.otherutils.n.a(a()) / 2) - (view.getHeight() / 2);
        view.setLayoutParams(layoutParams);
    }

    protected void f0() {
        this.mRecyclerView.scrollToPosition(0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.v1) {
            return;
        }
        this.v1 = true;
        R();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void finishReadActivity() {
        super.finishReadActivity();
        finish();
    }

    public /* synthetic */ void g(View view) {
        x0();
    }

    protected void g0() {
        this.mRecyclerView.scrollToPosition(this.L0.getItemCount() - 1);
    }

    public void gotoBookDetailActivity() {
        b0();
        MkBook mkBook = this.J0;
        if (mkBook == null) {
            return;
        }
        r0.a(this.f2277w, mkBook.getBook_id(), this.J0.getForm());
    }

    public /* synthetic */ void h(View view) {
        onBackPressed();
    }

    protected void h0() {
        if (this.mChapterPage == null || this.tv_seek_p == null) {
            return;
        }
        String strA = com.amgcyo.cuttadon.utils.otherutils.g.a(this.P0, this.Q0);
        this.mChapterPage.setText(strA);
        this.tv_seek_p.setText(strA);
        MkBook mkBook = this.J0;
        if (mkBook != null) {
            mkBook.setRead_begin(this.P0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e4, code lost:
    
        r3 = false;
     */
    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(@androidx.annotation.NonNull me.jessyan.art.mvp.Message r14) {
        /*
            Method dump skipped, instruction units count: 1830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity.handleMessage(me.jessyan.art.mvp.Message):void");
    }

    @Override // com.amgcyo.cuttadon.view.comic.m.c
    public void hideLoadingView(ComicChapter comicChapter) {
        FrameLayout frameLayout = this.fr_comic_loading;
        if (frameLayout == null || !frameLayout.isShown()) {
            return;
        }
        this.fr_comic_loading.setVisibility(8);
        ((AnimationDrawable) this.iv_loading.getDrawable()).stop();
        this.L0.g(true);
        a(comicChapter);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void hideMenu() {
        G();
        if (this.Q1) {
            stopScroll();
        }
    }

    public /* synthetic */ void i(View view) {
        MkBook mkBook = this.J0;
        me.jessyan.art.d.f.a().a(new com.amgcyo.cuttadon.view.read.page.i(mkBook != null ? mkBook.getForm() : 1), "tag_read_activity_to_book_city");
        finish();
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.F0 = MkApplication.getAppContext().mPreferenceManager;
        this.W0 = this.F0.a("pref_other_show_topbar", true);
        this.f2358b1 = this.F0.a("pref_reader_stream_wifi", false);
        this.f2359c1 = this.F0.a("pref_reader_stream_bottom_tips", false);
        this.h1 = com.amgcyo.cuttadon.utils.otherutils.g.h0();
        this.isDanmuOpen = this.F0.a("pref_reader_danmu_open_status", true);
        this.alpha = this.F0.a("pref_reader_danmu_alpha", com.zwb.danmaku.model.a.a);
        this.level = this.F0.b("pref_reader_danmu_size_level", 3);
        this.speed = this.F0.b("pref_reader_danmu_speed", 3);
        this.i1 = g0.a().a("infoLayoutHeight", 0);
        this.j1 = com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f);
        c(this.W0);
        Intent intent = getIntent();
        if (intent == null) {
            showMessage("错误码：c3030");
            finish();
            return;
        }
        this.mode = intent.getIntExtra("cimoc.intent.extra.EXTRA_MODE", 1);
        this.orientation = intent.getIntExtra("cimoc.intent.extra.EXTRA_ORIENTATION", 1);
        this.J0 = (MkBook) intent.getSerializableExtra("book");
        MkBook mkBook = this.J0;
        if (mkBook != null && !TextUtils.isEmpty(mkBook.getList_path())) {
            this.currentId = this.J0.getReading_chapter_key();
            this.I0 = this.J0.getBook_id();
            this.J0.getForm();
            this.tempCurrentId = this.currentId;
            String str = "阅读记录id：" + this.currentId + " \nbook_id: " + this.I0 + " \n目录地址：" + this.J0.getList_path() + "章节数：" + this.J0.getChapter_count();
            r(this.I0);
            K();
            f(false);
            this.p1 = true;
            ComicsNetUtil.d(this);
            ComicsNetUtil.a(new ComicsNetUtil.b() { // from class: com.amgcyo.cuttadon.activity.comic.r
                @Override // com.amgcyo.cuttadon.utils.comic.network.ComicsNetUtil.b
                public final void a(ComicsNetUtil.ConnectStatus connectStatus) {
                    this.a.a(connectStatus);
                }
            });
        }
        com.amgcyo.cuttadon.h.h.c.a(3);
    }

    public boolean isPortrait() {
        return this.orientation == 1;
    }

    public /* synthetic */ void j(View view) {
        d0();
    }

    public /* synthetic */ void k(View view) {
        if (this.z1 == null) {
            a.b bVar = new a.b(a());
            bVar.a(this.ib_more);
            bVar.a(PopupAnimation.ScrollAlphaFromTop);
            bVar.e(false);
            ComicReadMorePopupView comicReadMorePopupView = new ComicReadMorePopupView(a());
            bVar.a((BasePopupView) comicReadMorePopupView);
            this.z1 = comicReadMorePopupView;
        }
        this.z1.u();
        stopScroll();
        x0.c().a("[READ]切换夜间");
    }

    protected void l(int i2) {
        int i3 = this.currentId + 1;
        if (i3 >= this.R0) {
            showMessage("已经是最后一章了...");
            hideLoading();
            return;
        }
        ZymkChapter zymkChapter = this.k1.get(i3);
        if (zymkChapter == null || !b(zymkChapter)) {
            this.currentId = i3;
            a(this.currentId, i2);
            return;
        }
        NormalAdParams normalAdParamsN0 = n0();
        if (normalAdParamsN0 == null) {
            this.currentId = i3;
            a(this.currentId, i2);
            return;
        }
        String str = "setReardAdData:" + this.Q0 + " 进度：" + this.P0;
        TwinklingRefreshLayout twinklingRefreshLayout = this.l1;
        if (twinklingRefreshLayout != null) {
            twinklingRefreshLayout.e();
            this.l1.setEnableLoadmore(false);
            this.l1.f();
            this.l1.setEnableRefresh(false);
        }
        HorizontalRefreshLayout horizontalRefreshLayout = this.m1;
        if (horizontalRefreshLayout != null) {
            horizontalRefreshLayout.c();
            if (this.s1) {
                this.m1.setLeftEnable(false);
            } else {
                this.m1.setRightEnable(false);
            }
        }
        MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
        if (mkReaderAdapterQuick != null) {
            mkReaderAdapterQuick.a("");
            this.L0.n();
            this.L0.b(false);
        }
        ComicChapter comicChapter = new ComicChapter(3, this.Q0, this.J0.getImage(), com.amgcyo.cuttadon.utils.otherutils.h.U0(), "下一话：" + zymkChapter.getName(), zymkChapter, normalAdParamsN0);
        Message messageA = Message.a(this, new Object[]{Integer.valueOf(this.I0), Integer.valueOf(i2)});
        ArrayList arrayList = new ArrayList();
        arrayList.add(comicChapter);
        messageA.f21197s = i2;
        Object[] objArr = messageA.f21203y;
        objArr[0] = arrayList;
        objArr[1] = null;
        messageA.b();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    protected void m(int i2) {
        MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
        if (mkReaderAdapterQuick != null) {
            mkReaderAdapterQuick.notifyItemChanged(i2 + mkReaderAdapterQuick.c(), "payload");
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    protected void n(int i2) {
        TextView textView = this.tv_loading_msg;
        if (textView != null) {
            if (i2 == 0) {
                textView.setText("正在加载列表信息...");
            } else {
                textView.setText("正在渲染图片信息...");
            }
        }
    }

    protected abstract void nextPage();

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyDanmuSetItemChanged(float f2, int i2, int i3) {
        if (BaseTitleBarActivity.v() || this.M0 == null || this.L0 == null) {
            return;
        }
        if (f2 != -1.0f) {
            this.F0.a("pref_reader_danmu_alpha", f2);
            this.alpha = f2;
            this.L0.a(this.alpha);
        }
        if (i2 != 0) {
            this.F0.c("pref_reader_danmu_size_level", i2);
            this.level = i2;
            this.L0.f(i2);
        }
        if (i3 != 0) {
            this.F0.c("pref_reader_danmu_speed", i3);
            this.speed = i3;
            this.L0.h(i3);
        }
        int iFindLastVisibleItemPosition = this.M0.findLastVisibleItemPosition();
        for (int iFindFirstVisibleItemPosition = this.M0.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
            ComicChapter comicChapter = (ComicChapter) this.L0.getItem(iFindFirstVisibleItemPosition);
            if (comicChapter != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter.getDanmakuContents())) {
                comicChapter.setState(5);
                m(iFindFirstVisibleItemPosition);
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    protected void o(int i2) {
        TextView textView = this.danmu_num;
        if (textView == null || this.ll_bottom == null) {
            return;
        }
        this.N1 = i2;
        if (i2 >= 9999) {
            textView.setText("9999+");
        } else {
            textView.setText(String.valueOf(i2));
        }
        LinearLayout linearLayout = this.ll_bottom_root;
        if (linearLayout == null || linearLayout.isShown()) {
            return;
        }
        this.ll_bottom_root.setVisibility(0);
        this.ll_bottom.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.J0 != null) {
            if (y().i(this.J0.getBook_id()) == null) {
                D0();
                return;
            }
            finish();
        }
        super.onBackPressed();
    }

    public void onChapterChange(ZymkChapter zymkChapter) {
        if (this.mChapterTitle != null) {
            this.Q0 = zymkChapter.getCount();
            this.currentId = zymkChapter.getIndex();
            this.tempCurrentId = this.currentId;
            this.G0 = zymkChapter.getName();
            String name = zymkChapter.getName();
            if (name.length() > 18) {
                name = name.substring(0, 18).concat("...");
            }
            this.mChapterTitle.setText(name);
            this.tv_title.setText(name);
            a(this.J0, this.currentId);
        }
    }

    @OnClick({R.id.ib_back, R.id.tv_title, R.id.tv_source, R.id.ib_progress_back, R.id.iv_previous_p, R.id.iv_next_p, R.id.btn_set, R.id.btn_auto, R.id.btn_brightness, R.id.btn_dir, R.id.tv_menu_add_book, R.id.iv_read_speed_add_p, R.id.iv_read_speed_reduce_p, R.id.btn_huanyuan, R.id.btn_try_again, R.id.tv_read_finish, R.id.layout_danmu, R.id.rel_danmu_button, R.id.iv_danmu_set})
    public void onClick(View view) {
        clickButton();
        switch (view.getId()) {
            case R.id.btn_auto /* 2131296730 */:
                G();
                switchScroll();
                x0.c().a("[READ]自动");
                break;
            case R.id.btn_brightness /* 2131296731 */:
                b0();
                stopScroll();
                E0();
                x0.c().a("[READ]亮度");
                break;
            case R.id.btn_dir /* 2131296734 */:
                b0();
                stopScroll();
                startCatalog();
                x0.c().a("[READ]点击目录");
                break;
            case R.id.btn_huanyuan /* 2131296744 */:
            case R.id.tv_source /* 2131298815 */:
                if (this.J0 != null) {
                    y0.a.a.a("换源", new Object[0]);
                    f(true);
                }
                b0();
                x0.c().a("[READ]换源");
                break;
            case R.id.btn_set /* 2131296758 */:
                b0();
                stopScroll();
                y0();
                x0.c().a("[READ]设置");
                break;
            case R.id.btn_try_again /* 2131296760 */:
                b0();
                b(this.J0);
                break;
            case R.id.ib_back /* 2131297065 */:
            case R.id.ib_progress_back /* 2131297067 */:
            case R.id.tv_read_finish /* 2131298784 */:
                onBackPressed();
                break;
            case R.id.iv_danmu_set /* 2131297165 */:
                k0();
                G();
                break;
            case R.id.iv_read_speed_add_p /* 2131297203 */:
                b0();
                com.amgcyo.cuttadon.f.o.c(view);
                setScrollHelperSpeed(1000);
                this.sbReadSpeedP.setProgress(100);
                break;
            case R.id.iv_read_speed_reduce_p /* 2131297204 */:
                b0();
                com.amgcyo.cuttadon.f.o.c(view);
                setScrollHelperSpeed(16000);
                this.sbReadSpeedP.setProgress(0);
                break;
            case R.id.layout_danmu /* 2131297840 */:
                Z();
                break;
            case R.id.rel_danmu_button /* 2131298229 */:
                switchDanmuStates();
                break;
            case R.id.tv_menu_add_book /* 2131298742 */:
                b0();
                d(false);
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            ComicsNetUtil.e(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.L0 != null) {
            this.L0.a((BaseQuickAdapter.i) null);
        }
        com.bumptech.glide.c.a((Context) this).b();
        u(2);
        n();
        zhugeIodEvent("[READ]关闭阅读器3");
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & InputDeviceCompat.SOURCE_JOYSTICK) != 16777232 || motionEvent.getAction() != 2) {
            return super.onGenericMotionEvent(motionEvent);
        }
        int historySize = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            a(motionEvent, i2);
        }
        a(motionEvent, -1);
        return true;
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
        if (mkReaderAdapterQuick != null && mkReaderAdapterQuick.getItemCount() != 0) {
            int i3 = 0;
            if (i2 == 24) {
                i3 = this.f1[5];
            } else if (i2 == 25) {
                i3 = this.f1[6];
            } else if (i2 == 96) {
                i3 = this.f1[14];
            } else if (i2 == 97) {
                i3 = this.f1[13];
            } else if (i2 == 99) {
                i3 = this.f1[15];
            } else if (i2 != 100) {
                switch (i2) {
                    case 19:
                        i3 = this.f1[11];
                        break;
                    case 20:
                        i3 = this.f1[12];
                        break;
                    case 21:
                        i3 = this.f1[9];
                        break;
                    case 22:
                        i3 = this.f1[10];
                        break;
                    default:
                        switch (i2) {
                            case 102:
                            case 104:
                                i3 = this.f1[7];
                                break;
                            case 103:
                            case 105:
                                i3 = this.f1[8];
                                break;
                        }
                        break;
                }
            } else {
                i3 = this.f1[16];
            }
            if (i3 != 0) {
                p(i3);
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.github.chrisbanes.photoview.i
    public void onLongPress(float f2, float f3) {
        p(a(f2, f3, true));
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.p1 = false;
        stopScroll();
        unregisterReceiver(this.n1);
        U();
        CatalogPresenter catalogPresenter = this.u1;
        if (catalogPresenter != null) {
            catalogPresenter.d();
        }
        u(0);
    }

    public void onPrevLoadSuccess(List<ComicChapter> list) {
        this.L0.a(0, (Collection) list);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.p1 = true;
        registerReceiver(this.n1, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        TextView textView = this.tv_net;
        if (textView != null) {
            textView.setText(me.jessyan.art.f.e.a((Context) this, false));
        }
        if (this.B0) {
            b(l0());
        }
        this.B0 = false;
        a0();
        u(1);
        if (com.amgcyo.cuttadon.utils.otherutils.h.s(3)) {
            c(3);
        }
        a("read_page");
        w();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle bundle) {
        MkBook mkBook = this.J0;
        if (mkBook != null) {
            bundle.putSerializable("book", mkBook);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.github.chrisbanes.photoview.i
    public void onSingleTap(float f2, float f3) {
        FrameLayout frameLayout = this.fl_brightness;
        if (frameLayout == null || !frameLayout.isShown()) {
            p(a(f2, f3, false));
        } else {
            this.fl_brightness.setVisibility(8);
        }
    }

    @Override // com.mardous.discreteseekbar.DiscreteSeekBar.g
    public void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar) {
    }

    public void openComicSettingActivity() {
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(new Intent(this.f2277w, (Class<?>) MkComicSettingActivity.class), new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.comic.b
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent) {
                this.a.b(i2, intent);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void reallyStartDownloadCache() {
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void restartActivityPage() {
        b(this.J0);
    }

    public void scroll(int i2) {
        if (!isPortrait()) {
            this.mRecyclerView.scrollBy(0, i2);
            return;
        }
        if (!L()) {
            this.mRecyclerView.scrollBy(0, i2);
            return;
        }
        int iB = B();
        if (iB < this.L0.getItemCount() - 1) {
            this.mRecyclerView.smoothScrollToPosition(iB + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendDanmuContent(String str, int i2) {
        if (this.L0 == null) {
            showMessage("系统异常~");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            showMessage("弹幕内容不能为空~");
            return;
        }
        if (str.length() > 20) {
            showMessage("弹幕内容不能超过20个字符~");
            return;
        }
        String str2 = "发送的内容是：" + str + " 颜色是：" + i2 + " chapter_path: " + this.D0 + " picId: " + this.E0;
        int iC = C();
        if (iC < 0) {
            iC = 0;
        }
        ComicChapter comicChapter = (ComicChapter) this.L0.getItem(iC);
        if (comicChapter == null) {
            return;
        }
        this.D0 = comicChapter.getChapter_path();
        this.E0 = comicChapter.getId();
        if (TextUtils.isEmpty(this.D0) || this.E0 < 0 || this.I0 == 0) {
            showMessage("参数异常~");
            return;
        }
        String str3 = "item: " + comicChapter.getId() + " path: " + comicChapter.getPath();
        obtainPresenter().e(Message.a(this, new Object[]{Integer.valueOf(this.I0), this.D0, Integer.valueOf(this.E0), str, Integer.valueOf(i2), Integer.valueOf(iC), comicChapter}));
        this.w1.g();
    }

    public void setScrollHelperSpeed(int i2) {
        com.amgcyo.cuttadon.utils.comic.e eVar = this.scrollHelper;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void showGuiderByModel() {
        if (1 == this.mode) {
            showUserGuideIfNeed(R.layout.view_top_to_bottom, "pref_stream_atb_count");
            return;
        }
        int i2 = this.turn;
        if (i2 == 0) {
            showUserGuideIfNeed(R.layout.view_p_right, "pref_pager_ltr_count");
        } else if (1 == i2) {
            showUserGuideIfNeed(R.layout.view_p_left, "pref_pager_rtl_count");
        }
    }

    public void showGuiderByModelHelp() {
        if (1 == this.mode) {
            showUserGuideIfNeed(R.layout.view_top_to_bottom, "");
        } else {
            int i2 = this.turn;
            if (i2 == 0) {
                showUserGuideIfNeed(R.layout.view_p_right, "");
            } else if (1 == i2) {
                showUserGuideIfNeed(R.layout.view_p_left, "");
            }
        }
        b0();
    }

    public void showUserGuideIfNeed(@LayoutRes int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            a(i2, str);
            return;
        }
        int iA = g0.a().a(str, 0);
        if (iA < 3) {
            if (a(i2, str)) {
                return;
            }
            g0.a().b(str, iA + 1);
            return;
        }
        int iA2 = g0.a().a("show_control", 0);
        if (iA2 > 4000 || com.amgcyo.cuttadon.utils.otherutils.h.q(3)) {
            return;
        }
        try {
            Y();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g0.a().b("show_control", iA2 + 1);
    }

    public void stopScroll() {
        com.amgcyo.cuttadon.utils.comic.e eVar = this.scrollHelper;
        if (eVar != null) {
            eVar.b();
            switchReadStartStop(this.scrollHelper.a());
        }
    }

    @Override // com.amgcyo.cuttadon.g.i
    public void subMitrecordTime(int i2) {
        if (this.f2277w == null || this.J0 == null || com.amgcyo.cuttadon.utils.otherutils.g.j() == null || !me.jessyan.art.f.f.c(this.f2277w) || this.Q1) {
            return;
        }
        p0();
        if (this.u1 != null) {
            this.u1.i(Message.a(this, new Object[]{Integer.valueOf(this.J0.getBook_id()), this.J0.getList_path(), this.J0.getReading_site_id(), Integer.valueOf(i2), 906, Integer.valueOf(this.J0.getForm())}));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void switchDanmuStates() {
        if (BaseTitleBarActivity.v() || this.M0 == null || this.L0 == null) {
            return;
        }
        this.isDanmuOpen = !this.isDanmuOpen;
        this.F0.b("pref_reader_danmu_open_status", this.isDanmuOpen);
        I();
        this.L0.c(this.isDanmuOpen);
        if (!L()) {
            int iFindLastVisibleItemPosition = this.M0.findLastVisibleItemPosition();
            for (int iFindFirstVisibleItemPosition = this.M0.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                ComicChapter comicChapter = (ComicChapter) this.L0.getItem(iFindFirstVisibleItemPosition);
                if (comicChapter != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter.getDanmakuContents())) {
                    m(iFindFirstVisibleItemPosition);
                }
            }
            return;
        }
        int iFindFirstCompletelyVisibleItemPosition = this.M0.findFirstCompletelyVisibleItemPosition();
        if (this.isDanmuOpen) {
            String str = "打开漫画：" + iFindFirstCompletelyVisibleItemPosition;
            ComicChapter comicChapter2 = (ComicChapter) this.L0.getItem(iFindFirstCompletelyVisibleItemPosition);
            if (comicChapter2 == null || com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter2.getDanmakuContents())) {
                return;
            }
            m(iFindFirstCompletelyVisibleItemPosition);
            return;
        }
        String str2 = "关闭漫画：" + iFindFirstCompletelyVisibleItemPosition + " " + this.L0.getItemCount();
        int i2 = iFindFirstCompletelyVisibleItemPosition - 10;
        if (i2 < 0) {
            i2 = 0;
        }
        this.L0.notifyItemRangeChanged(i2, iFindFirstCompletelyVisibleItemPosition + 10, "payload");
    }

    public void switchReadStartStop(boolean z2) {
        if (z2) {
            this.tv_auto.setText(R.string.read_stop_hint);
            this.Q1 = true;
            this.ivAuto.setImageResource(R.drawable.read_stop_ic);
            this.llP.setVisibility(8);
            this.llReadSpeedP.setVisibility(0);
            return;
        }
        this.tv_auto.setText(R.string.read_start_hint);
        this.Q1 = false;
        this.ivAuto.setImageResource(R.drawable.read_start_ic);
        this.llP.setVisibility(0);
        this.llReadSpeedP.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void switchScroll() {
        try {
            if (this.scrollHelper != null) {
                boolean z2 = false;
                if (this.scrollHelper.a()) {
                    this.scrollHelper.b();
                    z2 = this.isDanmuOpen;
                    c();
                } else {
                    b();
                    if (isPortrait()) {
                        this.scrollHelper.a(L());
                    } else {
                        this.scrollHelper.a(false);
                    }
                }
                if (this.isDanmuOpen && M() && this.L0 != null && this.M0 != null) {
                    this.L0.c(z2);
                    int iFindLastVisibleItemPosition = this.M0.findLastVisibleItemPosition();
                    for (int iFindFirstVisibleItemPosition = this.M0.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                        ComicChapter comicChapter = (ComicChapter) this.L0.getItem(iFindFirstVisibleItemPosition);
                        if (comicChapter != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter.getDanmakuContents())) {
                            m(iFindFirstVisibleItemPosition);
                        }
                    }
                }
                switchReadStartStop(this.scrollHelper.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            g("操作失败!");
        }
    }

    public void swtichReadModel(int i2, int i3) {
        if (i2 == 0) {
            this.F0.c("pref_reader_mode", 0);
            this.F0.c("pref_reader_page_turn", 0);
            this.F0.c("pref_reader_page_orientation", i3);
        } else if (i2 == 1) {
            this.F0.c("pref_reader_mode", 0);
            this.F0.c("pref_reader_page_turn", 1);
            this.F0.c("pref_reader_page_orientation", i3);
        } else if (i2 == 2) {
            this.F0.c("pref_reader_mode", 1);
            this.F0.c("pref_reader_stream_turn", 2);
            this.F0.c("pref_reader_stream_orientation", i3);
        }
        this.J0.setRead_begin(this.P0);
        this.J0.setReading_chapter_key(this.currentId);
        b(this.J0);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity
    public void unlockContinueSuccess() {
        AdFrameLayout adFrameLayout;
        if (this.Q1) {
            stopScroll();
        }
        if (this.bottom_adHeight > 0 || ((adFrameLayout = this.ad_comics_bottom) != null && adFrameLayout.getVisibility() == 0)) {
            b(this.J0);
        }
    }

    protected com.amgcyo.cuttadon.database.f y() {
        if (this.H0 == null) {
            this.H0 = AppDatabase.i().a();
        }
        return this.H0;
    }

    protected void z() {
        this.f1 = L() ? ClickEvents.a(this.F0, this.turn, this.Z0) : ClickEvents.a(this.F0, this.Z0);
        this.g1 = L() ? ClickEvents.a(this.F0) : ClickEvents.b(this.F0);
    }

    private boolean b(ZymkChapter zymkChapter) {
        this.q1 = f(3);
        boolean z2 = false;
        if (!this.q1) {
            return false;
        }
        int index = zymkChapter.getIndex();
        zymkChapter.setReward(false);
        int iC = com.amgcyo.cuttadon.utils.otherutils.h.c(3);
        String str = index + " 间隔数：" + iC;
        boolean zH = com.amgcyo.cuttadon.app.o.c.h();
        boolean z3 = iC != 0 && index % iC == 0;
        if (!zH || !z3) {
            String str2 = "广告开启状态：" + zH + " 是否章节解锁chufa：" + z3;
            return false;
        }
        boolean zI = com.amgcyo.cuttadon.app.o.c.i();
        boolean zA = g0.a().a("unlock_" + this.I0 + "_" + zymkChapter.getId() + "_" + index, false);
        StringBuilder sb = new StringBuilder();
        sb.append("i != 0:");
        sb.append(index != 0);
        sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("!expam:");
        sb2.append(!zI);
        sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("!status:");
        sb3.append(!zA);
        sb3.toString();
        if (index != 0 && !zI && !zA) {
            z2 = true;
        }
        String str3 = "b:" + z2;
        zymkChapter.setReward(z2);
        return zymkChapter.isReward();
    }

    private void h(String str) {
        showLoading("努力加载中...");
        com.amgcyo.cuttadon.j.g.b.a(new c("", str));
    }

    protected void g(String str) {
        com.amgcyo.cuttadon.view.comic.comictoast.a.a(a(), str, com.anythink.expressad.video.module.a.a.m.ag).a();
    }

    public /* synthetic */ void j(int i2) {
        View view = this.mInfoLayout;
        if (view != null) {
            this.i1 = view.getHeight() + i2;
            g0.a().b("infoLayoutHeight", this.i1);
            v(this.i1);
            if (L()) {
                RecyclerView recyclerView = this.mRecyclerView;
                int i3 = this.i1;
                com.amgcyo.cuttadon.f.o.a(recyclerView, 0, -i3, 0, i3 - i2);
            }
        }
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public ComicPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ComicPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ComicPresenter) this.f2276v;
    }

    private static Intent a(Context context, int i2, int i3) {
        if (i2 == 0) {
            return new Intent(context, (Class<?>) MkPageReaderActivity.class);
        }
        if (i3 == 0) {
            return new Intent(context, (Class<?>) MkStreamReaderHActivity.class);
        }
        return new Intent(context, (Class<?>) MkStreamReaderPActivity.class);
    }

    private void f(boolean z2) {
        String comic_source = this.J0.getComic_source();
        String reading_site_id = this.J0.getReading_site_id();
        if (!TextUtils.isEmpty(comic_source) && !TextUtils.isEmpty(reading_site_id)) {
            if (z2) {
                x0();
                return;
            }
            return;
        }
        List listB = com.amgcyo.cuttadon.utils.otherutils.r.b(com.amgcyo.cuttadon.utils.otherutils.v.b(MkApplication.getAppContext(), "source_comic.json"), ComicSourceBean.class);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
            return;
        }
        List listA = com.amgcyo.cuttadon.utils.otherutils.g.a(listB, 0);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listA)) {
            return;
        }
        String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(listA);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.J0.setComic_source(strA);
        ComicSourceBean comicSourceBean = (ComicSourceBean) listA.get(new Random().nextInt(listA.size()));
        if (comicSourceBean != null) {
            this.J0.setReading_site_id(comicSourceBean.getSourceId());
            y().a(strA, comicSourceBean.getSourceId(), comicSourceBean.getTitle(), this.J0.getBook_id());
            if (z2) {
                x0();
            }
        }
    }

    private void i(String str) {
        this.ll_loading.setVisibility(8);
        ((AnimationDrawable) this.iv_loading.getDrawable()).stop();
        this.ll_fail.setVisibility(0);
        this.tv_load_fail_tip.setText(str);
        b0();
    }

    private void c(final ZymkChapter zymkChapter) {
        if (this.J0 == null) {
            return;
        }
        try {
            com.amgcyo.cuttadon.view.comic.k kVar = new com.amgcyo.cuttadon.view.comic.k(this.f2277w, View.inflate(this.f2277w, R.layout.dialog_reload_current_chapter, null), R.style.custom_dialog);
            kVar.setCancelable(true);
            kVar.a(this.J0, this.G);
            kVar.a(new k.a() { // from class: com.amgcyo.cuttadon.activity.comic.o
                @Override // com.amgcyo.cuttadon.view.comic.k.a
                public final void a() {
                    this.a.a(zymkChapter);
                }
            });
            kVar.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(ComicsNetUtil.ConnectStatus connectStatus) {
        if (this.p1) {
            TextView textView = this.tv_net;
            if (textView != null) {
                textView.setText(connectStatus.toString());
            }
            int iA = g0.a().a("NETWORK_COUNT", 0);
            if ((iA > 5 && !this.f2358b1) || ComicsNetUtil.ConnectStatus.NO_CONNECTED == connectStatus || ComicsNetUtil.ConnectStatus.NO_NETWORK == connectStatus || ComicsNetUtil.ConnectStatus.WIFI == connectStatus) {
                return;
            }
            showMessage("当前非WIFI环境，请注意流量消耗!");
            if (iA <= 5) {
                g0.a().b("NETWORK_COUNT", iA + 1);
            }
        }
    }

    public /* synthetic */ void k(int i2) {
        this.currentId++;
        String str = "加载下一章: " + this.currentId + " tempCurrentId: " + this.tempCurrentId;
        a(this.currentId, i2);
    }

    public /* synthetic */ void a(MkBook mkBook) {
        this.K0 = mkBook != null;
    }

    public /* synthetic */ void a(ZymkChapter zymkChapter, NormalAdParams normalAdParams, int i2) {
        TwinklingRefreshLayout twinklingRefreshLayout = this.l1;
        if (twinklingRefreshLayout != null) {
            twinklingRefreshLayout.e();
            this.l1.setEnableLoadmore(false);
            this.l1.f();
            this.l1.setEnableRefresh(false);
        }
        HorizontalRefreshLayout horizontalRefreshLayout = this.m1;
        if (horizontalRefreshLayout != null) {
            horizontalRefreshLayout.c();
            if (this.s1) {
                this.m1.setLeftEnable(false);
            } else {
                this.m1.setRightEnable(false);
            }
        }
        MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
        if (mkReaderAdapterQuick != null) {
            mkReaderAdapterQuick.a("");
            this.L0.n();
            this.L0.b(false);
        }
        ComicChapter comicChapter = new ComicChapter(3, this.Q0, this.J0.getImage(), com.amgcyo.cuttadon.utils.otherutils.h.U0(), "下一话：" + zymkChapter.getName(), zymkChapter, normalAdParams);
        Message messageA = Message.a(this, new Object[]{Integer.valueOf(this.I0), Integer.valueOf(i2)});
        ArrayList arrayList = new ArrayList();
        arrayList.add(comicChapter);
        messageA.f21197s = i2;
        Object[] objArr = messageA.f21203y;
        objArr[0] = arrayList;
        objArr[1] = null;
        messageA.b();
    }

    protected void b(MkBook mkBook) {
        if (mkBook == null) {
            return;
        }
        r0.a(this.f2277w, mkBook);
        finish();
    }

    protected void b(ComicChapter comicChapter) {
        this.Q0 = comicChapter.getCount();
        this.currentId = comicChapter.getOwnerChapterIndex();
        this.tempCurrentId = this.currentId;
        String str = "currentId:" + this.currentId + " max:" + this.Q0 + " tempCurrentId: " + this.tempCurrentId;
        MkBook mkBook = this.J0;
        if (mkBook != null) {
            mkBook.setReading_chapter_key(this.currentId);
        }
        this.G0 = comicChapter.getTempName();
        this.mChapterTitle.setText(this.G0);
        this.tv_title.setText(this.G0);
        a(this.J0, this.currentId);
        a(comicChapter);
    }

    public /* synthetic */ void b(int i2, Intent intent) {
        MkBook mkBook;
        if (intent != null && -1 == i2) {
            boolean[] booleanArrayExtra = intent.getBooleanArrayExtra("cimoc.intent.extra.EXTRA_RESULT");
            if (booleanArrayExtra == null) {
                g("操作失败!");
                return;
            }
            Arrays.toString(booleanArrayExtra);
            boolean z2 = booleanArrayExtra[0];
            if (this.V0 != z2) {
                if (z2) {
                    b();
                    g("屏幕常亮设置成功");
                } else {
                    c();
                    g("已取消屏幕常亮");
                }
                this.V0 = z2;
            }
            if (this.W0 != booleanArrayExtra[1] && (mkBook = this.J0) != null) {
                b(mkBook);
            }
            boolean z3 = booleanArrayExtra[2];
            if (this.X0 != z3) {
                this.X0 = z3;
                if (M()) {
                    ((ZoomableRecyclerView) this.mRecyclerView).setDoubleTap(true ^ this.X0);
                } else {
                    MkReaderAdapterQuick mkReaderAdapterQuick = this.L0;
                    if (mkReaderAdapterQuick != null) {
                        mkReaderAdapterQuick.d(true ^ this.X0);
                        MkReaderAdapterQuick mkReaderAdapterQuick2 = this.L0;
                        mkReaderAdapterQuick2.notifyItemRangeChanged(0, mkReaderAdapterQuick2.getItemCount());
                    }
                }
            }
            boolean z4 = booleanArrayExtra[3];
            if (this.Z0 != z4) {
                this.Z0 = z4;
                z();
            }
            boolean z5 = booleanArrayExtra[4];
            if (this.Y0 != z5) {
                this.Y0 = z5;
                V();
            }
            boolean z6 = booleanArrayExtra[5];
            if (this.f2357a1 != z6) {
                this.f2357a1 = z6;
                if (M()) {
                    if (this.f2357a1) {
                        this.e1 = this.L0.u();
                        this.mRecyclerView.addItemDecoration(this.e1);
                    } else {
                        RecyclerView.ItemDecoration itemDecoration = this.e1;
                        if (itemDecoration != null) {
                            this.mRecyclerView.removeItemDecoration(itemDecoration);
                        }
                    }
                }
            }
            float floatExtra = intent.getFloatExtra("cimoc.intent.extra.extra_result_scalefactor", this.f2360d1);
            if (this.f2360d1 != floatExtra) {
                this.f2360d1 = floatExtra;
                W();
                MkReaderAdapterQuick mkReaderAdapterQuick3 = this.L0;
                if (mkReaderAdapterQuick3 != null) {
                    mkReaderAdapterQuick3.b(this.f2360d1);
                    MkReaderAdapterQuick mkReaderAdapterQuick4 = this.L0;
                    mkReaderAdapterQuick4.notifyItemRangeChanged(0, mkReaderAdapterQuick4.getItemCount());
                }
            }
            if (booleanArrayExtra[6]) {
                ZymkChapter zymkChapterM0 = m0();
                if (zymkChapterM0 != null && this.I0 > 0) {
                    String strE = z.e(this.I0 + z.a + zymkChapterM0.getUpdated_at() + "_" + zymkChapterM0.getPath().replaceAll("/", "_").replaceAll(".html", ""));
                    StringBuilder sb = new StringBuilder();
                    sb.append("comicPath:");
                    sb.append(strE);
                    sb.toString();
                    h(strE);
                } else {
                    showMessage("操作失败!");
                }
            }
            this.f2358b1 = booleanArrayExtra[7];
            boolean z7 = booleanArrayExtra[8];
            if (z7 != this.f2359c1) {
                this.f2359c1 = z7;
                o0();
            }
        }
    }

    private void a(final int i2, long j2) {
        this.r1.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f2425s.k(i2);
            }
        }, j2);
    }

    public /* synthetic */ void a(int i2, CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isPressed()) {
            if (z2) {
                int iC = c0.c(a());
                String str = "系统亮度值：" + iC;
                this.sb_brightness.setProgress(iC);
                c0.b(this, -1);
            } else {
                String str2 = "使用非系统亮度值：" + i2;
                c0.c(a(), i2);
                this.sb_brightness.setProgress(i2);
            }
            this.F0.b("key_brightness_system", z2);
        }
    }

    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            String string = textView.getText().toString();
            if (com.amgcyo.cuttadon.f.o.d(R.string.net_set).equals(string)) {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                return;
            }
            if (com.amgcyo.cuttadon.f.o.d(R.string.huanyuan).equals(string)) {
                f(true);
                return;
            }
            if (com.amgcyo.cuttadon.f.o.d(R.string.check_version).equals(string)) {
                showAppUpdateChioceDialog();
                return;
            }
            if (com.amgcyo.cuttadon.f.o.d(R.string.check_version_web).equals(string)) {
                String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
                if (TextUtils.isEmpty(strC0)) {
                    return;
                }
                com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, strC0);
                return;
            }
            if (!com.amgcyo.cuttadon.f.o.d(R.string.comic_error_feedback).equals(string) && !com.amgcyo.cuttadon.f.o.d(R.string.comic_error_to_kefu).equals(string)) {
                if (com.amgcyo.cuttadon.f.o.d(R.string.comic_error_content).equals(string)) {
                    a(textView);
                    return;
                }
                if (com.amgcyo.cuttadon.utils.otherutils.h.n(com.amgcyo.cuttadon.h.a.i.b(3)).equals(string)) {
                    e("comics_position_reward_ad_video");
                    return;
                }
                if (view.getTag() != null && (view.getTag() instanceof ComicChapter)) {
                    ComicChapter comicChapter = (ComicChapter) view.getTag();
                    ZymkChapter zymkChapter = comicChapter.getZymkChapter();
                    if (zymkChapter == null || this.J0 == null) {
                        return;
                    }
                    String str = "index:" + zymkChapter.getIndex();
                    r0.a(a(), this.J0, comicChapter);
                    finish();
                    return;
                }
                if (com.amgcyo.cuttadon.f.o.d(R.string.comic_error_retry).equals(string)) {
                    String str2 = (String) view.getTag();
                    String str3 = "signatureKey:" + str2;
                    if (!TextUtils.isEmpty(str2)) {
                        g0.a().b(str2, String.valueOf(System.currentTimeMillis()));
                    }
                    w0();
                    return;
                }
                if (com.amgcyo.cuttadon.f.o.d(R.string.comic_error_refresh).equals(string)) {
                    w0();
                    return;
                }
                if (com.amgcyo.cuttadon.f.o.d(R.string.comic_error_restart_app).equals(string)) {
                    com.amgcyo.cuttadon.utils.otherutils.h.i("");
                    g0.a().b("hcehiuwhrg", "");
                    g0.a().b("koiweoivna", "");
                    g0.a().b("fqie9", "");
                    System.exit(0);
                    ProcessPhoenix.triggerRebirth(this);
                    return;
                }
                b(this.J0);
                return;
            }
            r0.startActivity(this.f2277w, MkFeedBackActivity.class);
        }
    }

    private void b(final NormalAdParams normalAdParams) {
        a(this.f4265n0);
        this.q1 = f(3);
        Boolean.valueOf(this.q1);
        if (!this.q1 || this.bottom_adHeight <= 0) {
            return;
        }
        int refreshAdTime = getRefreshAdTime();
        String str = "使用旧版本广告方案-adPollingSecond: " + refreshAdTime;
        if (refreshAdTime > 0) {
            this.f4265n0 = b0.a(0L, refreshAdTime, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.amgcyo.cuttadon.activity.comic.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f2418s.a(normalAdParams, (Long) obj);
                }
            });
        } else {
            a(normalAdParams);
        }
    }

    private void a(TextView textView) {
        if (textView == null || this.J0 == null) {
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a((Context) a(), true);
            return;
        }
        if (this.t1 == null) {
            this.t1 = new UserPresenter(me.jessyan.art.f.e.a(this));
        }
        String str = (String) textView.getTag();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1)) {
            if (this.tempCurrentId >= this.k1.size()) {
                this.tempCurrentId = this.k1.size() - 1;
            }
            ZymkChapter zymkChapter = this.k1.get(this.tempCurrentId);
            String path = zymkChapter.getPath();
            String str2 = "标题：" + zymkChapter.getName() + " chapter_path: " + path;
            this.t1.s(Message.a(this, new Object[]{Integer.valueOf(this.J0.getBook_id()), path, str, 3, 7}));
            return;
        }
        showMessage("提交反馈失败，请退出重试！");
    }

    public /* synthetic */ void a(ZymkChapter zymkChapter) {
        String strE = z.e(this.I0 + z.a + zymkChapter.getUpdated_at() + "_" + zymkChapter.getPath().replaceAll("/", "_").replaceAll(".html", ""));
        File file = new File(strE, "comic_32767.comic");
        if (file.exists() && file.delete()) {
            String str = "成功删除路径：" + strE;
        }
        b(this.J0);
    }

    private void a(float f2, ClickEvents.JoyLocks joyLocks) {
        if (this.A1[joyLocks.ordinal()] && f2 < this.C1) {
            this.A1[joyLocks.ordinal()] = false;
        }
        if (this.A1[joyLocks.ordinal()] || f2 <= this.C1) {
            return;
        }
        this.A1[joyLocks.ordinal()] = true;
        p(this.f1[this.B1[joyLocks.ordinal()]]);
    }

    private void a(MotionEvent motionEvent, int i2) {
        a(motionEvent.getAxisValue(22), ClickEvents.JoyLocks.RT);
        a(motionEvent.getAxisValue(23), ClickEvents.JoyLocks.LT);
    }

    private int a(float f2, float f3, boolean z2) {
        if (this.D1 == null) {
            this.D1 = new Point();
            getWindowManager().getDefaultDisplay().getSize(this.D1);
            Point point = this.D1;
            this.E1 = point.x / 3.0f;
            this.F1 = point.y / 3.0f;
        }
        if (this.G1 == null) {
            Point point2 = this.D1;
            int i2 = point2.x;
            int i3 = point2.y;
            this.G1 = new RectF(i2 / 4, i3 / 4, (i2 * 3) / 4, (i3 * 3) / 4);
        }
        if (this.G1.contains(f2, f3)) {
            return 11;
        }
        float f4 = this.E1;
        if (f2 < f4) {
            return z2 ? this.g1[0] : this.f1[0];
        }
        if (f2 > f4 * 2.0f) {
            return z2 ? this.g1[4] : this.f1[4];
        }
        float f5 = this.F1;
        if (f3 < f5) {
            return z2 ? this.g1[1] : this.f1[1];
        }
        if (f3 <= f5 * 2.0f) {
            return z2 ? this.g1[2] : this.f1[2];
        }
        if (L()) {
            return 11;
        }
        return z2 ? this.g1[3] : this.f1[3];
    }

    private void a(int i2, int i3) {
        d(3);
        String str = "what: " + i3;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1) && this.J0 != null) {
            if (i2 >= this.k1.size()) {
                i2 = this.k1.size() - 1;
            }
            ZymkChapter zymkChapter = this.k1.get(i2);
            if (zymkChapter != null) {
                String str2 = "mCurrentZymkChapter:" + zymkChapter.getName() + " index:" + zymkChapter.getIndex();
                com.amgcyo.cuttadon.j.g.b.a(new k("", i3, zymkChapter));
                return;
            }
            return;
        }
        i(this.J0 == null ? "获取书籍信息失败！请重试！" : "列表信息获取失败！请重试！");
    }

    protected void a(ComicChapter comicChapter) {
        if (!u0() || this.I0 <= 0 || this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(this.k1) || this.L0 == null || comicChapter == null) {
            return;
        }
        try {
            int ownerChapterIndex = comicChapter.getOwnerChapterIndex();
            if (ownerChapterIndex >= this.k1.size()) {
                ownerChapterIndex = this.k1.size() - 1;
            }
            ZymkChapter zymkChapter = this.k1.get(ownerChapterIndex);
            if (zymkChapter != null) {
                if (!zymkChapter.isRequestDanmu()) {
                    runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.comic.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2424s.N();
                        }
                    });
                    com.amgcyo.cuttadon.j.g.b.a(new a("", zymkChapter));
                } else {
                    o(zymkChapter.getDanmuCount());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(List<ComicChapter> list, int i2) {
        this.L0.a((Collection) list);
        if (i2 > list.size()) {
            i2 = list.size() - 1;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mRecyclerView.scrollToPosition(i3);
        o0();
        this.mRecyclerView.setVisibility(0);
        this.P0 = 1;
        h0();
        showGuiderByModel();
    }

    private boolean a(@LayoutRes int i2, final String str) {
        final View viewInflate = getLayoutInflater().inflate(i2, (ViewGroup) null);
        if (viewInflate == null) {
            return true;
        }
        e().addView(viewInflate, new FrameLayout.LayoutParams(-1, -1));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.comic.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2415s.a(viewInflate, str, view);
            }
        });
        return false;
    }

    public /* synthetic */ void a(final View view, String str, View view2) {
        String str2;
        if (view.getParent() != null) {
            final ViewGroup viewGroup = (ViewGroup) view.getParent();
            String str3 = str + "_fixKey";
            if (g0.a().a(str3, false)) {
                viewGroup.removeView(view);
                return;
            }
            if ("pref_stream_atb_count".equals(str)) {
                String strD = com.amgcyo.cuttadon.f.o.d(R.string.shuping_model);
                if (!isPortrait()) {
                    strD = com.amgcyo.cuttadon.f.o.d(R.string.hengping_model);
                }
                str2 = "当前翻页模式为【" + strD + "】\n请确认你是否已知晓以下操作方式：\n1：点击屏幕中央区域可呼出菜单；\n2：音量键翻页（呼出菜单-设置-更多设置）开启时，\n点击屏幕上半部分翻上页；\n点击屏幕下半部分翻下页；\n3：如果点击相关区域无效，可扩大或缩小点击区域或参考引导示意图";
            } else if ("pref_pager_ltr_count".equals(str)) {
                str2 = "当前翻页模式为【" + com.amgcyo.cuttadon.f.o.d(R.string.putong_model) + "】\n请确认你是否已知晓以下操作方式：\n1：点击屏幕中央区域可呼出菜单；\n2：点击屏幕左边或往右滑动翻上页；点击屏幕右边或往左滑动翻下页；\n3：如果点击相关区域无效，可扩大或缩小点击区域或参考引导示意图。";
            } else {
                str2 = "当前翻页模式为【" + com.amgcyo.cuttadon.f.o.d(R.string.riman_model) + "】\n请确认你是否已知晓以下操作方式：\n1：点击屏幕中央区域可呼出菜单；\n2：点击屏幕左边或往右滑动翻下页；点击屏幕右边或往左滑动翻上页；\n3：如果点击相关区域无效，可扩大或缩小点击区域或参考引导示意图。";
            }
            b1 b1Var = new b1(this.f2277w);
            b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.comic.m
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    viewGroup.removeView(view);
                }
            });
            b1Var.show();
            b1Var.a(10000L);
            b1Var.a(str2, "", "公告通知");
            g0.a().b(str3, true);
        }
    }

    private void a(NormalAdParams normalAdParams) {
        if (normalAdParams != null) {
            normalAdParams.setAdHeight(com.amgcyo.cuttadon.utils.otherutils.n.b(this.bottom_adHeight));
            normalAdParams.setSpecialAdPosition(true);
            this.ad_comics_bottom.b(normalAdParams);
        }
    }

    public /* synthetic */ void a(NormalAdParams normalAdParams, Long l2) throws Exception {
        a(normalAdParams);
    }
}
