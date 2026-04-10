package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.Chain;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj extends LruCache<Long, Bitmap> {
    private final Map<Long, SoftReference<mb>> mb;

    public interface mb {
        void mb(Bitmap bitmap);
    }

    private static class ox {
        private static hj mb = new hj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ox(int i2, int i3, BitmapFactory.Options options) {
        if (options.outWidth > i2 || options.outHeight > i3) {
            return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    private hj() {
        super(8, 8);
        this.mb = new HashMap();
    }

    public static hj mb() {
        return ox.mb;
    }

    public void mb(long j2, @NonNull mb mbVar) {
        if (get(Long.valueOf(j2)) != null) {
            mbVar.mb(get(Long.valueOf(j2)));
        } else {
            this.mb.put(Long.valueOf(j2), new SoftReference<>(mbVar));
        }
    }

    public void mb(final long j2, final long j3, final String str) {
        if (get(Long.valueOf(j2)) != null) {
            SoftReference<mb> softReferenceRemove = this.mb.remove(Long.valueOf(j2));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().mb(get(Long.valueOf(j2)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            h.mb(12, j3);
        } else {
            Chain.mb((Chain.mb<Object, R>) new Chain.mb<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hj.2
                @Override // com.ss.android.downloadlib.utils.Chain.mb
                public Object mb(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    IDownloadHttpConnection iDownloadHttpConnectionDownloadWithConnection;
                    try {
                        iDownloadHttpConnectionDownloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        DownloadUtils.safeClose(bufferedInputStream);
                        throw th;
                    }
                    if (iDownloadHttpConnectionDownloadWithConnection == null) {
                        DownloadUtils.safeClose(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(iDownloadHttpConnectionDownloadWithConnection.getInputStream());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int iMb = jb.mb(x.getContext(), 60.0f);
                            options.inSampleSize = hj.ox(iMb, iMb, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt(EventConstants.ExtraJson.KEY_TYPE, "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            AdEventHandler.mb().mb(EventConstants.UnityLabel.TTD_PREF_MONITOR, jSONObject, j3);
                            hj.this.put(Long.valueOf(j2), bitmapDecodeStream);
                            DownloadUtils.safeClose(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            DownloadUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.ss.android.downloadlib.exception.b.mb().mb(e, "BitmapCache loadBitmap");
                        DownloadUtils.safeClose(bufferedInputStream);
                    }
                    return null;
                    com.ss.android.downloadlib.exception.b.mb().mb(e, "BitmapCache loadBitmap");
                    DownloadUtils.safeClose(bufferedInputStream);
                    return null;
                }
            }, (Object) null).mb(new Chain.mb<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hj.1
                @Override // com.ss.android.downloadlib.utils.Chain.mb
                public Object mb(Object obj) {
                    SoftReference softReference = (SoftReference) hj.this.mb.remove(Long.valueOf(j2));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((mb) softReference.get()).mb(hj.this.get(Long.valueOf(j2)));
                    return null;
                }
            }).mb();
        }
    }
}
