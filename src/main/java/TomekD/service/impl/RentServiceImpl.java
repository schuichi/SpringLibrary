package TomekD.service.impl;

import TomekD.dao.BookDao;
import TomekD.dao.RentDao;
import TomekD.model.Book;
import TomekD.model.Rent;
import TomekD.model.User;
import TomekD.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void createRent(User user, Book book) {
        Rent rent = new Rent(user, book);

        rentDao.save(rent);
        book.decrementQuantity();
        bookDao.save(book);
    }

}
