package org.vsu.provider.infra.api.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vsu.provider.app.service.FileService;
import org.vsu.provider.domain.model.file.FileModel;
import org.vsu.provider.infra.api.dto.UnifiedResponse;
import org.vsu.provider.infra.api.rest.helper.FileHelper;

@RestController
@RequestMapping("/api/v1/files")
@AllArgsConstructor
public class FileController {

    private final FileService fileService;
    private final FileHelper fileHelper;

    @GetMapping
    public UnifiedResponse<FileModel> getFile(@RequestParam(name = "userId") String userId,
                                              @RequestParam(name = "fileName") String fileName) {
        return UnifiedResponse.result(fileService.getFile(userId, fileName));
    }

    @PostMapping
    public UnifiedResponse<?> saveFile(@RequestParam(name = "userId") String userId,
                                       @RequestParam(name = "fileName") String fileName,
                                       @RequestParam(name = "file") MultipartFile file) {
        byte[] fileBytes = fileHelper.fetchFileBytes(file);
        fileService.saveFile(userId, fileName, fileBytes);
        return UnifiedResponse.ok();
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public void test() {
        fileService.test();
        int x = 1;
    }

}
