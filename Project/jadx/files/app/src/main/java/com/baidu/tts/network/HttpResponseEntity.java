package com.baidu.tts.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpResponseEntity {
    private String contentEncoding;
    private long contentLength;
    private String contentType;
    private Map<String, List<String>> header;
    private InputStream inputStream;
    private int responseCode;

    public InputStream getContent() throws IllegalStateException, IOException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("response getInputstream is null");
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Map<String, List<String>> getHeader() {
        return this.header;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public void setContentLength(long j2) {
        this.contentLength = j2;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setHeader(Map<String, List<String>> map) {
        this.header = map;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }
}
