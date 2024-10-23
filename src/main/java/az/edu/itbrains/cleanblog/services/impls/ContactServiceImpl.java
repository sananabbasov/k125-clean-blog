package az.edu.itbrains.cleanblog.services.impls;

import az.edu.itbrains.cleanblog.dtos.contact.ContactSendDto;
import az.edu.itbrains.cleanblog.models.Contact;
import az.edu.itbrains.cleanblog.repositories.ContactRepository;
import az.edu.itbrains.cleanblog.services.ContactService;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public void sendEmail(ContactSendDto contactSendDto) {
        Contact contact = new Contact();
        contact.setEmail(contactSendDto.getEmail());
        contact.setName(contactSendDto.getName());
        contact.setMessage(contactSendDto.getMessage());
        contact.setPhoneNumber(contactSendDto.getPhoneNumber());
        contactRepository.save(contact);
    }
}
