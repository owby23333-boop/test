package com.xiaomi.verificationsdk.internal;

/* JADX INFO: loaded from: classes8.dex */
public class VerificationInfo {
    private String clientId;
    private String eventId;

    public VerificationInfo(String str, String str2) {
        this.eventId = str;
        this.clientId = str2;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }
}
