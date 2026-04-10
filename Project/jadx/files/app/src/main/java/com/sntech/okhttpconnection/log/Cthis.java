package com.sntech.okhttpconnection.log;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.this, reason: invalid class name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cthis {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final /* synthetic */ int f123do = 0;

    static {
        Executors.newCachedThreadPool();
        Pattern.compile(".*(.js|.jsx|.coffee|.ts|.css|.less|.sass|.scss|.jpg|.png|.gif|.bmp|.svg|.ttf|.eot|.woff|.woff2|.ejs|.jade|.vue|.jpeg|.ico|.flv|.mpeg|.mp4|.mp3|.txt|.html|.htm|.xml)$");
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m140do(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    fileInputStream.close();
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
