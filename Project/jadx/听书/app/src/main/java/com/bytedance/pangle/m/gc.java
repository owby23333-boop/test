package com.bytedance.pangle.m;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.m.m;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements m.z {
    private static volatile Object g;
    private static volatile IBinder z;

    public interface z {
    }

    private static String[] z(String... strArr) {
        return strArr;
    }

    @Override // com.bytedance.pangle.m.m.z
    public boolean z(String str, int i) {
        z();
        g(str, i);
        boolean z2 = z("speed", str, i);
        dl(str, i);
        return z2;
    }

    private static void z() {
        PackageManager packageManager;
        Field fieldZ;
        IBinder iBinderAsBinder;
        if (z == null && (fieldZ = z((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objZ = z(fieldZ, packageManager);
            g = objZ;
            if ((objZ instanceof IInterface) && (iBinderAsBinder = ((IInterface) g).asBinder()) != null) {
                z = iBinderAsBinder;
            }
        }
    }

    private static boolean z(String str, String str2, int i) {
        String str3 = com.bytedance.pangle.gc.dl.gz(str2, i) + File.separator + com.bytedance.pangle.m.g.z(com.bytedance.pangle.gc.dl.gc(str2, i));
        for (int i2 = 1; i2 <= 3; i2++) {
            z(z(str), (z) null);
            if (com.bytedance.pangle.m.g.z(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void g(String str, int i) {
        if (str == null) {
            return;
        }
        String strG = com.bytedance.pangle.gc.dl.g(str, i);
        String strGc = com.bytedance.pangle.gc.dl.gc(str, i);
        z(strG, strGc);
        z(Zeus.getAppApplication().getPackageName(), strGc, com.bytedance.pangle.m.g.z());
    }

    private static void z(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT == 30) {
            g(str, str2, str3);
        } else if (Build.VERSION.SDK_INT == 29) {
            dl(str, str2, str3);
        }
    }

    private static void g(String str, String str2, String str3) {
        if (g == null || str == null || str2 == null || str3 == null) {
            return;
        }
        z(g, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void dl(String str, String str2, String str3) {
        if (g == null || str == null || str2 == null || str3 == null) {
            return;
        }
        z(g, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void dl(String str, int i) {
        if (str == null) {
            return;
        }
        g(com.bytedance.pangle.gc.dl.e(str, i), com.bytedance.pangle.gc.dl.m(str, i));
        g(com.bytedance.pangle.gc.dl.gc(str, i));
        g();
    }

    private static void g() {
        z(dl(), (z) null);
    }

    private static void z(String[] strArr, z zVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new g(zVar).writeToParcel(parcelObtain, 0);
        try {
            z.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
    }

    private static String[] z(String str) {
        return z("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static String[] dl() {
        return z("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void z(String str, String str2) {
        try {
            com.bytedance.pangle.util.gz.z(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void g(String str, String str2) {
        try {
            com.bytedance.pangle.util.e.z(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void g(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static class g extends ResultReceiver {
        private z z;

        public g(z zVar) {
            super(null);
            this.z = zVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public static Field z(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return z(obj.getClass(), str);
    }

    public static Field z(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object z(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object z(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
