package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.p1;

/* JADX INFO: loaded from: classes.dex */
final class n0 extends p0<p1> {

    class a implements j1.b<p1, String> {
        a(n0 n0Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(p1 p1Var) {
            if (p1Var == null) {
                return null;
            }
            return p1Var.b();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p1 a(IBinder iBinder) {
            return p1.a.a(iBinder);
        }
    }

    n0() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected j1.b<p1, String> a() {
        return new a(this);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
