package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.i;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
final class jc extends xo<i> {
    jc() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<i, String> z() {
        return new uy.g<i, String>() { // from class: com.bytedance.embedapplog.jc.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public i z(IBinder iBinder) {
                return i.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(i iVar) {
                return iVar.z();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
