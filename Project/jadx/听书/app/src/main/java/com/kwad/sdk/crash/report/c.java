package com.kwad.sdk.crash.report;

import android.util.Log;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements e {
    private ArrayList<a> aQm = new ArrayList<>();

    public final void a(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        try {
            LU();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.aQm.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private void LU() {
        if (this.aQm.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.aQm.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.aQn, next.aQo, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    static class a {
        private ExceptionMessage aQn;
        private int aQo;

        a(ExceptionMessage exceptionMessage, int i) {
            this.aQn = exceptionMessage;
            this.aQo = i;
        }
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e eVarLr = com.kwad.sdk.crash.e.Lr();
            if (eVarLr.Lw() != null && eVarLr.Lv() != 2) {
                List<com.kwad.sdk.crash.a> list = eVarLr.Lw().aOD;
                double d = eVarLr.Lw().aOe;
                String appId = eVarLr.getAppId();
                String sdkVersion = eVarLr.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aOb) || aVar.aOb.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aOc) || aVar.aOc.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aOd) || a(exceptionMessage.mCrashDetail, aVar.aOd)) {
                                d = aVar.aOe;
                            }
                        }
                    }
                }
                return Math.random() < d;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
