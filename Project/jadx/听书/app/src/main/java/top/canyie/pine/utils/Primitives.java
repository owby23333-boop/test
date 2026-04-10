package top.canyie.pine.utils;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import top.canyie.pine.Pine;

/* JADX INFO: loaded from: classes5.dex */
public final class Primitives {
    private static final String TAG = "Pine.Primitives";
    private static int baseOffsetOfObjectArray;
    private static Field classAccessFlagsField;
    private static Method getInt;
    private static Method putObject;
    private static Field shadowKlassField;
    private static Field superClassField;
    private static boolean triedGetShadowKlassField;
    private static Object unsafe;
    private static Class<?> unsafeClass;

    public static int bytes2Int(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static long currentArtThread() {
        Pine.ensureInitialized();
        return Pine.currentArtThread0();
    }

    private static void ensureUnsafeReady() {
        if (unsafe != null) {
            return;
        }
        try {
            unsafeClass = Class.forName("sun.misc.Unsafe");
            unsafe = getUnsafe();
        } catch (Exception e) {
            throw new RuntimeException("Unsafe API is unavailable", e);
        }
    }

    public static int evenUp(int i) {
        return (i & 1) == 1 ? i + 1 : i;
    }

    public static double floats2Double(float f, float f2) {
        return Double.longBitsToDouble(ints2Long(Float.floatToIntBits(f), Float.floatToIntBits(f2)));
    }

    public static long getAddress(Object obj) {
        if (obj == null) {
            return 0L;
        }
        long address = Pine.getAddress(currentArtThread(), obj);
        if (address != 0) {
            return address;
        }
        ensureUnsafeReady();
        Object[] objArr = {obj};
        try {
            if (baseOffsetOfObjectArray == 0) {
                Method declaredMethod = unsafeClass.getDeclaredMethod("arrayBaseOffset", Class.class);
                declaredMethod.setAccessible(true);
                baseOffsetOfObjectArray = ((Integer) declaredMethod.invoke(unsafe, Object[].class)).intValue();
                Method declaredMethod2 = unsafeClass.getDeclaredMethod("getInt", Object.class, Long.TYPE);
                getInt = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
            return ((Integer) getInt.invoke(unsafe, objArr, Integer.valueOf(baseOffsetOfObjectArray))).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int getFieldOffset(Field field) throws NoSuchMethodException {
        try {
            Field declaredField = Field.class.getDeclaredField(TypedValues.Cycle.S_WAVE_OFFSET);
            declaredField.setAccessible(true);
            return declaredField.getInt(field);
        } catch (Exception e) {
            try {
                Method declaredMethod = Field.class.getDeclaredMethod("getOffset", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(field, new Object[0])).intValue();
            } catch (Exception e2) {
                ensureUnsafeReady();
                Method declaredMethod2 = unsafeClass.getDeclaredMethod("objectFieldOffset", Field.class);
                declaredMethod2.setAccessible(true);
                return ((Integer) declaredMethod2.invoke(unsafe, field)).intValue();
            }
        }
    }

    private static Object getUnsafe() throws NoSuchFieldException {
        Field declaredField;
        try {
            Method declaredMethod = unsafeClass.getDeclaredMethod("getUnsafe", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e) {
            try {
                declaredField = unsafeClass.getDeclaredField("theUnsafe");
            } catch (NoSuchFieldException e2) {
                declaredField = unsafeClass.getDeclaredField("THE_ONE");
            }
            declaredField.setAccessible(true);
            return declaredField.get(null);
        }
    }

    public static byte[] int2Bytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static double ints2Double(int i, int i2) {
        return Double.longBitsToDouble(ints2Long(i, i2));
    }

    public static long ints2Long(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    public static void removeClassFinalFlag(Class<?> cls) {
        if (Modifier.isFinal(cls.getModifiers())) {
            if (classAccessFlagsField == null) {
                try {
                    Field declaredField = Class.class.getDeclaredField("accessFlags");
                    classAccessFlagsField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException("Class.accessFlags not found", e);
                }
            }
            try {
                Field field = classAccessFlagsField;
                field.setInt(cls, field.getInt(cls) & (-17));
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void setObjectClass(Object obj, Class<?> cls) {
        if (obj.getClass() == cls) {
            return;
        }
        if (!triedGetShadowKlassField) {
            triedGetShadowKlassField = true;
            try {
                Field declaredField = Object.class.getDeclaredField("shadow$_klass_");
                shadowKlassField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.w(TAG, "Object.shadow$_klass_ not found, use Unsafe.", e);
            }
        }
        try {
            Field field = shadowKlassField;
            if (field != null) {
                field.set(obj, cls);
                return;
            }
            ensureUnsafeReady();
            if (putObject == null) {
                Method declaredMethod = unsafeClass.getDeclaredMethod("putObject", Object.class, Long.TYPE, Object.class);
                putObject = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            putObject.invoke(unsafe, obj, 0L, cls);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void setSuperClass(Class<?> cls, Class<?> cls2) {
        if (cls.getSuperclass() == cls2) {
            return;
        }
        if (superClassField == null) {
            try {
                Field declaredField = Class.class.getDeclaredField("superClass");
                superClassField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException("Class.superClass not found", e);
            }
        }
        try {
            superClassField.set(cls, cls2);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }
}
