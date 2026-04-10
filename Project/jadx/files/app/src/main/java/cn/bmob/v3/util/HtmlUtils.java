package cn.bmob.v3.util;

import cn.bmob.v3.helper.ErrorCode;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class HtmlUtils {
    private static Pattern HTML_TITLE_PATTERN = Pattern.compile("<title>.*?</title>");
    private static Pattern HTML_CODE_PATTERN = Pattern.compile("<div class=\"K\">.*?</div>");
    private static Pattern HTML_MESSAGE_PATTERN = Pattern.compile("<div class=\"O I\">.*?</div>");
    private static Pattern HTML_IP_PATTERN = Pattern.compile("<span class=\"F\">.*?</span>");

    private static String get(Pattern pattern, String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        String str2 = "";
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 == 0) {
                str2 = str2 + ((String) arrayList.get(i2));
            }
        }
        return outTag(str2);
    }

    public static Integer getCode(String str) {
        Integer numValueOf = Integer.valueOf(ErrorCode.E9015);
        try {
            return Integer.valueOf(get(HTML_CODE_PATTERN, str));
        } catch (Exception e2) {
            BLog.e(e2);
            return numValueOf;
        }
    }

    public static String getIp(String str) {
        return get(HTML_IP_PATTERN, str);
    }

    public static String getMessage(String str) {
        return get(HTML_MESSAGE_PATTERN, str);
    }

    public static String getTitle(String str) {
        return get(HTML_TITLE_PATTERN, str);
    }

    public static String outTag(String str) {
        return str.replaceAll("<.*?>", "");
    }
}
