package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.C;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c1 f2537a;
    private String dl;
    private final Context g;
    ServiceConnection z;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.f2537a = new c1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            b1.this.f2537a = null;
        }
    }

    public b1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c4be4c", new byte[]{93, 3, 56, 53});
        this.z = new pgla();
        this.g = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String z(ms.bz.bd.c.Pgl.c1 r16, java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.b1.z(ms.bz.bd.c.Pgl.c1, java.lang.String):java.lang.String");
    }

    public final void z(pblk.pblb pblbVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0444b4", new byte[]{2, 55, 73, 78, 82, 55, 115, 7, 112, 106, 97, 57, 73, 0, 112, 34, 58, Ascii.ESC, 81, 108, 51, 51, 70, 68}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "549818", new byte[]{39, 57, 71, 2, 6, 42, 47, 1, 105, 120, 106, 57, 90, 73, 0, 38, 50}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0bf234", new byte[]{34, 111, Ascii.CAN, 8, 4, 38, 42, 87, 54, 114, 111, 111, 5, 67, 2, 42, 55, 13, Ascii.RS, 102, 36, 110, 1, 79, 10, 58, 0, 70, 37, 116, 40, 99, 16})));
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e59a2", new byte[]{35, 100, 82, 68, 81, 43, 126, 71, 107, 100, 108, 111, 67, 84, 74, 36, 32, 10, 107, 121, 39, 105, 79, 73, 16, 10, 0, 97, 74, 86, 11, 67, 121, 126, 123, Ascii.ETB, 6, 109, 71, 76}));
        boolean z = false;
        try {
            if (this.g.bindService(intent, this.z, 1)) {
                try {
                    try {
                        SystemClock.sleep(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    } catch (Throwable unused) {
                        z = true;
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a140b", new byte[]{45, 115});
                            if (!z) {
                                return;
                            }
                        } finally {
                            if (z) {
                                this.g.unbindService(this.z);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
                c1 c1Var = this.f2537a;
                if (c1Var != null) {
                    String strZ = z(c1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c527fe", new byte[]{93, 2, 104, 103}));
                    if (pblbVar != null) {
                        pblbVar.z(strZ);
                    }
                }
                z = true;
            }
            if (!z) {
            }
        } catch (Throwable unused3) {
        }
    }
}
