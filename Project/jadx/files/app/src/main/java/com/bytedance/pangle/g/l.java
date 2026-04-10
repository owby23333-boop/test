package com.bytedance.pangle.g;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes2.dex */
final class l implements k {
    private static final long a = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final FileDescriptor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f14590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f14591d;

    l(FileDescriptor fileDescriptor, long j2, long j3) {
        this.b = fileDescriptor;
        this.f14590c = j2;
        this.f14591d = j3;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f14591d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.bytedance.pangle.g.j r19, long r20, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.l.a(com.bytedance.pangle.g.j, long, int):void");
    }
}
