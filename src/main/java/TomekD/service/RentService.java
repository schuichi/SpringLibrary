package TomekD.service;


import TomekD.model.Book;
import TomekD.model.User;

public interface RentService {

    void createRent(User user, Book book);

}
