package za.ac.cput.Impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public List<Payment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Payment> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Payment entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Payment> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Payment> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Payment> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Payment> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Payment> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Payment getOne(String s) {
        return null;
    }

    @Override
    public Payment getById(String s) {
        return null;
    }

    @Override
    public Payment getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Payment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Payment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Payment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Payment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Payment> boolean exists(Example<S> example) {
        return false;
    }
}
