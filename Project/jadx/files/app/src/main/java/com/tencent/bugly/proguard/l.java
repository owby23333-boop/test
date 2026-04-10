package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public ByteBuffer a;
    protected String b;

    public l(int i2) {
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i2);
    }

    private void a(int i2) {
        if (this.a.remaining() < i2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.a.capacity() + i2) * 2);
            byteBufferAllocate.put(this.a.array(), 0, this.a.position());
            this.a = byteBufferAllocate;
        }
    }

    private void b(byte b, int i2) {
        if (i2 < 15) {
            this.a.put((byte) (b | (i2 << 4)));
        } else {
            if (i2 >= 256) {
                throw new j("tag is too large: ".concat(String.valueOf(i2)));
            }
            this.a.put((byte) (b | 240));
            this.a.put((byte) i2);
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z2, int i2) {
        a(z2 ? (byte) 1 : (byte) 0, i2);
    }

    public final void a(byte b, int i2) {
        a(3);
        if (b == 0) {
            b((byte) 12, i2);
        } else {
            b((byte) 0, i2);
            this.a.put(b);
        }
    }

    public final void a(short s2, int i2) {
        a(4);
        if (s2 >= -128 && s2 <= 127) {
            a((byte) s2, i2);
        } else {
            b((byte) 1, i2);
            this.a.putShort(s2);
        }
    }

    public final void a(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            a((short) i2, i3);
        } else {
            b((byte) 2, i3);
            this.a.putInt(i2);
        }
    }

    public final void a(long j2, int i2) {
        a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            a((int) j2, i2);
        } else {
            b((byte) 3, i2);
            this.a.putLong(j2);
        }
    }

    private void a(float f2, int i2) {
        a(6);
        b((byte) 4, i2);
        this.a.putFloat(f2);
    }

    private void a(double d2, int i2) {
        a(10);
        b((byte) 5, i2);
        this.a.putDouble(d2);
    }

    public final void a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i2);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
        } else {
            b((byte) 6, i2);
            this.a.put((byte) bytes.length);
            this.a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i2) {
        a(8);
        b((byte) 8, i2);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(zArr.length, 0);
        for (boolean z2 : zArr) {
            a(z2, 0);
        }
    }

    public final void a(byte[] bArr, int i2) {
        a(bArr.length + 8);
        b(cb.f19602k, i2);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.a.put(bArr);
    }

    private void a(short[] sArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(sArr.length, 0);
        for (short s2 : sArr) {
            a(s2, 0);
        }
    }

    private void a(int[] iArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(iArr.length, 0);
        for (int i3 : iArr) {
            a(i3, 0);
        }
    }

    private void a(long[] jArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(jArr.length, 0);
        for (long j2 : jArr) {
            a(j2, 0);
        }
    }

    private void a(float[] fArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(fArr.length, 0);
        for (float f2 : fArr) {
            a(f2, 0);
        }
    }

    private void a(double[] dArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(dArr.length, 0);
        for (double d2 : dArr) {
            a(d2, 0);
        }
    }

    private void a(Object[] objArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i2) {
        a(8);
        b((byte) 9, i2);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(m mVar, int i2) {
        a(2);
        b((byte) 10, i2);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i2) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i2);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i2);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i2);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i2);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i2);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i2);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i2);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i2);
            return;
        }
        if (obj instanceof m) {
            a((m) obj, i2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i2);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i2);
            return;
        }
        if (obj.getClass().isArray()) {
            a((Object[]) obj, i2);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i2);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
