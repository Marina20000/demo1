package domain;

import java.util.Comparator;

/**
 * Compare user1 and user2 first by Lastname, then by name, and, finally, by surname
 */
public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if (user1 == user2) {
            return 0;
        }
        if (user2 == null) {
            return 1;
        }
        if (user1.getLastname() == null && user2.getLastname()== null)
            return compareByNameAndSurname(user1, user2.getName(), user2.getSurname());
        if(user1.getLastname()==null){
            return -1;
        }
        if(user1.getLastname().equals(user2.getLastname())){
            return compareByNameAndSurname(user1, user2.getName(), user2.getSurname());
        }
        if(user2.getLastname()==null){
            return 1;
        }
        return user1.getLastname().compareTo(user2.getLastname());
    }

    private int compareByNameAndSurname(User user1, String username, String userSurname){
        if(user1.getName() == null && username ==null){
            return compareBySurname(user1, userSurname);
        }
        if(user1.getName()==null){
            return -1;
        }
        if(user1.getName().equals(username)){
            return compareBySurname(user1, userSurname);
        }
        return user1.getName().compareTo(username);
    }

    private int compareBySurname(User user1, String surname) {
        if (user1.getSurname() == null && surname == null) {
            return 0;
        }
        if (user1.getSurname() == null) {
            return -1;
        }
        if(surname==null){
            return 1;
        }
        return user1.getSurname().compareTo(surname);
    }
}
