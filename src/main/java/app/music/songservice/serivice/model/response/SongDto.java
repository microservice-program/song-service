package app.music.songservice.serivice.model.response;

import app.music.songservice.entity.Song;

public record SongDto(String name,
                      String artist,
                      String album,
                      String length,
                      Long resourceId,
                      String year) {

    public Song mapToEntity() {
        Song song = new Song();
        song.setAlbum(album);
        song.setName(name);
        song.setArtist(artist);
        song.setLength(length);
        song.setResourceId(resourceId);
        song.setYear(year);
        return song;

    }
}
