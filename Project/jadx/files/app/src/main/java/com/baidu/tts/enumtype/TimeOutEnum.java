package com.baidu.tts.enumtype;

import com.anythink.expressad.exoplayer.i.a;
import com.anythink.expressad.video.module.a.a.m;

/* JADX INFO: loaded from: classes2.dex */
public enum TimeOutEnum {
    DEFAULT(6, 6000),
    TWO_SECOND(2, a.f9492f),
    THREE_SECOND(3, m.ag),
    FOUR_SECOND(4, 4000);

    private final long mMillSeconds;
    private final long mSeconds;

    TimeOutEnum(long j2, long j3) {
        this.mSeconds = j2;
        this.mMillSeconds = j3;
    }

    public long getMillSeconds() {
        return this.mMillSeconds;
    }

    public int getMillSecondsInt() {
        return (int) getMillSeconds();
    }

    public long getSeconds() {
        return this.mSeconds;
    }
}
