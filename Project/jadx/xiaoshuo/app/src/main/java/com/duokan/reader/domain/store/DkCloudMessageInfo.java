package com.duokan.reader.domain.store;

import com.duokan.account.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudMessageInfo extends DkStoreItemInfo {
    public long mPublishTime = 0;
    public long mEndTime = 0;
    public String mMessageId = null;
    public String mTitle = null;
    public String mMessage = null;
    public MsgType mType = null;
    public String mActionParams = null;
    public boolean mDirect = true;

    public enum MsgType {
        SYSTEM
    }

    public static DkCloudMessageInfo fromJson(JSONObject jSONObject) {
        try {
            DkCloudMessageInfo dkCloudMessageInfo = new DkCloudMessageInfo();
            try {
                dkCloudMessageInfo.mPublishTime = jSONObject.optLong("publish_time", 0L);
                dkCloudMessageInfo.mEndTime = jSONObject.optLong("end_time", 0L);
                dkCloudMessageInfo.mMessageId = jSONObject.getString("message_id");
                dkCloudMessageInfo.mTitle = jSONObject.getString("title");
                dkCloudMessageInfo.mMessage = jSONObject.getString("message");
                dkCloudMessageInfo.mType = MsgType.valueOf(jSONObject.getString("type").toUpperCase());
                dkCloudMessageInfo.mActionParams = jSONObject.optString(b.c.a.e);
                boolean z = true;
                if (jSONObject.optInt("push_type", 1) != 1) {
                    z = false;
                }
                dkCloudMessageInfo.mDirect = z;
                return dkCloudMessageInfo;
            } catch (Throwable unused) {
                return dkCloudMessageInfo;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
