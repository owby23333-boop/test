package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static Charset b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Charset f20993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f20994d = new d();

    @JvmField
    @NotNull
    public static final Charset a = Charset.forName("UTF-8");

    static {
        Charset.forName("UTF-16");
        Charset.forName(com.umeng.message.proguard.k.f20481d);
        Charset.forName(com.umeng.message.proguard.k.f20482e);
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
    }

    private d() {
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    public final Charset a() {
        Charset charset = f20993c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        f20993c = charsetForName;
        return charsetForName;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    public final Charset b() {
        Charset charset = b;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        b = charsetForName;
        return charsetForName;
    }
}
