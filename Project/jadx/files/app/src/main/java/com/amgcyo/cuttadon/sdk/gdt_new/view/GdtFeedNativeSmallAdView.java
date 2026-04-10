package com.amgcyo.cuttadon.sdk.gdt_new.view;

import android.content.Context;
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
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import me.jessyan.art.c.e.c;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class GdtFeedNativeSmallAdView extends BaseSelfRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f4153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private b f4154u;

    class a implements NativeADEventListener {
        final /* synthetic */ b a;
        final /* synthetic */ NativeUnifiedADData b;

        a(GdtFeedNativeSmallAdView gdtFeedNativeSmallAdView, b bVar, NativeUnifiedADData nativeUnifiedADData) {
            this.a = bVar;
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
            com.amgcyo.cuttadon.h.c.b.a(this.a.b, this.b);
        }
    }

    private class b {
        ImageView a;
        TextView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f4155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f4156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        LinearLayout f4157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        LinearLayout f4158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        RelativeLayout f4159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        NativeAdContainer f4160h;

        b(GdtFeedNativeSmallAdView gdtFeedNativeSmallAdView, View view) {
            this.a = (ImageView) view.findViewById(R.id.iv_native_image);
            this.b = (TextView) view.findViewById(R.id.btn_native_creative);
            this.f4155c = (TextView) view.findViewById(R.id.qm_tv_native_ad_title);
            this.f4156d = (TextView) view.findViewById(R.id.tv_native_ad_desc);
            this.f4157e = (LinearLayout) view.findViewById(R.id.ll_ad_native_banner);
            this.f4158f = (LinearLayout) view.findViewById(R.id.ll_text);
            this.f4159g = (RelativeLayout) view.findViewById(R.id.rl_img);
            this.f4160h = (NativeAdContainer) view.findViewById(R.id.native_ad_container);
        }
    }

    public GdtFeedNativeSmallAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC = o.c();
        if (jsonColorStyleC == null || this.f4154u == null) {
            return;
        }
        int panelBgColor = jsonColorStyleC.getPanelBgColor();
        this.f4154u.f4157e.setBackgroundColor(panelBgColor);
        this.f4154u.f4160h.setBackgroundColor(panelBgColor);
        int textColor = jsonColorStyleC.getTextColor();
        this.f4154u.f4156d.setTextColor(jsonColorStyleC.getFooterColor());
        this.f4154u.f4155c.setTextColor(textColor);
        String key = jsonColorStyleC.getKey();
        if (TextUtils.isEmpty(key) || !"night".equals(key)) {
            return;
        }
        o.a(this.f4154u.a);
    }

    public void setGdtNewFeedNativeData(NativeUnifiedADData nativeUnifiedADData) {
        View viewInflate = LayoutInflater.from(this.f4152s).inflate(R.layout.gdt_native_xiaotu_itemview, (ViewGroup) null, true);
        this.f4154u = new b(this, viewInflate);
        a(this.f4154u, nativeUnifiedADData);
        removeAllViews();
        if (this.f4152s instanceof MkNovelBaseReaderActivity) {
            a();
        }
        addView(viewInflate);
    }

    public GdtFeedNativeSmallAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GdtFeedNativeSmallAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f4152s = context;
        this.f4153t = e.a(this.f4152s).imageLoader();
    }

    private void a(b bVar, NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.b);
        arrayList.add(bVar.a);
        arrayList.add(bVar.f4158f);
        nativeUnifiedADData.bindAdToView(this.f4152s, bVar.f4160h, null, arrayList, new ArrayList(arrayList));
        nativeUnifiedADData.setNativeAdEventListener(new a(this, bVar, nativeUnifiedADData));
        bVar.f4156d.setText(nativeUnifiedADData.getDesc());
        bVar.f4155c.setText(nativeUnifiedADData.getTitle());
        com.amgcyo.cuttadon.h.c.b.a(bVar.b, nativeUnifiedADData);
        String iconUrl = nativeUnifiedADData.getIconUrl();
        ViewGroup.LayoutParams layoutParams = bVar.a.getLayoutParams();
        if (!TextUtils.isEmpty(iconUrl)) {
            String str = "icon url not null :" + iconUrl;
            layoutParams.width = n.a(52.0f);
            layoutParams.height = n.a(52.0f);
        } else {
            iconUrl = nativeUnifiedADData.getImgUrl();
            layoutParams.width = n.a(85.0f);
            layoutParams.height = n.a(52.0f);
        }
        bVar.a.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(iconUrl)) {
            bVar.f4159g.setVisibility(0);
            this.f4153t.a(this.f4152s, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(iconUrl).imageView(bVar.a).build());
        } else {
            bVar.f4159g.setVisibility(8);
        }
    }
}
