package com.capitalone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitalone.model.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

	Optional<Exchange> findByExchangeFromAndExchangeTo(String from, String to);

}
