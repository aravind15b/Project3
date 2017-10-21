package com.UserDao;

import java.util.List;
import com.model.Supplier;

public interface SupplierDao {
	public void insertSupplier(Supplier supplier);
	public Supplier getSupplier(int supid);
	public List<Supplier> retrive();
	public void removeSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier);
}
