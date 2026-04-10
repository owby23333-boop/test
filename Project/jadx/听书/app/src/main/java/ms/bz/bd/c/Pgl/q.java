package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pbly;

/* JADX INFO: loaded from: classes4.dex */
final class q extends pbly.pgla {
    q() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object z(long j, String str, Object obj) throws Throwable {
        Context contextG = pblv.z().g();
        String[] strArrSplit = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a0c32", new byte[]{Ascii.RS, 127}));
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.api.plugin.g.g(contextG, str2, 0).edit();
        editorEdit.putString(str3, (String) obj);
        editorEdit.commit();
        return null;
    }
}
