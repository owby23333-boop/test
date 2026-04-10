package com.bytedance.sdk.openadsdk.core.nativeexpress;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements uy {
    private Queue<Runnable> g = new LinkedList();
    private WeakReference<uy> z;

    public uy wp() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void z(uy uyVar) {
        this.z = new WeakReference<>(uyVar);
        while (!this.g.isEmpty()) {
            try {
                Runnable runnablePoll = this.g.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final boolean z) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(z);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.1
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).z(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().e();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.9
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).e();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().gz();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.10
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).gz();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final int i) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(i);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.11
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).z(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.z.get().z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.z.get().g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().fo();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.12
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).fo();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int dl() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.z.get().dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long getActualPlayDuration() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.z.get().getActualPlayDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().uy();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.13
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).uy();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().kb();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.14
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).kb();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(f, f2, f3, f4, i);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.15
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).z(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void a() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().a();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.16
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).a();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void g(final int i) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().g(i);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.2
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).g(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gc() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().gc();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.3
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).gc();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final int i, final String str) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(i, str);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.4
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).z(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().setPauseFromExpressView(z);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.5
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).setPauseFromExpressView(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final float f) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().z(f);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.6
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).z(f);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().m();
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.7
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).m();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(final int i) {
        WeakReference<uy> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null) {
            this.z.get().dl(i);
        } else {
            this.g.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.kb.8
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == null || kb.this.z.get() == null) {
                        return;
                    }
                    ((uy) kb.this.z.get()).dl(i);
                }
            });
        }
    }
}
