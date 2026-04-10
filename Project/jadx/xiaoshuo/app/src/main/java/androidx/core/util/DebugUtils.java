package androidx.core.util;

import androidx.annotation.RestrictTo;
import com.yuewen.eq2;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object cls, StringBuilder out) {
        int iLastIndexOf;
        if (cls == null) {
            out.append(eq2.g);
            return;
        }
        String simpleName = cls.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = cls.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        out.append(simpleName);
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(cls)));
    }
}
