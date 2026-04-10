package com.duokan.reader.common.cache;

import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> {
    public static final String k = ".slot";
    public static final /* synthetic */ boolean l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3996b;
    public final File c;
    public final String d;
    public final Semaphore e;
    public final LinkedHashMap<Integer, d<T>> f = new LinkedHashMap<>(0, 0.75f, true);
    public int g = 0;
    public int h = 0;
    public int i = Integer.MAX_VALUE;
    public volatile boolean j = false;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f3997a;

        public a() {
            this.f3997a = Pattern.compile(b.this.f3995a + "\\..*\\" + b.k);
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f3997a.matcher(str).matches();
        }
    }

    /* JADX INFO: renamed from: com.duokan.reader.common.cache.b$b, reason: collision with other inner class name */
    public class C0264b implements Comparator<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f3999a;

        public C0264b(HashMap map) {
            this.f3999a = map;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLongValue = ((Long) this.f3999a.get(file)).longValue();
            long jLongValue2 = ((Long) this.f3999a.get(file2)).longValue();
            if (jLongValue == jLongValue2) {
                return 0;
            }
            return jLongValue > jLongValue2 ? 1 : -1;
        }
    }

    public static abstract class c {
        public abstract boolean equals(Object obj);

        public abstract int hashCode();

        public boolean isSuitable(Object obj) {
            return equals(obj);
        }
    }

    public static class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f4001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f4002b;
        public boolean c = false;
        public boolean d = false;

        public d(c cVar, T t) {
            this.f4001a = cVar;
            this.f4002b = t;
        }

        public c a() {
            return this.f4001a;
        }

        public T b() {
            return this.f4002b;
        }
    }

    public interface e<T> {
        boolean a(T t, Object[] objArr);

        T b(Object[] objArr);
    }

    public b(String str, int i, File file) {
        this.f3995a = str;
        this.f3996b = i;
        this.c = file;
        this.d = str + Consts.DOT;
        this.e = new Semaphore(i);
    }

    public void A(d<T> dVar) {
        m();
        l(dVar);
        w(dVar);
        u(dVar.f4002b, true);
        dVar.f4002b = null;
    }

    public synchronized int B(int i) {
        m();
        return C(i, this.i);
    }

    public synchronized int C(int i, int i2) {
        m();
        while (true) {
            if ((this.g <= i && this.h <= i2) || this.f.isEmpty()) {
                break;
            }
            Map.Entry<Integer, d<T>> next = this.f.entrySet().iterator().next();
            int iIntValue = next.getKey().intValue();
            d<T> value = next.getValue();
            if (!value.d) {
                if (value.f4001a != null && !value.c) {
                    A(value);
                }
                this.f.remove(Integer.valueOf(iIntValue));
                this.g--;
            }
        }
        return this.g;
    }

    public d<T> a(c cVar, e<T> eVar, Object... objArr) throws Throwable {
        m();
        int iHashCode = cVar.hashCode();
        d<T> dVar = this.f.get(Integer.valueOf(iHashCode));
        if (dVar != null) {
            if (dVar.d) {
                return null;
            }
            g(dVar, iHashCode);
            if (dVar.f4002b != null) {
                h(dVar, false);
            }
            this.f.remove(Integer.valueOf(iHashCode));
            this.g--;
        }
        if (dVar == null && this.f.size() < this.f3996b) {
            dVar = new d<>(null, null);
        }
        if (dVar == null) {
            Iterator<Map.Entry<Integer, d<T>>> it = this.f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, d<T>> next = it.next();
                next.getKey().intValue();
                d<T> value = next.getValue();
                if (value.c) {
                    it.remove();
                    this.g--;
                    dVar = value;
                    break;
                }
            }
        }
        if (dVar == null) {
            Iterator<Map.Entry<Integer, d<T>>> it2 = this.f.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<Integer, d<T>> next2 = it2.next();
                int iIntValue = next2.getKey().intValue();
                d<T> value2 = next2.getValue();
                if (!value2.d) {
                    g(value2, iIntValue);
                    if (value2.f4002b != null) {
                        A(value2);
                    }
                    it2.remove();
                    this.g--;
                    dVar = value2;
                }
            }
        }
        if (dVar == null) {
            return null;
        }
        T t = dVar.f4002b;
        if (t == null) {
            dVar.f4001a = cVar;
            dVar.f4002b = t(eVar, objArr);
        } else {
            dVar.f4001a = cVar;
            if (!x(eVar, t, objArr)) {
                u(dVar.f4002b, true);
                dVar.f4002b = t(eVar, objArr);
            }
        }
        dVar.c = false;
        T t2 = dVar.f4002b;
        if (t2 == null) {
            return null;
        }
        int iS = this.i - s(t2);
        C(this.f3996b, iS >= 0 ? iS : 0);
        this.f.put(Integer.valueOf(iHashCode), dVar);
        this.g++;
        y(dVar);
        return dVar;
    }

    public d<T> b(c cVar, e<T> eVar, Object... objArr) {
        m();
        this.e.acquireUninterruptibly();
        synchronized (this) {
            d<T> dVarN = n(cVar, false);
            if (dVarN != null) {
                if (dVarN.d) {
                    this.e.release();
                    return null;
                }
                dVarN.d = true;
                return dVarN;
            }
            d<T> dVarA = a(cVar, eVar, objArr);
            if (dVarA == null) {
                this.e.release();
                return null;
            }
            dVarA.d = true;
            return dVarA;
        }
    }

    public d<T> c(c cVar) {
        m();
        this.e.acquireUninterruptibly();
        synchronized (this) {
            d<T> dVarN = n(cVar, false);
            if (dVarN == null) {
                this.e.release();
                return null;
            }
            if (dVarN.d) {
                this.e.release();
                return null;
            }
            dVarN.d = true;
            return dVarN;
        }
    }

    public d<T> d(c cVar, e<T> eVar, Object... objArr) {
        m();
        this.e.acquireUninterruptibly();
        synchronized (this) {
            i(cVar);
            if (n(cVar, false) != null) {
                this.e.release();
                return null;
            }
            d<T> dVarA = a(cVar, eVar, objArr);
            if (dVarA == null) {
                this.e.release();
                return null;
            }
            dVarA.d = true;
            return dVarA;
        }
    }

    public synchronized void e() {
        m();
        while (!this.f.isEmpty()) {
            int iIntValue = this.f.entrySet().iterator().next().getKey().intValue();
            d<T> dVar = this.f.get(Integer.valueOf(iIntValue));
            if (!dVar.d) {
                if (dVar.f4001a != null && !dVar.c) {
                    h(dVar, true);
                }
                this.f.remove(Integer.valueOf(iIntValue));
                this.g--;
            }
        }
    }

    public synchronized boolean f(c cVar) {
        m();
        return n(cVar, false) != null;
    }

    public final boolean g(d<T> dVar, int i) throws Throwable {
        FileInputStream fileInputStream;
        if (dVar.f4001a != null) {
            return true;
        }
        if (this.c == null) {
            return false;
        }
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(o(i));
            try {
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
                    try {
                        c cVar = (c) objectInputStream2.readObject();
                        T t = (T) objectInputStream2.readObject();
                        dVar.f4001a = cVar;
                        dVar.f4002b = t;
                        try {
                            objectInputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return true;
                    } catch (Exception e4) {
                        e = e4;
                        objectInputStream = objectInputStream2;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (fileInputStream == null) {
                            return false;
                        }
                        try {
                            fileInputStream.close();
                            return false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (fileInputStream == null) {
                            throw th;
                        }
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Exception e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public void h(d<T> dVar, boolean z) {
        m();
        j(dVar);
        w(dVar);
        if (u(dVar.f4002b, z)) {
            dVar.f4002b = null;
        }
        dVar.c = true;
    }

    public synchronized void i(c cVar) {
        m();
        d<T> dVarN = n(cVar, false);
        if (dVarN != null && !dVarN.d) {
            h(dVarN, false);
            this.g--;
        }
    }

    public abstract void j(d<T> dVar);

    public abstract boolean k(T t, boolean z);

    public abstract void l(d<T> dVar);

    /* JADX WARN: Removed duplicated region for block: B:35:0x009c A[Catch: all -> 0x009e, DONT_GENERATE, TryCatch #2 {, blocks: (B:6:0x0006, B:8:0x000a, B:10:0x0011, B:12:0x0017, B:13:0x001c, B:15:0x0020, B:17:0x002c, B:18:0x002e, B:20:0x0037, B:21:0x0047, B:22:0x004f, B:24:0x0052, B:26:0x005a, B:27:0x005d, B:30:0x008a, B:34:0x0094, B:33:0x0091, B:35:0x009c), top: B:44:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() {
        /*
            r8 = this;
            boolean r0 = r8.j
            if (r0 == 0) goto L5
            return
        L5:
            monitor-enter(r8)
            boolean r0 = r8.j     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L9c
            r0 = 1
            r8.j = r0     // Catch: java.lang.Throwable -> L9e
            java.io.File r0 = r8.c     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L1c
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L1c
            java.io.File r0 = r8.c     // Catch: java.lang.Throwable -> L9e
            r0.mkdirs()     // Catch: java.lang.Throwable -> L9e
        L1c:
            java.io.File r0 = r8.c     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L9c
            com.duokan.reader.common.cache.b$a r1 = new com.duokan.reader.common.cache.b$a     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r1.<init>()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            java.io.File[] r0 = r0.listFiles(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r1 = 0
            if (r0 != 0) goto L2e
            java.io.File[] r0 = new java.io.File[r1]     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
        L2e:
            java.util.HashMap r2 = new java.util.HashMap     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r2.<init>()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            int r3 = r0.length     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r4 = r1
        L35:
            if (r4 >= r3) goto L47
            r5 = r0[r4]     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            long r6 = r5.lastModified()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r2.put(r5, r6)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            int r4 = r4 + 1
            goto L35
        L47:
            com.duokan.reader.common.cache.b$b r3 = new com.duokan.reader.common.cache.b$b     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            r3.<init>(r2)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            java.util.Arrays.sort(r0, r3)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
        L4f:
            int r2 = r0.length     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            if (r1 >= r2) goto L94
            r2 = r0[r1]     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            int r3 = r0.length     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            int r4 = r8.f3996b     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
            int r3 = r3 - r4
            if (r1 >= r3) goto L5d
            r2.delete()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
        L5d:
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            java.lang.String r3 = r8.d     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            int r3 = r3.length()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            int r4 = r2.length()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            int r4 = r4 + (-5)
            java.lang.String r2 = r2.substring(r3, r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            java.util.LinkedHashMap<java.lang.Integer, com.duokan.reader.common.cache.b$d<T>> r3 = r8.f     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            com.duokan.reader.common.cache.b$d r4 = new com.duokan.reader.common.cache.b$d     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            r5 = 0
            r4.<init>(r5, r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            r3.put(r2, r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9e
            goto L8d
        L89:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> L9e
        L8d:
            int r1 = r1 + 1
            goto L4f
        L90:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L9e
        L94:
            java.util.LinkedHashMap<java.lang.Integer, com.duokan.reader.common.cache.b$d<T>> r0 = r8.f     // Catch: java.lang.Throwable -> L9e
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L9e
            r8.g = r0     // Catch: java.lang.Throwable -> L9e
        L9c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L9e
            return
        L9e:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L9e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.b.m():void");
    }

    public d<T> n(c cVar, boolean z) {
        m();
        d<T> dVar = this.f.get(Integer.valueOf(cVar.hashCode()));
        if (dVar == null || !g(dVar, cVar.hashCode()) || !dVar.f4001a.isSuitable(cVar) || (!z && dVar.c)) {
            return null;
        }
        return dVar;
    }

    public final File o(int i) {
        return new File(this.c, this.d + i + k);
    }

    public synchronized int p() {
        return this.i;
    }

    public synchronized int q() {
        return this.h;
    }

    public synchronized int r() {
        return this.g;
    }

    public abstract int s(T t);

    public T t(e<T> eVar, Object[] objArr) {
        m();
        T tB = eVar.b(objArr);
        if (tB != null) {
            this.h += s(tB);
        }
        return tB;
    }

    public boolean u(T t, boolean z) {
        m();
        int iS = s(t);
        boolean zK = k(t, z);
        if (zK) {
            this.h -= iS;
        }
        return zK;
    }

    public synchronized void v(d<T> dVar) {
        m();
        dVar.d = false;
        this.e.release();
    }

    public final void w(d<T> dVar) {
        if (this.c != null) {
            try {
                o(dVar.f4001a.hashCode()).delete();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean x(e<T> eVar, T t, Object[] objArr) {
        m();
        return eVar.a(t, objArr);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0050 -> B:48:0x006a). Please report as a decompilation issue!!! */
    public final void y(d<T> dVar) throws Throwable {
        FileOutputStream fileOutputStream;
        if (this.c == null) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        objectOutputStream = null;
        objectOutputStream = null;
        objectOutputStream = null;
        objectOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(o(dVar.f4001a.hashCode()));
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                        try {
                            Object obj = dVar.f4001a;
                            objectOutputStream2.writeObject(obj);
                            objectOutputStream2.writeObject(dVar.f4002b);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            fileOutputStream.close();
                            objectOutputStream = obj;
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                objectOutputStream = objectOutputStream;
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                objectOutputStream = objectOutputStream;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public synchronized void z(int i) {
        this.i = i;
    }
}
