package ahihi.service;

import ahihi.bean.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(Integer id);

    void save(Music music);

    void remove(Integer id);
}
