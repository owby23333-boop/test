package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public class AiText extends AbstractData {
    public static String COMPRESS_DEFAULT = "raw";
    public static String COMPRESS_GZIP = "gzip";
    public static String COMPRESS_RAW = "raw";
    public static String ENCODING_DEFAULT = "utf8";
    public static String ENCODING_GB2312 = "gb2312";
    public static String ENCODING_GBK = "gbk";
    public static String ENCODING_UTF8 = "utf8";
    public static String FORMAT_DEFAULT = "plain";
    public static String FORMAT_JSON = "json";
    public static String FORMAT_PLAIN = "plain";
    public static String FORMAT_XML = "xml";

    public static class Holder extends AiDataHolder<Holder, AiText> {
        private String compress;
        private String encoding;
        private String format;

        public Holder compress(String str) {
            this.compress = (String) update(this.compress, str);
            return this;
        }

        public Holder encoding(String str) {
            this.encoding = (String) update(this.encoding, str);
            return this;
        }

        public Holder format(String str) {
            this.format = (String) update(this.format, str);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiDataHolder
        public void paramSync(int i) {
            sync(i, "encoding", this.encoding.getBytes());
            sync(i, "compress", this.compress.getBytes());
            sync(i, "format", this.format.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiDataHolder
        public DataType type() {
            return DataType.TEXT;
        }

        private Holder(String str) {
            super(new AiText(), str);
            this.encoding = AiText.ENCODING_DEFAULT;
            this.compress = AiText.COMPRESS_DEFAULT;
            this.format = AiText.FORMAT_DEFAULT;
        }
    }

    public static Holder get(String str) {
        return new Holder(str);
    }

    public static void main(String[] strArr) {
        get("text").data("").compress(COMPRESS_GZIP).valid();
    }
}
