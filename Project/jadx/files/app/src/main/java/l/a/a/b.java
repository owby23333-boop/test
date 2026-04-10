package l.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: BaseSpringSystem.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f21013c;
    private final Map<String, e> a = new HashMap();
    private final Set<e> b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<k> f21014d = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f21015e = true;

    public b(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.f21013c = iVar;
        this.f21013c.a(this);
    }

    public e a() {
        e eVar = new e(this);
        a(eVar);
        return eVar;
    }

    public boolean b() {
        return this.f21015e;
    }

    public void b(double d2) {
        Iterator<k> it = this.f21014d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        a(d2);
        if (this.b.isEmpty()) {
            this.f21015e = true;
        }
        Iterator<k> it2 = this.f21014d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
        if (this.f21015e) {
            this.f21013c.b();
        }
    }

    void a(e eVar) {
        if (eVar != null) {
            if (!this.a.containsKey(eVar.c())) {
                this.a.put(eVar.c(), eVar);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }

    void a(double d2) {
        for (e eVar : this.b) {
            if (eVar.g()) {
                eVar.a(d2 / 1000.0d);
            } else {
                this.b.remove(eVar);
            }
        }
    }

    void a(String str) {
        e eVar = this.a.get(str);
        if (eVar != null) {
            this.b.add(eVar);
            if (b()) {
                this.f21015e = false;
                this.f21013c.a();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }
}
