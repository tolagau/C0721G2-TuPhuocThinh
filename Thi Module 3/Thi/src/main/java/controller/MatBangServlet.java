package controller;

import bean.*;
import repository.IMatBang;
import repository.imp.MatBangRepository;
import repository.imp.ThuVienRepository;
import util.ConnectionSQL;
import util.GetInfoDataType;
import util.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"/matbang"})

public class MatBangServlet extends HttpServlet {
    private  GetInfoDataType getInfoDataType = new GetInfoDataType();
    private static MatBangRepository matBangRepository = new MatBangRepository();
    private static ConnectionSQL connectionSQL = new ConnectionSQL();
    private static ThuVienRepository thuVienRepository = new ThuVienRepository();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "update":
                    break;
                case "create":
                    createNewLand(request, response);
                    break;
                case "search":
                    searchLand(request, response);
                    break;
                default:
                    showListSach(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String note = request.getParameter("note");
        if (note == null) {
            note = "";
        }
        try {
            switch (note) {
                case "create":
                    showFormAddLand(request, response);
                    break;
//                case "edit":
//                    showEmployeeEdit(request, response);
//                    break;

                case "listmuon":
                    showListMuonSach(request, response);
                    break;

                default:
                    showListSach(request, response);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void showListSach(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        List<Sach> sachList = getInfoDataType.selectSach();

        request.setAttribute("sachList", sachList);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    public static void showListMuonSach(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        List<MuonSach> muonSachList = ThuVienRepository.selectAll();

        request.setAttribute("sachList", muonSachList);

        request.getRequestDispatcher("listMuon.jsp").forward(request, response);
    }

    //show mượn sách
    public void showFormAddLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        List<Sach> sachList = getInfoDataType.selectSach();

        request.setAttribute("sachList", sachList);

        List<HocSinh> hocSinhList = getInfoDataType.selectHocSinh();

        request.setAttribute("hocSinhList", hocSinhList);


        request.getRequestDispatcher("create.jsp").forward(request, response);

    }


    public void createNewLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        String id = request.getParameter("id");
        String tenSach = request.getParameter("tenSach");

        String tenHocSinh = request.getParameter("tenHocSinh");
        String ngaymuon = request.getParameter("ngaymuon");
        String ngaytra = request.getParameter("ngaytra");
        MuonSach muonSach = new MuonSach(id, new Sach(tenSach), new HocSinh(tenHocSinh), ngaymuon, ngaytra);
        thuVienRepository.insertMuonSach(muonSach);
        request.setAttribute("mess", "đã thêm thành công");
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }


    //-- Validate--//

//    public void createNewLand(HttpServletRequest request, HttpServletResponse response) throws
//            ServletException, IOException {
//        Boolean flag = false;
//        String idError = "";
//        String id = request.getParameter("id");
//        String dientich = request.getParameter("dientich");
//
//        String trangthai = request.getParameter("trangthai");
//        String tang = request.getParameter("tang");
//        String loai_mat_bang = request.getParameter("loai_mat_bang");
//        String mota = request.getParameter("mota");
//        String gia = request.getParameter("gia");
//        String ngaybatdau = request.getParameter("ngaybatdau");
//        String ngayketthuc = request.getParameter("ngayketthuc");
//
//
//
//        if (Validate.checkRegex(id, Validate.ID_LAND)) {
//            flag = true;
//            idError += "Nhập sai định dạng, vd: NV-XXXX";
//            //xử lý trùng lặp id
//            List<MatBang> matBangList = matBangRepository.selectAll();
//            for (MatBang matBang1 : matBangList) {
//                if (matBang1.getId().equals(id)) {
//                    idError += "ID nhập bị trùng, hãy nhập id khác";
//                }
//            }
//        }
//        MatBang matBang = new MatBang(id, dientich, trangthai, tang, new LoaiMatBang(loai_mat_bang), mota, gia, ngaybatdau, ngayketthuc);
//        if (flag) {
//            request.setAttribute("idError", idError);
//            showFormAddLand(request, response);
//        } else {
//            matBangRepository.insertLand(matBang);
////            request.setAttribute("mess", "đã thêm thành công");
////            request.getRequestDispatcher("create.jsp").forward(request, response);
//            response.sendRedirect("/list");
//
//        }
//    }


    public void deleteLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String id = request.getParameter("id");
        matBangRepository.deleteLand(id);
        response.sendRedirect("/matbang");
    }

    public void searchLand(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String landTypeName = request.getParameter("landTypeName");
        String floor = request.getParameter("floor");
        String price = request.getParameter("price");
        List<MatBang> landList;
        if ((landTypeName == "") | (floor == "") | (price == "")) {
            landList = matBangRepository.searchLandField(landTypeName, price, floor);
        } else {
            landList = matBangRepository.searchLand(landTypeName, Integer.parseInt(price), Integer.parseInt(floor));
        }
        request.setAttribute("landList", landList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
