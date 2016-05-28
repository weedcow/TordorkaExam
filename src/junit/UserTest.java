package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.DAOimpl;

public class UserTest extends dao.DAOimpl{

	@Test
	public void test() {
			UserTest Test = new UserTest();
			Boolean result = Test.buyCar(1, 1);
			assertEquals(true, result);
	}

}
