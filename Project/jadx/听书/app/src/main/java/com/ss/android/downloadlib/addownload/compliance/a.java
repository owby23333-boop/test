package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.dl;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.fo.fo;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.downloader.pf.gz<Long, Bitmap> {
    private final Map<Long, SoftReference<z>> z;

    public interface z {
        void z(Bitmap bitmap);
    }

    private static class g {
        private static a z = new a();
    }

    public static a z() {
        return g.z;
    }

    private a() {
        super(8, 8);
        this.z = new HashMap();
    }

    public void z(long j, z zVar) {
        if (get(Long.valueOf(j)) != null) {
            zVar.z((Bitmap) get(Long.valueOf(j)));
        } else {
            this.z.put(Long.valueOf(j), new SoftReference<>(zVar));
        }
    }

    public void z(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<z> softReferenceRemove = this.z.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().z((Bitmap) get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e.z(12, j2);
        } else {
            com.ss.android.downloadlib.e.dl.z((dl.z<Object, R>) new dl.z<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
                @Override // com.ss.android.downloadlib.e.dl.z
                public Object z(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    fo foVarZ;
                    try {
                        foVarZ = com.ss.android.socialbase.downloader.downloader.dl.z(true, 0, str, null);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.pf.m.z(bufferedInputStream);
                        throw th;
                    }
                    if (foVarZ != null) {
                        bufferedInputStream = new BufferedInputStream(foVarZ.z());
                        try {
                            try {
                                bufferedInputStream.mark(bufferedInputStream.available());
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                int i = options.outWidth;
                                int i2 = options.outHeight;
                                int iZ = i.z(wp.getContext(), 60.0f);
                                options.inSampleSize = a.g(iZ, iZ, options);
                                options.inJustDecodeBounds = false;
                                bufferedInputStream.reset();
                                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                    jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                    jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                    jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                                } catch (Exception e2) {
                                    com.bytedance.sdk.component.utils.wp.z(e2);
                                }
                                com.ss.android.downloadlib.a.z.z().z("ttd_pref_monitor", jSONObject, j2);
                                a.this.put(Long.valueOf(j), bitmapDecodeStream);
                                com.ss.android.socialbase.downloader.pf.m.z(bufferedInputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                com.ss.android.socialbase.downloader.pf.m.z(bufferedInputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.ss.android.downloadlib.gc.dl.z().z(e, "BitmapCache loadBitmap");
                            com.ss.android.socialbase.downloader.pf.m.z(bufferedInputStream);
                        }
                        return null;
                    }
                    com.ss.android.socialbase.downloader.pf.m.z(null);
                    return null;
                    com.ss.android.downloadlib.gc.dl.z().z(e, "BitmapCache loadBitmap");
                    com.ss.android.socialbase.downloader.pf.m.z(bufferedInputStream);
                    return null;
                }
            }, (Object) null).z(new dl.z<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
                @Override // com.ss.android.downloadlib.e.dl.z
                public Object z(Object obj) {
                    SoftReference softReference = (SoftReference) a.this.z.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((z) softReference.get()).z((Bitmap) a.this.get(Long.valueOf(j)));
                    return null;
                }
            }).z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
