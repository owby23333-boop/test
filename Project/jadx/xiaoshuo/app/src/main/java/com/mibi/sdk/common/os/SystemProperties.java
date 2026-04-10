package com.mibi.sdk.common.os;

import android.annotation.SuppressLint;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"PrivateApi"})
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;

    public SystemProperties() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String get(String str) {
        if (str.length() <= 31) {
            return getPropertyNative(str);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static boolean getBoolean(String str, boolean z) {
        if (str.length() <= 31) {
            return getBooleanPropertyNative(str, z);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static boolean getBooleanPropertyNative(String str, boolean z) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Boolean) cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls, str, Boolean.valueOf(z))).booleanValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return z;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return z;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return z;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return z;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return z;
        }
    }

    public static int getInt(String str, int i) {
        if (str.length() <= 31) {
            return getIntPropertyNative(str, i);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static int getIntPropertyNative(String str, int i) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i))).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return i;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return i;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return i;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return i;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return i;
        }
    }

    public static long getLong(String str, long j) {
        if (str.length() <= 31) {
            return getLongPropertyNative(str, j);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static long getLongPropertyNative(String str, long j) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Long) cls.getDeclaredMethod("getLong", String.class, Long.TYPE).invoke(cls, str, Long.valueOf(j))).longValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return j;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return j;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return j;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return j;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return j;
        }
    }

    public static String getPropertyNative(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static void set(String str, String str2) {
        if (str.length() > 31) {
            throw new IllegalArgumentException("key.length > 31");
        }
        if (str2 != null && str2.length() > 91) {
            throw new IllegalArgumentException("val.length > 91");
        }
        setPropertyNative(str, str2);
    }

    public static void setPropertyNative(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            cls.getDeclaredMethod("set", String.class, String.class).invoke(cls, str, str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static String get(String str, String str2) {
        if (str.length() <= 31) {
            String propertyNative = getPropertyNative(str);
            return (propertyNative == null || propertyNative.length() == 0) ? str2 : propertyNative;
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static void set(String str, int i) {
        set(str, Integer.toString(i));
    }

    public static void set(String str, long j) {
        set(str, Long.toString(j));
    }

    public static void set(String str, boolean z) {
        set(str, Boolean.toString(z));
    }
}
