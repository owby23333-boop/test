package top.canyie.pine.entry;

import top.canyie.pine.Pine;
import top.canyie.pine.PineConfig;
import top.canyie.pine.utils.Primitives;
import top.canyie.pine.utils.ThreeTuple;

/* JADX INFO: loaded from: classes5.dex */
public final class Arm32Entry {
    private static final int CR_SIZE = 3;
    private static final boolean DISALLOW_LONG_CROSS_CR_AND_STACK;
    private static final int FPR_SIZE = 16;
    private static final boolean USE_HARDFP;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final float[] EMPTY_FLOAT_ARRAY = new float[0];

    public static class ParamTypesCache {
        int crLength;
        int fpLength;
        int stackLength;

        private ParamTypesCache() {
        }
    }

    static {
        int i = PineConfig.sdkLevel;
        USE_HARDFP = i >= 23;
        DISALLOW_LONG_CROSS_CR_AND_STACK = i >= 31;
    }

    private Arm32Entry() {
    }

    private static boolean booleanBridge(int i, int i2, int i3) {
        return ((Boolean) handleBridge(i, i2, i3)).booleanValue();
    }

    private static byte byteBridge(int i, int i2, int i3) {
        return ((Byte) handleBridge(i, i2, i3)).byteValue();
    }

    private static char charBridge(int i, int i2, int i3) {
        return ((Character) handleBridge(i, i2, i3)).charValue();
    }

    private static double doubleBridge(int i, int i2, int i3) {
        return ((Double) handleBridge(i, i2, i3)).doubleValue();
    }

    private static float floatBridge(int i, int i2, int i3) {
        return ((Float) handleBridge(i, i2, i3)).floatValue();
    }

    private static ThreeTuple<int[], int[], float[]> getArgs(Pine.HookRecord hookRecord, int i, int i2) {
        int iMin;
        int i3;
        int i4;
        if (hookRecord.paramTypesCache == null) {
            i3 = !hookRecord.isStatic ? 1 : 0;
            int i5 = 0;
            int i6 = 0;
            iMin = i3;
            for (Class<?> cls : hookRecord.paramTypes) {
                if (cls == Double.TYPE) {
                    i5++;
                    i3++;
                } else if (cls == Float.TYPE) {
                    i6++;
                } else {
                    if (cls == Long.TYPE) {
                        if (iMin == 0) {
                            iMin++;
                        }
                        if (iMin < 3) {
                            iMin++;
                        }
                        i3++;
                    }
                    if (iMin < 3) {
                        iMin++;
                    }
                }
                i3++;
            }
            i4 = (i5 * 2) + i6;
            ParamTypesCache paramTypesCache = new ParamTypesCache();
            paramTypesCache.crLength = iMin;
            paramTypesCache.stackLength = i3;
            paramTypesCache.fpLength = i4;
            hookRecord.paramTypesCache = paramTypesCache;
        } else {
            ParamTypesCache paramTypesCache2 = (ParamTypesCache) hookRecord.paramTypesCache;
            iMin = paramTypesCache2.crLength;
            i3 = paramTypesCache2.stackLength;
            i4 = paramTypesCache2.fpLength;
        }
        float[] fArr = EMPTY_FLOAT_ARRAY;
        if (!USE_HARDFP) {
            iMin = Math.min(iMin + i4, 3);
        } else if (i4 != 0) {
            fArr = new float[Math.min(Primitives.evenUp(i4), 16)];
        }
        int[] iArr = iMin != 0 ? new int[iMin] : EMPTY_INT_ARRAY;
        int[] iArr2 = i3 != 0 ? new int[i3] : EMPTY_INT_ARRAY;
        Pine.getArgsArm32(i, i2, iArr, iArr2, fArr);
        return new ThreeTuple<>(iArr, iArr2, fArr);
    }

