package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static Executor a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.a.getAndIncrement());
        }
    });
    private static final Object b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f14538c = null;

    private static Handler a() {
        Handler handler;
        synchronized (b) {
            if (f14538c == null) {
                f14538c = new Handler(Looper.getMainLooper());
            }
            handler = f14538c;
        }
        return handler;
    }

    public static ExecutorService a(int i2) {
        return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.a.getAndIncrement());
            }
        });
    }

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0013. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0009. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static java.lang.String e1672829046108dc(java.lang.String r4) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L55;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L10;
                case 96: goto L55;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L3f;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L0
        L10:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L17;
                case 61: goto L25;
                case 62: goto L34;
                default: goto L16;
            }
        L16:
            goto L55
        L17:
            int r3 = 0 - r1
            int r3 = r3 * 0
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L0
        L25:
            int r2 = 18 - r1
            int r2 = r2 * 18
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L55
        L34:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L0
        L3f:
            char[] r4 = r4.toCharArray()
        L43:
            int r0 = r4.length
            if (r2 >= r0) goto L4f
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L43
        L4f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L55:
            r0 = 74
            r1 = 55
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.e.e1672829046108dc(java.lang.String):java.lang.String");
    }
}
