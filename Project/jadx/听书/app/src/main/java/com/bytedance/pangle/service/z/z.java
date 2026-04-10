package com.bytedance.pangle.service.z;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.gc;
import com.bytedance.pangle.gz;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends gc.z {
    private static volatile z g;
    private final HashMap<ComponentName, IBinder> dl = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<ComponentName, g> f533a = new HashMap<>();
    private final C0113z<Intent> gc = new C0113z<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.z> m = new HashMap<>();
    private final HashSet<ComponentName> e = new HashSet<>();
    private final HashSet<ComponentName> gz = new HashSet<>();
    private final List<Runnable> fo = new ArrayList();
    private final Handler z = new Handler(Looper.getMainLooper());

    @Override // com.bytedance.pangle.gc.z, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    class g extends HashSet<gz> {
        g() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof gz)) {
                return false;
            }
            Iterator<gz> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    m.z(e);
                }
                if (it.next().z() == ((gz) obj).z()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            gz gzVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    gzVar = null;
                    break;
                }
                gzVar = (gz) it.next();
                try {
                } catch (RemoteException e) {
                    m.z(e);
                }
                if (gzVar.z() == ((gz) obj).z()) {
                    break;
                }
            }
            return super.remove(gzVar);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.service.z.z$z, reason: collision with other inner class name */
    class C0113z<T> extends HashMap<gz, T> {
        C0113z() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof gz)) {
                return false;
            }
            Iterator<gz> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    m.z(e);
                }
                if (it.next().z() == ((gz) obj).z()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            gz next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<gz> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e) {
                    m.z(e);
                }
                if (next.z() == ((gz) obj).z()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }
    }

    public static z g() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    private z() {
    }

    public void dl() {
        for (Runnable runnable : this.fo) {
            if (runnable != null) {
                this.z.post(runnable);
            }
        }
        this.fo.clear();
    }

    @Override // com.bytedance.pangle.gc
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return z(intent, str);
            }
            this.z.post(new Runnable() { // from class: com.bytedance.pangle.service.z.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z(intent, str);
                }
            });
        } else {
            this.fo.add(new Runnable() { // from class: com.bytedance.pangle.service.z.z.2
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName z(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.m.containsKey(component)) {
            com.bytedance.pangle.service.z zVarG = g(intent, str);
            if (zVarG == null) {
                return component;
            }
            this.m.put(component, zVarG);
            this.e.add(component);
        }
        com.bytedance.pangle.service.z zVar = this.m.get(component);
        if (zVar != null) {
            zVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private com.bytedance.pangle.service.z g(Intent intent, String str) {
        com.bytedance.pangle.service.z zVarDl = dl(intent, str);
        if (zVarDl != null) {
            zVarDl.onCreate();
        }
        return zVarDl;
    }

    private com.bytedance.pangle.service.z dl(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.z zVar = (com.bytedance.pangle.service.z) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                zVar.attach(plugin);
                return zVar;
            } catch (Exception e) {
                e = e;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            zLoadPlugin = false;
        }
    }

    @Override // com.bytedance.pangle.gc
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g().z(intent.getComponent());
            return true;
        }
        this.z.post(new Runnable() { // from class: com.bytedance.pangle.service.z.z.3
            @Override // java.lang.Runnable
            public void run() {
                z.g().z(intent.getComponent());
            }
        });
        return true;
    }

    public synchronized boolean z(ComponentName componentName) {
        if (!this.m.containsKey(componentName)) {
            return false;
        }
        this.gz.add(componentName);
        return g(componentName);
    }

    private boolean g(ComponentName componentName) {
        if (!this.e.contains(componentName)) {
            if (this.f533a.get(componentName) != null) {
                return false;
            }
            dl(componentName);
            return true;
        }
        if (!this.gz.contains(componentName) || this.f533a.containsKey(componentName)) {
            return false;
        }
        dl(componentName);
        return true;
    }

    private void dl(ComponentName componentName) {
        com.bytedance.pangle.service.z zVarRemove = this.m.remove(componentName);
        this.gz.remove(componentName);
        this.dl.remove(componentName);
        this.e.remove(componentName);
        if (zVarRemove != null) {
            zVarRemove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.gc
    public boolean bindService(final Intent intent, final gz gzVar, final int i, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return z(intent, gzVar, i, str);
            }
            this.z.post(new Runnable() { // from class: com.bytedance.pangle.service.z.z.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        z.this.z(intent, gzVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                    }
                }
            });
            return true;
        }
        this.fo.add(new Runnable() { // from class: com.bytedance.pangle.service.z.z.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z.this.z(intent, gzVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean z(Intent intent, gz gzVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.m.containsKey(component)) {
            com.bytedance.pangle.service.z zVarG = g(intent, str);
            if (zVarG == null) {
                return false;
            }
            this.m.put(component, zVarG);
        }
        com.bytedance.pangle.service.z zVar = this.m.get(component);
        if (!this.dl.containsKey(component)) {
            this.dl.put(component, zVar.onBind(intent));
        }
        IBinder iBinder = this.dl.get(component);
        if (iBinder != null) {
            if (this.f533a.containsKey(component)) {
                if (!this.f533a.get(component).contains(gzVar)) {
                    this.f533a.get(component).add(gzVar);
                    this.gc.put(gzVar, intent);
                    gzVar.z(component, iBinder);
                }
            } else {
                g gVar = new g();
                gVar.add(gzVar);
                this.f533a.put(component, gVar);
                this.gc.put(gzVar, intent);
                gzVar.z(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.bytedance.pangle.gc
    public void unbindService(final gz gzVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z(gzVar);
        } else {
            this.z.post(new Runnable() { // from class: com.bytedance.pangle.service.z.z.6
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z(gzVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(gz gzVar) {
        for (ComponentName componentName : this.f533a.keySet()) {
            g gVar = this.f533a.get(componentName);
            if (gVar.contains(gzVar)) {
                gVar.remove(gzVar);
                Intent intentRemove = this.gc.remove(gzVar);
                if (gVar.size() == 0) {
                    this.f533a.remove(componentName);
                    com.bytedance.pangle.service.z zVar = this.m.get(componentName);
                    if (zVar != null) {
                        zVar.onUnbind(intentRemove);
                    }
                }
                g(componentName);
                return;
            }
        }
    }
}
