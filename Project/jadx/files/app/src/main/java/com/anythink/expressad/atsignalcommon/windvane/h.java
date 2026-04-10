package com.anythink.expressad.atsignalcommon.windvane;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML(com.baidu.mobads.sdk.internal.a.f12785f, "text/html");


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f8324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8325k;

    h(String str, String str2) {
        this.f8324j = str;
        this.f8325k = str2;
    }

    public final String a() {
        return this.f8324j;
    }

    public final String b() {
        return this.f8325k;
    }

    private void a(String str) {
        this.f8324j = str;
    }

    private void b(String str) {
        this.f8325k = str;
    }
}
