package com.kwad.components.core.t;

import com.kwad.sdk.components.t;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private static final ConcurrentHashMap<Integer, a> YR = new ConcurrentHashMap<>();
    public static final long YS = com.kwad.sdk.core.config.e.Gn().longValue() * 1000;
    private static final Map<Integer, bg> YT = new ConcurrentHashMap();
    private static Map<Integer, Long> YU = new HashMap();

    public static void a(Integer num, t tVar, long j, long j2, long j3, long j4) {
        if (tVar == null && (num == null || num.intValue() == 0)) {
            return;
        }
        try {
            e(num);
            ConcurrentHashMap<Integer, a> concurrentHashMap = YR;
            a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                concurrentHashMap.put(num, new a(tVar, j, j2, j3, j4));
            } else {
                aVar.tl();
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    public static t a(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = YR.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.tl();
                return aVar.YW;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static a b(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = YR.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.tl();
                return aVar;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static void c(Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        try {
            a aVar = YR.get(num);
            if (aVar == null || aVar.tm() != 0) {
                return;
            }
            d(num);
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static void d(final Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        e(num);
        bg bgVar = new bg() { // from class: com.kwad.components.core.t.i.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a aVar = (a) i.YR.get(num);
                if (aVar != null) {
                    aVar.YW.onDestroy();
                }
                i.YU.remove(num);
                i.YR.remove(num);
            }
        };
        YT.put(num, bgVar);
        bw.runOnUiThreadDelay(bgVar, YS);
    }

    private static void e(Integer num) {
        Map<Integer, bg> map = YT;
        bg bgVar = map.get(num);
        if (bgVar != null) {
            bw.c(bgVar);
            map.remove(num);
        }
    }

    public static class a {
        private long II;
        private final t YW;
        private final AtomicInteger YX;
        private long YY;
        private long YZ;
        private long Za;

        public a(t tVar, long j, long j2, long j3, long j4) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.YX = atomicInteger;
            this.YW = tVar;
            atomicInteger.set(1);
            this.YY = j;
            this.II = j2;
            this.YZ = j3;
            this.Za = j4;
        }

        public final long tg() {
            return this.YY;
        }

        public final long th() {
            return this.II;
        }

        public final long ti() {
            return this.YZ;
        }

        public final long tj() {
            return this.Za;
        }

        public final t tk() {
            return this.YW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tl() {
            this.YX.incrementAndGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int tm() {
            return this.YX.decrementAndGet();
        }
    }
}
