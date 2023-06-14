package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlUserTest {

    @Test
    void testFindByTypeArr() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("admin,1,ionutmarian@email.com,dummypass,Ionut Marian,0721234567,1,communication/problem-solving,bugs solving");
        User user1 = new User("admin,2,mariusstate@email.com,pass@123,Marius State,0727984651,2,an eye for detail/social media management, marketing");
        User user2 = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        User user3 = new User("customer,2,andreienache@email.com,pass%1234,Andrei Enache,0729874562,2023-01-04,2018-01-02,true");
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        ControlUser controlUser = new ControlUser(users);
        ArrayList<User> list = controlUser.findByTypeArr("customer");
        int expected = 2;

        assertEquals(expected, list.size());
    }

    @Test
    void testFindByType() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected = user.toString();

        assertEquals(expected, controlUser.findByType(user.getType()).toString());

    }

    @Test
    void testFindByTypeNull() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected = null;

        assertEquals(expected, controlUser.findByType(user.getType()+1));
    }

    @Test
    void testFindByTypeEmail() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected=user.toString();

        assertEquals(expected,controlUser.findByTypeEmail(user.getType(), user.getEmail()).toString());
    }

    @Test
    void testFindByTypeEmailNull() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected=null;

        assertEquals(expected,controlUser.findByTypeEmail(user.getType()+1, user.getEmail()+1));
    }

    @Test
    void testRemove() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        controlUser.remove(user);
        int expected=0;

        assertEquals(expected,users.size());
    }

    @Test
    void testAdd() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        ControlUser controlUser = new ControlUser(users);
        controlUser.add(user);
        int expected=1;

        assertEquals(expected,users.size());
    }

    @Test
    void testCheckCustomer() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        boolean expected=true;

        assertEquals(expected, controlUser.checkCustomer(user.getType()));
    }

    @Test
    void testCheckCustomerFalse() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        boolean expected=false;

        assertEquals(expected, controlUser.checkCustomer(user.getType()+1));
    }

    @Test
    void findByEmailPassword() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected=user.toString();

        assertEquals(expected,controlUser.findByEmailPassword(user.getEmail(), user.getPassword()).toString());
    }

    @Test
    void findByEmailPasswordNull() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        String expected=null;

        assertEquals(expected,controlUser.findByEmailPassword(user.getEmail()+1, user.getPassword()+1));
    }

    @Test
    void nextId(){
        ArrayList<User> users = new ArrayList<>();
        User user = new User("customer,1,anaionescu@email.com,pass!321,Ana Ionescu,0724597213,2023-05-12,2017-12-18,false");
        users.add(user);
        ControlUser controlUser = new ControlUser(users);
        int expected=user.getId()+1;

        assertEquals(expected,controlUser.nextId());
    }

    @Test
    void nextIdNull(){
        ArrayList<User> users = new ArrayList<>();
        ControlUser controlUser = new ControlUser(users);
        int expected=-1;

        assertEquals(expected,controlUser.nextId());
    }
}