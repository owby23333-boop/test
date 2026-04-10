package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.google.common.base.Ascii;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pblo {
    private final Context dl;
    public final LinkedBlockingQueue<IBinder> z = new LinkedBlockingQueue<>(1024);
    ServiceConnection g = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pblo.this.z.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pblo(Context context) {
        this.dl = context;
    }

    public final void z(pblk.pblb pblbVar) {
        int i = Build.VERSION.SDK_INT;
        if (i != 28 && i < 33) {
            try {
                this.dl.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8dffb", new byte[]{116, 53, Ascii.SUB, 92, 81, 96, 100, 14, 48, Utf8.REPLACEMENT_BYTE, 57, 50, 0, Ascii.ESC, 93}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61cd07", new byte[]{36, 60, Ascii.GS, 94, Ascii.SUB, 47, 49, Ascii.EM, 33, 122, 40, 35, Ascii.NAK, Ascii.RS, 11, 37, 35, Ascii.EM, 49, 49, 105, Ascii.FS, 32, 53, 33, 9, 17, 35, 13, 7, 2, 1, 38, 57, 44, 5}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0f2f2", new byte[]{113, Base64.padSymbol, Ascii.CAN, 8, 81, 48, 97, 6, 50, 107, 60, 58, 2, 79, 93}));
            if (this.dl.bindService(intent, this.g, 1)) {
                try {
                    String strZ = new pblp(this.z.take()).z();
                    if (pblbVar != null) {
                        pblbVar.z(strZ);
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    this.dl.unbindService(this.g);
                    throw th;
                }
                this.dl.unbindService(this.g);
            }
        }
    }
}
