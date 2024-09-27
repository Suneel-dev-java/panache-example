package org.example.repository;

import org.example.entity.StockData;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockDataRepository implements PanacheRepository<StockData> {

}
