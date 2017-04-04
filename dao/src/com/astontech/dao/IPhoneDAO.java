package com.astontech.dao;

import com.astontech.bo.Phone;

import java.util.List;

public interface IPhoneDAO {

    public Phone getPhoneById(int phoneId);

    public List<Phone> getPhoneList();

    public int insertPerson(Phone phone);

    public boolean updatePhone(Phone phone);

    public boolean deletePhone(int phoneId);

}
