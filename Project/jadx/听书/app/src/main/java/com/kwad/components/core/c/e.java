package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e implements i {
    private static volatile e NE;
    private String NF;
    private int NG = 0;
    private int cacheSize = 1;
    private long NH = 1800;
    private boolean enable = false;

    public static e au(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        e eVar = new e(j);
        eVar.NG = adInfoEl.adBaseInfo.adCacheStrategy;
        eVar.NH = adInfoEl.adBaseInfo.adCacheSecond;
        eVar.cacheSize = adInfoEl.adBaseInfo.adCacheSize;
        eVar.enable = adInfoEl.adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    public static synchronized List<e> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(b(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        String string = cursor.getString(cursor.getColumnIndex("posId"));
        int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
        int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
        long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
        boolean z = true;
        if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
            z = false;
        }
        eVar = new e();
        eVar.NF = string;
        eVar.NG = i;
        eVar.cacheSize = i2;
        eVar.NH = j;
        eVar.enable = z;
        return eVar;
    }

    private static e of() {
        if (NE == null) {
            synchronized (e.class) {
                if (NE == null) {
                    NE = new e();
                }
            }
        }
        return NE;
    }

    public static e x(long j) {
        e eVarAd;
        return (a.nZ() == null || (eVarAd = a.nZ().ad(String.valueOf(j))) == null) ? of() : eVarAd;
    }

    private e() {
    }

    private e(long j) {
        this.NF = String.valueOf(j);
    }

    public final String og() {
        return this.NF;
    }

    public final int oh() {
        return this.NG;
    }

    public final int oi() {
        return this.cacheSize;
    }

    public final long oj() {
        return this.NH;
    }

    public final boolean isEnable() {
        return this.enable;
    }

    public final boolean isDefault() {
        return equals(of());
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.NF);
        contentValues.put("strategyCode", Integer.valueOf(this.NG));
        contentValues.put("cacheSize", Integer.valueOf(this.cacheSize));
        contentValues.put("cacheSecond", Long.valueOf(this.NH));
        contentValues.put("enable", Integer.valueOf(this.enable ? 1 : 0));
        return contentValues;
    }
}
