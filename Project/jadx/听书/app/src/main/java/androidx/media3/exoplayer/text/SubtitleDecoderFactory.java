package androidx.media3.exoplayer.text;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import androidx.media3.extractor.text.dvb.DvbDecoder;
import androidx.media3.extractor.text.pgs.PgsDecoder;
import androidx.media3.extractor.text.ssa.SsaDecoder;
import androidx.media3.extractor.text.subrip.SubripDecoder;
import androidx.media3.extractor.text.ttml.TtmlDecoder;
import androidx.media3.extractor.text.tx3g.Tx3gDecoder;
import androidx.media3.extractor.text.webvtt.Mp4WebvttDecoder;
import androidx.media3.extractor.text.webvtt.WebvttDecoder;

/* JADX INFO: loaded from: classes.dex */
public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT = new SubtitleDecoderFactory() { // from class: androidx.media3.exoplayer.text.SubtitleDecoderFactory.1
        @Override // androidx.media3.exoplayer.text.SubtitleDecoderFactory
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return MimeTypes.TEXT_VTT.equals(str) || MimeTypes.TEXT_SSA.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.TEXT_EXOPLAYER_CUES.equals(str);
        }

        @Override // androidx.media3.exoplayer.text.SubtitleDecoderFactory
        public SubtitleDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            if (str != null) {
                str.hashCode();
                switch (str) {
                    case "application/dvbsubs":
                        return new DvbDecoder(format.initializationData);
                    case "application/pgs":
                        return new PgsDecoder();
                    case "application/x-mp4-vtt":
                        return new Mp4WebvttDecoder();
                    case "text/vtt":
                        return new WebvttDecoder();
                    case "application/x-quicktime-tx3g":
                        return new Tx3gDecoder(format.initializationData);
                    case "text/x-ssa":
                        return new SsaDecoder(format.initializationData);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new Cea608Decoder(str, format.accessibilityChannel, Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS);
                    case "text/x-exoplayer-cues":
                        return new ExoplayerCuesDecoder();
                    case "application/cea-708":
                        return new Cea708Decoder(format.accessibilityChannel, format.initializationData);
                    case "application/x-subrip":
                        return new SubripDecoder();
                    case "application/ttml+xml":
                        return new TtmlDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    };

    SubtitleDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
