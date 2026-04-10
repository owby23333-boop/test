package com.ss.android.downloadlib.g;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public void z(final com.ss.android.g.z.g.g gVar, final e eVar, int i) {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.g.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (fo.z(gVar)) {
                    eVar.z(false);
                } else if (!m.z(gVar)) {
                    eVar.z(false);
                } else {
                    m.z(gVar, new gz() { // from class: com.ss.android.downloadlib.g.g.1.1
                        @Override // com.ss.android.downloadlib.g.gz
                        public void z(boolean z) {
                            eVar.z(z);
                        }
                    });
                }
            }
        }, i);
    }
}
