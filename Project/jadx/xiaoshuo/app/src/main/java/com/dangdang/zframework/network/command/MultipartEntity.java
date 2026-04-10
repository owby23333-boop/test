package com.dangdang.zframework.network.command;

import android.text.TextUtils;
import cn.kuaipan.android.http.multipart.FilePart;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.oauth.http.HttpResponseMessage;

/* JADX INFO: loaded from: classes10.dex */
public class MultipartEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String mBoundary;
    OutputStream mOutputStream;
    private final String NEW_LINE_STR = HttpResponseMessage.EOL;
    private final String CONTENT_TYPE = "Content-Type: ";
    private final String CONTENT_DISPOSITION = "Content-Disposition: ";
    private final String TYPE_TEXT_CHARSET = "text/plain; charset=UTF-8";
    private final String TYPE_OCTET_STREAM = FilePart.DEFAULT_CONTENT_TYPE;
    private final byte[] BINARY_ENCODING = "Content-Transfer-Encoding: binary\r\n\r\n".getBytes();
    private final byte[] BIT_ENCODING = "Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes();

    public MultipartEntity() {
        this.mBoundary = null;
        this.mBoundary = generateBoundary();
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private final String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int iNextInt = random.nextInt(11) + 30;
        for (int i = 0; i < iNextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    private byte[] getContentDispositionBytes(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("; filename=\"" + str2 + "\"");
        }
        sb.append(HttpResponseMessage.EOL);
        return sb.toString().getBytes();
    }

    private void writeFirstBoundary() throws IOException {
        this.mOutputStream.write(("--" + this.mBoundary + HttpResponseMessage.EOL).getBytes());
    }

    private void writeToOutputStream(String str, byte[] bArr, String str2, byte[] bArr2, String str3) {
        try {
            writeFirstBoundary();
            this.mOutputStream.write(("Content-Type: " + str2 + HttpResponseMessage.EOL).getBytes());
            this.mOutputStream.write(getContentDispositionBytes(str, str3));
            this.mOutputStream.write(bArr2);
            this.mOutputStream.write(bArr);
            this.mOutputStream.write(HttpResponseMessage.EOL.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBinaryPart(String str, byte[] bArr) {
        try {
            writeFirstBoundary();
            this.mOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes());
            this.mOutputStream.write(getContentDispositionBytes(str, "no-file"));
            this.mOutputStream.write(this.BINARY_ENCODING);
            this.mOutputStream.write(bArr);
            this.mOutputStream.write(HttpResponseMessage.EOL.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.dangdang.zframework.network.command.MultipartEntity] */
    public void addFilePart(String str, File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        ?? r0 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    writeFirstBoundary();
                    this.mOutputStream.write(getContentDispositionBytes(str, file.getName()));
                    this.mOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes());
                    this.mOutputStream.write(this.BINARY_ENCODING);
                    bArr = new byte[4096];
                } catch (IOException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    closeSilently(fileInputStream2);
                    r0 = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    r0 = fileInputStream;
                    closeSilently(r0);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                r0 = -1;
                if (i == -1) {
                    break;
                } else {
                    this.mOutputStream.write(bArr, 0, i);
                }
            }
            this.mOutputStream.write(HttpResponseMessage.EOL.getBytes());
            this.mOutputStream.flush();
            closeSilently(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void addStringPart(String str, String str2) {
        writeToOutputStream(str, str2.getBytes(), "text/plain; charset=UTF-8", this.BIT_ENCODING, "");
    }

    public HashMap<String, String> getContentType() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "multipart/form-data; boundary=" + this.mBoundary);
        return map;
    }

    public void send(HttpURLConnection httpURLConnection, HashMap<String, String> map, HashMap<String, byte[]> map2) throws Throwable {
        this.mOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (new File(value).exists()) {
                addFilePart(key, new File(value));
            }
        }
        for (Map.Entry<String, byte[]> entry2 : map2.entrySet()) {
            addBinaryPart(entry2.getKey(), entry2.getValue());
        }
        setEnd();
        this.mOutputStream.flush();
        this.mOutputStream.close();
    }

    public void setEnd() throws IOException {
        this.mOutputStream.write(("--" + this.mBoundary + "--\r\n").getBytes());
    }
}
