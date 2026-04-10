package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.api.error.AdFreqError;
import com.bytedance.msdk.api.error.AdPacingError;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomAdConfig;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c implements TTAbsAdLoaderAdapter.AdapterLoaderListener {
    protected long C;
    protected long D;
    protected long E;
    protected long F;
    protected bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d G;
    protected Context H;
    protected ITTAdatperCallback I;
    protected ITTAdatperCallback J;
    protected TTBaseAd N;
    protected GMNetworkRequestInfo S;
    private boolean W;
    protected int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected TTBaseAd f1642a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected b.f f1643b0;
    protected volatile boolean K = false;
    protected volatile boolean L = false;
    protected volatile boolean M = false;
    private final Map<String, TTAbsAdLoaderAdapter> O = new HashMap();
    protected int P = -1000;
    protected int Q = -1000;
    protected final AtomicBoolean R = new AtomicBoolean(false);
    private ConcurrentHashMap<String, AdLoadInfo> T = new ConcurrentHashMap<>();
    protected long U = 0;
    private long V = 0;
    private final Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> X = new HashMap();
    protected boolean Y = false;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> f1644c0 = new h(this);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> f1645d0 = new i(this);

    class a implements Runnable {
        final /* synthetic */ AdError a;

        a(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    class c implements Runnable {
        final /* synthetic */ AdError a;

        c(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ AdError b;

        d(List list, AdError adError) {
            this.a = list;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e$e, reason: collision with other inner class name */
    class RunnableC0049e implements Runnable {
        RunnableC0049e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    class f implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.P();
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.a.get() || e.this.f1614c.get()) {
                return;
            }
            e.this.f1614c.set(true);
            AdSlot adSlot = e.this.f1619h;
            if ((adSlot != null && adSlot.getAdType() == 7) || e.this.f1619h.getAdType() == 8) {
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "m-sdk----设置 cacheTimeout 已到时间【" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().d(e.this.f1619h.getAdUnitId()) + "】，给外部invokeAdVideoCache ...");
            }
            if (e.this.t()) {
                return;
            }
            e.this.f0();
            ThreadHelper.runOnUiThread(new a());
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    class h implements Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> {
        h(e eVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar2) {
            int iP;
            int iP2;
            if (jVar.p() == jVar2.p()) {
                iP = jVar.y();
                iP2 = jVar2.y();
            } else {
                iP = jVar.p();
                iP2 = jVar2.p();
            }
            return iP - iP2;
        }
    }

    class i implements Comparator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> {
        i(e eVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar2) {
            return (jVar.i() > jVar2.i() ? 1 : (jVar.i() == jVar2.i() ? 0 : -1)) >= 0 ? -1 : 1;
        }
    }

    class j extends Handler {
        j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.a(message);
        }
    }

    class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.a(message);
        }
    }

    class l implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ StackTraceElement[] b;

        l(boolean z2, StackTraceElement[] stackTraceElementArr) {
            this.a = z2;
            this.b = stackTraceElementArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Integer> list;
            Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> map;
            String str;
            e eVar;
            AdBreakError adBreakError;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVar;
            e.this.U = SystemClock.elapsedRealtime();
            e.this.j0();
            if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.k()) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "MSDK未进行初始化！！！");
                e.this.e(1);
                eVar = e.this;
                adBreakError = new AdBreakError(1, AdError.getMessage(1));
            } else if (e.this.M) {
                Logger.e("TTMediationSDK", "调用过销毁方法_destroy()！！！");
                e.this.e(AdError.ERROR_CODE_DESTROY);
                eVar = e.this;
                adBreakError = new AdBreakError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
            } else {
                e eVar2 = e.this;
                if (eVar2.H == null) {
                    Logger.e("TTMediationSDK", "Context为null！！！");
                    e.this.e(AdError.ERROR_CODE_CONTEXT_ERROR);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_CONTEXT_ERROR, AdError.getMessage(AdError.ERROR_CODE_CONTEXT_ERROR));
                } else if (eVar2.f1619h == null) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "AdSlot can't be null！！");
                    e.this.e(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_CONFIG_ERROR));
                } else if (eVar2.f1618g == null) {
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "msdk threadHandler can't be null！！");
                    e.this.e(AdError.ERROR_CODE_MSDK_THREAD_HANDLER);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_MSDK_THREAD_HANDLER, AdError.getMessage(AdError.ERROR_CODE_MSDK_THREAD_HANDLER));
                } else {
                    if (eVar2.f1615d == null && (dVar = eVar2.G) != null) {
                        eVar2.f1615d = dVar.c(eVar2.f1617f);
                        e.this.W();
                        e.this.j0();
                    }
                    e eVar3 = e.this;
                    eVar3.K = true;
                    eVar3.Y();
                    if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.a.b().a()) {
                        String strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(e.this.f1619h.getTestSlotId());
                        if (!TextUtils.isEmpty(strA)) {
                            e.this.z();
                            e eVar4 = e.this;
                            eVar4.f1615d = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(eVar4.f1615d, strA);
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = e.this.f1615d;
                            int iY = cVar != null ? cVar.y() : 0;
                            e.this.W();
                            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "测试工具加载广告........totalWaterFallCount: " + iY + "  ,rit_id:" + e.this.f1617f + " ,slot_id:" + strA);
                        }
                        e.this.Z();
                        if (e.this.f1619h.getAdType() == 3 && TextUtils.equals(m0.a(), "com.header.app.untext") && e.this.f1619h.isForceLoadBottom()) {
                            str = "强制开启开屏兜底...............";
                        } else {
                            e eVar5 = e.this;
                            if (eVar5.f1615d != null) {
                                eVar5.f1631t = eVar5.f1619h.getAdCount();
                                e eVar6 = e.this;
                                eVar6.f1616e = eVar6.f1615d.A();
                                e eVar7 = e.this;
                                eVar7.f1625n = new ArrayList(eVar7.f1615d.i());
                                if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().f(e.this.f1617f) || (list = e.this.f1625n) == null || list.size() == 0 || (map = e.this.f1616e) == null || map.size() == 0) {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "settings config.......注意，AdUnitId = " + e.this.f1619h.getAdUnitId() + "  没有对应的waterfall配置信息");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f1619h, 3);
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    e eVar8 = e.this;
                                    eVar8.a(eVar8.f1617f, eVar8.R);
                                    return;
                                }
                                if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().b(e.this.f1617f + "")) {
                                    Logger.d("TMe", "广告位 请求触发次数拦截............");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVarH = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().h(e.this.f1617f + "");
                                    Pair<String, String> pairF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().f(e.this.f1617f);
                                    if (gVarH == null || pairF == null) {
                                        return;
                                    }
                                    AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_EXCEED_FREQCTL), (String) pairF.second, (String) pairF.first);
                                    e.this.e(adFreqError.code);
                                    e.this.a(adFreqError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                                    return;
                                }
                                if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().c(e.this.f1617f + "") && !e.this.t()) {
                                    Logger.d("TMe", "广告位 请求触发时间间隔拦截............");
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVarI = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().i(e.this.f1617f + "");
                                    if (iVarI != null) {
                                        AdPacingError adPacingError = new AdPacingError(AdError.ERROR_CODE_EXCEED_PACING, AdError.getMessage(AdError.ERROR_CODE_EXCEED_PACING), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m.b().g(e.this.f1617f) + "", iVarI.j());
                                        e.this.e(adPacingError.code);
                                        e.this.a(adPacingError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                                        return;
                                    }
                                    return;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.b.a(e.this.f1625n);
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b bVarD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
                                e eVar9 = e.this;
                                if (bVarD.a(eVar9.f1617f, eVar9.e()) == 2) {
                                    boolean z2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().d(e.this.f1617f) == null;
                                    if (!e.this.t() && !z2 && e.this.R()) {
                                        e eVar10 = e.this;
                                        eVar10.Y = true;
                                        eVar10.N();
                                        return;
                                    } else {
                                        if (!e.this.t() && !z2) {
                                            e.this.f1619h.setPrimeRitReqType(3);
                                        }
                                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b bVarD2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d();
                                        e eVar11 = e.this;
                                        bVarD2.a(eVar11.f1617f, eVar11.f1619h);
                                    }
                                }
                                e.this.e(0);
                                e.this.a(this.a, this.b);
                                e eVar12 = e.this;
                                eVar12.f1630s.a(eVar12.f1625n);
                                e eVar13 = e.this;
                                eVar13.f1630s.e(eVar13.f1615d.y());
                                e eVar14 = e.this;
                                Handler handler = eVar14.f1618g;
                                if (handler != null) {
                                    handler.sendEmptyMessageDelayed(2, eVar14.E);
                                }
                                if (e.this.f1615d.I()) {
                                    e eVar15 = e.this;
                                    eVar15.f1623l = 0;
                                    eVar15.f1630s.b(true);
                                    e.this.i0();
                                } else {
                                    e.this.X();
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).c(1);
                                return;
                            }
                            if (eVar5.f1619h.getAdType() != 3 || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().x() || e.this.S == null) {
                                if (e.this.G == null || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g()) {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "settings config.......没有settings config配置信息,AdUnitId = " + e.this.f1619h.getAdUnitId());
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f1619h, 1);
                                } else {
                                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "settings config.......注意，AdUnitId = " + e.this.f1619h.getAdUnitId() + " 的配置信息为 null ！！");
                                    e.this.e(AdError.ERROR_CODE_REQUEST_BUT_CONFIG_ERROR);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(e.this.f1619h, 2);
                                }
                                e eVar16 = e.this;
                                eVar16.a(eVar16.f1617f, eVar16.R);
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.e();
                                return;
                            }
                            str = "执行开启开屏兜底...............";
                        }
                        Logger.e("TTMediationSDK", str);
                        e.this.T();
                        return;
                    }
                    Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(e.this.f1617f) + "请求过于频繁，触发了熔断机制");
                    e.this.e(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER);
                    eVar = e.this;
                    adBreakError = new AdBreakError(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER, AdError.getMessage(AdError.ERROR_CODE_REQUEST_CIRCUIT_BREAKER));
                }
            }
            eVar.a(adBreakError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
        }
    }

    class m implements Runnable {
        final /* synthetic */ GMCustomBaseAdapter a;
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f1650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1651f;

        m(GMCustomBaseAdapter gMCustomBaseAdapter, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3, long j2, int i4) {
            this.a = gMCustomBaseAdapter;
            this.b = jVar;
            this.f1648c = i2;
            this.f1649d = i3;
            this.f1650e = j2;
            this.f1651f = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.loadInner(e.this.H, e.this.f1619h, e.this.f1634w, this.b, e.this.a(this.f1648c, this.f1649d, this.b, this.f1650e), e.this.f1633v, this.f1651f, e.this);
            } catch (Exception e2) {
                e eVar = e.this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", eVar.N, eVar.f1619h, this.b, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 加载广告内部错误 " + e2.getClass().getName()));
                e2.printStackTrace();
            }
        }
    }

    class n implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        n(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.a, this.b);
        }
    }

    class o implements IGMInitAdnResult {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        o(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            e.this.a(this.a, this.b);
        }
    }

    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.f1618g != null) {
                    e.this.f1618g.removeCallbacksAndMessages(null);
                }
                if (e.this.f1628q != null) {
                    e.this.f1628q.clear();
                }
                if (e.this.f1626o != null) {
                    e.this.f1626o.clear();
                }
                if (e.this.f1627p != null) {
                    e.this.f1627p.clear();
                }
                if (e.this.N != null) {
                    e.this.N.onDestroy();
                }
                if (e.this.O != null) {
                    for (Map.Entry entry : e.this.O.entrySet()) {
                        if (entry != null) {
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = (TTAbsAdLoaderAdapter) entry.getValue();
                            tTAbsAdLoaderAdapter.setAdapterListener(null);
                            tTAbsAdLoaderAdapter.destroy();
                        }
                    }
                    e.this.O.clear();
                }
                e.this.f1630s.h();
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
            e eVar = e.this;
            eVar.I = null;
            eVar.J = null;
            eVar.G = null;
            eVar.f1616e = null;
            eVar.H = null;
            eVar.S = null;
            eVar.M = true;
            if (eVar.K) {
                e.this.a(new AdBreakError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
            }
        }
    }

    class q implements Runnable {
        final /* synthetic */ boolean a;

        q(boolean z2) {
            this.a = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            b.f fVar = eVar.f1643b0;
            if (fVar != null) {
                fVar.a(eVar.f1617f, this.a);
            }
        }
    }

    class r implements Runnable {
        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.O();
        }
    }

    protected e(Context context, String str) {
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> mapA;
        this.H = context;
        this.f1617f = str;
        this.G = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVar = this.G;
        if (dVar != null) {
            a(dVar.l());
            d(this.G.o());
            this.f1615d = this.G.c(this.f1617f);
            W();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null && (mapA = cVar.A()) != null) {
            for (Map.Entry<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> entry : mapA.entrySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> value = entry.getValue();
                if (value != null && value.size() > 0 && value.get(0).f() == 100) {
                    this.X.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Looper mSDKThreadLooper = ThreadHelper.getMSDKThreadLooper();
        if (mSDKThreadLooper != null) {
            this.f1618g = new j(mSDKThreadLooper);
        } else {
            ThreadHelper.initMSDKThread();
            this.f1618g = new k(ThreadHelper.getMSDKThreadLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, long j2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(jVar, this.f1619h, this.f1629r, this.S, i2, i3, !t(), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Handler handler;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(str2, str, -4, -4);
        if (this.C != 0 && (handler = this.f1618g) != null) {
            handler.removeMessages(3);
            this.f1618g.sendEmptyMessageDelayed(3, this.C);
        }
        a(jVarA, -1);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).c(1);
    }

    private void a(boolean z2) {
        ThreadHelper.runOnMSDKThread(new q(z2));
    }

    private boolean a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i4, long j2) {
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapterC = c(jVar);
        if (tTAbsAdLoaderAdapterC == null) {
            a(jVar, i2, i3);
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + " 创建TTAbsAdLoaderAdapter失败");
        } else {
            if (this.H != null) {
                tTAbsAdLoaderAdapterC.setAdapterListener(this);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i iVar = this.f1633v;
                if (iVar != null) {
                    jVar.h(iVar.a);
                }
                if (jVar.f() == 2 && jVar.x() != null) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f1619h, tTAbsAdLoaderAdapterC.getSdkVersion());
                }
                tTAbsAdLoaderAdapterC.loadAdInter(this.H, jVar, a(i2, i3, jVar, j2), this.f1619h, this.f1633v, i4, this.f1634w);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.f1617f, jVar.d(), jVar, i4);
                return true;
            }
            a(jVar, i2, i3);
        }
        return false;
    }

    private boolean a(Class<?> cls, Class<?> cls2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        String strB;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.a(cls, cls2)) {
            strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.b(cls, cls2);
        } else {
            strB = "自定义ADN初始化对象失败  ---------  初始化类 " + cls.getSimpleName() + " 需要继承自自定义ADN的广告对象基类 " + cls2.getSimpleName();
        }
        if (TextUtils.isEmpty(strB)) {
            return true;
        }
        Logger.e("TTMediationSDK_SDK_Init", strB);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, strB));
        return false;
    }

    private boolean a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.f1617f, str, jVar, i2);
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> listA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f1619h);
        if (listA == null || listA.size() <= 0) {
            return false;
        }
        TTBaseAd tTBaseAd = listA.get(0).a;
        AdSlot adSlot = this.f1619h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(jVar, this.f1619h, 3, mediationRitReqType);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f1619h, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str), !t(), 1, i2, 3, mediationRitReqType, (AdError) null, -1L);
        ArrayList arrayList = new ArrayList();
        for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : listA) {
            eVar.a.setMediationRitReqType(3);
            eVar.a.setMediationRitReqTypeSrc(mediationRitReqType);
            a(eVar.a, str);
            arrayList.add(eVar.a);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(listA.get(0).a, 0, "adn cache命中", 0L, this.f1619h, i2, arrayList.size(), 2, (String) null, -1L);
        onAdLoaded(arrayList, listA.get(0).b);
        return true;
    }

    private int a0() {
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> mapA;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        int size = 0;
        if (cVar != null && (mapA = cVar.A()) != null && mapA.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(mapA.keySet());
            for (Integer num : arrayList) {
                if (this.f1630s.c(num.intValue()) && (list = mapA.get(num)) != null) {
                    size += list.size();
                }
            }
        }
        return size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.base.TTBaseAd b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L5
            goto Laa
        L5:
            java.lang.String r1 = r6.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h r2 = r6.x()
            if (r2 == 0) goto L18
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h r6 = r6.x()
            java.lang.String r6 = r6.c()
            goto L19
        L18:
            r6 = r0
        L19:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L21
            goto Laa
        L21:
            java.util.List<com.bytedance.msdk.base.TTBaseAd> r2 = r5.f1628q
            java.util.Iterator r2 = r2.iterator()
        L27:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L41
            java.lang.Object r3 = r2.next()
            com.bytedance.msdk.base.TTBaseAd r3 = (com.bytedance.msdk.base.TTBaseAd) r3
            if (r3 == 0) goto L27
            java.lang.String r4 = r3.getAdNetworkSlotId()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L27
        L3f:
            r0 = r3
            goto Laa
        L41:
            java.util.List<com.bytedance.msdk.base.TTBaseAd> r2 = r5.f1626o
            java.util.Iterator r2 = r2.iterator()
        L47:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L60
            java.lang.Object r3 = r2.next()
            com.bytedance.msdk.base.TTBaseAd r3 = (com.bytedance.msdk.base.TTBaseAd) r3
            if (r3 == 0) goto L47
            java.lang.String r4 = r3.getAdNetworkSlotId()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L47
            goto L3f
        L60:
            java.util.List<com.bytedance.msdk.base.TTBaseAd> r2 = r5.f1627p
            java.util.Iterator r2 = r2.iterator()
        L66:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Laa
            java.lang.Object r3 = r2.next()
            com.bytedance.msdk.base.TTBaseAd r3 = (com.bytedance.msdk.base.TTBaseAd) r3
            if (r3 == 0) goto L66
            boolean r4 = r3.isServerBiddingAd()
            if (r4 == 0) goto L9f
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto L9f
            java.lang.String r4 = r3.getAid()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L9f
            java.lang.String r4 = r3.getAdNetworkSlotId()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L66
            java.lang.String r4 = r3.getAid()
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L66
            goto La9
        L9f:
            java.lang.String r4 = r3.getAdNetworkSlotId()
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L66
        La9:
            goto L3f
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j):com.bytedance.msdk.base.TTBaseAd");
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x010c: MOVE (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:34:0x010c */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0110: MOVE (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:36:0x0110 */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0114: MOVE (r4 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:38:0x0114 */
    private boolean b(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i4, long j2) {
        String str;
        String str2;
        GMCustomAdConfig className;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (this.f1634w == null) {
            Logger.e("TTMediationSDK_SDK_Init", "自定义Adapter 老API不支持自定义Adapter，请使用新的API");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 老API不支持自定义Adapter，请使用新的API"));
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(jVar.e());
            if (aVarA == null) {
                a(jVar, i2, i3);
                str6 = "自定义Adapter 配置为空";
            } else {
                Logger.i("TTMediationSDK_SDK_Init", "自定义Adapter 获取配置wfcBean = " + jVar);
                try {
                    className = aVarA.c().getClassName(jVar.t(), jVar.z());
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    str = "TTMediationSDK_SDK_Init";
                    str2 = "";
                }
                if (className == null) {
                    str6 = "自定义Adapter 配置的className为空，无法反射创建自定义广告Adapter对象 ";
                } else {
                    Class<?> cls = Class.forName(className.getClassName());
                    try {
                        if (a(cls, className.getClazz(), jVar)) {
                            try {
                                Object objNewInstance = cls.newInstance();
                                try {
                                    if (objNewInstance instanceof GMCustomBaseAdapter) {
                                        GMCustomBaseAdapter gMCustomBaseAdapter = (GMCustomBaseAdapter) objNewInstance;
                                        Logger.i("TTMediationSDK_SDK_Init", "自定义Adapter 反射创建初始化对象为 " + gMCustomBaseAdapter);
                                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(jVar.e()) != null) {
                                            ThreadHelper.runOnThreadPool(new m(gMCustomBaseAdapter, jVar, i2, i3, j2, i4));
                                            return true;
                                        }
                                        Logger.e("TTMediationSDK_SDK_Init", "自定义Adapter 创建广告对象失败  ---------  没有初始化，不能加载广告，请检查初始化配置");
                                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("", this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, "自定义Adapter 创建广告对象失败  ---------  没有初始化，不能加载广告，请检查初始化配置"));
                                        str = "TTMediationSDK_SDK_Init";
                                        str2 = "";
                                    } else {
                                        str = "TTMediationSDK_SDK_Init";
                                        String str8 = "自定义ADN 创建广告对象失败  ---------  对象类型错误  对象类型为 " + GMCustomBaseAdapter.class.getName();
                                        Logger.e(str, str8);
                                        str2 = "";
                                        try {
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str8));
                                        } catch (IllegalAccessException e3) {
                                            e = e3;
                                            e.printStackTrace();
                                            str7 = "自定义Adapter IllegalAccessException";
                                            Logger.e(str, str7);
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                            a(jVar, i2, i3);
                                            return false;
                                        } catch (InstantiationException e4) {
                                            e = e4;
                                            e.printStackTrace();
                                            str7 = "自定义Adapter InstantiationException";
                                            Logger.e(str, str7);
                                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                            a(jVar, i2, i3);
                                            return false;
                                        }
                                    }
                                    a(jVar, i2, i3);
                                    return true;
                                } catch (ClassNotFoundException e5) {
                                    e = e5;
                                    str2 = str5;
                                    e.printStackTrace();
                                    str7 = "自定义Adapter ClassNotFoundException";
                                    Logger.e(str, str7);
                                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                                    a(jVar, i2, i3);
                                    return false;
                                } catch (IllegalAccessException e6) {
                                    e = e6;
                                    str2 = str4;
                                } catch (InstantiationException e7) {
                                    e = e7;
                                    str2 = str3;
                                }
                            } catch (IllegalAccessException e8) {
                                e = e8;
                                str = "TTMediationSDK_SDK_Init";
                                str2 = "";
                            } catch (InstantiationException e9) {
                                e = e9;
                                str = "TTMediationSDK_SDK_Init";
                                str2 = "";
                            }
                        } else {
                            str = "TTMediationSDK_SDK_Init";
                            str2 = "";
                        }
                    } catch (ClassNotFoundException e10) {
                        e = e10;
                    }
                    Logger.e(str, str7);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
                    a(jVar, i2, i3);
                }
            }
            str = "TTMediationSDK_SDK_Init";
            str2 = "";
            str7 = str6;
            Logger.e(str, str7);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(str2, this.N, this.f1619h, jVar, new AdError(AdError.ERROR_CODE_CUSTOM_LOAD, str7));
            a(jVar, i2, i3);
        }
        return false;
    }

    private boolean b0() {
        List<TTBaseAd> list = this.f1628q;
        if (list != null) {
            Iterator<TTBaseAd> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list2 = this.f1627p;
        if (list2 != null) {
            Iterator<TTBaseAd> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next().isCacheSuccess()) {
                    return true;
                }
            }
        }
        List<TTBaseAd> list3 = this.f1626o;
        if (list3 != null) {
            Iterator<TTBaseAd> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (it3.next().isCacheSuccess()) {
                    return true;
                }
            }
        }
        return false;
    }

    private TTAbsAdLoaderAdapter c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        if (jVar != null) {
            return (TextUtils.equals("baidu", jVar.e()) && jVar.G()) ? a(this.f1619h.getLinkedId(), this.f1617f, jVar.d()) : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1617f, jVar);
        }
        Logger.i("TTMediationSDK", "wfcBean is null getTTAbsAdLoaderAdapter fail");
        return null;
    }

    private boolean c0() {
        return !t();
    }

    private void d(AdError adError) {
        this.W = true;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f1619h, adError, cVar != null ? cVar.C() : null, j());
    }

    private boolean d0() {
        return t() && h() == 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5 A[PHI: r0 r1
  0x00a5: PHI (r0v20 char) = (r0v18 char), (r0v23 char), (r0v24 char), (r0v24 char) binds: [B:24:0x0091, B:26:0x00a7, B:32:0x00b7, B:60:0x00a5] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r1v7 char) = (r1v6 char), (r1v8 char), (r1v9 char), (r1v9 char) binds: [B:24:0x0091, B:26:0x00a7, B:32:0x00b7, B:60:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a5 -> B:26:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00fb -> B:52:0x00fd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e0() {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.e0():void");
    }

    private TTBaseAd f(List<TTBaseAd> list) {
        TTBaseAd tTBaseAd = null;
        if (list != null && list.size() != 0) {
            for (TTBaseAd tTBaseAd2 : list) {
                if (tTBaseAd == null || tTBaseAd2.getFillTime() < tTBaseAd.getFillTime()) {
                    tTBaseAd = tTBaseAd2;
                }
            }
        }
        return tTBaseAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        AdSlot adSlot = this.f1619h;
        if ((adSlot == null || adSlot.getAdType() != 7) && this.f1619h.getAdType() != 8) {
            return;
        }
        AdSlot adSlot2 = this.f1619h;
        TTBaseAd tTBaseAd = this.N;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.V;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot2, tTBaseAd, jElapsedRealtime - j2, cVar != null ? cVar.C() : null);
    }

    private List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> g(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = list.iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j next = it.next();
            if (next.F()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.G() || next.E() || next.B()) {
                it.remove();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j();
                jVar.a(next.d());
                jVar.c(next.f());
                jVar.b(next.e());
                jVar.a(next.c());
                jVar.g(next.q());
                jVar.g(next.p());
                jVar.j(next.y());
                jVar.i(next.t());
                jVar.e("" + next.i());
                jVar.f(next.j());
                jVar.i(next.A());
                jVar.h(next.u());
                jVar.a(next.x());
                TTBaseAd tTBaseAdB = b(jVar);
                if (tTBaseAdB != null) {
                    jVar.e("" + tTBaseAdB.getBiddingCpmWithOutExchangeRate());
                }
                arrayList.add(jVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.f1645d0);
        Collections.sort(arrayList2, this.f1644c0);
        list.addAll(0, arrayList2);
        return list;
    }

    private void g0() {
        if (this.f1618g != null) {
            if (!b0()) {
                this.f1618g.postDelayed(new f(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().d(this.f1619h.getAdUnitId()));
                return;
            }
            if (!this.a.get() || this.f1614c.get()) {
                return;
            }
            this.f1614c.set(true);
            AdSlot adSlot = this.f1619h;
            if ((adSlot != null && adSlot.getAdType() == 7) || this.f1619h.getAdType() == 8) {
                Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "从onAdLoaded给外部invokeAdVideoCache ...");
            }
            if (t()) {
                return;
            }
            f0();
            ThreadHelper.runOnUiThread(new RunnableC0049e());
        }
    }

    private void h0() {
        Handler handler = this.f1618g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        AdError adError;
        this.f1636y = System.currentTimeMillis();
        Map<Integer, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> map = this.f1616e;
        if (map == null) {
            adError = new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG));
        } else {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list = map.get(0);
            if (!h0.a(list)) {
                e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c().a(this.B, this.H, this.f1619h, list, this.f1615d, this.f1619h.getPrimeRitReqType(), !t()));
                return;
            }
            adError = new AdError(AdError.ERROR_CODE_NO_CONFIG, AdError.getMessage(AdError.ERROR_CODE_NO_CONFIG));
        }
        c(adError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        AdSlot adSlot = this.f1619h;
        if (adSlot == null || this.f1615d == null) {
            return;
        }
        adSlot.setNetWorkNum("network_ad_num_" + this.f1615d.b());
        GMAdSlotBase gMAdSlotBase = this.f1634w;
        if (gMAdSlotBase != null) {
            gMAdSlotBase.setNetWorkNum("network_ad_num_" + this.f1615d.b());
        }
    }

    public void B() {
        ThreadHelper.runOnMSDKThread(new p());
    }

    public List<AdLoadInfo> C() {
        AdLoadInfo value;
        ArrayList arrayList = new ArrayList(this.T.size());
        for (Map.Entry<String, AdLoadInfo> entry : this.T.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals(AdLoadInfo.AD_LOADED, value.getErrMsg()) && !TextUtils.equals(AdLoadInfo.AD_LOADING, value.getErrMsg())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public ConcurrentHashMap<String, AdLoadInfo> D() {
        return this.T;
    }

    public int E() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    public String F() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkSlotId();
        }
        return null;
    }

    public Map<String, Object> G() {
        TTBaseAd tTBaseAd = this.N;
        return tTBaseAd != null ? tTBaseAd.getMediaExtraInfo() : new HashMap();
    }

    public String H() {
        if (this.N == null) {
            return null;
        }
        return (o() || !(this.N.isServerBiddingAd() || this.N.isClientBiddingAd() || this.N.isMultiBiddingAd())) ? this.N.getNetWorkPlatFormCpm() : GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public int I() {
        return this.Z;
    }

    public GMAdEcpmInfo J() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null) {
            return null;
        }
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p.a(tTBaseAd, true);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> K() {
        boolean z2;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> arrayList = new ArrayList<>();
        if (this.M) {
            return arrayList;
        }
        List<Integer> list = this.f1625n;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            z2 = false;
        } else {
            int i3 = 0;
            z2 = false;
            while (i2 < list.size()) {
                int iIntValue = list.get(i2).intValue();
                if (iIntValue == -100) {
                    i3 = 1;
                }
                if (iIntValue < -100) {
                    z2 = true;
                }
                if (this.f1616e.get(Integer.valueOf(iIntValue)) != null) {
                    arrayList.addAll(this.f1616e.get(Integer.valueOf(iIntValue)));
                }
                i2++;
            }
            i2 = i3;
        }
        if (i2 == 0 && n() && !h0.b(this.f1627p)) {
            for (TTBaseAd tTBaseAd : this.f1627p) {
                if (this.f1615d != null && (tTBaseAd.isMultiBiddingAd() || tTBaseAd.isClientBiddingAd())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVarA = this.f1615d.a(tTBaseAd.getAdNetworkSlotId());
                    if (jVarA != null) {
                        arrayList.add(jVarA);
                    }
                }
            }
        }
        if (!z2) {
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> listG = g();
            if (!h0.a(listG)) {
                arrayList.addAll(listG);
            }
        }
        Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (p() || n()) {
            return g(arrayList);
        }
        Collections.sort(arrayList, this.f1644c0);
        return arrayList;
    }

    protected void L() {
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "超过当前层最短加载时间.....");
        if (this.a.get() || this.b.get()) {
            return;
        }
        if (r()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "超过当前层最短加载时间....有P层广告回调成功出去....");
            q();
        }
        if (p() && !x()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "超过当前层最短加载时间.....  当前有serverBidding广告，serverBidding请求还未发起或者还没有返回.......");
            return;
        }
        if (s() && m()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "超过当前层最短加载时间且满足client bidding限制条件....有广告回调成功出去....");
            q();
        }
    }

    protected void M() {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        this.f1630s.a(true);
        V();
        if (this.a.get() || this.b.get()) {
            return;
        }
        List<TTBaseAd> list3 = this.f1628q;
        if ((list3 == null || list3.size() <= 0) && (((list = this.f1626o) == null || list.size() <= 0) && ((list2 = this.f1627p) == null || list2.size() <= 0))) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "总加载时间超时.......没有广告回调失败");
            a(new AdError(AdError.LOAD_AD_TIME_OUT_ERROR, AdError.getMessage(AdError.LOAD_AD_TIME_OUT_ERROR)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
            return;
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "总加载时间超时.......有广告回调成功");
        q();
    }

    protected void N() {
        AdSlot adSlotA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f1617f);
        if (adSlotA != null) {
            this.f1619h.setLinkedId(adSlotA.getLinkedId());
            this.f1619h.setPrimeRitReqType(adSlotA.getPrimeRitReqType());
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f1617f, this.f1619h);
        e(0);
        e((List<TTBaseAd>) null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c cVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().c(this.f1617f);
        if (cVarC != null) {
            this.f1633v = cVarC.f1633v;
            this.T = cVarC.D();
        }
        q();
    }

    protected abstract void O();

    protected abstract void P();

    protected void Q() {
        AdSlot adSlot = this.f1619h;
        if ((adSlot != null && adSlot.getAdType() == 7) || this.f1619h.getAdType() == 8) {
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
        }
        if (t()) {
            return;
        }
        f0();
        ThreadHelper.runOnUiThread(new g());
    }

    protected boolean R() {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> listE;
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "mLoadSortList: " + this.f1625n);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f1617f, this.f1619h, cVar != null ? cVar.C() : null) && (listE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().e(this.f1617f)) != null && listE.size() > 0) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar : listE) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar.a);
                c(arrayList);
            }
            if (this.f1628q.size() > 0 || this.f1627p.size() > 0 || this.f1626o.size() > 0) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "--==-- not hit cache!!! -----");
        return false;
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x001c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void S() {
        /*
            r3 = this;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            boolean r0 = r0.t()
            if (r0 == 0) goto L13
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            goto L14
        L13:
            r1 = 0
        L14:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e$l r2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e$l
            r2.<init>(r0, r1)
            com.bytedance.msdk.adapter.util.ThreadHelper.runOnMSDKThread(r2)
        L1c:
            r0 = 49
            switch(r0) {
                case 49: goto L22;
                case 50: goto L22;
                case 51: goto L2a;
                default: goto L21;
            }
        L21:
            goto L1c
        L22:
            r1 = 52
            r2 = 96
            switch(r2) {
                case 94: goto L1c;
                case 95: goto L2b;
                case 96: goto L2a;
                default: goto L29;
            }
        L29:
            goto L22
        L2a:
            return
        L2b:
            r2 = 49
        L2d:
            switch(r1) {
                case 55: goto L35;
                case 56: goto L1c;
                case 57: goto L22;
                default: goto L30;
            }
        L30:
            r1 = 55
            r2 = 61
            goto L2d
        L35:
            switch(r2) {
                case 60: goto L22;
                case 61: goto L22;
                case 62: goto L39;
                default: goto L38;
            }
        L38:
            goto L1c
        L39:
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.S():void");
    }

    protected void T() {
        if (this.S != null) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "settings config.......AdUnitId = " + this.f1617f + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.bytedance.msdk.base.a.a(this.S.getAdNetworkFlatFromId()));
        }
        e(AdError.ERROR_CODE_CONFIG_ERROR);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f1619h, -4);
        e0();
    }

    public void U() {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        if (this.f1630s.b() != 0 || this.f1635x.get()) {
            return;
        }
        this.f1618g.removeMessages(5);
        if (p() && x()) {
            if (s()) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告成功返回...所有的ClientBidding都有返回结果且没有到达其层超时...当前广告池中广告数量满足要求...直接返回......");
                q();
            }
            if (this.f1630s.g() || !this.f1630s.f()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有广告都已经加载完成....... ");
            List<TTBaseAd> list3 = this.f1628q;
            if ((list3 == null || list3.size() <= 0) && (((list = this.f1626o) == null || list.size() <= 0) && ((list2 = this.f1627p) == null || list2.size() <= 0))) {
                a(new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                return;
            }
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "SeverBidding广告返回且到达ClientBidding的等待时间，所有广告都有返回结果...直接返回......");
            q();
        }
    }

    protected void V() {
        TTAbsAdLoaderAdapter value;
        for (Map.Entry<String, TTAbsAdLoaderAdapter> entry : this.O.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.setTotalTimedOut(true);
            }
        }
    }

    protected void W() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null) {
            cVar.e();
            this.C = this.f1615d.j();
            this.D = this.f1615d.h();
            this.E = this.f1615d.x();
            this.F = this.f1615d.l();
            this.f1621j = this.f1615d.F();
            this.f1620i = this.f1615d.G();
            this.f1622k = this.f1615d.k() == 0;
            this.f1615d.m();
            this.Z = this.f1615d.o();
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "mRitConfig=" + this.f1615d.toString());
        }
    }

    protected void X() {
        a(0, false);
    }

    protected void Y() {
        this.R.set(false);
        this.f1632u.set(false);
        this.f1627p.clear();
        this.f1626o.clear();
        this.f1628q.clear();
        this.a.set(false);
        this.b.set(false);
        this.f1614c.set(false);
        Handler handler = this.f1618g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.h hVar = this.f1630s;
        if (hVar != null) {
            hVar.h();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i iVar = this.f1633v;
        if (iVar != null) {
            iVar.a = null;
        }
    }

    protected void Z() {
        this.f1619h.setIfTest(e());
        this.f1619h.setTransparentParams(k());
        this.f1619h.setAdUnitId(this.f1617f);
        this.f1619h.setAdloadSeq(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a());
        this.f1619h.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        if (this.f1619h.getReuestParam() != null) {
            this.f1619h.getReuestParam().getExtraObject().put("tt_request_ad_type", Integer.valueOf(this.f1619h.getAdStyleType()));
        }
        this.f1619h.setReqType(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.f1617f, e()));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar != null) {
            this.f1619h.setWaterfallId(cVar.E());
            this.f1619h.setVersion(this.f1615d.z());
            this.f1619h.setSegmentId(this.f1615d.t());
            this.f1619h.setSegmentVersion(this.f1615d.u());
            this.f1619h.setmWaterfallExtra(this.f1615d.D());
            this.f1619h.setBidFloor(this.f1615d.c());
            this.f1619h.setParalleType(this.f1615d.m());
            this.f1619h.setReqParallelNum(this.f1615d.o());
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    protected void a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    /* JADX WARN: Removed duplicated region for block: B:62:0x018b A[PHI: r3
  0x018b: PHI (r3v15 char) = (r3v8 char), (r3v8 char), (r3v14 char), (r3v18 char) binds: [B:60:0x0187, B:82:0x018b, B:63:0x018d, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0191 A[PHI: r3
  0x0191: PHI (r3v12 char) = (r3v8 char), (r3v14 char) binds: [B:58:0x0183, B:63:0x018d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0181 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x018d -> B:62:0x018b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(android.os.Message r8) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(android.os.Message):void");
    }

    public void a(ViewGroup viewGroup) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.showSplashClickEyeView(viewGroup);
        }
    }

    public void a(ViewGroup viewGroup, Activity activity) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.showSplashCardView(viewGroup, activity);
        }
    }

    protected void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        if (jVar == null) {
            return;
        }
        this.f1630s.a(jVar.d());
        this.f1630s.a(jVar.p());
        if (jVar.E() || jVar.B()) {
            this.f1630s.a();
            U();
        }
    }

    protected void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3) {
        if (jVar != null) {
            a(jVar);
            jVar.h(j());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, this.f1619h, i2, i3);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (adError == null) {
            adError = new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL));
        }
        h0();
        if (this.b.get() || this.a.get()) {
            return;
        }
        this.b.set(true);
        d(adError);
        if (t()) {
            a(false);
            return;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + adError.code + " error Message = " + adError.message);
        ThreadHelper.runOnUiThread(new a(adError));
    }

    public void a(TTBaseAd tTBaseAd, String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, str);
        if (tTBaseAd == null || jVarC == null) {
            return;
        }
        tTBaseAd.setLoadSort(jVarC.p());
        tTBaseAd.setShowSort(jVarC.y());
        tTBaseAd.setExchangeRate(jVarC.j());
        tTBaseAd.setAdNetworkSlotType(jVarC.f());
        tTBaseAd.setCpm(jVarC.i());
    }

    protected void a(String str, String str2, String str3, String str4, int i2, String str5) {
        AdLoadInfo adLoadInfo = this.T.get(str);
        if (adLoadInfo == null) {
            adLoadInfo = new AdLoadInfo();
        }
        adLoadInfo.setMediationRit(str).setAdnName(str2).setCustomAdnName(str3).setErrCode(i2).setErrMsg(str5).setAdType(str4);
        this.T.put(str, adLoadInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        r3 = 'B';
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(java.lang.String r3, java.util.concurrent.atomic.AtomicBoolean r4) {
        /*
            r2 = this;
            boolean r4 = r2.t()
            if (r4 == 0) goto L7
            goto L6e
        L7:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r4 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d
            r4.<init>()
            r0 = -1
            r4.c(r0)
            r4.d(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            boolean r0 = r0.e(r3)
            if (r0 != 0) goto L29
            com.bytedance.msdk.api.AdError r3 = new com.bytedance.msdk.api.AdError
            r0 = 44406(0xad76, float:6.2226E-41)
            java.lang.String r1 = "广告位ID不合法"
            r3.<init>(r0, r1)
            goto L59
        L29:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.f1617f
            java.lang.String r1 = com.bytedance.msdk.adapter.util.TTLogUtil.getTagSecondLevel(r1)
            r0.append(r1)
            java.lang.String r1 = "settings config.......AdUnitId = "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "  暂无config配置信息"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "TTMediationSDK"
            com.bytedance.msdk.adapter.util.Logger.e(r0, r3)
            com.bytedance.msdk.api.AdError r3 = new com.bytedance.msdk.api.AdError
            r0 = 40040(0x9c68, float:5.6108E-41)
            java.lang.String r1 = com.bytedance.msdk.api.AdError.getMessage(r0)
            r3.<init>(r0, r1)
        L59:
            r2.a(r3, r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r3)
            r4 = 1
            r3.c(r4)
            r3 = 64
        L6a:
            switch(r3) {
                case 64: goto L71;
                case 65: goto L6e;
                case 66: goto L71;
                default: goto L6d;
            }
        L6d:
            goto L6a
        L6e:
            r3 = 66
            goto L6a
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(java.lang.String, java.util.concurrent.atomic.AtomicBoolean):void");
    }

    protected void a(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, adNetworkSlotId, e())) {
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    arrayList.add(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e(tTBaseAd, dVar, 0L, this.f1619h));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e) arrayList.get(0)).a;
                Logger.d("TTMediationSDK", "--==-- 广告复用:广告缓存成功 -------" + tTBaseAd2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.base.a.a(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(adNetworkSlotId, arrayList);
            }
        }
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        return dVar != null && (dVar.i() || dVar.j() || dVar.m());
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x020f, code lost:
    
        return true;
     */
    /* JADX WARN: Path cross not found for [B:29:0x01da, B:54:0x0247], limit reached: 80 */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a9 A[PHI: r5
  0x02a9: PHI (r5v5 boolean) = (r5v2 boolean), (r5v6 boolean), (r5v0 boolean) binds: [B:63:0x029d, B:65:0x02ab, B:26:0x01d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x02a9 -> B:65:0x02ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r21, int r22) {
        /*
            Method dump skipped, instruction units count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, int):boolean");
    }

    protected int b(int i2) {
        List<Integer> list = this.f1625n;
        if (list == null) {
            return -1;
        }
        return list.indexOf(Integer.valueOf(i2)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(AdError adError);

    protected void b(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
    }

    protected final void b(List<TTBaseAd> list, AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || !cVar.I()) {
            return;
        }
        if (this.M) {
            list = null;
            adError = new AdError(AdError.ERROR_CODE_DESTROY, AdError.getMessage(AdError.ERROR_CODE_DESTROY));
        }
        if (t()) {
            return;
        }
        if (!h0.a(list)) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (TTBaseAd tTBaseAd : list) {
                Logger.i("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_FILL) + "AdNetWorkName[" + tTBaseAd.getAdNetWorkName() + "] AdUnitId[" + tTBaseAd.getAdNetworkSlotId() + "]  请求成功 (loadSort=" + tTBaseAd.getLoadSort() + ",showSort=" + tTBaseAd.getShowSort() + ad.f20406s);
            }
        }
        if (adError != null) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + adError.code + "  errorMsg:" + adError.message);
        }
        ThreadHelper.runOnUiThread(new d(list, adError));
    }

    protected final void c(AdError adError) {
        ThreadHelper.runOnUiThread(new c(adError));
    }

    public void c(TTBaseAd tTBaseAd) {
        AdSlot adSlot = this.f1619h;
        int mediationRitReqType = tTBaseAd.getMediationRitReqType(adSlot != null ? adSlot.getLinkedId() : null);
        tTBaseAd.setMediationRitReqType(3);
        tTBaseAd.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    protected void c(List<TTBaseAd> list) {
        if (h0.b(list)) {
            return;
        }
        if (this.f1630s.g()) {
            b((List<TTBaseAd>) null, new AdError(AdError.SINGLE_AD_REQUEST_TIMEOUT, AdError.AD_LOAD_AD_TIME_OUT_ERROR_MSG));
        } else {
            b(list, (AdError) null);
        }
        TTBaseAd tTBaseAd = list.get(0);
        if (tTBaseAd.isPAd()) {
            this.f1628q.addAll(list);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1628q, (Comparator<TTBaseAd>) null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd2 : list) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载成功...........返回了P层广告_当前P层广告缓存池数量：" + this.f1628q.size() + ",slotId：" + tTBaseAd2.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd2.getAdNetWorkName() + ",loadSort=" + tTBaseAd2.getLoadSort() + ",showSort=" + tTBaseAd2.getShowSort() + ",CPM=" + tTBaseAd2.getCpm());
                }
                return;
            }
            return;
        }
        if (tTBaseAd.isServerBiddingAd()) {
            this.f1627p.addAll(list);
            for (TTBaseAd tTBaseAd3 : list) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载成功...........返回了ServerBidding层广告_当前ServerBidding层广告缓存池数量：" + this.f1627p.size() + ",slotId：" + tTBaseAd3.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd3.getAdNetWorkName() + ",loadSort=" + tTBaseAd3.getLoadSort() + ",showSort=" + tTBaseAd3.getShowSort() + ",CPM=" + tTBaseAd3.getCpm());
            }
            return;
        }
        if (!tTBaseAd.isMultiBiddingAd() && !tTBaseAd.isClientBiddingAd()) {
            this.f1626o.addAll(list);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(this.f1626o, (Comparator<TTBaseAd>) null);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd4 : list) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载成功...........返回了普通层广告_当前普通广告缓存池数量：" + this.f1626o.size() + ",slotId：" + tTBaseAd4.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd4.getAdNetWorkName() + ",loadSort=" + tTBaseAd4.getLoadSort() + ",showSort=" + tTBaseAd4.getShowSort() + ",CPM=" + tTBaseAd4.getCpm());
                }
                return;
            }
            return;
        }
        this.f1627p.addAll(list);
        String str = tTBaseAd.isMultiBiddingAd() ? "多阶底价" : "clientBidding";
        for (TTBaseAd tTBaseAd5 : list) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载成功...........返回了" + str + "层广告_当前" + str + "层广告缓存池数量：" + this.f1627p.size() + ",slotId：" + tTBaseAd5.getAdNetworkSlotId() + ",广告类型：" + tTBaseAd5.getAdNetWorkName() + ",loadSort=" + tTBaseAd5.getLoadSort() + ",showSort=" + tTBaseAd5.getShowSort() + ",CPM=" + tTBaseAd5.getCpm());
        }
        this.f1630s.a();
        U();
    }

    protected boolean c(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j next;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list = this.f1616e.get(Integer.valueOf(i2));
        if (list != null) {
            Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next != null && next.G() && TextUtils.equals(next.e(), "pangle")) {
                    break;
                }
            }
            next = null;
        } else {
            next = null;
        }
        return next != null && next.s() == 3;
    }

    public HashMap<String, TTBaseAd> d(List<TTBaseAd> list) {
        HashMap<String, TTBaseAd> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    map.put(tTBaseAd.getAdNetworkSlotId(), tTBaseAd);
                }
            }
        }
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x014a, code lost:
    
        r12 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x001e, code lost:
    
        r12 = 'A';
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0148 -> B:82:0x014a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean d(int r12) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.d(int):boolean");
    }

    protected void e(int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f1619h, cVar != null ? cVar.C() : null, !t(), j(), i2);
    }

    protected final void e(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f1619h, this.f1615d.C());
        ThreadHelper.runOnUiThread(new b(str));
    }

    protected void e(List<TTBaseAd> list) {
        if (this.f1642a0 == null) {
            this.f1642a0 = f(list);
        }
        if (this.f1632u.get() || this.W) {
            return;
        }
        this.V = SystemClock.elapsedRealtime();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.f1642a0, this.f1619h, this.f1615d, this.V - this.U, j(), !t(), list != null ? list.size() : 0);
        this.f1632u.set(true);
    }

    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        List<TTBaseAd> list;
        List<TTBaseAd> list2;
        AdSlot adSlot;
        StringBuilder sb;
        String str;
        if (this.f1618g == null || dVar == null) {
            return;
        }
        b((List<TTBaseAd>) null, adError);
        if (dVar != null && adError != null) {
            a(dVar.d(), dVar.c(), dVar.e(), com.bytedance.msdk.base.a.a(dVar.b(), dVar.h()), adError.thirdSdkErrorCode, adError.thirdSdkErrorMessage);
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载失败...........adnName:" + dVar.c() + " ,slotId:" + dVar.d() + ",slotType:" + dVar.a() + ",loadSort:" + dVar.f() + ",showSort:" + dVar.g() + " ，adError:" + adError.toString());
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(adError, dVar);
        if (dVar != null && dVar.a() == 0 && a(dVar.d())) {
            return;
        }
        this.f1630s.a(dVar.d());
        this.f1630s.a(dVar.f());
        if (dVar.j() || dVar.i()) {
            this.f1630s.a();
            U();
        }
        if (dVar.m() && s()) {
            if (this.f1628q.size() < i()) {
                Iterator<TTBaseAd> it = this.f1626o.iterator();
                while (it.hasNext()) {
                    if (a(it.next()) && m()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                        str = "SeverBidding广告有返回结果且满足ClientBidding等待时间时普通池中有广告直接返回......";
                    }
                }
                if (this.a.get()) {
                    return;
                } else {
                    return;
                }
            }
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
            str = "SeverBidding广告有返回结果时P层池中有广告直接返回......";
            sb.append(str);
            Logger.d("TTMediationSDK", sb.toString());
            break;
        }
        if (this.a.get() || this.b.get()) {
            return;
        }
        List<TTBaseAd> list3 = this.f1628q;
        if ((list3 == null || list3.size() <= 0) && (((list = this.f1626o) == null || list.size() <= 0) && ((list2 = this.f1627p) == null || list2.size() <= 0))) {
            if (this.f1630s.g() || !this.f1630s.f() || (adSlot = this.f1619h) == null || TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102.a.a(adSlot.getTestSlotId()))) {
            }
            a(adError, dVar);
            return;
        }
        if (!this.f1630s.g() && this.f1630s.f() && m()) {
            Logger.i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "当前广告池中有广告且满足client bididing的返回条件...给出成功回调...");
        }
        if (!a(dVar) && this.f1630s.b(dVar.f()) == 0) {
            int iB = b(dVar.f());
            Logger.w("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "onAdFailed--》 加载下一层-nextIdx=" + iB);
            if (iB < this.f1625n.size() && !this.f1630s.c(this.f1625n.get(iB).intValue())) {
                if (dVar.l()) {
                    Handler handler = this.f1618g;
                    if (handler != null) {
                        handler.removeMessages(4);
                    }
                } else {
                    Handler handler2 = this.f1618g;
                    if (handler2 != null) {
                        handler2.removeMessages(1);
                    }
                }
            }
            a(iB, true);
        }
        if ((this.f1630s.g() || this.f1630s.f()) && m()) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有广告都加载失败....");
            adError = new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL));
            a(adError, dVar);
            return;
        }
        return;
        q();
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdLoaded(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tTBaseAd);
        onAdLoaded(arrayList, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0234 A[LOOP:2: B:73:0x0234->B:100:?, LOOP_START] */
    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAdLoaded(java.util.List<com.bytedance.msdk.base.TTBaseAd> r9, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d r10) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e.onAdLoaded(java.util.List, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d):void");
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdVideoCache() {
        if (this.f1618g == null || this.b.get() || this.f1614c.get() || !this.a.get()) {
            return;
        }
        this.f1614c.set(true);
        Q();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    protected void q() {
        ArrayList arrayList;
        ArrayList arrayList2;
        h0();
        if (this.a.get() || this.b.get()) {
            return;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "广告加载成功！给外部回调：invokeAdLoadCallbackOnMainUI........P.size:" + this.f1628q.size() + "   bidding.size:" + this.f1627p.size() + "   normal.size:" + this.f1626o.size());
        this.a.set(true);
        y();
        if ((d0() || (c0() && !this.Y)) && (p() || n())) {
            List<TTBaseAd> listU = u();
            TTBaseAd tTBaseAd = listU.size() > 0 ? listU.get(0) : null;
            int i2 = i();
            if (i2 > 1) {
                arrayList = new ArrayList();
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i3 < listU.size()) {
                        arrayList.add(listU.get(i3));
                    }
                }
                if (listU.size() > i2) {
                    arrayList2 = new ArrayList();
                    while (i2 < listU.size()) {
                        TTBaseAd tTBaseAd2 = listU.get(i2);
                        if (tTBaseAd2 != null && tTBaseAd2.isServerBiddingAd()) {
                            arrayList2.add(tTBaseAd2);
                        }
                        i2++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f1619h, arrayList, arrayList2);
        }
        if (t()) {
            a(true);
            return;
        }
        int i4 = (this.f1628q.size() + this.f1626o.size()) + this.f1627p.size() >= i() ? i() : this.f1628q.size() + this.f1626o.size() + this.f1627p.size();
        AdSlot adSlot = this.f1619h;
        TTBaseAd tTBaseAd3 = this.N;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.U;
        int iA0 = a0();
        int iB = b(this.P);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot, tTBaseAd3, jElapsedRealtime - j2, iA0, iB, 0, cVar != null ? cVar.C() : null, i4);
        ThreadHelper.runOnUiThread(new r());
        g0();
    }
}
