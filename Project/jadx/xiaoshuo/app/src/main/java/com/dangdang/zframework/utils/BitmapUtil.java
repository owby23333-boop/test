package com.dangdang.zframework.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.os.Environment;
import android.widget.ScrollView;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.dangdang.zframework.view.DDWebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public class BitmapUtil {
    public static BitmapDrawable LoadBackgroundResource(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenRawResource, null, options);
        try {
            inputStreamOpenRawResource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BitmapDrawable(context.getResources(), bitmapDecodeStream);
    }

    public static Bitmap compressBitmap(Bitmap bitmap, String str, String str2, boolean z) {
        try {
            if (str2.equals(str)) {
                if (!str2.equals(str) && !bitmap.isRecycled() && z) {
                    bitmap.recycle();
                }
                return bitmap;
            }
            String[] strArrSplit = str2.split("\\*");
            if (strArrSplit != null && strArrSplit.length >= 2) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), false);
                if (!str2.equals(str) && !bitmap.isRecycled() && z) {
                    bitmap.recycle();
                }
                return bitmapCreateScaledBitmap;
            }
            if (!str2.equals(str) && !bitmap.isRecycled() && z) {
                bitmap.recycle();
            }
            return null;
        } catch (OutOfMemoryError unused) {
            if (!str2.equals(str) && !bitmap.isRecycled() && z) {
                bitmap.recycle();
            }
            return null;
        } catch (Throwable th) {
            if (!str2.equals(str) && !bitmap.isRecycled() && z) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static void deleteFile(File file) {
        if (Environment.getExternalStorageState().equals("mounted") && file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    public static Bitmap getBitmapByPathAndScale(String str, int i) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapByScrollview(ScrollView scrollView) {
        Bitmap bitmapCreateBitmap = null;
        if (scrollView == null) {
            return null;
        }
        int height = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            try {
                height += scrollView.getChildAt(i).getHeight();
            } catch (Exception e) {
                e.printStackTrace();
                return bitmapCreateBitmap;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmapCreateBitmap;
            }
        }
        if (scrollView.getWidth() <= 0 || height <= 0) {
            return null;
        }
        bitmapCreateBitmap = Bitmap.createBitmap(scrollView.getWidth(), height, Bitmap.Config.RGB_565);
        scrollView.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap getBitmapByWebView(DDWebView dDWebView) {
        Bitmap bitmapCreateBitmap = null;
        if (dDWebView == null) {
            return null;
        }
        try {
            Picture pictureCapturePicture = dDWebView.capturePicture();
            if (pictureCapturePicture.getWidth() <= 0 || pictureCapturePicture.getHeight() <= 0) {
                return null;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.RGB_565);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    public static Bitmap getBtimap(File file) throws FileNotFoundException {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inJustDecodeBounds = false;
        int i = (int) (options.outHeight / options.outWidth);
        if (i <= 0) {
            i = 1;
        }
        options.inSampleSize = i;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static int[] getDecodeBounds(Context context, int i) {
        if (context == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static boolean isAvailable(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static int readBitmapDegree(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = Opcodes.GETFIELD;
            } else if (attributeInt == 6) {
                i = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int readPictureDegree(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = Opcodes.GETFIELD;
            } else if (attributeInt == 6) {
                i = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void recycle(Bitmap bitmap) {
        if (isAvailable(bitmap)) {
            try {
                bitmap.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void revitionImageSize(int i, File file) throws IOException {
        Bitmap bitmapDecodeStream;
        FileInputStream fileInputStream = new FileInputStream(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, null, options);
        fileInputStream.close();
        int i2 = 0;
        while (true) {
            if ((options.outWidth >> i2) <= i && (options.outHeight >> i2) <= i) {
                break;
            } else {
                i2++;
            }
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        options.inSampleSize = (int) Math.pow(2.0d, i2);
        options.inJustDecodeBounds = false;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
        } catch (OutOfMemoryError unused) {
            options.inSampleSize *= 2;
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
        }
        fileInputStream2.close();
        if (bitmapDecodeStream == null) {
            throw new IOException("Bitmap decode error!");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String str = options.outMimeType;
        if (str == null || !str.contains("png")) {
            bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
        } else {
            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        }
        fileOutputStream.close();
        bitmapDecodeStream.recycle();
    }

    public static Bitmap rotaingBitmap(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap rotaingImage(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static boolean saveBitamp(Bitmap bitmap, File file) {
        return saveBitamp(bitmap, file, 70);
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static boolean saveBitamp(Bitmap bitmap, File file, int i) throws Throwable {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream2)) {
                        fileOutputStream2.flush();
                    }
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        return getRoundedCornerBitmap(bitmap, bitmap.getWidth() / 2);
    }
}
