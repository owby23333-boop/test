package com.duokan.reader.common.cache;

import android.content.ContentValues;
import com.yuewen.t41;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ListCache<TInfo, TItem, TJson, TFilter extends t41<TItem>, TComparator extends Comparator<TItem>> {
    public static final HashMap<String, a<?, ?, ?, ?, ?>> j = new HashMap<>();
    public static final HashMap<String, Object> k = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<TJson> f3981b;
    public final g<TInfo, TItem, TJson> c;
    public final TComparator d;
    public final l<TItem, TFilter, TComparator> e;
    public final int f;
    public final Object g;
    public a<TInfo, TItem, TJson, TFilter, TComparator> h;
    public boolean i;

    public enum ListCacheStoreChangeType {
        SaveItem,
        DeleteItem,
        ClearItems,
        UpdateInfo,
        UpdateVersion
    }

    public static class a<TInfo, TItem, TJson, TFilter extends t41<TItem>, TComparator extends Comparator<TItem>> {
        public static ThreadPoolExecutor j = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j<TItem, TFilter, TComparator> f3983b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3982a = false;
        public ArrayList<k> c = null;
        public ArrayList<k> d = null;
        public Runnable e = null;
        public final Object f = new Object();
        public long g = DurationKt.MAX_MILLIS;
        public int h = -1;
        public JSONObject i = null;

        /* JADX INFO: renamed from: com.duokan.reader.common.cache.ListCache$a$a, reason: collision with other inner class name */
        public class RunnableC0263a implements Runnable {
            public RunnableC0263a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f3982a) {
                    a.this.w(new ArrayList(a.this.d));
                }
                synchronized (a.this.f) {
                    a.this.d = null;
                    a.this.e = null;
                    a.this.f.notifyAll();
                }
                if (a.this.f3982a) {
                    return;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
                a.this.h();
            }
        }

        public a(j<TItem, TFilter, TComparator> jVar) {
            this.f3983b = jVar;
        }

        public synchronized void A(int i, p pVar, g<TInfo, TItem, TJson> gVar) {
            if (this.f3982a) {
                return;
            }
            int iT = t();
            if (iT < i) {
                if (pVar == null) {
                    i();
                    x(null, gVar);
                } else {
                    pVar.a(iT);
                }
                z(i);
            }
        }

        public final void h() {
            synchronized (this.f) {
                ArrayList<k> arrayList = this.c;
                if (arrayList != null && this.e == null) {
                    this.d = arrayList;
                    this.c = null;
                    RunnableC0263a runnableC0263a = new RunnableC0263a();
                    this.e = runnableC0263a;
                    j.execute(runnableC0263a);
                }
            }
        }

        public synchronized void i() {
            if (this.f3982a) {
                return;
            }
            synchronized (this.f) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                }
                k kVar = new k();
                kVar.f3988a = ListCacheStoreChangeType.ClearItems;
                this.c.add(kVar);
            }
            h();
        }

        public synchronized void j(Collection<String> collection) {
            if (this.f3982a) {
                return;
            }
            synchronized (this.f) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                }
                for (String str : collection) {
                    if (str != null) {
                        k kVar = new k();
                        m mVar = new m();
                        kVar.f3989b = mVar;
                        mVar.f3990a = str;
                        kVar.f3988a = ListCacheStoreChangeType.DeleteItem;
                        this.c.add(kVar);
                    }
                }
            }
            h();
        }

        public synchronized void k() {
            if (this.f3982a) {
                return;
            }
            this.f3982a = true;
            synchronized (this.f) {
                while (this.e != null) {
                    try {
                        this.f.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        public final ContentValues l(TItem titem, d<TItem, TJson> dVar) {
            ContentValues contentValuesC = dVar.c(titem);
            if (contentValuesC == null) {
                contentValuesC = new ContentValues();
            }
            o[] oVarArrH = dVar.h();
            if (oVarArrH == null) {
                oVarArrH = new o[0];
            }
            if (oVarArrH.length != contentValuesC.size()) {
                throw new IllegalStateException();
            }
            for (o oVar : oVarArrH) {
                if (!contentValuesC.containsKey(oVar.f3993a)) {
                    throw new IllegalStateException();
                }
            }
            return contentValuesC;
        }

        public synchronized void m(Collection<TItem> collection, c<TJson> cVar, d<TItem, TJson> dVar, b<TItem, TJson> bVar) {
            ArrayList<m> arrayList = new ArrayList<>(collection.size());
            for (TItem titem : collection) {
                String strB = dVar.b(titem);
                if (strB != null) {
                    TJson tjsonA = dVar.a(titem, null);
                    TJson tjsonE = dVar.e(titem);
                    m mVar = new m();
                    mVar.f3990a = strB;
                    mVar.f3991b = l(titem, dVar);
                    mVar.d = cVar.b(tjsonA);
                    mVar.c = cVar.b(tjsonE);
                    mVar.e = -1L;
                    arrayList.add(mVar);
                }
            }
            u(arrayList);
        }

        public synchronized Collection<TItem> n(TFilter tfilter, TComparator tcomparator, f fVar, c<TJson> cVar, b<TItem, TJson> bVar) {
            TItem titemI;
            if (this.f3982a) {
                return new ArrayList();
            }
            v();
            j<TItem, TFilter, TComparator> jVar = this.f3983b;
            if (tcomparator == null) {
                tcomparator = (TComparator) jVar.k();
            }
            Collection<m> collectionL = jVar.l(tfilter, tcomparator, fVar);
            ArrayList arrayList = new ArrayList(collectionL.size());
            for (m mVar : collectionL) {
                try {
                    titemI = bVar.i(mVar.f3990a, cVar.c(mVar.c));
                } catch (Exception unused) {
                    titemI = null;
                }
                if (titemI != null && (tfilter == null || tfilter.a(titemI))) {
                    arrayList.add(titemI);
                }
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008f A[Catch: Exception -> 0x009a, all -> 0x00a5, TRY_LEAVE, TryCatch #2 {Exception -> 0x009a, blocks: (B:45:0x0087, B:47:0x008f), top: B:59:0x0087, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized TInfo o(com.duokan.reader.common.cache.ListCache.g<TInfo, TItem, TJson> r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                boolean r0 = r8.f3982a     // Catch: java.lang.Throwable -> La5
                if (r0 == 0) goto L10
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La5
                r0.<init>()     // Catch: java.lang.Throwable -> La5
                java.lang.Object r9 = r9.f(r0)     // Catch: java.lang.Throwable -> La5
                monitor-exit(r8)
                return r9
            L10:
                org.json.JSONObject r0 = r8.i     // Catch: java.lang.Throwable -> La5
                if (r0 != 0) goto L87
                java.lang.Object r0 = r8.f     // Catch: java.lang.Throwable -> La5
                monitor-enter(r0)     // Catch: java.lang.Throwable -> La5
                java.util.ArrayList<com.duokan.reader.common.cache.ListCache$k> r1 = r8.c     // Catch: java.lang.Throwable -> L84
                r2 = 1
                if (r1 == 0) goto L39
                int r1 = r1.size()     // Catch: java.lang.Throwable -> L84
                int r1 = r1 - r2
            L21:
                if (r1 < 0) goto L39
                java.util.ArrayList<com.duokan.reader.common.cache.ListCache$k> r3 = r8.c     // Catch: java.lang.Throwable -> L84
                java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$k r3 = (com.duokan.reader.common.cache.ListCache.k) r3     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$ListCacheStoreChangeType r4 = r3.f3988a     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$ListCacheStoreChangeType r5 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo     // Catch: java.lang.Throwable -> L84
                if (r4 != r5) goto L36
                java.lang.String r1 = r3.c     // Catch: java.lang.Throwable -> L84
                r3 = r1
                r1 = r2
                goto L3b
            L36:
                int r1 = r1 + (-1)
                goto L21
            L39:
                r1 = 0
                r3 = 0
            L3b:
                if (r1 != 0) goto L5c
                java.util.ArrayList<com.duokan.reader.common.cache.ListCache$k> r4 = r8.d     // Catch: java.lang.Throwable -> L84
                if (r4 == 0) goto L5c
                int r4 = r4.size()     // Catch: java.lang.Throwable -> L84
                int r4 = r4 - r2
            L46:
                if (r4 < 0) goto L5c
                java.util.ArrayList<com.duokan.reader.common.cache.ListCache$k> r5 = r8.d     // Catch: java.lang.Throwable -> L84
                java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$k r5 = (com.duokan.reader.common.cache.ListCache.k) r5     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$ListCacheStoreChangeType r6 = r5.f3988a     // Catch: java.lang.Throwable -> L84
                com.duokan.reader.common.cache.ListCache$ListCacheStoreChangeType r7 = com.duokan.reader.common.cache.ListCache.ListCacheStoreChangeType.UpdateInfo     // Catch: java.lang.Throwable -> L84
                if (r6 != r7) goto L59
                java.lang.String r3 = r5.c     // Catch: java.lang.Throwable -> L84
                goto L5d
            L59:
                int r4 = r4 + (-1)
                goto L46
            L5c:
                r2 = r1
            L5d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
                if (r2 != 0) goto L66
                com.duokan.reader.common.cache.ListCache$j<TItem, TFilter extends com.yuewen.t41<TItem>, TComparator extends java.util.Comparator<TItem>> r0 = r8.f3983b     // Catch: java.lang.Throwable -> La5
                java.lang.String r3 = r0.c()     // Catch: java.lang.Throwable -> La5
            L66:
                boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> La5
                if (r0 == 0) goto L74
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La5
                r0.<init>()     // Catch: java.lang.Throwable -> La5
                r8.i = r0     // Catch: java.lang.Throwable -> La5
                goto L87
            L74:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L7c java.lang.Throwable -> La5
                r0.<init>(r3)     // Catch: org.json.JSONException -> L7c java.lang.Throwable -> La5
                r8.i = r0     // Catch: org.json.JSONException -> L7c java.lang.Throwable -> La5
                goto L87
            L7c:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La5
                r0.<init>()     // Catch: java.lang.Throwable -> La5
                r8.i = r0     // Catch: java.lang.Throwable -> La5
                goto L87
            L84:
                r9 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
                throw r9     // Catch: java.lang.Throwable -> La5
            L87:
                org.json.JSONObject r0 = r8.i     // Catch: java.lang.Exception -> L9a java.lang.Throwable -> La5
                java.lang.Object r0 = r9.f(r0)     // Catch: java.lang.Exception -> L9a java.lang.Throwable -> La5
                if (r0 != 0) goto L98
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L9a java.lang.Throwable -> La5
                r0.<init>()     // Catch: java.lang.Exception -> L9a java.lang.Throwable -> La5
                java.lang.Object r0 = r9.f(r0)     // Catch: java.lang.Exception -> L9a java.lang.Throwable -> La5
            L98:
                monitor-exit(r8)
                return r0
            L9a:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La5
                r0.<init>()     // Catch: java.lang.Throwable -> La5
                java.lang.Object r9 = r9.f(r0)     // Catch: java.lang.Throwable -> La5
                monitor-exit(r8)
                return r9
            La5:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.ListCache.a.o(com.duokan.reader.common.cache.ListCache$g):java.lang.Object");
        }

        public synchronized TItem p(String str, c<TJson> cVar, b<TItem, TJson> bVar) {
            if (this.f3982a) {
                return null;
            }
            m mVarR = r(str);
            if (mVarR == null) {
                return null;
            }
            try {
                return bVar.g(mVarR.f3990a, cVar.c(mVarR.d));
            } catch (Exception unused) {
                return null;
            }
        }

        public synchronized Collection<String> q(TFilter tfilter, TComparator tcomparator, f fVar) {
            if (this.f3982a) {
                return new ArrayList();
            }
            v();
            j<TItem, TFilter, TComparator> jVar = this.f3983b;
            if (tcomparator == null) {
                tcomparator = (TComparator) jVar.k();
            }
            return jVar.d(tfilter, tcomparator, fVar);
        }

        public final m r(String str) {
            synchronized (this.f) {
                ArrayList<k> arrayList = this.c;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        k kVar = this.c.get(size);
                        ListCacheStoreChangeType listCacheStoreChangeType = kVar.f3988a;
                        if (listCacheStoreChangeType != ListCacheStoreChangeType.UpdateInfo && listCacheStoreChangeType != ListCacheStoreChangeType.UpdateVersion) {
                            if (listCacheStoreChangeType == ListCacheStoreChangeType.ClearItems) {
                                return null;
                            }
                            if (kVar.f3989b.f3990a.equals(str)) {
                                if (kVar.f3988a == ListCacheStoreChangeType.DeleteItem) {
                                    return null;
                                }
                                return kVar.f3989b;
                            }
                        }
                    }
                }
                ArrayList<k> arrayList2 = this.d;
                if (arrayList2 != null) {
                    for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                        k kVar2 = this.d.get(size2);
                        ListCacheStoreChangeType listCacheStoreChangeType2 = kVar2.f3988a;
                        if (listCacheStoreChangeType2 != ListCacheStoreChangeType.UpdateInfo && listCacheStoreChangeType2 != ListCacheStoreChangeType.UpdateVersion) {
                            if (listCacheStoreChangeType2 == ListCacheStoreChangeType.ClearItems) {
                                return null;
                            }
                            if (kVar2.f3989b.f3990a.equals(str)) {
                                if (kVar2.f3988a == ListCacheStoreChangeType.DeleteItem) {
                                    return null;
                                }
                                return kVar2.f3989b;
                            }
                        }
                    }
                }
                return this.f3983b.b(str);
            }
        }

        public synchronized Collection<TItem> s(TFilter tfilter, TComparator tcomparator, f fVar, c<TJson> cVar, b<TItem, TJson> bVar) {
            TItem titemG;
            if (this.f3982a) {
                return new ArrayList();
            }
            v();
            j<TItem, TFilter, TComparator> jVar = this.f3983b;
            if (tcomparator == null) {
                tcomparator = (TComparator) jVar.k();
            }
            Collection<m> collectionP = jVar.p(tfilter, tcomparator, fVar);
            ArrayList arrayList = new ArrayList(collectionP.size());
            for (m mVar : collectionP) {
                try {
                    titemG = bVar.g(mVar.f3990a, cVar.c(mVar.d));
                } catch (Exception unused) {
                    titemG = null;
                }
                if (titemG != null && (tfilter == null || tfilter.a(titemG))) {
                    arrayList.add(titemG);
                }
            }
            return arrayList;
        }

        public synchronized int t() {
            if (this.f3982a) {
                return -1;
            }
            if (this.h == -1) {
                this.h = this.f3983b.i();
            }
            return this.h;
        }

        public final void u(ArrayList<m> arrayList) {
            if (this.f3982a) {
                return;
            }
            synchronized (this.f) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    k kVar = new k();
                    kVar.f3989b = arrayList.get(i);
                    kVar.f3988a = ListCacheStoreChangeType.SaveItem;
                    if (arrayList.get(i).e < 0) {
                        m mVar = arrayList.get(i);
                        long j2 = this.g;
                        this.g = 1 + j2;
                        mVar.e = j2;
                    }
                    this.c.add(kVar);
                }
            }
            h();
        }

        public final void v() {
            ArrayList<k> arrayList;
            synchronized (this.f) {
                while (this.e != null) {
                    try {
                        this.f.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                arrayList = this.c;
                this.d = arrayList;
                this.c = null;
            }
            if (arrayList != null) {
                w(new ArrayList<>(this.d));
                synchronized (this.f) {
                    this.d = null;
                }
            }
        }

        public final void w(ArrayList<k> arrayList) {
            if (this.f3982a) {
                return;
            }
            this.f3983b.e(arrayList);
            if (!this.f3982a && this.f3983b.f() > 0) {
                j<TItem, TFilter, TComparator> jVar = this.f3983b;
                Collection<String> collectionM = jVar.m(jVar.f());
                if (collectionM.size() > 0) {
                    this.f3983b.g(collectionM);
                }
            }
        }

        public synchronized void x(TInfo tinfo, g<TInfo, TItem, TJson> gVar) {
            if (this.f3982a) {
                return;
            }
            if (tinfo == null) {
                this.i = null;
            } else {
                this.i = gVar.d(tinfo);
            }
            synchronized (this.f) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                }
                k kVar = new k();
                kVar.f3988a = ListCacheStoreChangeType.UpdateInfo;
                kVar.f3989b = null;
                JSONObject jSONObject = this.i;
                kVar.c = jSONObject == null ? "" : jSONObject.toString();
                this.c.add(kVar);
            }
            h();
        }

        public synchronized void y(Collection<TItem> collection, c<TJson> cVar, d<TItem, TJson> dVar, b<TItem, TJson> bVar) {
            ArrayList<m> arrayList = new ArrayList<>(collection.size());
            for (TItem titem : collection) {
                try {
                    String strB = dVar.b(titem);
                    if (strB != null) {
                        TJson tjsonA = dVar.a(titem, null);
                        if (cVar.a(tjsonA)) {
                            tjsonA = dVar.a(titem, cVar.c(r(strB).d));
                        }
                        TJson tjsonE = dVar.e(titem);
                        if (tjsonA != null) {
                            m mVar = new m();
                            mVar.f3990a = strB;
                            mVar.f3991b = l(titem, dVar);
                            mVar.d = cVar.b(tjsonA);
                            mVar.c = cVar.b(tjsonE);
                            mVar.e = -1L;
                            arrayList.add(mVar);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            u(arrayList);
        }

        public synchronized void z(int i) {
            if (this.f3982a) {
                return;
            }
            t();
            if (i > this.h) {
                this.h = i;
                synchronized (this.f) {
                    if (this.c == null) {
                        this.c = new ArrayList<>();
                    }
                    k kVar = new k();
                    kVar.f3988a = ListCacheStoreChangeType.UpdateVersion;
                    kVar.f3989b = null;
                    kVar.c = null;
                    kVar.d = this.h;
                    this.c.add(kVar);
                }
                h();
            }
        }
    }

    public interface b<TItem, TJson> {
        TItem g(String str, TJson tjson);

        TItem i(String str, TJson tjson);
    }

    public interface c<TJson> {
        boolean a(TJson tjson);

        String b(TJson tjson);

        TJson c(String str);
    }

    public interface d<TItem, TJson> {
        TJson a(TItem titem, TJson tjson);

        String b(TItem titem);

        ContentValues c(TItem titem);

        TJson e(TItem titem);

        o[] h();
    }

    public static abstract class e<TItem, TJson> implements d<TItem, TJson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o[] f3985a = new o[0];

        @Override // com.duokan.reader.common.cache.ListCache.d
        public ContentValues c(TItem titem) {
            return new ContentValues();
        }

        @Override // com.duokan.reader.common.cache.ListCache.d
        public o[] h() {
            return f3985a;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3987b;

        public f(int i, int i2) {
            this.f3986a = i;
            this.f3987b = i2;
        }
    }

    public interface g<TInfo, TItem, TJson> extends d<TItem, TJson>, b<TItem, TJson> {
        JSONObject d(TInfo tinfo);

        TInfo f(JSONObject jSONObject);
    }

    public static abstract class h<TInfo, TItem, TJson> extends e<TItem, TJson> implements g<TInfo, TItem, TJson> {
        @Override // com.duokan.reader.common.cache.ListCache.d
        public TJson e(TItem titem) {
            return null;
        }

        @Override // com.duokan.reader.common.cache.ListCache.b
        public TItem i(String str, TJson tjson) {
            return null;
        }
    }

    public interface i {
        long a();
    }

    public interface j<TItem, TFilter extends t41<TItem>, TComparator extends Comparator<TItem>> {
        void a();

        m b(String str);

        String c();

        Collection<String> d(TFilter tfilter, TComparator tcomparator, f fVar);

        void e(ArrayList<k> arrayList);

        int f();

        void g(Collection<String> collection);

        String getName();

        void h(ArrayList<m> arrayList);

        int i();

        void j(int i);

        TComparator k();

        Collection<m> l(TFilter tfilter, TComparator tcomparator, f fVar);

        Collection<String> m(int i);

        void n(String str);

        Collection<String> o(Collection<String> collection);

        Collection<m> p(TFilter tfilter, TComparator tcomparator, f fVar);

        void q(ArrayList<m> arrayList);
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListCacheStoreChangeType f3988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m f3989b;
        public String c;
        public int d;
    }

    public interface l<TItem, TFilter extends t41<TItem>, TComparator extends Comparator<TItem>> {
        j<TItem, TFilter, TComparator> a(String str, TComparator tcomparator, int i);

        void b(String str);
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContentValues f3991b;
        public String c;
        public String d;
        public long e;
    }

    public static abstract class n<TItem> implements Comparator<TItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3992a;

        public n(boolean z) {
            this.f3992a = z;
        }

        @Override // java.util.Comparator
        public int compare(TItem titem, TItem titem2) {
            return -1;
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3994b;

        public o(String str, String str2) {
            this.f3993a = str;
            this.f3994b = str2;
        }
    }

    public interface p {
        void a(int i);
    }

    public ListCache(String str, c<TJson> cVar, g<TInfo, TItem, TJson> gVar, TComparator tcomparator, l<TItem, TFilter, TComparator> lVar, int i2) {
        this.i = false;
        this.f3980a = str;
        this.f3981b = cVar;
        this.c = gVar;
        this.d = tcomparator;
        this.e = lVar;
        this.f = i2;
        HashMap<String, Object> map = k;
        synchronized (map) {
            if (!map.containsKey(str)) {
                map.put(str, new Object());
            }
            this.g = map.get(str);
        }
        this.i = false;
    }

    public Collection<TItem> A(TFilter tfilter, TComparator tcomparator, f fVar) {
        synchronized (this.g) {
            if (this.i) {
                return new ArrayList();
            }
            n();
            return this.h.s(tfilter, tcomparator, fVar, this.f3981b, this.c);
        }
    }

    public int B() {
        synchronized (this.g) {
            if (this.i) {
                return -1;
            }
            n();
            return this.h.t();
        }
    }

    public void C() {
        synchronized (this.g) {
            HashMap<String, a<?, ?, ?, ?, ?>> map = j;
            synchronized (map) {
                a<?, ?, ?, ?, ?> aVar = map.get(this.f3980a);
                if (aVar != null && aVar.f3982a) {
                    map.remove(this.f3980a);
                }
            }
            if (this.i) {
                this.i = false;
                this.h = null;
            } else {
                a<TInfo, TItem, TJson, TFilter, TComparator> aVar2 = this.h;
                if (aVar2 != null && aVar2.f3982a) {
                    this.h = null;
                }
            }
        }
    }

    public synchronized void D(Collection<TItem> collection) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            b();
            r(collection);
        }
    }

    public final void E(TItem[] titemArr) {
        D(c(titemArr));
    }

    public void F(TInfo tinfo) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.x(tinfo, this.c);
        }
    }

    public final void G(TItem titem) {
        H(d(titem));
    }

    public synchronized void H(Collection<TItem> collection) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            a<TInfo, TItem, TJson, TFilter, TComparator> aVar = this.h;
            c<TJson> cVar = this.f3981b;
            g<TInfo, TItem, TJson> gVar = this.c;
            aVar.y(collection, cVar, gVar, gVar);
        }
    }

    public final void I(TItem[] titemArr) {
        H(c(titemArr));
    }

    public void J(int i2) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.z(i2);
        }
    }

    public void K(int i2) {
        L(i2, null);
    }

    public void L(int i2, p pVar) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.A(i2, pVar, this.c);
        }
    }

    public void a() {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.x(null, this.c);
        }
    }

    public void b() {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.i();
        }
    }

    public final Collection<TItem> c(TItem[] titemArr) {
        ArrayList arrayList = new ArrayList(titemArr.length);
        for (TItem titem : titemArr) {
            arrayList.add(titem);
        }
        return arrayList;
    }

    public final Collection<TItem> d(TItem titem) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(titem);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        HashMap<String, a<?, ?, ?, ?, ?>> map = j;
        synchronized (map) {
            a<TInfo, TItem, TJson, TFilter, TComparator> aVar = this.h;
            if (aVar == null || aVar.f3982a) {
                if (map.containsKey(this.f3980a)) {
                    this.h = (a) map.get(this.f3980a);
                } else {
                    a<TInfo, TItem, TJson, TFilter, TComparator> aVar2 = (a<TInfo, TItem, TJson, TFilter, TComparator>) new a(this.e.a(this.f3980a, this.d, this.f));
                    this.h = aVar2;
                    map.put(this.f3980a, (a<?, ?, ?, ?, ?>) aVar2);
                }
            }
        }
    }

    public final void f(TItem titem) {
        if (titem == null) {
            return;
        }
        h(d(titem));
    }

    public final void g(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        j(linkedList);
    }

    public final void h(Collection<TItem> collection) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<TItem> it = collection.iterator();
            while (it.hasNext()) {
                String strB = this.c.b(it.next());
                if (strB != null) {
                    arrayList.add(strB);
                }
            }
            j(arrayList);
        }
    }

    public final void i(TItem[] titemArr) {
        h(c(titemArr));
    }

    public void j(Collection<String> collection) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            this.h.j(collection);
        }
    }

    public void k(String[] strArr) {
        j(Arrays.asList(strArr));
    }

    public void l() {
        synchronized (this.g) {
            if (!this.i) {
                o();
                m();
                this.i = true;
            }
        }
    }

    public final void m() {
        synchronized (j) {
            a<TInfo, TItem, TJson, TFilter, TComparator> aVar = this.h;
            if (aVar == null) {
                return;
            }
            if (aVar.f3982a) {
                this.h = null;
                return;
            }
            this.h.k();
            this.h = null;
            this.e.b(this.f3980a);
        }
    }

    public final void n() {
        if (this.i) {
            return;
        }
        a<TInfo, TItem, TJson, TFilter, TComparator> aVar = this.h;
        if (aVar == null || aVar.f3982a) {
            e();
        }
    }

    public final void o() {
        HashMap<String, a<?, ?, ?, ?, ?>> map = j;
        synchronized (map) {
            if (this.h != null) {
                return;
            }
            if (map.containsKey(this.f3980a)) {
                this.h = (a) map.get(this.f3980a);
            } else {
                this.h = null;
            }
        }
    }

    public g<TInfo, TItem, TJson> p() {
        return this.c;
    }

    public final void q(TItem titem) {
        r(d(titem));
    }

    public void r(Collection<TItem> collection) {
        synchronized (this.g) {
            if (this.i) {
                return;
            }
            n();
            a<TInfo, TItem, TJson, TFilter, TComparator> aVar = this.h;
            c<TJson> cVar = this.f3981b;
            g<TInfo, TItem, TJson> gVar = this.c;
            aVar.m(collection, cVar, gVar, gVar);
        }
    }

    public final void s(TItem[] titemArr) {
        r(c(titemArr));
    }

    public final Collection<TItem> t() {
        return u(null, null, null);
    }

    public Collection<TItem> u(TFilter tfilter, TComparator tcomparator, f fVar) {
        synchronized (this.g) {
            if (this.i) {
                return new ArrayList();
            }
            n();
            return this.h.n(tfilter, tcomparator, fVar, this.f3981b, this.c);
        }
    }

    public TInfo v() {
        synchronized (this.g) {
            if (this.i) {
                return this.c.f(new JSONObject());
            }
            n();
            return this.h.o(this.c);
        }
    }

    public TItem w(String str) {
        synchronized (this.g) {
            if (this.i) {
                return null;
            }
            if (str == null) {
                return null;
            }
            n();
            return this.h.p(str, this.f3981b, this.c);
        }
    }

    public final Collection<String> x() {
        return y(null, null, null);
    }

    public Collection<String> y(TFilter tfilter, TComparator tcomparator, f fVar) {
        synchronized (this.g) {
            if (this.i) {
                return new ArrayList();
            }
            n();
            return this.h.q(tfilter, tcomparator, fVar);
        }
    }

    public final Collection<TItem> z() {
        return A(null, null, null);
    }
}
