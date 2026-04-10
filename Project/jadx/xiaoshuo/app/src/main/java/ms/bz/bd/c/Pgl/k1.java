package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.common.base.Ascii;
import com.yuewen.k12;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class k1 {
    private static k1 e;
    private Context bf;
    private List<Integer> d = new ArrayList();

    private k1(Context context) {
        this.bf = null;
        this.bf = context;
    }

    public int bf() {
        Intent intentRegisterReceiver = this.bf.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "18e8f5", new byte[]{33, 52, 18, 94, 86, 43, 54, 87, Base64.padSymbol, 102, 52, Utf8.REPLACEMENT_BYTE, Ascii.CAN, 88, Ascii.ETB, 35, 49, Ascii.CR, Base64.padSymbol, 103, 46, 116, 52, 109, 109, Ascii.SYN, Ascii.ETB, 43, Ascii.CR, 87, 3, 18, 55, 98, 126, 7, Ascii.SYN})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "baf86e", new byte[]{96, 119, Ascii.DC4, 88, Ascii.FS, 97}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public int d() {
        Intent intentRegisterReceiver = this.bf.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "fb22b4", new byte[]{118, 110, 69, 84, 82, 42, 97, Ascii.CR, 106, 108, 99, 101, 79, 82, 19, 34, 102, 87, 106, 109, 121, 46, 99, 103, 105, Ascii.ETB, 64, 113, 90, 93, 84, 72, 96, 104, 122, 6, 65})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) pblk.a(16777217, 0, 0L, "a28525", new byte[]{96, 60, 94, 70, 10, 39, 102}), -1);
    }

    public int e() {
        if (this.bf.registerReceiver(null, new IntentFilter((String) pblk.a(16777217, 0, 0L, "cca04d", new byte[]{115, 111, Ascii.SYN, 86, 4, 122, 100, Ascii.FF, 57, 110, 102, 100, Ascii.FS, 80, 69, 114, 99, 86, 57, 111, 124, 47, 48, 101, Utf8.REPLACEMENT_BYTE, 71, 69, 112, 9, 95, 81, 73, 51, 106, 44, 86, 68}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) pblk.a(16777217, 0, 0L, "b1adbf", new byte[]{127, 54, 4, Ascii.NAK, 81}), -1) / r0.getIntExtra((String) pblk.a(16777217, 0, 0L, "37cda2", new byte[]{49, 54, 17, Ascii.FS, 91}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public synchronized int[] ga() {
        int size = this.d.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{this.d.get(0).intValue()};
        }
        try {
            List<Integer> list = this.d;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<Integer> listSubList = list.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = listSubList.get(i2).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public void tg() {
        int i;
        int iD;
        int iE;
        try {
            synchronized (this) {
                iD = d();
                iE = e();
            }
            i = (iD * 10000) + iE;
        } catch (Exception unused) {
            i = k12.e;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.d.add(numValueOf);
        try {
            int size = this.d.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.d.subList(size - 10, size));
                this.d.clear();
                this.d = arrayList;
            }
        } catch (Throwable unused2) {
        }
    }

    public static k1 e(Context context) {
        if (e == null) {
            synchronized (k1.class) {
                if (e == null) {
                    e = new k1(context);
                }
            }
        }
        return e;
    }
}
