package com.yuewen;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class px0 extends ey0 {
    public static final int c = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[][] f16323b = new byte[0][];

    @Override // com.yuewen.qr0
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Arrays.deepEquals(this.f16323b, ((px0) obj).f16323b);
        }
        return false;
    }
}
