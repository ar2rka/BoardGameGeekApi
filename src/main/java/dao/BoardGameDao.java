package dao;

import models.BoardGame;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class BoardGameDao {

    public class UserDao {

        public BoardGame findById(int id) {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BoardGame.class, id);
        }
    }
}
