package com.bykv.vk.openvk.component.video.z.gc;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import androidx.media3.session.MediaUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.z.gc.g$g, reason: collision with other inner class name */
    public interface InterfaceC0035g {
        void z(Bitmap bitmap);
    }

    public static void z(long j, String str, InterfaceC0035g interfaceC0035g) {
        new z(interfaceC0035g, j).z((Object[]) new String[]{str});
    }

    public static class z extends com.bytedance.sdk.component.uy.a.g<String, Integer, Bitmap> {
        private long dl;
        private InterfaceC0035g g;

        public z(InterfaceC0035g interfaceC0035g, long j) {
            this.g = interfaceC0035g;
            this.dl = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.dl * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl(MediaUtils.TAG, "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0035g interfaceC0035g = this.g;
            if (interfaceC0035g != null) {
                interfaceC0035g.z(bitmap);
            }
        }
    }
}
