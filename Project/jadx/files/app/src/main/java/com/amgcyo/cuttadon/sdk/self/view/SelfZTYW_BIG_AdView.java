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
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.j;
import com.fatcatfat.io.R;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class SelfZTYW_BIG_AdView extends BaseSelfRenderView {
    TextView A;
    LinearLayout B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4219s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    me.jessyan.art.c.e.c f4220t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    View f4221u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ImageView f4222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    SelfAdLogoFrameLayout f4223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    TextView f4224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    TextView f4225y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    TextView f4226z;

    class a implements g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4227s;

        a(NewApiAd newApiAd) {
            this.f4227s = newApiAd;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            SelfZTYW_BIG_AdView selfZTYW_BIG_AdView = SelfZTYW_BIG_AdView.this;
            selfZTYW_BIG_AdView.a(selfZTYW_BIG_AdView.f4222v, 4, selfZTYW_BIG_AdView.f4219s);
            SelfZTYW_BIG_AdView selfZTYW_BIG_AdView2 = SelfZTYW_BIG_AdView.this;
            selfZTYW_BIG_AdView2.setAdLogoStatus(selfZTYW_BIG_AdView2.f4223w);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            SelfZTYW_BIG_AdView selfZTYW_BIG_AdView = SelfZTYW_BIG_AdView.this;
            selfZTYW_BIG_AdView.a(selfZTYW_BIG_AdView.f4219s, this.f4227s);
            SelfZTYW_BIG_AdView selfZTYW_BIG_AdView2 = SelfZTYW_BIG_AdView.this;
            selfZTYW_BIG_AdView2.setAdLogoStatus(selfZTYW_BIG_AdView2.f4223w);
            return false;
        }
    }

    public SelfZTYW_BIG_AdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public SelfZTYW_BIG_AdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SelfZTYW_BIG_AdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.f4219s = context;
        this.f4221u = LayoutInflater.from(context).inflate(R.layout.selefendpicsingle_layout, (ViewGroup) this, false);
        this.f4224x = (TextView) this.f4221u.findViewById(R.id.btn_native_creative);
        this.f4225y = (TextView) this.f4221u.findViewById(R.id.tv_listitem_ad_title);
        this.f4226z = (TextView) this.f4221u.findViewById(R.id.tv_listitem_ad_desc);
        this.A = (TextView) this.f4221u.findViewById(R.id.tv_listitem_ad_source);
        this.f4223w = (SelfAdLogoFrameLayout) this.f4221u.findViewById(R.id.selfadlogo_fl);
        this.f4222v = this.f4223w.getIv_native_image();
        ViewGroup.LayoutParams layoutParams = this.f4222v.getLayoutParams();
        layoutParams.height = -1;
        this.f4222v.setLayoutParams(layoutParams);
        this.B = (LinearLayout) this.f4221u.findViewById(R.id.rl_ad_root);
        this.f4220t = e.a(this.f4219s).imageLoader();
    }

    public void a(final NewApiAd newApiAd) {
        removeAllViews();
        a();
        if (newApiAd.getDown_type() == 1) {
            this.f4224x.setText(o.d(R.string.ljxz));
        } else {
            this.f4224x.setText(o.d(R.string.ckxq));
        }
        this.f4225y.setText(newApiAd.getName());
        this.f4226z.setText(newApiAd.getDesc());
        String image = newApiAd.getImage();
        if (!TextUtils.isEmpty(image)) {
            this.f4220t.a(this.f4219s, ImageConfigImpl.builder().url(image).imageRadius(8).isNeedPlaceholder(false).imageView(this.f4222v).listener(new a(newApiAd)).build());
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.self.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4246s.a(newApiAd, view);
                }
            });
        }
        addView(this.f4221u);
    }

    public /* synthetic */ void a(NewApiAd newApiAd, View view) {
        com.amgcyo.cuttadon.h.h.a.a(this.f4219s, newApiAd);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC;
        if (!(this.f4219s instanceof MkNovelBaseReaderActivity) || (jsonColorStyleC = o.c()) == null) {
            return;
        }
        int panelBgColor = jsonColorStyleC.getPanelBgColor();
        int textColor = jsonColorStyleC.getTextColor();
        int footerColor = jsonColorStyleC.getFooterColor();
        this.B.setBackgroundColor(panelBgColor);
        this.f4225y.setTextColor(textColor);
        this.f4226z.setTextColor(footerColor);
        this.A.setTextColor(footerColor);
        String key = jsonColorStyleC.getKey();
        if (TextUtils.isEmpty(key) || !"night".equals(key)) {
            return;
        }
        o.a(this.f4222v);
    }
}
