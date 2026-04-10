package com.funny.audio.core.ext;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"highlightWordTags", "Landroid/text/SpannableString;", "", "highlightColor", "", "normalColor", "truncateWithEllipsis", "maxLength", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringKt {
    public static final String truncateWithEllipsis(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= i) {
            return str;
        }
        return StringsKt.take(str, i) + "...";
    }

    public static final SpannableString highlightWordTags(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Regex regex = new Regex("<word>(.*?)</word>");
        String str2 = str;
        int i3 = 0;
        List<MatchResult> list = SequencesKt.toList(Regex.findAll$default(regex, str2, 0, 2, null));
        SpannableString spannableString = new SpannableString(regex.replace(str2, "$1"));
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 33);
        for (MatchResult matchResult : list) {
            int first = matchResult.getRange().getFirst() - i3;
            matchResult.getRange().getLast();
            i3 += 13;
            spannableString.setSpan(new ForegroundColorSpan(i), first, matchResult.getGroupValues().get(1).length() + first, 33);
        }
        return spannableString;
    }
}
