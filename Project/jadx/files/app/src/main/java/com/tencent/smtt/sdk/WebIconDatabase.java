package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class WebIconDatabase {
    private static WebIconDatabase a;

    @Deprecated
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    private static synchronized WebIconDatabase a() {
        if (a == null) {
            a = new WebIconDatabase();
        }
        return a;
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void close() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            wVarA.c().m();
        }
    }

    public void open(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            wVarA.c().b(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            wVarA.c().d(str);
        }
    }

    public void removeAllIcons() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            wVarA.c().l();
        }
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        } else {
            wVarA.c().a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            wVarA.c().c(str);
        }
    }
}
