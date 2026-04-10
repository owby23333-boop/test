package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.pf;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
final class eo extends xo<pf> {
    eo() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<pf, String> z() {
        return new uy.g<pf, String>() { // from class: com.bytedance.embedapplog.eo.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public pf z(IBinder iBinder) {
                return pf.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(pf pfVar) {
                if (pfVar == null) {
                    return null;
                }
                return pfVar.dl();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
