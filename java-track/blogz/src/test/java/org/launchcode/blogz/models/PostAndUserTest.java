package org.launchcode.blogz.models;

import static org.junit.Assert.*;

import org.junit.Test;
import org.launchcode.blogz.models.Post;
import org.launchcode.blogz.models.User;

public class PostAndUserTest {

	@Test
	public void testUser() {
		String a = "Charlie";
		String b = "blue42";
		
		User chuck = new User(a, b);
				
		assertTrue("The name is not being stored properly", a == chuck.getUsername());
		assertTrue("The password is being stored properly", b == chuck.getPasswordHash());
	}
	
	@Test
	public void testIsValidUsername()
	{
		String a = "two";
		User frank = new User(a, "hammurabi");
		
		assertFalse("The user name validation is not working properly.", frank.getUsername() ==  a);
		
	}
	
	@Test
	public void testMemberList()
	{
		User hortense = new User("Hortense", "nonsense");
		assertTrue("Users are not being added to the list correctly", User.getMemberList().size() == 1);
		
		
	}

	@Test
	public void testEntity()
	{
		User user1 = new User("Bradley", "Chicken");
		User user2 = new User("Shelby", "Gondola");
		Post post1 = new Post("first","words", user1 );
		Post post2 = new Post("Shelby says...", "Seven super salons", user2);
		System.out.println(user1);
		System.out.println("user1 uid =" + user1.getUid());
		System.out.println(post1);
		System.out.println("post1 uid =" + post1.getUid());
		System.out.println(user2);
		System.out.println("user2 uid =" + user2.getUid());
		System.out.println(post2);
		System.out.println("post2 uid =" + post2.getUid());
	}

}