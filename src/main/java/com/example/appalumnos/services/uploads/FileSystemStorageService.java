package com.example.appalumnos.services.uploads;

import com.example.appalumnos.controllers.files.FileRestController;
import com.example.appalumnos.errors.storage.StorageException;
import com.example.appalumnos.errors.storage.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    public FileSystemStorageService(@Value("${upload.root-location}")String path) {
        this.rootLocation = Paths.get(path);
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(this.rootLocation);
        } catch (IOException e) {
            throw new StorageException("No se pudo iniciar el sistema de almacenamiento",e);
        }
    }

    @Override
    public String store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = StringUtils.getFilenameExtension(filename);
        String justFilename = filename.replace("."+extension,"");
        String storedFilename = System.currentTimeMillis()+"_"+ justFilename + "." + extension;
        try{
            if(file.isEmpty()){
                throw new StorageException("Fallo al intentar almacenar fichero vacio "+filename);
            }
            if (filename.contains("..")){
                throw new StorageException("No se puede almacenar fichero fuera del path autorizado "+filename);
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,
                        this.rootLocation.resolve(storedFilename),
                        StandardCopyOption.REPLACE_EXISTING);
                return storedFilename;
            }
        }catch(IOException e){
            throw new StorageException("Fallo al intentar almacenar fichero "+filename);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation,1)
                    .filter(path -> path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Fallo al leer los archivos almacenados",e);
        }
    }

    @Override
    public Path load(String filename) {
        return this.rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try{
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists()||resource.isReadable()){
                return resource;
            }else {
                throw new StorageFileNotFoundException("No se puede leer el fichero: "+filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("No se puede leer el fichero: "+filename,e);
        }
    }

    @Override
    public void delete(String filename) {
        String justFilename = StringUtils.getFilename(filename);
        try{
            Path file = load(filename);
            Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new StorageException("Fallo al eliminar el fichero "+filename,e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(this.rootLocation.toFile());
    }

    @Override
    public String getUrl(String filename) {
        return MvcUriComponentsBuilder.fromMethodName(FileRestController.class,"serveFile",filename,null)
                .build()
                .toUriString();
    }
}