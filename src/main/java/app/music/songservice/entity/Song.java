package app.music.songservice.entity;

import app.music.songservice.serivice.model.response.SongDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String artist;
    private String album;

    private String length;
    private Long resourceId;
    private String year;

    public SongDto mapToDto() {
        return new SongDto(
                name,
                artist,
                album,
                length,
                resourceId,
                year
        );
    }
}
