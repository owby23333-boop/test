package org.minidns.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class MultipleIoException extends IOException {
    private MultipleIoException(List<? extends IOException> list) {
        super(a((Collection<? extends Exception>) list));
        Collections.unmodifiableList(list);
    }

    private static String a(Collection<? extends Exception> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends Exception> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getMessage());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void a(List<? extends IOException> list) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            throw list.get(0);
        }
        throw new MultipleIoException(list);
    }
}
