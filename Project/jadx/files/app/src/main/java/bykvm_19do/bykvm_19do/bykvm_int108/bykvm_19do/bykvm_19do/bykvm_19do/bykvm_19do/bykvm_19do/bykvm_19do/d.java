package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    public d(Context context, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        super(context, aVar);
    }

    public static String g() {
        return ad.f20401n + j.l().e().f() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0" + ad.f20406s;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a
    public byte b() {
        return (byte) 0;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a
    public byte c() {
        return (byte) 1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a
    public String d() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e eVarE = j.l().e();
        if (eVarE != null) {
            return eVarE.f();
        }
        return null;
    }
}
