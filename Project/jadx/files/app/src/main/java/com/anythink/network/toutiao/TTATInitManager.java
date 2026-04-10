package com.anythink.network.toutiao;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTATInitManager extends ATInitMediation {
    public static final String TAG = "TTATInitManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile TTATInitManager f12644e;
    TTCustomController a;
    Map<String, Map<String, TTATBiddingInfo>> b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12650i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<MediationInitCallback> f12652k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, WeakReference> f12649h = new ConcurrentHashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f12653l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f12654m = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12645c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12646d = "price";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f12647f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12648g = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f12651j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATInitManager$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f12655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f12656d;

        AnonymousClass1(String str, String str2, int[] iArr, Context context) {
            this.a = str;
            this.b = str2;
            this.f12655c = iArr;
            this.f12656d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                TTAdConfig.Builder builderSupportMultiProcess = new TTAdConfig.Builder().appId(this.a).useTextureView(true).appName(this.b).titleBarTheme(1).directDownloadNetworkType(this.f12655c).data(TTATInitManager.this.b()).supportMultiProcess(false);
                if (TTATInitManager.this.a != null) {
                    builderSupportMultiProcess.customController(TTATInitManager.this.a);
                }
                TTAdSdk.init(this.f12656d, builderSupportMultiProcess.build(), new TTAdSdk.InitCallback() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void fail(int i2, String str) {
                        TTATInitManager.a(TTATInitManager.this, false, String.valueOf(i2), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public final void success() {
                        TTATInitManager.this.f12647f.postDelayed(new Runnable() { // from class: com.anythink.network.toutiao.TTATInitManager.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                TTATInitManager.b(TTATInitManager.this);
                                TTATInitManager.a(TTATInitManager.this, true, (String) null, (String) null);
                            }
                        }, 100L);
                    }
                });
            } catch (Throwable th) {
                TTATInitManager.a(TTATInitManager.this, false, "", th.getMessage());
            }
        }
    }

    private TTATInitManager() {
    }

    static /* synthetic */ boolean b(TTATInitManager tTATInitManager) {
        tTATInitManager.f12650i = true;
        return true;
    }

    public static TTATInitManager getInstance() {
        if (f12644e == null) {
            synchronized (TTATInitManager.class) {
                if (f12644e == null) {
                    f12644e = new TTATInitManager();
                }
            }
        }
        return f12644e;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "CSJ";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.bytedance.sdk.openadsdk.TTAdSdk";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return TTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getPermissionStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getProviderStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider");
        arrayList.add("com.bytedance.sdk.openadsdk.TTFileProvider");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setIsOpenDirectDownload(boolean z2) {
        this.f12648g = z2;
    }

    public void setTtCustomController(TTCustomController tTCustomController) {
        this.a = tTCustomController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            this.f12645c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        try {
            String str = this.f12645c == 2 ? "0" : "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put("value", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            String string = jSONArray.toString();
            if (ATSDK.isNetworkLogDebug()) {
                "TTPrivateData:".concat(String.valueOf(string));
            }
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    protected final void a(String str, WeakReference weakReference) {
        try {
            this.f12649h.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f12649h.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.f12649h.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
        if (TTAdSdk.isInitSuccess() || this.f12650i) {
            TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(b()).build());
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.f12653l) {
            if (this.f12651j.get()) {
                if (mediationInitCallback != null) {
                    this.f12652k.add(mediationInitCallback);
                }
                return;
            }
            if (this.f12652k == null) {
                this.f12652k = new ArrayList();
            }
            this.f12651j.set(true);
            String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.f12652k.add(mediationInitCallback);
            }
            int[] iArr = this.f12648g ? new int[]{1, 2, 3, 4, 5} : new int[]{2};
            this.f12647f.post(new AnonymousClass1(stringFromMap, context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString(), iArr, context.getApplicationContext()));
        }
    }

    private void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f12649h.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.f12649h.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z2, String str, String str2) {
        synchronized (this.f12653l) {
            int size = this.f12652k.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediationInitCallback mediationInitCallback = this.f12652k.get(i2);
                if (mediationInitCallback != null) {
                    if (z2) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.f12652k.clear();
            this.f12651j.set(false);
        }
    }

    protected final synchronized void a(Map<String, Object> map, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        a(map, (BaseAd) null, tTClientBidding, aTBiddingListener);
    }

    protected final synchronized void a(Map<String, Object> map, BaseAd baseAd, TTClientBidding tTClientBidding, ATBiddingListener aTBiddingListener) {
        if (aTBiddingListener != null) {
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            if (map.containsKey(this.f12646d)) {
                try {
                    d2 = Double.parseDouble(String.valueOf(map.get(this.f12646d)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            TTATBiddingNotify tTATBiddingNotify = new TTATBiddingNotify(tTClientBidding);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), tTATBiddingNotify, ATAdConst.CURRENCY.RMB_CENT), baseAd);
        }
    }

    static /* synthetic */ void a(TTATInitManager tTATInitManager, boolean z2, String str, String str2) {
        synchronized (tTATInitManager.f12653l) {
            int size = tTATInitManager.f12652k.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediationInitCallback mediationInitCallback = tTATInitManager.f12652k.get(i2);
                if (mediationInitCallback != null) {
                    if (z2) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            tTATInitManager.f12652k.clear();
            tTATInitManager.f12651j.set(false);
        }
    }
}
