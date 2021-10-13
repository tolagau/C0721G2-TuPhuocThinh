use quanlysinhvien


-- BÀI TẬP


#Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from Student
where StudentName like '%h%';

#Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * 
from Class
where month(StartDate) = '12';

#Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select Mark.MarkId,Mark.SubId,Mark.StudentId,Mark.Mark,Mark.ExamTimes,`Subject`.Credit
from Mark join `Subject` on Mark.SubId = `Subject`.SubId
where Credit between 3 and 5;

#Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

update Class
set ClassID = 2
					where ClassName like 'Hung'; 

#Hiển thị các thông tin: StudentName, SubName, Mark. 
#Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

select Student.StudentName, `Subject`.SubName, Mark.Mark 
from Mark
join `Subject` on Mark.SubId = `Subject`.SubId
join Student on Student.StudentId = Mark.StudentId
order by mark desc, StudentName asc






