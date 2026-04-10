package com.kwad.sdk.core.request.model;

/* JADX INFO: loaded from: classes3.dex */
public class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int adStyle;
    public long alj;
    public int count;
    public int taskType;

    public f() {
    }

    public f(int i2, int i3, int i4, long j2) {
        this.adStyle = i2;
        this.taskType = i3;
        this.count = 1;
        this.alj = j2;
    }

    public final void S(long j2) {
        this.alj = j2;
    }
}
