package com.anythink.expressad.exoplayer.h;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public interface aa {

    public static class a implements aa {
        private final Random a;
        private final int[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f9197c;

        public a() {
            this(0, new Random());
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i2) {
            int i3 = this.f9197c[i2] - 1;
            if (i3 >= 0) {
                return this.b[i3];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa d() {
            return new a(0, new Random(this.a.nextLong()));
        }

        private a(int i2, long j2) {
            this(i2, new Random(j2));
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i2) {
            int i3 = this.f9197c[i2] + 1;
            int[] iArr = this.b;
            if (i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa c(int i2) {
            int[] iArr = new int[this.b.length - 1];
            int i3 = 0;
            boolean z2 = false;
            while (true) {
                int[] iArr2 = this.b;
                if (i3 >= iArr2.length) {
                    return new a(iArr, new Random(this.a.nextLong()));
                }
                if (iArr2[i3] == i2) {
                    z2 = true;
                } else {
                    int i4 = z2 ? i3 - 1 : i3;
                    int[] iArr3 = this.b;
                    iArr[i4] = iArr3[i3] > i2 ? iArr3[i3] - 1 : iArr3[i3];
                }
                i3++;
            }
        }

        private a(int i2, Random random) {
            this(a(i2, random), random);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        private a(int[] iArr, Random random) {
            this.b = iArr;
            this.a = random;
            this.f9197c = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f9197c[iArr[i2]] = i2;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa a(int i2, int i3) {
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                iArr[i4] = this.a.nextInt(this.b.length + 1);
                int i5 = i4 + 1;
                int iNextInt = this.a.nextInt(i5);
                iArr2[i4] = iArr2[iNextInt];
                iArr2[iNextInt] = i4 + i2;
                i4 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.b.length + i3];
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < this.b.length + i3; i8++) {
                if (i6 < i3 && i7 == iArr[i6]) {
                    iArr3[i8] = iArr2[i6];
                    i6++;
                } else {
                    int i9 = i7 + 1;
                    iArr3[i8] = this.b[i7];
                    if (iArr3[i8] >= i2) {
                        iArr3[i8] = iArr3[i8] + i3;
                    }
                    i7 = i9;
                }
            }
            return new a(iArr3, new Random(this.a.nextLong()));
        }

        private static int[] a(int i2, Random random) {
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i3 + 1;
                int iNextInt = random.nextInt(i4);
                iArr[i3] = iArr[iNextInt];
                iArr[iNextInt] = i3;
                i3 = i4;
            }
            return iArr;
        }
    }

    public static final class b implements aa {
        private final int a;

        public b(int i2) {
            this.a = i2;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int i2 = this.a;
            if (i2 > 0) {
                return i2 - 1;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i2) {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                return i3;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            return this.a > 0 ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa d() {
            return new b(0);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i2) {
            int i3 = i2 + 1;
            if (i3 < this.a) {
                return i3;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa c(int i2) {
            return new b(this.a - 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa a(int i2, int i3) {
            return new b(this.a + i3);
        }
    }

    int a();

    int a(int i2);

    aa a(int i2, int i3);

    int b();

    int b(int i2);

    int c();

    aa c(int i2);

    aa d();
}
