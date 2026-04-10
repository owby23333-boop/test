package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f2542a;
    private Object dl;
    private Class g;
    private final Context z;

    public v1(Context context) {
        this.z = context;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "51c5bf", new byte[]{39, 60, Ascii.GS, 15, 92, 127, 50, 2, Base64.padSymbol, 108, 32, 125, Ascii.EM, 69, 19, 120, 59, 0, 62, 43, 13, 55, 32, 83, 82, 103, Utf8.REPLACEMENT_BYTE, Ascii.DC4, 55, 119, 13, 62, 0, 77}));
            this.g = cls;
            this.dl = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.f2542a = this.g.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "551efe", new byte[]{35, 50, 86, 62, 120, 91, Ascii.DC2}), Context.class);
        } catch (Exception unused2) {
        }
    }

    public final String z() {
        Context context = this.z;
        Method method = this.f2542a;
        Object obj = this.dl;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
