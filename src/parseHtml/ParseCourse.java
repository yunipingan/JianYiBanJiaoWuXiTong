package parseHtml;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.SystemParameters;
import beans.Course;
import beans.IMydata;

public class ParseCourse implements IParseHtml {
		
		public List<IMydata> parse(String html) {
			List<IMydata> courses = new ArrayList<IMydata>();
			Course course = null;
			Document document = Jsoup.parse(html);
			Element element = document.getElementById("kbtable");
			
			Elements trs = element.getElementsByTag("tr");
			for (int i = 0; i < trs.size()-1; i++) {
				
				Element e1 = trs.get(i);
				// 得到一行中的所有列
				Elements tds = e1.getElementsByTag("td");
				for (int j = 0 ; j <tds.size(); j++) {
					course = new Course();
					Element e2 = tds.get(j);
					
					Element div = e2.getElementsByTag("div").get(0);
					String value = div.text().trim();
					if(value.length()==1){
						System.out.println("无");
						course.setText("");
					}
					else{
						System.out.println(value.length()+"  "+value);
						course.setText(value);
					}
					courses.add(course);
				}
			}
			SystemParameters.courses = courses;
			return courses;
	}

}
