package miuix.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class GZIPCodec {
    public GZIPCodec() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static byte[] decode(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] byteArray = IOUtils.toByteArray(gZIPInputStream);
            IOUtils.closeQuietly((InputStream) gZIPInputStream);
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly((InputStream) gZIPInputStream);
            throw th;
        }
    }

    public static byte[] encode(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            IOUtils.closeQuietly((OutputStream) gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            IOUtils.closeQuietly((OutputStream) gZIPOutputStream2);
            throw th;
        }
    }

    public static String getID() {
        return "gzip";
    }
}
