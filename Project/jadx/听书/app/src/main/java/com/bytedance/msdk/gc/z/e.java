package com.bytedance.msdk.gc.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final Object dl = new Object();
    private Context g;
    private z z;

    e(Context context) {
        try {
            this.g = context == null ? com.bytedance.msdk.core.g.getContext() : context.getApplicationContext();
            if (this.z == null) {
                this.z = new z();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.g;
        return context == null ? com.bytedance.msdk.core.g.getContext() : context;
    }

    public class z {
        private SQLiteDatabase g = null;

        public z() {
        }

        private void g() {
            try {
                synchronized (e.dl) {
                    SQLiteDatabase sQLiteDatabase = this.g;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new gz(e.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.g = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
                dl();
            }
        }

        public SQLiteDatabase z() {
            g();
            return this.g;
        }

        private boolean dl() {
            SQLiteDatabase sQLiteDatabase = this.g;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }
    }

    public z z() {
        return this.z;
    }
}
