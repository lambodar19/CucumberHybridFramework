package Utils;

import com.github.javafaker.Faker;

public class CommonUtils {
public static final int IMPLICIT_WAIT_TIME =10;
public static final int EXPLICIT_WAIT_TIME =30;
public static final int PAGE_LOAD_TIME =20;

    public String generateRandomEmail()
    {
        Faker faker = new Faker();
        String myEmail = faker.internet().emailAddress();
        return myEmail;

    }
}
