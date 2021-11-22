package com.service;


import com.model.Song;

import java.util.List;

public interface ISongService {
    public List<Song> showListSong();

    public Song showDetailSong(int id);

    public void addSong(Song song);

    public void editSong(Song song);

    public void delete(int id);

    public List<Song> searchName(String name);
}
