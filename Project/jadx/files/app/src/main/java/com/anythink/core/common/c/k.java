package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.b.n;

/* JADX INFO: loaded from: classes2.dex */
public class k extends com.anythink.core.common.c.a<com.anythink.core.common.a.h> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile k f7049c;
    private final String b;

    public static class a {
        public static final String a = "offer_data_cache";
        public static final String b = "bid_id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7050c = "adsource_id";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7051d = "network_firm_id";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7052e = "offer_data";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7053f = "CREATE TABLE IF NOT EXISTS offer_data_cache(bid_id TEXT ,adsource_id TEXT ,network_firm_id INTEGER ,offer_data TEXT)";
    }

    private k(b bVar) {
        super(bVar);
        this.b = k.class.getName();
    }

    public static k a(b bVar) {
        if (f7049c == null) {
            synchronized (k.class) {
                if (f7049c == null) {
                    f7049c = new k(bVar);
                }
            }
        }
        return f7049c;
    }

    public final synchronized String b(String str) {
        Cursor cursorQuery = a().query(a.a, new String[]{a.f7052e}, "bid_id=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            return "";
        }
        cursorQuery.moveToNext();
        String string = cursorQuery.getString(0);
        cursorQuery.close();
        return string;
    }

    public final synchronized void a(String str) {
        try {
            b().delete(a.a, "bid_id = ? ", new String[]{str});
        } catch (Throwable th) {
            com.anythink.core.common.j.c.a("Error_SQL_DELETE", th.getMessage(), n.a().r());
        }
    }

    private synchronized boolean b(com.anythink.core.common.a.h hVar) {
        Cursor cursorQuery;
        if (hVar == null) {
            return false;
        }
        if (hVar.c() == 67) {
            cursorQuery = a().query(a.a, new String[]{a.f7052e}, "adsource_id=?", new String[]{hVar.b()}, null, null, null);
        } else {
            cursorQuery = a().query(a.a, new String[]{a.f7052e}, "bid_id=?", new String[]{hVar.a()}, null, null, null);
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized long a(com.anythink.core.common.a.h hVar) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, hVar.a());
            contentValues.put("adsource_id", hVar.b());
            contentValues.put(a.f7051d, hVar.a());
            contentValues.put(a.f7052e, hVar.d());
            if (b(hVar)) {
                if (hVar.c() == 67) {
                    StringBuilder sb = new StringBuilder("OfferDataCache update(Directly) new BidId:");
                    sb.append(hVar.a());
                    sb.append(",old adSourceId:");
                    sb.append(hVar.b());
                    return b().update(a.a, contentValues, "adsource_id = ? ", new String[]{hVar.b()});
                }
                new StringBuilder("OfferDataCache update(Adx) BidId:").append(hVar.a());
                return b().update(a.a, contentValues, "bid_id = ? ", new String[]{hVar.a()});
            }
            StringBuilder sb2 = new StringBuilder("OfferDataCache insert BidId:");
            sb2.append(hVar.a());
            sb2.append(",adSourceId:");
            sb2.append(hVar.b());
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
