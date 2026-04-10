package com.umeng.message.entity;

/* JADX INFO: loaded from: classes3.dex */
public class UNotificationItem {
    public int id;
    public UMessage message;

    public UNotificationItem(int i2, UMessage uMessage) {
        this.id = i2;
        this.message = uMessage;
    }

    public boolean equals(Object obj) {
        return obj != null && UNotificationItem.class == obj.getClass() && this.id == ((UNotificationItem) obj).id;
    }
}
