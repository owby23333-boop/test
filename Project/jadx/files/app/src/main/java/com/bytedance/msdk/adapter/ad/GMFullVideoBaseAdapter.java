package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMFullVideoBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotFullVideo mGMAdSlotFullVideo;

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        GMAdSlotFullVideo gMAdSlotFullVideo;
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotInterstitialFull) {
            gMAdSlotFullVideo = ((GMAdSlotInterstitialFull) gMAdSlotBase).getGMAdSlotFullVideo();
        } else {
            if (!(gMAdSlotBase instanceof GMAdSlotFullVideo)) {
                notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotFullVideo is not GMAdSlotInterstitialFull or GMAdSlotFullVideo"));
                return;
            }
            gMAdSlotFullVideo = (GMAdSlotFullVideo) gMAdSlotBase;
        }
        this.mGMAdSlotFullVideo = gMAdSlotFullVideo;
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail mGMAdSlotFullVideo is null"));
    }
}
