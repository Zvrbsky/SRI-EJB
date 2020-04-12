package edu.pjwstk.sri.lab2.dao;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import edu.pjwstk.sri.lab2.model.Category;

/**
 * DAO for Category
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryDao {
	@PersistenceContext(unitName = "sri2-persistence-unit")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(Category entity) {
		em.persist(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteById(Long id) {
		Category entity = em.find(Category.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Category findById(Long id) {
		return em.find(Category.class, id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Category update(Category entity) {
		return em.merge(entity);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Category> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Category> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.parentCategory LEFT JOIN FETCH c.childCategories ORDER BY c.id",
						Category.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
