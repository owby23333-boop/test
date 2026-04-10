package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMBannerBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotBanner mGMAdSlotBanner;

    public final int[] getBannerSize(int i2, GMAdSlotBanner gMAdSlotBanner) {
        switch (i2) {
            case 2:
                return new int[]{TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 100};
            case 3:
                return new int[]{300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION};
            case 4:
                return new int[]{468, 60};
            case 5:
                return new int[]{728, 90};
            case 6:
                if (gMAdSlotBanner.getWidth() > 0 && gMAdSlotBanner.getHeight() > 0) {
                    return new int[]{gMAdSlotBanner.getWidth(), gMAdSlotBanner.getHeight()};
                }
                break;
        }
        return new int[]{TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 50};
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotBanner) {
            this.mGMAdSlotBanner = (GMAdSlotBanner) gMAdSlotBase;
        } else {
            notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotBanner is not GMAdSlotBanner"));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail GMAdSlotBanner is null"));
    }
}
