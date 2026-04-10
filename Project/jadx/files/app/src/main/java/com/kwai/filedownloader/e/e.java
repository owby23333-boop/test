package com.kwai.filedownloader.e;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final int aHU;
    public final long aHV;
    public final boolean aHW;
    public final boolean aHX;
    public final int aHY;
    public final boolean aHZ;
    public final boolean aIa;

    public static class a {
        private static final e aIb = new e(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007e A[Catch: all -> 0x01ce, TryCatch #8 {all -> 0x01ce, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x007a, B:39:0x007e, B:41:0x0082, B:42:0x008a), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a A[Catch: all -> 0x01ce, TRY_LEAVE, TryCatch #8 {all -> 0x01ce, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x007a, B:39:0x007e, B:41:0x0082, B:42:0x008a), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0177  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.e.e.<init>():void");
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e IP() {
        return a.aIb;
    }

    public static int de(int i2) {
        if (i2 > 12) {
            d.h(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
            return 12;
        }
        if (i2 > 0) {
            return i2;
        }
        d.h(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
        return 1;
    }
}
