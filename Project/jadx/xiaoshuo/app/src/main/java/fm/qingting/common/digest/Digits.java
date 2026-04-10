package fm.qingting.common.digest;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes8.dex */
public class Digits {
    private static final char[] lowerCaseDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] upperCaseDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String bytesToHex(byte[] bytes, boolean upperCase) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        char[] cArr = upperCase ? upperCaseDigits : lowerCaseDigits;
        for (byte b2 : bytes) {
            sb.append(cArr[(b2 & 240) >> 4]);
            sb.append(cArr[b2 & Ascii.SI]);
        }
        return sb.toString();
    }

    public static String bytesToHex(byte[] bytes, boolean upperCase, String delimiter) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        char[] cArr = upperCase ? upperCaseDigits : lowerCaseDigits;
        for (byte b2 : bytes) {
            sb.append(cArr[(b2 & 240) >> 4]);
            sb.append(cArr[b2 & Ascii.SI]);
            sb.append(delimiter);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - delimiter.length());
        }
        return sb.toString();
    }
}
