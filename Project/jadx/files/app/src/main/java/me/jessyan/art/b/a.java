package me.jessyan.art.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: compiled from: Base64Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
@QDTCProtect
public class a extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final char[] f21136u = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f21137v = new int[128];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f21138s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f21139t;

    static {
        for (int i2 = 0; i2 < 64; i2++) {
            f21137v[f21136u[i2]] = i2;
        }
    }

    public a(InputStream inputStream) {
        super(inputStream);
    }

    public static byte[] b(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = null;
        }
        a aVar = new a(new ByteArrayInputStream(bytes));
        double length = bytes.length;
        Double.isNaN(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (length * 0.67d));
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = aVar.read(bArr);
                if (i2 == -1) {
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        do {
            i2 = ((FilterInputStream) this).in.read();
            if (i2 == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) i2));
        this.f21138s++;
        if (i2 == 61) {
            return -1;
        }
        int i3 = f21137v[i2];
        int i4 = (this.f21138s - 1) % 4;
        if (i4 == 0) {
            this.f21139t = i3 & 63;
            return read();
        }
        if (i4 == 1) {
            int i5 = ((this.f21139t << 2) + (i3 >> 4)) & 255;
            this.f21139t = i3 & 15;
            return i5;
        }
        if (i4 == 2) {
            int i6 = ((this.f21139t << 4) + (i3 >> 2)) & 255;
            this.f21139t = i3 & 3;
            return i6;
        }
        if (i4 == 3) {
            return ((this.f21139t << 6) + i3) & 255;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr.length < (i3 + i2) - 1) {
            throw new IOException("The input buffer is too small: " + i3 + " bytes requested starting at offset " + i2 + " while the buffer  is only " + bArr.length + " bytes long.");
        }
        int i4 = 0;
        while (i4 < i3) {
            int i5 = read();
            if (i5 == -1 && i4 == 0) {
                return -1;
            }
            if (i5 == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
        }
        return i4;
    }
}
