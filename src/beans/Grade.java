package beans;

public class Grade implements IMydata{
	
	String courseId;
	String courseName;
	String courseType;
	float usualPerformance;		//平时成绩
	float finalExam;			//期末考试成绩
	int totalScore;				//总成绩
	String examType;			//考试类型：正常考试、补缓考
	float credit;					//学分
	String text;				//拼凑到一块
	
	public Grade(){}
	public Grade(float usualPerformance, float finalExam, int totalScore,
			String examType) {
		super();
		this.usualPerformance = usualPerformance;
		this.finalExam = finalExam;
		this.totalScore = totalScore;
		this.examType = examType;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public float getUsualPerformance() {
		return usualPerformance;
	}
	public void setUsualPerformance(float usualPerformance) {
		this.usualPerformance = usualPerformance;
	}
	public float getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(float finalExam) {
		this.finalExam = finalExam;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	@Override
	public String getDataText() {
		// TODO Auto-generated method stub
		return getCourseId()
				+" " + getCourseName()
				+" " + getTotalScore()
				+ " " + getCredit()
				+ " " + getCourseType()
				+ " " + getExamType();
	}
	
}
