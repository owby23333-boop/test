package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.h;
import kotlin.text.d;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
/* JADX INFO: compiled from: -Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\t*\u00020\bH\u0000*\n\u0010\u000b\"\u00020\f2\u00020\f*\n\u0010\r\"\u00020\u000e2\u00020\u000e*\n\u0010\u000f\"\u00020\u00102\u00020\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "EOFException", "Ljava/io/EOFException;", "IOException", "Ljava/io/IOException;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-Platform")
public final class Platform {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String str) {
        return str.getBytes(d.a);
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m314synchronized(@NotNull Object obj, @NotNull a<? extends R> aVar) {
        R rInvoke;
        synchronized (obj) {
            try {
                rInvoke = aVar.invoke();
                h.b(1);
            } catch (Throwable th) {
                h.b(1);
                h.a(1);
                throw th;
            }
        }
        h.a(1);
        return rInvoke;
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] bArr) {
        return new String(bArr, d.a);
    }
}
