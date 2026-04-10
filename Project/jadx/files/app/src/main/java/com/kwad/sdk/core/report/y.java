package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ba;
import com.qq.e.comm.pi.IBidding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends com.kwad.sdk.core.network.b {

    @Nullable
    private final JSONObject ajA;
    int ajy;

    @Nullable
    private final b ajz;
    private final AdTemplate mAdTemplate;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String ajC;
        public int ajD;
        public int ajE;
        public int ajF;
        public JSONObject ajG;
        public String templateId;
        public int ajB = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i2 = this.ajB;
            if (i2 != -1) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "shield_reason", i2);
            }
            long j2 = this.duration;
            if (j2 != -1) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "duration", j2);
            }
            int i3 = this.showLiveStatus;
            if (i3 != -1) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "show_live_status", i3);
            }
            int i4 = this.showLiveStyle;
            if (i4 != -1) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "show_live_style", i4);
            }
            JSONObject jSONObject2 = this.ajG;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.ajG.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long Jz;
        public String To;
        public String adnName;
        public int adnType;
        public int ait;
        public int ajH;
        public int ajI;
        public int ajJ;
        public int ajK;
        public String ajL;
        public int ajR;
        public String ajS;
        public int ajT;
        public int ajU;
        public String ajW;
        public int ajX;
        public String ajY;
        public String ajZ;
        public int aka;
        public int akb;
        public long akc;
        public long akd;
        public int akg;
        public a akh;
        public int aki;
        public int akj;
        public String akn;
        public int akp;
        public int akq;
        public int akr;
        public String aku;
        public int downloadSource;
        public int jS;
        public ab.a jU;
        public double jV;
        public long vy;
        public long ajM = -1;
        public int ajN = -1;
        public long ajO = -1;
        public int ajP = -1;
        public int ajQ = 0;
        public String ajV = "";
        public int ake = -1;
        public int akf = -1;
        public int oz = 0;
        public int akk = -1;
        public int akl = -1;
        public int akm = -1;
        public int ako = -1;
        public int adxResult = -1;
        public int aks = -1;
        public int akt = 0;

        public final void a(@Nullable j jVar) {
            if (jVar != null) {
                this.aku = jVar.xl();
            }
        }

        public final void bt(int i2) {
            if (i2 == 0) {
                this.akq = 1;
            } else if (i2 == 1) {
                this.akq = 2;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.akq = 3;
            }
        }
    }

    y(@NonNull AdTemplate adTemplate, int i2, @Nullable b bVar, @Nullable JSONObject jSONObject) {
        this.mAdTemplate = adTemplate;
        this.ajy = i2;
        this.ajz = bVar;
        this.ajA = jSONObject;
    }

    private void A(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        putBody(AgooConstants.MESSAGE_EXT, jSONObject.toString());
    }

    private void a(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.akk;
        if (i2 >= 0) {
            putBody("adOrder", i2);
        }
        int i3 = bVar.akl;
        if (i3 >= 0) {
            putBody("adInterstitialSource", i3);
        }
        if (!TextUtils.isEmpty(bVar.ajL)) {
            putBody("adRenderArea", bVar.ajL);
        }
        int i4 = bVar.akm;
        if (i4 >= 0) {
            putBody("universeSecondAd", i4);
        }
        putBody("adxResult", bVar.adxResult);
        int i5 = bVar.akq;
        if (i5 != 0) {
            putBody("fingerSwipeType", i5);
        }
        int i6 = bVar.akr;
        if (i6 != 0) {
            putBody("fingerSwipeDistance", i6);
        }
        int i7 = bVar.akf;
        if (i7 != -1) {
            putBody("installStatus", i7);
        }
        a aVar = bVar.akh;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        String str2 = bVar.aku;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i8 = bVar.aks;
        if (i8 != -1) {
            putBody("triggerType", i8);
        }
        int i9 = bVar.ajQ;
        if (i9 != 0) {
            putBody("photoSizeStyle", i9);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable b bVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i2 = adTemplate.mInitVoiceStatus;
        if (i2 != 0) {
            putBody("initVoiceStatus", i2);
        }
        putBody("ecpmType", this.mAdTemplate.mBidEcpm == 0 ? 2 : 1);
        if (bVar == null) {
            return;
        }
        int i3 = bVar.ait;
        if (i3 != 0) {
            putBody("adAggPageSource", i3);
        }
        if (TextUtils.isEmpty(bVar.To)) {
            return;
        }
        putBody("payload", bVar.To);
    }

    private void b(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.jS;
        if (i2 != 0) {
            putBody("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(bVar.To)) {
            putBody("payload", bVar.To);
        }
        int i3 = bVar.ait;
        if (i3 != 0) {
            putBody("adAggPageSource", i3);
        }
        int i4 = bVar.akk;
        if (i4 >= 0) {
            putBody("adOrder", i4);
        }
        int i5 = bVar.akl;
        if (i5 >= 0) {
            putBody("adInterstitialSource", i5);
        }
        int i6 = bVar.aks;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = bVar.akt;
        if (i7 != 0) {
            putBody("cardCloseType", i7);
        }
        putBody("adxResult", bVar.adxResult);
        double d2 = bVar.jV;
        if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            putBody("splashShakeAcceleration", d2);
        }
        if (!TextUtils.isEmpty(bVar.akn)) {
            putBody("splashInteractionRotateAngle", bVar.akn);
        }
        int i8 = bVar.akq;
        if (i8 != 0) {
            putBody("fingerSwipeType", i8);
        }
        int i9 = bVar.akr;
        if (i9 != 0) {
            putBody("fingerSwipeDistance", i9);
        }
        long j2 = bVar.vy;
        if (j2 > 0) {
            putBody("playedDuration", j2);
        }
        int i10 = bVar.akj;
        if (i10 > 0) {
            putBody("playedRate", i10);
        }
        String str2 = bVar.aku;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i11 = bVar.ajP;
        if (i11 != -1) {
            putBody("retainCodeType", i11);
        }
        a aVar = bVar.akh;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i12 = bVar.ajQ;
        if (i12 != 0) {
            putBody("photoSizeStyle", i12);
        }
    }

    private void c(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = bVar.ajJ;
        if (i2 != 0) {
            putBody("itemCloseType", i2);
        }
        int i3 = bVar.ajH;
        if (i3 > 0) {
            putBody("photoPlaySecond", i3);
        }
        int i4 = bVar.ajI;
        if (i4 != 0) {
            putBody("awardReceiveStage", i4);
        }
        int i5 = bVar.ajK;
        if (i5 != 0) {
            putBody("elementType", i5);
        }
        if (!TextUtils.isEmpty(bVar.To)) {
            putBody("payload", bVar.To);
        }
        a aVar = bVar.akh;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i6 = bVar.ajR;
        if (i6 > 0) {
            putBody("deeplinkType", i6);
        }
        if (!TextUtils.isEmpty(bVar.ajS)) {
            putBody("deeplinkAppName", bVar.ajS);
        }
        int i7 = bVar.ajT;
        if (i7 != 0) {
            putBody("deeplinkFailedReason", i7);
        }
        int i8 = bVar.downloadSource;
        if (i8 > 0) {
            putBody("downloadSource", i8);
        }
        int i9 = bVar.akt;
        if (i9 != 0) {
            putBody("cardCloseType", i9);
        }
        int i10 = bVar.ajU;
        if (i10 > 0) {
            putBody("isPackageChanged", i10);
        }
        putBody("installedFrom", bVar.ajV);
        putBody("isChangedEndcard", bVar.ajX);
        int i11 = bVar.ait;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        String str2 = bVar.ajW;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!ba.isNullString(bVar.ajZ)) {
            putBody("installedPackageName", bVar.ajZ);
        }
        if (!ba.isNullString(bVar.ajY)) {
            putBody("serverPackageName", bVar.ajY);
        }
        int i12 = bVar.akb;
        if (i12 > 0) {
            putBody("closeButtonClickTime", i12);
        }
        int i13 = bVar.aka;
        if (i13 > 0) {
            putBody("closeButtonImpressionTime", i13);
        }
        int i14 = bVar.oz;
        if (i14 >= 0) {
            putBody("downloadStatus", i14);
        }
        long j2 = bVar.akc;
        if (j2 > 0) {
            putBody("landingPageLoadedDuration", j2);
        }
        long j3 = bVar.Jz;
        if (j3 > 0) {
            putBody("leaveTime", j3);
        }
        long j4 = bVar.akd;
        if (j4 > 0) {
            putBody("adItemClickBackDuration", j4);
        }
        int i15 = bVar.ajP;
        if (i15 != -1) {
            putBody("retainCodeType", i15);
        }
        long j5 = bVar.ajM;
        if (j5 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j5);
        }
        int i16 = bVar.ajN;
        if (i16 >= 0) {
            putBody("impFailReason", i16);
        }
        long j6 = bVar.ajO;
        if (j6 > -1) {
            putBody("winEcpm", j6);
        }
        int i17 = bVar.adnType;
        if (i17 > 0) {
            putBody("adnType", i17);
        }
        if (!TextUtils.isEmpty(bVar.adnName)) {
            putBody(RewardItem.KEY_ADN_NAME, bVar.adnName);
        }
        putBody("downloadCardType", bVar.akg);
        putBody("landingPageType", bVar.aki);
        int i18 = bVar.akl;
        if (i18 >= 0) {
            putBody("adInterstitialSource", i18);
        }
        int i19 = bVar.ako;
        if (i19 > 0) {
            putBody("downloadInstallType", i19);
        }
        int i20 = bVar.akq;
        if (i20 != 0) {
            putBody("fingerSwipeType", i20);
        }
        int i21 = bVar.akr;
        if (i21 != 0) {
            putBody("fingerSwipeDistance", i21);
        }
        int i22 = bVar.akp;
        if (i22 > 0) {
            putBody("businessSceneType", i22);
        }
        long j7 = bVar.vy;
        if (j7 > 0) {
            putBody("playedDuration", j7);
        }
        int i23 = bVar.akj;
        if (i23 > 0) {
            putBody("playedRate", i23);
        }
        int i24 = bVar.ake;
        if (i24 != -1) {
            putBody("appStorePageType", i24);
        }
        int i25 = bVar.aks;
        if (i25 != -1) {
            putBody("triggerType", i25);
        }
        int i26 = bVar.ajQ;
        if (i26 != 0) {
            putBody("photoSizeStyle", i26);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        String strReplaceFirst;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int i2 = this.ajy;
        if (i2 == 1) {
            strReplaceFirst = adInfoCb.adBaseInfo.showUrl.replaceFirst("__PR__", (this.mAdTemplate.mBidEcpm == 0 && ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sU()) ? String.valueOf(com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) : String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(strReplaceFirst, this.ajz);
        } else {
            if (i2 != 2) {
                strReplaceFirst = adInfoCb.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
                c(strReplaceFirst, this.ajz);
                A(this.ajA);
                return strReplaceFirst;
            }
            String strA = adInfoCb.adBaseInfo.clickUrl;
            if (this.ajz != null) {
                ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                strA = ab.a(strA, this.ajz.jU);
            }
            strReplaceFirst = ab.ag(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), strA).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(strReplaceFirst, this.ajz);
        }
        a(strReplaceFirst, this.mAdTemplate, this.ajz);
        A(this.ajA);
        return strReplaceFirst;
    }

    final List<String> xy() {
        ab.a aVar;
        AdInfo.AdTrackInfo next;
        b bVar;
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (!adInfoCb.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = adInfoCb.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.type == this.ajy && next.urls != null) {
                    break;
                }
            }
            if (next != null) {
                if (next.type == 2 && (bVar = this.ajz) != null) {
                    aVar = bVar.jU;
                }
                Iterator<String> it2 = next.urls.iterator();
                while (it2.hasNext()) {
                    arrayList.add(aa.a(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), it2.next(), aVar, com.kwad.sdk.core.response.a.a.au(adInfoCb)));
                }
            }
        }
        return arrayList;
    }
}
