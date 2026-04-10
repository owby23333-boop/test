package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cR(adInfo) ? ILivePush.ClickType.LIVE : com.kwad.sdk.core.response.b.a.bd(adInfo) ? "image" : com.kwad.sdk.core.response.b.a.cf(adInfo) ? "reward_preview" : "video";
    }
}
