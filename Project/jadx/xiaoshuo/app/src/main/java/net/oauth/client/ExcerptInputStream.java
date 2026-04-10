package net.oauth.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.oauth.OAuth;

/* JADX INFO: loaded from: classes9.dex */
public class ExcerptInputStream extends BufferedInputStream {
    public static final byte[] ELLIPSIS = OAuth.encodeCharacters(" ...");
    private static final int LIMIT = 1024;
    private byte[] excerpt;

    public ExcerptInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.excerpt = new byte[ELLIPSIS.length + 1024];
        mark(1024);
        int i = 0;
        do {
            int i2 = read(this.excerpt, i, 1024 - i);
            if (i2 == -1) {
                break;
            } else {
                i += i2;
            }
        } while (i < 1024);
        if (i == 1024) {
            byte[] bArr = ELLIPSIS;
            System.arraycopy(bArr, 0, this.excerpt, i, bArr.length);
        } else {
            byte[] bArr2 = new byte[i];
            System.arraycopy(this.excerpt, 0, bArr2, 0, i);
            this.excerpt = bArr2;
        }
        reset();
    }

    public byte[] getExcerpt() {
        return this.excerpt;
    }
}
