package ms.bz.bd.c.Pgl;

import com.funny.audio.core.utils.FileUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 extends RuntimeException {
    public y0(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + FileUtils.FILE_EXTENSION_SEPARATOR);
    }
}
