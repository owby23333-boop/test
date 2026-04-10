package com.baidu.tts.param;

import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class BasePlayerParams<T> extends APrototype<T> {
    public static final int NOTIFICATION_COUNT_PER_SECOND = 5;
    private static final long serialVersionUID = 7557839830344036398L;
    private int mStreamType = 3;
    private int mNotificationCountPerSecond = 5;

    public int getNotificationCountPerSecond() {
        return this.mNotificationCountPerSecond;
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    public void setNotificationCountPerSecond(int i2) {
        this.mNotificationCountPerSecond = i2;
    }

    public void setStreamType(int i2) {
        this.mStreamType = i2;
    }

    public void setNotificationCountPerSecond(String str) {
        this.mNotificationCountPerSecond = Integer.parseInt(str);
    }
}
