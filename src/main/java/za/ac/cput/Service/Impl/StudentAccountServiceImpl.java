package za.ac.cput.Service.Impl;
/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Service Implementation
 *
 *
 */
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Repository.StudentAccountRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAccountServiceImpl implements StudentAccountService {
    private static StudentAccountRepository studentAccountRepository;
    private List<StudentAccount> studentAccountList;
    private static StudentAccountService studentAccountService;

    public StudentAccountServiceImpl(StudentAccountRepository studentAccountRepository){
        StudentAccountServiceImpl.studentAccountRepository = studentAccountRepository;
    }

    @Override
    public StudentAccount save(StudentAccount studentAccount) {
    if(studentAccount.equals(null)){
        studentAccountRepository.save(studentAccount);
    }else{
        System.out.println("Student Account created ");
    }
    this.studentAccountList.add(studentAccount);
    return studentAccount;
    }

    @Override
    public Optional<StudentAccount> read(Long studAccountNumber) {
        return this.studentAccountList
                .stream()
                .filter(a -> a.getStudAccountNumber().equals(studAccountNumber))
                .findFirst();
    }

    @Override
    public void delete(StudentAccount studentAccount) {
        if(studentAccount.equals(studentAccount)) {
            studentAccountRepository.delete(studentAccount);
        }else{
            System.out.println("StudentAccount does not exist ");
        }
    }

    @Override
    public StudentAccount update(StudentAccount studentAccount) {
        if (studentAccount != null){
            studentAccountRepository.delete(studentAccount);
            studentAccountRepository.save(studentAccount);
        }
        return studentAccount;
    }

    @Override
    public List<StudentAccount> readAll() {
        return (List<StudentAccount>) this.studentAccountRepository.findAll();
    }
}
