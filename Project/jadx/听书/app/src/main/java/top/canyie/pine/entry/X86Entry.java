package top.canyie.pine.entry;

import top.canyie.pine.Pine;
import top.canyie.pine.utils.Primitives;

/* JADX INFO: loaded from: classes5.dex */
public final class X86Entry {
    private static final int[] EMPTY_INT_ARRAY = new int[0];

    private X86Entry() {
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

    private static int[] getArgsAsInts(Pine.HookRecord hookRecord, int i, int i2) {
        int i3 = !hookRecord.isStatic ? 1 : 0;
        Class<?>[] clsArr = hookRecord.paramTypes;
        int length = clsArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            Class<?> cls = clsArr[i4];
            i3 += (cls == Long.TYPE || cls == Double.TYPE) ? 2 : 1;
        }
        int[] iArr = i3 != 0 ? new int[i3] : EMPTY_INT_ARRAY;
        Pine.getArgsX86(i, iArr, i2);
        return iArr;
    }

    private static Object handleBridge(int i, int i2, int i3) {
        Object object;
        int i4;
        Object[] objArr;
        Object object2;
        Pine.log("handleBridge: artMethod=%#x extras=%#x ebx=%#x", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        Pine.HookRecord hookRecord = Pine.getHookRecord(i);
        int[] argsAsInts = getArgsAsInts(hookRecord, i2, i3);
        long jCurrentArtThread0 = Pine.currentArtThread0();
        if (hookRecord.isStatic) {
            object = null;
            i4 = 0;
        } else {
            object = Pine.getObject(jCurrentArtThread0, argsAsInts[0]);
            i4 = 1;
        }
        int i5 = hookRecord.paramNumber;
        if (i5 > 0) {
            objArr = new Object[i5];
            for (int i6 = 0; i6 < hookRecord.paramNumber; i6++) {
                Class<?> cls = hookRecord.paramTypes[i6];
                if (!cls.isPrimitive()) {
                    object2 = Pine.getObject(jCurrentArtThread0, argsAsInts[i4]);
                } else if (cls == Integer.TYPE) {
                    object2 = Integer.valueOf(argsAsInts[i4]);
                } else if (cls == Long.TYPE) {
                    int i7 = i4 + 1;
                    object2 = Long.valueOf(Primitives.ints2Long(argsAsInts[i4], argsAsInts[i7]));
                    i4 = i7;
                } else if (cls == Double.TYPE) {
                    int i8 = i4 + 1;
                    object2 = Double.valueOf(Primitives.ints2Double(argsAsInts[i4], argsAsInts[i8]));
                    i4 = i8;
                } else if (cls == Float.TYPE) {
                    object2 = Float.valueOf(Float.intBitsToFloat(argsAsInts[i4]));
                } else if (cls == Boolean.TYPE) {
                    object2 = Boolean.valueOf(argsAsInts[i4] != 0);
                } else if (cls == Short.TYPE) {
                    object2 = Short.valueOf((short) argsAsInts[i4]);
                } else if (cls == Character.TYPE) {
                    object2 = Character.valueOf((char) argsAsInts[i4]);
                } else {
                    if (cls != Byte.TYPE) {
                        throw new AssertionError("Unknown primitive type: " + cls);
                    }
                    object2 = Byte.valueOf((byte) argsAsInts[i4]);
                }
                objArr[i6] = object2;
                i4++;
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
