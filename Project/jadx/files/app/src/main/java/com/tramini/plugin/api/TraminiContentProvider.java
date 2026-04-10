package com.tramini.plugin.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tramini.plugin.a.a.c;

/* JADX INFO: loaded from: classes3.dex */
public class TraminiContentProvider extends ContentProvider {
    public static final String TAG = TraminiContentProvider.class.getSimpleName();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                c.c().a(TraminiContentProvider.this.getContext().getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        new Handler(Looper.getMainLooper()).postDelayed(new a(), 500L);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
