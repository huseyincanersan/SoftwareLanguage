package lukadras.example.business.abstracts;

import lukadras.example.business.requests.CreateLanguageRequest;
import lukadras.example.business.responses.GetLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetLanguageResponse> getAll();

    void add(CreateLanguageRequest createLanguageRequest) throws Exception;

    void delete(Integer id) throws Exception;

    void update(Integer id,CreateLanguageRequest createLanguageRequest);
}
