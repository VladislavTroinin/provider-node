package org.vsu.provider.app.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class StorageConfig {

    @Setter(AccessLevel.PRIVATE)
    @Value("${workflow.data.block-size}")
    private int blockSize;

    @Setter(AccessLevel.PRIVATE)
    @Value("${workflow.data.public-key}")
    private String publicKey;

    @Setter(AccessLevel.PRIVATE)
    @Value("${workflow.data.private-key}")
    private String privateKey;

}
