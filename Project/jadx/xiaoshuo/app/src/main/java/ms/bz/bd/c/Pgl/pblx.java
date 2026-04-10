package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public final class pblx {

    public static class pblb extends Exception {
        public pblb(String str) {
            super(str);
        }
    }

    public static final class pgla<A, B> {
        private final B bf;
        private final A e;

        private pgla(A a2, B b2) {
            this.e = a2;
            this.bf = b2;
        }

        public A e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || pgla.class != obj.getClass()) {
                return false;
            }
            pgla pglaVar = (pgla) obj;
            A a2 = this.e;
            if (a2 == null) {
                if (pglaVar.e != null) {
                    return false;
                }
            } else if (!a2.equals(pglaVar.e)) {
                return false;
            }
            B b2 = this.bf;
            B b3 = pglaVar.bf;
            return b2 == null ? b3 == null : b2.equals(b3);
        }

        public int hashCode() {
            A a2 = this.e;
            int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
            B b2 = this.bf;
            return iHashCode + (b2 != null ? b2.hashCode() : 0);
        }

        public static <A, B> pgla<A, B> e(A a2, B b2) {
            return new pgla<>(a2, b2);
        }
    }

    public static boolean e() {
        return e((String) pblk.a(16777217, 0, 0L, "4f88f1", new byte[]{38, 107, 70, 2, 91, Utf8.REPLACEMENT_BYTE, 35, 66, 109, 105, 43, 103, 78, 2, 95, 52, 54, 74, 126, 103, 55, 111, 5, 79, 86, 52, 50, 9, 122, 108, 46, 105, 68, 66, 80, 50, 56, 85, 39, 88, 34, 104, 120, 104, 114, Ascii.VT, 56, 73, 96, 124, 42, 118, 126, 88, 80, 42, 36}));
    }

    private static boolean e(String... strArr) {
        boolean z;
        boolean z2 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        return z2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:5|(4:38|6|7|8)|(5:34|9|10|11|(4:14|(3:36|24|48)|46|12))|40|29|30) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.Integer, java.lang.String> e(java.lang.String r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L94
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "bce51e"
            r8 = 1
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L94
            r9 = 0
            r10 = 97
            r8[r9] = r10     // Catch: java.lang.Throwable -> L94
            java.lang.Object r3 = ms.bz.bd.c.Pgl.pblk.a(r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> L94
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L94
            r2.<init>(r11, r3)     // Catch: java.lang.Throwable -> L94
            java.nio.channels.FileChannel r11 = r2.getChannel()     // Catch: java.lang.Throwable -> L93
            ms.bz.bd.c.Pgl.pblx$pgla r11 = e(r11)     // Catch: java.lang.Throwable -> L93
            java.lang.Object r11 = r11.e()     // Catch: java.lang.Throwable -> L93
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11     // Catch: java.lang.Throwable -> L93
            java.util.Map r11 = e(r11)     // Catch: java.lang.Throwable -> L93
            java.util.LinkedHashMap r11 = (java.util.LinkedHashMap) r11
            java.util.Set r11 = r11.entrySet()     // Catch: java.lang.Throwable -> L93
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Throwable -> L93
        L44:
            boolean r1 = r11.hasNext()     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L97
            java.lang.Object r1 = r11.next()     // Catch: java.lang.Throwable -> L93
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L53
            goto L44
        L53:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L93
            if (r3 != 0) goto L5a
            goto L44
        L5a:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L93
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L93
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L93
            r4 = 1896449818(0x7109871a, float:6.810044E29)
            if (r3 != r4) goto L6a
            goto L44
        L6a:
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L44
            java.lang.Object r4 = r1.getValue()     // Catch: java.lang.Throwable -> L44
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch: java.lang.Throwable -> L44
            byte[] r5 = r4.array()     // Catch: java.lang.Throwable -> L44
            int r6 = r4.arrayOffset()     // Catch: java.lang.Throwable -> L44
            int r7 = r4.position()     // Catch: java.lang.Throwable -> L44
            int r7 = r7 + r6
            int r4 = r4.limit()     // Catch: java.lang.Throwable -> L44
            int r6 = r6 + r4
            byte[] r4 = java.util.Arrays.copyOfRange(r5, r7, r6)     // Catch: java.lang.Throwable -> L44
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L44
            java.lang.Object r1 = r1.getKey()     // Catch: java.lang.Throwable -> L44
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L44
            goto L44
        L93:
            r1 = r2
        L94:
            if (r1 == 0) goto L9a
            r2 = r1
        L97:
            r2.close()     // Catch: java.lang.Throwable -> L9a
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblx.e(java.lang.String):java.util.Map");
    }

    public static pgla<ByteBuffer, Long> e(FileChannel fileChannel) throws pblb, IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) pblk.a(16777217, 0, 0L, "32a262", new byte[]{115, 97}));
        }
        long j = size - 22;
        long jMin = Math.min(j, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > jMin) {
                throw new IOException((String) pblk.a(16777217, 0, 0L, "a6ae94", new byte[]{33, 100}));
            }
            long j3 = j - j2;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(byteBufferAllocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(byteOrder);
                short s = byteBufferAllocate2.getShort(0);
                if (s == i) {
                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(4);
                    byteBufferAllocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - ((long) s)) - 6);
                    fileChannel.read(byteBufferAllocate3);
                    long j4 = byteBufferAllocate3.getInt(0);
                    if (j4 < 32) {
                        throw new pblb((String) pblk.a(16777217, 0, 0L, "0e2799", new byte[]{120}));
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(byteBufferAllocate4);
                    byteBufferAllocate4.order(byteOrder);
                    if (byteBufferAllocate4.getLong(8) == com.bytedance.hume.readapk.a.f2079b && byteBufferAllocate4.getLong(16) == com.bytedance.hume.readapk.a.f2078a) {
                        long j5 = byteBufferAllocate4.getLong(0);
                        if (j5 >= byteBufferAllocate4.capacity() && j5 <= 2147483639) {
                            int i2 = (int) (8 + j5);
                            long j6 = j4 - ((long) i2);
                            if (j6 >= 0) {
                                fileChannel.position(j6);
                                ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(i2);
                                fileChannel.read(byteBufferAllocate5);
                                byteBufferAllocate5.order(byteOrder);
                                if (byteBufferAllocate5.getLong(0) == j5) {
                                    return pgla.e(byteBufferAllocate5, Long.valueOf(j6));
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            i++;
        }
    }

    public static Map<Integer, ByteBuffer> e(ByteBuffer byteBuffer) throws pblb {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int iCapacity = byteBuffer.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "d69858", new byte[]{33}));
            }
            byteBuffer.capacity();
            if (iCapacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "f11368", new byte[]{34}));
            }
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            try {
                byteBuffer.position(0);
                byteBuffer.limit(iCapacity);
                byteBuffer.position(8);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (byteBufferSlice.hasRemaining()) {
                    if (byteBufferSlice.remaining() < 8) {
                        throw new pblb((String) pblk.a(16777217, 0, 0L, "18d8c7", new byte[]{118}));
                    }
                    long j = byteBufferSlice.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new pblb((String) pblk.a(16777217, 0, 0L, "c472b3", new byte[]{37}));
                    }
                    int i = (int) j;
                    int iPosition2 = byteBufferSlice.position() + i;
                    if (i > byteBufferSlice.remaining()) {
                        throw new pblb((String) pblk.a(16777217, 0, 0L, "5ee8d4", new byte[]{124}));
                    }
                    Integer numValueOf = Integer.valueOf(byteBufferSlice.getInt());
                    int i2 = i - 4;
                    if (i2 < 0) {
                        throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "0044e5", new byte[]{115}));
                    }
                    int iLimit2 = byteBufferSlice.limit();
                    int iPosition3 = byteBufferSlice.position();
                    int i3 = i2 + iPosition3;
                    if (i3 < iPosition3 || i3 > iLimit2) {
                        throw new BufferUnderflowException();
                    }
                    byteBufferSlice.limit(i3);
                    try {
                        ByteBuffer byteBufferSlice2 = byteBufferSlice.slice();
                        byteBufferSlice2.order(byteBufferSlice.order());
                        byteBufferSlice.position(i3);
                        byteBufferSlice.limit(iLimit2);
                        linkedHashMap.put(numValueOf, byteBufferSlice2);
                        byteBufferSlice.position(iPosition2);
                    } catch (Throwable th) {
                        byteBufferSlice.limit(iLimit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                throw th2;
            }
        }
        throw new IllegalArgumentException((String) pblk.a(16777217, 0, 0L, "bc091a", new byte[]{34}));
    }
}
