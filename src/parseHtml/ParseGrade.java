package parseHtml;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.SystemParameters;
import beans.Course;
import beans.Grade;
import beans.IMydata;

public class ParseGrade implements IParseHtml {
		
		public List<IMydata> parse(String html) {
			List<IMydata> grades = new ArrayList<IMydata>();
			Grade grade = null;
			Document document = Jsoup.parse(html);
			Element element = document.getElementById("dataList");
			
			Elements trs = element.getElementsByTag("tr");
			for (int i = 1; i < trs.size(); i++) {
				Element e1 = trs.get(i);
				Elements tds = e1.getElementsByTag("td");
				grade = new Grade();
				grade.setCourseId(tds.get(2).text());
				grade.setCourseName(tds.get(3).text());
				grade.setTotalScore(Integer.valueOf(tds.get(4).text()));
				grade.setCredit(Float.valueOf(tds.get(5).text()));
				grade.setCourseType(tds.get(8).text());
				grade.setExamType(tds.get(11).text());
		
				grades.add(grade);
				System.out.println(grade.getDataText());
				
			}
			SystemParameters.grades = grades;
			return grades;
	}

}
