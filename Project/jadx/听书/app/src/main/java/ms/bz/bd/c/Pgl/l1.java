package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class l1 {
    private static l1 z;
    private ArrayList dl = new ArrayList();
    private Context g;

    private l1(Context context) {
        this.g = null;
        this.g = context;
    }

    public static l1 z(Context context) {
        if (z == null) {
            synchronized (l1.class) {
                if (z == null) {
                    z = new l1(context);
                }
            }
        }
        return z;
    }

    public final void a() {
        byte b;
        int i;
        int iDl;
        int iZ;
        try {
            b = pble.z() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc673e", new byte[]{112, 105, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 7, 50, 103, 71, 115, 100, 123, 67, 68, 87, Ascii.CAN, 119, 115, 91, 84, 115, 114, 117, 80, 80, Utf8.REPLACEMENT_BYTE, 102, 115, 75, 105, 96, 51, 104, 75, 3, 14, 115, 98, 73, 96, 117, 124, 116, 75, 71});
            return;
        }
        try {
            synchronized (this) {
                iDl = dl();
                iZ = z();
            }
            i = (iDl * 10000) + iZ;
        } catch (Exception unused2) {
            i = -10001;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.dl.add(numValueOf);
        try {
            int size = this.dl.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.dl.subList(size - 10, size));
                this.dl.clear();
                this.dl = arrayList;
            }
        } catch (Throwable unused3) {
        }
    }

    public final int dl() {
        Intent intentRegisterReceiver = this.g.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "034497", new byte[]{32, Utf8.REPLACEMENT_BYTE, 67, 82, 9, 41, 55, 92, 108, 106, 53, 52, 73, 84, 72, 33, 48, 6, 108, 107, 47, 127, 101, 97, 50, Ascii.DC4, Ascii.SYN, 32, 92, 91, 2, Ascii.EM, 102, 110, 33, 5, Ascii.ETB})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9faad", new byte[]{99, 55, 0, Ascii.DC2, 89, 118, 101}), -1);
    }

    public final int g() {
        Intent intentRegisterReceiver = this.g.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "809a2d", new byte[]{40, 60, 78, 7, 2, 122, Utf8.REPLACEMENT_BYTE, 95, 97, Utf8.REPLACEMENT_BYTE, Base64.padSymbol, 55, 68, 1, 67, 114, 56, 5, 97, 62, 39, 124, 104, 52, 57, 71, Ascii.RS, 35, 81, 14, 10, Ascii.SUB, 107, 59, 42, 86, Ascii.US})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88c189", new byte[]{58, 46, 17, 81, Ascii.DC2, Base64.padSymbol}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public final synchronized int[] gc() {
        int size = this.dl.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.dl.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.dl;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List listSubList = arrayList.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = ((Integer) listSubList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public final int z() {
        if (this.g.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6668b", new byte[]{118, 58, 65, 80, 8, 124, 97, 89, 110, 104, 99, 49, 75, 86, 73, 116, 102, 3, 110, 105, 121, 122, 103, 99, 51, 65, SignedBytes.MAX_POWER_OF_TWO, 37, 94, 89, 84, Ascii.FS, 100, 108, 32, 80, 65}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34228b", new byte[]{46, 51, 87, 67, 11}), -1) / r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cb09c5", new byte[]{97, 99, 66, 65, 89}), -1)) * 100.0f) * 10.0f) / 10;
    }
}
