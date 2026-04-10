package com.umeng.message;

import com.umeng.message.entity.UNotificationItem;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class MessageNotificationQueue {
    private static volatile MessageNotificationQueue b;
    private final LinkedList<UNotificationItem> a = new LinkedList<>();

    private MessageNotificationQueue() {
    }

    public static MessageNotificationQueue getInstance() {
        if (b == null) {
            synchronized (MessageNotificationQueue.class) {
                if (b == null) {
                    b = new MessageNotificationQueue();
                }
            }
        }
        return b;
    }

    public void addLast(UNotificationItem uNotificationItem) {
        this.a.addLast(uNotificationItem);
    }

    public LinkedList<UNotificationItem> getQueue() {
        return this.a;
    }

    public UNotificationItem pollFirst() {
        return this.a.pollFirst();
    }

    public void remove(UNotificationItem uNotificationItem) {
        this.a.remove(uNotificationItem);
    }

    public int size() {
        return this.a.size();
    }
}
