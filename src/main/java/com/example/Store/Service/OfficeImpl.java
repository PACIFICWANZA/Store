package com.example.Store.Service;

import com.example.Store.Modules.Office;
import com.example.Store.Repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeImpl implements OfficeServiceI{
    public final OfficeRepository officeRepository;

    @Override
    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }



    @Override
   public Office updateOffice(Long officeCode, Office office) {
        Office existingOffice = officeRepository.findById(officeCode)
            .orElseThrow(() -> new RuntimeException("Office not found with code: " + officeCode));
        existingOffice.setCity(office.getCity());
        existingOffice.setCountry(office.getCountry());
        existingOffice.setPhone(office.getPhone());
        existingOffice.setAddressLine1(office.getAddressLine1());
        existingOffice.setAddressLine2(office.getAddressLine2());
        existingOffice.setState(office.getState());
        existingOffice.setPostalCode(office.getPostalCode());
        return officeRepository.save(existingOffice);
    }



    @Override
    public void deleteOffice(Long officeCode) {
        officeRepository.deleteById(officeCode);
    }

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }
}
