package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
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
    private HashMap<String, PreLoadItem> Fm;
    private List<String> Fn;
    private volatile SharedPreferences Fo;
    private final Object mLock;

    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public int materialType;
        public String preloadId;
    }

    /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    static class a {
        private static final SplashPreloadManager Fp = new SplashPreloadManager(0);
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Fo = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Fm = new HashMap<>();
        this.Fn = new ArrayList();
        init();
    }

    private void initData() {
        Map<String, ?> all = this.Fo.getAll();
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
                            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(preLoadItem.preloadId);
                            if (fileCf != null && fileCf.exists()) {
                                synchronized (this.mLock) {
                                    this.Fm.put(str, preLoadItem);
                                    if (!this.Fn.contains(str)) {
                                        this.Fn.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor editorEdit = this.Fo.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    public final void a(long j, int i) {
        int i2;
        int i3;
        int i4;
        int size;
        boolean z;
        char c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size2 = this.Fn.size();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            i3 = 0;
            i4 = 0;
            for (String str : this.Fm.keySet()) {
                PreLoadItem preLoadItem = this.Fm.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < jCurrentTimeMillis) {
                    arrayList.add(str);
                    if (preLoadItem.materialType == 2) {
                        i3++;
                    } else if (preLoadItem.materialType == 1) {
                        i4++;
                    }
                }
            }
            SharedPreferences.Editor editorEdit = this.Fo.edit();
            for (String str2 : arrayList) {
                this.Fn.remove(str2);
                this.Fm.remove(str2);
                editorEdit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.GP().remove(str2);
            }
            editorEdit.apply();
            size = this.Fn.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i5 = size - 15;
            for (i2 = 0; i2 < i5; i2++) {
                String str3 = "";
                synchronized (this.mLock) {
                    long j2 = Long.MAX_VALUE;
                    for (PreLoadItem preLoadItem2 : this.Fm.values()) {
                        if (preLoadItem2.expiredTime < j2) {
                            long j3 = preLoadItem2.expiredTime;
                            str3 = preLoadItem2.preloadId;
                            j2 = j3;
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        z = true;
                        c = 2;
                    } else {
                        PreLoadItem preLoadItem3 = this.Fm.get(str3);
                        if (preLoadItem3 != null) {
                            c = 2;
                            if (preLoadItem3.materialType == 2) {
                                i3++;
                                z = true;
                            } else {
                                z = true;
                                if (preLoadItem3.materialType == 1) {
                                    i4++;
                                }
                            }
                        } else {
                            z = true;
                            c = 2;
                        }
                        this.Fn.remove(str3);
                        this.Fm.remove(str3);
                        this.Fo.edit().remove(str3).apply();
                        com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.GP().remove(str3);
                }
            }
        }
        int i6 = i3;
        List<String> listLE = lE();
        int size3 = size2 - listLE.size();
        List<Integer> listI = i(listLE);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(j, listLE, listI, i, size3, i4, i6);
    }

    public static SplashPreloadManager lD() {
        SplashPreloadManager splashPreloadManager = a.Fp;
        if (splashPreloadManager.Fo == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    public final int a(AdResultData adResultData, boolean z, int i) {
        Iterator<AdInfo> it;
        String strK;
        boolean zA;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.k(adResultData);
        int i2 = 0;
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            if (adTemplate != null) {
                Iterator<AdInfo> it2 = adTemplate.adInfoList.iterator();
                while (it2.hasNext()) {
                    AdInfo next = it2.next();
                    if (next.adPreloadInfo != null && this.Fo != null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(next)) {
                            if (com.kwad.sdk.core.response.b.a.bc(next)) {
                                strK = com.kwad.sdk.core.response.b.a.K(next);
                            } else {
                                strK = com.kwad.sdk.core.response.b.a.bd(next) ? com.kwad.sdk.core.response.b.a.aU(next).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(strK)) {
                                String strAZ = com.kwad.sdk.core.response.b.a.aZ(next);
                                if (next.adPreloadInfo.preloadType != 1 || ao.isWifiConnected(ServiceProvider.getContext()) || z) {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + strAZ + " true url " + strK);
                                    it = it2;
                                    a(adResultData.getPosId(), 1);
                                    a.C0405a c0405a = new a.C0405a();
                                    if (p(next)) {
                                        zA = KSImageLoader.loadImageSync(strK) != null;
                                    } else {
                                        zA = k.a(strK, strAZ, c0405a);
                                    }
                                    if (zA) {
                                        o(next);
                                        i2++;
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 1, i);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 4, c0405a.msg);
                                        com.kwad.components.core.p.a.se().f(adTemplate, 1, c0405a.msg);
                                    }
                                } else {
                                    it = it2;
                                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            } else {
                                it = it2;
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            it = it2;
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 2, i);
                            o(next);
                            i2++;
                        }
                    } else {
                        it = it2;
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                    it2 = it;
                }
            }
        }
        AdTemplate adTemplate2 = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i2 > 0) {
            com.kwad.sdk.utils.k.aq("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.p.a.se().e(adTemplate2, i2);
        } else {
            com.kwad.sdk.utils.k.aq("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i2;
    }

    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (((long) adInfo.adPreloadInfo.validityPeriod) * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        preLoadItem.materialType = com.kwad.sdk.core.response.b.a.bc(adInfo) ? 2 : 1;
        synchronized (this.mLock) {
            this.Fm.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Fn.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Fn.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Fo != null) {
            SharedPreferences.Editor editorEdit = this.Fo.edit();
            editorEdit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            editorEdit.apply();
        }
    }

    public final boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    public static boolean i(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public static boolean j(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
            com.kwad.sdk.core.d.c.d("PreloadManager", "check preloadId " + str + " file exists " + (fileCf == null ? "null" : Boolean.valueOf(fileCf.exists())));
            if (fileCf != null && fileCf.exists()) {
                return true;
            }
        }
        return false;
    }

    public static File aa(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
        if (fileCf == null || !fileCf.exists()) {
            return null;
        }
        return fileCf;
    }

    public final List<String> S() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.Fn.size(); i++) {
                String str = this.Fn.get(i);
                File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
                if (fileCf != null && fileCf.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.Fn.size());
        return arrayList;
    }

    public final List<String> lE() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean start ");
            arrayList = new ArrayList(this.Fn);
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean " + this.Fn.size());
        return arrayList;
    }

    public final List<Integer> i(List<String> list) {
        PreLoadItem preLoadItem;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList start ");
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (this.Fm.containsKey(str) && (preLoadItem = this.Fm.get(str)) != null) {
                    arrayList.add(Integer.valueOf(preLoadItem.materialType));
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList " + arrayList.size());
        return arrayList;
    }
}
