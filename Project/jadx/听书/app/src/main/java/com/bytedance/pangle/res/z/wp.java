package com.bytedance.pangle.res.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    public static void z(e eVar) throws IOException {
        eVar.g(1835009, 0);
        int i = eVar.readInt();
        int i2 = eVar.readInt();
        int i3 = eVar.readInt();
        eVar.z();
        int i4 = eVar.readInt();
        int i5 = eVar.readInt();
        eVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            eVar.skipBytes(i3 * 4);
        }
        eVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 == 0) {
            return;
        }
        int i6 = i - i5;
        eVar.skipBytes(i6);
        int i7 = i6 % 4;
        if (i7 <= 0) {
            return;
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return;
            }
            eVar.readByte();
            i7 = i8;
        }
    }
}
