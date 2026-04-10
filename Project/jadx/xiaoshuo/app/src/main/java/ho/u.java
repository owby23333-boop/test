package ho;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import ho.n;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ho.a f21130b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21129a = false;
    public final a c = new a();
    public final b d = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            ho.a aVar;
            if ("miui.intent.action.MIRROR_STATE_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("connect_state", false);
                if (booleanExtra) {
                    u uVar = u.this;
                    if (!uVar.f21129a && (aVar = uVar.f21130b) != null) {
                        uVar.a(context, aVar);
                    }
                }
                u.this.f21129a = booleanExtra;
            }
        }
    }

    public class b extends o {
        public b() {
        }
    }

    @Override // ho.r
    public final int a(Context context) {
        n.b bVar = n.b.APP_INTENT;
        Bundle bundle = new Bundle();
        bundle.putString("relay_package_name", context.getPackageName());
        bundle.putInt("relay_data_type", n.a(bVar));
        bundle.putInt("relay_app_pid", Process.myPid());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("bundle", bundle);
        try {
            q.a(context.getContentResolver(), "cancelRelayData", bundle2);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    public final int b(Context context, n.b bVar, Bundle bundle) {
        if (this.f21130b == null) {
            return -1;
        }
        bundle.putString("relay_package_name", context.getPackageName());
        bundle.putInt("relay_data_type", n.a(bVar));
        bundle.putInt("relay_app_pid", Process.myPid());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("bundle", bundle);
        try {
            q.a(context.getContentResolver(), "syncRelayData", bundle2);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    public final int a(Context context, n.b bVar, Bundle bundle) {
        bundle.putString("relay_package_name", context.getPackageName());
        bundle.putInt("relay_data_type", n.a(bVar));
        bundle.putInt("relay_app_pid", Process.myPid());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("bundle", bundle);
        try {
            q.a(context.getContentResolver(), "showRelayData", bundle2);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // ho.r
    /* JADX INFO: renamed from: a */
    public final void mo1092a(Context context) {
        this.f21130b = null;
        try {
            Bundle bundle = new Bundle();
            b bVar = this.d;
            bVar.getClass();
            bundle.putBinder("relayCallback", bVar);
            q.a(context.getContentResolver(), "unRegisterRelayCallback", bundle);
        } catch (Exception e) {
            e.toString();
        }
        context.unregisterReceiver(this.c);
    }

    @Override // ho.r
    public final void a(Context context, ho.a aVar) {
        this.f21130b = aVar;
        try {
            Bundle bundle = new Bundle();
            b bVar = this.d;
            bVar.getClass();
            bundle.putBinder("relayCallback", bVar);
            q.a(context.getContentResolver(), "registerRelayCallback", bundle);
        } catch (Exception e) {
            e.toString();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("miui.intent.action.MIRROR_STATE_CHANGED");
        context.registerReceiver(this.c, intentFilter, "android.permission.INJECT_EVENTS", null);
    }
}
