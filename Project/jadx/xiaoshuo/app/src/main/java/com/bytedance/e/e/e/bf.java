package com.bytedance.e.e.e;

import android.app.ActivityManager;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    public static String e(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + SignatureUtils.DELIMITER);
        sb.append("processName: " + processErrorStateInfo.processName + SignatureUtils.DELIMITER);
        sb.append("pid: " + processErrorStateInfo.pid + SignatureUtils.DELIMITER);
        sb.append("uid: " + processErrorStateInfo.uid + SignatureUtils.DELIMITER);
        sb.append("tag: " + processErrorStateInfo.tag + SignatureUtils.DELIMITER);
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + SignatureUtils.DELIMITER);
        sb.append("longMsg : " + processErrorStateInfo.longMsg + SignatureUtils.DELIMITER);
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }
}
