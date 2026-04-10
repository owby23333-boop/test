package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.content.Context;
import android.location.Location;
import com.bytedance.msdk.adapter.ks.KsAdapterConfiguration;
import com.bytedance.msdk.adapter.ks.base.config.IMediationLocation;
import com.bytedance.msdk.adapter.ks.base.config.MediationInitConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationInitConfig f2450a;
    private boolean b;
    private final KsCustomController c = new KsCustomController() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.i.2
        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            return i.this.f2450a.appList();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            return i.this.f2450a.isCanUseLocation();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            return i.this.f2450a.isCanUseMacAddress();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            return i.this.f2450a.isCanUseWifiState();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            return i.this.f2450a.isCanUseOaid();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            return i.this.f2450a.isCanUsePhoneState();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            return i.this.f2450a.isCanUseWriteExternal();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            return i.this.f2450a.getAndroidId();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            return i.this.f2450a.getDevImei();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            List<String> devImeis = i.this.f2450a.getDevImeis();
            if (devImeis == null || devImeis.isEmpty()) {
                return null;
            }
            int size = devImeis.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = devImeis.get(i);
            }
            return strArr;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public List<String> getInstalledPackages() {
            List<String> appList = i.this.f2450a.getAppList();
            if (appList == null || appList.isEmpty()) {
                return null;
            }
            return appList;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            IMediationLocation location = i.this.f2450a.getLocation();
            if (location == null) {
                return null;
            }
            Location location2 = new Location("");
            location2.setLatitude(location.getLatitude());
            location2.setLongitude(location.getLongitude());
            return location2;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            return i.this.f2450a.getMacAddress();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            return i.this.f2450a.getDevOaid();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            KsAdSDK.setPersonalRecommend(!this.f2450a.isLimitPersonalAds());
            KsAdSDK.setProgrammaticRecommend(this.f2450a.isProgrammaticRecommend());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String d() {
        try {
            String str = (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.i.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return i.this.e();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "0.0";
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    public void a() {
        if (this.b) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.i.3
                @Override // java.lang.Runnable
                public void run() {
                    i.this.c();
                }
            });
        } else {
            c();
        }
    }

    public void a(final Context context, final KsAdapterConfiguration ksAdapterConfiguration, final MediationInitConfig mediationInitConfig) {
        this.f2450a = mediationInitConfig;
        this.b = o.a(mediationInitConfig);
        final String appId = mediationInitConfig.getAppId();
        final String appName = mediationInitConfig.getAppName();
        try {
            if (context == null || appId == null) {
                ksAdapterConfiguration.notifyFail("context or appId is empty");
                return;
            }
            Thread thread = new Thread(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.i.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        KsAdSDK.init(context, new SdkConfig.Builder().appId(appId).appName(appName).customController(i.this.c).build());
                        if (o.a("3.3.61")) {
                            KsAdSDK.start();
                        }
                        ksAdapterConfiguration.notifyInitTime(1, jCurrentTimeMillis, System.currentTimeMillis());
                        KsAdSDK.setPersonalRecommend(!mediationInitConfig.isLimitPersonalAds());
                        KsAdSDK.setProgrammaticRecommend(mediationInitConfig.isProgrammaticRecommend());
                        ksAdapterConfiguration.setInitSuccess(true);
                        ksAdapterConfiguration.notifySuccess();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        ksAdapterConfiguration.notifyFail("ks init fail in other thread");
                    }
                }
            });
            thread.setName("ks-init-thread");
            thread.start();
        } catch (Throwable th) {
            th.printStackTrace();
            ksAdapterConfiguration.notifyFail("ks init fail");
        }
    }

    public String b() {
        return this.b ? d() : e();
    }
}
