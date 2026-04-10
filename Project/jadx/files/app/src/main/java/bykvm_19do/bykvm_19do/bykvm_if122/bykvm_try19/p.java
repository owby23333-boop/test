package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public static GMAdEcpmInfo a(TTBaseAd tTBaseAd, boolean z2) {
        String multiCpm;
        if (tTBaseAd == null) {
            return null;
        }
        GMAdEcpmInfo gMAdEcpmInfo = new GMAdEcpmInfo();
        gMAdEcpmInfo.setAdNetworkPlatformId(tTBaseAd.getAdNetworkPlatformId());
        gMAdEcpmInfo.setAdNetworkPlatformName(tTBaseAd.getAdNetWorkName());
        gMAdEcpmInfo.setCustomAdNetworkPlatformName(tTBaseAd.getCustomAdNetWorkName());
        gMAdEcpmInfo.setAdNetworkRitId(tTBaseAd.getAdNetworkSlotId());
        gMAdEcpmInfo.setLevelTag(tTBaseAd.getLevelTag());
        if (z2) {
            if (b() || (!tTBaseAd.isServerBiddingAd() && !tTBaseAd.isClientBiddingAd() && !tTBaseAd.isMultiBiddingAd())) {
                multiCpm = tTBaseAd.getNetWorkPlatFormCpm();
                gMAdEcpmInfo.setPreEcpm(multiCpm);
            }
            gMAdEcpmInfo.setPreEcpm(GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION);
        } else {
            if (a() || !tTBaseAd.isServerBiddingAd()) {
                multiCpm = tTBaseAd.getMultiCpm();
                gMAdEcpmInfo.setPreEcpm(multiCpm);
            }
            gMAdEcpmInfo.setPreEcpm(GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION);
        }
        gMAdEcpmInfo.setRequestId(tTBaseAd.getReqId());
        gMAdEcpmInfo.setReqBiddingType(tTBaseAd.getAdNetworkSlotType());
        gMAdEcpmInfo.setErrorMsg(tTBaseAd.getErrorMsg());
        return gMAdEcpmInfo;
    }

    public static String a(TTBaseAd tTBaseAd) {
        Map<String, Object> eventMap;
        if (tTBaseAd != null && (eventMap = tTBaseAd.getEventMap()) != null) {
            Object obj = eventMap.get("waterfall_abtest");
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    private static boolean a() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().s();
    }

    public static boolean a(List<TTBaseAd> list, List<TTBaseAd> list2, List<TTBaseAd> list3, AdSlot adSlot, boolean z2, AtomicBoolean atomicBoolean, String str, int i2, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> list4, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(list, list2, list3, adSlot, str2);
        if (!z2 && !atomicBoolean.get()) {
            if (list.size() > 0) {
                for (TTBaseAd tTBaseAd : list) {
                    if (tTBaseAd != null) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(str, tTBaseAd.getAdNetworkSlotId()) + "isReady-》广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + tTBaseAd.isReady(str));
                        if (tTBaseAd.isReady(str) && !tTBaseAd.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list3 != null && list3.size() > 0) {
                for (TTBaseAd tTBaseAd2 : list3) {
                    if (tTBaseAd2 != null) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(str, tTBaseAd2.getAdNetworkSlotId()) + "isReady-》广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd2.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + tTBaseAd2.isReady(str));
                        if (tTBaseAd2.isReady(str) && !tTBaseAd2.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (TTBaseAd tTBaseAd3 : list2) {
                    if (tTBaseAd3 != null) {
                        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(str, tTBaseAd3.getAdNetworkSlotId()) + "isReady--->biding-->广告类型：" + com.bytedance.msdk.base.a.a(tTBaseAd3.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + tTBaseAd3.isReady(str));
                        if (tTBaseAd3.isReady(str) && !tTBaseAd3.isHasShown()) {
                            return true;
                        }
                    }
                }
            }
            if (list4 != null && list4.size() > 0) {
                for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : list4) {
                    String strD = jVar.d();
                    if (jVar.a() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(str, strD, i2) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(strD, adSlot, false) == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean b() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().r();
    }
}
