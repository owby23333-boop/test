package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cq;

/* JADX INFO: loaded from: classes8.dex */
class cs implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ cq.a f212a;

    public cs(cq.a aVar, Context context) {
        this.f212a = aVar;
        this.f7865a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = this.f212a.a();
                if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                    sQLiteDatabaseA.beginTransaction();
                    this.f212a.a(this.f7865a, sQLiteDatabaseA);
                    sQLiteDatabaseA.setTransactionSuccessful();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                co coVar = this.f212a.f203a;
                if (coVar != null) {
                    coVar.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        this.f212a.a(this.f7865a);
                        throw th;
                    }
                }
                co coVar2 = this.f212a.f203a;
                if (coVar2 != null) {
                    coVar2.close();
                }
                this.f212a.a(this.f7865a);
                throw th;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            co coVar3 = this.f212a.f203a;
            if (coVar3 != null) {
                coVar3.close();
            }
        }
        this.f212a.a(this.f7865a);
    }
}
