package com.dangdang.reader.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.dangdang.zframework.log.LogM;
import com.yuewen.q41;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class DangdangFileManager {
    public static String APP_DIR = "ddReader";
    public static String APP_ROOT_PATH = null;
    public static String APP_START_IMG_PATH = null;
    public static final String BD_TTS_DIR = "tts";
    private static final String BOOKNAME_SIGN = "(电子书)";
    public static final String BOOKSTORE_DIR = "bookstore";
    public static final String BOOK_CACHE;
    public static final String BOOK_DECODE_KEY = "book_decode_key";
    public static final String BOOK_DIR = "book";
    public static final long BOOK_DOWN_TIMEOUT = 3600000;
    public static final String BOOK_ENCODING = "utf-8";
    public static final String BOOK_ERROR = "book_error";
    public static final String BOOK_FINISH = "book_finish";
    public static final String BOOK_JSON = "book_json";
    public static final String BOOK_KEY = "book_key";
    public static final String BOOK_SHELF_RECOMMAND_CACHE;
    public static final String BOOK_SIZE = "book_size";
    public static final String BOOK_STORE_CACHE;
    public static final String BOOK_SUFFIX = ".epub";
    public static final String BOOK_SUFFIX_CACHE = ".epub.cache";
    public static final int BUFFER_SIZE = 10240;
    private static final String BookStore_Dir = "bookstore";
    private static final String BookStore_Zip = "bookstore.zip";
    public static final String DANGDANG_WIFI = "dangdangwifi";
    public static final String DANGDANG_WIFI_PATH = "/dangdangwifi";
    public static final String DDEPUB_DIR = "ddepub";
    public static final String DDEPUB_RES_DIR = "res";
    public static final int DEFAULT_FONTSIZE = 16;
    public static final char DELI = '|';
    public static final String ERROR_LOG_PATH;
    private static final String Ext_SDcardPath = "SECONDARY_STORAGE";
    public static final String FONT_DIR;
    public static final String FONT_EXTEN = ".zip";
    public static final String IMAGE_CACHE_DIR = "ImageCache";
    public static int IMAGE_DECODER_SIZE = 0;
    public static int IMAGE_DEFAULT_HEIGHT = 0;
    public static int IMAGE_DEFAULT_WIDTH = 0;
    public static final String ITEM_BOOK_COVER = "cover.jpg";
    public static final String ITEM_BOOK_READ_PROGRESS = "book_progress";
    public static final String LISTEN_BOOK_DIR = "ListenBook";
    public static final int MAX_LENGTH = 10240;
    public static final String OLD_ROOT_NAME = "dangdang";
    public static final String OLD_ROOT_PATH;
    public static final String PART_BOOK_DIR = "PartBook";
    public static final String PDF_RESOURCES_PATH = "plugin";
    public static final String PDF_TEMP_RESOURCES = "pdf_resources.zip";
    public static final String PLUGINAPK_NAME = "DDLightReadPlugin.apk";
    public static final String PREREAD_DIR = "preread";
    public static final String PRESET_FILENAME_CSS = "original_style.css";
    public static final String PRESET_FILENAME_DICT_XDB = "dict-gbk.xdb";
    public static final String PRESET_FILENAME_RULES = "rules.ini";
    public static final String PRE_SET_DIR;
    private static final String PreSet_DictDir = "dicts";
    private static final String PreSet_DictRule = "rules.ini";
    private static final String PreSet_DictXdb = "dict-gbk.xdb";
    private static final String PreSet_DictZip = "dicts.zip";
    private static final String PreSet_EnMonoTtf = "DroidSansMono.ttf";
    private static final String[] PreSet_EnTtf;
    private static final String PreSet_KoreaTtf = "NotoSansKR-Regular.otf";
    private static final String PreSet_ReadDir = "readfile";
    private static final String PreSet_ReadEndPageImg = "dd-f.jpg";
    private static final String PreSet_ReadZip = "readfile.zip";
    private static final String PreSet_Ttf = "default_blue_font.ttf";
    private static final String PreSet_Ttfzip = "default_blue_font.zip";
    public static final String READCOMPOSING_CACHE;
    public static final String READFILE_DIR = "readfile";
    public static final char REPLACE = '#';
    public static final String RESOURCE_DOWNLOAD_DIR = "ResourceDownload";
    public static final String ROOT_PATH;
    private static final String ReadDict = "readdict";
    public static final int STORAGE_MIN_SIZE = 15728640;
    private static final String Sdcard = "sdcard";
    public static final String TAG = "DangdangFileManager";
    public static final String UNDEFINE_DIR = "undefine";
    public static final String USER_BOOK_DIR;
    public static final String USER_READ_BOOK = "readbook";
    public static final String USER_READ_BOOK_DIR;
    public static final String USER_UNDEFINE = "undefine";
    public static final String USER_UNDEFINE_DIR;
    private static Context mContext;
    private static DangdangFileManager mFileManager;
    private static Bitmap sDefaultCover;

    public static class CompratorByLastModified implements Comparator<File> {
        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified < 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    public static class CompratorByType implements Comparator<File> {
        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            if (file.isDirectory() && file2.isDirectory()) {
                return 0;
            }
            return (file.isFile() && file2.isFile()) ? 0 : 1;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append(OLD_ROOT_NAME);
        sb.append(str);
        OLD_ROOT_PATH = sb.toString();
        ROOT_PATH = str + APP_DIR + str;
        USER_UNDEFINE_DIR = str + "undefine" + str;
        USER_READ_BOOK_DIR = USER_READ_BOOK + str;
        String str2 = "book" + str;
        USER_BOOK_DIR = str2;
        ERROR_LOG_PATH = str + "errlog" + str;
        FONT_DIR = str2 + "font" + str;
        PRE_SET_DIR = "undefine" + str + PREREAD_DIR + str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bookcache");
        sb2.append(str);
        BOOK_CACHE = sb2.toString();
        BOOK_STORE_CACHE = "storecache" + str;
        BOOK_SHELF_RECOMMAND_CACHE = "shelf_recommand" + str;
        READCOMPOSING_CACHE = "readm" + str;
        IMAGE_DECODER_SIZE = 200;
        IMAGE_DEFAULT_WIDTH = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        IMAGE_DEFAULT_HEIGHT = 480;
        mFileManager = null;
        sDefaultCover = null;
        PreSet_EnTtf = new String[]{"times.ttf", "DroidSerif-Regular.ttf"};
    }

    private DangdangFileManager() {
    }

    public static String FormetFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j < 0) {
            return "0.00B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "K";
        }
        if (j < q41.d) {
            return decimalFormat.format(j / 1048576.0d) + "M";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "G";
    }

    public static boolean checkBookJson(String str) {
        return new File(str + File.separator + BOOK_JSON).exists();
    }

    public static boolean checkMounted() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int iMin;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int iCeil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        if (i == -1) {
            iMin = 128;
        } else {
            double d3 = i;
            iMin = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? iCeil : iMin;
    }

    public static void copyAllFiles(String str, String str2) throws IOException {
        LogM.d("copyAllFiles()\nfrom=" + str + "\bto=" + str2);
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                File file2 = new File(str2 + File.separator + file.getName());
                if (file.isDirectory()) {
                    file2.mkdirs();
                    copyAllFiles(file.getAbsolutePath(), file2.getAbsolutePath());
                } else if (file.canRead()) {
                    file2.getParentFile().mkdirs();
                    byte[] bArr = new byte[1024];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    for (int i = fileInputStream.read(bArr); i != -1; i = fileInputStream.read(bArr)) {
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        if (file.isFile() && file.exists()) {
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            for (int i = fileInputStream.read(bArr); i != -1; i = fileInputStream.read(bArr)) {
                fileOutputStream.write(bArr, 0, i);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (z) {
                file.delete();
            }
        }
    }

    public static void deleteBook(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.exists()) {
                recurrenceDeleteFile(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBookmark(Context context, String str) {
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file == null) {
            return false;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static File getApkFile(String str, String str2) {
        File file = new File(str, str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static String getAppApkDir() {
        String str = APP_ROOT_PATH + "/apk/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getAppRomDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append(APP_DIR);
        sb.append(str);
        return sb.toString();
    }

    public static Bitmap getBitmap(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            LogM.e(TAG, "bitmap decoder failed");
            return null;
        }
    }

    public static File getBookKey(String str) {
        return new File(str + File.separator + BOOK_KEY);
    }

    public static String getBookNameFromPath(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        return strSubstring.lastIndexOf(Consts.DOT) != -1 ? strSubstring.substring(0, strSubstring.lastIndexOf(Consts.DOT)) : strSubstring;
    }

    public static String getBookNameWithoutSuffix(String str) {
        int iLastIndexOf = str.lastIndexOf(BOOKNAME_SIGN);
        return iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : str;
    }

    public static final int getBookSize(String str) {
        File file = new File(str + File.separator + BOOK_SIZE);
        if (file.exists()) {
            return stringToInt(getStringFromFile(file), 0);
        }
        return -1;
    }

    public static String getBookStoreBaseDir() {
        return getPreSetFile().toString() + File.separator + "bookstore";
    }

    public static String getBookStoreDir() {
        return getPreSetFile().toString() + File.separator;
    }

    public static Bitmap getBootBitmap() {
        if (!new File(getBootBitmapPath()).exists()) {
            return null;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(getBootBitmapPath());
        if (bitmapDecodeFile.getWidth() <= IMAGE_DEFAULT_WIDTH || bitmapDecodeFile.getHeight() <= IMAGE_DEFAULT_HEIGHT) {
            return null;
        }
        return bitmapDecodeFile;
    }

    public static String getBootBitmapPath() {
        File file = new File(getAppRomDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        return getAppRomDir() + "boot_bitmap";
    }

    public static int getBottomHeight() {
        return Utils.dip2px(getContext(), 60.0f);
    }

    public static byte[] getBytesFromFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            close(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bytesFromStream = StreamUtils.getBytesFromStream(fileInputStream);
                close(fileInputStream);
                return bytesFromStream;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                close(fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            close(fileInputStream);
            return null;
        }
    }

    public static Bitmap getClipBitmap(String str, int i, int i2) {
        Bitmap bitmap = getBitmap(str, i, i2);
        if (bitmap == null) {
            return bitmap;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        try {
            try {
                return Bitmap.createBitmap(bitmap, width / 7, 0, (width * 5) / 7, height);
            } catch (OutOfMemoryError unused) {
                LogM.w(TAG, "bitmap decoder failed");
                bitmap.recycle();
                return null;
            }
        } finally {
            bitmap.recycle();
        }
    }

    private static Context getContext() {
        return mContext;
    }

    public static String getCoverPath(String str, String str2) {
        return null;
    }

    public static long getDownLoadStart(String str, String str2) {
        File file = new File(str + File.separator + str2 + BOOK_SUFFIX);
        if (file.exists()) {
            return file.length();
        }
        try {
            file.createNewFile();
            return 0L;
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static final int getEpubBookSize(String str, String str2) {
        File file = new File(str + File.separator + str2 + BOOK_SUFFIX);
        if (file.exists()) {
            return (int) file.length();
        }
        return -1;
    }

    public static String getExtSdcardPath() {
        Map<String, String> map = System.getenv();
        String str = null;
        try {
            if (map.containsKey(Ext_SDcardPath)) {
                String[] strArrSplit = map.get(Ext_SDcardPath).split(":");
                str = strArrSplit[0];
                if (!str.toLowerCase().contains(Sdcard)) {
                    int length = strArrSplit.length;
                    for (int i = 0; i < length; i++) {
                        if (strArrSplit[i].contains(Sdcard)) {
                            str = strArrSplit[i];
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getExternalFilesDir() {
        if (!checkMounted()) {
            return getAppRomDir();
        }
        return getContext().getExternalFilesDir(null) + File.separator;
    }

    public static synchronized DangdangFileManager getFileManagerInstance() {
        if (mFileManager == null) {
            mFileManager = new DangdangFileManager();
        }
        return mFileManager;
    }

    public static final String getFileSize(File file) {
        return file.exists() ? FormetFileSize(file.length()) : "0.00K";
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0097 A[PHI: r0
  0x0097: PHI (r0v34 java.lang.String) = (r0v32 java.lang.String), (r0v33 java.lang.String) binds: [B:35:0x0095, B:38:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileType(java.io.File r2) {
        /*
            java.lang.String r2 = r2.getName()
            java.lang.String r0 = "."
            int r0 = r2.lastIndexOf(r0)
            int r0 = r0 + 1
            int r1 = r2.length()
            java.lang.String r2 = r2.substring(r0, r1)
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r0 = "m4a"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "mp3"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "mid"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "xmf"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "ogg"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lab
            java.lang.String r0 = "wav"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L4a
            goto Lab
        L4a:
            java.lang.String r0 = "3gp"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto La8
            java.lang.String r0 = "mp4"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L5b
            goto La8
        L5b:
            java.lang.String r0 = "jpg"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto La5
            java.lang.String r0 = "gif"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto La5
            java.lang.String r0 = "png"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto La5
            java.lang.String r0 = "jpeg"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto La5
            java.lang.String r0 = "bmp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L84
            goto La5
        L84:
            java.lang.String r0 = "txt"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L8f
            java.lang.String r2 = "text"
            goto Lad
        L8f:
            java.lang.String r0 = "pdf"
            boolean r1 = r2.equals(r0)
            if (r1 == 0) goto L99
        L97:
            r2 = r0
            goto Lad
        L99:
            java.lang.String r0 = "epub"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto La2
            goto L97
        La2:
            java.lang.String r2 = "*"
            goto Lad
        La5:
            java.lang.String r2 = "image"
            goto Lad
        La8:
            java.lang.String r2 = "video"
            goto Lad
        Lab:
            java.lang.String r2 = "audio"
        Lad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = "/*"
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.reader.utils.DangdangFileManager.getFileType(java.io.File):java.lang.String");
    }

    public static File getFontDownloadSaveFile(String str, String str2) {
        File file = new File(str, str2 + FONT_EXTEN);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static final long getImportBookSize(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return -1L;
    }

    public static final JSONObject getJsonObject(String str) {
        File file = new File(str + File.separator + BOOK_JSON);
        if (file.exists()) {
            try {
                return new JSONObject(getStringFromFile(file));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getListenBookDir(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getExternalFilesDir());
        sb.append(LISTEN_BOOK_DIR);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        String string = sb.toString();
        File file = new File(string);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        return string + str2;
    }

    public static String getPreSetBookStoreZip() {
        return getPreSetFile().toString() + File.separator + BookStore_Zip;
    }

    public static String getPreSetDictRule() {
        return getPreSetReadDir() + File.separator + "rules.ini";
    }

    public static String getPreSetDictXdb() {
        return getPreSetReadDir() + File.separator + "dict-gbk.xdb";
    }

    public static String getPreSetEnMonoTTF() {
        return getPreSetReadDir() + File.separator + PreSet_EnMonoTtf;
    }

    public static String[] getPreSetEnTTF() {
        String[] strArr = PreSet_EnTtf;
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = getPreSetReadDir() + File.separator + strArr[i];
        }
        return strArr2;
    }

    public static File getPreSetFile() {
        File file = new File(getContext().getFilesDir() + File.separator + PRE_SET_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getPreSetKoreaTTF() {
        return getPreSetReadDir() + File.separator + PreSet_KoreaTtf;
    }

    public static String getPreSetReadDir() {
        return getPreSetFile().toString() + File.separator + "readfile";
    }

    public static String getPreSetReadEndPageImg() {
        return getPreSetFile().toString() + File.separator + PreSet_ReadEndPageImg;
    }

    public static String getPreSetReadZip() {
        return getPreSetFile().toString() + File.separator + PreSet_ReadZip;
    }

    public static String getPreSetTTF() {
        return getPreSetReadDir() + File.separator + PreSet_Ttf;
    }

    public static String getPresetReadfileDir() {
        String appRomDir = getAppRomDir();
        StringBuilder sb = new StringBuilder();
        sb.append(appRomDir);
        sb.append("undefine");
        String str = File.separator;
        sb.append(str);
        sb.append("readfile");
        sb.append(str);
        return sb.toString();
    }

    public static String getRandomStr() {
        return (((int) (Math.random() * 4.0d)) + 1) + "";
    }

    public static String getReadCssPath() {
        return getPresetReadfileDir() + PRESET_FILENAME_CSS;
    }

    public static String getReadDictXDBPath() {
        return getPresetReadfileDir() + "dict-gbk.xdb";
    }

    public static String getReadRulesPath() {
        return getPresetReadfileDir() + "rules.ini";
    }

    public static String getRootPathOnPhone(Context context) {
        return context.getFilesDir().getAbsolutePath() + OLD_ROOT_PATH;
    }

    public static Bitmap getStartPageBitmap(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile.getWidth() <= IMAGE_DEFAULT_WIDTH) {
                return null;
            }
            if (bitmapDecodeFile.getHeight() > IMAGE_DEFAULT_HEIGHT) {
                return bitmapDecodeFile;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Drawable getStartPageDrawable(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile.getWidth() <= IMAGE_DEFAULT_WIDTH || bitmapDecodeFile.getHeight() <= IMAGE_DEFAULT_HEIGHT) {
                return null;
            }
            return new BitmapDrawable(bitmapDecodeFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:22:0x002b */
    public static String getStringFromFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = null;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                close(closeable2);
                throw th;
            }
            try {
                String str = new String(StreamUtils.getBytesFromStream(fileInputStream), "utf-8");
                close(fileInputStream);
                return str;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                close(fileInputStream);
                return null;
            } catch (UnsupportedEncodingException e4) {
                e = e4;
                e.printStackTrace();
                close(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            close(closeable2);
            throw th;
        }
    }

    public static String getSystemCachePath() {
        return getContext().getCacheDir().getAbsolutePath();
    }

    public static Uri getUriFromFile(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
    }

    public static boolean hasDownloadFinish(String str) {
        return new File(str + File.separator + BOOK_FINISH).exists();
    }

    public static void initSdkMode(Context context) {
        getFileManagerInstance().setContext(context);
        APP_ROOT_PATH = "/data/data/" + context.getPackageName();
        APP_DIR = "ddReaderSdk";
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static boolean isFileHasChild(String str) {
        File file = new File(str);
        return file.exists() && file.list() != null && file.list().length > 0;
    }

    public static boolean isReadBook(String str) {
        if (str == null) {
            return true;
        }
        int iLastIndexOf = str.lastIndexOf(USER_READ_BOOK);
        if (iLastIndexOf > 0) {
            return new File(str.substring(0, iLastIndexOf + 8)).isDirectory();
        }
        return false;
    }

    public static boolean isReadExists() {
        File file = new File(getPreSetReadDir());
        File[] fileArrListFiles = file.listFiles();
        return file.exists() && fileArrListFiles != null && fileArrListFiles.length >= 9;
    }

    public static void moveAllFiles(String str, String str2) {
        try {
            copyAllFiles(str, str2);
        } catch (IOException e) {
            LogM.e("ERROR", "moveAllFiles()\n" + e.toString());
        }
        recurrenceDeleteFile(new File(str));
    }

    public static void recurrenceDeleteFile(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                recurrenceDeleteFile(file2);
            }
        }
        file.delete();
    }

    public static boolean saveBookJson(String str, String str2) {
        File file = new File(str + File.separator + BOOK_JSON);
        if (file.exists() || str2 == null) {
            return true;
        }
        return writeStringToFile(str2, file);
    }

    public static void saveFile(Bitmap bitmap, File file) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(byteArray, 0, byteArray.length);
                        closeStream(fileOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        LogM.d("save", "saveFile  error");
                        e.printStackTrace();
                        closeStream(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        closeStream(fileOutputStream);
                        closeStream(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        closeStream(byteArrayOutputStream);
    }

    public static int stringToInt(String str, int i) {
        if (str == null) {
            return i;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return i;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String switchDateToStr(Date date) {
        return (date.getMonth() + 1) + "/" + date.getDate();
    }

    public static boolean writeDataToFile(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    close(fileOutputStream2);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    close(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (UnsupportedEncodingException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void writeDownLoadSize(String str, int i) {
        File file = new File(str + File.separator + BOOK_SIZE);
        if (file.exists()) {
            file.delete();
        }
        writeStringToFile(String.valueOf(i), file);
    }

    public static void writeDownloadFinishFile(String str) {
        File file = new File(str + File.separator + BOOK_FINISH);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean writeStringToFile(String str, File file) {
        try {
            return writeDataToFile(str.getBytes("utf-8"), file);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean writeUTF8ToFile(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(new String(bArr, "utf-8").getBytes("utf-8"));
                    fileOutputStream2.flush();
                    close(fileOutputStream2);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    close(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (UnsupportedEncodingException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean copyFilesFromAssets(Context context, String str, File file) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public static String getCoverPath(String str) {
        if (str == null) {
            return null;
        }
        return str + File.separator + ITEM_BOOK_COVER;
    }

    public static boolean writeStringToFile(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        DataInputStream dataInputStream = null;
        try {
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists() || !parentFile.isDirectory()) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    DataInputStream dataInputStream2 = new DataInputStream(inputStream);
                    try {
                        byte[] bArr = new byte[10240];
                        for (int i = dataInputStream2.read(bArr); i > 0; i = dataInputStream2.read(bArr)) {
                            fileOutputStream.write(bArr, 0, i);
                            fileOutputStream.flush();
                        }
                        close(dataInputStream2);
                        close(fileOutputStream);
                        return true;
                    } catch (FileNotFoundException e) {
                        e = e;
                        dataInputStream = dataInputStream2;
                        e.printStackTrace();
                        close(dataInputStream);
                        close(fileOutputStream);
                        return false;
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        dataInputStream = dataInputStream2;
                        e.printStackTrace();
                        close(dataInputStream);
                        close(fileOutputStream);
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        dataInputStream = dataInputStream2;
                        e.printStackTrace();
                        close(dataInputStream);
                        close(fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        close(dataInputStream);
                        close(fileOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (UnsupportedEncodingException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (UnsupportedEncodingException e8) {
                e = e8;
                fileOutputStream = null;
            } catch (IOException e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
