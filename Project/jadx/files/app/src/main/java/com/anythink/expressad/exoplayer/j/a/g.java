package com.anythink.expressad.exoplayer.j.a;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.j.a.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9623c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9624d = Integer.MAX_VALUE;
    public final int a;
    public final String b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9627g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l f9626f = l.b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TreeSet<n> f9625e = new TreeSet<>();

    public g(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public static g a(int i2, DataInputStream dataInputStream) throws IOException {
        g gVar = new g(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i2 < 2) {
            long j2 = dataInputStream.readLong();
            k kVar = new k();
            j.a(kVar, j2);
            gVar.a(kVar);
        } else {
            gVar.f9626f = l.a(dataInputStream);
        }
        return gVar;
    }

    public final boolean b() {
        return this.f9627g;
    }

    public final TreeSet<n> c() {
        return this.f9625e;
    }

    public final boolean d() {
        return this.f9625e.isEmpty();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.a == gVar.a && this.b.equals(gVar.b) && this.f9625e.equals(gVar.f9625e) && this.f9626f.equals(gVar.f9626f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (a(Integer.MAX_VALUE) * 31) + this.f9625e.hashCode();
    }

    public final n b(n nVar) throws a.C0200a {
        com.anythink.expressad.exoplayer.k.a.b(this.f9625e.remove(nVar));
        n nVarA = nVar.a(this.a);
        if (nVar.f9620e.renameTo(nVarA.f9620e)) {
            this.f9625e.add(nVarA);
            return nVarA;
        }
        throw new a.C0200a("Renaming of " + nVar.f9620e + " to " + nVarA.f9620e + " failed.");
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        this.f9626f.a(dataOutputStream);
    }

    public final i a() {
        return this.f9626f;
    }

    public final boolean a(k kVar) {
        l lVar = this.f9626f;
        this.f9626f = lVar.a(kVar);
        return !this.f9626f.equals(lVar);
    }

    public final void a(boolean z2) {
        this.f9627g = z2;
    }

    public final void a(n nVar) {
        this.f9625e.add(nVar);
    }

    public final n a(long j2) {
        n nVarA = n.a(this.b, j2);
        n nVarFloor = this.f9625e.floor(nVarA);
        if (nVarFloor != null && nVarFloor.b + nVarFloor.f9618c > j2) {
            return nVarFloor;
        }
        n nVarCeiling = this.f9625e.ceiling(nVarA);
        if (nVarCeiling == null) {
            return n.b(this.b, j2);
        }
        return n.a(this.b, j2, nVarCeiling.b - j2);
    }

    public final long a(long j2, long j3) {
        n nVarA = a(j2);
        if (nVarA.b()) {
            return -Math.min(nVarA.a() ? Long.MAX_VALUE : nVarA.f9618c, j3);
        }
        long j4 = j2 + j3;
        long jMax = nVarA.b + nVarA.f9618c;
        if (jMax < j4) {
            for (n nVar : this.f9625e.tailSet(nVarA, false)) {
                long j5 = nVar.b;
                if (j5 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j5 + nVar.f9618c);
                if (jMax >= j4) {
                    break;
                }
            }
        }
        return Math.min(jMax - j2, j3);
    }

    public final boolean a(e eVar) {
        if (!this.f9625e.remove(eVar)) {
            return false;
        }
        eVar.f9620e.delete();
        return true;
    }

    public final int a(int i2) {
        int i3;
        int iHashCode;
        int iHashCode2 = (this.a * 31) + this.b.hashCode();
        if (i2 < 2) {
            long jA = j.a(this.f9626f);
            i3 = iHashCode2 * 31;
            iHashCode = (int) (jA ^ (jA >>> 32));
        } else {
            i3 = iHashCode2 * 31;
            iHashCode = this.f9626f.hashCode();
        }
        return i3 + iHashCode;
    }
}
