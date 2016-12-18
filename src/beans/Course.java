package beans;

public class Course implements IMydata{
	
	String courseName;		//课程名称
	String courseId;		//课程id
	String courseTeacher;	//授课老师
	String courseAddress;	//上课地点
	String courseType;		//课程类型：必修，选修
	String term;			//课程学期
	String time;			//上课时间
	//Grade grade;			//课程成绩
	String text;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCourseName() {
		return courseName;
	}
	
	public Course(){};
	
	public Course(String courseName, String courseId, String courseTeacher,
			String courseAddress, String courseType, String term, String time) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseTeacher = courseTeacher;
		this.courseAddress = courseAddress;
		this.courseType = courseType;
		this.term = term;
		this.time = time;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getCourseAddress() {
		return courseAddress;
	}
	public void setCourseAddress(String courseAddress) {
		this.courseAddress = courseAddress;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String getDataText() {
		// TODO Auto-generated method stub
		return getText();
	}
	
}
