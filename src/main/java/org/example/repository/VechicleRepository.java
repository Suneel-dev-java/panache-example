package org.example.repository;

import org.example.entity.VechicleInfo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VechicleRepository implements PanacheRepository<VechicleInfo> {

}
