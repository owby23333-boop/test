package com.iflytek.aikit.core;

import android.util.Log;
import com.iflytek.aikit.media.player.PlayerPluginInterface;
import com.iflytek.aikit.plugin.base.PluginInterface;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;

/* JADX INFO: loaded from: classes7.dex */
public class AiRequest {
    private int handle;
    private PlayerPluginInterface playerPlugin;
    private PluginInterface pluginInterface;

    public static class Builder extends ParamBuilder<Builder> implements BuilderApi {
        private PluginInterface pluginInterface;

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audio(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                return this;
            }
            this.paramCount++;
            add(str, byteBuffer, DataType.AUDIO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audioFile(String str, ByteBuffer byteBuffer) {
            this.paramCount++;
            add(str, byteBuffer, DataFrom.FILE, DataType.AUDIO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder begin() {
            return status(AiStatus.BEGIN);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder bindPlugin(PluginInterface pluginInterface) {
            if (pluginInterface != null) {
                this.pluginInterface = pluginInterface;
            }
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public AiRequest build() {
            PluginInterface pluginInterface = this.pluginInterface;
            return pluginInterface != null ? new AiRequest(this.handle, pluginInterface) : new AiRequest(this.handle);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder clear() {
            super.clean();
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder cont() {
            return status(AiStatus.CONTINUE);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder customText(String str, String str2, int i) {
            if (str2 == null) {
                return this;
            }
            this.paramCount++;
            return customTextFile(str, str2.getBytes(), i);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder customTextFile(String str, byte[] bArr, int i) {
            this.paramCount++;
            custom(str, bArr, DataFrom.FILE, DataType.TEXT.getValue(), i);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        @Deprecated
        public Builder dataStatus(DataStatus dataStatus) {
            this.status = dataStatus.next();
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        @Deprecated
        public Builder desc(String str, Builder builder) {
            if (builder == null) {
                return this;
            }
            this.paramCount++;
            AiHelper.getInst().newDesc(this.handle, str, builder.handle);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder end() {
            return status(AiStatus.END);
        }

        @Override // com.iflytek.aikit.core.AiBuilder
        public void finalize() {
            try {
                super.finalize();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            AiHelper.getInst().delBuilderDelayed(this.handle);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public HeaderHolder header() {
            AiHelper.getInst().header(this.handle);
            return new HeaderHolder(this);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder image(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                return this;
            }
            this.paramCount++;
            add(str, byteBuffer, DataType.IMAGE);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder imageFile(String str, ByteBuffer byteBuffer) {
            this.paramCount++;
            add(str, byteBuffer, DataFrom.FILE, DataType.IMAGE);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder once() {
            return status(AiStatus.ONCE);
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder param(String str, double d) {
            return (Builder) super.param(str, d);
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder paramFalse(String str) {
            return (Builder) super.paramFalse(str);
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder paramFile(String str, String str2) {
            return (Builder) super.paramFile(str, str2);
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder paramTrue(String str) {
            return (Builder) super.paramTrue(str);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder payload(AiData aiData) {
            aiData.syncDesc(this.handle);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public ServiceHolder service(String str) {
            if (str == null) {
                throw new InvalidParameterException();
            }
            AiHelper.getInst().service(this.handle, str);
            return new ServiceHolder(this);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder status(AiStatus aiStatus) {
            this.status = aiStatus;
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder text(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                return this;
            }
            this.paramCount++;
            add(str, byteBuffer, DataType.TEXT);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder textFile(String str, ByteBuffer byteBuffer) {
            this.paramCount++;
            add(str, byteBuffer, DataFrom.FILE, DataType.TEXT);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder video(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                return this;
            }
            this.paramCount++;
            add(str, byteBuffer, DataType.VIDEO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder videoFile(String str, ByteBuffer byteBuffer) {
            this.paramCount++;
            add(str, byteBuffer, DataFrom.FILE, DataType.VIDEO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder param(String str, int i) {
            return (Builder) super.param(str, i);
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder paramFile(String str, byte[] bArr) {
            return (Builder) super.paramFile(str, bArr);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audio(String str, byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.paramCount++;
            add(str, bArr, DataType.AUDIO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audioFile(String str, byte[] bArr) {
            this.paramCount++;
            add(str, bArr, DataFrom.FILE, DataType.AUDIO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder image(String str, byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.paramCount++;
            add(str, bArr, DataType.IMAGE);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder imageFile(String str, byte[] bArr) {
            this.paramCount++;
            add(str, bArr, DataFrom.FILE, DataType.IMAGE);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        @Deprecated
        public /* bridge */ /* synthetic */ Builder param(String str, Builder builder) {
            return (Builder) super.param(str, builder);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder text(String str, byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.paramCount++;
            add(str, bArr, DataType.TEXT);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder textFile(String str, byte[] bArr) {
            this.paramCount++;
            add(str, bArr, DataFrom.FILE, DataType.TEXT);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder video(String str, byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.paramCount++;
            add(str, bArr, DataType.VIDEO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder videoFile(String str, byte[] bArr) {
            this.paramCount++;
            add(str, bArr, DataFrom.FILE, DataType.VIDEO);
            return this;
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder param(String str, String str2) {
            return (Builder) super.param(str, str2);
        }

        public ServiceHolder service(String str, Builder builder) {
            if (str != null) {
                AiHelper.getInst().serviceParam(this.handle, str, builder.handle);
                return new ServiceHolder(this);
            }
            throw new InvalidParameterException();
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audio(String str, String str2) {
            return str2 == null ? this : audio(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder audioFile(String str, String str2) {
            return audioFile(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder image(String str, String str2) {
            return str2 == null ? this : image(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder imageFile(String str, String str2) {
            return imageFile(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder param(String str, boolean z) {
            return (Builder) super.param(str, z);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder text(String str, String str2) {
            return str2 == null ? this : text(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder textFile(String str, String str2) {
            return textFile(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder video(String str, String str2) {
            return str2 == null ? this : video(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder videoFile(String str, String str2) {
            return videoFile(str, str2.getBytes());
        }

        @Override // com.iflytek.aikit.core.AiRequest.ParamBuilder, com.iflytek.aikit.core.AiRequest.BuilderApi
        public /* bridge */ /* synthetic */ Builder param(String str, byte[] bArr) {
            return (Builder) super.param(str, bArr);
        }

        @Override // com.iflytek.aikit.core.AiRequest.BuilderApi
        public Builder text(String str, String str2, String str3) {
            if (str2 == null) {
                return this;
            }
            byte[] bytes = new byte[0];
            try {
                bytes = str2.getBytes(str3);
            } catch (UnsupportedEncodingException e) {
                Log.e("AEE", "text:" + e.toString());
            }
            return text(str, bytes);
        }
    }

    public interface BuilderApi {
        Builder audio(String str, String str2);

        Builder audio(String str, ByteBuffer byteBuffer);

        Builder audio(String str, byte[] bArr);

        Builder audioFile(String str, String str2);

        Builder audioFile(String str, ByteBuffer byteBuffer);

        Builder audioFile(String str, byte[] bArr);

        Builder begin();

        Builder bindPlugin(PluginInterface pluginInterface);

        AiRequest build();

        Builder clear();

        Builder cont();

        Builder customText(String str, String str2, int i);

        Builder customTextFile(String str, byte[] bArr, int i);

        @Deprecated
        Builder dataStatus(DataStatus dataStatus);

        @Deprecated
        Builder desc(String str, Builder builder);

        Builder end();

        HeaderHolder header();

        Builder image(String str, String str2);

        Builder image(String str, ByteBuffer byteBuffer);

        Builder image(String str, byte[] bArr);

        Builder imageFile(String str, String str2);

        Builder imageFile(String str, ByteBuffer byteBuffer);

        Builder imageFile(String str, byte[] bArr);

        Builder once();

        Builder param(String str, double d);

        Builder param(String str, int i);

        @Deprecated
        Builder param(String str, Builder builder);

        Builder param(String str, String str2);

        Builder param(String str, boolean z);

        Builder param(String str, byte[] bArr);

        Builder paramFalse(String str);

        Builder paramFile(String str, String str2);

        Builder paramFile(String str, byte[] bArr);

        Builder paramTrue(String str);

        Builder payload(AiData aiData);

        ServiceHolder service(String str);

        Builder status(AiStatus aiStatus);

        Builder text(String str, String str2);

        Builder text(String str, String str2, String str3);

        Builder text(String str, ByteBuffer byteBuffer);

        Builder text(String str, byte[] bArr);

        Builder textFile(String str, String str2);

        Builder textFile(String str, ByteBuffer byteBuffer);

        Builder textFile(String str, byte[] bArr);

        Builder video(String str, String str2);

        Builder video(String str, ByteBuffer byteBuffer);

        Builder video(String str, byte[] bArr);

        Builder videoFile(String str, String str2);

        Builder videoFile(String str, ByteBuffer byteBuffer);

        Builder videoFile(String str, byte[] bArr);
    }

    public static class HeaderHolder extends ParamBuilder<HeaderHolder> {
        private final Builder builder;

        public HeaderHolder(Builder builder) {
            this.builder = builder;
            this.handle = builder.handle;
        }

        public Builder end() {
            return this.builder;
        }
    }

    public static class ServiceHolder extends ParamBuilder<ServiceHolder> {
        private final Builder builder;

        public ServiceHolder(Builder builder) {
            this.builder = builder;
            this.handle = builder.handle;
        }

        public ServiceHolder ctrl(AiData aiData) {
            aiData.syncCtrl(this.handle);
            return this;
        }

        public Builder end() {
            return this.builder;
        }
    }

    public enum VarType implements Const {
        STRING(0),
        INT(1),
        DOUBLE(2),
        BOOL(3),
        UNKNOWN(-1);

        private final int value;

        VarType(int i) {
            this.value = i;
        }

        @Override // com.iflytek.aikit.core.Const
        public int getValue() {
            return this.value;
        }

        public static VarType valueOf(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return INT;
            }
            if (i == 2) {
                return DOUBLE;
            }
            if (i == 3) {
                return BOOL;
            }
            if (i == -1) {
                return UNKNOWN;
            }
            throw new IllegalArgumentException("type not supported");
        }
    }

    private void bindPlugin(PluginInterface pluginInterface) {
        this.pluginInterface = pluginInterface;
        try {
            if (pluginInterface instanceof PlayerPluginInterface) {
                PlayerPluginInterface playerPluginInterface = (PlayerPluginInterface) pluginInterface;
                this.playerPlugin = playerPluginInterface;
                playerPluginInterface.bindHandleId(this.handle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public void finalize() throws Throwable {
        super.finalize();
        PlayerPluginInterface playerPluginInterface = this.playerPlugin;
        if (playerPluginInterface != null) {
            playerPluginInterface.unBindHandleId();
        }
    }

    public int getHandle() {
        return this.handle;
    }

    public PluginInterface getPluginInterface() {
        try {
            if (this.pluginInterface instanceof PlayerPluginInterface) {
                return this.playerPlugin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.pluginInterface;
    }

    public static abstract class ParamBuilder<T> extends AiBuilder {
        /* JADX WARN: Multi-variable type inference failed */
        private T response() {
            return this;
        }

        @Override // com.iflytek.aikit.core.AiBuilder
        public /* bridge */ /* synthetic */ void clean() {
            super.clean();
        }

        public T param(String str, int i) {
            this.paramCount++;
            AiHelper.getInst().newInteger(this.handle, str, i);
            return response();
        }

        public T paramFalse(String str) {
            return param(str, false);
        }

        public T paramFile(String str, byte[] bArr) {
            if (bArr != null) {
                this.paramCount++;
                add(str, bArr, DataFrom.FILE, DataType.OTHER);
            }
            return response();
        }

        public T paramTrue(String str) {
            return param(str, true);
        }

        public T param(String str, double d) {
            this.paramCount++;
            AiHelper.getInst().newDouble(this.handle, str, d);
            return response();
        }

        public T paramFile(String str, String str2) {
            if (str2 != null) {
                return paramFile(str, str2.getBytes());
            }
            return response();
        }

        public T param(String str, boolean z) {
            this.paramCount++;
            AiHelper.getInst().newBoolean(this.handle, str, z);
            return response();
        }

        public T param(String str, byte[] bArr) {
            if (bArr != null) {
                this.paramCount++;
                add(str, bArr);
            }
            return response();
        }

        public T param(String str, String str2) {
            if (str2 != null) {
                add(str, str2.getBytes());
            }
            return response();
        }

        @Deprecated
        public T param(String str, Builder builder) {
            if (builder != null) {
                this.paramCount++;
                AiHelper.getInst().newBuilder(this.handle, str, builder.handle);
            }
            return response();
        }
    }

    public AiRequest() {
    }

    private AiRequest(int i) {
        this.handle = i;
    }

    private AiRequest(int i, PluginInterface pluginInterface) {
        if (pluginInterface != null) {
            bindPlugin(pluginInterface);
        }
        this.handle = i;
    }
}
