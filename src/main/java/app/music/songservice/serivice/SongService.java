package app.music.songservice.serivice;

import app.music.songservice.serivice.model.response.RecordId;
import app.music.songservice.serivice.model.response.RecordIds;
import app.music.songservice.serivice.model.response.SongDto;

import java.util.List;

public interface SongService {
    RecordId createSong(SongDto songDto);

    SongDto getSongById(Long id);

    RecordIds deleteSongs(List<Long> ids);
}
