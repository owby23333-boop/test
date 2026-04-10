package com.anythink.core.common.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.c.d;
import com.anythink.core.common.c.e;
import com.anythink.core.common.c.f;
import com.anythink.core.common.c.g;
import com.anythink.core.common.c.h;
import com.anythink.core.common.c.i;
import com.anythink.core.common.c.j;
import com.anythink.core.common.c.k;
import com.anythink.core.common.c.l;
import com.anythink.core.common.c.m;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    private static c a;

    private c(Context context) {
        super(context);
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d.a.f7007f);
            sQLiteDatabase.execSQL(g.a.f7029i);
            a(sQLiteDatabase, 3, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'sdkconfig'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'placement_ad_impression'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_action_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_show_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_install_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'inspect_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'video_res_cache_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'notice_url_fail_info'");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final void b(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final String c() {
        return "anythink.db";
    }

    @Override // com.anythink.core.common.c.b
    protected final int d() {
        return 9;
    }

    @Override // com.anythink.core.common.c.b
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    protected final void a(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        while (i2 < i3) {
            switch (i2) {
                case 1:
                case 2:
                    d(sQLiteDatabase);
                    c(sQLiteDatabase);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(l.a.f7062j);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(j.a.f7048h);
                    sQLiteDatabase.execSQL(k.a.f7053f);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(f.a.f7020h);
                    sQLiteDatabase.execSQL(e.a.f7012f);
                    break;
                case 6:
                    sQLiteDatabase.execSQL(h.a.f7033d);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(m.a.f7069h);
                    break;
                case 8:
                    sQLiteDatabase.execSQL(i.b.f7041i);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
                    sQLiteDatabase.execSQL(g.a.f7029i);
                    break;
            }
            i2++;
        }
    }
}
