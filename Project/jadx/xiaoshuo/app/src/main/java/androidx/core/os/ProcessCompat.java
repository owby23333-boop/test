package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {

    @RequiresApi(16)
    public static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        private Api16Impl() {
        }

        @SuppressLint({"PrivateApi"})
        public static boolean isApplicationUid(int uid) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserIdIsAppMethod;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(uid));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(17)
    public static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        private Api17Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        public static boolean isApplicationUid(int uid) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserHandleIsAppMethod;
                if (method != null && ((Boolean) method.invoke(null, Integer.valueOf(uid))) == null) {
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isApplicationUid(int uid) {
            return Process.isApplicationUid(uid);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int uid) {
        return Api24Impl.isApplicationUid(uid);
    }
}
