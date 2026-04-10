package com.anythink.splashad.unitgroup.api;

import android.app.Activity;
import android.view.ViewGroup;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.api.IATSplashEyeAd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomSplashAdapter extends ATBaseAdAdapter {
    ATSplashSkipInfo mATSplashSkipInfo;
    protected int mFetchAdTimeout = 10000;
    protected CustomSplashEventListener mImpressionListener;

    public final void cleanImpressionListener() {
    }

    public IATSplashEyeAd getSplashEyeAd() {
        return null;
    }

    public final ATSplashSkipInfo getSplashSkipInfo() {
        return this.mATSplashSkipInfo;
    }

    public final void internalShow(Activity activity, ViewGroup viewGroup, CustomSplashEventListener customSplashEventListener) {
        this.mImpressionListener = customSplashEventListener;
        show(activity, viewGroup);
    }

    public final boolean isCustomSkipView() {
        ATSplashSkipInfo aTSplashSkipInfo = this.mATSplashSkipInfo;
        if (aTSplashSkipInfo != null) {
            return aTSplashSkipInfo.canUseCustomSkipView();
        }
        return false;
    }

    public boolean isSupportCustomSkipView() {
        return getMixedFormatAdType() == 0;
    }

    public final void setFetchAdTimeout(int i2) {
        this.mFetchAdTimeout = i2;
    }

    public final void setSplashSkipInfo(ATSplashSkipInfo aTSplashSkipInfo) {
        this.mATSplashSkipInfo = aTSplashSkipInfo;
    }

    public abstract void show(Activity activity, ViewGroup viewGroup);

    public void startSplashCustomSkipViewClickEye() {
    }
}
