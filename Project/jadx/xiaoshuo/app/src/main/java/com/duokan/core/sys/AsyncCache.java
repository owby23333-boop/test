package com.duokan.core.sys;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes12.dex */
public class AsyncCache {
    public static final int j = Integer.MAX_VALUE;
    public static final int k = 0;
    public static final String l = "index.db";
    public static final int m = 1;
    public static final int n = 1;
    public static final int o = 1;
    public static final /* synthetic */ boolean p = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Integer, RecordList> f2820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f2821b;
    public final Semaphore c;
    public LinkedList<Runnable> d;
    public boolean e;
    public int f;
    public int g;
    public final String h;
    public final SQLiteDatabase i;

    public enum DataState {
        NULL,
        UNFILLED,
        FILLED,
        EMPTY
    }

    public static class RecordList extends LinkedList<h> {
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncCache.this.v();
        }
    }

    public class b implements i {
        public b() {
        }

        @Override // com.duokan.core.sys.AsyncCache.i
        public boolean a(h hVar) {
            return (hVar.f2836b.n() || hVar.f2836b.o() || hVar.f2836b.p()) ? false : true;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Semaphore f2824a;

        public c(Semaphore semaphore) {
            this.f2824a = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AsyncCache.this.r()) {
                ListIterator listIteratorU = AsyncCache.this.u(false);
                while (listIteratorU.hasNext()) {
                    h hVar = (h) listIteratorU.next();
                    if (hVar.f2836b.B() > 0 && !hVar.f2836b.n()) {
                        AsyncCache.this.f -= hVar.f2836b.B();
                        hVar.f2836b.y();
                    }
                }
            }
            this.f2824a.release();
        }
    }

    public class d implements ListIterator<h> {
        public static final /* synthetic */ boolean h = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2827b;
        public int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ ArrayList f;

        public d(int i, boolean z, ArrayList arrayList) {
            this.d = i;
            this.e = z;
            this.f = arrayList;
            this.f2826a = i;
            this.f2827b = z ? i : -1;
            this.c = z ? arrayList.size() - 1 : 0;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(h hVar) {
            ((ListIterator) this.f.get(this.c)).add(hVar);
            this.f2826a++;
            this.f2827b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h next() {
            this.f2827b++;
            while (!((ListIterator) this.f.get(this.c)).hasNext()) {
                this.c++;
            }
            return (h) ((ListIterator) this.f.get(this.c)).next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public h previous() {
            this.f2827b--;
            while (!((ListIterator) this.f.get(this.c)).hasPrevious()) {
                this.c--;
            }
            return (h) ((ListIterator) this.f.get(this.c)).previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(h hVar) {
            ((ListIterator) this.f.get(this.c)).set(hVar);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f2827b + 1 < this.d;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f2827b - 1 >= 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f2827b + 1;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f2827b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.f2827b;
            if (i < 0 || i >= this.f2826a) {
                return;
            }
            ((ListIterator) this.f.get(this.c)).remove();
            this.f2826a--;
            this.f2827b--;
        }
    }

    public static abstract class e {
        public static final /* synthetic */ boolean d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DataState f2828a = DataState.NULL;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2829b = false;
        public Thread c = null;

        public final boolean A(e eVar) {
            boolean zX;
            try {
                zX = x(eVar);
            } catch (Error e) {
                e.printStackTrace();
                zX = false;
            }
            if (zX) {
                this.f2828a = DataState.UNFILLED;
                eVar.f2828a = DataState.EMPTY;
            }
            return zX;
        }

        public abstract int B();

        public final void h() {
            this.c = Thread.currentThread();
        }

        public final boolean i() {
            boolean zT;
            try {
                zT = t();
            } catch (Error e) {
                e.printStackTrace();
                zT = false;
            }
            if (zT) {
                this.f2828a = DataState.UNFILLED;
            }
            return zT;
        }

        public final boolean j() {
            return Thread.currentThread() == this.c;
        }

        public final void k() {
            this.f2829b = true;
        }

        public final void l() {
            try {
                u();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f2828a = DataState.EMPTY;
        }

        public final void m() {
            try {
                v();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f2828a = DataState.FILLED;
        }

        public final boolean n() {
            return this.c != null;
        }

        public final boolean o() {
            return this.f2829b;
        }

        public final boolean p() {
            return this.f2828a == DataState.EMPTY;
        }

        public final boolean q() {
            return this.f2828a == DataState.FILLED;
        }

        public final boolean r() {
            return this.f2828a == DataState.NULL;
        }

        public abstract int s();

        public abstract boolean t();

        public abstract void u();

        public abstract void v();

        public abstract void w();

        public abstract boolean x(e eVar);

        public final void y() {
            try {
                w();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f2828a = DataState.EMPTY;
        }

        public final void z() {
            this.c = null;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f2830a = "indices";

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f2831a = "index_id";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f2832b = "hash_code";
            public static final String c = "key";
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2834b;
        public final String c;

        public g(String str) {
            this("", str);
        }

        public String a() {
            return this.f2834b;
        }

        public String b() {
            return this.c;
        }

        public abstract int c(g gVar);

        public int hashCode() {
            return this.f2833a;
        }

        public g(String str, String str2) {
            this(str, str2, TextUtils.isEmpty(str) ? 0 : str.hashCode());
        }

        public g(String str, String str2, int i) {
            this.f2834b = str;
            this.c = str2;
            this.f2833a = i;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f2836b;
        public boolean c = false;

        public h(g gVar, e eVar) {
            this.f2835a = gVar;
            this.f2836b = eVar;
        }

        public int hashCode() {
            return this.f2835a.hashCode();
        }
    }

    public interface i {
        boolean a(h hVar);
    }

    public AsyncCache() {
        this(null);
    }

    public final e f(g gVar) {
        return g(gVar, Integer.MAX_VALUE);
    }

    public final e g(g gVar, int i2) {
        synchronized (r()) {
            h hVarP = p(gVar, i2, new b());
            if (hVarP == null) {
                return null;
            }
            j(hVarP);
            hVarP.f2836b.h();
            return hVarP.f2836b;
        }
    }

    public final e h(g gVar, e eVar) {
        e eVar2;
        synchronized (r()) {
            h hVar = new h(gVar, eVar);
            hVar.f2836b.h();
            i(hVar);
            this.c.release();
            eVar2 = hVar.f2836b;
        }
        return eVar2;
    }

    public final void i(h hVar) {
        s(hVar.hashCode()).add(hVar);
    }

    public final void j(h hVar) {
        RecordList recordListQ = q(hVar.hashCode());
        recordListQ.remove(hVar);
        recordListQ.addLast(hVar);
        this.f2820a.remove(recordListQ);
        this.f2820a.put(Integer.valueOf(hVar.hashCode()), recordListQ);
    }

    public final void k() {
        l(false);
    }

    public final void l(boolean z) {
        Semaphore semaphore = new Semaphore(0);
        y(new c(semaphore));
        if (z) {
            semaphore.acquireUninterruptibly();
        }
    }

    public final void m() {
        this.e = true;
        try {
            this.c.release();
            this.f2821b.join();
        } catch (Exception unused) {
        }
    }

    public final int n() {
        Iterator<RecordList> it = this.f2820a.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public final void o(e eVar) {
        synchronized (r()) {
            eVar.z();
            eVar.k();
        }
    }

    public final h p(g gVar, int i2, i iVar) {
        ListIterator<h> listIteratorU = u(true);
        h hVar = null;
        int i3 = 0;
        while (listIteratorU.hasPrevious()) {
            h hVarPrevious = listIteratorU.previous();
            int iC = hVarPrevious.f2835a.c(gVar);
            if (iC >= i2 && (iVar == null || iVar.a(hVarPrevious))) {
                if (hVar == null || i3 < iC) {
                    hVar = hVarPrevious;
                    i3 = iC;
                }
                if (i3 == Integer.MAX_VALUE) {
                    break;
                }
            }
        }
        return hVar;
    }

    public final RecordList q(int i2) {
        return this.f2820a.get(Integer.valueOf(i2));
    }

    public final Object r() {
        return this;
    }

    public final RecordList s(int i2) {
        RecordList recordListQ = q(i2);
        if (recordListQ != null) {
            return recordListQ;
        }
        RecordList recordList = new RecordList();
        this.f2820a.put(Integer.valueOf(i2), recordList);
        return recordList;
    }

    public final boolean t() {
        return this.c.availablePermits() == 0;
    }

    public final ListIterator<h> u(boolean z) {
        int iN = n();
        ArrayList arrayList = new ArrayList(this.f2820a.size());
        for (RecordList recordList : this.f2820a.values()) {
            if (recordList != null) {
                arrayList.add(recordList.listIterator(z ? recordList.size() : 0));
            }
        }
        return new d(iN, z, arrayList);
    }

    public final void v() {
        LinkedList<Runnable> linkedList;
        while (!this.e) {
            if (this.c.availablePermits() < 1 && !this.d.isEmpty()) {
                synchronized (r()) {
                    linkedList = this.d;
                    this.d = new LinkedList<>();
                }
                while (!linkedList.isEmpty()) {
                    linkedList.getFirst().run();
                    linkedList.removeFirst();
                }
            }
            this.c.acquireUninterruptibly();
            synchronized (r()) {
                ListIterator<h> listIteratorU = u(true);
                h hVar = null;
                while (listIteratorU.hasPrevious()) {
                    h hVarPrevious = listIteratorU.previous();
                    if (hVarPrevious.f2836b.p()) {
                        listIteratorU.remove();
                    } else if (hVar == null && !hVarPrevious.c) {
                        hVar = hVarPrevious;
                    }
                }
                if (hVar != null) {
                    if (!hVar.f2836b.o()) {
                        ListIterator<h> listIteratorU2 = u(false);
                        while (listIteratorU2.hasNext()) {
                            h next = listIteratorU2.next();
                            if (next.f2836b.o() && next.f2836b.q() && next.f2836b.B() >= hVar.f2836b.s() && hVar.f2836b.A(next.f2836b)) {
                                break;
                            }
                        }
                        if (hVar.f2836b.r() && this.f + hVar.f2836b.s() > this.g) {
                            ListIterator<h> listIteratorU3 = u(false);
                            while (listIteratorU3.hasNext()) {
                                h next2 = listIteratorU3.next();
                                if (!next2.f2836b.n() && next2.f2836b.q() && next2.f2836b.B() >= hVar.f2836b.s() && hVar.f2836b.A(next2.f2836b)) {
                                    break;
                                }
                            }
                        }
                        if (hVar.f2836b.r()) {
                            ListIterator<h> listIteratorU4 = u(false);
                            while (listIteratorU4.hasNext()) {
                                h next3 = listIteratorU4.next();
                                if (this.f <= ((double) this.g) * 0.6d) {
                                    break;
                                }
                                if (next3.f2836b.o() && next3.f2836b.q()) {
                                    this.f -= next3.f2836b.B();
                                    next3.f2836b.y();
                                }
                            }
                        }
                        if (hVar.f2836b.r()) {
                            ListIterator<h> listIteratorU5 = u(false);
                            while (listIteratorU5.hasNext()) {
                                h next4 = listIteratorU5.next();
                                if (this.f + hVar.f2836b.s() <= this.g) {
                                    break;
                                }
                                if (!next4.f2836b.n() && next4.f2836b.q()) {
                                    this.f -= next4.f2836b.B();
                                    next4.f2836b.y();
                                }
                            }
                        }
                    }
                    if (hVar.f2836b.r() && this.f + hVar.f2836b.s() <= this.g && hVar.f2836b.i()) {
                        this.f += hVar.f2836b.B();
                    }
                    if (hVar.f2836b.r()) {
                        hVar.f2836b.l();
                    } else {
                        hVar.f2836b.m();
                    }
                    hVar.c = true;
                }
            }
        }
        synchronized (r()) {
            ListIterator<h> listIteratorU6 = u(false);
            while (listIteratorU6.hasNext()) {
                h next5 = listIteratorU6.next();
                if (!next5.c) {
                    next5.f2836b.l();
                }
                if (!next5.f2836b.p()) {
                    this.f -= next5.f2836b.B();
                    next5.f2836b.y();
                }
                listIteratorU6.remove();
            }
        }
    }

    public final void w(e eVar) {
        synchronized (r()) {
            eVar.z();
        }
    }

    public final void x(h hVar) {
        RecordList recordListQ = q(hVar.hashCode());
        if (recordListQ == null) {
            return;
        }
        recordListQ.remove(hVar);
    }

    public final boolean y(Runnable runnable) {
        if (this.e || runnable == null) {
            return false;
        }
        synchronized (r()) {
            this.d.push(runnable);
        }
        this.c.release();
        return true;
    }

    public void z(int i2) {
        this.g = i2;
    }

    public AsyncCache(String str) {
        this.f2820a = new LinkedHashMap<>();
        this.c = new Semaphore(0);
        this.d = new LinkedList<>();
        this.e = false;
        this.f = 0;
        this.g = 3145728;
        this.h = str;
        SQLiteDatabase sQLiteDatabase = null;
        if (TextUtils.isEmpty(str)) {
            this.i = null;
        } else {
            try {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(new File(Uri.parse(str).getPath(), l), (SQLiteDatabase.CursorFactory) null);
                sQLiteDatabaseOpenOrCreateDatabase.beginTransaction();
                try {
                    if (sQLiteDatabaseOpenOrCreateDatabase.getVersion() < 1) {
                        sQLiteDatabaseOpenOrCreateDatabase.execSQL(String.format("CREATE TABLE %1$s(2$s INTEGER PRIMARY KEY, 3$s INTEGER, 4$s BLOB)", f.f2830a, f.a.f2831a, f.a.f2832b, "key"));
                    }
                    sQLiteDatabaseOpenOrCreateDatabase.setVersion(1);
                    sQLiteDatabaseOpenOrCreateDatabase.setTransactionSuccessful();
                    sQLiteDatabaseOpenOrCreateDatabase.endTransaction();
                    sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                } catch (Throwable th) {
                    sQLiteDatabaseOpenOrCreateDatabase.endTransaction();
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.i = sQLiteDatabase;
        }
        Thread thread = new Thread(new a());
        this.f2821b = thread;
        thread.start();
    }
}
