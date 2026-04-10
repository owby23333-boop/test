package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.component.utils.wp;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class pbln {
    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                wp.z(e);
            }
        }
    }
}
