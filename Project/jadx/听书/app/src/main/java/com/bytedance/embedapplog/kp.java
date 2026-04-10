package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.uy;
import com.bytedance.embedapplog.v;

/* JADX INFO: loaded from: classes2.dex */
final class kp extends xo<v> {
    kp() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<v, String> z() {
        return new uy.g<v, String>() { // from class: com.bytedance.embedapplog.kp.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public v z(IBinder iBinder) {
                return v.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(v vVar) {
                if (vVar == null) {
                    return null;
                }
                return vVar.z();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
