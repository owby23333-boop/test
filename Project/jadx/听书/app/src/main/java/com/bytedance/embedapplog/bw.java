package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.p;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
final class bw extends xo<p> {
    bw() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.xo, com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        z(context, context.getPackageName());
        return super.g(context);
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<p, String> z() {
        return new uy.g<p, String>() { // from class: com.bytedance.embedapplog.bw.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public p z(IBinder iBinder) {
                return p.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(p pVar) {
                if (pVar == null) {
                    return null;
                }
                return pVar.z();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void z(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            cb.z(e);
        }
    }
}
