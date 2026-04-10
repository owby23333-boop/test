package com.amgcyo.cuttadon.sdk.ks.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsNativeAd;
import java.util.Locale;
import me.jessyan.art.f.e;

/* JADX INFO: loaded from: classes.dex */
public class KsFeedNativeSmallAdView extends BaseSelfRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.jessyan.art.c.e.c f4192t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f4193u;

    class a implements KsNativeAd.AdInteractionListener {
        a(KsFeedNativeSmallAdView ksFeedNativeSmallAdView) {
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

    class b implements KsAppDownloadListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c f4194s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ KsNativeAd f4195t;

        b(KsFeedNativeSmallAdView ksFeedNativeSmallAdView, c cVar, KsNativeAd ksNativeAd) {
            this.f4194s = cVar;
            this.f4195t = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            if (this.f4194s.b != null) {
                if (TextUtils.isEmpty(this.f4195t.getActionDescription())) {
                    this.f4194s.b.setText(this.f4195t.getActionDescription());
                } else {
                    this.f4194s.b.setText("立即下载");
                }
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            TextView textView = this.f4194s.b;
            if (textView != null) {
                textView.setText("立即安装");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            TextView textView = this.f4194s.b;
            if (textView != null) {
                textView.setText("开始下载");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            if (this.f4194s.b != null) {
                if (TextUtils.isEmpty(this.f4195t.getActionDescription())) {
                    this.f4194s.b.setText(this.f4195t.getActionDescription());
                } else {
                    this.f4194s.b.setText("立即下载");
                }
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            TextView textView = this.f4194s.b;
            if (textView != null) {
                textView.setText("立即打开");
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i2) {
            TextView textView = this.f4194s.b;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i2)));
            }
        }
    }

    private class c {
        ImageView a;
        TextView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f4196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f4197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        LinearLayout f4198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        RelativeLayout f4199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ImageView f4200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f4201h;

        c(KsFeedNativeSmallAdView ksFeedNativeSmallAdView, View view) {
            this.a = (ImageView) view.findViewById(R.id.iv_native_image);
            this.b = (TextView) view.findViewById(R.id.btn_native_creative);
            this.f4196c = (TextView) view.findViewById(R.id.qm_tv_native_ad_title);
            this.f4197d = (TextView) view.findViewById(R.id.tv_native_ad_desc);
            this.f4198e = (LinearLayout) view.findViewById(R.id.ll_ad_native_banner);
            this.f4199f = (RelativeLayout) view.findViewById(R.id.rl_img);
            this.f4200g = (ImageView) view.findViewById(R.id.ksad_logo_icon);
            this.f4201h = (TextView) view.findViewById(R.id.ksad_logo_text);
        }
    }

    public KsFeedNativeSmallAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f4191s = context;
        this.f4192t = e.a(this.f4191s).imageLoader();
    }

    public void setKsFeedNativeData(KsNativeAd ksNativeAd) {
        View viewInflate = LayoutInflater.from(this.f4191s).inflate(R.layout.ksfeednative_xiaotu_itemview, (ViewGroup) null, true);
        this.f4193u = new c(this, viewInflate);
        a((ViewGroup) viewInflate, this.f4193u, ksNativeAd);
        removeAllViews();
        if (this.f4191s instanceof MkNovelBaseReaderActivity) {
            a();
        }
        addView(viewInflate);
    }

    public KsFeedNativeSmallAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC = o.c();
        if (jsonColorStyleC == null || this.f4193u == null) {
            return;
        }
        this.f4193u.f4198e.setBackgroundColor(jsonColorStyleC.getPanelBgColor());
        int textColor = jsonColorStyleC.getTextColor();
        this.f4193u.f4197d.setTextColor(jsonColorStyleC.getFooterColor());
        this.f4193u.f4196c.setTextColor(textColor);
        String key = jsonColorStyleC.getKey();
        if (TextUtils.isEmpty(key) || !"night".equals(key)) {
            return;
        }
        o.a(this.f4193u.a);
    }

    public KsFeedNativeSmallAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.ViewGroup r7, com.amgcyo.cuttadon.sdk.ks.view.KsFeedNativeSmallAdView.c r8, com.kwad.sdk.api.KsNativeAd r9) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.ks.view.KsFeedNativeSmallAdView.a(android.view.ViewGroup, com.amgcyo.cuttadon.sdk.ks.view.KsFeedNativeSmallAdView$c, com.kwad.sdk.api.KsNativeAd):void");
    }

    private void a(c cVar, KsNativeAd ksNativeAd) {
        ksNativeAd.setDownloadListener(new b(this, cVar, ksNativeAd));
    }
}
