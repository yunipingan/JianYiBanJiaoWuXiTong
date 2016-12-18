package parseHtml;

public class ParseHtmlFactory {

	public static IParseHtml getIParseHtml(String choice){
		IParseHtml parseHtml = null;
		switch (choice) {
		case "course":
			parseHtml = new ParseCourse();
			break;

		case "grade":
			parseHtml = new ParseGrade();
			break;
		default:{
			break;
		}
		}
		return parseHtml;
	}

}
