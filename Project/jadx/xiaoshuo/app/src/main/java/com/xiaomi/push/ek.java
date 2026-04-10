package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ek implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ek f7919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7920b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f286a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f285a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f287a = Collections.synchronizedList(new ArrayList());

    private ek(Context context) {
        this.f288a = context;
        if (context.getApplicationContext() != null) {
            this.f288a = context.getApplicationContext();
        }
        this.f7920b = this.f288a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f289a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f7920b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        this.f289a.post(new el(this, str, th));
    }

    public static ek a(Context context) {
        if (f7919a == null) {
            synchronized (ek.class) {
                if (f7919a == null) {
                    f7919a = new ek(context);
                }
            }
        }
        return f7919a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x015b -> B:102:0x0160). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m325a() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    file = new File(this.f288a.getFilesDir(), f285a);
                } catch (Exception e) {
                    e = e;
                    fileLockLock = null;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    fileLockLock = null;
                    randomAccessFile = null;
                }
            } catch (IOException e2) {
                Log.e(this.f7920b, "", e2);
            }
            if (!w.m818a(file)) {
                Log.w(this.f7920b, "Cannot wirte internal file: " + file);
                return;
            }
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.f7920b, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f287a.isEmpty()) {
                        try {
                            Pair<String, Throwable> pairRemove = f287a.remove(0);
                            String str = (String) pairRemove.first;
                            if (pairRemove.second != null) {
                                str = (str + SignatureUtils.DELIMITER) + Log.getStackTraceString((Throwable) pairRemove.second);
                            }
                            bufferedWriter2.write(str + SignatureUtils.DELIMITER);
                        } catch (Exception e3) {
                            e = e3;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.f7920b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    Log.e(this.f7920b, "", e4);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e5) {
                                    Log.e(this.f7920b, "", e5);
                                }
                            }
                            if (randomAccessFile == null) {
                                return;
                            } else {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    Log.e(this.f7920b, "", e6);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e7) {
                                    Log.e(this.f7920b, "", e7);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e8) {
                                    Log.e(this.f7920b, "", e8);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e9) {
                            Log.e(this.f7920b, "", e9);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                fileLockLock = null;
            } catch (Throwable th3) {
                th = th3;
                fileLockLock = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
