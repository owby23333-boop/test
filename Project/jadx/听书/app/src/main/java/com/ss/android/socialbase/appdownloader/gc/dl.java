package com.ss.android.socialbase.appdownloader.gc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.fo.fo;
import com.ss.android.socialbase.downloader.pf.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private static volatile dl g = null;
    private static int z = 8;
    private z<Integer, Bitmap> dl;

    private static class z<K, T> extends LinkedHashMap<K, T> {
        final int z;

        public z(int i, int i2) {
            super(i2, 0.75f, true);
            this.z = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.z;
        }
    }

    public static dl z() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    private dl() {
        this.dl = null;
        int i = z;
        this.dl = new z<>(i, i / 2);
    }

    public Bitmap z(int i) {
        return this.dl.get(Integer.valueOf(i));
    }

    public void z(final int i, final String str) {
        if (TextUtils.isEmpty(str) || z(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.wp().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gc.dl.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamG;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStreamZ;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        fo foVarZ = com.ss.android.socialbase.downloader.downloader.dl.z(true, 0, str, null);
                        if (foVarZ != null) {
                            inputStreamZ = foVarZ.z();
                            try {
                                byteArrayOutputStreamG = dl.g(inputStreamZ);
                                try {
                                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamG.toByteArray());
                                } catch (Exception e2) {
                                    byteArrayInputStream2 = null;
                                    e = e2;
                                    byteArrayInputStream = null;
                                } catch (Throwable th2) {
                                    closeable = null;
                                    th = th2;
                                    byteArrayInputStream = null;
                                }
                            } catch (Exception e3) {
                                byteArrayInputStream = null;
                                byteArrayInputStream2 = null;
                                e = e3;
                                byteArrayOutputStreamG = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream = null;
                                closeable = null;
                                th = th3;
                                byteArrayOutputStreamG = null;
                            }
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamG.toByteArray());
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int i2 = options.outWidth;
                                    int i3 = options.outHeight;
                                    int iZ = com.ss.android.socialbase.appdownloader.dl.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), 44.0f);
                                    options.inSampleSize = dl.z(iZ, iZ, options);
                                    options.inJustDecodeBounds = false;
                                    dl.this.dl.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    m.z(inputStreamZ, byteArrayOutputStreamG, byteArrayInputStream, byteArrayInputStream2);
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            } catch (Exception e5) {
                                byteArrayInputStream2 = null;
                                e = e5;
                            } catch (Throwable th4) {
                                closeable = null;
                                th = th4;
                                m.z(inputStreamZ, byteArrayOutputStreamG, byteArrayInputStream, closeable);
                                throw th;
                            }
                        } else {
                            m.z(null, null, null, null);
                            return;
                        }
                    } catch (Exception e6) {
                        byteArrayOutputStreamG = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e = e6;
                        inputStreamZ = null;
                    } catch (Throwable th5) {
                        byteArrayOutputStreamG = null;
                        byteArrayInputStream = null;
                        closeable = null;
                        th = th5;
                        inputStreamZ = null;
                    }
                    wp.z(e);
                    m.z(inputStreamZ, byteArrayOutputStreamG, byteArrayInputStream, byteArrayInputStream2);
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int z(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream g(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i >= 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }
}
