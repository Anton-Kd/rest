package ru.netology.rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.rest.authorities.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        users.put("Anton", "111");
        users.put("Petya", "222");
        if (users.containsKey(user) && users.get(user).equals(password)) {
            for (Enum v : Authorities.values()) {
                authoritiesList.add((Authorities) v);
            }
        }
        return authoritiesList;
    }
}
