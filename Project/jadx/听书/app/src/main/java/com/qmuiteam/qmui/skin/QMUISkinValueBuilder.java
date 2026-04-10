package com.qmuiteam.qmui.skin;

import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinValueBuilder {
    public static final String ALPHA = "alpha";
    public static final String BACKGROUND = "background";
    public static final String BG_TINT_COLOR = "bgTintColor";
    public static final String BORDER = "border";
    public static final String BOTTOM_SEPARATOR = "bottomSeparator";
    public static final String HINT_COLOR = "hintColor";
    public static final String LEFT_SEPARATOR = "LeftSeparator";
    public static final String MORE_BG_COLOR = "moreBgColor";
    public static final String MORE_TEXT_COLOR = "moreTextColor";
    public static final String PROGRESS_COLOR = "progressColor";
    public static final String RIGHT_SEPARATOR = "rightSeparator";
    public static final String SECOND_TEXT_COLOR = "secondTextColor";
    public static final String SRC = "src";
    public static final String TEXT_COLOR = "textColor";
    public static final String TEXT_COMPOUND_BOTTOM_SRC = "tcbSrc";
    public static final String TEXT_COMPOUND_LEFT_SRC = "tclSrc";
    public static final String TEXT_COMPOUND_RIGHT_SRC = "tcrSrc";
    public static final String TEXT_COMPOUND_TINT_COLOR = "tcTintColor";
    public static final String TEXT_COMPOUND_TOP_SRC = "tctSrc";
    public static final String TINT_COLOR = "tintColor";
    public static final String TOP_SEPARATOR = "topSeparator";
    public static final String UNDERLINE = "underline";
    private static LinkedList<QMUISkinValueBuilder> sValueBuilderPool;
    private HashMap<String, String> mValues = new HashMap<>();

    public static QMUISkinValueBuilder acquire() {
        LinkedList<QMUISkinValueBuilder> linkedList = sValueBuilderPool;
        if (linkedList == null) {
            return new QMUISkinValueBuilder();
        }
        QMUISkinValueBuilder qMUISkinValueBuilderPoll = linkedList.poll();
        return qMUISkinValueBuilderPoll != null ? qMUISkinValueBuilderPoll : new QMUISkinValueBuilder();
    }

    public static void release(QMUISkinValueBuilder qMUISkinValueBuilder) {
        qMUISkinValueBuilder.clear();
        if (sValueBuilderPool == null) {
            sValueBuilderPool = new LinkedList<>();
        }
        if (sValueBuilderPool.size() < 2) {
            sValueBuilderPool.push(qMUISkinValueBuilder);
        }
    }

    private QMUISkinValueBuilder() {
    }

    public QMUISkinValueBuilder background(int i) {
        this.mValues.put(BACKGROUND, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder background(String str) {
        this.mValues.put(BACKGROUND, str);
        return this;
    }

    public QMUISkinValueBuilder underline(int i) {
        this.mValues.put("underline", String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder underline(String str) {
        this.mValues.put("underline", str);
        return this;
    }

    public QMUISkinValueBuilder moreTextColor(int i) {
        this.mValues.put(MORE_TEXT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder moreTextColor(String str) {
        this.mValues.put(MORE_TEXT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder moreBgColor(int i) {
        this.mValues.put(MORE_BG_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder moreBgColor(String str) {
        this.mValues.put(MORE_BG_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder textCompoundTintColor(int i) {
        this.mValues.put(TEXT_COMPOUND_TINT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textCompoundTintColor(String str) {
        this.mValues.put(TEXT_COMPOUND_TINT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder textCompoundTopSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_TOP_SRC, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textCompoundTopSrc(String str) {
        this.mValues.put(TEXT_COMPOUND_TOP_SRC, str);
        return this;
    }

    public QMUISkinValueBuilder textCompoundRightSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_RIGHT_SRC, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textCompoundRightSrc(String str) {
        this.mValues.put(TEXT_COMPOUND_RIGHT_SRC, str);
        return this;
    }

    public QMUISkinValueBuilder textCompoundBottomSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_BOTTOM_SRC, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textCompoundBottomSrc(String str) {
        this.mValues.put(TEXT_COMPOUND_BOTTOM_SRC, str);
        return this;
    }

    public QMUISkinValueBuilder textCompoundLeftSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_LEFT_SRC, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textCompoundLeftSrc(String str) {
        this.mValues.put(TEXT_COMPOUND_LEFT_SRC, str);
        return this;
    }

    public QMUISkinValueBuilder textColor(int i) {
        this.mValues.put(TEXT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder textColor(String str) {
        this.mValues.put(TEXT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder hintColor(int i) {
        this.mValues.put(HINT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder hintColor(String str) {
        this.mValues.put(HINT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder progressColor(int i) {
        this.mValues.put(PROGRESS_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder progressColor(String str) {
        this.mValues.put(PROGRESS_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder src(int i) {
        this.mValues.put(SRC, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder src(String str) {
        this.mValues.put(SRC, str);
        return this;
    }

    public QMUISkinValueBuilder border(int i) {
        this.mValues.put(BORDER, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder border(String str) {
        this.mValues.put(BORDER, str);
        return this;
    }

    public QMUISkinValueBuilder topSeparator(int i) {
        this.mValues.put(TOP_SEPARATOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder topSeparator(String str) {
        this.mValues.put(TOP_SEPARATOR, str);
        return this;
    }

    public QMUISkinValueBuilder rightSeparator(int i) {
        this.mValues.put(RIGHT_SEPARATOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder rightSeparator(String str) {
        this.mValues.put(RIGHT_SEPARATOR, str);
        return this;
    }

    public QMUISkinValueBuilder bottomSeparator(int i) {
        this.mValues.put(BOTTOM_SEPARATOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder bottomSeparator(String str) {
        this.mValues.put(BOTTOM_SEPARATOR, str);
        return this;
    }

    public QMUISkinValueBuilder leftSeparator(int i) {
        this.mValues.put(LEFT_SEPARATOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder leftSeparator(String str) {
        this.mValues.put(LEFT_SEPARATOR, str);
        return this;
    }

    public QMUISkinValueBuilder alpha(int i) {
        this.mValues.put("alpha", String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder alpha(String str) {
        this.mValues.put("alpha", str);
        return this;
    }

    public QMUISkinValueBuilder tintColor(int i) {
        this.mValues.put(TINT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder tintColor(String str) {
        this.mValues.put(TINT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder bgTintColor(int i) {
        this.mValues.put(BG_TINT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder bgTintColor(String str) {
        this.mValues.put(BG_TINT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder secondTextColor(int i) {
        this.mValues.put(SECOND_TEXT_COLOR, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder secondTextColor(String str) {
        this.mValues.put(SECOND_TEXT_COLOR, str);
        return this;
    }

    public QMUISkinValueBuilder custom(String str, int i) {
        this.mValues.put(str, String.valueOf(i));
        return this;
    }

    public QMUISkinValueBuilder custom(String str, String str2) {
        this.mValues.put(str, str2);
        return this;
    }

    public QMUISkinValueBuilder clear() {
        this.mValues.clear();
        return this;
    }

    public QMUISkinValueBuilder convertFrom(String str) {
        for (String str2 : str.split("[|]")) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length == 2) {
                this.mValues.put(strArrSplit[0].trim(), strArrSplit[1].trim());
            }
        }
        return this;
    }

    public boolean isEmpty() {
        return this.mValues.isEmpty();
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : this.mValues.keySet()) {
            String str2 = this.mValues.get(str);
            if (str2 != null && !str2.isEmpty()) {
                if (!z) {
                    sb.append("|");
                }
                sb.append(str);
                sb.append(":");
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public void release() {
        release(this);
    }
}
