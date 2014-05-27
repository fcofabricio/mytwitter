package net.codeorbecoded.mytwitter.test.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import net.codeorbecoded.mytwitter.constraints.TransientGroup;
import net.codeorbecoded.mytwitter.model.User;
import net.codeorbecoded.mytwitter.repositories.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public class UserTest extends BaseEntityTest<User> {
	
	private User subject;
	private static UserRepository userRepository;
	private static EntityManager entityManager;
	
	@BeforeClass
	public static void setUpClass() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ForTest-PU");
		entityManager = emf.createEntityManager();
		
		userRepository = 
			(UserRepository) new JpaRepositoryFactory(entityManager).getRepository(UserRepository.class);
	}
	
	@Before
	public void setUpTest() {
		subject = new User("Example User", "user@example.com", "foobar", "foobar");
	}
	
	@Test
	public void shouldBeValid() {
		assertThat(getConstraintViolations(subject), is(empty()));
	}

	@Test
	public void blankNameShouldNotBeValid() {
		subject.setName(" ");		
		assertThat(getConstraintViolations(subject), hasSize(1));
	}
	
	@Test
	public void tooLongNameShouldNotBeValid() {
		subject.setName(StringUtils.repeat('a', 51));		
		assertThat(getConstraintViolations(subject), hasSize(1));
	}
	
	@Test
	public void invalidEmailShouldNotBeValid() {
		String invalidEmails = "foobar user@foo,com user_at_foo.org example.user@foo. aaa@bar+baz.com";
		for (String invalidEmail : StringUtils.split(invalidEmails)) {
			subject.setEmail(invalidEmail);
			assertThat(getConstraintViolations(subject), hasSize(1));
		}
	}
	
	@Test
	public void invalidPasswordShouldNotBeValid() {
		subject.setPassword(null);
		subject.setPasswordConfirmation(null);
		
		assertThat(getConstraintViolations(subject, TransientGroup.class), hasSize(3));
		
		subject.setPassword(" ");
		subject.setPasswordConfirmation(" ");
		
		assertThat(getConstraintViolations(subject, TransientGroup.class), hasSize(3));
	}
	
	@Test
	public void mismatchPasswordShouldNotBeValid() {
		subject.setPasswordConfirmation("mismatch");		
		assertThat(getConstraintViolations(subject, TransientGroup.class), hasSize(1));
	}
	
	@Test(expected = PersistenceException.class)
	public void duplicateEmailShouldNotBeValid() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		userRepository.save(subject);
		userRepository.save(new User("Invalid User", "USER@example.com", "foobar", "foobar"));
		transaction.rollback();
	}
	
	@Test
	public void shouldAuthenticateWithValidPassword() {
		assertThat(subject.authenticate("foobar"), is(true));
	}
	
	@Test
	public void shouldNotAuthenticateWithInvalidPassword() {
		assertThat(subject.authenticate("wrongpw"), is(false));
	}

}
