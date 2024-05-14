package org.vsu.provider.infra.api.websocket.provider;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.vsu.provider.app.annotation.Provider;
import org.vsu.provider.app.provider.DistributorProvider;
import org.vsu.provider.domain.model.block.BlockInfo;
import org.vsu.provider.domain.model.block.BlockModel;
import org.vsu.provider.domain.model.block.InfoBlock;
import org.vsu.provider.domain.model.block.StorageBlock;

@Provider
@AllArgsConstructor
public class WsDistributorProvider implements DistributorProvider {

    @Override
    public Integer getDataBlockSize() {
        return 1024;
    }

    @Override
    public StorageBlock getStorageBlock(@NonNull String userId,
                                        @NonNull String fileName,
                                        @NonNull Integer orderNumber) {
        return null;
    }

    @Override
    public void saveStorageBlock(@NonNull StorageBlock storageBlock) {
        // todo
    }

}
