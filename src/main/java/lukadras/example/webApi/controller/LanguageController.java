package lukadras.example.webApi.controller;

import lukadras.example.business.abstracts.LanguageService;
import lukadras.example.business.requests.CreateLanguageRequest;
import lukadras.example.business.responses.GetLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetLanguageResponse> getAll(){

        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        this.languageService.add(createLanguageRequest);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        this.languageService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable  Integer id, @RequestBody CreateLanguageRequest createLanguageRequest)
    {
        this.languageService.update(id,createLanguageRequest);
    }
}
