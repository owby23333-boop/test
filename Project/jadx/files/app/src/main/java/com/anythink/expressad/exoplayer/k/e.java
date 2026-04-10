package com.anythink.expressad.exoplayer.k;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String a = "rgb";
    private static final String b = "rgba";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f9832c = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f9833d = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f9834e = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f9835f;

    static {
        HashMap map = new HashMap();
        f9835f = map;
        map.put("aliceblue", -984833);
        f9835f.put("antiquewhite", -332841);
        f9835f.put("aqua", -16711681);
        f9835f.put("aquamarine", -8388652);
        f9835f.put("azure", -983041);
        f9835f.put("beige", -657956);
        f9835f.put("bisque", -6972);
        f9835f.put("black", -16777216);
        f9835f.put("blanchedalmond", -5171);
        f9835f.put("blue", -16776961);
        f9835f.put("blueviolet", -7722014);
        f9835f.put("brown", -5952982);
        f9835f.put("burlywood", -2180985);
        f9835f.put("cadetblue", -10510688);
        f9835f.put("chartreuse", -8388864);
        f9835f.put("chocolate", -2987746);
        f9835f.put("coral", -32944);
        f9835f.put("cornflowerblue", -10185235);
        f9835f.put("cornsilk", -1828);
        f9835f.put("crimson", -2354116);
        f9835f.put("cyan", -16711681);
        f9835f.put("darkblue", -16777077);
        f9835f.put("darkcyan", -16741493);
        f9835f.put("darkgoldenrod", -4684277);
        f9835f.put("darkgray", -5658199);
        f9835f.put("darkgreen", -16751616);
        f9835f.put("darkgrey", -5658199);
        f9835f.put("darkkhaki", -4343957);
        f9835f.put("darkmagenta", -7667573);
        f9835f.put("darkolivegreen", -11179217);
        f9835f.put("darkorange", -29696);
        f9835f.put("darkorchid", -6737204);
        f9835f.put("darkred", -7667712);
        f9835f.put("darksalmon", -1468806);
        f9835f.put("darkseagreen", -7357297);
        f9835f.put("darkslateblue", -12042869);
        f9835f.put("darkslategray", -13676721);
        f9835f.put("darkslategrey", -13676721);
        f9835f.put("darkturquoise", -16724271);
        f9835f.put("darkviolet", -7077677);
        f9835f.put("deeppink", -60269);
        f9835f.put("deepskyblue", -16728065);
        f9835f.put("dimgray", -9868951);
        f9835f.put("dimgrey", -9868951);
        f9835f.put("dodgerblue", -14774017);
        f9835f.put("firebrick", -5103070);
        f9835f.put("floralwhite", -1296);
        f9835f.put("forestgreen", -14513374);
        f9835f.put("fuchsia", -65281);
        f9835f.put("gainsboro", -2302756);
        f9835f.put("ghostwhite", -460545);
        f9835f.put("gold", -10496);
        f9835f.put("goldenrod", -2448096);
        f9835f.put("gray", -8355712);
        f9835f.put("green", -16744448);
        f9835f.put("greenyellow", -5374161);
        f9835f.put("grey", -8355712);
        f9835f.put("honeydew", -983056);
        f9835f.put("hotpink", -38476);
        f9835f.put("indianred", -3318692);
        f9835f.put("indigo", -11861886);
        f9835f.put("ivory", -16);
        f9835f.put("khaki", -989556);
        f9835f.put("lavender", -1644806);
        f9835f.put("lavenderblush", -3851);
        f9835f.put("lawngreen", -8586240);
        f9835f.put("lemonchiffon", -1331);
        f9835f.put("lightblue", -5383962);
        f9835f.put("lightcoral", -1015680);
        f9835f.put("lightcyan", -2031617);
        f9835f.put("lightgoldenrodyellow", -329006);
        f9835f.put("lightgray", -2894893);
        f9835f.put("lightgreen", -7278960);
        f9835f.put("lightgrey", -2894893);
        f9835f.put("lightpink", -18751);
        f9835f.put("lightsalmon", -24454);
        f9835f.put("lightseagreen", -14634326);
        f9835f.put("lightskyblue", -7876870);
        f9835f.put("lightslategray", -8943463);
        f9835f.put("lightslategrey", -8943463);
        f9835f.put("lightsteelblue", -5192482);
        f9835f.put("lightyellow", -32);
        f9835f.put("lime", -16711936);
        f9835f.put("limegreen", -13447886);
        f9835f.put("linen", -331546);
        f9835f.put("magenta", -65281);
        f9835f.put("maroon", -8388608);
        f9835f.put("mediumaquamarine", -10039894);
        f9835f.put("mediumblue", -16777011);
        f9835f.put("mediumorchid", -4565549);
        f9835f.put("mediumpurple", -7114533);
        f9835f.put("mediumseagreen", -12799119);
        f9835f.put("mediumslateblue", -8689426);
        f9835f.put("mediumspringgreen", -16713062);
        f9835f.put("mediumturquoise", -12004916);
        f9835f.put("mediumvioletred", -3730043);
        f9835f.put("midnightblue", -15132304);
        f9835f.put("mintcream", -655366);
        f9835f.put("mistyrose", -6943);
        f9835f.put("moccasin", -6987);
        f9835f.put("navajowhite", -8531);
        f9835f.put("navy", -16777088);
        f9835f.put("oldlace", -133658);
        f9835f.put("olive", -8355840);
        f9835f.put("olivedrab", -9728477);
        f9835f.put("orange", -23296);
        f9835f.put("orangered", -47872);
        f9835f.put("orchid", -2461482);
        f9835f.put("palegoldenrod", -1120086);
        f9835f.put("palegreen", -6751336);
        f9835f.put("paleturquoise", -5247250);
        f9835f.put("palevioletred", -2396013);
        f9835f.put("papayawhip", -4139);
        f9835f.put("peachpuff", -9543);
        f9835f.put("peru", -3308225);
        f9835f.put("pink", -16181);
        f9835f.put("plum", -2252579);
        f9835f.put("powderblue", -5185306);
        f9835f.put("purple", -8388480);
        f9835f.put("rebeccapurple", -10079335);
        f9835f.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        f9835f.put("rosybrown", -4419697);
        f9835f.put("royalblue", -12490271);
        f9835f.put("saddlebrown", -7650029);
        f9835f.put("salmon", -360334);
        f9835f.put("sandybrown", -744352);
        f9835f.put("seagreen", -13726889);
        f9835f.put("seashell", -2578);
        f9835f.put("sienna", -6270419);
        f9835f.put("silver", -4144960);
        f9835f.put("skyblue", -7876885);
        f9835f.put("slateblue", -9807155);
        f9835f.put("slategray", -9404272);
        f9835f.put("slategrey", -9404272);
        f9835f.put("snow", -1286);
        f9835f.put("springgreen", -16711809);
        f9835f.put("steelblue", -12156236);
        f9835f.put("tan", -2968436);
        f9835f.put("teal", -16744320);
        f9835f.put("thistle", -2572328);
        f9835f.put("tomato", -40121);
        f9835f.put("transparent", 0);
        f9835f.put("turquoise", -12525360);
        f9835f.put("violet", -1146130);
        f9835f.put("wheat", -663885);
        f9835f.put("white", -1);
        f9835f.put("whitesmoke", -657931);
        f9835f.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        f9835f.put("yellowgreen", -6632142);
    }

    private e() {
    }

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    private static int a(String str) {
        return a(str, false);
    }

    private static int b(String str) {
        return a(str, true);
    }

    private static int a(String str, boolean z2) {
        a.a(!TextUtils.isEmpty(str));
        String strReplace = str.replace(" ", "");
        if (strReplace.charAt(0) == '#') {
            int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i2;
            }
            if (strReplace.length() == 9) {
                return ((i2 & 255) << 24) | (i2 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith(b)) {
            Matcher matcher = (z2 ? f9834e : f9833d).matcher(strReplace);
            if (matcher.matches()) {
                return a(z2 ? (int) (Float.parseFloat(matcher.group(4)) * 255.0f) : Integer.parseInt(matcher.group(4), 10), Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (strReplace.startsWith(a)) {
            Matcher matcher2 = f9832c.matcher(strReplace);
            if (matcher2.matches()) {
                return a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = f9835f.get(af.d(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int a(int i2, int i3, int i4) {
        return a(255, i2, i3, i4);
    }
}
