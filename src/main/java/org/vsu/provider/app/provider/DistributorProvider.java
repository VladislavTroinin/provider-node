package org.vsu.provider.app.provider;

import org.springframework.lang.NonNull;
import org.vsu.provider.domain.model.block.InfoBlock;
import org.vsu.provider.domain.model.block.StorageBlock;

public interface DistributorProvider {

    Integer getDataBlockSize();

    StorageBlock getStorageBlock(@NonNull String userId,
                                 @NonNull String fileName,
                                 @NonNull Integer orderNumber);

    void saveStorageBlock(@NonNull StorageBlock storageBlock);

    void test();

}
