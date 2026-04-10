package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d.a {
    private static volatile a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<ComponentName, IBinder> f14659c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<ComponentName, b> f14660d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C0306a<Intent> f14661e = new C0306a<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f14662f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashSet<ComponentName> f14663g = new HashSet<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<ComponentName> f14664h = new HashSet<>();
    private final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.bytedance.pangle.service.a.a$a, reason: collision with other inner class name */
    class C0306a<T> extends HashMap<f, T> {
        C0306a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            f next;
            T t2 = (T) super.remove(obj);
            if (t2 != null) {
                return t2;
            }
            Iterator<f> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((f) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }
    }

    class b extends HashSet<f> {
        b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            Object obj2 = null;
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar = (f) it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (fVar.a() == ((f) obj).a()) {
                    obj2 = fVar;
                    break;
                }
            }
            return super.remove(obj2);
        }
    }

    private a() {
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f14662f.containsKey(component)) {
            com.bytedance.pangle.service.a aVarD = d(intent, str);
            if (aVarD == null) {
                return component;
            }
            this.f14662f.put(component, aVarD);
            this.f14663g.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f14662f.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a aVarE = e(intent, str);
        if (aVarE != null) {
            aVarE.onCreate();
        }
        return aVarE;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                throw new RuntimeException(e);
            }
        } catch (Exception e3) {
            e = e3;
            zLoadPlugin = false;
        }
    }

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.f14662f.containsKey(componentName)) {
            return false;
        }
        this.f14664h.add(componentName);
        return b(componentName);
    }

    private boolean b(ComponentName componentName) {
        if (!this.f14663g.contains(componentName)) {
            if (this.f14660d.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.f14664h.contains(componentName) || this.f14660d.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a aVarRemove = this.f14662f.remove(componentName);
        this.f14664h.remove(componentName);
        this.f14659c.remove(componentName);
        this.f14663g.remove(componentName);
        if (aVarRemove != null) {
            aVarRemove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(final Intent intent, final f fVar, final int i2, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, fVar, str);
        }
        this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, fVar, str);
                } catch (RemoteException e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, f fVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f14662f.containsKey(component)) {
            com.bytedance.pangle.service.a aVarD = d(intent, str);
            if (aVarD == null) {
                return false;
            }
            this.f14662f.put(component, aVarD);
        }
        com.bytedance.pangle.service.a aVar = this.f14662f.get(component);
        if (!this.f14659c.containsKey(component)) {
            this.f14659c.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f14659c.get(component);
        if (iBinder != null) {
            if (this.f14660d.containsKey(component)) {
                if (!this.f14660d.get(component).contains(fVar)) {
                    this.f14660d.get(component).add(fVar);
                    this.f14661e.put(fVar, intent);
                    fVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(fVar);
                this.f14660d.put(component, bVar);
                this.f14661e.put(fVar, intent);
                fVar.a(component, iBinder);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(f fVar) {
        for (ComponentName componentName : this.f14660d.keySet()) {
            b bVar = this.f14660d.get(componentName);
            if (bVar.contains(fVar)) {
                bVar.remove(fVar);
                Intent intentRemove = this.f14661e.remove(fVar);
                if (bVar.size() == 0) {
                    this.f14660d.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f14662f.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(intentRemove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final void a(final f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(fVar);
        } else {
            this.a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            });
        }
    }
}
