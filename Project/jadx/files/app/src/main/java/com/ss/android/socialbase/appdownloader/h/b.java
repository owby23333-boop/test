package com.ss.android.socialbase.appdownloader.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static int mb = 8;
    private static volatile b ox;
    private mb<Integer, Bitmap> b;

    private static class mb<K, T> extends LinkedHashMap<K, T> {
        final int mb;

        public mb(int i2, int i3) {
            super(i3, 0.75f, true);
            this.mb = i2;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.mb;
        }
    }

    private b() {
        this.b = null;
        int i2 = mb;
        this.b = new mb<>(i2, i2 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream ox(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static b mb() {
        if (ox == null) {
            synchronized (b.class) {
                if (ox == null) {
                    ox = new b();
                }
            }
        }
        return ox;
    }

    public Bitmap mb(int i2) {
        return this.b.get(Integer.valueOf(i2));
    }

    public void mb(final int i2, final String str) {
        if (TextUtils.isEmpty(str) || mb(i2) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.b.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamOx;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e2;
                IDownloadHttpConnection iDownloadHttpConnectionDownloadWithConnection;
                int i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                try {
                    try {
                        iDownloadHttpConnectionDownloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e3) {
                        byteArrayOutputStreamOx = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e3;
                        inputStream = null;
                    } catch (Throwable th2) {
                        byteArrayOutputStreamOx = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th2;
                        inputStream = null;
                    }
                    if (iDownloadHttpConnectionDownloadWithConnection == null) {
                        DownloadUtils.safeClose(null, null, null, null);
                        return;
                    }
                    inputStream = iDownloadHttpConnectionDownloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStreamOx = b.ox(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamOx.toByteArray());
                        } catch (Exception e4) {
                            byteArrayInputStream2 = null;
                            e2 = e4;
                            byteArrayInputStream = null;
                        } catch (Throwable th3) {
                            byteArrayInputStream2 = null;
                            th = th3;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e5;
                        byteArrayOutputStreamOx = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th4;
                        byteArrayOutputStreamOx = null;
                    }
                    try {
                        byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamOx.toByteArray());
                    } catch (Exception e6) {
                        byteArrayInputStream2 = null;
                        e2 = e6;
                    } catch (Throwable th5) {
                        byteArrayInputStream2 = null;
                        th = th5;
                        Closeable[] closeableArr = new Closeable[i3];
                        closeableArr[0] = inputStream;
                        closeableArr[1] = byteArrayOutputStreamOx;
                        closeableArr[2] = byteArrayInputStream;
                        closeableArr[3] = byteArrayInputStream2;
                        DownloadUtils.safeClose(closeableArr);
                        throw th;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int i4 = options.outWidth;
                        int i5 = options.outHeight;
                        int iMb = com.ss.android.socialbase.appdownloader.b.mb(DownloadComponentManager.getAppContext(), 44.0f);
                        options.inSampleSize = b.mb(iMb, iMb, options);
                        options.inJustDecodeBounds = false;
                        b.this.b.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr2 = {inputStream, byteArrayOutputStreamOx, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr2);
                        i3 = closeableArr2;
                    } catch (Exception e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        Closeable[] closeableArr3 = {inputStream, byteArrayOutputStreamOx, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr3);
                        i3 = closeableArr3;
                    }
                    e2.printStackTrace();
                    Closeable[] closeableArr32 = {inputStream, byteArrayOutputStreamOx, byteArrayInputStream, byteArrayInputStream2};
                    DownloadUtils.safeClose(closeableArr32);
                    i3 = closeableArr32;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int mb(int i2, int i3, BitmapFactory.Options options) {
        if (options.outWidth > i2 || options.outHeight > i3) {
            return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }
}
