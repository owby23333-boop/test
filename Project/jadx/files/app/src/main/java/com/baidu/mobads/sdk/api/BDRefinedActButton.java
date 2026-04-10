package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;

/* JADX INFO: loaded from: classes2.dex */
public class BDRefinedActButton extends LinearLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDRefinedActButton(Context context) {
        this(context, null, 0);
    }

    private void initView(Context context) {
        try {
            this.mContext = context;
            Object[] objArr = {this.mContext};
            this.mLoader = bp.a(this.mContext);
            this.mAdView = (View) ar.a(w.f13183h, this.mLoader, (Class<?>[]) new Class[]{Context.class}, objArr);
            if (this.mAdView != null) {
                addView(this.mAdView, new RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdData(NativeResponse nativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    public void setButtonBackgroundColor(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setButtonBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setButtonFontSizeSp(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setButtonFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setButtonFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setButtonFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setButtonTextColor(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setButtonTextColor", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setIsShowDialog(boolean z2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(w.f13183h, view, this.mLoader, "setIsShowDialog", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public BDRefinedActButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDRefinedActButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context);
    }
}
