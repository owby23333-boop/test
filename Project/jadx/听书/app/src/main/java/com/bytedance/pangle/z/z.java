package com.bytedance.pangle.z;

import com.bytedance.pangle.gc.gc;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final CountDownLatch g;
    Throwable z;

    /* JADX INFO: renamed from: com.bytedance.pangle.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0114z {
        void z() throws Throwable;
    }

    private z(boolean z, InterfaceC0114z[] interfaceC0114zArr) {
        this.g = new CountDownLatch(interfaceC0114zArr.length);
        for (final InterfaceC0114z interfaceC0114z : interfaceC0114zArr) {
            gc.z(new Runnable() { // from class: com.bytedance.pangle.z.z.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0114z.z();
                    } catch (Throwable th) {
                        z.this.z = th;
                    }
                    z.this.g.countDown();
                }
            }, z);
        }
    }

    public static void z(boolean z, InterfaceC0114z... interfaceC0114zArr) throws Throwable {
        new z(z, interfaceC0114zArr).z();
    }

    private void z() throws Throwable {
        try {
            this.g.await();
            Throwable th = this.z;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
