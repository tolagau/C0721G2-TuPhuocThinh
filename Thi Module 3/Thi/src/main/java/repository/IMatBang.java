package repository;

import bean.MatBang;

import java.util.List;

public interface IMatBang {
    public List<MatBang> selectAll();
    public MatBang selectLand(String id);
    public void insertLand(MatBang land);
    public void updateLand(MatBang land) ;
    public void deleteLand( String id) ;

    public List<MatBang> searchLand(String loaiMatBang, int gia, int tang);
    public List<MatBang> searchLandField(String loaiMatBang, String gia, String tang);

}
