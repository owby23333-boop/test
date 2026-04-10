package com.getkeepsafe.relinker;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.b;
import com.getkeepsafe.relinker.f.f;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: ReLinkerInstance.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    protected final Set<String> a;
    protected final b.InterfaceC0314b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final b.a f14834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f14835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f14836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected b.d f14837f;

    /* JADX INFO: compiled from: ReLinkerInstance.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Context f14838s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ String f14839t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ String f14840u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ b.c f14841v;

        a(Context context, String str, String str2, b.c cVar) {
            this.f14838s = context;
            this.f14839t = str;
            this.f14840u = str2;
            this.f14841v = cVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                c.this.c(this.f14838s, this.f14839t, this.f14840u);
                this.f14841v.success();
            } catch (MissingLibraryException e2) {
                this.f14841v.a(e2);
            } catch (UnsatisfiedLinkError e3) {
                this.f14841v.a(e3);
            }
        }
    }

    /* JADX INFO: compiled from: ReLinkerInstance.java */
    class b implements FilenameFilter {
        final /* synthetic */ String a;

        b(c cVar, String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.a);
        }
    }

    protected c() {
        this(new d(), new com.getkeepsafe.relinker.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2) throws Throwable {
        f fVar;
        if (this.a.contains(str) && !this.f14835d) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.b.loadLibrary(str);
            this.a.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e2) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e2));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileB = b(context, str, str2);
            if (!fileB.exists() || this.f14835d) {
                if (this.f14835d) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                a(context, str, str2);
                this.f14834c.a(context, this.b.a(), this.b.a(str), fileB, this);
            }
            try {
                if (this.f14836e) {
                    f fVar2 = null;
                    try {
                        fVar = new f(fileB);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List<String> listJ = fVar.j();
                        fVar.close();
                        Iterator<String> it = listJ.iterator();
                        while (it.hasNext()) {
                            a(context, this.b.b(it.next()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.b.c(fileB.getAbsolutePath());
            this.a.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    protected File b(Context context, String str, String str2) {
        String strA = this.b.a(str);
        if (e.a(str2)) {
            return new File(a(context), strA);
        }
        return new File(a(context), strA + "." + str2);
    }

    protected c(b.InterfaceC0314b interfaceC0314b, b.a aVar) {
        this.a = new HashSet();
        if (interfaceC0314b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.b = interfaceC0314b;
        this.f14834c = aVar;
    }

    public c a(b.d dVar) {
        this.f14837f = dVar;
        return this;
    }

    public c a() {
        this.f14836e = true;
        return this;
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (b.c) null);
    }

    public void a(Context context, String str, b.c cVar) {
        a(context, str, (String) null, cVar);
    }

    public void a(Context context, String str, String str2, b.c cVar) {
        if (context != null) {
            if (!e.a(str)) {
                a("Beginning load of %s...", str);
                if (cVar == null) {
                    c(context, str, str2);
                    return;
                } else {
                    new Thread(new a(context, str, str2, cVar)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    protected File a(Context context) {
        return context.getDir("lib", 0);
    }

    protected void a(Context context, String str, String str2) {
        File fileA = a(context);
        File fileB = b(context, str, str2);
        File[] fileArrListFiles = fileA.listFiles(new b(this, this.b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f14835d || !file.getAbsolutePath().equals(fileB.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }

    public void a(String str) {
        b.d dVar = this.f14837f;
        if (dVar != null) {
            dVar.log(str);
        }
    }
}
