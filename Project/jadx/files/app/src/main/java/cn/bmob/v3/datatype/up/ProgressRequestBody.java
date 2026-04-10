package cn.bmob.v3.datatype.up;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: classes.dex */
public class ProgressRequestBody extends RequestBody {
    private BufferedSink bufferedSink;
    private final UpProgressListener progressListener;
    private final RequestBody requestBody;

    public ProgressRequestBody(RequestBody requestBody, UpProgressListener upProgressListener) {
        this.requestBody = requestBody;
        this.progressListener = upProgressListener;
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) { // from class: cn.bmob.v3.datatype.up.ProgressRequestBody.1
            long bytesWritten = 0;
            long contentLength = 0;

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j2) throws IOException {
                super.write(buffer, j2);
                if (this.contentLength == 0) {
                    this.contentLength = ProgressRequestBody.this.contentLength();
                }
                this.bytesWritten += j2;
                ProgressRequestBody.this.progressListener.onRequestProgress(this.bytesWritten, this.contentLength);
            }
        };
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return this.requestBody.getContentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = Okio.buffer(sink(bufferedSink));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }
}
