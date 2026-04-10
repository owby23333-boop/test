package com.bykv.vk.openvk.component.video.z.g;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private final long dl;
    private final long g;
    private final long z;

    public long z(int i) {
        if (i <= 0) {
            return this.z;
        }
        return Math.min(this.z + (this.g * ((long) i)), this.dl);
    }
}
