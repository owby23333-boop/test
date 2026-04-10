package d1;

import android.content.Context;

/* JADX INFO: compiled from: C0039a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            android.content.Context r0 = r7.a
            android.content.ContentResolver r1 = r0.getContentResolver()
            r0 = 0
            if (r8 == 0) goto L2b
            r2 = 1
            if (r8 == r2) goto L19
            r2 = 2
            if (r8 == r2) goto L11
            r2 = r0
            goto L32
        L11:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            goto L20
        L19:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
        L20:
            r8.append(r2)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L2d
        L2b:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L2d:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r2 = r8
        L32:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L51
            boolean r9 = r8.moveToNext()
            if (r9 == 0) goto L4d
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)
            java.lang.String r9 = r8.getString(r9)
            r0 = r9
        L4d:
            r8.close()
            goto L58
        L51:
            java.lang.String r8 = "VMS_IDLG_SDK_DB"
            java.lang.String r9 = "return cursor is null,return"
            v.c.b(r8, r9)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a.a(int, java.lang.String):java.lang.String");
    }
}
