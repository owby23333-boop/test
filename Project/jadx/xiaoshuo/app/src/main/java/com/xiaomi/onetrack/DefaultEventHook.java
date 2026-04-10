package com.xiaomi.onetrack;

import com.xiaomi.onetrack.OneTrack;

/* JADX INFO: loaded from: classes8.dex */
public class DefaultEventHook implements OneTrack.IEventHook {
    @Override // com.xiaomi.onetrack.OneTrack.IEventHook
    public boolean isCustomDauEvent(String str) {
        return false;
    }

    @Override // com.xiaomi.onetrack.OneTrack.IEventHook
    public boolean isRecommendEvent(String str) {
        return false;
    }
}
