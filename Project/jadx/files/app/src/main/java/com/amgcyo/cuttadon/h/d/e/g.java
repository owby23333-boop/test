package com.amgcyo.cuttadon.h.d.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.h.d.a;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMUnifiedNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdFeedManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.amgcyo.cuttadon.h.d.a {
    private Activity b;

    /* JADX INFO: compiled from: AdFeedManager.java */
    class a implements GMNativeAdLoadCallback {
        final /* synthetic */ NormalAdParams a;
        final /* synthetic */ AdFrameLayout b;

        a(NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
            this.a = normalAdParams;
            this.b = adFrameLayout;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public void onAdLoaded(@NonNull List<GMNativeAd> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                return;
            }
            ((com.amgcyo.cuttadon.h.d.a) g.this).a = this.a.getStochasticKey();
            g.this.a(list.get(0), this.b);
            if (this.b.getVisibility() == 8) {
                this.b.setVisibility(0);
            }
            com.amgcyo.cuttadon.h.a.c.c(((com.amgcyo.cuttadon.h.d.a) g.this).a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public void onAdLoadedFail(@NonNull AdError adError) {
            String str = "gromore banner error:" + adError.toString();
            AdFrameLayout adFrameLayout = this.b;
            if (adFrameLayout != null) {
                adFrameLayout.a(adError.message, adError.code);
            }
        }
    }

    /* JADX INFO: compiled from: AdFeedManager.java */
    class b implements GMDislikeCallback {
        final /* synthetic */ FrameLayout a;

        b(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onCancel() {
            g.this.a("dislike 点击了取消");
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onSelected(int i2, String str) {
            g.this.a("点击：" + str);
            g.this.a(this.a);
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onShow() {
        }
    }

    /* JADX INFO: compiled from: AdFeedManager.java */
    class c implements GMNativeExpressAdListener {
        final /* synthetic */ a.b a;
        final /* synthetic */ GMNativeAd b;

        c(a.b bVar, GMNativeAd gMNativeAd) {
            this.a = bVar;
            this.b = gMNativeAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            g.this.a("模板广告被点击");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            g.this.a("模板广告show");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderFail(View view, String str, int i2) {
            g.this.a("模板广告渲染失败code=" + i2 + ",msg=" + str);
            String str2 = "onRenderFail   code=" + i2 + ",msg=" + str;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderSuccess(float f2, float f3) {
            int i2;
            int i3;
            g.this.a("模板广告渲染成功:width=" + f2 + ",height=" + f3);
            if (this.a.a != null) {
                View expressView = this.b.getExpressView();
                if (f2 == -1.0f && f3 == -2.0f) {
                    i3 = -1;
                    i2 = -2;
                } else {
                    int screenWidth = UIUtils.getScreenWidth(g.this.b);
                    i2 = (int) ((screenWidth * f3) / f2);
                    i3 = screenWidth;
                }
                if (expressView != null) {
                    UIUtils.removeFromParent(expressView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i2);
                    this.a.a.removeAllViews();
                    this.a.a.addView(expressView, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: compiled from: AdFeedManager.java */
    class d implements GMVideoListener {
        d() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            String str = "onProgressUpdate  current:" + j2 + "  duration: " + j3;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            g.this.a("模板播放完成");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(@NotNull AdError adError) {
            g.this.a("模板广告视频播放出错");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            g.this.a("模板广告视频暂停");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            g.this.a("模板广告视频继续播放");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            g.this.a("模板广告视频开始播放");
        }
    }

    /* JADX INFO: compiled from: AdFeedManager.java */
    class e implements GMVideoListener {
        e() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            g.this.a("广告视频播放进度");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            g.this.a("广告播放完成");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(@NotNull AdError adError) {
            g.this.a("广告视频播放出错");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            g.this.a("广告视频暂停");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            g.this.a("广告视频继续播放");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            g.this.a("广告视频开始播放");
        }
    }

    /* JADX INFO: compiled from: AdFeedManager.java */
    class f implements GMAdAppDownloadListener {
        f() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            g.this.a("下载失败回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            g.this.a("安装完成回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            g.this.a("下载暂停回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadProgress(long j2, long j3, int i2, int i3) {
            g.this.a("下载中回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadStarted() {
            g.this.a("开始下载");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onIdle() {
            g.this.a("未开始下载");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onInstalled(String str, String str2) {
            g.this.a("下载完成回调");
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.d.e.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdFeedManager.java */
    class C0098g implements GMNativeAdListener {
        C0098g() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            g.this.a("自渲染广告被点击");
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            g.this.a("广告展示");
        }
    }

    public g(Activity activity) {
        this.b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private View c(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_large_pic, (ViewGroup) frameLayout, false);
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
        a(frameLayout, viewInflate, dVar, gMNativeAd, new GMViewBinder.Builder(R.layout.listitem_ad_large_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).sourceId(R.id.tv_listitem_ad_source).mainImageId(R.id.iv_listitem_image).callToActionId(R.id.btn_listitem_creative).logoLayoutId(R.id.tt_ad_logo).iconImageId(R.id.iv_listitem_icon).build());
        if (gMNativeAd.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAd.getImageUrl()).into(dVar.f3894o);
        }
        return viewInflate;
    }

    private View d(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_small_pic, (ViewGroup) frameLayout, false);
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
        a(frameLayout, viewInflate, eVar, gMNativeAd, new GMViewBinder.Builder(R.layout.listitem_ad_small_pic).titleId(R.id.tv_listitem_ad_title).sourceId(R.id.tv_listitem_ad_source).descriptionTextId(R.id.tv_listitem_ad_desc).mainImageId(R.id.iv_listitem_image).logoLayoutId(R.id.tt_ad_logo).callToActionId(R.id.btn_listitem_creative).iconImageId(R.id.iv_listitem_icon).build());
        if (gMNativeAd.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAd.getImageUrl()).into(eVar.f3895o);
        }
        return viewInflate;
    }

    private View e(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_vertical_pic, (ViewGroup) frameLayout, false);
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
        a(frameLayout, viewInflate, fVar, gMNativeAd, new GMViewBinder.Builder(R.layout.listitem_ad_vertical_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).mainImageId(R.id.iv_listitem_image).iconImageId(R.id.iv_listitem_icon).callToActionId(R.id.btn_listitem_creative).sourceId(R.id.tv_listitem_ad_source).logoLayoutId(R.id.tt_ad_logo).build());
        if (gMNativeAd.getImageUrl() != null) {
            com.bumptech.glide.c.a(this.b).mo58load(gMNativeAd.getImageUrl()).into(fVar.f3896o);
        }
        return viewInflate;
    }

    private View f(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = null;
        try {
            viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_large_video, (ViewGroup) frameLayout, false);
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
            GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R.layout.listitem_ad_large_video).titleId(R.id.tv_listitem_ad_title).sourceId(R.id.tv_listitem_ad_source).descriptionTextId(R.id.tv_listitem_ad_desc).mediaViewIdId(R.id.iv_listitem_video).callToActionId(R.id.btn_listitem_creative).logoLayoutId(R.id.tt_ad_logo).iconImageId(R.id.iv_listitem_icon).build();
            gMNativeAd.setUseCustomVideo(true);
            String videoUrl = gMNativeAd.getVideoUrl();
            if (!TextUtils.isEmpty(videoUrl)) {
                a(gMNativeAd, gVar.f3897o, videoUrl);
            }
            gMNativeAd.setVideoListener(new e());
            gMNativeAd.setAppDownloadListener(new f());
            a(frameLayout, viewInflate, gVar, gMNativeAd, gMViewBinderBuild);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return viewInflate;
    }

    private void b(NormalAdParams normalAdParams, com.amgcyo.cuttadon.h.d.c cVar, AdFrameLayout adFrameLayout) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        if (adWidth <= 0) {
            adWidth = (int) UIUtils.getScreenWidthDp(this.b);
        }
        int adHeight = normalAdParams.getAdHeight();
        String str = adWidth + " " + adHeight + " " + n.b(adHeight);
        new GMUnifiedNativeAd(this.b, adUnitId).loadAd(new GMAdSlotNative.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().setNativeAdLogoParams(new FrameLayout.LayoutParams(UIUtils.dip2px(this.b.getApplicationContext(), 40.0f), UIUtils.dip2px(this.b.getApplicationContext(), 13.0f), 53)).build()).setAdmobNativeAdOptions(GMAdOptionUtil.getAdmobNativeAdOptions()).setAdStyleType(normalAdParams.getStyleType()).setImageAdSize(adWidth, adHeight).setAdCount(normalAdParams.getAdCount()).setBidNotify(true).build(), new a(normalAdParams, adFrameLayout));
    }

    public void a(NormalAdParams normalAdParams, com.amgcyo.cuttadon.h.d.c cVar, AdFrameLayout adFrameLayout) {
        b(normalAdParams, cVar, adFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GMNativeAd gMNativeAd, FrameLayout frameLayout) {
        View viewF;
        a("是否模板广告：" + gMNativeAd.isExpressAd());
        if (gMNativeAd.isExpressAd()) {
            viewF = a(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 2) {
            viewF = d(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 3) {
            viewF = c(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 4) {
            viewF = b(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 5) {
            viewF = f(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 16) {
            viewF = e(frameLayout, gMNativeAd);
        } else if (gMNativeAd.getAdImageMode() == 15) {
            viewF = f(frameLayout, gMNativeAd);
        } else {
            a("图片展示样式错误");
            viewF = null;
        }
        if (viewF != null) {
            viewF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.removeAllViews();
            frameLayout.addView(viewF);
        }
    }

    private View a(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = null;
        try {
            viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_native_express, (ViewGroup) frameLayout, false);
            a.b bVar = new a.b();
            bVar.a = (FrameLayout) viewInflate.findViewById(R.id.iv_listitem_express);
            viewInflate.setTag(bVar);
            if (gMNativeAd.hasDislike()) {
                gMNativeAd.setDislikeCallback(this.b, new b(frameLayout));
            }
            gMNativeAd.setNativeAdListener(new c(bVar, gMNativeAd));
            gMNativeAd.setVideoListener(new d());
            gMNativeAd.render();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return viewInflate;
    }

    private View b(FrameLayout frameLayout, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.listitem_ad_group_pic, (ViewGroup) frameLayout, false);
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
        a(frameLayout, viewInflate, cVar, gMNativeAd, new TTViewBinder.Builder(R.layout.listitem_ad_group_pic).titleId(R.id.tv_listitem_ad_title).descriptionTextId(R.id.tv_listitem_ad_desc).sourceId(R.id.tv_listitem_ad_source).mainImageId(R.id.iv_listitem_image1).logoLayoutId(R.id.tt_ad_logo).callToActionId(R.id.btn_listitem_creative).iconImageId(R.id.iv_listitem_icon).groupImage1Id(R.id.iv_listitem_image1).groupImage2Id(R.id.iv_listitem_image2).groupImage3Id(R.id.iv_listitem_image3).build());
        if (gMNativeAd.getImageList() != null && gMNativeAd.getImageList().size() >= 3) {
            String str = gMNativeAd.getImageList().get(0);
            String str2 = gMNativeAd.getImageList().get(1);
            String str3 = gMNativeAd.getImageList().get(2);
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

    private void a(GMNativeAd gMNativeAd, ViewGroup viewGroup, String str) {
        final VideoView videoView = new VideoView(this.b);
        viewGroup.addView(videoView);
        final GMNativeCustomVideoReporter gMNativeCustomVideoReporter = gMNativeAd.getGMNativeCustomVideoReporter();
        videoView.setVideoURI(Uri.parse(str));
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.amgcyo.cuttadon.h.d.e.c
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                return g.a(gMNativeCustomVideoReporter, videoView, mediaPlayer, i2, i3);
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.amgcyo.cuttadon.h.d.e.b
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                g.a(gMNativeCustomVideoReporter, mediaPlayer);
            }
        });
        videoView.start();
        if (gMNativeCustomVideoReporter != null) {
            gMNativeCustomVideoReporter.reportVideoStart();
        }
    }

    static /* synthetic */ boolean a(GMNativeCustomVideoReporter gMNativeCustomVideoReporter, VideoView videoView, MediaPlayer mediaPlayer, int i2, int i3) {
        if (gMNativeCustomVideoReporter == null) {
            return false;
        }
        gMNativeCustomVideoReporter.reportVideoError(videoView.getCurrentPosition(), i2, i3);
        return false;
    }

    static /* synthetic */ void a(GMNativeCustomVideoReporter gMNativeCustomVideoReporter, MediaPlayer mediaPlayer) {
        if (gMNativeCustomVideoReporter != null) {
            gMNativeCustomVideoReporter.reportVideoFinish();
        }
    }

    private void a(final FrameLayout frameLayout, View view, a.C0096a c0096a, GMNativeAd gMNativeAd, GMViewBinder gMViewBinder) {
        if (gMNativeAd.hasDislike()) {
            final GMAdDislike dislikeDialog = gMNativeAd.getDislikeDialog(this.b);
            if (dislikeDialog == null) {
                return;
            }
            c0096a.b.setVisibility(0);
            c0096a.b.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.h.d.e.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f3904s.a(dislikeDialog, frameLayout, view2);
                }
            });
        } else {
            ImageView imageView = c0096a.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        a(gMNativeAd, c0096a);
        gMNativeAd.setNativeAdListener(new C0098g());
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
        gMNativeAd.registerView(this.b, (ViewGroup) view, arrayList, arrayList2, gMViewBinder);
        c0096a.f3880d.setText(gMNativeAd.getTitle());
        c0096a.f3881e.setText(gMNativeAd.getDescription());
        c0096a.f3882f.setText(TextUtils.isEmpty(gMNativeAd.getSource()) ? "广告来源" : gMNativeAd.getSource());
        String iconUrl = gMNativeAd.getIconUrl();
        if (iconUrl != null) {
            com.bumptech.glide.c.a(this.b).mo58load(iconUrl).into(c0096a.a);
        }
        Button button = c0096a.f3879c;
        int interactionType = gMNativeAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAd.getActionText()) ? "查看详情" : gMNativeAd.getActionText());
        } else if (interactionType == 4) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAd.getActionText()) ? "立即下载" : gMNativeAd.getActionText());
        } else if (interactionType != 5) {
            button.setVisibility(8);
            a("交互类型异常");
        } else {
            button.setVisibility(0);
            button.setText("立即拨打");
        }
    }

    public /* synthetic */ void a(GMAdDislike gMAdDislike, FrameLayout frameLayout, View view) {
        gMAdDislike.showDislikeDialog();
        gMAdDislike.setDislikeCallback(new h(this, frameLayout));
    }

    @SuppressLint({"SetTextI18n"})
    private void a(GMNativeAd gMNativeAd, a.C0096a c0096a) {
        if (c0096a == null) {
            return;
        }
        if (gMNativeAd != null && gMNativeAd.getNativeAdAppInfo() != null) {
            c0096a.f3883g.setVisibility(0);
            GMNativeAdAppInfo nativeAdAppInfo = gMNativeAd.getNativeAdAppInfo();
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
