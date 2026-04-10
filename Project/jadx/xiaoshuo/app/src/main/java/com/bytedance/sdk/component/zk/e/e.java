package com.bytedance.sdk.component.zk.e;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.za;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private za bf;
    private final tg<bf> e;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.zk.e.e$e, reason: collision with other inner class name */
    public static class C0111e {
        private static final e e = new e();
    }

    public static e e() {
        return C0111e.e;
    }

    public za bf() {
        if (this.bf == null) {
            synchronized (e.class) {
                if (this.bf == null) {
                    this.bf = e("csj_io_handler");
                }
            }
        }
        return this.bf;
    }

    private e() {
        this.e = tg.e(2);
    }

    public za e(za.e eVar, String str) {
        bf bfVar = (bf) this.e.e();
        if (bfVar == null) {
            return bf(eVar, str);
        }
        bfVar.e(eVar);
        bfVar.e(str);
        return bfVar;
    }

    public za e(String str) {
        return e(null, str);
    }

    private bf bf(za.e eVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new bf(handlerThread, eVar);
    }

    public boolean e(za zaVar) {
        if (!(zaVar instanceof bf)) {
            return false;
        }
        bf bfVar = (bf) zaVar;
        if (this.e.e(bfVar)) {
            return true;
        }
        bfVar.bf();
        return true;
    }
}
