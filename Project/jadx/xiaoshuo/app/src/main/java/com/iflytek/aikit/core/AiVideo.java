package com.iflytek.aikit.core;

import java.security.InvalidParameterException;

/* JADX INFO: loaded from: classes7.dex */
public class AiVideo extends AbstractData {
    public static String ENCODING_DEFAULT = "h264";
    public static String ENCODING_H264 = "h264";

    public static class Holder extends AiDataHolder<Holder, AiVideo> {
        private String encoding;
        private int frameRate;
        private int height;
        private int width;

        public Holder(String str) {
            super(new AiVideo(), str);
            this.encoding = AiVideo.ENCODING_DEFAULT;
            this.frameRate = -1;
            this.width = -1;
            this.height = -1;
        }

        public Holder encoding(String str) {
            this.encoding = (String) update(this.encoding, str);
            return this;
        }

        public Holder frameRate(int i) {
            this.frameRate = ((Integer) update(Integer.valueOf(this.frameRate), Integer.valueOf(i))).intValue();
            return this;
        }

        public Holder height(int i) {
            this.height = ((Integer) update(Integer.valueOf(this.height), Integer.valueOf(i))).intValue();
            return this;
        }

        @Override // com.iflytek.aikit.core.AiDataHolder
        public void paramSync(int i) {
            sync(i, "encoding", this.encoding.getBytes());
            sync(i, "frame_rate", Integer.valueOf(this.frameRate));
            sync(i, "width", Integer.valueOf(this.width));
            sync(i, "height", Integer.valueOf(this.height));
        }

        @Override // com.iflytek.aikit.core.AiDataHolder
        public DataType type() {
            return DataType.VIDEO;
        }

        public Holder width(int i) {
            this.width = ((Integer) update(Integer.valueOf(this.width), Integer.valueOf(i))).intValue();
            return this;
        }

        @Override // com.iflytek.aikit.core.AiDataHolder
        public AiVideo valid() {
            super.valid();
            if (this.frameRate == -1 || this.width == -1 || this.height == -1) {
                throw new InvalidParameterException();
            }
            return (AiVideo) this.object;
        }
    }

    public static Holder get(String str) {
        return new Holder(str);
    }

    public static void main(String[] strArr) {
        get("video").data("").frameRate(1).valid();
    }
}
