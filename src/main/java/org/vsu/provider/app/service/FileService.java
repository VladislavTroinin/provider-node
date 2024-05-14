package org.vsu.provider.app.service;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.vsu.provider.app.config.StorageConfig;
import org.vsu.provider.app.provider.DistributorProvider;
import org.vsu.provider.domain.model.block.BlockModel;
import org.vsu.provider.domain.model.block.DataBlock;
import org.vsu.provider.domain.model.block.StorageBlock;
import org.vsu.provider.domain.model.file.FileModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

@AllArgsConstructor
public class FileService {

//    private final StorageConfig storageConfig;
    private final DistributorProvider distributorProvider;

    public FileModel getFile(@NonNull String userId, @NonNull String fileName) {
        int defaultDataBlockSize = distributorProvider.getDataBlockSize();

        int blockIndex = 0;
        List<byte[]> fileByteList = new ArrayList<>();

//        do {
//            StorageBlock storageBlock = distributorProvider.getStorageBlock(userId, fileName, blockIndex++);
//            Integer dataBlockByteCount = storageBlock.infoBlock().byteCount();
//            byte[] actualDataBytes = !isLastBlock
//                    ? storageBlock.dataBlock().bytes()
//                    : Arrays.copyOf(storageBlock.dataBlock().bytes(), storageBlock.infoBlock().byteCount());
//            int dataBlockSize = isLastBlock ? storageBlock.infoBlock().byteCount() : defaultDataBlockSize;
//
//            dataBlocks.add(storageBlock.dataBlock());
//
//        } while ();

        return null;
    }

    public void saveFile(@NonNull String userId, @NonNull String fileName, @NonNull byte[] fileBytes) {
//        int fileSize = fileBytes.length;
//        int storageBlockSize = storageConfig.getBlockSize();
//        int blockCount = Math.ceilDiv(fileSize, storageBlockSize);
//
//        for (int i = 0; i < blockCount; i++) {
//            int fromIndex = i * storageBlockSize;
//            int toIndex = Math.min((i + 1) * storageBlockSize, fileSize);
//            int actualBlockSize = toIndex - fromIndex;
//
//            byte[] blockBytes = new byte[storageBlockSize];
//            System.arraycopy(fileBytes, fromIndex, blockBytes, 0, actualBlockSize);
//            BlockModel blockModel = new BlockModel(userId, fileName, i, actualBlockSize, blockBytes);
//            distributorProvider.saveStorageBlock(blockModel);
//        }
    }

}
