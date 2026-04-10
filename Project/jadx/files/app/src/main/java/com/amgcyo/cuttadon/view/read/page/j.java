package com.amgcyo.cuttadon.view.read.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import cn.bmob.v3.datatype.up.ParallelUploader;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelHActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.BaiduTtsModel;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.ReaderPageInfo;
import com.amgcyo.cuttadon.api.entity.reader.BaiduTtsSpeechEvent;
import com.amgcyo.cuttadon.api.entity.reader.ReadConfig;
import com.amgcyo.cuttadon.api.entity.reader.ReadThemeBean;
import com.amgcyo.cuttadon.soloader.SoFileLoadManager;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.s0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.fatcatfat.io.R;
import com.umeng.message.proguard.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.EventBus;

/* JADX INFO: compiled from: MkNovelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements SpeechSynthesizerListener, com.amgcyo.cuttadon.j.h.f {
    private com.amgcyo.cuttadon.utils.otherutils.k A;
    private List<String> A0;
    private int B;
    private int C;
    private int C0;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean W;
    private boolean X;
    private String Y;
    private SpeechSynthesizer Z;
    List<MkCatalog> a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private com.amgcyo.cuttadon.j.h.e f5266a0;
    ReadConfig b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f5268c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private String f5269c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f5270d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f5271d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5272e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f5273e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f5274f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private String f5275f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PageView f5276g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private String f5277g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f5278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<o> f5280i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private String[] f5281i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<o> f5282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<o> f5284k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    MkConfigSource f5285k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private Typeface f5287l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f5288m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f5290n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private List<String> f5291n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Paint f5292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Paint f5294p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private String f5295p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextPaint f5296q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private MkCatalog f5297q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private k f5298r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f5299r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private o f5300s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5302t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private String f5303t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected Typeface f5304u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f5305u0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f5308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5310x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private HandlerThread f5311x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private Handler f5313y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PageMode f5314z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f5315z0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f5286l = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f5306v = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5312y = true;
    private boolean P = false;
    private NormalAdParams Q = null;
    public int R = 0;
    public int S = 0;
    private boolean T = false;
    int U = 0;
    private int V = 0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private BaiduTtsSpeechEvent f5267b0 = new BaiduTtsSpeechEvent();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f5279h0 = false;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private int f5283j0 = 0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f5293o0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private ReaderPageInfo f5301s0 = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Integer> f5307v0 = new HashMap();

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private boolean f5309w0 = false;
    private int B0 = com.amgcyo.cuttadon.utils.otherutils.h.o();

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private boolean f5289m0 = z.a();

    /* JADX INFO: compiled from: MkNovelLoader.java */
    public interface b {
        void loadChapterAgain(int i2);

        void onChapterChange(int i2);

        void onColorChange(int i2, int i3, int i4);

        void onErrorShowView(Bitmap bitmap, float f2, int i2, int i3, int i4, int i5, String str);

        void onFinishedSetPageInfo(ReaderPageInfo readerPageInfo, NormalAdParams normalAdParams);

        void onHideStatusBar(boolean z2, Canvas canvas);

        void showChapterInfo(boolean z2);
    }

    j(PageView pageView, ReadConfig readConfig, b bVar, k kVar, MkConfigSource mkConfigSource) {
        this.f5276g = pageView;
        this.f5274f = pageView.getContext();
        this.b = readConfig;
        this.f5268c = readConfig.getBookId();
        MkAppConfig mkAppConfigJ0 = com.amgcyo.cuttadon.utils.otherutils.h.j0();
        if (mkAppConfigJ0 != null) {
            this.f5295p0 = mkAppConfigJ0.getSave_time();
        }
        this.a = new ArrayList(1);
        this.f5270d = bVar;
        this.f5298r = kVar;
        this.f5285k0 = mkConfigSource;
        Q();
        S();
        U();
        T();
        X();
    }

    private void F() {
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.c();
        }
    }

    private boolean G() {
        int i2;
        if (!this.f5308w || (i2 = this.f5306v) == 6 || i2 == 5) {
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        this.f5306v = 1;
        return false;
    }

    private void H() {
        int i2 = this.V;
        this.V = this.U;
        this.U = i2;
        this.f5284k = this.f5282j;
        this.f5282j = this.f5280i;
        this.f5280i = null;
        J();
        this.f5278h = L();
        this.f5300s = null;
    }

    private void I() {
        int i2 = this.V;
        this.V = this.U;
        this.U = i2;
        this.f5280i = this.f5282j;
        this.f5282j = this.f5284k;
        this.f5284k = null;
        J();
        this.f5278h = m(0);
        this.f5300s = null;
    }

    private void J() {
        b bVar = this.f5270d;
        if (bVar != null) {
            this.f5272e = false;
            this.f5286l = "";
            bVar.onChapterChange(this.U);
        }
    }

    private o K() {
        int i2;
        o oVar = this.f5278h;
        if (oVar != null && (i2 = oVar.a + 1) < this.f5282j.size()) {
            return this.f5282j.get(i2);
        }
        return null;
    }

    private o L() {
        return this.f5282j.get(this.f5282j.size() - 1);
    }

    private o M() {
        int i2;
        if (this.f5278h != null && r0.a - 1 >= 0) {
            return this.f5282j.get(i2);
        }
        return null;
    }

    private o N() {
        return this.f5278h;
    }

    private boolean O() {
        return this.U + 1 >= this.a.size();
    }

    private boolean P() {
        if (this.U - 1 >= 0) {
            return false;
        }
        b bVar = this.f5270d;
        if (bVar != null) {
            bVar.showChapterInfo(true);
        }
        return true;
    }

    private void Q() {
        this.R = com.amgcyo.cuttadon.utils.otherutils.h.e(1);
        if (this.R > 0) {
            this.S = com.amgcyo.cuttadon.utils.otherutils.h.d(1);
        }
        this.T = com.amgcyo.cuttadon.utils.otherutils.g.n0();
        String str = "构造函数获取广告相关参数：\nstyle: " + this.R + " interval_count: " + this.S + " isOldAdModel: " + this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        if (this.f5267b0 == null) {
            this.f5267b0 = new BaiduTtsSpeechEvent();
        }
        this.Z = SpeechSynthesizer.getInstance();
        this.Z.setContext(this.f5274f);
        this.Z.setSpeechSynthesizerListener(this);
        String strN = com.amgcyo.cuttadon.utils.otherutils.h.n();
        String strP = com.amgcyo.cuttadon.utils.otherutils.h.p();
        String strQ = com.amgcyo.cuttadon.utils.otherutils.h.q();
        String strR = com.amgcyo.cuttadon.utils.otherutils.h.r();
        String str = "bdId：" + strN;
        String str2 = "bdk：" + strP;
        String str3 = "bds：" + strQ;
        String str4 = "bdsn：" + strR;
        if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ) || TextUtils.isEmpty(strR)) {
            return 3040;
        }
        this.Z.setAppId(strN);
        this.Z.setApiKey(strP, strQ);
        this.Z.setParam(SpeechSynthesizer.PARAM_AUTH_SN, strR);
        this.f5275f0 = SoFileLoadManager.c().getAbsolutePath();
        this.Z.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI);
        this.Z.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, this.f5275f0 + File.separator + "bd_etts_text.dat");
        this.Z.setParam(SpeechSynthesizer.PARAM_SPEED, String.valueOf(this.f5269c0));
        d(this.f5298r.d());
        this.Z.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, this.f5275f0 + File.separator + this.f5277g0);
        return this.Z.initTts(TtsMode.OFFLINE);
    }

    private void S() {
        this.f5314z = this.f5298r.m();
        this.f5302t = com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary);
        this.A = this.f5298r.h();
        try {
            ReadThemeBean readThemeBeanA = this.A.a();
            if (readThemeBeanA != null) {
                this.f5302t = g0.a().a(readThemeBeanA.getKey(), com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f5288m = this.f5298r.k();
        this.W = this.f5298r.o();
        this.X = false;
        e(this.f5298r.j());
        this.f5287l0 = Typeface.create(this.f5304u, 1);
        this.K = m.a(this.f5288m);
        this.F = com.amgcyo.cuttadon.utils.otherutils.n.a(15);
        this.G = this.b.getNotchHeight();
        this.f5269c0 = this.f5298r.e();
        this.f5277g0 = this.f5298r.d();
        Context context = this.f5274f;
        o(s0.a(context, this.f5298r.b(context)));
    }

    private void T() {
        this.f5276g.setPageMode(this.f5314z);
        this.f5276g.setBgColor(this.O);
    }

    private void U() {
        this.f5290n = new Paint();
        this.f5290n.setColor(this.H);
        this.f5290n.setTextAlign(Paint.Align.LEFT);
        this.f5290n.setTextSize(com.amgcyo.cuttadon.utils.otherutils.n.c(this.f5274f, 12.0f));
        this.f5290n.setAntiAlias(true);
        this.f5290n.setSubpixelText(true);
        this.f5290n.setTypeface(this.f5304u);
        this.f5296q = new TextPaint(1);
        this.f5296q.setColor(this.H);
        this.f5296q.setTextSize(this.J);
        this.f5296q.setAntiAlias(true);
        this.f5296q.setTextAlign(Paint.Align.LEFT);
        this.f5296q.setFakeBoldText(this.X);
        this.f5296q.setTypeface(this.f5304u);
        this.f5292o = new TextPaint();
        this.f5292o.setColor(this.H);
        this.f5292o.setTextSize(this.I);
        this.f5292o.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f5292o.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5292o.setAntiAlias(true);
        this.f5292o.setTypeface(this.f5304u);
        this.f5296q.setFakeBoldText(this.X);
        this.f5294p = new Paint();
        this.f5294p.setColor(this.O);
        a(this.A);
    }

    private void V() {
        this.f5311x0 = new HandlerThread("NonBlockSyntherizer-thread");
        this.f5311x0.start();
        this.f5313y0 = new a(this.f5311x0.getLooper());
    }

    private boolean W() {
        List<MkCatalog> list = this.a;
        return list != null && this.U + 1 >= list.size() && this.f5272e;
    }

    private void X() {
        this.U = this.b.getCurrentChapterId();
        this.V = this.U;
    }

    private void Y() {
        this.f5280i = null;
        this.f5284k = null;
        try {
            if (this.f5308w && this.f5306v == 2 && this.f5282j != null && this.f5282j.size() > 0) {
                l(this.U);
                if (this.f5278h.a >= this.f5282j.size()) {
                    this.f5278h.a = this.f5282j.size() - 1;
                }
                this.f5278h = this.f5282j.get(this.f5278h.a);
            }
            this.f5276g.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Z() {
        this.A0 = null;
        try {
            if (this.f5267b0 == null) {
                this.f5267b0 = new BaiduTtsSpeechEvent();
            }
            this.f5283j0++;
            if (this.f5283j0 >= this.f5281i0.length) {
                this.f5267b0.setStopSpeech(true);
                this.f5283j0 = -1;
            } else {
                this.f5267b0.setStopSpeech(false);
                k(this.f5283j0);
            }
            me.jessyan.art.d.f.a().a(this.f5267b0, "baiduTtsEvent");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ int e(j jVar) {
        int i2 = jVar.f5273e0;
        jVar.f5273e0 = i2 + 1;
        return i2;
    }

    private void k(int i2) {
        String[] strArr;
        if (!this.f5279h0 || (strArr = this.f5281i0) == null || strArr.length <= 0) {
            return;
        }
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.stop();
        }
        com.amgcyo.cuttadon.j.h.e eVar = this.f5266a0;
        if (eVar != null) {
            eVar.stop();
        }
        int length = this.f5281i0.length;
        if (i2 >= length || i2 < 0) {
            i2 = length - 1;
        }
        this.f5283j0 = i2;
        try {
            String strReplaceAll = this.f5281i0[i2].replaceAll("\\s", "");
            if (!com.amgcyo.cuttadon.utils.otherutils.g.o(strReplaceAll) || TextUtils.isEmpty(strReplaceAll)) {
                if (this.f5283j0 != length - 1) {
                    Z();
                    return;
                }
                BaiduTtsSpeechEvent baiduTtsSpeechEvent = new BaiduTtsSpeechEvent();
                baiduTtsSpeechEvent.setStopSpeech(true);
                this.f5283j0 = -1;
                me.jessyan.art.d.f.a().a(baiduTtsSpeechEvent, "baiduTtsEvent");
                return;
            }
            this.f5315z0 = z.i(strReplaceAll) > this.B0;
            String strValueOf = String.valueOf(this.f5283j0);
            SpeechSynthesizer speechSynthesizer2 = this.Z;
            if (speechSynthesizer2 != null) {
                speechSynthesizer2.stop();
                if (!this.f5315z0) {
                    if (this.Z.speak(strReplaceAll, strValueOf) != 0) {
                        Z();
                        return;
                    }
                    return;
                }
                this.C0 = 0;
                this.A0 = z.p(strReplaceAll);
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                    Z();
                    return;
                }
                String str = this.A0.get(this.C0);
                String str2 = "文本过长，需要拆分成" + this.A0.size() + "段;\n正在读取第" + this.C0 + "段文本: " + str;
                if (this.Z.speak(str, strValueOf) != 0) {
                    onSpeechFinish(strValueOf);
                    return;
                }
                return;
            }
            com.amgcyo.cuttadon.j.h.e eVar2 = this.f5266a0;
            if (eVar2 != null) {
                if (!this.f5315z0) {
                    this.A0 = null;
                    eVar2.a(strReplaceAll, strValueOf);
                    return;
                }
                this.C0 = 0;
                this.A0 = z.p(strReplaceAll);
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                    this.A0 = null;
                    this.f5266a0.a(strReplaceAll, strValueOf);
                    return;
                }
                String str3 = this.A0.get(this.C0);
                String str4 = "文本过长，需要拆分成" + this.A0.size() + "段;\n正在读取第" + this.C0 + "段文本: " + str3;
                this.f5266a0.a(str3, strValueOf);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.amgcyo.cuttadon.utils.otherutils.g.a(new Throwable("StartRead error:" + e2.getMessage() + " tempCurrentIndex: " + i2), "h_tts");
            Z();
        }
    }

    private List<o> n(int i2) throws Exception {
        List<MkCatalog> list = this.a;
        if (list == null) {
            return null;
        }
        if (i2 == list.size()) {
            i2 = this.a.size() - 1;
        }
        this.f5297q0 = this.a.get(i2);
        long jB = 0;
        if (!this.f5289m0) {
            jB = t0.b(this.f5295p0);
            this.f5293o0 = jB >= 1440;
            if (this.f5293o0) {
                String str = "later_" + this.f5268c + this.f5297q0.getCatalogId();
                boolean zA = g0.a().a(str, false);
                String str2 = "key:" + str + "  aBoolean value: " + zA;
                this.f5293o0 = !zA;
                String str3 = "key:" + str + " configExpired value: " + zA;
            }
        }
        List<String> listA = (this.f5289m0 || this.f5293o0) ? a(jB) : a(this.f5297q0);
        if (listA == null) {
            return null;
        }
        this.f5299r0 = 0;
        List<o> listA2 = a(this.f5297q0, listA);
        if (!this.f5297q0.isIs_content()) {
            for (o oVar : listA2) {
                oVar.f5320g = true;
                oVar.f5319f = "去换源";
            }
            return listA2;
        }
        if (this.f5297q0.isOnErrorReturn()) {
            for (o oVar2 : listA2) {
                oVar2.f5320g = true;
                oVar2.f5319f = "点击重试";
            }
            return listA2;
        }
        if (this.f5289m0) {
            for (o oVar3 : listA2) {
                oVar3.f5320g = true;
                oVar3.f5319f = "立即更新";
            }
        } else if (this.f5293o0) {
            for (o oVar4 : listA2) {
                oVar4.f5320g = true;
                oVar4.f5319f = "重新获取";
            }
        }
        if (this.U + 1 >= this.a.size()) {
            o oVar5 = new o();
            this.f5299r0 = 1;
            oVar5.f5324k = true;
            oVar5.a = listA2.size();
            oVar5.f5316c = 1;
            oVar5.f5319f = "type_update";
            listA2.add(oVar5);
        }
        return listA2;
    }

    private void o(int i2) {
        this.J = i2;
        this.I = this.J + com.amgcyo.cuttadon.utils.otherutils.n.c(this.f5274f, 4.0f);
        int i3 = this.I;
        this.L = i3 / 2;
        this.M = this.J;
        this.N = i3;
    }

    public void A() {
        if (O()) {
            return;
        }
        if (t()) {
            this.f5278h = m(0);
        } else {
            this.f5278h = new o();
        }
        this.f5276g.a(false);
    }

    public void B() {
        if (P()) {
            return;
        }
        if (u()) {
            this.f5278h = m(0);
        } else {
            this.f5278h = new o();
        }
        this.f5276g.a(false);
    }

    public boolean C() {
        if (this.f5306v != 2) {
            return false;
        }
        try {
            return this.f5276g.b();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean D() {
        try {
            return this.f5276g.c();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void E() {
        this.f5279h0 = false;
        this.f5283j0 = 0;
        e();
    }

    protected abstract List<String> a(MkCatalog mkCatalog) throws Exception;

    public int g() {
        return this.f5306v;
    }

    public void h(int i2) {
        if (this.Z != null) {
            this.f5269c0 = String.valueOf(i2);
            this.Z.stop();
            this.Z.setParam(SpeechSynthesizer.PARAM_SPEED, this.f5269c0);
        } else {
            com.amgcyo.cuttadon.j.h.e eVar = this.f5266a0;
            if (eVar != null) {
                double d2 = i2;
                Double.isNaN(d2);
                eVar.a((float) (d2 / 10.0d));
                this.f5266a0.stop();
            }
        }
        this.f5279h0 = false;
    }

    public void i(int i2) {
        this.U = i2;
        this.f5280i = null;
        this.f5284k = null;
        ReadConfig readConfig = this.b;
        if (readConfig != null) {
            readConfig.setRead_begin(0);
        }
        q();
    }

    public void j(int i2) {
        if (this.f5308w) {
            this.f5278h = m(i2);
            this.f5276g.a(false);
        }
    }

    boolean l() {
        return this.f5310x;
    }

    public boolean m() {
        return this.f5309w0;
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onError(String str, SpeechError speechError) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechFinish(String str) {
        if (this.Z != null) {
            this.f5283j0 = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            sb.append("是否拆分:  ");
            sb.append(this.f5315z0);
            sb.append("   集合状态:  ");
            sb.append(!com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0));
            sb.toString();
            if (!this.f5315z0 || com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                Z();
                return;
            }
            this.C0++;
            if (this.C0 >= this.A0.size()) {
                this.A0 = null;
                this.f5315z0 = false;
                Z();
                this.C0 = 0;
                return;
            }
            String str2 = this.A0.get(this.C0);
            String str3 = "文本过长，需要拆分成" + this.A0.size() + "段;\n正在读取第" + this.C0 + "段文本: " + str2;
            String str4 = "speak:" + this.Z.speak(str2, String.valueOf(this.f5283j0));
        }
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechProgressChanged(String str, int i2) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechStart(String str) {
    }

    @Override // com.amgcyo.cuttadon.j.h.f
    public void onStart(String str) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeDataArrived(String str, byte[] bArr, int i2, int i3) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeFinish(String str) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeStart(String str) {
    }

    boolean p() {
        o oVarK;
        this.f5283j0 = 0;
        if (G()) {
            return false;
        }
        if (this.f5306v != 2 || (oVarK = K()) == null) {
            if (O()) {
                return false;
            }
            this.f5300s = this.f5278h;
            if (t()) {
                this.f5278h = this.f5282j.get(0);
            } else {
                this.f5278h = new o();
            }
            this.f5276g.d();
            this.P = true;
            if (this.f5278h.f5318e && this.f5279h0) {
                C();
            } else {
                k(0);
            }
            return true;
        }
        if (oVarK.f5324k) {
            b bVar = this.f5270d;
            if (bVar != null) {
                bVar.showChapterInfo(false);
                oVarK.f5324k = false;
                oVarK.f5325l = 0;
            }
            return false;
        }
        this.f5300s = this.f5278h;
        oVarK.f5325l = 1;
        this.f5278h = oVarK;
        this.f5276g.d();
        this.P = true;
        if (oVarK.f5318e && this.f5279h0) {
            C();
        } else {
            k(0);
        }
        return true;
    }

    void q() {
        int read_begin;
        this.f5312y = false;
        PageView pageView = this.f5276g;
        if (pageView != null && pageView.g()) {
            if (!this.f5308w) {
                this.f5306v = 1;
                this.f5276g.a(false);
                return;
            }
            if (this.a.isEmpty()) {
                this.f5306v = 7;
                this.f5276g.a(false);
                return;
            }
            if (!s()) {
                this.f5278h = new o();
            } else if (this.f5310x) {
                this.f5278h = m(0);
            } else {
                if (this.f5282j.isEmpty() || TextUtils.isEmpty(this.Y)) {
                    read_begin = this.b.getRead_begin();
                    if (read_begin < 0) {
                        read_begin = 0;
                    }
                } else {
                    Iterator<o> it = this.f5282j.iterator();
                    loop0: while (true) {
                        int read_begin2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                read_begin = read_begin2;
                                break loop0;
                            }
                            o next = it.next();
                            try {
                                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(next.f5317d)) {
                                    for (String str : next.f5317d) {
                                        if (this.Y.length() <= str.length()) {
                                            if (!str.contains(this.Y)) {
                                                if (z.e(str, this.Y) >= 0.48f) {
                                                    read_begin = next.a;
                                                    break loop0;
                                                }
                                            } else {
                                                read_begin = next.a;
                                                break loop0;
                                            }
                                        } else if (!this.Y.contains(str)) {
                                            if (z.e(str, this.Y) >= 0.48f) {
                                                read_begin = next.a;
                                                break loop0;
                                            }
                                        } else {
                                            read_begin = next.a;
                                            break loop0;
                                        }
                                    }
                                } else {
                                    read_begin2 = this.b.getRead_begin();
                                    if (read_begin2 < 0) {
                                        break;
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (read_begin >= this.f5282j.size()) {
                    read_begin = this.f5282j.size() - 1;
                }
                this.f5278h = m(read_begin);
                this.f5300s = this.f5278h;
                this.f5310x = true;
            }
            this.f5276g.a(false);
        }
    }

    void r() {
        if (this.f5278h.a == 0 && this.U > this.V) {
            if (this.f5280i != null) {
                H();
                return;
            } else if (u()) {
                this.f5278h = L();
                return;
            } else {
                this.f5278h = new o();
                return;
            }
        }
        if (this.f5282j != null && (this.f5278h.a != r0.size() - 1 || this.U >= this.V)) {
            this.f5278h = this.f5300s;
            return;
        }
        if (this.f5284k != null) {
            I();
        } else if (t()) {
            this.f5278h = this.f5282j.get(0);
        } else {
            this.f5278h = new o();
        }
    }

    boolean s() {
        l(this.U);
        return this.f5282j != null;
    }

    boolean t() {
        int i2 = this.U;
        int i3 = i2 + 1;
        this.V = i2;
        this.U = i3;
        this.f5280i = this.f5282j;
        List<o> list = this.f5284k;
        if (list != null) {
            this.f5282j = list;
            this.f5284k = null;
            J();
        } else {
            l(i3);
        }
        return this.f5282j != null;
    }

    boolean u() {
        int i2 = this.U;
        int i3 = i2 - 1;
        this.V = i2;
        this.U = i3;
        this.f5284k = this.f5282j;
        List<o> list = this.f5280i;
        if (list != null) {
            this.f5282j = list;
            this.f5280i = null;
            J();
        } else {
            l(i3);
        }
        return this.f5282j != null;
    }

    public void v() {
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.pause();
        }
        com.amgcyo.cuttadon.j.h.e eVar = this.f5266a0;
        if (eVar != null) {
            eVar.pause();
        }
        this.f5279h0 = false;
    }

    boolean w() {
        o oVarM;
        if (G()) {
            return false;
        }
        if (this.f5306v == 2 && (oVarM = M()) != null) {
            this.f5300s = this.f5278h;
            this.f5278h = oVarM;
            this.f5276g.d();
            this.P = false;
            if (oVarM.f5318e && this.f5279h0) {
                F();
            } else {
                k(0);
            }
            return true;
        }
        if (P()) {
            return false;
        }
        this.f5300s = this.f5278h;
        if (u()) {
            this.f5278h = L();
        } else {
            this.f5278h = new o();
        }
        this.P = false;
        this.f5276g.d();
        if (this.f5278h.f5318e && this.f5279h0) {
            F();
        } else {
            k(0);
        }
        return true;
    }

    public abstract void x();

    public void y() {
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.release();
        }
        com.amgcyo.cuttadon.j.h.e eVar = this.f5266a0;
        if (eVar != null) {
            eVar.release();
        }
        this.f5279h0 = false;
    }

    public void z() {
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.resume();
        }
        com.amgcyo.cuttadon.j.h.e eVar = this.f5266a0;
        if (eVar != null) {
            eVar.resume();
        }
        this.f5279h0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0013, B:9:0x001d, B:10:0x0024, B:11:0x0029), top: B:17:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L29
            int r0 = r6.length()     // Catch: java.lang.Exception -> L2e
            if (r0 <= 0) goto L29
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L2e
            r0.<init>(r6)     // Catch: java.lang.Exception -> L2e
            boolean r1 = r0.exists()     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L24
            long r0 = r0.length()     // Catch: java.lang.Exception -> L2e
            r2 = 10
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L24
            android.graphics.Typeface r6 = android.graphics.Typeface.createFromFile(r6)     // Catch: java.lang.Exception -> L2e
            r5.f5304u = r6     // Catch: java.lang.Exception -> L2e
            goto L36
        L24:
            android.graphics.Typeface r6 = android.graphics.Typeface.DEFAULT     // Catch: java.lang.Exception -> L2e
            r5.f5304u = r6     // Catch: java.lang.Exception -> L2e
            goto L36
        L29:
            android.graphics.Typeface r6 = android.graphics.Typeface.DEFAULT     // Catch: java.lang.Exception -> L2e
            r5.f5304u = r6     // Catch: java.lang.Exception -> L2e
            goto L36
        L2e:
            r6 = move-exception
            r6.printStackTrace()
            android.graphics.Typeface r6 = android.graphics.Typeface.DEFAULT
            r5.f5304u = r6
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.read.page.j.e(java.lang.String):void");
    }

    private void l(int i2) {
        try {
            this.f5282j = n(i2);
            if (this.f5282j == null) {
                this.f5306v = 1;
                return;
            }
            if (this.f5282j.isEmpty()) {
                this.f5306v = 4;
                o oVar = new o();
                oVar.f5317d = new ArrayList(1);
                this.f5282j.add(oVar);
            } else {
                this.f5306v = 2;
            }
            J();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f5282j = null;
            this.f5306v = 3;
        }
    }

    private o m(int i2) {
        List<o> list = this.f5282j;
        if (list == null) {
            return null;
        }
        if (i2 >= list.size()) {
            i2 = this.f5282j.size() - 1;
        }
        return this.f5282j.get(i2);
    }

    public void c(int i2) {
        this.f5306v = i2;
        this.f5276g.a(false);
    }

    public void d(int i2) {
        if (this.f5276g != null) {
            this.f5314z = PageMode.values()[i2];
            this.f5276g.setPageMode(this.f5314z);
            k kVar = this.f5298r;
            if (kVar != null) {
                kVar.a(this.f5314z);
            }
            this.f5276g.a(false);
        }
    }

    o f() {
        List<o> list;
        int i2;
        List<MkCatalog> list2;
        o oVar = this.f5278h;
        if (oVar == null || (list = this.f5282j) == null || (i2 = oVar.a + 1) >= list.size() || ((list2 = this.a) != null && this.U + 1 < list2.size())) {
            return null;
        }
        return this.f5282j.get(i2);
    }

    public void g(int i2) {
        this.f5310x = false;
        this.f5306v = i2;
    }

    public void b(int i2) {
        this.f5288m = i2;
        this.K = m.a(i2);
        Y();
    }

    private List<String> a(long j2) {
        if (this.f5289m0) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f5291n0)) {
                this.f5291n0 = new ArrayList();
                this.f5291n0.add(String.format(com.amgcyo.cuttadon.f.o.d(R.string.string_enable), "5.0.2", com.amgcyo.cuttadon.utils.otherutils.h.C0()));
            }
        } else if (this.f5293o0) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.b(this.f5291n0)) {
                this.f5291n0.clear();
                this.f5291n0 = null;
            }
            this.f5291n0 = new ArrayList();
            String strA = t0.a(Long.valueOf(TimeUnit.MINUTES.toMillis(j2)));
            this.f5291n0.add("当前书源信息已过期" + strA + "，为保证书籍及时获取最新章节信息，\n请重新获取最新书源信息后再进行阅读！");
        }
        return this.f5291n0;
    }

    public void c() {
        this.f5308w = false;
        a((List) this.a);
        a((List) this.f5282j);
        a((List) this.f5284k);
        this.a = null;
        this.f5282j = null;
        this.f5284k = null;
        this.f5276g = null;
        this.f5278h = null;
    }

    public List<o> j() {
        return this.f5282j;
    }

    private void b(Bitmap bitmap, boolean z2) {
        Canvas canvas = new Canvas(bitmap);
        if (!z2) {
            Bitmap bitmapA = this.A.a(this.f5274f);
            int iIntValue = 0;
            if (bitmapA != null && !bitmapA.isRecycled()) {
                canvas.drawBitmap(bitmapA, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), new Rect(0, 0, this.D, this.E), (Paint) null);
            } else {
                canvas.drawColor(this.O);
            }
            this.f5272e = false;
            if (this.a.isEmpty() || this.f5306v != 2) {
                return;
            }
            int i2 = this.f5278h.a + 1;
            int size = this.f5282j.size();
            this.f5272e = i2 == size;
            MkCatalog mkCatalog = this.f5297q0;
            if (mkCatalog != null && this.f5307v0 != null) {
                int catalogId = mkCatalog.getCatalogId();
                this.f5303t0 = z.n(this.f5297q0.getName());
                if (!this.f5307v0.containsKey(Integer.valueOf(catalogId))) {
                    this.f5307v0.put(Integer.valueOf(catalogId), Integer.valueOf(size));
                    Iterator<Map.Entry<Integer, Integer>> it = this.f5307v0.entrySet().iterator();
                    while (it.hasNext()) {
                        iIntValue += it.next().getValue().intValue();
                    }
                    this.f5305u0 = iIntValue;
                }
            }
            if (this.f5301s0 == null) {
                this.f5301s0 = new ReaderPageInfo(this.S, this.R);
            }
            this.f5301s0.setCur(i2);
            this.f5301s0.setSize(size);
            this.f5301s0.setChapterName(this.f5303t0);
            this.f5301s0.setTotalPageSize(this.f5305u0);
            b bVar = this.f5270d;
            if (bVar != null) {
                bVar.onFinishedSetPageInfo(this.f5301s0, this.Q);
                return;
            }
            return;
        }
        this.f5294p.setColor(this.O);
    }

    public void f(int i2) {
        this.f5302t = i2;
    }

    public boolean o() {
        o oVarN = N();
        return (oVarN == null || oVarN.f5321h == null) ? false : true;
    }

    public List<MkCatalog> i() {
        return this.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.read.page.j.d(java.lang.String):void");
    }

    public int h() {
        o oVar = this.f5278h;
        if (oVar == null) {
            return 0;
        }
        int i2 = oVar.a;
        return (!oVar.f5318e || i2 <= 0) ? (this.f5299r0 <= 0 || !W()) ? i2 : i2 - this.f5299r0 : i2 - 1;
    }

    /* JADX INFO: compiled from: MkNovelLoader.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public /* synthetic */ void a() {
            j.this.a(PageMode.NONE);
            if (j.this.f5274f instanceof MkReadModelHActivity) {
                ((MkReadModelHActivity) j.this.f5274f).baiduTTS();
            }
            ((MkNovelBaseReaderActivity) j.this.f5274f).hideLoading();
            String strD = g0.a().d("baidu_tts_download_path");
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            File file = new File(strD);
            if (file.exists()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("语音插件源文件：");
                sb.append(file.getName());
                sb.append(zDelete ? " 删除成功 " : " 删除失败 ");
                sb.toString();
            }
        }

        public /* synthetic */ void b() {
            ((MkNovelBaseReaderActivity) j.this.f5274f).hideLoading();
            if (j.this.f5271d0 != -102 && j.this.f5271d0 != -109 && j.this.f5271d0 != -119) {
                ((MkNovelBaseReaderActivity) j.this.f5274f).showTtsEngine(false);
                ((MkNovelBaseReaderActivity) j.this.f5274f).showErrorMsgGravityBottom("初始化失败！错误码：" + j.this.f5271d0 + "，请使用原生TTS语音引擎！");
                return;
            }
            String strC = com.amgcyo.cuttadon.utils.otherutils.h.c("notify_content");
            if (!TextUtils.isEmpty(strC) && Pattern.matches(".*(?=-102|-109|-119).*", strC)) {
                final String strC2 = com.amgcyo.cuttadon.utils.otherutils.h.c(ParallelUploader.Params.NOTIFY_URL);
                b1 b1Var = new b1(j.this.f5274f);
                b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.view.read.page.b
                    @Override // com.amgcyo.cuttadon.g.f
                    public final void a() {
                        this.a.a(strC2);
                    }
                });
                b1Var.show();
                b1Var.a(strC, strC2, "公告通知");
                return;
            }
            ((MkNovelBaseReaderActivity) j.this.f5274f).showTtsEngine(false);
            ((MkNovelBaseReaderActivity) j.this.f5274f).showErrorMsgGravityBottom("该语音暂不可用(" + j.this.f5271d0 + ")，请使用原生TTS语音引擎");
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ((MkNovelBaseReaderActivity) j.this.f5274f).showLoading("");
                j jVar = j.this;
                jVar.f5271d0 = jVar.R();
                String str = "result:" + j.this.f5271d0;
                BaiduTtsModel baiduTtsModel = (BaiduTtsModel) message.obj;
                if (j.this.f5271d0 == 0) {
                    if (baiduTtsModel == null || !(j.this.f5274f instanceof MkNovelBaseReaderActivity)) {
                        return;
                    }
                    ((MkNovelBaseReaderActivity) j.this.f5274f).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.view.read.page.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5258s.a();
                        }
                    });
                    return;
                }
                String str2 = "合成引擎初始化失败, 错误码：" + j.this.f5271d0;
                if (j.this.f5271d0 != -102 || j.this.f5273e0 > 1) {
                    j.this.f5273e0 = 0;
                    ((MkNovelBaseReaderActivity) j.this.f5274f).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.view.read.page.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5259s.b();
                        }
                    });
                    return;
                }
                try {
                    if (j.this.Z != null) {
                        j.this.Z.release();
                        j.this.Z = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ((MkNovelBaseReaderActivity) j.this.f5274f).hideLoading();
                j.e(j.this);
                j.this.a(baiduTtsModel);
            }
        }

        public /* synthetic */ void a(String str) {
            com.amgcyo.cuttadon.f.o.a(j.this.f5274f, com.amgcyo.cuttadon.utils.otherutils.h.b("notify_open_type"), str);
        }
    }

    public void e(int i2) {
        this.J = s0.a(this.f5274f, i2);
        o(this.J);
        this.f5296q.setTextSize(this.J);
        this.f5292o.setTextSize(this.I);
        Y();
    }

    public void c(String str) {
        this.Y = str;
    }

    public void e() {
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.a(false);
        }
    }

    public void a() {
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.b();
        }
    }

    public void a(boolean z2) {
        this.W = z2;
        Y();
    }

    public void a(Typeface typeface) {
        this.f5304u = typeface;
        this.f5296q.setTypeface(typeface);
        this.f5290n.setTypeface(typeface);
        this.f5292o.setTypeface(typeface);
        e(this.f5298r.b(this.f5274f));
    }

    public void a(com.amgcyo.cuttadon.utils.otherutils.k kVar) {
        this.A = kVar;
        this.H = kVar.a;
        this.O = kVar.f4405i;
        try {
            ReadThemeBean readThemeBeanA = this.A.a();
            if (readThemeBeanA != null) {
                this.f5302t = g0.a().a(readThemeBeanA.getKey(), com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = kVar.f4407k;
        this.f5276g.setBgColor(this.O);
        this.f5290n.setColor(this.H);
        this.f5292o.setColor(this.H);
        this.f5296q.setColor(this.H);
        this.f5294p.setColor(this.O);
        this.f5276g.a(false);
        b bVar = this.f5270d;
        if (bVar != null) {
            bVar.onColorChange(this.H, this.O, i2);
        }
    }

    private void b(boolean z2) {
        this.f5309w0 = z2;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f5298r.d();
        }
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.stop();
            d(str);
            if (this.f5271d0 == 0) {
                this.f5298r.a(str);
                int iLoadModel = this.Z.loadModel(this.f5275f0 + "/" + this.f5277g0, this.f5275f0 + "/bd_etts_text.dat");
                StringBuilder sb = new StringBuilder();
                sb.append("read_result：");
                sb.append(iLoadModel);
                sb.toString();
            }
            this.f5279h0 = true;
            k(this.f5283j0);
            PageView pageView = this.f5276g;
            if (pageView != null) {
                pageView.a(false);
            }
        }
    }

    public void d() {
        SpeechSynthesizer speechSynthesizer = this.Z;
        if (speechSynthesizer != null) {
            speechSynthesizer.stop();
            this.Z = null;
        }
        this.f5279h0 = false;
        this.f5283j0 = -1;
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.a(false);
        }
    }

    public void a(PageMode pageMode) {
        this.f5314z = pageMode;
        this.f5276g.setPageMode(this.f5314z);
        this.f5276g.a(false);
    }

    public boolean n() {
        return this.f5279h0;
    }

    public void a(ReadConfig readConfig) {
        this.b = readConfig;
    }

    private void a(List list) {
        if (list != null) {
            list.clear();
        }
    }

    void a(Bitmap bitmap, boolean z2) {
        b(this.f5276g.getBgBitmap(), z2);
        if (!z2) {
            a(bitmap);
        }
        this.f5276g.postInvalidate();
    }

    private void a(Bitmap bitmap) {
        float f2;
        Canvas canvas = new Canvas(bitmap);
        if (this.f5314z == PageMode.SCROLL) {
            canvas.drawColor(this.O);
        }
        int i2 = this.f5306v;
        String str = "";
        if (i2 != 2) {
            if (i2 == 1) {
                str = "正在加载章节...";
            } else if (i2 == 3) {
                str = "加载失败!";
            } else if (i2 == 4) {
                str = "文章内容为空";
            } else if (i2 == 5) {
                str = "正在排版请等待...";
            } else if (i2 == 6) {
                str = "文件解析错误";
            } else if (i2 == 7) {
                str = "获取列表信息失败.😅";
            }
            Paint.FontMetrics fontMetrics = this.f5296q.getFontMetrics();
            canvas.drawText(str, (this.D - this.f5296q.measureText(str)) / 2.0f, ((this.E - (fontMetrics.top - fontMetrics.bottom)) / 2.0f) + com.amgcyo.cuttadon.utils.otherutils.n.a(40.0f), this.f5296q);
            return;
        }
        if (this.f5314z == PageMode.SCROLL) {
            f2 = -this.f5296q.getFontMetrics().top;
        } else {
            f2 = this.G - this.f5296q.getFontMetrics().top;
        }
        a(bitmap, canvas);
        int textSize = this.K + ((int) this.f5296q.getTextSize());
        int textSize2 = this.M + ((int) this.f5296q.getTextSize());
        int textSize3 = this.L + ((int) this.f5292o.getTextSize());
        int textSize4 = this.N + ((int) this.f5296q.getTextSize());
        StringBuilder sb = new StringBuilder();
        o oVar = this.f5278h;
        if (oVar != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(oVar.f5317d)) {
            float f3 = f2;
            int i3 = 0;
            while (true) {
                o oVar2 = this.f5278h;
                if (i3 >= oVar2.f5316c) {
                    break;
                }
                String strA = oVar2.f5317d.get(i3);
                if (this.f5279h0 && this.f5283j0 == 0) {
                    this.f5292o.setTypeface(this.f5287l0);
                    this.f5292o.setColor(this.f5302t);
                } else {
                    this.f5292o.setTypeface(this.f5304u);
                    this.f5292o.setColor(this.H);
                }
                if (this.W) {
                    strA = com.amgcyo.cuttadon.utils.otherutils.n.a(strA);
                }
                sb.append(strA);
                if (i3 == 0) {
                    f3 += this.N;
                }
                canvas.drawText(strA, ((int) (this.D - this.f5292o.measureText(strA))) / 2, f3, this.f5292o);
                f3 += i3 == this.f5278h.f5316c - 1 ? textSize4 : textSize3;
                i3++;
            }
            f2 = f3;
        }
        o oVar3 = this.f5278h;
        if (oVar3 == null || com.amgcyo.cuttadon.utils.otherutils.g.a(oVar3.f5317d)) {
            return;
        }
        int i4 = 0;
        for (int i5 = this.f5278h.f5316c; i5 < this.f5278h.f5317d.size(); i5++) {
            String strA2 = this.f5278h.f5317d.get(i5);
            if (this.f5279h0 && i4 == this.f5283j0) {
                this.f5296q.setTypeface(this.f5287l0);
                this.f5296q.setColor(this.f5302t);
            } else {
                this.f5296q.setTypeface(this.f5304u);
                this.f5296q.setColor(this.H);
            }
            if (this.W) {
                strA2 = com.amgcyo.cuttadon.utils.otherutils.n.a(strA2);
            }
            canvas.drawText(strA2.replaceAll("\n", ""), this.F, f2, this.f5296q);
            if (strA2.endsWith("\n")) {
                f2 += textSize2;
                i4++;
            } else {
                f2 += textSize;
            }
            sb.append(strA2);
        }
        this.f5281i0 = sb.toString().split("\n");
        int i6 = (int) (f2 + this.f5296q.getFontMetrics().bottom);
        float f4 = this.C - i6;
        this.f5276g.a("对内容进行绘制 if");
        if (!TextUtils.isEmpty(this.f5286l)) {
            b bVar = this.f5270d;
            int i7 = this.F;
            bVar.onErrorShowView(bitmap, f4, i7, i6, i7, this.C, this.f5286l);
            return;
        }
        this.f5276g.a("else");
    }

    public boolean k() {
        o oVarN = N();
        if (oVarN != null) {
            String str = oVarN.f5319f;
            if (!TextUtils.isEmpty(str)) {
                String str2 = "页面类型：" + str;
                return !"type_ad".equals(str);
            }
        }
        return true;
    }

    public void b() {
        o oVarN = N();
        if (oVarN != null) {
            oVarN.b = true;
        }
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.a(false);
        }
    }

    private void a(Bitmap bitmap, Canvas canvas) {
        if (this.f5278h == null) {
            return;
        }
        this.f5276g.a("drawCustomView:" + this.f5278h.f5319f);
        o oVar = this.f5278h;
        if (oVar.f5318e) {
            b bVar = this.f5270d;
            if (bVar != null) {
                bVar.onHideStatusBar(true, canvas);
            }
            if (!"type_ad".equals(this.f5278h.f5319f) || this.f5276g.a(bitmap, this.f5278h)) {
                return;
            }
            this.f5278h = this.P ? K() : M();
            a(bitmap);
            return;
        }
        if (oVar.f5320g) {
            this.f5286l = oVar.f5319f;
            return;
        }
        if (oVar.f5325l == 1) {
            if ("type_update".equals(oVar.f5319f)) {
                this.f5299r0 = 1;
                if (this.f5276g.a(bitmap, this.f5278h.b)) {
                    return;
                }
                this.f5278h = this.P ? K() : M();
                a(bitmap);
                return;
            }
            return;
        }
        b bVar2 = this.f5270d;
        if (bVar2 != null) {
            bVar2.onHideStatusBar(false, canvas);
        }
    }

    void a(int i2, int i3) {
        this.D = i2;
        this.E = i3;
        this.B = this.D - (this.F * 2);
        this.C = (this.E - (this.G * 2)) - ((int) this.f5296q.getFontMetrics().bottom);
        this.f5276g.setPageMode(this.f5314z);
        if (!this.f5310x) {
            this.f5276g.a(false);
            if (this.f5312y) {
                return;
            }
            q();
            return;
        }
        if (this.f5306v == 2) {
            l(this.U);
            this.f5278h = m(this.f5278h.a);
        }
        this.f5276g.a(false);
    }

    private void a(boolean z2, NormalAdParams normalAdParams, MkCatalog mkCatalog, List<o> list) {
        if (mkCatalog == null || mkCatalog.getCatalogId() <= 0 || this.R != 1) {
            return;
        }
        o oVar = new o();
        oVar.f5318e = true;
        oVar.f5322i = normalAdParams;
        oVar.f5323j = z2;
        oVar.f5316c = 1;
        oVar.f5319f = "type_ad";
        oVar.f5321h = com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog, this.f5268c, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("添加首页广告，是否解锁：");
        sb.append(oVar.f5321h != null);
        sb.append(" \n本章：");
        sb.append(mkCatalog.getName());
        sb.toString();
        list.add(oVar);
    }

    private List<o> a(MkCatalog mkCatalog, List<String> list) {
        boolean zB;
        boolean zA;
        String str;
        String str2;
        int iBreakText;
        int i2;
        String str3 = "";
        ArrayList arrayList = new ArrayList();
        int i3 = this.R;
        if (3 == i3 || i3 <= 0 || !this.T) {
            zB = false;
            zA = false;
        } else {
            zB = com.amgcyo.cuttadon.h.a.c.b("position_page_ad");
            if (zB) {
                this.Q = com.amgcyo.cuttadon.sdk.utils.e.c();
            }
            NormalAdParams normalAdParams = this.Q;
            if (normalAdParams != null) {
                zA = com.amgcyo.cuttadon.h.a.d.a(normalAdParams.getBaseAd());
                this.Q.setChapingAd(zA);
            } else {
                zA = false;
            }
            String str4 = "本次广告对象是否是插屏：" + zA;
            ReadConfig readConfig = this.b;
            if (readConfig != null && readConfig.isFrom_unlock_activity()) {
                this.b.setFrom_unlock_activity(false);
            } else {
                NormalAdParams normalAdParams2 = this.Q;
                if (normalAdParams2 != null && !zA) {
                    a(zB, normalAdParams2, mkCatalog, arrayList);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i4 = this.C;
        String name = mkCatalog.getName();
        b(com.amgcyo.cuttadon.utils.otherutils.g.a(list));
        int i5 = -1;
        String strSubstring = name;
        boolean z2 = true;
        int i6 = 0;
        while (true) {
            if (!z2) {
                try {
                    if (i5 >= list.size()) {
                        break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return arrayList;
            }
            if (!z2) {
                strSubstring = list.get(i5).replaceAll("\\s", str3);
                if (str3.equals(strSubstring)) {
                    str = str3;
                    i5++;
                    str3 = str;
                } else if (this.f5288m != 0) {
                    strSubstring = z.k("  ") + strSubstring + "\n";
                } else {
                    strSubstring = strSubstring + "\n";
                }
            } else {
                i4 -= this.N;
            }
            while (strSubstring.length() > 0) {
                int textSize = (int) (i4 - (z2 ? this.f5292o.getTextSize() : this.f5296q.getTextSize()));
                if (textSize <= 0 && this.a != null) {
                    o oVar = new o();
                    oVar.a = arrayList.size();
                    oVar.f5317d = new ArrayList(arrayList2);
                    oVar.f5316c = i6;
                    arrayList.add(oVar);
                    if (!zA) {
                        a(arrayList, zB, i6);
                    }
                    arrayList2.clear();
                    i4 = this.C;
                    i6 = 0;
                } else {
                    if (z2) {
                        str2 = str3;
                        iBreakText = this.f5292o.breakText(strSubstring, true, this.B, null);
                    } else {
                        str2 = str3;
                        iBreakText = this.f5296q.breakText(strSubstring, true, this.B, null);
                    }
                    String strSubstring2 = strSubstring.substring(0, iBreakText);
                    if (!"\n".equals(strSubstring2)) {
                        arrayList2.add(strSubstring2);
                        if (z2) {
                            i6++;
                            i2 = this.L;
                        } else {
                            i2 = this.K;
                        }
                        textSize -= i2;
                    }
                    i4 = textSize;
                    strSubstring = strSubstring.substring(iBreakText);
                    str3 = str2;
                }
            }
            str = str3;
            if (!z2 && arrayList2.size() != 0) {
                i4 = (i4 - this.M) + this.K;
            }
            if (z2) {
                i4 = (i4 - this.N) + this.L;
                z2 = false;
            }
            i5++;
            str3 = str;
        }
        if (arrayList2.size() != 0 && this.a != null) {
            o oVar2 = new o();
            oVar2.a = arrayList.size();
            oVar2.f5317d = new ArrayList(arrayList2);
            oVar2.f5316c = i6;
            arrayList.add(oVar2);
            if (!zA) {
                a(arrayList, zB, i6);
            }
            arrayList2.clear();
        }
        return arrayList;
    }

    private void a(List<o> list, boolean z2, int i2) {
        if (this.R != 2 || this.Q == null) {
            return;
        }
        int size = list.size();
        int i3 = this.f5305u0 + size;
        int i4 = this.S;
        if (i4 <= 0 || i3 % i4 != 0) {
            return;
        }
        o oVar = new o();
        oVar.f5318e = true;
        oVar.a = size;
        oVar.f5323j = z2;
        oVar.f5322i = this.Q;
        oVar.f5316c = i2;
        oVar.f5319f = "type_ad";
        list.add(oVar);
    }

    public void a(int i2) {
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.a(i2);
        }
    }

    public void a(BaiduTtsModel baiduTtsModel) {
        V();
        a((Object) baiduTtsModel);
    }

    private void a(Object obj) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = obj;
        this.f5313y0.sendMessage(messageObtain);
    }

    @Override // com.amgcyo.cuttadon.j.h.f
    public void a(String str) {
        if (this.f5266a0 != null) {
            this.f5283j0 = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            sb.append("是否拆分:  ");
            sb.append(this.f5315z0);
            sb.append("   集合状态:  ");
            sb.append(!com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0));
            sb.toString();
            if (this.f5315z0 && !com.amgcyo.cuttadon.utils.otherutils.g.a(this.A0)) {
                this.C0++;
                if (this.C0 >= this.A0.size()) {
                    this.A0 = null;
                    this.f5315z0 = false;
                    Z();
                    this.C0 = 0;
                    return;
                }
                String str2 = this.A0.get(this.C0);
                String str3 = "文本过长，需要拆分成" + this.A0.size() + "段;\n正在读取第" + this.C0 + "段文本: " + str2;
                this.f5266a0.a(str2, String.valueOf(this.f5283j0));
                return;
            }
            Z();
        }
    }

    @Override // com.amgcyo.cuttadon.j.h.f
    public void a(int i2, String str, String str2) {
        if (i2 == 0) {
            if (!TextUtils.isEmpty(str)) {
                com.amgcyo.cuttadon.f.o.b("使用《" + str + "》开始播放");
            }
            EventBus.getDefault().post(new g(1, str2, str), "begin_tts");
            return;
        }
        com.amgcyo.cuttadon.f.o.b("语音初始化失败!错误码：55805:(" + i2 + ad.f20406s);
    }

    public void a(com.amgcyo.cuttadon.j.h.e eVar) {
        this.f5279h0 = true;
        this.f5266a0 = eVar;
        this.Z = null;
        k(this.f5283j0);
        PageView pageView = this.f5276g;
        if (pageView != null) {
            pageView.a(false);
        }
    }
}
