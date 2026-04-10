package com.kwad.framework.filedownloader.f;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    public final int apE;
    public final long apF;
    public final boolean apG;
    public final boolean apH;
    public final int apI;
    public final boolean apJ;
    public final boolean apK;

    /* synthetic */ e(byte b) {
        this();
    }

    public static class a {
        private static final e apL = new e(0);
    }

    public static e zB() {
        return a.apL;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075 A[Catch: all -> 0x018a, TryCatch #7 {all -> 0x018a, blocks: (B:7:0x002d, B:8:0x0034, B:9:0x003a, B:10:0x0040, B:11:0x0046, B:12:0x004a, B:37:0x0071, B:39:0x0075, B:41:0x0079, B:42:0x0081), top: B:95:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081 A[Catch: all -> 0x018a, TRY_LEAVE, TryCatch #7 {all -> 0x018a, blocks: (B:7:0x002d, B:8:0x0034, B:9:0x003a, B:10:0x0040, B:11:0x0046, B:12:0x004a, B:37:0x0071, B:39:0x0075, B:41:0x0079, B:42:0x0081), top: B:95:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.f.e.<init>():void");
    }

    public static int ce(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i > 0) {
            return i;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }
}
