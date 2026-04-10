package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements e {
    private ArrayList<a> arP = new ArrayList<>();

    static class a {
        private ExceptionMessage arQ;
        private int arR;

        a(ExceptionMessage exceptionMessage, int i2) {
            this.arQ = exceptionMessage;
            this.arR = i2;
        }
    }

    private void An() {
        if (this.arP.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.arP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.arQ, next.arR, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
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

    private void b(ExceptionMessage exceptionMessage, int i2, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i2 == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e eVarZJ = com.kwad.sdk.crash.e.zJ();
            if (eVarZJ.zO() != null && eVarZJ.zN() != 2) {
                List<com.kwad.sdk.crash.a> list = eVarZJ.zO().aqp;
                double d2 = eVarZJ.zO().apW;
                String appId = eVarZJ.getAppId();
                String sdkVersion = eVarZJ.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.apT) || aVar.apT.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.apU) || aVar.apU.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.apV) || a(exceptionMessage.mCrashDetail, aVar.apV)) {
                                d2 = aVar.apW;
                            }
                        }
                    }
                }
                return Math.random() < d2;
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w("BaseExceptionUploader", Log.getStackTraceString(e2));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i2, @Nullable CountDownLatch countDownLatch) {
        try {
            An();
            b(exceptionMessage, i2, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            this.arP.add(new a(exceptionMessage, i2));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
