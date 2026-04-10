package com.alipay.sdk.m.h0;

import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1824a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1825b = "";
    public static String c = "";

    public static synchronized void a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList);
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static synchronized void a(String str, String str2, String str3) {
        f1824a = str;
        f1825b = str2;
        c = str3;
    }

    public static synchronized void a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(th));
        a(arrayList);
    }

    public static synchronized void a(List<String> list) {
        if (!com.alipay.sdk.m.d0.a.a(f1825b) && !com.alipay.sdk.m.d0.a.a(c)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(c);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(", " + it.next());
            }
            stringBuffer.append(SignatureUtils.DELIMITER);
            try {
                File file = new File(f1824a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f1824a, f1825b);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                fileWriter.write(stringBuffer.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }
}
