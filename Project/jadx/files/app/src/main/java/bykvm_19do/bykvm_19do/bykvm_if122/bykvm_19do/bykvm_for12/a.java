package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final Map<String, Integer> a = new HashMap();
    private final Map<String, Integer> b = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.bytedance.msdk.api.AdSlot r6, com.bytedance.msdk.api.AdSlot r7, com.bytedance.msdk.base.TTBaseAd r8) {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a.a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.base.TTBaseAd):boolean");
    }

    public static boolean a(Map<String, String> map, Map<String, String> map2) {
        if (map != null || map2 != null) {
            if (map == null || map2 == null || map.size() != map2.size()) {
                return false;
            }
            Set<String> setKeySet = map.keySet();
            if (setKeySet != null) {
                for (String str : setKeySet) {
                    if (str != null) {
                        String str2 = map.get(str);
                        String str3 = map2.get(str);
                        if (str2 != null || str3 != null) {
                            if (!TextUtils.equals(str2, str3)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    protected int a(e eVar, AdSlot adSlot, AdSlot adSlot2, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        if (eVar == null || eVar.a == null) {
            return 4;
        }
        String adUnitId = adSlot2 != null ? adSlot2.getAdUnitId() : "";
        String adNetWorkName = eVar.a.getAdNetWorkName();
        String adNetworkSlotId = eVar.a.getAdNetworkSlotId();
        GMAdConstant.AdIsReadyStatus adIsReadyStatusIsReadyStatus = eVar.a.isReadyStatus();
        if (adIsReadyStatusIsReadyStatus == GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            if (eVar.a.isHasShown()) {
                Logger.d("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 7;
            }
            if (a(adUnitId, eVar.a)) {
                Logger.d("TTMediationSDK", "--==-- " + str + ":广告过期了(M配置) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 2;
            }
            if (a(adSlot, adSlot2, eVar.a)) {
                sb = new StringBuilder();
                sb.append("--==-- ");
                sb.append(str);
                sb.append(":复用成功：---");
                sb.append(adNetWorkName);
                sb.append(", adSlotId: ");
                sb.append(adNetworkSlotId);
                Logger.d("TTMediationSDK", sb.toString());
                return -1;
            }
            sb2 = new StringBuilder();
            sb2.append("--==-- ");
            sb2.append(str);
            sb2.append(":AdSlot不符合 ---: ");
            sb2.append(adNetWorkName);
            sb2.append(", adSlotId: ");
            sb2.append(adNetworkSlotId);
            Logger.d("TTMediationSDK", sb2.toString());
            return 6;
        }
        if (eVar.a.isHasShown()) {
            Logger.d("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 7;
        }
        if (adIsReadyStatusIsReadyStatus == GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            Logger.d("TTMediationSDK", "--==-- " + str + ":广告过期了(adn api) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 1;
        }
        if (adIsReadyStatusIsReadyStatus == GMAdConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            Logger.d("TTMediationSDK", "--==-- " + str + ":isReady是false ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 5;
        }
        if (a(adSlot, adSlot2, eVar.a)) {
            sb = new StringBuilder();
            sb.append("--==-- ");
            sb.append(str);
            sb.append(":复用成功：---");
            sb.append(adNetWorkName);
            sb.append(", adSlotId: ");
            sb.append(adNetworkSlotId);
            Logger.d("TTMediationSDK", sb.toString());
            return -1;
        }
        sb2 = new StringBuilder();
        sb2.append("--==-- ");
        sb2.append(str);
        sb2.append(":AdSlot不符合 ---: ");
        sb2.append(adNetWorkName);
        sb2.append(", adSlotId: ");
        sb2.append(adNetworkSlotId);
        Logger.d("TTMediationSDK", sb2.toString());
        return 6;
    }

    public int a(String str, String str2) {
        Integer num = this.a.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public void a(String str, String str2, int i2) {
        this.a.put(str + "_" + str2, Integer.valueOf(i2));
    }

    public final boolean a(String str, TTBaseAd tTBaseAd) {
        String str2;
        if (tTBaseAd == null || tTBaseAd.hasDestroyed()) {
            str2 = "--==-- 广告已经destroy了，视为过期 ------";
        } else {
            z = SystemClock.elapsedRealtime() > tTBaseAd.getFillTime() + ((long) a(str, tTBaseAd.getAdNetworkSlotId()));
            str2 = "--==-- 使用了配置的过期时间进行判断 ------";
        }
        Logger.d("TTMediationSDK", str2);
        return z;
    }

    public int b(String str, String str2) {
        Integer num = this.b.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public void b(String str, String str2, int i2) {
        this.b.put(str + "_" + str2, Integer.valueOf(i2));
    }
}
