package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UnifiedBannerADListener f17700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownAPPConfirmPolicy f17701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicInteger f17702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LoadAdParams f17704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private UnifiedBannerView f17705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ADListenerAdapter f17706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f17707n;

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f17702i = new AtomicInteger(0);
        this.f17703j = 30;
        this.f17704k = null;
        this.f17700g = unifiedBannerADListener;
        this.f17705l = unifiedBannerView;
        this.f17706m = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f17705l, (Activity) context, str, str2, str3, this.f17706m);
    }

    void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t2;
        this.f17701h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t2 = this.a) == 0) {
            return;
        }
        ((UBVI) t2).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener = this.f17700g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    void c(int i2) {
        this.f17703j = i2;
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i2);
        }
    }

    void destroy() {
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((UBVI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    void loadAD() {
        if (a()) {
            if (!b()) {
                this.f17702i.incrementAndGet();
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((UBVI) t2).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    void onWindowFocusChanged(boolean z2) {
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).onWindowFocusChanged(z2);
        }
    }

    void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f17704k = loadAdParams;
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f17706m.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f17706m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f17707n = serverSideVerificationOptions;
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f17701h;
        if (downAPPConfirmPolicy != null) {
            this.f17701h = downAPPConfirmPolicy;
            T t2 = this.a;
            if (t2 != 0) {
                ((UBVI) t2).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i2 = this.f17703j;
        this.f17703j = i2;
        T t3 = this.a;
        if (t3 != 0) {
            ((UBVI) t3).setRefresh(i2);
        }
        LoadAdParams loadAdParams = this.f17704k;
        this.f17704k = loadAdParams;
        T t4 = this.a;
        if (t4 != 0) {
            ((UBVI) t4).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.f17707n);
        while (this.f17702i.getAndDecrement() > 0) {
            loadAD();
        }
    }
}
