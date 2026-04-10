package com.kwad.components.ad.reward;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static void a(int i2, int i3, j jVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i2 == 0) {
            com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 1);
            return;
        }
        if (i2 == 1) {
            boolean zJO = jVar.qd.jO();
            if (i3 == 0) {
                if (zJO) {
                    com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (zJO) {
                com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 4);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        boolean zJO2 = jVar.qc.jO();
        if (i3 == 0) {
            if (zJO2) {
                com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 1);
            }
        } else if (zJO2) {
            com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 3);
        } else {
            com.kwad.sdk.core.report.a.l(cVar.getAdTemplate(), 2);
        }
    }
}
