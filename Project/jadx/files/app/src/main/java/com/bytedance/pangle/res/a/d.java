package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static void a(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        a(inputStream);
        a(bArr);
        int i4 = 0;
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i3)));
        }
        int i5 = i2 + i3;
        int length = bArr.length;
        if (i2 < 0 || i5 < i2 || i5 > length) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(i5);
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        while (i4 < i3) {
            int i6 = inputStream.read(bArr, i2 + i4, i3 - i4);
            if (i6 == -1) {
                break;
            } else {
                i4 += i6;
            }
        }
        if (i4 == i3) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + i4 + " bytes; " + i3 + " bytes expected");
    }
}
