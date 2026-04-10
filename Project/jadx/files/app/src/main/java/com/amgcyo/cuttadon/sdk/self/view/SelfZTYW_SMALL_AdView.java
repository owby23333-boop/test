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
public class SelfZTYW_SMALL_AdView extends BaseSelfRenderView {
    LinearLayout A;
    ImageView B;
    SelfAdLogoFrameLayout C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    me.jessyan.art.c.e.c f4229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Context f4230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    TextView f4231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ImageView f4232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    View f4233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    TextView f4234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    TextView f4235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    TextView f4236z;

    class a implements g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4237s;

        a(NewApiAd newApiAd) {
            this.f4237s = newApiAd;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            SelfZTYW_SMALL_AdView selfZTYW_SMALL_AdView = SelfZTYW_SMALL_AdView.this;
            selfZTYW_SMALL_AdView.setAdLogoStatus(selfZTYW_SMALL_AdView.C);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            SelfZTYW_SMALL_AdView.this.getViewHeight();
            SelfZTYW_SMALL_AdView selfZTYW_SMALL_AdView = SelfZTYW_SMALL_AdView.this;
            selfZTYW_SMALL_AdView.setAdLogoStatus(selfZTYW_SMALL_AdView.C);
            SelfZTYW_SMALL_AdView selfZTYW_SMALL_AdView2 = SelfZTYW_SMALL_AdView.this;
            selfZTYW_SMALL_AdView2.a(selfZTYW_SMALL_AdView2.f4230t, this.f4237s);
            return false;
        }
    }

    public SelfZTYW_SMALL_AdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public void setBottomAdData(final NewApiAd newApiAd) {
        if (this.f4234x == null) {
            return;
        }
        removeAllViews();
        this.f4231u = (TextView) this.f4233w.findViewById(R.id.btn_native_creative);
        this.f4234x.setText(newApiAd.getName());
        a();
        this.f4235y.setText(newApiAd.getDesc());
        String image = newApiAd.getImage();
        if (!TextUtils.isEmpty(image)) {
            this.f4229s.a(this.f4230t, ImageConfigImpl.builder().url(image).imageRadius(8).isNeedPlaceholder(false).listener(new a(newApiAd)).imageView(this.f4232v).build());
        }
        if (newApiAd.getDown_type() == 1) {
            this.f4231u.setText(o.d(R.string.ljxz));
        } else {
            this.f4231u.setText(o.d(R.string.ckxq));
        }
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.self.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4248s.a(newApiAd, view);
            }
        });
        addView(this.f4233w);
    }

    public SelfZTYW_SMALL_AdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.f4230t = context;
        this.f4233w = LayoutInflater.from(context).inflate(R.layout.selfbottomadview_layout, (ViewGroup) null, false);
        View view = this.f4233w;
        if (view == null) {
            return;
        }
        this.C = (SelfAdLogoFrameLayout) view.findViewById(R.id.selfadlogo_fl);
        this.f4232v = this.C.getIv_native_image();
        ViewGroup.LayoutParams layoutParams = this.f4232v.getLayoutParams();
        layoutParams.height = -1;
        this.f4232v.setLayoutParams(layoutParams);
        this.f4234x = (TextView) this.f4233w.findViewById(R.id.qm_tv_native_ad_title);
        this.f4231u = (TextView) this.f4233w.findViewById(R.id.btn_native_creative);
        this.f4235y = (TextView) this.f4233w.findViewById(R.id.tv_native_ad_desc);
        this.A = (LinearLayout) this.f4233w.findViewById(R.id.ll_ad_native_banner);
        this.f4236z = (TextView) this.f4233w.findViewById(R.id.tv_native_ad_from);
        this.B = (ImageView) this.f4233w.findViewById(R.id.img_native_dislike);
        this.B.setVisibility(8);
        this.f4229s = e.a(this.f4230t).imageLoader();
    }

    public SelfZTYW_SMALL_AdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
        JsonColorStyle jsonColorStyleC;
        if (!(this.f4230t instanceof MkNovelBaseReaderActivity) || (jsonColorStyleC = o.c()) == null || this.f4231u == null) {
            return;
        }
        this.A.setBackgroundColor(jsonColorStyleC.getPanelBgColor());
        int textColor = jsonColorStyleC.getTextColor();
        int footerColor = jsonColorStyleC.getFooterColor();
        this.f4235y.setTextColor(footerColor);
        this.f4236z.setTextColor(footerColor);
        this.f4236z.setTextColor(footerColor);
        this.f4234x.setTextColor(textColor);
        String key = jsonColorStyleC.getKey();
        if (!TextUtils.isEmpty(key) && "night".equals(key)) {
            o.a(this.f4232v);
        }
        this.f4231u.setBackground(o.a(-1, n.a(5.0f), -1, (String) null, jsonColorStyleC.getTint()));
    }

    public /* synthetic */ void a(NewApiAd newApiAd, View view) {
        com.amgcyo.cuttadon.h.h.a.a(this.f4230t, newApiAd);
    }
}
