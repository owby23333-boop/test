package com.bytedance.sdk.component.panglearmor.z.z.z;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static com.bytedance.sdk.component.panglearmor.z.z.dl.g z(com.bytedance.sdk.component.panglearmor.z.g.g gVar) throws IOException, com.bytedance.sdk.component.panglearmor.z.z.dl.z {
        Pair<ByteBuffer, Long> pairZ = com.bytedance.sdk.component.panglearmor.z.z.g.g.z.z(gVar);
        if (pairZ == null) {
            throw new com.bytedance.sdk.component.panglearmor.z.z.dl.z("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairZ.first;
        long jLongValue = ((Long) pairZ.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jZ = com.bytedance.sdk.component.panglearmor.z.z.g.g.z.z(byteBuffer);
        if (jZ > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.z.z.dl.z("ZIP Central Directory start offset out of range: " + jZ + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jG = com.bytedance.sdk.component.panglearmor.z.z.g.g.z.g(byteBuffer);
        long j = jZ + jG;
        if (j > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.z.z.dl.z("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
        }
        return new com.bytedance.sdk.component.panglearmor.z.z.dl.g(jZ, jG, com.bytedance.sdk.component.panglearmor.z.z.g.g.z.dl(byteBuffer), jLongValue, byteBuffer);
    }

    public static z z(com.bytedance.sdk.component.panglearmor.z.g.g gVar, com.bytedance.sdk.component.panglearmor.z.z.dl.g gVar2) throws Exception {
        long jZ = gVar2.z();
        long jG = gVar2.g() + jZ;
        long jA = gVar2.a();
        if (jG != jA) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jG + ", EoCD start: " + jA);
        }
        if (jZ < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jZ)));
        }
        ByteBuffer byteBufferZ = gVar.z(jZ - 24, 24);
        byteBufferZ.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferZ.getLong(8) != 2334950737559900225L || byteBufferZ.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j = byteBufferZ.getLong(0);
        if (j < byteBufferZ.capacity() || j > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = jZ - j2;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferZ2 = gVar.z(j3, 8);
        byteBufferZ2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = byteBufferZ2.getLong(0);
        if (j4 != j) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new z(j3, gVar.z(j3, j2));
    }

    public static class z {
        private final com.bytedance.sdk.component.panglearmor.z.g.g g;
        private final long z;

        public z(long j, com.bytedance.sdk.component.panglearmor.z.g.g gVar) {
            this.z = j;
            this.g = gVar;
        }

        public long z() {
            return this.z;
        }

        public com.bytedance.sdk.component.panglearmor.z.g.g g() {
            return this.g;
        }
    }
}
