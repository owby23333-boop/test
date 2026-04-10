package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.v;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private String liveStartTime;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private String originPrice;
    private String os;
    private int playableStyle;
    private String price;
    private String qM;
    private List<String> sb;
    private String sc;
    private String sd;
    private String se;
    private boolean sf;
    private String sg;
    private String sh = "查看详情";
    private String si = "立即预约";
    private List<String> sj;

    @Nullable
    private AdTemplate sk;
    private String title;

    private void T(String str) {
        this.sd = str;
    }

    private void U(String str) {
        this.se = str;
    }

    @Nullable
    public static a a(v vVar, boolean z2) {
        AdTemplate adTemplate;
        if (vVar == null || (adTemplate = vVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo adInfoCb = d.cb(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.a.a.bJ(adInfoCb);
        aVar.os = com.kwad.sdk.core.response.a.a.bL(adInfoCb);
        aVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
        aVar.sb = com.kwad.sdk.core.response.a.c.bS(adTemplate);
        aVar.sc = com.kwad.sdk.core.response.a.a.ax(adInfoCb);
        aVar.playableStyle = d.h(adTemplate, z2);
        aVar.sk = adTemplate;
        aVar.mApkDownloadHelper = vVar.fx();
        return aVar;
    }

    @Nullable
    public static a v(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo adInfoCb = d.cb(adTemplate);
        AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfoCb);
        a aVar = new a();
        aVar.title = adProductInfoCr.getName();
        if (TextUtils.isEmpty(aVar.title)) {
            aVar.title = com.kwad.sdk.core.response.a.a.aq(adInfoCb);
        }
        aVar.os = adProductInfoCr.getIcon();
        aVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
        aVar.price = adProductInfoCr.getPrice();
        aVar.originPrice = adProductInfoCr.getOriginPrice();
        if (!adProductInfoCr.isCouponListEmpty() && (firstCouponList = adProductInfoCr.getFirstCouponList()) != null) {
            aVar.U(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.T(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a w(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoBJ = com.kwad.sdk.core.response.a.b.bJ(adTemplate);
        a aVar = new a();
        aVar.os = merchantLiveReservationInfoBJ.userHeadUrl;
        aVar.liveStartTime = merchantLiveReservationInfoBJ.liveStartTime;
        aVar.title = merchantLiveReservationInfoBJ.title;
        aVar.sf = merchantLiveReservationInfoBJ.needShowSubscriberCount();
        aVar.sg = merchantLiveReservationInfoBJ.getFormattedLiveSubscribeCount();
        aVar.sj = merchantLiveReservationInfoBJ.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = merchantLiveReservationInfoBJ.playEndCard;
        aVar.sh = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.si = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.sk = adTemplate;
        return aVar;
    }

    public final String fo() {
        return this.os;
    }

    @Nullable
    public final com.kwad.components.core.d.b.c fx() {
        return this.mApkDownloadHelper;
    }

    public final String gE() {
        return this.qM;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String hA() {
        return this.liveStartTime;
    }

    public final String hq() {
        return this.se;
    }

    public final String hr() {
        return this.sd;
    }

    @Nullable
    public final AdTemplate hs() {
        return this.sk;
    }

    public final List<String> ht() {
        return this.sb;
    }

    public final boolean hu() {
        List<String> list = this.sb;
        return list == null || list.size() == 0;
    }

    public final int hv() {
        return this.playableStyle;
    }

    public final String hw() {
        return this.sg;
    }

    public final String hx() {
        return this.si;
    }

    public final boolean hy() {
        return this.sf;
    }

    public final List<String> hz() {
        return this.sj;
    }
}
