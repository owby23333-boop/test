package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.p;
import com.bytedance.embedapplog.rk;

/* JADX INFO: loaded from: classes.dex */
final class lw extends zb<p> {
    public lw() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.zb, com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        e(context, context.getPackageName());
        return super.d(context);
    }

    @Override // com.bytedance.embedapplog.zb
    public aq.bf<p, String> e() {
        return new aq.bf<p, String>() { // from class: com.bytedance.embedapplog.lw.1
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public p bf(IBinder iBinder) {
                return p.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(p pVar) {
                if (pVar == null) {
                    return null;
                }
                return pVar.e();
            }
        };
    }

    @Override // com.bytedance.embedapplog.zb
    public Intent e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void e(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            tx.e(e);
        }
    }
}
