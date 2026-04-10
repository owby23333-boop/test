package com.ss.android.downloadlib.z.z;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.z.z.dl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2023a = "";
    private static volatile z e = null;
    private static String gc = "";
    private static String m = "";
    private Context kb;
    public dl z;
    private boolean gz = true;
    private boolean fo = false;
    private volatile boolean uy = false;
    private final List<Pair<g, a>> wp = new ArrayList();
    public final List<Object> g = new ArrayList();
    private final ServiceConnection i = new ServiceConnection() { // from class: com.ss.android.downloadlib.z.z.z.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (z.this.dl) {
                z.this.z(false);
                z.this.z = dl.z.z(iBinder);
                z.this.dl();
                Iterator<Object> it = z.this.g.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (z.this.dl) {
                z.this.z(false);
                z.this.z = null;
                Iterator<Object> it = z.this.g.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    private String v = "";
    public final Object dl = new Object();

    private z() {
    }

    public static z z() {
        if (e == null) {
            synchronized (z.class) {
                if (e == null) {
                    e = new z();
                }
            }
        }
        return e;
    }

    public boolean z(Context context, boolean z) {
        if (TextUtils.isEmpty(f2023a)) {
            JSONObject jSONObjectFo = wp.fo();
            String strOptString = jSONObjectFo.optString("s");
            f2023a = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("q"), strOptString);
            gc = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("u"), strOptString);
            m = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("w"), strOptString);
        }
        this.fo = z;
        if (context == null) {
            return true;
        }
        this.kb = context.getApplicationContext();
        if (TextUtils.isEmpty(m)) {
            m = this.kb.getPackageName();
        }
        if (this.z != null || a()) {
            return true;
        }
        return this.kb.bindService(z(context), this.i, 33);
    }

    public void g() {
        if (this.z != null) {
            this.kb.unbindService(this.i);
            this.z = null;
        }
        this.g.clear();
        this.wp.clear();
    }

    public Intent z(Context context) {
        Intent intent = new Intent();
        intent.setAction(f2023a);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (gc.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void z(g gVar, a aVar) {
        synchronized (this.dl) {
            gVar.gc = m;
            if (TextUtils.isEmpty(gVar.m)) {
                gVar.m = this.v;
            }
            dl dlVar = this.z;
            if (dlVar != null) {
                try {
                    dlVar.z(gVar, aVar);
                } catch (RemoteException e2) {
                    com.bytedance.sdk.component.utils.wp.z(e2);
                }
            } else if (a() || z(this.kb, this.fo)) {
                this.wp.add(Pair.create(gVar, aVar));
            }
        }
    }

    public void dl() {
        for (Pair<g, a> pair : this.wp) {
            try {
                this.z.z((g) pair.first, (a) pair.second);
            } catch (RemoteException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
        }
        this.wp.clear();
    }

    public boolean a() {
        return this.uy;
    }

    public void z(boolean z) {
        this.uy = z;
    }
}
