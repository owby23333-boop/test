package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATInitManager extends ATInitMediation {
    public static final String TAG = "GDTATInitManager";
    private static volatile GDTATInitManager b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12433g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, WeakReference> f12429c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, RewardVideoAD> f12430d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, UnifiedInterstitialAD> f12431e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f12434h = new Object();
    int a = 0;

    private GDTATInitManager() {
    }

    private void c() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f12429c.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.f12429c.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static GDTATInitManager getInstance() {
        if (b == null) {
            synchronized (GDTATInitManager.class) {
                if (b == null) {
                    b = new GDTATInitManager();
                }
            }
        }
        return b;
    }

    protected final void b() {
        this.f12431e.clear();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getActivityStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.ads.ADActivity");
        arrayList.add("com.qq.e.ads.PortraitADActivity");
        arrayList.add("com.qq.e.ads.LandscapeADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoPortraitADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoLandscapeADActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Tencent";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.qq.e.ads.ADActivity";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return GDTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getServiceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.qq.e.comm.DownloadService");
        return arrayList;
    }

    public synchronized void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setGDTATCustomController(GDTATCustomController gDTATCustomController) {
        if (gDTATCustomController != null) {
            GlobalSetting.setAgreePrivacyStrategy(gDTATCustomController.getAgreePrivacyStrategy());
        }
    }

    protected final void a(String str, WeakReference weakReference) {
        try {
            this.f12429c.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            this.a = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        if (this.a == 2) {
            GlobalSetting.setPersonalizedState(1);
        } else {
            GlobalSetting.setPersonalizedState(0);
        }
        if (ATSDK.isNetworkLogDebug()) {
            String str = "GlobalSetting.getPersonalizedState():" + GlobalSetting.getPersonalizedState();
        }
        c();
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        if (map.containsKey(ATInitMediation.KEY_LOCAL)) {
            this.f12433g = stringFromMap;
        } else if (this.f12433g != null && !TextUtils.equals(this.f12433g, stringFromMap)) {
            checkToSaveInitData(getNetworkName(), map, this.f12433g);
            this.f12433g = null;
        }
        if (!this.f12432f) {
            GDTAdSdk.init(context.getApplicationContext(), stringFromMap);
            this.f12432f = true;
        }
        if (mediationInitCallback != null) {
            mediationInitCallback.onSuccess();
        }
    }

    protected final void a(String str, RewardVideoAD rewardVideoAD) {
        this.f12430d.clear();
        this.f12430d.put(str, rewardVideoAD);
    }

    protected final void a() {
        this.f12430d.clear();
    }

    protected final void a(String str, UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f12431e.clear();
        this.f12431e.put(str, unifiedInterstitialAD);
    }

    protected static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener) {
        getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInitManager.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                GDTATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.gdt.GDTATInitManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GDTBidRequestInfo gDTBidRequestInfo;
                        synchronized (GDTATInitManager.this.f12434h) {
                            gDTBidRequestInfo = new GDTBidRequestInfo(map);
                        }
                        if (gDTBidRequestInfo.isValid()) {
                            ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                            if (aTBidRequestInfoListener2 != null) {
                                aTBidRequestInfoListener2.onSuccess(gDTBidRequestInfo);
                                return;
                            }
                            return;
                        }
                        ATBidRequestInfoListener aTBidRequestInfoListener3 = aTBidRequestInfoListener;
                        if (aTBidRequestInfoListener3 != null) {
                            aTBidRequestInfoListener3.onFailed(ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                        }
                    }
                });
            }
        });
    }

    protected static LoadAdParams a(Map<String, Object> map) {
        LoadAdParams loadAdParams = new LoadAdParams();
        HashMap map2 = new HashMap();
        a(map2, map);
        loadAdParams.setDevExtra(map2);
        return loadAdParams;
    }

    protected static void a(Map map, Map<String, Object> map2) {
        try {
            Object obj = map2.get(g.k.f6904n);
            map.put("staIn", obj != null ? obj.toString() : "");
            map.put("meSrc", "299");
            Object obj2 = map2.get(g.k.f6903m);
            map.put("thrmei", obj2 != null ? obj2.toString() : "");
        } catch (Exception unused) {
        }
    }
}
