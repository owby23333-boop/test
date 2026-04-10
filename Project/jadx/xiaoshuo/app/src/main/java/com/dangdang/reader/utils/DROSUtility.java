package com.dangdang.reader.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.utils.DRUiUtility;
import com.dangdang.zframework.utils.DateUtil;
import com.xiaomi.ad.y;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.eq2;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes10.dex */
public final class DROSUtility {
    public static final String ACTION_DEL_ALL_IMAGE_CACHE = "com.dangdang.reader_delImageCache";
    public static final String TAG = "DROSUtility";
    private static DROSUtility mOSUtility = null;
    private static int mTestId = 1900000000;

    public static class RemoveFile implements Runnable {
        private Context mContext;
        private String mFileName;
        private boolean mSend;

        public RemoveFile(Context context, String str, boolean z) {
            this.mContext = context;
            this.mFileName = str;
            this.mSend = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zRemoveFile = DROSUtility.removeFile(this.mFileName);
            if (zRemoveFile && this.mContext != null && this.mSend) {
                Intent intent = new Intent();
                intent.setAction(DROSUtility.ACTION_DEL_ALL_IMAGE_CACHE);
                this.mContext.sendBroadcast(intent);
            }
            LogM.w(DROSUtility.TAG, "removeFile" + zRemoveFile);
        }

        public void start() {
            new Thread(this).start();
        }
    }

    private DROSUtility() {
    }

    public static boolean checkEbook(String str) {
        return Integer.parseInt(str) > mTestId;
    }

    public static boolean checkHeapSize(int i, int i2) {
        if (Debug.getNativeHeapSize() > i2 * i * 4) {
            return true;
        }
        LogM.e("wyz Heap size too small");
        return false;
    }

    public static Bitmap clipBitmap(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        try {
            try {
                return Bitmap.createBitmap(bitmap, (width * 3) / 20, 0, (width * 14) / 20, height);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                bitmap.recycle();
                return null;
            }
        } finally {
            bitmap.recycle();
        }
    }

    public static String getCssPath() {
        return DangdangFileManager.APP_ROOT_PATH + "/EpubCss/";
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getEpubCssPath() {
        String cssPath = getCssPath();
        File file = new File(cssPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return cssPath;
    }

    public static String getMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "");
        } catch (NoSuchAlgorithmException e) {
            LogM.e(TAG, "getMd5" + e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized DROSUtility getOSUtilityInstance() {
        if (mOSUtility == null) {
            mOSUtility = new DROSUtility();
        }
        return mOSUtility;
    }

    public static String getPermanentId(Context context) {
        SharedPreferences preferences = new ConfigManager(context.getApplicationContext()).getPreferences();
        String str = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_4).format(new Date());
        LogM.i("getPermanentId", "getPermanentId.year=" + str);
        if (!str.equals(preferences.getString("init_permanentId", str))) {
            return preferences.getString("init_permanentId", str);
        }
        String str2 = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST);
        LogM.d(TAG, "permanentId=:" + str2);
        SharedPreferences.Editor editorEdit = preferences.edit();
        editorEdit.putString("init_permanentId", str2);
        editorEdit.commit();
        return str2;
    }

    public static String getPicUrl(String str, String str2) {
        return str2 == null ? getPicUrl(str) : getPicUrl(str);
    }

    public static String getPicUrlAsOriginal(String str, String str2) {
        return str2 == null ? getPicUrlAsOriginal(str) : getPicUrlAsOriginal(str);
    }

    public static String getPrice(String str) {
        if (str == null) {
            str = "";
        }
        String strTrim = (eq2.g.equals(str) ? "" : str).trim();
        if (strTrim.length() == 0) {
            return "0";
        }
        if (strTrim.length() == 1) {
            return "0.0" + strTrim;
        }
        if (strTrim.length() == 2) {
            return "0." + strTrim;
        }
        int length = strTrim.length();
        StringBuilder sb = new StringBuilder();
        int i = length - 2;
        sb.append(strTrim.substring(0, i));
        sb.append(Consts.DOT);
        sb.append(strTrim.substring(i, length));
        return sb.toString();
    }

    public static int getRandomInt(int i, int i2) {
        return ((int) (Math.random() * ((double) ((i2 - i) + 1)))) + i;
    }

    public static boolean isConnect(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception e) {
            Log.v("error", e.toString());
            return false;
        }
    }

    public static boolean removeFile(String str) {
        boolean zDelete;
        File file = new File(str);
        if (file.isDirectory()) {
            for (String str2 : file.list()) {
                removeFile(str + "/" + str2);
            }
            zDelete = file.delete();
        } else {
            zDelete = file.delete();
            if (!zDelete) {
                LogM.w(TAG, "removeFile" + file.getName());
            }
        }
        if (zDelete) {
            return true;
        }
        LogM.w(TAG, "removeFile" + file.getName());
        return true;
    }

    public static void share(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        context.startActivity(Intent.createChooser(intent, ""));
    }

    private static String toHexString(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(Integer.toHexString(b2 & 255));
            sb.append(str);
        }
        return sb.toString();
    }

    public static String getPicUrl(String str, String str2, String str3) {
        String str4 = "";
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!str2.contains("_epub")) {
            return str2;
        }
        String strSubstring = str2.substring(0, str2.indexOf("_epub") - 1);
        String strSubstring2 = str2.substring(str2.indexOf("_epub"), str2.length());
        if (ImageConfig.IMAGE_SIZE_LL.equals(str3)) {
            str4 = "d";
        } else if (ImageConfig.IMAGE_SIZE_BB.equals(str3)) {
            str4 = y.j;
        }
        return strSubstring + str4 + strSubstring2;
    }

    public static String getPicUrlAsOriginal(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer("http://img3");
            int i = Integer.parseInt(str);
            stringBuffer.append("" + (i % 10) + ".ddimg.cn/");
            stringBuffer.append("" + (i % 99) + "/");
            stringBuffer.append("" + (i % 37) + "/");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            stringBuffer.append(sb.toString());
            stringBuffer.append("-1");
            stringBuffer.append("_o.jpg");
            return stringBuffer.toString();
        } catch (Exception e) {
            LogM.e(e.toString());
            return "";
        }
    }

    public static String getPicUrl(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer("http://img3");
            int i = Integer.parseInt(str);
            stringBuffer.append("" + (i % 10) + ".ddimg.cn/");
            stringBuffer.append("" + (i % 99) + "/");
            stringBuffer.append("" + (i % 37) + "/");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            stringBuffer.append(sb.toString());
            stringBuffer.append("-1");
            if (DRUiUtility.getDensity() >= 2.0f) {
                stringBuffer.append("_b.jpg");
            } else {
                stringBuffer.append("_l.jpg");
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            LogM.e(e.toString());
            return "";
        }
    }
}
