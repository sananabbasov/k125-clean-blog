package az.edu.itbrains.cleanblog.services.impls;

import az.edu.itbrains.cleanblog.dtos.about.AboutDto;
import az.edu.itbrains.cleanblog.models.About;
import az.edu.itbrains.cleanblog.repositories.AboutRepository;
import az.edu.itbrains.cleanblog.services.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public AboutDto getAboutInfo() {
        About about = aboutRepository.findById(1L).orElseThrow();
        AboutDto aboutDto = new AboutDto(about.getContent());
        return aboutDto;
    }
}
