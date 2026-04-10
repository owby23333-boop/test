package com.ss.android.socialbase.downloader.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ttmd5.TTMd5;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadUtils {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static final String ETAG = "Etag";
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String TAG = "DownloadUtils";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    private static ConnectivityManager connectivityManager;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String sCurProcessName = null;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap = new SparseArray<>();
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners = new SparseArray<>();
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = null;
    private static Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = null;

    public static List<HttpHeader> add0_0RangeHeader(List<HttpHeader> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader("If-Match", str));
        }
        arrayList.add(new HttpHeader("Accept-Encoding", "identity"));
        arrayList.add(new HttpHeader("Range", "bytes=0-0"));
        return arrayList;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, DownloadChunk downloadChunk) {
        return addRangeHeader(list, str, downloadChunk.getCurOffset(), downloadChunk.getEndOffset());
    }

    public static void addTTNetProtectTimeout(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static void addThrottleNetSpeed(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(throttleNetSpeed)));
        }
    }

    public static double byteToMb(long j2) {
        double d2 = j2;
        Double.isNaN(d2);
        return d2 / 1048576.0d;
    }

    public static boolean cacheExpired(DownloadInfo downloadInfo) {
        boolean z2 = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            Logger.d(TAG, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z2 = true;
            }
        } else {
            Logger.d(TAG, "dcache::last modify is emtpy, so just return cache");
        }
        Logger.d(TAG, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z2);
        return z2;
    }

    public static boolean canAcceptPartial(int i2, String str) {
        if (DownloadExpSwitchCode.isSwitchEnable(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static boolean canChunkDowngradeRetry(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static int checkMd5Status(String str, String str2, String str3) {
        return TTMd5.checkMd5(str3, new File(str, str2));
    }

    public static boolean checkMd5Valid(String str, String str2, String str3) {
        return isMd5Valid(checkMd5Status(str, str2, str3));
    }

    public static boolean checkPermission(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static void clearAntiHijackDir(DownloadInfo downloadInfo) {
        DownloadSetting downloadSettingObtain;
        JSONObject jSONObjectOptJSONObject;
        if (downloadInfo == null || (jSONObjectOptJSONObject = (downloadSettingObtain = DownloadSetting.obtain(downloadInfo.getId())).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (!TextUtils.isEmpty(strOptString)) {
            deleteFile(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String redirectSavePath = getRedirectSavePath(title, downloadSettingObtain);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(redirectSavePath) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(redirectSavePath);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            deleteDirIfEmpty(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static ListenerType convertListenerType(int i2) {
        return i2 == ListenerType.SUB.ordinal() ? ListenerType.SUB : i2 == ListenerType.NOTIFICATION.ordinal() ? ListenerType.NOTIFICATION : ListenerType.MAIN;
    }

    public static boolean copyFile(File file, File file2) throws BaseException {
        return copyFile(file, file2, true);
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str2 = "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath();
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!copyFile(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static long cost(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean zMkdirs = false;
        if (file.exists() && file.isDirectory()) {
            throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (file2.exists()) {
                        file2.delete();
                        if (file2.mkdirs() || file2.exists()) {
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:" + str);
                        }
                        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + str);
                    }
                    if (!file2.mkdirs() && !file2.exists()) {
                        if (DownloadSetting.obtain(downloadInfo).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + str);
                        }
                        int i3 = 0;
                        while (!zMkdirs) {
                            int i4 = i3 + 1;
                            if (i3 >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                zMkdirs = file2.mkdirs();
                                i3 = i4;
                            } catch (InterruptedException unused) {
                            }
                        }
                        if (!zMkdirs) {
                            if (getAvailableSpaceBytes(downloadInfo.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + str);
                            }
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + str);
                        }
                    }
                }
                file.createNewFile();
            } catch (IOException e2) {
                throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, e2);
            }
        }
        return new RandomAccessOutputStream(file, i2);
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo) {
        deleteAllDownloadFiles(downloadInfo, true);
    }

    private static boolean deleteDirIfEmpty(String str) {
        String str2 = "deleteDirIfEmpty on thread: " + Thread.currentThread();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static void deleteFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = "deleteFile: " + str + "/" + str2;
            file.delete();
        }
    }

    @TargetApi(19)
    private static void doCopyFile(File file, File file2, boolean z2) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j2 = 0;
                        while (j2 < size) {
                            long j3 = size - j2;
                            long jTransferFrom = channel2.transferFrom(channel, j2, j3 > FILE_COPY_BUFFER_SIZE ? 31457280L : j3);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j2 += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z2) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static void ensureDirExists(String str) {
        if (str == null) {
            return;
        }
        ensureDirExists(new File(str));
    }

    public static String generateDistinctDirectory(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strMd5Hex = md5Hex(str2);
        return (TextUtils.isEmpty(strMd5Hex) || str.contains(strMd5Hex)) ? str : new File(str, strMd5Hex).getAbsolutePath();
    }

    public static long getAvailableSpaceBytes(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e2) {
            throw new BaseException(DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, e2);
        } catch (Throwable th) {
            throw new BaseException(DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, th);
        }
    }

    public static boolean getBoolean(Object obj, boolean z2) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z2;
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 != null) {
            return connectivityManager2;
        }
        ConnectivityManager connectivityManager3 = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager = connectivityManager3;
        return connectivityManager3;
    }

    public static long getContentLength(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Length");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase) && DownloadExpSwitchCode.isSwitchEnable(1)) {
            return parseContentLengthFromContentRange(iDownloadHeadHttpConnection);
        }
        try {
            return Long.parseLong(respHeadFieldIgnoreCase);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long getCurByte(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z2 = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (!z2) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk == null || chunkCount != downloadChunk.size()) {
            return 0L;
        }
        return getTotalOffset(downloadChunk);
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        sCurProcessName = getCurProcessNameByApplication();
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameByActivityThread();
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameByActivityManager(context);
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        sCurProcessName = getCurProcessNameFromProc();
        return sCurProcessName;
    }

    private static String getCurProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (Logger.debug()) {
                            Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static String getCurProcessNameByActivityThread() {
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            String str2 = (String) objInvoke;
            try {
                if (!TextUtils.isEmpty(str2) && Logger.debug()) {
                    Logger.d("Process", "processName = " + str2);
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                str = str2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        th.printStackTrace();
        return str;
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && Logger.debug()) {
                Logger.d("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = bufferedReader.read();
                    if (i2 <= 0) {
                        break;
                    }
                    sb.append((char) i2);
                }
                if (Logger.debug()) {
                    Logger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                safeClose(bufferedReader);
                return string;
            } catch (Throwable unused) {
                safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static File getDatabaseFile(Context context, boolean z2, String str) {
        String externalStorageState = "";
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File externalDBFile = (z2 && "mounted".equals(externalStorageState) && hasExternalStoragePermission(context)) ? getExternalDBFile(str) : null;
        if (externalDBFile == null) {
            externalDBFile = context.getDatabasePath(str);
        }
        if (externalDBFile != null) {
            return externalDBFile;
        }
        return new File("/data/data/" + context.getPackageName() + "/database/", str);
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir(), true);
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveTempDir(), false);
    }

    public static String getEncodedStr(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String getErrorMsgWithTagPrefix(Throwable th, String str) {
        if (str == null) {
            return getThrowableMsg(th);
        }
        return str + "-" + getThrowableMsg(th);
    }

    private static File getExternalDBFile(String str) {
        File externalFilesDir;
        if (!isSdcardAvailable() || !isSdcardWritable()) {
            return null;
        }
        try {
            externalFilesDir = DownloadComponentManager.getAppContext().getExternalFilesDir("database" + File.separator + str);
        } catch (Exception e2) {
            e = e2;
            externalFilesDir = null;
        }
        if (externalFilesDir == null) {
            return null;
        }
        try {
            if (!externalFilesDir.exists()) {
                externalFilesDir.createNewFile();
            }
            if (Logger.debug()) {
                Logger.d(TAG, "download db path:" + externalFilesDir.getAbsolutePath());
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        return externalFilesDir;
    }

    public static File getExternalDownloadPath() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static String getFileNameFromConnection(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        String contentDisposition = parseContentDisposition(iDownloadHeadHttpConnection.getResponseHeaderField(CONTENT_DISPOSITION));
        return TextUtils.isEmpty(contentDisposition) ? md5Hex(str) : contentDisposition;
    }

    private static long getFirstChunkCurOffset(List<DownloadChunk> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long currentOffset = -1;
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null && (downloadChunk.getCurrentOffset() <= downloadChunk.getEndOffset() || downloadChunk.getEndOffset() == 0)) {
                if (currentOffset == -1 || currentOffset > downloadChunk.getCurrentOffset()) {
                    currentOffset = downloadChunk.getCurrentOffset();
                }
            }
        }
        return currentOffset;
    }

    public static long getFirstOffset(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk == null || downloadChunk.size() <= 1) {
            return 0L;
        }
        long firstChunkCurOffset = getFirstChunkCurOffset(downloadChunk);
        if (firstChunkCurOffset >= 0) {
            return firstChunkCurOffset;
        }
        return 0L;
    }

    public static String getFixLengthString(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static int getInt(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String getLoggerTag(String str) {
        return Logger.downloaderTag(str);
    }

    public static long getMaxBytesOverMobile() {
        return 2147483648L;
    }

    public static String getMd5StatusMsg(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 == 99) {
            return str + "unknown error";
        }
        switch (i2) {
            case 0:
                return str + "md5 match";
            case 1:
                return str + "md5 not match";
            case 2:
                return str + "md5 empty";
            case 3:
                return str + "ttmd5 version not support";
            case 4:
                return str + "ttmd5 tag parser error";
            case 5:
                return str + "file not exist";
            case 6:
                return str + "get file md5 error";
            default:
                return str;
        }
    }

    public static String getRedirectSavePath(String str, DownloadSetting downloadSetting) {
        JSONObject jSONObjectOptJSONObject;
        String str2;
        if (downloadSetting == null || (jSONObjectOptJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String strOptString = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (strOptString.contains("%s")) {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        } else {
            str2 = strOptString + str;
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        if (iDownloadHeadHttpConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str);
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE, true)) {
            return responseHeaderField;
        }
        if (TextUtils.isEmpty(responseHeaderField)) {
            responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str.toLowerCase());
        }
        return TextUtils.isEmpty(responseHeaderField) ? iDownloadHeadHttpConnection.getResponseHeaderField(str.toUpperCase()) : responseHeaderField;
    }

    public static String getString(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static String getTargetFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String getTempFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static String getTempFilePath(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String targetFilePath = !TextUtils.isEmpty(str2) ? getTargetFilePath(str2, str3) : getTargetFilePath(str, str3);
        if (TextUtils.isEmpty(targetFilePath)) {
            return null;
        }
        return String.format("%s.tp", targetFilePath);
    }

    public static String getTempFileSavePath(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String getThrowableMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static long getTotalOffset(List<DownloadChunk> list) {
        Iterator<DownloadChunk> it = list.iterator();
        long downloadChunkBytes = 0;
        while (it.hasNext()) {
            downloadChunkBytes += it.next().getDownloadChunkBytes();
        }
        return downloadChunkBytes;
    }

    private static String getValidDownloadPath(File file, boolean z2) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (isValidDirectory(file)) {
            return file.getAbsolutePath();
        }
        int i2 = appContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
            if (z2) {
                File externalDownloadPath = getExternalDownloadPath();
                if (isValidDirectory(externalDownloadPath)) {
                    return externalDownloadPath.getAbsolutePath();
                }
            }
            File externalFilesDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            File externalFilesDir2 = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return appContext.getFilesDir().getAbsolutePath();
    }

    private static void handleTempSaveCallback(int i2, boolean z2, BaseException baseException) {
        synchronized (saveTempFileStatusMap) {
            List<ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(i2);
            if (list != null) {
                for (ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : list) {
                    if (iTempFileSaveCompleteCallback != null) {
                        if (z2) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        } else {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                    }
                }
            }
            Logger.d(TAG, "handleTempSaveCallback id:" + i2);
            saveTempFileStatusMap.remove(i2);
        }
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (HttpHeader httpHeader : list) {
            if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getName()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getValue())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String hexToString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, a.bN);
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static boolean isChunkedTask(long j2) {
        return j2 == -1;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return false;
        }
        return DownloadExpSwitchCode.isSwitchEnable(8) ? VALUE_CHUNKED.equals(iDownloadHeadHttpConnection.getResponseHeaderField(TRANSFER_ENCODING)) || getContentLength(iDownloadHeadHttpConnection) == -1 : getContentLength(iDownloadHeadHttpConnection) == -1;
    }

    public static boolean isConnectionException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Exception in connect");
    }

    public static boolean isDownloadSuccessAndFileNotExist(int i2, String str, String str2) {
        return i2 == -3 && !isFileExist(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isDownloaderProcess() {
        /*
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.sIsDownloaderProcess
            if (r0 == 0) goto L9
            boolean r0 = r0.booleanValue()
            return r0
        L9:
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()
            java.lang.String r0 = getCurProcessName(r0)
            if (r0 == 0) goto L3a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ":downloader"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.ss.android.socialbase.downloader.utils.DownloadUtils.sIsDownloaderProcess = r0
            goto L41
        L3a:
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.ss.android.socialbase.downloader.utils.DownloadUtils.sIsDownloaderProcess = r0
        L41:
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.sIsDownloaderProcess
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.isDownloaderProcess():boolean");
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo) {
        return isFileDownloaded(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean isFileExist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean isForbiddenException(Throwable th) {
        DownloadHttpException downloadHttpException;
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (!(th instanceof DownloadHttpException) || (((downloadHttpException = (DownloadHttpException) th) == null || downloadHttpException.getHttpStatusCode() != 403) && (TextUtils.isEmpty(throwableMsg) || !throwableMsg.contains("403")))) {
            return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Forbidden");
        }
        return true;
    }

    public static boolean isHeaderEqual(List<HttpHeader> list, List<HttpHeader> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static boolean isHttpDataDirtyError(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean isHttpsError(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static boolean isInsufficientSpaceError(Throwable th) {
        if (th == null) {
            return false;
        }
        if (!(th instanceof BaseException)) {
            if (!(th instanceof IOException)) {
                return false;
            }
            String throwableMsg = getThrowableMsg(th);
            return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("ENOSPC");
        }
        BaseException baseException = (BaseException) th;
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1006) {
            return true;
        }
        if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
            return false;
        }
        String message = baseException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
    }

    public static boolean isMainProcess() {
        Boolean bool = sIsMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        boolean z2 = false;
        if (curProcessName == null || !curProcessName.contains(":")) {
            if (curProcessName != null && curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName())) {
                z2 = true;
            }
            sIsMainProcess = Boolean.valueOf(z2);
        } else {
            sIsMainProcess = false;
        }
        return sIsMainProcess.booleanValue();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isMd5Valid(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static boolean isNetNotAvailableException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("network not available");
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkError(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean isNoWifiAndInNet() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext == null || isWifi(appContext) || !isNetworkConnected(appContext)) ? false : true;
    }

    public static boolean isProcessNameSame(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        return curProcessName != null && curProcessName.equals(str);
    }

    public static boolean isResponseCode304Error(Throwable th) {
        return DownloadComponentManager.getTTNetHandler().isResponseCode304Error(th);
    }

    public static boolean isResponseCode412Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCode416Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Requested Range Not Satisfiable");
    }

    public static boolean isResponseCodeError(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (TextUtils.isEmpty(throwableMsg)) {
            return false;
        }
        return throwableMsg.contains("Requested Range Not Satisfiable") || throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCodeValid(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean isResponseDataFromBegin(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean isSavePathSecurity(String str) {
        Context appContext;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SAVE_PATH_SECURITY) > 0 && (appContext = DownloadComponentManager.getAppContext()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + appContext.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSdcardAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    private static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTimeOutException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(throwableMsg)) {
                return false;
            }
            if (!throwableMsg.contains("time out") && !throwableMsg.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDirectory(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWaitWifiAndInNet(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && isNetworkConnected(DownloadComponentManager.getAppContext());
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 != null && (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean moveFile(File file, File file2) throws BaseException {
        String str = "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath();
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = copyFile(file, file2);
            try {
                String str2 = "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath();
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return zRenameTo;
    }

    public static boolean needNotifyDownloaderProcess() {
        return !isDownloaderProcess() && DownloadComponentManager.isDownloadInMultiProcess() && DownloadProxy.get(true).isServiceAlive();
    }

    private static String parseContentDisposition(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (CONTENT_DISPOSITION_QUOTED_PATTERN == null) {
                CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (CONTENT_DISPOSITION_NON_QUOTED_PATTERN == null) {
            CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Range");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(respHeadFieldIgnoreCase);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            Logger.w(TAG, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static long parseContentRangeOfInstanceLength(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                Logger.w(TAG, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static void parseException(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isTimeOutException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode412Error(th)) {
            throw new DownloadHttpException(1004, 412, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode416Error(th)) {
            throw new DownloadHttpException(1004, 416, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isForbiddenException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isNetNotAvailableException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isConnectionException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, getErrorMsgWithTagPrefix(th, str2));
        }
        if (!(th instanceof IOException)) {
            throw new BaseException(1000, getErrorMsgWithTagPrefix(th, str2));
        }
        parseTTNetException(th, str);
        parseIOException((IOException) th, str);
    }

    public static List<DownloadChunk> parseHostChunkList(List<DownloadChunk> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                if (downloadChunk.isHostChunk()) {
                    sparseArray.put(downloadChunk.getChunkIndex(), downloadChunk);
                    List<DownloadChunk> list2 = (List) sparseArray2.get(downloadChunk.getChunkIndex());
                    if (list2 != null) {
                        Iterator<DownloadChunk> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().setHostChunk(downloadChunk);
                        }
                        downloadChunk.setSubChunkList(list2);
                    }
                } else {
                    DownloadChunk downloadChunk2 = (DownloadChunk) sparseArray.get(downloadChunk.getHostChunkIndex());
                    if (downloadChunk2 != null) {
                        List<DownloadChunk> subChunkList = downloadChunk2.getSubChunkList();
                        if (subChunkList == null) {
                            subChunkList = new ArrayList<>();
                            downloadChunk2.setSubChunkList(subChunkList);
                        }
                        downloadChunk.setHostChunk(downloadChunk2);
                        subChunkList.add(downloadChunk);
                    } else {
                        List arrayList = (List) sparseArray2.get(downloadChunk.getHostChunkIndex());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(downloadChunk.getHostChunkIndex(), arrayList);
                        }
                        arrayList.add(downloadChunk);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static void parseIOException(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String errorMsgWithTagPrefix = getErrorMsgWithTagPrefix(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_SERVICE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(DownloadErrorCode.ERROR_PORT_UNREACHABLE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(DownloadErrorCode.ERROR_SOCKET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(DownloadErrorCode.ERROR_HTTP_RETRY, errorMsgWithTagPrefix);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(DownloadErrorCode.ERROR_PROTOCOL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(DownloadErrorCode.ERROR_MALFORMED_URL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(DownloadErrorCode.ERROR_FILE_NOT_FOUND, errorMsgWithTagPrefix);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(DownloadErrorCode.ERROR_INTERRUPTED_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, errorMsgWithTagPrefix);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(DownloadErrorCode.ERROR_EOF, errorMsgWithTagPrefix);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(DownloadErrorCode.ERROR_STREAM_RESET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, errorMsgWithTagPrefix);
        }
        if (!isInsufficientSpaceError(iOException)) {
            throw new BaseException(1023, errorMsgWithTagPrefix);
        }
        throw new BaseException(1006, errorMsgWithTagPrefix);
    }

    private static void parseTTNetException(Throwable th, String str) throws DownloadTTNetException {
        DownloadTTNetException downloadTTNetExceptionTranslateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th, null);
        if (downloadTTNetExceptionTranslateTTNetException == null) {
            downloadTTNetExceptionTranslateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th.getCause(), null);
        }
        if (downloadTTNetExceptionTranslateTTNetException == null) {
            return;
        }
        throw new DownloadTTNetException(downloadTTNetExceptionTranslateTTNetException.getErrorCode(), getErrorMsgWithTagPrefix(downloadTTNetExceptionTranslateTTNetException, str)).setRequestLog(downloadTTNetExceptionTranslateTTNetException.getRequestLog());
    }

    public static long parserMaxAge(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static void safeClose(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void saveFileAsTargetName(DownloadInfo downloadInfo, IDownloadMonitorDepend iDownloadMonitorDepend, ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback) {
        boolean z2;
        BaseException baseException;
        boolean z3;
        Logger.d(TAG, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (saveTempFileStatusMap) {
                if (saveTempFileStatusMap.get(downloadInfo.getId()) == Boolean.TRUE) {
                    Logger.d(TAG, "has another same task is saving temp file");
                    if (iTempFileSaveCompleteCallback != null) {
                        List<ITempFileSaveCompleteCallback> arrayList = saveTempFileListeners.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            saveTempFileListeners.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(iTempFileSaveCompleteCallback);
                    }
                    return;
                }
                Logger.d(TAG, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                saveTempFileStatusMap.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zIsSavePathSecurity = isSavePathSecurity(downloadInfo.getSavePath());
                if (file2.exists()) {
                    Logger.d(TAG, "targetFile exist");
                    int iCheckMd5Status = checkMd5Status(file2, downloadInfo.getMd5());
                    if (isMd5Valid(iCheckMd5Status)) {
                        Logger.d(TAG, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iCheckMd5Status);
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        }
                        handleTempSaveCallback(downloadInfo.getId(), true, null);
                    } else {
                        if (file.exists()) {
                            z2 = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), getMd5StatusMsg(iCheckMd5Status)));
                            if (iTempFileSaveCompleteCallback != null) {
                                iTempFileSaveCompleteCallback.onFailed(baseException2);
                            }
                            handleTempSaveCallback(downloadInfo.getId(), false, baseException2);
                            z2 = false;
                        }
                        if (zIsSavePathSecurity && !file2.delete()) {
                            if (z2) {
                                BaseException baseException3 = new BaseException(DownloadErrorCode.ERROR_TARGET_FILE_DELETE_FAILED, "delete targetPath file existed with md5 check invalid status:" + getMd5StatusMsg(iCheckMd5Status));
                                if (iTempFileSaveCompleteCallback != null) {
                                    iTempFileSaveCompleteCallback.onFailed(baseException3);
                                }
                                handleTempSaveCallback(downloadInfo.getId(), false, baseException3);
                            } else if (iDownloadMonitorDepend != null) {
                                DownloadMonitorHelper.monitorSendWithTaskMonitor(iDownloadMonitorDepend, downloadInfo, new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z2 = false;
                } else if (file.exists()) {
                    z2 = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (iTempFileSaveCompleteCallback != null) {
                        iTempFileSaveCompleteCallback.onFailed(baseException4);
                    }
                    handleTempSaveCallback(downloadInfo.getId(), false, baseException4);
                    z2 = false;
                }
                if (z2) {
                    try {
                        int iOptInt = DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 2);
                        if (iOptInt > 0) {
                            int iCheckMd5Status2 = checkMd5Status(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iCheckMd5Status2);
                            if (iOptInt >= 2 && !isMd5Valid(iCheckMd5Status2)) {
                                BaseException baseException5 = new BaseException(DownloadErrorCode.ERROR_MD5_INVALID, getMd5StatusMsg(iCheckMd5Status2));
                                if (iTempFileSaveCompleteCallback != null) {
                                    iTempFileSaveCompleteCallback.onFailed(baseException5);
                                }
                                handleTempSaveCallback(downloadInfo.getId(), false, baseException5);
                                deleteAllDownloadFiles(downloadInfo, zIsSavePathSecurity);
                                return;
                            }
                        }
                        z3 = !moveFile(file, file2);
                        baseException = null;
                    } catch (BaseException e2) {
                        baseException = e2;
                        z3 = DownloadSetting.obtain(downloadInfo.getId()).optBugFix(DownloadSettingKeys.BugFix.FIX_FILE_RENAME_FAILED);
                    }
                    if (!z3) {
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        }
                        handleTempSaveCallback(downloadInfo.getId(), true, null);
                    } else {
                        if (baseException == null) {
                            baseException = new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                        handleTempSaveCallback(downloadInfo.getId(), false, baseException);
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(TAG, "saveFileAsTargetName throwable " + th.getMessage());
            if (iTempFileSaveCompleteCallback != null) {
                iTempFileSaveCompleteCallback.onFailed(new BaseException(DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, getErrorMsgWithTagPrefix(th, "saveFileAsTargetName")));
            }
        }
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i2));
        }
        return map;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader("If-Match", str));
        }
        arrayList.add(new HttpHeader("Accept-Encoding", "identity"));
        String str2 = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
        arrayList.add(new HttpHeader("Range", str2));
        Logger.d(TAG, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + str2);
        return arrayList;
    }

    public static boolean copyFile(File file, File file2, boolean z2) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(DownloadErrorCode.ERROR_TARGET_DIR_MKDIR_FAILED, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    String str = "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath();
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    doCopyFile(file, file2, z2);
                    return true;
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                parseException(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo, boolean z2) {
        if (downloadInfo == null) {
            return;
        }
        if (z2) {
            try {
                deleteFile(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            clearAntiHijackDir(downloadInfo);
        }
        if (z2) {
            String strMd5Hex = md5Hex(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strMd5Hex) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strMd5Hex)) {
                return;
            }
            deleteDirIfEmpty(downloadInfo.getSavePath());
        }
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo, boolean z2, String str) {
        if (!z2 && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (checkMd5Valid(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int checkMd5Status(File file, String str) {
        return TTMd5.checkMd5(str, file);
    }

    public static boolean checkMd5Valid(File file, String str) {
        return isMd5Valid(TTMd5.checkMd5(str, file));
    }

    private static void ensureDirExists(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String toHexString(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 >= 0 && i2 + i3 <= bArr.length) {
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = HEX_CHARS;
                    cArr[i5] = cArr2[i7 >> 4];
                    i5 = i8 + 1;
                    cArr[i8] = cArr2[i7 & 15];
                }
                return new String(cArr, 0, i4);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean isResponseCodeError(BaseException baseException) {
        if (baseException instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) baseException;
            if (downloadHttpException.getHttpStatusCode() == 412 || downloadHttpException.getHttpStatusCode() == 416) {
                return true;
            }
        }
        return false;
    }

    public static void safeClose(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static boolean isFileDownloaded(String str, String str2, boolean z2) {
        if (!z2 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (new File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, null)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileDownloaded(String str, String str2, String str3, boolean z2) {
        if (!z2 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (new File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, str3)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
