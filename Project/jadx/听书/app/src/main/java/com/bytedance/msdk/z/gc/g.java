package com.bytedance.msdk.z.gc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.wp;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.component.uy.a.g<String, Void, Bitmap> {
    private SoftReference<ImageView> g;

    public g(ImageView imageView) {
        this.g = new SoftReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
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
            wp.z(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.g.get() != null) {
                this.g.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        dl.z("download Image", "Error download Image fail...");
    }
}
