/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.estacionai.repository;

import com.projeto.estacionai.model.Bloco;
import com.projeto.estacionai.model.Vaga;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduardo
 */
@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    public List<Vaga> findByBlocoLike(Bloco bloco);

    public List<Vaga> findByOcupadaFalse();
}
