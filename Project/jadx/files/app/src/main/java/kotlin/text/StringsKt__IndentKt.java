package kotlin.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/text/StringsKt")
public class StringsKt__IndentKt extends g {
    public static /* synthetic */ String a(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = com.anythink.expressad.foundation.g.a.bQ;
        }
        return a(str, str2);
    }

    @NotNull
    public static final String a(@NotNull String str, @NotNull String str2) {
        return a(str, "", str2);
    }

    @NotNull
    public static final String a(@NotNull String str, @NotNull String str2, @NotNull String str3) throws IOException {
        int i2;
        if (!n.a((CharSequence) str3)) {
            List<String> listE = StringsKt__StringsKt.e(str);
            int length = str.length() + (str2.length() * listE.size());
            kotlin.jvm.b.l<String, String> lVarA = a(str2);
            int iA = kotlin.collections.k.a((List) listE);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj : listE) {
                int i4 = i3 + 1;
                String strInvoke = null;
                if (i3 >= 0) {
                    String str4 = (String) obj;
                    if ((i3 != 0 && i3 != iA) || !n.a((CharSequence) str4)) {
                        int length2 = str4.length();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length2) {
                                i2 = -1;
                                break;
                            }
                            if (!b.a(str4.charAt(i5))) {
                                i2 = i5;
                                break;
                            }
                            i5++;
                        }
                        if (i2 != -1 && n.a(str4, str3, i2, false, 4, (Object) null)) {
                            int length3 = i2 + str3.length();
                            if (str4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            strInvoke = str4.substring(length3);
                        }
                        if (strInvoke == null || (strInvoke = lVarA.invoke(strInvoke)) == null) {
                            strInvoke = str4;
                        }
                    }
                    if (strInvoke != null) {
                        arrayList.add(strInvoke);
                    }
                    i3 = i4;
                } else {
                    kotlin.collections.i.c();
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder(length);
            kotlin.collections.i.a(arrayList, sb, "\n", null, null, 0, null, null, 124, null);
            return sb.toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    private static final kotlin.jvm.b.l<String, String> a(final String str) {
        return str.length() == 0 ? new kotlin.jvm.b.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @NotNull
            public final String a(@NotNull String str2) {
                return str2;
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ String invoke(String str2) {
                String str3 = str2;
                a(str3);
                return str3;
            }
        } : new kotlin.jvm.b.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke(@NotNull String str2) {
                return str + str2;
            }
        };
    }
}
