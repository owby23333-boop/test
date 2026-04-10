package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static com.kwad.sdk.core.f.d ee;
    private static Vibrator ef;
    private static List<a> eg = new CopyOnWriteArrayList();

    public static class a {
        private b ei;
        private Context mContext;

        public a(b bVar, Context context) {
            this.ei = bVar;
            this.mContext = context;
        }
    }

    public interface b {
        boolean b(double d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (ef == null) {
            ef = (Vibrator) context.getSystemService("vibrator");
        }
        return ef;
    }

    private static void a(float f2, Context context) {
        ee = new com.kwad.sdk.core.f.d(f2);
        eg = new CopyOnWriteArrayList();
        ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                if (d.eg != null) {
                    Iterator it = d.eg.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (aVar.ei != null && aVar.ei.b(d2)) {
                            bh.a(aVar.mContext, d.F(aVar.mContext));
                            break;
                        }
                    }
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KSFeedShakeManager", "onShakeEvent openGate2");
                            d.ee.xP();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        ee.e(f2);
        ee.bi(context);
    }

    public static void a(float f2, Context context, b bVar) {
        if (ee == null) {
            a(f2, context);
        }
        eg.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : eg) {
            if (aVar.ei == bVar) {
                eg.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.b.d("KSFeedShakeManager", "sShakeItems size " + eg.size());
    }
}
