package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class a extends FileObserver {
    private final c a;
    private volatile boolean b;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do.a$a, reason: collision with other inner class name */
    private final class C0059a extends Thread {
        private int a;

        C0059a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.a);
            a.this.b = true;
        }
    }

    public a(c cVar, String str, int i2) {
        super(str, i2);
        this.b = true;
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.a = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        c cVar;
        if (this.b && i2 == 8 && !TextUtils.isEmpty(str) && str.contains(AgooConstants.MESSAGE_TRACE) && (cVar = this.a) != null) {
            this.b = false;
            cVar.a(200, "/data/anr/" + str, 80);
            new C0059a(5000).start();
        }
    }
}
