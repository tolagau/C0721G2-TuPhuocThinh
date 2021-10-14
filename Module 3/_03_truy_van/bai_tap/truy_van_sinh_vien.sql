use quanlysinhvien;

-- BÀI TẬP


#Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from Student
where StudentName like 'h%';

#Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * 
from Class
where month(StartDate) = '12';

#Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select Mark.MarkId, Mark.SubId, Mark.StudentId, 
Mark.Mark, Mark.ExamTimes, `Subject`.Credit
from Mark join `Subject` on Mark.SubId = `Subject`.SubId
where Credit between 3 and 5;

#Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

update Class #tên bảng
set ClassID = 2 # trường dữ liệu cần thay đổi
					where ClassName like 'Hung'; # điều kiện

#Hiển thị các thông tin: StudentName, SubName, Mark. 
#Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

select Student.StudentName, `Subject`.SubName, Mark.Mark 
from Mark
join `Subject` on Mark.SubId = `Subject`.SubId
join Student on Student.StudentId = Mark.StudentId
order by mark desc, StudentName asc;

#Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào, lớp đó thuộc loại lớp nào

select Student.StudentID, Student.StudentName, Student.Address, 
Student.Phone, Student.`Status`, Student.ClassId, Class.ClassName, Class.`Status`

from Student join Class on Student.ClassId = Class.ClassId;

#Lấy ra số lượng học viên của từng lớp

select count(StudentID) as soluong, Class.ClassName
from Student 
join Class on Student.ClassID = Class.ClassID
group by ClassName;

#Lấy ra danh sách học viên và sắp xếp tên theo alphabet.
select *
from Student
order by StudentName asc