package org.apache.commons.lang.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static String cDefaultPattern = null;
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private final boolean mLocaleForced;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;
    private final boolean mTimeZoneForced;
    private static final Map cInstanceCache = new HashMap(7);
    private static final Map cDateInstanceCache = new HashMap(7);
    private static final Map cTimeInstanceCache = new HashMap(7);
    private static final Map cDateTimeInstanceCache = new HashMap(7);
    private static final Map cTimeZoneDisplayCache = new HashMap(7);

    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c) {
            this.mValue = c;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 1;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i);
    }

    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i;
            this.mSize = i2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            int length;
            if (i < 100) {
                int i2 = this.mSize;
                while (true) {
                    i2--;
                    if (i2 < 2) {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                    stringBuffer.append('0');
                }
            } else {
                if (i < 1000) {
                    length = 3;
                } else {
                    Validate.isTrue(i > -1, "Negative values should not be possible", i);
                    length = Integer.toString(i).length();
                }
                int i3 = this.mSize;
                while (true) {
                    i3--;
                    if (i3 < length) {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                    stringBuffer.append('0');
                }
            }
        }
    }

    public static class Pair {
        private final Object mObj1;
        private final Object mObj2;

        public Pair(Object obj, Object obj2) {
            this.mObj1 = obj;
            this.mObj2 = obj2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            Object obj2 = this.mObj1;
            if (obj2 != null ? obj2.equals(pair.mObj1) : pair.mObj1 == null) {
                Object obj3 = this.mObj2;
                Object obj4 = pair.mObj2;
                if (obj3 == null) {
                    if (obj4 == null) {
                        return true;
                    }
                } else if (obj3.equals(obj4)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.mObj1;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.mObj2;
            return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            stringBuffer.append(this.mObj1);
            stringBuffer.append(':');
            stringBuffer.append(this.mObj2);
            stringBuffer.append(']');
            return stringBuffer.toString();
        }
    }

    public interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            this.mStyle = z ? i | Integer.MIN_VALUE : i;
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return (this.mStyle * 31) + this.mLocale.hashCode();
        }
    }

    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;
        private final TimeZone mTimeZone;
        private final boolean mTimeZoneForced;

        public TimeZoneNameRule(TimeZone timeZone, boolean z, Locale locale, int i) {
            this.mTimeZone = timeZone;
            this.mTimeZoneForced = z;
            this.mLocale = locale;
            this.mStyle = i;
            if (z) {
                this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, i, locale);
                this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, i, locale);
            } else {
                this.mStandard = null;
                this.mDaylight = null;
            }
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (this.mTimeZoneForced) {
                if (!this.mTimeZone.useDaylightTime() || calendar.get(16) == 0) {
                    stringBuffer.append(this.mStandard);
                    return;
                } else {
                    stringBuffer.append(this.mDaylight);
                    return;
                }
            }
            TimeZone timeZone = calendar.getTimeZone();
            if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mTimeZoneForced ? Math.max(this.mStandard.length(), this.mDaylight.length()) : this.mStyle == 0 ? 4 : 40;
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 5;
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i) {
            this.mField = i;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i) {
            this.mField = i;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
            } else {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            }
        }
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new IllegalArgumentException("The pattern must not be null");
        }
        this.mPattern = str;
        this.mTimeZoneForced = timeZone != null;
        this.mTimeZone = timeZone == null ? TimeZone.getDefault() : timeZone;
        this.mLocaleForced = locale != null;
        this.mLocale = locale == null ? Locale.getDefault() : locale;
    }

    public static FastDateFormat getDateInstance(int i) {
        return getDateInstance(i, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return getDateTimeInstance(i, i2, null, null);
    }

    private static synchronized String getDefaultPattern() {
        if (cDefaultPattern == null) {
            cDefaultPattern = new SimpleDateFormat().toPattern();
        }
        return cDefaultPattern;
    }

    public static FastDateFormat getInstance() {
        return getInstance(getDefaultPattern(), null, null);
    }

    public static FastDateFormat getTimeInstance(int i) {
        return getTimeInstance(i, null, null);
    }

    public static synchronized String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        String displayName;
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
        Map map = cTimeZoneDisplayCache;
        displayName = (String) map.get(timeZoneDisplayKey);
        if (displayName == null) {
            displayName = timeZone.getDisplayName(z, i, locale);
            map.put(timeZoneDisplayKey, displayName);
        }
        return displayName;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule rule : this.mRules) {
            rule.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        TimeZone timeZone;
        TimeZone timeZone2;
        Locale locale;
        Locale locale2;
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        String str = this.mPattern;
        String str2 = fastDateFormat.mPattern;
        return (str == str2 || str.equals(str2)) && ((timeZone = this.mTimeZone) == (timeZone2 = fastDateFormat.mTimeZone) || timeZone.equals(timeZone2)) && (((locale = this.mLocale) == (locale2 = fastDateFormat.mLocale) || locale.equals(locale2)) && this.mTimeZoneForced == fastDateFormat.mTimeZoneForced && this.mLocaleForced == fastDateFormat.mLocaleForced);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Unknown class: ");
        stringBuffer2.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(stringBuffer2.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean getTimeZoneOverridesCalendar() {
        return this.mTimeZoneForced;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + 0 + this.mTimeZone.hashCode() + (this.mTimeZoneForced ? 1 : 0) + this.mLocale.hashCode() + (this.mLocaleForced ? 1 : 0);
    }

    public void init() {
        List pattern = parsePattern();
        Rule[] ruleArr = (Rule[]) pattern.toArray(new Rule[pattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = iEstimateLength;
                return;
            }
            iEstimateLength += this.mRules[length].estimateLength();
        }
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    public List parsePattern() {
        int i;
        Rule ruleSelectNumberRule;
        Rule timeZoneNameRule;
        Rule characterLiteral;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            iArr[i2] = i3;
            String token = parseToken(this.mPattern, iArr);
            int i4 = iArr[i2];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i2);
            if (cCharAt == 'y') {
                i = 0;
                ruleSelectNumberRule = length2 >= 4 ? selectNumberRule(1, length2) : TwoDigitYearField.INSTANCE;
            } else if (cCharAt != 'z') {
                switch (cCharAt) {
                    case '\'':
                        String strSubstring = token.substring(1);
                        characterLiteral = strSubstring.length() == 1 ? new CharacterLiteral(strSubstring.charAt(0)) : new StringLiteral(strSubstring);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'K':
                        characterLiteral = selectNumberRule(10, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            ruleSelectNumberRule = new TextField(2, months);
                        } else if (length2 == 3) {
                            ruleSelectNumberRule = new TextField(2, shortMonths);
                        } else {
                            characterLiteral = length2 == 2 ? TwoDigitMonthField.INSTANCE : UnpaddedMonthField.INSTANCE;
                            ruleSelectNumberRule = characterLiteral;
                        }
                        i = 0;
                        break;
                    case 'S':
                        characterLiteral = selectNumberRule(14, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'W':
                        characterLiteral = selectNumberRule(4, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'Z':
                        characterLiteral = length2 == 1 ? TimeZoneNumberRule.INSTANCE_NO_COLON : TimeZoneNumberRule.INSTANCE_COLON;
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'a':
                        characterLiteral = new TextField(9, amPmStrings);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'd':
                        characterLiteral = selectNumberRule(5, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'h':
                        characterLiteral = new TwelveHourField(selectNumberRule(10, length2));
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'k':
                        ruleSelectNumberRule = new TwentyFourHourField(selectNumberRule(11, length2));
                        i = 0;
                        break;
                    case 'm':
                        characterLiteral = selectNumberRule(12, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 's':
                        characterLiteral = selectNumberRule(13, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    case 'w':
                        characterLiteral = selectNumberRule(3, length2);
                        ruleSelectNumberRule = characterLiteral;
                        i = 0;
                        break;
                    default:
                        switch (cCharAt) {
                            case 'D':
                                characterLiteral = selectNumberRule(6, length2);
                                ruleSelectNumberRule = characterLiteral;
                                i = 0;
                                break;
                            case 'E':
                                characterLiteral = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                ruleSelectNumberRule = characterLiteral;
                                i = 0;
                                break;
                            case 'F':
                                characterLiteral = selectNumberRule(8, length2);
                                ruleSelectNumberRule = characterLiteral;
                                i = 0;
                                break;
                            case 'G':
                                timeZoneNameRule = new TextField(0, eras);
                                i = 0;
                                ruleSelectNumberRule = timeZoneNameRule;
                                break;
                            case 'H':
                                characterLiteral = selectNumberRule(11, length2);
                                ruleSelectNumberRule = characterLiteral;
                                i = 0;
                                break;
                            default:
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Illegal pattern component: ");
                                stringBuffer.append(token);
                                throw new IllegalArgumentException(stringBuffer.toString());
                        }
                        break;
                }
            } else if (length2 >= 4) {
                ruleSelectNumberRule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                i = 0;
            } else {
                i = 0;
                timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                ruleSelectNumberRule = timeZoneNameRule;
            }
            arrayList.add(ruleSelectNumberRule);
            i3 = i4 + 1;
            i2 = i;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StrBuilder strBuilder = new StrBuilder();
        int i = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            strBuilder.append('\'');
            boolean z = false;
            while (i < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 != '\'') {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    strBuilder.append(cCharAt2);
                } else {
                    int i2 = i + 1;
                    if (i2 >= length || str.charAt(i2) != '\'') {
                        z = !z;
                    } else {
                        strBuilder.append(cCharAt2);
                        i = i2;
                    }
                }
                i++;
            }
        } else {
            strBuilder.append(cCharAt);
            while (true) {
                int i3 = i + 1;
                if (i3 >= length || str.charAt(i3) != cCharAt) {
                    break;
                }
                strBuilder.append(cCharAt);
                i = i3;
            }
        }
        iArr[0] = i;
        return strBuilder.toString();
    }

    public NumberRule selectNumberRule(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? new PaddedNumberField(i, i2) : new TwoDigitNumberField(i) : new UnpaddedNumberField(i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FastDateFormat[");
        stringBuffer.append(this.mPattern);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return getDateInstance(i, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return getDateTimeInstance(i, i2, null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return getInstance(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return getTimeInstance(i, null, locale);
    }

    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, leastMaximum);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, maximum);
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang.time.FastDateFormat.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return getDateInstance(i, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return getInstance(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return getTimeInstance(i, timeZone, null);
    }

    public static synchronized FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        Object num = new Integer(i);
        if (timeZone != null) {
            num = new Pair(num, timeZone);
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Pair pair = new Pair(num, locale);
        Map map = cDateInstanceCache;
        fastDateFormat = (FastDateFormat) map.get(pair);
        if (fastDateFormat == null) {
            try {
                fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateInstance(i, locale)).toPattern(), timeZone, locale);
                map.put(pair, fastDateFormat);
            } catch (ClassCastException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("No date pattern for locale: ");
                stringBuffer.append(locale);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        Pair pair = new Pair(new Integer(i), new Integer(i2));
        if (timeZone != null) {
            pair = new Pair(pair, timeZone);
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Pair pair2 = new Pair(pair, locale);
        Map map = cDateTimeInstanceCache;
        fastDateFormat = (FastDateFormat) map.get(pair2);
        if (fastDateFormat == null) {
            try {
                fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateTimeInstance(i, i2, locale)).toPattern(), timeZone, locale);
                map.put(pair2, fastDateFormat);
            } catch (ClassCastException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("No date time pattern for locale: ");
                stringBuffer.append(locale);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        return fastDateFormat;
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return getInstance(str, null, locale);
    }

    public static synchronized FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        Object num = new Integer(i);
        if (timeZone != null) {
            num = new Pair(num, timeZone);
        }
        if (locale != null) {
            num = new Pair(num, locale);
        }
        Map map = cTimeInstanceCache;
        fastDateFormat = (FastDateFormat) map.get(num);
        if (fastDateFormat == null) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            try {
                fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getTimeInstance(i, locale)).toPattern(), timeZone, locale);
                map.put(num, fastDateFormat);
            } catch (ClassCastException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("No date pattern for locale: ");
                stringBuffer.append(locale);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        fastDateFormat = new FastDateFormat(str, timeZone, locale);
        Map map = cInstanceCache;
        FastDateFormat fastDateFormat2 = (FastDateFormat) map.get(fastDateFormat);
        if (fastDateFormat2 == null) {
            fastDateFormat.init();
            map.put(fastDateFormat, fastDateFormat);
        } else {
            fastDateFormat = fastDateFormat2;
        }
        return fastDateFormat;
    }

    public String format(long j) {
        return format(new Date(j));
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return format(new Date(j), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        if (this.mTimeZoneForced) {
            calendar.getTime();
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(calendar, stringBuffer);
    }
}
