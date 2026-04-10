package com.amgcyo.cuttadon.sdk.self.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.j;
import com.fatcatfat.io.R;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class SelfSWXTAdView extends BaseSelfRenderView {
    SelfAdLogoFrameLayout A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4209s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    me.jessyan.art.c.e.c f4210t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    View f4211u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    TextView f4212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    TextView f4213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    TextView f4214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    LinearLayout f4215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ImageView f4216z;

    class a implements g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4217s;

        a(NewApiAd newApiAd) {
            this.f4217s = newApiAd;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            SelfSWXTAdView selfSWXTAdView = SelfSWXTAdView.this;
            selfSWXTAdView.a(selfSWXTAdView.f4216z, 5, selfSWXTAdView.f4209s);
            SelfSWXTAdView selfSWXTAdView2 = SelfSWXTAdView.this;
            selfSWXTAdView2.setAdLogoStatus(selfSWXTAdView2.A);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            SelfSWXTAdView selfSWXTAdView = SelfSWXTAdView.this;
            selfSWXTAdView.a(selfSWXTAdView.f4209s, this.f4217s);
            SelfSWXTAdView selfSWXTAdView2 = SelfSWXTAdView.this;
            selfSWXTAdView2.setAdLogoStatus(selfSWXTAdView2.A);
            return false;
        }
    }

    public SelfSWXTAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public void setEndAdData(final NewApiAd newApiAd) {
        a();
        this.f4213w.setText(newApiAd.getName());
        this.f4214x.setText(newApiAd.getDesc());
        this.f4215y.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.self.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4244s.a(newApiAd, view);
            }
        });
        String image = newApiAd.getImage();
        if (!TextUtils.isEmpty(image)) {
            this.f4210t.a(this.f4209s, ImageConfigImpl.builder().url(image).imageRadius(8).isNeedPlaceholder(false).imageView(this.f4216z).listener(new a(newApiAd)).build());
        }
        if (newApiAd.getDown_type() == 1) {
            this.f4212v.setText(o.d(R.string.ljxz));
        } else {
            this.f4212v.setText(o.d(R.string.ckxq));
        }
        addView(this.f4211u);
    }

    public SelfSWXTAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SelfSWXTAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.f4209s = context;
        this.f4211u = LayoutInflater.from(context).inflate(R.layout.selfendbigbannerad_layout, (ViewGroup) null, false);
        this.f4213w = (TextView) this.f4211u.findViewById(R.id.tv_native_ad_title);
        this.f4214x = (TextView) this.f4211u.findViewById(R.id.tv_native_ad_desc);
        this.f4215y = (LinearLayout) this.f4211u.findViewById(R.id.rl_ad_root);
        this.A = (SelfAdLogoFrameLayout) this.f4211u.findViewById(R.id.selfadlogo_fl);
        this.f4216z = this.A.getIv_native_image();
        this.f4212v = (TextView) this.f4211u.findViewById(R.id.btn_native_creative);
        this.f4210t = e.a(this.f4209s).imageLoader();
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC;
        if (!(this.f4209s instanceof MkNovelBaseReaderActivity) || (jsonColorStyleC = o.c()) == null || this.f4212v == null) {
            return;
        }
        this.f4215y.setBackgroundColor(jsonColorStyleC.getPanelBgColor());
        int textColor = jsonColorStyleC.getTextColor();
        this.f4214x.setTextColor(textColor);
        this.f4213w.setTextColor(textColor);
        String key = jsonColorStyleC.getKey();
        if (!TextUtils.isEmpty(key) && "night".equals(key)) {
            o.a(this.f4216z);
        }
        this.f4212v.setBackground(o.a(-1, n.a(5.0f), -1, (String) null, jsonColorStyleC.getTint()));
        this.f4212v.setTextColor(o.b(R.color.white));
    }

    public /* synthetic */ void a(NewApiAd newApiAd, View view) {
        com.amgcyo.cuttadon.h.h.a.a(this.f4209s, newApiAd);
    }
}
