package com.anythink.expressad.exoplayer.j.a;

import android.os.ConditionVariable;
import androidx.annotation.NonNull;
import com.anythink.expressad.exoplayer.j.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements a {
    private static final String a = "SimpleCache";
    private static final HashSet<File> b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f9642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f9643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f9644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, ArrayList<a.b>> f9645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9647i;

    private m(File file, d dVar) {
        this(file, dVar, null, false);
    }

    @Deprecated
    private static synchronized void d() {
        f9641c = true;
        b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized n a(String str, long j2) {
        n nVarB;
        while (true) {
            nVarB = b(str, j2);
            if (nVarB == null) {
                wait();
            }
        }
        return nVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized n b(String str, long j2) {
        n nVarA;
        n nVarB;
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        g gVarB = this.f9644f.b(str);
        if (gVarB == null) {
            nVarB = n.b(str, j2);
        } else {
            while (true) {
                nVarA = gVarB.a(j2);
                if (!nVarA.f9619d || nVarA.f9620e.exists()) {
                    break;
                }
                f();
            }
            nVarB = nVarA;
        }
        if (!nVarB.f9619d) {
            g gVarA = this.f9644f.a(str);
            if (gVarA.b()) {
                return null;
            }
            gVarA.a(true);
            return nVarB;
        }
        n nVarB2 = this.f9644f.b(str).b(nVarB);
        ArrayList<a.b> arrayList = this.f9645g.get(nVarB.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
        return nVarB2;
    }

    private n g(String str, long j2) throws Throwable {
        n nVarA;
        g gVarB = this.f9644f.b(str);
        if (gVarB == null) {
            return n.b(str, j2);
        }
        while (true) {
            nVarA = gVarB.a(j2);
            if (!nVarA.f9619d || nVarA.f9620e.exists()) {
                break;
            }
            f();
        }
        return nVarA;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long c() {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        return this.f9646h;
    }

    private m(File file, d dVar, byte[] bArr) {
        this(file, dVar, bArr, bArr != null);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a() {
        if (this.f9647i) {
            return;
        }
        this.f9645g.clear();
        try {
            f();
        } finally {
            d(this.f9642d);
            this.f9647i = true;
        }
    }

    private m(File file, d dVar, byte[] bArr, boolean z2) {
        this(file, dVar, new h(file, bArr, z2));
    }

    private static synchronized boolean b(File file) {
        return b.contains(file.getAbsoluteFile());
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized File c(String str, long j2) {
        g gVarB;
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        gVarB = this.f9644f.b(str);
        com.anythink.expressad.exoplayer.k.a.a(gVarB);
        com.anythink.expressad.exoplayer.k.a.b(gVarB.b());
        if (!this.f9642d.exists()) {
            this.f9642d.mkdirs();
            f();
        }
        return n.a(this.f9642d, gVarB.a, j2, System.currentTimeMillis());
    }

    private m(File file, d dVar, h hVar) {
        if (c(file)) {
            this.f9642d = file;
            this.f9643e = dVar;
            this.f9644f = hVar;
            this.f9645g = new HashMap<>();
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("SimpleCache.initialize()") { // from class: com.anythink.expressad.exoplayer.j.a.m.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    synchronized (m.this) {
                        conditionVariable.open();
                        m.a(m.this);
                        d unused = m.this.f9643e;
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: ".concat(String.valueOf(file)));
    }

    private void e() throws Throwable {
        if (!this.f9642d.exists()) {
            this.f9642d.mkdirs();
            return;
        }
        this.f9644f.a();
        File[] fileArrListFiles = this.f9642d.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getName().equals(h.a)) {
                n nVarA = file.length() > 0 ? n.a(file, this.f9644f) : null;
                if (nVarA != null) {
                    a(nVarA);
                } else {
                    file.delete();
                }
            }
        }
        this.f9644f.d();
        try {
            this.f9644f.b();
        } catch (a.C0200a unused) {
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void b(String str, a.b bVar) {
        if (this.f9647i) {
            return;
        }
        ArrayList<a.b> arrayList = this.f9645g.get(str);
        if (arrayList != null) {
            arrayList.remove(bVar);
            if (arrayList.isEmpty()) {
                this.f9645g.remove(str);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void d(String str, long j2) {
        k kVar = new k();
        j.a(kVar, j2);
        a(str, kVar);
    }

    private static synchronized void d(File file) {
        if (!f9641c) {
            b.remove(file.getAbsoluteFile());
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized Set<String> b() {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        return new HashSet(this.f9644f.e());
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized NavigableSet<e> a(String str, a.b bVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        ArrayList<a.b> arrayList = this.f9645g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f9645g.put(str, arrayList);
        }
        arrayList.add(bVar);
        return a(str);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void b(e eVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        a(eVar, true);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized i c(String str) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        return this.f9644f.e(str);
    }

    private void c(e eVar) {
        ArrayList<a.b> arrayList = this.f9645g.get(eVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long b(String str, long j2, long j3) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        g gVarB = this.f9644f.b(str);
        if (gVarB != null) {
            return gVarB.a(j2, j3);
        }
        return -j3;
    }

    private void c(n nVar) {
        ArrayList<a.b> arrayList = this.f9645g.get(nVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private void f() throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = this.f9644f.c().iterator();
        while (it.hasNext()) {
            for (n nVar : it.next().c()) {
                if (!nVar.f9620e.exists()) {
                    arrayList.add(nVar);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a((e) arrayList.get(i2), false);
        }
        this.f9644f.d();
        this.f9644f.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    @NonNull
    public final synchronized NavigableSet<e> a(String str) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        g gVarB = this.f9644f.b(str);
        if (gVarB != null && !gVarB.d()) {
            return new TreeSet((Collection) gVarB.c());
        }
        return new TreeSet();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long b(String str) {
        return j.a(c(str));
    }

    private void b(n nVar) {
        ArrayList<a.b> arrayList = this.f9645g.get(nVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private static synchronized boolean c(File file) {
        if (f9641c) {
            return true;
        }
        return b.add(file.getAbsoluteFile());
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(File file) {
        boolean z2 = true;
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        n nVarA = n.a(file, this.f9644f);
        com.anythink.expressad.exoplayer.k.a.b(nVarA != null);
        g gVarB = this.f9644f.b(nVarA.a);
        com.anythink.expressad.exoplayer.k.a.a(gVarB);
        com.anythink.expressad.exoplayer.k.a.b(gVarB.b());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long jA = j.a(gVarB.a());
            if (jA != -1) {
                if (nVarA.b + nVarA.f9618c > jA) {
                    z2 = false;
                }
                com.anythink.expressad.exoplayer.k.a.b(z2);
            }
            a(nVarA);
            this.f9644f.b();
            notifyAll();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(e eVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        g gVarB = this.f9644f.b(eVar.a);
        com.anythink.expressad.exoplayer.k.a.a(gVarB);
        com.anythink.expressad.exoplayer.k.a.b(gVarB.b());
        gVarB.a(false);
        this.f9644f.d(gVarB.b);
        notifyAll();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized boolean a(String str, long j2, long j3) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        g gVarB = this.f9644f.b(str);
        if (gVarB != null) {
            if (gVarB.a(j2, j3) >= j3) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(String str, k kVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9647i);
        this.f9644f.a(str, kVar);
        this.f9644f.b();
    }

    private void a(n nVar) {
        this.f9644f.a(nVar.a).a(nVar);
        this.f9646h += nVar.f9618c;
        b(nVar);
    }

    private void a(e eVar, boolean z2) {
        g gVarB = this.f9644f.b(eVar.a);
        if (gVarB == null || !gVarB.a(eVar)) {
            return;
        }
        this.f9646h -= eVar.f9618c;
        if (z2) {
            try {
                this.f9644f.d(gVarB.b);
                this.f9644f.b();
            } finally {
                c(eVar);
            }
        }
    }

    static /* synthetic */ void a(m mVar) throws Throwable {
        if (!mVar.f9642d.exists()) {
            mVar.f9642d.mkdirs();
            return;
        }
        mVar.f9644f.a();
        File[] fileArrListFiles = mVar.f9642d.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!file.getName().equals(h.a)) {
                    n nVarA = file.length() > 0 ? n.a(file, mVar.f9644f) : null;
                    if (nVarA != null) {
                        mVar.a(nVarA);
                    } else {
                        file.delete();
                    }
                }
            }
            mVar.f9644f.d();
            try {
                mVar.f9644f.b();
            } catch (a.C0200a unused) {
            }
        }
    }
}
