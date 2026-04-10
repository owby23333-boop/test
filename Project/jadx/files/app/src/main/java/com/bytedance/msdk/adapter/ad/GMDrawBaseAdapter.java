package com.bytedance.msdk.adapter.ad;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMDrawBaseAdapter extends TTAbsAdLoaderAdapter {
    public GMAdSlotDraw mGMAdSlotDraw;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Context f13949z;

    public Context getContext() {
        return this.f13949z;
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(Context context, Map<String, Object> map) {
        this.f13949z = context;
        GMAdSlotBase gMAdSlotBase = this.mGMAdSlotBase;
        if (gMAdSlotBase instanceof GMAdSlotDraw) {
            this.mGMAdSlotDraw = (GMAdSlotDraw) gMAdSlotBase;
        } else {
            notifyAdFailed(new AdError("ClassCastException：load ad fail mGMAdSlotDraw is not GMAdSlotDraw"));
        }
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyAdFailed(new AdError("load ad fail mGMAdSlotDraw is null"));
    }
}
