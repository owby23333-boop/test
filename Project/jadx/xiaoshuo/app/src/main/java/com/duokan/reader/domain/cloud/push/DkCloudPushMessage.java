package com.duokan.reader.domain.cloud.push;

import com.duokan.free.tts.service.e;
import com.duokan.reader.domain.cloud.DkCloudItem;
import com.duokan.reader.domain.cloud.DkCloudJsonItem;
import com.duokan.reader.domain.store.DkCloudMessageInfo;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudPushMessage extends DkCloudJsonItem {
    private static final long MESSAGE_VERSION = 0;
    private static final long serialVersionUID = 1;
    private ActionType mActionType;
    private final DkCloudMessageInfo mMessageInfo;
    private final String mMiServerMsgId;
    private Date mReceivedDate;
    private boolean mReportMiServer;

    public enum ActionType {
        PROMPT,
        BOOK_DETAIL,
        BOOK_TOPIC,
        FICTION_DETAIL,
        FICTION_TOPIC,
        URL
    }

    public DkCloudPushMessage(String str, boolean z, DkCloudMessageInfo dkCloudMessageInfo) {
        super(0L);
        this.mReceivedDate = new Date();
        this.mMiServerMsgId = str;
        this.mReportMiServer = z;
        this.mMessageInfo = dkCloudMessageInfo;
        try {
            JSONObject jSONObject = new JSONObject(dkCloudMessageInfo.mActionParams);
            if (jSONObject.has("book_id")) {
                this.mActionType = ActionType.BOOK_DETAIL;
            } else if (jSONObject.has("book_topic_id")) {
                this.mActionType = ActionType.BOOK_TOPIC;
            } else if (jSONObject.has(e.c.f3725a)) {
                this.mActionType = ActionType.FICTION_DETAIL;
            } else if (jSONObject.has("fiction_topic_id")) {
                this.mActionType = ActionType.FICTION_TOPIC;
            } else if (jSONObject.has("url")) {
                this.mActionType = ActionType.URL;
            } else {
                this.mActionType = ActionType.PROMPT;
            }
        } catch (Exception unused) {
            this.mActionType = ActionType.PROMPT;
        }
    }

    public String getActionParamString() {
        return this.mMessageInfo.mActionParams;
    }

    public String getActionUrl() {
        try {
            return new JSONObject(this.mMessageInfo.mActionParams).getString("url");
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return this.mMessageInfo.mMessageId;
    }

    public long getEndTime() {
        return this.mMessageInfo.mEndTime * 1000;
    }

    public boolean getIsDirect() {
        return this.mMessageInfo.mDirect;
    }

    public boolean getIsReportMiServer() {
        return this.mReportMiServer;
    }

    public String getMessageContent() {
        return this.mMessageInfo.mMessage;
    }

    public String getMessageTitle() {
        return this.mMessageInfo.mTitle;
    }

    public ActionType getMessageType() {
        return this.mActionType;
    }

    public String getMiServerMsgId() {
        return this.mMiServerMsgId;
    }

    public long getPublishTime() {
        return this.mMessageInfo.mPublishTime;
    }

    public Date getReceivedDate() {
        return this.mReceivedDate;
    }

    public void markReportMiServer() {
        this.mReportMiServer = true;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }
}
