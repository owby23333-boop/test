package com.bykv.vk.openvk.component.video.e.bf;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final long bf;
    private final long d;
    private final long e;

    public long e(int i) {
        return i <= 0 ? this.e : Math.min(this.e + (this.bf * ((long) i)), this.d);
    }
}
