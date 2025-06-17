package com.example.Store.Service;

import com.example.Store.Modules.Office;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfficeServiceI {
    Office createOffice(Office office);
    List<Office> getAllOffices();
    Office updateOffice(Long officeCode, Office office);
    void deleteOffice(Long officeCode);

}
