package com.anythink.network.baidu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATInitManager extends ATInitMediation {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final String f12341d = "AT_BAIDU_C2S_";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile BaiduATInitManager f12342e;
    Map<String, Map<String, BaiduATBiddingInfo>> a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12344f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<MediationInitCallback> f12346h;
    boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12343c = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f12347i = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f12345g = new AtomicBoolean(false);

    public interface InitCallback {
        void onError(Throwable th);

        void onSuccess();
    }

    private BaiduATInitManager() {
    }

    private synchronized void b(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        if (this.a != null && (map = this.a.get(str)) != null) {
            map.remove(str2);
        }
    }

    public static BaiduATInitManager getInstance() {
        if (f12342e == null) {
            synchronized (BaiduATInitManager.class) {
                if (f12342e == null) {
                    f12342e = new BaiduATInitManager();
                }
            }
        }
        return f12342e;
    }

    public static void printLog(String str) {
        ATSDK.isNetworkLogDebug();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getActivityStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.mobads.sdk.api.AppActivity");
        arrayList.add("com.baidu.mobads.sdk.api.MobRewardVideoActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Baidu";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.baidu.mobads.sdk.api.BDAdConfig";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return BaiduATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getProviderStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.mobads.sdk.api.BdFileProvider");
        return arrayList;
    }

    public synchronized void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setBaiduATCustomController(BaiduATCustomController baiduATCustomController) {
        if (baiduATCustomController != null) {
            MobadsPermissionSettings.setPermissionReadDeviceID(baiduATCustomController.getPermissionReadDeviceID());
            MobadsPermissionSettings.setPermissionLocation(baiduATCustomController.getPermissionLocation());
            MobadsPermissionSettings.setPermissionStorage(baiduATCustomController.getPermissionStorage());
            MobadsPermissionSettings.setPermissionAppList(baiduATCustomController.getPermissionAppList());
            MobadsPermissionSettings.setPermissionOAID(baiduATCustomController.getPermissionOAID());
            MobadsPermissionSettings.setPermissionDeviceInfo(baiduATCustomController.getPermissionDeviceInfo());
            MobadsPermissionSettings.setPermissionAppUpdate(baiduATCustomController.getPermissionAppUpdate());
            MobadsPermissionSettings.setPermissionRunningApp(baiduATCustomController.getPermissionRunningApp());
            this.b = true;
        }
    }

    static /* synthetic */ boolean a(BaiduATInitManager baiduATInitManager) {
        baiduATInitManager.f12344f = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, Throwable th) {
        synchronized (this.f12347i) {
            int size = this.f12346h.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediationInitCallback mediationInitCallback = this.f12346h.get(i2);
                if (mediationInitCallback != null) {
                    if (z2) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(th.getMessage());
                    }
                }
            }
            this.f12346h.clear();
            this.f12345g.set(false);
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        initSDK(context, map, false, mediationInitCallback);
    }

    public synchronized void initSDK(Context context, Map<String, Object> map, boolean z2, MediationInitCallback mediationInitCallback) {
        try {
            this.f12343c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        MobadsPermissionSettings.setLimitPersonalAds(this.f12343c == 2);
        if (!this.b) {
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
            MobadsPermissionSettings.setPermissionOAID(true);
            MobadsPermissionSettings.setPermissionAppList(true);
            MobadsPermissionSettings.setPermissionStorage(true);
            MobadsPermissionSettings.setPermissionLocation(true);
        }
        if (ATSDK.isNetworkLogDebug()) {
            String str = "MobadsPermissionSettings.getLimitPersonalAdsStatus():" + MobadsPermissionSettings.getLimitPersonalAdsStatus();
        }
        if (z2) {
            this.f12344f = false;
        }
        if (this.f12344f) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
            }
            return;
        }
        synchronized (this.f12347i) {
            if (this.f12345g.get()) {
                if (mediationInitCallback != null) {
                    this.f12346h.add(mediationInitCallback);
                }
                return;
            }
            if (this.f12346h == null) {
                this.f12346h = new ArrayList();
            }
            this.f12345g.set(true);
            String str2 = (String) map.get("app_id");
            if (mediationInitCallback != null) {
                this.f12346h.add(mediationInitCallback);
            }
            try {
                new BDAdConfig.Builder().setAppsid(str2).setHttps(false).build(context.getApplicationContext()).init();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.network.baidu.BaiduATInitManager.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaiduATInitManager.a(BaiduATInitManager.this);
                        BaiduATInitManager.this.a(true, (Throwable) null);
                    }
                }, 1500L);
            } catch (Throwable th) {
                th.printStackTrace();
                a(false, th);
            }
        }
    }

    private synchronized String a(String str, Object obj, double d2, Object obj2) {
        String str2;
        if (this.a == null) {
            this.a = new ConcurrentHashMap(3);
        }
        Map<String, BaiduATBiddingInfo> concurrentHashMap = this.a.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>(2);
            this.a.put(str, concurrentHashMap);
        }
        str2 = f12341d + UUID.randomUUID().toString();
        concurrentHashMap.put(str2, new BaiduATBiddingInfo(obj, d2, obj2));
        return str2;
    }

    private synchronized BaiduATBiddingInfo a(String str, String str2) {
        Map<String, BaiduATBiddingInfo> map;
        if (this.a == null || (map = this.a.get(str)) == null) {
            return null;
        }
        return map.remove(str2);
    }
}
