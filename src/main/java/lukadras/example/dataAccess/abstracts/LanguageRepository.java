package lukadras.example.dataAccess.abstracts;

import lukadras.example.entitiy.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
