package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface b {
    void addHeader(String str, String str2);

    String bn(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> xQ();

    Map<String, List<String>> xR();

    void xS();
}
