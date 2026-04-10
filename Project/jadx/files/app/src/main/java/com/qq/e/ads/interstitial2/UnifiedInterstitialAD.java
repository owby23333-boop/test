package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicInteger f17738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f17739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile VideoOption f17740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f17741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f17742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile LoadAdParams f17743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private UnifiedInterstitialADListener f17744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ServerSideVerificationOptions f17745n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ADListenerAdapter f17746o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f17738g = new AtomicInteger(0);
        this.f17739h = new AtomicInteger(0);
        this.f17744m = unifiedInterstitialADListener;
        this.f17746o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f17738g = new AtomicInteger(0);
        this.f17739h = new AtomicInteger(0);
        this.f17744m = unifiedInterstitialADListener;
        this.f17746o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f17746o);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f17744m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    protected void c() {
        setVideoOption(this.f17740i);
        setMinVideoDuration(this.f17741j);
        setMaxVideoDuration(this.f17742k);
        setLoadAdParams(this.f17743l);
        setServerSideVerificationOptions(this.f17745n);
        while (this.f17738g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f17739h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).close();
        }
    }

    public void destroy() {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((UIADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((UIADI) t2).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((UIADI) t2).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f17738g.incrementAndGet();
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((UIADI) t2).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f17739h.incrementAndGet();
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((UIADI) t2).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f17743l = loadAdParams;
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).setLoadAdParams(this.f17743l);
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.f17742k = i2;
        if (this.f17742k > 0 && this.f17741j > this.f17742k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f17746o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i2) {
        this.f17741j = i2;
        if (this.f17742k > 0 && this.f17741j > this.f17742k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).setMinVideoDuration(i2);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f17746o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f17746o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f17745n = serverSideVerificationOptions;
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f17740i = videoOption;
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).show();
        } else {
            a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void show(Activity activity) {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).show(activity);
        } else {
            a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void showAsPopupWindow() {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).showAsPopupWindow();
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showAsPopupWindow(Activity activity) {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).showAsPopupWindow(activity);
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t2 = this.a;
        if (t2 != 0) {
            ((UIADI) t2).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
