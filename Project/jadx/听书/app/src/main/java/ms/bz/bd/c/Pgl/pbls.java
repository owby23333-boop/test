package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: loaded from: classes4.dex */
public final class pbls {
    private final Context dl;
    ServiceConnection g = new pgla();
    pblt z;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pbls.this.z = new pblt(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pbls(Context context) {
        this.dl = context;
    }

    public final void z(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "abbaa0", new byte[]{115, 111, Ascii.FS, 91, 68, 50, 107, 13, 55, 52, 102, 105, Ascii.DC2, 16, 87, 35, 113, 70, 33, 39, 121, 99, Ascii.DC4}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eee3bb", new byte[]{119, 104, Ascii.ESC, 9, 71, 96, 111, 10, 48, 102, 98, 110, Ascii.NAK, 66, 84, 113, 117, 65, 38, 117, 125, 100, 19, 9, 121, 112, 112, 77, 55, 102, 125, 99, 37, 66, 79, 99, 111, 71, 49}));
        if (this.dl.bindService(intent, this.g, 1)) {
            try {
                pblt pbltVar = this.z;
                if (pbltVar != null) {
                    String strZ = pbltVar.z();
                    if (pblbVar != null) {
                        pblbVar.z(strZ);
                    }
                }
            } catch (Throwable unused) {
            }
            this.dl.unbindService(this.g);
        }
    }
}
