package com.kwad.sdk.core.imageloader.core.download;

import com.funny.audio.core.utils.FileUtils;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public interface ImageDownloader {
    InputStream getStream(String str, Object obj);

    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE(FileUtils.URI_TYPE_FILE),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public final String wrap(String str) {
            return this.uriPrefix + str;
        }

        public final String crop(String str) {
            if (!belongsTo(str)) {
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
            }
            return str.substring(this.uriPrefix.length());
        }
    }
}
