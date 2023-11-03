public class CollegeInterface {
    public static void main(String[] args) {
        Student s1 = new Student("Awin", "CSE", "SJCET");
        System.out.println("Details: " + s1.getStudentName() + " - " + s1.getCollegeName() + " - " + s1.getDepartmentName());
    }
}

interface CollegeName {
    String getCollegeName();
}

interface Department extends CollegeName {
    String getDepartmentName();
}

class Student implements Department {
    String studentName, departmentName, collegeName;

    Student(String studentName, String departmentName, String collegeName) {
        this.studentName = studentName;
        this.departmentName = departmentName;
        this.collegeName= collegeName;
    }
    
    public String getStudentName() {
    	return studentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
