package com.amgcyo.cuttadon.h.d.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.h.d.a;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAd;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.fatcatfat.io.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: AdBannerManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.amgcyo.cuttadon.h.d.a {
    private Activity b;

    /* JADX INFO: compiled from: AdBannerManager.java */
    class a implements GMBannerAdListener {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClicked() {
            e.this.a("onAdClicked");
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClosed() {
            e.this.a("onAdClosed:" + this.a);
            com.amgcyo.cuttadon.h.a.c.a(this.a, 0L);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdLeftApplication() {
            e.this.a("onAdLeftApplication");
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdOpened() {
            e.this.a("onAdOpened");
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShow() {
            e.this.a("onAdShow");
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShowFail(@NonNull AdError adError) {
            e.this.a(" onAdShowFail:" + adError.toString());
        }
    }

    /* JADX INFO: compiled from: AdBannerManager.java */
    class b extends GMNativeToBannerListener {
        final /* synthetic */ AdFrameLayout a;

        b(AdFrameLayout adFrameLayout) {
            this.a = adFrameLayout;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener
        public View getGMBannerViewFromNativeAd(GMNativeAdInfo gMNativeAdInfo) {
            return e.this.a(gMNativeAdInfo, this.a);
        }
    }

    /* JADX INFO: compiled from: AdBannerManager.java */
    class c implements GMBannerAdLoadCallback {
        final /* synthetic */ AdFrameLayout a;
        final /* synthetic */ GMBannerAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.d.c f3907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3908d;

        c(AdFrameLayout adFrameLayout, GMBannerAd gMBannerAd, com.amgcyo.cuttadon.h.d.c cVar, String str) {
            this.a = adFrameLayout;
            this.b = gMBannerAd;
            this.f3907c = cVar;
            this.f3908d = str;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public void onAdFailedToLoad(@NonNull AdError adError) {
            String str = "gromore banner error:" + adError.toString();
            e.this.a(adError.toString());
            AdFrameLayout adFrameLayout = this.a;
            if (adFrameLayout != null) {
                adFrameLayout.a(adError.message, adError.code);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public void onAdLoaded() {
            this.a.setVisibility(0);
            e.this.a("onAdLoaded");
            this.a.removeAllViews();
            View bannerView = this.b.getBannerView();
            com.amgcyo.cuttadon.h.d.c cVar = this.f3907c;
            if (cVar != null) {
                cVar.a(this.b);
            }
            if (bannerView != null) {
                this.a.addView(bannerView);
            }
            com.amgcyo.cuttadon.h.a.c.c(this.f3908d);
        }
    }

    public e(Activity activity) {
        this.b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private void b(NormalAdParams normalAdParams, com.amgcyo.cuttadon.h.d.c cVar, AdFrameLayout adFrameLayout) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        if (adWidth <= 0) {
            adWidth = (int) UIUtils.getScreenWidthDp(this.b);
        }
        int adHeight = normalAdParams.getAdHeight();
        if (adHeight <= 0) {
            adHeight = 54;
        }
        String str = adWidth + " " + adHeight;
        GMBannerAd gMBannerAd = new GMBannerAd(this.b, adUnitId);
        String stochasticKey = normalAdParams.getStochasticKey();
        gMBannerAd.setAdBannerListener(new a(stochasticKey));
        gMBannerAd.setNativeToBannerListener(new b(adFrameLayout));
        gMBannerAd.loadAd(new GMAdSlotBanner.Builder().setBannerSize(6).setImageAdSize(adWidth, adHeight).setAllowShowCloseBtn(true).setBidNotify(true).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().setNativeAdLogoParams(new FrameLayout.LayoutParams(UIUtils.dip2px(this.b.getApplicationContext(), 40.0f), UIUtils.dip2px(this.b.getApplicationContext(), 13.0f), 53)).build()).setAdmobNativeAdOptions(GMAdOptionUtil.getAdmobNativeAdOptions()).setMuted(true).build(), new c(adFrameLayout, gMBannerAd, cVar, stochasticKey));
    }

    private View c(@NonNull GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_large_pic, (ViewGroup) null, false);
        a.d dVar = new a.d();
        dVar.f3880d = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_title);
        dVar.f3881e = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_desc);
        dVar.f3882f = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_source);
        dVar.f3894o = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image);
        dVar.a = (ImageView) viewInflate.findViewById(R.id.iv_listitem_icon);
        dVar.b = (ImageView) viewInflate.findViewById(R.id.iv_listitem_dislike);
        dVar.f3879c = (Button) viewInflate.findViewById(R.id.btn_listitem_creative);
        dVar.f3883g = (LinearLayout) viewInflate.findViewById(R.id.app_info);
        dVar.f3884h = (TextView) viewInflate.findViewById(R.id.app_name);
        dVar.f3885i = (TextView) viewInflate.findViewById(R.id.author_name);
        dVar.f3886j = (TextView) viewInflate.findViewById(R.id.package_size);
        dVar.f3887k = (TextView) viewInflate.findViewById(R.id.permissions_url);
        dVar.f3890n = (TextView) viewInflate.findViewById(R.id.permissions_content);
        dVar.f3888l = (TextView) viewInflate.findViewById(R.id.privacy_agreement);
        dVar.f3889m = (TextView) viewInflate.findViewById(R.id.version_name);
        a(adFrameLayout, viewInflate, dVar, gMNativeAdInfo, new GMViewBinder.Builder(R.layout.listitem_ad_large_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).sourceId(R.id.tv_listitem_ad_source).mainImageId(R.id.iv_listitem_image).callToActionId(R.id.btn_listitem_creative).logoLayoutId(R.id.tt_ad_logo).iconImageId(R.id.iv_listitem_icon).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAdInfo.getImageUrl()).into(dVar.f3894o);
        }
        return viewInflate;
    }

    private View d(@NonNull GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_small_pic, (ViewGroup) null, false);
        a.e eVar = new a.e();
        eVar.f3880d = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_title);
        eVar.f3882f = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_source);
        eVar.f3881e = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_desc);
        eVar.f3895o = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image);
        eVar.a = (ImageView) viewInflate.findViewById(R.id.iv_listitem_icon);
        eVar.b = (ImageView) viewInflate.findViewById(R.id.iv_listitem_dislike);
        eVar.f3879c = (Button) viewInflate.findViewById(R.id.btn_listitem_creative);
        eVar.f3883g = (LinearLayout) viewInflate.findViewById(R.id.app_info);
        eVar.f3884h = (TextView) viewInflate.findViewById(R.id.app_name);
        eVar.f3885i = (TextView) viewInflate.findViewById(R.id.author_name);
        eVar.f3886j = (TextView) viewInflate.findViewById(R.id.package_size);
        eVar.f3887k = (TextView) viewInflate.findViewById(R.id.permissions_url);
        eVar.f3890n = (TextView) viewInflate.findViewById(R.id.permissions_content);
        eVar.f3888l = (TextView) viewInflate.findViewById(R.id.privacy_agreement);
        eVar.f3889m = (TextView) viewInflate.findViewById(R.id.version_name);
        a(adFrameLayout, viewInflate, eVar, gMNativeAdInfo, new GMViewBinder.Builder(R.layout.listitem_ad_small_pic).titleId(R.id.tv_listitem_ad_title).sourceId(R.id.tv_listitem_ad_source).descriptionTextId(R.id.tv_listitem_ad_desc).mainImageId(R.id.iv_listitem_image).logoLayoutId(R.id.tt_ad_logo).callToActionId(R.id.btn_listitem_creative).iconImageId(R.id.iv_listitem_icon).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAdInfo.getImageUrl()).into(eVar.f3895o);
        }
        return viewInflate;
    }

    private View e(@NonNull GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_vertical_pic, (ViewGroup) null, false);
        a.f fVar = new a.f();
        fVar.f3880d = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_title);
        fVar.f3882f = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_source);
        fVar.f3881e = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_desc);
        fVar.f3896o = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image);
        fVar.a = (ImageView) viewInflate.findViewById(R.id.iv_listitem_icon);
        fVar.b = (ImageView) viewInflate.findViewById(R.id.iv_listitem_dislike);
        fVar.f3879c = (Button) viewInflate.findViewById(R.id.btn_listitem_creative);
        fVar.f3883g = (LinearLayout) viewInflate.findViewById(R.id.app_info);
        fVar.f3884h = (TextView) viewInflate.findViewById(R.id.app_name);
        fVar.f3885i = (TextView) viewInflate.findViewById(R.id.author_name);
        fVar.f3886j = (TextView) viewInflate.findViewById(R.id.package_size);
        fVar.f3887k = (TextView) viewInflate.findViewById(R.id.permissions_url);
        fVar.f3890n = (TextView) viewInflate.findViewById(R.id.permissions_content);
        fVar.f3888l = (TextView) viewInflate.findViewById(R.id.privacy_agreement);
        fVar.f3889m = (TextView) viewInflate.findViewById(R.id.version_name);
        a(adFrameLayout, viewInflate, fVar, gMNativeAdInfo, new GMViewBinder.Builder(R.layout.listitem_ad_vertical_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).mainImageId(R.id.iv_listitem_image).iconImageId(R.id.iv_listitem_icon).callToActionId(R.id.btn_listitem_creative).sourceId(R.id.tv_listitem_ad_source).logoLayoutId(R.id.tt_ad_logo).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAdInfo.getImageUrl()).into(fVar.f3896o);
        }
        return viewInflate;
    }

    private View f(@NonNull GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        View viewInflate = null;
        try {
            viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_large_video, (ViewGroup) null, false);
            a.g gVar = new a.g();
            gVar.f3880d = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_title);
            gVar.f3881e = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_desc);
            gVar.f3882f = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_source);
            gVar.f3897o = (FrameLayout) viewInflate.findViewById(R.id.iv_listitem_video);
            gVar.a = (ImageView) viewInflate.findViewById(R.id.iv_listitem_icon);
            gVar.b = (ImageView) viewInflate.findViewById(R.id.iv_listitem_dislike);
            gVar.f3879c = (Button) viewInflate.findViewById(R.id.btn_listitem_creative);
            gVar.f3883g = (LinearLayout) viewInflate.findViewById(R.id.app_info);
            gVar.f3884h = (TextView) viewInflate.findViewById(R.id.app_name);
            gVar.f3885i = (TextView) viewInflate.findViewById(R.id.author_name);
            gVar.f3886j = (TextView) viewInflate.findViewById(R.id.package_size);
            gVar.f3887k = (TextView) viewInflate.findViewById(R.id.permissions_url);
            gVar.f3890n = (TextView) viewInflate.findViewById(R.id.permissions_content);
            gVar.f3888l = (TextView) viewInflate.findViewById(R.id.privacy_agreement);
            gVar.f3889m = (TextView) viewInflate.findViewById(R.id.version_name);
            a(adFrameLayout, viewInflate, gVar, gMNativeAdInfo, new GMViewBinder.Builder(R.layout.listitem_ad_large_video).titleId(R.id.tv_listitem_ad_title).sourceId(R.id.tv_listitem_ad_source).descriptionTextId(R.id.tv_listitem_ad_desc).mediaViewIdId(R.id.iv_listitem_video).callToActionId(R.id.btn_listitem_creative).logoLayoutId(R.id.tt_ad_logo).iconImageId(R.id.iv_listitem_icon).build());
            return viewInflate;
        } catch (Exception e2) {
            e2.printStackTrace();
            return viewInflate;
        }
    }

    public void a(NormalAdParams normalAdParams, com.amgcyo.cuttadon.h.d.c cVar, AdFrameLayout adFrameLayout) {
        b(normalAdParams, cVar, adFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        if (this.b == null || gMNativeAdInfo == null) {
            return null;
        }
        if (gMNativeAdInfo.getAdImageMode() == 2) {
            return d(gMNativeAdInfo, adFrameLayout);
        }
        if (gMNativeAdInfo.getAdImageMode() == 3) {
            return c(gMNativeAdInfo, adFrameLayout);
        }
        if (gMNativeAdInfo.getAdImageMode() == 4) {
            return b(gMNativeAdInfo, adFrameLayout);
        }
        if (gMNativeAdInfo.getAdImageMode() == 5) {
            return f(gMNativeAdInfo, adFrameLayout);
        }
        if (gMNativeAdInfo.getAdImageMode() == 16) {
            return e(gMNativeAdInfo, adFrameLayout);
        }
        if (gMNativeAdInfo.getAdImageMode() == 15) {
            return f(gMNativeAdInfo, adFrameLayout);
        }
        a("图片展示样式错误");
        return null;
    }

    private void a(final AdFrameLayout adFrameLayout, View view, a.C0096a c0096a, GMNativeAdInfo gMNativeAdInfo, GMViewBinder gMViewBinder) {
        if (gMNativeAdInfo.hasDislike()) {
            final GMAdDislike dislikeDialog = gMNativeAdInfo.getDislikeDialog(this.b);
            c0096a.b.setVisibility(0);
            c0096a.b.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.h.d.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f3898s.a(dislikeDialog, adFrameLayout, view2);
                }
            });
        } else {
            ImageView imageView = c0096a.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        a(gMNativeAdInfo, c0096a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(c0096a.f3882f);
        arrayList.add(c0096a.f3880d);
        arrayList.add(c0096a.f3881e);
        arrayList.add(c0096a.a);
        if (c0096a instanceof a.d) {
            arrayList.add(((a.d) c0096a).f3894o);
        } else if (c0096a instanceof a.e) {
            arrayList.add(((a.e) c0096a).f3895o);
        } else if (c0096a instanceof a.f) {
            arrayList.add(((a.f) c0096a).f3896o);
        } else if (c0096a instanceof a.g) {
            arrayList.add(((a.g) c0096a).f3897o);
        } else if (c0096a instanceof a.c) {
            a.c cVar = (a.c) c0096a;
            arrayList.add(cVar.f3891o);
            arrayList.add(cVar.f3892p);
            arrayList.add(cVar.f3893q);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(c0096a.f3879c);
        gMNativeAdInfo.registerView(this.b, (ViewGroup) view, arrayList, arrayList2, gMViewBinder);
        c0096a.f3880d.setText(gMNativeAdInfo.getTitle());
        c0096a.f3881e.setText(gMNativeAdInfo.getDescription());
        c0096a.f3882f.setText(TextUtils.isEmpty(gMNativeAdInfo.getSource()) ? "广告来源" : gMNativeAdInfo.getSource());
        String iconUrl = gMNativeAdInfo.getIconUrl();
        if (iconUrl != null) {
            com.bumptech.glide.c.a(this.b).mo58load(iconUrl).into(c0096a.a);
        }
        Button button = c0096a.f3879c;
        int interactionType = gMNativeAdInfo.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAdInfo.getActionText()) ? "查看详情" : gMNativeAdInfo.getActionText());
        } else if (interactionType == 4) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAdInfo.getActionText()) ? "立即下载" : gMNativeAdInfo.getActionText());
        } else if (interactionType != 5) {
            button.setVisibility(8);
            a("交互类型异常");
        } else {
            button.setVisibility(0);
            button.setText("立即拨打");
        }
    }

    private View b(@NonNull GMNativeAdInfo gMNativeAdInfo, AdFrameLayout adFrameLayout) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_group_pic, (ViewGroup) null, false);
        a.c cVar = new a.c();
        cVar.f3880d = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_title);
        cVar.f3882f = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_source);
        cVar.f3881e = (TextView) viewInflate.findViewById(R.id.tv_listitem_ad_desc);
        cVar.f3891o = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image1);
        cVar.f3892p = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image2);
        cVar.f3893q = (ImageView) viewInflate.findViewById(R.id.iv_listitem_image3);
        cVar.a = (ImageView) viewInflate.findViewById(R.id.iv_listitem_icon);
        cVar.b = (ImageView) viewInflate.findViewById(R.id.iv_listitem_dislike);
        cVar.f3879c = (Button) viewInflate.findViewById(R.id.btn_listitem_creative);
        cVar.f3883g = (LinearLayout) viewInflate.findViewById(R.id.app_info);
        cVar.f3884h = (TextView) viewInflate.findViewById(R.id.app_name);
        cVar.f3885i = (TextView) viewInflate.findViewById(R.id.author_name);
        cVar.f3886j = (TextView) viewInflate.findViewById(R.id.package_size);
        cVar.f3887k = (TextView) viewInflate.findViewById(R.id.permissions_url);
        cVar.f3890n = (TextView) viewInflate.findViewById(R.id.permissions_content);
        cVar.f3888l = (TextView) viewInflate.findViewById(R.id.privacy_agreement);
        cVar.f3889m = (TextView) viewInflate.findViewById(R.id.version_name);
        a(adFrameLayout, viewInflate, cVar, gMNativeAdInfo, new TTViewBinder.Builder(R.layout.listitem_ad_group_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).sourceId(R.id.tv_listitem_ad_source).mainImageId(R.id.iv_listitem_image1).logoLayoutId(R.id.tt_ad_logo).callToActionId(R.id.btn_listitem_creative).iconImageId(R.id.iv_listitem_icon).groupImage1Id(R.id.iv_listitem_image1).groupImage2Id(R.id.iv_listitem_image2).groupImage3Id(R.id.iv_listitem_image3).build());
        if (gMNativeAdInfo.getImageList() != null && gMNativeAdInfo.getImageList().size() >= 3) {
            String str = gMNativeAdInfo.getImageList().get(0);
            String str2 = gMNativeAdInfo.getImageList().get(1);
            String str3 = gMNativeAdInfo.getImageList().get(2);
            if (str != null) {
                com.bumptech.glide.c.a(this.b).mo58load(str).into(cVar.f3891o);
            }
            if (str2 != null) {
                com.bumptech.glide.c.a(this.b).mo58load(str2).into(cVar.f3892p);
            }
            if (str3 != null) {
                com.bumptech.glide.c.a(this.b).mo58load(str3).into(cVar.f3893q);
            }
        }
        return viewInflate;
    }

    public /* synthetic */ void a(GMAdDislike gMAdDislike, AdFrameLayout adFrameLayout, View view) {
        if (gMAdDislike != null) {
            gMAdDislike.showDislikeDialog();
            gMAdDislike.setDislikeCallback(new f(this, adFrameLayout));
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void a(GMNativeAdInfo gMNativeAdInfo, a.C0096a c0096a) {
        if (c0096a == null) {
            return;
        }
        if (gMNativeAdInfo != null && gMNativeAdInfo.getNativeAdAppInfo() != null) {
            c0096a.f3883g.setVisibility(0);
            GMNativeAdAppInfo nativeAdAppInfo = gMNativeAdInfo.getNativeAdAppInfo();
            c0096a.f3884h.setText("应用名称：" + nativeAdAppInfo.getAppName());
            c0096a.f3885i.setText("开发者：" + nativeAdAppInfo.getAuthorName());
            c0096a.f3886j.setText("包大小：" + nativeAdAppInfo.getPackageSizeBytes());
            c0096a.f3887k.setText("权限url:" + nativeAdAppInfo.getPermissionsUrl());
            c0096a.f3888l.setText("隐私url：" + nativeAdAppInfo.getPrivacyAgreement());
            c0096a.f3889m.setText("版本号：" + nativeAdAppInfo.getVersionName());
            c0096a.f3890n.setText("权限内容:" + a(nativeAdAppInfo.getPermissionsMap()));
            return;
        }
        c0096a.f3883g.setVisibility(8);
    }
}
