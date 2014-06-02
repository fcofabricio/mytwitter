package net.codeorbecoded.mytwitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import net.codeorbecoded.mytwitter.constraints.PasswordMatch;
import net.codeorbecoded.mytwitter.constraints.TransientGroup;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name = "users")
@PasswordMatch(passwordField = "password", passwordConfirmationField = "passwordConfirmation", groups = TransientGroup.class)
public class User extends AbstractEntity {

	@NotBlank(message = "Name is required!")
	@Size(max = 50, message = "Name must be at most {max} characters!")
	private String name;

	@Email(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", 
		message = "Invalid e-mail!")
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank(message = "Password is required!", groups = TransientGroup.class)
	@Size(min = 6, message = "Password must has at least {min} characters!", groups = TransientGroup.class)
	@Transient
	private String password;
	
	@NotBlank(message = "Password confirmation is required!", groups = TransientGroup.class)
	@Transient
	private String passwordConfirmation;
	
	@Column(nullable = false)
	private String passwordDigest;
	
	public User() { }
	
	public User(String name, String email, String password, String passwordConfirmation) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setPasswordConfirmation(passwordConfirmation);
	}
	
	public boolean authenticate(String password) {
		return BCrypt.checkpw(password, getPasswordDigest());
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		setPasswordDigest(BCrypt.hashpw(getPassword(), BCrypt.gensalt()));
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	private String getPasswordDigest() {
		return passwordDigest;
	}

	private void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}
	
}
