package app.music.songservice.controller;

import app.music.songservice.exceptions.exception.BadRequestException;
import app.music.songservice.serivice.SongService;
import app.music.songservice.serivice.model.response.RecordId;
import app.music.songservice.serivice.model.response.RecordIds;
import app.music.songservice.serivice.model.response.SongDto;
import app.music.songservice.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static app.music.songservice.util.ValidationUtils.checkCondition;

@RestController
@RequestMapping("api/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping
    public ResponseEntity<RecordId> createSong(@RequestBody SongDto songDto) {
        return ResponseEntity.ok(songService.createSong(songDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @DeleteMapping
    public ResponseEntity<RecordIds> deleteSongs(@RequestParam String id) {
        List<Long> ids = RequestUtils.parseStringToListLong(id);
        checkCondition(ids.size() < 200, new BadRequestException("You can delete only 200 records"));
        return ResponseEntity.ok(songService.deleteSongs(ids));
    }

}
