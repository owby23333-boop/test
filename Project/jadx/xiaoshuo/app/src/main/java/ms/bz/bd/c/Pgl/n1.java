package ms.bz.bd.c.Pgl;

import kotlin.text.Typography;
import org.apache.commons.lang.CharUtils;

/* JADX INFO: loaded from: classes9.dex */
public class n1 {
    static {
    }

    public static String e(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace(CharUtils.CR, ' ').replace('\n', ' ');
    }
}
