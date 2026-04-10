package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class MimeTypeMap {
    private static MimeTypeMap a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : wVarA.c().h(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        if (a == null) {
            a = new MimeTypeMap();
        }
        return a;
    }

    public String getExtensionFromMimeType(String str) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : wVarA.c().l(str);
    }

    public String getMimeTypeFromExtension(String str) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : wVarA.c().j(str);
    }

    public boolean hasExtension(String str) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : wVarA.c().k(str);
    }

    public boolean hasMimeType(String str) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : wVarA.c().i(str);
    }
}
