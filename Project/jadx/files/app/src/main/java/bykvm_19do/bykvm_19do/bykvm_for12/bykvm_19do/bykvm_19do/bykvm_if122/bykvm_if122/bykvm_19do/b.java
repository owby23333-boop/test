package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import com.bytedance.msdk.adapter.util.ThreadHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {
    protected final String a;

    public b(String str, Object... objArr) {
        this.a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(ThreadHelper.THREDA_NAME_PREFIX + this.a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
