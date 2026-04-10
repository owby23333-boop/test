package com.bytedance.e.e.vn;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.e.e.v.m;
import com.bytedance.e.e.zk;

/* JADX INFO: loaded from: classes.dex */
public class bf extends e {
    public bf(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strGa = zk.e().ga();
        if (TextUtils.isEmpty(strGa) || "0".equals(strGa)) {
            e(d());
            m.e("[DeviceIdTask] did is null, continue check.");
            return;
        }
        zk.d().e(strGa);
        m.e("[DeviceIdTask] did is " + strGa);
    }
}
