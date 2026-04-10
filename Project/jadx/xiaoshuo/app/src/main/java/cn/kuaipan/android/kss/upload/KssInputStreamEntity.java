package cn.kuaipan.android.kss.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

/* JADX INFO: loaded from: classes.dex */
public class KssInputStreamEntity extends InputStreamEntity {
    private final InputStream content;

    public KssInputStreamEntity(InputStream inputStream, long j) {
        super(inputStream, j);
        inputStream.mark((int) Math.min(2147483647L, j));
        this.content = inputStream;
    }

    @Override // org.apache.http.entity.InputStreamEntity, org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        this.content.reset();
        return super.getContent();
    }

    @Override // org.apache.http.entity.InputStreamEntity, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return super.isRepeatable() || this.content.markSupported();
    }

    @Override // org.apache.http.entity.InputStreamEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.content.reset();
        super.writeTo(outputStream);
    }
}
