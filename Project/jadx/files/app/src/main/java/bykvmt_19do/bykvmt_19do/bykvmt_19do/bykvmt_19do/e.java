package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TToast;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMUnifiedNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.mtesttools.api.TTMediationTestTool;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTFeedAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g {
    private GMUnifiedNativeAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GMNativeAd f2077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewGroup f2078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    GMNativeAdListener f2080f = new h();

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class a implements GMNativeAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public void onAdLoaded(List<GMNativeAd> list) {
            if (list != null && list.size() > 0) {
                e.this.f2077c = list.get(0);
            }
            if (e.this.b == null) {
                return;
            }
            e.this.b.b("onAdLoaded", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdLoadCallback
        public void onAdLoadedFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdLoadedFail", adError);
            if (e.this.b == null) {
                return;
            }
            e.this.b.b("onAdLoadedFial", adError);
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class b implements GMDislikeCallback {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onCancel() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onSelected(int i2, String str) {
            e.this.h();
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onShow() {
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class c implements GMNativeExpressAdListener {
        final /* synthetic */ j a;
        final /* synthetic */ GMNativeAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f2081c;

        c(j jVar, GMNativeAd gMNativeAd, Context context) {
            this.a = jVar;
            this.b = gMNativeAd;
            this.f2081c = context;
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a(IAdInterListener.AdCommandType.AD_CLICK, e.this.f2079e, e.this.f2077c.getShowEcpm(), null);
            if (e.this.b == null) {
                return;
            }
            e.this.b.a(IAdInterListener.AdCommandType.AD_CLICK, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShow", e.this.f2079e, e.this.f2077c.getShowEcpm(), null);
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderFail(View view, String str, int i2) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRenderFail", new AdError(i2, str));
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onRenderFail", new AdError(i2, str));
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderSuccess(float f2, float f3) {
            int i2;
            int i3;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRenderSuccess", e.this.f2079e, e.this.f2077c.getShowEcpm(), null);
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onRenderSuccess", null);
            if (this.a.a != null) {
                View expressView = this.b.getExpressView();
                if (f2 == -1.0f && f3 == -2.0f) {
                    i3 = -1;
                    i2 = -2;
                } else {
                    int iA = e.this.a(this.f2081c);
                    i2 = (int) ((iA * f3) / f2);
                    i3 = iA;
                }
                if (expressView == null || expressView.getParent() != null) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i2);
                this.a.a.removeAllViews();
                this.a.a.addView(expressView, layoutParams);
            }
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class d implements GMVideoListener {
        d() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onProgressUpdate", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoCompleted", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(AdError adError) {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoError", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoPause", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoResume", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoStart", null);
        }
    }

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class C0067e implements GMVideoListener {
        C0067e() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onProgressUpdate", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoCompleted", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(AdError adError) {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoError", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoPause", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoResume", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onVideoStart", null);
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class f implements GMAdAppDownloadListener {
        final /* synthetic */ Context a;

        f(e eVar, Context context) {
            this.a = context;
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            TToast.show(this.a, "下载失败回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            TToast.show(this.a, "安装完成回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            TToast.show(this.a, "下载暂停回调");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadProgress(long j2, long j3, int i2, int i3) {
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onDownloadStarted() {
            TToast.show(this.a, "开始下载");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onIdle() {
            TToast.show(this.a, "未开始下载");
        }

        @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
        public void onInstalled(String str, String str2) {
            TToast.show(this.a, "下载完成回调");
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class g implements View.OnClickListener {
        final /* synthetic */ GMAdDislike a;

        /* JADX INFO: compiled from: TTFeedAdLoad.java */
        class a implements GMDislikeCallback {
            a() {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onCancel() {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onRefuse() {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onSelected(int i2, String str) {
                e.this.h();
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onShow() {
            }
        }

        g(GMAdDislike gMAdDislike) {
            this.a = gMAdDislike;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.showDislikeDialog();
            this.a.setDislikeCallback(new a());
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    class h implements GMNativeAdListener {
        h() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a(IAdInterListener.AdCommandType.AD_CLICK, e.this.f2079e, e.this.f2077c.getShowEcpm(), null);
            if (e.this.b == null) {
                return;
            }
            e.this.b.a(IAdInterListener.AdCommandType.AD_CLICK, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShow", e.this.f2079e, e.this.f2077c.getShowEcpm(), null);
            if (e.this.b == null) {
                return;
            }
            e.this.b.a("onAdShow", null);
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class i {
        ImageView a;
        ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Button f2083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f2084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f2085e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f2086f;

        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class j {
        FrameLayout a;

        private j() {
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class k extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2087g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ImageView f2088h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ImageView f2089i;

        private k() {
            super(null);
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class l extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2090g;

        private l() {
            super(null);
        }

        /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class m extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2091g;

        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class n extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2092g;

        private n() {
            super(null);
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTFeedAdLoad.java */
    private static class o extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        FrameLayout f2093g;

        private o() {
            super(null);
        }

        /* synthetic */ o(a aVar) {
            this();
        }
    }

    private View e(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_vertical_pic, viewGroup, false);
        n nVar = new n(null);
        nVar.f2084d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        nVar.f2086f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        nVar.f2085e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        nVar.f2092g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        nVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        nVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        nVar.f2083c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_vertical_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).iconImageId(R$id.iv_listitem_icon).callToActionId(R$id.btn_listitem_creative).sourceId(R$id.tv_listitem_ad_source).logoLayoutId(R$id.tt_ad_logo).build();
        viewInflate.setTag(nVar);
        a(context, viewInflate, nVar, gMNativeAd, gMViewBinderBuild);
        if (gMNativeAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(nVar.f2092g, gMNativeAd.getImageUrl());
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ViewGroup viewGroup = this.f2078d;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2079e;
    }

    private float b(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().widthPixels;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f3 / f2) + 0.5f;
    }

    private View f(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate;
        a aVar = null;
        try {
            viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_large_video, viewGroup, false);
        } catch (Exception e2) {
            e = e2;
            viewInflate = null;
        }
        try {
            o oVar = new o(aVar);
            oVar.f2084d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
            oVar.f2085e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
            oVar.f2086f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
            oVar.f2093g = (FrameLayout) viewInflate.findViewById(R$id.iv_listitem_video);
            oVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
            oVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
            oVar.f2083c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
            GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_video).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mediaViewIdId(R$id.iv_listitem_video).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build();
            viewInflate.setTag(oVar);
            gMNativeAd.setVideoListener(new C0067e());
            gMNativeAd.setAppDownloadListener(new f(this, context));
            a(context, viewInflate, oVar, gMNativeAd, gMViewBinderBuild);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMNativeAd gMNativeAd = this.f2077c;
        if (gMNativeAd != null) {
            return gMNativeAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMNativeAd gMNativeAd = this.f2077c;
        if (gMNativeAd != null) {
            return gMNativeAd.getPreEcpm();
        }
        return null;
    }

    private View b(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_group_pic, viewGroup, false);
        k kVar = new k(null);
        kVar.f2084d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        kVar.f2086f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        kVar.f2085e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        kVar.f2087g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image1);
        kVar.f2088h = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image2);
        kVar.f2089i = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image3);
        kVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        kVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        kVar.f2083c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_group_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image1).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(kVar);
        a(context, viewInflate, kVar, gMNativeAd, gMViewBinderBuild);
        if (gMNativeAd.getImageList() != null && gMNativeAd.getImageList().size() >= 3) {
            String str = gMNativeAd.getImageList().get(0);
            String str2 = gMNativeAd.getImageList().get(1);
            String str3 = gMNativeAd.getImageList().get(2);
            if (str != null) {
                TTMediationTestTool.showImage(kVar.f2087g, str);
            }
            if (str2 != null) {
                TTMediationTestTool.showImage(kVar.f2088h, str2);
            }
            if (str3 != null) {
                TTMediationTestTool.showImage(kVar.f2089i, str3);
            }
        }
        return viewInflate;
    }

    private View c(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_large_pic, viewGroup, false);
        l lVar = new l(null);
        lVar.f2084d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        lVar.f2085e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        lVar.f2086f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        lVar.f2090g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        lVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        lVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        lVar.f2083c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(lVar);
        a(context, viewInflate, lVar, gMNativeAd, gMViewBinderBuild);
        if (gMNativeAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(lVar.f2090g, gMNativeAd.getImageUrl());
        }
        return viewInflate;
    }

    private View d(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_small_pic, viewGroup, false);
        m mVar = new m(null);
        mVar.f2084d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        mVar.f2086f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        mVar.f2085e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        mVar.f2091g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        mVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        mVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        mVar.f2083c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_small_pic).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(mVar);
        a(context, viewInflate, mVar, gMNativeAd, gMViewBinderBuild);
        if (gMNativeAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(mVar.f2091g, gMNativeAd.getImageUrl());
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMUnifiedNativeAd(activity, eVar.i());
        int i4 = i2 != 2 ? 1 : 2;
        this.f2079e = eVar.i();
        this.a.loadAd(new GMAdSlotNative.Builder().setTestSlotId("gm_test_slot_" + eVar.c()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setAdmobNativeAdOptions(GMAdOptionUtil.getAdmobNativeAdOptions()).setAdStyleType(i4).setImageAdSize((int) b(activity.getApplicationContext()), 340).setAdCount(1).setMuted(false).setVolume(1.0f).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        this.f2078d = viewGroup;
        GMNativeAd gMNativeAd = this.f2077c;
        if (gMNativeAd == null) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(activity, "暂无数据，请稍后重试");
            return;
        }
        View viewF = null;
        if (gMNativeAd.isExpressAd()) {
            viewF = a(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 2) {
            viewF = d(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 3) {
            viewF = c(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 4) {
            viewF = b(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 5) {
            viewF = f(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 16) {
            viewF = e(activity, viewGroup, this.f2077c);
        } else if (this.f2077c.getAdImageMode() == 15) {
            viewF = f(activity, viewGroup, this.f2077c);
        } else {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(activity, "图片展示样式错误");
        }
        if (viewF != null) {
            viewF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.removeAllViews();
            viewGroup.addView(viewF);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMNativeAd gMNativeAd = this.f2077c;
        if (gMNativeAd != null) {
            return gMNativeAd.getAdNetworkRitId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private View a(Context context, ViewGroup viewGroup, @NonNull GMNativeAd gMNativeAd) {
        View viewInflate;
        a aVar = null;
        try {
            viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_native_express, viewGroup, false);
        } catch (Exception e2) {
            e = e2;
            viewInflate = null;
        }
        try {
            j jVar = new j(aVar);
            jVar.a = (FrameLayout) viewInflate.findViewById(R$id.iv_listitem_express);
            if (gMNativeAd.hasDislike()) {
                gMNativeAd.setDislikeCallback((Activity) context, new b());
            }
            gMNativeAd.setNativeAdListener(new c(jVar, gMNativeAd, context));
            gMNativeAd.setVideoListener(new d());
            gMNativeAd.render();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return viewInflate;
    }

    private void a(Context context, View view, i iVar, GMNativeAd gMNativeAd, GMViewBinder gMViewBinder) {
        if (gMNativeAd.hasDislike()) {
            GMAdDislike dislikeDialog = gMNativeAd.getDislikeDialog((Activity) context);
            iVar.b.setVisibility(0);
            iVar.b.setOnClickListener(new g(dislikeDialog));
        } else {
            ImageView imageView = iVar.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        gMNativeAd.setNativeAdListener(this.f2080f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(iVar.f2086f);
        arrayList.add(iVar.f2084d);
        arrayList.add(iVar.f2085e);
        arrayList.add(iVar.a);
        if (iVar instanceof l) {
            arrayList.add(((l) iVar).f2090g);
        } else if (iVar instanceof m) {
            arrayList.add(((m) iVar).f2091g);
        } else if (iVar instanceof n) {
            arrayList.add(((n) iVar).f2092g);
        } else if (iVar instanceof o) {
            arrayList.add(((o) iVar).f2093g);
        } else if (iVar instanceof k) {
            k kVar = (k) iVar;
            arrayList.add(kVar.f2087g);
            arrayList.add(kVar.f2088h);
            arrayList.add(kVar.f2089i);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(iVar.f2083c);
        gMNativeAd.registerView((Activity) context, (ViewGroup) view, arrayList, arrayList2, gMViewBinder);
        iVar.f2084d.setText(gMNativeAd.getTitle());
        iVar.f2085e.setText(gMNativeAd.getDescription());
        iVar.f2086f.setText(TextUtils.isEmpty(gMNativeAd.getSource()) ? "广告来源" : gMNativeAd.getSource());
        String iconUrl = gMNativeAd.getIconUrl();
        if (iconUrl != null) {
            TTMediationTestTool.showImage(iVar.a, iconUrl);
        }
        Button button = iVar.f2083c;
        int interactionType = gMNativeAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAd.getActionText()) ? "查看详情" : gMNativeAd.getActionText());
        } else if (interactionType == 4) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAd.getActionText()) ? "立即下载" : gMNativeAd.getActionText());
        } else if (interactionType != 5) {
            button.setVisibility(8);
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(context, "交互类型异常");
        } else {
            button.setVisibility(0);
            button.setText("立即拨打");
        }
    }
}
