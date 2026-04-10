package com.dangdang.zframework.utils;

import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.network.report.ReportFilterBean;
import com.dangdang.zframework.network.report.ReportManager;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class HttpReportUtils {
    public static boolean checkActionOrPath(String str, String str2, String str3) {
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length >= 2) {
            String str4 = strArrSplit[1];
            if (str2 == null) {
                str2 = "noConfig";
            }
            if (str3 == null) {
                str3 = "noConfig";
            }
            try {
                String[] strArrSplit2 = str4.split("\\&");
                HashMap map = new HashMap(strArrSplit2.length);
                for (String str5 : strArrSplit2) {
                    String[] strArrSplit3 = str5.split("\\=");
                    if (strArrSplit3 != null && strArrSplit3.length >= 2) {
                        map.put(strArrSplit3[0], strArrSplit3[1]);
                    }
                }
                String str6 = (String) map.get("action");
                if (str6 == null) {
                    if (str.contains(str3)) {
                        LogM.d("h_report", "匹配到path :" + str3 + "  url:" + str);
                        return true;
                    }
                    LogM.d("h_report", "没有匹配到path :" + str3 + "  url:" + str);
                    return false;
                }
                if (!str6.equals(str2)) {
                    LogM.d("h_report", "没有匹配到action :" + str2 + "  url:" + str);
                    return false;
                }
                LogM.d("h_report", "匹配到action :" + str2 + " resulet:" + str6 + "  url:" + str);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean checkIsParseResponse(String str) {
        ReportFilterBean reportFilterBean = ReportManager.mReportFilterBean;
        if (reportFilterBean == null) {
            return false;
        }
        for (ReportFilterBean.ArrayBean arrayBean : reportFilterBean.array) {
            if (checkActionOrPath(str, arrayBean.action, arrayBean.path)) {
                return true;
            }
        }
        return false;
    }

    public static String getAction(String str, String str2) {
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit == null || strArrSplit.length < 2) {
            return "empty   ";
        }
        String str3 = strArrSplit[1];
        if (str2 == null) {
            str2 = "noConfig";
        }
        try {
            String[] strArrSplit2 = str3.split("\\&");
            HashMap map = new HashMap(strArrSplit2.length);
            for (String str4 : strArrSplit2) {
                String[] strArrSplit3 = str4.split("\\=");
                if (strArrSplit3 != null && strArrSplit3.length >= 2) {
                    map.put(strArrSplit3[0], strArrSplit3[1]);
                }
            }
            return (String) map.get(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "null  ";
        }
    }

    public static int getResponseErrorCode(int i) {
        ReportFilterBean reportFilterBean = ReportManager.mReportFilterBean;
        if (reportFilterBean == null) {
            return 0;
        }
        Iterator<ReportFilterBean.ArrayBean> it = reportFilterBean.array.iterator();
        while (it.hasNext()) {
            Iterator<Integer> it2 = it.next().filter.iterator();
            while (it2.hasNext()) {
                if (i == it2.next().intValue()) {
                    return 0;
                }
            }
        }
        return i;
    }
}
