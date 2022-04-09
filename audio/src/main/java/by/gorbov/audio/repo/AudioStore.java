package by.gorbov.audio.repo;

import by.gorbov.audio.entity.Resource;
import org.springframework.content.commons.repository.ContentStore;


public interface AudioStore extends ContentStore<Resource,String> {
}
