package com.amgcyo.cuttadon.activity.read;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.BaiduTtsModel;
import com.amgcyo.cuttadon.api.entity.other.EngineInfoBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.other.ReaderPageInfo;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.api.entity.reader.BaiduTtsSpeechEvent;
import com.amgcyo.cuttadon.api.entity.reader.ReadConfig;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.service.MkReaderTtsService;
import com.amgcyo.cuttadon.soloader.SoFileLoadManager;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.dialog.t1;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.amgcyo.cuttadon.view.otherview.DarkFrameLayout;
import com.amgcyo.cuttadon.view.read.page.PageMode;
import com.amgcyo.cuttadon.view.read.page.PageView;
import com.amgcyo.cuttadon.view.read.page.j;
import com.baidu.tts.BuildConfig;
import com.fatcatfat.io.R;
import com.getkeepsafe.relinker.b;
import com.ss.android.download.api.constant.BaseConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkReadModelHActivity extends MkNovelBaseReaderActivity implements PageView.g, j.b {
    com.amgcyo.cuttadon.view.read.page.j A1;
    private ReadConfig C1;
    boolean D1;
    private TextView E1;
    private FrameLayout.LayoutParams F1;
    private View G1;
    private AdFrameLayout H1;
    private TextView I1;
    private TextView J1;
    private View K1;
    private View L1;
    private CommonShapeButton M1;
    private CommonShapeButton N1;
    private CommonShapeButton O1;
    private ConfigPresenter P1;
    private View Q1;
    private CommonShapeButton R1;
    private CommonShapeButton S1;
    private LinearLayout T1;
    protected Timer U1;
    private TextToSpeech W1;
    private com.amgcyo.cuttadon.j.h.e X1;
    private boolean Y1;
    Intent a2;
    PageView z1;
    private boolean B1 = true;
    private Handler V1 = new c(Looper.getMainLooper());
    private b.d Z1 = new b.d() { // from class: com.amgcyo.cuttadon.activity.read.j0
        @Override // com.getkeepsafe.relinker.b.d
        public final void log(String str) {
            MkReadModelHActivity.j(str);
        }
    };

    class a extends com.amgcyo.cuttadon.view.read.page.n {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f2716s;

        a(int i2) {
            this.f2716s = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MkReadModelHActivity mkReadModelHActivity = MkReadModelHActivity.this;
            if (mkReadModelHActivity.A1 == null || mkReadModelHActivity.getConfig() == null) {
                return;
            }
            MkReadModelHActivity.this.A1.a(this.f2716s);
        }
    }

    class b extends DisposableObserver<Typeface> {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Typeface typeface) {
            MkReadModelHActivity.this.A1.a(typeface);
            MkReadModelHActivity.this.hideLoading();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            MkReadModelHActivity.this.hideLoading();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            MkReadModelHActivity.this.hideLoading();
        }

        @Override // io.reactivex.observers.DisposableObserver
        protected void onStart() {
            super.onStart();
            MkReadModelHActivity.this.showLoading("努力加载中...");
        }
    }

    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                MkReadModelHActivity.this.finishBaiduTtsSpeech();
                MkReadModelHActivity.this.V0 = -1;
            }
        }
    }

    class d extends com.amgcyo.cuttadon.j.g.h.a<String, Boolean> {
        d(String str) {
            super(str);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            if (bool.booleanValue()) {
                MkReadModelHActivity.this.f0();
                return;
            }
            Integer.valueOf(1);
            String strF = SoFileLoadManager.b().f();
            String str = "最终的abiName:" + strF;
            String str2 = SoFileLoadManager.AbiType.ARM64_V8A.f().equals(strF) ? "7.21M" : "6.75M";
            final String strG = com.amgcyo.cuttadon.utils.otherutils.g.g(strF);
            String str3 = "下载路径：" + strG;
            final File file = new File(SoFileLoadManager.c().getAbsolutePath(), strG.substring(strG.lastIndexOf("/")));
            if (file.exists()) {
                MkReadModelHActivity.this.c(file);
                return;
            }
            com.amgcyo.cuttadon.f.o.a(MkReadModelHActivity.this.a(), "提示", "首次使用需下载听书插件(" + str2 + ")，是否下载？", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2733s.a(strG, file, view);
                }
            }, (View.OnClickListener) null);
        }

        public /* synthetic */ void a(String str, File file, View view) {
            MkReadModelHActivity.this.a(str, file);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Boolean a(String str) {
            try {
                return Boolean.valueOf(SoFileLoadManager.a());
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    class e implements b.c {
        e() {
        }

        @Override // com.getkeepsafe.relinker.b.c
        public void a(Throwable th) {
            MkReadModelHActivity.this.Y1 = false;
            MkReadModelHActivity.this.l("语音插件初始化失败");
            th.printStackTrace();
            th.getMessage();
            String str = " loadLibrary failure：" + th.getMessage();
        }

        @Override // com.getkeepsafe.relinker.b.c
        public void success() {
            MkReadModelHActivity.this.Y1 = true;
            MkReadModelHActivity.this.i0();
            File[] fileArrListFiles = SoFileLoadManager.c().listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    String absolutePath = file.getAbsolutePath();
                    String str = "是目录：" + absolutePath;
                    com.amgcyo.cuttadon.utils.otherutils.z.c(absolutePath);
                }
            }
        }
    }

    private void Y() {
        if (this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(y()) || this.currentChpaterId < y().size()) {
            return;
        }
        this.currentChpaterId = y().size() - 1;
    }

    private void Z() {
        com.amgcyo.cuttadon.j.g.b.a(new d(""));
    }

    private EngineInfoBean a0() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a()) {
            return new EngineInfoBean("百度离线语音", BuildConfig.LIBRARY_PACKAGE_NAME, com.amgcyo.cuttadon.f.o.d(R.string.baidu_tts_desc), true);
        }
        return null;
    }

    private String b0() {
        return com.amgcyo.cuttadon.f.o.d(R.string.click_download_plugin);
    }

    private String c0() {
        String str;
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null) {
            return "";
        }
        List<com.amgcyo.cuttadon.view.read.page.o> listJ = jVar.j();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listJ)) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            List<String> list = listJ.get(this.curPage - 1).f5317d;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
            }
            String[] strArrSplit = sb.toString().split(com.amgcyo.cuttadon.utils.otherutils.z.j());
            int length = strArrSplit.length;
            for (int i2 = 0; i2 < length; i2++) {
                str = strArrSplit[i2];
                boolean zO = com.amgcyo.cuttadon.utils.otherutils.g.o(str);
                if (str.length() > 10 && zO) {
                    break;
                }
            }
            str = "";
        }
        return !TextUtils.isEmpty(str) ? com.amgcyo.cuttadon.utils.otherutils.z.n(str) : "";
    }

    @Subscriber(mode = ThreadMode.POST, tag = "catalog_to_read")
    private void catalogToRead(MkBook mkBook) {
        finish();
    }

    private String d0() {
        return com.amgcyo.cuttadon.f.o.d(R.string.set_default_engine);
    }

    private void e0() {
        com.getkeepsafe.relinker.c cVarA = com.getkeepsafe.relinker.b.a(this.Z1);
        cVarA.a();
        cVarA.a(this.f2277w, "gnustl_shared", new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        SoFileLoadManager.a(this.f2277w);
        e0();
    }

    @SuppressLint({"SetTextI18n"})
    private void g0() {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.b(y()) || this.E0 == null || this.currentChpaterId < y().size() - 1 || this.G1 != null) {
            return;
        }
        try {
            this.G1 = getLayoutInflater().inflate(R.layout.layout_chapter_endview, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) this.G1.findViewById(R.id.ll_root);
            this.H1 = (AdFrameLayout) this.G1.findViewById(R.id.chapter_last_page_ad);
            this.I1 = (TextView) this.G1.findViewById(R.id.tv_book_status);
            TextView textView = (TextView) this.G1.findViewById(R.id.tv_desc_status);
            this.K1 = this.G1.findViewById(R.id.view_left);
            this.L1 = this.G1.findViewById(R.id.view_right);
            this.J1 = (TextView) this.G1.findViewById(R.id.tv_bottom_text);
            if (this.E0.getStatus() == 1) {
                this.I1.setText("全  书  完");
                textView.setText("THE    END");
            } else {
                this.I1.setText("作  者  努  力  更  新  中");
                textView.setText("后 面 更 精 彩    晚 点 再 来 看 看 吧");
            }
            this.I1.setTextColor(this.W0.a);
            this.M1 = (CommonShapeButton) this.G1.findViewById(R.id.shape_hy);
            this.N1 = (CommonShapeButton) this.G1.findViewById(R.id.shape_sj);
            this.O1 = (CommonShapeButton) this.G1.findViewById(R.id.shape_sc);
            this.W0 = getReaderColorStyle();
            int i2 = this.W0.f4408l;
            this.K1.setBackgroundColor(this.W0.a);
            this.L1.setBackgroundColor(this.W0.a);
            this.J1.setTextColor(this.W0.a);
            this.M1.setTextColor(-1);
            this.N1.setTextColor(-1);
            this.O1.setTextColor(-1);
            if (com.amgcyo.cuttadon.utils.otherutils.g.h0()) {
                this.M1.setmFillColor(i2);
                this.N1.setmFillColor(this.W0.f4407k);
                this.O1.setmFillColor(this.W0.f4407k);
            } else {
                this.M1.setmFillColor(this.W0.f4407k);
                this.N1.setmFillColor(i2);
                this.O1.setmFillColor(i2);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(linearLayout.getLayoutParams());
            if (com.amgcyo.cuttadon.utils.otherutils.h.I() <= 0) {
                layoutParams.addRule(13);
                linearLayout.setLayoutParams(layoutParams);
                this.H1.setVisibility(8);
            } else {
                layoutParams.addRule(10);
                layoutParams.topMargin = com.amgcyo.cuttadon.h.a.d.a;
                linearLayout.setLayoutParams(layoutParams);
                this.H1.setVisibility(0);
            }
            this.M1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2746s.n(view);
                }
            });
            this.N1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2744s.o(view);
                }
            });
            this.O1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2738s.p(view);
                }
            });
            this.z1.setAddPageView(this.G1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h0() {
        int iA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("new_person_count", 0);
        if (!this.x1 && iA <= 2) {
            showMenuPanel();
            this.x1 = true;
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("new_person_count", iA + 1);
        } else {
            if (this.x1) {
                return;
            }
            if (getTaskSourceType() > 0 || getTaskCacheType() > 0) {
                showMenuPanel();
                this.x1 = true;
            }
        }
    }

    private String i(String str) {
        return com.amgcyo.cuttadon.utils.otherutils.g.a(a(), str) ? d0() : b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar != null) {
            jVar.a(new BaiduTtsModel());
        } else {
            showMessage("参数异常！");
            finishReadActivity();
        }
    }

    static /* synthetic */ void j(String str) {
    }

    private void j0() {
        try {
            String[] list = getAssets().list("baidu_tts");
            if ((list == null || list.length <= 0) && !this.Y1) {
                Z();
            } else {
                i0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k0() {
        finish();
        if (this.E0 != null) {
            Bundle bundle = new Bundle();
            this.E0.setRead_begin(0);
            bundle.putSerializable("book", this.E0);
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_refresh_page")
    private void refreshPage(String str) {
        String str2 = "value:" + str;
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar != null) {
            jVar.b();
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "tts_color")
    private void refreshTtsColor(int i2) {
        com.amgcyo.cuttadon.view.read.page.j jVar;
        if (i2 == 0 || !this.Q0 || (jVar = this.A1) == null) {
            return;
        }
        jVar.f(i2);
        this.A1.e();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "baiduTtsEvent")
    private void setBaiduTtsEvent(BaiduTtsSpeechEvent baiduTtsSpeechEvent) {
        if (baiduTtsSpeechEvent == null || this.A1 == null) {
            return;
        }
        if (baiduTtsSpeechEvent.isStopSpeech()) {
            this.A1.a();
        } else {
            this.A1.e();
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "begin_tts")
    private void subscriberBeginReadEvent(com.amgcyo.cuttadon.view.read.page.g gVar) {
        if (gVar == null || this.A1 == null) {
            return;
        }
        this.Q0 = true;
        T();
        this.V0 = gVar.c();
        setMenuState(3);
        this.X1.a(com.amgcyo.cuttadon.utils.otherutils.g.Q());
        this.A1.a(this.X1);
        this.A1.a(PageMode.NONE);
        resetVoiceTime(getConfig().r());
        this.a2 = new Intent(a(), (Class<?>) MkReaderTtsService.class);
        this.a2.putExtra("reader_tts_bgm", getConfig().p());
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(this.a2);
        } else {
            startService(this.a2);
        }
        com.amgcyo.cuttadon.h.h.c.b(gVar.b() + " · " + gVar.a());
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_get_config")
    private void subscriberGetConfig(com.amgcyo.cuttadon.view.read.page.i iVar) {
        if (iVar == null) {
            return;
        }
        k0();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_tts_play_paused")
    private void subscriberPlayPaused(com.amgcyo.cuttadon.utils.event.a aVar) {
        if (aVar == null || this.A1 == null) {
            return;
        }
        String str = "subscriberPlayPaused:" + aVar.a();
        if (aVar.a()) {
            this.A1.z();
        } else {
            this.A1.v();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected View C() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.pageview, (ViewGroup) null, false);
        this.z1 = (PageView) viewInflate.findViewById(R.id.read_pv_page);
        viewInflate.setId(R.id.reader_view);
        return viewInflate;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void K() {
        if (this.C1 == null || this.A1 == null || y() == null || this.E0 == null) {
            return;
        }
        this.C1.setChapterList(y());
        this.A1.g(1);
        this.A1.x();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void M() {
        if (this.E0 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", this.E0);
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
        finish();
    }

    public /* synthetic */ void X() {
        this.C1.setRead_begin(this.E0.getRead_begin());
        this.C1.setCurrentChapterId(this.E0.getReading_chapter_key());
        this.A1.a(this.C1);
        this.A1.x();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyAnim(int i2) {
        super.applyAnim(i2);
        if (this.A1 == null) {
            return;
        }
        String str = "index: " + i2;
        if (i2 != PageMode.SCROLL.ordinal()) {
            this.A1.d(i2);
        } else {
            H();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyBaiduReadVoicer() {
        super.applyBaiduReadVoicer();
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null) {
            return;
        }
        jVar.b(getConfig().d());
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyBaiduSpeed(int i2) {
        this.speed = i2;
        if (this.A1 == null) {
            return;
        }
        int i3 = this.V0;
        if (i3 == 0) {
            String str = "baidu speed: " + i2;
            this.A1.h(i2);
            this.A1.b("");
            return;
        }
        if (i3 == 1 && this.X1 != null) {
            String str2 = "tts speed: " + i2;
            if (i2 <= 0) {
                i2 = 1;
            }
            com.amgcyo.cuttadon.utils.otherutils.g.q(i2);
            this.A1.h(i2);
            this.A1.a(this.X1);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyColorStyle(String str) {
        super.applyColorStyle(str);
        if (this.A1 == null) {
            return;
        }
        this.W0 = getReaderColorStyle();
        this.A1.a(this.W0);
        try {
            int i2 = this.W0.f4408l;
            if (this.G1 != null && this.K1 != null && this.O1 != null) {
                this.K1.setBackgroundColor(this.W0.a);
                this.L1.setBackgroundColor(this.W0.a);
                this.J1.setTextColor(this.W0.a);
                this.I1.setTextColor(this.W0.a);
                this.M1.setTextColor(-1);
                this.N1.setTextColor(-1);
                this.O1.setTextColor(-1);
                if (com.amgcyo.cuttadon.utils.otherutils.g.h0()) {
                    this.M1.setmFillColor(i2);
                    this.N1.setmFillColor(this.W0.f4407k);
                    this.O1.setmFillColor(this.W0.f4407k);
                } else {
                    this.M1.setmFillColor(this.W0.f4407k);
                    this.N1.setmFillColor(i2);
                    this.O1.setmFillColor(i2);
                }
            }
            if (this.R1 != null) {
                this.R1.setTextColor(-1);
                this.R1.setmFillColor(this.W0.f4407k);
            }
            if (this.S1 != null) {
                this.S1.setTextColor(-1);
                this.S1.setmFillColor(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyFont(final String str) {
        if (this.A1 == null || this.f2276v == 0) {
            return;
        }
        obtainPresenter().a((Disposable) Observable.create(new ObservableOnSubscribe() { // from class: com.amgcyo.cuttadon.activity.read.o0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.a(str, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b()));
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyFontSize(int i2) {
        super.applyFontSize(i2);
        if (this.A1 == null) {
            return;
        }
        String str = "index: " + i2;
        this.A1.e(i2);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyLayoutStyle(int i2) {
        super.applyLayoutStyle(i2);
        if (this.A1 == null) {
            return;
        }
        String str = "layoutStyle: " + i2;
        this.A1.b(i2);
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applyNextChapterClick() {
        if (this.A1 == null || this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
            return;
        }
        int i2 = this.currentChpaterId + 1;
        if (i2 >= y().size()) {
            showMessage("已经是最后一章了...");
        } else {
            a(i2, true);
            hideMenuPanel(true);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyOrientation() {
        if (this.E0 == null) {
            return;
        }
        String strC0 = c0();
        Bundle bundle = new Bundle();
        this.E0.setUpdated(8);
        bundle.putSerializable("book", this.E0);
        bundle.putString("getCurrentPageFirstLineText", strC0);
        finish();
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applyPreChapterClick() {
        if (this.A1 == null || this.f2276v == 0) {
            return;
        }
        int i2 = this.currentChpaterId - 1;
        if (i2 < 0) {
            showMessage("已经是第一章了...");
        } else {
            a(i2, false);
            hideMenuPanel(true);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyProgress(int i2) {
        super.applyProgress(i2);
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null || i2 == jVar.h()) {
            return;
        }
        this.A1.j(i2);
        hideMenuPanel(true);
    }

    @Override // com.amgcyo.cuttadon.g.h
    public void applySkipToChapter(MkCatalog mkCatalog) {
        if (this.A1 == null || this.f2276v == 0 || mkCatalog == null) {
            return;
        }
        b(mkCatalog);
        hideMenuPanel(true);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void applyStrTraditional(boolean z2) {
        super.applyStrTraditional(z2);
        if (this.A1 == null) {
            return;
        }
        if (z2) {
            showMessage("切换繁体");
        } else {
            showMessage("切换简体");
        }
        this.A1.a(z2);
    }

    public void baiduTTS() {
        this.Q0 = true;
        T();
        this.V0 = 0;
        setMenuState(3);
        this.A1.b(getConfig().d());
        resetVoiceTime(getConfig().r());
        this.a2 = new Intent(a(), (Class<?>) MkReaderTtsService.class);
        this.a2.putExtra("reader_tts_bgm", getConfig().p());
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(this.a2);
        } else {
            startService(this.a2);
        }
        com.amgcyo.cuttadon.h.h.c.b("baidu_tts");
    }

    protected void c(boolean z2) {
        EngineInfoBean engineInfoBeanA0;
        String strE = com.amgcyo.cuttadon.utils.otherutils.h.e("iflytek_tts_url");
        if (TextUtils.isEmpty(strE)) {
            strE = "http://www.iyuji.cn/iyuji/home";
        }
        String str = strE;
        ArrayList arrayList = new ArrayList();
        String str2 = "是否要添加百度语音：" + z2;
        if (z2 && (engineInfoBeanA0 = a0()) != null) {
            engineInfoBeanA0.setBtn_title("点击开始听书");
            arrayList.add(engineInfoBeanA0);
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new EngineInfoBean("讯飞语记", "com.iflytek.vflynote", "注意：使用该引擎请启动讯飞语记开启【电话权限】和【存储权限】否则会出现朗读无声音、快速翻页、跳段等问题！", str, i("com.iflytek.vflynote")));
        }
        com.amgcyo.cuttadon.utils.otherutils.h.m();
        com.amgcyo.cuttadon.view.dialog.e1 e1Var = new com.amgcyo.cuttadon.view.dialog.e1(this);
        e1Var.show();
        e1Var.a(arrayList);
        e1Var.a(new t1.c() { // from class: com.amgcyo.cuttadon.activity.read.n0
            @Override // com.amgcyo.cuttadon.view.dialog.t1.c
            public final void a(EngineInfoBean engineInfoBean) {
                this.a.a(engineInfoBean);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public void cancel() {
        if (this.chapter_page == null || this.rl_top_bar == null) {
            return;
        }
        this.curPage--;
        if (this.curPage <= 0) {
            this.curPage = 1;
        }
        this.chapter_page.setText("第" + this.curPage + "/" + this.totalPage + "页");
        this.rl_top_bar.setVisibility(0);
        this.ll_bottom.setVisibility(0);
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public void center() {
        LinearLayout linearLayout = this.ll_coin_tips;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.ll_coin_tips.setVisibility(8);
        }
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null) {
            showMessage("阅读器内部异常，请重试!");
            finish();
        } else if (jVar.k()) {
            showMenuPanel();
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public void exemptNovelAd() {
        e("position_reward_ad_video");
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public void exitReader() {
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void finishAutoRead() {
        super.finishAutoRead();
        Timer timer = this.U1;
        if (timer != null) {
            timer.cancel();
        }
        W();
        this.isAutoRead = false;
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar != null) {
            jVar.d(getConfig().m().ordinal());
        }
        showMessage(com.amgcyo.cuttadon.f.o.d(R.string.str_quit_auto_read));
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void finishBaiduTtsSpeech() {
        super.finishBaiduTtsSpeech();
        if (this.A1 == null || getConfig() == null) {
            return;
        }
        if (this.V0 == 0) {
            this.A1.d();
        } else {
            com.amgcyo.cuttadon.j.h.e eVar = this.X1;
            if (eVar != null) {
                eVar.release();
            }
        }
        hideMenuPanel(true);
        setMenuState(1);
        this.A1.d(getConfig().m().ordinal());
        this.A1.E();
        showMessage(com.amgcyo.cuttadon.f.o.d(R.string.str_quit_tts_read));
        this.V0 = -1;
        this.Q0 = false;
        Intent intent = this.a2;
        if (intent != null) {
            stopService(intent);
        }
        W();
        L();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public View getAddPageView() {
        return this.G1;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public com.amgcyo.cuttadon.view.read.page.j getBasePageLoader() {
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        return jVar != null ? jVar : super.getBasePageLoader();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public FrameLayout getContentView(NormalAdParams normalAdParams, boolean z2) {
        DarkFrameLayout darkFrameLayout = this.chapterContentAdView;
        if (darkFrameLayout == null || normalAdParams == null) {
            showMessage("参数异常，请重新启动APP后重试！");
            finish();
            return null;
        }
        if (z2) {
            darkFrameLayout.removeAllViews();
            com.amgcyo.cuttadon.view.read.page.l.a(this.chapterContentAdView);
            if (this.F1 == null) {
                int iA = com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f);
                this.F1 = new FrameLayout.LayoutParams(-1, -2);
                FrameLayout.LayoutParams layoutParams = this.F1;
                layoutParams.leftMargin = iA;
                layoutParams.rightMargin = iA;
                layoutParams.topMargin = Math.round(com.amgcyo.cuttadon.utils.otherutils.n.a(this) / 9.0f);
                FrameLayout.LayoutParams layoutParams2 = this.F1;
                layoutParams2.gravity = 49;
                this.chapterContentAdView.setLayoutParams(layoutParams2);
            }
            normalAdParams.setSelfAdPosition(com.amgcyo.cuttadon.f.n.E);
            this.chapterContentAdView.b(normalAdParams);
        }
        return this.chapterContentAdView;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public View getErrorView() {
        try {
            if (this.W0 == null) {
                this.W0 = getReaderColorStyle();
            }
            if (this.Q1 == null) {
                this.Q1 = getLayoutInflater().inflate(R.layout.layout_change_source, (ViewGroup) null);
                this.R1 = (CommonShapeButton) this.Q1.findViewById(R.id.btn_quhy);
                this.S1 = (CommonShapeButton) this.Q1.findViewById(R.id.btn_feedback);
                this.T1 = (LinearLayout) this.Q1.findViewById(R.id.ll_error);
                this.S1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2753s.j(view);
                    }
                });
            }
            if (this.S1 == null) {
                return null;
            }
            this.R1.setmFillColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
            this.S1.setmFillColor(com.amgcyo.cuttadon.f.o.b(R.color.danmu_blue));
            return this.Q1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public TextView getLoadingAdText() {
        if (this.E1 == null) {
            this.E1 = new TextView(this);
            this.E1.setLineSpacing(0.0f, 1.5f);
            this.E1.setTextSize(14.0f);
            this.E1.setGravity(17);
            this.E1.setLayoutParams(new ViewGroup.LayoutParams(-2, com.amgcyo.cuttadon.utils.otherutils.n.a(a()) / 3));
        }
        List<BaseAd> listZ = com.amgcyo.cuttadon.utils.otherutils.h.Z();
        int iB = com.amgcyo.cuttadon.h.a.i.b(1);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.b(listZ) || iB <= 0) {
            this.E1.setText("正在努力加载中...");
        } else {
            this.E1.setText(String.format(Locale.getDefault(), "正在努力加载中...\n推荐您观看小视频免%d分钟广告", Integer.valueOf(iB)));
        }
        this.W0 = getReaderColorStyle();
        this.E1.setTextColor(this.W0.b);
        return this.E1;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public PageView getPageView() {
        return this.z1;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull me.jessyan.art.mvp.Message message) {
        NormalAdParams normalAdParamsC;
        AdFrameLayout adFrameLayout;
        com.amgcyo.cuttadon.view.read.page.j jVar;
        super.handleMessage(message);
        hideLoading();
        if (this.E0 == null) {
            return;
        }
        int i2 = message.f21197s;
        if (i2 == 827) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPresenter:");
            sb.append(this.f2276v != 0);
            sb.toString();
            if (this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
                com.amgcyo.cuttadon.view.read.page.j jVar2 = this.A1;
                if (jVar2 != null) {
                    jVar2.c(7);
                    return;
                }
                return;
            }
            this.C1.setChapterList(y());
            this.i1 = y().size();
            this.k1 = ((MkChapterContent) message.f21202x).getName();
            openBookChapter();
            return;
        }
        if (i2 == 863) {
            com.amgcyo.cuttadon.view.read.page.j jVar3 = this.A1;
            if (jVar3 != null) {
                jVar3.c(3);
                return;
            }
            return;
        }
        if (i2 == 891) {
            if (this.Q0) {
                finishBaiduTtsSpeech();
            }
            MkBook mkBook = (MkBook) message.f21202x;
            if (mkBook == null || this.f2277w == null) {
                return;
            }
            if (mkBook.getUpdated() == 0) {
                finish();
                Bundle bundle = new Bundle();
                mkBook.setRead_begin(0);
                mkBook.setReading_chapter_key(mkBook.getReading_chapter_key() + 1);
                mkBook.setUpdated(0);
                bundle.putSerializable("book", mkBook);
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
                return;
            }
            if ((com.amgcyo.cuttadon.utils.otherutils.h.I() > 0 && (adFrameLayout = this.H1) != null && adFrameLayout.getVisibility() == 0 && this.H1.getChildCount() <= 0) && (normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c()) != null) {
                normalAdParamsC.setSelfAdPosition(com.amgcyo.cuttadon.f.n.D);
                this.H1.b(normalAdParamsC);
            }
            PageView pageView = this.z1;
            if (pageView != null) {
                pageView.b();
                return;
            }
            return;
        }
        if (i2 != 893) {
            return;
        }
        this.D1 = false;
        MkChapterContent mkChapterContent = (MkChapterContent) message.f21202x;
        if (mkChapterContent == null || (jVar = this.A1) == null || com.amgcyo.cuttadon.utils.otherutils.g.a(jVar.i()) || this.M0 == null) {
            return;
        }
        this.k1 = mkChapterContent.getName();
        if (TextUtils.isEmpty(mkChapterContent.getError_msg())) {
            String str = "重试成功 章节名称是：" + this.k1;
        } else {
            String str2 = "重试失败 章节名称是：" + this.k1;
            this.M0.setOnErrorReturn(true);
            this.A1.i().remove(mkChapterContent.getCatalogId());
            this.A1.i().add(mkChapterContent.getCatalogId(), this.M0);
        }
        this.A1.g(1);
        ReadConfig readConfig = this.C1;
        if (readConfig != null) {
            readConfig.setRead_begin(0);
        }
        this.A1.a(this.C1);
        this.A1.x();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        com.amgcyo.cuttadon.utils.otherutils.n.a(this);
        this.z1.setTouchListener(this);
        this.C1 = new ReadConfig(this.E0.getName(), this.E0.getBook_id(), this.currentChpaterId, this.E0.getRead_begin(), this.E0.getReading_site_id(), false, this.I0);
        this.C1.setFrom_unlock_activity(this.F0);
        this.A1 = this.z1.a(this.C1, this, getConfig(), this.T0);
        if (!TextUtils.isEmpty(this.P0)) {
            this.P0 = com.amgcyo.cuttadon.utils.otherutils.z.n(this.P0);
        }
        this.A1.c(this.P0);
        this.B1 = true;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public boolean isListenTobooks() {
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        return jVar != null && jVar.n();
    }

    public /* synthetic */ void j(View view) {
        if (BaseTitleBarActivity.v()) {
            return;
        }
        I();
    }

    public /* synthetic */ void k(View view) {
        String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        Toast.makeText(this.f2277w, "正在通过系统浏览器下载", 0).show();
        com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, strC0);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    protected void l(int i2) {
        PageView pageView = this.z1;
        if (pageView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pageView.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, i2);
        this.z1.setLayoutParams(layoutParams);
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void loadChapterAgain(int i2) {
        MkCatalog mkCatalog;
        MkBook mkBook;
        if (this.f2276v == 0 || com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
            showMessage("数据异常，请退出重试!");
            finish();
            return;
        }
        this.M0 = y().get(i2);
        if (this.D1 || (mkCatalog = this.M0) == null || (mkBook = this.E0) == null) {
            return;
        }
        a(mkCatalog, mkBook, false);
    }

    protected void loadData() {
        obtainPresenter().h(me.jessyan.art.mvp.Message.a(this, new Object[]{Boolean.valueOf(this.B1), this.E0, Integer.valueOf(this.currentChpaterId)}));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public /* synthetic */ void m(View view) {
        CharSequence text = this.R1.getText();
        if (text == null) {
            return;
        }
        String string = text.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        byte b2 = -1;
        switch (string.hashCode()) {
            case 21416041:
                if (string.equals("去换源")) {
                    b2 = 0;
                }
                break;
            case 881040266:
                if (string.equals("点击重试")) {
                    b2 = 1;
                }
                break;
            case 957852996:
                if (string.equals("立即更新")) {
                    b2 = 2;
                }
                break;
            case 1138032578:
                if (string.equals("重新获取")) {
                    b2 = 3;
                }
                break;
        }
        if (b2 == 0) {
            startSourcePopup();
            return;
        }
        if (b2 == 1) {
            k0();
            return;
        }
        if (b2 == 2) {
            showLoading();
            getArtAppVersionMethod();
        } else {
            if (b2 != 3) {
                return;
            }
            if (!networkisAvailable()) {
                c("网络不可用，请检查网络连接后重试或点击稍后获取！");
                return;
            }
            showLoading();
            if (this.P1 == null) {
                this.P1 = new ConfigPresenter(me.jessyan.art.f.e.a(this));
            }
            this.P1.b(me.jessyan.art.mvp.Message.a(this, new Object[]{true, string}));
        }
    }

    public /* synthetic */ void n(View view) {
        startSourcePopup();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public boolean nextPage() {
        LinearLayout linearLayout = this.ll_coin_tips;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.ll_coin_tips.setVisibility(8);
            return false;
        }
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null) {
            return false;
        }
        if (!jVar.o()) {
            return this.A1.g() != 1;
        }
        showMessage("请观看小视频解锁后续章节");
        if (this.isAutoRead) {
            finishAutoRead();
        }
        if (this.Q0) {
            finishBaiduTtsSpeech();
        }
        return false;
    }

    public /* synthetic */ void o(View view) {
        finish();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void onChapterChange(int i2) {
        StringBuilder sb;
        String str;
        MkBook mkBook = this.E0;
        if (mkBook == null) {
            return;
        }
        this.D1 = false;
        this.currentChpaterId = i2;
        a(mkBook, this.currentChpaterId);
        N();
        this.E0.setReading_chapter_key(this.currentChpaterId);
        try {
            if (this.f2276v != 0 && !com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
                Y();
                this.M0 = y().get(this.currentChpaterId);
                this.O0 = this.M0.getPath();
                this.N0 = this.M0.getUrl();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        MkCatalog mkCatalog = this.M0;
        if (mkCatalog != null) {
            this.k1 = mkCatalog.getName();
        }
        d(1);
        if (z().a(this.E0.getReading_chapter_key(), this.k1, this.E0.getBook_id()) > 0) {
            sb = new StringBuilder();
            str = "章节改变时，保存章节信息成功";
        } else {
            sb = new StringBuilder();
            str = "章节改变时，保存章节信息失败...";
        }
        sb.append(str);
        sb.append(this.k1);
        sb.toString();
        if (this.A1.m()) {
            this.E0.setRead_begin(0);
            loadData();
        } else {
            j(i2);
        }
        h0();
        g0();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void onColorChange(int i2, int i3, int i4) {
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar != null) {
            jVar.c();
            this.A1.y();
        }
        Intent intent = this.a2;
        if (intent != null) {
            stopService(intent);
        }
        TextToSpeech textToSpeech = this.W1;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void onErrorShowView(Bitmap bitmap, float f2, int i2, int i3, int i4, int i5, String str) {
        if (f2 <= 0.0f) {
            return;
        }
        if (this.Q1 == null) {
            this.Q1 = getErrorView();
        }
        if (this.Q1 == null || this.T1 == null || this.z1 == null) {
            return;
        }
        int iC = com.amgcyo.cuttadon.utils.otherutils.n.c(a()) / 6;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.T1.getLayoutParams());
        layoutParams.height = com.amgcyo.cuttadon.utils.otherutils.n.a(38.0f) * 3;
        layoutParams.setMargins(iC, i3, iC, 0);
        this.T1.setLayoutParams(layoutParams);
        this.R1.setText(str);
        if ("点击重试".equals(str)) {
            this.S1.setVisibility(4);
        } else {
            this.S1.setVisibility(0);
        }
        if ("立即更新".equals(str)) {
            this.S1.setText("官网更新");
            this.S1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2739s.k(view);
                }
            });
        } else if ("重新获取".equals(str)) {
            this.S1.setText("稍后获取");
            this.S1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2747s.l(view);
                }
            });
        }
        this.R1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2741s.m(view);
            }
        });
        this.z1.a(this.Q1, bitmap, i3);
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void onFinishedSetPageInfo(ReaderPageInfo readerPageInfo, NormalAdParams normalAdParams) {
        TextView textView;
        if (this.A1 == null || readerPageInfo == null) {
            if (this.read_count == null || (textView = this.chapter_name) == null) {
                return;
            }
            textView.setText("暂无章节信息");
            this.read_count.setText("正在计算...");
            return;
        }
        int cur = readerPageInfo.getCur();
        int size = readerPageInfo.getSize();
        int totalPageSize = readerPageInfo.getTotalPageSize();
        int interval_count = readerPageInfo.getInterval_count();
        int style = readerPageInfo.getStyle();
        MkBook mkBook = this.E0;
        if (mkBook != null) {
            mkBook.setRead_begin(cur);
        }
        a(cur, size, totalPageSize, interval_count, style, normalAdParams);
        com.amgcyo.cuttadon.view.read.page.o oVar = this.A1.f5278h;
        if (oVar == null || !oVar.f5318e) {
            this.rl_top_bar.setVisibility(0);
            this.ll_bottom.setVisibility(0);
        } else {
            this.rl_top_bar.setVisibility(8);
            this.ll_bottom.setVisibility(8);
        }
        this.curPage = cur;
        this.totalPage = size;
        this.chapter_page.setText("第" + cur + "/" + size + "页");
        if (cur == 1) {
            String strN = com.amgcyo.cuttadon.utils.otherutils.z.n(this.E0.getName());
            if (TextUtils.isEmpty(strN)) {
                strN = this.E0.getName();
            }
            this.chapter_name.setText(strN);
        } else {
            String chapterName = readerPageInfo.getChapterName();
            if (!TextUtils.isEmpty(chapterName)) {
                this.chapter_name.setText(chapterName);
            }
        }
        Q();
        String str = "currentChpaterId: " + this.currentChpaterId;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void onHideStatusBar(boolean z2, Canvas canvas) {
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.Q0 || this.isAutoRead || this.A1 == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (i2 == 24 || i2 == 25) {
            final boolean[] zArr = {com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volume", false)};
            boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volum_click", false);
            if (!zArr[0] && !zA) {
                com.amgcyo.cuttadon.f.o.a(a(), "提示", "是否启用音量键翻页?也可呼出菜单选择“阅读设置”-“更多设置“中开启”", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.r0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MkReadModelHActivity.a(zArr, view);
                    }
                }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.m0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MkReadModelHActivity.b(zArr, view);
                    }
                });
            }
            if (i2 != 24) {
                if (i2 == 25 && zArr[0]) {
                    return this.A1.C();
                }
            } else if (zArr[0]) {
                return this.A1.D();
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.Q0 || this.isAutoRead) {
            return super.onKeyUp(i2, keyEvent);
        }
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_open_volume", false);
        return (i2 == 25 || i2 == 24) ? zA : super.onKeyUp(i2, keyEvent);
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        int iH = jVar != null ? jVar.h() : 0;
        if (this.E0 == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        this.E0.setReading_chapter_key(this.currentChpaterId);
        this.E0.setReading_datetime(jCurrentTimeMillis);
        this.E0.setRead_begin(iH);
        this.E0.setVertical_top(0);
        if (z().a(this.currentChpaterId, jCurrentTimeMillis, this.E0.getBook_id(), iH, 0) > 0) {
            String str = "onPause页面停止时，保存章节信息成功,章节id：" + this.currentChpaterId;
        }
        me.jessyan.art.d.f.a().a(new MkCommentEvent(), "tag_bookshelf__operate");
        if (this.isAutoRead && getMenuState() == 6 && this.U1 != null) {
            finishAutoRead();
        }
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("shelf_book", this.E0.getBook_id());
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("book", this.E0);
        super.onSaveInstanceState(bundle);
    }

    public void openBookChapter() {
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null || jVar.g() != 1 || y() == null) {
            return;
        }
        this.z1.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2736s.X();
            }
        });
        if (this.G0 != -1) {
            chooseListenerType();
        }
    }

    public /* synthetic */ void p(View view) {
        MkBook mkBook = this.E0;
        me.jessyan.art.d.f.a().a(new com.amgcyo.cuttadon.view.read.page.i(mkBook != null ? mkBook.getForm() : 1), "tag_read_activity_to_book_city");
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void pauseAutoRead(boolean z2) {
        super.pauseAutoRead(z2);
        Timer timer = this.U1;
        if (timer == null) {
            return;
        }
        if (z2) {
            timer.cancel();
        } else {
            m(this.speed);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public boolean prePage() {
        LinearLayout linearLayout = this.ll_coin_tips;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.ll_coin_tips.setVisibility(8);
            return false;
        }
        com.amgcyo.cuttadon.view.read.page.j jVar = this.A1;
        if (jVar == null || !jVar.o()) {
            return true;
        }
        showMessage("请观看小视频解锁后续章节");
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void resetVoiceTime(int i2) {
        super.resetVoiceTime(i2);
        hideMenuPanel(false);
        this.V1.removeMessages(1);
        int iL = com.amgcyo.cuttadon.view.read.page.k.l(i2);
        if (iL > 0) {
            showMessage((iL / BaseConstants.Time.MINUTE) + "分钟后自动关闭语音朗读");
            this.V1.sendEmptyMessageDelayed(1, (long) iL);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j.b
    public void showChapterInfo(boolean z2) {
        if (z2) {
            showMessage(com.amgcyo.cuttadon.f.o.d(R.string.no_pre_chapter));
        } else {
            showLoading(com.amgcyo.cuttadon.f.o.d(R.string.check_update));
            obtainPresenter().f(me.jessyan.art.mvp.Message.a(this, new Object[]{this.E0, 891}));
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void showTtsEngine(final boolean z2) {
        if (this.A1 == null) {
            return;
        }
        this.W1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() { // from class: com.amgcyo.cuttadon.activity.read.s0
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i2) {
                this.a.a(z2, i2);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity
    public void startAutoRead(int i2, int i3, boolean z2) {
        super.startAutoRead(i2, i3, z2);
        if (this.A1 == null) {
            return;
        }
        String str = "hideMenuPanel：" + z2;
        if (z2) {
            hideMenuPanel(false);
        }
        this.A1.a(PageMode.AutoPage);
        this.isAutoRead = true;
        this.speed = i3;
        setMenuState(6);
        Timer timer = this.U1;
        if (timer != null) {
            timer.cancel();
        }
        m(i3);
        T();
    }

    @Override // com.amgcyo.cuttadon.g.i
    public void subMitrecordTime(int i2) {
        if (this.f2276v == 0 || TextUtils.isEmpty(this.O0) || this.f2277w == null || this.E0 == null || com.amgcyo.cuttadon.utils.otherutils.g.j() == null || !me.jessyan.art.f.f.c(this.f2277w)) {
            return;
        }
        String str = "是否语音朗读：" + this.Q0 + " 是否自动阅读：" + this.isAutoRead;
        if (this.Q0 || this.isAutoRead || !com.amgcyo.cuttadon.utils.otherutils.h.P0()) {
            return;
        }
        obtainPresenter().i(me.jessyan.art.mvp.Message.a(this, new Object[]{Integer.valueOf(this.E0.getBook_id()), this.O0, this.E0.getReading_site_id(), Integer.valueOf(i2), 906, Integer.valueOf(this.E0.getForm())}));
    }

    @Override // com.amgcyo.cuttadon.view.read.page.PageView.g
    public void unlockChapter(Slippage slippage) {
        a(slippage);
    }

    private void b(MkCatalog mkCatalog) {
        int catalogId = mkCatalog.getCatalogId();
        this.E0.setReading_chapter_key(catalogId);
        this.E0.setRead_begin(0);
        this.A1.i(catalogId);
    }

    private void k(String str) {
        final File file = new File(com.amgcyo.cuttadon.utils.otherutils.z.h(), str.substring(str.lastIndexOf("/")));
        if (file.exists()) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this, file);
        } else {
            new com.amgcyo.cuttadon.j.b.c(this, file.getAbsolutePath(), new com.amgcyo.cuttadon.j.b.b() { // from class: com.amgcyo.cuttadon.activity.read.q0
                @Override // com.amgcyo.cuttadon.j.b.b
                public final void a() {
                    this.a.b(file);
                }
            }).execute(str);
        }
    }

    public /* synthetic */ void l(View view) {
        if (this.M0 != null && this.E0 != null) {
            String str = "later_" + this.E0.getBook_id() + this.M0.getCatalogId();
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(str, true);
            String str2 = "key:" + str + " value: " + com.amgcyo.cuttadon.utils.otherutils.g0.a().a(str, false);
            k0();
            return;
        }
        showMessage("参数异常，请重试！");
        finish();
    }

    private void a(int i2, boolean z2) {
        if (z2) {
            this.A1.A();
        } else {
            this.A1.B();
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(y())) {
            return;
        }
        try {
            showMessage(y().get(i2).getName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void b(EngineInfoBean engineInfoBean) {
        if (b0().equals(engineInfoBean.getBtn_title())) {
            String strM = com.amgcyo.cuttadon.utils.otherutils.h.m();
            if (!TextUtils.isEmpty(strM)) {
                showMessage("请使用浏览器下载！");
                com.amgcyo.cuttadon.view.webview.b.startActivity(a(), strM);
                return;
            } else {
                showMessage("该TTS引擎已下线。");
                return;
            }
        }
        if (engineInfoBean.isIs_baidu_tts()) {
            j0();
        } else {
            this.X1 = com.amgcyo.cuttadon.j.h.d.a(this, this.A1, engineInfoBean);
        }
    }

    private void a(int i2, int i3, int i4, int i5, int i6, NormalAdParams normalAdParams) {
        BaseAd baseAd;
        if (normalAdParams == null || !normalAdParams.isChapingAd()) {
            return;
        }
        if (i6 != 2) {
            if (i6 == 1 && i2 == 1 && (baseAd = normalAdParams.getBaseAd()) != null) {
                normalAdParams.setChapingAd(false);
                com.amgcyo.cuttadon.h.a.h.a(this.f2277w, normalAdParams.getAdPosition(), baseAd);
                return;
            }
            return;
        }
        if (i2 <= 0 || i4 <= 0) {
            return;
        }
        String str = i4 + " " + i5;
        int i7 = i2 + i4;
        String str2 = " pageSize " + i7;
        if (i5 <= 0 || i7 % (i5 + 1) != 0) {
            return;
        }
        String str3 = i3 + " 是插屏广告并且满足隔页要求，添加广告对象";
        BaseAd baseAd2 = normalAdParams.getBaseAd();
        if (baseAd2 != null) {
            com.amgcyo.cuttadon.h.a.h.a(this.f2277w, normalAdParams.getAdPosition(), baseAd2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final String str) {
        final String strC = com.amgcyo.cuttadon.sdk.utils.g.c("tterr_pk");
        String str2 = "下载路径：" + strC;
        if (!TextUtils.isEmpty(strC)) {
            runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2758s.a(str, strC);
                }
            });
            return;
        }
        showMessage(str + " ，请反馈给客服！");
    }

    private void m(int i2) {
        this.U1 = new Timer();
        this.U1.schedule(new a(i2), 0L, i2);
    }

    public /* synthetic */ void b(File file) {
        if (file.exists()) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(a(), file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.y0.a(file.getAbsolutePath(), file.getParent());
        String str = "文件存在，解压缩状态：" + zA;
        if (zA) {
            f0();
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("baidu_tts_download_path", file.getAbsolutePath());
        } else {
            l("语音插件解压失败！");
        }
    }

    static /* synthetic */ void b(boolean[] zArr, View view) {
        zArr[0] = false;
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_open_volum_click", true);
    }

    public /* synthetic */ void a(String str, ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(g(str));
        observableEmitter.onComplete();
    }

    public /* synthetic */ void a(boolean z2, int i2) {
        TextToSpeech textToSpeech = this.W1;
        if (textToSpeech != null && i2 == 0) {
            a(this.W1.getEngines(), z2, textToSpeech.getDefaultEngine());
        } else {
            c(z2);
        }
    }

    protected void a(List<TextToSpeech.EngineInfo> list, boolean z2, String str) {
        String str2;
        EngineInfoBean engineInfoBeanA0;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            String str3 = "tts引擎数量：" + list.size() + " 首选引擎为：" + str;
            ArrayList arrayList = new ArrayList();
            String str4 = "是否要添加百度语音：" + z2;
            if (z2 && (engineInfoBeanA0 = a0()) != null) {
                arrayList.add(engineInfoBeanA0);
            }
            for (TextToSpeech.EngineInfo engineInfo : list) {
                String str5 = engineInfo.name;
                String str6 = engineInfo.label;
                String str7 = str5 + " " + engineInfo.label;
                switch (str5) {
                    case "com.iflytek.speechsuite":
                        str2 = "部分机型自带语音引擎，内核大部分为讯飞语音。";
                        break;
                    case "com.iflytek.vflynote":
                        str2 = "注意：使用该引擎请启动讯飞语记开启【电话权限】和【存储权限】否则会出现朗读无声音、快速翻页、跳段等问题！";
                        break;
                    case "com.xiaomi.mibrain.speech":
                        str2 = "小米手机自带语音合成引擎。";
                        break;
                    case "com.google.android.tts":
                        str2 = "Google语音合成，需要下载中文语音包数据，部分地区可能无法正常使用。";
                        break;
                    case "com.baidu.duersdk.opensdk":
                        str2 = "度秘语音引擎，因系统版本不同，部分机型可能无法正常使用。";
                        break;
                    case "com.vivo.agent":
                    case "com.vivo.aiservice":
                        str2 = "vivo手机自带语音引擎，因系统版本不同，部分机型可能无法正常使用。";
                        break;
                    default:
                        str2 = "暂无相关说明，如果无法正常听书，请向该语音合成引擎提供商咨询或反馈给客服！";
                        break;
                }
                arrayList.add(new EngineInfoBean(str6, str5, str2, false));
            }
            com.amgcyo.cuttadon.utils.otherutils.h.m();
            t1 t1Var = new t1(this);
            t1Var.show();
            t1Var.a(arrayList);
            t1Var.a(new t1.c() { // from class: com.amgcyo.cuttadon.activity.read.t0
                @Override // com.amgcyo.cuttadon.view.dialog.t1.c
                public final void a(EngineInfoBean engineInfoBean) {
                    this.a.b(engineInfoBean);
                }
            });
            return;
        }
        c(z2);
    }

    public /* synthetic */ void a(EngineInfoBean engineInfoBean) {
        String url = engineInfoBean.getUrl();
        String str = "下载链接：" + url;
        if (engineInfoBean.isIs_baidu_tts()) {
            j0();
            return;
        }
        if (b0().equals(engineInfoBean.getBtn_title())) {
            if ("com.iflytek.vflynote".equals(engineInfoBean.getPage_name())) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(a(), engineInfoBean.getPage_name(), url);
                return;
            } else {
                showMessage("请使用浏览器下载！");
                com.amgcyo.cuttadon.view.webview.b.startActivity(a(), url);
                return;
            }
        }
        Toast.makeText(this.f2277w, "请将【" + engineInfoBean.getZh_cn_name() + "】设置为首选引擎", 0).show();
        com.amgcyo.cuttadon.utils.otherutils.g.e((Activity) this.f2277w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final File file) {
        new com.amgcyo.cuttadon.j.b.c(this, file.getAbsolutePath(), new com.amgcyo.cuttadon.j.b.b() { // from class: com.amgcyo.cuttadon.activity.read.u0
            @Override // com.amgcyo.cuttadon.j.b.b
            public final void a() {
                this.a.a(file);
            }
        }).execute(str);
    }

    public /* synthetic */ void a(File file) {
        if (file.exists()) {
            c(file);
        } else {
            l("语音插件不存在");
        }
    }

    public /* synthetic */ void a(String str, final String str2) {
        com.amgcyo.cuttadon.f.o.a(a(), "提示", str + " ，请升级到最新版本，是否升级？", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2750s.a(str2, view);
            }
        }, (View.OnClickListener) null);
    }

    public /* synthetic */ void a(String str, View view) {
        k(str);
    }

    static /* synthetic */ void a(boolean[] zArr, View view) {
        zArr[0] = true;
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("is_open_volume", true);
    }
}
