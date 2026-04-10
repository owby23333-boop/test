package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static volatile c f21299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final d f21300t = new d();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f21301u = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<o>> a;
    private final Map<Object, List<Class<?>>> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f21302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<C0588c> f21303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f21304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f21305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final org.greenrobot.eventbus.b f21306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final org.greenrobot.eventbus.a f21307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n f21308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ExecutorService f21309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f21310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f21311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f21312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f21313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f21314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f21315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f21316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final f f21317r;

    /* JADX INFO: compiled from: EventBus.java */
    class a extends ThreadLocal<C0588c> {
        a(c cVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public C0588c initialValue() {
            return new C0588c();
        }
    }

    /* JADX INFO: compiled from: EventBus.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[ThreadMode.values().length];

        static {
            try {
                a[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: org.greenrobot.eventbus.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventBus.java */
    static final class C0588c {
        final List<Object> a = new ArrayList();
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f21318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        o f21319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f21320e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f21321f;

        C0588c() {
        }
    }

    public c() {
        this(f21300t);
    }

    private void a(Object obj, m mVar) {
        Class<?> cls = mVar.f21340c;
        o oVar = new o(obj, mVar);
        CopyOnWriteArrayList<o> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(oVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || mVar.f21341d > copyOnWriteArrayList.get(i2).b.f21341d) {
                copyOnWriteArrayList.add(i2, oVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (mVar.f21342e) {
            if (!this.f21315p) {
                b(oVar, this.f21302c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f21302c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(oVar, entry.getValue());
                }
            }
        }
    }

    public static c c() {
        if (f21299s == null) {
            synchronized (c.class) {
                if (f21299s == null) {
                    f21299s = new c();
                }
            }
        }
        return f21299s;
    }

    private boolean d() {
        g gVar = this.f21304e;
        if (gVar != null) {
            return gVar.a();
        }
        return true;
    }

    public void b(Object obj) {
        List<m> listA = this.f21308i.a(obj.getClass());
        synchronized (this) {
            Iterator<m> it = listA.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f21316q + ", eventInheritance=" + this.f21315p + "]";
    }

    c(d dVar) {
        this.f21303d = new a(this);
        this.f21317r = dVar.b();
        this.a = new HashMap();
        this.b = new HashMap();
        this.f21302c = new ConcurrentHashMap();
        this.f21304e = dVar.c();
        g gVar = this.f21304e;
        this.f21305f = gVar != null ? gVar.a(this) : null;
        this.f21306g = new org.greenrobot.eventbus.b(this);
        this.f21307h = new org.greenrobot.eventbus.a(this);
        List<org.greenrobot.eventbus.p.b> list = dVar.f21330j;
        this.f21316q = list != null ? list.size() : 0;
        this.f21308i = new n(dVar.f21330j, dVar.f21328h, dVar.f21327g);
        this.f21311l = dVar.a;
        this.f21312m = dVar.b;
        this.f21313n = dVar.f21323c;
        this.f21314o = dVar.f21324d;
        this.f21310k = dVar.f21325e;
        this.f21315p = dVar.f21326f;
        this.f21309j = dVar.f21329i;
    }

    private void b(o oVar, Object obj) {
        if (obj != null) {
            a(oVar, obj, d());
        }
    }

    public synchronized void c(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.b.remove(obj);
        } else {
            this.f21317r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public f b() {
        return this.f21317r;
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<o> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                o oVar = copyOnWriteArrayList.get(i2);
                if (oVar.a == obj) {
                    oVar.f21352c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public void a(Object obj) {
        C0588c c0588c = this.f21303d.get();
        List<Object> list = c0588c.a;
        list.add(obj);
        if (c0588c.b) {
            return;
        }
        c0588c.f21318c = d();
        c0588c.b = true;
        if (c0588c.f21321f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    a(list.remove(0), c0588c);
                }
            } finally {
                c0588c.b = false;
                c0588c.f21318c = false;
            }
        }
    }

    private void a(Object obj, C0588c c0588c) throws Error {
        boolean zA;
        Class<?> cls = obj.getClass();
        if (this.f21315p) {
            List<Class<?>> listA = a(cls);
            int size = listA.size();
            zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= a(obj, c0588c, listA.get(i2));
            }
        } else {
            zA = a(obj, c0588c, cls);
        }
        if (zA) {
            return;
        }
        if (this.f21312m) {
            this.f21317r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f21314o || cls == h.class || cls == l.class) {
            return;
        }
        a(new h(this, obj));
    }

    private boolean a(Object obj, C0588c c0588c, Class<?> cls) {
        CopyOnWriteArrayList<o> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (o oVar : copyOnWriteArrayList) {
            c0588c.f21320e = obj;
            c0588c.f21319d = oVar;
            try {
                a(oVar, obj, c0588c.f21318c);
                if (c0588c.f21321f) {
                    return true;
                }
            } finally {
                c0588c.f21320e = null;
                c0588c.f21319d = null;
                c0588c.f21321f = false;
            }
        }
        return true;
    }

    private void a(o oVar, Object obj, boolean z2) {
        int i2 = b.a[oVar.b.b.ordinal()];
        if (i2 == 1) {
            a(oVar, obj);
            return;
        }
        if (i2 == 2) {
            if (z2) {
                a(oVar, obj);
                return;
            } else {
                this.f21305f.a(oVar, obj);
                return;
            }
        }
        if (i2 == 3) {
            k kVar = this.f21305f;
            if (kVar != null) {
                kVar.a(oVar, obj);
                return;
            } else {
                a(oVar, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z2) {
                this.f21306g.a(oVar, obj);
                return;
            } else {
                a(oVar, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.f21307h.a(oVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + oVar.b.b);
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (f21301u) {
            arrayList = f21301u.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                f21301u.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    void a(i iVar) {
        Object obj = iVar.a;
        o oVar = iVar.b;
        i.a(iVar);
        if (oVar.f21352c) {
            a(oVar, obj);
        }
    }

    void a(o oVar, Object obj) {
        try {
            oVar.b.a.invoke(oVar.a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(oVar, obj, e3.getCause());
        }
    }

    private void a(o oVar, Object obj, Throwable th) {
        if (obj instanceof l) {
            if (this.f21311l) {
                this.f21317r.a(Level.SEVERE, "SubscriberExceptionEvent subscriber " + oVar.a.getClass() + " threw an exception", th);
                l lVar = (l) obj;
                this.f21317r.a(Level.SEVERE, "Initial event " + lVar.b + " caused exception in " + lVar.f21339c, lVar.a);
                return;
            }
            return;
        }
        if (!this.f21310k) {
            if (this.f21311l) {
                this.f21317r.a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + oVar.a.getClass(), th);
            }
            if (this.f21313n) {
                a(new l(this, th, obj, oVar.a));
                return;
            }
            return;
        }
        throw new EventBusException("Invoking subscriber failed", th);
    }

    ExecutorService a() {
        return this.f21309j;
    }
}
