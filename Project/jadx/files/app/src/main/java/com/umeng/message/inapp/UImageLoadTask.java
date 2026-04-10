package com.umeng.message.inapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class UImageLoadTask extends AsyncTask<String, Void, Bitmap[]> {
    private static final String a = UImageLoadTask.class.getName();
    private ImageLoaderCallback b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitmapFactory.Options f20296d;

    public interface ImageLoaderCallback {
        void onLoadImage(Bitmap[] bitmapArr);
    }

    public UImageLoadTask(Context context, UInAppMessage uInAppMessage) {
        this.f20295c = l.a(context, uInAppMessage.msg_id);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            this.f20296d = new BitmapFactory.Options();
            this.f20296d.inSampleSize = a(uInAppMessage, i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private Bitmap b(String str) {
        Bitmap bitmapDecodeFile = null;
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(this.f20295c + (str.hashCode() + ""));
            UMLog.mutlInfo(a, 2, "load from local");
            return bitmapDecodeFile;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bitmapDecodeFile;
        }
    }

    private Bitmap c(String str) throws IOException {
        Bitmap bitmapDecodeStream;
        UMLog.mutlInfo(a, 2, "Downloading image start");
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        uRLConnectionOpenConnection.connect();
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        if (this.f20296d == null) {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        } else {
            UMLog.mutlInfo(a, 2, "decode options");
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, this.f20296d);
        }
        inputStream.close();
        UMLog.mutlInfo(a, 2, "Downloading image finish");
        return bitmapDecodeStream;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap[] doInBackground(String... strArr) {
        Bitmap[] bitmapArr = new Bitmap[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                if (a(strArr[i2])) {
                    bitmapArr[i2] = b(strArr[i2]);
                } else {
                    bitmapArr[i2] = b(strArr[i2]);
                    if (bitmapArr[i2] == null) {
                        bitmapArr[i2] = c(strArr[i2]);
                        a(bitmapArr[i2], strArr[i2]);
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return bitmapArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap[] bitmapArr) {
        super.onPostExecute(bitmapArr);
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap == null) {
                return;
            }
        }
        ImageLoaderCallback imageLoaderCallback = this.b;
        if (imageLoaderCallback != null) {
            imageLoaderCallback.onLoadImage(bitmapArr);
        }
    }

    private boolean a(String str) {
        return new File(this.f20295c, str.hashCode() + "").exists();
    }

    private void a(Bitmap bitmap, String str) {
        boolean z2;
        boolean zCompress;
        if (bitmap == null) {
            return;
        }
        try {
            File file = new File(this.f20295c);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f20295c, str.hashCode() + ""));
            zCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                z2 = zCompress;
                e = e2;
                e.printStackTrace();
                zCompress = z2;
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        }
        UMLog.mutlInfo(a, 2, "store bitmap" + zCompress);
    }

    private static int a(UInAppMessage uInAppMessage, int i2, int i3) {
        int i4 = uInAppMessage.height;
        int i5 = uInAppMessage.width;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public void a(ImageLoaderCallback imageLoaderCallback) {
        this.b = imageLoaderCallback;
    }
}
