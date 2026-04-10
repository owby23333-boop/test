package cn.bmob.v3.util;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;

    public static String byte2String(byte[] bArr) {
        return new String(bArr, Charset.forName(a.bN));
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long jCopyLarge = copyLarge(inputStream, outputStream);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[4096]);
    }

    public static long skip(InputStream inputStream, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j2);
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        long j3 = j2;
        while (j3 > 0) {
            long j4 = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(j3, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH));
            if (j4 < 0) {
                break;
            }
            j3 -= j4;
        }
        return j2 - j3;
    }

    public static void skipFully(InputStream inputStream, long j2) throws IOException {
        if (j2 < 0) {
            throw new IllegalArgumentException("Bytes to skip must not be negative: " + j2);
        }
        long jSkip = skip(inputStream, j2);
        if (jSkip == j2) {
            return;
        }
        throw new EOFException("Bytes to skip: " + j2 + " actual: " + jSkip);
    }

    public static byte[] string2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.getBytes(Charset.forName(a.bN));
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j2;
            }
            outputStream.write(bArr, 0, i2);
            j2 += (long) i2;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j2, long j3) throws IOException {
        return copyLarge(inputStream, outputStream, j2, j3, new byte[4096]);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j2, long j3, byte[] bArr) throws IOException {
        if (j2 > 0) {
            skipFully(inputStream, j2);
        }
        if (j3 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int iMin = (j3 <= 0 || j3 >= ((long) length)) ? length : (int) j3;
        long j4 = 0;
        while (iMin > 0) {
            int i2 = inputStream.read(bArr, 0, iMin);
            if (-1 == i2) {
                break;
            }
            outputStream.write(bArr, 0, i2);
            j4 += (long) i2;
            if (j3 > 0) {
                iMin = (int) Math.min(j3 - j4, length);
            }
        }
        return j4;
    }
}
