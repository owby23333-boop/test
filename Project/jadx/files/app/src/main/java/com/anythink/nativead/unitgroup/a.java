package com.anythink.nativead.unitgroup;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.l;
import com.anythink.core.common.b.m;
import com.anythink.core.common.e.e;
import com.anythink.nativead.api.ATNativePrepareInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends BaseAd {
    private static final String TAG = "a";
    protected e mAdTrackingInfo;
    protected ATEventInterface mDownloadListener;
    private l mNativeEventListener;
    private ATNativePrepareInfo nativePrepareInfo;
    public final int NETWORK_UNKNOW = -1;
    protected String mAdSourceType = "0";
    protected int mNetworkType = -1;

    protected a() {
    }

    public abstract void bindDislikeListener(View.OnClickListener onClickListener);

    public abstract void clear(View view);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract View getAdIconView();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract View getAdMediaView(Object... objArr);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdType() {
        return this.mAdSourceType;
    }

    @Override // com.anythink.core.api.BaseAd
    public final e getDetail() {
        return this.mAdTrackingInfo;
    }

    public final ATNativePrepareInfo getNativePrepareInfo() {
        return this.nativePrepareInfo;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i2, int i3, ATShakeViewListener aTShakeViewListener) {
        return null;
    }

    public abstract boolean isNativeExpress();

    public final void notifyAdClicked() {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdClicked(null);
        }
    }

    public final void notifyAdDislikeClick() {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdDislikeButtonClick();
        }
    }

    public final void notifyAdImpression() {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdImpressed();
        }
    }

    public final void notifyAdVideoEnd() {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdVideoEnd();
        }
    }

    public final void notifyAdVideoPlayProgress(int i2) {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdVideoProgress(i2);
        }
    }

    public final void notifyAdVideoStart() {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onAdVideoStart();
        }
    }

    public final void notifyAdVideoVideoPlayFail(String str, String str2) {
        StringBuilder sb = new StringBuilder("notifyAdVideoVideoPlayFail...");
        sb.append(str);
        sb.append(",");
        sb.append(str2);
        l lVar = this.mNativeEventListener;
        if (lVar == null || !(lVar instanceof m)) {
            return;
        }
        ((m) lVar).a(str, str2);
    }

    public final void notifyDeeplinkCallback(boolean z2) {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onDeeplinkCallback(z2);
        }
    }

    public final void notifyDownloadConfirm(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        l lVar = this.mNativeEventListener;
        if (lVar != null) {
            lVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
        }
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void pauseVideo();

    public abstract void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo);

    public abstract void resumeVideo();

    public final void setDownloadListener(ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    @Override // com.anythink.core.api.BaseAd
    public void setNativeEventListener(l lVar) {
        this.mNativeEventListener = lVar;
    }

    public final void setNativePrepareInfo(ATNativePrepareInfo aTNativePrepareInfo) {
        this.nativePrepareInfo = aTNativePrepareInfo;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(e eVar) {
        this.mAdTrackingInfo = eVar;
    }
}
