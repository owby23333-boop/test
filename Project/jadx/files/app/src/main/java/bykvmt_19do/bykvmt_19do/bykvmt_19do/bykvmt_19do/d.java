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
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAd;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener;
import com.bytedance.msdk.api.v2.ad.draw.GMUnifiedDrawAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import com.bytedance.mtesttools.api.TTMediationTestTool;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: TTDrawAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g {
    private GMUnifiedDrawAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GMDrawAd f2060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewGroup f2061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    GMDrawAdListener f2063f = new g();

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class a implements GMDrawAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdLoadCallback
        public void onAdLoadFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdLoadFail", adError);
            if (d.this.b == null) {
                return;
            }
            d.this.b.b("onAdLoadFail", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdLoadCallback
        public void onAdLoadSuccess(List<GMDrawAd> list) {
            if (list != null && list.size() > 0) {
                d.this.f2060c = list.get(0);
            }
            if (d.this.b == null) {
                return;
            }
            d.this.b.b("onAdLoadSuccess", null);
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
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
            d.this.h();
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onShow() {
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class c implements GMDrawExpressAdListener {
        final /* synthetic */ i a;
        final /* synthetic */ GMDrawAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f2064c;

        c(i iVar, GMDrawAd gMDrawAd, Context context) {
            this.a = iVar;
            this.b = gMDrawAd;
            this.f2064c = context;
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a(IAdInterListener.AdCommandType.AD_CLICK, d.this.f2062e, d.this.f2060c.getShowEcpm(), null);
            if (d.this.b == null) {
                return;
            }
            d.this.b.a(IAdInterListener.AdCommandType.AD_CLICK, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShow", d.this.f2062e, d.this.f2060c.getShowEcpm(), null);
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
        public void onRenderFail(View view, String str, int i2) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRenderFail", new AdError(i2, str));
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onRenderFail", new AdError(i2, str));
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
        public void onRenderSuccess(float f2, float f3) {
            int i2;
            int i3;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRenderSuccess", d.this.f2062e, d.this.f2060c.getShowEcpm(), null);
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onRenderSuccess", null);
            if (this.a.a != null) {
                View expressView = this.b.getExpressView();
                if (f2 == -1.0f && f3 == -2.0f) {
                    i3 = -1;
                    i2 = -2;
                } else {
                    int iA = d.this.a(this.f2064c);
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

    /* JADX INFO: renamed from: bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class C0066d implements GMVideoListener {
        C0066d() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onProgressUpdate", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoCompleted", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(AdError adError) {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoError", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoPause", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoResume", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoStart", null);
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class e implements GMVideoListener {
        e() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onProgressUpdate(long j2, long j3) {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onProgressUpdate", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoCompleted() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoCompleted", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoError(AdError adError) {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoError", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoPause() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoPause", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoResume() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoResume", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
        public void onVideoStart() {
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onVideoStart", null);
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class f implements View.OnClickListener {
        final /* synthetic */ GMAdDislike a;

        /* JADX INFO: compiled from: TTDrawAdLoad.java */
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
                d.this.h();
            }

            @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
            public void onShow() {
            }
        }

        f(GMAdDislike gMAdDislike) {
            this.a = gMAdDislike;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.showDislikeDialog();
            this.a.setDislikeCallback(new a());
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    class g implements GMDrawAdListener {
        g() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a(IAdInterListener.AdCommandType.AD_CLICK, d.this.f2062e, d.this.f2060c.getShowEcpm(), null);
            if (d.this.b == null) {
                return;
            }
            d.this.b.a(IAdInterListener.AdCommandType.AD_CLICK, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener
        public void onAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShow", d.this.f2062e, d.this.f2060c.getShowEcpm(), null);
            if (d.this.b == null) {
                return;
            }
            d.this.b.a("onAdShow", null);
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class h {
        ImageView a;
        ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Button f2066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f2067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f2068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f2069f;

        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class i {
        FrameLayout a;

        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class j extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2070g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ImageView f2071h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ImageView f2072i;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class k extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2073g;

        private k() {
            super(null);
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class l extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2074g;

        private l() {
            super(null);
        }

        /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class m extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f2075g;

        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TTDrawAdLoad.java */
    private static class n extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        FrameLayout f2076g;

        private n() {
            super(null);
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private View e(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_vertical_pic, viewGroup, false);
        m mVar = new m(null);
        mVar.f2067d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        mVar.f2069f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        mVar.f2068e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        mVar.f2075g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        mVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        mVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        mVar.f2066c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_vertical_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).iconImageId(R$id.iv_listitem_icon).callToActionId(R$id.btn_listitem_creative).sourceId(R$id.tv_listitem_ad_source).logoLayoutId(R$id.tt_ad_logo).build();
        viewInflate.setTag(mVar);
        a(context, viewInflate, mVar, gMDrawAd, gMViewBinderBuild);
        if (gMDrawAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(mVar.f2075g, gMDrawAd.getImageUrl());
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ViewGroup viewGroup = this.f2061d;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2062e;
    }

    private View b(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_group_pic, viewGroup, false);
        j jVar = new j(null);
        jVar.f2067d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        jVar.f2069f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        jVar.f2068e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        jVar.f2070g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image1);
        jVar.f2071h = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image2);
        jVar.f2072i = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image3);
        jVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        jVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        jVar.f2066c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_group_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image1).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(jVar);
        a(context, viewInflate, jVar, gMDrawAd, gMViewBinderBuild);
        if (gMDrawAd.getImageList() != null && gMDrawAd.getImageList().size() >= 3) {
            String str = gMDrawAd.getImageList().get(0);
            String str2 = gMDrawAd.getImageList().get(1);
            String str3 = gMDrawAd.getImageList().get(2);
            if (str != null) {
                TTMediationTestTool.showImage(jVar.f2070g, str);
            }
            if (str2 != null) {
                TTMediationTestTool.showImage(jVar.f2071h, str2);
            }
            if (str3 != null) {
                TTMediationTestTool.showImage(jVar.f2072i, str3);
            }
        }
        return viewInflate;
    }

    private View f(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate;
        a aVar = null;
        try {
            viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_large_video, viewGroup, false);
            try {
                n nVar = new n(aVar);
                nVar.f2067d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
                nVar.f2068e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
                nVar.f2069f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
                nVar.f2076g = (FrameLayout) viewInflate.findViewById(R$id.iv_listitem_video);
                nVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
                nVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
                nVar.f2066c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
                GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_video).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mediaViewIdId(R$id.iv_listitem_video).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build();
                viewInflate.setTag(nVar);
                gMDrawAd.setVideoListener(new e());
                a(context, viewInflate, nVar, gMDrawAd, gMViewBinderBuild);
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
    public GMAdEcpmInfo c() {
        GMDrawAd gMDrawAd = this.f2060c;
        if (gMDrawAd != null) {
            return gMDrawAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMDrawAd gMDrawAd = this.f2060c;
        if (gMDrawAd != null) {
            return gMDrawAd.getPreEcpm();
        }
        return null;
    }

    private View c(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_large_pic, viewGroup, false);
        k kVar = new k(null);
        kVar.f2067d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        kVar.f2068e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        kVar.f2069f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        kVar.f2073g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        kVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        kVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        kVar.f2066c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_large_pic).titleId(R$id.tv_listitem_ad_title).descriptionTextId(R$id.tv_listitem_ad_desc).sourceId(R$id.tv_listitem_ad_source).mainImageId(R$id.iv_listitem_image).callToActionId(R$id.btn_listitem_creative).logoLayoutId(R$id.tt_ad_logo).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(kVar);
        a(context, viewInflate, kVar, gMDrawAd, gMViewBinderBuild);
        if (gMDrawAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(kVar.f2073g, gMDrawAd.getImageUrl());
        }
        return viewInflate;
    }

    private View d(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_small_pic, viewGroup, false);
        l lVar = new l(null);
        lVar.f2067d = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_title);
        lVar.f2069f = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_source);
        lVar.f2068e = (TextView) viewInflate.findViewById(R$id.tv_listitem_ad_desc);
        lVar.f2074g = (ImageView) viewInflate.findViewById(R$id.iv_listitem_image);
        lVar.a = (ImageView) viewInflate.findViewById(R$id.iv_listitem_icon);
        lVar.b = (ImageView) viewInflate.findViewById(R$id.iv_listitem_dislike);
        lVar.f2066c = (Button) viewInflate.findViewById(R$id.btn_listitem_creative);
        GMViewBinder gMViewBinderBuild = new GMViewBinder.Builder(R$layout.ttt_listitem_ad_small_pic).titleId(R$id.tv_listitem_ad_title).sourceId(R$id.tv_listitem_ad_source).descriptionTextId(R$id.tv_listitem_ad_desc).mainImageId(R$id.iv_listitem_image).logoLayoutId(R$id.tt_ad_logo).callToActionId(R$id.btn_listitem_creative).iconImageId(R$id.iv_listitem_icon).build();
        viewInflate.setTag(lVar);
        a(context, viewInflate, lVar, gMDrawAd, gMViewBinderBuild);
        if (gMDrawAd.getImageUrl() != null) {
            TTMediationTestTool.showImage(lVar.f2074g, gMDrawAd.getImageUrl());
        }
        return viewInflate;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMUnifiedDrawAd(activity, eVar.i());
        new HashMap().put("gdt", "gdt custom data");
        this.f2062e = eVar.i();
        this.a.loadAd(new GMAdSlotDraw.Builder().setTestSlotId("gm_test_slot_" + eVar.c()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setAdCount(1).setImageAdSize(600, 600).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        this.f2061d = viewGroup;
        GMDrawAd gMDrawAd = this.f2060c;
        if (gMDrawAd == null) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(activity, "暂无数据，请稍后重试");
            return;
        }
        View viewF = null;
        if (gMDrawAd.isExpressAd()) {
            viewF = a(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 2) {
            viewF = d(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 3) {
            viewF = c(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 4) {
            viewF = b(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 5) {
            viewF = f(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 16) {
            viewF = e(activity, viewGroup, this.f2060c);
        } else if (this.f2060c.getAdImageMode() == 15) {
            viewF = f(activity, viewGroup, this.f2060c);
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
        GMDrawAd gMDrawAd = this.f2060c;
        if (gMDrawAd != null) {
            return gMDrawAd.getAdNetworkRitId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private View a(Context context, ViewGroup viewGroup, @NonNull GMDrawAd gMDrawAd) {
        View viewInflate;
        a aVar = null;
        try {
            viewInflate = LayoutInflater.from(context).inflate(R$layout.ttt_listitem_ad_native_express, viewGroup, false);
        } catch (Exception e2) {
            e = e2;
            viewInflate = null;
        }
        try {
            i iVar = new i(aVar);
            iVar.a = (FrameLayout) viewInflate.findViewById(R$id.iv_listitem_express);
            if (gMDrawAd.hasDislike()) {
                gMDrawAd.setDislikeCallback((Activity) context, new b());
            }
            gMDrawAd.setDrawAdListener(new c(iVar, gMDrawAd, context));
            gMDrawAd.setVideoListener(new C0066d());
            gMDrawAd.render();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return viewInflate;
    }

    private void a(Context context, View view, h hVar, GMDrawAd gMDrawAd, GMViewBinder gMViewBinder) {
        if (gMDrawAd.hasDislike()) {
            GMAdDislike dislikeDialog = gMDrawAd.getDislikeDialog((Activity) context);
            hVar.b.setVisibility(0);
            hVar.b.setOnClickListener(new f(dislikeDialog));
        } else {
            ImageView imageView = hVar.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        gMDrawAd.setDrawAdListener(this.f2063f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(hVar.f2069f);
        arrayList.add(hVar.f2067d);
        arrayList.add(hVar.f2068e);
        arrayList.add(hVar.a);
        if (hVar instanceof k) {
            arrayList.add(((k) hVar).f2073g);
        } else if (hVar instanceof l) {
            arrayList.add(((l) hVar).f2074g);
        } else if (hVar instanceof m) {
            arrayList.add(((m) hVar).f2075g);
        } else if (hVar instanceof n) {
            arrayList.add(((n) hVar).f2076g);
        } else if (hVar instanceof j) {
            j jVar = (j) hVar;
            arrayList.add(jVar.f2070g);
            arrayList.add(jVar.f2071h);
            arrayList.add(jVar.f2072i);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(hVar.f2066c);
        gMDrawAd.registerView((Activity) context, (ViewGroup) view, arrayList, arrayList2, gMViewBinder);
        hVar.f2067d.setText(gMDrawAd.getTitle());
        hVar.f2068e.setText(gMDrawAd.getDescription());
        hVar.f2069f.setText(TextUtils.isEmpty(gMDrawAd.getSource()) ? "广告来源" : gMDrawAd.getSource());
        String iconUrl = gMDrawAd.getIconUrl();
        if (iconUrl != null) {
            TTMediationTestTool.showImage(hVar.a, iconUrl);
        }
        Button button = hVar.f2066c;
        int interactionType = gMDrawAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMDrawAd.getActionText()) ? "查看详情" : gMDrawAd.getActionText());
        } else if (interactionType == 4) {
            button.setVisibility(0);
            button.setText(TextUtils.isEmpty(gMDrawAd.getActionText()) ? "立即下载" : gMDrawAd.getActionText());
        } else if (interactionType != 5) {
            button.setVisibility(8);
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(context, "交互类型异常");
        } else {
            button.setVisibility(0);
            button.setText("立即拨打");
        }
    }
}
