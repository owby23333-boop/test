package com.google.a.a.a.a.a;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f6780a;

    /* JADX INFO: renamed from: com.google.a.a.a.a.a.a$a, reason: collision with other inner class name */
    public static final class C0430a extends b {
        @Override // com.google.a.a.a.a.a.b
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:4:0x0006, B:6:0x000e, B:7:0x0014, B:9:0x001e, B:10:0x0024), top: B:22:0x0006 }] */
    static {
        /*
            java.lang.Integer r0 = a()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L14
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L2a
            r2 = 19
            if (r1 < r2) goto L14
            com.google.a.a.a.a.a.f r1 = new com.google.a.a.a.a.a.f     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L60
        L14:
            java.lang.String r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch: java.lang.Throwable -> L2a
            r1 = r1 ^ 1
            if (r1 == 0) goto L24
            com.google.a.a.a.a.a.e r1 = new com.google.a.a.a.a.a.e     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L60
        L24:
            com.google.a.a.a.a.a.a$a r1 = new com.google.a.a.a.a.a.a$a     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L60
        L2a:
            r1 = move-exception
            goto L2e
        L2c:
            r1 = move-exception
            r0 = 0
        L2e:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<com.google.a.a.a.a.a.a$a> r3 = com.google.a.a.a.a.a.a.C0430a.class
            java.lang.String r3 = r3.getName()
            int r4 = r3.length()
            int r4 = r4 + 132
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
            com.google.a.a.a.a.a.a$a r1 = new com.google.a.a.a.a.a.a$a
            r1.<init>()
        L60:
            com.google.a.a.a.a.a.a.f6780a = r1
            if (r0 == 0) goto L67
            r0.intValue()
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.a.a.a.<clinit>():void");
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void a(Throwable th, Throwable th2) {
        f6780a.a(th, th2);
    }
}
