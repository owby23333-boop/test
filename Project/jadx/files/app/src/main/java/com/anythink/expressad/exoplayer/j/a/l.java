package com.anythink.expressad.exoplayer.j.a;

import androidx.annotation.Nullable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements i {
    public static final l b = new l(Collections.emptyMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9638c = 10485760;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, byte[]> f9640e;

    private l(Map<String, byte[]> map) {
        this.f9640e = Collections.unmodifiableMap(map);
    }

    public static l a(DataInputStream dataInputStream) throws IOException {
        int i2 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < i2; i3++) {
            String utf = dataInputStream.readUTF();
            int i4 = dataInputStream.readInt();
            if (i4 < 0 || i4 > f9638c) {
                throw new IOException("Invalid value size: ".concat(String.valueOf(i4)));
            }
            byte[] bArr = new byte[i4];
            dataInputStream.readFully(bArr);
            map.put(utf, bArr);
        }
        return new l(map);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final boolean b(String str) {
        return this.f9640e.containsKey(str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return a(((l) obj).f9640e);
    }

    public final int hashCode() {
        if (this.f9639d == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.f9640e.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f9639d = iHashCode;
        }
        return this.f9639d;
    }

    public final l a(k kVar) {
        HashMap map = new HashMap(this.f9640e);
        a((HashMap<String, byte[]>) map, kVar.a());
        a((HashMap<String, byte[]>) map, kVar.b());
        return a((Map<String, byte[]>) map) ? this : new l(map);
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.f9640e.size());
        for (Map.Entry<String, byte[]> entry : this.f9640e.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final byte[] a(String str, byte[] bArr) {
        if (!this.f9640e.containsKey(str)) {
            return bArr;
        }
        byte[] bArr2 = this.f9640e.get(str);
        return Arrays.copyOf(bArr2, bArr2.length);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final String a(String str, String str2) {
        return this.f9640e.containsKey(str) ? new String(this.f9640e.get(str), Charset.forName("UTF-8")) : str2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.i
    public final long a(String str) {
        if (this.f9640e.containsKey(str)) {
            return ByteBuffer.wrap(this.f9640e.get(str)).getLong();
        }
        return -1L;
    }

    private boolean a(Map<String, byte[]> map) {
        if (this.f9640e.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : this.f9640e.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static Map<String, byte[]> a(Map<String, byte[]> map, k kVar) {
        HashMap map2 = new HashMap(map);
        a((HashMap<String, byte[]>) map2, kVar.a());
        a((HashMap<String, byte[]>) map2, kVar.b());
        return map2;
    }

    private static void a(HashMap<String, byte[]> map, List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            map.remove(list.get(i2));
        }
    }

    private static void a(HashMap<String, byte[]> map, Map<String, Object> map2) {
        byte[] bytes;
        for (String str : map2.keySet()) {
            Object obj = map2.get(str);
            if (obj instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
            } else if (obj instanceof String) {
                bytes = ((String) obj).getBytes(Charset.forName("UTF-8"));
            } else if (obj instanceof byte[]) {
                bytes = (byte[]) obj;
            } else {
                throw new IllegalArgumentException();
            }
            if (bytes.length <= f9638c) {
                map.put(str, bytes);
            } else {
                throw new IllegalArgumentException(String.format("The size of %s (%d) is greater than maximum allowed: %d", str, Integer.valueOf(bytes.length), Integer.valueOf(f9638c)));
            }
        }
    }

    private static byte[] a(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName("UTF-8"));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }
}
