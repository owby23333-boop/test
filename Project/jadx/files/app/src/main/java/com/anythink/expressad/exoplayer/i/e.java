package com.anythink.expressad.exoplayer.i;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.aa;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends h {

    @Nullable
    private a a;

    public static final class a {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9558c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9559d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public final int f9560e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f9562g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final af[] f9563h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int[] f9564i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int[][][] f9565j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final af f9566k;

        /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.i.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        @interface InterfaceC0199a {
        }

        a(int[] iArr, af[] afVarArr, int[] iArr2, int[][][] iArr3, af afVar) {
            this.f9562g = iArr;
            this.f9563h = afVarArr;
            this.f9565j = iArr3;
            this.f9564i = iArr2;
            this.f9566k = afVar;
            this.f9561f = iArr.length;
            this.f9560e = this.f9561f;
        }

        private int c(int i2) {
            int i3;
            int[][] iArr = this.f9565j[i2];
            int i4 = 0;
            int i5 = 0;
            while (i4 < iArr.length) {
                int iMax = i5;
                for (int i6 = 0; i6 < iArr[i4].length; i6++) {
                    int i7 = iArr[i4][i6] & 7;
                    if (i7 == 3) {
                        i3 = 2;
                    } else {
                        if (i7 == 4) {
                            return 3;
                        }
                        i3 = 1;
                    }
                    iMax = Math.max(iMax, i3);
                }
                i4++;
                i5 = iMax;
            }
            return i5;
        }

        @Deprecated
        private int d(int i2) {
            int i3;
            int iMax = 0;
            for (int i4 = 0; i4 < this.f9561f; i4++) {
                if (this.f9562g[i4] == i2) {
                    int[][] iArr = this.f9565j[i4];
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= iArr.length) {
                            break;
                        }
                        int iMax2 = i6;
                        for (int i7 = 0; i7 < iArr[i5].length; i7++) {
                            int i8 = iArr[i5][i7] & 7;
                            if (i8 == 3) {
                                i3 = 2;
                            } else {
                                if (i8 == 4) {
                                    i6 = 3;
                                    break;
                                }
                                i3 = 1;
                            }
                            iMax2 = Math.max(iMax2, i3);
                        }
                        i5++;
                        i6 = iMax2;
                    }
                    iMax = Math.max(iMax, i6);
                }
            }
            return iMax;
        }

        private int e(int i2) {
            int i3;
            int iMax = 0;
            for (int i4 = 0; i4 < this.f9561f; i4++) {
                if (this.f9562g[i4] == i2) {
                    int[][] iArr = this.f9565j[i4];
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= iArr.length) {
                            break;
                        }
                        int iMax2 = i6;
                        for (int i7 = 0; i7 < iArr[i5].length; i7++) {
                            int i8 = iArr[i5][i7] & 7;
                            if (i8 == 3) {
                                i3 = 2;
                            } else {
                                if (i8 == 4) {
                                    i6 = 3;
                                    break;
                                }
                                i3 = 1;
                            }
                            iMax2 = Math.max(iMax2, i3);
                        }
                        i5++;
                        i6 = iMax2;
                    }
                    iMax = Math.max(iMax, i6);
                }
            }
            return iMax;
        }

        public final int a() {
            return this.f9561f;
        }

        public final af b(int i2) {
            return this.f9563h[i2];
        }

        @Deprecated
        private int b(int i2, int i3, int i4) {
            return a(i2, i3, i4);
        }

        public final int a(int i2) {
            return this.f9562g[i2];
        }

        public final int a(int i2, int i3, int i4) {
            return this.f9565j[i2][i3][i4] & 7;
        }

        public final af b() {
            return this.f9566k;
        }

        public final int a(int i2, int i3) {
            int i4 = this.f9563h[i2].a(i3).a;
            int[] iArr = new int[i4];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                if (a(i2, i3, i7) == 4) {
                    iArr[i6] = i7;
                    i6++;
                }
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i6);
            String str = null;
            boolean z2 = false;
            int i8 = 0;
            int iMin = 16;
            while (i5 < iArrCopyOf.length) {
                String str2 = this.f9563h[i2].a(i3).a(iArrCopyOf[i5]).f9990h;
                int i9 = i8 + 1;
                if (i8 == 0) {
                    str = str2;
                } else {
                    z2 |= !com.anythink.expressad.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                iMin = Math.min(iMin, this.f9565j[i2][i3][i5] & 24);
                i5++;
                i8 = i9;
            }
            return z2 ? Math.min(iMin, this.f9564i[i2]) : iMin;
        }

        @Deprecated
        private af c() {
            return this.f9566k;
        }

        private int a(int i2, int i3, int[] iArr) {
            int i4 = 0;
            String str = null;
            boolean z2 = false;
            int i5 = 0;
            int iMin = 16;
            while (i4 < iArr.length) {
                String str2 = this.f9563h[i2].a(i3).a(iArr[i4]).f9990h;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z2 |= !com.anythink.expressad.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                iMin = Math.min(iMin, this.f9565j[i2][i3][i4] & 24);
                i4++;
                i5 = i6;
            }
            return z2 ? Math.min(iMin, this.f9564i[i2]) : iMin;
        }
    }

    protected abstract Pair<aa[], f[]> a(a aVar, int[][][] iArr, int[] iArr2);

    @Nullable
    public final a a() {
        return this.a;
    }

    @Override // com.anythink.expressad.exoplayer.i.h
    public final void a(Object obj) {
        this.a = (a) obj;
    }

    @Override // com.anythink.expressad.exoplayer.i.h
    public final i a(z[] zVarArr, af afVar) {
        int[] iArr;
        int[] iArr2 = new int[zVarArr.length + 1];
        ae[][] aeVarArr = new ae[zVarArr.length + 1][];
        int[][][] iArr3 = new int[zVarArr.length + 1][][];
        for (int i2 = 0; i2 < aeVarArr.length; i2++) {
            int i3 = afVar.b;
            aeVarArr[i2] = new ae[i3];
            iArr3[i2] = new int[i3][];
        }
        int[] iArr4 = new int[zVarArr.length];
        for (int i4 = 0; i4 < iArr4.length; i4++) {
            iArr4[i4] = zVarArr[i4].m();
        }
        for (int i5 = 0; i5 < afVar.b; i5++) {
            ae aeVarA = afVar.a(i5);
            int length = zVarArr.length;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i6 >= zVarArr.length) {
                    i6 = length;
                    break;
                }
                z zVar = zVarArr[i6];
                int i8 = length;
                int i9 = i7;
                for (int i10 = 0; i10 < aeVarA.a; i10++) {
                    int iA = zVar.a(aeVarA.a(i10)) & 7;
                    if (iA > i9) {
                        if (iA == 4) {
                            break;
                        }
                        i8 = i6;
                        i9 = iA;
                    }
                }
                i6++;
                i7 = i9;
                length = i8;
            }
            if (i6 == zVarArr.length) {
                iArr = new int[aeVarA.a];
            } else {
                z zVar2 = zVarArr[i6];
                int[] iArr5 = new int[aeVarA.a];
                for (int i11 = 0; i11 < aeVarA.a; i11++) {
                    iArr5[i11] = zVar2.a(aeVarA.a(i11));
                }
                iArr = iArr5;
            }
            int i12 = iArr2[i6];
            aeVarArr[i6][i12] = aeVarA;
            iArr3[i6][i12] = iArr;
            iArr2[i6] = iArr2[i6] + 1;
        }
        af[] afVarArr = new af[zVarArr.length];
        int[] iArr6 = new int[zVarArr.length];
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            int i14 = iArr2[i13];
            afVarArr[i13] = new af((ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[i13], i14));
            iArr3[i13] = (int[][]) com.anythink.expressad.exoplayer.k.af.a(iArr3[i13], i14);
            iArr6[i13] = zVarArr[i13].a();
        }
        a aVar = new a(iArr6, afVarArr, iArr4, iArr3, new af((ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[zVarArr.length], iArr2[zVarArr.length])));
        Pair<aa[], f[]> pairA = a(aVar, iArr3, iArr4);
        return new i((aa[]) pairA.first, (f[]) pairA.second, aVar);
    }

    private static int a(z[] zVarArr, ae aeVar) {
        int length = zVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zVarArr.length) {
            z zVar = zVarArr[i2];
            int i4 = i3;
            int i5 = length;
            for (int i6 = 0; i6 < aeVar.a; i6++) {
                int iA = zVar.a(aeVar.a(i6)) & 7;
                if (iA > i4) {
                    if (iA == 4) {
                        return i2;
                    }
                    i5 = i2;
                    i4 = iA;
                }
            }
            i2++;
            length = i5;
            i3 = i4;
        }
        return length;
    }

    private static int[] a(z zVar, ae aeVar) {
        int[] iArr = new int[aeVar.a];
        for (int i2 = 0; i2 < aeVar.a; i2++) {
            iArr[i2] = zVar.a(aeVar.a(i2));
        }
        return iArr;
    }

    private static int[] a(z[] zVarArr) {
        int[] iArr = new int[zVarArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = zVarArr[i2].m();
        }
        return iArr;
    }
}
