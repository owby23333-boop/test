package com.dangdang.zframework.network.report;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.utils.DangDangParams;
import com.dangdang.zframework.utils.DateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class ReportManager {
    public static ReportFilterBean mReportFilterBean;

    public static ReportBean configBean(String str, int i, int i2, int i3, String str2, String str3) {
        ReportBean reportBean = new ReportBean();
        reportBean.serialNumber = DangDangParams.getPublicParamsMap().get("deviceSerialNo") + System.currentTimeMillis();
        reportBean.code = i2;
        reportBean.mapiHost = "";
        if (str == null || str.isEmpty()) {
            reportBean.url = "";
        } else {
            reportBean.url = str.split("\\?")[0];
        }
        reportBean.costTime = i;
        reportBean.custId = 0L;
        reportBean.thirdCustid = 0;
        reportBean.udid = DangDangParams.getPublicParamsMap().get("deviceId");
        reportBean.uuid = DangDangParams.getPublicParamsMap().get("deviceSerialNo");
        reportBean.permanentId = DangDangParams.getPublicParamsMap().get("permanentId");
        reportBean.nickName = "";
        reportBean.account = "";
        reportBean.userClient = "android-ebook";
        reportBean.clientVersion = DangDangParams.getPublicParamsMap().get("clientVersionNo");
        reportBean.unionId = DangDangParams.getPublicParamsMap().get("channelId");
        reportBean.coordinate = "";
        reportBean.networdType = "";
        reportBean.mobileType = "";
        reportBean.imei = DangDangParams.getPublicParamsMap().get("deviceId");
        reportBean.mac = DangDangParams.getPublicParamsMap().get("macAddr");
        reportBean.addressName = "";
        reportBean.platformName = DangDangParams.getPublicParamsMap().get(DangDangParams.VENDOR_NAME);
        reportBean.platformVersion = DangDangParams.getPublicParamsMap().get("clientOs");
        reportBean.uuid = DangDangParams.getPublicParamsMap().get("token");
        reportBean.creationDate = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2, Locale.CHINA).format(new Date());
        reportBean.parameter = getParameter(str);
        reportBean.errorDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA).format(new Date());
        reportBean.errorPage = "";
        reportBean.errorTag = str2;
        reportBean.errorLevel = "warn";
        reportBean.pageTrace = "";
        reportBean.netTrace = "";
        reportBean.systemLog = "";
        reportBean.extraInfo = "";
        reportBean.baseInfo = "";
        reportBean.pageData = "";
        reportBean.message = str3;
        reportBean.errorCode = i3;
        return reportBean;
    }

    public static String getActionOrPath(String str, String str2) {
        String[] strArrSplit = str.split("\\?");
        String str3 = "";
        if (strArrSplit == null || strArrSplit.length < 2) {
            return "";
        }
        try {
            String[] strArrSplit2 = strArrSplit[1].split("\\&");
            HashMap map = new HashMap(strArrSplit2.length);
            for (String str4 : strArrSplit2) {
                String[] strArrSplit3 = str4.split("\\=");
                if (strArrSplit3 != null && strArrSplit3.length >= 2) {
                    map.put(strArrSplit3[0], strArrSplit3[1]);
                }
            }
            String str5 = (String) map.get(str2);
            if (str5 == null) {
                try {
                    String path = getPath(str);
                    if (path != null) {
                        str3 = path;
                    }
                } catch (Exception e) {
                    e = e;
                    str3 = str5;
                    e.printStackTrace();
                }
            } else {
                str3 = str5;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return (TextUtils.isEmpty(str3) || str3.length() <= 10) ? str3 : str3.substring(0, 9);
    }

    public static String getErrorTag(int i, int i2, String str) {
        if (i != 200) {
            return "http_error:" + getActionOrPath(str, "action") + i;
        }
        return "action_error:" + getActionOrPath(str, "action") + ":" + i2;
    }

    public static String getParameter(String str) {
        String[] strArrSplit;
        if (str != null && (strArrSplit = str.split("\\?")) != null && strArrSplit.length >= 2) {
            try {
                String[] strArrSplit2 = strArrSplit[1].split("\\&");
                HashMap map = new HashMap();
                for (String str2 : strArrSplit2) {
                    String[] strArrSplit3 = str2.split("\\=");
                    if (strArrSplit3 != null && strArrSplit3.length >= 2) {
                        map.put(strArrSplit3[0], strArrSplit3[1]);
                    }
                }
                return new JSONObject(map).toJSONString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getPath(String str) {
        try {
            String[] strArrSplit = str.split("\\/");
            if (strArrSplit == null || strArrSplit.length <= 0) {
                return null;
            }
            return strArrSplit[strArrSplit.length - 1];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void initReportFilterBean(String str) {
        try {
            mReportFilterBean = (ReportFilterBean) JSON.parseObject(str, ReportFilterBean.class);
        } catch (Exception e) {
            mReportFilterBean = null;
            e.printStackTrace();
        }
    }

    public static void sendCustomResultToServer(long j, String str, String str2) {
        try {
            WrapDDEventBus.getInstance().sendEventBus(configBean(str, (int) j, -1, -1, str, str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendHttpResultToServer(String str, long j, int i, int i2, String str2) {
        StringBuilder sb;
        try {
            if (i == 200) {
                sb = new StringBuilder();
                sb.append("code:");
                sb.append(i2);
                sb.append("message:");
                sb.append(str2);
                sb.append("  url:");
                sb.append(str);
            } else {
                sb = new StringBuilder();
                sb.append("code:");
                sb.append(i);
                sb.append("  url:");
                sb.append(str);
            }
            WrapDDEventBus.getInstance().sendEventBus(configBean(str, (int) j, i, i2, getErrorTag(i, i2, str), sb.toString()));
            LogM.d("send_xxx", "code:" + i + "errorCode:" + i2 + "msg:" + str2 + "url:" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReportFilterBean getReportFilterBean() {
        return mReportFilterBean;
    }
}
