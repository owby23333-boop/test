package com.amgcyo.cuttadon.utils.event;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkCommentEvent implements Serializable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4380s;

    public MkCommentEvent(int i2) {
        this.f4380s = i2;
    }

    public void b(int i2) {
        this.f4380s = i2;
    }

    public int f() {
        return this.f4380s;
    }

    public MkCommentEvent() {
    }
}
