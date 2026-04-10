package com.anythink.expressad.exoplayer.e;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.s;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public interface m {

    public static final class a {
        public final int a;
        public final byte[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9023d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.a = i2;
            this.b = bArr;
            this.f9022c = i3;
            this.f9023d = i4;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.f9022c == aVar.f9022c && this.f9023d == aVar.f9023d && Arrays.equals(this.b, aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.f9022c) * 31) + this.f9023d;
        }
    }

    int a(f fVar, int i2, boolean z2);

    void a(long j2, int i2, int i3, int i4, a aVar);

    void a(s sVar, int i2);

    void a(com.anythink.expressad.exoplayer.m mVar);
}
