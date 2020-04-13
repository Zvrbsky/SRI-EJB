package edu.pjwstk.sri.lab2.dao;

import edu.pjwstk.sri.lab2.model.Category;
import edu.pjwstk.sri.lab2.storage.CategoryStorage;

import java.util.List;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for Category
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryDao {
	@PersistenceContext(unitName = "sri2-persistence-unit")
	private EntityManager em;

	@Inject
	private CategoryStorage categoryStorage;

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
	public List<Category> listAll() {
		return categoryStorage.getAllCategories();
	}
}
