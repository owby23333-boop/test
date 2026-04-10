package me.jessyan.art.b;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: compiled from: Base64Encoder.java */
/* JADX INFO: loaded from: classes3.dex */
@QDTCProtect
public class b extends FilterOutputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final char[] f21140u = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f21141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f21142t;

    public b(OutputStream outputStream) {
        super(outputStream);
    }

    public static String a(byte[] bArr) {
        double length = bArr.length;
        Double.isNaN(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (length * 1.37d));
        b bVar = new b(byteArrayOutputStream);
        try {
            bVar.write(bArr);
            bVar.close();
            return byteArrayOutputStream.toString("UTF-8");
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i2 = this.f21141s;
        if (i2 % 3 == 1) {
            ((FilterOutputStream) this).out.write(f21140u[(this.f21142t << 4) & 63]);
            ((FilterOutputStream) this).out.write(61);
            ((FilterOutputStream) this).out.write(61);
        } else if (i2 % 3 == 2) {
            ((FilterOutputStream) this).out.write(f21140u[(this.f21142t << 2) & 63]);
            ((FilterOutputStream) this).out.write(61);
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.f21141s;
        if (i3 % 3 == 0) {
            this.f21142t = i2 & 3;
            ((FilterOutputStream) this).out.write(f21140u[i2 >> 2]);
        } else if (i3 % 3 == 1) {
            int i4 = ((this.f21142t << 4) + (i2 >> 4)) & 63;
            this.f21142t = i2 & 15;
            ((FilterOutputStream) this).out.write(f21140u[i4]);
        } else if (i3 % 3 == 2) {
            ((FilterOutputStream) this).out.write(f21140u[((this.f21142t << 2) + (i2 >> 6)) & 63]);
            ((FilterOutputStream) this).out.write(f21140u[i2 & 63]);
            this.f21142t = 0;
        }
        this.f21141s++;
        if (this.f21141s % 57 == 0) {
            ((FilterOutputStream) this).out.write(10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            write(bArr[i2 + i4]);
        }
    }
}
