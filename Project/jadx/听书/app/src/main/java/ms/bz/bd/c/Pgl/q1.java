package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 {
    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7480c0", new byte[]{Ascii.GS, 106, 10, Ascii.SUB, 97});
    }

    public static String z(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
