package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.uy;
import com.bytedance.embedapplog.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gy extends xo<wp> {
    private final Context z;

    @Override // com.bytedance.embedapplog.xo, com.bytedance.embedapplog.gm
    public /* bridge */ /* synthetic */ boolean z(Context context) {
        return super.z(context);
    }

    gy(Context context) {
        super("com.coolpad.deviceidsupport");
        this.z = context;
    }

    @Override // com.bytedance.embedapplog.xo
    protected uy.g<wp, String> z() {
        return new uy.g<wp, String>() { // from class: com.bytedance.embedapplog.gy.1
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public wp z(IBinder iBinder) {
                return wp.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(wp wpVar) {
                if (wpVar == null) {
                    return null;
                }
                return wpVar.g(gy.this.z.getPackageName());
            }
        };
    }

    @Override // com.bytedance.embedapplog.xo
    protected Intent dl(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.xo, com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                gm.z zVar = new gm.z();
                zVar.g = string;
                return zVar;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return super.g(context);
    }
}
