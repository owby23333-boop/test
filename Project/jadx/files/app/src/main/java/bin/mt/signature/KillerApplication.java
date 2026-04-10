package bin.mt.signature;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes5.dex */
public class KillerApplication extends Application {
    public static final String URL = "https://github.com/L-JINBIN/ApkSignatureKillerEx";

    public class a {
        private boolean override;
    }

    public final class b {
        private transient int accessFlags;
        private transient int classFlags;
        private transient ClassLoader classLoader;
        private transient int classSize;
        private transient int clinitThreadId;
        private transient Class componentType;
        private transient short copiedMethodsOffset;
        private transient Object dexCache;
        private transient int dexClassDefIndex;
        private volatile transient int dexTypeIndex;
        private transient Object extData;
        private transient long iFields;
        private transient Object[] ifTable;
        private transient long methods;
        private transient String name;
        private transient int numReferenceInstanceFields;
        private transient int numReferenceStaticFields;
        private transient int objectSize;
        private transient int objectSizeAllocFastPath;
        private transient int primitiveType;
        private transient int referenceInstanceOffsets;
        private transient long sFields;
        private transient int status;
        private transient Class superClass;
        private transient short virtualMethodsOffset;
        private transient Object vtable;
    }

    public final class c extends a {
        private int accessFlags;
        private long artMethod;
        private b declaringClass;
        private b declaringClassOfOverriddenMethod;
        private Object[] parameters;
    }

    public final class d {
        private final Member member = null;
        private final f handle = null;
    }

    public final class e {
        private e(Object... objArr) {
            throw new IllegalStateException("Failed to new a instance");
        }

        private static Object invoke(Object... objArr) {
            throw new IllegalStateException("Failed to invoke the method");
        }
    }

    public class f {
        private f cachedSpreadInvoker;
        private MethodType nominalType;
        private final MethodType type = null;
        protected final int handleKind = 0;
        protected final long artFieldOrMethod = 0;
    }

    public final class g extends f {
        private final MethodHandleInfo info = null;
    }

    public final class h {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static int f613s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static int f614t;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f615i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f616j;

        private static void a() {
        }

        private static void b() {
        }
    }

    public final /* synthetic */ class i {
    }

    public final class j {
        public static final Unsafe a;
        public static final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final HashSet f620f = new HashSet();

        static {
            try {
                Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
                a = unsafe;
                b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
                unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
                long jObjectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
                unsafe.objectFieldOffset(g.class.getDeclaredField("info"));
                long jObjectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
                f617c = jObjectFieldOffset2;
                long jObjectFieldOffset3 = unsafe.objectFieldOffset(b.class.getDeclaredField("iFields"));
                unsafe.objectFieldOffset(b.class.getDeclaredField("sFields"));
                unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
                Method declaredMethod = h.class.getDeclaredMethod("a", null);
                Method declaredMethod2 = h.class.getDeclaredMethod("b", null);
                declaredMethod.setAccessible(true);
                declaredMethod2.setAccessible(true);
                MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
                MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
                long j2 = unsafe.getLong(methodHandleUnreflect, jObjectFieldOffset);
                long j3 = unsafe.getLong(methodHandleUnreflect2, jObjectFieldOffset);
                long j4 = unsafe.getLong(h.class, jObjectFieldOffset2);
                long j5 = j3 - j2;
                f618d = j5;
                f619e = (j2 - j4) - j5;
                Field declaredField = h.class.getDeclaredField("i");
                Field declaredField2 = h.class.getDeclaredField("j");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
                unsafe.getLong(methodHandleUnreflectGetter, jObjectFieldOffset);
                unsafe.getLong(methodHandleUnreflectGetter2, jObjectFieldOffset);
                unsafe.getLong(h.class, jObjectFieldOffset3);
            } catch (ReflectiveOperationException e2) {
                Log.e("HiddenApiBypass", "Initialize error", e2);
                throw new ExceptionInInitializerError(e2);
            }
        }

