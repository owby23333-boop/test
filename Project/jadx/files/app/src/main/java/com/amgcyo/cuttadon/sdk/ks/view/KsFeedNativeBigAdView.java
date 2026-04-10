package com.amgcyo.cuttadon.sdk.ks.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class KsFeedNativeBigAdView extends BaseSelfRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4169s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.jessyan.art.c.e.c f4170t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private d f4171u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private JsonColorStyle f4172v;

    class a implements KsNativeAd.VideoPlayListener {
        a(KsFeedNativeBigAdView ksFeedNativeBigAdView) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i2, int i3) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayReady() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
        }
    }

    class b implements KsNativeAd.AdInteractionListener {
        b(KsFeedNativeBigAdView ksFeedNativeBigAdView) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            if (ksNativeAd != null) {
                String str = "广告" + ksNativeAd.getAppName() + "被点击";
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            if (ksNativeAd != null) {
                String str = "广告" + ksNativeAd.getAppName() + "展示";
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    class c implements KsAppDownloadListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ d f4173s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ String f4174t;

        c(KsFeedNativeBigAdView ksFeedNativeBigAdView, d dVar, String str) {
            this.f4173s = dVar;
            this.f4174t = str;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            if (this.f4173s.f4177e != null) {
                if (TextUtils.isEmpty(this.f4174t)) {
                    this.f4173s.f4177e.setText(this.f4174t);
                } else {
                    this.f4173s.f4177e.setText("立即下载");
                }
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            TextView textView = this.f4173s.f4177e;
            if (textView != null) {
                textView.setText("立即安装");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            TextView textView = this.f4173s.f4177e;
            if (textView != null) {
                textView.setText("开始下载");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            if (this.f4173s.f4177e != null) {
                if (TextUtils.isEmpty(this.f4174t)) {
                    this.f4173s.f4177e.setText(this.f4174t);
                } else {
                    this.f4173s.f4177e.setText("立即下载");
                }
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            TextView textView = this.f4173s.f4177e;
            if (textView != null) {
                textView.setText("立即打开");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = this.f4173s.f4177e;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i2)));
            }
        }
    }

    private class d {
        TextView a;
        ViewGroup b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f4175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f4176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f4177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ImageView f4178f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f4179g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f4180h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ViewGroup f4181i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ViewGroup f4182j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        TextView f4183k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        TextView f4184l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        TextView f4185m;

        d(KsFeedNativeBigAdView ksFeedNativeBigAdView, View view) {
            this.f4175c = (TextView) view.findViewById(R.id.app_download_title);
            this.a = (TextView) view.findViewById(R.id.ad_desc);
            this.f4176d = (TextView) view.findViewById(R.id.app_download_desc);
            this.b = (ViewGroup) view.findViewById(R.id.ad_download_container);
            this.f4178f = (ImageView) view.findViewById(R.id.app_download_icon);
            this.f4177e = (TextView) view.findViewById(R.id.app_download_btn);
            this.f4182j = (ViewGroup) view.findViewById(R.id.ad_h5_container);
            this.f4183k = (TextView) view.findViewById(R.id.h5_desc);
            this.f4184l = (TextView) view.findViewById(R.id.h5_title);
            this.f4185m = (TextView) view.findViewById(R.id.h5_open_btn);
            this.f4179g = (ImageView) view.findViewById(R.id.ksad_logo_icon);
            this.f4180h = (TextView) view.findViewById(R.id.ksad_logo_text);
            this.f4181i = (ViewGroup) view.findViewById(R.id.ad_container);
        }
    }

    private class e extends d {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        ImageView f4186n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        ImageView f4187o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        ImageView f4188p;

        e(KsFeedNativeBigAdView ksFeedNativeBigAdView, View view) {
            super(ksFeedNativeBigAdView, view);
            this.f4186n = (ImageView) view.findViewById(R.id.ad_image_left);
            this.f4187o = (ImageView) view.findViewById(R.id.ad_image_mid);
            this.f4188p = (ImageView) view.findViewById(R.id.ad_image_right);
        }
    }

    private class f extends d {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        ImageView f4189n;

        f(KsFeedNativeBigAdView ksFeedNativeBigAdView, View view) {
            super(ksFeedNativeBigAdView, view);
            this.f4189n = (ImageView) view.findViewById(R.id.ad_image);
        }
    }

    private class g extends d {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        FrameLayout f4190n;

        g(KsFeedNativeBigAdView ksFeedNativeBigAdView, View view) {
            super(ksFeedNativeBigAdView, view);
            this.f4190n = (FrameLayout) view.findViewById(R.id.video_container);
        }
    }

    public KsFeedNativeBigAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f4169s = context;
        this.f4170t = me.jessyan.art.f.e.a(this.f4169s).imageLoader();
    }

    private void b(KsNativeAd ksNativeAd) {
        KsImage ksImage;
        View viewInflate = LayoutInflater.from(this.f4169s).inflate(R.layout.ksfeednative_single_imgitemview, (ViewGroup) null, false);
        f fVar = new f(this, viewInflate);
        this.f4171u = fVar;
        a((ViewGroup) viewInflate, fVar, ksNativeAd);
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty() && (ksImage = ksNativeAd.getImageList().get(0)) != null && ksImage.isValid()) {
            this.f4170t.a(this.f4169s, ImageConfigImpl.builder().placeholder(R.drawable.icon_pic_def).url(ksImage.getImageUrl()).imageView(fVar.f4189n).build());
        }
        setRootLinearLayoutBgColor(this.f4171u.f4181i);
        setImagviewNightColor(fVar.f4189n);
        addView(viewInflate);
    }

    private void c(KsNativeAd ksNativeAd) {
        View viewInflate = LayoutInflater.from(this.f4169s).inflate(R.layout.ksfeednative_videoitemview, (ViewGroup) null, false);
        g gVar = new g(this, viewInflate);
        this.f4171u = gVar;
        a((ViewGroup) viewInflate, gVar, ksNativeAd);
        ksNativeAd.setVideoPlayListener(new a(this));
        View videoView = ksNativeAd.getVideoView(this.f4169s, new KsAdVideoPlayConfig.Builder().videoSoundEnable(h.f("ks")).dataFlowAutoStart(true).build());
        if (videoView != null && videoView.getParent() == null) {
            gVar.f4190n.removeAllViews();
            gVar.f4190n.addView(videoView);
        }
        setRootLinearLayoutBgColor(this.f4171u.f4181i);
        addView(viewInflate);
    }

    public void setImagviewNightColor(ImageView... imageViewArr) {
        JsonColorStyle jsonColorStyle = this.f4172v;
        if (jsonColorStyle == null || !(this.f4169s instanceof MkNovelBaseReaderActivity)) {
            return;
        }
        String key = jsonColorStyle.getKey();
        if (TextUtils.isEmpty(key) || !"night".equals(key)) {
            return;
        }
        for (ImageView imageView : imageViewArr) {
            o.a(imageView);
        }
    }

    public void setKsFeedNativeData(KsNativeAd ksNativeAd) {
        int materialType = ksNativeAd.getMaterialType();
        this.f4172v = o.c();
        String str = "快手信息流广告类型：" + materialType;
        if (materialType == 1) {
            c(ksNativeAd);
        } else if (materialType == 2) {
            b(ksNativeAd);
        } else if (materialType == 3) {
            a(ksNativeAd);
        }
        a();
    }

    public void setRootLinearLayoutBgColor(View view) {
        if (this.f4172v == null || !(this.f4169s instanceof MkNovelBaseReaderActivity)) {
            return;
        }
        view.setBackgroundColor(this.f4172v.getPanelBgColor());
    }

    public KsFeedNativeBigAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        if (this.f4169s instanceof MkNovelBaseReaderActivity) {
            this.f4172v = o.c();
            if (this.f4172v == null || this.f4171u == null) {
                return;
            }
            int textColor = this.f4172v.getTextColor();
            this.f4171u.a.setTextColor(textColor);
            this.f4171u.f4175c.setTextColor(textColor);
            this.f4171u.f4184l.setTextColor(textColor);
            int footerColor = this.f4172v.getFooterColor();
            this.f4171u.f4176d.setTextColor(footerColor);
            this.f4171u.f4183k.setTextColor(footerColor);
        }
    }

    public KsFeedNativeBigAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(KsNativeAd ksNativeAd) {
        View viewInflate = LayoutInflater.from(this.f4169s).inflate(R.layout.ksfeednative_groupimg_itemview, (ViewGroup) null, false);
        e eVar = new e(this, viewInflate);
        this.f4171u = eVar;
        a((ViewGroup) viewInflate, eVar, ksNativeAd);
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList != null && !imageList.isEmpty()) {
            for (int i2 = 0; i2 < imageList.size(); i2++) {
                KsImage ksImage = ksNativeAd.getImageList().get(i2);
                if (ksImage != null && ksImage.isValid()) {
                    if (i2 == 0) {
                        this.f4170t.a(this.f4169s, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(ksImage.getImageUrl()).imageView(eVar.f4186n).build());
                    } else if (i2 == 1) {
                        this.f4170t.a(this.f4169s, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(ksImage.getImageUrl()).imageView(eVar.f4187o).build());
                    } else if (i2 == 2) {
                        this.f4170t.a(this.f4169s, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(ksImage.getImageUrl()).imageView(eVar.f4188p).build());
                    }
                }
            }
        }
        setRootLinearLayoutBgColor(this.f4171u.f4181i);
        setImagviewNightColor(eVar.f4186n, eVar.f4187o, eVar.f4188p);
        addView(viewInflate);
    }

    private void a(ViewGroup viewGroup, d dVar, KsNativeAd ksNativeAd) {
        HashMap map = new HashMap();
        map.put(dVar.f4181i, 1);
        map.put(dVar.f4177e, 1);
        map.put(dVar.f4178f, 2);
        map.put(dVar.f4175c, 2);
        map.put(dVar.f4176d, 2);
        if (dVar instanceof f) {
            map.put(((f) dVar).f4189n, 1);
        }
        ksNativeAd.registerViewForInteraction((Activity) getContext(), viewGroup, map, new b(this));
        dVar.a.setText(ksNativeAd.getAdDescription());
        String adSource = ksNativeAd.getAdSource();
        if (TextUtils.isEmpty(adSource)) {
            dVar.f4180h.setVisibility(8);
            dVar.f4180h.setText("");
            dVar.f4179g.setVisibility(8);
        } else {
            com.bumptech.glide.c.e(this.f4169s).mo58load(ksNativeAd.getAdSourceLogoUrl(1)).into(dVar.f4179g);
            dVar.f4180h.setTextColor(-6513508);
            dVar.f4180h.setText(adSource);
        }
        int interactionType = ksNativeAd.getInteractionType();
        if (interactionType != 1) {
            if (interactionType != 2) {
                return;
            }
            dVar.f4183k.setText(ksNativeAd.getAdDescription());
            dVar.f4185m.setText(ksNativeAd.getActionDescription());
            dVar.f4184l.setText(ksNativeAd.getProductName());
            dVar.b.setVisibility(8);
            dVar.f4182j.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            dVar.f4178f.setVisibility(8);
        } else {
            dVar.f4178f.setVisibility(0);
            this.f4170t.a(this.f4169s, ImageConfigImpl.builder().placeholder(R.drawable.ks_app_default_icon).url(ksNativeAd.getAppIconUrl()).imageView(dVar.f4178f).build());
        }
        dVar.f4175c.setText(ksNativeAd.getAppName());
        dVar.f4176d.setText(ksNativeAd.getAdDescription());
        dVar.f4177e.setText(ksNativeAd.getActionDescription());
        a(dVar, ksNativeAd);
        dVar.b.setVisibility(0);
        dVar.f4182j.setVisibility(8);
    }

    private void a(d dVar, KsNativeAd ksNativeAd) {
        ksNativeAd.setDownloadListener(new c(this, dVar, ksNativeAd.getActionDescription()));
    }
}
