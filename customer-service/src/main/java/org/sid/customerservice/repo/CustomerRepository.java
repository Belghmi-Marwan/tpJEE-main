package org.sid.customerservice.repo;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    @GetMapping("/byName/{name}")
//    @PreAuthorize("hasAuthority('USER')")
//    Customer findByName(String name);
//
//    @GetMapping("/")
//    @PreAuthorize("hasAuthority('USER')")
//    Page<Customer> findAll(Pageable pageable);
//
//    @GetMapping("/byNameContains/{name}")
//    @PreAuthorize("hasAuthority('USER')")
//    Page<Customer> findByNameContains(String name, Pageable pageable);
//
//    @PostMapping("/")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    Customer save(Customer customer);
}
