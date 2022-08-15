package com.example.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.Specifications;

@Repository
public class SpecificationsDaoImpl implements SpecificationsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddSpecifications(Specifications specifications) {
		currencySession().save(specifications);
	}

	@Override
	public Specifications getSpecifications(Integer id) {
		return currencySession().get(Specifications.class, id);
	}

	@Override
	public void updateSpecifications(Specifications specifications) {
		Specifications newSpe=getSpecifications(specifications.getId());
		newSpe.setCamera(specifications.getCamera());
		newSpe.setCardDoHoa(specifications.getCardDoHoa());
		newSpe.setCpu(specifications.getCpu());
		newSpe.setDateRelase(specifications.getDateRelase());
		newSpe.setDungLuongPin(specifications.getDungLuongPin());
		newSpe.setManHinh(specifications.getManHinh());
		newSpe.setNhuCau(specifications.getNhuCau());
		newSpe.setoCung(specifications.getoCung());
		newSpe.setOs(specifications.getOs());
		newSpe.setProduct(specifications.getProduct());
		
		currencySession().update(newSpe);
	}

	@Override
	public void updateSpecifications(Integer id, Specifications specifications) {
		Specifications newSpe=getSpecifications(id);
		newSpe.setCamera(specifications.getCamera());
		newSpe.setCardDoHoa(specifications.getCardDoHoa());
		newSpe.setCpu(specifications.getCpu());
		newSpe.setDateRelase(specifications.getDateRelase());
		newSpe.setDungLuongPin(specifications.getDungLuongPin());
		newSpe.setManHinh(specifications.getManHinh());
		newSpe.setNhuCau(specifications.getNhuCau());
		newSpe.setoCung(specifications.getoCung());
		newSpe.setOs(specifications.getOs());
		newSpe.setProduct(specifications.getProduct());
		
		currencySession().update(newSpe);
	}

}
