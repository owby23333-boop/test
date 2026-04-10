package com.anythink.network.ks;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class KSATInitManager extends ATInitMediation {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12489d = "KSATInitManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile KSATInitManager f12490e;
    Boolean a;
    Boolean b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private KSATCustomController f12495i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f12493g = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, WeakReference> f12496j = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12491c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f12492f = new Handler(Looper.getMainLooper());

    private KSATInitManager() {
    }

    static /* synthetic */ boolean e(KSATInitManager kSATInitManager) {
        kSATInitManager.f12494h = true;
        return true;
    }

    public static KSATInitManager getInstance() {
        if (f12490e == null) {
            synchronized (KSATInitManager.class) {
                if (f12490e == null) {
                    f12490e = new KSATInitManager();
                }
            }
        }
        return f12490e;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Kuaishou";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.kwad.sdk.api.KsAdSDK";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return KSATConst.getNetworkVersion();
    }

    public String getPayloadInfo(String str, double d2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getJSONArray("adBids").getJSONObject(0).put("bidEcpm", d2);
            str = jSONObject.toString();
            jSONObject.toString();
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public Map<String, Boolean> getPluginClassStatus() {
        HashMap map = new HashMap();
        map.put("recyclerview-*.aar", Boolean.FALSE);
        try {
            map.put("recyclerview-*.aar", Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public List getResourceStatus() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ksad_reward_order_end_dialog");
        return arrayList;
    }

    public void initSDK(Context context, Map<String, Object> map) {
        initSDK(context, map, null);
    }

    public void setKSATCustomController(KSATCustomController kSATCustomController) {
        if (kSATCustomController != null) {
            this.f12495i = kSATCustomController;
        }
    }

    public void setPersonalRecommend(boolean z2) {
        this.a = Boolean.valueOf(z2);
    }

    public void setProgrammaticRecommend(boolean z2) {
        this.b = Boolean.valueOf(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean zBooleanValue = this.f12491c != 2;
        boolean zBooleanValue2 = this.f12491c != 2;
        Boolean bool = this.a;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        }
        Boolean bool2 = this.b;
        if (bool2 != null) {
            zBooleanValue2 = bool2.booleanValue();
        }
        KsAdSDK.setPersonalRecommend(zBooleanValue);
        KsAdSDK.setProgrammaticRecommend(zBooleanValue2);
        if (ATSDK.isNetworkLogDebug()) {
            "PersonalRecommend: ".concat(String.valueOf(zBooleanValue));
            "ProgrammaticRecommend: ".concat(String.valueOf(zBooleanValue2));
        }
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, final MediationInitCallback mediationInitCallback) {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f12496j.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.f12496j.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            this.f12491c = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused2) {
        }
        if (this.f12494h) {
            b();
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        final String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        if (TextUtils.isEmpty(stringFromMap)) {
            return;
        }
        this.f12492f.post(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (KSATInitManager.this.f12493g) {
                    if (KSATInitManager.this.f12494h) {
                        if (mediationInitCallback != null) {
                            mediationInitCallback.onSuccess();
                        }
                        return;
                    }
                    SdkConfig.Builder builder = new SdkConfig.Builder();
                    builder.appId(stringFromMap);
                    if (KSATInitManager.this.f12495i != null) {
                        builder.canReadICCID(KSATInitManager.this.f12495i.getCanReadICCID());
                        builder.canReadMacAddress(KSATInitManager.this.f12495i.getCanReadMacAddress());
                        builder.canReadNearbyWifiList(KSATInitManager.this.f12495i.getCanReadNearbyWifiList());
                        if (KSATInitManager.this.f12495i.getKsCustomeController() != null) {
                            builder.customController(KSATInitManager.this.f12495i.getKsCustomeController());
                        }
                    }
                    boolean zInit = KsAdSDK.init(applicationContext, builder.build());
                    KSATInitManager.this.b();
                    if (zInit) {
                        KSATInitManager.e(KSATInitManager.this);
                        if (mediationInitCallback != null) {
                            mediationInitCallback.onSuccess();
                        }
                    } else if (mediationInitCallback != null) {
                        mediationInitCallback.onFail("Kuaishou init failed");
                    }
                }
            }
        });
    }

    protected final void a(String str, WeakReference weakReference) {
        try {
            this.f12496j.put(str, weakReference);
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            for (Map.Entry<String, WeakReference> entry : this.f12496j.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.f12496j.remove(entry.getKey());
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void a(Context context, final Map<String, Object> map, final Map<String, Object> map2, final ATBidRequestInfoListener aTBidRequestInfoListener) {
        initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInitManager.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str) {
                ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(ATBidRequestInfo.INIT_ERROR_TYPE);
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                KSATInitManager.this.runOnThreadPool(new Runnable() { // from class: com.anythink.network.ks.KSATInitManager.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        KSBidRequestInfo kSBidRequestInfo = new KSBidRequestInfo(map, map2);
                        if (kSBidRequestInfo.isValid()) {
                            ATBidRequestInfoListener aTBidRequestInfoListener2 = aTBidRequestInfoListener;
                            if (aTBidRequestInfoListener2 != null) {
                                aTBidRequestInfoListener2.onSuccess(kSBidRequestInfo);
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
}
