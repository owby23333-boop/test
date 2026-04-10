package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ViewGroup f17780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile SplashADListener f17781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile ADRewardListener f17782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile LoadAdParams f17783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f17784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f17785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f17786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile int f17787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile byte[] f17788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f17789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f17790q;

    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f17781h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.f17781h.onADLoaded(l2.longValue());
                    }
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f17781h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    }
                    break;
                case 102:
                    SplashAD.this.f17781h.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f17781h.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f17782i != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        HashMap map = new HashMap();
                        map.put("transId", str);
                        SplashAD.this.f17782i.onReward(map);
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f17781h.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f17781h.onADDismissed();
                    break;
                default:
                    switch (type) {
                        case 112:
                            Long l3 = (Long) aDEvent.getParam(Long.class);
                            if (l3 != null) {
                                SplashAD.this.f17781h.onADTick(l3.longValue());
                            }
                            break;
                        case 113:
                            if (SplashAD.this.f17781h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f17781h).onZoomOut();
                            }
                            break;
                        case 114:
                            if (SplashAD.this.f17781h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f17781h).onZoomOutPlayFinish();
                            }
                            break;
                    }
                    break;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this.f17784k = false;
        this.f17781h = splashADListener;
        this.f17790q = i2;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, String str2) {
        this.f17784k = false;
        this.f17781h = splashADListener;
        this.f17790q = i2;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z2) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t2 = this.a;
        if (t2 == 0) {
            this.f17786m = z2;
            this.f17780g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t2;
        if (z2) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z2) {
        if (a()) {
            if (!b()) {
                this.f17786m = z2;
                this.f17785l = true;
                return;
            }
            T t2 = this.a;
            if (t2 == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t2;
            if (z2) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z2) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t2 = this.a;
        if (t2 == 0) {
            this.f17780g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t2;
        if (z2) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        if (this.f17781h != null) {
            this.f17781h.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((NSPVI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t2 = this.a;
        if (t2 != 0) {
            return ((NSPVI) t2).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f17784k = true;
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((NSPVI) t2).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i2, int i3) {
    }

    public void setDeveloperLogo(int i2) {
        T t2 = this.a;
        if (t2 == 0) {
            this.f17787n = i2;
        } else {
            ((NSPVI) t2).setDeveloperLogo(i2);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t2 = this.a;
        if (t2 == 0) {
            this.f17788o = bArr;
        } else {
            ((NSPVI) t2).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t2 = this.a;
        if (t2 != 0) {
            ((NSPVI) t2).setLoadAdParams(loadAdParams);
        } else {
            this.f17783j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f17782i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f17789p = serverSideVerificationOptions;
        T t2 = this.a;
        if (t2 != 0) {
            ((NSPVI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t2 = this.a;
        if (t2 != 0) {
            ((NSPVI) t2).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f17783j != null) {
            nspvi.setLoadAdParams(this.f17783j);
        }
        if (this.f17787n != 0) {
            nspvi.setDeveloperLogo(this.f17787n);
        }
        if (this.f17788o != null) {
            nspvi.setDeveloperLogo(this.f17788o);
        }
        nspvi.setFetchDelay(this.f17790q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f17789p);
        if ((this.f17781h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f17781h).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f17780g != null) {
            if (this.f17786m) {
                fetchFullScreenAndShowIn(this.f17780g);
            } else {
                fetchAndShowIn(this.f17780g);
            }
        }
        if (this.f17784k) {
            nspvi.preload();
            this.f17784k = false;
        }
        if (this.f17785l) {
            if (this.f17786m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f17785l = false;
        }
    }
}
