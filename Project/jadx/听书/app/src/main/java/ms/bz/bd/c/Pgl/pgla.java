package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class pgla {
    private final Context dl;
    public final LinkedBlockingQueue<IBinder> z = new LinkedBlockingQueue<>(1024);
    ServiceConnection g = new ServiceConnectionC0509pgla();

    /* JADX INFO: renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    final class ServiceConnectionC0509pgla implements ServiceConnection {
        ServiceConnectionC0509pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pgla.this.z.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pgla(Context context) {
        this.dl = context;
    }

    public final void z(pblk.pblb pblbVar) {
        try {
            this.dl.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de219c", new byte[]{118, 104, 76, 11, 7, 103, 114, 87, 45, 108, 102, 102, 15, 118, 19, 100, 119, 72, 102, 108, 112, 105, 85, 68, Ascii.DC4, 109, 67, 109, 71}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc6ac1", new byte[]{113, 110, 72, 91, 93, 53, 117, 81, 41, 60, 97, 96, 11, Ascii.DC4, 95, 50, 105, 77, 105, 127, 83, 66, 102, 48, 111, Ascii.NAK, 95, 102, 78, Ascii.NAK}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ce5541", new byte[]{113, 104, 75, 15, 10, 53, 117, 87, 42, 104, 97, 102, 8, 114, Ascii.RS, 54, 112, 72, 97, 104, 119, 105, 82, SignedBytes.MAX_POWER_OF_TWO, Ascii.EM, Utf8.REPLACEMENT_BYTE, 68, 109, SignedBytes.MAX_POWER_OF_TWO}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ace329", new byte[]{115, 110, Ascii.ESC, 9, 12, Base64.padSymbol, 119, 81, 122, 110, 99, 96, 88, 116, Ascii.CAN, 62, 114, 78, 49, 110, 117, 111, 2, 70, Ascii.US, 55, 70, 107, 16, 45, 67, 116, 6, 87, 1, 43, 111, 71, 58, 119, 113, 115, 15, 99, 36, 10, 81, 71, 38, 117, 121, 98, 19})));
        if (this.dl.bindService(intent, this.g, 1)) {
            try {
                String strZ = new pblb(this.z.take()).z();
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
