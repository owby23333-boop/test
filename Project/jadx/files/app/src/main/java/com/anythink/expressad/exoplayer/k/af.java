package com.anythink.expressad.exoplayer.k;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class af {
    public static final int a;
    public static final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9818f = "Util";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f9819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f9820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f9821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f9822j;

    static {
        a = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        b = Build.DEVICE;
        f9815c = Build.MANUFACTURER;
        f9816d = Build.MODEL;
        f9817e = b + ", " + f9816d + ", " + f9815c + ", " + a;
        f9819g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f9820h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f9821i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f9822j = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    private af() {
    }

    @TargetApi(23)
    private static boolean a() {
        return false;
    }

    private static boolean a(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static boolean a(int i2) {
        return i2 == 10 || i2 == 13;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static int b(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    @Nullable
    public static String b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return d(str);
        }
    }

    public static boolean b(int i2) {
        return i2 == 3 || i2 == 2 || i2 == Integer.MIN_VALUE || i2 == 1073741824 || i2 == 4;
    }

    public static boolean c(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == 1073741824;
    }

    public static byte[] c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static int d(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 == 1) {
            return 13;
        }
        if (i2 == 2) {
            return 6;
        }
        int i3 = 4;
        if (i2 != 4) {
            i3 = 5;
            if (i2 != 5) {
                return i2 != 8 ? 1 : 3;
            }
        }
        return i3;
    }

    private static long d(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j2 ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static int e(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 8) ? 4 : 2;
        }
        return 1;
    }

    private static long e(long j2, long j3) {
        long j4 = j2 - j3;
        if (((j2 ^ j4) & (j3 ^ j2)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    public static int f(int i2) {
        switch (i2) {
        }
        return 3;
    }

    public static int f(String str) {
        int length = str.length();
        a.a(length <= 4);
        int iCharAt = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCharAt = (iCharAt << 8) | str.charAt(i2);
        }
        return iCharAt;
    }

    public static byte[] g(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    private static int h(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static String h(String str) {
        int length = str.length();
        int iEnd = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '%') {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        int i4 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i4);
        Matcher matcher = f9821i.matcher(str);
        while (i2 > 0 && matcher.find()) {
            char c2 = (char) Integer.parseInt(matcher.group(1), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            i2--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i4) {
            return null;
        }
        return sb.toString();
    }

    private static long i(String str) {
        Matcher matcher = f9820h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        double d3 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d4 = d3 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d5 = d4 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d6 = d5 + (strGroup4 != null ? 3600.0d * Double.parseDouble(strGroup4) : 0.0d);
        String strGroup5 = matcher.group(12);
        double d7 = d6 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        if (strGroup6 != null) {
            d2 = Double.parseDouble(strGroup6);
        }
        long j2 = (long) ((d7 + d2) * 1000.0d);
        return zIsEmpty ? -j2 : j2;
    }

    private static long j(String str) throws com.anythink.expressad.exoplayer.t {
        Matcher matcher = f9819g.matcher(str);
        if (!matcher.matches()) {
            throw new com.anythink.expressad.exoplayer.t("Invalid date/time format: ".concat(String.valueOf(str)));
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - ((long) (i2 * BaseConstants.Time.MINUTE)) : timeInMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.UUID k(java.lang.String r5) {
        /*
            java.lang.String r0 = d(r5)
            int r1 = r0.hashCode()
            r2 = -1860423953(0xffffffff911c2eef, float:-1.2320693E-28)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L2e
            r2 = -1400551171(0xffffffffac8548fd, float:-3.7881907E-12)
            if (r1 == r2) goto L24
            r2 = 790309106(0x2f1b28f2, float:1.4111715E-10)
            if (r1 == r2) goto L1a
            goto L38
        L1a:
            java.lang.String r1 = "clearkey"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = 2
            goto L39
        L24:
            java.lang.String r1 = "widevine"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = 0
            goto L39
        L2e:
            java.lang.String r1 = "playready"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r0 = 1
            goto L39
        L38:
            r0 = -1
        L39:
            if (r0 == 0) goto L4c
            if (r0 == r4) goto L49
            if (r0 == r3) goto L46
            java.util.UUID r5 = java.util.UUID.fromString(r5)     // Catch: java.lang.RuntimeException -> L44
            return r5
        L44:
            r5 = 0
            return r5
        L46:
            java.util.UUID r5 = com.anythink.expressad.exoplayer.b.bj
            return r5
        L49:
            java.util.UUID r5 = com.anythink.expressad.exoplayer.b.bl
            return r5
        L4c:
            java.util.UUID r5 = com.anythink.expressad.exoplayer.b.bk
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.af.k(java.lang.String):java.util.UUID");
    }

    private static int l(String str) {
        String strD = d(str);
        if (strD.endsWith(".mpd")) {
            return 0;
        }
        if (strD.endsWith(".m3u8")) {
            return 2;
        }
        return strD.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    private static String m(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (a(str.charAt(i4))) {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i3 * 2) + length);
        while (i3 > 0) {
            int i5 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (a(cCharAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(cCharAt));
                i3--;
            } else {
                sb.append(cCharAt);
            }
            i2 = i5;
        }
        if (i2 < length) {
            sb.append((CharSequence) str, i2, length);
        }
        return sb.toString();
    }

    private static long c(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    private static void d(Display display, Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    private static String[] b(String str, String str2) {
        return str.split(str2, 2);
    }

    private static File c(Context context, String str) {
        return File.createTempFile(str, null, context.getCacheDir());
    }

    private static <T> int b(List<? extends Comparable<? super T>> list, T t2, boolean z2, boolean z3) {
        int i2;
        int iBinarySearch = Collections.binarySearch(list, t2);
        if (iBinarySearch < 0) {
            i2 = iBinarySearch ^ (-1);
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t2) == 0);
            i2 = z2 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z3 ? Math.min(list.size() - 1, i2) : i2;
    }

    @TargetApi(16)
    private static void c(Display display, Point point) {
        display.getSize(point);
    }

    public static ComponentName a(Context context, Intent intent) {
        if (a >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static int g(int i2) {
        if (i2 == 0) {
            return 16777216;
        }
        if (i2 == 1) {
            return com.anythink.expressad.exoplayer.b.aZ;
        }
        if (i2 == 2) {
            return com.anythink.expressad.exoplayer.b.aY;
        }
        if (i2 == 3 || i2 == 4) {
            return 131072;
        }
        throw new IllegalStateException();
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || BmobDbOpenHelper.FILE.equals(scheme);
    }

    public static long b(long j2, float f2) {
        if (f2 == 1.0f) {
            return j2;
        }
        double d2 = j2;
        double d3 = f2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return Math.round(d2 / d3);
    }

    public static int b(int i2, int i3) {
        if (i2 == Integer.MIN_VALUE) {
            return i3 * 3;
        }
        if (i2 != 1073741824) {
            if (i2 == 2) {
                return i3 * 2;
            }
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                throw new IllegalArgumentException();
            }
        }
        return i3 * 4;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int b(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return l(path);
    }

    private static boolean a(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (a(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    private static <T extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }

    public static <T> void a(List<T> list, int i2, int i3) {
        list.subList(i2, i3).clear();
    }

    @TargetApi(17)
    private static void b(Display display, Point point) {
        display.getRealSize(point);
    }

    public static <T> T[] a(T[] tArr, int i2) {
        a.a(i2 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i2);
    }

    private static File b(Context context, String str) throws IOException {
        File fileCreateTempFile = File.createTempFile(str, null, context.getCacheDir());
        fileCreateTempFile.delete();
        fileCreateTempFile.mkdir();
        return fileCreateTempFile;
    }

    public static ExecutorService a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.anythink.expressad.exoplayer.k.af.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    public static void a(com.anythink.expressad.exoplayer.j.h hVar) {
        if (hVar != null) {
            try {
                hVar.b();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void a(Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static String a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charset.forName("UTF-8"));
    }

    public static String[] a(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int a(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static long a(long j2, long j3) {
        return Math.max(0L, Math.min(j2, j3));
    }

    public static float a(float f2) {
        return Math.max(0.1f, Math.min(f2, 8.0f));
    }

    public static int a(int[] iArr, int i2) {
        int iBinarySearch = Arrays.binarySearch(iArr, i2);
        if (iBinarySearch < 0) {
            return -(iBinarySearch + 2);
        }
        do {
            iBinarySearch--;
            if (iBinarySearch < 0) {
                break;
            }
        } while (iArr[iBinarySearch] == i2);
        return iBinarySearch;
    }

    public static int a(long[] jArr, long j2, boolean z2) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j2);
            i2 = iBinarySearch + 1;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    private static <T> int a(List<? extends Comparable<? super T>> list, T t2, boolean z2, boolean z3) {
        int i2;
        int iBinarySearch = Collections.binarySearch(list, t2);
        if (iBinarySearch < 0) {
            i2 = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(t2) == 0);
            i2 = z2 ? iBinarySearch + 1 : iBinarySearch;
        }
        return z3 ? Math.max(0, i2) : i2;
    }

    public static int a(long[] jArr, long j2, boolean z2, boolean z3) {
        int i2;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i2 = iBinarySearch ^ (-1);
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j2);
            i2 = z2 ? iBinarySearch - 1 : iBinarySearch;
        }
        return z3 ? Math.min(jArr.length - 1, i2) : i2;
    }

    public static long a(long j2, long j3, long j4) {
        if (j4 >= j3 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (j4 < j3 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        double d2 = j3;
        double d3 = j4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = j2;
        Double.isNaN(d4);
        return (long) (d4 * (d2 / d3));
    }

    private static long[] a(List<Long> list, long j2, long j3) {
        long[] jArr = new long[list.size()];
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = list.get(i2).longValue() / j4;
                i2++;
            }
        } else if (j3 < j2 && j2 % j3 == 0) {
            long j5 = j2 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = list.get(i2).longValue() * j5;
                i2++;
            }
        } else {
            double d2 = j2;
            double d3 = j3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = d2 / d3;
            while (i2 < jArr.length) {
                double dLongValue = list.get(i2).longValue();
                Double.isNaN(dLongValue);
                jArr[i2] = (long) (dLongValue * d4);
                i2++;
            }
        }
        return jArr;
    }

    public static void a(long[] jArr, long j2) {
        int i2 = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
            return;
        }
        if (j2 < 1000000 && 1000000 % j2 == 0) {
            long j4 = 1000000 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j4;
                i2++;
            }
            return;
        }
        double d2 = j2;
        Double.isNaN(d2);
        double d3 = 1000000.0d / d2;
        while (i2 < jArr.length) {
            double d4 = jArr[i2];
            Double.isNaN(d4);
            jArr[i2] = (long) (d4 * d3);
            i2++;
        }
    }

    public static long a(long j2, float f2) {
        if (f2 == 1.0f) {
            return j2;
        }
        double d2 = j2;
        double d3 = f2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return Math.round(d2 * d3);
    }

    public static long a(long j2, com.anythink.expressad.exoplayer.ac acVar, long j3, long j4) {
        if (com.anythink.expressad.exoplayer.ac.a.equals(acVar)) {
            return j2;
        }
        long j5 = acVar.f8463f;
        long j6 = j2 - j5;
        if (((j5 ^ j2) & (j2 ^ j6)) < 0) {
            j6 = Long.MIN_VALUE;
        }
        long j7 = acVar.f8464g;
        long j8 = j2 + j7;
        if (((j7 ^ j8) & (j2 ^ j8)) < 0) {
            j8 = Long.MAX_VALUE;
        }
        boolean z2 = j6 <= j3 && j3 <= j8;
        boolean z3 = j6 <= j4 && j4 <= j8;
        return (z2 && z3) ? Math.abs(j3 - j2) <= Math.abs(j4 - j2) ? j3 : j4 : z2 ? j3 : z3 ? j4 : j6;
    }

    public static int[] a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        return iArr;
    }

    public static String a(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.8.4";
    }

    private static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.trim().split("(\\s*,\\s*)", -1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (i2 == o.f(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    private static int a(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            String path = uri.getPath();
            if (path == null) {
                return 3;
            }
            return l(path);
        }
        return l(".".concat(String.valueOf(str)));
    }

    private static String a(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            j2 = 0;
        }
        long j3 = (j2 + 500) / 1000;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 60;
        long j6 = j3 / com.anythink.expressad.d.a.b.P;
        sb.setLength(0);
        return j6 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
        }
        file.delete();
    }

    private static int a(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = f9822j[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static Point a(Context context) {
        return a(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    private static Point a(Context context, Display display) {
        if (a < 25 && display.getDisplayId() == 0) {
            if ("Sony".equals(f9815c) && f9816d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (("NVIDIA".equals(f9815c) && f9816d.contains("SHIELD")) || ("philips".equals(d(f9815c)) && (f9816d.startsWith("QM1") || f9816d.equals("QV151E") || f9816d.equals("TPM171E")))) {
                String str = null;
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "sys.display-size");
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String[] strArrSplit = str.trim().split("x", -1);
                        if (strArrSplit.length == 2) {
                            int i2 = Integer.parseInt(strArrSplit[0]);
                            int i3 = Integer.parseInt(strArrSplit[1]);
                            if (i2 > 0 && i3 > 0) {
                                return new Point(i2, i3);
                            }
                        }
                    } catch (NumberFormatException unused2) {
                    }
                    "Invalid sys.display-size: ".concat(String.valueOf(str));
                }
            }
        }
        Point point = new Point();
        int i4 = a;
        if (i4 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else if (i4 >= 17) {
            display.getRealSize(point);
        } else if (i4 >= 16) {
            display.getSize(point);
        } else {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        return point;
    }

    @TargetApi(23)
    private static void a(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static void a(Throwable th) throws Throwable {
        throw th;
    }
}
