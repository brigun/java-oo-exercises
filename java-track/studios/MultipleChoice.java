
public class MultipleChoice extends Question
{
		String choiceA;
		String choiceB;
		String choiceC;
		String choiceD;
		
		public MultipleChoice(String ask, String ans, String a, String b, String c, String d)
		{
			super(ask, ans);
			choiceA = a;
			choiceB = b;
			choiceC = c;
			choiceD = d;
		}
		
}
