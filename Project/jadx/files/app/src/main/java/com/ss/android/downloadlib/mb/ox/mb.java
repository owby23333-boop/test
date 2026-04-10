package com.ss.android.downloadlib.mb.ox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.expressad.foundation.d.c;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.mb.ox.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f18032h = "";
    private static String hj = "";
    private static volatile mb ko = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f18033u = "";
    private Context jb;
    public b mb;
    private boolean ww = true;
    private boolean lz = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f18035x = false;
    private final List<Pair<ox, hj>> je = new ArrayList();
    public final List<InterfaceC0515mb> ox = new ArrayList();
    private final ServiceConnection nk = new ServiceConnection() { // from class: com.ss.android.downloadlib.mb.ox.mb.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (mb.this.b) {
                mb.this.mb(false);
                mb.this.mb = b.mb.mb(iBinder);
                mb.this.b();
                Iterator<InterfaceC0515mb> it = mb.this.ox.iterator();
                while (it.hasNext()) {
                    it.next().mb();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (mb.this.b) {
                mb.this.mb(false);
                mb.this.mb = null;
                Iterator<InterfaceC0515mb> it = mb.this.ox.iterator();
                while (it.hasNext()) {
                    it.next().ox();
                }
            }
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f18034o = "";
    public final Object b = new Object();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.mb.ox.mb$mb, reason: collision with other inner class name */
    public interface InterfaceC0515mb {
        void mb();

        void ox();
    }

    private mb() {
    }

    public static mb mb() {
        if (ko == null) {
            synchronized (mb.class) {
                if (ko == null) {
                    ko = new mb();
                }
            }
        }
        return ko;
    }

    public void b() {
        for (Pair<ox, hj> pair : this.je) {
            try {
                this.mb.mb((ox) pair.first, (hj) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.je.clear();
    }

    public boolean hj() {
        return this.f18035x;
    }

    public void ox() {
        if (this.mb != null) {
            this.jb.unbindService(this.nk);
            this.mb = null;
        }
        this.ox.clear();
        this.je.clear();
    }

    public boolean mb(Context context, boolean z2) {
        if (TextUtils.isEmpty(hj)) {
            JSONObject jSONObjectLz = x.lz();
            String strOptString = jSONObjectLz.optString("s");
            hj = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString(c.bj), strOptString);
            f18032h = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("u"), strOptString);
            f18033u = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString(IAdInterListener.AdReqParam.WIDTH), strOptString);
        }
        this.lz = z2;
        if (context == null) {
            return true;
        }
        this.jb = context.getApplicationContext();
        if (TextUtils.isEmpty(f18033u)) {
            f18033u = this.jb.getPackageName();
        }
        if (this.mb != null || hj()) {
            return true;
        }
        return this.jb.bindService(mb(context), this.nk, 33);
    }

    public Intent mb(Context context) {
        Intent intent = new Intent();
        intent.setAction(hj);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (f18032h.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void mb(ox oxVar, hj hjVar) {
        synchronized (this.b) {
            oxVar.f18036h = f18033u;
            if (TextUtils.isEmpty(oxVar.f18037u)) {
                oxVar.f18037u = this.f18034o;
            }
            if (this.mb != null) {
                try {
                    this.mb.mb(oxVar, hjVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (hj() || mb(this.jb, this.lz)) {
                this.je.add(Pair.create(oxVar, hjVar));
            }
        }
    }

    public void mb(boolean z2) {
        this.f18035x = z2;
    }
}
