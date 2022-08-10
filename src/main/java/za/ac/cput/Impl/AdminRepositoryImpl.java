package za.ac.cput.Impl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;

import java.util.List;
import java.util.Optional;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public List<Admin> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Admin> findAllById(Iterable<String> strings) {
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
    public void delete(Admin entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Admin> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Admin> findById(String s) {
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
    public <S extends Admin> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Admin> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Admin> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Admin getOne(String s) {
        return null;
    }

    @Override
    public Admin getById(String s) {
        return null;
    }

    @Override
    public Admin getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Admin> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Admin> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Admin> boolean exists(Example<S> example) {
        return false;
    }
}