    private static Object handleBridge(int i, int i2, int i3) {
        Object object;
        int i4;
        int i5;
        Object[] objArr;
        int i6;
        int i7;
        int i8;
        Object object2;
        int i9;
        int i10;
        int i11;
        char c;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int iCloneExtras = (int) Pine.cloneExtras(i2);
        char c2 = 1;
        Pine.log("handleBridge: artMethod=%#x originExtras=%#x extras=%#x sp=%#x", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iCloneExtras), Integer.valueOf(i3));
        Pine.HookRecord hookRecord = Pine.getHookRecord(i);
        ThreeTuple<int[], int[], float[]> args = getArgs(hookRecord, iCloneExtras, i3);
        int[] iArr = args.f2565a;
        int[] iArr2 = args.b;
        float[] fArr = args.c;
        long jCurrentArtThread0 = Pine.currentArtThread0();
        if (hookRecord.isStatic) {
            object = null;
            i4 = 0;
            i5 = 0;
        } else {
            object = Pine.getObject(jCurrentArtThread0, iArr[0]);
            i4 = 1;
            i5 = 1;
        }
        int i17 = hookRecord.paramNumber;
        if (i17 > 0) {
            objArr = new Object[i17];
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i19 < hookRecord.paramNumber) {
                Class<?> cls = hookRecord.paramTypes[i19];
                if (cls == Double.TYPE) {
                    int iMax = Math.max(i20, Primitives.evenUp(i18));
                    if (iMax < fArr.length) {
                        i5++;
                        i20 = iMax + 2;
                        object2 = Double.valueOf(Primitives.floats2Double(fArr[iMax], fArr[iMax + 1]));
                        i6 = i18;
                    } else {
                        if (i4 >= iArr.length || USE_HARDFP) {
                            i14 = iArr2[i5];
                        } else {
                            int i21 = i4 + 1;
                            int i22 = iArr[i4];
                            i4 = i21;
                            i14 = i22;
                        }
                        i5++;
                        if (i4 >= iArr.length || USE_HARDFP) {
                            i15 = i4;
                            i16 = iArr2[i5];
                        } else {
                            i15 = i4 + 1;
                            i16 = iArr[i4];
                        }
                        object2 = Double.valueOf(Primitives.ints2Double(i14, i16));
                        i4 = i15;
                        i6 = i18;
                        i20 = iMax;
                    }
                } else if (cls == Float.TYPE) {
                    int i23 = i18;
                    int iMax2 = i23 % 2 == 0 ? Math.max(i20, i23) : i23;
                    if (iMax2 < fArr.length) {
                        i6 = iMax2 + 1;
                        object2 = Float.valueOf(fArr[iMax2]);
                    } else {
                        if (i4 >= iArr.length || USE_HARDFP) {
                            int i24 = i4;
                            i12 = iArr2[i5];
                            i13 = i24;
                        } else {
                            i13 = i4 + 1;
                            i12 = iArr[i4];
                        }
                        object2 = Float.valueOf(Float.intBitsToFloat(i12));
                        i4 = i13;
                        i6 = iMax2;
                    }
                } else {
                    i6 = i18;
                    if (cls != Long.TYPE) {
                        if (i4 < iArr.length) {
                            i8 = i4 + 1;
                            i7 = iArr[i4];
                        } else {
                            int i25 = i4;
                            i7 = iArr2[i5];
                            i8 = i25;
                        }
                        if (!cls.isPrimitive()) {
                            object2 = Pine.getObject(jCurrentArtThread0, i7);
                            i4 = i8;
                        } else if (cls == Integer.TYPE) {
                            object2 = Integer.valueOf(i7);
                            i4 = i8;
                        } else if (cls == Boolean.TYPE) {
                            object2 = Boolean.valueOf(i7 != 0);
                            i4 = i8;
                        } else if (cls == Short.TYPE) {
                            object2 = Short.valueOf((short) i7);
                            i4 = i8;
                        } else if (cls == Character.TYPE) {
                            object2 = Character.valueOf((char) i7);
                            i4 = i8;
                        } else {
                            if (cls != Byte.TYPE) {
                                throw new AssertionError("Unknown primitive type: " + cls);
                            }
                            object2 = Byte.valueOf((byte) i7);
                            i4 = i8;
                        }
                    } else if (i4 == 0 && hookRecord.isStatic && USE_HARDFP) {
                        objArr[i19] = Long.valueOf(Primitives.ints2Long(iArr[c2], iArr[2]));
                        i5 += 2;
                        c = c2;
                        i4 = 3;
                        i19++;
                        c2 = c;
                        i18 = i6;
                    } else {
                        if (i4 == 2 && DISALLOW_LONG_CROSS_CR_AND_STACK) {
                            i4 = 3;
                        }
                        if (i4 < iArr.length) {
                            int i26 = i4 + 1;
                            int i27 = iArr[i4];
                            i4 = i26;
                            i9 = i27;
                        } else {
                            i9 = iArr2[i5];
                        }
                        i5++;
                        if (i4 < iArr.length) {
                            i11 = i4 + 1;
                            i10 = iArr[i4];
                        } else {
                            int i28 = i4;
                            i10 = iArr2[i5];
                            i11 = i28;
                        }
                        Long lValueOf = Long.valueOf(Primitives.ints2Long(i9, i10));
                        i4 = i11;
                        object2 = lValueOf;
                    }
                }
                objArr[i19] = object2;
                c = 1;
                i5++;
                i19++;
                c2 = c;
                i18 = i6;
            }
        } else {
            objArr = Pine.EMPTY_OBJECT_ARRAY;
        }
        return Pine.handleCall(hookRecord, object, objArr);
    }

    private static int intBridge(int i, int i2, int i3) {
        return ((Integer) handleBridge(i, i2, i3)).intValue();
    }

    private static long longBridge(int i, int i2, int i3) {
        return ((Long) handleBridge(i, i2, i3)).longValue();
    }

    private static Object objectBridge(int i, int i2, int i3) {
        return handleBridge(i, i2, i3);
    }

    private static short shortBridge(int i, int i2, int i3) {
        return ((Short) handleBridge(i, i2, i3)).shortValue();
    }

    private static void voidBridge(int i, int i2, int i3) {
        handleBridge(i, i2, i3);
    }
}
