package kotlin.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NotNull Appendable appendable, T t2, @Nullable kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        if (lVar != null) {
            appendable.append(lVar.invoke(t2));
            return;
        }
        if (t2 != 0 ? t2 instanceof CharSequence : true) {
            appendable.append((CharSequence) t2);
        } else if (t2 instanceof Character) {
            appendable.append(((Character) t2).charValue());
        } else {
            appendable.append(String.valueOf(t2));
        }
    }
}
