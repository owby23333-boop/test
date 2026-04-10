package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.ui.component.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediaAdView extends BaseMediaAdView {
    public static final String TAG = "anythink_" + MediaAdView.class.getSimpleName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    RelativeLayout f6205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    RelativeLayout f6206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TextView f6207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TextView f6208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TextView f6209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TextView f6210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final float f6211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f6212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f6214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f6215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageView f6216r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RoundImageView f6217s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f6218t;

    public MediaAdView(Context context, i iVar, j jVar, boolean z2, BaseMediaAdView.a aVar) {
        super(context, iVar, jVar, z2, aVar);
        this.f6211m = 1.0f;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public List<View> getClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6212n);
        arrayList.add(this.f6215q);
        arrayList.add(this.f6213o);
        arrayList.add(this.f6217s);
        arrayList.add(this.f6218t);
        k kVar = this.b;
        if (kVar != null && kVar.x() == 0) {
            arrayList.add(this.f6214p);
            arrayList.add(this.f6205g);
        }
        return arrayList;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public View getMonitorClickView() {
        return this.f6213o;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void init(int i2, int i3) {
        View viewFindViewById;
        super.init(i2, i3);
        View viewInflate = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_media_ad_view", "layout"), (ViewGroup) null, false);
        FrameLayout frameLayout = this.f6139f;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f6139f.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f6212n = (TextView) findViewById(h.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.f6213o = (TextView) findViewById(h.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.f6214p = (ImageView) findViewById(h.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.f6215q = (ImageView) findViewById(h.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.f6216r = (ImageView) findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        this.f6217s = (RoundImageView) findViewById(h.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.f6218t = (TextView) findViewById(h.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.f6205g = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_media_ad_container", "id"));
        this.f6206h = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.f6207i = (TextView) findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.f6208j = (TextView) findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.f6209k = (TextView) findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.f6210l = (TextView) findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        String strR = this.a.r();
        if (TextUtils.isEmpty(strR)) {
            this.f6212n.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.f6218t.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 0;
                this.f6218t.setLayoutParams(layoutParams);
            }
        } else {
            this.f6212n.setText(strR);
        }
        String strW = this.a.w();
        if (TextUtils.isEmpty(strW)) {
            this.f6213o.setText(h.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.f10649g));
        } else {
            this.f6213o.setText(strW);
        }
        this.f6215q.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.u()), i2, i3, new b.a() { // from class: com.anythink.basead.ui.MediaAdView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
                String str3 = MediaAdView.TAG;
                "load: image load fail:".concat(String.valueOf(str2));
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(MediaAdView.this.a.u(), str)) {
                    MediaAdView.this.f6215q.setImageBitmap(bitmap);
                    MediaAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.MediaAdView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            int[] iArrA = u.a(MediaAdView.this.getWidth(), MediaAdView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) MediaAdView.this.f6215q.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = iArrA[0];
                                layoutParams2.height = iArrA[1];
                                layoutParams2.addRule(13);
                                MediaAdView.this.f6215q.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                    Bitmap bitmapA = com.anythink.core.common.k.b.a(MediaAdView.this.getContext(), bitmap);
                    MediaAdView.this.f6214p.setScaleType(ImageView.ScaleType.FIT_XY);
                    MediaAdView.this.f6214p.setImageBitmap(bitmapA);
                }
            }
        });
        if (TextUtils.isEmpty(this.a.v())) {
            this.f6216r.setVisibility(8);
        } else {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.v()), new b.a() { // from class: com.anythink.basead.ui.MediaAdView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    MediaAdView.this.f6216r.setVisibility(8);
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(MediaAdView.this.a.v(), str)) {
                        MediaAdView.this.f6216r.setImageBitmap(bitmap);
                        ViewGroup.LayoutParams layoutParams2 = MediaAdView.this.f6216r.getLayoutParams();
                        int i4 = layoutParams2.height;
                        layoutParams2.width = (int) (i4 * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                        layoutParams2.height = i4;
                        MediaAdView.this.f6216r.setLayoutParams(layoutParams2);
                        MediaAdView.this.f6216r.setScaleType(ImageView.ScaleType.FIT_XY);
                        MediaAdView.this.f6216r.setImageBitmap(bitmap);
                        MediaAdView.this.f6216r.setVisibility(0);
                    }
                }
            });
        }
        String strS = this.a.s();
        if (TextUtils.isEmpty(strS)) {
            this.f6218t.setVisibility(8);
        } else {
            this.f6218t.setText(strS);
        }
        if (TextUtils.isEmpty(this.a.t())) {
            this.f6217s.setVisibility(8);
        } else {
            this.f6217s.setRadiusInDip(6);
            this.f6217s.setNeedRadiu(true);
            ViewGroup.LayoutParams layoutParams2 = this.f6217s.getLayoutParams();
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.t()), layoutParams2.width, layoutParams2.height, new b.a() { // from class: com.anythink.basead.ui.MediaAdView.3
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(MediaAdView.this.a.t(), str)) {
                        MediaAdView.this.f6217s.setImageBitmap(bitmap);
                    }
                }
            });
        }
        if (this.a.K()) {
            RelativeLayout relativeLayout = this.f6206h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.f6206h.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
            TextView textView = this.f6207i;
            if (textView != null) {
                textView.setVisibility(0);
                this.f6207i.setText(this.a.F());
                this.f6207i.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
            TextView textView2 = this.f6208j;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.f6208j.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.b(n.a().g(), MediaAdView.this.a.H());
                    }
                });
            }
            TextView textView3 = this.f6209k;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f6209k.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.b(n.a().g(), MediaAdView.this.a.I());
                    }
                });
            }
            TextView textView4 = this.f6210l;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.f6210l.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.f10649g), this.a.G()));
                this.f6210l.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
        }
        if (com.anythink.basead.a.e.a(this.a) || (viewFindViewById = findViewById(h.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = viewFindViewById.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = h.a(getContext(), 84.0f);
            viewFindViewById.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }
}
