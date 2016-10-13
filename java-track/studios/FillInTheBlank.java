
public class FillInTheBlank extends Question
{
	private String statement;
	
	public FillInTheBlank(String ask, String ans, String phrase)
	{
		super(ask, ans);
		statement = phrase;
	}

}
