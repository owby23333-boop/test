package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdFreqError;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile a f1502j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f1503c = {"unity", "ks"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f1504d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Integer> f1505e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<e>> f1506f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, j> f1507g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, String> f1508h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Integer> f1509i = new HashMap();

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a$a, reason: collision with other inner class name */
    class RunnableC0043a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ AdSlot b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f1510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f1511d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f1512e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ GMNetworkRequestInfo f1513f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f1514g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ GMAdSlotBase f1515h;

        RunnableC0043a(String str, AdSlot adSlot, boolean z2, Map map, Context context, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, GMAdSlotBase gMAdSlotBase) {
            this.a = str;
            this.b = adSlot;
            this.f1510c = z2;
            this.f1511d = map;
            this.f1512e = context;
            this.f1513f = gMNetworkRequestInfo;
            this.f1514g = iVar;
            this.f1515h = gMAdSlotBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            String adNetWorkName;
            String strA;
            e eVar;
            List<e> list = (List) a.this.f1506f.get(this.a);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (e eVar2 : list) {
                    if (eVar2 != null && eVar2.a.isHasShown()) {
                        list.remove(eVar2);
                        arrayList.add(eVar2);
                    }
                }
            }
            if (Logger.isDebug()) {
                if (arrayList.size() <= 0 || (eVar = (e) arrayList.get(0)) == null) {
                    adNetWorkName = "";
                    strA = adNetWorkName;
                } else {
                    strA = com.bytedance.msdk.base.a.a(eVar.a.getAdType(), eVar.a.getSubAdType());
                    adNetWorkName = eVar.a.getAdNetWorkName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("--==-- 广告复用:show时缓存移除 -----：");
                sb.append(adNetWorkName);
                sb.append(", ");
                sb.append(strA);
                sb.append(", ");
                sb.append(this.a);
                sb.append(arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0");
                Logger.d("TTMediationSDK", sb.toString());
            }
            AdSlot adSlot = this.b;
            String adUnitId = adSlot != null ? adSlot.getAdUnitId() : "";
            AdSlot adSlot2 = this.b;
            boolean z2 = adSlot2 == null || adSlot2.getAdType() == 1;
            if ((!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(adUnitId, this.a) && this.f1510c) && !z2 && a.this.d(adUnitId, this.a)) {
                a.this.a(this.a, this.b, this.f1511d, this.f1512e, this.f1513f, this.f1514g, this.f1515h);
                return;
            }
            Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + this.a);
        }
    }

    private class b implements TTAbsAdLoaderAdapter.AdapterLoaderListener {
        private AdSlot a;

        b(AdSlot adSlot) {
            this.a = adSlot;
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdFailed(AdError adError, d dVar) {
            if (adError == null || dVar == null) {
                return;
            }
            Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存失败 --- " + dVar.c() + ", " + dVar.d() + ", " + com.bytedance.msdk.base.a.a(dVar.b(), dVar.h()) + ", errCode: " + adError.thirdSdkErrorCode + ",msg=" + adError.thirdSdkErrorMessage);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(TTBaseAd tTBaseAd, d dVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tTBaseAd);
            onAdLoaded(arrayList, dVar);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(List<TTBaseAd> list, d dVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
                    arrayList.add(new e(tTBaseAd, dVar, 0L, this.a));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((e) arrayList.get(0)).a;
                Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存成功 --- " + tTBaseAd2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.base.a.a(tTBaseAd2.getAdType(), tTBaseAd2.getSubAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                a.this.a(tTBaseAd2.getAdNetworkSlotId(), arrayList);
            }
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdVideoCache() {
        }
    }

    private a() {
    }

    public static a a() {
        if (f1502j == null) {
            synchronized (a.class) {
                if (f1502j == null) {
                    f1502j = new a();
                }
            }
        }
        return f1502j;
    }

    private String a(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            int i2 = 0;
            while (i2 < list.size()) {
                sb.append(list.get(i2).a());
                sb.append(i2 == list.size() + (-1) ? "]" : ",");
                i2++;
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e2) {
                Logger.d("TTMediationSDK", "--==-- 广告复用：adCannotUseInfo json err: " + e2.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdSlot adSlot, Map<String, Object> map, Context context, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, GMAdSlotBase gMAdSlotBase) {
        String strA;
        String string;
        StringBuilder sb;
        String str2;
        if (adSlot == null) {
            sb = new StringBuilder();
            str2 = "--==-- 广告复用:show时预请求取消，adSlot为空 -------: ";
        } else {
            if (context != null) {
                j jVarC = c(adSlot.getAdUnitId(), str);
                if (jVarC != null) {
                    try {
                        strA = g.a(jVarC.q(), g.c(jVarC.e()), com.bytedance.msdk.base.a.a(jVarC.t(), jVarC.z()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        strA = null;
                    }
                    if (TextUtils.isEmpty(strA) && g.a(strA) && jVarC != null) {
                        String[] strArr = this.f1503c;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                String str3 = strArr[i2];
                                if (TextUtils.equals(str3, jVarC.e())) {
                                    sb = new StringBuilder();
                                    sb.append("--==-- 广告复用:show时预请求取消，");
                                    sb.append(str3);
                                    str2 = "为单例模式 -------: ";
                                    break;
                                }
                                i2++;
                            } else {
                                int iIntValue = this.f1509i.get(str) != null ? this.f1509i.get(str).intValue() : -1;
                                Logger.d("TTMediationSDK", "--==-- 广告复用:show时预请求开始 -------: " + str);
                                TTAbsAdLoaderAdapter tTAbsAdLoaderAdapterB = g.b(strA);
                                if (tTAbsAdLoaderAdapterB == null) {
                                    h.a(jVarC, adSlot, 4, 1);
                                    return;
                                }
                                h.b(jVarC, adSlot, 4, 1);
                                if (!k.b().b(adSlot.getAdUnitId(), jVarC.d())) {
                                    Logger.d("TMe", "adn 代码位预请求触发次数拦截............");
                                    Pair<String, String> pairD = k.b().d(adSlot.getAdUnitId(), jVarC.d());
                                    if (pairD != null) {
                                        AdFreqError adFreqError = new AdFreqError(AdError.ERROR_CODE_ADN_EXCEED_FREQCTL, AdError.getMessage(AdError.ERROR_CODE_ADN_EXCEED_FREQCTL), (String) pairD.second, (String) pairD.first);
                                        h.a(jVarC, adSlot, a().a(jVarC.d()), true, 2, iIntValue, 4, 1, (AdError) adFreqError, -1L);
                                        h.a(adFreqError, adSlot, jVarC, iIntValue, 4, 1, a().a(jVarC.d()), 0L, null, null, null);
                                        return;
                                    }
                                    return;
                                }
                                tTAbsAdLoaderAdapterB.setAdapterListener(new b(adSlot));
                                tTAbsAdLoaderAdapterB.loadAdInter(context, jVarC, g.a(jVarC, adSlot, map, gMNetworkRequestInfo, 4, 1, true, -1L), adSlot, iVar, iIntValue, gMAdSlotBase);
                                sb = new StringBuilder();
                                str2 = "--==-- 广告复用:show时预请求已发完 -------: ";
                            }
                        }
                    } else {
                        string = "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + strA + ", wfcBean: " + jVarC + ", adnSlotId: " + str;
                    }
                } else {
                    strA = null;
                    if (TextUtils.isEmpty(strA)) {
                    }
                    string = "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + strA + ", wfcBean: " + jVarC + ", adnSlotId: " + str;
                }
                Logger.d("TTMediationSDK", string);
            }
            sb = new StringBuilder();
            str2 = "--==-- 广告复用:show时预请求取消，context为null -------: ";
        }
        sb.append(str2);
        sb.append(str);
        string = sb.toString();
        Logger.d("TTMediationSDK", string);
    }

    private boolean a(List<e> list, e eVar) {
        for (e eVar2 : list) {
            if (eVar2 != null && eVar != null && eVar2.a == eVar.a) {
                return true;
            }
        }
        return false;
    }

    private int b(String str, AdSlot adSlot, boolean z2) {
        int i2;
        String str2;
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f1506f.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            Logger.d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
            return 1;
        }
        String adUnitId = adSlot != null ? adSlot.getAdUnitId() : "";
        ArrayList arrayList = new ArrayList();
        e eVar = null;
        boolean z3 = false;
        for (e eVar2 : copyOnWriteArrayList) {
            GMAdConstant.AdIsReadyStatus adIsReadyStatusIsReadyStatus = eVar2.a.isReadyStatus();
            if (adIsReadyStatusIsReadyStatus == GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY ? a(adUnitId, eVar2.a) : adIsReadyStatusIsReadyStatus != GMAdConstant.AdIsReadyStatus.AD_IS_READY) {
                copyOnWriteArrayList.remove(eVar2);
                i2 = 5;
                str2 = "--==-- 广告复用:广告过期了 -------: " + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str;
            } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(eVar2.a(), adSlot, eVar2.a)) {
                Logger.d("TTMediationSDK", "--==-- 广告复用:复用成功：--------" + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str);
                z3 = true;
            } else {
                i2 = 6;
                str2 = "--==-- 广告复用:AdSlot不符合 -------: " + eVar2.a.getAdNetWorkName() + ", adSlotId: " + str;
            }
            Logger.d("TTMediationSDK", str2);
            if (eVar == null) {
                eVar = eVar2;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
            aVar.c(eVar2.a.getLoadSort());
            aVar.e(eVar2.a.getShowSort());
            aVar.b(eVar2.a.getAdNetworkSlotId());
            aVar.d(i2);
            aVar.b(eVar2.a.isHasShown() ? 1 : 0);
            arrayList.add(aVar);
        }
        if (z3) {
            return 3;
        }
        if (z2 && eVar != null) {
            h.a(adSlot, eVar.a, a(arrayList));
        }
        return 2;
    }

    public int a(String str, AdSlot adSlot, boolean z2) {
        int iB;
        synchronized (this) {
            iB = 1;
            if (b(adSlot != null ? adSlot.getAdUnitId() : "", str) == 0) {
                iB = b(str, adSlot, z2);
            } else {
                CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f1506f.get(str);
                if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                    Logger.d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
                } else {
                    e eVar = null;
                    ArrayList arrayList = z2 ? new ArrayList() : null;
                    boolean z3 = false;
                    for (e eVar2 : copyOnWriteArrayList) {
                        int iA = a(eVar2, eVar2.a(), adSlot, "广告复用");
                        if (iA == -1) {
                            z3 = true;
                        } else {
                            if (iA != 6) {
                                copyOnWriteArrayList.remove(eVar2);
                            }
                            if (z2) {
                                if (eVar == null) {
                                    eVar = eVar2;
                                }
                                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
                                aVar.c(eVar2.a.getLoadSort());
                                aVar.e(eVar2.a.getShowSort());
                                aVar.b(eVar2.a.getAdNetworkSlotId());
                                aVar.d(iA);
                                aVar.b(eVar2.a.isHasShown() ? 1 : 0);
                                arrayList.add(aVar);
                            }
                        }
                    }
                    if (z3) {
                        iB = 3;
                    } else {
                        if (z2 && eVar != null) {
                            h.a(adSlot, eVar.a, a(arrayList));
                        }
                        iB = 2;
                    }
                }
            }
        }
        return iB;
    }

    public String a(String str) {
        return this.f1508h.get(str);
    }

    public List<e> a(String str, AdSlot adSlot) {
        ArrayList arrayList;
        synchronized (this) {
            CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f1506f.get(str);
            if (copyOnWriteArrayList == null) {
                arrayList = null;
            } else {
                int adCount = adSlot != null ? adSlot.getAdCount() : 1;
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; arrayList2.size() < adCount && i2 < copyOnWriteArrayList.size(); i2++) {
                    if (!copyOnWriteArrayList.get(i2).c() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i2).a(), adSlot, copyOnWriteArrayList.get(i2).a)) {
                        arrayList2.add(copyOnWriteArrayList.get(i2));
                    }
                }
                for (int i3 = 0; arrayList2.size() < adCount && i3 < copyOnWriteArrayList.size(); i3++) {
                    if (copyOnWriteArrayList.get(i3).c() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i3).a(), adSlot, copyOnWriteArrayList.get(i3).a)) {
                        arrayList2.add(copyOnWriteArrayList.get(i3));
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(true);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public void a(String str, AdSlot adSlot, Map<String, Object> map, boolean z2, GMNetworkRequestInfo gMNetworkRequestInfo, i iVar, Context context, GMAdSlotBase gMAdSlotBase) {
        ThreadHelper.runOnMSDKThread(new RunnableC0043a(str, adSlot, z2, map, context, gMNetworkRequestInfo, iVar, gMAdSlotBase));
    }

    public void a(String str, String str2, j jVar, int i2) {
        if (jVar != null) {
            this.f1507g.put(str + "_" + str2, jVar);
        }
        this.f1509i.put(str2, Integer.valueOf(i2));
    }

    public void a(String str, List<e> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f1506f.get(str);
        if (copyOnWriteArrayList == null) {
            this.f1506f.put(str, new CopyOnWriteArrayList<>(list));
            return;
        }
        for (e eVar : list) {
            if (!a(copyOnWriteArrayList, eVar)) {
                copyOnWriteArrayList.add(eVar);
            }
        }
    }

    public j c(String str, String str2) {
        return this.f1507g.get(str + "_" + str2);
    }

    public boolean c(String str, String str2, int i2) {
        if (i2 == 2) {
            return false;
        }
        Integer num = this.f1504d.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void d(String str, String str2, int i2) {
        this.f1505e.put(str + "_" + str2, Integer.valueOf(i2));
    }

    public boolean d(String str, String str2) {
        Integer num = this.f1505e.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void e(String str, String str2) {
        this.f1508h.put(str, str2);
    }

    public void e(String str, String str2, int i2) {
        this.f1504d.put(str + "_" + str2, Integer.valueOf(i2));
    }
}
