package com.ss.android.socialbase.downloader.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.ss.android.socialbase.downloader.e.g.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    private static final String z = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f2067a;
    private long dl;
    private int e;
    private long fo;
    private int g;
    private long gc;
    private AtomicInteger gz;
    private boolean i;
    private g kb;
    private long m;
    private com.ss.android.socialbase.downloader.v.g pf;
    private List<g> uy;
    private AtomicBoolean v;
    private int wp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private g(z zVar) {
        if (zVar == null) {
            return;
        }
        this.g = zVar.z;
        this.dl = zVar.g;
        this.f2067a = new AtomicLong(zVar.dl);
        this.gc = zVar.f2068a;
        this.m = zVar.gc;
        this.e = zVar.m;
        this.fo = zVar.e;
        this.gz = new AtomicInteger(-1);
        z(zVar.gz);
        this.v = new AtomicBoolean(false);
    }

    public g(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.g = cursor.getInt(cursor.getColumnIndex(ar.d));
        this.e = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.dl = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f2067a = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f2067a = new AtomicLong(0L);
        }
        this.gc = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.gz = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.gz = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.m = cursor.getLong(columnIndex3);
        }
        this.v = new AtomicBoolean(false);
    }

    protected g(Parcel parcel) {
        this.g = parcel.readInt();
        this.dl = parcel.readLong();
        this.f2067a = new AtomicLong(parcel.readLong());
        this.gc = parcel.readLong();
        this.m = parcel.readLong();
        this.e = parcel.readInt();
        this.gz = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeLong(this.dl);
        AtomicLong atomicLong = this.f2067a;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.gc);
        parcel.writeLong(this.m);
        parcel.writeInt(this.e);
        AtomicInteger atomicInteger = this.gz;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues z() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(this.g));
        contentValues.put("chunkIndex", Integer.valueOf(this.e));
        contentValues.put("startOffset", Long.valueOf(this.dl));
        contentValues.put("curOffset", Long.valueOf(v()));
        contentValues.put("endOffset", Long.valueOf(this.gc));
        contentValues.put("chunkContentLen", Long.valueOf(this.m));
        contentValues.put("hostChunkIndex", Integer.valueOf(g()));
        return contentValues;
    }

    public void z(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.wp = 0;
        sQLiteStatement.clearBindings();
        int i = this.wp + 1;
        this.wp = i;
        sQLiteStatement.bindLong(i, this.g);
        int i2 = this.wp + 1;
        this.wp = i2;
        sQLiteStatement.bindLong(i2, this.e);
        int i3 = this.wp + 1;
        this.wp = i3;
        sQLiteStatement.bindLong(i3, this.dl);
        int i4 = this.wp + 1;
        this.wp = i4;
        sQLiteStatement.bindLong(i4, v());
        int i5 = this.wp + 1;
        this.wp = i5;
        sQLiteStatement.bindLong(i5, this.gc);
        int i6 = this.wp + 1;
        this.wp = i6;
        sQLiteStatement.bindLong(i6, this.m);
        int i7 = this.wp + 1;
        this.wp = i7;
        sQLiteStatement.bindLong(i7, g());
    }

    public int g() {
        AtomicInteger atomicInteger = this.gz;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void z(int i) {
        AtomicInteger atomicInteger = this.gz;
        if (atomicInteger == null) {
            this.gz = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean dl() {
        AtomicBoolean atomicBoolean = this.v;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void z(com.ss.android.socialbase.downloader.v.g gVar) {
        this.pf = gVar;
        fv();
    }

    public void z(boolean z2) {
        AtomicBoolean atomicBoolean = this.v;
        if (atomicBoolean == null) {
            this.v = new AtomicBoolean(z2);
        } else {
            atomicBoolean.set(z2);
        }
        this.pf = null;
    }

    public void z(g gVar) {
        this.kb = gVar;
        if (gVar != null) {
            z(gVar.js());
        }
    }

    public boolean a() {
        return g() == -1;
    }

    public g gc() {
        g gVar = !a() ? this.kb : this;
        if (gVar == null || !gVar.m()) {
            return null;
        }
        return gVar.e().get(0);
    }

    public boolean m() {
        List<g> list = this.uy;
        return list != null && list.size() > 0;
    }

    public void z(List<g> list) {
        this.uy = list;
    }

    public List<g> e() {
        return this.uy;
    }

    public boolean gz() {
        g gVar = this.kb;
        if (gVar == null) {
            return true;
        }
        if (!gVar.m()) {
            return false;
        }
        for (int i = 0; i < this.kb.e().size(); i++) {
            g gVar2 = this.kb.e().get(i);
            if (gVar2 != null) {
                int iIndexOf = this.kb.e().indexOf(this);
                if (iIndexOf > i && !gVar2.fo()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void g(boolean z2) {
        this.i = z2;
    }

    public boolean fo() {
        long j = this.dl;
        if (a()) {
            long j2 = this.fo;
            if (j2 > this.dl) {
                j = j2;
            }
        }
        return v() - j >= this.m;
    }

    public long uy() {
        g gVar = this.kb;
        if (gVar != null && gVar.e() != null) {
            int iIndexOf = this.kb.e().indexOf(this);
            boolean z2 = false;
            for (int i = 0; i < this.kb.e().size(); i++) {
                g gVar2 = this.kb.e().get(i);
                if (gVar2 != null) {
                    if (z2) {
                        return gVar2.v();
                    }
                    if (iIndexOf == i) {
                        z2 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public void g(int i) {
        this.g = i;
    }

    public void dl(int i) {
        this.e = i;
    }

    public void z(long j) {
        this.m = j;
    }

    public int kb() {
        return this.g;
    }

    public long wp() {
        return this.dl;
    }

    public long i() {
        AtomicLong atomicLong = this.f2067a;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long v() {
        if (a() && m()) {
            long jI = 0;
            for (int i = 0; i < this.uy.size(); i++) {
                g gVar = this.uy.get(i);
                if (gVar != null) {
                    if (!gVar.fo()) {
                        return gVar.i();
                    }
                    if (jI < gVar.i()) {
                        jI = gVar.i();
                    }
                }
            }
            return jI;
        }
        return i();
    }

    public void g(long j) {
        AtomicLong atomicLong = this.f2067a;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f2067a = new AtomicLong(j);
        }
    }

    public long pf() {
        long jV = v() - this.dl;
        if (m()) {
            jV = 0;
            for (int i = 0; i < this.uy.size(); i++) {
                g gVar = this.uy.get(i);
                if (gVar != null) {
                    jV += gVar.v() - gVar.wp();
                }
            }
        }
        return jV;
    }

    public long ls() {
        return this.gc;
    }

    public long p() {
        return this.m;
    }

    public void fv() {
        this.fo = v();
    }

    public long dl(boolean z2) {
        long jV = v();
        long j = this.m;
        long j2 = this.fo;
        long j3 = j - (jV - j2);
        if (!z2 && jV == j2) {
            j3 = j - (jV - this.dl);
        }
        com.ss.android.socialbase.downloader.m.z.g("DownloadChunk", "contentLength:" + this.m + " curOffset:" + v() + " oldOffset:" + this.fo + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<g> z(int i, long j) {
        g gVar;
        long jLs;
        long jWp;
        long j2;
        long j3;
        g gVar2 = this;
        int i2 = i;
        if (!a() || m()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jI = i();
        long jDl = gVar2.dl(true);
        long j4 = jDl / ((long) i2);
        com.ss.android.socialbase.downloader.m.z.g(z, "retainLen:" + jDl + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + gVar2.e);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jWp = wp();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jLs2 = ls();
                    j2 = jLs2;
                    j3 = jLs2 > jI ? (jLs2 - jI) + 1 : jDl - (((long) i4) * j4);
                    jWp = jI;
                    long j5 = jDl;
                    long j6 = j3;
                    g gVarZ = new z(gVar2.g).z((-i3) - 1).z(jWp).g(jI).gc(jI).dl(j2).a(j6).z(gVar2).z();
                    com.ss.android.socialbase.downloader.m.z.g(z, "divide sub chunk : " + i3 + " startOffset:" + jWp + " curOffset:" + jI + " endOffset:" + j2 + " contentLen:" + j6);
                    arrayList.add(gVarZ);
                    jI += j4;
                    i3++;
                    gVar2 = this;
                    i2 = i;
                    jDl = j5;
                } else {
                    jWp = jI;
                }
            }
            j2 = (jI + j4) - 1;
            j3 = j4;
            long j52 = jDl;
            long j62 = j3;
            g gVarZ2 = new z(gVar2.g).z((-i3) - 1).z(jWp).g(jI).gc(jI).dl(j2).a(j62).z(gVar2).z();
            com.ss.android.socialbase.downloader.m.z.g(z, "divide sub chunk : " + i3 + " startOffset:" + jWp + " curOffset:" + jI + " endOffset:" + j2 + " contentLen:" + j62);
            arrayList.add(gVarZ2);
            jI += j4;
            i3++;
            gVar2 = this;
            i2 = i;
            jDl = j52;
        }
        long jP = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            g gVar3 = arrayList.get(size);
            if (gVar3 != null) {
                jP += gVar3.p();
            }
        }
        com.ss.android.socialbase.downloader.m.z.g(z, "reuseChunkContentLen:".concat(String.valueOf(jP)));
        g gVar4 = arrayList.get(0);
        if (gVar4 != null) {
            if (ls() == 0) {
                jLs = j - wp();
            } else {
                jLs = (ls() - wp()) + 1;
            }
            gVar4.z(jLs - jP);
            gVar = this;
            gVar4.dl(gVar.e);
            com.ss.android.socialbase.downloader.v.g gVar5 = gVar.pf;
            if (gVar5 != null) {
                gVar5.z(gVar4.ls(), p() - jP);
            }
        } else {
            gVar = this;
        }
        gVar.z(arrayList);
        return arrayList;
    }

    public int js() {
        return this.e;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2068a;
        private long dl;
        private long e;
        private long g;
        private long gc;
        private g gz;
        private int m;
        private int z;

        public z(int i) {
            this.z = i;
        }

        public z z(long j) {
            this.g = j;
            return this;
        }

        public z g(long j) {
            this.dl = j;
            return this;
        }

        public z dl(long j) {
            this.f2068a = j;
            return this;
        }

        public z a(long j) {
            this.gc = j;
            return this;
        }

        public z z(int i) {
            this.m = i;
            return this;
        }

        public z z(g gVar) {
            this.gz = gVar;
            return this;
        }

        public z gc(long j) {
            this.e = j;
            return this;
        }

        public g z() {
            return new g(this);
        }
    }
}
