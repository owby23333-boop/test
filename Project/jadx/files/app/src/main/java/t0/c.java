package t0;

import com.sntech.stat.newstat.oaid.Cdo;

/* JADX INFO: compiled from: MsaManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements Cdo {
    public final /* synthetic */ long a;
    public final /* synthetic */ e b;

    public c(e eVar, long j2) {
        this.b = eVar;
        this.a = j2;
    }

    public void a(Cdo.InterfaceC0508do interfaceC0508do) {
        if (interfaceC0508do != null && interfaceC0508do.isSupported()) {
            this.b.a = interfaceC0508do.getOAID();
            this.b.b = interfaceC0508do.getVAID();
            this.b.f21709c = interfaceC0508do.getAAID();
            this.b.f21712f = interfaceC0508do.isSupported();
        }
        this.b.f21710d = System.currentTimeMillis() - this.a;
        boolean z2 = com.sntech.stat.Cdo.f125do;
    }
}
