package cn.bmob.v3.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;

    public static void cleanDirectory(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e2 = null;
        for (File file2 : fileArrListFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static void copyFile(File file, File file2) throws Throwable {
        copyFile(file, file2, true);
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable, java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static void doCopyFile(File file, File file2, boolean z2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ?? channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        ?? channel2 = 0;
        channel2 = 0;
        channel2 = 0;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                } catch (Throwable th) {
                    th = th;
                    channel = 0;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                channel = fileOutputStream;
                IOUtils.closeQuietly((Closeable) channel2);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                IOUtils.closeQuietly((Closeable) channel);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
            try {
                channel2 = fileOutputStream.getChannel();
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
                IOUtils.closeQuietly((Closeable) channel2);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                IOUtils.closeQuietly((Closeable) channel);
                IOUtils.closeQuietly((InputStream) fileInputStream);
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
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly((Closeable) channel2);
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                IOUtils.closeQuietly((Closeable) channel);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (zExists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static void moveFile(File file, File file2) throws Throwable {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new IOException("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        }
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file, file2);
        if (file.delete()) {
            return;
        }
        deleteQuietly(file2);
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file);
    }

    public static byte[] readFileToByteArray(File file) throws Throwable {
        FileInputStream fileInputStreamOpenInputStream;
        try {
            fileInputStreamOpenInputStream = openInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStreamOpenInputStream = null;
        }
        try {
            byte[] byteArray = IOUtils.toByteArray(fileInputStreamOpenInputStream);
            IOUtils.closeQuietly((InputStream) fileInputStreamOpenInputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) fileInputStreamOpenInputStream);
            throw th;
        }
    }

    public static JSONObject readFileToJSONObject(File file) throws JSONException, IOException {
        return new JSONObject(readFileToString(file, "UTF-8"));
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        return new String(readFileToByteArray(file), charset);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStreamOpenOutputStream;
        try {
            fileOutputStreamOpenOutputStream = openOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStreamOpenOutputStream = null;
        }
        try {
            fileOutputStreamOpenOutputStream.write(bArr);
            IOUtils.closeQuietly((OutputStream) fileOutputStreamOpenOutputStream);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((OutputStream) fileOutputStreamOpenOutputStream);
            throw th;
        }
    }

    public static void writeJSONObjectToFile(File file, JSONObject jSONObject) throws Throwable {
        writeByteArrayToFile(file, jSONObject.toString().getBytes(Charset.forName("UTF-8")));
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws Throwable {
        writeByteArrayToFile(file, str.getBytes(charset));
    }

    public static void copyFile(File file, File file2, boolean z2) throws Throwable {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            doCopyFile(file, file2, z2);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charset.forName(str));
    }

    public static void writeStringToFile(File file, String str, String str2) throws Throwable {
        writeStringToFile(file, str, Charset.forName(str2));
    }
}
