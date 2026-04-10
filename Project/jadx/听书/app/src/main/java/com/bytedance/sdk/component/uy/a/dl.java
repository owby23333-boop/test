package com.bytedance.sdk.component.uy.a;

import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.component.uy.z.e;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends Thread {
    private e proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        e eVar = this.proxy;
        if (eVar != null) {
            eVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        e eVar = this.proxy;
        return eVar != null ? eVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new e(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.uy.a.z.z("PThread");
            kb.g.wp().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    dl.super.start();
                }
            }, kb.g.a(), TimeUnit.MILLISECONDS);
        }
    }

    protected boolean isProxyEnable() {
        return kb.g.g(1);
    }

    public dl() {
    }

    public dl(Runnable runnable) {
        super(runnable);
    }

    public dl(String str) {
        super(str);
    }

    public dl(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public dl(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public dl(Runnable runnable, String str) {
        super(runnable, str);
    }

    public dl(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public dl(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}
