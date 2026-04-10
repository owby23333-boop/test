package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private static t E = null;
    public static final String a = "k";
    public static final String b = "p";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16796c = "v";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16797d = "l";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f16798e = "i";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16799f = "a";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16800g = "s";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16801h = "n";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16802i = "u";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16803j = "c";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f16804k = "r";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f16805l = "b";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f16806m = "m";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f16807n = "el";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f16808o = "ail";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f16809p = "aps";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f16810q = "dp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f16811r = "pcn";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f16812s = "pst";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f16813t = "d";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f16814u = "at";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f16815v = "dm";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f16816w = "rm";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f16817x = "pc";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f16818y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f16819z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bh.f16577p, (SQLiteDatabase.CursorFactory) null, t.this.f16819z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 >= 3 || i3 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized t a(Context context) {
        if (E == null) {
            E = new t(context);
        }
        return E;
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            return this.C.update(bh.f16578q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public long a(s sVar) {
        long jInsert = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.b));
        contentValues.put("aps", Integer.valueOf(sVar.f16786p));
        contentValues.put("p", sVar.f16773c);
        contentValues.put("a", sVar.f16775e);
        contentValues.put("l", sVar.f16778h);
        contentValues.put("v", sVar.f16774d);
        contentValues.put(f16810q, sVar.f16784n);
        contentValues.put("a", sVar.f16775e);
        contentValues.put(f16811r, sVar.f16785o);
        contentValues.put(f16812s, Long.valueOf(sVar.f16789s));
        contentValues.put(f16816w, Integer.valueOf(sVar.f16793w));
        contentValues.put("at", Integer.valueOf(sVar.f16787q));
        contentValues.put(f16817x, Integer.valueOf(sVar.f16794x));
        contentValues.put(f16818y, Integer.valueOf(sVar.f16795y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f16780j)) {
            contentValues.put("dm", sVar.f16780j);
        }
        try {
            if (b(sVar.a)) {
                jInsert = this.C.update(bh.f16578q, contentValues, "k=" + sVar.a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.a));
                jInsert = this.C.insert(bh.f16578q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return jInsert;
    }

    public s a(int i2) {
        Cursor cursorQuery;
        s sVar = null;
        try {
            cursorQuery = this.C.query(bh.f16578q, null, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        s sVar2 = new s();
                        try {
                            sVar2.a = i2;
                            sVar2.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar2.f16773c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar2.f16775e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar2.f16778h = cursorQuery.getString(cursorQuery.getColumnIndex("l"));
                            sVar2.f16774d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar2.f16784n = cursorQuery.getString(cursorQuery.getColumnIndex(f16810q));
                            sVar2.f16786p = cursorQuery.getInt(cursorQuery.getColumnIndex("aps"));
                            sVar2.f16785o = cursorQuery.getString(cursorQuery.getColumnIndex(f16811r));
                            sVar2.f16787q = cursorQuery.getInt(cursorQuery.getColumnIndex("at"));
                            sVar2.f16789s = cursorQuery.getLong(cursorQuery.getColumnIndex(f16812s));
                            sVar2.f16790t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar2.f16793w = cursorQuery.getInt(cursorQuery.getColumnIndex(f16816w));
                            sVar2.f16780j = cursorQuery.getString(cursorQuery.getColumnIndex("dm"));
                            sVar2.f16794x = cursorQuery.getInt(cursorQuery.getColumnIndex(f16817x));
                            boolean z2 = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(f16818y)) != 1) {
                                z2 = false;
                            }
                            sVar2.f16795y = z2;
                            sVar = sVar2;
                        } catch (Throwable unused) {
                            sVar = sVar2;
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return sVar;
    }

    public List<s> a() {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.C.query(bh.f16578q, null, null, null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        s sVar = new s();
                        sVar.a = cursorQuery.getInt(cursorQuery.getColumnIndex("k"));
                        sVar.f16773c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                        sVar.f16775e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                        sVar.f16778h = cursorQuery.getString(cursorQuery.getColumnIndex("l"));
                        sVar.f16774d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                        sVar.f16789s = cursorQuery.getLong(cursorQuery.getColumnIndex(f16812s));
                        sVar.f16790t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                        sVar.f16793w = cursorQuery.getInt(cursorQuery.getColumnIndex(f16816w));
                        sVar.f16794x = cursorQuery.getInt(cursorQuery.getColumnIndex(f16817x));
                        boolean z2 = true;
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex(f16818y)) != 1) {
                            z2 = false;
                        }
                        sVar.f16795y = z2;
                        arrayList.add(sVar);
                    } catch (Throwable unused) {
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                        }
                        return arrayList;
                    }
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bh.f16578q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        Cursor cursorQuery;
        s sVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z2 = true;
            cursorQuery = this.C.query(bh.f16578q, null, "p=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        s sVar2 = new s();
                        try {
                            sVar2.a = cursorQuery.getInt(cursorQuery.getColumnIndex("k"));
                            sVar2.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar2.f16773c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar2.f16775e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar2.f16778h = cursorQuery.getString(cursorQuery.getColumnIndex("l"));
                            sVar2.f16774d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar2.f16784n = cursorQuery.getString(cursorQuery.getColumnIndex(f16810q));
                            sVar2.f16786p = cursorQuery.getInt(cursorQuery.getColumnIndex("aps"));
                            sVar2.f16785o = cursorQuery.getString(cursorQuery.getColumnIndex(f16811r));
                            sVar2.f16787q = cursorQuery.getInt(cursorQuery.getColumnIndex("at"));
                            sVar2.f16789s = cursorQuery.getLong(cursorQuery.getColumnIndex(f16812s));
                            sVar2.f16790t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar2.f16793w = cursorQuery.getInt(cursorQuery.getColumnIndex(f16816w));
                            sVar2.f16780j = cursorQuery.getString(cursorQuery.getColumnIndex("dm"));
                            sVar2.f16794x = cursorQuery.getInt(cursorQuery.getColumnIndex(f16817x));
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(f16818y)) != 1) {
                                z2 = false;
                            }
                            sVar2.f16795y = z2;
                            sVar = sVar2;
                        } catch (Throwable unused) {
                            sVar = sVar2;
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return sVar;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dm.a(sVar.f16775e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r rVarA = r.a();
            for (s sVar2 : arrayList) {
                if (rVarA != null) {
                    rVarA.a(sVar2.f16775e);
                }
                this.C.delete(bh.f16578q, "k=" + sVar2.a, null);
                if (r.b != null && !r.b.contains(Integer.valueOf(sVar2.a))) {
                    dm.c(this.D.getFilesDir().getCanonicalPath() + bh.f16571j + sVar2.a);
                }
                if (rVarA.b() != null && rVarA.b().get(sVar2.f16773c) != null) {
                    dm.c(this.D.getFileStreamPath(sVar2.f16773c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            this.C.update(bh.f16578q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public boolean b(int i2) {
        Cursor cursorQuery;
        boolean z2 = false;
        try {
            cursorQuery = this.C.query(bh.f16578q, new String[]{"p"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        z2 = true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return z2;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return z2;
    }

    public int c(int i2) {
        Cursor cursorQuery;
        int i3 = 0;
        try {
            cursorQuery = this.C.query(bh.f16578q, new String[]{"n"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return i3;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return i3;
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bh.f16578q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f16817x, Integer.valueOf(i3));
            this.C.update(bh.f16578q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update(bh.f16578q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public boolean d(int i2) {
        Cursor cursorQuery;
        boolean z2 = false;
        try {
            cursorQuery = this.C.query(bh.f16578q, new String[]{"s"}, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("s")) == 1) {
                            z2 = true;
                        }
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                    }
                    return z2;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return z2;
    }
}
