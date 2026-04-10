package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.e.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private static volatile w a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7953c = "Waterfall_Final";
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    class a {
        String a;
        ConcurrentHashMap<String, C0172a> b = new ConcurrentHashMap<>();

        /* JADX INFO: renamed from: com.anythink.core.common.w$a$a, reason: collision with other inner class name */
        class C0172a {
            com.anythink.core.c.d a;
            CopyOnWriteArrayList<ai> b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            boolean f7955c;

            C0172a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void b() {
                if (this.f7955c) {
                    return;
                }
                this.f7955c = true;
            }

            private boolean c() {
                return this.f7955c;
            }

            private List<ai> a() {
                return this.b;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void a(ai aiVar) {
                com.anythink.core.common.k.g.a((List<ai>) this.b, aiVar, true);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void a(List<ai> list) {
                if (this.b != null && this.b.size() > 0) {
                    this.b.removeAll(list);
                }
            }
        }

        a() {
        }

        private boolean b(String str) {
            C0172a c0172a = this.b.get(str);
            if (c0172a != null) {
                return c0172a.f7955c;
            }
            return false;
        }

        private void c(String str) {
            C0172a c0172a = this.b.get(str);
            if (c0172a != null) {
                c0172a.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void d(String str) {
            Iterator<Map.Entry<String, C0172a>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key != null) {
                    String string = key.toString();
                    if (this.b.get(string).f7955c && !TextUtils.equals(str, string)) {
                        it.remove();
                    }
                }
            }
        }

        private void a(String str, com.anythink.core.c.d dVar, List<ai> list) {
            C0172a c0172a = new C0172a();
            c0172a.a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0172a.b = copyOnWriteArrayList;
            this.b.put(str, c0172a);
        }

        static /* synthetic */ void b(a aVar, String str) {
            C0172a c0172a = aVar.b.get(str);
            if (c0172a != null) {
                c0172a.b();
            }
        }

        static /* synthetic */ List c(a aVar, String str) {
            C0172a c0172a = aVar.b.get(str);
            if (c0172a != null) {
                return c0172a.b;
            }
            return null;
        }

        private List<ai> a(String str) {
            C0172a c0172a = this.b.get(str);
            if (c0172a != null) {
                return c0172a.b;
            }
            return null;
        }

        private void a(String str, ai aiVar) {
            C0172a c0172a = this.b.get(str);
            if (c0172a != null) {
                c0172a.a(aiVar);
            }
        }

        private static /* synthetic */ boolean d(a aVar, String str) {
            C0172a c0172a = aVar.b.get(str);
            if (c0172a != null) {
                return c0172a.f7955c;
            }
            return false;
        }

        private void a(String str, List<ai> list) {
            C0172a c0172a = this.b.get(str);
            if (c0172a != null) {
                c0172a.a(list);
            }
        }

        private static /* synthetic */ void a(a aVar, String str, com.anythink.core.c.d dVar, List list) {
            C0172a c0172a = aVar.new C0172a();
            c0172a.a = dVar;
            CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.addAll(list);
            c0172a.b = copyOnWriteArrayList;
            aVar.b.put(str, c0172a);
        }

        private static /* synthetic */ void a(a aVar, String str, ai aiVar) {
            C0172a c0172a = aVar.b.get(str);
            if (c0172a != null) {
                c0172a.a(aiVar);
            }
        }

        static /* synthetic */ void a(a aVar, String str, List list) {
            C0172a c0172a = aVar.b.get(str);
            if (c0172a != null) {
                c0172a.a((List<ai>) list);
            }
        }
    }

    private w() {
    }

    public static w a() {
        if (a == null) {
            synchronized (w.class) {
                if (a == null) {
                    a = new w();
                }
            }
        }
        return a;
    }

    public final synchronized void b(String str, String str2, List<ai> list) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return;
        }
        a.a(aVar, str2, list);
        a(str, str2, list);
    }

    public final List<ai> b(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar != null) {
            return a.c(aVar, str2);
        }
        return null;
    }

    public final synchronized void a(String str, String str2, com.anythink.core.c.d dVar, List<ai> list) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        a.C0172a c0172a = aVar.b.get(str2);
        boolean z2 = c0172a != null ? c0172a.f7955c : false;
        a.C0172a c0172a2 = aVar.new C0172a();
        c0172a2.a = dVar;
        CopyOnWriteArrayList<ai> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAll(list);
        c0172a2.b = copyOnWriteArrayList;
        aVar.b.put(str2, c0172a2);
        aVar.a = str2;
        this.b.put(str, aVar);
        aVar.d(str2);
        if (z2) {
            a.b(aVar, str2);
        }
    }

    public final String b(String str) {
        a aVar = this.b.get(str);
        return aVar != null ? aVar.a : "";
    }

    public final synchronized void a(String str, String str2, List<ai> list) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return;
        }
        for (ai aiVar : list) {
            a.C0172a c0172a = aVar.b.get(str2);
            if (c0172a != null) {
                c0172a.a(aiVar);
            }
        }
    }

    public final synchronized void a(String str, String str2, ai aiVar) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(aiVar);
        a.a(aVar, str2, arrayList);
    }

    public final synchronized void a(String str, String str2) {
        a aVar = this.b.get(str);
        if (aVar == null) {
            return;
        }
        a.b(aVar, str2);
    }

    public final List<ai> a(String str) {
        a aVar = this.b.get(str);
        List listC = aVar != null ? a.c(aVar, aVar.a) : null;
        if (listC == null) {
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(str);
            if (dVarA != null) {
                return dVarA.F();
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listC);
        return arrayList;
    }
}
