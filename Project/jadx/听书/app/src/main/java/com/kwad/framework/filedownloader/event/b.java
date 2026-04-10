package com.kwad.framework.filedownloader.event;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public Runnable aoA = null;
    protected final String aoB;

    public b(String str) {
        this.aoB = str;
    }

    public final String getId() {
        return this.aoB;
    }
}
