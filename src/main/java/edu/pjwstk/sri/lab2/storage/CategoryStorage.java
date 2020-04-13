package edu.pjwstk.sri.lab2.storage;

import edu.pjwstk.sri.lab2.model.Category;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Startup
@Singleton
public class CategoryStorage {
    @PersistenceContext(unitName = "sri2-persistence-unit")
    private EntityManager em;

    private List<Category> allCategories;

    @PostConstruct
    @Schedule(minute="*/1", hour="*")
    @Lock(LockType.WRITE)
    public void saveCategories()
    {
        System.out.println("DBG: saveCategories called");
        allCategories = em.createQuery(
            "SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.parentCategory LEFT JOIN FETCH c.childCategories ORDER BY c.id",
            Category.class).getResultList();
    }

    @Lock(LockType.READ)
    public List<Category> getAllCategories()
    {
        return allCategories;
    }

}
