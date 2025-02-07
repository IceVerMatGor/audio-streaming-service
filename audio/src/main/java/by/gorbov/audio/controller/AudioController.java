package by.gorbov.audio.controller;

import by.gorbov.audio.entity.Resource;
import by.gorbov.audio.repo.AudioStore;
import by.gorbov.audio.repo.ResourceRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/api/v1/resources")
@AllArgsConstructor
@Slf4j
public class AudioController {

    private final ResourceRepo resourceService;
    private final AudioStore audioStore;

    @PutMapping("/{id}/audio")
    public ResponseEntity<?> setContent(@PathVariable("id") Long id, @RequestParam("audio") MultipartFile audio)
            throws IOException {

        Optional<Resource> resource = resourceService.findById(id);
        if (resource.isPresent()) {
            resource.get().setAudioType(audio.getContentType());

            resource.get().setChecksum(DigestUtils.md5Hex(audio.getInputStream()));

            audioStore.setContent(resource.get(), audio.getInputStream());

            resource.get().setOriginalFileName(audio.getOriginalFilename());
            resource.get().setPath(resource.get().getAudioId().toString());

            resourceService.save(resource.get());


            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/{id}/audio")
    public ResponseEntity<?> getContent(@PathVariable("id") Long id) {

        Optional<Resource> r = resourceService.findById(id);
        if (r.isPresent()) {
            InputStreamResource inputStreamResource = new InputStreamResource(audioStore.getContent(r.get()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentLength(r.get().getSize());
            headers.set("Content-Type", r.get().getAudioType());
            return new ResponseEntity<Object>(inputStreamResource, headers, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value = "/{id}/zip", produces = "application/zip")
    public void getContentZip(@PathVariable("id") Long id, HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.setContentType("application/zip");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=download.zip");

        Optional<Resource> r = resourceService.findById(id);

        if (r.isPresent()) {
            ZipOutputStream zipOut = new ZipOutputStream(httpServletResponse.getOutputStream());
            zipOut.setLevel(9);
            FileInputStream fis = new FileInputStream(r.get().getPath());

            ZipEntry zipEntry = new ZipEntry(r.get().getOriginalFileName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();

        }
    }
}
