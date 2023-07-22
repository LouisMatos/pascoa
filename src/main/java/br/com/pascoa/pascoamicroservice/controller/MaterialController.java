package br.com.pascoa.pascoamicroservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pascoa.pascoamicroservice.dto.MaterialDTO;
import br.com.pascoa.pascoamicroservice.service.MaterialService;

@RestController
@RequestMapping(value = "/material")
public class MaterialController {


  @Autowired
  private MaterialService materialService;

  @PostMapping
  public ResponseEntity<MaterialDTO> newMaterial(@RequestBody MaterialDTO dto){
    return new ResponseEntity<>(materialService.newMaterial(dto), HttpStatus.OK);
  }
  
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<MaterialDTO> findById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(materialService.findById(id), HttpStatus.OK);
  }


  @GetMapping
  public ResponseEntity<List<MaterialDTO>> findAll() {
    return new ResponseEntity<>(materialService.findAll(), HttpStatus.OK);
  }
}
