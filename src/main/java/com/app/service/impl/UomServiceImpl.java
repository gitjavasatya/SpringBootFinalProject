package com.app.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Uom;
import com.app.repo.UomRepository;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private UomRepository repo;

	@Override
	public long save(Uom uom) {
		uom.setCreatedDate(new Date());
		uom=repo.save(uom);
		return uom.getUomId();
	}

	@Override
	public void update(Uom uom) {
		uom.setCreatedDate(repo.getOne(uom.getUomId()).getCreatedDate());
		uom.setLastModifiedDate(new Date());
		repo.save(uom);
	}

	@Override
	public void deleteById(long uomId) {
		repo.delete(uomId);
	}

	@Override
	public Uom getOneById(long uomId) {
		Uom uomob=repo.getOne(uomId);
		return uomob;
	}

	@Override
	public List<Uom> getAll() {
		List<Uom> uomlist=repo.findAll();
		Collections.sort(uomlist);
		return uomlist;
	}

}
