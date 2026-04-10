package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

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
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAd;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.mtesttools.api.TTMediationTestTool;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: TTBannerAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g {
    private GMBannerAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f2037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewGroup f2038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    GMBannerAdListener f2040f = new C0065c();

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    class a extends GMNativeToBannerListener {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener
        public View getGMBannerViewFromNativeAd(GMNativeAdInfo gMNativeAdInfo) {
            return c.this.a(gMNativeAdInfo);
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    class b implements GMBannerAdLoadCallback {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public void onAdFailedToLoad(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdFailedToLoad", adError);
            if (c.this.b == null) {
                return;
            }
            c.this.b.b("onAdFailedToLoad", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public void onAdLoaded() {
            if (c.this.b == null) {
                return;
            }
            c.this.b.b("onAdLoaded", null);
        }
    }

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    class C0065c implements GMBannerAdListener {
        C0065c() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClicked() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdClicked", c.this.f2039e, c.this.a.getShowEcpm(), null);
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdClicked", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdClosed", c.this.f2039e, c.this.a.getShowEcpm(), null);
            if (c.this.f2038d != null) {
                c.this.f2038d.removeAllViews();
            }
            if (c.this.a != null) {
                c.this.a.destroy();
            }
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdClosed", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdLeftApplication() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdLeftApplication", c.this.f2039e, c.this.a.getShowEcpm(), null);
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdLeftApplication", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdOpened() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdOpened", c.this.f2039e, c.this.a.getShowEcpm(), null);
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdOpened", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShow", c.this.f2039e, c.this.a.getShowEcpm(), null);
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public void onAdShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShowFail", adError);
            if (c.this.b == null) {
                return;
            }
            c.this.b.a("onAdShowFail", adError);
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    class d implements View.OnClickListener {
        final /* synthetic */ GMAdDislike a;

        /* JADX INFO: compiled from: TTBannerAdLoad.java */
        class a implements GMDislikeCallback {
            a(d dVar) {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onCancel() {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onRefuse() {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onSelected(int i2, String str) {
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onShow() {
            }
        }

        d(c cVar, GMAdDislike gMAdDislike) {
            this.a = gMAdDislike;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.showDislikeDialog();
            this.a.setDislikeCallback(new a(this));
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class e {
        ImageView a;
        ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Button f2041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f2042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f2043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f2044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        LinearLayout f2045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f2046h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        TextView f2047i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        TextView f2048j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        TextView f2049k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        TextView f2050l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        TextView f2051m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        TextView f2052n;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class f extends e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        ImageView f2053o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        ImageView f2054p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        ImageView f2055q;

        private f() {
            super(null);
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class g extends e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        ImageView f2056o;

        private g() {
            super(null);
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class h extends e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        ImageView f2057o;

        private h() {
            super(null);
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class i extends e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        ImageView f2058o;

        private i() {
            super(null);
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTBannerAdLoad.java */
    private static class j extends e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        FrameLayout f2059o;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    private View e(ViewGroup viewGroup, @NonNull GMNativeAdInfo gMNativeAdInfo) {
        View viewInflate;
        a aVar = null;
        try {
            viewInflate = LayoutInflater.from(this.f2037c).inflate(R$layout.ttt_listitem_ad_large_video, viewGroup, false);
            try {
                j jVar = new j(aVar);
                jVar.f2042d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
                jVar.f2043e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
                jVar.f2044f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
                jVar.f2059o = (FrameLayout) viewInflate.findViewById(R$id.iv_listitem_video);
                jVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
                jVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
                jVar.f2041c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
                a(viewInflate, jVar, gMNativeAdInfo, new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_video).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mediaViewIdId(R$id.iv_listitem_video).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            viewInflate = null;
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2039e;
    }

    private View b(ViewGroup viewGroup, @NonNull GMNativeAdInfo gMNativeAdInfo) {
        View viewInflate = LayoutInflater.from(this.f2037c).inflate(R$layout.ttt_listitem_ad_large_pic, viewGroup, false);
        g gVar = new g(null);
        gVar.f2042d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        gVar.f2043e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        gVar.f2044f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        gVar.f2056o = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        gVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        gVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        gVar.f2041c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        a(viewInflate, gVar, gMNativeAdInfo, new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            TTMediationTestTool.showImage(gVar.f2056o, gMNativeAdInfo.getImageUrl());
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMBannerAd gMBannerAd = this.a;
        if (gMBannerAd != null) {
            return gMBannerAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMBannerAd gMBannerAd = this.a;
        if (gMBannerAd != null) {
            return gMBannerAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.f2037c = activity;
        this.b = aVar;
        this.a = new GMBannerAd(activity, eVar.i());
        this.a.setAdBannerListener(this.f2040f);
        this.a.setNativeToBannerListener(new a());
        this.f2039e = eVar.i();
        this.a.loadAd(new GMAdSlotBanner.Builder().setTestSlotId("gm_test_slot_" + eVar.c()).setBannerSize(3).setRefreshTime(30).setAllowShowCloseBtn(true).build(), new b());
    }

    private View c(ViewGroup viewGroup, @NonNull GMNativeAdInfo gMNativeAdInfo) {
        View viewInflate = LayoutInflater.from(this.f2037c).inflate(R$layout.ttt_listitem_ad_small_pic, (ViewGroup) null, false);
        h hVar = new h(null);
        hVar.f2042d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        hVar.f2044f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        hVar.f2043e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        hVar.f2057o = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        hVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        hVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        hVar.f2041c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        a(viewInflate, hVar, gMNativeAdInfo, new GMViewBinder.Builder(R$layout.ttt_listitem_ad_small_pic).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            TTMediationTestTool.showImage(hVar.f2057o, gMNativeAdInfo.getImageUrl());
        }
        return viewInflate;
    }

    private View d(ViewGroup viewGroup, @NonNull GMNativeAdInfo gMNativeAdInfo) {
        View viewInflate = LayoutInflater.from(this.f2037c).inflate(R$layout.ttt_listitem_ad_vertical_pic, viewGroup, false);
        i iVar = new i(null);
        iVar.f2042d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        iVar.f2044f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        iVar.f2043e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        iVar.f2058o = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        iVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        iVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        iVar.f2041c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        a(viewInflate, iVar, gMNativeAdInfo, new GMViewBinder.Builder(R$layout.ttt_listitem_ad_vertical_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).iconImageId(R$id.iv_listitem_icon).callToActionId(R$id.btn_listitem_creative).sourceId(R$id.tv_listitem_ad_source).logoLayoutId(R$id.tt_ad_logo).build());
        if (gMNativeAdInfo.getImageUrl() != null) {
            TTMediationTestTool.showImage(iVar.f2058o, gMNativeAdInfo.getImageUrl());
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        if (this.a == null || viewGroup == null) {
            return;
        }
        this.f2038d = viewGroup;
        viewGroup.removeAllViews();
        View bannerView = this.a.getBannerView();
        if (bannerView != null) {
            viewGroup.addView(bannerView);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMBannerAd gMBannerAd = this.a;
        if (gMBannerAd != null) {
            return gMBannerAd.getAdNetworkRitId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(GMNativeAdInfo gMNativeAdInfo) {
        if (gMNativeAdInfo.getAdImageMode() == 2) {
            return c(null, gMNativeAdInfo);
        }
        if (gMNativeAdInfo.getAdImageMode() == 3) {
            return b(null, gMNativeAdInfo);
        }
        if (gMNativeAdInfo.getAdImageMode() == 4) {
            return a((ViewGroup) null, gMNativeAdInfo);
        }
        if (gMNativeAdInfo.getAdImageMode() == 5) {
            return e(null, gMNativeAdInfo);
        }
        if (gMNativeAdInfo.getAdImageMode() == 16) {
            return d(null, gMNativeAdInfo);
        }
        if (gMNativeAdInfo.getAdImageMode() == 15) {
            return e(null, gMNativeAdInfo);
        }
        return null;
    }

    private View a(ViewGroup viewGroup, @NonNull GMNativeAdInfo gMNativeAdInfo) {
        View viewInflate = LayoutInflater.from(this.f2037c).inflate(R$layout.ttt_listitem_ad_group_pic, viewGroup, false);
        f fVar = new f(null);
        fVar.f2042d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        fVar.f2044f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        fVar.f2043e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        fVar.f2053o = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image1);
        fVar.f2054p = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image2);
        fVar.f2055q = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image3);
        fVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        fVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        fVar.f2041c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        a(viewInflate, fVar, gMNativeAdInfo, new TTViewBinder.Builder(R$layout.ttt_listitem_ad_group_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image1).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).groupImage1Id(R$id.iv_listitem_image1).groupImage2Id(R$id.iv_listitem_image2).groupImage3Id(R$id.iv_listitem_image3).build());
        if (gMNativeAdInfo.getImageList() != null && gMNativeAdInfo.getImageList().size() >= 3) {
            String str = gMNativeAdInfo.getImageList().get(0);
            String str2 = gMNativeAdInfo.getImageList().get(1);
            String str3 = gMNativeAdInfo.getImageList().get(2);
            if (str != null) {
                TTMediationTestTool.showImage(fVar.f2053o, gMNativeAdInfo.getImageUrl());
            }
            if (str2 != null) {
                TTMediationTestTool.showImage(fVar.f2054p, gMNativeAdInfo.getImageUrl());
            }
            if (str3 != null) {
                TTMediationTestTool.showImage(fVar.f2055q, gMNativeAdInfo.getImageUrl());
            }
        }
        return viewInflate;
    }

    private void a(View view, e eVar, GMNativeAdInfo gMNativeAdInfo, GMViewBinder gMViewBinder) {
        if (gMNativeAdInfo.hasDislike()) {
            GMAdDislike dislikeDialog = gMNativeAdInfo.getDislikeDialog(this.f2037c);
            eVar.b.setVisibility(0);
            eVar.b.setOnClickListener(new d(this, dislikeDialog));
        } else {
            ImageView imageView = eVar.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        a(gMNativeAdInfo, eVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(eVar.f2044f);
        arrayList.add(eVar.f2042d);
        arrayList.add(eVar.f2043e);
        arrayList.add(eVar.a);
        if (eVar instanceof g) {
            arrayList.add(((g) eVar).f2056o);
        } else if (eVar instanceof h) {
            arrayList.add(((h) eVar).f2057o);
        } else if (eVar instanceof i) {
            arrayList.add(((i) eVar).f2058o);
        } else if (eVar instanceof j) {
            arrayList.add(((j) eVar).f2059o);
        } else if (eVar instanceof f) {
            f fVar = (f) eVar;
            arrayList.add(fVar.f2053o);
            arrayList.add(fVar.f2054p);
            arrayList.add(fVar.f2055q);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(eVar.f2041c);
        gMNativeAdInfo.registerView(this.f2037c, (ViewGroup) view, arrayList, arrayList2, gMViewBinder);
        eVar.f2042d.setText(gMNativeAdInfo.getTitle());
        eVar.f2043e.setText(gMNativeAdInfo.getDescription());
        eVar.f2044f.setText(TextUtils.isEmpty(gMNativeAdInfo.getSource()) ? "广告来源" : gMNativeAdInfo.getSource());
        if (gMNativeAdInfo.getIconUrl() != null) {
            TTMediationTestTool.showImage(eVar.a, gMNativeAdInfo.getImageUrl());
        }
        Button button = eVar.f2041c;
        int interactionType = gMNativeAdInfo.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAdInfo.getActionText()) ? "查看详情" : gMNativeAdInfo.getActionText());
        } else if (interactionType == 4) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMNativeAdInfo.getActionText()) ? "立即下载" : gMNativeAdInfo.getActionText());
        } else if (interactionType != 5) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText("立即拨打");
        }
    }

    private void a(GMNativeAdInfo gMNativeAdInfo, e eVar) {
        if (eVar == null) {
            return;
        }
        if (gMNativeAdInfo != null && gMNativeAdInfo.getNativeAdAppInfo() != null) {
            eVar.f2045g.setVisibility(0);
            GMNativeAdAppInfo nativeAdAppInfo = gMNativeAdInfo.getNativeAdAppInfo();
            eVar.f2046h.setText("应用名称：" + nativeAdAppInfo.getAppName());
            eVar.f2047i.setText("开发者：" + nativeAdAppInfo.getAuthorName());
            eVar.f2048j.setText("包大小：" + nativeAdAppInfo.getPackageSizeBytes());
            eVar.f2049k.setText("权限url:" + nativeAdAppInfo.getPermissionsUrl());
            eVar.f2050l.setText("隐私url：" + nativeAdAppInfo.getPrivacyAgreement());
            eVar.f2051m.setText("版本号：" + nativeAdAppInfo.getVersionName());
            eVar.f2052n.setText("权限内容:" + a(nativeAdAppInfo.getPermissionsMap()));
            return;
        }
        eVar.f2045g.setVisibility(8);
    }

    private String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            stringBuffer.append(str + " : " + map.get(str) + " \n");
        }
        return stringBuffer.toString();
    }
}
