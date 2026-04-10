package okhttp3;

import com.umeng.message.utils.HttpRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", HttpRequest.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String str, @NotNull String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String username, @NotNull String password, @NotNull Charset charset) {
        return "Basic " + ByteString.INSTANCE.encodeString(username + ':' + password, charset).base64();
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
        }
        return basic(str, str2, charset);
    }
}
