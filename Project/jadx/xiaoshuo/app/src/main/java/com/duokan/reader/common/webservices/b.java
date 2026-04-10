package com.duokan.reader.common.webservices;

import com.yuewen.nh1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public interface b {

    public interface a {
        void a(b bVar);
    }

    void a();

    long b(File file) throws IOException;

    int c();

    int code() throws IOException;

    nh1 d();

    long e();

    void f(a aVar);

    JSONObject g() throws Exception;

    Map<String, List<String>> getAllHeaders();

    long h();

    String i() throws Exception;

    int j();

    List<String> k(String str);

    InputStream l();

    long m(OutputStream outputStream) throws IOException;

    String message() throws IOException;

    boolean timeout();

    String url();
}
