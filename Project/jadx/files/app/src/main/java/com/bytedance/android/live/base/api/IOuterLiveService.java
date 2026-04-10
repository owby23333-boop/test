package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public interface IOuterLiveService extends IOuterLiveRoomService {
    void enterLiveRoom(Context context, long j2, Bundle bundle);

    ILiveOuterPreviewCoverView makePreviewCoverView(Context context, Bundle bundle);

    ILiveOuterPreviewFragment makePreviewFragment();
}
