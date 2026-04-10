package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class a extends AsyncTask<String, Void, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoftReference<ImageView> f2402a;

    public a(ImageView imageView) {
        this.f2402a = new SoftReference<>(imageView);
    }

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

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {
            MediationApiLog.i("download Image", "Error download Image fail...");
        } else if (this.f2402a.get() != null) {
            this.f2402a.get().setImageBitmap(bitmap);
        }
    }
}
