package org.apache.http.entity.mime.content;

import cn.kuaipan.android.http.multipart.FilePart;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes9.dex */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    public InputStreamBody(InputStream inputStream, String str, String str2) {
        super(str);
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.in = inputStream;
        this.filename = str2;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = this.in.read(bArr);
                if (i == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        } finally {
            this.in.close();
        }
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, FilePart.DEFAULT_CONTENT_TYPE, str);
    }
}
