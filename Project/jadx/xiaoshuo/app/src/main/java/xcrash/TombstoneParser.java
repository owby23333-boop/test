package xcrash;

import android.os.Build;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.util.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class TombstoneParser {
    public static final String keyCode = "code";
    public static final String keyFaultAddr = "fault addr";
    public static final String keyForeground = "foreground";
    public static final String keyMemoryInfo = "memory info";
    public static final String keyMemoryNear = "memory near";
    public static final String keyModel = "Model";
    public static final String keyNetworkInfo = "network info";
    public static final String keyOtherThreads = "other threads";
    public static final String keyProcessId = "pid";
    public static final String keyProcessName = "pname";
    public static final String keyRegisters = "registers";
    public static final String keySignal = "signal";
    public static final String keyThreadId = "tid";
    public static final String keyThreadName = "tname";
    private static final Pattern patHeadItem = Pattern.compile("^(.*):\\s'(.*?)'$");
    private static final Pattern patProcessThread = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern patProcess = Pattern.compile("^pid:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern patSignalCode = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern patAppVersionProcessName = Pattern.compile("^(\\d{20})_(.*)__(.*)$");
    public static final String keyTombstoneMaker = "Tombstone maker";
    public static final String keyCrashType = "Crash type";
    public static final String keyStartTime = "Start time";
    public static final String keyCrashTime = "Crash time";
    public static final String keyAppId = "App ID";
    public static final String keyAppVersion = "App version";
    public static final String keyRooted = "Rooted";
    public static final String keyApiLevel = "API level";
    public static final String keyOsVersion = "OS version";
    public static final String keyKernelVersion = "Kernel version";
    public static final String keyAbiList = "ABI list";
    public static final String keyManufacturer = "Manufacturer";
    public static final String keyBrand = "Brand";
    public static final String keyBuildFingerprint = "Build fingerprint";
    public static final String keyAbi = "ABI";
    public static final String keyAbortMessage = "Abort message";
    private static final Set<String> keyHeadItems = new HashSet(Arrays.asList(keyTombstoneMaker, keyCrashType, keyStartTime, keyCrashTime, keyAppId, keyAppVersion, keyRooted, keyApiLevel, keyOsVersion, keyKernelVersion, keyAbiList, keyManufacturer, keyBrand, "Model", keyBuildFingerprint, keyAbi, keyAbortMessage));
    public static final String keyBacktrace = "backtrace";
    public static final String keyBuildId = "build id";
    public static final String keyStack = "stack";
    public static final String keyMemoryMap = "memory map";
    public static final String keyLogcat = "logcat";
    public static final String keyOpenFiles = "open files";
    public static final String keyJavaStacktrace = "java stacktrace";
    public static final String keyXCrashError = "xcrash error";
    public static final String keyXCrashErrorDebug = "xcrash error debug";
    private static final Set<String> keySections = new HashSet(Arrays.asList(keyBacktrace, keyBuildId, keyStack, keyMemoryMap, keyLogcat, keyOpenFiles, keyJavaStacktrace, keyXCrashError, keyXCrashErrorDebug));
    private static final Set<String> keySingleLineSections = new HashSet(Arrays.asList("foreground"));

    /* JADX INFO: renamed from: xcrash.TombstoneParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$xcrash$TombstoneParser$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$xcrash$TombstoneParser$Status = iArr;
            try {
                iArr[Status.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$xcrash$TombstoneParser$Status[Status.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$xcrash$TombstoneParser$Status[Status.SECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Status {
        UNKNOWN,
        HEAD,
        SECTION
    }

    private TombstoneParser() {
    }

    private static void addSystemInfo(Map<String, String> map) {
        if (TextUtils.isEmpty(map.get(keyAppId))) {
            map.put(keyAppId, XCrash.getAppId());
        }
        if (TextUtils.isEmpty(map.get(keyTombstoneMaker))) {
            map.put(keyTombstoneMaker, "xCrash 2.4.9");
        }
        if (TextUtils.isEmpty(map.get(keyRooted))) {
            map.put(keyRooted, Util.isRoot() ? "Yes" : "No");
        }
        if (TextUtils.isEmpty(map.get(keyApiLevel))) {
            map.put(keyApiLevel, String.valueOf(Build.VERSION.SDK_INT));
        }
        if (TextUtils.isEmpty(map.get(keyOsVersion))) {
            map.put(keyOsVersion, Build.VERSION.RELEASE);
        }
        if (TextUtils.isEmpty(map.get(keyBuildFingerprint))) {
            map.put("Model", Build.FINGERPRINT);
        }
        if (TextUtils.isEmpty(map.get(keyManufacturer))) {
            map.put(keyManufacturer, Build.MANUFACTURER);
        }
        if (TextUtils.isEmpty(map.get(keyBrand))) {
            map.put(keyBrand, Build.BRAND);
        }
        if (TextUtils.isEmpty(map.get("Model"))) {
            map.put("Model", Build.MODEL);
        }
        if (TextUtils.isEmpty(map.get(keyAbiList))) {
            map.put(keyAbiList, Util.getAbiList());
        }
    }

    public static Map<String, String> parse(File file) throws IOException {
        return parse(file.getAbsolutePath(), null);
    }

    private static void parseFromLogPath(Map<String, String> map, String str) {
        String strSubstring;
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(map.get(keyCrashTime))) {
            map.put(keyCrashTime, new SimpleDateFormat(StdDateFormat.DATE_FORMAT_STR_ISO8601, Locale.US).format(new Date(new File(str).lastModified())));
        }
        String str2 = map.get(keyStartTime);
        String str3 = map.get(keyAppVersion);
        String str4 = map.get(keyProcessName);
        String str5 = map.get(keyCrashType);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            String strSubstring2 = str.substring(str.lastIndexOf(47) + 1);
            if (!strSubstring2.isEmpty() && strSubstring2.startsWith("tombstone_")) {
                String strSubstring3 = strSubstring2.substring(10);
                if (strSubstring3.endsWith(".java.xcrash")) {
                    if (TextUtils.isEmpty(str5)) {
                        map.put(keyCrashType, "java");
                    }
                    strSubstring = strSubstring3.substring(0, strSubstring3.length() - 12);
                } else if (strSubstring3.endsWith(".native.xcrash")) {
                    if (TextUtils.isEmpty(str5)) {
                        map.put(keyCrashType, "native");
                    }
                    strSubstring = strSubstring3.substring(0, strSubstring3.length() - 14);
                } else {
                    if (!strSubstring3.endsWith(".anr.xcrash")) {
                        return;
                    }
                    if (TextUtils.isEmpty(str5)) {
                        map.put(keyCrashType, CrashAnalysis.ANR_CRASH);
                    }
                    strSubstring = strSubstring3.substring(0, strSubstring3.length() - 11);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                    Matcher matcher = patAppVersionProcessName.matcher(strSubstring);
                    if (matcher.find() && matcher.groupCount() == 3) {
                        if (TextUtils.isEmpty(str2)) {
                            map.put(keyStartTime, new SimpleDateFormat(StdDateFormat.DATE_FORMAT_STR_ISO8601, Locale.US).format(new Date(Long.parseLong(matcher.group(1), 10) / 1000)));
                        }
                        if (TextUtils.isEmpty(str3)) {
                            map.put(keyAppVersion, matcher.group(2));
                        }
                        if (TextUtils.isEmpty(str4)) {
                            map.put(keyProcessName, matcher.group(3));
                        }
                    }
                }
            }
        }
    }

    private static void parseFromReader(Map<String, String> map, BufferedReader bufferedReader, boolean z) throws IOException {
        int i;
        StringBuilder sb = new StringBuilder();
        Status status = Status.UNKNOWN;
        String lineInBinary = z ? readLineInBinary(bufferedReader) : bufferedReader.readLine();
        int i2 = 1;
        int i3 = lineInBinary == null ? 1 : 0;
        String str = null;
        String str2 = "";
        boolean z2 = false;
        boolean zEquals = false;
        while (i3 == 0) {
            String lineInBinary2 = z ? readLineInBinary(bufferedReader) : bufferedReader.readLine();
            int i4 = lineInBinary2 == null ? i2 : 0;
            int i5 = AnonymousClass1.$SwitchMap$xcrash$TombstoneParser$Status[status.ordinal()];
            if (i5 != i2) {
                if (i5 == 2) {
                    if (lineInBinary.startsWith("pid: ")) {
                        Matcher matcher = patProcessThread.matcher(lineInBinary);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            putKeyValue(map, "pid", matcher.group(1));
                            putKeyValue(map, "tid", matcher.group(2));
                            putKeyValue(map, keyThreadName, matcher.group(3));
                            putKeyValue(map, keyProcessName, matcher.group(4));
                        } else {
                            Matcher matcher2 = patProcess.matcher(lineInBinary);
                            if (matcher2.find() && matcher2.groupCount() == 2) {
                                putKeyValue(map, "pid", matcher2.group(1));
                                putKeyValue(map, keyProcessName, matcher2.group(2));
                            }
                        }
                    } else if (lineInBinary.startsWith("signal ")) {
                        Matcher matcher3 = patSignalCode.matcher(lineInBinary);
                        if (matcher3.find() && matcher3.groupCount() == 3) {
                            putKeyValue(map, keySignal, matcher3.group(1));
                            putKeyValue(map, "code", matcher3.group(2));
                            putKeyValue(map, keyFaultAddr, matcher3.group(3));
                        }
                    } else {
                        Matcher matcher4 = patHeadItem.matcher(lineInBinary);
                        if (matcher4.find() && matcher4.groupCount() == 2 && keyHeadItems.contains(matcher4.group(1))) {
                            putKeyValue(map, matcher4.group(1), matcher4.group(2));
                        }
                    }
                    if (lineInBinary2 != null && (lineInBinary2.startsWith("    r0 ") || lineInBinary2.startsWith("    x0 ") || lineInBinary2.startsWith("    eax ") || lineInBinary2.startsWith("    rax "))) {
                        status = Status.SECTION;
                        str = keyRegisters;
                        str2 = "";
                        z2 = true;
                        zEquals = false;
                    }
                    if (lineInBinary2 == null || lineInBinary2.isEmpty()) {
                        status = Status.UNKNOWN;
                    }
                } else if (i5 == 3) {
                    if (lineInBinary.equals(str2) || i4 != 0) {
                        if (keySingleLineSections.contains(str) && sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        putKeyValue(map, str, sb.toString(), zEquals);
                        sb.setLength(0);
                        status = Status.UNKNOWN;
                    } else {
                        if (z2) {
                            if (str.equals(keyJavaStacktrace) && lineInBinary.startsWith(" ")) {
                                lineInBinary = lineInBinary.trim();
                            } else if (lineInBinary.startsWith("    ")) {
                                lineInBinary = lineInBinary.substring(4);
                            }
                        }
                        sb.append(lineInBinary);
                        sb.append('\n');
                    }
                }
            } else if (lineInBinary.equals(b.d)) {
                status = Status.HEAD;
            } else {
                if (lineInBinary.equals(b.e)) {
                    status = Status.SECTION;
                    sb.append(lineInBinary);
                    sb.append('\n');
                    str2 = b.f;
                    str = keyOtherThreads;
                    i = 1;
                    z2 = false;
                    zEquals = false;
                } else {
                    i = 1;
                    if (lineInBinary.length() > 1 && lineInBinary.endsWith(":")) {
                        status = Status.SECTION;
                        String strSubstring = lineInBinary.substring(0, lineInBinary.length() - 1);
                        if (keySections.contains(strSubstring)) {
                            z2 = strSubstring.equals(keyBacktrace) || strSubstring.equals(keyBuildId) || strSubstring.equals(keyStack) || strSubstring.equals(keyMemoryMap) || strSubstring.equals(keyOpenFiles) || strSubstring.equals(keyJavaStacktrace) || strSubstring.equals(keyXCrashErrorDebug);
                            zEquals = strSubstring.equals(keyXCrashError);
                            str = strSubstring;
                            str2 = "";
                        } else {
                            if (strSubstring.equals(keyMemoryInfo)) {
                                str = strSubstring;
                            } else if (strSubstring.startsWith("memory near ")) {
                                sb.append(lineInBinary);
                                sb.append('\n');
                                str = keyMemoryNear;
                            } else {
                                str = strSubstring;
                                str2 = "";
                                z2 = false;
                                zEquals = false;
                            }
                            zEquals = true;
                            str2 = "";
                            z2 = false;
                        }
                    }
                    i2 = i;
                    lineInBinary = lineInBinary2;
                    i3 = i4;
                }
                i2 = i;
                lineInBinary = lineInBinary2;
                i3 = i4;
            }
            i = 1;
            i2 = i;
            lineInBinary = lineInBinary2;
            i3 = i4;
        }
    }

    private static void putKeyValue(Map<String, String> map, String str, String str2) {
        putKeyValue(map, str, str2, false);
    }

    private static String readLineInBinary(BufferedReader bufferedReader) throws IOException {
        try {
            bufferedReader.mark(2);
            for (int i = 0; i < 2; i++) {
                try {
                    int i2 = bufferedReader.read();
                    if (i2 == -1) {
                        bufferedReader.reset();
                        return null;
                    }
                    if (i2 > 0) {
                        bufferedReader.reset();
                        return bufferedReader.readLine();
                    }
                } catch (Exception unused) {
                    bufferedReader.reset();
                    return bufferedReader.readLine();
                }
            }
            bufferedReader.reset();
            return null;
        } catch (Exception unused2) {
            return bufferedReader.readLine();
        }
    }

    public static Map<String, String> parse(String str) throws IOException {
        return parse(str, null);
    }

    private static void putKeyValue(Map<String, String> map, String str, String str2, boolean z) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        String str3 = map.get(str);
        if (!z) {
            if (str3 == null || (str3.isEmpty() && !str2.isEmpty())) {
                map.put(str, str2);
                return;
            }
            return;
        }
        if (str3 != null) {
            str2 = str3 + str2;
        }
        map.put(str, str2);
    }

    public static Map<String, String> parse(String str, String str2) throws IOException {
        HashMap map = new HashMap();
        if (str != null) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            parseFromReader(map, bufferedReader, true);
            bufferedReader.close();
        }
        if (str2 != null) {
            BufferedReader bufferedReader2 = new BufferedReader(new StringReader(str2));
            parseFromReader(map, bufferedReader2, false);
            bufferedReader2.close();
        }
        parseFromLogPath(map, str);
        if (TextUtils.isEmpty((String) map.get(keyAppVersion))) {
            String appVersion = XCrash.getAppVersion();
            if (TextUtils.isEmpty(appVersion)) {
                appVersion = "unknown";
            }
            map.put(keyAppVersion, appVersion);
        }
        addSystemInfo(map);
        return map;
    }
}
