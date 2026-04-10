package com.bytedance.z.g.m;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.uy;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    g(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strGc = gz.z().gc();
        if (TextUtils.isEmpty(strGc) || "0".equals(strGc)) {
            z(dl());
            uy.z("[DeviceIdTask] did is null, continue check.");
        } else {
            gz.dl().z(strGc);
            uy.z("[DeviceIdTask] did is ".concat(String.valueOf(strGc)));
        }
    }
}
