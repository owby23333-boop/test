package com.amgcyo.cuttadon.utils.otherutils;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: MkDateFormat.java */
/* JADX INFO: loaded from: classes.dex */
public class y {
    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                return simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(str2)) < 0;
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "1分钟前";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            long time = new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(simpleDateFormat.parse(str))).getTime();
            if (time < 60000) {
                long jE = e(time);
                StringBuilder sb = new StringBuilder();
                if (jE <= 0) {
                    jE = 1;
                }
                sb.append(jE);
                sb.append("秒前");
                return sb.toString();
            }
            if (time < 2700000) {
                long jC = c(time);
                StringBuilder sb2 = new StringBuilder();
                if (jC <= 0) {
                    jC = 1;
                }
                sb2.append(jC);
                sb2.append("分钟前");
                return sb2.toString();
            }
            if (time < 86400000) {
                long jB = b(time);
                StringBuilder sb3 = new StringBuilder();
                if (jB <= 0) {
                    jB = 1;
                }
                sb3.append(jB);
                sb3.append("小时前");
                return sb3.toString();
            }
            if (time < bj.f12907e) {
                return "昨天";
            }
            if (time < 2592000000L) {
                long jA = a(time);
                StringBuilder sb4 = new StringBuilder();
                if (jA <= 0) {
                    jA = 1;
                }
                sb4.append(jA);
                sb4.append("天前");
                return sb4.toString();
            }
            if (time < 29030400000L) {
                long jD = d(time);
                StringBuilder sb5 = new StringBuilder();
                if (jD <= 0) {
                    jD = 1;
                }
                sb5.append(jD);
                sb5.append("个月前");
                return sb5.toString();
            }
            long jF = f(time);
            StringBuilder sb6 = new StringBuilder();
            if (jF <= 0) {
                jF = 1;
            }
            sb6.append(jF);
            sb6.append("年前");
            return sb6.toString();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "出现异常";
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "1分钟前";
        }
        try {
            long time = new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str).getTime();
            if (time < 60000) {
                long jE = e(time);
                StringBuilder sb = new StringBuilder();
                if (jE <= 0) {
                    jE = 1;
                }
                sb.append(jE);
                sb.append("秒前");
                return sb.toString();
            }
            if (time < 2700000) {
                long jC = c(time);
                StringBuilder sb2 = new StringBuilder();
                if (jC <= 0) {
                    jC = 1;
                }
                sb2.append(jC);
                sb2.append("分钟前");
                return sb2.toString();
            }
            if (time < 86400000) {
                long jB = b(time);
                StringBuilder sb3 = new StringBuilder();
                if (jB <= 0) {
                    jB = 1;
                }
                sb3.append(jB);
                sb3.append("小时前");
                return sb3.toString();
            }
            if (time < bj.f12907e) {
                return "昨天";
            }
            if (time < 2592000000L) {
                long jA = a(time);
                StringBuilder sb4 = new StringBuilder();
                if (jA <= 0) {
                    jA = 1;
                }
                sb4.append(jA);
                sb4.append("天前");
                return sb4.toString();
            }
            if (time < 29030400000L) {
                long jD = d(time);
                StringBuilder sb5 = new StringBuilder();
                if (jD <= 0) {
                    jD = 1;
                }
                sb5.append(jD);
                sb5.append("个月前");
                return sb5.toString();
            }
            long jF = f(time);
            StringBuilder sb6 = new StringBuilder();
            if (jF <= 0) {
                jF = 1;
            }
            sb6.append(jF);
            sb6.append("年前");
            return sb6.toString();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String d(String str) {
        if (!TimeZone.getDefault().getID().equals(TimeZone.getTimeZone("Asia/Shanghai").getID())) {
            str = e(str);
        }
        long jB = b(str, null);
        if (jB == 0) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        if ((jB + "").length() == 10) {
            jB *= 1000;
        }
        calendar.setTimeInMillis(jB);
        Date time = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        if (calendar2.before(calendar)) {
            return a(calendar, new SimpleDateFormat("H:mm", Locale.CHINA).format(time));
        }
        calendar2.add(5, -1);
        if (calendar2.before(calendar)) {
            return "昨天 " + a(calendar, new SimpleDateFormat("H:mm", Locale.CHINA).format(time));
        }
        calendar2.set(5, 1);
        calendar2.set(2, 0);
        if (calendar2.before(calendar)) {
            return new SimpleDateFormat("M月d日", Locale.CHINA).format(time) + a(calendar, new SimpleDateFormat("H:mm", Locale.CHINA).format(time));
        }
        return new SimpleDateFormat("yyyy/M/d ", Locale.CHINA).format(time) + a(calendar, new SimpleDateFormat("H:mm", Locale.CHINA).format(time));
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 0) {
            str = a();
        }
        return a(a(a(str), TimeZone.getTimeZone("Asia/Shanghai"), TimeZone.getDefault()));
    }

    private static long f(long j2) {
        return d(j2) / 365;
    }

    public static long f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return System.currentTimeMillis();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(simpleDateFormat.parse(str))).getTime();
        } catch (Exception e2) {
            g.a(e2);
            e2.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
    }

    private static long e(long j2) {
        return j2 / 1000;
    }

    public static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Date a(Date date, TimeZone timeZone, TimeZone timeZone2) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime() - ((long) (timeZone.getOffset(date.getTime()) - timeZone2.getOffset(date.getTime()))));
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }

    public static String a(Calendar calendar, String str) {
        if (calendar.get(11) > 12) {
            return "下午 " + str;
        }
        return "上午 " + str;
    }

    private static long c(long j2) {
        return e(j2) / 60;
    }

    private static long a(long j2) {
        return b(j2) / 24;
    }

    public static long b(String str, String str2) {
        if (str == null) {
            return 0L;
        }
        if (str2 == null) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            Date date = new SimpleDateFormat(str2).parse(str);
            if (date != null) {
                return date.getTime() / 1000;
            }
            return 0L;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private static long b(long j2) {
        return c(j2) / 60;
    }

    private static long d(long j2) {
        return a(j2) / 30;
    }
}
