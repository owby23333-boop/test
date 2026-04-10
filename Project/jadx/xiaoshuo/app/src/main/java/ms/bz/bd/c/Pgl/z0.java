package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.u0;

/* JADX INFO: loaded from: classes9.dex */
public class z0 {
    private final Context bf;
    private String d;
    ServiceConnection e;
    private f1 tg;

    public class pgla implements ServiceConnection {
        public pgla() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            z0.this.tg = new f1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            z0.this.tg = null;
        }
    }

    public z0(Context context) {
        this.e = new pgla();
        this.bf = context;
    }

    public String e(u0.pblb pblbVar) {
        boolean z;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) pblk.a(16777217, 0, 0L, "9bd25f", new byte[]{Ascii.VT, 97, Ascii.EM, 72, 5, 101, 122, 81, 32, 108, 104, 111, Ascii.EM, 6, 39, 112, 51, 77, 1, 106, 58, 101, Ascii.SYN, 66}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) pblk.a(16777217, 0, 0L, "63ae3d", new byte[]{36, 62, Ascii.US, 95, 4, 118, 44, 6, 49, 37, 105, 62, 2, Ascii.DC4, 2, 122, 49}), (String) pblk.a(16777217, 0, 0L, "5acd67", new byte[]{39, 108, Ascii.GS, 94, 1, 37, 47, 84, 51, 36, 106, 108, 0, Ascii.NAK, 7, 41, 50, Ascii.SO, Ascii.ESC, 48, 33, 109, 4, Ascii.EM, Ascii.SI, 57, 5, 69, 32, 34, 45, 96, Ascii.NAK})));
        intent.setAction((String) pblk.a(16777217, 0, 0L, "22bcba", new byte[]{34, 51, 5, Ascii.RS, 82, 120, 127, 16, 60, 62, 109, 56, Ascii.DC4, Ascii.SO, 73, 119, 33, 93, 60, 35, 38, 62, Ascii.CAN, 19, 19, 89, 1, 54, Ascii.GS, Ascii.FF, 10, Ascii.DC4, 46, 36, 120, 68, 7, 58, 16, Ascii.SYN}));
        boolean z2 = false;
        String strE = null;
        try {
            if (this.bf.bindService(intent, this.e, 1)) {
                try {
                    try {
                        SystemClock.sleep(3000L);
                    } catch (Throwable unused) {
                        z = true;
                        try {
                            return strE;
                        } finally {
                            if (z) {
                                this.bf.unbindService(this.e);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
                f1 f1Var = this.tg;
                if (f1Var != null) {
                    strE = e(f1Var, (String) pblk.a(16777217, 0, 0L, "b25158", new byte[]{92, 5, 111, 97}));
                    if (pblbVar != null) {
                        pblbVar.e(strE);
                    }
                }
                z2 = true;
            }
        } catch (Throwable unused3) {
            z = false;
        }
        if (z2) {
        }
        return strE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String e(ms.bz.bd.c.Pgl.f1 r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.z0.e(ms.bz.bd.c.Pgl.f1, java.lang.String):java.lang.String");
    }
}
