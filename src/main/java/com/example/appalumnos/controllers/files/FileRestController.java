package com.example.appalumnos.controllers.files;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.errors.storage.StorageException;
import com.example.appalumnos.services.uploads.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(APIConfig.API_PATH+"/files")
public class FileRestController {
    private final StorageService storageService;

    @Autowired
    public FileRestController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping( value = "{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename, HttpServletRequest request){
        Resource file = storageService.loadAsResource(filename);
        String contentType = null;
        try{
            contentType = request.getServletContext().getMimeType(file.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new StorageException("No se puede determinar el tipo del fichero "+filename,e);
        }
        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(file);
    }

    @PostMapping(value = "",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestPart MultipartFile file){
        String urlImage = null;
        try{
            if(!file.isEmpty()){
                String image = storageService.store(file);
                urlImage = storageService.getUrl(image);
                Map<String,Object> response = Map.of("url",urlImage);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }else{
                throw new StorageException("No se puede subir fichero vacio");
            }
        } catch(StorageException e){
            throw new StorageException("No se puede subir fichero vacio");
        }
    }
}
