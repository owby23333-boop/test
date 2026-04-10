package d1;

import android.database.ContentObserver;

/* JADX INFO: compiled from: C0042c.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends ContentObserver {
    public String a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f20769c;

    public b(c cVar, int i2, String str) {
        super(null);
        this.f20769c = cVar;
        this.b = i2;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        c cVar = this.f20769c;
        if (cVar != null) {
            cVar.a(this.b, this.a);
        } else {
            v.c.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
