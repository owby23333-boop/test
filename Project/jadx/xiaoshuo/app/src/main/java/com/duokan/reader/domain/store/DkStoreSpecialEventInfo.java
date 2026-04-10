package com.duokan.reader.domain.store;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreSpecialEventInfo extends DkStoreItemInfo {
    public String mEventName = null;
    public long mStartTime = 0;
    public long mEndTime = 0;
    public long mServerTime = 0;
    public long mClientTime = 0;
    public JSONArray mStrategy = null;
    public SpecialEventType mEventType = SpecialEventType.UNKNOWN;

    public enum SpecialEventType {
        FULL_CUT,
        UNKNOWN
    }
}
