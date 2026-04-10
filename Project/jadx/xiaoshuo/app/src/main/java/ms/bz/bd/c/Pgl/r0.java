package ms.bz.bd.c.Pgl;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
class r0 implements Comparator<Object> {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int iAbs = Math.abs(((ScanResult) obj).level);
        int iAbs2 = Math.abs(((ScanResult) obj2).level);
        if (iAbs > iAbs2) {
            return 1;
        }
        return iAbs == iAbs2 ? 0 : -1;
    }
}
