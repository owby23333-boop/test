package com.bytedance.embedapplog;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class iq implements Callable<h> {
    private Long g;
    private final tb z;

    public iq(tb tbVar, Long l) {
        Long.valueOf(0L);
        this.z = tbVar;
        this.g = l;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public h call() {
        Future futureZ = x.z(new Callable<h>() { // from class: com.bytedance.embedapplog.iq.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public h call() {
                try {
                    return iq.this.z.z();
                } catch (Exception e) {
                    js.g("__kiteFingerTask#future call error " + e.getMessage());
                    return new h();
                }
            }
        });
        try {
            if (this.g.longValue() > 0) {
                return (h) futureZ.get(this.g.longValue(), TimeUnit.SECONDS);
            }
            return (h) futureZ.get();
        } catch (TimeoutException e) {
            js.g("__kiteFingerTask# collection timed out" + e.getMessage());
            return new h();
        }
    }
}
