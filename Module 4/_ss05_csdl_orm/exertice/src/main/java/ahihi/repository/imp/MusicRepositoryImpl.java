package ahihi.repository.imp;

import ahihi.bean.Music;
import ahihi.repository.IMusicRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
@Service
public class MusicRepositoryImpl implements IMusicRepository {


    @Override
    public List<Music> findAll() {

        List<Music> musicList = BaseRepository.entityManager.createQuery("select s from music as s", Music.class).getResultList();

        return musicList;
    }

    @Override
    public Music findById(Integer id) {
        return BaseRepository.entityManager.find(Music.class, id);
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer id) {
        Music music = findById(id);
        if (music != null)
            BaseRepository.entityManager.remove(music);
    }
}
