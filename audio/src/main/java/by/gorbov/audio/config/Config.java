package by.gorbov.audio.config;

import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

@Configuration
@EnableFilesystemStores
@RequiredArgsConstructor
@Slf4j
public class Config {
    private final Properties configProp;

    @Bean
    File filesystemRoot() {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            configProp.load(in);
            return new File(configProp.getProperty("path"));
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Bean
    public FileSystemResourceLoader fileSystemResourceLoader() {
        return new FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
    }
}
