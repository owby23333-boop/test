package top.canyie.pine.entry;

import top.canyie.pine.Pine;
import top.canyie.pine.utils.ThreeTuple;

/* JADX INFO: loaded from: classes5.dex */
public final class Arm64Entry {
    private static final long BYTE_BITS = 255;
    private static final int CR_SIZE = 7;
    private static final int FPR_SIZE = 8;
    private static final long INT_BITS = 4294967295L;
    private static final long SHORT_BITS = 65535;
    private static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    public static class ParamTypesCache {
        int crLength;
        int fprLength;
        int stackLength;
        boolean[] typeWides;

        private ParamTypesCache() {
        }
    }

    private Arm64Entry() {
    }

    public static boolean booleanBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Boolean) handleBridge(j, j2, j3, j4, j5, j6, j7)).booleanValue();
    }

    public static byte byteBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Byte) handleBridge(j, j2, j3, j4, j5, j6, j7)).byteValue();
    }

    public static char charBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Character) handleBridge(j, j2, j3, j4, j5, j6, j7)).charValue();
    }

    public static double doubleBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Double) handleBridge(j, j2, j3, j4, j5, j6, j7)).doubleValue();
    }

    public static float floatBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Float) handleBridge(j, j2, j3, j4, j5, j6, j7)).floatValue();
    }

    private static ThreeTuple<long[], long[], double[]> getArgs(Pine.HookRecord hookRecord, long j, long j2, long j3, long j4, long j5, long j6) {
        int i;
        int i2;
        int i3;
        boolean[] zArr;
        boolean[] zArr2;
        boolean z;
        boolean z2;
        if (hookRecord.paramTypesCache == null) {
            int i4 = hookRecord.paramNumber;
            boolean z3 = hookRecord.isStatic;
            if (z3) {
                i = 0;
            } else {
                i4++;
                i = 1;
            }
            i2 = i;
            if (i4 != 0) {
                zArr2 = new boolean[i4];
                if (!z3) {
                    zArr2[0] = false;
                }
                i3 = 0;
                for (int i5 = 0; i5 < hookRecord.paramNumber; i5++) {
                    Class<?> cls = hookRecord.paramTypes[i5];
                    if (cls == Double.TYPE) {
                        z = true;
                        z2 = true;
                    } else if (cls == Float.TYPE) {
                        z2 = false;
                        z = true;
                    } else if (cls == Long.TYPE) {
                        z = false;
                        z2 = true;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    if (z) {
                        if (i3 < 8) {
                            i3++;
                        }
                    } else if (i < 7) {
                        i++;
                    }
                    i2 += z2 ? 8 : 4;
                    if (hookRecord.isStatic) {
                        zArr2[i5] = z2;
                    } else {
                        zArr2[i5 + 1] = z2;
                    }
                }
            } else {
                zArr2 = EMPTY_BOOLEAN_ARRAY;
                i3 = 0;
            }
            ParamTypesCache paramTypesCache = new ParamTypesCache();
            paramTypesCache.crLength = i;
            paramTypesCache.stackLength = i2;
            paramTypesCache.fprLength = i3;
            paramTypesCache.typeWides = (boolean[]) zArr2.clone();
            hookRecord.paramTypesCache = paramTypesCache;
            zArr = zArr2;
        } else {
            ParamTypesCache paramTypesCache2 = (ParamTypesCache) hookRecord.paramTypesCache;
            i = paramTypesCache2.crLength;
            i2 = paramTypesCache2.stackLength;
            i3 = paramTypesCache2.fprLength;
            zArr = (boolean[]) paramTypesCache2.typeWides.clone();
        }
        int i6 = j2 != 0 ? i2 : 0;
        long[] jArr = i != 0 ? new long[i] : EMPTY_LONG_ARRAY;
        long[] jArr2 = i6 != 0 ? new long[i6] : EMPTY_LONG_ARRAY;
        double[] dArr = i3 != 0 ? new double[i3] : EMPTY_DOUBLE_ARRAY;
        Pine.getArgsArm64(j, j2, zArr, jArr, jArr2, dArr);
        if (i >= 4) {
            jArr[3] = j3;
            if (i != 4) {
                jArr[4] = j4;
                if (i != 5) {
                    jArr[5] = j5;
                    if (i != 6) {
                        jArr[6] = j6;
                    }
                }
            }
        }
        return new ThreeTuple<>(jArr, jArr2, dArr);
    }

    private static Object handleBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        Object object;
        int i;
        int i2;
        Object[] objArr;
        long j8;
        int i3;
        Object object2;
        long jDoubleToLongBits;
        long jCloneExtras = Pine.cloneExtras(j2);
        Pine.log("handleBridge: artMethod=%#x originExtras=%#x extras=%#x sp=%#x", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(jCloneExtras), Long.valueOf(j3));
        Pine.HookRecord hookRecord = Pine.getHookRecord(j);
        ThreeTuple<long[], long[], double[]> args = getArgs(hookRecord, jCloneExtras, j3, j4, j5, j6, j7);
        long[] jArr = args.f2565a;
        long[] jArr2 = args.b;
        double[] dArr = args.c;
        long jCurrentArtThread0 = Pine.currentArtThread0();
        if (hookRecord.isStatic) {
            object = null;
            i = 0;
            i2 = 0;
        } else {
            object = Pine.getObject(jCurrentArtThread0, jArr[0]);
            i = 1;
            i2 = 1;
        }
        int i4 = hookRecord.paramNumber;
        if (i4 > 0) {
            objArr = new Object[i4];
            int i5 = 0;
            int i6 = 0;
            while (i5 < hookRecord.paramNumber) {
                Class<?> cls = hookRecord.paramTypes[i5];
                if (cls == Double.TYPE) {
                    if (i6 < dArr.length) {
                        i3 = i6 + 1;
                        object2 = Double.valueOf(dArr[i6]);
                    } else {
                        i3 = i6;
                        object2 = Double.valueOf(Double.longBitsToDouble(jArr2[i2]));
                    }
                } else if (cls == Float.TYPE) {
                    if (i6 < dArr.length) {
                        jDoubleToLongBits = Double.doubleToLongBits(dArr[i6]);
                        i6++;
                    } else {
                        jDoubleToLongBits = jArr2[i2];
                    }
                    i3 = i6;
                    object2 = Float.valueOf(Float.intBitsToFloat((int) (jDoubleToLongBits & INT_BITS)));
                } else {
                    if (i < jArr.length) {
                        j8 = jArr[i];
                        i++;
                    } else {
                        j8 = jArr2[i2];
                    }
                    if (!cls.isPrimitive()) {
                        i3 = i6;
                        object2 = Pine.getObject(jCurrentArtThread0, j8 & INT_BITS);
                    } else if (cls == Integer.TYPE) {
                        i3 = i6;
                        object2 = Integer.valueOf((int) (j8 & INT_BITS));
                    } else if (cls == Long.TYPE) {
                        i3 = i6;
                        object2 = Long.valueOf(j8);
                    } else if (cls == Boolean.TYPE) {
                        i3 = i6;
                        object2 = Boolean.valueOf((j8 & INT_BITS) != 0);
                    } else if (cls == Short.TYPE) {
                        i3 = i6;
                        object2 = Short.valueOf((short) (j8 & 65535));
                    } else if (cls == Character.TYPE) {
                        i3 = i6;
                        object2 = Character.valueOf((char) (j8 & 65535));
                    } else {
                        if (cls != Byte.TYPE) {
                            throw new AssertionError("Unknown primitive type: " + cls);
                        }
                        i3 = i6;
                        object2 = Byte.valueOf((byte) (j8 & BYTE_BITS));
                    }
                }
                objArr[i5] = object2;
                i2++;
                i5++;
                i6 = i3;
            }
        } else {
            objArr = Pine.EMPTY_OBJECT_ARRAY;
        }
        return Pine.handleCall(hookRecord, object, objArr);
    }

    public static int intBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Integer) handleBridge(j, j2, j3, j4, j5, j6, j7)).intValue();
    }

    public static long longBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Long) handleBridge(j, j2, j3, j4, j5, j6, j7)).longValue();
    }

    public static Object objectBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return handleBridge(j, j2, j3, j4, j5, j6, j7);
    }

    public static short shortBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return ((Short) handleBridge(j, j2, j3, j4, j5, j6, j7)).shortValue();
    }

    public static void voidBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        handleBridge(j, j2, j3, j4, j5, j6, j7);
    }
}
