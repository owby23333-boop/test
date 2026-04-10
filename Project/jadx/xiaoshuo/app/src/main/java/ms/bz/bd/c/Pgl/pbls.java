package ms.bz.bd.c.Pgl;

import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public class pbls extends RuntimeException {
    public pbls(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + Consts.DOT);
    }
}
