package com.kwad.components.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.h;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> XQ;
    private List<String> XR;
    private volatile SharedPreferences XS;
    private final Object mLock;

    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    public static class PreLoadPara extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int isValidReturned;
        public long spreadTime;
    }

    static class a {
        private static final SplashPreloadManager XT = new SplashPreloadManager(0);
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.XQ = new HashMap<>();
        this.XR = new ArrayList();
        init();
    }

    /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    @AnyThread
    private static boolean aL(String str) {
        if (str != null) {
            File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(fileAN == null ? "null" : Boolean.valueOf(fileAN.exists()));
            b.d("PreloadManager", sb.toString());
            if (fileAN != null && fileAN.exists()) {
                return true;
            }
        }
        return false;
    }

    public static File aM(String str) {
        if (str == null) {
            return null;
        }
        b.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(str);
        if (fileAN == null || !fileAN.exists()) {
            return null;
        }
        return fileAN;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.a.a.aW(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.XS = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.XS.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(preLoadItem.preloadId);
                            if (fileAN == null || !fileAN.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                b.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    this.XQ.put(str, preLoadItem);
                                    if (!this.XR.contains(str)) {
                                        this.XR.add(str);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e2) {
                b.printStackTrace(e2);
            }
        }
        SharedPreferences.Editor editorEdit = this.XS.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    private void sl() {
        int size;
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str2 : this.XQ.keySet()) {
                PreLoadItem preLoadItem = this.XQ.get(str2);
                if (preLoadItem != null && preLoadItem.expiredTime < jCurrentTimeMillis) {
                    arrayList.add(str2);
                }
            }
            SharedPreferences.Editor editorEdit = this.XS.edit();
            for (String str3 : arrayList) {
                this.XR.remove(str3);
                this.XQ.remove(str3);
                editorEdit.remove(str3);
                com.kwad.sdk.core.diskcache.a.a.vE().remove(str3);
            }
            editorEdit.apply();
            size = this.XR.size();
        }
        if (size > 30) {
            b.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i2 = size - 15;
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = Long.MAX_VALUE;
                synchronized (this.mLock) {
                    str = "";
                    for (PreLoadItem preLoadItem2 : this.XQ.values()) {
                        if (preLoadItem2.expiredTime < j2) {
                            j2 = preLoadItem2.expiredTime;
                            str = preLoadItem2.preloadId;
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.XR.remove(str);
                        this.XQ.remove(str);
                        this.XS.edit().remove(str).apply();
                        b.d("PreloadManager", "移除 preloadId = " + str + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    com.kwad.sdk.core.diskcache.a.a.vE().remove(str);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager sm() {
        SplashPreloadManager splashPreloadManager = a.XT;
        if (splashPreloadManager.XS == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void y(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (((long) adInfo.adPreloadInfo.validityPeriod) * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.aT(adInfo);
        synchronized (this.mLock) {
            this.XQ.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.XR.contains(adInfo.adPreloadInfo.preloadId)) {
                this.XR.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.XS != null) {
            SharedPreferences.Editor editorEdit = this.XS.edit();
            editorEdit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            editorEdit.apply();
        }
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z2) {
        int i2;
        long j2;
        String str;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.splash.monitor.a.sp();
        com.kwad.components.splash.monitor.a.h(adResultData);
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo == null || this.XS == null) {
                        com.kwad.components.splash.monitor.a.sp();
                        i2 = 3;
                        j2 = next.posId;
                        str = SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG;
                        com.kwad.components.splash.monitor.a.a(adInfo, i2, str, j2);
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (aL(adInfo.adPreloadInfo.preloadId)) {
                            com.kwad.components.splash.monitor.a.sp();
                            com.kwad.components.splash.monitor.a.a(adInfo, SystemClock.elapsedRealtime() - jElapsedRealtime, 2, next.posId);
                            y(adInfo);
                            i3++;
                        } else {
                            String strE = com.kwad.sdk.core.response.a.a.aV(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aW(adInfo) ? com.kwad.sdk.core.response.a.a.aN(adInfo).materialUrl : null;
                            if (TextUtils.isEmpty(strE)) {
                                com.kwad.components.splash.monitor.a.sp();
                                i2 = 2;
                                j2 = next.posId;
                                str = SplashMonitorInfo.ERROR_URL_INVALID_MSG;
                                com.kwad.components.splash.monitor.a.a(adInfo, i2, str, j2);
                            } else {
                                String strAT = com.kwad.sdk.core.response.a.a.aT(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || af.isWifiConnected(KsAdSDKImpl.get().getContext()) || z2) {
                                    b.d("PreloadManager", "start Download preloadId " + strAT + " true url " + strE);
                                    sl();
                                    a.C0442a c0442a = new a.C0442a();
                                    if (h.a(strE, strAT, c0442a)) {
                                        y(adInfo);
                                        i3++;
                                        com.kwad.components.splash.monitor.a.sp();
                                        com.kwad.components.splash.monitor.a.a(adInfo, SystemClock.elapsedRealtime() - jElapsedRealtime, 1, next.posId);
                                    } else {
                                        com.kwad.components.splash.monitor.a.sp();
                                        com.kwad.components.splash.monitor.a.a(adInfo, 4, c0442a.msg, next.posId);
                                        com.kwad.components.core.m.a.pr().b(next, 1, c0442a.msg);
                                    }
                                } else {
                                    com.kwad.components.splash.monitor.a.sp();
                                    com.kwad.components.splash.monitor.a.a(adInfo, 1, SplashMonitorInfo.ERROR_NET_MSG, next.posId);
                                }
                            }
                        }
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i3 > 0) {
            i.W("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.m.a.pr().e(adTemplate, i3);
        } else {
            i.W("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i3;
    }

    @AnyThread
    public final boolean f(AdResultData adResultData) {
        PreLoadItem preLoadItem;
        boolean zAL = false;
        zAL = false;
        zAL = false;
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    String strAT = com.kwad.sdk.core.response.a.a.aT(adInfo);
                    zAL = aL(strAT);
                    PreLoadPara preLoadPara = new PreLoadPara();
                    preLoadPara.isValidReturned = zAL ? 1 : 0;
                    if (zAL) {
                        synchronized (this.mLock) {
                            preLoadItem = this.XQ.get(strAT);
                        }
                        if (preLoadItem != null) {
                            preLoadPara.spreadTime = preLoadItem.cacheTime;
                        }
                    }
                    b.d("PreloadManager", "check checked " + zAL + " spreadTime " + preLoadPara.spreadTime);
                    com.kwad.sdk.core.report.a.c(adTemplate, preLoadPara.toJson());
                }
            }
        }
        return zAL;
    }

    public final List<String> sn() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            b.d("PreloadManager", "getPreloadIdList start ");
            for (int i2 = 0; i2 < this.XR.size(); i2++) {
                String str = this.XR.get(i2);
                File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(str);
                if (fileAN != null && fileAN.exists()) {
                    arrayList.add(str);
                }
            }
            b.d("PreloadManager", "getPreloadIdList end ");
        }
        b.d("PreloadManager", "getPreloadIdList " + this.XR.size());
        return arrayList;
    }
}
