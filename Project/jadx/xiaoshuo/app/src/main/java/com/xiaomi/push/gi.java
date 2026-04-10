package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes8.dex */
public class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8002a = {80, 85, 83, 72};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte f449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f8003b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8004a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final d f452a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f452a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!gi.m469a(bArr)) {
                return bArr;
            }
            gi giVarA = gi.a(bArr);
            return (giVarA.f449a == 0 || giVarA.f449a != bVar.a()) ? giVarA.f8003b : bVar.a(giVarA.f8003b, giVarA.f450a);
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    public static final class c {
    }

    public static final class d implements b {
        @Override // com.xiaomi.push.gi.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.gi.b
        public byte[] a(byte[] bArr, int i) throws Throwable {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    public gi(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    public gi(short s, byte b2, int i, byte[] bArr) {
        this.f451a = s;
        this.f449a = b2;
        this.f450a = i;
        this.f8003b = bArr;
    }

    public static gi a(byte b2, int i, byte[] bArr) {
        return new gi(b2, i, bArr);
    }

    public static gi a(short s, byte b2, int i, byte[] bArr) {
        return new gi(s, b2, i, bArr);
    }

    public static gi a(byte[] bArr) {
        if (m469a(bArr)) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            byteBufferOrder.getInt();
            short s = byteBufferOrder.getShort();
            byte b2 = byteBufferOrder.get();
            int i = byteBufferOrder.getInt();
            byte[] bArr2 = new byte[byteBufferOrder.getInt()];
            byteBufferOrder.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m469a(byte[] bArr) {
        byte[] bArr2 = f8002a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
