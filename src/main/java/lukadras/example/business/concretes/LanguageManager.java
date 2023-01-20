package lukadras.example.business.concretes;

import lukadras.example.business.abstracts.LanguageService;
import lukadras.example.business.requests.CreateLanguageRequest;
import lukadras.example.business.responses.GetLanguageResponse;
import lukadras.example.dataAccess.abstracts.LanguageRepository;
import lukadras.example.entitiy.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetLanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();


        List<GetLanguageResponse> languageResponses = new ArrayList<GetLanguageResponse>();

        for(Language language:languages)
        {
            GetLanguageResponse responseItem = new GetLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            languageResponses.add(responseItem);
        }


        return languageResponses;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        List<Language> languages = languageRepository.findAll();

        for(Language item:languages)
        {
            if (item.getName().equals(createLanguageRequest.getName()))
            {
                throw new Exception("Sistemde kayitli bir dil girmeye calistniz");
            }
        }


        if (language.getName().isEmpty()){
           throw new Exception("Dil Ismi bos gecilemez");
        }else {
            this.languageRepository.save(language);
        }


    }

    @Override
    public void delete(Integer id) throws Exception {
        boolean languages = languageRepository.findById(id).isEmpty();

        if (!languages)
        {
            languageRepository.deleteById(id);
        }else {
            throw new Exception("Id Bulunamadi");
        }

    }

    @Override
    public void update(Integer id, CreateLanguageRequest createLanguageRequest) {
        Language languages = languageRepository.findById(id).get();
        languages.setName(createLanguageRequest.getName());
        languageRepository.save(languages);
    }

    @Override
    public GetLanguageResponse getById(Integer id) throws Exception {
        Boolean check = languageRepository.findById(id).isEmpty();

        if(check){
            throw new Exception("Id bulunamadi");
        }else
        {
            Language language = languageRepository.findById(id).get();
            GetLanguageResponse getLanguageResponse = new GetLanguageResponse();
            getLanguageResponse.setName(language.getName());

            return getLanguageResponse;
        }
    }
}
