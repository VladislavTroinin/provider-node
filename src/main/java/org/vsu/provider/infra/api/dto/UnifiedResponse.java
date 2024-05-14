package org.vsu.provider.infra.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.vsu.provider.infra.api.enumeration.ResponseStatusCode;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UnifiedResponse<T> {

    private final int statusCode;

    @JsonInclude(Include.NON_NULL)
    private final String errorMessage;

    @JsonInclude(Include.NON_NULL)
    private final LocalDateTime time;

    @JsonInclude(Include.NON_NULL)
    private final T resultData;

    public static UnifiedResponse<?> ok() {
        return new UnifiedResponse<>(
                ResponseStatusCode.OK.getValue(),
                null,
                LocalDateTime.now(),
                null);
    }

    public static <T> UnifiedResponse<T> result(@NonNull T resultData) {
        return new UnifiedResponse<>(
                ResponseStatusCode.OK.getValue(),
                null,
                LocalDateTime.now(),
                resultData);
    }

    public static UnifiedResponse<?> error(@NonNull ResponseStatusCode statusCode, @NonNull String errorMessage) {
        return new UnifiedResponse<>(
                statusCode.getValue(),
                errorMessage,
                LocalDateTime.now(),
                null);
    }

}
