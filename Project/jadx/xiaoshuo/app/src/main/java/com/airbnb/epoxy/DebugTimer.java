package com.airbnb.epoxy;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class DebugTimer implements Timer {
    private String sectionName;
    private long startTime;
    private final String tag;

    public DebugTimer(String str) {
        this.tag = str;
        reset();
    }

    private void reset() {
        this.startTime = -1L;
        this.sectionName = null;
    }

    @Override // com.airbnb.epoxy.Timer
    public void start(String str) {
        if (this.startTime != -1) {
            throw new IllegalStateException("Timer was already started");
        }
        this.startTime = System.nanoTime();
        this.sectionName = str;
    }

    @Override // com.airbnb.epoxy.Timer
    public void stop() {
        if (this.startTime == -1) {
            throw new IllegalStateException("Timer was not started");
        }
        String str = this.tag;
        Log.d(str, String.format(this.sectionName + ": %.3fms", Float.valueOf((System.nanoTime() - this.startTime) / 1000000.0f)));
        reset();
    }
}
