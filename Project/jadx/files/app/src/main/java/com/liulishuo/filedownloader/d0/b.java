package com.liulishuo.filedownloader.d0;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FileDownloadConnection.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a();

    boolean a(String str) throws ProtocolException;

    boolean a(String str, long j2);

    void addHeader(String str, String str2);

    Map<String, List<String>> b();

    Map<String, List<String>> c();

    void execute() throws IOException;

    InputStream getInputStream() throws IOException;

    int getResponseCode() throws IOException;

    String getResponseHeaderField(String str);
}
