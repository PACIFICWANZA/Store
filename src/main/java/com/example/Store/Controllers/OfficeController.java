package com.example.Store.Controllers;

import com.example.Store.Modules.Office;
import com.example.Store.Service.OfficeServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office")
@RequiredArgsConstructor
public class OfficeController {

    public final OfficeServiceI officeServiceI;

    @PostMapping("/createOffice")
    public ResponseEntity<String> createOffice(@RequestBody Office office) {
        officeServiceI.createOffice(office);
        return ResponseEntity.ok(("Office created successfully"));
    }

    @GetMapping("/viewOffices")
    public ResponseEntity<List<Office>> getAllOffices() {
        try {
            List<Office> offices = officeServiceI.getAllOffices();
            return ResponseEntity.ok(offices);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateOffice/{officeCode}")
    public ResponseEntity<?> updateOffice(@PathVariable Long officeCode, @RequestBody Office office) {
        try {
            Office updatedOffice = officeServiceI.updateOffice(officeCode, office);
            return ResponseEntity.ok(updatedOffice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteOffice/{officeCode}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long officeCode) {
        try {
            officeServiceI.deleteOffice(officeCode);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}