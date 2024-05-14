package org.vsu.provider.domain.model.block;

import org.springframework.lang.NonNull;

public record DataBlock(@NonNull byte[] bytes) {

}
