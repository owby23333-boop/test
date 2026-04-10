package miuix.pickerwidget.internal.util;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import miuix.core.util.Pools;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleNumberFormatter {
    private static Locale sLocale = Locale.getDefault();
    private static char sZeroDigit = new DecimalFormatSymbols(sLocale).getZeroDigit();

    private static String convertInt(int i, int i2) {
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        if (i2 < 0) {
            i2 = -i2;
            i--;
            sbAcquire.append('-');
        }
        if (i2 >= 10000) {
            String string = Integer.toString(i2);
            for (int length = string.length(); length < i; length++) {
                sbAcquire.append('0');
            }
            sbAcquire.append(string);
        } else {
            for (int i3 = i2 >= 1000 ? 4 : i2 >= 100 ? 3 : i2 >= 10 ? 2 : 1; i3 < i; i3++) {
                sbAcquire.append('0');
            }
            sbAcquire.append(i2);
        }
        String string2 = sbAcquire.toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string2;
    }

    public static String format(int i) {
        return format(-1, i);
    }

    private static char getZeroDigit(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        if (!locale.equals(sLocale)) {
            sZeroDigit = new DecimalFormatSymbols(locale).getZeroDigit();
            sLocale = locale;
        }
        return sZeroDigit;
    }

    private static String localizeDigits(char c, String str) {
        int length = str.length();
        int i = c - '0';
        StringBuilder sbAcquire = Pools.getStringBuilderPool().acquire();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                cCharAt = (char) (cCharAt + i);
            }
            sbAcquire.append(cCharAt);
        }
        String string = sbAcquire.toString();
        Pools.getStringBuilderPool().release(sbAcquire);
        return string;
    }

    public static String format(int i, int i2) {
        char zeroDigit = getZeroDigit(Locale.getDefault());
        String strConvertInt = convertInt(i, i2);
        return zeroDigit != '0' ? localizeDigits(zeroDigit, strConvertInt) : strConvertInt;
    }
}
