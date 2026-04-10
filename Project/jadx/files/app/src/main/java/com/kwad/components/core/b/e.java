package com.kwad.components.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e implements h {
    private static volatile e Io;

    @Nullable
    private String Ip;
    private int Iq = 0;
    private int Ir = 1;
    private long Is = com.anythink.expressad.d.a.b.aC;
    private boolean It = false;

    private e() {
    }

    private e(long j2) {
        this.Ip = String.valueOf(j2);
    }

    public static e F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j2 = adTemplate.posId;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        e eVar = new e(j2);
        AdInfo.AdBaseInfo adBaseInfo = adInfoCb.adBaseInfo;
        eVar.Iq = adBaseInfo.adCacheStrategy;
        eVar.Is = adBaseInfo.adCacheSecond;
        eVar.Ir = adBaseInfo.adCacheSize;
        eVar.It = adBaseInfo.adCacheSwitch == 1;
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
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return arrayList;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        String string = cursor.getString(cursor.getColumnIndex("posId"));
        int i2 = cursor.getInt(cursor.getColumnIndex("strategyCode"));
        int i3 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
        long j2 = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
        boolean z2 = true;
        if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
            z2 = false;
        }
        eVar = new e();
        eVar.Ip = string;
        eVar.Iq = i2;
        eVar.Ir = i3;
        eVar.Is = j2;
        eVar.It = z2;
        return eVar;
    }

    @NonNull
    private static e mA() {
        if (Io == null) {
            synchronized (e.class) {
                if (Io == null) {
                    Io = new e();
                }
            }
        }
        return Io;
    }

    @NonNull
    @WorkerThread
    public static e n(long j2) {
        e eVarAe;
        return (a.mr() == null || (eVarAe = a.mr().ae(String.valueOf(j2))) == null) ? mA() : eVarAe;
    }

    public final boolean isDefault() {
        return equals(mA());
    }

    public final boolean isEnable() {
        return this.It;
    }

    public final int mB() {
        return this.Iq;
    }

    public final int mC() {
        return this.Ir;
    }

    public final long mD() {
        return this.Is;
    }

    @Override // com.kwad.components.core.b.h
    public final ContentValues mE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.Ip);
        contentValues.put("strategyCode", Integer.valueOf(this.Iq));
        contentValues.put("cacheSize", Integer.valueOf(this.Ir));
        contentValues.put("cacheSecond", Long.valueOf(this.Is));
        contentValues.put("enable", Integer.valueOf(this.It ? 1 : 0));
        return contentValues;
    }
}
