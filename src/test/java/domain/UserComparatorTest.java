package domain;

import org.junit.Assert;
import org.junit.Test;

public class UserComparatorTest {
    @Test
    public void positiveNameCompareTest(){
        User user1 = new User.UserBuilder().name("a").build();
        User user2 = new User.UserBuilder().name("b").build();
        Assert.assertEquals(-1, new UserComparator().compare(user1, user2));
    }

    @Test
    public void nullNameCompareTest(){
        User user1 = new User.UserBuilder().build();
        User user2 = new User.UserBuilder().name("b").build();
        Assert.assertEquals(-1, new UserComparator().compare(user1, user2));
    }

    @Test
    public void bothNullNameCompareTest(){
        User user1 = new User.UserBuilder().build();
        User user2 = new User.UserBuilder().build();
        Assert.assertEquals(0, new UserComparator().compare(user1, user2));
    }

    @Test
    public void positiveNameAndSurnameCompareTest(){
        User user1 = new User.UserBuilder().name("A").surname("A").build();
        User user2 = new User.UserBuilder().name("A").surname("B").build();
        Assert.assertEquals(-1,new UserComparator().compare(user1, user2));
    }

    @Test
    public void nullableNameAndSurnameCompareTest(){
        User user1 = new User.UserBuilder().surname("A").build();
        User user2 = new User.UserBuilder().name("A").surname("A").build();
        Assert.assertEquals(-1,new UserComparator().compare(user1, user2));

        User user3 = new User.UserBuilder().name("A").build();
        User user4 = new User.UserBuilder().name("A").surname("A").build();
        Assert.assertEquals(-1,new UserComparator().compare(user3, user4));

        User user5 = new User.UserBuilder().name("A").surname("A").build();
        User user6 = new User.UserBuilder().name("A").build();
        Assert.assertEquals(1,new UserComparator().compare(user5, user6));
    }

    @Test
    public void positiveLastnameCompareTest(){
        User user1 = new User.UserBuilder().lastname("A").build();
        User user2 = new User.UserBuilder().lastname("B").build();
        Assert.assertEquals(-1,new UserComparator().compare(user1, user2));

        User user3 = new User.UserBuilder().lastname("A").name("A").build();
        User user4 = new User.UserBuilder().lastname("A").name("B").build();
        Assert.assertEquals(-1,new UserComparator().compare(user3, user4));

        User user5 = new User.UserBuilder().lastname("B").name("A").build();
        User user6 = new User.UserBuilder().name("A").surname("A").build();
        Assert.assertEquals(1,new UserComparator().compare(user5, user6));
    }
}
