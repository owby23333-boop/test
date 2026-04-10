package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager hW;
    private int iA;
    private final ViewPager.OnPageChangeListener iB;
    private ImageView iw;
    private ImageView ix;
    private ImageView iy;
    private int iz;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.iB = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i3) {
                ImageView imageView;
                float f2;
                InterstitialAggregateManualTipsView.this.iz = i3;
                if (InterstitialAggregateManualTipsView.this.iz == InterstitialAggregateManualTipsView.this.iA - 1) {
                    imageView = InterstitialAggregateManualTipsView.this.iw;
                    f2 = 0.5f;
                } else {
                    imageView = InterstitialAggregateManualTipsView.this.iw;
                    f2 = 1.0f;
                }
                imageView.setAlpha(f2);
                InterstitialAggregateManualTipsView.this.ix.setAlpha(f2);
            }
        };
        this.mContext = context;
        initView();
    }

    private void cC() {
        int i2 = this.iz;
        if (i2 < this.iA - 1) {
            this.hW.setCurrentItem(i2 + 1, true);
        }
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.iw = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.ix = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        this.iy = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        com.kwad.sdk.b.kwai.a.a(this, this.iw, this.ix, this.iy);
    }

    public final void a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.hW = transViewPager;
        this.iz = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.iA = aVar.getCount();
        new d(this.hW.getContext()).a(this.hW);
        this.hW.addOnPageChangeListener(this.iB);
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String strCP = com.kwad.sdk.core.response.a.b.cP(adInfoCb);
        String strCQ = com.kwad.sdk.core.response.a.b.cQ(adInfoCb);
        String strCR = com.kwad.sdk.core.response.a.b.cR(adInfoCb);
        if (TextUtils.isEmpty(strCP) || TextUtils.isEmpty(strCQ) || TextUtils.isEmpty(strCR)) {
            setVisibility(8);
            return;
        }
        KSImageLoader.loadImage(this.iw, strCP);
        KSImageLoader.loadImage(this.ix, strCQ);
        KSImageLoader.loadImage(this.iy, strCR);
        com.kwad.sdk.core.report.a.b(adTemplate, 162, (JSONObject) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.e.c cVarB;
        AdTemplate adTemplate;
        int i2;
        if (view.equals(this.iw)) {
            cC();
            adTemplate = this.mAdTemplate;
            i2 = 162;
        } else {
            if (!view.equals(this.ix)) {
                if (!view.equals(this.iy) || (cVarB = this.hW.B(this.iz)) == null) {
                    return;
                }
                cVarB.ey();
                return;
            }
            cC();
            adTemplate = this.mAdTemplate;
            i2 = 36;
        }
        com.kwad.sdk.core.report.a.p(adTemplate, i2);
    }
}
