package com.bytedance.pangle.res.z;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    static byte[] z(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    static int z(e eVar) {
        return (int) eVar.z.z().g();
    }

    static int z(byte[] bArr, int i, int i2, gz gzVar) {
        if (i < 2130706432) {
            return i;
        }
        int iZ = gzVar.z(i);
        byte[] bArrZ = z(iZ);
        bArr[i2] = bArrZ[0];
        bArr[i2 + 1] = bArrZ[1];
        bArr[i2 + 2] = bArrZ[2];
        bArr[i2 + 3] = bArrZ[3];
        return iZ;
    }

    static void z(byte[] bArr, gz gzVar) throws IOException {
        g gVar = new g(bArr, gzVar);
        gVar.g(new ByteArrayInputStream(bArr));
        while (gVar.dl() != 1) {
        }
    }

    static void z(String str, byte[] bArr, gz gzVar) throws Throwable {
        if (!TextUtils.isEmpty(str) && gzVar.z(str)) {
            if (str.equals("AndroidManifest.xml")) {
                z(bArr, gzVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                z(bArr, gzVar);
            } else if (str.equals("resources.arsc")) {
                new z(bArr, gzVar).z();
            }
        }
    }

    public static void z(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (map.containsKey(Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                map2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i7, i7 + 20));
                map3.put(Integer.valueOf(map.get(Integer.valueOf(i6)).intValue()), Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) map2.get(Integer.valueOf(((Integer) map3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }
}
