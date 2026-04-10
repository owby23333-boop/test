package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.o1;

/* JADX INFO: loaded from: classes.dex */
final class w0 extends p0<o1> {

    class a implements j1.b<o1, String> {
        a(w0 w0Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(o1 o1Var) {
            if (o1Var == null) {
                return null;
            }
            return o1Var.a();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o1 a(IBinder iBinder) {
            return o1.a.a(iBinder);
        }
    }

    w0() {
        super("com.zui.deviceidservice");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected j1.b<o1, String> a() {
        return new a(this);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
