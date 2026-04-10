package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ILiveProvider {
    String getIdentity();

    ILiveView getLiveView(Context context, int i2, String str, boolean z2, Bundle bundle);

    List<RoomInfo> getRoomInfoList(int i2, int i3, int i4);

    void startLive(Context context, int i2, String str, Bundle bundle);
}
