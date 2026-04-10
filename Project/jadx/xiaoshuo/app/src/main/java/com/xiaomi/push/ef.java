package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.dangdang.reader.utils.DangdangFileManager;
import com.dangdang.zframework.utils.DateUtil;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
class ef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7906a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f269a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f270b;
    private String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f267a = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7907b = 2097152;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<File> f268a = new ArrayList<>();

    public ef a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f270b = this.f267a.format(date2);
            this.c = this.f267a.format(date);
        } else {
            this.f270b = this.f267a.format(date);
            this.c = this.f267a.format(date2);
        }
        return this;
    }

    public void a(int i) {
        if (i != 0) {
            this.f7907b = i;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ef m319a(File file) {
        if (file.exists()) {
            this.f268a.add(file);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) throws IOException {
        char[] cArr = new char[4096];
        int i = bufferedReader.read(cArr);
        boolean z = false;
        while (i != -1 && !z) {
            String str = new String(cArr, 0, i);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= i || !matcher.find(i2)) {
                    break;
                }
                int iStart = matcher.start();
                String strSubstring = str.substring(iStart, this.f270b.length() + iStart);
                if (!this.f269a) {
                    if (strSubstring.compareTo(this.f270b) >= 0) {
                        this.f269a = true;
                        i3 = iStart;
                    }
                } else if (strSubstring.compareTo(this.c) > 0) {
                    z = true;
                    i = iStart;
                    break;
                }
                int iIndexOf = str.indexOf(10, iStart);
                if (iIndexOf == -1) {
                    iIndexOf = this.f270b.length();
                }
                i2 = iStart + iIndexOf;
            }
            if (this.f269a) {
                int i4 = i - i3;
                this.f266a += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                } else {
                    bufferedWriter.write(cArr, i3, i4);
                    if (this.f266a > this.f7907b) {
                        return;
                    }
                }
            }
            i = bufferedReader.read(cArr);
        }
    }

    private void a(File file) throws Throwable {
        BufferedReader bufferedReader;
        Pattern patternCompile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter bufferedWriter = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        bufferedWriter = null;
        bufferedWriter = null;
        bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.bw.m776a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + SignatureUtils.DELIMITER);
                    this.f266a = 0;
                    Iterator<File> it = this.f268a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter2, patternCompile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            x.a(bufferedWriter);
                            x.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = bufferedWriter2;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            x.a(bufferedWriter);
                            x.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            x.a(bufferedWriter);
                            x.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter2.write(dc.a().c());
                    x.a(bufferedWriter2);
                    x.a(bufferedReader2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public File a(Context context, Date date, Date date2, File file) throws Throwable {
        File fileA;
        if (SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE.equalsIgnoreCase(context.getPackageName())) {
            fileA = ee.a(context);
            if (fileA == null) {
                return null;
            }
            m319a(new File(fileA, "xmsf.log.1"));
            m319a(new File(fileA, "xmsf.log"));
        } else {
            File file2 = new File(context.getFilesDir() + f7906a);
            if (!w.m818a(file2)) {
                return null;
            }
            m319a(new File(file2, "log0.txt"));
            m319a(new File(file2, "log1.txt"));
            fileA = file2;
        }
        if (!fileA.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + DangdangFileManager.FONT_EXTEN);
        if (file3.exists()) {
            return null;
        }
        a(date, date2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        a(file4);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (file4.exists()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            x.a(file3, file4);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
            file4.delete();
            if (file3.exists()) {
                return file3;
            }
        }
        return null;
    }
}
