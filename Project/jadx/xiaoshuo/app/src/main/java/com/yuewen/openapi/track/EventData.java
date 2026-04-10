package com.yuewen.openapi.track;

/* JADX INFO: loaded from: classes8.dex */
public class EventData {
    public String eventId;
    public String eventType;

    public EventData(String str, String str2) {
        this.eventType = str;
        this.eventId = str2;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }
}