        public static Object a(Class cls, Object obj, String str, Object... objArr) throws NoSuchMethodException {
            int i2;
            if (obj != null && !cls.isInstance(obj)) {
                throw new IllegalArgumentException("this object is not an instance of the given class");
            }
            Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
            declaredMethod.setAccessible(true);
            Unsafe unsafe = a;
            long j2 = unsafe.getLong(cls, f617c);
            if (j2 == 0) {
                throw new NoSuchMethodException("Cannot find matching method");
            }
            int i3 = unsafe.getInt(j2);
            for (int i4 = 0; i4 < i3; i4++) {
                a.putLong(declaredMethod, b, (((long) i4) * f618d) + j2 + f619e);
                if (str.equals(declaredMethod.getName())) {
                    Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                    if (parameterTypes.length == objArr.length) {
                        while (i2 < parameterTypes.length) {
                            if (parameterTypes[i2].isPrimitive()) {
                                Class<?> cls2 = parameterTypes[i2];
                                i2 = ((cls2 != Integer.TYPE || (objArr[i2] instanceof Integer)) && (cls2 != Byte.TYPE || (objArr[i2] instanceof Byte)) && ((cls2 != Character.TYPE || (objArr[i2] instanceof Character)) && ((cls2 != Boolean.TYPE || (objArr[i2] instanceof Boolean)) && ((cls2 != Double.TYPE || (objArr[i2] instanceof Double)) && ((cls2 != Float.TYPE || (objArr[i2] instanceof Float)) && ((cls2 != Long.TYPE || (objArr[i2] instanceof Long)) && (cls2 != Short.TYPE || (objArr[i2] instanceof Short)))))))) ? i2 + 1 : 0;
                            } else {
                                Object obj2 = objArr[i2];
                                if (obj2 == null || parameterTypes[i2].isInstance(obj2)) {
                                }
                            }
                        }
                        return declaredMethod.invoke(obj, objArr);
                    }
                    continue;
                }
            }
            throw new NoSuchMethodException("Cannot find matching method");
        }

        public static boolean b(String... strArr) {
            try {
                a(VMRuntime.class, a(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
                return true;
            } catch (Throwable th) {
                Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
                return false;
            }
        }
    }

    public final /* synthetic */ class k {
    }

    public final class l implements Parcelable.Creator {
        public final /* synthetic */ Parcelable.Creator a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Signature f621c;

        public l(Parcelable.Creator creator, String str, Signature signature) {
            this.a = creator;
            this.b = str;
            this.f621c = signature;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Signature[] apkContentsSigners;
            PackageInfo packageInfo = (PackageInfo) this.a.createFromParcel(parcel);
            if (packageInfo.packageName.equals(this.b)) {
                Signature[] signatureArr = packageInfo.signatures;
                Signature signature = this.f621c;
                if (signatureArr != null && signatureArr.length > 0) {
                    signatureArr[0] = signature;
                }
                if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                    apkContentsSigners[0] = signature;
                }
            }
            return packageInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return (PackageInfo[]) this.a.newArray(i2);
        }
    }

