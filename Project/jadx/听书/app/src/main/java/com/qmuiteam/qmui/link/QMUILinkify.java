package com.qmuiteam.qmui.link;

import android.R;
import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.funny.audio.core.utils.NetWorkUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.z;
import com.xuexiang.xupdate.utils.ShellUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class QMUILinkify {
    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    private static final int MAX_NUMBER = 21;
    public static final int PHONE_NUMBERS = 4;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 7;
    private static final String UrlEndAppendNextChars = "[$]";
    public static final int WEB_URLS = 1;
    public static final Pattern WECHAT_PHONE = Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})");
    public static final Pattern NOT_PHONE = Pattern.compile("^\\d+(\\.\\d+)+(-\\d+)*$");
    public static final WebUrlMatcher QMUI_WEB_URL_MATCHER = new WebUrlMatcher() { // from class: com.qmuiteam.qmui.link.QMUILinkify.1
        @Override // com.qmuiteam.qmui.link.QMUILinkify.WebUrlMatcher
        public Pattern getPattern() {
            return WebUrlPattern.WEB_URL;
        }
    };
    private static WebUrlMatcher sWebUrlMatcher = new WebUrlMatcher() { // from class: com.qmuiteam.qmui.link.QMUILinkify.2
        @Override // com.qmuiteam.qmui.link.QMUILinkify.WebUrlMatcher
        public Pattern getPattern() {
            return Patterns.WEB_URL;
        }
    };
    public static final MatchFilter sUrlMatchFilter = new MatchFilter() { // from class: com.qmuiteam.qmui.link.QMUILinkify.3
        @Override // com.qmuiteam.qmui.link.QMUILinkify.MatchFilter
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            for (int i3 = i; i3 < i2; i3++) {
                try {
                    if (charSequence.charAt(i3) > 256) {
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            try {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt < 256 && QMUILinkify.UrlEndAppendNextChars.indexOf(cCharAt) < 0) {
                    if (!Character.isWhitespace(cCharAt)) {
                        return false;
                    }
                }
            } catch (Exception unused2) {
            }
            if (i == 0) {
                return true;
            }
            return charSequence.charAt(i - 1) != '@';
        }
    };
    public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() { // from class: com.qmuiteam.qmui.link.QMUILinkify.4
        @Override // com.qmuiteam.qmui.link.QMUILinkify.MatchFilter
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                if (Character.isDigit(charSequence.charAt(i)) && (i3 = i3 + 1) >= 7) {
                    return true;
                }
                i++;
            }
            return false;
        }
    };
    public static final TransformFilter sPhoneNumberTransformFilter = new TransformFilter() { // from class: com.qmuiteam.qmui.link.QMUILinkify.5
        @Override // com.qmuiteam.qmui.link.QMUILinkify.TransformFilter
        public final String transformUrl(Matcher matcher, String str) {
            return Patterns.digitsAndPlusOnly(matcher);
        }
    };

    public interface MatchFilter {
        boolean acceptMatch(CharSequence charSequence, int i, int i2);
    }

    public interface TransformFilter {
        String transformUrl(Matcher matcher, String str);
    }

    public interface WebUrlMatcher {
        Pattern getPattern();
    }

    public static void useQmuiWebUrlMatcher() {
        sWebUrlMatcher = QMUI_WEB_URL_MATCHER;
    }

    public static void setWebUrlMatcher(WebUrlMatcher webUrlMatcher) {
        sWebUrlMatcher = webUrlMatcher;
    }

    public static boolean addLinks(Spannable spannable, int i, ColorStateList colorStateList, ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList<LinkSpec> arrayList = new ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, sWebUrlMatcher.getPattern(), new String[]{"http://", "https://", "rtsp://"}, sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, Patterns.EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
        }
        if ((i & 4) != 0) {
            gatherPhoneLinks(arrayList, spannable, WECHAT_PHONE, new Pattern[]{NOT_PHONE}, new String[]{"tel:"}, sPhoneNumberMatchFilter, sPhoneNumberTransformFilter);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        for (LinkSpec linkSpec : arrayList) {
            applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable, colorStateList, colorStateList2, qMUIOnSpanClickListener);
        }
        return true;
    }

    public static boolean addLinks(TextView textView, int i, ColorStateList colorStateList, ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i, colorStateList, colorStateList2, qMUIOnSpanClickListener)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(text);
        if (!addLinks(spannableStringValueOf, i, colorStateList, colorStateList2, qMUIOnSpanClickListener)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str) {
        addLinks(textView, pattern, str, (MatchFilter) null, (TransformFilter) null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter) {
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(spannableStringValueOf, pattern, str, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str) {
        return addLinks(spannable, pattern, str, (MatchFilter) null, (TransformFilter) null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                applyLink(makeUrl(matcher.group(0), new String[]{lowerCase}, matcher, transformFilter), iStart, iEnd, spannable, null, null, null);
                z = true;
            }
        }
        return z;
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable, final ColorStateList colorStateList, final ColorStateList colorStateList2, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        spannable.setSpan(new StyleableURLSpan(str, qMUIOnSpanClickListener) { // from class: com.qmuiteam.qmui.link.QMUILinkify.6
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                ColorStateList colorStateList3 = colorStateList;
                if (colorStateList3 != null) {
                    int colorForState = colorStateList3.getColorForState(new int[]{R.attr.state_enabled, -16842919}, 0);
                    int colorForState2 = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, colorForState);
                    if (this.mPressed) {
                        colorForState = colorForState2;
                    }
                    textPaint.linkColor = colorForState;
                }
                ColorStateList colorStateList4 = colorStateList2;
                if (colorStateList4 != null) {
                    int colorForState3 = colorStateList4.getColorForState(new int[]{R.attr.state_enabled, -16842919}, 0);
                    int colorForState4 = colorStateList2.getColorForState(new int[]{R.attr.state_pressed}, colorForState3);
                    if (this.mPressed) {
                        colorForState3 = colorForState4;
                    }
                    textPaint.bgColor = colorForState3;
                }
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, i, i2, 33);
    }

    private static abstract class StyleableURLSpan extends URLSpan implements ITouchableSpan {
        protected QMUIOnSpanClickListener mOnSpanClickListener;
        protected boolean mPressed;
        protected String mUrl;

        public StyleableURLSpan(String str, QMUIOnSpanClickListener qMUIOnSpanClickListener) {
            super(str);
            this.mPressed = false;
            this.mUrl = str;
            this.mOnSpanClickListener = qMUIOnSpanClickListener;
        }

        @Override // com.qmuiteam.qmui.link.ITouchableSpan
        public void setPressed(boolean z) {
            this.mPressed = z;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan, com.qmuiteam.qmui.link.ITouchableSpan
        public void onClick(View view) {
            if (this.mOnSpanClickListener.onSpanClick(this.mUrl)) {
                return;
            }
            super.onClick(view);
        }
    }

    private static String makeUrl(String str, String[] strArr, Matcher matcher, TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i++;
            }
        }
        return !z ? strArr[0] + str : str;
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = iStart;
                linkSpec.end = iEnd;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherPhoneLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, Pattern[] patternArr, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            if (!isInExcepts(matcher.group(), patternArr)) {
                int iStart = matcher.start();
                int iEnd = matcher.end();
                if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                    LinkSpec linkSpec = new LinkSpec();
                    linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                    linkSpec.start = iStart;
                    linkSpec.end = iEnd;
                    arrayList.add(linkSpec);
                }
            }
        }
    }

    private static boolean isInExcepts(CharSequence charSequence, Pattern[] patternArr) {
        for (Pattern pattern : patternArr) {
            if (pattern.matcher(charSequence).find()) {
                return true;
            }
        }
        return isTooLarge(charSequence);
    }

    private static boolean isTooLarge(CharSequence charSequence) {
        if (charSequence.length() <= 21) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isDigit(charSequence.charAt(i2)) && (i = i + 1) > 21) {
                return true;
            }
        }
        return false;
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strFindAddress = WebView.findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = strFindAddress.length() + iIndexOf;
                    linkSpec.start = iIndexOf + i;
                    i += length;
                    linkSpec.end = i;
                    string = string.substring(length);
                    try {
                        linkSpec.url = "geo:0,0?q=" + URLEncoder.encode(strFindAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList) {
        int i;
        Collections.sort(arrayList, new Comparator<LinkSpec>() { // from class: com.qmuiteam.qmui.link.QMUILinkify.7
            @Override // java.util.Comparator
            public final int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
                if (linkSpec.start < linkSpec2.start) {
                    return -1;
                }
                if (linkSpec.start <= linkSpec2.start && linkSpec.end >= linkSpec2.end) {
                    return linkSpec.end > linkSpec2.end ? -1 : 0;
                }
                return 1;
            }
        });
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            LinkSpec linkSpec = arrayList.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec2 = arrayList.get(i3);
            if (linkSpec.start <= linkSpec2.start && linkSpec.end > linkSpec2.start) {
                if (linkSpec2.end > linkSpec.end && linkSpec.end - linkSpec.start <= linkSpec2.end - linkSpec2.start) {
                    i = linkSpec.end - linkSpec.start < linkSpec2.end - linkSpec2.start ? i2 : -1;
                } else {
                    i = i3;
                }
                if (i != -1) {
                    arrayList.remove(i);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    private static class LinkSpec {
        int end;
        int start;
        String url;

        private LinkSpec() {
        }
    }

    private static class WebUrlPattern {
        private static final String[] EXT = {"top", "com", TKDownloadReason.KSAD_TK_NET, "org", "edu", "gov", "int", "mil", "tel", "biz", "cc", "tv", "info", "zw", "name", "hk", "mobi", "asia", "cd", "travel", "pro", "museum", "coop", "aero", an.aw, "ae", "af", "ag", "ai", "al", "am", "an", LiveConfigKey.AUDIO, "aq", "ar", "as", t.u, "au", "aw", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cq", "cr", "cu", "cv", "cx", "cy", "cz", "de", "dj", an.bo, t.v, "do", "dz", "ec", "ee", NetWorkUtils.NETWORK_TYPE_3G, "eh", "es", "et", "ev", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gh", "gi", "gl", "gm", "gn", "gp", "gr", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "in", "io", "iq", "ir", an.ae, "it", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", an.A, LiveConfigKey.MEDIUM, "mg", "mh", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nt", "nu", "nz", "om", "qa", "pa", "pe", "pf", an.aA, "ph", "pk", an.az, "pm", "pn", "pr", "pt", "pw", "py", "re", "ro", "ru", "rw", "sa", "sb", "sc", LiveConfigKey.STANDARD, "se", "sg", ShellUtils.COMMAND_SH, "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tm", "tn", "to", "tp", "tr", TtmlNode.TAG_TT, "tv", "tw", "tz", z.d, "ug", "uk", "us", "uy", "va", "vc", "ve", "vg", "vn", "vu", "wf", "ws", "ye", "yu", "za", "zm", "zr"};
        private static final String IP_ADDRESS = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
        private static final String LABEL_CHAR = "a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
        private static final String PATH_AND_QUERY = "[/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*";
        private static final String PORT_NUMBER = "\\:\\d{1,5}";
        private static final String PROTOCOL = "(?i:http|https|rtsp)://";
        private static final String UCS_CHAR = "[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
        private static Pattern WEB_URL;

        private WebUrlPattern() {
        }

        static {
            int i = 0;
            StringBuilder sb = new StringBuilder("(");
            while (true) {
                String[] strArr = EXT;
                if (i < strArr.length) {
                    if (i != 0) {
                        sb.append("|");
                    }
                    sb.append(strArr[i]);
                    i++;
                } else {
                    sb.append(")");
                    WEB_URL = Pattern.compile("(((?i:http|https|rtsp)://)?(((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))|" + ("((?:(www\\.|[a-zA-Z\\.\\-]+\\.)?[a-zA-Z0-9\\-]+)\\." + sb.toString() + ")") + ")(\\:\\d{1,5})?([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?)");
                    return;
                }
            }
        }
    }
}
