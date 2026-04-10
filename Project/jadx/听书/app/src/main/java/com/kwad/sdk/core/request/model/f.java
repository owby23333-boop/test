package com.kwad.sdk.core.request.model;

/* JADX INFO: loaded from: classes4.dex */
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public long aIK;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.aIK = j;
    }

    public final void aG(long j) {
        this.aIK = j;
    }
}
