package com.bytedance.pangle.gz;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes2.dex */
class wp implements kb {
    private static final long z = Os.sysconf(OsConstants._SC_PAGESIZE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f516a;
    private final long dl;
    private final FileDescriptor g;

    wp(FileDescriptor fileDescriptor, long j, long j2) {
        this.g = fileDescriptor;
        this.dl = j;
        this.f516a = j2;
    }

    @Override // com.bytedance.pangle.gz.kb
    public long z() {
        return this.f516a;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.gz.kb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(com.bytedance.pangle.gz.uy r19, long r20, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.gz.wp.z(com.bytedance.pangle.gz.uy, long, int):void");
    }
}
