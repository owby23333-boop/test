package com.miui.privacypolicy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes17.dex */
public class FileUtils {
    protected static final String ERROR_FILE_NAME = "privacy_agree_error";
    private static final String FOLDER_NAME = "privacypolicy";
    protected static final String INFO_FILE_NAME = "privacy_update";
    private static final String TAG = "Privacy_FileUtils";
    protected static final String TEMP_UPDATE_VERSION_FILE_NAME = "privacy_temp_update_version";
    protected static final String VERSION_FILE_NAME = "privacy_version";

    private FileUtils() {
    }

    public static void closeQuietly(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                Log.e(TAG, "closeQuietly Writer error " + e);
            }
        }
    }

    public static boolean deleteFile(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(FOLDER_NAME);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean isAgreeErrorFileExit(Context context, String str) {
        return !TextUtils.isEmpty(readData(context, ERROR_FILE_NAME, str));
    }

    public static boolean isVersionFileExit(Context context, String str) {
        return !TextUtils.isEmpty(readData(context, VERSION_FILE_NAME, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static String readData(Context context, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(FOLDER_NAME);
        sb.append(str3);
        sb.append((String) str2);
        sb.append(str3);
        sb.append(str);
        String string = sb.toString();
        if (!new File(string).exists()) {
            return "";
        }
        ?? r3 = 0;
        String inputStream = null;
        try {
            try {
                fileInputStream = new FileInputStream(string);
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                closeQuietly((InputStream) r3);
                throw th;
            }
            try {
                inputStream = readInputStream(fileInputStream);
                str2 = fileInputStream;
            } catch (Exception e2) {
                e = e2;
                Log.e(TAG, "readData fail!", e);
                str2 = fileInputStream;
            }
            closeQuietly((InputStream) str2);
            return inputStream;
        } catch (Throwable th2) {
            th = th2;
            r3 = str2;
            closeQuietly((InputStream) r3);
            throw th;
        }
    }

    private static String readInputStream(FileInputStream fileInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = fileInputStream.read(bArr, 0, 1024);
                    if (i <= 0) {
                        return byteArrayOutputStream.toString();
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Exception e) {
                    Log.e(TAG, "readInputStream fail!", e);
                    closeQuietly(byteArrayOutputStream);
                    return null;
                }
            } finally {
                closeQuietly(byteArrayOutputStream);
            }
            closeQuietly(byteArrayOutputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void saveData(String str, Context context, String str2, String str3) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String str4 = File.separator;
        sb.append(str4);
        sb.append(FOLDER_NAME);
        sb.append(str4);
        sb.append((String) str3);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                str3 = new FileOutputStream(new File(file, str2));
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(str3));
                    try {
                        bufferedWriter2.write(str);
                        closeQuietly(bufferedWriter2);
                        str3 = str3;
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        Log.e(TAG, "saveData fail!", e);
                        closeQuietly(bufferedWriter);
                        str3 = str3;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        closeQuietly(bufferedWriter);
                        closeQuietly((OutputStream) str3);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                str3 = 0;
            } catch (Throwable th2) {
                th = th2;
                str3 = 0;
            }
            closeQuietly((OutputStream) str3);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.e(TAG, "closeQuietly InputStream error " + e);
            }
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                Log.e(TAG, "closeQuietly OutputStream error " + e);
            }
            try {
                outputStream.close();
            } catch (IOException e2) {
                Log.e(TAG, "closeQuietly OutputStream error " + e2);
            }
        }
    }
}
