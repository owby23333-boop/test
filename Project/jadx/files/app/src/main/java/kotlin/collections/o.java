package kotlin.collections;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class o extends n {
    public static <T extends Comparable<? super T>> void c(@NotNull List<T> list) {
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
