package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static long hc;
    private com.kwad.sdk.core.g.d gX;
    private com.kwad.sdk.core.g.c gY;
    private CopyOnWriteArrayList<d> oA = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<C0292b> oB = new CopyOnWriteArrayList<>();
    private int oC;

    public interface c {
        void B(String str);
    }

    public interface e {
        void f(double d);
    }

    static final class a {
        private static final b oF = new b();
    }

    public static b fm() {
        return a.oF;
    }

    public static class d {
        private final e oH;
        private final WeakReference<View> oI;

        public d(e eVar, View view) {
            this.oI = new WeakReference<>(view);
            this.oH = eVar;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.nativead.b$b, reason: collision with other inner class name */
    public static class C0292b {
        private Context mContext;
        private c oG;

        public C0292b(c cVar, Context context) {
            this.oG = cVar;
            this.mContext = context;
        }
    }

    public final void a(float f, View view, e eVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.gX == null) {
            this.oC = com.kwad.sdk.c.a.a.bi(view.getContext());
            a(f, view.getContext());
        }
        this.oA.add(new d(eVar, view));
    }

    public final void a(e eVar) {
        for (d dVar : this.oA) {
            if (dVar.oH == eVar) {
                this.oA.remove(dVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sShakeItems size " + this.oA.size());
    }

    private void a(float f, Context context) {
        this.gX = new com.kwad.sdk.core.g.d(f);
        this.oA = new CopyOnWriteArrayList<>();
        this.gX.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.nativead.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void cd() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void a(double d2) {
                if (b.this.oA != null) {
                    b.this.e(d2);
                    bw.a(new bg() { // from class: com.kwad.components.ad.nativead.b.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "onShakeEvent openGate2");
                            b.this.gX.Jb();
                        }
                    }, null, 500L);
                }
            }
        });
        this.gX.g(f);
        this.gX.bG(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d2) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList = this.oA;
        int iFH = (int) (com.kwad.sdk.core.config.e.FH() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        d dVar = null;
        int i = Integer.MAX_VALUE;
        d dVar2 = null;
        for (d dVar3 : copyOnWriteArrayList) {
            WeakReference weakReference = dVar3.oI;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bz.o((View) weakReference.get(), iFH)) {
                    int i2 = this.oC / 2;
                    int iMin = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                    if (iMin < i) {
                        dVar = dVar3;
                        i = iMin;
                    } else if (iMin == i) {
                        dVar2 = dVar3;
                    }
                }
            }
        }
        if (dVar != null) {
            if (dVar2 != null) {
                Rect rect2 = new Rect();
                ((View) dVar.oI.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) dVar2.oI.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    dVar = dVar2;
                }
            }
            dVar.oH.f(d2);
        }
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, c cVar) {
        com.kwad.sdk.core.g.c cVar2 = this.gY;
        if (cVar2 == null) {
            a(rotateInfo, context);
        } else {
            cVar2.a(rotateInfo);
        }
        this.oB.add(new C0292b(cVar, context));
    }

    public final void a(c cVar) {
        for (C0292b c0292b : this.oB) {
            if (c0292b != null && c0292b.oG == cVar) {
                this.oB.remove(c0292b);
            }
        }
        com.kwad.sdk.core.d.c.d("KSNativeAdRotateAndShakeManager", "sRotateItems size " + this.oB.size());
    }

    private void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        this.gY = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.nativead.b.2
            @Override // com.kwad.sdk.core.g.a
            public final void ce() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                if (b.this.oB != null) {
                    for (C0292b c0292b : b.this.oB) {
                        if (c0292b != null && c0292b.oG != null) {
                            c0292b.oG.B(str);
                            return;
                        }
                    }
                }
            }
        });
        this.gY.bG(context);
    }

    public final void N(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bG(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = this.gY;
            if (cVar != null) {
                cVar.bH(context);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized boolean bY() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!(jElapsedRealtime - hc > 500)) {
            return false;
        }
        hc = jElapsedRealtime;
        return true;
    }
}
