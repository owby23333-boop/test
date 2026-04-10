package ho;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import ho.n;
import ho.s;
import ho.t;

/* JADX INFO: loaded from: classes8.dex */
public final class p implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ho.a f21122b;
    public final a c = new a();
    public final b d = new b();

    public class a extends s.a {
        public a() {
        }
    }

    public class b implements t.c {
        public b() {
        }
    }

    @Override // ho.r
    public final int a(Context context) {
        n.b bVar = n.b.APP_INTENT;
        v vVarB = t.a().b();
        if (vVarB == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("relay_package_name", this.f21121a);
            bundle.putInt("relay_data_type", n.a(bVar));
            vVarB.a(bundle);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    public final int b(Context context, n.b bVar, Bundle bundle) {
        v vVarB = t.a().b();
        if (vVarB == null) {
            return -1;
        }
        try {
            bundle.putString("relay_package_name", this.f21121a);
            bundle.putInt("relay_data_type", n.a(bVar));
            vVarB.c(bundle);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    public final int a(Context context, n.b bVar, Bundle bundle) {
        v vVarB = t.a().b();
        if (vVarB == null) {
            return -1;
        }
        try {
            bundle.putString("relay_package_name", this.f21121a);
            bundle.putInt("relay_data_type", n.a(bVar));
            vVarB.b(bundle);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void mo1092a(Context context) {
        this.f21122b = null;
    }

    @Override // ho.r
    public final void a(Context context, ho.a aVar) {
        this.f21122b = aVar;
    }
}
