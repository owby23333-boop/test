package com.bykv.vk.openvk.component.video.e.ga;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class bf {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.e.ga.bf$bf, reason: collision with other inner class name */
    public interface InterfaceC0059bf {
        void e(Bitmap bitmap);
    }

    public static void e(long j, String str, InterfaceC0059bf interfaceC0059bf) {
        new e(interfaceC0059bf, j).execute(str);
    }

    public static class e extends AsyncTask<String, Integer, Bitmap> {
        private long bf;
        private InterfaceC0059bf e;

        public e(InterfaceC0059bf interfaceC0059bf, long j) {
            this.e = interfaceC0059bf;
            this.bf = j;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
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
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.bf * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.vn.d.d("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0059bf interfaceC0059bf = this.e;
            if (interfaceC0059bf != null) {
                interfaceC0059bf.e(bitmap);
            }
        }
    }
}
