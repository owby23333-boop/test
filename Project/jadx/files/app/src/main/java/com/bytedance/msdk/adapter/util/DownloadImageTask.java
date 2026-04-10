package com.bytedance.msdk.adapter.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private SoftReference<ImageView> a;

    public DownloadImageTask(ImageView imageView) {
        this.a = new SoftReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null || this.a.get() == null) {
            return;
        }
        this.a.get().setImageBitmap(bitmap);
    }
}
