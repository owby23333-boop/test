package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Ascii;
import ms.bz.bd.c.Pgl.pblb;

/* JADX INFO: loaded from: classes9.dex */
final class s extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object e(int i, long j, String str, Object obj) throws Throwable {
        Context contextBf = pgla.e().bf();
        String[] strArrSplit = str.split((String) pblk.a(16777217, 0, 0L, "3cc71c", new byte[]{Ascii.RS, 125}));
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        SharedPreferences.Editor editorEdit = contextBf.getSharedPreferences(str2, 0).edit();
        editorEdit.putString(str3, (String) obj);
        editorEdit.commit();
        return null;
    }
}
