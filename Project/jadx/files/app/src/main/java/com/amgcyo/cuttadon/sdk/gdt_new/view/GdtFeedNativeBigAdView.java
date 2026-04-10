package com.amgcyo.cuttadon.sdk.gdt_new.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.read.page.m;
import com.fatcatfat.io.R;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class GdtFeedNativeBigAdView extends BaseSelfRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.jessyan.art.c.e.c f4138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f4139u;

    class a implements NativeADMediaListener {
        a(GdtFeedNativeBigAdView gdtFeedNativeBigAdView) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i2) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    class b implements NativeADEventListener {
        final /* synthetic */ c a;
        final /* synthetic */ NativeUnifiedADData b;

        b(GdtFeedNativeBigAdView gdtFeedNativeBigAdView, c cVar, NativeUnifiedADData nativeUnifiedADData) {
            this.a = cVar;
            this.b = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            String str = "onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            com.amgcyo.cuttadon.h.c.b.a(this.a.f4140c, this.b);
        }
    }

    private class c {
        NativeAdContainer a;
        ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Button f4140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f4141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f4142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        MediaView f4143f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f4144g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ImageView f4145h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ImageView f4146i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ImageView f4147j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        LinearLayout f4148k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        TextView f4149l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        TextView f4150m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        LinearLayout f4151n;

        c(GdtFeedNativeBigAdView gdtFeedNativeBigAdView, View view) {
            this.a = (NativeAdContainer) view.findViewById(R.id.native_ad_container);
            this.f4143f = (MediaView) view.findViewById(R.id.gdt_media_view);
            this.f4141d = (TextView) view.findViewById(R.id.text_title);
            this.f4144g = (ImageView) view.findViewById(R.id.img_poster);
            this.f4142e = (TextView) view.findViewById(R.id.text_desc);
            this.f4140c = (Button) view.findViewById(R.id.btn_download);
            this.b = (ImageView) view.findViewById(R.id.img_logo);
            this.f4149l = (TextView) view.findViewById(R.id.native_3img_desc);
            this.f4148k = (LinearLayout) view.findViewById(R.id.native_3img_ad_container);
            this.f4145h = (ImageView) view.findViewById(R.id.img_1);
            this.f4146i = (ImageView) view.findViewById(R.id.img_2);
            this.f4147j = (ImageView) view.findViewById(R.id.img_3);
            this.f4150m = (TextView) view.findViewById(R.id.native_3img_title);
            this.f4151n = (LinearLayout) view.findViewById(R.id.ll_ad_native_banner);
        }
    }

    public GdtFeedNativeBigAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f4137s = context;
        this.f4138t = e.a(this.f4137s).imageLoader();
    }

    private VideoOption getVideoOption() {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(1);
        builder.setAutoPlayMuted(true);
        builder.setDetailPageMuted(false);
        builder.setNeedCoverImage(true);
        builder.setNeedProgressBar(true);
        builder.setEnableDetailPage(true);
        builder.setEnableUserControl(false);
        return builder.build();
    }

    public void setGdtNewFeedNativeData(NativeUnifiedADData nativeUnifiedADData) {
        View viewInflate = LayoutInflater.from(this.f4137s).inflate(R.layout.gdt_native_datu_itemview, (ViewGroup) null, true);
        this.f4139u = new c(this, viewInflate);
        a(this.f4139u, nativeUnifiedADData);
        removeAllViews();
        if (this.f4137s instanceof MkNovelBaseReaderActivity) {
            a();
        }
        addView(viewInflate);
    }

    public GdtFeedNativeBigAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC = o.c();
        if (jsonColorStyleC == null || this.f4139u == null) {
            return;
        }
        int panelBgColor = jsonColorStyleC.getPanelBgColor();
        this.f4139u.f4151n.setBackgroundColor(panelBgColor);
        this.f4139u.a.setBackgroundColor(panelBgColor);
        int textColor = jsonColorStyleC.getTextColor();
        int footerColor = jsonColorStyleC.getFooterColor();
        this.f4139u.f4141d.setTextColor(textColor);
        this.f4139u.f4142e.setTextColor(footerColor);
        this.f4139u.f4150m.setTextColor(textColor);
        this.f4139u.f4149l.setTextColor(footerColor);
        String key = jsonColorStyleC.getKey();
        if (TextUtils.isEmpty(key) || !"night".equals(key)) {
            return;
        }
        o.a(this.f4139u.b);
        o.a(this.f4139u.f4144g);
        o.a(this.f4139u.f4145h);
        o.a(this.f4139u.f4146i);
        o.a(this.f4139u.f4147j);
    }

    public GdtFeedNativeBigAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(c cVar, NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.f4140c);
        arrayList.add(cVar.b);
        arrayList.add(cVar.f4142e);
        arrayList.add(cVar.f4141d);
        ArrayList arrayList2 = new ArrayList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        if (nativeUnifiedADData.getAdPatternType() != 1 && nativeUnifiedADData.getAdPatternType() != 4) {
            if (nativeUnifiedADData.getAdPatternType() == 3) {
                arrayList.add(cVar.f4148k);
                arrayList3.add(cVar.f4145h);
                arrayList3.add(cVar.f4146i);
                arrayList3.add(cVar.f4147j);
            }
        } else {
            arrayList.add(cVar.f4144g);
            arrayList3.add(cVar.f4144g);
            if (m.a(this.f4137s)) {
                ViewGroup.LayoutParams layoutParams = cVar.f4144g.getLayoutParams();
                layoutParams.height = n.a(230.0f);
                cVar.f4144g.setLayoutParams(layoutParams);
            }
        }
        nativeUnifiedADData.bindAdToView(this.f4137s, cVar.a, null, arrayList, arrayList2);
        if (!arrayList3.isEmpty()) {
            nativeUnifiedADData.bindImageViews(arrayList3, 0);
        } else if (nativeUnifiedADData.getAdPatternType() == 2) {
            VideoOption videoOption = getVideoOption();
            if (m.a(this.f4137s)) {
                ViewGroup.LayoutParams layoutParams2 = cVar.f4143f.getLayoutParams();
                layoutParams2.height = n.a(200.0f);
                cVar.f4143f.setLayoutParams(layoutParams2);
            }
            nativeUnifiedADData.bindMediaView(cVar.f4143f, videoOption, new a(this));
        } else if (nativeUnifiedADData.getAdPatternType() != 1 && nativeUnifiedADData.getAdPatternType() != 4) {
            arrayList.add(findViewById(R.id.native_3img_ad_container));
        } else {
            arrayList.add(cVar.f4144g);
        }
        nativeUnifiedADData.setNativeAdEventListener(new b(this, cVar, nativeUnifiedADData));
        int adPatternType = nativeUnifiedADData.getAdPatternType();
        if (adPatternType == 1 || adPatternType == 2) {
            cVar.f4144g.setVisibility(0);
            String iconUrl = nativeUnifiedADData.getIconUrl();
            ViewGroup.LayoutParams layoutParams3 = cVar.b.getLayoutParams();
            if (!TextUtils.isEmpty(iconUrl)) {
                String str = "icon url not null :" + iconUrl;
                layoutParams3.width = n.a(52.0f);
                layoutParams3.height = n.a(52.0f);
            } else {
                iconUrl = nativeUnifiedADData.getImgUrl();
                layoutParams3.width = n.a(85.0f);
                layoutParams3.height = n.a(52.0f);
            }
            cVar.b.setLayoutParams(layoutParams3);
            if (!TextUtils.isEmpty(iconUrl)) {
                this.f4138t.a(this.f4137s, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(iconUrl).imageView(cVar.b).build());
            }
            cVar.f4141d.setText(nativeUnifiedADData.getTitle());
            cVar.f4142e.setText(nativeUnifiedADData.getDesc());
            String str2 = "标题：" + nativeUnifiedADData.getTitle() + " 是否主线程：" + e.a();
        } else if (adPatternType == 3) {
            cVar.f4150m.setText(nativeUnifiedADData.getTitle());
            cVar.f4149l.setText(nativeUnifiedADData.getDesc());
        } else if (adPatternType == 4) {
            cVar.f4141d.setText(nativeUnifiedADData.getTitle());
            cVar.f4142e.setText(nativeUnifiedADData.getDesc());
        }
        com.amgcyo.cuttadon.h.c.b.a(cVar.f4140c, nativeUnifiedADData);
    }
}
