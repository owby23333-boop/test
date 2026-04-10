package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cq f7856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private cp f199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HashMap<String, co> f201a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f202a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f200a = new ArrayList<>();

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f205a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f7858b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected co f203a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Random f207a = new Random();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7857a = 0;

        public a(String str) {
            this.f205a = str;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public Object mo270a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f206a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f203a == null || TextUtils.isEmpty(this.f205a)) {
                return;
            }
            File file = new File(this.f205a);
            u.a(context, new File(file.getParentFile(), bn.b(file.getAbsolutePath())), new cs(this, context));
        }

        public void a(co coVar, Context context) {
            this.f203a = coVar;
            this.f7858b = coVar.a();
            this.f206a = new WeakReference<>(context);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m272a() {
            return this.f203a == null || TextUtils.isEmpty(this.f7858b) || this.f206a == null;
        }

        public void a(a aVar) {
            this.f204a = aVar;
        }

        public void a(Context context, Object obj) {
            cq.a(context).a(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m271a() {
            return this.f205a;
        }

        public SQLiteDatabase a() {
            return this.f203a.getWritableDatabase();
        }

        public void a(Context context) {
            a aVar = this.f204a;
            if (aVar != null) {
                aVar.a(context, mo270a());
            }
            b(context);
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7862a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String[] f211a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f7862a = str2;
            this.f211a = strArr;
        }

        @Override // com.xiaomi.push.cq.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f7858b, this.f7862a, this.f211a);
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ContentValues f7863a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f7863a = contentValues;
        }

        @Override // com.xiaomi.push.cq.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f7858b, null, this.f7863a);
        }
    }

    private cq(Context context) {
        this.f198a = context;
    }

    public void b(a aVar) {
        co coVarA;
        if (aVar == null) {
            return;
        }
        if (this.f199a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM271a = aVar.m271a();
        synchronized (this.f201a) {
            coVarA = this.f201a.get(strM271a);
            if (coVarA == null) {
                coVarA = this.f199a.a(this.f198a, strM271a);
                this.f201a.put(strM271a, coVarA);
            }
        }
        if (this.f202a.isShutdown()) {
            return;
        }
        aVar.a(coVarA, this.f198a);
        a((Runnable) aVar);
    }

    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<a> f7861a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f7861a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cq.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            for (a aVar : this.f7861a) {
                if (aVar != null) {
                    aVar.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.cq.a
        public final void a(Context context) {
            super.a(context);
            for (a aVar : this.f7861a) {
                if (aVar != null) {
                    aVar.a(context);
                }
            }
        }
    }

    public static cq a(Context context) {
        if (f7856a == null) {
            synchronized (cq.class) {
                if (f7856a == null) {
                    f7856a = new cq(context);
                }
            }
        }
        return f7856a;
    }

    private void a() {
        ag.a(this.f198a).b(new cr(this), com.xiaomi.push.service.ba.a(this.f198a).a(ig.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7859a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f208a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f209a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String[] f210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<T> f7860b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f7860b = new ArrayList();
            this.f209a = list;
            this.f208a = str2;
            this.f210a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f7859a = i;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cq.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f7860b.clear();
            List<String> list = this.f209a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f209a.size()];
                this.f209a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.f7859a;
            Cursor cursorQuery = sQLiteDatabase.query(super.f7858b, strArr, this.f208a, this.f210a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.f7860b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.f7860b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.cq.a
        public SQLiteDatabase a() {
            return ((a) this).f203a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        co coVarA;
        if (aVar == null) {
            return;
        }
        if (this.f199a != null) {
            String strM271a = aVar.m271a();
            synchronized (this.f201a) {
                coVarA = this.f201a.get(strM271a);
                if (coVarA == null) {
                    coVarA = this.f199a.a(this.f198a, strM271a);
                    this.f201a.put(strM271a, coVarA);
                }
            }
            if (this.f202a.isShutdown()) {
                return;
            }
            aVar.a(coVarA, this.f198a);
            synchronized (this.f200a) {
                this.f200a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f202a.isShutdown()) {
            return;
        }
        this.f202a.execute(runnable);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m269a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f199a != null) {
            HashMap map = new HashMap();
            if (this.f202a.isShutdown()) {
                return;
            }
            for (a aVar : arrayList) {
                if (aVar.m272a()) {
                    aVar.a(a(aVar.m271a()), this.f198a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(aVar.m271a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(aVar.m271a(), arrayList2);
                }
                arrayList2.add(aVar);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f203a, this.f198a);
                    this.f202a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private co a(String str) {
        co coVarA = this.f201a.get(str);
        if (coVarA == null) {
            synchronized (this.f201a) {
                if (coVarA == null) {
                    coVarA = this.f199a.a(this.f198a, str);
                    this.f201a.put(str, coVarA);
                }
            }
        }
        return coVarA;
    }
}
