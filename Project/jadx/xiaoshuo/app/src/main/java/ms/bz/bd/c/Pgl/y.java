package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class y extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Throwable thBf = m1.e().bf();
        if (thBf == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thBf.getStackTrace();
        if (stackTrace.length < 4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < 4; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.getClassName())) {
                Class<?> cls = Class.forName(stackTrace[i2].getClassName());
                m1 m1VarE = m1.e();
                String methodName = stackTrace[i2].getMethodName();
                m1VarE.getClass();
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(methodName)) {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && method.getName().equals(methodName)) {
                            arrayList2.add(method);
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }
}
