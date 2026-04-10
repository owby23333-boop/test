package com.kwad.components.ad.e;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.utils.bh;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private com.kwad.sdk.core.f.d ee;
    private CopyOnWriteArrayList<C0344b> mx = new CopyOnWriteArrayList<>();
    private int my;

    static final class a {
        private static final b mB = new b();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.e.b$b, reason: collision with other inner class name */
    public static class C0344b {
        private final c mC;
        private final WeakReference<View> mD;

        public C0344b(c cVar, View view) {
            this.mD = new WeakReference<>(view);
            this.mC = cVar;
        }
    }

    public interface c {
        void f(double d2);
    }

    private void a(float f2, Context context) {
        this.ee = new com.kwad.sdk.core.f.d(f2);
        this.mx = new CopyOnWriteArrayList<>();
        this.ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.e.b.1
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                if (b.this.mx != null) {
                    b.this.e(d2);
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.e.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.ee.xP();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ee.e(f2);
        this.ee.bi(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(double r10) {
        /*
            r9 = this;
            java.util.concurrent.CopyOnWriteArrayList<com.kwad.components.ad.e.b$b> r0 = r9.mx
            float r1 = com.kwad.sdk.core.config.d.uR()
            r2 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r2
            int r1 = (int) r1
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto La2
            r2 = 2147483647(0x7fffffff, float:NaN)
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r2 = r3
            r4 = 2147483647(0x7fffffff, float:NaN)
        L1d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L6b
            java.lang.Object r5 = r0.next()
            com.kwad.components.ad.e.b$b r5 = (com.kwad.components.ad.e.b.C0344b) r5
            java.lang.ref.WeakReference r6 = com.kwad.components.ad.e.b.C0344b.b(r5)
            if (r6 == 0) goto L1d
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            java.lang.Object r8 = r6.get()
            android.view.View r8 = (android.view.View) r8
            boolean r8 = r8.getGlobalVisibleRect(r7)
            if (r8 == 0) goto L1d
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            boolean r6 = com.kwad.sdk.b.kwai.a.m(r6, r1)
            if (r6 == 0) goto L1d
            int r6 = r9.my
            int r6 = r6 / 2
            int r8 = r7.top
            int r8 = r8 - r6
            int r8 = java.lang.Math.abs(r8)
            int r7 = r7.bottom
            int r7 = r7 - r6
            int r6 = java.lang.Math.abs(r7)
            int r6 = java.lang.Math.min(r8, r6)
            if (r6 >= r4) goto L67
            r3 = r5
            r4 = r6
            goto L1d
        L67:
            if (r6 != r4) goto L1d
            r2 = r5
            goto L1d
        L6b:
            if (r3 == 0) goto La2
            if (r2 == 0) goto L9a
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            java.lang.ref.WeakReference r1 = com.kwad.components.ad.e.b.C0344b.b(r3)
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            r1.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            java.lang.ref.WeakReference r4 = com.kwad.components.ad.e.b.C0344b.b(r2)
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            r4.getGlobalVisibleRect(r0)
            int r0 = r0.top
            int r1 = r1.top
            if (r0 >= r1) goto L9a
            goto L9b
        L9a:
            r2 = r3
        L9b:
            com.kwad.components.ad.e.b$c r0 = com.kwad.components.ad.e.b.C0344b.a(r2)
            r0.f(r10)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.e.b.e(double):void");
    }

    public static b eI() {
        return a.mB;
    }

    public final void a(float f2, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.ee == null) {
            this.my = com.kwad.sdk.b.kwai.a.aF(view.getContext());
            a(f2, view.getContext());
        }
        this.mx.add(new C0344b(cVar, view));
    }

    public final void a(c cVar) {
        for (C0344b c0344b : this.mx) {
            if (c0344b.mC == cVar) {
                this.mx.remove(c0344b);
            }
        }
        com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "sShakeItems size " + this.mx.size());
    }
}
