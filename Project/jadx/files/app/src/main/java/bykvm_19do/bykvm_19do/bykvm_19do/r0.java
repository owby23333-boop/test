package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.r1;

/* JADX INFO: loaded from: classes.dex */
final class r0 extends p0<r1> {

    class a implements j1.b<r1, String> {
        a(r0 r0Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(r1 r1Var) {
            if (r1Var == null) {
                return null;
            }
            return r1Var.a();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r1 a(IBinder iBinder) {
            return r1.a.a(iBinder);
        }
    }

    r0() {
        super("com.mdid.msa");
    }

    private void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected j1.b<r1, String> a() {
        return new a(this);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0, bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        a(context, context.getPackageName());
        return super.b(context);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    protected Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }
}
