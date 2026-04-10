package ho;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import ho.v;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class t {
    public static t f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f21126b;
    public c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21125a = false;
    public final a d = new a();
    public final b e = new b();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName componentName) {
            t.this.f21126b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName componentName) {
            t.this.f21126b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v c0801a;
            c cVar;
            t tVar = t.this;
            int i = v.a.f21133a;
            if (iBinder == null) {
                c0801a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.mirror.ISynergyService");
                c0801a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof v)) ? new v.a.C0801a(iBinder) : (v) iInterfaceQueryLocalInterface;
            }
            tVar.f21126b = c0801a;
            Objects.toString(t.this.f21126b);
            Objects.toString(t.this.c);
            t tVar2 = t.this;
            if (tVar2.f21126b == null || (cVar = tVar2.c) == null) {
                return;
            }
            p pVar = p.this;
            pVar.getClass();
            v vVarB = t.a().b();
            if (vVarB != null) {
                try {
                    vVarB.a(pVar.f21121a, pVar.c);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            t.this.f21126b = null;
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("miui.intent.action.MIRROR_STATE_CHANGED".equals(intent.getAction()) && intent.getBooleanExtra("connect_state", false)) {
                t tVar = t.this;
                if (tVar.f21125a && tVar.f21126b == null) {
                    tVar.a(context, tVar.c);
                }
            }
        }
    }

    public interface c {
    }

    public static t a() {
        t tVar;
        t tVar2 = f;
        if (tVar2 != null) {
            return tVar2;
        }
        synchronized (t.class) {
            tVar = new t();
            f = tVar;
        }
        return tVar;
    }

    public final v b() {
        if (this.f21125a) {
            return this.f21126b;
        }
        return null;
    }

    public final void a(Context context, c cVar) {
        ServiceInfo serviceInfo;
        ApplicationInfo applicationInfo;
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.mirror.ACTION_SYNERGY_SERVICE");
        intent.setPackage("com.xiaomi.mirror");
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 65536);
        if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null || (applicationInfo = serviceInfo.applicationInfo) == null || applicationInfo.uid != 1000) {
            return;
        }
        this.f21125a = context.bindService(intent, this.d, 1);
        this.c = cVar;
    }
}
