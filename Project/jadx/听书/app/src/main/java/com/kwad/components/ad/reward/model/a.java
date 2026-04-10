package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private String liveStartTime;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String sW;
    private String sX;
    private String title;
    private List<String> uQ;
    private String uR;
    private String uS;
    private String uT;
    private boolean uU;
    private String uV;
    private String uW = "查看详情";
    private String uX = "立即预约";
    private List<String> uY;
    private AdTemplate uZ;

    public static a R(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo adInfoEl = e.el(adTemplate);
        AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfoEl);
        a aVar = new a();
        String name = adProductInfoCV.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ax(adInfoEl);
        }
        aVar.sW = adProductInfoCV.getIcon();
        aVar.sX = com.kwad.sdk.core.response.b.a.au(adInfoEl);
        aVar.price = adProductInfoCV.getPrice();
        aVar.originPrice = adProductInfoCV.getOriginPrice();
        if (!adProductInfoCV.isCouponListEmpty() && (firstCouponList = adProductInfoCV.getFirstCouponList()) != null) {
            aVar.T(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.S(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo adInfoEl = e.el(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cl(adInfoEl);
        aVar.sW = com.kwad.sdk.core.response.b.a.co(adInfoEl);
        aVar.sX = com.kwad.sdk.core.response.b.a.au(adInfoEl);
        aVar.uQ = com.kwad.sdk.core.response.b.d.ec(adTemplate);
        aVar.uR = com.kwad.sdk.core.response.b.a.aE(adInfoEl);
        aVar.playableStyle = e.l(adTemplate, z);
        aVar.uZ = adTemplate;
        aVar.mApkDownloadHelper = rVar.ij();
        return aVar;
    }

    public static a S(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDt = com.kwad.sdk.core.response.b.b.dt(adTemplate);
        a aVar = new a();
        aVar.sW = merchantLiveReservationInfoDt.userHeadUrl;
        aVar.liveStartTime = merchantLiveReservationInfoDt.liveStartTime;
        aVar.title = merchantLiveReservationInfoDt.title;
        aVar.uU = merchantLiveReservationInfoDt.needShowSubscriberCount();
        aVar.uV = merchantLiveReservationInfoDt.getFormattedLiveSubscribeCount();
        aVar.uY = merchantLiveReservationInfoDt.bookUserUrlList;
        aVar.uW = merchantLiveReservationInfoDt.playEndCard.detailBtnTitle;
        aVar.uX = merchantLiveReservationInfoDt.playEndCard.reservationBtnTitle;
        aVar.uZ = adTemplate;
        return aVar;
    }

    public final String ho() {
        return this.sW;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String hp() {
        return this.sX;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String ig() {
        return this.uT;
    }

    public final String ih() {
        return this.uS;
    }

    private void S(String str) {
        this.uS = str;
    }

    private void T(String str) {
        this.uT = str;
    }

    public final AdTemplate ii() {
        return this.uZ;
    }

    public final com.kwad.components.core.e.d.c ij() {
        return this.mApkDownloadHelper;
    }

    public final List<String> ik() {
        return this.uQ;
    }

    public final boolean il() {
        List<String> list = this.uQ;
        return list == null || list.size() == 0;
    }

    public final int im() {
        return this.playableStyle;
    }

    public final String in() {
        return this.uV;
    }

    public final String io() {
        return this.uX;
    }

    public final boolean ip() {
        return this.uU;
    }

    public final List<String> iq() {
        return this.uY;
    }

    public final String ir() {
        return this.liveStartTime;
    }
}
