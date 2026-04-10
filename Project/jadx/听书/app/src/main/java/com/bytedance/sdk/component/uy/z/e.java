package com.bytedance.sdk.component.uy.z;

import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.uy.kb;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Thread {
    private final Thread dl;
    private volatile boolean g;
    private volatile Thread z;

    public e(Thread thread) {
        this.dl = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.z != null) {
            this.z.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.z != null) {
            return this.z.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.g) {
            return;
        }
        this.g = true;
        kb.g.uy().execute(new com.bytedance.sdk.component.uy.dl.dl(new fo(this.dl.getName()) { // from class: com.bytedance.sdk.component.uy.z.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (kb.g.pf()) {
                    e.this.z();
                } else {
                    e.this.g();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            g gVarDl = kb.g.dl();
            String name2 = this.dl.getName();
            if (gVarDl != null) {
                name2 = gVarDl.z(name2);
            }
            threadCurrentThread.setName(name2);
            this.z = threadCurrentThread;
            threadCurrentThread.setPriority(this.dl.getPriority());
            this.dl.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Thread threadCurrentThread = Thread.currentThread();
        this.z = threadCurrentThread;
        threadCurrentThread.setPriority(this.dl.getPriority());
        this.dl.run();
    }
}
