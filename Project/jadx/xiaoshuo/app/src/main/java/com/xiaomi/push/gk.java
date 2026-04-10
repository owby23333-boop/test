package com.xiaomi.push;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public final class gk extends ge {
    public gk() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.ge
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo456a(ByteBuffer byteBuffer) {
        return m459a().length == 0 ? byteBuffer : super.mo456a(byteBuffer);
    }

    @Override // com.xiaomi.push.ge
    public int c() {
        if (m459a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
