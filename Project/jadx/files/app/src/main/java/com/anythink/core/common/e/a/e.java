package com.anythink.core.common.e.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.l;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends BaseAd implements a, Serializable {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseAd f7105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f7106g;

    public e(BaseAd baseAd, Map<String, Object> map) {
        this.a = 1;
        this.b = 5;
        this.f7102c = 1;
        this.f7104e = 5;
        this.f7105f = baseAd;
        this.f7106g = map;
        Object obj = map.get("orientation");
        if (obj != null) {
            this.a = Integer.parseInt(obj.toString());
        }
        Object obj2 = map.get(com.anythink.expressad.d.a.b.dk);
        if (obj2 != null) {
            this.b = Integer.parseInt(obj2.toString());
        }
        Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.f7102c = Integer.parseInt(obj3.toString());
        }
        Object obj4 = map.get("button_type");
        if (obj4 != null) {
            this.f7103d = Integer.parseInt(obj4.toString());
        }
        Object obj5 = map.get("s_c_t");
        if (obj5 != null) {
            this.f7104e = Integer.parseInt(obj5.toString());
        }
    }

    private void a(Map<String, Object> map) {
        Object obj = map.get("orientation");
        if (obj != null) {
            this.a = Integer.parseInt(obj.toString());
        }
        Object obj2 = map.get(com.anythink.expressad.d.a.b.dk);
        if (obj2 != null) {
            this.b = Integer.parseInt(obj2.toString());
        }
        Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.f7102c = Integer.parseInt(obj3.toString());
        }
        Object obj4 = map.get("button_type");
        if (obj4 != null) {
            this.f7103d = Integer.parseInt(obj4.toString());
        }
        Object obj5 = map.get("s_c_t");
        if (obj5 != null) {
            this.f7104e = Integer.parseInt(obj5.toString());
        }
    }

    @Override // com.anythink.core.common.e.a.a
    public final long b() {
        return this.b;
    }

    @Override // com.anythink.core.common.e.a.a
    public final int c() {
        int i2 = this.f7102c;
        return (i2 != 1 && i2 == 0) ? 1 : 0;
    }

    @Override // com.anythink.core.common.e.a.a
    public final int d() {
        int i2 = this.f7103d;
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 != 3) {
        }
        return 2;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void destroy() {
        this.f7105f.destroy();
    }

    @Override // com.anythink.core.common.e.a.a
    public final int e() {
        return this.f7104e;
    }

    @Override // com.anythink.core.common.e.a.a
    public final int f() {
        Object obj;
        if (this.f7105f.getDetail() == null || this.f7105f.getDetail().H() != 8 || (obj = this.f7106g.get("video_muted")) == null) {
            return 0;
        }
        return TextUtils.equals(obj.toString(), "0") ? 1 : 0;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final ATAdAppInfo getAdAppInfo() {
        return this.f7105f.getAdAppInfo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdChoiceIconUrl() {
        return this.f7105f.getAdChoiceIconUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdFrom() {
        return this.f7105f.getAdFrom();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdIconView() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final Bitmap getAdLogo() {
        return this.f7105f.getAdLogo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdLogoView() {
        return this.f7105f.getAdLogoView();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdMediaView(Object... objArr) {
        return this.f7105f.getAdMediaView(objArr);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdType() {
        return this.f7105f.getAdType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdvertiserName() {
        return this.f7105f.getAdvertiserName();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getAppCommentNum() {
        return this.f7105f.getAppCommentNum();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAppDownloadButton() {
        return this.f7105f.getAppDownloadButton();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getAppPrice() {
        return this.f7105f.getAppPrice();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getCallToActionText() {
        return this.f7105f.getCallToActionText();
    }

    @Override // com.anythink.core.api.BaseAd
    public final ViewGroup getCustomAdContainer() {
        return this.f7105f.getCustomAdContainer();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getDescriptionText() {
        return this.f7105f.getDescriptionText();
    }

    @Override // com.anythink.core.api.BaseAd
    public final com.anythink.core.common.e.e getDetail() {
        return this.f7105f.getDetail();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getDomain() {
        BaseAd baseAd = this.f7105f;
        return baseAd != null ? baseAd.getDomain() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getIconImageUrl() {
        return this.f7105f.getIconImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final List<String> getImageUrlList() {
        return this.f7105f.getImageUrlList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageHeight() {
        return this.f7105f.getMainImageHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getMainImageUrl() {
        return this.f7105f.getMainImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageWidth() {
        return this.f7105f.getMainImageWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeAdInteractionType() {
        return this.f7105f.getNativeAdInteractionType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final ATCustomVideo getNativeCustomVideo() {
        return this.f7105f.getNativeCustomVideo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressHeight() {
        return this.f7105f.getNativeExpressHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressWidth() {
        return this.f7105f.getNativeExpressWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeType() {
        return this.f7105f.getNativeType();
    }

    @Override // com.anythink.core.api.BaseAd, com.anythink.core.api.IATThirdPartyMaterial
    public final Map<String, Object> getNetworkInfoMap() {
        return this.f7105f.getNetworkInfoMap();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getShakeView(int i2, int i3, ATShakeViewListener aTShakeViewListener) {
        BaseAd baseAd = this.f7105f;
        if (baseAd != null) {
            return baseAd.getShakeView(i2, i3, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final Double getStarRating() {
        return this.f7105f.getStarRating();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getTitle() {
        return this.f7105f.getTitle();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoDuration() {
        return this.f7105f.getVideoDuration();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoHeight() {
        return this.f7105f.getVideoHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoProgress() {
        return this.f7105f.getVideoProgress();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getVideoUrl() {
        return this.f7105f.getVideoUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoWidth() {
        return this.f7105f.getVideoWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getWarning() {
        BaseAd baseAd = this.f7105f;
        return baseAd != null ? baseAd.getWarning() : "";
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams) {
        this.f7105f.registerListener(view, list, layoutParams);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNativeEventListener(l lVar) {
        this.f7105f.setNativeEventListener(lVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNetworkInfoMap(Map<String, Object> map) {
        this.f7105f.setNetworkInfoMap(map);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(com.anythink.core.common.e.e eVar) {
        this.f7105f.setTrackingInfo(eVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setVideoMute(boolean z2) {
        this.f7105f.setVideoMute(z2);
    }

    @Override // com.anythink.core.common.e.a.a
    public final int a() {
        return this.a;
    }
}
