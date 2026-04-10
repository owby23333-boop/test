package cn.kuaipan.android.kss.upload;

import android.util.Log;
import cn.kuaipan.android.http.KscHttpResponse;
import cn.kuaipan.android.kss.KssDef;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public class ServerExpect implements KssDef {
    private static final String HEADER_FACTORY_MODE = "X-Factory-Mode";
    private static final String HEADER_NEXT_CHUNK_SIZE = "X-Next-Chunk-Size";
    private static final String HEADER_UPLOAD_DELAY = "X-Upload-Delay";
    private static final String LOG_TAG = "ServerExpect";
    private static final int MAX_DELAY = 300;
    public boolean factoryMode = false;
    public int uploadDelay = -1;
    public int nextChunkSize = -1;

    private static int getInt(Header header) {
        if (header == null) {
            return -1;
        }
        try {
            return Integer.parseInt(header.getValue());
        } catch (NumberFormatException unused) {
            Log.w(LOG_TAG, "Failed parser header: " + header);
            return -1;
        }
    }

    public static ServerExpect getServerExpect(KscHttpResponse kscHttpResponse) {
        HttpResponse response = kscHttpResponse == null ? null : kscHttpResponse.getResponse();
        if (response == null) {
            return null;
        }
        ServerExpect serverExpect = new ServerExpect();
        Header firstHeader = response.getFirstHeader(HEADER_FACTORY_MODE);
        boolean z = true;
        if (firstHeader != null) {
            serverExpect.factoryMode = getInt(firstHeader) == 1;
            z = true;
        }
        Header firstHeader2 = response.getFirstHeader(HEADER_UPLOAD_DELAY);
        if (firstHeader2 != null) {
            serverExpect.uploadDelay = getInt(firstHeader2);
            z = true;
        }
        Header firstHeader3 = response.getFirstHeader(HEADER_NEXT_CHUNK_SIZE);
        if (firstHeader3 != null) {
            serverExpect.nextChunkSize = getInt(firstHeader3);
        } else {
            z = z;
        }
        if (z) {
            return serverExpect;
        }
        return null;
    }

    public void validate() {
        int i = this.nextChunkSize;
        if (i >= 0) {
            int i2 = i - (i % 65536);
            this.nextChunkSize = i2;
            int iMin = Math.min(i2, KssDef.MAX_CHUNKSIZE);
            this.nextChunkSize = iMin;
            this.nextChunkSize = Math.max(iMin, 65536);
        }
        int i3 = this.uploadDelay;
        if (i3 <= 0 || this.factoryMode) {
            return;
        }
        this.uploadDelay = Math.min(i3, 300);
    }
}
