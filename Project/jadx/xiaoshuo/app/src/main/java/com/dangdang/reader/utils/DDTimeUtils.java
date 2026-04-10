package com.dangdang.reader.utils;

import android.text.format.DateFormat;
import com.dangdang.zframework.utils.DateUtil;
import com.yuewen.a33;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes10.dex */
public class DDTimeUtils {
    public static String dataFormatString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
    }

    public static String dateFormat(Date date) {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2, Locale.CHINA).format(date) + " ";
    }

    public static String dateFormat2(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(date);
    }

    public static String dateFormatDHMS(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("dd日HH:mm:ss", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatHHmm(long j) {
        String str;
        long j2 = (j / 1000) / 60;
        long j3 = j2 / 60;
        if (j3 <= 0) {
            str = "00:";
        } else if (j3 >= 1 && j3 < 10) {
            str = "0" + j3 + ":";
        } else if (j3 >= 10) {
            str = j3 + ":";
        } else {
            str = null;
        }
        long j4 = j2 % 60;
        if (j4 < 0 || j4 >= 10) {
            return str + j4;
        }
        return str + "0" + j4;
    }

    public static String dateFormatHHmmV2(long j) {
        String str;
        if (j <= 0) {
            return "0分钟";
        }
        long j2 = j / 60;
        if (j2 > 0) {
            str = j2 + "小时";
        } else {
            str = "";
        }
        long j3 = j % 60;
        if (j3 <= 0) {
            return str;
        }
        return str + j3 + "分钟";
    }

    public static String dateFormatHM(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_7, Locale.CHINA).format(date) + " ";
    }

    public static String dateFormatLong(Date date) {
        return new SimpleDateFormat("yyyyMMddHHMMSS", Locale.CHINA).format(date);
    }

    public static String dateFormatMD(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_9, Locale.CHINA).format(date) + " ";
    }

    public static String dateFormatNoYear(long j) {
        String str;
        long j2 = j / 1000;
        long j3 = j2 / 60;
        if (j3 <= 0) {
            str = "00:";
        } else if (j3 >= 1 && j3 < 10) {
            str = "0" + j3 + ":";
        } else if (j3 >= 10) {
            str = j3 + ":";
        } else {
            str = null;
        }
        long j4 = j2 % 60;
        if (j4 < 0 || j4 >= 10) {
            return str + j4;
        }
        return str + "0" + j4;
    }

    public static String dateFormatYMD(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYMD2(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYMDHM(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYMDHM2(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYMDHMS(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2, Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYMDHMS2(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.CHINA).format(date) + "";
    }

    public static String dateFormatYYMMDD(long j) {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_8, Locale.CHINA).format(new Date(j));
    }

    public static String dateFormathh_mm_ss(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy年MM月dd日HH_mm_ss", Locale.CHINA).format(date) + " ";
    }

    public static String dateSecFormat(Date date) {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.CHINA).format(date) + " ";
    }

    public static String formatDuring(long j) {
        long j2 = j / 86400000;
        long j3 = (j % 86400000) / 3600000;
        long j4 = (j % 3600000) / 60000;
        long j5 = (j % 60000) / 1000;
        if (j2 > 0) {
            if (j3 > 12) {
                return (j2 + 1) + "天";
            }
            return j2 + "天";
        }
        if (j3 > 0) {
            return j3 + "小时";
        }
        if (j4 > 0) {
            return j4 + "分钟";
        }
        return j5 + "秒";
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_7, Locale.CHINA).format(new Date());
    }

    public static String getDay(long j) {
        if (j <= 0) {
            return "00";
        }
        long j2 = (((j / 1000) / 60) / 60) / 24;
        if (j2 < 10) {
            return "0" + j2;
        }
        return "" + j2;
    }

    public static String getFilterDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(2, i);
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(gregorianCalendar.getTime());
    }

    public static String getFormatTime1(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        if (i == i4 && i2 == i5 && i3 == i6) {
            return "今天 " + DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
        }
        calendar.add(5, -1);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2);
        int i9 = calendar.get(5);
        if (i != i7 || i2 != i8 || i3 != i9) {
            return i == i7 ? DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_5, "GMT+8") : DateUtil.dateFormat(j, "yyyy-MM-dd", "GMT+8");
        }
        return "昨天 " + DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
    }

    public static String getFormatTime2(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        if (i == i4 && i2 == i5 && i3 == i6) {
            return "今天 " + DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
        }
        calendar.add(5, -1);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2);
        int i9 = calendar.get(5);
        if (i != i7 || i2 != i8 || i3 != i9) {
            return i == i7 ? DateUtil.dateFormat(j, "MM-dd HH:mm", "GMT+8") : DateUtil.dateFormat(j, "yyyy-MM-dd HH:mm", "GMT+8");
        }
        return "昨天 " + DateUtil.dateFormat(j, DateUtil.DATE_FORMAT_TYPE_7, "GMT+8");
    }

    public static String getFullMinute(long j) {
        return "" + ((j / 1000) / 60);
    }

    public static String getHour(long j) {
        if (j <= 0) {
            return "00";
        }
        long j2 = (((j % 86400000) / 1000) / 60) / 60;
        if (j2 < 10) {
            return "0" + j2;
        }
        return "" + j2;
    }

    public static String getMinute(long j) {
        if (j <= 0) {
            return "00";
        }
        long j2 = ((j % 3600000) / 1000) / 60;
        if (j2 < 10) {
            return "0" + j2;
        }
        return "" + j2;
    }

    public static String getSecond(long j) {
        if (j <= 0) {
            return "00";
        }
        long j2 = (j % 60000) / 1000;
        if (j2 < 10) {
            return "0" + j2;
        }
        return "" + j2;
    }

    public static String getTheEnglishSimpleMonth(int i) {
        switch (i) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "Jul";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return "--";
        }
    }

    public static int getTheMonth(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTimeInMillis(j);
        return calendar.get(2);
    }

    public static int getTheMonthOfDay(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTimeInMillis(j);
        return calendar.get(5);
    }

    public static String getTimeDistance(long j) {
        long j2 = j / 86400000;
        long j3 = 24 * j2;
        long j4 = (j / 3600000) - j3;
        long j5 = j3 * 60;
        long j6 = j4 * 60;
        long j7 = ((j / 60000) - j5) - j6;
        return j2 + "天" + j4 + "小时" + j7 + "分" + ((((j / 1000) - (j5 * 60)) - (j6 * 60)) - (60 * j7)) + "秒";
    }

    public static String getTimeDistance2(long j) {
        long j2 = j / 86400000;
        long j3 = 24 * j2;
        long j4 = (j / 3600000) - j3;
        long j5 = j3 * 60;
        long j6 = j4 * 60;
        long j7 = ((j / 60000) - j5) - j6;
        return j2 + "天" + j4 + "时" + j7 + "分" + ((((j / 1000) - (j5 * 60)) - (j6 * 60)) - (60 * j7)) + "秒";
    }

    public static String getTs() {
        return "" + (System.currentTimeMillis() / 1000);
    }

    public static boolean isSameDay(long j, long j2) {
        return dateFormatYMD(j).equals(dateFormatYMD(j2));
    }

    public static String long2DateString(long j) {
        return DateFormat.format("yyyy-MM-dd kk:mm", j).toString();
    }

    public static String long2DateStringInChinese(long j) {
        char[] cArr = {38646, 19968, 20108, 19977, 22235, 20116, 20845, 19971, 20843, 20061, 21313};
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(j));
        String strSubstring = str.substring(0, 4);
        String strSubstring2 = str.substring(5, 7);
        String strSubstring3 = str.substring(8, 10);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(cArr[strSubstring.charAt(0) - '0']));
        sb.append(String.valueOf(cArr[strSubstring.charAt(1) - '0']));
        sb.append(String.valueOf(cArr[strSubstring.charAt(2) - '0']));
        sb.append(String.valueOf(cArr[strSubstring.charAt(3) - '0']));
        sb.append("年");
        String str2 = "十";
        sb.append(strSubstring2.charAt(0) + 65488 > 0 ? "十" : "");
        sb.append(strSubstring2.charAt(1) + 65488 > 0 ? String.valueOf(cArr[strSubstring2.charAt(1) - '0']) : "");
        sb.append("月");
        if (strSubstring3.charAt(0) - '0' <= 0) {
            str2 = "";
        } else if (strSubstring3.charAt(0) - '1' != 0) {
            str2 = String.valueOf(cArr[strSubstring3.charAt(0) - '0']) + "十";
        }
        sb.append(str2);
        sb.append(strSubstring3.charAt(1) + 65488 > 0 ? String.valueOf(cArr[strSubstring3.charAt(1) - '0']) : "");
        sb.append("日");
        return sb.toString();
    }

    public static String secondsToHHMMSS(long j) {
        long j2 = j / a33.p;
        long j3 = j2 * 60;
        long j4 = (j / 60) - j3;
        return j2 + ":" + j4 + ":" + ((j - (j3 * 60)) - (60 * j4));
    }

    public static Date string2Date(String str) {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2, Locale.CHINA).parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String stringDateFormatLong(String str) {
        return new SimpleDateFormat("yyyyMMddHHMMSS", Locale.CHINA).format(string2Date(str));
    }

    public static String timeFormat(long j) {
        return getHour(j) + ":" + getMinute(j) + ":" + getSecond(j);
    }

    public static String dataFormatString(String str) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(string2Date(str));
    }

    public static String dateFormat(long j) {
        Date date = new Date(j);
        return new SimpleDateFormat("yyyy年MM月dd日HH:mm", Locale.CHINA).format(date) + " ";
    }

    public static String dateFormat2(long j) {
        return dateFormat2(new Date(j));
    }

    public static String dateFormatYMD(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2, i3);
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(gregorianCalendar.getTime()) + "";
    }
}
