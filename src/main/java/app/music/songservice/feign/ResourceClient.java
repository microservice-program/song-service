package app.music.songservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "song-resource", url = "http://localhost:8080/api/resources")
public interface ResourceClient {

    @GetMapping("/{id}/check")
    Boolean checkResourceById(@PathVariable Long id);
}
