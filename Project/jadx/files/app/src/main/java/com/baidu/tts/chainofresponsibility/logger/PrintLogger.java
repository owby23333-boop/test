package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PrintLogger {
    private List<String> mPrintStrings = new ArrayList();
    private List<String> mUnprintStrings = new ArrayList();

    public void addPrintString(String str) {
        List<String> list = this.mPrintStrings;
        if (list == null || list.contains(str)) {
            return;
        }
        this.mPrintStrings.add(str);
    }

    public void addPrintStrings(List<String> list) {
        List<String> list2 = this.mPrintStrings;
        if (list2 != null) {
            list2.addAll(list);
        }
    }

    public void addUnPrintString(String str) {
        List<String> list = this.mUnprintStrings;
        if (list == null || list.contains(str)) {
            return;
        }
        this.mUnprintStrings.add(str);
    }

    public void addUnPrintStrings(List<String> list) {
        List<String> list2 = this.mUnprintStrings;
        if (list2 != null) {
            list2.addAll(list);
        }
    }

    public void clear() {
        List<String> list = this.mPrintStrings;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.mUnprintStrings;
        if (list2 != null) {
            list2.clear();
        }
    }

    public void print(LoggerBean loggerBean, Void r7, LoggerChain loggerChain) {
        boolean z2;
        String tag = loggerBean.getTag();
        String message = loggerBean.getMessage();
        String className = loggerBean.getClassName();
        if (className != null) {
            message = ad.f20405r + className + ad.f20406s + message;
        }
        List<String> list = this.mUnprintStrings;
        if (list == null || list.isEmpty()) {
            z2 = true;
        } else if (this.mUnprintStrings.contains(tag)) {
            z2 = false;
        } else {
            z2 = true;
            for (String str : this.mUnprintStrings) {
                if (str != null && message != null && message.contains(str)) {
                    z2 = false;
                }
            }
        }
        List<String> list2 = this.mPrintStrings;
        if (list2 != null && !list2.isEmpty()) {
            if (this.mPrintStrings.contains(tag)) {
                z2 = true;
            } else {
                for (String str2 : this.mPrintStrings) {
                    if (str2 != null && message != null) {
                        z2 = message.contains(str2);
                    }
                }
            }
        }
        if (z2) {
            Log.println(loggerBean.getLevel(), "bdtts-" + tag, message);
        }
    }
}
