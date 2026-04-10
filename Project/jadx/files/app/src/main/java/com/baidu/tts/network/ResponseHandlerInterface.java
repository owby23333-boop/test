package com.baidu.tts.network;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ResponseHandlerInterface {
    void sendErrorMessage(int i2, Map<String, List<String>> map, String str, Exception exc);

    void sendResponseMessage(HttpResponseEntity httpResponseEntity) throws IOException;

    void setRequestURI(URI uri);
}
