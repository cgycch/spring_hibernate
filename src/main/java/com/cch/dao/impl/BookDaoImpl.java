package com.cch.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cch.dao.BookDao;
import com.cch.entities.Book;

@Repository
//@Transactional   //当使用事物的注解模式时，必须添加次注解，负责无法实现增、删、改操作
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao{
	
    @Autowired
    private SessionFactory sessionFactory;
    
    //HibernateDaoSupport need 
    //将sessionFactory注入到dao的超类的SessionFactory属性当中
    //在方法上加上注解@PostConstruct ，这个方法就会在Bean 初始化之后被Spring 容器执行
    //（注：Bean 初始化包括，实例化Bean ，并装配Bean 的属性（依赖注入））。
    @PostConstruct 
	public void setSessionFactory() {
		super.setSessionFactory(sessionFactory);
	}

    
    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
    public String findBookById(int id)
    {
        String hql="SELECT bookName from Book where id=?";
        Query query=getSession().createQuery(hql).setInteger(0, id);
        String str= query.uniqueResult().toString();
        return str;
    }
    
    /**
	 * 根据id查询
	 */
	public Book queryBookById(int bId) {
		Book b = this.getHibernateTemplate().get(Book.class, bId);
		return b;
	}
	
	
	@SuppressWarnings("unchecked")
	public Book queryBookByNameAndISBN(Book book) {
		String hql = "from Employee where eName = ? and ePassword = ?";
		List<Book> list = (List<Book>) this.getHibernateTemplate().find(hql, book.getBookName(),
				book.getIsbn());
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

    
    public void saveBook(Book book)
    {
        getSession().save(book);
    }
    
	/**
	 * 查询
	 */
	@SuppressWarnings("unchecked")
	public List<Book> queryAllBook() {
		String hql = "from Book";
		List<Book> list = (List<Book>) this.getHibernateTemplate().find(hql);
		return list;
	}
	
	public void test() {
	findAll();
	}
    
    

}
