package app.music.songservice.serivice;

import app.music.songservice.exceptions.exception.NotFoundException;
import app.music.songservice.repo.SongRepo;
import app.music.songservice.serivice.model.response.RecordId;
import app.music.songservice.serivice.model.response.RecordIds;
import app.music.songservice.serivice.model.response.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepo songRepo;

    @Override
    public RecordId createSong(SongDto songDto) {
        var song = songDto.mapToEntity();
        song = songRepo.save(song);
        return new RecordId(song.getId());
    }

    @Override
    public SongDto getSongById(Long id) {
        return songRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Song not found"))
                .mapToDto();
    }

    @Override
    public RecordIds deleteSongs(List<Long> ids) {
        songRepo.deleteAllById(ids);
        return new RecordIds(ids);
    }
}
