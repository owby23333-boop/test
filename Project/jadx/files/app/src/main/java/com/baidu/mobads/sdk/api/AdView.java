package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.cp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cp mAdProd;

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        if (this.hasCalledRequestMethod.get()) {
            return;
        }
        this.hasCalledRequestMethod.set(true);
        this.mAdProd.a();
    }

    public void destroy() {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.e();
        }
    }

    public void setAppSid(String str) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.g(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bq.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int iMin = layoutParams.width;
        int iMin2 = layoutParams.height;
        DisplayMetrics displayMetricsF = ax.f(getContext());
        int i2 = displayMetricsF.widthPixels;
        int i3 = displayMetricsF.heightPixels;
        float f2 = displayMetricsF.density;
        bq.a().a("AdView.setLayoutParams", Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2));
        if (iMin <= 0) {
            iMin = Math.min(i2, i3);
        } else if (iMin > 0) {
            float f3 = 200.0f * f2;
            if (iMin < f3) {
                iMin = (int) f3;
            }
        }
        if (iMin2 <= 0) {
            iMin2 = (int) (Math.min(i2, i3) * HEIGHT_FACTOR);
        } else if (iMin2 > 0) {
            float f4 = f2 * 30.0f;
            if (iMin2 < f4) {
                iMin2 = (int) f4;
            }
        }
        layoutParams.width = iMin;
        layoutParams.height = iMin2;
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(iMin);
            this.mAdProd.c(iMin2);
        }
        bq.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    AdView(Context context, boolean z2, AdSize adSize, String str) {
        this(context, null, z2, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z2, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        co coVar = new co(context);
        this.mAdProd = new cp(this, context, coVar, str, z2);
        coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i2, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onLayoutComplete(int i2, int i3) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowFocusChanged(boolean z3) {
                AdView.this.mAdProd.a(z3);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowVisibilityChanged(int i2) {
                AdView.this.mAdProd.b(i2);
            }
        });
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
