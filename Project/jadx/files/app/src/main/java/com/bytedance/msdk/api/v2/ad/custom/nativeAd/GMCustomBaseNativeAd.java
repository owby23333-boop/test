package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.view.View;
import com.bytedance.msdk.api.v2.GMReceiveBidResultCallback;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GMCustomBaseNativeAd extends GMCustomAd {
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f14277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private double f14278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<String> f14279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f14280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f14282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private GMNativeAdAppInfo f14283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private double f14284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private GMReceiveBidResultCallback f14285s = new GMReceiveBidResultCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomBaseNativeAd.1
        @Override // com.bytedance.msdk.api.v2.GMReceiveBidResultCallback
        public void bidResult(boolean z2, double d2, int i2, Map<String, Object> map) {
            GMCustomBaseNativeAd.this.receiveBidResult(z2, d2, i2, map);
        }
    };

    public GMCustomBaseNativeAd() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.setGmReceiveBidResultCallback(this.f14285s);
        }
    }

    public String getActionText() {
        return this.f14274h;
    }

    public int getAdImageMode() {
        return this.f14281o;
    }

    public double getBiddingPrice() {
        return this.f14284r;
    }

    public String getDescription() {
        return this.f14269c;
    }

    public View getExpressView() {
        return null;
    }

    public String getIconUrl() {
        return this.f14270d;
    }

    public int getImageHeight() {
        return this.f14273g;
    }

    public List<String> getImageList() {
        return this.f14279m;
    }

    public String getImageUrl() {
        return this.f14271e;
    }

    public int getImageWidth() {
        return this.f14272f;
    }

    public int getInteractionType() {
        return this.f14282p;
    }

    public GMNativeAdAppInfo getNativeAdAppInfo() {
        return this.f14283q;
    }

    public String getPackageName() {
        return this.f14277k;
    }

    public String getSource() {
        return this.f14280n;
    }

    public double getStarRating() {
        return this.f14278l;
    }

    public String getTitle() {
        return this.b;
    }

    public int getVideoHeight() {
        return this.f14276j;
    }

    public String getVideoUrl() {
        return null;
    }

    public final String getVideoUrlInner() {
        try {
            return getVideoUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int getVideoWidth() {
        return this.f14275i;
    }

    public boolean isServerBidding() {
        return this.a.getAdNetworkSlotType() == 2;
    }

    public final boolean isUseCustomVideo() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            return gMCustomTTBaseAd.isUseCustomVideo();
        }
        return false;
    }

    public void receiveBidResult(boolean z2, double d2, int i2, Map<String, Object> map) {
    }

    public void setActionText(String str) {
        this.f14274h = str;
    }

    public void setAdImageMode(int i2) {
        this.f14281o = i2;
    }

    public void setBiddingPrice(double d2) {
        this.f14284r = d2;
    }

    public void setDescription(String str) {
        this.f14269c = str;
    }

    public final void setDislikeDialogCallBack(IGMCustomNativeDislikeDialog iGMCustomNativeDislikeDialog) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || iGMCustomNativeDislikeDialog == null) {
            return;
        }
        gMCustomTTBaseAd.setDislikeDialogCallBack(iGMCustomNativeDislikeDialog);
    }

    public void setExpressAd(boolean z2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.setExpressAd(z2);
        }
    }

    public void setIconUrl(String str) {
        this.f14270d = str;
    }

    public void setImageHeight(int i2) {
        this.f14273g = i2;
    }

    public void setImageList(List<String> list) {
        this.f14279m = list;
    }

    public void setImageUrl(String str) {
        this.f14271e = str;
    }

    public void setImageWidth(int i2) {
        this.f14272f = i2;
    }

    public void setInteractionType(int i2) {
        this.f14282p = i2;
    }

    public void setNativeAdAppInfo(GMNativeAdAppInfo gMNativeAdAppInfo) {
        this.f14283q = gMNativeAdAppInfo;
    }

    public void setPackageName(String str) {
        this.f14277k = str;
    }

    public void setSource(String str) {
        this.f14280n = str;
    }

    public void setStarRating(double d2) {
        this.f14278l = d2;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public void setVideoHeight(int i2) {
        this.f14276j = i2;
    }

    public void setVideoWidth(int i2) {
        this.f14275i = i2;
    }
}