    static {
        killPM("com.fatcatfat.io", "MIIDazCCAlOgAwIBAgIEP7h2uzANBgkqhkiG9w0BAQsFADBmMQ8wDQYDVQQGEwZmYXRjYXQxDzAN\nBgNVBAgTBmZhdGNhdDEPMA0GA1UEBxMGZmF0Y2F0MQ8wDQYDVQQKEwZmYXRjYXQxDzANBgNVBAsT\nBmZhdGNhdDEPMA0GA1UEAxMGZmF0Y2F0MB4XDTIwMDYyNjA2NDA1NVoXDTQ1MDYyMDA2NDA1NVow\nZjEPMA0GA1UEBhMGZmF0Y2F0MQ8wDQYDVQQIEwZmYXRjYXQxDzANBgNVBAcTBmZhdGNhdDEPMA0G\nA1UEChMGZmF0Y2F0MQ8wDQYDVQQLEwZmYXRjYXQxDzANBgNVBAMTBmZhdGNhdDCCASIwDQYJKoZI\nhvcNAQEBBQADggEPADCCAQoCggEBAIxJnctkymjpvyP+oTSkcoVycdJfMw35REXJ6azWuRU8kk2Y\n3vtYkUWEe0Hqild16+C/eGvLE6m/Gt4+q55o3nDr7py9u6EFaaac1oaxJYo3G2XnYNUdd55xj523\nMjwsSnAibsV9m8Wbk61bRKAnYA+jMys6aKxpB2JTvrybMbcwhR+/74ft3dkZ/JoHWnvT8VXcZBbD\n4n8wXIJqkuGSOoeihDUFZ9uk6LGhM/+MpvIwt9Fd0rBizkGhvnRZIqFeyeOfdmvuq6edpNfhHB0t\nLC2PELwVVZDmChU4jUVtow6z66VdnSNt2nIJqROPQgW5RbkBBaP7G7BwRmLhZJ6Y/OECAwEAAaMh\nMB8wHQYDVR0OBBYEFIGV9IuKmi9YcKDeQmH1+q/2/wh3MA0GCSqGSIb3DQEBCwUAA4IBAQAHe1TJ\nRBxl48bBOEObziHUBb+CmafhjV3N59yuTF0brayR2AwlcZICCY+moy1D5f5XFJAftsuE5b6GkKDx\nyJ3jLK7OabKVZ/X2bWNoTJ2IeSaI/cVhDCTz+RE0NbS4gdhRwJ5U81+uSE+TpYKl1a/U96N96aOO\nkTA5AGcNu8G90MRWLvzah+6IpQ7sfjKTUH8MyxFqV/hqiQZ6zeIKQlfs4lvWZl9ZlSMxcqp1nzp6\n4YPBSNhoaKVFdiOJi0J+t9uwwqxQ0KrcVcSKc5/uoGqQrkw23Uq7mJPBlD/WDdTO6TKWSk/eodDE\nrhj63OZwkU3MOc7ukGf7qDSwv5z8CsYq\n");
        killOpen("com.fatcatfat.io", "", "", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field a(java.lang.Class r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /*
            r0 = 1
            java.lang.reflect.Field r1 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L9
            r1.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L9
            return r1
        L9:
            r1 = move-exception
        La:
            java.lang.Class r3 = r3.getSuperclass()
            if (r3 == 0) goto L22
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L22
            java.lang.reflect.Field r2 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L20
            r2.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L20
            return r2
        L20:
            goto La
        L22:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bin.mt.signature.KillerApplication.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    public static boolean b(String str, String str2) {
        if (str2.startsWith("/") && str2.endsWith(com.anythink.china.common.a.a.f6395g)) {
            String[] strArrSplit = str2.substring(1).split("/", 6);
            int length = strArrSplit.length;
            if (length == 4 || length == 5) {
                if (strArrSplit[0].equals("data") && strArrSplit[1].equals("app") && strArrSplit[length - 1].equals("base.apk")) {
                    return strArrSplit[length - 2].startsWith(str);
                }
                if (strArrSplit[0].equals("mnt") && strArrSplit[1].equals("asec") && strArrSplit[length - 1].equals("pkg.apk")) {
                    return strArrSplit[length - 2].startsWith(str);
                }
            } else if (length == 3) {
                if (strArrSplit[0].equals("data") && strArrSplit[1].equals("app")) {
                    return strArrSplit[2].startsWith(str);
                }
            } else if (length == 6 && strArrSplit[0].equals("mnt") && strArrSplit[1].equals("expand") && strArrSplit[3].equals("app") && strArrSplit[5].equals("base.apk")) {
                return strArrSplit[4].endsWith(str);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void killOpen(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bin.mt.signature.KillerApplication.killOpen(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static void killPM(String str, String str2) {
        try {
            a(PackageInfo.class, "CREATOR").set(null, new l(PackageInfo.CREATOR, str, new Signature(Base64.decode(str2, 0))));
            if (Build.VERSION.SDK_INT >= 28) {
                HashSet hashSet = j.f620f;
                hashSet.addAll(Arrays.asList("Landroid/os/Parcel;", "Landroid/content/pm", "Landroid/app"));
                String[] strArr = new String[hashSet.size()];
                hashSet.toArray(strArr);
                j.b(strArr);
            }
            try {
                Object obj = a(PackageManager.class, "sPackageInfoCache").get(null);
                obj.getClass().getMethod("clear", null).invoke(obj, null);
            } catch (Throwable unused) {
            }
            try {
                ((Map) a(Parcel.class, "mCreators").get(null)).clear();
            } catch (Throwable unused2) {
            }
            try {
                ((Map) a(Parcel.class, "sPairedCreators").get(null)).clear();
            } catch (Throwable unused3) {
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
