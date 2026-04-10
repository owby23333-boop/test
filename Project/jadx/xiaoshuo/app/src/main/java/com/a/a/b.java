package com.a.a;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f1612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1613b;
    private final long c;

    public b(FileChannel fileChannel, long j, long j2) {
        this.f1612a = fileChannel;
        this.f1613b = j;
        this.c = j2;
    }

    @Override // com.a.a.a
    public final long a() {
        return this.c;
    }

    @Override // com.a.a.a
    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f1612a.map(FileChannel.MapMode.READ_ONLY, this.f1613b + j, i);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
