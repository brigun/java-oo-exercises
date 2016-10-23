package blogz;

import java.util.Date;

public class Post extends Entity
{
	private String title;
	private String body;
	private User author;
	private final Date created;
	private Date edited;
	
	public Post(String name, String text, User author)
	{
		super();
		this.title = name;
		this.body = text;
		this.author = author;
		this.created = new Date();
		this.edited = created;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getBody()
	{
		return this.body;
	}
	
	public User getAuthor()
	{
		return this.author;
	}
	
	public Date getCreated()
	{
		return this.created;
	}
	
	public Date getEdited()
	{
		return this.edited;
	}
	
	public void setEdited()
	{
		this.edited =new Date();
	}
	
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
		this.setEdited();
	}
	
	public void setBody(String newText)
	{
		this.body = newText;
		this.setEdited();
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", body=" + body + ", author=" + author + ", created=" + created + ", edited="
				+ edited + "]";
	}
	

}
