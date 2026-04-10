package cn.bmob.v3.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZipUtil {
    public static String compress(String str) {
        if (str != null && str.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes());
                gZIPOutputStream.close();
                return byteArrayOutputStream.toString("ISO-8859-1");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static String getRealString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr.length >= 2) {
            boolean z2 = getShort(new byte[]{bArr[0], bArr[1]}) == 8075;
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                InputStream gZIPInputStream = z2 ? new GZIPInputStream(byteArrayInputStream) : byteArrayInputStream;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream), 1000);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                gZIPInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            sb.append(new String(bArr));
        }
        return sb.toString();
    }

    private static int getShort(byte[] bArr) {
        return (bArr[1] & 255) | (bArr[0] << 8);
    }

    public static void main(String[] strArr) throws IOException {
        System.out.println(uncompress(compress("中国China")));
    }

    public static String uncompress(String str) throws Throwable {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
                try {
                    GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream2);
                    try {
                        byte[] bArr = new byte[256];
                        while (true) {
                            int i2 = gZIPInputStream2.read(bArr);
                            if (i2 < 0) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i2);
                        }
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream2);
                        IOUtils.closeQuietly((InputStream) gZIPInputStream2);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                    } catch (IOException e2) {
                        byteArrayOutputStream4 = byteArrayOutputStream2;
                        gZIPInputStream = gZIPInputStream2;
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream4;
                        try {
                            e.printStackTrace();
                            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                            IOUtils.closeQuietly((InputStream) gZIPInputStream);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                            IOUtils.closeQuietly((InputStream) gZIPInputStream);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        gZIPInputStream = gZIPInputStream2;
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream3;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((InputStream) gZIPInputStream);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream4 = byteArrayOutputStream2;
                    gZIPInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    gZIPInputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = byteArrayOutputStream2;
                gZIPInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                gZIPInputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        return byteArrayOutputStream2.toString();
    }
}
