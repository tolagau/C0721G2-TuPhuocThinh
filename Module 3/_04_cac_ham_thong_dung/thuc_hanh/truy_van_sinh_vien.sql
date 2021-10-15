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
order by StudentName asc;


#Bài thực hành ss04_các hàm thông dụng

#Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

#Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

#Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S
         join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

#Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

#bài tập s04
#   -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- -- ~~ -- 

#Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select SubName, max(credit) as MaxCredit
from `subject`;

#Hiển thị các thông tin môn học có điểm thi lớn nhất.
select avg(Mark)
from Mark;
 
 #Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
 
 select Student.*, avg(Mark.Mark) as TrungBình
 from Student  
 join Mark  on Mark.StudentId = Student.StudentId
 join `subject` on `Subject`.SubId = Mark.SubId
group by Mark.Mark
order by Mark.Mark desc
















