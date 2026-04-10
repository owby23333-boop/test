package i0.a.b.d.a;

import android.database.ContentObserver;

/* JADX INFO: compiled from: IdentifierIdObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends ContentObserver {
    private String a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f20864c;

    public c(b bVar, int i2, String str) {
        super(null);
        this.f20864c = bVar;
        this.b = i2;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        b bVar = this.f20864c;
        if (bVar != null) {
            bVar.a(this.b, this.a);
        }
    }
}
