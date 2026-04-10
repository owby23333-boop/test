package com.liulishuo.filedownloader.h0;

/* JADX INFO: compiled from: FileDownloadProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final int a;
    public final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f17212h;

    /* JADX INFO: compiled from: FileDownloadProperties.java */
    public static class b {
        private static final e a = new e();
    }

    public static e a() {
        return b.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7 A[Catch: all -> 0x02a7, TryCatch #1 {all -> 0x02a7, blocks: (B:51:0x00c3, B:53:0x00c7, B:55:0x00cb, B:57:0x00d9), top: B:138:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9 A[Catch: all -> 0x02a7, TRY_LEAVE, TryCatch #1 {all -> 0x02a7, blocks: (B:51:0x00c3, B:53:0x00c7, B:55:0x00cb, B:57:0x00d9), top: B:138:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a0  */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.h0.e.<init>():void");
    }

    public static int a(int i2) {
        if (i2 > 12) {
            d.e(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
            return 12;
        }
        if (i2 >= 1) {
            return i2;
        }
        d.e(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
        return 1;
    }
}
