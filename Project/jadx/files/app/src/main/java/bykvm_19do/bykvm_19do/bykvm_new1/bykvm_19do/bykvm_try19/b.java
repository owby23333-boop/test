package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_try19;

import android.os.Handler;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {
    b(Handler handler, long j2, long j3) {
        super(handler, j2, j3);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String strC = i.e().c();
        if (TextUtils.isEmpty(strC) || "0".equals(strC)) {
            a(c());
            str = "[DeviceIdTask] did is null, continue check.";
        } else {
            i.j().a(strC);
            str = "[DeviceIdTask] did is " + strC;
        }
        j.a(str);
    }
}
