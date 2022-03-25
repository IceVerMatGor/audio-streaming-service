package by.gorbov.audio.repo;

import by.gorbov.audio.entity.Audio;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.commons.repository.Store;
import org.springframework.content.rest.StoreRestResource;

import java.util.UUID;
@StoreRestResource(path="audios",linkRel = "audios")
public interface DvdStore extends Store<String> {
}
