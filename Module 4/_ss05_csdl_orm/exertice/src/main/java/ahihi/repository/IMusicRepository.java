package ahihi.repository;

import ahihi.bean.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    Music findById(Integer id);

    void save(Music music);

    void remove(Integer id);

}
