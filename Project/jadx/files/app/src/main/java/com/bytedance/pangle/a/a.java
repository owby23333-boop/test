package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    final CountDownLatch a;
    Throwable b;

    /* JADX INFO: renamed from: com.bytedance.pangle.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0298a {
        void a();
    }

    private a(InterfaceC0298a[] interfaceC0298aArr) {
        this.a = new CountDownLatch(interfaceC0298aArr.length);
        for (final InterfaceC0298a interfaceC0298a : interfaceC0298aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0298a.a();
                    } catch (Throwable th) {
                        a.this.b = th;
                    }
                    a.this.a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0298a... interfaceC0298aArr) throws Throwable {
        a aVar = new a(interfaceC0298aArr);
        try {
            aVar.a.await();
            Throwable th = aVar.b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
