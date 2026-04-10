package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i2);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
