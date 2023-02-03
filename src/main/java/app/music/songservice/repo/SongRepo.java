package app.music.songservice.repo;

import app.music.songservice.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {

}
