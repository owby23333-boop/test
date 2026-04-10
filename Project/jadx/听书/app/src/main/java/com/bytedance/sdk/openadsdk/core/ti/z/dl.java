package com.bytedance.sdk.openadsdk.core.ti.z;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    public interface z {
        void a(String str, String str2);

        void dl(String str, String str2);

        void g(String str, String str2);

        void g(String str, String str2, Throwable th);

        void gc(String str, String str2);

        void z();

        void z(String str, String str2);

        void z(String str, String str2, Throwable th);

        void z(String str, Throwable th);
    }

    public static void z(Object obj) {
        try {
            if (!g(obj)) {
                if (obj != null) {
                    z(null, obj, a(obj), false);
                    return;
                }
                return;
            }
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            Object objApply = function.apply(sparseArray);
            if (objApply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                z(function, objApply, (String) function.apply(sparseArray2), true);
            }
        } catch (Throwable th) {
            wp.g("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    private static String a(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        return ttc == null ? "" : ttc.value();
    }

    public static boolean g(Object obj) {
        Boolean bool;
        if (obj == null || !(obj instanceof Function)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            SparseArray sparseArray2 = (SparseArray) ((Function) obj).apply(sparseArray);
            if (sparseArray2 != null && (bool = (Boolean) sparseArray2.get(-99999978)) != null) {
                if (bool.booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            wp.z(e);
        }
        return false;
    }

    private static void z(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z2) {
        if (obj == null) {
            return;
        }
        str.hashCode();
        if (str.equals("log")) {
            z(function, obj, z2);
        } else if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            g(function, obj, z2);
        }
        wp.g("HookObject", "register object  " + obj + " successed~ ");
    }

    private static void z(Function<SparseArray<Object>, Object> function, Object obj, boolean z2) {
        try {
            if (z2) {
                LogAdapter.z((z) new g(function), true);
            } else if (obj instanceof TTILog) {
                LogAdapter.z((z) new g(obj), true);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private static void g(Function<SparseArray<Object>, Object> function, Object obj, boolean z2) {
        if (wp.dl()) {
            com.bytedance.sdk.openadsdk.e.dl dlVar = new com.bytedance.sdk.openadsdk.e.dl();
            com.bytedance.sdk.openadsdk.e.dl.z = dlVar;
            try {
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    if (z2) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, -8999909);
                        sparseArray.put(-99999985, Integer.class);
                        sparseArray.put(-8999925, method);
                        Integer num = (Integer) function.apply(sparseArray);
                        if (num != null) {
                            method.setAccessible(true);
                            dlVar.z(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            dlVar.z(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
            }
            dlVar.z(obj);
        }
    }

    public static class g implements z {
        Function g;
        Object z;

        public g(Object obj) {
            this.z = obj;
        }

        public g(Function<SparseArray<Object>, Object> function) {
            this.g = function;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void z(String str, String str2) {
            if (this.g != null) {
                z(-8999900, str, str2, null);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void g(String str, String str2) {
            if (this.g != null) {
                z(-8999901, str, str2, null);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void dl(String str, String str2) {
            if (this.g != null) {
                z(-8999902, str, str2, null);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void a(String str, String str2) {
            if (this.g != null) {
                z(-8999903, str, str2, null);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).w(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void z(String str, String str2, Throwable th) {
            if (this.g != null) {
                z(-8999903, str, str2, th);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).w(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void gc(String str, String str2) {
            if (this.g != null) {
                z(-8999905, str, str2, null);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void g(String str, String str2, Throwable th) {
            if (this.g != null) {
                z(-8999905, str, str2, th);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void z(String str, Throwable th) {
            if (this.g != null) {
                z(-8999905, str, null, th);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ti.z.dl.z
        public void z() {
            if (this.g != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.g.apply(sparseArray);
            }
            Object obj = this.z;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void z(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.g.apply(sparseArray);
        }
    }

    public static void dl(Object obj) {
        String strA = "";
        try {
            if (g(obj)) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                strA = (String) ((Function) obj).apply(sparseArray);
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    strA = a(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        strA.hashCode();
        if (strA.equals(TKDownloadReason.KSAD_TK_NET)) {
            com.bytedance.sdk.openadsdk.e.dl.z = null;
        }
    }

    public static com.bytedance.sdk.openadsdk.e.g z(String str) {
        str.hashCode();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            return com.bytedance.sdk.openadsdk.e.dl.z;
        }
        return null;
    }
}
