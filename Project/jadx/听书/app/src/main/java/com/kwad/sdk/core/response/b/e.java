package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static g IR() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.wp();
        }
        return null;
    }

    public static boolean ed(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long ee(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int ef(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int eg(AdTemplate adTemplate) {
        if (adTemplate != null) {
            return (adTemplate.mAdScene == null || adTemplate.mAdScene.adStyle == 0) ? ef(adTemplate) : adTemplate.mAdScene.getAdStyle();
        }
        return 0;
    }

    public static int eh(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long ei(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String ej(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String ek(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo el(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    public static PhotoInfo em(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String en(AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.K(el(adTemplate));
        }
        return h.a(em(adTemplate));
    }

    public static String eo(AdTemplate adTemplate) {
        return el(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String ep(AdTemplate adTemplate) {
        g gVarIR = IR();
        String strIV = gVarIR == null ? "" : gVarIR.IV();
        return TextUtils.isEmpty(strIV) ? strIV : a.Y(el(adTemplate));
    }

    public static String eq(AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.co(el(adTemplate));
        }
        g gVarIR = IR();
        return gVarIR == null ? "" : gVarIR.IW();
    }

    public static long er(AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.ab(el(adTemplate));
        }
        g gVarIR = IR();
        return gVarIR == null ? adTemplate.hashCode() : gVarIR.IX();
    }

    public static int es(AdTemplate adTemplate) {
        g gVarIR = IR();
        if (gVarIR == null) {
            return 0;
        }
        return gVarIR.IY();
    }

    public static boolean k(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEl = el(adTemplate);
        return a.aF(adInfoEl) && !a.cX(adInfoEl) && !z && et(adTemplate) == 2;
    }

    public static boolean O(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEl = el(adTemplate);
        return (a.aF(adInfoEl) || a.cX(adInfoEl) || et(adTemplate) != 3) ? false : true;
    }

    public static int et(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return el(adTemplate).adBaseInfo.taskType;
    }

    public static String eu(AdTemplate adTemplate) {
        if (ed(adTemplate)) {
            return a.cI(el(adTemplate));
        }
        return h.c(em(adTemplate));
    }

    public static long ev(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return el(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean ew(AdTemplate adTemplate) {
        return el(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean ex(AdTemplate adTemplate) {
        int iL = l(adTemplate, true);
        return iL == 1 || iL == 2;
    }

    public static boolean ey(AdTemplate adTemplate) {
        int iL = l(adTemplate, false);
        return iL == 1 || iL == 2;
    }

    public static int l(AdTemplate adTemplate, boolean z) {
        int i;
        AdInfo adInfoEl = el(adTemplate);
        if (!eF(adTemplate)) {
            return adInfoEl.adBaseInfo.mABParams.playableStyle;
        }
        if (z) {
            i = adInfoEl.adMatrixInfo.adDataV2.actionBarInfo.cardType;
        } else {
            i = adInfoEl.adMatrixInfo.adDataV2.endCardInfo.cardType;
        }
        if (i == 5) {
            return 1;
        }
        return i == 6 ? 2 : -1;
    }

    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j, int i) {
        AdTemplate adTemplateA = a(list, j, i);
        if (adTemplateA == null) {
            return false;
        }
        long jEv = ev(adTemplateA);
        int iEf = ef(adTemplateA);
        if (i > 0) {
            if (jEv != j || iEf != i) {
                return false;
            }
        } else if (jEv != j) {
            return false;
        }
        return true;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long jEv = ev(adTemplate);
        int iEf = ef(adTemplate);
        if (i > 0) {
            if (jEv == j && iEf == i) {
                return true;
            }
        } else if (jEv == j) {
            return true;
        }
        return false;
    }

    public static int ez(AdTemplate adTemplate) {
        return el(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean eA(AdTemplate adTemplate) {
        AdInfo adInfoEl = el(adTemplate);
        return adInfoEl.adStyleConfInfo.adPushDownloadJumpType == 0 && ef(adTemplate) == 17 && a.aF(adInfoEl);
    }

    public static int eB(AdTemplate adTemplate) {
        if (adTemplate.adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.BQ();
            }
            return 800;
        }
        return adTemplate.adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static KsLiveInfo eC(AdTemplate adTemplate) {
        AdInfo adInfoEl = el(adTemplate);
        if (adInfoEl.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(adInfoEl.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        if (adInfoEl.advertiserInfo.userName != null) {
            ksLiveBaseInfo.setUserName(adInfoEl.advertiserInfo.userName);
        }
        if (adInfoEl.advertiserInfo.portraitUrl != null) {
            ksLiveBaseInfo.setPortraitUrl(adInfoEl.advertiserInfo.portraitUrl);
        }
        if (adInfoEl.adBaseInfo.liveDisplayWatchingCount > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(adInfoEl.adBaseInfo.liveDisplayWatchingCount);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = adInfoEl.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        if (adProductInfo.couponList != null && adProductInfo.couponList.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int eD(AdTemplate adTemplate) {
        return el(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean eE(AdTemplate adTemplate) {
        int iEf = ef(adTemplate);
        if (iEf == 13) {
            return true;
        }
        return iEf == 23 && eD(adTemplate) == 2;
    }

    public static boolean eF(AdTemplate adTemplate) {
        int iEf = ef(adTemplate);
        if (iEf == 3) {
            return true;
        }
        return iEf == 23 && eD(adTemplate) == 1;
    }

    public static int eG(AdTemplate adTemplate) {
        return adTemplate.type;
    }

    public static int eH(AdTemplate adTemplate) {
        return adTemplate.defaultType;
    }
}
