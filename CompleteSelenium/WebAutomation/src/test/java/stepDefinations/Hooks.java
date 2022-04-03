package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before("@regtest")
	public void beforevalidation()
	{
		System.out.println(" before hoook");
	}

	@After("@regtest")
	public void aftervalidation()
	{
		System.out.println(" before hoook");
	}
}
