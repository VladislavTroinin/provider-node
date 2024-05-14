package org.vsu.provider.app.message.ru;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.vsu.provider.app.message.ExceptionMessages;

@Component
@ConditionalOnProperty(value = "internationalization.language", havingValue = "ru", matchIfMissing = true)
public class RussianExceptionMessages implements ExceptionMessages {

    @Override
    public String cannotReadUploadedFile() {
        return "Невозможно прочитать загруженный файл.";
    }

}
