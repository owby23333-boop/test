package com.google.zxing.p;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements com.google.zxing.g {
    private com.google.zxing.h b(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i2;
        int i3;
        int iC = bVar.c();
        int iB = bVar.b();
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(iC);
        char c2 = 0;
        int i4 = 1;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, iB >> (z2 ? 8 : 5));
        int i5 = z2 ? iB : 15;
        int i6 = iB / 2;
        Map<DecodeHintType, ?> map2 = map;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i6;
            if (i10 < 0 || i10 >= iB) {
                break;
            }
            try {
                aVar = bVar.a(i10, aVar);
                Map<DecodeHintType, ?> map3 = map2;
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        aVar.e();
                        if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        com.google.zxing.h hVarA = a(i10, aVar, map3);
                        if (i11 == i4) {
                            hVarA.a(ResultMetadataType.ORIENTATION, 180);
                            com.google.zxing.i[] iVarArrD = hVarA.d();
                            if (iVarArrD != null) {
                                float f2 = iC;
                                i3 = iC;
                                try {
                                    iVarArrD[0] = new com.google.zxing.i((f2 - iVarArrD[c2].a()) - 1.0f, iVarArrD[c2].b());
                                    try {
                                        iVarArrD[1] = new com.google.zxing.i((f2 - iVarArrD[1].a()) - 1.0f, iVarArrD[1].b());
                                    } catch (ReaderException unused) {
                                        continue;
                                        i11++;
                                        iC = i3;
                                        c2 = 0;
                                        i4 = 1;
                                    }
                                } catch (ReaderException unused2) {
                                    i11++;
                                    iC = i3;
                                    c2 = 0;
                                    i4 = 1;
                                }
                            }
                        }
                        return hVarA;
                    } catch (ReaderException unused3) {
                        i3 = iC;
                    }
                }
                i2 = iC;
                map2 = map3;
            } catch (NotFoundException unused4) {
                i2 = iC;
            }
            i7 = i8;
            iC = i2;
            c2 = 0;
            i4 = 1;
        }
        throw NotFoundException.f();
    }

    public abstract com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.g
    public com.google.zxing.h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return b(bVar, map);
        } catch (NotFoundException e2) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !bVar.d()) {
                throw e2;
            }
            com.google.zxing.b bVarE = bVar.e();
            com.google.zxing.h hVarB = b(bVarE, map);
            Map<ResultMetadataType, Object> mapC = hVarB.c();
            int iIntValue = SubsamplingScaleImageView.ORIENTATION_270;
            if (mapC != null && mapC.containsKey(ResultMetadataType.ORIENTATION)) {
                iIntValue = (((Integer) mapC.get(ResultMetadataType.ORIENTATION)).intValue() + SubsamplingScaleImageView.ORIENTATION_270) % 360;
            }
            hVarB.a(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            com.google.zxing.i[] iVarArrD = hVarB.d();
            if (iVarArrD != null) {
                int iB = bVarE.b();
                for (int i2 = 0; i2 < iVarArrD.length; i2++) {
                    iVarArrD[i2] = new com.google.zxing.i((iB - iVarArrD[i2].b()) - 1.0f, iVarArrD[i2].a());
                }
            }
            return hVarB;
        }
    }

    @Override // com.google.zxing.g
    public void reset() {
    }

    protected static void a(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iC = aVar.c();
        if (i2 < iC) {
            boolean z2 = !aVar.a(i2);
            while (i2 < iC) {
                if (aVar.a(i2) == z2) {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z2 = !z2;
                } else {
                    iArr[i3] = iArr[i3] + 1;
                }
                i2++;
            }
            if (i3 != length) {
                if (i3 != length - 1 || i2 != iC) {
                    throw NotFoundException.f();
                }
                return;
            }
            return;
        }
        throw NotFoundException.f();
    }

    protected static void b(com.google.zxing.common.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zA = aVar.a(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.a(i2) != zA) {
                length--;
                zA = !zA;
            }
        }
        if (length < 0) {
            a(aVar, i2 + 1, iArr);
            return;
        }
        throw NotFoundException.f();
    }

    protected static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
