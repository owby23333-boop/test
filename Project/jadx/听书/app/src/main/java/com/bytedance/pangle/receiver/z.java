package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.fo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private static final dl z;

    private interface dl {
        boolean z(Context context) throws Throwable;
    }

    static {
        if (Build.VERSION.SDK_INT < 28) {
            z = new gc();
        } else {
            z = new g();
        }
    }

    public static void z(Application application) {
        if (application != null) {
            try {
                if (fo.tb()) {
                    z.z(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static class g extends gc {
        @Override // com.bytedance.pangle.receiver.z.gc, com.bytedance.pangle.receiver.z.C0111z, com.bytedance.pangle.receiver.z.dl
        public boolean z(Context context) throws Throwable {
            return false;
        }

        private g() {
            super();
        }
    }

    private static class gc extends C0111z {
        private gc() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.z.C0111z, com.bytedance.pangle.receiver.z.dl
        public boolean z(Context context) throws Throwable {
            Object objZ = z(context, "mWhiteListMap");
            if (!(objZ instanceof Map)) {
                return false;
            }
            Map map = (Map) objZ;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    private static class a extends C0111z {
        private a() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.z.C0111z, com.bytedance.pangle.receiver.z.dl
        public boolean z(Context context) throws Throwable {
            Object objZ = z(context, "mWhiteList");
            if (!(objZ instanceof List)) {
                return false;
            }
            ((List) objZ).add(context.getPackageName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.receiver.z$z, reason: collision with other inner class name */
    private static class C0111z implements dl {
        private C0111z() {
        }

        @Override // com.bytedance.pangle.receiver.z.dl
        public boolean z(Context context) throws Throwable {
            Object objG = g(context);
            Object objZ = z(objG, "mWhiteList");
            if (!(objZ instanceof String[])) {
                if (objG == null) {
                    return false;
                }
                FieldUtils.writeField(objG, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objZ);
            FieldUtils.writeField(objG, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        Object z(Context context, String str) {
            return z(g(context), str);
        }

        private Object z(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        private Object g(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
