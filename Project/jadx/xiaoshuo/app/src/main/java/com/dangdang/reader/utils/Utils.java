package com.dangdang.reader.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.StatFs;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.webkit.ProxyConfig;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.utils.DateUtil;
import com.duokan.dksearch.ui.b;
import com.xiaomi.onetrack.b.e;
import com.yuewen.eq2;
import com.yuewen.kl2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class Utils {
    public static long localTime;
    public static long serverTime;

    public static String ToDBC(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (c > 65280 && c < 65375) {
                charArray[i] = (char) (c - 65248);
            }
        }
        return new String(charArray);
    }

    public static boolean checkIlleChar(String str) {
        return Pattern.compile("[.,\"\\?!:'#$%&()*+,-./:;<=>@^_`{|}~]").matcher(str).find();
    }

    public static boolean checkStr(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean compare(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str));
            calendar2.setTime(simpleDateFormat.parse(str2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.compareTo(calendar2) > 0;
    }

    public static boolean compareLong(long j, long j2) {
        return j >= j2;
    }

    public static String converCoverSize(String str) {
        if (str != null && str.length() != 0 && !str.equals(eq2.g)) {
            try {
                int iLastIndexOf = str.lastIndexOf("_");
                return str.substring(0, iLastIndexOf) + str.substring(iLastIndexOf, str.length()).replaceFirst(e.f7599a, "o");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static float converYuan(float f) {
        return f / 100.0f;
    }

    public static String converYuanTwoDecimals(float f) {
        return new DecimalFormat("0.00").format(converYuan(f));
    }

    public static String convertListToStr(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(",");
            sb.append(str);
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static int dip2px(Context context, float f) {
        float f2;
        try {
            f2 = context.getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            e.printStackTrace();
            pringLogE(" dip2px error, " + e);
            f2 = 1.0f;
        }
        return (int) ((f * f2) + 0.5f);
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String formatBell(float f) {
        return new DecimalFormat("##").format(f * 100.0f);
    }

    public static String formatEmail(String str) {
        String[] strArrSplit = str.split("@");
        int length = strArrSplit[0].length();
        StringBuffer stringBuffer = new StringBuffer();
        if (length < 3) {
            stringBuffer.append(strArrSplit[0].substring(0, 1));
            stringBuffer.append("***@" + strArrSplit[1]);
        } else if (length < 3 || length > 5) {
            String strSubstring = strArrSplit[0].substring(0, 3);
            String strSubstring2 = strArrSplit[0].substring(length - 2, length);
            stringBuffer.append(strSubstring);
            stringBuffer.append("***" + strSubstring2 + "@" + strArrSplit[1]);
        } else {
            stringBuffer.append(strArrSplit[0].substring(0, 3));
            stringBuffer.append("***@" + strArrSplit[1]);
        }
        return stringBuffer.toString();
    }

    public static String formatFileSize(long j) {
        int i = 0;
        while (j > 1024) {
            i++;
            j /= 1024;
        }
        if (i == 0) {
            return j + "B";
        }
        if (i == 1) {
            return j + "KB";
        }
        if (i == 2) {
            return j + "MB";
        }
        if (i != 3) {
            return "";
        }
        return j + "GB";
    }

    public static String formatMB(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        if (j < 1048576) {
            return decimalFormat.format(new Float(j / 1024.0f).doubleValue()) + "KB";
        }
        return decimalFormat.format(new Float(j / 1048576.0f).doubleValue()) + "MB";
    }

    public static String formatPhoneNum(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 3) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 3; i < Math.min(7, charArray.length); i++) {
            charArray[i] = '*';
        }
        return String.copyValueOf(charArray);
    }

    public static String formatPrice(float f) {
        return new DecimalFormat("#0.00").format(f);
    }

    public static String formatResourceText(String str, int i) {
        return Html.fromHtml(String.format(str, Integer.valueOf(i))).toString();
    }

    public static String getAmountNumber(long j, boolean z) {
        if (j < 10000) {
            return j + "";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        if (!z) {
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        }
        if (j >= 1000000000) {
            return decimalFormat.format(j / 1.0E8d) + "亿";
        }
        return decimalFormat.format(j / 10000.0d) + "万";
    }

    public static String getBarHostLevelTitle(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "钻石吧主" : "铂金吧主" : "黄金吧主" : "白银吧主" : "新晋吧主";
    }

    public static SpannableStringBuilder getBtnGradientSpan(String str, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new LinearGradientFontSpan(i, i2), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static float getDensity(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static LongSparseArray<String> getExterPath() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String[] strArrSplit;
        LongSparseArray<String> longSparseArray = new LongSparseArray<>();
        try {
            inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            if (!line.contains("secure") && !line.contains("asec")) {
                int i = 0;
                if (line.contains("fat")) {
                    String[] strArrSplit2 = line.split(" ");
                    if (strArrSplit2 != null) {
                        while (i < strArrSplit2.length) {
                            long jUseful = useful(strArrSplit2[i], true);
                            if (jUseful > 0) {
                                longSparseArray.put(jUseful, strArrSplit2[i]);
                            }
                            i++;
                        }
                    }
                } else if (line.contains("fuse") && (strArrSplit = line.split(" ")) != null) {
                    while (i < strArrSplit.length) {
                        long jUseful2 = useful(strArrSplit[i], true);
                        if (jUseful2 > 0) {
                            longSparseArray.put(jUseful2, strArrSplit[i]);
                        }
                        i++;
                    }
                }
            }
            return longSparseArray;
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        return longSparseArray;
    }

    public static String getFormatPrice(int i) {
        return new DecimalFormat("#0.00").format(i / 100.0f);
    }

    public static long getLastLeaveTime(Context context) {
        return 0L;
    }

    public static String getMBSize(int i) {
        int i2;
        String strValueOf = String.valueOf((i * 1.0f) / 1048576.0f);
        int iIndexOf = strValueOf.indexOf(46);
        return (iIndexOf <= -1 || (i2 = iIndexOf + 3) > strValueOf.length()) ? strValueOf : strValueOf.substring(0, i2);
    }

    public static String getNewNumber(String str, boolean z) {
        return getNewNumber(StringParseUtil.parseLong(str, 0L), z);
    }

    public static boolean getRemindState(Context context) {
        return false;
    }

    public static long getServerTime() {
        long jCurrentTimeMillis = serverTime;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - localTime;
        return jCurrentTimeMillis2 > 0 ? jCurrentTimeMillis + jCurrentTimeMillis2 : jCurrentTimeMillis;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStrSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) > 127) {
                i++;
            }
            i++;
        }
        return i;
    }

    public static String getStringByBytes(String str, int i) {
        try {
            byte[] bytes = str.getBytes("GBK");
            if (i == 0) {
                return "";
            }
            if (i == 1) {
                return bytes[0] > 0 ? str.substring(0, 1) : "";
            }
            if (bytes.length > i) {
                int i2 = i - 1;
                if (bytes[i2] > 0) {
                    str = new String(bytes, 0, i);
                } else {
                    int i3 = 0;
                    for (int i4 = i2; i4 >= 0 && bytes[i4] < 0; i4--) {
                        i3++;
                    }
                    str = i3 % 2 == 0 ? new String(bytes, 0, i, "GBK") : new String(bytes, 0, i2, "GBK");
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getStringResource(Context context, int i) {
        return context == null ? "" : context.getResources().getString(i);
    }

    public static int[] getWH(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int hasAvailable(int i, int i2, int i3) {
        LongSparseArray<String> exterPath = getExterPath();
        int size = exterPath.size();
        if (size <= 0) {
            return -1;
        }
        return exterPath.keyAt(size - 1) - ((long) i2) > ((long) i) ? 1 : 0;
    }

    public static void hideInput(Context context) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideSoftInput(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isArrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isCollEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isLimitFreeInvalidate(long j) {
        long jCurrentTimeMillis = serverTime;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        } else {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - localTime;
            if (jCurrentTimeMillis2 > 0) {
                jCurrentTimeMillis += jCurrentTimeMillis2;
            }
        }
        return j <= jCurrentTimeMillis;
    }

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("-?[0-9]*").matcher(str).matches();
    }

    public static boolean isSoftInputDisplay(View view) {
        if (view != null) {
            return ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive(view);
        }
        return false;
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isValidFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("\\");
        hashSet.add("/");
        hashSet.add(":");
        hashSet.add(ProxyConfig.MATCH_ALL_SCHEMES);
        hashSet.add("?");
        hashSet.add("\"");
        hashSet.add("<");
        hashSet.add(">");
        hashSet.add(b.e.t);
        return !hashSet.contains(str);
    }

    public static long leftTime(long j) {
        long jCurrentTimeMillis = serverTime;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        } else {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - localTime;
            if (jCurrentTimeMillis2 > 0) {
                jCurrentTimeMillis += jCurrentTimeMillis2;
            }
        }
        return j - jCurrentTimeMillis;
    }

    public static void pringLogE(String str) {
        LogM.e(Utils.class.getSimpleName(), str);
    }

    public static int px2dip(Context context, float f) {
        float f2;
        try {
            f2 = context.getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            e.printStackTrace();
            pringLogE(" px2dip error, " + e);
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static String removeEbook(String str) {
        int iLastIndexOf;
        return (str == null || !str.contains("(电子书)") || (iLastIndexOf = str.lastIndexOf("(电子书)")) <= 0) ? str : str.substring(0, iLastIndexOf);
    }

    private static void resetGetAllBuyStatus(Context context) {
    }

    private static void resetGetAllHideStatus(Context context) {
    }

    public static void resetRefreshTime(Context context) {
    }

    public static float retainDecimal(float f, int i) {
        return new BigDecimal(f).setScale(i, 4).floatValue();
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

    public static void setLastLeaveTime(Context context, long j) {
    }

    public static void setRemindState(Context context, boolean z) {
    }

    public static void setViewClickAble(View view, boolean z) {
        view.setClickable(z);
        if (z) {
            view.setAlpha(1.0f);
        } else {
            view.setAlpha(0.6f);
        }
    }

    public static void showSoftInput(final View view) {
        if (view != null) {
            view.requestFocus();
            new Timer().schedule(new TimerTask() { // from class: com.dangdang.reader.utils.Utils.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            }, 200L);
        }
    }

    public static long useful(String str, boolean z) {
        try {
            File file = new File(str);
            if (file.canWrite() && file.canRead()) {
                try {
                    File file2 = z ? new File(str, "ddReader/undefine/readbook") : new File(str);
                    if (!file2.exists() && !file2.mkdirs()) {
                        return -1L;
                    }
                    File file3 = new File(file2, System.currentTimeMillis() + "");
                    file3.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    fileOutputStream.write("a".getBytes());
                    fileOutputStream.close();
                    file3.delete();
                    if (!z) {
                        return 1L;
                    }
                    StatFs statFs = new StatFs(str);
                    long blockSize = statFs.getBlockSize();
                    long availableBlocks = statFs.getAvailableBlocks();
                    if (blockSize > 0 && availableBlocks > 0) {
                        return blockSize * availableBlocks;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return -1L;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1L;
        }
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String formatResourceText(String str, String str2) {
        return Html.fromHtml(String.format(str, str2)).toString();
    }

    public static String getFormatPrice(float f) {
        return new DecimalFormat("#0.00").format(f / 100.0f);
    }

    public static String getNewNumber(long j, boolean z) {
        if (j < 10000) {
            return j + "";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        if (!z) {
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        }
        return decimalFormat.format(j / 10000.0d) + "w";
    }

    public static String getStringByBytes(String str, int i, String str2) {
        String str3;
        String str4;
        try {
            byte[] bytes = str.getBytes("GBK");
            if (i == 0) {
                return "";
            }
            if (i == 1) {
                return bytes[0] > 0 ? str.substring(0, 1) : "";
            }
            if (bytes.length <= i) {
                return str;
            }
            int i2 = i - 1;
            if (bytes[i2] > 0) {
                str4 = new String(bytes, 0, i);
            } else {
                int i3 = 0;
                for (int i4 = i2; i4 >= 0 && bytes[i4] < 0; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    str4 = new String(bytes, 0, i, "GBK");
                } else {
                    str3 = new String(bytes, 0, i2, "GBK");
                    return str3 + str2;
                }
            }
            str3 = str4;
            return str3 + str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
